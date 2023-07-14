package fr.swiftfaze.brink.business.service;

import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.eclipse.jgit.api.Git;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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

        List<File> fileList = this.convertMultipartFilesToFiles(multipartFiles);

        for (File file : fileList) {
            String path = "/home/git/brink/users/admin/projects/demo-project/" + file.getName();
            this.gitService.sendFileToGitServer(file, path);
        }

    }

    private List<File> convertMultipartFilesToFiles(List<MultipartFile> multipartFiles) throws Exception {
        List<File> fileList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            System.out.println("Uploaded Filename: " + multipartFile.getOriginalFilename());
            String filePath = multipartFile.getOriginalFilename();

            assert filePath != null;
            String extension = this.getFileExtension(filePath);
            String fileName = this.getFilename(filePath);
            String dir = this.getFileDir(filePath);


            this.gitService.runGitServerCommand("mkdir -p /home/git/brink/users/admin/projects/demo-project/" + dir);

            File file = File.createTempFile(fileName, extension);
            multipartFile.transferTo(file);
            fileList.add(file);
        }
        return fileList;
    }


    public void processUploadedFilenames(MultipartHttpServletRequest multipartRequest) {
        Iterator<String> iterator = multipartRequest.getFileNames();

        while (iterator.hasNext()) {
            String uploadedFileName = iterator.next();
            System.out.println("Uploaded Filename: " + uploadedFileName);
        }
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
            return path.substring(0, extensionIndex).replace(" Project/", "/");
        }
        return path;
    }

    private String getFilename(String filename) {
        int extensionIndex = filename.lastIndexOf(".");
        if (extensionIndex != -1) {
            return filename.substring(0, extensionIndex);
        }
        return filename;
    }
}
