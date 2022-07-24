package com.brandlive.qa.automation.events3.pages.admin.landingpagesetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Speakers extends Base {

    private void clickOnSpeakersTab() {
        String speakers = "//div[text()='Speakers']";
        WebElement speakersTab = waitForDisplayedAndEnabled(By.xpath(speakers), "Speakers Tab");
        if (speakersTab.isDisplayed()) {
            speakersTab.click();
            log.info("The Speakers Tab is displayed and clicked.");
        }
    }

    private void clickOnAddSpeaker() {
        String addSpeakers = "//div[@class='field-group large-button']//label[text()='Add Speaker']";
        WebElement addSpeakersButton = waitForDisplayedAndEnabled(By.xpath(addSpeakers), "Add Speakers button");
        if (addSpeakersButton.isDisplayed()) {
            javascriptExecutorClick(addSpeakersButton);
            log.info("The Add Speakers button is displayed and clicked.");
        }
    }

    public void selectSpeakers() {
        clickOnSpeakersTab();
        clickOnAddSpeaker();
        String speaker = "(//div[@class='add-speaker']//div)[1]";
        WebElement addSpeaker = waitForDisplayedAndEnabled(By.xpath(speaker), "Add Speakers");
        addSpeaker.click();
        log.info("Selected the speaker.");
    }

    public boolean verifyAddedSpeakerOnAdmin() {
        String speaker = "//li[@class='speakers-column']//img";
        if (elementPresent(By.xpath(speaker))) {
            log.info("Verified the added speaker on the admin side.");
            return true;
        }
        return false;
    }
}