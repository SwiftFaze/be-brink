package fr.swiftfaze.brink.business.service;

import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.eclipse.jgit.api.Git;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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




}
