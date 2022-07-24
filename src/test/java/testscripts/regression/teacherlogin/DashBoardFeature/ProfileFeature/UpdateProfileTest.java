package testscripts.regression.teacherlogin.DashBoardFeature.ProfileFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class UpdateProfileTest  extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(UpdateProfileTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Teacher Profile' is present in Teacher Dashboard Page.")
    public void verifyTeacherProfile(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage  teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            reportLog("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to("https://master.ck12.org/my/dashboard-new/");

            String assertTextVML = "Presence of Teacher Profile Text";
            Assert.assertTrue(updateProfile.verifyTeacherProfileText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Edit' Button to update Teacher Profile.")
    public void verifyFunctionalityOfEditButton() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Edit' button.";
            Assert.assertTrue(updateProfile.verifyEditButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            updateProfile.clickOnEditButton();

            String assertTextVWIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Change Location' Button.")
    public void verifyFunctionalityOfChangeLocationButton() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Change Location' button.";
            Assert.assertTrue(updateProfile.verifyChangeLocationButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            updateProfile.clickOnChangeLocationButton();

            String assertTextVWIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Close' Button After Clicking On Change Location.")
    public void verifyFunctionalityOfCloseButton() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Change Location' button.";
            Assert.assertTrue(updateProfile.verifyCloseButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            updateProfile.clickOnCloseButton();

            String assertTextVWIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

            String assertTextVL = "Presence of 'Change Location' button.";
            Assert.assertTrue(updateProfile.verifyChangeLocationButton(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Select Grade' DropDown of Update Profile POp Up.")
    public void verifyFunctionalityOfSelectGrade() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Grade' DropDown.";
            Assert.assertTrue(updateProfile.verifyGradeDropDown(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            updateProfile.clickOnGradeDropDown();

            String assertTextVWIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

            String assertTextVL = "Presence of 'Kindgarten' link.";
            Assert.assertTrue(updateProfile.verifyKindgartenLink(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Select Subjects' DropDown of Update Profile POp Up.")
    public void verifyFunctionalityOfSubjectDropDown() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Subjects' DropDown.";
            Assert.assertTrue(updateProfile.verifySubjectDropDown(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            updateProfile.clickOnSubjectDropDown();

            String assertTextVWIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 13, description = "Verify All the 'container' Are Present Inside the Subjects DropDown.")
    public void verifyContainerInsideTheSubjectDropDown() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVML = "Presence of 'Science' Container.";
            Assert.assertTrue(updateProfile.verifyScienceContainer(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVWIC = "Presence of 'Math' Container.";
            Assert.assertTrue(updateProfile.verifyMathContainer(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

            String assertTextVL = "Presence of 'English' Container.";
            Assert.assertTrue(updateProfile.verifyEnglishContainer(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 15, description = "Verify Functionality Of 'Science' Container.")
    public void verifyFunctionalityOfScienceContainer() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            updateProfile.clickOnScienceContainer();

            String assertTextVWIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

            String assertTextVML = "Presence of 'Earth Science' CheckBox.";
            Assert.assertTrue(updateProfile.verifyEarthScienceContainer(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVL = "Presence of 'Life Science' Container.";
            Assert.assertTrue(updateProfile.verifyLifeScienceContainer(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of 'Math' Container.")
    public void verifyFunctionalityOfMathContainer() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVWIC = "Presence of 'Math' Container.";
            Assert.assertTrue(updateProfile.verifyMathContainer(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

            updateProfile.clickOnMathContainer();

            String assertTextVIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVIC);
            reportLog(assertTextVIC);

            String assertTextVML = "Presence of 'Grade 1' CheckBox.";
            Assert.assertTrue(updateProfile.verifyGrade1Container(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVL = "Presence of 'Grade 2' Container.";
            Assert.assertTrue(updateProfile.verifyGrade2Container(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of 'English' Container.")
    public void verifyFunctionalityOfEnglishContainer() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVL = "Presence of 'English' Container.";
            Assert.assertTrue(updateProfile.verifyEnglishContainer(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            updateProfile.clickOnEnglishContainer();

            String assertTextVWIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

            String assertTextVML = "Presence of 'Spelling' CheckBox.";
            Assert.assertTrue(updateProfile.verifySpellingContainer(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of 'Update Profile' button without Giving User Name.")
    public void verifyFunctionalityOfUpdateButtonWithoutUserName() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            String assertTextVWIC = "Presence of 'Welcome To Ck12' Text.";
            Assert.assertTrue(updateProfile.verifyWelcomeToCk12Text(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

            updateProfile.removeNameFromUserNamePlaceHolder();

            String assertTextVWC = "Presence of 'Update Profile' Button.";
            Assert.assertTrue(updateProfile.verifyUpdateProfileButton(), assertFailurePreText + assertTextVWC);
            reportLog(assertTextVWC);

            updateProfile.clickOnUpdateProfileButton();

            String assertTextVML = "Presence of 'Enter Your Name' Text .";
            Assert.assertTrue(updateProfile.verifyEnterYourNameText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Changes Are Visible in DashBoard Page After Clicking On Update Profile.")
    public void verifyChangesOfProfileOnDashBoardPage() {
        boolean result = true;
        try {
            UpdateProfile updateProfile = new UpdateProfile(webDriver,extentTest,extentReports);

            updateProfile.changeUserName();

            String assertTextVWIC = "Presence of 'Update Profile' Button.";
            Assert.assertTrue(updateProfile.verifyUpdateProfileButton(), assertFailurePreText + assertTextVWIC);
            reportLog(assertTextVWIC);

            updateProfile.clickOnUpdateProfileButton();

            String assertTextVML = "Presence of 'Spelling' CheckBox.";
            Assert.assertTrue(updateProfile.verifyUpdatedUserName(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}