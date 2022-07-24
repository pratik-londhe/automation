package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class TurnInFeature extends BasePage {

    private final GuiControl linkAnswerOption = new GuiControl(getElementMap().get("linkAnswerOption"), webDriver);
    private final GuiControl btnTurnInAgain = new GuiControl(getElementMap().get("btnTurnInAgain"), webDriver);
    private final GuiControl btnSeeRecommendation = new GuiControl(getElementMap().get("btnSeeRecommendation"), webDriver);
    private final GuiControl textReview = new GuiControl(getElementMap().get("textReview"), webDriver);
    private final GuiControl textAlreadyAssign = new GuiControl(getElementMap().get("textAlreadyAssign"), webDriver);
    private final GuiControl btnTurnIn = new GuiControl(getElementMap().get("btnTurnIn"), webDriver);
    private final GuiControl textModalityTitle = new GuiControl(getElementMap().get("textModalityTitle"), webDriver);
    private final GuiControl iconSuccessfullyTurnIn = new GuiControl(getElementMap().get("iconSuccessfullyTurnIn"), webDriver);
    private final GuiControl textOOps = new GuiControl(getElementMap().get("textOOps"), webDriver);
    private final GuiControl iconAccountProfile = new GuiControl(getElementMap().get("iconAccountProfile"), webDriver);
    private final GuiControl linkNoDueDate = new GuiControl(getElementMap().get("linkNoDueDate"), webDriver);
    private final GuiControl linkReadAssignmentName = new GuiControl(getElementMap().get("linkReadAssignmentName"), webDriver);
    private final GuiControl btnViewPractice = new GuiControl(getElementMap().get("btnViewPractice"), webDriver);
    private final GuiControl iconAccount = new GuiControl(getElementMap().get("iconAccount"), webDriver);
    private final GuiControl linkSignOut = new GuiControl(getElementMap().get("linkSignOut"), webDriver);
    private final GuiControl btnCreateAnAssignment = new GuiControl(getElementMap().get("btnCreateAnAssignment"), webDriver);
    private final GuiControl tabAvailableAssignment = new GuiControl(getElementMap().get("tabAvailableAssignment"), webDriver);

    public TurnInFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyAlreadyAssignText() {
        return textAlreadyAssign.isElementPresent();
    }

    public boolean verifyReviewAnswerText() {
        waitForSec(5);
        return textReview.isElementPresent();
    }

    public boolean verifyTurnInAgainButton() {
        waitForSec(5);
        return btnTurnInAgain.isElementPresent();
    }

    public boolean verifyAnswerOptionLink() {
        return linkAnswerOption.isElementPresent();
    }

    public void clickOnAnswerOptionLink() {
        if (linkAnswerOption.isElementPresent()) {
            linkAnswerOption.mouseHover();
            linkAnswerOption.clickJScript();
            reportLog("Clicked on Answer Option link.");
        }
    }

    public boolean verifySeeRecommendationButton() {
        return btnSeeRecommendation.isElementPresent();
    }

    public void clickOnSeeRecommendationButton() {
        if (btnSeeRecommendation.isElementPresent()) {
            btnSeeRecommendation.clickJScript();
            reportLog("Clicked on See Recommendation Button.");
        }
    }

    public boolean verifyCreateAssignmentButton() {
        waitForSec(5);
        if (btnCreateAnAssignment.isElementPresent()) {
            btnCreateAnAssignment.mouseHover();
            return true;
        } else {
            return false;
        }
    }

    public void clickOnAvailableAssignmentTab() {
        waitForSec(5);
        if (tabAvailableAssignment.isElementPresent()) {
            tabAvailableAssignment.click();
            reportLog("Clicked on Available Assignment Tab.");
        }
    }

    public boolean verifyTurnInButton() {
        return btnTurnIn.isElementPresent();
    }

    public boolean verifyModalityTitleText() {
        return textModalityTitle.isElementPresent();
    }

    public boolean verifyCompletedAssignmentCheckMark() {
        waitForSec(5);
        return !iconSuccessfullyTurnIn.isElementPresent();
    }

    public boolean verifyOpsCompletePracticeText() {
        return textOOps.isElementPresent();
    }

    public void clickOnTurnInButton() {
        waitForSec(5);
        if (btnTurnIn.isElementPresent()) {
            btnTurnIn.clickJScript();
            reportLog("Clicked on Turn In Button.");
        }
    }

    public boolean verifyNoDueDateLink() {
        waitForSec(5);
        return linkNoDueDate.isElementPresent();
    }

    public void clickOnNoDueDateLink() {
        if (linkNoDueDate.isElementPresent()) {
            linkNoDueDate.clickJScript();
            reportLog("Clicked on No due Date Link.");
        }
    }

    public boolean verifyProfileIcon() {
        waitForSec(5);
        return iconAccountProfile.isElementPresent();
    }

    public void clickOnProfileIcon() {
        iconAccountProfile.waitForElementUntilClickable(30);
        iconAccountProfile.clickJScript();
        reportLog("Clicked on Account Icon.");
    }

    public void clickOnAssignmentName() {
        waitForSec(2);
        if (linkReadAssignmentName.isElementPresent()) {
            linkReadAssignmentName.clickJScript();
            waitForSec(2);
            linkReadAssignmentName.scrollIntoView();
            reportLog("Click On First Assignment");
        }
    }

    public boolean verifyStartPracticeButton() {
        return btnViewPractice.isElementPresent();
    }

    public boolean verifyStudentAccountIcon() {
        return iconAccount.isElementPresent();
    }

    public boolean verifyLinkSignOut() {
        return linkSignOut.isElementPresent();
    }

    public void clickOnLinkSignOut() {
        linkSignOut.isElementPresent();
        linkSignOut.click();
        reportLog("Clicked on SignOut Link");
    }
}