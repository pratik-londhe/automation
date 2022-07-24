package com.brandlive.qa.automation.events3.pages.admin.moderatorsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddAnnouncement extends Base {

    private void addAnnouncementMessage(String aMessage) {
        String announcementMsg = "//textarea[@placeholder='Your message here...']";
        WebElement announcementMessage = waitForDisplayedAndEnabled(By.xpath(announcementMsg), "Announcement message.");
        announcementMessage.sendKeys(aMessage);
        log.info("Entered the announcement message.");
    }

    public void addAnnouncement(String announcementTO, String aMessage) {
        String announcementOption = "//label[text()='" + announcementTO + "']";
        String send = "//button[@class='button save primary']";
        WebElement announcementOptionTO = waitForDisplayedAndEnabled(By.xpath(announcementOption), "Announcement option.");
        WebElement sendButton = waitForDisplayedAndEnabled(By.xpath(send), "Send button.");
        if (announcementTO.equals("To whole event")) {
            announcementOptionTO.click();
            log.info("Clicked on the announcement radio option: " + announcementTO);
            addAnnouncementMessage(aMessage);
            sendButton.click();
            log.info("Clicked on the Send button.");
        } else if (announcementTO.equals("To sessions")) {
            announcementOptionTO.click();
            log.info("Clicked on the announcement radio option: " + announcementTO);
            addAnnouncementMessage(aMessage);
            sendButton.click();
            log.info("Clicked on the Send button.");
        }
        sleep(3);
    }
}