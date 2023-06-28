package fr.swiftfaze.brink.business.service;

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
            JAXBContext jaxbContext = JAXBContext.newInstance(AbletonProjectDto.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (AbletonProjectDto) jaxbUnmarshaller.unmarshal(new StringReader(abletonXmlProjectFile));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }


}
