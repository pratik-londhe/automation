package testscripts.regression.teacherlogin.ExploreFeature.CafeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CafeAskQuestionFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CafeAskQuestionFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of Follow Button On the Container Of Forum.")
    public void verifyFunctionalityOfFollowButton(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            String assertTextVSPOG = "Teacher profile icon after logging in.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Cafe' Container.";
            Assert.assertTrue(cafeFeature.verifyCafeLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeFeature.clickOnCafeLink();

            String assertTextVPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVSOG = "Presence of 'Continue' button.";
            Assert.assertTrue(cafeFeature.verifyForumContainerLink(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            cafeFeature.clickOnForumContainerLink();

            String assertTextVSPG = "Presence of 'Forum ' Name.";
            Assert.assertTrue(cafeFeature.verifyForumName(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

            String assertTextVPG = "Presence of 'Follow' button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowButton(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify 'Ask Question' button is Present On the Forum Page UI.")
    public void verifyAskQuestionButtonIsAvailable() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnFollowButton();

            String assertTextVSG = "Presence of 'Following ' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

            String assertTextVSPOG = "Presence of 'Ask Question' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyAskQuestionButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Ask Question' button.")
    public void verifyFunctionalityOfAskQuestionButton() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnAskQuestionButton();

            String assertTextVSG = "Presence of 'Close Question Container' Icon.";
            Assert.assertTrue(cafeForumUIFeature.verifyCloseQuestionContainerIcon(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

            cafeForumUIFeature.scrollTheScreen();

            String assertTextVEB = "Presence of 'Post' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyPostButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Close Question Container' Icon..")
    public void verifyFunctionalityOfCloseQuestionContainerIcon() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnCloseQuestionContainerIcon();

            String assertTextVSPOG = "Presence of 'Ask Question' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyAskQuestionButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.clickOnAskQuestionButton();

            String assertTextVSG = "Presence of 'Close Question Container' Icon.";
            Assert.assertTrue(cafeForumUIFeature.verifyCloseQuestionContainerIcon(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

            cafeForumUIFeature.scrollTheScreen();

            String assertTextVEB = "Presence of 'Post' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyPostButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality of 'Post' button without Question And Tag.")
    public void verifyFunctionalityOfPostButtonWithoutQuestionAndTag() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnPostButton();

            String assertTextVSPOG = "Presence of 'Write Your' Question.";
            Assert.assertTrue(cafeForumUIFeature.verifyWriteYourQuestionText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality of 'Post' button  without Question And with Tag.")
    public void verifyFunctionalityOfPostButtonWithoutQuestion() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            String assertTextVPOG = "Presence of 'Tag PlaceHolder'.";
            Assert.assertTrue(cafeForumUIFeature.verifyTagPlaceHolder(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            cafeForumUIFeature.setTextInTagPlaceHolder();

            String assertTextVEB = "Presence of 'Post' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyPostButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnPostButton();

            String assertTextVSPOG = "Presence of 'Write Your' Question.";
            Assert.assertTrue(cafeForumUIFeature.verifyWriteYourQuestionText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify User Can Asked Question Without following cafe.")
    public void verifyFunctionalityOfAskQuestionButtonWithoutFollowing() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            String assertTextVSG = "Presence of 'Close Question Container' Icon.";
            Assert.assertTrue(cafeForumUIFeature.verifyCloseQuestionContainerIcon(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

            cafeForumUIFeature.clickOnCloseQuestionContainerIcon();

            String assertTextVPOG = "Presence of 'Ask Question Button'.";
            Assert.assertTrue(cafeForumUIFeature.verifyAskQuestionButton(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            cafeForumUIFeature.scrollTheScreenAtTop();

            String assertTextVEB = "Presence of 'Following' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnFollowingButton();

            String assertTextVPG = "Presence of 'Follow' button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowButton(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

            String assertTextVSPOG = "Presence of 'Ask Question Button'.";
            Assert.assertTrue(cafeForumUIFeature.verifyAskQuestionButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.clickOnAskQuestionButton();

            String assertTextVSOG = "Presence of 'Close Question Container' Icon.";
            Assert.assertTrue(cafeForumUIFeature.verifyCloseQuestionContainerIcon(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}