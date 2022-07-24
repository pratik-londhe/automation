package com.brandlive.qa.automation.events3.pages.admin.moderatorsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Moderator extends Base {

    public void closeModeratorAutoSignInPopUP() {
        String autoSignPopUP = "//a[@class='clear-alert']";
        WebElement moderatorAutoSignPopUP = waitForDisplayedAndEnabled(By.xpath(autoSignPopUP), "Moderator auto sign pop up.");
        moderatorAutoSignPopUP.click();
        sleep(2);
    }

    public void clickOnAddButton() {
        closeModeratorAutoSignInPopUP();
        String add = "//*[name()='svg' and @id='icon-add']";
        WebElement addButton = waitForDisplayedAndEnabled(By.xpath(add), "Add button of Announcement.");
        addButton.click();
        log.info("Clicked on the Add button of announcement.");
        sleep(3);
    }

    public void clickOnAddAnnouncementButton() {
        String addAnnouncement = "//button[@class='clear sharp btn-left-align']";
        WebElement addAnnouncementButton = waitForDisplayedAndEnabled(By.xpath(addAnnouncement), "Add Announcement button.");
        javascriptExecutorClick(addAnnouncementButton);
        log.info("Clicked on the Add announcement button.");
    }

    public void clickOnModeratorButton() {
        String moderator = "//a[@class='theme-btn primary']";
        WebElement moderatorButton = waitForDisplayedAndEnabled(By.xpath(moderator), "Moderator Button.");
        moderatorButton.click();
        log.info("Clicked on the Moderator button.");
        sleep(5);
    }

    public void clickOnDetailsLink() {
        String details = "//button[@class='footer-link no-style']";
        WebElement detailsLink = waitForDisplayedAndEnabled(By.xpath(details), "Details link.");
        detailsLink.click();
        log.info("Clicked on the details link.");
    }

    public boolean verifyMessage(String message) {
        String chatMsg = "//p[text()='" + message + "']";
        WebElement chatQuesMessage = waitForDisplayedAndEnabled(By.xpath(chatMsg), "Chat and Question Message.");
        if (chatQuesMessage.isDisplayed()) {
            log.info("Verified the chat and question message.");
            return true;
        }
        return false;
    }

    public void approveChatMessage(String chatMessage) {
        String chatMsg = "//p[text()='" + chatMessage + "']";
        String approve = "//button[@aria-label='Approve']";
        mouseHoverAction(webDriver.findElement(By.xpath(chatMsg)));
        WebElement approveIcon = waitForDisplayedAndEnabled(By.xpath(approve), "Chat Approve Icon.");
        approveIcon.click();
        log.info("Chat Approve Icon.");
    }

    public boolean verifyApproveIcon(String message, String moderationAction) {
        boolean result = false;
        String chatMsg = "//p[text()='" + message + "']";
        String approve = "//button[@aria-label='Approve']";
        if (moderationAction.equals("ON")) {
            mouseHoverAction(webDriver.findElement(By.xpath(chatMsg)));
            if (elementPresent(By.xpath(approve))) {
                log.info("Approve Icon is displayed when Moderation is ON.");
                result = true;
            } else {
                log.info("Approve Icon is not displayed when Moderation is ON.");
                return false;
            }
        } else if (moderationAction.equals("OFF")) {
            mouseHoverAction(webDriver.findElement(By.xpath(chatMsg)));
            if (!elementPresent(By.xpath(approve))) {
                log.info("Approve Icon is not displayed when Moderation is OFF.");
                result = true;
            } else {
                log.info("Approve Icon is displayed when Moderation is OFF.");
                return false;
            }
        }
        return result;
    }

    public void clickOnEditEventButton() {
        String editEvent = "//button[@class='small primary']";
        WebElement editEventButton = waitForDisplayedAndEnabled(By.xpath(editEvent), "Edit Event Button.");
        editEventButton.click();
        log.info("Clicked on te Edit event button.");
        sleep(5);
    }
}