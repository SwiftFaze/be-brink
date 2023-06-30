package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.*;
import org.w3c.dom.Element;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonExternalPlugin {

    @XmlAttribute(name = "Id")
    private int id;

    @XmlAnyElement
    private Element pluginDesc;

    @XmlTransient
    private String pluginName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

}
