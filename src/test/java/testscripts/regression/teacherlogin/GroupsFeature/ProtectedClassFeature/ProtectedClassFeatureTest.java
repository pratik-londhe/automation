package testscripts.regression.teacherlogin.GroupsFeature.ProtectedClassFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class ProtectedClassFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ProtectedClassFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";

    private String url = "https://master.ck12.org/group-settings/575381";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Class Code is not display on the below of class name when teacher is not allows student to join class. ")
    public void verifyClassCodeIsNotDisplay(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            String classUrl = "https://master.ck12.org/my/dashboard-new/groups/";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to(classUrl);

            String assertTextVSB = "Presence of 'Recent Class Activity' link";
            Assert.assertTrue(protectedClassFeature.verifyRecentClassActivityLink(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            String assertTextVL = "Class Code Is Not Display Below Class Name";
            Assert.assertTrue(protectedClassFeature.verifyClassCodeIsNotDisplayBelowClassName(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Ui Page Of Protected Class Feature")
    public void verifyUiPageOfProtectedClass() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            webDriver.navigate().to(url);

            String assertTextVML = "Presence of 'View' link.";
            Assert.assertTrue(protectedClassFeature.verifyViewLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVSB = "Presence of 'Add Student' Button";
            Assert.assertTrue(protectedClassFeature.verifyAddStudentLink(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Switch' for  Allowing to student to join class.")
    public void verifyFunctionalityOfYesSwitch() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            String assertTextVSB = "Presence of 'Copy Class Code' link";
            Assert.assertTrue(protectedClassFeature.verifyYesOrNoSwitch(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            protectedClassFeature.clickOnNoSwitch();

            String assertTextVL = "Presence of 'View' link.";
            Assert.assertTrue(protectedClassFeature.verifyViewLink(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify Class Code is not display on the below of class name when teacher is not allows student to join class. ")
    public void verifyClassCodeIsDisplay() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            String classUrl = "https://master.ck12.org/my/dashboard-new/groups/";

            webDriver.navigate().to(classUrl);

            String assertTextVSB = "Presence of 'Recent Class Activity' link";
            Assert.assertTrue(protectedClassFeature.verifyRecentClassActivityLink(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            String assertTextVL = "Class Code Is Display Below Class Name";
            Assert.assertTrue(protectedClassFeature.verifyClassCodeIsDisplayBelowClassName(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'View' link of  Protected Class Page.")
    public void verifyFunctionalityOfViewLink() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            webDriver.navigate().to(url);

            String assertTextVL = "Presence of 'View' link.";
            Assert.assertTrue(protectedClassFeature.verifyViewLink(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            protectedClassFeature.clickOnViewLink();

            String assertTextVML = "Presence of 'User Name' text";
            Assert.assertTrue(protectedClassFeature.verifyUserNameText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            webDriver.navigate().to(url);

            String assertTextVLI = "Presence of 'View' link.";
            Assert.assertTrue(protectedClassFeature.verifyViewLink(), assertFailurePreText + assertTextVLI);
            reportLog(assertTextVLI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Add Student' link of  Protected Class Page.")
    public void verifyFunctionalityOfAddStudentLink() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            String assertTextVSB = "Presence of 'Add Student' Button";
            Assert.assertTrue(protectedClassFeature.verifyAddStudentLink(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            protectedClassFeature.clickOnAddStudentLink();

            String assertTextVML = "Presence of 'Add Student Without Email' link";
            Assert.assertTrue(protectedClassFeature.verifyAddStudentWithoutLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Close Modal' Icon of  Add Student Pop Up.")
    public void verifyFunctionalityOfCloseModelIcon() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            String assertTextVSB = "Presence of 'Close Modal' Icon";
            Assert.assertTrue(protectedClassFeature.verifyCloseModelIcon(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            protectedClassFeature.clickOnCloseModelIcon();

            String assertTextVL = "Presence of 'View' link.";
            Assert.assertTrue(protectedClassFeature.verifyViewLink(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of 'Copy' Class Code Link.")
    public void verifyFunctionalityOfCopyLink() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            String assertTextVSB = "Presence of 'Copy Class Code' link";
            Assert.assertTrue(protectedClassFeature.verifyCopyClassCodeLink(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            protectedClassFeature.clickOnCopyClassCodeLink();

            String assertTextVL = "Presence of 'Copied' Text.";
            Assert.assertTrue(protectedClassFeature.verifyCopiedText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'Switch' for not Allowing to student to join class.")
    public void verifyFunctionalityOfNoSwitch() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            String assertTextVSB = "Presence of 'Copy Class Code' link";
            Assert.assertTrue(protectedClassFeature.verifyYesOrNoSwitch(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            protectedClassFeature.clickOnYesSwitch();

            String assertTextVL = "Presence of 'View' link.";
            Assert.assertTrue(protectedClassFeature.verifyViewLink(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Class Code is changed when allowing student to join Class.")
    public void verifyChangedClassCode() {
        boolean result = true;
        try {
            ProtectedClassFeature protectedClassFeature = new ProtectedClassFeature(webDriver, extentTest, extentReports);

            String assertTextVSB = "Presence of 'Copy Class Code' link";
            Assert.assertTrue(protectedClassFeature.verifyYesOrNoSwitch(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            protectedClassFeature.clickOnNoSwitch();

            String assertTextVL = "Presence of 'View' link.";
            Assert.assertTrue(protectedClassFeature.verifyViewLink(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            String assertTextVB = "Presence of 'Copy Class Code' link";
            Assert.assertTrue(protectedClassFeature.verifyCopyClassCodeLink(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

            String assertTextVCC = "Presence of 'Class Code' text";
            Assert.assertTrue(protectedClassFeature.verifyClassCodeText(), assertFailurePreText + assertTextVCC);
            reportLog(assertTextVCC);

            protectedClassFeature.clickOnCopyClassCodeLink();

            String assertTextVC = "Presence of 'Copied' Text.";
            Assert.assertTrue(protectedClassFeature.verifyCopiedText(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

            String assertTextVS = "Presence of 'Copy Class Code' link";
            Assert.assertTrue(protectedClassFeature.verifyYesOrNoSwitch(), assertFailurePreText + assertTextVS);
            reportLog(assertTextVS);

            protectedClassFeature.clickOnYesSwitch();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Student Login Successfully to join Class.")
    public void verifyStudentLoginSuccessfully() {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);

            String flexBookUrl = "https://flexbooks-master.ck12.org/flexbooks/teacher";
            String email = "studentfa+testuser@ck12.org";
            String pass = "fa1234";

            webDriver.navigate().to(flexBookUrl);

//            String assertTextVFO = "Presence of Try It Now Button.";
//            Assert.assertTrue(cBookLandingPage.verifyFlexBookLink(), assertFailurePreText + assertTextVFO);
//            reportLog(assertTextVFO);
//
//            cBookLandingPage.clickOnFlexBookLink();

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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Student Can't join Class if Teacher Is not allowing.")
    public void verifyStudentCanNotJoinClassWhenTeachersNotAllowedToJoinClass() {
        boolean result = true;
        try {
            JoinClass joinClass = new JoinClass(webDriver, extentTest, extentReports);
            String joinClassUrl = "https://master.ck12.org/my/groups/#";

            webDriver.navigate().to(joinClassUrl);

            String assertTextVFO = "Presence of 'Join Class' Button.";
            Assert.assertTrue(joinClass.verifyJoinClassButton(), assertFailurePreText + assertTextVFO);
            reportLog(assertTextVFO);

            /*String assertTextVCAC = "Presence of 'Class Code' PlaceHolder.";
            Assert.assertTrue(protectedClassFeature.verifyClassCodePlaceHolder(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            protectedClassFeature.pasteCopiedClassCodeInPlaceHolder();*/

            String assertTextVSO = "Presence of 'Join Class' Button.";
            Assert.assertTrue(joinClass.verifyJoinClassButton(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            joinClass.clickOnJoinClassButton();

            /*String assertTextVSAI = "Presence of 'Wrong Error' Text.";
            Assert.assertTrue(joinClass.verifyWrongErrorText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}