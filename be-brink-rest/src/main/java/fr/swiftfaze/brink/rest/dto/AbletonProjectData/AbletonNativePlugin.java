package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonNativePlugin {
    @XmlAttribute(name = "Id")
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
