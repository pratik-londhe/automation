package testscripts.regression.studentlogin.GroupsFeature.ClassSettingFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class StudentSettingPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentSettingPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Email Notification For Assignment And Q&A Is ON' of Student Setting Page")
    public void verifyFunctionalityAssignmentLink(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver, extentTest, extentReports);
            ClassPage classPage = new ClassPage(webDriver, extentTest, extentReports);
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

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

    @Test(priority = 2, description = "Verify Functionality Of 'ON Switcher' Of Assignment Email Notification")
    public void verifyFunctionalityOnSwitcherOfAssignment() {
        boolean result = true;
        try {
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver, extentTest, extentReports);
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            String assertTextVAS = "Presence Of On Switcher of Assignment";
            Assert.assertTrue(studentSettingPage.verifyAssignmentSwitcher(), assertFailurePreText + assertTextVAS);
            reportLog(assertTextVAS);

            studentSettingPage.clickOnAssignmentSwitcher();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            String assertTextVTONFAL = "Presence Of TON For Assignment Link";
            Assert.assertTrue(studentSettingPage.verifyTONForAssignmentLink(), assertFailurePreText + assertTextVTONFAL);
            reportLog(assertTextVTONFAL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'OFF Switcher' Of Assignment Email Notification")
    public void verifyFunctionalityOffSwitcherOfAssignment() {
        boolean result = true;
        try {
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver, extentTest, extentReports);
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            String assertTextVAS = "Presence Of On Switcher of Assignment";
            Assert.assertTrue(studentSettingPage.verifyAssignmentSwitcher(), assertFailurePreText + assertTextVAS);
            reportLog(assertTextVAS);

            studentSettingPage.clickOnAssignmentSwitcher();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            String assertTextVINP = "Presence Of Instant Notification Text.";
            Assert.assertTrue(studentSettingPage.verifyInstantNotificationText(), assertFailurePreText + assertTextVINP);
            reportLog(assertTextVINP);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify Functionality Of 'TON Link' Of Assignment Notification")
    public void verifyFunctionalityOfTONLinkOfAssignment() {
        boolean result = true;
        try {
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver, extentTest, extentReports);
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnAssignmentSwitcher();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            String assertTextVTONFAL = "Presence Of TON For Assignment Link";
            Assert.assertTrue(studentSettingPage.verifyTONForAssignmentLink(), assertFailurePreText + assertTextVTONFAL);
            reportLog(assertTextVTONFAL);

            studentSettingPage.clickOnTONForAssignmentLink();

            String assertTextVENTA = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENTA);
            reportLog(assertTextVENTA);

            String assertTextVINP = "Presence Of Instant Notification Text.";
            Assert.assertTrue(studentSettingPage.verifyInstantNotificationText(), assertFailurePreText + assertTextVINP);
            reportLog(assertTextVINP);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'ON Switcher' Of Q&A Email Notification")
    public void verifyFunctionalityOnSwitcherOfQA() {
        boolean result = true;
        try {
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver, extentTest, extentReports);
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            String assertTextVAS = "Presence Of On Switcher of Q&A";
            Assert.assertTrue(studentSettingPage.verifyEmailNotificationSwitcher(), assertFailurePreText + assertTextVAS);
            reportLog(assertTextVAS);

            studentSettingPage.clickOnEmailNotificationSwitcher();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            String assertTextVTONFAL = "Presence Of TON For Q&A Link";
            Assert.assertTrue(studentSettingPage.verifyTONForEmailNotificationLink(), assertFailurePreText + assertTextVTONFAL);
            reportLog(assertTextVTONFAL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify Functionality Of 'OFF Switcher' Of Q&A Email Notification")
    public void verifyFunctionalityOffSwitcherOfQA() {
        boolean result = true;
        try {
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver, extentTest, extentReports);
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            String assertTextVAS = "Presence Of On Switcher of Q&A";
            Assert.assertTrue(studentSettingPage.verifyEmailNotificationSwitcher(), assertFailurePreText + assertTextVAS);
            reportLog(assertTextVAS);

            studentSettingPage.clickOnEmailNotificationSwitcher();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            String assertTextVACP = "Presence Of All Class Post Text.";
            Assert.assertTrue(studentSettingPage.verifyAllClassPost(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'TON Link' Of QA Notification")
    public void verifyFunctionalityOfTONLinkOfQA() {
        boolean result = true;
        try {
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver, extentTest, extentReports);
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEmailNotificationSwitcher();

            String assertTextVENT = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            String assertTextVTONFAL = "Presence Of TON For Q&A Link";
            Assert.assertTrue(studentSettingPage.verifyTONForEmailNotificationLink(), assertFailurePreText + assertTextVTONFAL);
            reportLog(assertTextVTONFAL);

            studentSettingPage.clickOnTONForEmailNotificationLink();

            String assertTextVENTA = "Presence Of Email Notification Text.";
            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), assertFailurePreText + assertTextVENTA);
            reportLog(assertTextVENTA);

            String assertTextVACP = "Presence Of All Class Post Text.";
            Assert.assertTrue(studentSettingPage.verifyAllClassPost(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 8, description = "Verify Functionality Of 'Edit Icon' Of Assignment Notification")
    public void verifyFunctionalityOfEditAssignmentNotification() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            String assertTextVEANI = "Presence Of Edit Assignment Notification Icon";
            Assert.assertTrue(studentSettingPage.verifyEditAssignmentNotificationIcon(), assertFailurePreText + assertTextVEANI);
            reportLog(assertTextVEANI);

            studentSettingPage.clickOnEditAssignmentNotificationIcon();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 9, description = "Verify Functionality Of 'Close Button' Of Edit Assignment Notification Page")
    public void verifyFunctionalityOfCloseEditAssignmentNotification() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            String assertTextVACP = "Presence Of Close Edit Assignment Notification Button";
            Assert.assertTrue(studentSettingPage.verifyCloseEditAssignmentNotificationButton(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

            studentSettingPage.clickOnCloseEditAssignmentNotificationButton();

            String assertTextVINP = "Presence Of Instant Notification Text.";
            Assert.assertTrue(studentSettingPage.verifyInstantNotificationText(), assertFailurePreText + assertTextVINP);
            reportLog(assertTextVINP);

        } catch (Exception e) {
            result = handleException(e);

        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 10, description = "Verify Instantly Send Emails Label Is Selected After Clicking On  Edit Assignment Notification Page")
    public void verifyFunctionalityOfInstantlyLabelIsSelected() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditAssignmentNotificationIcon();

            String assertTextVACP = "Presence Of Close Edit Assignment Notification Button";
            Assert.assertTrue(studentSettingPage.verifyCloseEditAssignmentNotificationButton(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

            String assertTextVIC = "Presence Of Instantly CheckBox Is Selected";
            Assert.assertTrue(studentSettingPage.verifyInstantlyCheckBox(), assertFailurePreText + assertTextVIC);
            reportLog(assertTextVIC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 11, description = "Verify Functionality OF 'Weekly' Checkbox Of Edit Assignment Notification Page")
    public void verifyFunctionalityOfWeeklyCheckBox() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            String assertTextVWC = "Presence Of Weekly CheckBox";
            Assert.assertTrue(studentSettingPage.verifyWeeklyCheckBox(), assertFailurePreText + assertTextVWC);
            reportLog(assertTextVWC);

            studentSettingPage.clickOnWeeklyCheckBox();

            String assertTextVENTA = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENTA);
            reportLog(assertTextVENTA);

            String assertTextVACP = "Presence Of Close Edit Assignment Notification Button";
            Assert.assertTrue(studentSettingPage.verifyCloseEditAssignmentNotificationButton(), assertFailurePreText + assertTextVACP);
            reportLog(assertTextVACP);

            studentSettingPage.clickOnCloseEditAssignmentNotificationButton();

            String assertTextVWDT = "Presence Of Weekly Digest Text";
            Assert.assertTrue(studentSettingPage.verifyWeeklyDigestText(), assertFailurePreText + assertTextVWDT);
            reportLog(assertTextVWDT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 12, description = "Verify Functionality OF 'Digest EveryDay' Checkbox Of Edit Assignment Notification Page")
    public void verifyFunctionalityOfDigestEveryDayCheckBox() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditAssignmentNotificationIcon();

            String assertTextVWDA = "Presence Of Digest EveryDay CheckBox";
            Assert.assertTrue(studentSettingPage.verifyDigestEveryDayCheckBox(), assertFailurePreText + assertTextVWDA);
            reportLog(assertTextVWDA);

            studentSettingPage.clickOnDigestEveryDayCheckBox();

            String assertTextVENTAA = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENTAA);
            reportLog(assertTextVENTAA);

            studentSettingPage.clickOnCloseEditAssignmentNotificationButton();

            String assertTextVWDT = "Presence Of Digest  In 6 Hours Text";
            Assert.assertTrue(studentSettingPage.verifyDigestIn6HoursText(), assertFailurePreText + assertTextVWDT);
            reportLog(assertTextVWDT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 13, description = "Verify Functionality OF 'Digest Every 12 Hours' DropDown Of Edit Assignment Notification Page")
    public void verifyFunctionalityOfDigestEvery12Hours() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditAssignmentNotificationIcon();

            String assertTextVWDA = "Presence Of Digest EveryDay CheckBox";
            Assert.assertTrue(studentSettingPage.verifyDigestEveryDayCheckBox(), assertFailurePreText + assertTextVWDA);
            reportLog(assertTextVWDA);

            studentSettingPage.clickOnHoursDropDown();
            studentSettingPage.clickOn12HoursLink();

            String assertTextVENTAA = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENTAA);
            reportLog(assertTextVENTAA);

            studentSettingPage.clickOnCloseEditAssignmentNotificationButton();

            String assertTextVWDT = "Presence Of Digest  In 12 Hours Text";
            Assert.assertTrue(studentSettingPage.verifyDigestIn12HoursText(), assertFailurePreText + assertTextVWDT);
            reportLog(assertTextVWDT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 14, description = "Verify Functionality OF 'Digest Every 24 Hours' DropDown Of Edit Assignment Notification Page")
    public void verifyFunctionalityOfDigestEvery24Hours() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditAssignmentNotificationIcon();

            String assertTextVWDA = "Presence Of Digest EveryDay CheckBox";
            Assert.assertTrue(studentSettingPage.verifyDigestEveryDayCheckBox(), assertFailurePreText + assertTextVWDA);
            reportLog(assertTextVWDA);

            studentSettingPage.clickOnHoursDropDown();
            studentSettingPage.clickOn24HoursLink();

            String assertTextVENTAA = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENTAA);
            reportLog(assertTextVENTAA);

            studentSettingPage.clickOnCloseEditAssignmentNotificationButton();

            String assertTextVWDT = "Presence Of Digest  In 12 Hours Text";
            Assert.assertTrue(studentSettingPage.verifyDigestIn24HoursText(), assertFailurePreText + assertTextVWDT);
            reportLog(assertTextVWDT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 15, description = "Verify Functionality OF 'Digest Every 6 Hours' DropDown Of Edit Assignment Notification Page")
    public void verifyFunctionalityOfDigestEvery6Hours() {
        boolean result = true;
        try {
            StudentSettingPage studentSettingPage = new StudentSettingPage(webDriver, extentTest, extentReports);

            studentSettingPage.clickOnEditAssignmentNotificationIcon();

            String assertTextVWDA = "Presence Of Digest EveryDay CheckBox";
            Assert.assertTrue(studentSettingPage.verifyDigestEveryDayCheckBox(), assertFailurePreText + assertTextVWDA);
            reportLog(assertTextVWDA);

            studentSettingPage.clickOnHoursDropDown();
            studentSettingPage.clickOn6HoursLink();

            String assertTextVENTAA = "Presence Of Email Notification Text.";
            Assert.assertTrue(new StudentMemberPage(webDriver, extentTest, extentReports).verifyEmailNotificationText(), assertFailurePreText + assertTextVENTAA);
            reportLog(assertTextVENTAA);

            studentSettingPage.clickOnCloseEditAssignmentNotificationButton();

            String assertTextVWDT = "Presence Of Digest  In 12 Hours Text";
            Assert.assertTrue(studentSettingPage.verifyDigestIn6HoursText(), assertFailurePreText + assertTextVWDT);
            reportLog(assertTextVWDT);

            studentSettingPage.clickOnEditAssignmentNotificationIcon();

            String assertTextVIC = "Presence Of Instantly CheckBox Is Selected";
            Assert.assertTrue(studentSettingPage.verifyInstantlyCheckBox(), assertFailurePreText + assertTextVIC);
            reportLog(assertTextVIC);

            studentSettingPage.clickOnInstantlyCheckBox();
            studentSettingPage.clickOnCloseEditAssignmentNotificationButton();

            String assertTextVINP = "Presence Of Instant Notification Text.";
            Assert.assertTrue(studentSettingPage.verifyInstantNotificationText(), assertFailurePreText + assertTextVINP);
            reportLog(assertTextVINP);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}