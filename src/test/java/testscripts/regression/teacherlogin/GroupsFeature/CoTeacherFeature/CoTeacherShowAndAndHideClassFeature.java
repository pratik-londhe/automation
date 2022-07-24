package testscripts.regression.teacherlogin.GroupsFeature.CoTeacherFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CoTeacherShowAndAndHideClassFeature extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CoTeacherShowAndAndHideClassFeature.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";



    @org.testng.annotations.Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Display On DashBoard' button should be worked properly For CoTeacher.")
    public void verifyDisplayOnDashBoardButtonIsVisible(String email, String password) {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://master.ck12.org/my/dashboard-new/groups/";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to(url);

            /*String assertTextVSCB = "Presence of 'Show' Text.";
            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);*/

            String assertTextVSCDB = "Presence of 'Hidden Classes' Link.";
            Assert.assertTrue(coTeacherFeature.verifyHiddenClassesLink(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            coTeacherFeature.clickOnHiddenClassesLink();

            String assertTextVSB = "Presence of 'Show' Text.";
            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            coTeacherFeature.clickOnClassMenu();

            String assertTextVTI = "Presence of 'ToC' icon.";
            Assert.assertTrue(coTeacherFeature.verifyDisplayOnDashBoardLink(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @org.testng.annotations.Test(priority = 3, description = "Verify the 'Co-teacher' can able to Display a class from Teacher dashboard page.")
    public void verifyFunctionalityOfDisplayOnDashBoardLink() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            coTeacherFeature.clickOnDisplayOnDashBoardLink();

            String assertTextVSCB = "Presence of 'Display On DashBoard' Text.";
            Assert.assertTrue(coTeacherFeature.verifyDisplayOnDashBoardText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            coTeacherFeature.scrollScreenForDisplayButton();

            String assertTextVSCDB = "Presence of 'Display' button.";
            Assert.assertTrue(coTeacherFeature.verifyDisplayButton(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            coTeacherFeature.clickOnDisplayButton();

            String assertTextVSB = "Presence of 'Show' Text.";
            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

//            coTeacherFeature.clickOnClassMenu();
//
//            String assertTextVTI = "Presence of 'ToC' icon.";
//            Assert.assertTrue(coTeacherFeature.verifyDisplayOnDashBoardLink(), assertFailurePreText + assertTextVTI);
//            reportLog(assertTextVTI);
//
//            coTeacherFeature.clickOnDisplayOnDashBoardLink();
//
//            String assertTextVCB = "Presence of 'Display On DashBoard' Text.";
//            Assert.assertTrue(coTeacherFeature.verifyDisplayOnDashBoardText(), assertFailurePreText + assertTextVCB);
//            reportLog(assertTextVCB);
//
//            coTeacherFeature.scrollScreenForDisplayButton();
//
//            String assertTextVCDB = "Presence of 'Display' button.";
//            Assert.assertTrue(coTeacherFeature.verifyDisplayButton(), assertFailurePreText + assertTextVCDB);
//            reportLog(assertTextVCDB);
//
//            coTeacherFeature.clickOnDisplayButton();

//            String assertTextVB = "Presence of 'Show' Text.";
//            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVB);
//            reportLog(assertTextVB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @org.testng.annotations.Test(priority = 5, description = "Verify Hide button should be worked properly after teacher user joined another teacher class.")
    public void verifyHideClassButtonIsVisibleForCoTeacher() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String assertTextVTI = "Presence of 'ToC' icon.";
            Assert.assertTrue(coTeacherFeature.verifyCurrentClassesLink(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            coTeacherFeature.clickOnCurrentClassesLink();

            String assertTextVSCDB = "Presence of 'Show' Text.";
            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            coTeacherFeature.clickOnClassMenu();

            String assertTextVLNC = "Presence of 'Hide From DashBoard' link.";
            Assert.assertTrue(coTeacherFeature.verifyHideFromDashBoardLink(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @org.testng.annotations.Test(priority = 7, description = "Verify the 'Co-teacher' can able to hide a class from Teacher dashboard page.")
    public void verifyFunctionalityOfHideClassButton() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            coTeacherFeature.clickOnHideFromDashBoardLink();

            String assertTextVSCDB = "Presence of 'Hide From DashBoard' Text.";
            Assert.assertTrue(coTeacherFeature.verifyHideFromDashBoardText(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            coTeacherFeature.scrollScreen();

            String assertTextVLNC = "Presence of 'Hide' button.";
            Assert.assertTrue(coTeacherFeature.verifyHideButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            coTeacherFeature.clickOnHideButton();

            String assertTextVSCB = "Presence of 'Show' Text.";
            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

//            coTeacherFeature.clickOnClassMenu();
//
//            String assertTextVLC = "Presence of 'Hide From DashBoard' link.";
//            Assert.assertTrue(coTeacherFeature.verifyHideFromDashBoardLink(), assertFailurePreText + assertTextVLC);
//            reportLog(assertTextVLC);
//
//            coTeacherFeature.clickOnHideFromDashBoardLink();
//
//            String assertTextVSB = "Presence of 'Hide From DashBoard' Text.";
//            Assert.assertTrue(coTeacherFeature.verifyHideFromDashBoardText(), assertFailurePreText + assertTextVSB);
//            reportLog(assertTextVSB);
//
//            coTeacherFeature.scrollScreen();
//
//            String assertTextVNC = "Presence of 'Hide' button.";
//            Assert.assertTrue(coTeacherFeature.verifyHideButton(), assertFailurePreText + assertTextVNC);
//            reportLog(assertTextVNC);
//
//            coTeacherFeature.clickOnHideButton();
//
//            String assertTextVS = "Presence of 'Show' Text.";
//            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVS);
//            reportLog(assertTextVS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 9, description = "Verify the Functionality Of 'Create New One' link.")
    public void verifyFunctionalityOfCreateNewOneLink() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String assertTextVSCDB = "Presence of 'Create NEw One' Link.";
            Assert.assertTrue(coTeacherFeature.verifyCreateNewOneLink(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            coTeacherFeature.clickOnCreateNewOneLink();

            String assertTextVLNC = "Presence of 'Hide' button.";
            Assert.assertTrue(coTeacherFeature.verifyCreateNEwClassText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 11, description = "Verify the Functionality Of 'Close' Icon Of Create New Class Page.")
    public void verifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String assertTextVSCDB = "Presence of 'Close' Icon.";
            Assert.assertTrue(coTeacherFeature.verifyCloseIcon(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            coTeacherFeature.clickOnCloseIcon();

            String assertTextVSCB = "Presence of 'Show' Text.";
            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @org.testng.annotations.Test(priority = 13, description = "Verify Owner Of Class Successfully Login.")
    public void verifyTeacherLoginSuccessfully() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
            TurnInFeature turnInFeature = new TurnInFeature(webDriver, extentTest, extentReports);

            String flexBookUrl = "https://qa-flash.ck12.org/teacher/";
            String email = "teacher101+testuser@ck12.org";
            String pass = "fa1234";

            webDriver.navigate().to(flexBookUrl);

            String assertTextVFO = "Presence of Try It Now Button.";
            Assert.assertTrue(cBookLandingPage.verifyFlexBookLink(), assertFailurePreText + assertTextVFO);
            reportLog(assertTextVFO);

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
            new LoginPage(webDriver, extentTest, extentReports).login(email, pass);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Student icon' after logging in.";
            Assert.assertTrue(turnInFeature.verifyStudentAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 15, description = "Verify the Class hidden by the co-teacher its should not be reflected in class owner dashboard page.")
    public void verifyHiddenClassesOnClassOwnerList() {
        boolean result = true;
        try {
            CoTeacherFeature coTeacherFeature = new CoTeacherFeature(webDriver, extentTest, extentReports);

            String url = "https://qa-flash.ck12.org/my/dashboard-new/groups/";

            webDriver.navigate().to(url);

            String assertTextVSCB = "Presence of 'Show' Text.";
            Assert.assertTrue(coTeacherFeature.verifyShowText(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

            coTeacherFeature.clickOnClassMenu();

            String assertTextVLNC = "Presence of 'Hide From DashBoard' link.";
            Assert.assertTrue(coTeacherFeature.verifyHideFromDashBoardLink(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}