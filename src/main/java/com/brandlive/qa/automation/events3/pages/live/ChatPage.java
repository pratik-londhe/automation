package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ChatPage extends Base {

    public boolean verifyProfileDetailsPopUpWindow() {
        String profileDetails = "//div[@class='modal normal']";
        String chat = "//textarea[@class='add-live-comment-textarea ']";
        WebElement chatTextArea = waitForDisplayedAndEnabled(By.xpath(chat), "Chat Test Area");
        chatTextArea.click();
        log.info("Clicked on the chat text area.");
        WebElement profileDetailsWindow = waitForDisplayedAndEnabled(By.xpath(profileDetails), "Profile details windows");
        if (profileDetailsWindow.isDisplayed()) {
            log.info("Profile details window is opened.");
            return true;
        }
        return false;
    }

    public boolean verifyChatMessage(String chatMsg, String moderationAction, boolean approved) {
        boolean result = false;
        String chatMessage = "//div[text()='" + chatMsg + "']";
        if (moderationAction.equals("OFF")) {
            if (elementPresent(By.xpath(chatMessage))) {
                log.info("The chat message is displayed.");
                result = true;
            } else {
                log.info("The chat message is not present.");
                return false;
            }

        } else if (moderationAction.equals("ON")) {
            if (!approved) {
                if (!elementPresent(By.xpath(chatMessage))) {
                    log.info("The chat message is not displayed.");
                    result = true;
                } else {
                    log.info("The chat message is present.");
                    return false;
                }
            } else {
                if (elementPresent(By.xpath(chatMessage))) {
                    log.info("The chat message is displayed after approved.");
                    result = true;
                } else {
                    log.info("The chat message is not displayed after approved.");
                    return false;
                }
            }
        }
        return result;
    }

    public void sendChatMessage(String chatMessage) {
        String chatTextArea = "//textarea[contains(@class,'add-live-comment-textarea')]";
        WebElement chatMsgTextArea = waitForDisplayedAndEnabled(By.xpath(chatTextArea), "Chat Test Area");
        chatMsgTextArea.sendKeys(chatMessage);
        log.info("Entered the chat Message.");
        chatMsgTextArea.sendKeys(Keys.ENTER);
        log.info("Pressed the enter.");
        sleep(3);
    }
}