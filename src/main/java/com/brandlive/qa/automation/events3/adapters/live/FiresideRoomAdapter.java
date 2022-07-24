package com.brandlive.qa.automation.events3.adapters.live;

import com.brandlive.qa.automation.events3.pages.live.FiresideRoom;
import com.brandlive.qa.automation.utils.Doer;

public class FiresideRoomAdapter extends Doer {
    FiresideRoom firesideRoom = new FiresideRoom();

    public void startTheFiresideSession() {
        firesideRoom.clickOnStartSessionButton();
        sleep(15);
    }

    public void joinTheFiresideRoom() {
        firesideRoom.clickOnJoinTheStage();
    }

    public void verifyTheFiresideRoomControls() {
        firesideRoom.turnOffVideoInTheRoom();
        firesideRoom.turnOnVideoInTheRoom();
        firesideRoom.muteMicInTheRoom();
        firesideRoom.unMuteMicInTheRoom();
        firesideRoom.verifyScreeShareIcon();
    }

    public void verifyFiresideHeaderTabs() {
        firesideRoom.verifyTheHeaderTabsInFiresideRoom();
    }

    public void verifyFiresideHeaderTagName(String firesideHeaderTag) {
        firesideRoom.verifyTheFiresideHeaderTag(firesideHeaderTag);
    }

    public void verifySpotlightCountForSingleHostUser(String spotlightCount) {
        firesideRoom.verifyTheFiresideHeaderTag(spotlightCount);
    }

    public void closeTheBreakoutV2Room() {
        firesideRoom.closeFiresideRoom();
    }
}