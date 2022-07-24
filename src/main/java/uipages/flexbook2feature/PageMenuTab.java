package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

/**
 * Created by pratik.londhe on 8/20/2018.
 */
public class PageMenuTab extends BasePage {

    private final GuiControl tabClasses = new GuiControl(getElementMap().get("tabClasses"), webDriver);
    private final GuiControl tabLibrary = new GuiControl(getElementMap().get("tabLibrary"), webDriver);
    private final GuiControl firstClass = new GuiControl(getElementMap().get("firstClass"), webDriver);
    private final GuiControl assignmentTab = new GuiControl(getElementMap().get("assignmentTab"), webDriver);
    private final GuiControl memberTab = new GuiControl(getElementMap().get("memberTab"), webDriver);
    private final GuiControl className = new GuiControl(getElementMap().get("className"), webDriver);
    private final GuiControl assignmentContainer = new GuiControl(getElementMap().get("assignmentContainer"), webDriver);
    private final GuiControl startAssign = new GuiControl(getElementMap().get("startAssign"), webDriver);
    private final GuiControl btnStart = new GuiControl(getElementMap().get("btnStart"), webDriver);
    private final GuiControl answer = new GuiControl(getElementMap().get("answer"), webDriver);
    private final GuiControl checkItButton = new GuiControl(getElementMap().get("checkItButton"), webDriver);
    private final GuiControl btnSubmit = new GuiControl(getElementMap().get("btnSubmit"), webDriver);
    private final GuiControl YesBtn = new GuiControl(getElementMap().get("YesBtn"), webDriver);
    private final GuiControl btnTurnIn = new GuiControl(getElementMap().get("btnTurnIn"), webDriver);
    private final GuiControl btnContinue = new GuiControl(getElementMap().get("btnContinue"), webDriver);
    private final GuiControl tabReport = new GuiControl(getElementMap().get("tabReport"), webDriver);
    private final GuiControl firstClassOne = new GuiControl(getElementMap().get("firstClassOne"), webDriver);
    private final GuiControl btnTurnInAgain = new GuiControl(getElementMap().get("btnTurnInAgain"), webDriver);
    private final GuiControl OkSuccessButton = new GuiControl(getElementMap().get("OkSuccessButton"), webDriver);

    public PageMenuTab(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver,extentTest,extentReports);
    }

    public void attemptAssignmentAndSubmitScore() {
        /*answer.clickJScript();
        checkItButton.clickJScript();*/
        waitForSec(6);
        btnSubmit.clickJScript();
        YesBtn.clickJScript();
        waitForSec(10);
        btnTurnIn.click();
        btnTurnIn.click();
        waitForSec(4);
        btnTurnInAgain.clickJScript();
        waitForSec(4);
        OkSuccessButton.clickJScript();
       // btnContinue.clickJScript();
    }

    public void clickOnLibraryTab() {
        if (tabLibrary.isElementPresent()) {
            tabLibrary.clickJScript();
            reportLog("clicked on Library tab");
        }
    }

    public void clickOnClassesTab() {
        if (tabClasses.isElementPresent()) {
            tabClasses.clickJScript();
            reportLog("clicked on Classes tab");
        }
    }

    public void clickOnClass() {
        waitForSec(4);
        try {
            firstClassOne.isElementPresent();
            firstClassOne.clickJScript();
            reportLog("clicked on Classes tab");
        } catch (Exception e) {
            logger.info(e);
            firstClass.clickJScript();
        }
    }

    public void clickOnAssignmentTab() {
        if (assignmentTab.isElementPresent()) {
            assignmentTab.clickJScript();
            reportLog("clicked on Classes tab");
        }
    }

    public void clickOnMemberTab() {
        if (memberTab.isElementPresent()) {
            memberTab.clickJScript();
            reportLog("clicked on Classes tab");
            waitForSec(4);
        }
    }

    public void clickOnClassName() {
        if (className.isElementPresent()) {
            className.clickJScript();
            reportLog("clicked on Classes tab");
            waitForSec(4);
        }
    }

    public void clickOnAssignmentContainer() {
        if (assignmentContainer.isElementPresent()) {
            assignmentContainer.clickJScript();
            reportLog("clicked on Classes tab");
            waitForSec(4);
        }
    }

    public void clickOnStartAssignment() {
        waitForSec(8);
        if (startAssign.isElementPresent()) {
            startAssign.clickJScript();
            reportLog("clicked on Classes tab");
        }
    }

    public void clickOnStartPractice() {
        waitForSec(10);
        if (btnStart.isElementPresent()) {
            btnStart.clickJScript();
            reportLog("clicked on Classes tab");
            waitForSec(4);
        }
    }

    public void clickOnReportLink() {
        waitForSec(4);
        tabReport.clickJScript();
    }
}