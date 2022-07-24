package testscripts.regression.teacherlogin.ExploreFeature.CafeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CafeForumUIPageFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CafeForumUIPageFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Share' button is Present On the Forum Page UI.")
    public void verifyShareButtonIsPresent(String email, String password) {
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

            cafeForumUIFeature.clickOnFollowButton();

            String assertTextVSG = "Presence of 'Following ' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

            String assertTextVSL = "Presence of 'Share ' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifyShareLink(), assertFailurePreText + assertTextVSL);
            reportLog(assertTextVSL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Share' button.")
    public void verifyFunctionalityOfShareButton() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnShareLink();

            String assertTextVSPOG = "Presence of 'Share This Discussion ' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyShareThisDiscussionText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Send' button.";
            Assert.assertTrue(cafeForumUIFeature.verifySendButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Close Share' Icon.")
    public void verifyFunctionalityOfCloseShareIcon() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            String assertTextVEB = "Presence of 'Close Share' Icon.";
            Assert. assertTrue(cafeForumUIFeature.verifyCloseShareIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnCloseShareIcon();

            String assertTextVSG = "Presence of 'Following ' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

            String assertTextVSL = "Presence of 'Share ' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifyShareLink(), assertFailurePreText + assertTextVSL);
            reportLog(assertTextVSL);

            cafeForumUIFeature.clickOnShareLink();

            String assertTextVSPOG = "Presence of 'Share This Discussion ' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyShareThisDiscussionText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Send Button' Without Email.")
    public void verifyFunctionalityOfSendButtonWithoutEmail() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            String assertTextVEB = "Presence of 'Send' button.";
            Assert.assertTrue(cafeForumUIFeature.verifySendButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnSendButton();

            String assertTextVSOG = "Presence of 'Email Error' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyEmptyErrorText(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            cafeForumUIFeature.clickOnCloseShareIcon();

            String assertTextVSG = "Presence of 'Following ' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 9, description = "Verify User Can Share Forum with valid Email.")
    public void verifyFunctionalityOfSendButton() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Email' Place Holder.";
            Assert.assertTrue(cafeForumUIFeature.verifyEmailPlaceHolder(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.setTextInEmailPlaceHolder();

            String assertTextVEB = "Presence of 'Send' button.";
            Assert.assertTrue(cafeForumUIFeature.verifySendButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnSendButton();

            String assertTextVSOG = "Presence of 'Thanks' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyThanksText(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 11, description = "Verify Functionality Of Done Button")
    public void verifyFunctionalityOfDoneButton() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Done' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyDoneButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.clickOnDoneButton();

            String assertTextVSG = "Presence of 'Following ' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify 'Setting' button is Present On the Forum Page UI.")
    public void verifySettingLinkIsPresent() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Setting' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifySettingLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'setting' button After Following.")
    public void verifyFunctionalityOfSettingLink() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnSettingLink();

            String assertTextVEB = "Presence of 'Email Notification ' Text.";
           // Assert.assertTrue(cafeForumUIFeature.verifyEmailNotificationText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVSOG = "Presence of 'Thanks' text.";
            //Assert.assertTrue(cafeForumUIFeature.verifyBackButton(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of 'Back' button.")
    public void verifyFunctionalityOfBackButton() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnBackButton();

            String assertTextVSG = "Presence of 'Following ' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

            String assertTextVSPOG = "Presence of 'Setting' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifySettingLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify 'Followers' link is present on The Forum PAge.")
    public void verifyFollowersLinkIsPresent() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Followers' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowersLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify functionality of 'Followers' link.")
    public void verifyFunctionalityOfFollowersLink() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnFollowersLink();

//            String assertTextVSG = "Presence of 'Following ' Button.";
//            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
//            reportLog(assertTextVSG);

            String assertTextVSOG = "Presence of 'Thanks' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyBackButton(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality of 'Back' icon.")
    public void verifyFunctionalityOfBackButtonOnFollowersPage() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnBackButton();

            String assertTextVSG = "Presence of 'Following ' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
            reportLog(assertTextVSG);

            String assertTextVSOG = "Presence of 'Ask Question' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyAskQuestionButton(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify 'Invite A Friend' link is present on The Forum PAge.")
    public void verifyInviteFriendLinkIsPresent() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnFollowersLink();

//            String assertTextVSG = "Presence of 'Following ' Button.";
//            Assert.assertTrue(cafeForumUIFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSG);
//            reportLog(assertTextVSG);

            String assertTextVSOG = "Presence of 'Invite Friend Link'.";
            Assert.assertTrue(cafeForumUIFeature.verifyInviteFriendLink(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Functionality of 'Invite A Friend' link.")
    public void verifyFunctionalityOfInviteFriendLink() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature = new CafeForumUIFeature(webDriver, extentTest, extentReports);

            cafeForumUIFeature.clickOnInviteFriendLink();

            String assertTextVSPOG = "Presence of 'Share This Discussion ' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyShareThisDiscussionText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVEB = "Presence of 'Close Share' Icon.";
            Assert.assertTrue(cafeForumUIFeature.verifyCloseShareIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}