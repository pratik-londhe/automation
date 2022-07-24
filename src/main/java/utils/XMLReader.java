package utils;

import org.apache.log4j.Logger;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pratik.londhe on 8/18/2018.
 */
public class XMLReader {
    private static final Logger logger = Logger.getLogger(XMLReader.class);
    private Map<String, String> elementMap = null;

    public Map<String, String> getElementRepo(String fileName) {
        try {
            elementMap = new HashMap();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/resources/elementRepo/" + fileName + ".xml");
            NodeList nodeList = document.getElementsByTagName("UIElement");
            for (int counter = 0; counter < nodeList.getLength(); counter++) {
                Node node = nodeList.item(counter);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    elementMap.put(element.getAttribute("name"), element.getAttribute("locatorType") + "_TBD_" + element.getAttribute("locatorValue"));
                }
            }
        } catch (ParserConfigurationException pc) {
            logger.error(pc);
        } catch (SAXException sax) {
            logger.error(sax);
        } catch (IOException io) {
            logger.error(io);
        }
        return elementMap;
    }
}
