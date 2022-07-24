/*
package testscripts.regression.teacherlogin.ReportFeature.TryNewReports;

import uipages.flexbook2feature.TurnInFeature;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.ClassAssignmentFeature;
import uipages.reports2feature.TeacherReports;

public class TurnInFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TurnInFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private LoginPage loginPage;
    private CBookLandingPage cBookLandingPage;
    private TurnInFeature turnInFeature;
    private ClassAssignmentFeature classAssignmentFeature;
    private TeacherReports teacherReports;



   // @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Assignment Is Available In Teacher Assignment List")
    public void verifyTeacherLogin(String email, String password) {
        boolean result = true;
        try {
            loginPage = new LoginPage(webDriver,extentTest,extentReports);
            cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            turnInFeature = new TurnInFeature(webDriver,extentTest,extentReports);
            classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);
            teacherReports = new TeacherReports(webDriver,extentTest,extentReports);

            String assignmentURL1 = "https://master.ck12.org/teacher/";

            webDriver.navigate().to(assignmentURL1);

            cBookLandingPage.clickOnFlexBookLink();
            cBookLandingPage.clickOnSignInIcon();
            loginPage.login(email, password);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Teacher icon' after logging in.";
            Assert.assertTrue(cBookLandingPage.verifyTeacherAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assignmentURL = "https://master.ck12.org/group-assignments/617724";

            webDriver.navigate().to(assignmentURL);

            String assertTextVCAC = "Presence of Profile Icon.";
            Assert.assertTrue(turnInFeature.verifyNoDueDateLink(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 2, description = "Verify Functionality Of Yes 'Undo Assign'  Assignment Button ")
    public void verifyUndoAssignFunctionality() {
        boolean result = true;
        try {
            turnInFeature.clickOnNoDueDateLink();
            turnInFeature.clickOnAssignmentName();

            String assertTextVSAI = "Presence of 'Undo Assign' Button.";
            Assert.assertTrue(classAssignmentFeature.verifyUndoAssignLink(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            classAssignmentFeature.clickOnUndoAssignLink();

            Assert.assertTrue(classAssignmentFeature.verifyCancelRemoveButton(), "Failed to verified Cancel Remove Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Cancel Remove Button");
            logger.info("User Successfully verified Cancel Remove Button");

            Assert.assertTrue(classAssignmentFeature.verifyYesRemoveButton(), "Failed to verified Yes Remove Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Yes Remove Button");
            logger.info("User Successfully verified Yes Remove Button");

            classAssignmentFeature.clickOnYesRemoveButton();

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 3, description = "Verify Functionality Of  Assign Assignment From Available Assignment List ")
    public void verifyFunctionalityOfAssignAssignment() {
        boolean result = true;
        try {
            turnInFeature.clickOnAvailableAssignmentTab();

            String assertTextVAB = "Presence Of Assign Assignment Button.";
            Assert.assertTrue(teacherReports.verifyAssignButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            teacherReports.clickOnAssignButton();

            Assert.assertTrue(classAssignmentFeature.verifyAssignButton(), "Failed to verified Assign Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Assign Button");
            logger.info("User Successfully verified Assign Button");

            classAssignmentFeature.clickOnAssignButton();

            Assert.assertTrue(turnInFeature.verifyCreateAssignmentButton(), "Failed to verified Create An Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Create An Assignment Button");
            logger.info("User Successfully verify verified An Assignment Button");

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 4, description = "Verify Successfully Login Through Student Account")
    public void verifyStudentLoginSuccessfully() {
        boolean result = true;
        try {
            String flexBookUrl = "https://master.ck12.org/teacher/";
            String email = "gs_student1+testuser@ck12.org";
            String pass = "fa1234";

            webDriver.navigate().to(flexBookUrl);
            cBookLandingPage.clickOnFlexBookLink();

            String assertTextVCAC = "Presence of Profile Icon.";
            Assert.assertTrue(turnInFeature.verifyProfileIcon(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            turnInFeature.clickOnProfileIcon();

            String assertTextVSO = "Presence of Sign Out Link.";
            Assert.assertTrue(turnInFeature.verifyLinkSignOut(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            turnInFeature.clickOnLinkSignOut();

            cBookLandingPage.clickOnSignInIcon();
            loginPage.login(email, pass);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Student icon' after logging in.";
            Assert.assertTrue(turnInFeature.verifyStudentAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 5, description = "Verify Functionality Of 'Turn In ' Button In Read Modality Assignment Page")
    public void verifyFunctionalityOfTurInButtonInReadPage() {
        boolean result = true;
        try {
            String assignmentURL = "https://flexbooks-master.ck12.org/user:z3nfdgvhy2hlcjerdgvzdhvzzxjay2sxmi5vcmc./cbook/assignment/section/1.0/primary/lesson/You-and-the-Environment/";

            webDriver.navigate().to(assignmentURL);

            String assertTextVLSO = "Presence of 'Turn In' Button.";
            Assert.assertTrue(turnInFeature.verifyTurnInButton(), assertFailurePreText + assertTextVLSO);
            reportLog(assertTextVLSO);

            String assertTextVMTT = "Presence of Modality Title Text.";
            Assert.assertTrue(turnInFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVMTT);
            reportLog(assertTextVMTT);

            turnInFeature.clickOnTurnInButton();

            String assertTextVCAC = "Presence of Completed Assignment CheckMark.";
            Assert.assertTrue(turnInFeature.verifyCompletedAssignmentCheckMark(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 6, description = "Verify Functionality Of 'Turn In ' Button In Practice Page")
    public void verifyFunctionalityOfTurInButtonInPracticePage() {
        boolean result = true;
        try {
            String assignmentURL = "https://flexbooks-master.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.1/primary/lesson/goals-of-science-bio-adv/";

            webDriver.navigate().to(assignmentURL);

            String assertTextVLSO = "Presence of 'Turn In' Button.";
            Assert.assertTrue(turnInFeature.verifyTurnInButton(), assertFailurePreText + assertTextVLSO);
            reportLog(assertTextVLSO);

            String assertTextVMTT = "Presence of Modality Title Text.";
            Assert.assertTrue(turnInFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVMTT);
            reportLog(assertTextVMTT);

            String assertTextVSPB = "Presence of 'Start Practise' button.";
            Assert.assertTrue(turnInFeature.verifyStartPracticeButton(), assertFailurePreText + assertTextVSPB);
            reportLog(assertTextVSPB);

            turnInFeature.clickOnTurnInButton();

            String assertTextVCAC = "Presence of OOps ! Completed Assignment Text.";
            Assert.assertTrue(turnInFeature.verifyOpsCompletePracticeText(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
*/
