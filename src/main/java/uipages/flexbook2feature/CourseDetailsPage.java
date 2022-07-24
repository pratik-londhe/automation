package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

/**
 * Created by pratik.londhe on 8/13/2018.
 */
public class CourseDetailsPage extends BasePage {

    private final GuiControl linksConceptWithoutParentChapter = new GuiControl(getElementMap().get("linksConceptWithoutParentChapter"), webDriver);

    private final GuiControl btnGotIt = new GuiControl(getElementMap().get("btnGotIt"), webDriver);

    public CourseDetailsPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnGotItButton() {
        if (btnGotIt.isElementPresent()) {
            btnGotIt.click();
            reportLog("Clicked on Got It Button.");
        }
    }

    public void clickOnConceptWithoutParentChapter() {
        waitForSec(10);
        if (linksConceptWithoutParentChapter.isElementPresent()) {
            linksConceptWithoutParentChapter.clickFirstFromListOfElements();
            reportLog("Clicked on first concept from list");
        }
    }
}