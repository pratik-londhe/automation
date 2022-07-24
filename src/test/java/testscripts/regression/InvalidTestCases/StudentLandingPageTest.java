package testscripts.regression.InvalidTestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.StudentDashBoardPage;
import uipages.flexbook2feature.StudentLandingPage;

public class StudentLandingPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentLandingPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    private StudentDashBoardPage studentDashBoardPage;
    private StudentLandingPage studentLandingPage;



    @Test(priority = 1, description = "Get Started and Why CK-12? Links should be displayed below of 100% Free, Personalized.")
    public void verifyGetStartedAndCk12Link() {
        boolean result = true;
        try {
            studentLandingPage = new StudentLandingPage(webDriver,extentTest,extentReports);
            studentDashBoardPage = new StudentDashBoardPage(webDriver,extentTest,extentReports);

//            String assertTextVTPOG = "Presence Of 'Personalize Learning' Text";
//            Assert.assertTrue(studentLandingPage.verifyPersonalizeLearningText(), assertFailurePreText + assertTextVTPOG);
//            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Get Started' Tab";
            Assert.assertTrue(studentLandingPage.verifyGetStartedTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Why Ck12' Link.";
            Assert.assertTrue(studentLandingPage.verifyWhyCk12Link(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Clicking 'Get started' button will redirect to sign in pop up.")
    public void verifyFunctionalityOfGetStaredTab() {
        boolean result = true;
        try {
            String email = "student1+testuser@ck12.org";
            String pass = "Pratikck12";

            studentLandingPage.clickOnGetStartedTab();

            String assertTextVTPOG = "Presence Of 'Sign In' Text";
            Assert.assertTrue(studentLandingPage.verifySignInText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            new LoginPage(webDriver,extentTest, extentReports).login(email, pass);
            new LoginPage(webDriver,extentTest, extentReports).clickOnBtnSignIn();

            String assertTextVTOG = "Student profile icon after login";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTOG);
            reportLog(assertTextVTOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify 'Go to Dashboard' button gets displayed after sign in as user..")
    public void verifyGoTODashBoardPage() {
        boolean result = true;
        try {
            String assertTextVHI = "Presence Of 'Ck12 Title'";
            Assert.assertTrue(studentLandingPage.verifyCk12Title(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            studentLandingPage.clickOnCk12Title();

            String assertTextVSO = "Presence Of 'Go to DashBoard' Tab.";
            Assert.assertTrue(studentLandingPage.verifyGoToDashBoardButton(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Clicking 'Go to Dashboard' link redirects to Dashboard page after login.")
    public void verifyFunctionalityOfGoTODashBoardPage() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver,extentTest,extentReports);

            studentLandingPage.clickOnGoToDashBoardButton();

            String assertTextVHI = "Presence Of 'Class Activity' Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Self Study' Tab.";
            Assert.assertTrue(studentDashBoardPage.verifySelfStudyTab(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVI = "Presence Of 'Ck12 Title'";
            Assert.assertTrue(studentLandingPage.verifyCk12Title(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            studentLandingPage.clickOnCk12Title();

            String assertTextVO = "Presence Of 'Go to DashBoard' Tab.";
            Assert.assertTrue(studentLandingPage.verifyGoToDashBoardButton(), assertFailurePreText + assertTextVO);
            reportLog(assertTextVO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Clicking 'Why CK-12' button displays a video pop up.")
    public void verifyFunctionalityOfWhyCk12Tab() {
        boolean result = true;
        try {
            String assertTextVSO = "Presence Of 'Why Ck12' Link.";
            Assert.assertTrue(studentLandingPage.verifyWhyCk12Link(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            studentLandingPage.clickOnWhyCk12Link();

            String assertTextVI = "Presence Of 'Why Ck12' Text";
            Assert.assertTrue(studentLandingPage.verifyWhyCk12Text(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            String assertTextVO = "Presence Of 'Go to DashBoard' Tab.";
            Assert.assertTrue(studentLandingPage.verifyCloseIcon(), assertFailurePreText + assertTextVO);
            reportLog(assertTextVO);

            studentLandingPage.clickOnCloseIcon();

            String assertTextVOS = "Presence Of 'Go to DashBoard' Tab.";
            Assert.assertTrue(studentLandingPage.verifyGoToDashBoardButton(), assertFailurePreText + assertTextVOS);
            reportLog(assertTextVOS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Physics and Chemistry Simulations, PLIX, Adaptive Practice and Study Guides circle should show below Explore in Student user.")
    public void verifyCircleBelowExplore() {
        boolean result = true;
        try {
            studentLandingPage.scrollScreen();

            String assertTextVSO = "Presence Of 'Explore' Text.";
            Assert.assertTrue(studentLandingPage.verifyExploreText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVI = "Presence Of 'Physics Chemistry ' Circle ";
            Assert.assertTrue(studentLandingPage.verifyPhysicsChemistryCircle(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            String assertTextVO = "Presence Of 'Plix' Circle.";
            Assert.assertTrue(studentLandingPage.verifyPlixCircle(), assertFailurePreText + assertTextVO);
            reportLog(assertTextVO);

            String assertTextVOS = "Presence Of 'Practice' circle.";
            Assert.assertTrue(studentLandingPage.verifyPracticeCircle(), assertFailurePreText + assertTextVOS);
            reportLog(assertTextVOS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Hover Physics and Chemistry Simulations circle and verify it should display Way Learning Text.")
    public void hoverPhysicsChemistryCircle() {
        boolean result = true;
        try {
            String assertTextVI = "Presence Of 'Physics Chemistry ' Circle ";
            Assert.assertTrue(studentLandingPage.verifyPhysicsChemistryCircle(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            studentLandingPage.hoverPhysicsChemistryCircle();

            String assertTextVSO = "Presence Of 'Physics Chemistry Overlay' Text.";
            Assert.assertTrue(studentLandingPage.verifyOverlayPhysicsChemistryText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Hover Plix circle and verify it should display Overlay Text.")
    public void hoverPlixCircle() {
        boolean result = true;
        try {
            String assertTextVO = "Presence Of 'Plix' Circle.";
            Assert.assertTrue(studentLandingPage.verifyPlixCircle(), assertFailurePreText + assertTextVO);
            reportLog(assertTextVO);

            studentLandingPage.hoverPlixCircle();

            String assertTextVSO = "Presence Of 'Plix Overlay' Text.";
            Assert.assertTrue(studentLandingPage.verifyOverlayPlixText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Hover Practice circle and verify it should display Overlay Text.")
    public void hoverPracticeCircle() {
        boolean result = true;
        try {
            String assertTextVOS = "Presence Of 'Practice' circle.";
            Assert.assertTrue(studentLandingPage.verifyPracticeCircle(), assertFailurePreText + assertTextVOS);
            reportLog(assertTextVOS);

            studentLandingPage.hoverPracticeCircle();

            String assertTextVSO = "Presence Of 'Practice Overlay' Text.";
            Assert.assertTrue(studentLandingPage.verifyOverlayPracticeText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Hover Study Guide circle and verify it should display Overlay Text.")
    public void hoverStudyGuideCircle() {
        boolean result = true;
        try {
            String assertTextVOS = "Presence Of 'Study Guide' circle.";
            Assert.assertTrue(studentLandingPage.verifyStudyGuideCircle(), assertFailurePreText + assertTextVOS);
            reportLog(assertTextVOS);

            studentLandingPage.hoverStudyGuidesCircle();

            String assertTextVSO = "Presence Of 'Study Guide Overlay' Text.";
            Assert.assertTrue(studentLandingPage.verifyOverlayStudyGuideText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}