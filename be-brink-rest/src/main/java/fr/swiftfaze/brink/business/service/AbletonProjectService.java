package fr.swiftfaze.brink.business.service;

import fr.swiftfaze.brink.exception.BrinkInternalErrors;
import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AbletonProjectService {

    private static final Logger logger = LoggerFactory.getLogger(AbletonProjectService.class);
    private final XmlService xmlService;
    private final GitService gitService;

    public AbletonProjectService(XmlService xmlService, GitService gitService) {
        this.xmlService = xmlService;
        this.gitService = gitService;
    }

    public AbletonProjectDto convert2AbletonProject(String abletonXmlProjectFile) throws Exception {
        return this.xmlService.convertXml2Object(abletonXmlProjectFile, AbletonProjectDto.class);
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

    public void upload(MultipartHttpServletRequest request) throws Exception {
        try {
            MultiValueMap<String, MultipartFile> multipartFilesMap = request.getMultiFileMap();
            for (Map.Entry<String, List<MultipartFile>> multipartFileListMap : multipartFilesMap.entrySet()) {
                this.gitService.uploadMultiPartFileList(multipartFileListMap.getValue());
            }
        } catch (Exception e) {
            throw new Exception(BrinkInternalErrors.MULTIPART_FILE_MAP);
        }


    }





}
