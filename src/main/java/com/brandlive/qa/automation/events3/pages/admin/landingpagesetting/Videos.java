package com.brandlive.qa.automation.events3.pages.admin.landingpagesetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Videos extends Base {

    private void clickOnVideoTab() {
        String video = "//div[text()='Videos']";
        WebElement videoTab = waitForDisplayedAndEnabled(By.xpath(video), "Video Tab");
        if (videoTab.isDisplayed()) {
            javascriptExecutorClick(videoTab);
            log.info("The Video Tab is displayed and clicked.");
        }
    }

    private void clickOnAddVideo() {
        String addVideo = "//div[@class='field-group large-button']//label[text()='Add Video']";
        WebElement addVideoButton = waitForDisplayedAndEnabled(By.xpath(addVideo), "Add Video button");
        if (addVideoButton.isDisplayed()) {
            javascriptExecutorClick(addVideoButton);
            log.info("The Add Video button is displayed and clicked.");
        }
    }

    public void selectVideo() {
        clickOnVideoTab();
        clickOnAddVideo();
        log.info("Select a Video...");
        String video = "(//div[@class='video-banner'])[1]";
        WebElement selectVideo = waitForDisplayedAndEnabled(By.xpath(video), "Video");
        selectVideo.click();
        log.info("Selected a video");

    }

    public boolean verifyAddedVideoOnAdmin() {
        String video = "//div[@class='video-poster']";
        if (elementPresent(By.xpath(video))) {
            log.info("Verified the added video on the admin side.");
            return true;
        }
        return false;
    }
}