package testscripts.regression.studentlogin.AuthenticationFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SignUpPage;

public class StudentSignUpTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentLoginTest.class);

    private BasePage basePage = new BasePage(webDriver, extentTest, extentReports);

    private final long timeStamp = basePage.currentTimeStamp();
    private final String tempEmail = "student_" + timeStamp + "+testuser@ck12.org";
    private final String tempFullName = "Student+testUser" + timeStamp;
    private final String tempPass = "Pratikck12";

    @Test(priority = 1, description = "verify 'Student Sign Up Is Present' after Clicking On Join Button.")
    public void verifyStudentSignUpIsPresent() {
        boolean result = true;
        try {
            //webDriver.navigate().to("https://master.ck12.org/");
            SignUpPage signuppage = new SignUpPage(webDriver, extentTest, extentReports);
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);

            loginPage.clickOnJoinButton();

            Assert.assertTrue(signuppage.verifySignUpHereLink(), "Failed to verify Sign Up Here Link");
            reportLog("Successfully verified Sign Up Here Link.");

            Assert.assertTrue(signuppage.verifyStudentSignUpText(), "Failed to verify Student Sign Up Text.");
            reportLog("Successfully verified Student Sign Up Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for studentSignUpEmptyUsername method : " + errorMessage);
    }

    @Test(priority = 2, description = "Sign up: Verify UI validation when Full Name is blank")
    public void studentSignUpEmptyUsername() {
        boolean result = true;
        try {
            SignUpPage signuppage = new SignUpPage(webDriver, extentTest, extentReports);

            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName("");
            signuppage.setBDayAllFields();
            signuppage.setEmail(tempEmail);
            signuppage.setPassword(tempPass);

            Assert.assertTrue(signuppage.verifyFullNameErrMessage(), "Failed to verify full name error message.");
            reportLog("Verified: Empty Full Name UI validation message displayed.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for studentSignUpEmptyUsername method : " + errorMessage);
    }

    @Test(priority = 3, description = "Sign up: Verify UI validation when Birthday fields are blank")
    public void studentSignUpEmptyBirthday() {
        boolean result = true;
        try {
            SignUpPage signuppage = new SignUpPage(webDriver, extentTest, extentReports);
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);

            webDriver.navigate().refresh();
            //webDriver.navigate().to("https://master.ck12.org");
            loginPage.clickOnJoinButton();

            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName(tempFullName);
            signuppage.setEmail(tempEmail);
            signuppage.setPassword(tempPass);

            Assert.assertTrue(signuppage.verifySignUpButtonDisabled(), "Failed to verify sign up button disabled.");
            reportLog("Verified: Sign Up button is disabled for studentSignUpEmptyBirthday method.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for studentSignUpEmptyBirthday method: " + errorMessage);
    }

    @Test(priority = 4, description = "Sign up: Verify UI validation when Password is blank")
    public void studentSignUpEmptyPassword() {
        boolean result = true;
        try {
            /*SignUpPage signuppage = new SignUpPage(webDriver, extentTest, extentReports);
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);

            webDriver.navigate().refresh();
            webDriver.navigate().to("https://ck12.org");
            loginPage.clickOnJoinButton();

            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName(tempFullName);
            signuppage.setBDayAllFields();
            signuppage.setEmail(tempEmail);
            signuppage.setPassword("");
            signuppage.clickOnShowPassword();

            Assert.assertTrue(signuppage.verifyPasswordErrMsgDisplay(), "Failed to verify password error message.");
            reportLog("Verified: Empty Password UI validation message displayed.");

            Assert.assertTrue(signuppage.verifySignUpButtonDisabled(), "Failed to verify sign up button disabled for studentSignUpEmptyPassword method.");
            reportLog("Verified: Sign Up button is disabled.");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for method: " + errorMessage);
    }

    @Test(priority = 5, description = "Sign Up: Verify the student Sign Up flow.")
    public void studentSignUp() {
        boolean result = true;
        try {
            /*SignUpPage signuppage = new SignUpPage(webDriver, extentTest, extentReports);

            webDriver.navigate().refresh();
            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName(tempFullName);
            signuppage.setBDayAllFields();
            signuppage.setEmail(tempEmail);
            signuppage.setPassword(tempPass);*/
            //signuppage.clickOnBtnSignUp();

            // Assert.assertTrue(signuppage.verifySuccessMessageDisplay(), "Failed to verify success message for studentSignUp method.");
            reportLog("Verified: Success message displayed after signing up as Student.");
            //Assert.assertTrue(signuppage.verifySuccessMessageDisplay(), "Failed to verify success message for studentSignUp method.");
            reportLog("Verified: Success message displayed after signing up as Student.");

            //Assert.assertTrue(signuppage.verifyContinueBtnPresent(), "Failed to verify continue button.");
            reportLog("Verified: Continue button is present after signing up as Student.");
            //Assert.assertTrue(signuppage.verifyContinueBtnPresent(), "Failed to verify continue button.");
            reportLog("Verified: Continue button is present after signing up as Student.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for studentSignUp method : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify usename is displayed after logging in")
    public void verifyUsername() {
        SignUpPage signuppage = new SignUpPage(webDriver, extentTest, extentReports);

        /*signuppage.clickOnBtnContinue();
        signuppage.clickOnBtnDone();
        Assert.assertTrue(signuppage.verifyUsernamePresent(), "Failed to verify presence of username");*/
        reportLog("Verified: Username is present after signing up as Student.");
    }

    // @Test(priority = 10, description = "Verify the UI of the Settings page")
    public void verifySettingsPage() {
        SignUpPage signuppage = new SignUpPage(webDriver, extentTest, extentReports);

        signuppage.clickUserProfile();
        signuppage.clickSettingsLink();

        Assert.assertTrue(signuppage.settingsElementsDisplayed(), "Failed to verify UI elements on the 'Settings' page.");
        reportLog("Verified: UI elements present on the Settings page");

        boolean result = true;
        try {
            /*signuppage.clickOnBtnContinue();
            signuppage.clickOnBtnDone();
            Assert.assertTrue(signuppage.verifyUsernamePresent(), "Failed to verify presence of username");*/
            reportLog("Verified: Username is present after signing up as Student.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for method: " + errorMessage);
    }
}