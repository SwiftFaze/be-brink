package fr.swiftfaze.brink.rest.dto.AbletonProjectData;

import fr.swiftfaze.brink.business.model.IAbletonTrackName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbletonTrackName implements IAbletonTrackName {

    @XmlElement(name = "EffectiveName")
    private AbletonStringValue effectiveName;

    @XmlElement(name = "UserName")
    private AbletonStringValue userName;

    @XmlElement(name = "Annotation")
    private AbletonStringValue annotation;

    @XmlElement(name = "MemorizedFirstClipName")
    private AbletonStringValue memorizedFirstClipName;

    @Override
    public String getEffectiveName() {
        return effectiveName.getValue();
    }

    @Override
    public void setEffectiveName(AbletonStringValue effectiveName) {
        this.effectiveName = effectiveName;
    }

    @Override
    public String getUserName() {
        return userName.getValue();
    }

    @Override
    public void setUserName(AbletonStringValue userName) {
        this.userName = userName;
    }

    @Override
    public String getAnnotation() {
        return annotation.getValue();
    }

    @Override
    public void setAnnotation(AbletonStringValue annotation) {
        this.annotation = annotation;
    }

    @Override
    public String getMemorizedFirstClipName() {
        return memorizedFirstClipName.getValue();
    }

    @Override
    public void setMemorizedFirstClipName(AbletonStringValue memorizedFirstClipName) {
        this.memorizedFirstClipName = memorizedFirstClipName;
    }
}
