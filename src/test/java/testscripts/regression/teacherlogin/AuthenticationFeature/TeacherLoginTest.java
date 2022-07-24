package testscripts.regression.teacherlogin.AuthenticationFeature;

import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.SignOutPage;

public class TeacherLoginTest extends BaseTestScript {
    private String testCaseFailureText = "Test failed for method: ";

   @Test(priority = 1, description = "Verify the 'Join' button in the teacher landing page. ")
    public void verifyJoinButtonIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://master.ck12.org/teacher/");

            Assert.assertTrue(signOutPage.verifyJoinButton(), assertFailurePreText + "Presence of 'Join' Button.");
            reportLog("Presence of 'Join' Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify clicking 'Join' button will redirect to the Teacher Sign up page from Teacher home page. ")
    public void verifyFunctionalityOfJoinButton() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            signOutPage.clickOnJoinButton();

            Assert.assertTrue(signOutPage.verifyTeacherSignUpText(), assertFailurePreText + "Presence of 'Teacher Sign Up' Text.");
            reportLog("Presence of 'Teacher Sign Up' Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   @Test(priority = 7, description = "Verify 'Are you a Student? Sign up here link gets displayed in Student sign up page.")
    public void verifyAreYouATeacherTextIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            reportLog("Verify you are the teacher or not.");

            Assert.assertTrue(signOutPage.verifyAreYouStudentText(), assertFailurePreText + "Presence of 'Are You Student' Text.");
            reportLog("Presence of 'Are You Student' Text.");

            String assertTextVODD = "Presence of 'Sign Up Here' Link.";
            Assert.assertTrue(signOutPage.verifySignUpHereLink(), assertFailurePreText + assertTextVODD);
            reportLog("Presence of 'Sign Up Here' Link.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify clicking 'Sign up here' link in the page will redirect to Student sign up page from student home page.")
    public void verifyFunctionalityOfSignUpHereLink() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            signOutPage.clickOnSignUpHereLink();

            Assert.assertTrue(signOutPage.verifyJoinButton(), assertFailurePreText + "Presence of 'Join' Button.");
            reportLog("Presence of 'Join' Button.");

            Assert.assertTrue(signOutPage.verifyStudentSignUpText(), assertFailurePreText + "Presence of 'Student Sign Up Text' Text.");
            reportLog("Presence of 'Student Sign Up Text' Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify 'SignUp with Google' & 'SignUp with Facebook' buttons are present intially when clicking on 'Join' button.")
    public void verifyDifferentWaysOfSignUpOptionIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(signOutPage.verifySignUpHereLink(), assertFailurePreText + "Presence of 'Sign Up Here' Link.");
            reportLog("Presence of 'Sign Up Here' Link.");

            signOutPage.clickOnSignUpHereLink();

            Assert.assertTrue(signOutPage.verifyTeacherSignUpText(), assertFailurePreText + "Presence of 'Teacher Sign Up Text' Text.");
            reportLog("Presence of 'Teacher Sign Up Text' Text.");

            Assert.assertTrue(signOutPage.verifySignUpWithGoogleButton(), assertFailurePreText + "Presence of 'Teacher Sign Up Text' Text.");
            reportLog("Presence of 'Teacher Sign Up Text' Text.");

            Assert.assertTrue(signOutPage.verifySignUpWithFaceBookButton(), assertFailurePreText + "Presence of 'Sign Up With FaceBook' Button.");
            reportLog("Presence of 'Sign Up With FaceBook' Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify 'SignUp using Email' is present below the Google & Facebook button and 'Show More' link.")
    public void verifySignUpUSingEmailButtonIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(signOutPage.verifyShowMoreButton(), assertFailurePreText + "Presence of 'Show More' Button.");
            reportLog("Presence of 'Show More' Button.");

            Assert.assertTrue(signOutPage.verifySignUpUsingEmailButton(), assertFailurePreText + "Presence of 'Sign Up Using Email' Button.");
            reportLog("Presence of 'Sign Up Using Email' Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'Show More' link.")
    public void verifyFunctionalityOfShowMoreLink() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(signOutPage.verifyShowMoreButton(), assertFailurePreText + "Presence of 'Show More' Button.");
            reportLog("Presence of 'Show More' Button.");

            signOutPage.clickOnShowMoreButton();

            Assert.assertTrue(signOutPage.verifySignUpWithTwitterButton(), assertFailurePreText + "Presence of 'Sign Up With Twitter' Button.");
            reportLog("Presence of 'Sign Up With Twitter' Button.");

            Assert.assertTrue(signOutPage.verifySignUpWithMicrosoftButton(), assertFailurePreText + "Presence of 'Sign Up With MicroSoft' Button.");
            reportLog("Presence of 'Sign Up With MicroSoft' Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify 'Already have an account?' text and 'Sign in' link..")
    public void verifySignInLinkIsVisible() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            signOutPage.scrollTheScreen();

            Assert.assertTrue(signOutPage.verifySignInLink(), assertFailurePreText + "Presence of 'Sign In' Text.");
            reportLog("Presence of 'Sign In' Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify 'Sign in' pop up showing when clicking on 'Sign in' link in 'Student Sign up' page.")
    public void verifyFunctionalityOfSignInLink() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            signOutPage.clickOnSignInLink();

            Assert.assertTrue(signOutPage.verifySignInText(), assertFailurePreText + "Presence of 'Sign In' Text.");
            reportLog("Presence of 'Sign In' Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify sign up information details will appear when clicking on 'Sign Up using email' button in Teacher sign up page.")
    public void verifyFunctionalityOfSignUpUsingEmailButton() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            webDriver.navigate().refresh();

            Assert.assertTrue(signOutPage.verifyTeacherSignUpText(), assertFailurePreText + "Presence of 'Teacher Sign Up' Text.");
            reportLog("Presence of 'Teacher Sign Up' Text.");

            Assert.assertTrue(signOutPage.verifySignUpUsingEmailButton(), assertFailurePreText + "Presence of 'Sign Up Using Email' Button.");
            reportLog("Presence of 'Sign Up Using Email' Button.");

            signOutPage.clickOnSignUpUsingEmailButton();

            Assert.assertTrue(signOutPage.verifyFullNamePlaceHolder(), assertFailurePreText + "Presence of 'Full Name' PlaceHolder.");
            reportLog("Presence of 'Full Name' PlaceHolder.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Full Name, Email, Password fields present for Teacher user.")
    public void verifyAllRequiredFieldsOfStudentSignUp() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(signOutPage.verifyEmailPlaceHolder(), assertFailurePreText + "Presence of 'Email' PlaceHolder.");
            reportLog("Presence of 'Email' PlaceHolder.");

            Assert.assertTrue(signOutPage.verifyPasswordPlaceHolder(), assertFailurePreText + "Presence of 'Password' PlaceHolder.");
            reportLog("Presence of 'Password' PlaceHolder.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }


    @Test(priority = 25, description = "Verify Double quotes, smaller than (<) or @ are not allowed. ' message gets displayed if full name field is given with data with combinations of <@.")
    public void verifyDoubleQuotesAreNotAllowedInFullName() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

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
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            String name = "!#$%^&*[]";

            String assertTextVOD = "Presence of 'Full Name' PlaceHolder.";
            Assert.assertTrue(signOutPage.verifyFullNamePlaceHolder(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            signOutPage.setValueInFullNamePlaceHolder(name);
            signOutPage.clickOnPasswordPlaceHolder();

            String assertTextVM = "Presence of 'Special Character' Error Text.";
            Assert.assertTrue(signOutPage.verifySpecialCharacterErrorText(), assertFailurePreText + assertTextVM);
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
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            String pass = "Abc12";

            Assert.assertTrue(signOutPage.verifyPasswordPlaceHolder(), assertFailurePreText + "Presence of 'Password' PlaceHolder.");
            reportLog("Presence of 'Password' PlaceHolder.");

            signOutPage.setValueInPasswordPlaceHolder(pass);
            signOutPage.clickOnPasswordPlaceHolder();

            Assert.assertTrue(signOutPage.verifySixCharacterErrorText(), assertFailurePreText + "Presence of 'Six Character' Error Text.");
            reportLog("Presence of 'Six Character' Error Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 31, description = "Verify 'Show password' checkbox is present for both Teacher and Student user Sign up.")
    public void verifyShowPasswordIsDisplay() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(signOutPage.verifyShowPasswordCheckBox(), assertFailurePreText + "Presence of ' Show Password' CheckBox.");
            reportLog("Presence of ' Show Password' CheckBox.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 33, description = "Verify Password characters should display if 'Show password' checkbox is checked.")
    public void verifyFunctionalityOfShowPasswordCheckBox() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            signOutPage.clickOnShowPasswordCheckBox();

            Assert.assertTrue(signOutPage.verifyShowPasswordCheckBoxIsSelected(), assertFailurePreText + "Presence of ' Show Password' CheckBox is Selected.");
            reportLog("Presence of ' Show Password' CheckBox is Selected.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 35, description = "Verify Password characters should be hidden if 'Show password' checkbox is unchecked.")
    public void verifyPasswordIsHidden() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(signOutPage.verifyShowPasswordCheckBox(), assertFailurePreText + "Presence of ' Show Password' CheckBox.");
            reportLog("Presence of ' Show Password' CheckBox.");

            signOutPage.clickOnShowPasswordCheckBox();

            Assert.assertTrue(signOutPage.verifyPasswordIsHidden(), assertFailurePreText + "Presence of 'Hidden Password' Text.");
            reportLog("Presence of 'Hidden Password' Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 37, description = "Verify Sign up button is under disable condition untill all the fields are filled up..")
    public void verifySignUpProcessButtonIsEnabled() {
        boolean result = true;
        try {
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(signOutPage.verifySignUpButton(), assertFailurePreText + "Presence of ' Sign Up' Button Is Enabled.");
            reportLog("Presence of ' Sign Up' Button Is Enabled.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
