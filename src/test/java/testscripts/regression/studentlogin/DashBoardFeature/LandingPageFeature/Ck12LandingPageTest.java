package testscripts.regression.studentlogin.DashBoardFeature.LandingPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CK12SubjectsPage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.StudentDashBoardPage;
import uipages.flexbook2feature.StudyGuideFeature;

public class Ck12LandingPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(Ck12LandingPageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Ck12 Logo Icon is Visible on student Landing Page")
    public void verifyCk12LogoIcoIsVisible(String email, String password) {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).studentLogin(email, password);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Ck12 Image' Icon";
            Assert.assertTrue(ck12SubjectsPage.verifyCK12ImageIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of Ck 12 Image ICon and Verify It redirects Student Landing Page")
    public void verifyFunctionalityOfCk12ImageIcon() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            ck12SubjectsPage.clickOnCK12ImageIcon();

//            String assertTextVHI = "Presence Of 'Start Learning' button";
//            Assert.assertTrue(ck12SubjectsPage.verifyStartLearningButton(), assertFailurePreText + assertTextVHI);
//            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'HAve A Class Code Link'.";
            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Have A Class Code Link'")
    public void verifyFunctionalityOfHaveClassCode() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            ck12SubjectsPage.clickOnHaveClassCodeLink();

            String assertTextVHI = "Presence Of 'Enter Your Code' text";
            Assert.assertTrue(ck12SubjectsPage.verifyEnterYourCodeText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Close Join Class' Icon.";
            Assert.assertTrue(ck12SubjectsPage.verifyCloseJoinClassIcon(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Close Join Class' Icon")
    public void verifyFunctionalityOfCloseJoinClassIcon() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            ck12SubjectsPage.clickOnCloseJoinClassIcon();

            String assertTextVSO = "Presence Of 'HAve A Class Code Link'.";
            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            ck12SubjectsPage.clickOnHaveClassCodeLink();

            String assertTextVHI = "Presence Of 'Enter Your Code' text";
            Assert.assertTrue(ck12SubjectsPage.verifyEnterYourCodeText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Join Class ' button without classCode")
    public void verifyFunctionalityOfClassCodeButton() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            String assertTextVSO = "Presence Of 'Join Class ' Button.";
            Assert.assertTrue(ck12SubjectsPage.verifyJoinClassButton(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            ck12SubjectsPage.clickOnJoinClassButton();

            String assertTextVHI = "Presence Of 'Empty Error Message' text";
            Assert.assertTrue(ck12SubjectsPage.verifyTextEmptyErrorMessage(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVH = "Presence Of 'Close Join Class' Icon.";
            Assert.assertTrue(ck12SubjectsPage.verifyCloseJoinClassIcon(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVSO);

            ck12SubjectsPage.clickOnCloseJoinClassIcon();

            String assertTextVENT = "Presence Of 'HAve A Class Code Link'.";
            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 11, description = "Verify Ck12 Demo Video Present On Ck12 Landing PAge")
    public void verifyCk12DemoVideoIsPresent() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            ck12SubjectsPage.enterIntoParentFrame();

            String assertTextVSO = "Presence Of 'Play' Button.";
            Assert.assertTrue(ck12SubjectsPage.verifyPlayButton(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 13, description = "Verify Ck 12 Demo Video Is Played Successfully")
    public void verifyCk12DemoVideoIsPlayed() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            ck12SubjectsPage.clickOnPlayButton();

            String assertTextVSO = "Presence Of 'Video Title' text.";
            Assert.assertTrue(ck12SubjectsPage.verifyVideoTitleText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            ck12SubjectsPage.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 15, description = "Verify Functionality Of 'Start Learning' button.")
    public void verifyFunctionalityOfStartLearningButton() {
        boolean result = true;
        try {
            CK12SubjectsPage ck12SubjectsPage = new CK12SubjectsPage(webDriver, extentTest, extentReports);

            String assertTextVHI = "Presence Of 'Start Learning' button";
            Assert.assertTrue(ck12SubjectsPage.verifyStartLearningButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            ck12SubjectsPage.clickOnStartLearningButton();

            String assertTextVENT = "Presence Of 'HAve A Class Code Link'.";
            Assert.assertTrue(ck12SubjectsPage.verifyHaveClassCodeLink(), assertFailurePreText + assertTextVENT);
            reportLog(assertTextVENT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}