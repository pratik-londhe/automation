package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class BuilderModeHeader extends Base {

    public void exitBuilderMode(){
        String exitButton = "//div[@class='room-state-switch-button editing']";
        WebElement exitBuilderModeButton = waitForDisplayedAndEnabled(By.xpath(exitButton),"Exit Show Builder Mode");
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", exitBuilderModeButton);
        //exitBuilderModeButton.click();
        javascriptExecutorClick(exitBuilderModeButton);
        sleep(10);
    }

    public void validateExitButtonInShowBuilderMode(){
        String exitButton = "//div[@class='room-state-switch-button editing']";
        waitForDisplayedAndEnabled(By.xpath(exitButton),"Exit Show Builder Mode");
    }

    public void openSettingsTab(){
        String settingsTab = "(//div[@class='header-small-button'])[1]";
        WebElement settingsTabIcon = waitForDisplayedAndEnabled(By.xpath(settingsTab),"Settings in Builder Mode");
        if(!settingsTabIcon.getAttribute("class").contains("drawer-open")){
            settingsTabIcon.click();
        }
    }

    public void closeSettingsTab(){
        String close = "//div[@class='meta-share-tabs']//button[contains(@class,'transparent text')]";
        WebElement closeIcon = waitForDisplayedAndEnabled(By.xpath(close),"Settings in Builder Mode");
        closeIcon.click();
    }

    public void openInviteUsersTab(){
        String inviteUsersTab = "(//div[@class='header-small-button'])[2]";
        sleep(1);
        WebElement inviteUsersTabIcon = waitForDisplayedAndEnabled(By.xpath(inviteUsersTab),"Invite Users in Builder Mode");
        inviteUsersTabIcon.click();
    }

    public String copyInviteLink(){
        String copyLink = "//div[@class='share-link-controls']//button";
        WebElement copyLinkButton = waitForDisplayedAndEnabled(By.xpath(copyLink),"Invite Users in Builder Mode");
        log.info("Get the copied URL from the Clipboard...");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String copiedEventURL = null;

        try {
            copiedEventURL = (String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("The copied event link is"+copiedEventURL);
        return copiedEventURL;
    }

    public void invitePresenterFromBuilderMode(String emailId){
        sleep(2);
       // String typeEmail = "//form[@class='input-form']//input";
        String typeEmail = "//input[@placeholder='Type email...']";
        WebElement typeEmailInputField = waitForDisplayedAndEnabled(By.xpath(typeEmail),"Type email field in Builder Mode");
        typeEmailInputField.sendKeys(emailId);
        String sendInvite = "//button[@class='send-invite-button']";
        WebElement sendInviteButton = waitForDisplayedAndEnabled(By.xpath(sendInvite),"Send invite button in Builder Mode");
        sendInviteButton.click();
    }
}
