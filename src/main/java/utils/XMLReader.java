package utils;

import environment.PropertyReader;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class XMLReader {
    private static final Logger logger = Logger.getLogger(XMLReader.class);
    private Map<String, String> elementMap = null;
    protected static Properties configProperty;
    private Document document;


    //This method returns locator value and type
    public synchronized Map<String, String> getElementRepo(String fileName) {
        try {
            configProperty = PropertyReader.getConfigData();
            elementMap = new HashMap();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            if (Boolean.parseBoolean(configProperty.getProperty("isWebExe"))) {
                document = documentBuilder.parse(".\\src\\main\\resources\\elementRepo\\repoWeb\\" + fileName + ".xml");
            }
            if (Boolean.parseBoolean(configProperty.getProperty("isMobileExe"))) {
                document = documentBuilder.parse(".\\src\\main\\resources\\elementRepo\\repoMobile\\" + fileName + ".xml");
            }
            NodeList nodeList = document.getElementsByTagName("UIElement");
            for (int counter = 0; counter < nodeList.getLength(); counter++) {
                Node node = nodeList.item(counter);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    elementMap.put(element.getAttribute("name"), element.getAttribute("locatorType") + "_TBD_" + element.getAttribute("locatorValue"));
                }
            }
        } catch (ParserConfigurationException pc) {
            logger.error(pc.getMessage());
        } catch (SAXException sax) {
            logger.error(sax.getMessage());
        } catch (IOException io) {
            logger.error(io.getMessage());
        }
        return elementMap;
    }
}