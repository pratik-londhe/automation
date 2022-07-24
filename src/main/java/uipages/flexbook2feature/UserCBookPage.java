package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import uipages.BasePage;
import utils.GuiControl;

public class UserCBookPage extends BasePage {

    private final GuiControl btnSignInGoogle = new GuiControl(getElementMap().get("btnSignInGoogle"), webDriver);
    private final GuiControl txtPleaseSignInMessage = new GuiControl(getElementMap().get("txtPleaseSignInMessage"), webDriver);
    private final GuiControl txtEmail = new GuiControl(getElementMap().get("txtEmail"), webDriver);

    public UserCBookPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    private void clickOnTryItNowPopUpAndGoFurther() {

        CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);

        cBookLandingPage.clickOnFlexBookLink();
    }

    public void clickOnFirstFlexBookAndGoFurther() {

        UserCBookPage userCBookPage = new UserCBookPage(webDriver,extentTest,extentReports);
        CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);

        userCBookPage.clickOnTryItNowPopUpAndGoFurther();
        courseBookDetailsPage.clickOnFirstFlexBook();

        Assert.assertTrue(courseBookDetailsPage.verifyAuthorLink(), "Test Script Field to Verify Author Link");
        reportLog("User Successfully Verify Author Link");

        Assert.assertTrue(courseBookDetailsPage.verifyDetailsTab(), "Test Script Field to Verify Details Tab");
        reportLog("User Successfully  Verify Details Tab");

        courseBookDetailsPage.clickOnDetailsTab();
        courseBookDetailsPage.clickOnOverviewTab();

        Assert.assertTrue(courseBookDetailsPage.verifyChaptersLink(), "Test Script Field to Verify Chapters Link");
        reportLog("User Successfully Verify Chapters Link");

        courseBookDetailsPage.clickOnFirstChapter();

        Assert.assertTrue(courseBookDetailsPage.verifyLinksOfChapterConcept(), "Test Script Field to Verify Concepts Link");
        reportLog("User Successfully Verify Concepts Link");

        courseBookDetailsPage.clickFirstConceptOfLink();

        Assert.assertTrue(courseBookDetailsPage.verifyNextButton(), "Test Script Field to Verify Next Button");
        reportLog("User Successfully Verify Next Button");

        Assert.assertTrue(courseBookDetailsPage.verifyStartButton(), "Test Script Field to Verify Start Button");
        reportLog("User Successfully Verify Start Button");
    }

    public boolean verifySignInGoogleButton() {
        return btnSignInGoogle.isElementPresent();
    }

    public boolean verifyPleaseSignInMessageText() {
        return txtPleaseSignInMessage.isElementPresent();
    }

    public void setEmail(String email) {
        if (txtEmail.isElementPresent()) {
            txtEmail.setText(email);
            reportLog("Successfully Set Email");
        }
    }
}