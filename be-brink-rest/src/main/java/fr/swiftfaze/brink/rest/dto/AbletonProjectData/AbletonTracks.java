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
    private List<AbletonAudioTrack> audioTracks;

    @XmlElement(name = "MidiTrack")
    private List<AbletonMidiTrack> midiTracks;

    @XmlElement(name = "GroupTrack")
    private List<AbletonGroupTrack> groupTracks;


    public List<AbletonAudioTrack> getAudioTracks() {
        return audioTracks;
    }

    public void setAudioTracks(List<AbletonAudioTrack> audioTracks) {
        this.audioTracks = audioTracks;
    }

    public List<AbletonMidiTrack> getMidiTracks() {
        return midiTracks;
    }

    public void setMidiTracks(List<AbletonMidiTrack> midiTracks) {
        this.midiTracks = midiTracks;
    }

    public List<AbletonGroupTrack> getGroupTracks() {
        return groupTracks;
    }

    public void setGroupTracks(List<AbletonGroupTrack> groupTracks) {
        this.groupTracks = groupTracks;
    }



}
