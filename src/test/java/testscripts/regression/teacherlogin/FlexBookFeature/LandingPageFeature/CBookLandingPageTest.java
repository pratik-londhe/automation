package testscripts.regression.teacherlogin.FlexBookFeature.LandingPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.LoginPage;

public class CBookLandingPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookLandingPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the options present under User Profile dropdown on CourseBook landing page")
    public void verifyTeacherIcon(String email, String password, String url) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to(url);
            cBookLandingPage.clickOnFlexBookLink();
            cBookLandingPage.clickOnSignInIcon();
            loginPage.login(email, password);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVTAI = "Presence of Teacher account icon";
            Assert.assertTrue(cBookLandingPage.verifyTeacherAccountIcon(), assertFailurePreText + assertTextVTAI);
            reportLog(assertTextVTAI);

            cBookLandingPage.clickOnAccountIcon();

            String assertTextVLD = "Presence of Dashboard Link";
            Assert.assertTrue(cBookLandingPage.verifyLinkDashboard(), assertFailurePreText + assertTextVLD);
            reportLog(assertTextVLD);

            String assertTextVLC = "Presence of 'My Classes' link";
            Assert.assertTrue(cBookLandingPage.verifyLinkClasses(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

            String assertTextVLL = "Presence of 'My Library' link";
            Assert.assertTrue(cBookLandingPage.verifyLinkLibrary(), assertFailurePreText + assertTextVLL);
            reportLog(assertTextVLL);

            String assertTextVLSI = "Presence of 'Settings' link";
            Assert.assertTrue(cBookLandingPage.verifyLinkSetting(), assertFailurePreText + assertTextVLSI);
            reportLog(assertTextVLSI);

            String assertTextVLSO = "Presence of 'Sign Out' link";
            Assert.assertTrue(cBookLandingPage.verifyLinkSignOut(), assertFailurePreText + assertTextVLSO);
            reportLog(assertTextVLSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the functionality of 'Get Started' button on CourseBook landing page.")
    public void VerifyGetStarted() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);

            cBookLandingPage.clickOnGetStarted();

            String assertTextVLAGS = "Flexbook links after clicking on 'Get Started'";
            Assert.assertTrue(cBookLandingPage.verifyLinksAfterGetStarted(), assertFailurePreText + assertTextVLAGS);
            reportLog(assertTextVLAGS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the functionality of 'Browse Physics' button on CourseBook landing page.")
    public void checkBrowsePhysicsButton() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);

            String assertTextVBPT = "Presence of 'Browse Physics' tab.";
            Assert.assertTrue(cBookLandingPage.verifyBrowsePhysicsTab(), assertFailurePreText + assertTextVBPT);
            reportLog(assertTextVBPT);

            cBookLandingPage.clickOnBrowsePhysicsTab();

            String assertTextVST = "Presence of 'Subject' tab.";
            Assert.assertTrue(cBookLandingPage.verifySubjectTab(), assertFailurePreText + assertTextVST);
            reportLog(assertTextVST);

            String assertTextVGT = "Presence of 'Grade' tab.";
            Assert.assertTrue(cBookLandingPage.verifyGradeTab(), assertFailurePreText + assertTextVGT);
            reportLog(assertTextVGT);

            cBookLandingPage.scrollThroughSubjectTAb();

            String assertTextVSFB = "Presence of the 'Search Flexbook' tab";
            Assert.assertTrue(cBookLandingPage.verifySearchFlexBookButton(), assertFailurePreText + assertTextVSFB);
            reportLog(assertTextVSFB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the functionality of 'Search FlexBook' Button After Clicking On Browse Physics Button.")
    public void verifyFunctionalityOfSearchFlexBookButton() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);

            cBookLandingPage.clickOnSearchFlexBookButton();
            cBookLandingPage.getCountFlexBooks();

            String assertTextVSDD = "Presence of Browse subject dropdown";
            Assert.assertTrue(cBookLandingPage.verifySubjectDropDown(), assertFailurePreText + assertTextVSDD);
            reportLog(assertTextVSDD);

            String assertTextVGDD = "Presence of browse grade dropdown";
            Assert.assertTrue(cBookLandingPage.verifyGradeDropDown(), assertFailurePreText + assertTextVGDD);
            reportLog(assertTextVGDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}