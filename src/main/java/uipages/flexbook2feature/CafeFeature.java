package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CafeFeature  extends BasePage {

    private final GuiControl linkCafe = new GuiControl(getElementMap().get("linkCafe"), webDriver);
    private final GuiControl textCafe = new GuiControl(getElementMap().get("textCafe"), webDriver);
    private final GuiControl textHelpAskAndShare = new GuiControl(getElementMap().get("textHelpAskAndShare"), webDriver);
    private final GuiControl tabTakeTheTour = new GuiControl(getElementMap().get("tabTakeTheTour"), webDriver);
    private final GuiControl linkCk12Guideline = new GuiControl(getElementMap().get("linkCk12Guideline"), webDriver);
    private final GuiControl iconCloseGuideLine = new GuiControl(getElementMap().get("iconCloseGuideLine"), webDriver);
    private final GuiControl textCafeGuideLine = new GuiControl(getElementMap().get("textCafeGuideLine"), webDriver);
    private final GuiControl btnTakeTheTour = new GuiControl(getElementMap().get("btnTakeTheTour"), webDriver);
    private final GuiControl btnSkipTour = new GuiControl(getElementMap().get("btnSkipTour"), webDriver);
    private final GuiControl linkSkipTour = new GuiControl(getElementMap().get("linkSkipTour"), webDriver);
    private final GuiControl btnContinue = new GuiControl(getElementMap().get("btnContinue"), webDriver);
    private final GuiControl btnDone = new GuiControl(getElementMap().get("btnDone"), webDriver);
    private final GuiControl containerStudent = new GuiControl(getElementMap().get("containerStudent"), webDriver);
    private final GuiControl containerTeacher = new GuiControl(getElementMap().get("containerTeacher"), webDriver);
    private final GuiControl containerAll = new GuiControl(getElementMap().get("containerAll"), webDriver);
    private final GuiControl containerStudentActive = new GuiControl(getElementMap().get("containerStudentActive"), webDriver);
    private final GuiControl containerTeacherActive = new GuiControl(getElementMap().get("containerTeacherActive"), webDriver);
    private final GuiControl containerAllActive = new GuiControl(getElementMap().get("containerAllActive"), webDriver);
    private final GuiControl btnFollow = new GuiControl(getElementMap().get("btnFollow"), webDriver);
    private final GuiControl btnFollowing = new GuiControl(getElementMap().get("btnFollowing"), webDriver);
    private final GuiControl iconThread = new GuiControl(getElementMap().get("iconThread"), webDriver);
    private final GuiControl iconAnswer = new GuiControl(getElementMap().get("iconAnswer"), webDriver);
    private final GuiControl linkForum = new GuiControl(getElementMap().get("linkForum"), webDriver);
    private final GuiControl textAnswerCount = new GuiControl(getElementMap().get("textAnswerCount"), webDriver);
    private final GuiControl textThreadCount = new GuiControl(getElementMap().get("textThreadCount"), webDriver);
    private final GuiControl textForumName = new GuiControl(getElementMap().get("textForumName"), webDriver);
    private final GuiControl linkForumGoBack = new GuiControl(getElementMap().get("linkForumGoBack"), webDriver);

    public CafeFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyForumContainerLink() {
        return linkForum.isElementPresent();
    }

    public void clickOnForumContainerLink() {
        if (linkForum.isElementPresent()) {
            linkForum.clickJScript();
            reportLog("Successfully click On Forum Container Link");
        }
    }

    public boolean verifyForumName() {
        waitForSec(5);
        return textForumName.isElementPresent();
    }

    public boolean verifyForumGoBackLink() {
        return linkForumGoBack.isElementPresent();
    }

    public void clickOnForumGoBackLink() {
        if (linkForumGoBack.isElementPresent()) {
            linkForumGoBack.clickJScript();
            reportLog("Successfully click On Forum Go Back Link");
        }
    }

    public boolean verifyFollowButton() {
        tabTakeTheTour.scrollIntoView();
        waitForSec(2);
        return btnFollow.isElementPresent();
    }

    public void clickOnFollowButton() {
        if (btnFollow.isElementPresent()) {
            btnFollow.clickJScript();
            reportLog("Successfully click On Follow Button");
        }
    }

    public boolean verifyFollowingButton() {
        waitForSec(5);
        return btnFollowing.isElementPresent();
    }

    public void clickOnFollowingButton() {
        if (btnFollowing.isElementPresent()) {
            btnFollowing.clickJScript();
            reportLog("Successfully click On Following Button");
        }
    }

    public boolean verifyThreadIcon() {
        return iconThread.isElementPresent();
    }

    public boolean verifyThreadCountText() {
        return textThreadCount.isElementPresent();
    }

    public void HoverOnThreadIcon() {
        if (iconThread.isElementPresent()) {
            iconThread.clickJScript();
            reportLog("Successfully Hover On Tread Icon");
        }
    }

    public boolean verifyAnswerIcon() {
        return iconAnswer.isElementPresent();
    }

    public boolean verifyAnswerCountText() {
        return textAnswerCount.isElementPresent();
    }

    public void HoverOnAnswerIcon() {
        if (iconAnswer.isElementPresent()) {
            iconAnswer.clickJScript();
            reportLog("Successfully Hover On Answer Icon");
        }
    }

    public boolean verifyStudentFilter() {
        return containerStudent.isElementPresent();
    }

    public void clickOnStudentFilter() {
        if (containerStudent.isElementPresent()) {
            containerStudent.clickJScript();
            reportLog("Successfully click On Student Filter");
        }
    }

    public boolean verifyTeacherFilter() {
        return containerTeacher.isElementPresent();
    }

    public void clickOnTeacherFilter() {
        if (containerTeacher.isElementPresent()) {
            containerTeacher.clickJScript();
            reportLog("Successfully click On Teacher Filter");
        }
    }

    public boolean verifyAllFilter() {
        return containerAll.isElementPresent();
    }

    public void clickOnAllFilter() {
        if (containerAll.isElementPresent()) {
            containerAll.clickJScript();
            reportLog("Successfully click On All Filter");
        }
    }

    public boolean verifyActiveStudentFilter() {
        return containerStudentActive.isElementPresent();
    }

    public boolean verifyActiveTeacherFilter() {
        waitForSec(5);
        return containerTeacherActive.isElementPresent();
    }

    public boolean verifyActiveAllFilter() {
        waitForSec(5);
        return containerAllActive.isElementPresent();
    }

    public boolean verifyCafeLink() {
        waitForSec(5);
        return linkCafe.isElementPresent();
    }

    public void clickOnCafeLink() {
        if (linkCafe.isElementPresent()) {
            linkCafe.clickJScript();
            reportLog("Successfully click On Cafe Link");
        }
    }

    public boolean verifyTakeTheTourTab() {
        waitForSec(5);
        return tabTakeTheTour.isElementPresent();
    }

    public void clickOnTakeTheTourTab() {
        if (tabTakeTheTour.isElementPresent()) {
            tabTakeTheTour.clickJScript();
            reportLog("Successfully click On Take The Tour Tab");
        }
    }

    public boolean verifyCk12GuidelineLink() {
        return linkCk12Guideline.isElementPresent();
    }

    public void clickOnCk12GuidelineLink() {
        if (linkCk12Guideline.isElementPresent()) {
            linkCk12Guideline.clickJScript();
            reportLog("Successfully click On Ck12 Guideline Link");
        }
    }

    public boolean verifyCafeText() {
        return textCafe.isElementPresent();
    }

    public boolean verifyHelpAskAndShareText() {
        return textHelpAskAndShare.isElementPresent();
    }

    public boolean verifyTakeTheTourButton() {
        waitForSec(5);
        return btnTakeTheTour.isElementPresent();
    }

    public void clickOnTakeTheTourButton() {
        if (btnTakeTheTour.isElementPresent()) {
            btnTakeTheTour.clickJScript();
            reportLog("Successfully click On Take The Tour button");
        }
    }

    public boolean verifySkippTourButton() {
        return btnSkipTour.isElementPresent();
    }

    public void clickOnSkippTourButton() {
        if (btnSkipTour.isElementPresent()) {
            btnSkipTour.clickJScript();
            reportLog("Successfully click On Skipp Tour button");
        }
    }

    public boolean verifySkipButton() {
        return linkSkipTour.isElementPresent();
    }

    public void clickOnSkipButton() {
        if (linkSkipTour.isElementPresent()) {
            linkSkipTour.clickJScript();
            reportLog("Successfully click On Skip button");
        }
    }

    public boolean verifyContinueButton() {
        waitForSec(5);
        return btnContinue.isElementPresent();
    }

    public void clickOnContinueButton() {
        if (btnContinue.isElementPresent()) {
            btnContinue.clickJScript();
            reportLog("Successfully click On Continue button");
        }
    }

    public boolean verifyDoneButton() {
        waitForSec(5);
        return btnDone.isElementPresent();
    }

    public void clickOnDoneButton() {
        if (btnDone.isElementPresent()) {
            btnDone.clickJScript();
            reportLog("Successfully click On Done button");
        }
    }

    public boolean verifyCafeGuideLineText() {
        waitForSec(5);
        return textCafeGuideLine.isElementPresent();
    }

    public boolean verifyCloseGuidelineIcon() {
        return iconCloseGuideLine.isElementPresent();
    }

    public void clickOnCloseGuidelineIcon() {
        if (iconCloseGuideLine.isElementPresent()) {
            iconCloseGuideLine.clickJScript();
            reportLog("Successfully click On CloseGuideline Icon");
        }
    }
}