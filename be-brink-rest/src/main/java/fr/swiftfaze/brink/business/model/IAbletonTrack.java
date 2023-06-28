package fr.swiftfaze.brink.business.model;


import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonIntValue;
import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonTrackName;

public interface IAbletonTrack {

    int getId();

    void setId(int id);

    int getLomId();

    void setLomId(AbletonIntValue lomId);


    AbletonTrackName getTrackName();

    void setTrackName(AbletonTrackName name);

}
