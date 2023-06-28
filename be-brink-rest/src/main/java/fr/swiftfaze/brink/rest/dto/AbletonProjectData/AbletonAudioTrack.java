package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import fr.swiftfaze.brink.business.model.IAbletonTrack;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonAudioTrack implements IAbletonTrack {

    @XmlAttribute(name = "Id")
    private int id;

    @XmlElement(name = "LomId")
    private AbletonIntValue lomId;

    @XmlElement(name = "Name")
    private AbletonTrackName name;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getLomId() {
        return lomId.getValue();
    }

    @Override
    public void setLomId(AbletonIntValue lomId) {
        this.lomId = lomId;
    }

    @Override
    public AbletonTrackName getTrackName() {
        return name;
    }

    @Override
    public void setTrackName(AbletonTrackName name) {
        this.name = name;
    }
}
