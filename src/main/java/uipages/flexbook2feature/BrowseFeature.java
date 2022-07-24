package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;


public class BrowseFeature extends BasePage {

    private final GuiControl linkFlexBook2 = new GuiControl(getElementMap().get("linkFlexBook2"), webDriver);
    private final GuiControl iconCk12Logo = new GuiControl(getElementMap().get("iconCk12Logo"), webDriver);
    private final GuiControl textStudentName = new GuiControl(getElementMap().get("textStudentName"), webDriver);
    private final GuiControl iconDonate = new GuiControl(getElementMap().get("iconDonate"), webDriver);
    private final GuiControl iconSubjectArrowDown = new GuiControl(getElementMap().get("iconSubjectArrowDown"), webDriver);
    private final GuiControl tabStartLearning = new GuiControl(getElementMap().get("tabStartLearning"), webDriver);
    private final GuiControl textWhatDoYouWantToLearnToday = new GuiControl(getElementMap().get("textWhatDoYouWantToLearnToday"), webDriver);
    private final GuiControl containerMath = new GuiControl(getElementMap().get("containerMath"), webDriver);
    private final GuiControl linkCk12FlexBook = new GuiControl(getElementMap().get("linkCk12FlexBook"), webDriver);
    private final GuiControl textScience = new GuiControl(getElementMap().get("textScience"), webDriver);
    private final GuiControl textCollege = new GuiControl(getElementMap().get("textCollege"), webDriver);
    private final GuiControl iconSubjectArrowUp = new GuiControl(getElementMap().get("iconSubjectArrowUp"), webDriver);
    private final GuiControl linkFlexBook = new GuiControl(getElementMap().get("linkFlexBook"), webDriver);
    private final GuiControl textCustomizedDigitalFlexBook = new GuiControl(getElementMap().get("textCustomizedDigitalFlexBook"), webDriver);
    private final GuiControl tabGetStarted = new GuiControl(getElementMap().get("tabGetStarted"), webDriver);

    public BrowseFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyFlexBookLink() {
        return linkFlexBook.isElementPresent();
    }

    public void clickOnFlexBookLink() {
        if (linkFlexBook.isElementPresent()) {
            linkFlexBook.clickJScript();
            reportLog("Successfully click On FlexBook Link");
        }
    }

    public boolean verifyFlexBook2Link() {
        waitForSec(5);
        return linkFlexBook2.isElementPresent();
    }

    public void scrollScreen() {
        iconSubjectArrowDown.scrollIntoView();
        reportLog("Successfully Scroll Screen Through Subject Arrow Down");
    }

    public void clickOnFlexBook2Link() {
        if (linkFlexBook2.isElementPresent()) {
            linkFlexBook2.clickJScript();
            reportLog("Successfully click On FlexBook 2.0 Link");
        }
    }

    public boolean verifyCk12LogoIcon() {
        waitForSec(5);
        return iconCk12Logo.isElementPresent();
    }

    public boolean verifyStudentNameText() {
        return textStudentName.isElementPresent();
    }

    public void clickUsernameDropDownFB2LandingPage() {
        waitForSec(2);
        if(textStudentName.isElementPresent()) {
            textStudentName.click();
        }
    }

    public boolean verifyDonateIcon() {
        waitForSec(4);
        return iconDonate.isElementPresent();
    }

    public boolean verifySubjectArrowDown() {
        return iconSubjectArrowDown.isElementPresent();
    }

    public void clickOnSubjectArrowDown() {
        if (iconSubjectArrowDown.isElementPresent()) {
            iconSubjectArrowDown.clickJScript();
            reportLog("Successfully click On Icon Subject Arrow Down");
        }
    }

    public boolean verifySubjectArrowUp() {
        return iconSubjectArrowUp.isElementPresent();
    }

    public void clickOnSubjectArrowUp() {
        if (iconSubjectArrowUp.isElementPresent()) {
            iconSubjectArrowUp.clickJScript();
            reportLog("Successfully click On Icon Subject Arrow Up");
        }
    }

    public boolean verifyStartLearningTab() {
        return tabStartLearning.isElementPresent();
    }

    public void clickOnStartLearningTab() {
        if (tabStartLearning.isElementPresent()) {
            tabStartLearning.clickJScript();
            reportLog("Successfully click On Start Learning Tab");
        }
    }

    public boolean verifyWhatDoYouWantToLEarnTodayText() {
        waitForSec(5);
        return textWhatDoYouWantToLearnToday.isElementPresent();
    }

    public boolean verifyMathContainer() {
        return containerMath.isElementPresent();
    }

    public boolean verifyCk12MathFlexBooks() {
        return linkCk12FlexBook.isElementPresent();
    }

    public boolean verifyScienceText() {
        waitForSec(5);
        return textScience.isElementPresent();
    }

    public boolean verifyCollegeText() {
        return textCollege.isElementPresent();
    }

    public boolean verifyCustomizedDigitalFlexBookLink() {
        waitForSec(5);
        return textCustomizedDigitalFlexBook.isElementPresent();
    }

    public boolean verifyGetStartedTab() {
        return tabGetStarted.isElementPresent();
    }

    public void clickOnGetStartedTab() {
        if (tabGetStarted.isElementPresent()) {
            tabGetStarted.clickJScript();
            reportLog("Successfully click On Get Started Tab");
        }
    }
}