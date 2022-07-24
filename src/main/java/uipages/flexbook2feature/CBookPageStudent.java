package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class CBookPageStudent extends BasePage {

    private String textOfFirstConceptLink;
    private String firstNameOfConcept;
    private String secondNameOfConcept;

    private final GuiControl iconAccount = new GuiControl(getElementMap().get("iconAccount"), webDriver);
    private final GuiControl btnStartCourseDetail = new GuiControl(getElementMap().get("btnStartCourseDetail"), webDriver);
    private final GuiControl txtLastModified = new GuiControl(getElementMap().get("txtLastModified"), webDriver);
    private final GuiControl btnViewPractice = new GuiControl(getElementMap().get("btnViewPractice"), webDriver);
    private final GuiControl btnKeepPracticing = new GuiControl(getElementMap().get("btnKeepPracticing"), webDriver);
    private final GuiControl txtNameOfConcept = new GuiControl(getElementMap().get("txtNameOfConcept"), webDriver);
    private final GuiControl nextIcon = new GuiControl(getElementMap().get("nextIcon"), webDriver);
    private final GuiControl insightPopUp = new GuiControl(getElementMap().get("insightPopUp"), webDriver);

    public CBookPageStudent(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnTryItNowPopUp(String email, String password) {

        CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
        LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
        CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);

        cBookLandingPage.clickOnFlexBookLink();
        cBookLandingPage.clickOnSignInIcon();
        loginPage.login(email, password);
        cBookLandingPage.clickOnSignInButton();
        cBookPageStudent.verifyStudentAccountIcon();
        cBookLandingPage.clickOnGetStarted();
        cBookLandingPage.verifyLinksAfterGetStarted();
    }

    public boolean verifyStudentAccountIcon() {
        return iconAccount.isElementPresent();
    }

    public boolean verifyProfileIcon() {
        return iconAccount.isElementPresent();
    }

    public boolean verifyStartCourseDetailsButton() {
        waitForSec(5);
        return btnStartCourseDetail.isElementPresent();
    }

    public void clickOnTheNextIcon() {
        waitForSec(5);
        nextIcon.clickJScript();
    }

    public boolean verifyTextLastModified() {
        return txtLastModified.isElementPresent();
    }

    public void clickOnStartCourseDetailButton() {
        btnStartCourseDetail.scrollIntoView();
        if (btnStartCourseDetail.isElementPresent()) {
            btnStartCourseDetail.click();
            reportLog("Successfully Clicked On Start Button");
        }
    }

    public void getTextOfFirstConceptLink() {
        waitForSec(5);
        List<WebElement> link = webDriver.findElements(By.xpath("//a[@data-dx-desc='course_toc_section_button']"));
        for (WebElement linksName : link) {
            if (linksName.isDisplayed()) {
                textOfFirstConceptLink = linksName.getText();
                reportLog("Text Present in this Link is = " + textOfFirstConceptLink);
                break;
            }
        }
    }

    public boolean verifyStartPracticeButton() {
        waitForSec(8);
        return btnViewPractice.isElementPresent();
    }

    public void clickOnStartPracticeButton() {
        waitForSec(6);
        if (btnViewPractice.isElementPresent()) {
            btnViewPractice.clickJScript();
            reportLog("Successfully Clicked On View Practice Button");
        }
    }

    public boolean verifyKeepPracticingButton() {
        return btnKeepPracticing.isElementPresent();
    }

    public void clickOnKeepPracticingButton() {
        if (btnKeepPracticing.isElementPresent()) {
            btnKeepPracticing.click();
            reportLog("Successfully Clicked On Keep Practicing Button");
        }
    }

    public void getNameOfFirstConcept() {
        if (txtNameOfConcept.isElementPresent()) {
            firstNameOfConcept = txtNameOfConcept.getText();
            reportLog("Successfully Fetch Name Of First Concept, Name is = " + firstNameOfConcept);
        }
    }

    public void getNameOfSecondConcept() {
        if (txtNameOfConcept.isElementPresent()) {
            secondNameOfConcept = txtNameOfConcept.getText();
            reportLog("Successfully Fetch Name Of Second Concept, Name is = " + secondNameOfConcept);
        }
    }

    public boolean verifyTextConceptName() {
        waitForSec(5);
        return !firstNameOfConcept.equals(secondNameOfConcept);
    }

    public void clickOnInsightPopUp() {
        waitForSec(5);
        try {
            insightPopUp.click();
            logger.info("Closed the insights pop up.");
        } catch (Exception e) {
            logger.info(e);
            logger.info("Pop up is not present.");
        }
    }
}