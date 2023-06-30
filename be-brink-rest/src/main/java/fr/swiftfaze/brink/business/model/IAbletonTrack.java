package fr.swiftfaze.brink.business.model;


import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonDeviceChain;
import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonIntValue;
import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonTrackName;

public interface IAbletonTrack {

    int getId();

    void setId(int id);

    int getLomId();

    void setLomId(AbletonIntValue lomId);

    AbletonTrackName getName();

    void setName(AbletonTrackName name);

    int getGroupId();

    void setGroupId(AbletonIntValue groupId);

    AbletonDeviceChain getDeviceChain();

    void setDeviceChain(AbletonDeviceChain deviceChain);


}
