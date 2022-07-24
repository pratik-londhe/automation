package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class CBookLandingPage extends BasePage {
    private static final Logger logger = Logger.getLogger(CBookLandingPage.class);

    private int count = 0;

    private final GuiControl linkFlexBook = new GuiControl(getElementMap().get("linkFlexBook"), webDriver);
    private final GuiControl iconSignIn = new GuiControl(getElementMap().get("iconSignIn"), webDriver);
    private final GuiControl btnSignIn = new GuiControl(getElementMap().get("btnSignIn"), webDriver);
    private final GuiControl iconAccount = new GuiControl(getElementMap().get("iconAccount"), webDriver);
    private final GuiControl linkDashboard = new GuiControl(getElementMap().get("linkDashboard"), webDriver);
    private final GuiControl linkClasses = new GuiControl(getElementMap().get("linkClasses"), webDriver);
    private final GuiControl linkLibrary = new GuiControl(getElementMap().get("linkLibrary"), webDriver);
    private final GuiControl linkSetting = new GuiControl(getElementMap().get("linkSetting"), webDriver);
    private final GuiControl linkSignOut = new GuiControl(getElementMap().get("linkSignOut"), webDriver);
    private final GuiControl tabGetStarted = new GuiControl(getElementMap().get("tabGetStarted"), webDriver);
    private final GuiControl tabBrowsePhysics = new GuiControl(getElementMap().get("tabBrowsePhysics"), webDriver);
    private final GuiControl tabSubject = new GuiControl(getElementMap().get("tabSubject"), webDriver);
    private final GuiControl tabGrade = new GuiControl(getElementMap().get("tabGrade"), webDriver);
    private final GuiControl btnSearchFlexBook = new GuiControl(getElementMap().get("btnSearchFlexBook"), webDriver);
    private final GuiControl dropDownSubject = new GuiControl(getElementMap().get("dropDownSubject"), webDriver);
    private final GuiControl dropDownGrade = new GuiControl(getElementMap().get("dropDownGrade"), webDriver);
    private final GuiControl iconFeedBack = new GuiControl(getElementMap().get("iconFeedBack"), webDriver);
    private final GuiControl iconYes = new GuiControl(getElementMap().get("iconYes"), webDriver);
    private final GuiControl linkGoToDashboard = new GuiControl(getElementMap().get("linkGoToDashboard"), webDriver);
    private final GuiControl linkCK12LandingPage = new GuiControl(getElementMap().get("linkCK12LandingPage"), webDriver);
    private final GuiControl tabContent = new GuiControl(getElementMap().get("tabContent"), webDriver);
    private final GuiControl tapClasses = new GuiControl(getElementMap().get("tapClasses"), webDriver);
    private final GuiControl linkWhyCK12 = new GuiControl(getElementMap().get("linkWhyCK12"), webDriver);
    private final GuiControl ck12Video = new GuiControl(getElementMap().get("ck12Video"), webDriver);
    private final GuiControl drpdwnSelectLanguage = new GuiControl(getElementMap().get("drpdwnSelectLanguage"), webDriver);
    private final GuiControl linkLangMarathi = new GuiControl(getElementMap().get("linkLangMarathi"), webDriver);
    private final GuiControl textMarathiLanguage = new GuiControl(getElementMap().get("textMarathiLanguage"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl iFrame = new GuiControl(getElementMap().get("iFrame"), webDriver);
    private final GuiControl textExplore = new GuiControl(getElementMap().get("textExplore"), webDriver);
    private final GuiControl flipOverlaySimulation = new GuiControl(getElementMap().get("flipOverlaySimulation"), webDriver);
    private final GuiControl flipOverlayPlix = new GuiControl(getElementMap().get("flipOverlayPlix"), webDriver);
    private final GuiControl flipOverlayAdaptivePractice = new GuiControl(getElementMap().get("flipOverlayAdaptivePractice"), webDriver);
    private final GuiControl flipOverlayStudyGuide = new GuiControl(getElementMap().get("flipOverlayStudyGuide"), webDriver);
    private final GuiControl textFlipOverlaySimulation = new GuiControl(getElementMap().get("textFlipOverlaySimulation"), webDriver);
    private final GuiControl textFlipOverlayPlix = new GuiControl(getElementMap().get("textFlipOverlayPlix"), webDriver);
    private final GuiControl textFlipOverlayAdaptive = new GuiControl(getElementMap().get("textFlipOverlayAdaptive"), webDriver);
    private final GuiControl textFlipOverlayStudyGuide = new GuiControl(getElementMap().get("textFlipOverlayStudyGuide"), webDriver);
    private final GuiControl ck12HeaderText = new GuiControl(getElementMap().get("ck12HeaderText"), webDriver);
    private final GuiControl ck12MissionText = new GuiControl(getElementMap().get("ck12MissionText"), webDriver);
    private final GuiControl linkGrade1To5 = new GuiControl(getElementMap().get("linkGrade1To5"), webDriver);
    private final GuiControl dataGrade1 = new GuiControl(getElementMap().get("dataGrade1"), webDriver);
    private final GuiControl dataGrade2 = new GuiControl(getElementMap().get("dataGrade2"), webDriver);
    private final GuiControl dataGrade3 = new GuiControl(getElementMap().get("dataGrade3"), webDriver);
    private final GuiControl dataGrade4 = new GuiControl(getElementMap().get("dataGrade4"), webDriver);
    private final GuiControl dataGrade5 = new GuiControl(getElementMap().get("dataGrade5"), webDriver);
    private final GuiControl linkArithmetic = new GuiControl(getElementMap().get("linkArithmetic"), webDriver);
    private final GuiControl linkMeasurement = new GuiControl(getElementMap().get("linkMeasurement"), webDriver);
    private final GuiControl linkAlgebra = new GuiControl(getElementMap().get("linkAlgebra"), webDriver);
    private final GuiControl linkGeometry = new GuiControl(getElementMap().get("linkGeometry"), webDriver);
    private final GuiControl linkProbability = new GuiControl(getElementMap().get("linkProbability"), webDriver);
    private final GuiControl linkStatistics = new GuiControl(getElementMap().get("linkStatistics"), webDriver);
    private final GuiControl linkRecentlyViewedSubjects = new GuiControl(getElementMap().get("linkRecentlyViewedSubjects"), webDriver);
    private final GuiControl btnExplore = new GuiControl(getElementMap().get("btnExplore"), webDriver);
    private final GuiControl linkLibraryProd = new GuiControl(getElementMap().get("linkLibraryProd"), webDriver);

    public CBookLandingPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifySubjectDropDown() {
        dropDownSubject.scrollIntoView();
        return dropDownSubject.isElementPresent();
    }

    public boolean verifyGradeDropDown() {
        return dropDownGrade.isElementPresent();
    }

    public void clickOnFeedBackIcon() {
        try {
            reportLog("Checking FeedBAck Icon Is Present Or Not");
            if (iconYes.isElementPresent()) {
                reportLog("Yes CheckBox Is Present");
                iconFeedBack.clickJScript();
                reportLog("Successfully clicked on FeedBack Icon");
            }
        } catch (Exception e) {
            reportLog("Yes CheckBox Is Not Present");
            logger.info(e);
        }
    }

    public void getCountFlexBooks() {
        waitForSec(5);
        List<WebElement> list = webDriver.findElements(By.xpath("//div[@class='cover']"));
        count = list.size();
        reportLog("Successfully Got The Count Of FlexBooks And Count Is = " + count);
    }

    public void clickOnTryItNow(String email, String password) {
        LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);

        clickOnFlexBookLink();
        clickOnSignInIcon();
        loginPage.login(email, password);
        clickOnSignInButton();
        verifyTeacherAccountIcon();
        clickOnGetStarted();
        verifyLinksAfterGetStarted();
    }

    public void clickOnFlexBookLink() {
        waitForSec(2);
        if (btnExplore.isElementPresent()) {
            btnExplore.clickJScript();
            reportLog("Successfully clicked on Explore Button");
        }
        waitForSec(2);
        if (linkFlexBook.isElementPresent()) {
            linkFlexBook.clickJScript();
            reportLog("Successfully clicked on FlexBook link");
        }
    }

    public boolean verifyFlexBookLink() {
        waitForSec(5);
        return linkFlexBook.isElementPresent();
    }

    public void clickOnSignInIcon() {
        waitForSec(5);
        if (iconSignIn.isElementPresent()) {
            iconSignIn.clickJScript();
            reportLog("Successfully clicked on Sign In Icon");
        }
    }

    public boolean verifySignInButton() {
        waitForSec(5);
        return iconSignIn.isElementPresent();
    }

    public void clickOnSignInButton() {
        if (btnSignIn.isElementPresent()) {
            btnSignIn.clickJScript();
            reportLog("Successfully clicked on Sign In Button");
        }
    }

    public boolean verifyTeacherAccountIcon() {
        return iconAccount.isElementPresent();
    }

    public void clickOnAccountIcon() {
        if (iconAccount.isElementPresent()) {
            iconAccount.clickJScript();
            reportLog("Successfully clicked on Teacher Account Dropdown List");
        }
    }

    public boolean verifyLinkDashboard() {
        return linkDashboard.isElementPresent();
    }

    public boolean verifyLinkClasses() {
        return linkClasses.isElementPresent();
    }

    public void clickOnLinkClasses() {
        if (linkClasses.isElementPresent()) {
            linkClasses.click();
            reportLog("Successfully clicked on Link Classes");
        }
        waitForSec(5);
    }

    public boolean verifyLinkLibrary() {
        return linkLibrary.isElementPresent();
    }

    public void clickOnLinkLibrary() {
        waitForSec(4);
        if (linkLibrary.isElementPresent()) {
            linkLibrary.click();
            reportLog("Successfully clicked on Link Library");
        }
    }

    public void clickOnLinkLibraryProd() {
        waitForSec(4);
        if (linkLibraryProd.isElementPresent()) {
            linkLibraryProd.click();
            reportLog("Successfully clicked on Link Library");
        }
    }

    public boolean verifyLinkSetting() {
        return linkSetting.isElementPresent();
    }

    public boolean verifyLinkSignOut() {
        return linkSignOut.isElementPresent();
    }

    public void clickOnLinkSignOut() {
        if (linkSignOut.isElementPresent()) {
            linkSignOut.click();
            reportLog("Successfully clicked on Link SignOut");
        }
    }

    public void clickOnGetStarted() {
        if (tabGetStarted.isElementPresent()) {
            tabGetStarted.click();
            reportLog("Clicked on Get Started Tab");
        }
    }

    public boolean verifyLinksAfterGetStarted() {
        List<WebElement> afterGet = webDriver.findElements(By.xpath("//a[@data-dx-desc='course_landing_cbook_button']"));
        int afterCount = afterGet.size();
        if (afterCount > 0) {
            reportLog("Total Number of CourseBook Are = " + afterCount);
            return true;
        } else {
            reportLog("Total There is no FlexBook Present = " + afterCount);
            return false;
        }
    }

    public boolean verifyBrowsePhysicsTab() {
        tabBrowsePhysics.scrollIntoView();
        return tabBrowsePhysics.isElementPresent();
    }

    public void clickOnBrowsePhysicsTab() {
        if (tabBrowsePhysics.isElementPresent()) {
            tabBrowsePhysics.scrollIntoView();
            //tabBrowsePhysics.clickJScript();
            //tabBrowsePhysics.click();
            waitForSec(1);
            webDriver.navigate().to("https://master.ck12.org/fbbrowse/?_ga=2.243182850.1420319451.1596107612-585585221.1596107612");
            reportLog("User Successfully clicked On browse Physics tab");
        }
    }

    public boolean verifySubjectTab() {
        waitForSec(4);
        return tabSubject.isElementPresent();
    }

    public void scrollThroughSubjectTAb() {
        if (tabSubject.isElementPresent()) {
            tabSubject.scrollIntoView();
            reportLog("User Successfully Scrolled Screen through subject Tab");
        }
    }

    public boolean verifyGradeTab() {
        return tabGrade.isElementPresent();
    }

    public boolean verifySearchFlexBookButton() {
        return btnSearchFlexBook.isElementPresent();
    }

    public void clickOnSearchFlexBookButton() {
        if (btnSearchFlexBook.isElementPresent()) {
            btnSearchFlexBook.click();
            reportLog("User Successfully clicked On Search FlexBook Button");
        }
    }

    public boolean isGoToDashboardLinkVisible() {
        return linkGoToDashboard.isElementPresent();
    }

    public void clickOnCK12LandingPageLink() {
        if (linkCK12LandingPage.isElementPresent()) {
            linkCK12LandingPage.click();
            reportLog("Clicked on the CK12 landing page icon.");
        }
    }

    public void clickOnGoToDashboardPageLink() {
        if (linkGoToDashboard.isElementPresent()) {
            linkGoToDashboard.click();
            reportLog("Clicked on the Go To Dashboard link.");
        }
    }

    public boolean isTabContentVisible() {
        return tabContent.isElementPresent();
    }

    public boolean isTabClassesVisible() {
        return tapClasses.isElementPresent();
    }

    public boolean isLinkWhyCK12Visible() {
        return linkWhyCK12.isElementPresent();
    }

    public void clickOnWhyCK12Link() {
        if (linkWhyCK12.isElementPresent()) {
            linkWhyCK12.click();
            reportLog("Clicked on the Why CK12 link.");
        }
    }

    public boolean isCK12VideoVisible() {
        waitForSec(5);
        return ck12Video.isElementPresent();
    }

    public void clickOnSelectLanguageDrpDwn() {
        drpdwnSelectLanguage.scrollIntoView();
        if (drpdwnSelectLanguage.isElementPresent()) {
            drpdwnSelectLanguage.click();
            reportLog("Clicked on the select language drop down.");
        }
    }

    public void selectLanguage() {
        linkLangMarathi.switchToFrameByFrameElement(iFrame.getWebElement());
        if (linkLangMarathi.isElementPresent()) {
            linkLangMarathi.click();
            reportLog("Selected the marathi language.");
        }
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.click();
            reportLog("Clicked on the close icon.");
        }
    }

    public void switchToFrame() {
        webDriver.switchTo().frame(0);
        reportLog("Switched to the frame.");
    }

    public void switchedOutFromFrame() {
        webDriver.switchTo().defaultContent();
        reportLog("Switched out from the frame.");
    }

    public boolean isMarathiTextVisible() {
        textMarathiLanguage.scrollIntoView();
        String textMarathi = "प्रत्येक विद्यार्थ्यासाठी 100% मोफत, वैयक्तिकृत शिक्षण";
        return textMarathi.equals(textMarathiLanguage.getText());
    }

    public boolean verifySimulationTextByMouseHover() {
        textExplore.scrollIntoView();
        reportLog("Scrolled to embeds explore.");
        flipOverlaySimulation.mouseHover();
        reportLog("Mouse hover on Simulation.");
        String textSimulation = "Discover a new way of learning Physics and Chemistry using Real World Simulations.";
        return textSimulation.equals(textFlipOverlaySimulation.getText());
    }

    public boolean verifyPlixTextByMouseHover() {
        flipOverlayPlix.mouseHover();
        reportLog("Mouse hover on PLIX.");
        String textSimulation = "Play, Learn, Interact and Xplore a concept with PLIX.";
        return textSimulation.equals(textFlipOverlayPlix.getText());
    }

    public boolean verifyAdaptivePracticeTextByMouseHover() {
        flipOverlayAdaptivePractice.mouseHover();
        reportLog("Mouse hover on Adaptive Practice.");
        String textSimulation = "Master Math and Science concepts through regular practice.";
        return textSimulation.equals(textFlipOverlayAdaptive.getText());
    }

    public boolean verifyStudyGuideTextByMouseHover() {
        flipOverlayStudyGuide.mouseHover();
        reportLog("Mouse hover on Study guide.");
        String textSimulation = "Find schools and districts near you that are on CK-12.";
        return textSimulation.equals(textFlipOverlayStudyGuide.getText());
    }

    public boolean verifyCK12MissionHeaderText() {
        String textHeader = "100% Free, Personalized Learning for Every Student";
        return textHeader.equals(ck12HeaderText.getText());
    }

    public boolean verifyCK12MissionText() {
        String textMission = "Create digital classrooms, customize textbooks, and learnK-12 STEM concepts.";
        String textCK12Mission = String.valueOf(ck12MissionText.getText());
        return textMission.equals(String.valueOf(textCK12Mission.replace("\n", "")));
    }

    public void clickOnLinkGrade1To5() {
        if (linkGrade1To5.isElementPresent()) {
            linkGrade1To5.clickJScript();
            reportLog("Clicked on the link Gride 1-5.");
        }
    }

    public boolean verifyTheDataGradesOnSubjectPage() {
        return dataGrade1.isDisplayed() && dataGrade2.isDisplayed() && dataGrade3.isDisplayed() && dataGrade4.isDisplayed() && dataGrade5.isDisplayed();
    }

    public void scrollToElement() {
        linkGrade1To5.scrollIntoView();
    }

    public void clickOnArithmeticSubjectLink() {
        if (linkArithmetic.isElementPresent()) {
            linkArithmetic.clickJScript();
            reportLog("Clicked on the arithmetic subject link on the CK12 landing page.");
        }
    }

    public void clickOnMeasurementSubjectLink() {
        if (linkMeasurement.isElementPresent()) {
            linkMeasurement.clickJScript();
            reportLog("Clicked on the measurement subject link on the CK12 landing page.");
        }
    }

    public void clickOnAlgebraSubjectLink() {
        if (linkAlgebra.isElementPresent()) {
            linkAlgebra.clickJScript();
            reportLog("Clicked on the algebra subject link on the CK12 landing page.");
        }
    }

    public void clickOnGeometrySubjectLink() {
        if (linkGeometry.isElementPresent()) {
            linkGeometry.clickJScript();
            reportLog("Clicked on the geometry subject link on the CK12 landing page.");
        }
    }

    public void clickOnProbabiliySubjectLink() {
        if (linkProbability.isElementPresent()) {
            linkProbability.clickJScript();
            reportLog("Clicked on the probability subject link on the CK12 landing page.");
        }
    }

    public void clickOnStatisticsSubjectLink() {
        if (linkStatistics.isElementPresent()) {
            linkStatistics.clickJScript();
            reportLog("Clicked on the statistics subject link on the CK12 landing page.");
        }
    }
}