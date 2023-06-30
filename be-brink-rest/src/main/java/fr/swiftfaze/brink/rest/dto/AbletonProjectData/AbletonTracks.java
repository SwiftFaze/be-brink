package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Tracks")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonTracks {
    @XmlElement(name = "AudioTrack")
    private List<AbletonAudioTrack> audioTrackList;

    @XmlElement(name = "MidiTrack")
    private List<AbletonMidiTrack> midiTrackList;

    @XmlElement(name = "GroupTrack")
    private List<AbletonGroupTrack> groupTrackList;

    @XmlElement(name = "ReturnTrack")
    private List<AbletonReturnTrack> returnTrackList;

    public List<AbletonAudioTrack> getAudioTrackList() {
        return audioTrackList;
    }

    public void setAudioTrackList(List<AbletonAudioTrack> audioTracks) {
        this.audioTrackList = audioTracks;
    }

    public List<AbletonMidiTrack> getMidiTrackList() {
        return midiTrackList;
    }

    public void setMidiTrackList(List<AbletonMidiTrack> midiTrackList) {
        this.midiTrackList = midiTrackList;
    }

    public List<AbletonGroupTrack> getGroupTrackList() {
        return groupTrackList;
    }

    public void setGroupTrackList(List<AbletonGroupTrack> groupTrackList) {
        this.groupTrackList = groupTrackList;
    }

    public List<AbletonReturnTrack> getReturnTrackList() {
        return returnTrackList;
    }

    public void setReturnTrackList(List<AbletonReturnTrack> returnTrackList) {
        this.returnTrackList = returnTrackList;
    }


}
