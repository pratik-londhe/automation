package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.BreakoutV2RoomAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

public class Event3BreakoutV2StepDefs extends StepDefs {

    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3OpenLiveAdapter event3LiveAdapter = new Event3OpenLiveAdapter();
    BreakoutV2RoomAdapter breakoutV2RoomAdaptor = new BreakoutV2RoomAdapter();

    @And("^Create event \"(.*?)\" with breakout v(\\d+) session with two rooms added$")
    public void create_event_with_breakout_v_session_with_two_rooms_added(String version, int versionBreakout) {
        if (version.contains("3.0")) {
            event3CreationAdapter.createBreakoutV2EventWithTwoRoomsAdded();
        }
        sleep();
    }

    @And("^Check the breakout room and Join the room$")
    public void check_the_breakout_room_and_Join_the_room() {
        event3LiveAdapter.clickOnTheSessionTab();
        breakoutV2RoomAdaptor.joinTheBreakoutV2Room();
        sleep(10);
    }

    @And("^Validate the breakout room$")
    public void validate_the_breakout_room() {
        breakoutV2RoomAdaptor.verifyTheBreakoutV2Room();
    }

    @And("^Close the breakout room$")
    public void close_the_breakout_room() {
        breakoutV2RoomAdaptor.closeTheBreakoutV2Room();
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
    }
}