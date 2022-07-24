package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CBookPrimaryConceptPage extends BasePage {

    private final GuiControl btnStart = new GuiControl(getElementMap().get("btnStart"), webDriver);

    public CBookPrimaryConceptPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnStart() {
        waitForSec(5);
        if (btnStart.isElementPresent()) {
            btnStart.click();
            reportLog("Clicked on Start button.");
        }
    }
}