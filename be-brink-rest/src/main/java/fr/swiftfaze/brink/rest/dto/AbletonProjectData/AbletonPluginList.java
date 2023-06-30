package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonPluginList {

    private AbletonPluginList() {
        this.externalPluginList = new ArrayList<>();
        this.m4lPluginList = new ArrayList<>();
    }


    @XmlElement(name = "PluginDevice")
    private List<AbletonExternalPlugin> externalPluginList;

    @XmlElement(name = "MxDeviceAudioEffect")
    private List<AbletonM4lPlugin> m4lPluginList;

    public List<AbletonExternalPlugin> getExternalPluginList() {
        return externalPluginList;
    }

    public void setExternalPluginList(List<AbletonExternalPlugin> externalPluginList) {
        this.externalPluginList = externalPluginList;
    }

    public List<AbletonM4lPlugin> getM4lPluginList() {
        return m4lPluginList;
    }

    public void setM4lPluginList(List<AbletonM4lPlugin> m4lPluginList) {
        this.m4lPluginList = m4lPluginList;
    }


}
