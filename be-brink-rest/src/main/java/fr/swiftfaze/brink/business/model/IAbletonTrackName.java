package fr.swiftfaze.brink.business.model;


import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonStringValue;

public interface IAbletonTrackName {

    String getEffectiveName();

    void setEffectiveName(AbletonStringValue effectiveName);

    String getUserName();

    void setUserName(AbletonStringValue userName);

    String getAnnotation();

    void setAnnotation(AbletonStringValue annotation);

    String getMemorizedFirstClipName();

    void setMemorizedFirstClipName(AbletonStringValue memorizedFirstClipName);

}
