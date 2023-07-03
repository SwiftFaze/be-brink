package fr.swiftfaze.brink.business.service;

import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AbletonProjectService {

    private static final Logger logger = LoggerFactory.getLogger(AbletonProjectService.class);
    private final XmlService xmlService = new XmlService();

    public AbletonProjectDto convert2AbletonProject(String abletonXmlProjectFile) {
        return this.xmlService.convertXml2Object(abletonXmlProjectFile, AbletonProjectDto.class);
    }




}
