package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.BuilderModeShowBoard;
import com.brandlive.qa.automation.greenroom.pages.LiveModeShowBoard;
import com.brandlive.qa.automation.utils.Doer;

public class ShowBoardAdapter extends Doer {
    BuilderModeShowBoard builderShowBoard = new BuilderModeShowBoard();
    LiveModeShowBoard liveModeShowBoard = new LiveModeShowBoard();

    public void addShotWithFeeds(int noOfFeeds) {
        builderShowBoard.addShotInBuilderMode();
        builderShowBoard.applyLayoutInBuilderMode(noOfFeeds);
    }

    public boolean validateShots(String shotName) {
        return builderShowBoard.validateShotPresent(shotName);
    }

    public void playShotInLiveMode() {
        liveModeShowBoard.playShotInLiveMode();
    }

    public void selectShotFromShowBoard(){
        builderShowBoard.expandShowBoard();
       // builderShowBoard.selectShot();
    }
}
