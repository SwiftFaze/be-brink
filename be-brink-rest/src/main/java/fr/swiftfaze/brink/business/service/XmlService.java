package fr.swiftfaze.brink.business.service;

import fr.swiftfaze.brink.rest.dto.AbletonProjectDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class XmlService {

    public <T> T convertXml2Object(String abletonXmlProjectFile, Class<T> conversionClass) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(conversionClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return conversionClass.cast(jaxbUnmarshaller.unmarshal(new StringReader(abletonXmlProjectFile)));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getChildElementXmlString(Element xml, String tagName) {
        Element childElement = (Element) xml.getElementsByTagName(tagName).item(0);
        return elementToString(childElement);
    }

    public String elementToString(Element element) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(element), new StreamResult(writer));
            return writer.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }


}
