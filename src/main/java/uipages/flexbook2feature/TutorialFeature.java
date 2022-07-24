package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.GuiControl;

public class TutorialFeature extends PageMenuTab {
    private static final Logger logger = Logger.getLogger(TutorialFeature.class);

    private final GuiControl iconTutorial = new GuiControl(getElementMap().get("iconTutorial"), webDriver);
    private final GuiControl contentActiveBar = new GuiControl(getElementMap().get("contentActiveBar"), webDriver);
    private final GuiControl classesActiveBar = new GuiControl(getElementMap().get("classesActiveBar"), webDriver);
    private final GuiControl learnMoreAboutDashBoardText = new GuiControl(getElementMap().get("learnMoreAboutDashBoardText"), webDriver);
    private final GuiControl btnTakeTheTour = new GuiControl(getElementMap().get("btnTakeTheTour"), webDriver);
    private final GuiControl btnLater = new GuiControl(getElementMap().get("btnLater"), webDriver);
    private final GuiControl textYouCanAlwaysReopen = new GuiControl(getElementMap().get("textYouCanAlwaysReopen"), webDriver);
    private final GuiControl btnOKLater = new GuiControl(getElementMap().get("btnOKLater"), webDriver);
    private final GuiControl textAllContentInOneLocation = new GuiControl(getElementMap().get("textAllContentInOneLocation"), webDriver);
    private final GuiControl btnOkGotIt = new GuiControl(getElementMap().get("btnOkGotIt"), webDriver);
    private final GuiControl textStudentProgress = new GuiControl(getElementMap().get("textStudentProgress"), webDriver);
    private final GuiControl textDemoClass = new GuiControl(getElementMap().get("textDemoClass"), webDriver);
    private final GuiControl iconCloseDemo = new GuiControl(getElementMap().get("iconCloseDemo"), webDriver);
    private final GuiControl textDoNotWorry = new GuiControl(getElementMap().get("textDoNotWorry"), webDriver);
    private final GuiControl btnOk = new GuiControl(getElementMap().get("btnOk"), webDriver);

    public TutorialFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyDoNotWorryText() {
        return textDoNotWorry.isElementPresent();
    }

    public boolean verifyTutorialIcon() {
        waitForSec(5);
        return iconTutorial.isElementPresent();
    }

    public void clickOnTutorialIcon() {
        if (iconTutorial.isElementPresent()) {
            iconTutorial.clickJScript();
            reportLog("Successfully clicked On icon Tutorial");
        }
    }

    public boolean verifyActiveContentBar() {
        return contentActiveBar.isElementPresent();
    }

    public boolean verifyActiveClassesBar() {
        return classesActiveBar.isElementPresent();
    }

    public boolean verifyLearnMoreAboutDashBoardText() {
        waitForSec(5);
        return learnMoreAboutDashBoardText.isElementPresent();
    }

    public boolean verifyLaterButton() {
        return btnLater.isElementPresent();
    }

    public void clickOnLaterButton() {
        if (btnLater.isElementPresent()) {
            btnLater.clickJScript();
            reportLog("Successfully clicked On Later Button");
        }
    }

    public boolean verifyTakeTheTourButton() {
        return btnTakeTheTour.isElementPresent();
    }

    public void clickOnTakeTheTourButton() {
        if (btnTakeTheTour.isElementPresent()) {
            btnTakeTheTour.clickJScript();
            reportLog("Successfully clicked On Take The Tour Button");
        }
    }

    public boolean verifyYouCanAlwaysReopenText() {
        waitForSec(5);
        return textYouCanAlwaysReopen.isElementPresent();
    }

    public boolean verifyOkLaterButton() {
        return btnOKLater.isElementPresent();
    }

    public void clickOnOkLaterButton() {
        if (btnOKLater.isElementPresent()) {
            btnOKLater.clickJScript();
            reportLog("Successfully clicked On Ok Later Button");
        }
    }

    public boolean verifyAllContentInOneLocationText() {
        waitForSec(5);
        return textAllContentInOneLocation.isElementPresent();
    }

    public boolean verifyOkGotItButton() {
        return btnOkGotIt.isElementPresent();
    }

    public void clickOnOkGotItButton() {
        if (btnOkGotIt.isElementPresent()) {
            btnOkGotIt.clickJScript();
            reportLog("Successfully clicked On Ok Got It Button");
        }
    }

    public boolean verifyStudentProgressText() {
        waitForSec(5);
        return textStudentProgress.isElementPresent();
    }

    public boolean verifyDemoClassText() {
        waitForSec(5);
        return textDemoClass.isElementPresent();
    }

    public boolean verifyCloseIcon() {
        return iconCloseDemo.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconCloseDemo.isElementPresent()) {
            iconCloseDemo.clickJScript();
            reportLog("Successfully clicked On Close Icon");
        }
    }

    public boolean verifyOkButton() {
        waitForSec(5);
        return btnOk.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOk.isElementPresent()) {
            btnOk.clickJScript();
            reportLog("Successfully clicked On Ok Button");
        }
    }
}