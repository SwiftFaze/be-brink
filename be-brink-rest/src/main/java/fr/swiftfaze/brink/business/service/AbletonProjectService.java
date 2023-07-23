package fr.swiftfaze.brink.business.service;

import fr.swiftfaze.brink.business.model.AbletonFileData;
import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.eclipse.jgit.api.Git;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AbletonProjectService {

    private static final Logger logger = LoggerFactory.getLogger(AbletonProjectService.class);
    private final XmlService xmlService = new XmlService();
    private final GitService gitService = new GitService();

    public AbletonProjectDto convert2AbletonProject(String abletonXmlProjectFile) {
        return this.xmlService.convertXml2Object(abletonXmlProjectFile, AbletonProjectDto.class);
    }


    public void createAbletonProject(String abletonXmlProjectFile, String projectPath) {
        Git git = this.gitService.initRepository(projectPath, abletonXmlProjectFile);


    }


    public void uploadSession(List<MultipartFile> multipartFiles) throws Exception {
        System.out.println("Files recieved - " + multipartFiles.size());
        List<AbletonFileData> fileList = this.convertMultipartFilesToFiles(multipartFiles);
        System.out.println("Files successfully converted");
        for (AbletonFileData abletonFileData : fileList) {
            String path = "/home/git/brink/users/admin/projects/" + abletonFileData.getPath();
            this.gitService.sendFileToGitServer(abletonFileData.getFile(), path);
        }
        System.out.println("Completed");
    }

    private List<AbletonFileData> convertMultipartFilesToFiles(List<MultipartFile> multipartFiles) throws Exception {
        List<AbletonFileData> abletonFileList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {

            String filePath = multipartFile.getOriginalFilename();

            assert filePath != null;
            String extension = this.getFileExtension(filePath);
            String fileName = this.getFilename(filePath);
            String dir = this.getFileDir(filePath);
            dir = dir.replace(" ", "\\ ");
            String path = dir + fileName;


            this.gitService.runGitServerCommand("mkdir -p /home/git/brink/users/admin/projects/" + dir);


            AbletonFileData abletonFileData = new AbletonFileData();

            try {
                File file = File.createTempFile(dir + fileName, extension);

                abletonFileData.setFile(file);
                abletonFileData.setDirectory(dir);
                abletonFileData.setName(fileName);
                abletonFileData.setPath(path);
                abletonFileList.add(abletonFileData);

                multipartFile.transferTo(file);
                file.deleteOnExit();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return abletonFileList;
    }


    private String getFileExtension(String filename) {
        int extensionIndex = filename.lastIndexOf(".");
        if (extensionIndex != -1) {
            return filename.substring(extensionIndex);
        }
        return "";
    }

    private String getFileDir(String path) {
        int extensionIndex = path.lastIndexOf("/");
        if (extensionIndex != -1) {
            return path.substring(0, extensionIndex) + "/";
        }
        return path;
    }

    private String getFilename(String filename) {
        int extensionIndex = filename.lastIndexOf("/");
        if (extensionIndex != -1) {
            return filename.substring(extensionIndex + 1);
        }
        return filename;
    }


    public List<String> getUserProjectList() throws Exception {
        List<String> projectNameList = new ArrayList<>();
        String response = this.gitService.runGitServerCommand("ls /home/git/brink/users/admin/projects/");

        while (response.contains("\n")) {
            int extensionIndex = response.lastIndexOf("\n");
            projectNameList.add(response.substring(extensionIndex));
            response = response.substring(0, extensionIndex);
        }
        projectNameList.add(response);
        projectNameList.remove(0);
        return projectNameList;


    }
}
