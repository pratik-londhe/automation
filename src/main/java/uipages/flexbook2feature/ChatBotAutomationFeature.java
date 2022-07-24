package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.GuiControl;

/**
 * Created by basidali.mahimkar on 10/4/2019.
 */
public class ChatBotAutomationFeature extends PageMenuTab {

    private final GuiControl btnOpenChatBot = new GuiControl(getElementMap().get("btnOpenChatBot"), webDriver);
    private final GuiControl textAskMeAnything = new GuiControl(getElementMap().get("textAskMeAnything"), webDriver);
    private final GuiControl textModalityTitle = new GuiControl(getElementMap().get("textModalityTitle"), webDriver);
    private final GuiControl textChatBotTitle = new GuiControl(getElementMap().get("textChatBotTitle"), webDriver);
    private final GuiControl iconCloseChatBot = new GuiControl(getElementMap().get("iconCloseChatBot"), webDriver);
    private final GuiControl linkWatchVideo = new GuiControl(getElementMap().get("linkWatchVideo"), webDriver);
    private final GuiControl textSuggestedActions = new GuiControl(getElementMap().get("textSuggestedActions"), webDriver);
    private final GuiControl linkTakeAQuiz = new GuiControl(getElementMap().get("linkTakeAQuiz"), webDriver);
    private final GuiControl linkTryInteractive = new GuiControl(getElementMap().get("linkTryInteractive"), webDriver);
    private final GuiControl textWatchAVideo = new GuiControl(getElementMap().get("textWatchAVideo"), webDriver);
    private final GuiControl linkPractice = new GuiControl(getElementMap().get("linkPractice"), webDriver);
    private final GuiControl placeHolderChatBotInput = new GuiControl(getElementMap().get("placeHolderChatBotInput"), webDriver);
    private final GuiControl textDidNotGet = new GuiControl(getElementMap().get("textDidNotGet"), webDriver);
    private final GuiControl textValidResult = new GuiControl(getElementMap().get("textValidResult"), webDriver);

    public ChatBotAutomationFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyOpenChatBotButton() {
        waitForSec(5);
        return btnOpenChatBot.isElementPresent();
    }

    public boolean verifyChatBotInputPlaceHolder() {
        return placeHolderChatBotInput.isElementPresent();
    }

    public boolean verifyDidNotGetThisText() {
        waitForSec(5);
        return textDidNotGet.isElementPresent();
    }

    public boolean verifyValidResultText() {
        waitForSec(5);
        return textValidResult.isElementPresent();
    }

    public void setValueInChatBotPlaceHolder(String ques) {
        if (placeHolderChatBotInput.isElementPresent()) {
            placeHolderChatBotInput.setText(ques);
            reportLog("Successfully Enter value in ChatBot Input PlaceHolder");
        }
    }

    public void pressEnterKey() {
        placeHolderChatBotInput.sendKeys(String.valueOf(Keys.ENTER));
        reportLog("Successfully Clicked on Enter Button.");
    }

    public void clickOnOpenChatBotButton() {
        if (btnOpenChatBot.isElementPresent()) {
            btnOpenChatBot.clickJScript();
            reportLog("Successfully clicked On Open ChatBot Button");
        }
    }

    public boolean verifyAskMeAnythingTextIsRandorOnOpenChatBotButton() {
        return textAskMeAnything.isElementPresent();
    }

    public boolean verifyModalityTitleText() {
        waitForSec(5);
        return textModalityTitle.isElementPresent();
    }

    public boolean verifyChatBotTitleText() {
        waitForSec(5);
        return textChatBotTitle.isElementPresent();
    }

    public boolean verifyCloseChatBotIcon() {
        return iconCloseChatBot.isElementPresent();
    }

    public void clickOnCloseChatBotIcon() {
        if (iconCloseChatBot.isElementPresent()) {
            iconCloseChatBot.clickJScript();
            reportLog("Successfully clicked On Close ChatBot icon");
        }
    }

    public boolean verifySuggestionActionText() {
        return textSuggestedActions.isElementPresent();
    }

    public boolean verifySuggestionActionTextIsNotPresent() {
        return ! textSuggestedActions.isElementPresent();
    }

    public boolean verifyWatchVideoLink() {
        return linkWatchVideo.isElementPresent();
    }

    public void clickOnWatchVideoLink() {
        if (linkWatchVideo.isElementPresent()) {
            linkWatchVideo.clickJScript();
            reportLog("Successfully clicked On Watch Video Link");
        }
    }

    public boolean verifyTakeQuizLink() {
        return linkTakeAQuiz.isElementPresent();
    }

    public void clickOnTakeQuizLink() {
        if (linkTakeAQuiz.isElementPresent()) {
            linkTakeAQuiz.clickJScript();
            reportLog("Successfully clicked On Take Quiz Link");
        }
    }

    public boolean verifyTryInteractiveLink() {
        return linkTryInteractive.isElementPresent();
    }

    public void clickOnTryInteractiveLink() {
        if (linkTryInteractive.isElementPresent()) {
            linkTryInteractive.clickJScript();
            reportLog("Successfully clicked On Try Interactive Link");
        }
    }

    public boolean verifyWatchAVideoText() {
        waitForSec(5);
        return textWatchAVideo.isElementPresent();
    }

    public boolean verifyPracticeLink() {
        waitForSec(5);
        return linkPractice.isElementPresent();
    }
}
