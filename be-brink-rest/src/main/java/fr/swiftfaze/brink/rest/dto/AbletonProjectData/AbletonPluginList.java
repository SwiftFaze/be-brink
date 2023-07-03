package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import fr.swiftfaze.brink.commons.typologies.factory.AbletonPluginHandler;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonPluginList {

    public AbletonPluginList() {
        this.pluginList = new ArrayList<>();
    }

    @XmlAnyElement(lax = true)
    @XmlJavaTypeAdapter(AbletonPluginHandler.class)
    private List<AbletonPlugin> pluginList;




    public List<AbletonPlugin> getPluginList() {
        return pluginList;
    }

    public void setPluginList(List<AbletonPlugin> pluginList) {
        this.pluginList = pluginList;
    }
}
