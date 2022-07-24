package testscripts.regression.teacherlogin.AuthenticationFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SignUpPage;

/**
 * @author Yash Shrimali
 */

public class TeacherSignUpTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TeacherSignUpTest.class);

    private BasePage basePage = new BasePage(webDriver, extentTest, extentReports);
    private SignUpPage signuppage;

    private final long timeStamp = basePage.currentTimeStamp();
    private final String tempEmail = "teacher" + timeStamp + "+testuser@ck12.org";
    private final String tempFullName = "teacher+testUser" + timeStamp;
    private final String tempPass = "Pratikck12";

    @Test(priority = 1, description = "Verify the Student 'Sign Up Here' link Is Present After Clicking On Join Button.")
    public void verifyStudentSignUpHereIsPresent() {
        boolean result = true;
        try {
            signuppage = new SignUpPage(webDriver, extentTest, extentReports);

            //webDriver.navigate().to("https://master.ck12.org/");
            new LoginPage(webDriver, extentTest, extentReports).clickOnJoinButton();

            Assert.assertTrue(signuppage.verifySignUpHereLink(), "Failed to verify Sign Up Here Link");
            reportLog("Successfully verified Sign Up Here Link.");

            Assert.assertTrue(signuppage.verifyStudentSignUpText(), "Failed to verify Student Sign Up Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Student Sign Up Text.");
            logger.info("Successfully verified Student Sign Up Text.");

            signuppage.clickOnSignUpHereLink();

            Assert.assertTrue(signuppage.verifySignUpHereLink(), "Failed to verify Sign Up Here Link");
            extentTest.log(LogStatus.PASS, "Successfully verified Sign Up Here Link.");
            logger.info("Successfully verified Sign Up Here Link.");

            Assert.assertTrue(signuppage.verifyTeacherSignUpText(), "Failed to verify Teacher Sign Up Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Teacher Sign Up Text.");
            logger.info("Successfully verified Teacher Sign Up Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for teacherSignUpWithBlankUsername method." + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Teacher Sign Up flow with blank username.")
    public void teacherSignUpWithBlankUsername() {
        boolean result = true;
        try {
            signuppage = new SignUpPage(webDriver, extentTest, extentReports);

            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName("");
            signuppage.setEmail(tempEmail);
            signuppage.setPassword(tempPass);
            signuppage.clickOnBtnSignUp();

            Assert.assertTrue(signuppage.verifyFullNameErrMessage(), "Failed to verify success message in teacherSignUp method.");
            extentTest.log(LogStatus.PASS, "Successfully verified the error message for empty username on teacher sign up page.");
            logger.info("Successfully verified the error message for empty username on teacher sign up page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for teacherSignUpWithBlankUsername method." + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Teacher Sign Up flow with blank email.")
    public void teacherSignUpWithBlankEmail() {
        boolean result = true;
        try {
            webDriver.navigate().refresh();
            signuppage = new SignUpPage(webDriver, extentTest, extentReports);

            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName(tempFullName);
            signuppage.setEmail("");
            signuppage.setPassword(tempPass);
            signuppage.clickOnBtnSignUp();

            Assert.assertTrue(signuppage.verifyEmailErrMessage(), "Failed to verify success message in teacherSignUp method.");
            extentTest.log(LogStatus.PASS, "Successfully verified the error message for empty email on teacher sign up page.");
            logger.info("Successfully verified the error message for empty email on teacher sign up page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for teacherSignUpWithBlankEmail method." + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Teacher Sign Up flow with blank password.")
    public void teacherSignUpWithBlankPass() {
        boolean result = true;
        try {
            webDriver.navigate().refresh();
            signuppage = new SignUpPage(webDriver, extentTest, extentReports);

            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName(tempFullName);
            signuppage.setEmail(tempEmail);
            signuppage.setPassword("");
            signuppage.clickOnShowPassword();

            Assert.assertTrue(signuppage.verifyPasswordErrMsgDisplay(), "Failed to verify success message in teacherSignUp method.");
            extentTest.log(LogStatus.PASS, "Successfully verified the error message for empty password on teacher sign up page.");
            logger.info("Successfully verified the error message for empty password on teacher sign up page.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for teacherSignUpWithBlankUsername method." + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Teacher Sign Up flow with all fields are blank.")
    public void teacherSignUpWithAllFieldsBlank() {
        boolean result = true;
        try {
            webDriver.navigate().refresh();
            signuppage = new SignUpPage(webDriver, extentTest, extentReports);

            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName("");
            signuppage.setEmail("");
            signuppage.setPassword("");
            signuppage.clickOnShowPassword();
            basePage.waitForSec(2);

            Assert.assertTrue(signuppage.verifyFullNameErrMessage(), "Failed to verify success message in teacherSignUp method.");
            extentTest.log(LogStatus.PASS, "Successfully verified the error message for empty username on teacher sign up page.");
            logger.info("Successfully verified the error message for empty username on teacher sign up page.");

            Assert.assertTrue(signuppage.verifyEmailErrMessage(), "Failed to verify success message in teacherSignUp method.");
            extentTest.log(LogStatus.PASS, "Successfully verified the error message for empty email on teacher sign up page.");
            logger.info("Successfully verified the error message for empty email on teacher sign up page.");

            Assert.assertTrue(signuppage.verifyPasswordErrMsgDisplay(), "Failed to verify success message in teacherSignUp method.");
            extentTest.log(LogStatus.PASS, "Successfully verified the error message for empty password on teacher sign up page.");
            logger.info("Successfully verified the error message for empty password on teacher sign up page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for teacherSignUpWithAllFieldsBlank method." + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Teacher Sign Up flow.")
    public void teacherSignUp() {
        boolean result = true;
        try {
            webDriver.navigate().refresh();
            signuppage = new SignUpPage(webDriver, extentTest, extentReports);

            signuppage.clickOnBtnSignUpUsingEmail();
            signuppage.setFullName(tempFullName);
            signuppage.setEmail(tempEmail);
            signuppage.setPassword(tempPass);
            signuppage.clickOnBtnSignUp();

            Assert.assertTrue(signuppage.verifySuccessMessageDisplay(), "Failed to verify success message in teacherSignUp method.");
            extentTest.log(LogStatus.PASS, "Verified: Success message is displayed after signing up as Teacher.");
            logger.info("Verified: Success message is displayed after signing up as Teacher.");

            Assert.assertTrue(signuppage.verifyContinueBtnPresent(), "Failed to verify continue button in teacherSignUp method.");
            extentTest.log(LogStatus.PASS, "Verified: Continue button is present after signing up as Teacher.");
            logger.info("Verified: Continue button is present after signing up as Teacher.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for teacherSignUp method." + errorMessage);
    }
}
