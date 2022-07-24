package testscripts.regression.teacherlogin.ReportFeature.TryNewReports;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CoTeacherAssignmentFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CoTeacherAssignmentFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";
    private CoTeacherFeature coTeacherFeature;
    private CBookOptionDropDownFeatures cBookOptionDropDownFeatures;



  //  @Test(priority = 1,dataProvider = "CK12DataProvider",  description = "Verify Teacher Can Not Create An Assignment in the Class Of CoTeacher.")
    public void verifyDisplayOnDashBoardButtonIsVisible(String email, String password) {
        boolean result = true;
        try {
            coTeacherFeature =new CoTeacherFeature(webDriver,extentTest,extentReports);
            cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);

            String url="https://master.ck12.org/group-assignments/617411";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Class Name' Text.";
            Assert.assertTrue(coTeacherFeature.verifyClassNameText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            String assertTextVSCDB = "Create An Assignment Is Not Visible";
            Assert.assertTrue(coTeacherFeature.checkCreateAssignmentButtonIsNotVisible(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 2, description = "Verify Both The Class NAme Is Same In Case Of Created Class And JOined class..")
    public void verifyBothTheClassNameIsSame() {
        boolean result = true;
        try {
            String url = "https://qa-flash.ck12.org/my/dashboard-new/groups/";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Create Class Name' Text.";
            Assert.assertTrue(coTeacherFeature.verifyCreateClassNameText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            String assertTextVSCDB = "Presence of 'Joined Class Name' Text.";
            Assert.assertTrue(coTeacherFeature.verifyJoinedClassNameText(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            String assertTextVSB = "Name Of Create Class And Join Class Are Same.";
            Assert.assertTrue(coTeacherFeature.verifyNameOfCreateClassAndJoinClassAreSame(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 3, description = "Verify 'Turn In' Button Is Available For CoTeacher.")
    public void verifyTurnInButtonIsPresent() {
        boolean result = true;
        try {
            String url = "https://flexbooks-qa-flash.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.1/primary/lesson/scientific-investigation-bio";

            webDriver.navigate().to(url);

            String assertTextVSCDB = "Presence of 'Turn In' Button.";
            Assert.assertTrue(coTeacherFeature.verifyTurnInButtonIsVisible(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 4, description = "Verify CoTeacher Of Class Successfully Login.")
    public void verifyTeacherLoginSuccessfully() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            TurnInFeature turnInFeature = new TurnInFeature(webDriver,extentTest,extentReports);

            String flexBookUrl = "https://qa-flash.ck12.org/teacher/";
            String email = "teacher101+testuser@ck12.org";
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
            new LoginPage(webDriver,extentTest, extentReports).login(email, pass);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Student icon' after logging in.";
            Assert.assertTrue(turnInFeature.verifyStudentAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 5, description = "Verify CoTeacher Can Not Share Resources From Option DropDown Feature Of FlexBook Modality Page.")
    public void verifyShareWithClassesFromModalityPage() {
        boolean result = true;
        try {
            String url = "https://flexbooks-qa-flash.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.1/primary/lesson/scientific-investigation-bio";

            webDriver.navigate().to(url);

            Assert.assertTrue(cBookOptionDropDownFeatures.verifyOptionsDropDown(), "Test Script Field to verify Options DropDown");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Options DropDown");
            logger.info("Teacher Successfully verify Options DropDown");

            cBookOptionDropDownFeatures.clickOnOptionsDropDown();

            Assert.assertTrue(cBookOptionDropDownFeatures.verifyAddToFlexBookButton(), "Test Script Field to verify Add To FlexBook Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Add To FlexBook Button");
            logger.info("Teacher Successfully verify Add To FlexBook Button");

            Assert.assertTrue(cBookOptionDropDownFeatures.verifyShareToClassButton(), "Test Script Field to verify Share To Class Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Share To Class Button");
            logger.info("Teacher Successfully verify Share To Class Button");

            cBookOptionDropDownFeatures.clickOnShareToClassButton();

            String assertTextVLC = "Presence of 'You Don't Own Any Class' button.";
            Assert.assertTrue(coTeacherFeature.verifyYouDoNotOwnAnyClassText(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 7, description = "Verify 'Assign To Class' option is present inside Option DropDown.")
    public void verifyAssignAssignmentOptionIsVisible() {
        boolean result = true;
        try {
            String url = "https://flexbooks-qa-flash.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.1/primary/lesson/scientific-investigation-bio";

            webDriver.navigate().to(url);

            Assert.assertTrue(cBookOptionDropDownFeatures.verifyOptionsDropDown(), "Test Script Field to verify Options DropDown");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Options DropDown");
            logger.info("Teacher Successfully verify Options DropDown");

            cBookOptionDropDownFeatures.clickOnOptionsDropDown();

            Assert.assertTrue(cBookOptionDropDownFeatures.verifyAddToFlexBookButton(), "Test Script Field to verify Add To FlexBook Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Add To FlexBook Button");
            logger.info("Teacher Successfully verify Add To FlexBook Button");

            String assertTextVSCB = "Presence of 'Assign To Class' button Of Option DropDown.";
            Assert.assertTrue(coTeacherFeature.verifyAssignButtonOfOptionDropDown(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 9, description = "Verify CoTeacher Can Not Assign Resources From Option DropDown Feature Of FlexBook Modality Page.")
    public void verifyAssignAssignmentFromModalityPage() {
        boolean result = true;
        try {
            coTeacherFeature.clickOnAssignButtonOfOptionDropDown();

            String assertTextVLNC = "Presence of 'Ck12 Image' Icon.";
            Assert.assertTrue(coTeacherFeature.verifyCk12ImageIcon(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            coTeacherFeature.clickOnCk12ImageIcon();

            String assertTextVLC = "Presence of 'Create Class' Link.";
            Assert.assertTrue(coTeacherFeature.verifyCreateNewClassLink(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}