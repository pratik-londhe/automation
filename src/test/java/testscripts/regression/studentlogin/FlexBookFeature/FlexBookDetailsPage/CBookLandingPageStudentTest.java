package testscripts.regression.studentlogin.FlexBookFeature.FlexBookDetailsPage;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.CBookPageStudent;
import uipages.flexbook2feature.LoginPage;

public class CBookLandingPageStudentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookLandingPageStudentTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the options present under Student Profile dropdown on CourseBook landing page")
    public void verifyStudentIcon(String email, String password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);

            cBookLandingPage.clickOnFlexBookLink();
            cBookLandingPage.clickOnSignInIcon();
            loginPage.login(email, password);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Student icon' after logging in.";
            Assert.assertTrue(cBookPageStudent.verifyStudentAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            cBookLandingPage.clickOnAccountIcon();

            String assertTextVLD = "Presence of 'Dashboard' link.";
            Assert.assertTrue(cBookLandingPage.verifyLinkDashboard(), assertFailurePreText + assertTextVLD);
            reportLog(assertTextVLD);

            String assertTextVLC = "Presence of 'My Classes' link.";
            Assert.assertTrue(cBookLandingPage.verifyLinkClasses(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

            String assertTextVLL = "Presence of 'My Library' link.";
            Assert.assertTrue(cBookLandingPage.verifyLinkLibrary(), assertFailurePreText + assertTextVLL);
            reportLog(assertTextVLL);

            String assertTextVLS = "Presence of 'Setting' link.";
            Assert.assertTrue(cBookLandingPage.verifyLinkSetting(), assertFailurePreText + assertTextVLS);
            reportLog(assertTextVLS);

            String assertTextVLSO = "Presence of 'Sign Out' link.";
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
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);

            cBookLandingPage.clickOnGetStarted();

            String assertTextVLAGS = "Presence of at least one Flexbook.";
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
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);

            String assertTextVBPT = "Presence of 'Browse Physics' link.";
            Assert.assertTrue(cBookLandingPage.verifyBrowsePhysicsTab(), assertFailurePreText + assertTextVBPT);
            reportLog(assertTextVBPT);

            cBookLandingPage.clickOnBrowsePhysicsTab();

            String assertTextVST = "Presence of 'Subject' tab.";
            Assert.assertTrue(cBookLandingPage.verifySubjectTab(), assertFailurePreText + assertTextVST);
            reportLog(assertTextVST);

            String assertTextVGT = "Presence of 'Grade' dropdown.";
            Assert.assertTrue(cBookLandingPage.verifyGradeTab(), assertFailurePreText + assertTextVGT);
            reportLog(assertTextVGT);

            String assertTextVSFBB = "Presence of 'Search Flexbook' button.";
            Assert.assertTrue(cBookLandingPage.verifySearchFlexBookButton(), assertFailurePreText + assertTextVSFBB);
            reportLog(assertTextVSFBB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the functionality of 'Search FlexBook' Button After Clicking On Browse Physics Button.")
    public void verifyFunctionalityOfSearchFlexBookButton() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);

            cBookLandingPage.clickOnSearchFlexBookButton();
            cBookLandingPage.getCountFlexBooks();

            String assertTextVSDD = "Presence of 'Browse Subject' dropdown.";
            Assert.assertTrue(cBookLandingPage.verifySubjectDropDown(), assertFailurePreText + assertTextVSDD);
            reportLog(assertTextVSDD);

            String assertTextVSD = "Presence of 'Browse Grade' dropdown.";
            Assert.assertTrue(cBookLandingPage.verifyGradeDropDown(), assertFailurePreText + assertTextVSD);
            reportLog(assertTextVSD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}