package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import utils.GuiControl;

public class ReportsPageWithoutAssignmentTest extends BasePage {

    private final GuiControl textNewReports = new GuiControl(getElementMap().get("textNewReports"), webDriver);
    private final GuiControl btnCreateAssignment = new GuiControl(getElementMap().get("btnCreateAssignment"), webDriver);
    private final GuiControl linkHowToReadReports = new GuiControl(getElementMap().get("linkHowToReadReports"), webDriver);
    private final GuiControl textHowToReadReports = new GuiControl(getElementMap().get("textHowToReadReports"), webDriver);
    private final GuiControl textPartOfCk12Reports = new GuiControl(getElementMap().get("textPartOfCk12Reports"), webDriver);
    private final GuiControl iconReportsTutorialClose = new GuiControl(getElementMap().get("iconReportsTutorialClose"), webDriver);
    private final GuiControl iconHeaderComponent = new GuiControl(getElementMap().get("iconHeaderComponent"), webDriver);
    private final GuiControl tablePartOfCk12Tutorial = new GuiControl(getElementMap().get("tablePartOfCk12Tutorial"), webDriver);
    private final GuiControl textHowModalityScored = new GuiControl(getElementMap().get("textHowModalityScored"), webDriver);
    private final GuiControl rowModalityType = new GuiControl(getElementMap().get("rowModalityType"), webDriver);
    private final GuiControl rowGoalAndAction = new GuiControl(getElementMap().get("rowGoalAndAction"), webDriver);
    private final GuiControl rowStatus = new GuiControl(getElementMap().get("rowStatus"), webDriver);
    private final GuiControl textDifferentColourMeaning = new GuiControl(getElementMap().get("textDifferentColourMeaning"), webDriver);
    private final GuiControl textHeatMap = new GuiControl(getElementMap().get("textHeatMap"), webDriver);

    public ReportsPageWithoutAssignmentTest(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyNewReportsText() {
        waitForSec(5);
        return textNewReports.isElementPresent();
    }

    public boolean verifyCreateAssignmentButton() {
        waitForSec(5);
        return btnCreateAssignment.isElementPresent();
    }

    public boolean verifyHowToReadReportsLink() {
        return linkHowToReadReports.isElementPresent();
    }

    public void clickOnHowToReadReportsLink() {
        if (linkHowToReadReports.isElementPresent()) {
            linkHowToReadReports.clickJScript();
            reportLog("Successfully clicked On How To Read Reports Link");
        }
    }

    public boolean verifyHowToReadReportsText() {
        waitForSec(5);
        return textHowToReadReports.isElementPresent();
    }

    public boolean verifyPartOfCk12ReportsText() {
        return textPartOfCk12Reports.isElementPresent();
    }

    public boolean verifyCloseReportsTutorialIcon() {
        iconReportsTutorialClose.scrollIntoView();
        waitForSec(5);
        return iconReportsTutorialClose.isElementPresent();
    }

    public void clickOnCloseReportsTutorialIcon() {
        if (iconReportsTutorialClose.isElementPresent()) {
            iconReportsTutorialClose.clickJScript();
            reportLog("Successfully clicked On Reports Tutorial Close Icon");
        }
    }

    public boolean verifyHeaderComponentIcon() {
        return iconHeaderComponent.isElementPresent();
    }

    public void clickOnHeaderComponentIcon() {
        if (iconHeaderComponent.isElementPresent()) {
            iconHeaderComponent.doubleClick();
            reportLog("Successfully clicked On Header Component Icon");
        }
    }

    public boolean verifyPartOfCk12TutorialTable() {
        return tablePartOfCk12Tutorial.isElementPresent();
    }

    public boolean verifyHowModalityScoredText() {
        return textHowModalityScored.isElementPresent();
    }

    public boolean verifyModalityTypeRow() {
        textHowModalityScored.scrollIntoView();
        waitForSec(5);
        return rowModalityType.isElementPresent();
    }

    public boolean verifyStatusRow() {
        return rowStatus.isElementPresent();
    }

    public boolean verifyGoalAndActionRow() {
        return rowGoalAndAction.isElementPresent();
    }

    public boolean verifyDifferentColourMeaningText() {
        textDifferentColourMeaning.scrollIntoView();
        waitForSec(5);
        return textDifferentColourMeaning.isElementPresent();
    }

    public boolean verifyHeatMapText() {
        return textHeatMap.isElementPresent();
    }
}
