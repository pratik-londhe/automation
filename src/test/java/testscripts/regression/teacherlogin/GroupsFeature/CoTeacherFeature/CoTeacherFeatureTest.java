package testscripts.regression.teacherlogin.GroupsFeature.CoTeacherFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CoTeacherFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CoTeacherFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify co-teacher is not able to perform deleting the class action.")
    public void verifyCoTeacherCanNotDeleteClass(String email, String password) {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://master.ck12.org/group-settings/617042";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Class Name' Text.";
            Assert.assertTrue(coTeacherFeature.verifyClassNameText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            String assertTextVSB = "Delete Class Button Is Not Visible For CoTeacher";
            Assert.assertTrue(coTeacherFeature.checkDeleteClassButtonIsNotVisible(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify co-teacher is not able to Add Student In The Class.")
    public void verifyCoTeacherCanNotAddStudent() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://master.ck12.org/group-settings/617042";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Class Name' Text.";
            Assert.assertTrue(coTeacherFeature.verifyClassNameText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            /*String assertTextVSCDB = "Presence of 'Class Admin ' Text.";
            Assert.assertTrue(coTeacherFeature.verifyClassAdminText(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);*/

            String assertTextVSB = "Add Student Button Is Not Visible For CoTeacher";
            Assert.assertTrue(coTeacherFeature.checkAddStudentButtonIsNotVisible(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify co-teacher is able to see the reports like a class owner.")
    public void verifyCoTeacherCanSeeReports() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://master.ck12.org/group-settings/617042";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Class Name' Text.";
            Assert.assertTrue(coTeacherFeature.verifyClassNameText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            String assertTextVTI = "Presence of 'ToC' icon.";
            Assert.assertTrue(coTeacherFeature.verifyClassReportsText(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify co-teacher is able to Q&A section like a class owner.")
    public void verifyQASectionForCoTeacher() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://master.ck12.org/group-settings/617042";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Class Name' Text.";
            Assert.assertTrue(coTeacherFeature.verifyClassNameText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

          /*  String assertTextVTI = "Presence of 'ToC' icon.";
            Assert.assertTrue(coTeacherFeature.verifyHowDoesThisWorkLink(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify co-teacher is able to settings section like a class owner.")
    public void verifySettingSectionForCoTeacher() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://master.ck12.org/group-settings/617042";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Class Name' Text.";
            Assert.assertTrue(coTeacherFeature.verifyClassNameText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            String assertTextVSCDB = "Presence of 'Email Notification' Text.";
            Assert.assertTrue(coTeacherFeature.verifyEmailNotificationText(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 11, description = "Verify CoTeacher Can Not Share Resources In the class as a CoTeacher.")
    public void verifyShareToClassOption() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://flexbooks-master.ck12.org/user:dgvhy2hlcjewmit0zxn0dxnlckbjazeylm9yzw../cbook/untitled-flexbook-2.0cd/r1/";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Choose' button.";
            Assert.assertTrue(coTeacherFeature.verifyChooseButton(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            coTeacherFeature.clickOnChooseButton();

            String assertTextVLNC = "Presence of 'Share To Class' button.";
            Assert.assertTrue(coTeacherFeature.verifyShareToClassButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            coTeacherFeature.clickOnShareToClassButton();

            String assertTextVLC = "Presence of 'You Don't Own Any Class' button.";
            Assert.assertTrue(coTeacherFeature.verifyYouDoNotOwnAnyClassText(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 13, description = "Verify CoTeacher Can Not Assign Assignment In the class as a CoTeacher.")
    public void verifyAssignAssignmentThroughCoTeacher() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://flexbooks-master.ck12.org/user:dgvhy2hlcjewmit0zxn0dxnlckbjazeylm9yzw../cbook/untitled-flexbook-2.0cd/r1/section/1.0/primary/lesson/alcoholic-fermentation-advanced-bio-adv";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Assign' button.";
            Assert.assertTrue(coTeacherFeature.verifyAssignButton(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            coTeacherFeature.clickOnAssignButton();

            String assertTextVLNC = "Presence of 'Ck12 Image' Icon.";
            Assert.assertTrue(coTeacherFeature.verifyCk12ImageIcon(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            coTeacherFeature.clickOnCk12ImageIcon();

            String assertTextVLC = "Presence of 'Create NEw Class' Link.";
            Assert.assertTrue(coTeacherFeature.verifyCreateNewClassLink(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //  @Test(priority = 15, description = "Verify CoTeacher Can Not Share Resources From Modality Page In the class as a CoTeacher.")
    public void verifyShareWithClassesFromModalityPage() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://qa-flash.ck12.org/my/c/elementary-math-grade-2/multiplication-sentences-from-illustrations-ii-numbers-6-7-8-9-11-and-12/asmtpractice/Multiply-to-12-with-Pictures-Practice/";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Assign To Class' button.";
            Assert.assertTrue(coTeacherFeature.verifyAssignToClassButton(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            String assertTextVLC = "Presence of 'Share With Class' Link.";
            Assert.assertTrue(coTeacherFeature.verifyShareWithClassButton(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

            coTeacherFeature.clickOnShareWithClassButton();

            String assertTextVLNC = "Presence of 'Share To Class' button.";
            Assert.assertTrue(coTeacherFeature.verifyCreateAClassButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 17, description = "Verify CoTeacher Can Not Assign Assignment From Modality Page In the class as a CoTeacher.")
    public void verifyAssignAssignmentFromModalityPage() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String assertTextVSCB = "Presence of 'Assign To Class' button.";
            Assert.assertTrue(coTeacherFeature.verifyAssignToClassButton(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            coTeacherFeature.clickOnAssignToClassButton();

            String assertTextVLNC = "Presence of 'Ck12 Image' Icon.";
            Assert.assertTrue(coTeacherFeature.verifyCk12ImageIconAgain(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            coTeacherFeature.clickOnCk12ImageIconAgain();

            String assertTextVLC = "Presence of 'Create Class' Link.";
            Assert.assertTrue(coTeacherFeature.verifyCreateClassLink(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}



