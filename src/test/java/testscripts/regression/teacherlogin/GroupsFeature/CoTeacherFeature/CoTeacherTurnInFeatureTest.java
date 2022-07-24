package testscripts.regression.teacherlogin.GroupsFeature.CoTeacherFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TurnInFeature;
import uipages.reports2feature.ClassAssignmentFeature;
import uipages.reports2feature.TeacherReports;

public class CoTeacherTurnInFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CoTeacherTurnInFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Owner of Class Teacher Is Login Successfully")
    public void verifyTeacherLogin(String email, String password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver, extentTest, extentReports);

            cBookLandingPage.clickOnFlexBookLink();
            cBookLandingPage.clickOnSignInIcon();
            loginPage.login(email, password);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Teacher icon' after logging in.";
            Assert.assertTrue(cBookLandingPage.verifyTeacherAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assignmentURL = "https://master.ck12.org/group-assignments/617411";

            webDriver.navigate().to(assignmentURL);

            String assertTextVCAC = "Presence of Profile Icon.";
            Assert.assertTrue(turnInFeature.verifyNoDueDateLink(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            turnInFeature.clickOnNoDueDateLink();
            turnInFeature.clickOnAssignmentName();

            String assertTextVSA = "Presence of 'Undo Assign' Button.";
            Assert.assertTrue(classAssignmentFeature.verifyUndoAssignLink(), assertFailurePreText + assertTextVSA);
            reportLog(assertTextVSA);

            classAssignmentFeature.clickOnUndoAssignLink();

            Assert.assertTrue(classAssignmentFeature.verifyCancelRemoveButton(), "Failed to verified Cancel Remove Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Cancel Remove Button");
            logger.info("User Successfully verified Cancel Remove Button");

            Assert.assertTrue(classAssignmentFeature.verifyYesRemoveButton(), "Failed to verified Yes Remove Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Yes Remove Button");
            logger.info("User Successfully verified Yes Remove Button");

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify Owner Of Class Teacher Assign Assignment in the class successfully.")
    public void verifyFunctionalityOfAssignAssignment() {
        boolean result = true;
        try {
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver, extentTest, extentReports);
            TeacherReports teacherReports = new TeacherReports(webDriver, extentTest, extentReports);

            classAssignmentFeature.clickOnYesRemoveButton();
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

    @Test(priority = 3, description = "Verify Successfully Login Through CoTeacher Account.")
    public void verifyStudentLoginSuccessfully() {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);

            String flexBookUrl = "https://master.ck12.org/teacher/";
            String email = "student123";
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

    @Test(priority = 4, description = "Verify 'Turn In ' Button Is Available For CoTeacher On Read Modality Assignment Page.")
    public void verifyTurInButtonIsAvailable() {
        boolean result = true;
        try {
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);

            String assignmentURL = "https://flexbooks-master.ck12.org/cbook/ck-12-interactive-middle-school-math-6-for-ccss-.%3a_/r16/section/1.1/primary/lesson/introducing-ratios-math-6-ccss";

            webDriver.navigate().to(assignmentURL);

            String assertTextVLSO = "Presence of 'Turn In' Button.";
           // Assert.assertTrue(turnInFeature.verifyTurnInButton(), assertFailurePreText + assertTextVLSO);
            reportLog(assertTextVLSO);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Turn In ' Button In Read Modality Assignment Page After Completing Assignment.")
    public void verifyFunctionalityOfTurInButtonInReadPage() {
        boolean result = true;
        try {
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);

            String assertTextVMTT = "Presence of Modality Title Text.";
            Assert.assertTrue(turnInFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVMTT);
            reportLog(assertTextVMTT);

            //turnInFeature.clickOnTurnInButton();

           /* String assertTextVCAC = "Presence of Completed Assignment CheckMark.";
            Assert.assertTrue(turnInFeature.verifyCompletedAssignmentCheckMark(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);*/

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify 'Turn In ' Button Is Available For CoTeacher On Practice Page.")
    public void verifyTurInButtonISAvailableOnPracticePage() {
        boolean result = true;
        try {
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);

            String assignmentURL = "https://flexbooks-master.ck12.org/cbook/ck-12-interactive-middle-school-math-6-for-ccss-.%3a_/r16/section/1.1/primary/lesson/introducing-ratios-math-6-ccss";

            webDriver.navigate().to(assignmentURL);

            String assertTextVLSO = "Presence of 'Turn In' Button.";
           // Assert.assertTrue(turnInFeature.verifyTurnInButton(), assertFailurePreText + assertTextVLSO);
            reportLog(assertTextVLSO);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Turn In ' Button In Practice Page Without Solving Assignment.")
    public void verifyFunctionalityOfTurInButtonInPracticePage() {
        boolean result = true;
        try {
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);

            String assertTextVMTT = "Presence of Modality Title Text.";
            Assert.assertTrue(turnInFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVMTT);
            reportLog(assertTextVMTT);

            String assertTextVSPB = "Presence of 'Start Practise' button.";
           // Assert.assertTrue(turnInFeature.verifyStartPracticeButton(), assertFailurePreText + assertTextVSPB);
            reportLog(assertTextVSPB);

            //turnInFeature.clickOnTurnInButton();

           /* String assertTextVCAC = "Presence of OOps ! Completed Assignment Text.";
            Assert.assertTrue(turnInFeature.verifyOpsCompletePracticeText(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);*/

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}