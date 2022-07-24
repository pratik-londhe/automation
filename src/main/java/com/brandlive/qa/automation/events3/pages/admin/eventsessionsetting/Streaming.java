package com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Streaming extends Base {

    private void clickOnEdit() {
        String edit = "(//*[name()='svg' and @id='icon-edit'])[2]";
        WebElement editIcon = waitForDisplayedAndEnabled(By.xpath(edit), "edit icon on the setting page.");
        editIcon.click();
        log.info("Clicked on the edit icon.");
        sleep(3);
    }

    private void clickOnStreamsDropDown() {
        String streams = "(//*[name()='svg' and @id='icon-keyboard-arrow-down'])[2]";
        WebElement streamsDropDown = waitForDisplayedAndEnabled(By.xpath(streams), "Streams Down down.");
        streamsDropDown.click();
        log.info("Clicked on the edit icon.");
    }

    public void selectStreamingOptionForSession(String streamOption) {
        clickOnEdit();
        clickOnStreamsDropDown();
        String streamingOption = "//div[@class='video-selected-info']//label[text()='" + streamOption + "']";
        WebElement streamsDropDown = waitForDisplayedAndEnabled(By.xpath(streamingOption), "Streaming option.");
        if (streamsDropDown.isDisplayed()) {
            streamsDropDown.click();
            log.info("Clicked on the edit icon.");
        }
    }

    public void addVideoURL(String videoLink) {
        String videoURL = "//input[@placeholder='Enter video URL']";
        WebElement linkVideo = waitForDisplayedAndEnabled(By.xpath(videoURL), "Add video URL.");
        linkVideo.sendKeys(videoLink);
        log.info("Entered the Video link.");
        clickOnDoneButton();
    }

    private void clickOnDoneButton() {
        String done = "//button[@class='primary']";
        WebElement doneButton = waitForDisplayedAndEnabled(By.xpath(done), "Done button.");
        doneButton.click();
        log.info("Clicked on the Done button.");
    }

    public boolean verifyUploadedVideoLink(String videoURL) {
        String videoLink = "//div[@class='video-link']//p";
        WebElement uploadedVideoLink = waitForDisplayedAndEnabled(By.xpath(videoLink), "Video link");
        if (uploadedVideoLink.getText().equals(videoURL)) {
            log.info("The video link is uploaded successfully.");
            return true;
        }
        return false;
    }

    public void addVideoIframe(String vIframe) {
        String videoIframe = "//div[@class='video-embed-code']//textarea";
        WebElement iframeVideo = waitForDisplayedAndEnabled(By.xpath(videoIframe), "Add video iframe.");
        iframeVideo.sendKeys(vIframe);
        log.info("Entered the Video iframe.");
        clickOnDoneButton();
    }
}