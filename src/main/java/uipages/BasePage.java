package uipages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import utils.GuiControl;
import utils.XMLReader;

import java.sql.Timestamp;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by pratik.londhe on 8/18/2018.
 */

public class BasePage extends GuiControl {
    public final Logger logger = Logger.getLogger(getClass());
    private Map<String, String> elementRepo = null;
    private String oldFileName = "";
    private Timestamp timestamp;
    protected WebDriver webDriver;
    protected static ExtentTest extentTest;
    protected ExtentReports extentReports;

    public BasePage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        this.webDriver = webDriver;
        this.extentReports = extentReports;
        this.extentTest = extentTest;
    }

    public final Map<String, String> getElementMap() {
        String fileName = Thread.currentThread().getStackTrace()[2].getFileName().split(Pattern.quote("."))[0];
        if (elementRepo != null && fileName.equals(oldFileName))
            return elementRepo;
        oldFileName = fileName;
        elementRepo = new XMLReader().getElementRepo(fileName);
        return elementRepo;
    }

    public void waitForSec(int numberOfSecond) {
        try {
            Thread.sleep(numberOfSecond * 1000L);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public long currentTimeStamp() {
        timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }


    @Step("{0}")
    public void reportLog(String message) {
        extentTest.log(LogStatus.INFO, message);
        logger.info(message);
    }
}