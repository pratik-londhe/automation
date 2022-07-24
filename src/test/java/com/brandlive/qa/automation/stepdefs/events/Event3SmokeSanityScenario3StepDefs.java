package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.*;
import com.brandlive.qa.automation.events3.adapters.live.Event3ChatAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.events3.pages.admin.creation.EventCreation;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

public class Event3SmokeSanityScenario3StepDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3HomePageAdapter event3HomePageAdapter = new Event3HomePageAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();
    Event3ChatAdapter event3ChatAdapter = new Event3ChatAdapter();
    Event3SessionSettingAdapter event3SessionSettingAdapter = new Event3SessionSettingAdapter();
    EventCreation eventCreation = new EventCreation();
    Event3LandingPageAdapter event3LandingPageAdapter = new Event3LandingPageAdapter();
    Event3CustomPagesAdapter event3CustomPagesAdapter = new Event3CustomPagesAdapter();

    @And("^Add O(\\d+) Event with Broadcast session or OD session with English Language and No registration and No LP$")
    public void add_O_Event_with_Broadcast_session_or_OD_session_with_English_Language_and_No_registration_and_No_LP(int event) {
        event3CreationAdapter.createBroadcastEvent(false, false, "O2");
    }

    @And("^Make sure this Open Event has no Home Page$")
    public void make_sure_this_Open_Event_has_no_Home_Page() {
        event3HomePageAdapter.verifyHomePageForOpenEvent(true, false, false);
    }

    @And("^Publish and go live\\. Make sure the Session page is opened live$")
    public void publish_and_go_live_Make_sure_the_Session_page_is_opened_live() {
        event3CreationAdapter.publishEvent();
        event3OpenLiveAdapter.copyPublishedEventLink();
        event3OpenLiveAdapter.goWithTheLiveEvent();
    }

    @And("^Add message to chat window\\. Make sure popup window for attendee to add details before sending message displayed$")
    public void add_message_to_chat_window_Make_sure_popup_window_for_attendee_to_add_details_before_sending_message_displayed() {
        event3ChatAdapter.verifyProfileDetailsPopUpBeforeChatForOpenEvent();
    }

    @And("^Add second session of different type\\. Make sure the LP and Home page is enabled\\.$")
    public void add_second_session_of_different_type_Make_sure_the_LP_and_Home_page_is_enabled() {
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
        event3SessionSettingAdapter.clickOnAddSession();
        event3CreationAdapter.addOnDemandSessionOnEventTab();
        event3HomePageAdapter.verifyHomePageForOpenEvent(false, false, false);
        event3LandingPageAdapter.verifyLandingPageIsDisplayed();
    }

    @And("^Add custom pages to the event\\.$")
    public void add_custom_pages_to_the_event() {
        event3SessionSettingAdapter.clickOnEventTab();
        event3CustomPagesAdapter.addCustomPageAndPageGatingReqToEvent(1, false, "", "", "", "", "", "");
    }

    @And("^Publish and go live\\. Make sure the Landing page is opened live with Join Event button$")
    public void publish_and_go_live_Make_sure_the_Landing_page_is_opened_live_with_Join_Event_button() {
        event3CreationAdapter.publishEvent();
        event3OpenLiveAdapter.copyPublishedEventLink();
        event3OpenLiveAdapter.goWithTheLiveEvent();
        event3OpenLiveAdapter.clickOnTheJoinEvent();
    }

    @And("^Navigate to Home page and Later navigate to session pages\\.$")
    public void navigate_to_Home_page_and_Later_navigate_to_session_pages() {
        event3OpenLiveAdapter.clickOnTheSessionTab();
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
    }
}