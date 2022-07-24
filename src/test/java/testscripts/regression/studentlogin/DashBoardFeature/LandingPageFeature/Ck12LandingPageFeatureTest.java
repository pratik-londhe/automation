package testscripts.regression.studentlogin.DashBoardFeature.LandingPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import constants.CK12Constant;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class Ck12LandingPageFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(Ck12LandingPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, description = "Verify Sign Up Banner Button is Available on student Landing Page before Login")
    public void verifySignUpBannerIsAvailable() {
        boolean result = true;
        try {
            StudentLandingPage studentLandingPage = new StudentLandingPage(webDriver, extentTest, extentReports);
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            String assertTextVHI = "Presence Of 'Ck12 Image' Icon";
            Assert.assertTrue(ck12SubjectsPage.verifyCK12ImageIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            studentLandingPage.scrollScreenForSignUpBanner();

            String assertTextVTPOG = "Presence Of Sign Up Banner Button";
            Assert.assertTrue(studentLandingPage.verifySignUpBannerButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of Sign Up Banner Button Before Login.")
    public void verifyFunctionalityOfSignUpBannerBeforeLogin() {
        boolean result = true;
        try {
            StudentLandingPage studentLandingPage = new StudentLandingPage(webDriver, extentTest, extentReports);
            SignOutPage signOutPage = new SignOutPage(webDriver, extentTest, extentReports);

            studentLandingPage.clickOnSignUpBannerButton();

            String assertTextVH = "Presence Of 'Join' Button.";
            Assert.assertTrue(signOutPage.verifyJoinButton(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVH);

            String assertTextVENT = "Presence Of 'Student SignUp Text'.";
            Assert.assertTrue(signOutPage.verifyStudentSignUpText(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, dataProvider = "CK12DataProvider", description = "Verify Sign Up Banner Button is Available on student Landing Page After Login")
    public void verifySignUpBannerButtonIsAvailableAfterLogin(String email, String password) {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);
            new LoginPage(webDriver, extentTest, extentReports).studentLogin(email, password);
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);
            StudentLandingPage studentLandingPage = new StudentLandingPage(webDriver, extentTest, extentReports);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Ck12 Image' Icon";
            Assert.assertTrue(ck12SubjectsPage.verifyCK12ImageIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            ck12SubjectsPage.clickOnCK12ImageIcon();

            String assertTextVTOG = "Presence Of HAve A class Code LInk";
            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVTOG);
            reportLog(assertTextVTOG);

            studentLandingPage.scrollScreenForSignUpBanner();

            String assertTextVTPG = "Presence Of Sign Up Banner Button";
            Assert.assertTrue(studentLandingPage.verifySignUpBannerButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Sign Up Banner Button After Login.")
    public void verifyFunctionalityOfSignUpBannerAfterLogin() {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);
            StudentLandingPage studentLandingPage = new StudentLandingPage(webDriver, extentTest, extentReports);

            studentLandingPage.clickOnSignUpBannerButton();

            String assertTextVTPOG = "Presence Of Class Activity Tab";
            Assert.assertTrue(studentDashBoardPage.verifyClassActivityTab(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Ck12 Image' Icon";
            Assert.assertTrue(ck12SubjectsPage.verifyCK12ImageIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            ck12SubjectsPage.clickOnCK12ImageIcon();

            String assertTextVTOG = "Presence Of HAve A class Code LInk";
            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVTOG);
            reportLog(assertTextVTOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Different Browse Learning Links Are Available")
    public void verifyLearningBrowse() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);
            StudentLandingPage studentLandingPage = new StudentLandingPage(webDriver, extentTest, extentReports);

            studentLandingPage.scrollScreenForReinforcementLearning();

            String assertTextVTPOG = "Presence Of Adaptive Practice Link LInk";
            Assert.assertTrue(ck12SubjectsPage.verifyAdaptivePracticeLink(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVH = "Presence Of 'Plix' link.";
            Assert.assertTrue(ck12SubjectsPage.verifyPlixLink(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVH);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify Functionality Of Adaptive Practice FlexBook Link And Verify It Redirects Adaptive Practice Page. ")
    public void verifyFunctionalityOfAdaptivePracticeLink() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);
            StudentLandingPage studentLandingPage = new StudentLandingPage(webDriver, extentTest, extentReports);

            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);
            ck12SubjectsPage.clickOnAdaptivePracticeLink();

            String assertTextVSO = "Presence Of 'Adaptive Practice ' text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Ck12 Image' Icon";
            Assert.assertTrue(adaptivePracticeFeature.verifyCk12Icon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            /*adaptivePracticeFeature.clickOnCk12Icon();

            String assertTextVTOG = "Presence Of HAve A class Code LInk";
            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVTOG);
            reportLog(assertTextVTOG);

            studentLandingPage.scrollScreenForReinforcementLearning();

            String assertTextVHSD = "Presence Of 'Physics' link.";
            Assert.assertTrue(ck12SubjectsPage.verifyPhysicsLink(), assertFailurePreText + assertTextVHSD);
            reportLog(assertTextVHSD);
*/
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Physics FlexBook Link And Verify It Redirects Physics Page. ")
    public void verifyFunctionalityOfPhysicsLink() {
        boolean result = true;
        try {
/*            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);
            StudentLandingPage studentLandingPage = new StudentLandingPage(webDriver, extentTest, extentReports);

            ck12SubjectsPage.clickOnPhysicsLink();

            String assertTextVSO = "Presence Of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Ck12 Image' Icon";
            Assert.assertTrue(simulationFeature.verifyCk12ImageIcon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            simulationFeature.clickOnCk12ImageIcon();

//            String assertTextVTOG = "Presence Of HAve A class Code LInk";
//            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVTOG);
//            reportLog(assertTextVTOG);

            studentLandingPage.scrollScreenForReinforcementLearning();

            String assertTextVHSD = "Presence Of 'Physics' link.";
            Assert.assertTrue(ck12SubjectsPage.verifyChemistryLink(), assertFailurePreText + assertTextVHSD);
            reportLog(assertTextVHSD);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Chemistry FlexBook Link And Verify It Redirects Chemistry Page. ")
    public void verifyFunctionalityOfChemistryLink() {
        boolean result = true;
        try {
/*            SimulationFeature simulationFeature = new SimulationFeature(webDriver, extentTest, extentReports);
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);
            StudentLandingPage studentLandingPage = new StudentLandingPage(webDriver, extentTest, extentReports);

            ck12SubjectsPage.clickOnChemistryLink();

            String assertTextVSO = "Presence Of 'Exploration Series' Text.";
            Assert.assertTrue(simulationFeature.verifyExplorationSeriesText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            String assertTextVENT = "Presence Of 'Ck12 Image' Icon";
            Assert.assertTrue(simulationFeature.verifyCk12ImageIcon(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

            simulationFeature.clickOnCk12ImageIcon();

//            String assertTextVTOG = "Presence Of HAve A class Code LInk";
//            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVTOG);
//            reportLog(assertTextVTOG);

            studentLandingPage.scrollScreenForReinforcementLearning();
            String assertTextVHSD = "Presence Of 'Plix' link.";
            Assert.assertTrue(ck12SubjectsPage.verifyPlixLink(), assertFailurePreText + assertTextVHSD);
            reportLog(assertTextVHSD);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of Study Guide Link And Verify It Redirects Study Guide Page.")
    public void verifyFunctionalityOfStudyGuideLink() {
        boolean result = true;
        try {
/*            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            ck12SubjectsPage.clickOnStudyGuideLink();

            String assertTextVSO = "Presence Of 'Study Guide ' Text.";
            Assert.assertTrue(new StudyGuideFeature(webDriver, extentTest, extentReports).verifyStudyGuideText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}