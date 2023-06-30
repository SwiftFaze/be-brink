package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "DeviceChain")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonDeviceChain {

    @XmlElement(name = "DeviceChain")
    private AbletonPluginChain pluginChain;


    public AbletonPluginChain getPluginChain() {
        return pluginChain;
    }

    public void setPluginChain(AbletonPluginChain groupTrackList) {
        this.pluginChain = pluginChain;
    }


}
