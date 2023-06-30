package fr.swiftfaze.brink.business.service;

import fr.swiftfaze.brink.commons.typologies.factory.AbletonPluginFactory;
import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonNativePlugin;
import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class AbletonProjectService {

    private static final Logger logger = LoggerFactory.getLogger(AbletonProjectService.class);

    public AbletonProjectDto convert2AbletonProject(String abletonXmlProjectFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AbletonProjectDto.class, AbletonPluginFactory.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (AbletonProjectDto) jaxbUnmarshaller.unmarshal(new StringReader(abletonXmlProjectFile));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    public AbletonNativePlugin convert2AbletonPlugin(String abletonXmlPluginFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AbletonNativePlugin.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (AbletonNativePlugin) jaxbUnmarshaller.unmarshal(new StringReader(abletonXmlPluginFile));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }



}
