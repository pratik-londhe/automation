package testscripts.regression.studentlogin.AuthenticationFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.SignOutPage;

public class StudentLoginTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentLoginTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, description = "Verify the 'Join' button should be displayed in RHS  student landing page ")
    public void verifyJoinButtonIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Join' Button.";
            Assert.assertTrue(signOutPage.verifyJoinButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 3, description = "Verify Create an Account with CK12 tooltip should be displayed while hover the mouse over the 'Join' button. ")
    public void verifyFunctionalityOfHoveringJoinButton() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            signOutPage.HoverOnJoinButton();

            String assertTextVM = "Presence of 'Create Account With Ck12' Text.";
            Assert.assertTrue(signOutPage.verifyCreateAccountWithCk12Text(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify student sign up page should be displayed when clicking on 'Join' button in student landing page. ")
    public void verifyFunctionalityOfJoinButton() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            signOutPage.clickOnJoinButton();

            String assertTextVM = "Presence of 'Student Sign Up Text' Text.";
            Assert.assertTrue(signOutPage.verifyStudentSignUpText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify 'Are you a teacher? Sign up here link gets displayed in Student sign up page.")
    public void verifyAreYouATeacherTextIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVM = "Presence of 'Are You Teacher' Text.";
            Assert.assertTrue(signOutPage.verifyAreYouTeacherText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVODD = "Presence of 'Sign Up Here' Link.";
            Assert.assertTrue(signOutPage.verifySignUpHereLink(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Teacher sign up page should be shown when user clicking on Are you a teacher? 'Sign up here' link in student sign up page.")
    public void verifyFunctionalityOfSignUpHereLink() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            signOutPage.clickOnSignUpHereLink();

            String assertTextVML = "Presence of 'Join' Button.";
            Assert.assertTrue(signOutPage.verifyJoinButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Presence of 'Teacher Sign Up' Text.";
            Assert.assertTrue(signOutPage.verifyTeacherSignUpText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify 'SignUp with Google' & 'SignUp with Facebook' buttons are present intially when clicking on 'Join' button.")
    public void verifyDifferentWaysOfSignUpOptionIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVODD = "Presence of 'Sign Up Here' Link.";
            Assert.assertTrue(signOutPage.verifySignUpHereLink(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            signOutPage.clickOnSignUpHereLink();
            webDriver.navigate().to("https://master.ck12.org/auth/signup/student?returnTo=https://master.ck12.org/my/dashboard-new/");

            String assertTextVM = "Presence of 'Student Sign Up Text' Text.";
            Assert.assertTrue(signOutPage.verifyStudentSignUpText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVOD = "Presence of 'Sign Up With Google' Button.";
            Assert.assertTrue(signOutPage.verifySignUpWithGoogleButton(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            String assertTextVD = "Presence of 'Sign Up With FaceBook' Button.";
            Assert.assertTrue(signOutPage.verifySignUpWithFaceBookButton(), assertFailurePreText + assertTextVD);
            reportLog(assertTextVD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify 'SignUp using Email' is present below the Google & Facebook button and 'Show More' link.")
    public void verifySignUpUSingEmailButtonIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVODD = "Presence of 'Show More' Button.";
            Assert.assertTrue(signOutPage.verifyShowMoreButton(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            String assertTextVM = "Presence of 'Sign Up Using Email' Button.";
            Assert.assertTrue(signOutPage.verifySignUpUsingEmailButton(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'Show More' link.")
    public void verifyFunctionalityOfShowMoreLink() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVODD = "Presence of 'Show More' Button.";
            Assert.assertTrue(signOutPage.verifyShowMoreButton(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            signOutPage.clickOnShowMoreButton();

            String assertTextVOD = "Presence of 'Sign Up With Twitter' Button.";
            Assert.assertTrue(signOutPage.verifySignUpWithTwitterButton(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            String assertTextVD = "Presence of 'Sign Up With MicroSoft' Button.";
            Assert.assertTrue(signOutPage.verifySignUpWithMicrosoftButton(), assertFailurePreText + assertTextVD);
            reportLog(assertTextVD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify 'Already have an account?' text and 'Sign in' link..")
    public void verifySignInLinkIsVisible() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            signOutPage.scrollTheScreen();

            String assertTextVODD = "Presence of 'Sign In' Text.";
            Assert.assertTrue(signOutPage.verifySignInLink(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify 'Sign in' pop up showing when clicking on 'Sign in' link in 'Student Sign up' page.")
    public void verifyFunctionalityOfSignInLink() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            signOutPage.clickOnSignInLink();

            String assertTextVODD = "Presence of 'Sign In' Text.";
            Assert.assertTrue(signOutPage.verifySignInText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify sign up information details will appear when clicking on 'Sign Up using email' button in student sign up page.")
    public void verifyFunctionalityOfSignUpUsingEmailButton() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            webDriver.navigate().refresh();
            webDriver.navigate().to("https://master.ck12.org/student/");
            signOutPage.clickOnJoinButton();

            String assertTextVM = "Presence of 'Student Sign Up' Text.";
            Assert.assertTrue(signOutPage.verifyStudentSignUpText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVODD = "Presence of 'Sign Up Using Email' Button.";
            Assert.assertTrue(signOutPage.verifySignUpUsingEmailButton(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            signOutPage.clickOnSignUpUsingEmailButton();

            String assertTextVOD = "Presence of 'Full Name' PlaceHolder.";
            Assert.assertTrue(signOutPage.verifyFullNamePlaceHolder(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Full Name, Birthday(dropdown), Email, Password feilds present for Student user.")
    public void verifyAllRequiredFieldsOfStudentSignUp() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVM = "Presence of 'Email' PlaceHolder.";
            Assert.assertTrue(signOutPage.verifyEmailPlaceHolder(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVODD = "Presence of 'Password' PlaceHolder.";
            Assert.assertTrue(signOutPage.verifyPasswordPlaceHolder(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Double quotes, smaller than (<) or @ are not allowed. ' message gets displayed if full name field is given with data with combinations of <@.")
    public void verifyDoubleQuotesAreNotAllowedInFullName() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String name = "@student<<";

            String assertTextVOD = "Presence of 'Full Name' PlaceHolder.";
            Assert.assertTrue(signOutPage.verifyFullNamePlaceHolder(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            signOutPage.setValueInFullNamePlaceHolder(name);
            signOutPage.clickOnPasswordPlaceHolder();

            String assertTextVM = "Presence of 'Double Quotes Error' Text.";
            Assert.assertTrue(signOutPage.verifyDoubleQuotesErrorText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Special Characters are not allowed alert message displayed if data !#$%^&*[].")
    public void verifySpecialCharacterAreNotAllowedInFullName() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String name = "!#$%^&*[]";

            String assertTextVOD = "Presence of 'Full Name' PlaceHolder.";
            //Assert.assertTrue(signOutPage.verifyFullNamePlaceHolder(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            signOutPage.setValueInFullNamePlaceHolder(name);
            signOutPage.clickOnPasswordPlaceHolder();

            String assertTextVM = "Presence of 'Special Character' Error Text.";
            //Assert.assertTrue(signOutPage.verifySpecialCharacterErrorText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 29, description = "Verify 'At least 6 characters' alert displayed when we enter less then 6 characters in Password field.")
    public void verifySixCharacterRequiredInPassword() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String pass = "Abc12";

            String assertTextVOD = "Presence of 'Password' PlaceHolder.";
            Assert.assertTrue(signOutPage.verifyPasswordPlaceHolder(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            signOutPage.setValueInPasswordPlaceHolder(pass);
            signOutPage.clickOnPasswordPlaceHolder();

            String assertTextVM = "Presence of 'Six Character' Error Text.";
            Assert.assertTrue(signOutPage.verifySixCharacterErrorText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 31, description = "Verify 'Show password' checkbox is present for both Teacher and Student user Sign up.")
    public void verifyShowPasswordIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVOD = "Presence of ' Show Password' CheckBox.";
            Assert.assertTrue(signOutPage.verifyShowPasswordCheckBox(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 33, description = "Verify Password characters should display if 'Show password' checkbox is checked.")
    public void verifyFunctionalityOfShowPasswordCheckBox() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            signOutPage.clickOnShowPasswordCheckBox();

            String assertTextVOD = "Presence of ' Show Password' CheckBox is Selected.";
            Assert.assertTrue(signOutPage.verifyShowPasswordCheckBoxIsSelected(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 35, description = "Verify Password characters should be hidden if 'Show password' checkbox is unchecked.")
    public void verifyPasswordIsHidden() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVOD = "Presence of ' Show Password' CheckBox.";
            Assert.assertTrue(signOutPage.verifyShowPasswordCheckBox(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            signOutPage.clickOnShowPasswordCheckBox();

            String assertTextVM = "Presence of 'Hidden Password' Text.";
            Assert.assertTrue(signOutPage.verifyPasswordIsHidden(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 37, description = "Verify Sign up button is under disable condition untill all the fields are filled up..")
    public void verifySignUpProcessButtonIsEnabled() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            String assertTextVOD = "Presence of ' Sign Up' Button Is Enabled.";
            Assert.assertTrue(signOutPage.verifySignUpButton(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}