package fr.swiftfaze.brink.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);
    private final XmlService xmlService;

    public FileService(XmlService xmlService) {
        this.xmlService = xmlService;
    }





    public String getFileExtension(String filename) {
        int extensionIndex = filename.lastIndexOf(".");
        if (extensionIndex != -1) {
            return filename.substring(extensionIndex);
        }
        return "";
    }

    public String getFileDir(String path) {
        int extensionIndex = path.lastIndexOf("/");
        if (extensionIndex != -1) {
            return path.substring(0, extensionIndex) + "/";
        }
        return path;
    }

    public String getFilename(String filename) {
        int extensionIndex = filename.lastIndexOf("/");
        if (extensionIndex != -1) {
            return filename.substring(extensionIndex + 1);
        }
        return filename;
    }


}
