package testscripts.regression.studentlogin.LibraryFeature.ChatBotFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

/**
 * Created by basidali.mahimkar on 10/4/2019.
 */

public class ChatBotAutomation extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ChatBotAutomation.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, description = "Verify User Can access chatBot Feature Before login.")
    public void verifyOpenChatBotButtonBeforeLogin() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            webDriver.navigate().to("https://master.ck12.org/c/biology/photosynthesis-summary/lesson/Photosynthesis-Summary-BIO/?referrer=concept_details");

            String assertTextVSPOG = "Presence of 'Modality Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Open ChatBot' Button.";
            Assert.assertTrue(chatBotAutomationFeature.verifyOpenChatBotButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, dataProvider = "CK12DataProvider", description = "Verify open ChatBot button is display on the modality details page.")
    public void verifyOpenChatBotButtonAfterLogin(String email, String password) {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver, extentTest, extentReports);
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).studentLogin(email, password);

            String assertTextVSPOG = "Student profile icon after logging in.";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Open ChatBot' Button.";
            Assert.assertTrue(chatBotAutomationFeature.verifyOpenChatBotButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Ask me Anything test is randing on Open ChatBot Button.")
    public void verifyAskMeEveryThingTextIsRanding() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            String assertTextVEB = "Presence of 'Ask Me Everything ' Text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyAskMeAnythingTextIsRandorOnOpenChatBotButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify functionality of open ChatBot button.")
    public void verifyFunctionalityOfOpenChatBotButton() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            chatBotAutomationFeature.clickOnOpenChatBotButton();

            String assertTextVAB = "Presence of 'ChatBot Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyChatBotTitleText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVOAB = "Presence of 'Close ChatBot ' icon'";
            Assert.assertTrue(chatBotAutomationFeature.verifyCloseChatBotIcon(), assertFailurePreText + assertTextVOAB);
            reportLog(assertTextVOAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify functionality of Close ChatBot Icon.")
    public void verifyFunctionalityOfCloseChatBotICon() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            chatBotAutomationFeature.clickOnCloseChatBotIcon();

            String assertTextVCNDD = "Presence of 'Open ChatBot' Button.";
            Assert.assertTrue(chatBotAutomationFeature.verifyOpenChatBotButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            chatBotAutomationFeature.clickOnOpenChatBotButton();

            String assertTextVAB = "Presence of 'ChatBot Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyChatBotTitleText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Suggested Actions Link Are Present.")
    public void verifySuggestedLinksArePresent() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            chatBotAutomationFeature.clickOnCloseChatBotIcon();

            String assertTextVCNDD = "Presence of 'Open ChatBot' Button.";
            Assert.assertTrue(chatBotAutomationFeature.verifyOpenChatBotButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            chatBotAutomationFeature.clickOnOpenChatBotButton();

            String assertTextVAB = "Presence of 'ChatBot Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyChatBotTitleText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVOAB = "Presence of 'Suggested Action' Text'";
            Assert.assertTrue(chatBotAutomationFeature.verifySuggestionActionText(), assertFailurePreText + assertTextVOAB);
            reportLog(assertTextVOAB);

            String assertTextVFBL = "Presence of 'Try Interactive' link.";
            Assert.assertTrue(chatBotAutomationFeature.verifyTryInteractiveLink(), assertFailurePreText + assertTextVFBL);
            reportLog(assertTextVFBL);

            String assertTextVACDD = "Presence of 'TAke a Quiz' link.";
            Assert.assertTrue(chatBotAutomationFeature.verifyTakeQuizLink(), assertFailurePreText + assertTextVACDD);
            reportLog(assertTextVACDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Suggested Action 'Watch A Video' link.")
    public void verifyFunctionalityOfWatchAVideoLink() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Watch Video' link.";
            Assert.assertTrue(chatBotAutomationFeature.verifyWatchVideoLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            chatBotAutomationFeature.clickOnWatchVideoLink();

            String assertTextVAB = "Presence of 'Watch A Video' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyWatchAVideoText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Suggested Action 'Take Quiz' link.")
    public void verifyFunctionalityOfTAkeAQuizLink() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            chatBotAutomationFeature.clickOnCloseChatBotIcon();

            String assertTextVCNDD = "Presence of 'Open ChatBot' Button.";
            Assert.assertTrue(chatBotAutomationFeature.verifyOpenChatBotButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            webDriver.navigate().refresh();

            String assertTextVSPOG = "Presence of 'Modality Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            chatBotAutomationFeature.clickOnOpenChatBotButton();

            String assertTextVAB = "Presence of 'ChatBot Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyChatBotTitleText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVACDD = "Presence of 'TAke a Quiz' link.";
            Assert.assertTrue(chatBotAutomationFeature.verifyTakeQuizLink(), assertFailurePreText + assertTextVACDD);
            reportLog(assertTextVACDD);

            chatBotAutomationFeature.clickOnTakeQuizLink();

            String assertTextVOAB = "Presence of 'Practice' link'";
            Assert.assertTrue(chatBotAutomationFeature.verifyPracticeLink(), assertFailurePreText + assertTextVOAB);
            reportLog(assertTextVOAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Suggested Action 'Try Interactive' link")
    public void verifyFunctionalityOfTryInteractiveLink() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            chatBotAutomationFeature.clickOnCloseChatBotIcon();

            String assertTextVCNDD = "Presence of 'Open ChatBot' Button.";
            Assert.assertTrue(chatBotAutomationFeature.verifyOpenChatBotButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            webDriver.navigate().refresh();

            String assertTextVSPOG = "Presence of 'Modality Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            chatBotAutomationFeature.clickOnOpenChatBotButton();

            String assertTextVAB = "Presence of 'ChatBot Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyChatBotTitleText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVFBL = "Presence of 'Try Interactive' link.";
            Assert.assertTrue(chatBotAutomationFeature.verifyTryInteractiveLink(), assertFailurePreText + assertTextVFBL);
            reportLog(assertTextVFBL);

            chatBotAutomationFeature.clickOnTryInteractiveLink();

            String assertTextVOAB = "Presence of 'Practice' link'";
            Assert.assertTrue(chatBotAutomationFeature.verifyPracticeLink(), assertFailurePreText + assertTextVOAB);
            reportLog(assertTextVOAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify suggested action option didnt comes after using suggested action.")
    public void verifyFunctionalityOfSuggestedActionIsNotPresent() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Not Presence of 'Suggested Action ' Text.";
            Assert.assertTrue(chatBotAutomationFeature.verifySuggestionActionTextIsNotPresent(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}