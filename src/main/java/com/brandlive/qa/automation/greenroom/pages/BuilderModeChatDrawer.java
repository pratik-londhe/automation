package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class BuilderModeChatDrawer extends Base {

    public void openChatDrawerInBuilderMode(){
        String chatDrawer = "//*[name()='svg' and @id='icon-chat-tab']";
        WebElement chatDrawerInBuilderMode = waitForDisplayedAndEnabled(By.xpath(chatDrawer),"Chat Drawer in Builder Mode");
        chatDrawerInBuilderMode.click();
    }

    public void openPresenterGroupChatInBuilderMode(){
        String presenterGroup = "(//*[name()='svg' and @id='icon-arrow-right'])[1]";
        WebElement presenterGroupChat = waitForDisplayedAndEnabled(By.xpath(presenterGroup),"Presenter group chat in Builder Mode");
        presenterGroupChat.click();
    }

    public void sendMsgInChat(String msg){
        String chatInput = "//span[@class='chat-input']";
        String sendMsg = "//*[name()='svg' and @id='icon-send']";
        WebElement chatInputField = waitForDisplayedAndEnabled(By.xpath(chatInput),"chat input field in Builder Mode");
        chatInputField.sendKeys(msg);
        sleep(2);
        WebElement sendMsgIcon = waitForDisplayedAndEnabled(By.xpath(sendMsg),"Send msg icon in Builder Mode");
        sendMsgIcon.click();
        sleep(1);
    }

    public void openDMChatInBuilderMode(){
        String dmChat = "(//*[name()='svg' and @id='icon-arrow-right'])[3]";
        WebElement dmChatField = waitForDisplayedAndEnabled(By.xpath(dmChat),"DM chat in Builder Mode");
        dmChatField.click();
    }

    public boolean validateChatNotificationOnChatDrawer(){
        String notification = "//span[contains(@class,'unseen-messages')]";
        return elementPresent(By.xpath(notification));
    }

    public boolean validateChatNotificationOnPresenterGroup(){
        String presenterGroupNotification = "(//span[@class='unseen margin-left-small'])[1]";
        return elementPresent(By.xpath(presenterGroupNotification));
    }

    public boolean validateChatNotificationOnPresenterDM(){
        String presenterDMNotification = "(//span[@class='unseen margin-left-small'])[2]";
        return elementPresent(By.xpath(presenterDMNotification));
    }

    public void closeChatMessagesWindow(){
        String backArrow = "//button[@class='chat-back-button']//*[name()='svg' and @id='icon-arrow-left']";
        WebElement chatMsgBackArrow = waitForDisplayedAndEnabled(By.xpath(backArrow),"Chat messages back arrow in Builder Mode");
        chatMsgBackArrow.click();
        sleep(1);
    }

    public void validateUnreadChatToastNotification() {
        String toastNotification = "//*[name()='svg' and @id='icon-close']";
        elementPresent(By.xpath(toastNotification));
    }

}
