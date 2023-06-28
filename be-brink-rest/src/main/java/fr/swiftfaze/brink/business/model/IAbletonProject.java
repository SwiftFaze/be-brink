package fr.swiftfaze.brink.business.model;

import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonLiveSet;

public interface IAbletonProject {

    int getMajorVersion();

    void setMajorVersion(int majorVersion);

    String getMinorVersion();

    void setMinorVersion(String minorVersion);

    String getCreator();

    void setCreator(String creator);

    String getRevision();

    void setRevision(String revision);

    int getSchemaChangeCount();

    void setSchemaChangeCount(int schemaChangeCount);

    AbletonLiveSet getLiveSet();

    void setLiveSet(AbletonLiveSet liveSet);

}
