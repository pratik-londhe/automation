package testscripts.regression.teacherlogin.AuthenticationFeature;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.ForgotPasswordSignInPopUp;
import uipages.flexbook2feature.LoginPage;

public class ForgotPasswordSignInPopUpTest extends BaseTestScript {

    @Test(priority = 1, description = "Verify Functionality of 'Forgot Password Link' On SignIn Pop Up")
    public void ForgotPasswordLink() {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            ForgotPasswordSignInPopUp forgotPasswordSignInPopUp = new ForgotPasswordSignInPopUp(webDriver, extentTest, extentReports);

            loginPage.clickOnSignInLink();

            Assert.assertTrue(forgotPasswordSignInPopUp.verifyForgotPasswordLink(), " Failed To verify Forgot Password link");
            reportLog("User SuccessFully Verify Forgot Password link ");

            forgotPasswordSignInPopUp.clickOnForgotPasswordLink();

            Assert.assertTrue(forgotPasswordSignInPopUp.verifySendAddressButton(), " Failed To verify Send Address Button");
            reportLog("Send Address Button");

            Assert.assertTrue(forgotPasswordSignInPopUp.verifyCancelButton(), " Failed To verify Cancel Button");
            reportLog("Cancel Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for ForgotPasswordLink method. " + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality of 'Cancel' Button On Forgot Password Pop Up")
    public void CancelButtonOnForgotPasswordPopUp() {
        ForgotPasswordSignInPopUp forgotPasswordSignInPopUp = new ForgotPasswordSignInPopUp(webDriver, extentTest, extentReports);
        boolean result = true;
        try {
            forgotPasswordSignInPopUp.clickOnCancelButton();

            Assert.assertTrue(forgotPasswordSignInPopUp.verifyJoinButton(), " Failed To verify Join Button");
            reportLog("Join Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for Cancel Button On Forgot Password Pop Up method. " + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Send Address' Button Without Feeling Email Address")
    public void SendAddressWithoutEmail() {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            ForgotPasswordSignInPopUp forgotPasswordSignInPopUp = new ForgotPasswordSignInPopUp(webDriver, extentTest, extentReports);

            loginPage.clickOnSignInLink();

            Assert.assertTrue(forgotPasswordSignInPopUp.verifyForgotPasswordLink(), " Failed To verify Forgot Password link");
            reportLog("Forgot Password link ");

            forgotPasswordSignInPopUp.clickOnForgotPasswordLink();

            Assert.assertTrue(forgotPasswordSignInPopUp.verifySendAddressButton(), " Failed To verify Send Address Button");
            reportLog("Send Address Button");

            forgotPasswordSignInPopUp.clickOnSendAddressButton();

            Assert.assertTrue(forgotPasswordSignInPopUp.verifyCancelButton(), " Failed To verify cancel button in SendAddressWithoutEmail method");
            reportLog("Cancel Button ");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for SendAddressWithoutEmail method. " + errorMessage);
    }

    @Test(priority = 4, dataProvider = "CK12DataProvider", description = "Verify Functionality of 'Send Address' Button With Feeling Email Address")
    public void SendPasswordWithEmail(String emailAddress) {
        boolean result = true;
        try {
            ForgotPasswordSignInPopUp forgotPasswordSignInPopUp = new ForgotPasswordSignInPopUp(webDriver, extentTest, extentReports);

            forgotPasswordSignInPopUp.clickOnTxtAddress(emailAddress);
            forgotPasswordSignInPopUp.clickOnSendAddressButton();

            Assert.assertTrue(forgotPasswordSignInPopUp.verifyJoinButton(), " Failed To verify Join Button");
            reportLog("Join Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for Send Password With Email method. " + errorMessage);
    }
}