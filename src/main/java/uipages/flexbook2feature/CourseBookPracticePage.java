package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class CourseBookPracticePage extends BasePage {

    private final GuiControl btnBack = new GuiControl(getElementMap().get("btnBack"), webDriver);
    private final GuiControl linkImproveQuestion = new GuiControl(getElementMap().get("linkImproveQuestion"), webDriver);
    private final GuiControl btnStartPractice = new GuiControl(getElementMap().get("btnStartPractice"), webDriver);
    private final GuiControl txtImproveThisQuestion = new GuiControl(getElementMap().get("txtImproveThisQuestion"), webDriver);
    private final GuiControl txtOptionChoices = new GuiControl(getElementMap().get("txtOptionChoices"), webDriver);
    private final GuiControl txtDetailsErrorReport = new GuiControl(getElementMap().get("txtDetailsErrorReport"), webDriver);
    private final GuiControl btnSubmit = new GuiControl(getElementMap().get("btnSubmit"), webDriver);
    private final GuiControl iconCloseReportError = new GuiControl(getElementMap().get("iconCloseReportError"), webDriver);
    private final GuiControl txtQuestion = new GuiControl(getElementMap().get("txtQuestion"), webDriver);
    private final GuiControl linkGetHint = new GuiControl(getElementMap().get("linkGetHint"), webDriver);
    private final GuiControl btnGotIt = new GuiControl(getElementMap().get("btnGotIt"), webDriver);
    private final GuiControl linkScratchpad = new GuiControl(getElementMap().get("linkScratchpad"), webDriver);
    private final GuiControl iconRemove = new GuiControl(getElementMap().get("iconRemove"), webDriver);
    private final GuiControl iconCloseTool = new GuiControl(getElementMap().get("iconCloseTool"), webDriver);
    private final GuiControl iconThetaProgress = new GuiControl(getElementMap().get("iconThetaProgress"), webDriver);
    private final GuiControl btnStopForNowOrDone = new GuiControl(getElementMap().get("btnStopForNowOrDone"), webDriver);
    private final GuiControl iconCheckMark = new GuiControl(getElementMap().get("iconCheckMark"), webDriver);
    private final GuiControl iconStopWatch = new GuiControl(getElementMap().get("iconStopWatch"), webDriver);
    private final GuiControl iconSkillLevel = new GuiControl(getElementMap().get("iconSkillLevel"), webDriver);
    private final GuiControl btnKeepPracticing = new GuiControl(getElementMap().get("btnKeepPracticing"), webDriver);
    private final GuiControl txtAllCircle = new GuiControl(getElementMap().get("txtAllCircle"), webDriver);
    private final GuiControl btnClosePractice = new GuiControl(getElementMap().get("btnClosePractice"), webDriver);
    private final GuiControl progressBarSkillLevel = new GuiControl(getElementMap().get("progressBarSkillLevel"), webDriver);
    private final GuiControl confidentModelPopup = new GuiControl(getElementMap().get("confidentModelPopup"), webDriver);
    private final GuiControl dismissConfidentModalPopup = new GuiControl(getElementMap().get("dismissConfidentModalPopup"), webDriver);
    private final GuiControl closeNewPracticeWalkThroughPopup = new GuiControl(getElementMap().get("closeNewPracticeWalkThroughPopup"), webDriver);

    public CourseBookPracticePage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyButtonStartPractice() {
        waitForSec(5);
        return btnStartPractice.isElementPresent();
    }

    public void clickOnButtonStartPractice() {
        if (btnStartPractice.isElementPresent()) {
            btnStartPractice.clickJScript();
            reportLog("Successfully clicked on Start Practice Button");
        }
    }

    public boolean verifyBackButton() {
        waitForSec(5);
        return btnBack.isElementPresent();
    }

    public boolean verifyLinkImproveQuestion() {
        linkImproveQuestion.scrollIntoView();
        return linkImproveQuestion.isElementPresent();
    }

    public void clickOnLinkImproveThisQuestion() {
        linkImproveQuestion.clickJScript();
        reportLog("Successfully clicked on Link Improve This Question");
    }

    public boolean verifyTextImproveThisQuestion() {
        return txtImproveThisQuestion.isElementPresent();
    }

    public void clickOnOptionChoicesLink() {
        if (txtOptionChoices.isElementPresent()) {
            txtOptionChoices.clickJScript();
            reportLog("Successfully clicked on Select 'Option choices' option From Dropdown ");
        }
    }

    public boolean verifyTextDetailsErrorReport() {
        return txtDetailsErrorReport.isElementPresent();
    }

    public void clickOnSubmitButton() {
        if (btnSubmit.isElementPresent()) {
            btnSubmit.click();
            reportLog("Successfully clicked on Submit Button");
        }
    }

    public void clickOnIconCloseReportError() {
        if (iconCloseReportError.isElementPresent()) {
            iconCloseReportError.clickJScript();
            reportLog("Successfully clicked on Close Error Report Icon");
        }
    }

    public boolean verifyQuestionText() {
        return txtQuestion.isElementPresent();
    }

    public boolean verifyGetHintLink() {
        return linkGetHint.isElementPresent();
    }

    public void clickOnGetHintLink() {
        if (linkGetHint.isElementPresent()) {
            linkGetHint.click();
            reportLog("Successfully clicked onGet HInt Link");
        }
    }

    public void clickOnGotItButton() {
        waitForSec(5);
        if (btnGotIt.isElementPresent()) {
            btnGotIt.click();
            reportLog("Successfully clicked on Got it Button");
        }
    }

    public boolean verifyScratchpadLink() {
        return linkScratchpad.isElementPresent();
    }

    public boolean verifyRemoveIcon() {
        if(iconRemove.isElementPresent()) {
            return true;
        }
        return false;
    }

    public boolean verifyCloseToolIcon() {
        return iconCloseTool.isElementPresent();
    }

    public void clickOnScratchpadLink() {
        waitForSec(5);
        if (linkScratchpad.isElementPresent()) {
            linkScratchpad.clickJScript();
            reportLog("Successfully clicked on Scratchpad link");
        }
    }

    public void clickOnCloseToolIcon() {
        if (iconCloseTool.isElementPresent()) {
            iconCloseTool.clickJScript();
            reportLog("Successfully clicked on Close Tool icon");
        }
    }

    public boolean verifyThetaProgressAgain() {
        waitForSec(5);
        return iconThetaProgress.getWebElement().getSize().getWidth() >= 4;
    }

    public boolean verifyStopForNowButton() {
        return btnStopForNowOrDone.isElementPresent();
    }

    public void clickOnStopForNowOrDOneButton() {
        if (btnStopForNowOrDone.isElementPresent()) {
            btnStopForNowOrDone.click();
            reportLog("Successfully clicked on Button Stop For Now Or Done");
        }
        waitForSec(5);
    }

    public boolean verifyIconCheckMark() {
        return iconCheckMark.isElementPresent();
    }

    public boolean verifyIconSopWatch() {
        return iconStopWatch.isElementPresent();
    }

    public boolean verifyIconSkillLevel() {
        return iconSkillLevel.isElementPresent();
    }

    public boolean verifyAllCircle() {
        txtAllCircle.scrollIntoView();
        List<WebElement> circle = txtAllCircle.getWebElement().findElements(By.xpath("//div[@class='ScoreChartComponent__for-adaptive-circle___2zd1Z']"));
        return !circle.isEmpty();
    }

    public boolean verifyButtonKeepPracticing() {
        return btnKeepPracticing.isElementPresent();
    }

    public void clickOnButtonKeepPracticing() {
        if (btnKeepPracticing.isElementPresent()) {
            btnKeepPracticing.clickJScript();
            reportLog("Successfully clicked on Button Keep Practicing");
        }
    }

    public void clickOnBackButtonPractice() {
        waitForSec(5);
        if (btnBack.isElementPresent()) {
            btnBack.clickJScript();
            reportLog("Successfully clicked on  Back Button Practice");
        }
    }

    public boolean verifyBackButtonPractice() {
        waitForSec(4);
        return btnBack.isElementPresent();
    }

    public void clickOnIconClosePractice() {
        if (btnClosePractice.isElementPresent()) {
            btnClosePractice.click();
            reportLog("Successfully clicked on  Back Button Practice");
        }
    }

    public void verifyConfidentModelPopup() {
        if (confidentModelPopup.isElementPresent()) {
            dismissConfidentModalPopup.click();
            reportLog("Successfully verify the model popup and clicked on the 4th option");
        }
    }

    public void closeNewPracticeTunnelWalkthrough(){
        closeNewPracticeWalkThroughPopup.clickJScript();
    }

    public boolean verifyIconClosePractice() {
        return btnClosePractice.isElementPresent();
    }

    public boolean verifySkillLevelProgressBar() {
        return progressBarSkillLevel.isElementPresent();
    }
}