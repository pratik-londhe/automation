package testscripts.regression.teacherlogin.AuthenticationFeature;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SignOutPage;
import uipages.flexbook2feature.TeacherDashboardPage;

public class TeacherSignOutTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TeacherSignOutTest.class);
    public String testCaseFailureText = "Test failed for method: ";

    @Test(dataProvider = "CK12DataProvider", description = "Verify the Teacher Sign Out.")
    public void teacherSignOut(String email, String password) {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + "Presence of Teacher account icon On Gamma");
            reportLog("Presence of Teacher account icon On Gamma");

            signOutPage.clickOnUserProfileIcon();

            Assert.assertTrue(signOutPage.verifySignOut(), assertFailurePreText + "Presence of Sign Out Link After Clicking On Account Icon");
            reportLog("Presence of Sign Out Link After Clicking On Account Icon");

            signOutPage.clickOnSignOut();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
