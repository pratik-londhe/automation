package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.brandlive.qa.automation.events3.pages.admin.creation.EventCreation.nameOfRoom;

public class BreakoutV2Room extends Base {

    public void clickOnTheJoinButton() {
        log.info("Click on the Join button...");
        String join = "//span[text()= '" + nameOfRoom + "']//following::button[1]";
        WebElement JoinButton = waitForDisplayedAndEnabled(By.xpath(join), "Join button on the Breakout Session.");
        JoinButton.click();
        log.info("Clicked on the Join button.");
    }

    public void clickOnTheJoinRoomButton() {
        log.info("Click on the Join Room button...");
        String joinRoom = "//button[@class='action primary']";
        String breakoutModal = "//div[@class='breakouts-modal-wrapper']";
        WebElement breakoutModalPopUp = waitForDisplayedAndEnabled(By.xpath(breakoutModal), "Breakout modal pop up on the Breakout Session.");
        if (breakoutModalPopUp.isDisplayed()) {
            WebElement joinRoomButton = waitForDisplayedAndEnabled(By.xpath(joinRoom), "Join button on the Breakout Session.");
            joinRoomButton.click();
            log.info("Clicked on the Join Room button.");
        }
    }

    public boolean verifyWaitingMessageForSingleUser() {
        log.info("Verify waiting message for the single user in the breakout room...");
        String textMessage = "//div[@class='waiting-text-container']//span";
        WebElement waitingTextMessage = waitForDisplayedAndEnabled(By.xpath(textMessage), "Waiting text message in teh room.");
        if (waitingTextMessage.getText().contains("Waiting for participants to join the room")) {
            log.info("Verified the Waiting message for the single user.");
            return true;
        }
        return false;
    }

    public void turnOnVideoInTheRoom() {
        log.info("On the video call in the breakout room.");
        String videoOff = "(//div[@class='breakouts-footer-middle']//button)[1]";
        WebElement videoControlOff = waitForDisplayedAndEnabled(By.xpath(videoOff), "Video off in the breakout room.");
        if (videoControlOff.isDisplayed()) {
            videoControlOff.click();
            log.info("Turned On the video in the breakout room.");
        }
    }

    public void turnOffVideoInTheRoom() {
        log.info("Off the video call in the breakout room.");
        String videoOn = "(//div[@class='breakouts-footer-middle']//button)[1]";
        WebElement videoControlOn = waitForDisplayedAndEnabled(By.xpath(videoOn), "Video On in the breakout room.");
        if (videoControlOn.isDisplayed()) {
            videoControlOn.click();
            log.info("Turned off the video in the breakout room.");
        }
    }

    public void unMuteMicInTheRoom() {
        log.info("Un mute Mic in the breakout room.");
        String micMute = "(//div[@class='breakouts-footer-middle']//button)[2]";
        WebElement micMuteIcon = waitForDisplayedAndEnabled(By.xpath(micMute), "Mute Mic in the breakout room.");
        if (micMuteIcon.isDisplayed()) {
            javascriptExecutorClick(micMuteIcon);
            log.info("Un Mute the Mic in the breakout room.");
        }
    }

    public void muteMicInTheRoom() {
        log.info("Mute Mic in the breakout room.");
        String micUnMute = "(//div[@class='breakouts-footer-middle']//button)[2]";
        WebElement micUnMuteIcon = waitForDisplayedAndEnabled(By.xpath(micUnMute), "Un mute mic in the breakout room.");
        if (micUnMuteIcon.isDisplayed()) {
            javascriptExecutorClick(micUnMuteIcon);
            log.info("Mute The Mic in the breakout room.");
        }
    }

    public void closeBreakoutV2Room() {
        log.info("Close the breakout V2 room.");
        String closeRoom = "(//div[@class='breakouts-footer-middle']//button)[3]";
        String breakoutModal = "//div[@class='breakouts-modal-wrapper']";
        String yesLeaveSession = "//button[@class='action primary']";
        WebElement closeRoomButton = waitForDisplayedAndEnabled(By.xpath(closeRoom), "Close Room button in the breakout room.");
        if (closeRoomButton.isDisplayed()) {
            closeRoomButton.click();
            log.info("Closed the breakout V2 room.");
        }
        WebElement breakoutModalPopUp = waitForDisplayedAndEnabled(By.xpath(breakoutModal), "Breakout Modal Pop Upin the breakout room.");
        if (breakoutModalPopUp.isDisplayed()) {
            WebElement yesLeaveSessionButton = waitForDisplayedAndEnabled(By.xpath(yesLeaveSession), "Yes, Leave Session button in the breakout room.");
            yesLeaveSessionButton.click();
            log.info("Clicked on the Yes, Leave Session button.");
        }
        sleep(3);
    }

