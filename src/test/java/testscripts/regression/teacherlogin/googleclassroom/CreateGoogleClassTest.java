package testscripts.regression.teacherlogin.googleclassroom;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.AnswerKey;
import uipages.flexbook2feature.LoginPage;
import uipages.googleclassroom.GoogleClassroomPage;

public class CreateGoogleClassTest extends BaseTestScript {

    private static final Logger logger = Logger.getLogger(CreateGoogleClassTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";
    private String gcUrl = "https://www.classroom.google.com";
    private String unameStu = "sfatuser1@gmail.com";
    private String studPass = "Fahead!234";
    private String score;
    private String report;


    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the functionality of create Google class.")
    public void createGoogleClass(String googleClassURL, String email, String pass, String googleClass) {
        boolean result = true;
        try {
            GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to(googleClassURL);
            reportLog("Navigated to the google classroom to join an account.");

            googleClassroomPage.gmailLogin(email, pass);
            reportLog("User performed the gmail account login to connect Google Classroom.");

            googleClassroomPage.clickOnPlusIcon();
            reportLog("User clicked on the Plus icon to create a google class.");

            googleClassroomPage.clickOnCreateClass();
            reportLog("User clicked on the create class button.");

            googleClassroomPage.clickOnCheckBox();
            reportLog("User clicked on the checkbox.");

            googleClassroomPage.clickOnBtnContinue();
            reportLog("User performed the gmail account login to connect Google Classroom.");

            googleClassroomPage.createGoogleClass(googleClass);
            reportLog("User created the google class:" + googleClass);

            Assert.assertTrue(googleClassroomPage.isGCClassCreated(googleClass), "Failed to verify the created GC class.");
            reportLog("The Google Class is created: " + googleClass);
            logger.info("The Google class is created.");

            googleClassroomPage.getClassCode();
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality of 'View Archived' Button After Clicking On Library Tab")
    public void assignAssignmentToGCClass() {
        GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);
        LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
        AnswerKey answerKey = new AnswerKey(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            googleClassroomPage.openNewTabAndCK12URL();
            reportLog("Opened the ck12 site.");

            loginPage.clickOnSinInLinkProd();
            reportLog("Clicked on the Sign In link.");

            loginPage.signInWithGoogle();
            reportLog("Signed in with google.");

            googleClassroomPage.clickOnBtnAssign();
            reportLog("Clicked on the assign button.");

            googleClassroomPage.clickOnGCPlatform();
            reportLog("Selected the GC platform.");

            googleClassroomPage.clickOnConnectGCLink();
            reportLog("Clicked on connect with Google Classroom.");

            answerKey.switchToChildWindow();
            reportLog("Switched on the child window.");

            googleClassroomPage.selectProfile();
            reportLog("Selected the gmail account profile.");

            answerKey.switchToParentWindow();
            reportLog("Switched on the parent window.");

            googleClassroomPage.selectClass();
            reportLog("Selected GC class to assign assignment.");

            googleClassroomPage.assignConceptToGCClass();
            reportLog("Assigned the concept to GC class.");

            Assert.assertTrue(googleClassroomPage.verifyGotItButton(), "Failed to verify the Got It button.");
            reportLog("The assignment is assigned successfully to GC class and verified the Go It success message.");
            logger.info("The assignment is assigned successfully to GC class and verified the Go It success message.");

            webDriver.navigate().to(gcUrl);
            googleClassroomPage.gcSignOut();
            //googleClassroomPage.gcRemoveAccount();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 10, description = "Verify Student Sign in on GC page")
    public void verifyGmailLoginStudent() {
        boolean result = true;
        try {
            GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);

            googleClassroomPage.clickOnUseAnotherAccount();
            googleClassroomPage.studentLogin(unameStu, studPass);

            /*String assertTextVSCDB = "Presence of 'Products' menu verified. Student has successfully logged in.";
            Assert.assertTrue(googleClassroomPage.verifyProductsMenuIcon(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);*/
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify Functionality Of 'Join Class' feature inside Google Classroom")
    public void verifyJoinClass() {
        boolean result = true;
        try {
            GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);

            googleClassroomPage.clickJoinClassButtonDashboard();
            googleClassroomPage.selectJoinClassOptionDashboard();
            googleClassroomPage.setClassCode();
            googleClassroomPage.clickOnJoinButton();

            String assertTextVSCDB = "Presence of title of the class verified. Student has successfully joined the class.";
            Assert.assertTrue(googleClassroomPage.verifyClassJoined(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify Functionality Of opening the assignment from inside Google Classroom")
    public void verifyOpenAssignment() {
        boolean result = true;
        try {
            GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);
            AnswerKey answerKey = new AnswerKey(webDriver, extentTest, extentReports);

            googleClassroomPage.clickOnClassworkLink();
            googleClassroomPage.expandAssignmentBar();
            googleClassroomPage.clickAssignmentLink();
            answerKey.switchToChildWindow();
            googleClassroomPage.clickOkReviewGCPermission();
            answerKey.switchToThirdWindow();
            googleClassroomPage.chooseStudentAccount(studPass);
            answerKey.switchToChildWindowOfAssignment();

           /* String assertTextVSCDB = "Presence of title of the CK12 logo to verify Practice page has opened.";
            Assert.assertTrue(googleClassroomPage.verifyPracticePageOpened(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 16, description = "Verify that GC Student user is able to attempt the practice")
    public void verifyStudentAttemptAssignment() {
        boolean result = true;
        try {
            GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);

            googleClassroomPage.beginPracticeAttempt();
            googleClassroomPage.clickOnStopForNow();

            String assertTextVSCDB = "Presence of assigned FB2.0 modality page";
            Assert.assertTrue(googleClassroomPage.verifyConceptPageLoadsAfterSubmit(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            googleClassroomPage.turnInScore();

            webDriver.navigate().to(gcUrl);
            //googleClassroomPage.gcSignOutAll();
            googleClassroomPage.gcSignOut();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Student Sign in on GC page")
    public void verifyTheScoreInGradeBookTabAndArchiveGCClass() {
        boolean result = true;
        try {
            GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);
            AnswerKey answerKey = new AnswerKey(webDriver, extentTest, extentReports);

            googleClassroomPage.selectTeacherProfileAndEnterPass(studPass);
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);

            googleClassroomPage.openNewTabAndCK12URL();
            googleClassroomPage.studentSignOutFromCK12();
            loginPage.clickOnSinInLinkProd();
            extentTest.log(LogStatus.PASS, "Clicked on the Sign In link.");

            loginPage.signInWithGoogle();
            extentTest.log(LogStatus.PASS, "Signed in with google.");
            /*answerKey.switchToThirdWindow();
            googleClassroomPage.chooseTeacherAccount(studPass);
            answerKey.switchToChildWindowOfAssignment();*/

            webDriver.navigate().to(gcUrl);

            // googleClassroomPage.selectTeacherProfileAndEnterPass(pwdStu);
            googleClassroomPage.goToGradeBook();
            score = googleClassroomPage.getScore();
            reportLog("Student score is: " + score);
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 18, description = "Verify ck12 class report via grade book")
    public void verifyTheCK12ClassReportViaGradeBook() {
        boolean result = true;
        try {
            GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);
            AnswerKey answerKey = new AnswerKey(webDriver, extentTest, extentReports);

            googleClassroomPage.ClickOnTheConceptsToVisitGradeBook();
            answerKey.switchToThirdWindow();
            report = googleClassroomPage.accessCK12ReportViaGradBook();
            extentTest.log(LogStatus.PASS, "Student score is: " + report);
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify google class archive functionality")
    public void deleteGoogleClass() {
        boolean result = true;
        try {
            GoogleClassroomPage googleClassroomPage = new GoogleClassroomPage(webDriver, extentTest, extentReports);

            webDriver.navigate().to(gcUrl);

            googleClassroomPage.deleteGoogleClass();
            reportLog("Google Class is archived.");

            Assert.assertTrue(googleClassroomPage.verifyGCClassIsDeleted(), "Failed to delete GC class.");
            reportLog("Google class is deleted successfully.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}