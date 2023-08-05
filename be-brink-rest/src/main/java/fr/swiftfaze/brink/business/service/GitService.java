package fr.swiftfaze.brink.business.service;

import com.jcraft.jsch.*;
import fr.swiftfaze.brink.business.model.AbletonFileData;
import fr.swiftfaze.brink.exception.BrinkInternalErrors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class GitService {

    private static final Logger logger = LoggerFactory.getLogger(GitService.class);
    private static final String REPO_LOCATION = "~/projects/ableton_test.git";
    private static final String REMOTE_URL = "git@192.168.1.29:~/projects/ableton_test.git";

    // TODO MOVE TO ENVIRONMENT VARIABLES
    private static final String HOST = "192.168.1.29";
    private static final int PORT = 22;
    private static final String USERNAME = "git";
    private static final String PASSWORD = "git";
    private static final String GIT_ROOT_REPO = "/home/git/brink/";
    private static final String GIT_USER_REPO = GIT_ROOT_REPO + "users/";
    private static final String GIT_ADMIN_USER_REPO = GIT_USER_REPO + "admin/";
    private static final String GIT_PROJECTS_REPO = GIT_ADMIN_USER_REPO + "projects/";
    private static final String TEMP_FILE_PATH = "demo-project.als";

    private final FileService fileService;

    public GitService(FileService fileService) {
        this.fileService = fileService;
    }


    public void initRepository(String path) throws Exception {
        init(path);
        add(path);
        commit("init", path);
    }


    public String runGitServerCommand(String command) throws Exception {

        Session session = null;
        ChannelExec channel = null;
        String response;
        try {
            session = new JSch().getSession(USERNAME, HOST, PORT);
            session.setPassword(PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();

            // Wait for response to be sent back
            while (!channel.isClosed()) {
                Thread.sleep(100);
            }

            response = responseStream.toString();
        } catch (Exception e) {
            throw new Exception(BrinkInternalErrors.SERVER_COMMAND);
        } finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
        return response;
    }

    public void sendFileToGitServer(File file, String remoteFilePath) throws Exception {
        Session session = null;
        ChannelSftp sftpChannel = null;

        try {
            session = new JSch().getSession(USERNAME, HOST, PORT);
            session.setPassword(PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();

            sftpChannel = (ChannelSftp) channel;
            sftpChannel.put(new FileInputStream(file), remoteFilePath);


        } catch (Exception e) {
            throw new Exception(BrinkInternalErrors.FILE_TRANSFER);
        } finally {
            if (sftpChannel != null) {
                sftpChannel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }

    public byte[] downloadFolderAndCompress(String remoteFolderPath) throws Exception {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(USERNAME, HOST, PORT);
            session.setPassword(PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) channel;

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);

            addFilesToZip(sftpChannel, remoteFolderPath, "", zipOutputStream);

            zipOutputStream.close();
            sftpChannel.disconnect();
            session.disconnect();

            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            // Handle errors appropriately
            throw new Exception("Error while downloading and compressing folder: " + e.getMessage());
        }
    }

    private void addFilesToZip(ChannelSftp sftpChannel, String remoteFolderPath, String currentPath, ZipOutputStream zipOutputStream) throws Exception {
        Vector<ChannelSftp.LsEntry> entries = sftpChannel.ls(remoteFolderPath);
        for (ChannelSftp.LsEntry entry : entries) {
            if (!entry.getFilename().equals(".") && !entry.getFilename().equals("..")) {
                if (entry.getAttrs().isDir()) {
                    String nestedPath = currentPath + entry.getFilename() + "/";
                    addFilesToZip(sftpChannel, remoteFolderPath + "/" + entry.getFilename(), nestedPath, zipOutputStream);
                } else {
                    InputStream inputStream = sftpChannel.get(remoteFolderPath + "/" + entry.getFilename());
                    ZipEntry zipEntry = new ZipEntry(currentPath + entry.getFilename());
                    zipOutputStream.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        zipOutputStream.write(buffer, 0, bytesRead);
                    }

                    inputStream.close();
                    zipOutputStream.closeEntry();
                }
            }
        }
    }



//    public void stuff() {
//                        Repository newlyCreatedRepo = FileRepositoryBuilder.create(
//                    new File("/tmp/new_repo/.git"));
//            newlyCreatedRepo.create();


//            Git git = Git.cloneRepository()
//                    .setURI("http://192.168.1.28/brink/test.git")
//                    .setDirectory(new File("brink/test5"))
//                    .setCloneAllBranches(true)
//                    .setCredentialsProvider(provider).call();
//


//

//
//
//
//            git.push()
//                    .setRemote("http://192.168.1.28/brink/test22.git")
//                    .setCredentialsProvider(provider).call();
//


//    }


//    public void pushAbletonProject(Git git, String repoPath, String fileContents) {
//        try {
//
//            // Create a new branch called "develop" and checkout to it
//            git.branchCreate().setName("develop").call();
//            git.checkout().setName("develop").call();
//
//            File file = new File(git.getRepository().getDirectory().getParent(), "project.txt" );
//            file.createNewFile();
//            Files.write(file.toPath(), fileContents.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
//
//            git.add().addFilepattern(".").call();
//
//
//
//
//
//
//            // Commit the changes
//            PersonIdent author = new PersonIdent("Rob2", "rob@example.com");
//            git.commit().setAll(true).setMessage("project setup").setAuthor(author).call();
//
//            String remoteUrl = this.remote + repoPath + ".git";
//
//
//
//            // Push to the remote repository on the "develop" branch
//            PushCommand pushCommand = git.push();
//            pushCommand.setRemote(remoteUrl);
//            pushCommand.setCredentialsProvider(provider);
//            pushCommand.call();
//
//        } catch (GitAPIException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


    public void commit(String commitMessage, String path) throws Exception {
        System.out.println("git -C " + path + "commit -m \"" + commitMessage + "\" --all ");
        System.out.println(runGitServerCommand("git -C " + path + " commit -m \"" + commitMessage + "\" --all "));
    }

    public void add(String path) throws Exception {
        System.out.println("git -C " + path + "add .");
        System.out.println(runGitServerCommand("git -C " + path + " add ."));
    }
    public void init(String path) throws Exception {
        System.out.println(runGitServerCommand("git init " + path));
    }


    public AbletonFileData convertMultipartFile2AbletonFileData(MultipartFile multipartFile) throws Exception {
        // TODO MOVE THIS TO FILESERVICE
        return createAbletonFileData(multipartFile);
    }

    private void createDirectory(String filePath) throws Exception {
        String dir = this.fileService.getFileDir(filePath);
        runGitServerCommand("mkdir -p /home/git/brink/users/admin/projects/" + dir);
    }

    private AbletonFileData createAbletonFileData(MultipartFile multipartFile) throws Exception {
        try {
            String filePath = multipartFile.getOriginalFilename();
            assert filePath != null;
            String extension = this.fileService.getFileExtension(filePath);
            String fileName = this.fileService.getFilename(filePath);
            String dir = this.fileService.getFileDir(filePath);
            String path = dir + fileName;


            AbletonFileData abletonFileData = new AbletonFileData();
            File file = File.createTempFile(dir + fileName, extension);
            multipartFile.transferTo(file);

            abletonFileData.setFile(file);
            abletonFileData.setOriginalFilePath(filePath);
            abletonFileData.setDirectory(dir);
            abletonFileData.setName(fileName);
            abletonFileData.setPath(path);

            file.deleteOnExit();
            return abletonFileData;
        } catch (IOException e) {
            throw new Exception(BrinkInternalErrors.WRITE_FILE_DATA);
        }
    }


    public void uploadMultiPartFileList(List<MultipartFile> multipartFileList) throws Exception {
        List<AbletonFileData> abletonFileDataList = new ArrayList<>();

        String projectRootPath = "";

        for (MultipartFile multipartFile : multipartFileList) {
            abletonFileDataList.add(this.convertMultipartFile2AbletonFileData(multipartFile));

        }


        for (AbletonFileData abletonFileData : abletonFileDataList) {
            String path = "/home/git/brink/users/admin/projects/" + abletonFileData.getPath();

            if (Objects.equals(projectRootPath, "")) {
                projectRootPath = abletonFileData.getDirectory();
            }

            createDirectory(abletonFileData.getOriginalFilePath());
            sendFileToGitServer(abletonFileData.getFile(), path);
        }
        initRepository(GIT_PROJECTS_REPO + projectRootPath);

    }


}
