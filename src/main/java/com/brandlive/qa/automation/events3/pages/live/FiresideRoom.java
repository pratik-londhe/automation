package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiresideRoom extends Base {

    public void clickOnStartSessionButton() {
        String startSession = "//button[@class='primary Apollo evt-button']";
        WebElement startSessionButton = waitForDisplayedAndEnabled(By.xpath(startSession), "Start Session button");
        startSessionButton.click();
        log.info("Clicked on the Start Session button.");
    }

    public void clickOnJoinTheStage() {
        String joinTheStage = "//button[@class='action primary']";
        WebElement joinTheStageButton = waitForDisplayedAndEnabled(By.xpath(joinTheStage), "Join The Stage button");
        joinTheStageButton.click();
        log.info("Clicked on the Join the stage button.");
    }

    public boolean verifyScreeShareIcon() {
        String screenShare = "//*[name()='svg' and @id='icon-share-screen']";
        if (elementPresent(By.xpath(screenShare))) {
            log.info("Verified the Screen share icon.");
            return true;
        }
        return false;
    }

    public boolean verifySpotLightCount(String spotlightCount) {
        String spotLight = "//span[@class='spotlight-count']";
        WebElement spotLightCount = waitForDisplayedAndEnabled(By.xpath(spotLight), "In Spotlight count.");
        if (spotLightCount.getText().equals(spotlightCount)) {
            log.info("The spotlight count for one attendee is : " + spotLightCount.getText());
            return true;
        }
        return false;
    }

    public boolean verifyTheHeaderTabsInFiresideRoom() {
        clickOnAttendeesIcon();
        boolean result = false;
        String[] firesideHeaderTabs = {"Attendees", "On-Stage Chat", "Session Chat"};
        log.info("Expected Fireside tabs size are:" + firesideHeaderTabs);
        List<String> firesideHeaderTabsExpected = new ArrayList<>(Arrays.asList(firesideHeaderTabs));
        String tabs = "//div[@class='tab-header-button']//button";
        List<WebElement> headerTabs = webDriver.findElements(By.xpath(tabs));
        for (WebElement tab : headerTabs) {
            if (firesideHeaderTabsExpected.contains(tab.getText())) {
                log.info("Verified the tab:" + tab.getText());
                result = true;
            } else {
                log.info("The tab is not present: " + tab.getText());
                return false;
            }
        }
        return result;
    }

    public boolean verifyTheFiresideHeaderTag(String firesideHeader) {
        String firesideTag = "//div[@class='fireside-header-info-button tag-container']//span";
        WebElement firesideTagName = waitForDisplayedAndEnabled(By.xpath(firesideTag), "Fireside Tag Name");
        if (firesideTagName.getText().contains(firesideHeader)) {
            log.info("Verified fireside tag name.");
            return true;
        }
        return false;
    }

    public void turnOnVideoInTheRoom() {
        log.info("On the video call in the Fireside room.");
        String videoOff = "(//div[@class='fireside-footer-middle']//button)[1]";
        WebElement videoControlOff = waitForDisplayedAndEnabled(By.xpath(videoOff), "Video off in the Fireside room.");
        if (videoControlOff.isDisplayed()) {
            videoControlOff.click();
            log.info("Turned On the video in the Fireside room.");
        }
    }

    public void turnOffVideoInTheRoom() {
        log.info("Off the video call in the Fireside room.");
        String videoOn = "(//div[@class='breakouts-footer-middle']//button)[1]";
        WebElement videoControlOn = waitForDisplayedAndEnabled(By.xpath(videoOn), "Video On in the Fireside room.");
        if (videoControlOn.isDisplayed()) {
            videoControlOn.click();
            log.info("Turned off the video in the Fireside room.");
        }
    }

    public void unMuteMicInTheRoom() {
        log.info("Un mute Mic in the Fireside room.");
        String micMute = "(//div[@class='fireside-footer-middle']//button)[2]";
        WebElement micMuteIcon = waitForDisplayedAndEnabled(By.xpath(micMute), "Mute Mic in the Fireside room.");
        if (micMuteIcon.isDisplayed()) {
            javascriptExecutorClick(micMuteIcon);
            log.info("Un Mute the Mic in the Fireside room.");
        }
    }

    public void muteMicInTheRoom() {
        log.info("Mute Mic in the Fireside room.");
        String micUnMute = "(//div[@class='fireside-footer-middle']//button)[2]";
        WebElement micUnMuteIcon = waitForDisplayedAndEnabled(By.xpath(micUnMute), "Un mute mic in the Fireside room.");
        if (micUnMuteIcon.isDisplayed()) {
            javascriptExecutorClick(micUnMuteIcon);
            log.info("Mute The Mic in the Fireside room.");
        }
    }

    public void closeFiresideRoom() {
        log.info("Close the Fireside room.");
        String closeRoom = "(//div[@class='fireside-footer-middle']//button)[4]";
        String breakoutModal = "//div[@class='fireside-modal-header']";
        String yesLeaveStage = "//button[@class='action primary']";
        WebElement closeRoomButton = waitForDisplayedAndEnabled(By.xpath(closeRoom), "Close Room button in the Fireside room.");
        if (closeRoomButton.isDisplayed()) {
            closeRoomButton.click();
            log.info("Closed the breakout V2 room.");
        }
        WebElement breakoutModalPopUp = waitForDisplayedAndEnabled(By.xpath(breakoutModal), "Breakout Modal Pop Up in the Fireside room.");
        if (breakoutModalPopUp.isDisplayed()) {
            WebElement yesLeaveSessionButton = waitForDisplayedAndEnabled(By.xpath(yesLeaveStage), "Yes, Leave Session button in the Fireside room.");
            yesLeaveSessionButton.click();
            log.info("Clicked on the Yes, Leave Session button.");
        }
        sleep(3);
    }

    private void clickOnAttendeesIcon() {
        log.info("Click on the Attendees icon.");
        String attendees = "(//div[@class='fireside-footer-right']//button)[1]";
        WebElement attendeesIcon = waitForDisplayedAndEnabled(By.xpath(attendees), "Attendees icon in the Fireside room.");
        if (attendeesIcon.isDisplayed()) {
            attendeesIcon.click();
            log.info("Clicked on the attendees icon in the Fireside room.");
        }
    }
}