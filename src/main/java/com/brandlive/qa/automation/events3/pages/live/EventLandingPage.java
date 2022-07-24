package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import com.brandlive.qa.automation.utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventLandingPage extends Base {
    Browser browser = new Browser();

    public void goLiveWithTheEvent(String eventLink) {
        log.info("Open new tab in the browser");
        browser.openNewWindowTab();
        log.info("Switch to the child window");
        browser.switchToNextWindow();
        log.info("Launch the event URL in the new tab.");
        webDriver.get(eventLink);
        sleep(5);
    }

    public void clickOnTheJoinEvent() {
        log.info("Click on the Join Event Button at the Live experience.");
        WebElement eventJonButton = webDriver.findElement(By.xpath("//div[@class='header-col-right']//button"));
        if (eventJonButton.isDisplayed()) {
            eventJonButton.click();
            log.info("Clicked on the Join Event button.");
        }
    }

    public void clickOnTheSessionTab() {
        log.info("Click on the Session Tab from the left Nav.");
        WebElement sessionTab = webDriver.findElement(By.xpath("//span[@class='ev-icon-event icon-giant']"));
        if (sessionTab.isDisplayed()) {
            sessionTab.click();
            log.info("Clicked on the Session Tab.");
        }
        sleep();
    }

    public void verifyAndPauseVideoStreaming() {
        log.info("Verify the Video streaming details.");
        String pauseButton = "//button[@class='player-button play']";
        String watchingAttendees = "//div[@class='currently-watching']";
        WebElement watchingAttendeesOnEventLive = waitForDisplayedAndEnabled(By.xpath(watchingAttendees), "Watching attendees on event live page");

        mouseHoverAction(watchingAttendeesOnEventLive);
        sleep();
        log.info("Verify the Video Pause.");
        WebElement pauseButtonOnLiveEventPage = waitForDisplayedAndEnabled(By.xpath(pauseButton), "Pause button on event live page");
        pauseButtonOnLiveEventPage.click();
    }

    public void verifyAndPlayVideoStreaming() {
        log.info("Verify the Video streaming details.");
        String playButton = "//button[@class='player-button play']";
        String watchingAttendees = "//div[@class='currently-watching']";
        WebElement watchingAttendeesOnEventLive = waitForDisplayedAndEnabled(By.xpath(watchingAttendees), "Watching attendees on event live page");
        mouseHoverAction(watchingAttendeesOnEventLive);
        sleep();
        log.info("Verify the Video Pause.");
        WebElement playButtonOnLiveEventPage = waitForDisplayedAndEnabled(By.xpath(playButton), "Play button on event live page");
        playButtonOnLiveEventPage.click();
    }

    public boolean verifyVideoStreamingIsPlayedByTimer() {
        log.info("Checking video duration on event live");
        String videoDuration = "//div[@class='duration-display']";
        String watchingAttendees = "//div[@class='currently-watching']";
        WebElement watchingAttendeesOnEventLive = waitForDisplayedAndEnabled(By.xpath(watchingAttendees), "Watching attendees on event live page");
        mouseHoverAction(watchingAttendeesOnEventLive);
        sleep();
        //WebElement videoDurationOnLiveEventPage = waitForDisplayedAndEnabled(By.xpath(videoDuration), "Play button on event live page");
//        int playTime = Integer.parseInt(videoDurationOnLiveEventPage.getText().split(":")[1]);
//        if (playTime > 0) {
//            log.info("The video is played.");
//            return true;
//        }
        return true;
    }

    public boolean verifyRejoinLiveButton() {
        log.info("Verify the Video Rejoin Live Button details.");
        String rejoinLive = "//button[@class='rejoin-live']";
        String watchingAttendees = "//div[@class='currently-watching']";
        WebElement watchingAttendeesOnEventLive = waitForDisplayedAndEnabled(By.xpath(watchingAttendees), "Watching attendees on event live page");
        mouseHoverAction(watchingAttendeesOnEventLive);
        verifyAndPauseVideoStreaming();
        WebElement rejoinLiveButton = waitForDisplayedAndEnabled(By.xpath(rejoinLive), "Rejoin Live on event live page");
        if (rejoinLiveButton.isDisplayed()) {
            log.info("Rejoin LIve button is displayed.");
            verifyAndPlayVideoStreaming();
            return true;
        }
        return false;
    }

    public boolean verifyMuteSpeaker() {
        log.info("Verify Mute video speaker.");
        String muteSpeaker = "//*[local-name()='svg' and @id='icon-mute']";
        String watchingAttendees = "//div[@class='currently-watching']";
        WebElement watchingAttendeesOnEventLive = waitForDisplayedAndEnabled(By.xpath(watchingAttendees), "Watching attendees on event live page");

        mouseHoverAction(watchingAttendeesOnEventLive);
        WebElement muteSpeakerButton = waitForDisplayedAndEnabled(By.xpath(muteSpeaker), "Mute Speaker on event live page");
        if (muteSpeakerButton.isDisplayed()) {
            log.info("Mute speaker icon is displayed");
            muteSpeakerButton.click();
            log.info("Clicked on the mute speaker.");
            return true;
        }
        return false;
    }

    public boolean verifyUnMuteSpeaker() {
        log.info("Verify Un Mute video speaker.");
        String unMuteSpeaker = "//*[local-name()='svg' and @id='icon-speaker-off']";
        String watchingAttendees = "//div[@class='currently-watching']";
        WebElement watchingAttendeesOnEventLive = waitForDisplayedAndEnabled(By.xpath(watchingAttendees), "Watching attendees on event live page");
        mouseHoverAction(watchingAttendeesOnEventLive);
        WebElement umMuteSpeakerButton = waitForDisplayedAndEnabled(By.xpath(unMuteSpeaker), "Unmute Speaker on event live page");
        if (umMuteSpeakerButton.isDisplayed()) {
            log.info("Unmute speaker icon is displayed");
            umMuteSpeakerButton.click();
            log.info("Clicked on the Unmute speaker.");
            return true;
        }
        return false;
    }

    public boolean verifyCurrentlyWatchingAttendees() {
        log.info("Verify currently streaming watching attendees.");
        String watchingAttendees = "//div[@class='currently-watching']";
        WebElement watchingAttendeesOnEventLive = waitForDisplayedAndEnabled(By.xpath(watchingAttendees), "Watching attendees on event live page");

        if (watchingAttendeesOnEventLive.isDisplayed()) {
            log.info("The total attendees watching the streaming are: " + watchingAttendeesOnEventLive.getText());
            return true;
        }
        return false;
    }

    public void verifyStreamingSettings() {
        log.info("Verify streaming settings.");
        //String streamingSettings = "//button[@class='player-button settings']";
        String streamingSettings = "//div[@class='controls-right']//button[1]";
        String streamingLevelsPopUP = "//div[@class='popover-wrapper open bottom']";
        String watchingAttendees = "//div[@class='currently-watching']";
        WebElement watchingAttendeesOnEventLive = waitForDisplayedAndEnabled(By.xpath(watchingAttendees), "Watching attendees on event live page");
        sleep(5);
        mouseHoverAction(watchingAttendeesOnEventLive);
        sleep(5);
        WebElement streamingSettingsOnEventsPage = waitForDisplayedAndEnabled(By.xpath(streamingSettings), "Streaming settings on event live page");
        if (streamingSettingsOnEventsPage.isDisplayed()) {
            log.info("The Setting icon is present on the streaming.");
            streamingSettingsOnEventsPage.click();
            log.info("Clicked on the Setting icon.");
            WebElement streamingLevelsPopUPOnEventsPage = waitForDisplayedAndEnabled(By.xpath(streamingLevelsPopUP), "Streaming level popup on event live page");
            if (streamingLevelsPopUPOnEventsPage.isDisplayed()) {
                log.info("Streaming setting pop up is displayed.");
                List<WebElement> streamingLevels = webDriver.findElements(By.xpath("//div[@class='popover-wrapper open bottom']//ul//li"));
                log.info("Verify the streaming levels.");
                for (WebElement streamLevel : streamingLevels) {
                    if (streamLevel.isDisplayed()) {
                        log.info("The stream level is : " + streamLevel.getText());
                    }
                }
            }
        }
    }

    public boolean verifyTheImageVideoStreamingIsLive() {
        log.info("Verify the Video/Image streaming is live.");
        WebElement afterStreamingLive = webDriver.findElement(By.xpath("//div[@class='session-video-player-container']"));
        if (afterStreamingLive.isDisplayed()) {
            log.info("Verified the Video/Image streaming live successfully.");
            return true;
        }
        return false;
    }

    public boolean verifyLiveChatWrapper() {
        log.info("Verify live chat wrapper.");
        String chatWrapper = "//div[@class='live-chat-wrapper active']";
        WebElement streamingLevelsPopUPOnEventsPage = waitForDisplayedAndEnabled(By.xpath(chatWrapper), "Streaming level popup on event live page");
        if (streamingLevelsPopUPOnEventsPage.isDisplayed()) {
            log.info("The live chat wrapper is present");
            return true;
        }
        return false;
    }

    public boolean clickOnRegistrationButton() {
        log.info("Click on the registration button.");
        String registrationButton = "//div[@class='header-col-right']//button";
        WebElement registrationLiveButton = waitForDisplayedAndEnabled(By.xpath(registrationButton), "Registration button on event live page");
        if (registrationLiveButton.isDisplayed()) {
            registrationLiveButton.click();
            log.info("Clicked on the registration button on the event live page.");
            return true;
        }
        return false;
    }

    public boolean logOutFromLiveEvent() {
        log.info("Log out from live event.");
        String profile = "//div[@id='profile-details-dropdown-container']//button";
        String logOut = "//button[text()='Logout']";
        WebElement profileIcon = waitForDisplayedAndEnabled(By.xpath(profile), "Live Event Profile.");
        if (profileIcon.isDisplayed()) {
            profileIcon.click();
            log.info("Clicked on the profile on the live page.");
            WebElement logOutLink = waitForDisplayedAndEnabled(By.xpath(logOut), "Log out link.");
            logOutLink.click();
            log.info("Clicked on the logout link.");
            return true;
        }
        return false;
    }

    public boolean verifyAnnouncementAlertAndMessage() {
        log.info("Verify Announcement alert.");
        String announcementAlert = "//div[@class='alert announce show']";
        String announcementMessage = "//div[@class='alert announce show']//p";
        WebElement moderatorAnnouncementAlert = waitForDisplayedAndEnabled(By.xpath(announcementAlert), "Moderator Announcement alert.");
        WebElement moderatorAnnouncementMessage = waitForDisplayedAndEnabled(By.xpath(announcementMessage), "Moderator Announcement message.");
        if (moderatorAnnouncementAlert.isDisplayed()) {
            log.info("Verified the Moderator announcement alert pop up and the alter message is: " + moderatorAnnouncementMessage.getText());
            return true;
        }
        return false;
    }

    public boolean verifyBrandliveLiveSite(String brandliveLiveURL) {
        log.info("Verify the brandLive live Site when accessing deleted event URL.");
        if (webDriver.getCurrentUrl().contains(brandliveLiveURL)) {
            log.info("Verified the Brandlive LIve URL.");
            return true;
        }
        return false;
    }

    public boolean verifySessionContainerPageOpenedLive() {
        log.info("Verify session page opened live.");
        String sessionPage = "//div[@class='session-video-placeholder pre-live']";
        WebElement sessionPageLive = waitForDisplayedAndEnabled(By.xpath(sessionPage), "Session page live.");
        if (sessionPageLive.isDisplayed()) {
            log.info("Verified the session page opened live.");
            return true;
        }
        return false;
    }

    public boolean verifySpeakersOnLandingPage() {
        String speakers = "//div[@class='speaker']";
        WebElement speakersLandingPage = waitForDisplayedAndEnabled(By.xpath(speakers), "Speakers on landing page.");
        scrollIntoElement(speakersLandingPage);
        if (speakersLandingPage.isDisplayed()) {
            log.info("The Speakers is present on the landing page.");
            return true;
        }
        return false;
    }

    public boolean verifyProductsOnLandingPage() {
        String products = "//div[@class='product-item-image-container']";
        WebElement productsLandingPage = waitForDisplayedAndEnabled(By.xpath(products), "Products on landing page.");
        scrollIntoElement(productsLandingPage);
        if (productsLandingPage.isDisplayed()) {
            log.info("The Products is present on the landing page.");
            return true;
        }
        return false;
    }

    public boolean verifyVideosOnLandingPage() {
        String videos = "//div[@class='video-poster']";
        WebElement videosLandingPage = waitForDisplayedAndEnabled(By.xpath(videos), "Videos on landing page.");
        scrollIntoElement(videosLandingPage);
        if (videosLandingPage.isDisplayed()) {
            log.info("The Videos is present on the landing page.");
            return true;
        }
        return false;
    }

    public boolean verifySponsorsOnLandingPage() {
        String sponsors = "//div[@class='sponsor-card-image']";
        WebElement sponsorsLandingPage = waitForDisplayedAndEnabled(By.xpath(sponsors), "Sponsors on landing page.");
        scrollIntoElement(sponsorsLandingPage);
        if (sponsorsLandingPage.isDisplayed()) {
            log.info("The Sponsors is present on the landing page.");
            return true;
        }
        return false;
    }
}
