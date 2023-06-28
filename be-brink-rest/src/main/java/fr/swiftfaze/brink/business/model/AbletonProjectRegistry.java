package fr.swiftfaze.brink.business.model;

import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonLiveSet;

public class AbletonProjectRegistry implements IAbletonProject {
    private int majorVersion;
    private String minorVersion;
    private String creator;
    private String revision;
    private int schemaChangeCount;
    private AbletonLiveSet abletonLiveSet;


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
        return abletonLiveSet;
    }

    @Override
    public void setLiveSet(AbletonLiveSet liveSet) {
        this.abletonLiveSet = liveSet;
    }
}
