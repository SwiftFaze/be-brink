package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonStringValue {
    @XmlAttribute(name = "Value")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String id) {
        this.value = value;
    }

}