    private void clickOnAttendeesIcon() {
        log.info("Click on the Attendees icon.");
        String attendees = "(//div[@class='breakouts-footer-right']//button)[1]";
        WebElement attendeesIcon = waitForDisplayedAndEnabled(By.xpath(attendees), "Attendees icon in the breakout room.");
        if (attendeesIcon.isDisplayed()) {
            attendeesIcon.click();
            log.info("Clicked on the attendees icon in the breakout V2 room.");
        }
    }

    public boolean verifyNumberOfAttendeesForSingleUserJoined() {
        log.info("Close the breakout V2 room.");
        clickOnAttendeesIcon();
        String breakOutAttendeesPopUp = "//div[@class='breakouts-attendees-container']";
        String attendeesActive = "//span[@class='tab-header-append']";
        WebElement breakOutAttendeesPopUpPage = waitForDisplayedAndEnabled(By.xpath(breakOutAttendeesPopUp), "Breakout Attendees pop up in the breakout room.");
        if (breakOutAttendeesPopUpPage.isDisplayed()) {
            WebElement attendeesActiveCount = waitForDisplayedAndEnabled(By.xpath(attendeesActive), "Attendees count in the breakout room.");
            if (attendeesActiveCount.getText().contains("1")) {
                log.info("Verified the attendees count in the breakout V2 room.");
                return true;
            }
        }
        return false;
    }

    private void clickOnChatIcon() {
        log.info("Click on the Chat icon.");
        String chat = "(//div[@class='breakouts-footer-right']//button)[2]";
        WebElement chatIcon = waitForDisplayedAndEnabled(By.xpath(chat), "Chat icon in the breakout room.");
        if (chatIcon.isDisplayed()) {
            chatIcon.click();
            log.info("Clicked on the Chat icon in the breakout V2 room.");
        }
    }

    public boolean verifyTheChatWrapperInTheRoom() {
        log.info("Verify The chat wrapper in the breakout V2 room.");
        String breakoutChatWrapper = "//div[@class='breakouts-chat-wrapper']";
        String textArea = "//textarea[@class='add-live-comment-textarea']";
        String gif = "//div[@class='giphy-picker-container']";
        String emojiSmile = "//div[@class='emoji-picker-container']";
        clickOnChatIcon();
        WebElement breakOutAttendeesPopUpPage = waitForDisplayedAndEnabled(By.xpath(breakoutChatWrapper), "Chat wrapper pop up in the breakout room.");
        if (breakOutAttendeesPopUpPage.isDisplayed()) {
            WebElement chatTextArea = waitForDisplayedAndEnabled(By.xpath(textArea), "Chat text area in chat wrapper in the breakout room.");
            WebElement gifIcon = waitForDisplayedAndEnabled(By.xpath(gif), "Gif icon in chat wrapper in the breakout room.");
            WebElement emojiSmileIcon = waitForDisplayedAndEnabled(By.xpath(emojiSmile), "Emoji Smile in chat wrapper in the breakout room.");
            if (chatTextArea.isDisplayed() && gifIcon.isDisplayed() && emojiSmileIcon.isDisplayed()) {
                log.info("Verified the Chat Area, Gif and Emoji icons in the chat wrapper in the breakout V2 room.");
                return true;
            }
        }
        return false;
    }

    public boolean verifyBreakoutSessionPageAfterClosingTheRoom() {
        log.info("Verify the Breakout V2 session page after closing the Room.");
        List<WebElement> roomCards = webDriver.findElements(By.xpath("//div[contains(@class, 'room-card')]"));
        log.info("The Room card size is: " + roomCards.size());
        WebElement sessionTab = webDriver.findElement(By.xpath("//span[@class='ev-icon-event icon-giant']"));
        if (roomCards.size() == 2 && sessionTab.isDisplayed()) {
            log.info("Verified teh session page after closing teh breakout V2 room.");
            return true;
        }
        return false;
    }
}