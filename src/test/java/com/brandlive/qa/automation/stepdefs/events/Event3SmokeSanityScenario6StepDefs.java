package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3HomePageAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3ModeratorAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3SmokeSanityScenario6StepDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();
    Event3ModeratorAdapter event3ModeratorAdapter = new Event3ModeratorAdapter();
    Event3HomePageAdapter event3HomePageAdapter = new Event3HomePageAdapter();

    class RegistrationInfo {
        private String firstName;
        private String lastName;
        private String email;
        private String passcode;
        private String announcementTO;
        private String announcementMessage;
        private String brandliveURL;
        private String generalInfoPageHeader;
        private String templateName;
    }

    @And("^Add Apollo Event with Broadcast session or OD session with registration and No LP$")
    public void add_Apollo_Event_with_Broadcast_session_or_OD_session_with_registration_and_No_LP(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Event details are - " + info.templateName + ". ");
            event3CreationAdapter.createBroadcastEvent(true, false, info.templateName);
        }
    }

    @And("^Publish and go live\\.$")
    public void publish_and_go_live() {
        event3CreationAdapter.publishEvent();
        event3OpenLiveAdapter.copyPublishedEventLink();
        event3OpenLiveAdapter.goWithTheLiveEvent();
    }

    @And("^Make sure Registration page General info is opened$")
    public void make_sure_Registration_page_General_info_is_opened(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("General Info page message details are - " + info.generalInfoPageHeader + ". ");
            event3LiveRegistrationAdapter.verifyGeneralInfoPage(info.generalInfoPageHeader);
        }
    }

    @And("^Complete the registration flow successfully$")
    public void complete_the_registration_flow_successfully(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Registration details are - " + info.firstName + ", " + info.lastName + ", " + info.email + info.passcode + ". ");
            event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.email, info.passcode);
        }
        sleep(2);
        browser.switchToPreviousWindow();
        event3CreationAdapter.clickOnPathingHeader();
    }

    @And("^Add announcements using Moderator window$")
    public void add_announcements_using_Moderator_window(List<RegistrationInfo> Infos) {
        event3HomePageAdapter.clickOnUpcomingEventTab();
        event3HomePageAdapter.searchCreatedEvent();
        event3ModeratorAdapter.clickOnEventDetailsLink();
        event3ModeratorAdapter.clickOnModeratorButton();
        for (RegistrationInfo info : Infos) {
            log.info("Announcement Details are - " + info.announcementTO + ", " + info.announcementMessage + ". ");
            event3ModeratorAdapter.addAnnouncement(info.announcementTO, info.announcementMessage);
        }
    }

    @And("^make sure announcements appear on live experience side$")
    public void make_sure_announcements_appear_on_live_experience_side() {
        browser.switchToNextWindow();
        event3OpenLiveAdapter.verifyAnnouncementAlertAndMessage();
    }

    @And("^Make sure the Session page is opened live$")
    public void make_sure_the_Session_page_is_opened_live() {
        event3OpenLiveAdapter.verifySessionContainerPageOpenedLive();
    }

    @And("^Duplicate this event$")
    public void duplicate_this_event() {
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
        event3HomePageAdapter.goToAdminPage();
        sleep(3);
        event3HomePageAdapter.clickOnUpcomingEventTab();
        event3HomePageAdapter.searchCreatedEvent();
        event3HomePageAdapter.createDuplicateEvent();
    }

    @And("^Delete the original event$")
    public void delete_the_original_event() {
        event3HomePageAdapter.deleteOriginalEvent();
    }

    @And("^Make sure the live URL of original event is not accessible as the event is deleted$")
    public void make_sure_the_live_URL_of_original_event_is_not_accessible_as_the_event_is_deleted(List<RegistrationInfo> Infos) {
        event3OpenLiveAdapter.goWithTheLiveEvent();
        for (RegistrationInfo info : Infos) {
            log.info("BrandLive URL Details are - " + info.brandliveURL + ". ");
            event3OpenLiveAdapter.verifyBrandliveLiveSite(info.brandliveURL);
        }
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
    }
}