package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "DeviceChain")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonPluginChain {

    private AbletonPluginChain() {
        this.pluginList = new ArrayList<>();
    }

    @XmlElement(name = "Devices")
    private List<AbletonPluginList> pluginList;


    public List<AbletonPluginList> getPluginList() {
        return pluginList;
    }

    public void setPluginList(List<AbletonPluginList> groupTrackList) {
        this.pluginList = pluginList;
    }


}
