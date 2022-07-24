package testscripts.regression.teacherlogin.DashBoardFeature.FeedbackFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.FeedbackFeature;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;

public class FeedbackFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(FeedbackFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";


    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify FeedBack Button is Available On Landing Page.")
    public void verifyFeedBackButton(String email, String password) {
        boolean result = true;
        try {
            FeedbackFeature feedbackFeature = new FeedbackFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'FeedBack' Icon";
            Assert.assertTrue(feedbackFeature.verifyFeedBackIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify FeedBack Button is Available On Landing Page.")
    public void verifyFunctionalityOfFeedBackButton() {
        boolean result = true;
        try {
            FeedbackFeature feedbackFeature = new FeedbackFeature(webDriver,extentTest,extentReports);

            feedbackFeature.clickOnFeedBackIcon();

            String assertTextVTPOG = "Presence Of 'How Can Improve' Text";
            Assert.assertTrue(feedbackFeature.verifyHowCanWeImproveText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Report' PlaceHolder";
            Assert.assertTrue(feedbackFeature.verifyReportPlaceHolder(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify UI Page Of Feedback Report.")
    public void verifyUIPageOfFeedBackReport() {
        boolean result = true;
        try {
            FeedbackFeature feedbackFeature = new FeedbackFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'Send Report' Button";
            Assert.assertTrue(feedbackFeature.verifySendReportButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Cancel Report' Button";
            Assert.assertTrue(feedbackFeature.verifyCancelReportButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Upload Image' Icon.";
            Assert.assertTrue(feedbackFeature.verifyUploadImageIcon(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Close Report ICon of Feedback Page.")
    public void verifyFunctionalityOfCloseReportIcon() {
        boolean result = true;
        try {
            FeedbackFeature feedbackFeature = new FeedbackFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'Close Report' Icon";
            Assert.assertTrue(feedbackFeature.verifyCloseReportIcon(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            feedbackFeature.clickOnCloseReportIcon();

            String assertTextVHI = "Presence Of 'FeedBack' Icon";
            Assert.assertTrue(feedbackFeature.verifyFeedBackIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            feedbackFeature.clickOnFeedBackIcon();

            String assertTextVSO = "Presence Of 'How Can Improve' Text";
            Assert.assertTrue(feedbackFeature.verifyHowCanWeImproveText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Cancel Report Button of Feedback Page.")
    public void verifyFunctionalityOfCancelReportButton() {
        boolean result = true;
        try {
            FeedbackFeature feedbackFeature = new FeedbackFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'Cancel Report' Icon";
            Assert.assertTrue(feedbackFeature.verifyCancelReportButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            feedbackFeature.clickOnCancelReportButton();

            String assertTextVHI = "Presence Of 'FeedBack' Icon";
            Assert.assertTrue(feedbackFeature.verifyFeedBackIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            feedbackFeature.clickOnFeedBackIcon();

            String assertTextVSO = "Presence Of 'How Can Improve' Text";
            Assert.assertTrue(feedbackFeature.verifyHowCanWeImproveText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Send Button Without giving VAlue In Report PlaceHolder.")
    public void verifyFunctionalityOfSendReportButton() {
        boolean result = true;
        try {
            FeedbackFeature feedbackFeature = new FeedbackFeature(webDriver,extentTest,extentReports);

            String assertTextVHI = "Presence Of 'Report' PlaceHolder";
            Assert.assertTrue(feedbackFeature.verifyReportPlaceHolder(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPOG = "Presence Of 'Send Report' Icon";
            Assert.assertTrue(feedbackFeature.verifySendReportButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            feedbackFeature.clickOnSendReportButton();

            String assertTextVSO = "Presence Of 'Report Error' Text";
            Assert.assertTrue(feedbackFeature.verifyReportErrorText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Send Button by giving Value In Report PlaceHolder.")
    public void verifyFunctionalityOfSendReportButtonWithValue() {
        boolean result = true;
        try {
            FeedbackFeature feedbackFeature = new FeedbackFeature(webDriver,extentTest,extentReports);

            String feedbackText = "Test Feedback";

            String assertTextVHI = "Presence Of 'Report' PlaceHolder";
            Assert.assertTrue(feedbackFeature.verifyReportPlaceHolder(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            feedbackFeature.enterFeedbackText(feedbackText);

            String assertTextVTPOG = "Presence Of 'Send Report' Icon";
            Assert.assertTrue(feedbackFeature.verifySendReportButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            feedbackFeature.clickOnSendReportButton();

            String assertTextVSO = "Presence Of 'Feedback Sent Success' text.";
            Assert.assertTrue(feedbackFeature.verifyReportSuccessText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 15, description = "Verify Functionality Of Delete Icon After Uploading Image.")
    public void verifyFunctionalityOfDeleteIcon() {
        boolean result = true;
        try {
            FeedbackFeature feedbackFeature = new FeedbackFeature(webDriver,extentTest,extentReports);

            String assertTextVSO = "Presence Of 'Delete' Icon.";
            Assert.assertTrue(feedbackFeature.verifyDeleteIcon(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            feedbackFeature.clickOnDeleteIcon();

            String assertTextVHI = "Presence Of 'Uploaded Image Are NotDisplay'";
            Assert.assertTrue(feedbackFeature.verifyUploadImageIsNotDisplay(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}