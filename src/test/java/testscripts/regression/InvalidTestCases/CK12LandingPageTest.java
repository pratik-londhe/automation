package testscripts.regression.InvalidTestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;

public class CK12LandingPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CK12LandingPageTest.class);

    public String assertSuccessPreText = "Successfully verified: ";
    public String testCaseFailureText = "Test failed for method: ";
    public String assertFailurePreText = "Failed to verify: ";
    CBookLandingPage cBookLandingPage;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Go To Dashboard Link.")
    public void verifyGoToDashboardLink(String email, String password) {
        boolean result = true;
        try {
            cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPG = "Presence of teacher profile icon.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            cBookLandingPage.clickOnCK12LandingPageLink();

            String assertTextIGTDLV = "Presence of Go To Dashboard link.";
            Assert.assertTrue(cBookLandingPage.isGoToDashboardLinkVisible(), assertFailurePreText + assertTextIGTDLV);
            reportLog(assertTextIGTDLV);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Functionality of Go To Dashboard link.")
    public void verifyFunctionalityOfGoToDashboardLink() {
        boolean result = true;
        try {
            cBookLandingPage.clickOnGoToDashboardPageLink();

            String assertTextITCV = "Presence of content tab on dashboard page.";
            Assert.assertTrue(cBookLandingPage.isTabContentVisible(), assertFailurePreText + assertTextITCV);
            reportLog(assertTextITCV);

            String assertTextVTCV = "Presence of classes tab on dashboard page.";
            Assert.assertTrue(cBookLandingPage.isTabClassesVisible(), assertFailurePreText + assertTextVTCV);
            reportLog(assertTextVTCV);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Why CK12 Link.")
    public void verifyWhyCK12Link() {
        boolean result = true;
        try {
            cBookLandingPage.clickOnCK12LandingPageLink();

            String assertTextILWCK12V = "Presence of Why CK12 link.";
            Assert.assertTrue(cBookLandingPage.isLinkWhyCK12Visible(), assertFailurePreText + assertTextILWCK12V);
            reportLog(assertTextILWCK12V);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the functionality of Why CK12 link.")
    public void verifyFunctionalityOfWhyCK12Link() {
        boolean result = true;
        try {
            cBookLandingPage.clickOnWhyCK12Link();
            cBookLandingPage.switchToFrame();

            String assertTextICK12VV = "Presence of CK12 video.";
            Assert.assertTrue(cBookLandingPage.isCK12VideoVisible(), assertFailurePreText + assertTextICK12VV);
            reportLog(assertTextICK12VV);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the functionality of select language drop down.")
    public void verifyFunctionalityOfSelectLanguageDrpDwn() {
        boolean result = true;
        try {
            cBookLandingPage.switchedOutFromFrame();
            cBookLandingPage.clickOnCloseIcon();
            cBookLandingPage.clickOnSelectLanguageDrpDwn();
            cBookLandingPage.selectLanguage();
            cBookLandingPage.switchedOutFromFrame();

            String assertTextITCV = "Presence of marathi language text.";
            Assert.assertTrue(cBookLandingPage.isMarathiTextVisible(), assertFailurePreText + assertTextITCV);
            reportLog(assertTextITCV);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}