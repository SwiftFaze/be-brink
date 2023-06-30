package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LiveSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonLiveSet {

    @XmlElement(name = "Tracks")
    private AbletonTracks tracks;

    @XmlElement(name = "MasterTrack")
    private AbletonMasterTrack masterTrack;


    public AbletonTracks getTracks() {
        return tracks;
    }

    public void setTracks(AbletonTracks tracks) {
        this.tracks = tracks;
    }

    public AbletonMasterTrack getMasterTrack() {
        return masterTrack;
    }

    public void setMasterTrack(AbletonMasterTrack masterTrack) {
        this.masterTrack = masterTrack;
    }


}
