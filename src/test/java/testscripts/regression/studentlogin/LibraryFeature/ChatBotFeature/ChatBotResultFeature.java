package testscripts.regression.studentlogin.LibraryFeature.ChatBotFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class ChatBotResultFeature extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ChatBotResultFeature.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1,dataProvider = "CK12DataProvider",description = "verify result after Asking Invalid question regarding module.")
    public void verifyChatBotPlaceHolder(String email, String password) {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver,extentTest,extentReports);
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver,extentTest,extentReports);

            webDriver.navigate().to("https://master.ck12.org/c/biology/photosynthesis-summary/lesson/Photosynthesis-Summary-BIO/?referrer=concept_details");

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, password);

            String assertTextVSPOG = "Student profile icon after logging in.";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVSPG = "Presence of 'Modality Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

            String assertTextVCNDD = "Presence of 'Open ChatBot' Button.";
            Assert.assertTrue(chatBotAutomationFeature.verifyOpenChatBotButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            chatBotAutomationFeature.clickOnOpenChatBotButton();

            String assertTextVAB = "Presence of 'ChatBot Title' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyChatBotTitleText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextAB = "Presence of 'ChatBot Input ' PlaceHolder.";
            Assert.assertTrue(chatBotAutomationFeature.verifyChatBotInputPlaceHolder(), assertFailurePreText + assertTextAB);
            reportLog(assertTextAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "verify result after Asking Invalid question regarding module.")
    public void verifyFunctionalityOfChatBotInputWithInvalidData() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver,extentTest,extentReports);

            String question = "ABC";

            chatBotAutomationFeature.setValueInChatBotPlaceHolder(question);
            chatBotAutomationFeature.pressEnterKey();

            String assertTextVAB = "Presence of 'Did Not Get This' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyDidNotGetThisText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVOAB = "Presence of 'Suggested Action' Text'";
            Assert.assertTrue(chatBotAutomationFeature.verifySuggestionActionText(), assertFailurePreText + assertTextVOAB);
            reportLog(assertTextVOAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Asked same Invalid question twice and verify result are same.")
    public void verifyFunctionalityOfChatBotInputWithInvalidDataAgain() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver,extentTest,extentReports);

            String question = "ABC";

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

            chatBotAutomationFeature.setValueInChatBotPlaceHolder(question);
            chatBotAutomationFeature.pressEnterKey();

            String assertTextVB = "Presence of 'Did Not Get This' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyDidNotGetThisText(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

            String assertTextVOAB = "Presence of 'Suggested Action' Text'";
            Assert.assertTrue(chatBotAutomationFeature.verifySuggestionActionText(), assertFailurePreText + assertTextVOAB);
            reportLog(assertTextVOAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "verify result after Asking valid question regarding module.")
    public void verifyFunctionalityOfChatBotInputWithValidData() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver,extentTest,extentReports);

            String question = "what is phoyosynthesis";

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

            chatBotAutomationFeature.setValueInChatBotPlaceHolder(question);
            chatBotAutomationFeature.pressEnterKey();

            String assertTextVB = "Presence of 'Valid Result' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyValidResultText(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Asked same valid question twice and verify result are same.")
    public void verifyFunctionalityOfChatBotInputWithValidDataAgain() {
        boolean result = true;
        try {
            ChatBotAutomationFeature chatBotAutomationFeature = new ChatBotAutomationFeature(webDriver,extentTest,extentReports);

            String question = "what is phoyosynthesis";

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

            chatBotAutomationFeature.setValueInChatBotPlaceHolder(question);
            chatBotAutomationFeature.pressEnterKey();

            String assertTextVB = "Presence of 'Valid Result' text.";
            Assert.assertTrue(chatBotAutomationFeature.verifyValidResultText(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}