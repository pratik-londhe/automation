package testscripts.regression.studentlogin.GroupsFeature.ClassSettingFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class StudentSettingEditPage extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentSettingPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of 'Edit Icon' Of Q&A Notification")
    public void verifyFunctionalityOfEditQANotification(String email, String password) {
        boolean result = true;
        try {
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver, extentTest, extentReports);
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            ClassPage classPage = new ClassPage(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Teacher profile icon after login";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnClassesTab();
            studentMemberPage.clickOnClassName();

            String assertTextVHI = "Presence Of Home Icon";
            Assert.assertTrue(new TeacherAddStudentInClass(webDriver, extentTest, extentReports).verifyHomeIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of Settings section on class page.";
            Assert.assertTrue(classPage.verifySettingsOption(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            classPage.clickOnSettingsOption();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            String assertTextVEANI = "Presence Of Edit QA Notification Icon";
            Assert.assertTrue(studentSettingPage.verifyEditQANotificationIcon(), assertFailurePreText + assertTextVEANI);
            reportLog(assertTextVEANI);

            studentSettingPage.clickOnEditQANotificationIcon();

            String assertTextVACP = "Presence Of Close Edit Assignment Notification Button";
            Assert.assertTrue(studentSettingPage.verifyCloseEditQANotificationButton(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality Of 'Close Button' Of Edit Q & A Notification Page")
    public void verifyFunctionalityOfCloseEditQANotification() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVINP = "Presence Of Instant Notification Text.";
            Assert.assertTrue(studentSettingPage.verifyInstantNotificationText(), assertFailurePreText + assertTextVINP);
            reportLog(assertTextVINP);

            String assertTextVACP = "Presence Of All Class Post Text.";
            Assert.assertTrue(studentSettingPage.verifyAllClassPost(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

        } catch (Exception e) {
            result = handleException(e);

        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Instantly Send Emails Label for All Post From the class Is Selected After Clicking On  Edit QA Notification Page")
    public void verifyFunctionalityOfInstantlyLabelIsSelected() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();

            String assertTextVACP = "Presence Of All Class Post CheckBox.";
            Assert.assertTrue(studentSettingPage.verifyCheckBoxAllClassesPost(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

            String assertTextVAC = "Presence Of Instantly CheckBox.";
            Assert.assertTrue(studentSettingPage.verifyInstantlyChkBox(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify functionality of 'Weekly Digest' CheckBox for All Post From the class")
    public void verifyFunctionalityOfWeeklyCheckBox() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            String assertTextVACP = "Presence Of Weekly CheckBox.";
            Assert.assertTrue(studentSettingPage.verifyWeeklyChkBox(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

            studentSettingPage.clickOnWeeklyChkBox();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Weekly Digest All Class Post Text.";
            Assert.assertTrue(studentSettingPage.verifyWeeklyDigestAllClassPostText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify functionality of 'Digest Every Day ' CheckBox for All Post From the class")
    public void verifyFunctionalityOfDigestEveryCheckBox() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();

            String assertTextVACP = "Presence Of Digest Every Day CheckBox.";
            Assert.assertTrue(studentSettingPage.verifyDigestEveryDayChkBox(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

            studentSettingPage.clickOnDigestEveryDayChkBox();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Digest In 6 Hours All Class Post Text.";
            Assert.assertTrue(studentSettingPage.verifyDigestIn6HoursAllPostsText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify functionality of 'Digest In Every 24 Hours' DropDown for All Post From the class")
    public void verifyFunctionalityOfDigestInEvery24Hours() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();
            studentSettingPage.clickOnHoursDropDownForQA();
            studentSettingPage.clickOn24HoursLinkForQA();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Digest In 24 Hours All Class Post Text.";
            Assert.assertTrue(studentSettingPage.verifyDigestIn24HoursAllPostsText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify functionality of 'Digest In Every 12 Hours' DropDown for All Post From the class")
    public void verifyFunctionalityOfDigestInEvery12Hours() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();
            studentSettingPage.clickOnHoursDropDownForQA();
            studentSettingPage.clickOn12HoursLinkForQA();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Digest In 12 Hours All Class Post Text.";
            Assert.assertTrue(studentSettingPage.verifyDigestIn12HoursAllPostsText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify functionality of 'Digest In Every 12 Hours' DropDown for Just My Post")
    public void verifyFuncOfDigestEvery12HoursForMyPost() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();

            String assertTextVACP = "Presence Of My Post CheckBox.";
            Assert.assertTrue(studentSettingPage.verifyMyPostCheckBox(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

            studentSettingPage.clickOnMyPostCheckBox();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Digest In 12 Hours Your Post Text.";
            Assert.assertTrue(studentSettingPage.verifyDigestIn12HoursYourPostsText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify functionality of 'Digest In Every 6 Hours' DropDown for Just My Post")
    public void verifyFuncOfDigestEvery6HoursForMyPost() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();
            studentSettingPage.clickOnHoursDropDownForQA();
            studentSettingPage.clickOn6HoursLinkForQA();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Digest In 6 Hours Your Post Text.";
            Assert.assertTrue(studentSettingPage.verifyDigestIn6HoursYourPostsText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify functionality of 'Digest Weekly' CheckBox for Just My Post")
    public void verifyFuncOfDigestWeeklyForMyPost() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();
            studentSettingPage.clickOnWeeklyChkBox();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Weekly Digest Your Post Text.";
            Assert.assertTrue(studentSettingPage.verifyWeeklyDigestYourPostsText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify functionality of ' Instantly ' CheckBox for Just My Post")
    public void verifyFuncOfDigestInstantlyForMyPost() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();
            studentSettingPage.clickOnInstantlyChkBox();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Instantly Your Post Text.";
            Assert.assertTrue(studentSettingPage.verifyInstantlyYourPostsText(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify functionality of ' Instantly ' CheckBox for All Class Post")
    public void verifyFuncOfDigestInstantlyForAllClassPost() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditQANotificationIcon();
            studentSettingPage.clickOnCheckBoxAllClassesPost();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            studentSettingPage.clickOnCloseEditQANotificationButton();

            String assertTextVAC = "Presence Of Instantly All class Post Text.";
            Assert.assertTrue(studentSettingPage.verifyAllClassPost(), assertFailurePreText + assertTextVAC);
            reportLog(assertTextVAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}