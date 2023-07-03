package fr.swiftfaze.brink.commons.typologies.factory;

import fr.swiftfaze.brink.business.service.AbletonPluginService;
import fr.swiftfaze.brink.business.service.XmlService;
import fr.swiftfaze.brink.rest.dto.AbletonProjectData.AbletonPlugin;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AbletonPluginHandler extends XmlAdapter<Element, AbletonPlugin> {

    AbletonPluginService abletonPluginService = new AbletonPluginService();
    XmlService xmlService = new XmlService();

    @Override
    public AbletonPlugin unmarshal(Element xml) {
        AbletonPlugin abletonPlugin = this.setPluginGeneralInfo(xml);

        String pluginType = xml.getLocalName();


        switch (pluginType) {
            case AbletonPlugin.EXTERNAL_PLUGIN: {

                abletonPlugin.setType("External Plugin");
                setPaths(xml, abletonPlugin, 0);
                abletonPlugin.setDisplayName(this.createDisplayName(abletonPlugin.getRelativePath()));
                break;
            }
            case AbletonPlugin.ABLETON_INSTRUMENT: {

                abletonPlugin.setType("Native Ableton Instrument");
                setPaths(xml, abletonPlugin, 0);
                abletonPlugin.setDisplayName(this.createDisplayName(abletonPlugin.getRelativePath()));

            }
            case AbletonPlugin.M4L_DEVICE: {

                abletonPlugin.setType("Max 4 Live Device");

                setPaths(xml, abletonPlugin, 1);
                setPluginChildren(abletonPlugin, xml);
                abletonPlugin.setDisplayName(this.createDisplayName(abletonPlugin.getRelativePath()));
                break;
            }
            default: {

                abletonPlugin.setType("Native Ableton Effect");
                setPaths(xml, abletonPlugin, 0);
                setPluginChildren(abletonPlugin, xml);
                abletonPlugin.setDisplayName(this.createDisplayName(abletonPlugin.getRelativePath()));
                break;
            }
        }


        return abletonPlugin;
    }

    private void setPaths(Element xml, AbletonPlugin abletonPlugin, int index) {
        Element relativePathElement = (Element) xml.getElementsByTagName("RelativePath").item(index);
        String relativePath = relativePathElement.getAttribute("Value");
        abletonPlugin.setRelativePath(relativePath);

        Element pathNameElement = (Element) xml.getElementsByTagName("Path").item(index);
        String pathName = pathNameElement.getAttribute("Value");
        abletonPlugin.setPath(pathName);
    }

    private void setPluginChildren(AbletonPlugin abletonPlugin, Element xml) {
        Element rackElement = (Element) xml.getElementsByTagName("Branches").item(0);
        abletonPlugin.setRack(rackElement != null);
        if (rackElement != null) {
            String arrangerAutomationXmlString = this.xmlService.getChildElementXmlString(xml, "Devices");
            abletonPlugin.setChildPluginList(this.abletonPluginService.convert2AbletonNativePluginList(arrangerAutomationXmlString));
        }

    }


    private AbletonPlugin setPluginGeneralInfo(Element xml) {
        AbletonPlugin abletonPlugin = new AbletonPlugin();


        int id = Integer.parseInt(xml.getAttribute("Id"));


        abletonPlugin.setId(id);


        return abletonPlugin;
    }

    @Override
    public Element marshal(AbletonPlugin abletonPlugin) {
        return null;
    }


    private String createDisplayName(String path) {
        int lastSlashIndex = path.lastIndexOf('/');
        if (lastSlashIndex != -1 && lastSlashIndex < path.length() - 1) {
            return path.substring(lastSlashIndex + 1);
        } else {
            return "";
        }
    }


}
