package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import fr.swiftfaze.brink.business.model.IAbletonTrack;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonMidiTrack implements IAbletonTrack {

    @XmlAttribute(name = "Id")
    private int id;

    @XmlElement(name = "LomId")
    private AbletonIntValue lomId;

    @XmlElement(name = "Name")
    private AbletonTrackName name;
    @XmlElement(name = "TrackGroupId")
    private AbletonIntValue groupId;
    @XmlElement(name = "DeviceChain")
    private AbletonDeviceChain deviceChain;

    @XmlElement(name = "Freeze")
    private AbletonBooleanValue isFrozen;

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
    public AbletonTrackName getName() {
        return name;
    }

    @Override
    public void setName(AbletonTrackName name) {
        this.name = name;
    }

    @Override
    public int getGroupId() {
        return groupId.getValue();
    }

    @Override
    public void setGroupId(AbletonIntValue groupId) {
        this.groupId = groupId;
    }
    @Override
    public AbletonDeviceChain getDeviceChain() {
        return deviceChain;
    }

    @Override
    public void setDeviceChain(AbletonDeviceChain deviceChain) {
        this.deviceChain = deviceChain;
    }

    public Boolean getFrozen() {
        return isFrozen.getValue();
    }

    public void setFrozen(AbletonBooleanValue frozen) {
        this.isFrozen = frozen;
    }


}
