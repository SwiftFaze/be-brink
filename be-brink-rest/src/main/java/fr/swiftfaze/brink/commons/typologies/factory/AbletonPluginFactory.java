package fr.swiftfaze.brink.commons.typologies.factory;



import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonNativePlugins.Eq8;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class AbletonPluginFactory {

    @XmlElementDecl(name="Eq8")
    public JAXBElement<Eq8> createAbletonEq8Plugin(Eq8 eq8) {
        return new JAXBElement<>(new QName("Eq8"), Eq8.class, eq8);
    }

}
