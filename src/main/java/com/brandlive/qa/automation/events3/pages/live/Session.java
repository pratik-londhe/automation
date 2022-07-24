package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Session extends Base {

    public void verifyAndPauseVideoStreamingForOD() {
        log.info("Verify the Video streaming details.");
        String pauseButton = "//button[@title='Pause (k)']";
        String progressBar = "//div[@class='ytp-progress-bar-padding']";
        switchToFrameByFrameId("widget2");
        mouseHoverAction(webDriver.findElement(By.xpath(progressBar)));
        sleep();
        log.info("Verify the Video Pause.");
        WebElement pauseButtonOnLiveEventPage = waitForDisplayedAndEnabled(By.xpath(pauseButton), "Pause button on event live page");
        pauseButtonOnLiveEventPage.click();
    }

    public void verifyAndPlayVideoStreamingForOD() {
        log.info("Verify the Video streaming details.");
        String playButton = "//button[@class='ytp-play-button ytp-button']";
        String progressBar = "//div[@class='ytp-progress-bar-padding']";
        mouseHoverAction(webDriver.findElement(By.xpath(progressBar)));
        sleep(3);
        log.info("Verify the Video Pause.");
        WebElement playButtonOnLiveEventPage = waitForDisplayedAndEnabled(By.xpath(playButton), "Play button on event live page");
        playButtonOnLiveEventPage.click();
    }

    public boolean verifyODVideoStreamingIsPlayedByTimer() {
        log.info("Checking video duration on event live");
        String videoDuration = "//span[@class='ytp-time-current']";
        String progressBar = "//div[@class='ytp-progress-bar-padding']";
        mouseHoverAction(webDriver.findElement(By.xpath(progressBar)));
        sleep();
        WebElement videoDurationOnLiveEventPage = waitForDisplayedAndEnabled(By.xpath(videoDuration), "Play button on event live page");
        int playTime = Integer.parseInt(videoDurationOnLiveEventPage.getText().split(":")[1]);
        if (playTime > 0) {
            log.info("The video is played.");
            switchOutFromFrame();
            return true;
        }
        return false;
    }

    public boolean verifySimilarSessionOnSessionPage() {
        String similarSession = "//div[@class='agenda-session-card-image']";
        WebElement similarSessionOnSessionPage = waitForDisplayedAndEnabled(By.xpath(similarSession), "Similar Session on landing page.");
        scrollIntoElement(similarSessionOnSessionPage);
        if (similarSessionOnSessionPage.isDisplayed()) {
            log.info("The Similar Session is present on the Session page.");
            return true;
        }
        return false;
    }

    public void clickOnPollsTab() {
        String polls = "//span[text()='Polls']";
        WebElement pollsTab = waitForDisplayedAndEnabled(By.xpath(polls), "Polls tab on session page.");
        javascriptExecutorClick(pollsTab);
        log.info("Clicked on the Polls tab.");
    }

    public void clickOnDocumentsTab() {
        String documents = "//span[text()='Documents']";
        WebElement documentsTab = waitForDisplayedAndEnabled(By.xpath(documents), "Documents tab on session page.");
        javascriptExecutorClick(documentsTab);
        log.info("Clicked on the documents tab.");
    }

    public void verifyAndPlayVideoIframeStreamingForOD() {
        switchToFrameByIndex(0);
        log.info("Verify the Video streaming details.");
        String playButton = "//button[@class='ytp-large-play-button ytp-button']";
        log.info("Verify the Video Play.");
        WebElement playButtonOnLiveEventPage = waitForDisplayedAndEnabled(By.xpath(playButton), "Play button on event live page");
        javascriptExecutorClick(playButtonOnLiveEventPage);
        log.info("Clicked on the Play video button.");
    }

    public void verifyAndPauseVideoIframeStreamingForOD() {
        log.info("Verify the Video streaming details.");
        String pauseButton = "//video[@class='video-stream html5-main-video']";
        log.info("Verify the Video Pause.");
        WebElement pauseButtonOnLiveEventPage = waitForDisplayedAndEnabled(By.xpath(pauseButton), "Pause button on event live page");
        pauseButtonOnLiveEventPage.click();
        log.info("Clicked on the Pause button.");
    }
}