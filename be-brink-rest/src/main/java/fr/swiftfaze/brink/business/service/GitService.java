package fr.swiftfaze.brink.business.service;

import com.jcraft.jsch.*;
import org.eclipse.jgit.api.Git;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class GitService {

    private static final Logger logger = LoggerFactory.getLogger(GitService.class);
    private static final String REPO_LOCATION = "~/projects/ableton_test.git";
    private static final String REMOTE_URL = "git@192.168.1.29:~/projects/ableton_test.git";

    private static final String HOST = "192.168.1.29";
    private static final int PORT = 22;
    private static final String USERNAME = "git";
    private static final String PASSWORD = "git";
    private static final String GIT_ROOT_REPO = "/home/git/brink/";
    private static final String GIT_USER_REPO = GIT_ROOT_REPO + "users/";
    private static final String GIT_ADMIN_USER_REPO = GIT_USER_REPO + "admin/";
    private static final String GIT_PROJECT_REPO = "projects/";
    private static final String TEMP_FILE_PATH = "demo-project.als";



    public Git initRepository(String repoPath, String abletonXmlProjectFile) {
        try {
            String newSessionPath = GIT_ADMIN_USER_REPO + GIT_PROJECT_REPO + "demo-project/";
            runGitServerCommand("git init " + newSessionPath);
            runGitServerCommand("ls -la " + newSessionPath );



            try {
                FileWriter writer = new FileWriter(TEMP_FILE_PATH);
                writer.write(abletonXmlProjectFile);
                writer.close();
//                sendFileToGitServer(newSessionPath + "demo-project.als");



                System.out.println("Java file created successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }





//            runGitServerCommand("rm -rf " + GIT_ADMIN_USER_REPO + GIT_PROJECT_REPO);




        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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


            System.out.println("File uploaded - " + remoteFilePath);
        } finally {
            if (sftpChannel != null) {
                sftpChannel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }
    public void stuff() {
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


    }


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


}
