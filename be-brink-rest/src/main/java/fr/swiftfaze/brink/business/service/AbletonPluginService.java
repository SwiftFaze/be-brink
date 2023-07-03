package fr.swiftfaze.brink.business.service;

import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonPluginList;
import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AbletonPluginService {

    private static final Logger logger = LoggerFactory.getLogger(AbletonPluginService.class);
    private final XmlService xmlService = new XmlService();

    public AbletonPluginList convert2AbletonNativePluginList(String xml) {
        return this.xmlService.convertXml2Object(xml, AbletonPluginList.class);
    }


}
