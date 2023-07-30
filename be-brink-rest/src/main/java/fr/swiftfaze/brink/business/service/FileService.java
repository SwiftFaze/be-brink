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
        int index = filename.lastIndexOf(".");
        if (index != -1) {
            return filename.substring(index);
        }
        return "";
    }

    public String getFileDir(String path) {
        int index = path.lastIndexOf("/");
        if (index != -1) {
            String dir =  path.substring(0, index) + "/";
            return dir.replace(" ", "\\ ");
        }
        return path;
    }

    public String getFilename(String filename) {
        int index = filename.lastIndexOf("/");
        if (index != -1) {
            return filename.substring(index + 1);
        }
        return filename;
    }

    public String getRootDirectory(String filename) {
        int index = filename.indexOf("/");
        if (index != -1) {
            return filename.substring(0, index) + "/";
        }
        return "";
    }


}
