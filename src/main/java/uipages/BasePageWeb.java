package uipages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import utils.GuiControlMobile;
import utils.GuiControlWeb;
import utils.XMLReader;

import java.sql.Timestamp;
import java.util.Map;
import java.util.regex.Pattern;


public class BasePageWeb extends GuiControlWeb {

    private Map<String, String> elementRepo = null;
    private String oldFileName = "";
    protected WebDriver webDriver;

    public BasePageWeb(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public final Map<String, String> getElementMap() {
        String fileName = Thread.currentThread().getStackTrace()[2].getFileName().split(Pattern.quote("."))[0];
        if (elementRepo != null && fileName.equals(oldFileName))
            return elementRepo;
        oldFileName = fileName;
        elementRepo = new XMLReader().getElementRepo(fileName);
        return elementRepo;
    }

    public long currentTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }
}