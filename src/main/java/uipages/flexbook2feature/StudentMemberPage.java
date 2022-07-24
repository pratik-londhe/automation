package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class StudentMemberPage extends BasePage {

    private final GuiControl linkClass = new GuiControl(getElementMap().get("linkClass"), webDriver);
    private final GuiControl textStartDate = new GuiControl(getElementMap().get("textStartDate"), webDriver);
    private final GuiControl textProgress = new GuiControl(getElementMap().get("textProgress"), webDriver);
    private final GuiControl textTitle = new GuiControl(getElementMap().get("textTitle"), webDriver);
    private final GuiControl textLatestAssignmentScore = new GuiControl(getElementMap().get("textLatestAssignmentScore"), webDriver);
    private final GuiControl textClassAdmin = new GuiControl(getElementMap().get("textClassAdmin"), webDriver);
    private final GuiControl textEmailNotification = new GuiControl(getElementMap().get("textEmailNotification"), webDriver);

    public StudentMemberPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnClassName() {
        if (linkClass.isElementPresent()) {
            linkClass.clickJScript();
            reportLog("Successfully click on Class Name");
        }
    }

    public boolean verifyStartDateText(){
        waitForSec(5);
        return textStartDate.isElementPresent();
    }

    public boolean verifyProgressText(){
        return textProgress.isElementPresent();
    }

    public boolean verifyTitleText(){
        return textTitle.isElementPresent();
    }

    public boolean verifyLatestAssignmentScoresText(){
        return textLatestAssignmentScore.isElementPresent();
    }

    public boolean verifyClassAdminText(){
        return textClassAdmin.isElementPresent();
    }

    public boolean verifyEmailNotificationText(){
        return textEmailNotification.isElementPresent();
    }
}