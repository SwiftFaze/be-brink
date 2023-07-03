package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonPlugin {

    public final static String ABLETON_INSTRUMENT = "InstrumentVector";
    public final static String EXTERNAL_PLUGIN = "PluginDevice";
    public final static String M4L_DEVICE = "MxDeviceAudioEffect";


    public AbletonPlugin() {
        this.childPluginList = new AbletonPluginList();
    }

    private int id;
    private String type;
    private String displayName;
    private String path;
    private String relativePath;
    private Boolean isRack;
    private AbletonPluginList childPluginList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public AbletonPluginList getChildPluginList() {
        return childPluginList;
    }

    public void setChildPluginList(AbletonPluginList childPluginList) {
        this.childPluginList = childPluginList;
    }

    public Boolean getRack() {
        return isRack;
    }

    public void setRack(Boolean rack) {
        isRack = rack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
