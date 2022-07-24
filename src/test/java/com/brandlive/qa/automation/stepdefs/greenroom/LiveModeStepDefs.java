package com.brandlive.qa.automation.stepdefs.greenroom;

import com.brandlive.qa.automation.greenroom.adapters.GreenroomHeaderAdapter;
import com.brandlive.qa.automation.greenroom.adapters.ShowBoardAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class LiveModeStepDefs extends StepDefs {

    GreenroomHeaderAdapter greenroomHeaderAdapter = new GreenroomHeaderAdapter();
    ShowBoardAdapter showBoardAdapter = new ShowBoardAdapter();

    @Given("^Enter Greenroom in builder mode$")
    public void enter_Greenroom_in_builder_mode() {
        greenroomHeaderAdapter.enterGreenroomShowBuilderMode();
    }

    @Given("^Go live with the GR show$")
    public void go_live_with_the_GR_show() {
        greenroomHeaderAdapter.goLiveWithShow();
        showBoardAdapter.playShotInLiveMode();
        sleep(30);
    }

    @And("^Play the next shot from the show$")
    public void play_the_next_shot_from_the_show() {
        browser.switchToPreviousWindow();
        showBoardAdapter.playShotInLiveMode();
        browser.switchToNextWindow();
    }
}
