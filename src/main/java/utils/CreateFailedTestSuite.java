package utils;

import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class CreateFailedTestSuite {

    private CreateFailedTestSuite() {

    }

    public static final Logger logger = Logger.getLogger(CreateFailedTestSuite.class);

    public static void create(List<String> failedTestList, String xmlName, String suiteName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();

            if (suiteName.contains("Zalenium")) {

                Element suiteElement = document.createElement("suite");
                document.appendChild(addAttributes(document, "name", "CK12FailedTestSuite", suiteElement));
                suiteElement.setAttribute("parallel", "tests");

                Element testElement = document.createElement("test");
                suiteElement.appendChild(addAttributes(document, "name", "Chrome Test", testElement));
                suiteElement.appendChild(addAttributes(document, "parallel", "classes", testElement));

                Element paraParameter = document.createElement("parameter");
                testElement.appendChild(addAttributes(document, "name", "browser", paraParameter));
                testElement.appendChild(addAttributes(document, "value", "CHROME", paraParameter));

                Element classes = document.createElement("classes");
                for (String path : failedTestList) {
                    Element classElement = document.createElement("class");
                    classes.appendChild(addAttributes(document, "name", path, classElement));
                }
                paraParameter.appendChild(classes);
                testElement.appendChild(paraParameter);
                suiteElement.appendChild(testElement);

                Element secondElement = document.createElement("test");
                suiteElement.appendChild(addAttributes(document, "name", "Firefox Test", secondElement));
                suiteElement.appendChild(addAttributes(document, "parallel", "classes", secondElement));

                Element secParaParameter = document.createElement("parameter");
                testElement.appendChild(addAttributes(document, "name", "browser", secParaParameter));
                testElement.appendChild(addAttributes(document, "value", "FIREFOX", secParaParameter));

                Element secClasses = document.createElement("classes");
                for (String path : failedTestList) {
                    Element classElement = document.createElement("class");
                    secClasses.appendChild(addAttributes(document, "name", path, classElement));
                }
                secParaParameter.appendChild(secClasses);
                secondElement.appendChild(secParaParameter);
                createXML(document, xmlName);
            } else {
                Element suiteElement = document.createElement("suite");
                document.appendChild(addAttributes(document, "name", "CK12FailedTestSuite", suiteElement));
                suiteElement.setAttribute("parallel", "tests");

                Element testElement = document.createElement("test");
                suiteElement.appendChild(addAttributes(document, "name", "Safari Test", testElement));
                suiteElement.appendChild(addAttributes(document, "parallel", "classes", testElement));

                Element paraParameter = document.createElement("parameter");
                testElement.appendChild(addAttributes(document, "name", "browser", paraParameter));
                testElement.appendChild(addAttributes(document, "value", "SAFARI", paraParameter));

                Element classes = document.createElement("classes");
                for (String path : failedTestList) {
                    Element classElement = document.createElement("class");
                    classes.appendChild(addAttributes(document, "name", path, classElement));
                }
                paraParameter.appendChild(classes);
                testElement.appendChild(paraParameter);
                suiteElement.appendChild(testElement);

                Element secondElement = document.createElement("test");
                suiteElement.appendChild(addAttributes(document, "name", "Edge Test", secondElement));
                suiteElement.appendChild(addAttributes(document, "parallel", "classes", secondElement));

                Element secParaParameter = document.createElement("parameter");
                testElement.appendChild(addAttributes(document, "name", "browser", secParaParameter));
                testElement.appendChild(addAttributes(document, "value", "EDGE", secParaParameter));

                Element secClasses = document.createElement("classes");
                for (String path : failedTestList) {
                    Element classElement = document.createElement("class");
                    secClasses.appendChild(addAttributes(document, "name", path, classElement));
                }
                secParaParameter.appendChild(secClasses);
                secondElement.appendChild(secParaParameter);
                createXML(document, xmlName);
            }

        } catch (Exception ex) {
            logger.info(ex);
        }
    }

    public static Element addAttributes(Document document, String attrName, String attrValue, Element testElement) {
        Attr testName = document.createAttribute(attrName);
        testName.setValue(attrValue);
        testElement.setAttributeNode(testName);
        return testElement;
    }

    public static void createXML(Document document, String xmlName) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(xmlName));
            transformer.transform(source, result);
        } catch (Exception ex) {
            logger.info(ex);
        }
    }
}