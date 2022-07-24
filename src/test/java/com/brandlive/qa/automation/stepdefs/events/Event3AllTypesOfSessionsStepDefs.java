package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3AllTypesOfSessionsStepDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();

    class RegistrationInfo {
        private String firstName;
        private String lastName;
        private String email;
        private String passcode;
    }

    @And("^Create event \"([^\"]*)\" with all types of session with english language and registration$")
    public void create_event_with_all_types_of_session_with_english_language_and_registration(String version) {
        if (version.contains("3.0")) {
            event3CreationAdapter.createAllTypesOFSessions();
        }
        sleep();
    }

    @And("^Multiple attendee register to an event$")
    public void multiple_attendee_register_to_an_event(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
            log.info("Registration details are - " + info.firstName + ", " + info.lastName + ", " + info.email + info.passcode + ". ");
            event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.email, info.passcode);
            sleep(3);
            event3OpenLiveAdapter.clickOnTheSessionTab();
            event3LiveRegistrationAdapter.logOutFromLiveEvent();
        }
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
    }
}