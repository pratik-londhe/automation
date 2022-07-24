package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class TeacherDashboardPage extends BasePage {

    private static final Logger logger = Logger.getLogger(StudentDashBoardPage.class);
    private final GuiControl iconTeacherProfile = new GuiControl(getElementMap().get("iconTeacherProfile"), webDriver);

    public TeacherDashboardPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyTeacherProfileOnGamma() {
        waitForSec(5);
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                iconTeacherProfile.isElementPresent();
                result = true;
                break;
            } catch (StaleElementReferenceException serEx) {
                logger.error(serEx);
            }
            attempts++;
        }
        return result;
    }
}