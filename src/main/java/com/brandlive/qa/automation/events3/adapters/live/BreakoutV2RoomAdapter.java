package com.brandlive.qa.automation.events3.adapters.live;

import com.brandlive.qa.automation.events3.pages.live.BreakoutV2Room;
import com.brandlive.qa.automation.utils.Doer;

public class BreakoutV2RoomAdapter extends Doer {

    BreakoutV2Room breakoutV2Room = new BreakoutV2Room();

    public void joinTheBreakoutV2Room() {
        breakoutV2Room.clickOnTheJoinButton();
        sleep(15);
        breakoutV2Room.clickOnTheJoinRoomButton();
    }

    public void verifyTheBreakoutV2Room() {
        breakoutV2Room.verifyWaitingMessageForSingleUser();
        breakoutV2Room.turnOffVideoInTheRoom();
        breakoutV2Room.turnOnVideoInTheRoom();
        breakoutV2Room.muteMicInTheRoom();
        breakoutV2Room.unMuteMicInTheRoom();
        breakoutV2Room.verifyNumberOfAttendeesForSingleUserJoined();
        breakoutV2Room.verifyTheChatWrapperInTheRoom();
    }

    public void closeTheBreakoutV2Room() {
        breakoutV2Room.closeBreakoutV2Room();
        breakoutV2Room.verifyBreakoutSessionPageAfterClosingTheRoom();
    }
}
