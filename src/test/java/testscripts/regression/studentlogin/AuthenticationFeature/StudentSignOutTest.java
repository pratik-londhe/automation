package testscripts.regression.studentlogin.AuthenticationFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SignOutPage;
import uipages.flexbook2feature.StudentDashBoardPage;

public class StudentSignOutTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentSignOutTest.class);

    @Test(dataProvider = "CK12DataProvider", description = "Verify the student sign out.")
    public void studentSignOut(String email, String password) {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, password);

            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), "Failed to verify user profile for StudentSignOutTest.");
            reportLog( "User Successfully logged in and verified profile icon.");

            signOutPage.clickOnUserProfileIcon();

            Assert.assertTrue(signOutPage.verifySignOut(), "Failed to verify student sign out.");
            reportLog( "User logged out successfully");

            signOutPage.clickOnSignOut();

            Assert.assertTrue(new LoginPage(webDriver,extentTest, extentReports).verifySignInLink(), "Failed to verify student sign In Link.");
            reportLog( "User successfully verify student sign In Link.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for studentSignOut method : " + errorMessage);
    }
}