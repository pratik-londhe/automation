package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events2.adapters.Event2CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.greenroom.adapters.ShowBoardAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class EventCreationAndSettingStepDefs extends StepDefs {

    Event2CreationAdapter event2CreationAdapter = new Event2CreationAdapter();
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3OpenLiveAdapter event3LiveAdapter = new Event3OpenLiveAdapter();
    ShowBoardAdapter showBoardAdapter = new ShowBoardAdapter();

    @And("^Check correct channel selected in events \"(.*?)\"$")
    public void Check_correct_channel_selected_in_events(String version) {
        if (version.contains("2.5")) {
            event2CreationAdapter.checkChannelInEvents();
        } else {
            event3CreationAdapter.checkChannelInEvents();
            sleep(4);
        }
        sleep();
    }

    @And("^Created and published event \"(.*?)\" successfully$")
    public void Created_an_event_successfully(String version) {
        if (version.contains("2.5")) {
            event2CreationAdapter.createEvent();
            event2CreationAdapter.publishEvent();
        } else {
            event3CreationAdapter.createEvent();
            event3CreationAdapter.publishEvent();
        }
        sleep();
    }

    @And("^Create open event \"(.*?)\" with broadcast session$")
    public void create_open_event_with_broadcast_session(String version) {
        if (version.contains("2.5")) {
            event2CreationAdapter.createEvent();
            event2CreationAdapter.publishEvent();
        } else {
            event3CreationAdapter.createSingleBroadcastEvent(false,true);
        }
        sleep();
    }

    @And("^Publish event \"(.*?)\"$")
    public void publish_event(String version) {
        if (version.contains("2.5")) {
            event2CreationAdapter.createEvent();
            event2CreationAdapter.publishEvent();
        } else {
            event3CreationAdapter.publishEvent();
            event3LiveAdapter.copyPublishedEventLink();
        }
        sleep();
    }

    @And("^Go live with the event \"(.*?)\"$")
    public void go_live_with_the_event(String version) {
        if (version.contains("2.5")) {
            event2CreationAdapter.createEvent();
            event2CreationAdapter.publishEvent();
        } else {
            event3LiveAdapter.goWithTheLiveEvent();
            event3LiveAdapter.clickOnTheJoinEvent();
            event3LiveAdapter.clickOnTheSessionTab();
        }
        sleep();
    }

    @And("^Check the Greenroom show is streaming$")
    public void check_the_Greenroom_show_is_streaming() {
        sleep(300);
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
        sleep(10);
    }

    @And("^Check the Greenroom show is streaming live$")
    public void check_the_Greenroom_show_is_streaming_live() {
        sleep(10);
        event3LiveAdapter.verifyTheVideoStreamingControls();
        browser.getBrowserConsoleLogs();
    }

    @Given("^Check the show is streaming for presenter$")
    public void check_the_show_is_streaming_for_presenter() {
        browser.getBrowserConsoleLogs();
        sleep(30);
    }

}
