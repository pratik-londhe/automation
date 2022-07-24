package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3CustomPagesAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3RegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3SessionSettingAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3SmokeSanityScenario7StefDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3SessionSettingAdapter event3SessionSettingAdapter = new Event3SessionSettingAdapter();
    Event3CustomPagesAdapter event3CustomPagesAdapter = new Event3CustomPagesAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();
    Event3RegistrationAdapter event3RegistrationAdapter = new Event3RegistrationAdapter();

    class EventInfo {
        private String templateName;
    }

    class PageGatingReqInfo {
        private String mediaType;
        private String mediaName;
        private String productName;
        private String pListName;
        private String passcodeType;
    }

    class RegistrationInfo {
        private String firstName;
        private String lastName;
        private String email;
        private String passcode;
    }

    @And("^Add O2 Event with Fireside or Breakout room sessions with LP$")
    public void add_O_Event_with_Fireside_or_Breakout_room_sessions_with_LP(List<EventInfo> Infos) {
        for (EventInfo info : Infos) {
            log.info("Event details are - " + info.templateName + ". ");
            event3CreationAdapter.createFiresideSessionWithO2Event(true, info.templateName);
        }
    }

    @And("^Add (\\d+) custom pages and enable page gating on each page.$")
    public void add_custom_pages_and_enable_page_gating_on_each_page(int noOfCustomPages, List<PageGatingReqInfo> Infos) {
        event3SessionSettingAdapter.clickOnEventTab();
        for (PageGatingReqInfo info : Infos) {
            log.info("Page Gating Req details are - " + info.mediaType + ", " + info.mediaName + ", " + info.productName + ", " + info.pListName + ", " + info.passcodeType + ". ");
            event3CustomPagesAdapter.addCustomPageAndPageGatingReqToEvent(noOfCustomPages, true, "ON", info.mediaType, info.mediaName, info.productName, info.pListName, info.passcodeType);
        }
    }

    @And("^Add each page gating passcode during registration.$")
    public void add_each_page_gating_passcode_during_registration(List<RegistrationInfo> Infos) {
        event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
        for (RegistrationInfo info : Infos) {
            log.info("Registration details are - " + info.firstName + ", " + info.lastName + ", " + info.email + ", " + info.passcode + ". ");
            event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.email, info.passcode);
        }
    }

    @And("^Verify page gating is functioning correctly$")
    public void verify_page_gating_is_functioning_correctly() {
        event3CustomPagesAdapter.verifyCustomPagesLiveSide("ON");
    }

    @And("^Go back to admin and uncheck page gating toggle and all custom pages can be seen.$")
    public void go_back_to_admin_and_uncheck_page_gating_toggle_and_all_custom_pages_can_be_seen() {
        browser.switchToPreviousWindow();
        event3SessionSettingAdapter.clickOnEventTab();
        event3CustomPagesAdapter.toggleActionOnPageGating("OFF");
        event3CreationAdapter.publishEvent();
        browser.switchToNextWindow();
        browser.refreshBrowserWindow();
        event3CustomPagesAdapter.verifyCustomPagesLiveSide("OFF");
    }
}