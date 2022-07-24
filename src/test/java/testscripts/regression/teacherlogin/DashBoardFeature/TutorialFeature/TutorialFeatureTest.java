package testscripts.regression.teacherlogin.DashBoardFeature.TutorialFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.flexbook2feature.TutorialFeature;

public class TutorialFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TutorialFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Tutorial' Icon With content Container Is Display.")
    public void verifyTutorialIconIsDisplayWithContentContainer(String email, String password) {
        boolean result = true;
        try {
            String url = "https://master.ck12.org/my/dashboard-new/";

            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            webDriver.navigate().to(url);

            String assertTextVHI = "Presence Of 'Tutorial' Icon";
            Assert.assertTrue(tutorialFeature.verifyTutorialIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            /*String assertTextVI = "Presence Of 'Active Content' Bar";
            Assert.assertTrue(tutorialFeature.verifyActiveContentBar(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Tutorial' Icon When content Container Is Selected.")
    public void verifyFunctionalityOfTutorialIconWithContentContainer() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            tutorialFeature.clickOnTutorialIcon();

            String assertTextVTPOG = "Presence Of 'Learn More About DashBoard' Text";
            Assert.assertTrue(tutorialFeature.verifyLearnMoreAboutDashBoardText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Take The Tour' Button";
            Assert.assertTrue(tutorialFeature.verifyTakeTheTourButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVI = "Presence Of 'Later' Button";
            Assert.assertTrue(tutorialFeature.verifyLaterButton(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Later Button.")
    public void verifyFunctionalityOfLaterButton() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            tutorialFeature.clickOnLaterButton();

            String assertTextVTPOG = "Presence Of 'YouCanAlwaysReopen' Text";
            Assert.assertTrue(tutorialFeature.verifyYouCanAlwaysReopenText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Ok Later' Button";
            Assert.assertTrue(tutorialFeature.verifyOkLaterButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            tutorialFeature.clickOnOkLaterButton();

            String assertTextVI = "Presence Of 'Tutorial' Icon";
            Assert.assertTrue(tutorialFeature.verifyTutorialIcon(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Take The Tour Button.")
    public void verifyFunctionalityOfTakeTheTourButton() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            tutorialFeature.clickOnTutorialIcon();

            String assertTextVTPOG = "Presence Of 'Learn More About DashBoard' Text";
            Assert.assertTrue(tutorialFeature.verifyLearnMoreAboutDashBoardText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Take The Tour' Button";
            Assert.assertTrue(tutorialFeature.verifyTakeTheTourButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            tutorialFeature.clickOnTakeTheTourButton();

            String assertTextVI = "Presence Of 'All Content In One Location' Text";
            Assert.assertTrue(tutorialFeature.verifyAllContentInOneLocationText(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Ok Got It Button With Content Active Bar.")
    public void verifyFunctionalityOfOkGotItButton() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of Ok Got It' Button";
            Assert.assertTrue(tutorialFeature.verifyOkGotItButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            tutorialFeature.clickOnOkGotItButton();

            String assertTextVI = "Presence Of 'Tutorial' Icon";
            Assert.assertTrue(tutorialFeature.verifyTutorialIcon(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 11, description = "Verify 'Tutorial' Icon With 'Classes' Container Is Display.")
    public void verifyTutorialIconIsDisplayWithClassesContainer() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            String url = "https://master.ck12.org/my/dashboard-new/groups/";

            webDriver.navigate().to(url);

            String assertTextVTPOG = "Presence Of 'Active Classes Bar' Button";
            Assert.assertTrue(tutorialFeature.verifyActiveClassesBar(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVI = "Presence Of 'Tutorial' Icon";
            Assert.assertTrue(tutorialFeature.verifyTutorialIcon(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 13, description = "Verify Functionality Of Tutorial button with Classes Container.")
    public void verifyFunctionalityOfTutorialIconWithClassesContainer() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            tutorialFeature.clickOnTutorialIcon();

            String assertTextVTPOG = "Presence Of 'Learn More About DashBoard' Text";
            Assert.assertTrue(tutorialFeature.verifyLearnMoreAboutDashBoardText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Take The Tour' Button";
            Assert.assertTrue(tutorialFeature.verifyTakeTheTourButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVI = "Presence Of 'Later' Button";
            Assert.assertTrue(tutorialFeature.verifyLaterButton(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            tutorialFeature.clickOnTakeTheTourButton();

            String assertTextVPOG = "Presence Of 'Student Progress' Text";
            Assert.assertTrue(tutorialFeature.verifyStudentProgressText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 15, description = "Verify Functionality Of 'Ok Got It' Button and verify it redirects to demo class example page.")
    public void verifyFunctionalityOfOkGotItButtonWithClassesContainer() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of Ok Got It' Button";
            Assert.assertTrue(tutorialFeature.verifyOkGotItButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            tutorialFeature.clickOnOkGotItButton();

            String assertTextVHI = "Presence Of 'Demo Class' Text";
            Assert.assertTrue(tutorialFeature.verifyDemoClassText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVI = "Presence Of 'Close' Icon";
            Assert.assertTrue(tutorialFeature.verifyCloseIcon(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 17, description = "Verify Functionality Of Close Tutorial Button.")
    public void verifyFunctionalityOfCloseDemoIcon() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            tutorialFeature.clickOnCloseIcon();

            String assertTextVI = "Presence Of 'Tutorial' Icon";
            Assert.assertTrue(tutorialFeature.verifyTutorialIcon(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            tutorialFeature.clickOnTutorialIcon();

            String assertTextVTPOG = "Presence Of 'Learn More About DashBoard' Text";
            Assert.assertTrue(tutorialFeature.verifyLearnMoreAboutDashBoardText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Take The Tour' Button";
            Assert.assertTrue(tutorialFeature.verifyTakeTheTourButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            tutorialFeature.clickOnTakeTheTourButton();

            String assertTextVPOG = "Presence Of 'Student Progress' Text";
            Assert.assertTrue(tutorialFeature.verifyStudentProgressText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVTPG = "Presence Of Ok Got It' Button";
            Assert.assertTrue(tutorialFeature.verifyOkGotItButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            tutorialFeature.clickOnOkGotItButton();

            String assertTextVH = "Presence Of 'Demo Class' Text";
            Assert.assertTrue(tutorialFeature.verifyDemoClassText(), assertFailurePreText + assertTextVH);
            reportLog(assertTextVH);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 19, description = " Verify Functionality Of 'Ok' button. ")
    public void verifyFunctionalityOfOkButton() {
        boolean result = true;
        try {
            TutorialFeature tutorialFeature = new TutorialFeature(webDriver,extentTest,extentReports);

            String assertTextVI = "Presence Of 'Do Not Worry' Text";
            Assert.assertTrue(tutorialFeature.verifyDoNotWorryText(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            String assertTextVHI = "Presence Of 'Ok' Button";
            Assert.assertTrue(tutorialFeature.verifyOkButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            tutorialFeature.clickOnOkButton();

            String assertTextVTPG = "Presence Of 'Ok' Button";
            Assert.assertTrue(tutorialFeature.verifyOkButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}