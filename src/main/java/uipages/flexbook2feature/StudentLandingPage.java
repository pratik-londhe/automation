package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class StudentLandingPage extends BasePage {

    private final GuiControl textPersonalizeLearning = new GuiControl(getElementMap().get("textPersonalizeLearning"), webDriver);
    private final GuiControl tabGetStarted = new GuiControl(getElementMap().get("tabGetStarted"), webDriver);
    private final GuiControl linkWhyCk12 = new GuiControl(getElementMap().get("linkWhyCk12"), webDriver);
    private final GuiControl textSignIn = new GuiControl(getElementMap().get("textSignIn"), webDriver);
    private final GuiControl titleCk12 = new GuiControl(getElementMap().get("titleCk12"), webDriver);
    private final GuiControl btnGoToDashBoard = new GuiControl(getElementMap().get("btnGoToDashBoard"), webDriver);
    private final GuiControl textWhyCk12 = new GuiControl(getElementMap().get("textWhyCk12"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl textExplore = new GuiControl(getElementMap().get("textExplore"), webDriver);
    private final GuiControl circlePhysics = new GuiControl(getElementMap().get("circlePhysics"), webDriver);
    private final GuiControl circlePlix = new GuiControl(getElementMap().get("circlePlix"), webDriver);
    private final GuiControl circlePractice = new GuiControl(getElementMap().get("circlePractice"), webDriver);
    private final GuiControl circleStudyGuide = new GuiControl(getElementMap().get("circleStudyGuide"), webDriver);
    private final GuiControl textOverlayPhysicsCircle = new GuiControl(getElementMap().get("textOverlayPhysicsCircle"), webDriver);
    private final GuiControl textOverlayPlixCircle = new GuiControl(getElementMap().get("textOverlayPlixCircle"), webDriver);
    private final GuiControl textOverlayPracticeCircle = new GuiControl(getElementMap().get("textOverlayPracticeCircle"), webDriver);
    private final GuiControl textOverlayStudyGuideCircle = new GuiControl(getElementMap().get("textOverlayStudyGuideCircle"), webDriver);
    private final GuiControl btnBannerSignUp = new GuiControl(getElementMap().get("btnBannerSignUp"), webDriver);
    private final GuiControl textReinforceLearning = new GuiControl(getElementMap().get("textReinforceLearning"), webDriver);

    public StudentLandingPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifySignUpBannerButton() {
        waitForSec(5);
        return btnBannerSignUp.isElementPresent();
    }

    public void clickOnSignUpBannerButton() {
        if (btnBannerSignUp.isElementPresent()) {
            btnBannerSignUp.clickJScript();
            reportLog("Successfully Clicked On Sign Up Banner Button");
        }
    }

    public void scrollScreenForSignUpBanner() {
        btnBannerSignUp.scrollIntoView();
        reportLog("Successfully Scroll Screen Through Sign Up Banner Button");
    }

    public void scrollScreenForReinforcementLearning() {
        textReinforceLearning.scrollIntoView();
        reportLog("Successfully Scroll Screen Through Reinforcement Learning Text");
        waitForSec(5);
    }

    public void hoverPhysicsChemistryCircle() {
        if (circlePhysics.isElementPresent()) {
            circlePhysics.mouseHover();
            reportLog("Successfully Hover Physics Chemistry Circle");
        }
    }

    public void hoverPlixCircle() {
        if (circlePlix.isElementPresent()) {
            circlePlix.mouseHover();
            reportLog("Successfully Hover Plix Circle");
        }
    }

    public void hoverPracticeCircle() {
        if (circlePractice.isElementPresent()) {
            circlePractice.mouseHover();
            reportLog("Successfully Hover Practice Circle");
        }
    }

    public void hoverStudyGuidesCircle() {
        if (circleStudyGuide.isElementPresent()) {
            circleStudyGuide.mouseHover();
            reportLog("Successfully Hover Study Guide Circle");
        }
    }

    public boolean verifyPhysicsChemistryCircle() {
        return circlePhysics.isElementPresent();
    }

    public boolean verifyOverlayPhysicsChemistryText() {
        waitForSec(2);
        return textOverlayPhysicsCircle.isElementPresent();
    }

    public boolean verifyOverlayPlixText() {
        waitForSec(2);
        return textOverlayPlixCircle.isElementPresent();
    }

    public boolean verifyOverlayPracticeText() {
        waitForSec(2);
        return textOverlayPracticeCircle.isElementPresent();
    }

    public boolean verifyOverlayStudyGuideText() {
        waitForSec(2);
        return textOverlayStudyGuideCircle.isElementPresent();
    }

    public boolean verifyPlixCircle() {
        return circlePlix.isElementPresent();
    }

    public boolean verifyPracticeCircle() {
        return circlePractice.isElementPresent();
    }

    public boolean verifyStudyGuideCircle() {
        return circleStudyGuide.isElementPresent();
    }

    public boolean verifyCk12Title() {
        return titleCk12.isElementPresent();
    }

    public void clickOnCk12Title() {
        if (titleCk12.isElementPresent()) {
            titleCk12.clickJScript();
            reportLog("Successfully Clicked On Ck12 Title");
        }
    }

    public boolean verifyGoToDashBoardButton() {
        waitForSec(5);
        return btnGoToDashBoard.isElementPresent();
    }

    public boolean verifyExploreText() {
        waitForSec(2);
        return textExplore.isElementPresent();
    }

    public void scrollScreen() {
        textExplore.scrollIntoView();
        reportLog("Successfully Scroll The Screen");
    }

    public boolean verifyWhyCk12Text() {
        waitForSec(5);
        return textWhyCk12.isElementPresent();
    }

    public void clickOnGoToDashBoardButton() {
        if (btnGoToDashBoard.isElementPresent()) {
            btnGoToDashBoard.clickJScript();
            reportLog("Successfully Clicked On Go To DashBoard Button");
        }
    }

    public boolean verifyPersonalizeLearningText() {
        waitForSec(5);
        return textPersonalizeLearning.isElementPresent();
    }

    public boolean verifySignInText() {
        waitForSec(5);
        return textSignIn.isElementPresent();
    }

    public boolean verifyGetStartedTab() {
        return tabGetStarted.isElementPresent();
    }

    public void clickOnGetStartedTab() {
        if (tabGetStarted.isElementPresent()) {
            tabGetStarted.clickJScript();
            reportLog("Successfully Clicked On Get Started Tab");
        }
    }

    public boolean verifyWhyCk12Link() {
        return linkWhyCk12.isElementPresent();
    }

    public void clickOnWhyCk12Link() {
        if (linkWhyCk12.isElementPresent()) {
            linkWhyCk12.clickJScript();
            reportLog("Successfully Clicked On Why Ck12 Link");
        }
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Successfully Clicked On Close Icon");
        }
    }
}