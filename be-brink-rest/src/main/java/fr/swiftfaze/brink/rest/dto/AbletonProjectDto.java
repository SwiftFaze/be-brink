package fr.swiftfaze.brink.rest.dto;

import fr.swiftfaze.brink.business.model.IAbletonProject;
import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonLiveSet;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Ableton")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonProjectDto implements IAbletonProject {
    @XmlAttribute(name = "MajorVersion")
    private int majorVersion;
    @XmlAttribute(name = "MinorVersion")
    private String minorVersion;
    @XmlAttribute(name = "SchemaChangeCount")
    private int schemaChangeCount;
    @XmlAttribute(name = "Creator")
    private String creator;
    @XmlAttribute(name = "Revision")
    private String revision;
    @XmlElement(name = "LiveSet")
    private AbletonLiveSet liveSet;

    @Override
    public int getMajorVersion() {
        return majorVersion;
    }

    @Override
    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    @Override
    public String getMinorVersion() {
        return minorVersion;

    }

    @Override
    public void setMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String getRevision() {
        return revision;
    }

    @Override
    public void setRevision(String revision) {
        this.revision = revision;
    }

    @Override
    public int getSchemaChangeCount() {
        return schemaChangeCount;
    }

    @Override
    public void setSchemaChangeCount(int schemaChangeCount) {
        this.schemaChangeCount = schemaChangeCount;
    }

    @Override
    public AbletonLiveSet getLiveSet() {
        return liveSet;
    }

    @Override
    public void setLiveSet(AbletonLiveSet liveSet) {
        this.liveSet = liveSet;
    }


}
