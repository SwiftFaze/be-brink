package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonIntValue {
    @XmlAttribute(name = "Value")
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int id) {
        this.value = value;
    }

}
