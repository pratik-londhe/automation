package testscripts.regression.teacherlogin.ExploreFeature.CafeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CafeForumFeatureWithoutFollowingTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CafeForumFeatureWithoutFollowingTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, description = "Cafe Browse page can access before login")
    public void verifyUserCanBrowseCafePageBeforeLogin() {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);
            CafeFeature cafeFeature= new CafeFeature(webDriver,extentTest,extentReports);

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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Forum home page can access before login")
    public void verifyUserCanBrowseForumPageBeforeLogin() {
        boolean result = true;
        try {
            CafeFeature cafeFeature= new CafeFeature(webDriver,extentTest,extentReports);

            String assertTextVSOG = "Presence of 'Continue' button.";
            Assert.assertTrue(cafeFeature.verifyForumContainerLink(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            cafeFeature.clickOnForumContainerLink();

            String assertTextVAB = "Presence of 'Take The Tour' button.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVSPOG = "Presence of 'Skip The Tour ' button.";
            Assert.assertTrue(cafeFeature.verifySkippTourButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeFeature.clickOnSkippTourButton();

            String assertTextVSPG = "Presence of 'Forum ' Name.";
            Assert.assertTrue(cafeFeature.verifyForumName(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify User Can Share without Following Forum.")
    public void verifyFunctionalityOfShareButton() {
        boolean result = true;
        try {
            CafeFeature cafeFeature= new CafeFeature(webDriver,extentTest,extentReports);
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            cafeForumUIFeature.clickOnShareLink();

            String assertTextVSPOG = "Presence of 'Share This Discussion ' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyShareThisDiscussionText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Send' button.";
            Assert.assertTrue(cafeForumUIFeature.verifySendButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Close Share' Icon.";
            Assert.assertTrue(cafeForumUIFeature.verifyCloseShareIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnCloseShareIcon();

            String assertTextVSPG = "Presence of 'Forum ' Name.";
            Assert.assertTrue(cafeFeature.verifyForumName(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify User Can See Followers without Following Forum.")
    public void verifyFollowersArePresent() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            String assertTextVSPOG = "Presence of 'Followers' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifyFollowersLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.clickOnFollowersLink();

            String assertTextVSOG = "Presence of 'Thanks' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyBackButton(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify User Can Invite friend without Following Forum.")
    public void verifyInviteFriend() {
        boolean result = true;
        try {
            CafeFeature cafeFeature= new CafeFeature(webDriver,extentTest,extentReports);
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            String assertTextVSOG = "Presence of 'Invite Friend Link'.";
            Assert.assertTrue(cafeForumUIFeature.verifyInviteFriendLink(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            cafeForumUIFeature.clickOnInviteFriendLink();

            String assertTextVSPOG = "Presence of 'Share This Discussion ' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyShareThisDiscussionText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVEB = "Presence of 'Close Share' Icon.";
            Assert.assertTrue(cafeForumUIFeature.verifyCloseShareIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnCloseShareIcon();

            String assertTextVCNDD = "Presence of 'Thanks' text.";
            Assert.assertTrue(cafeForumUIFeature.verifyBackButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            cafeForumUIFeature.clickOnBackButton();

            String assertTextVSPG = "Presence of 'Forum ' Name.";
            Assert.assertTrue(cafeFeature.verifyForumName(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'setting' button Without Following.")
    public void verifyFunctionalityOfSettingButton() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            String assertTextVSPOG = "Presence of 'Setting' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifySettingLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.clickOnSettingLink();

            String assertTextVSOG = "Presence of 'Want To Follow TExt'.";
            Assert.assertTrue(cafeForumUIFeature.verifyWantToFollowText(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of 'Don't Follow' button.")
    public void verifyFunctionalityOfDoNotFollowButton() {
        boolean result = true;
        try {
            CafeFeature cafeFeature= new CafeFeature(webDriver,extentTest,extentReports);
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            String assertTextVEB = "Presence of 'Do Not Follow' Button.";
            Assert.assertTrue(cafeForumUIFeature.verifyDoNotFollowButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnDoNotFollowButton();

            String assertTextVSPG = "Presence of 'Forum ' Name.";
            Assert.assertTrue(cafeFeature.verifyForumName(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

            String assertTextVSPOG = "Presence of 'Setting' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifySettingLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.clickOnSettingLink();

            String assertTextVSOG = "Presence of 'Want To Follow TExt'.";
            Assert.assertTrue(cafeForumUIFeature.verifyWantToFollowText(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'Browse Discussion' Link.")
    public void verifyFunctionalityOfBrowseDiscussionLink() {
        boolean result = true;
        try {
            CafeFeature cafeFeature= new CafeFeature(webDriver,extentTest,extentReports);
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            String assertTextVEB = "Presence of 'Browse Discussion Link'.";
            Assert.assertTrue(cafeForumUIFeature.verifyBrowseDiscussionLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnBrowseDiscussionLink();

            String assertTextVSPG = "Presence of 'Forum ' Name.";
            Assert.assertTrue(cafeFeature.verifyForumName(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

            String assertTextVSPOG = "Presence of 'Setting' Link.";
            Assert.assertTrue(cafeForumUIFeature.verifySettingLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeForumUIFeature.clickOnSettingLink();

            String assertTextVSOG = "Presence of 'Want To Follow TExt'.";
            Assert.assertTrue(cafeForumUIFeature.verifyWantToFollowText(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of 'Yes Follow' Button.")
    public void verifyFunctionalityOfYesFollowLink() {
        boolean result = true;
        try {
            CafeForumUIFeature cafeForumUIFeature= new CafeForumUIFeature(webDriver,extentTest,extentReports);

            String email="teacher+testuser@ck12.org";
            String pass = "Pratik123";

            String assertTextVEB = "Presence of 'YEs Follow Button'.";
            Assert.assertTrue(cafeForumUIFeature.verifyYesFollowButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeForumUIFeature.clickOnYesFollowButton();

            new LoginPage(webDriver,extentTest, extentReports).login(email, pass);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}