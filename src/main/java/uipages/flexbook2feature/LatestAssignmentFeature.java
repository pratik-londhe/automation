package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class LatestAssignmentFeature extends BasePage {
    private static final Logger logger = Logger.getLogger(LatestAssignmentFeature.class);

    private final GuiControl tabLatestAssignment = new GuiControl(getElementMap().get("tabLatestAssignment"), webDriver);
    private final GuiControl textClassName = new GuiControl(getElementMap().get("textClassName"), webDriver);
    private final GuiControl textAssignmentTitle = new GuiControl(getElementMap().get("textAssignmentTitle"), webDriver);
    private final GuiControl btnStart = new GuiControl(getElementMap().get("btnStart"), webDriver);
    private final GuiControl iconExpandOpen = new GuiControl(getElementMap().get("iconExpandOpen"), webDriver);
    private final GuiControl iconExpandClose = new GuiControl(getElementMap().get("iconExpandClose"), webDriver);
    private final GuiControl linkAssignmentConcept = new GuiControl(getElementMap().get("linkAssignmentConcept"), webDriver);
    private final GuiControl textHeaderContainer = new GuiControl(getElementMap().get("textHeaderContainer"), webDriver);
    private final GuiControl btnTurnIn = new GuiControl(getElementMap().get("btnTurnIn"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl iconQuiz = new GuiControl(getElementMap().get("iconQuiz"), webDriver);

    public LatestAssignmentFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyLatestAssignmentTab() {
        waitForSec(5);
        return tabLatestAssignment.isElementPresent();
    }

    public boolean verifyClassNameText() {
        return textClassName.isElementPresent();
    }

    public boolean verifyAssignmentTitleText() {
        return textAssignmentTitle.isElementPresent();
    }

    public boolean verifyStartButton() {
        return btnStart.isElementPresent();
    }

    public void clickOnStartButton() {
        if (btnStart.isElementPresent()) {
            btnStart.clickJScript();
            reportLog("Successfully Click On Start Button");
        }
    }

    public boolean verifyExpandOpenIcon() {
        return iconExpandOpen.isElementPresent();
    }

    public void clickOnExpandOpenIcon() {
        if (iconExpandOpen.isElementPresent()) {
            iconExpandOpen.clickJScript();
            reportLog("Successfully Click On Expand Open Icon");
        }
    }

    public boolean verifyExpandCloseIcon() {
        return iconExpandClose.isElementPresent();
    }

    public void clickOnExpandCloseIcon() {
        if (iconExpandClose.isElementPresent()) {
            iconExpandClose.clickJScript();
            reportLog("Successfully Click On Expand Close Icon");
        }
    }

    public boolean verifyAssignmentConceptLink() {
        waitForSec(5);
        return linkAssignmentConcept.isElementPresent();
    }

    public void clickOnAssignmentConceptLink() {
        if (linkAssignmentConcept.isElementPresent()) {
            linkAssignmentConcept.mouseHover();
            linkAssignmentConcept.click();
            reportLog("Successfully Click On Assignment Concept Link");
        }
    }

    public boolean verifyHeaderContainerText() {
        waitForSec(5);
        return textHeaderContainer.isElementPresent();
    }

    public boolean verifyTurnInButton() {
        return btnTurnIn.isElementPresent();
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Successfully Click On icon Close");
        }
    }

    public boolean verifyQuizIcon() {
        return iconQuiz.isElementPresent();
    }

    public void clickOnQuizIcon() {
        if (iconQuiz.isElementPresent()) {
            iconQuiz.mouseHover();
            iconQuiz.clickJScript();
            reportLog("Successfully Click On icon Quiz");
        }
    }
}