package com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Speakers extends Base {

    private void clickOnAddSpeakers() {
        String addSpeakers = "//div[@class='field-group large-button']//label[text()='Add Speakers']";
        WebElement addSpeakersButton = waitForDisplayedAndEnabled(By.xpath(addSpeakers), "Add Speakers");
        javascriptExecutorClick(addSpeakersButton);
        log.info("Clicked on the Add Speakers on the session page.");
    }

    public void selectSpeakers() {
        clickOnAddSpeakers();
        String speaker = "(//div[@class='add-speaker']//div)[1]";
        WebElement addSpeaker = waitForDisplayedAndEnabled(By.xpath(speaker), "Add Speakers");
        addSpeaker.click();
        log.info("Selected the speaker on the Session page.");
    }

    public boolean verifyAddedSpeakerOnAdmin() {
        String speakers = "//div[@class='speakers-list']//img";
        if (elementPresent(By.xpath(speakers))) {
            log.info("Verified the added speakers on the admin side.");
            return true;
        }
        return false;
    }
}