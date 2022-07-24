package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3RegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3AddPasscodeListStepDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3RegistrationAdapter event3RegistrationAdapter = new Event3RegistrationAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();

    class EventSessionInfo {
        private String templateName;
        private String language;
    }

    class PasscodeInfo {
        private String gatingType;
        private String passcode;
        private String mediaType;
        private String mediaName;
        private String productName;
        private String passcodeListName;
        private String masterPasscode;
        private String passcodeType;
    }

    class RegistrationInfo {
        private String firstName;
        private String lastName;
        private String email;
        private String masterPasscode;
    }

    @And("^Create an event with multi Broadcast sessions, English Language and registration$")
    public void create_an_event_with_multi_Broadcast_sessions_English_Language_and_registration(List<EventSessionInfo> Infos) {
        for (EventSessionInfo info : Infos) {
            log.info("Event and Session details are - " + info.templateName + ", " + info.language + ". ");
            event3CreationAdapter.createMultiBroadcastEvent(true, true, info.templateName, info.language);
        }
    }

    @And("^Add passcode list \\(Email with Passcode\\) with master passcode added\\.$")
    public void add_passcode_list_Email_with_Passcode_with_master_passcode_added(List<PasscodeInfo> Infos) {
        event3RegistrationAdapter.clickOnRegTabFromLeftNav();
        event3RegistrationAdapter.clickOnEvenAvailabilityCard();
        for (PasscodeInfo info : Infos) {
            log.info("Passcode List gating details are - " + info.gatingType + ", " + info.passcode + ", " + info.mediaType + ", " + info.mediaName + ", " + info.productName + ", " + info.passcodeListName + ", " + info.masterPasscode + ", " + info.passcodeType + ". ");
            event3RegistrationAdapter.addRegistrationGating(info.gatingType, "", info.mediaType, info.mediaName, info.productName, info.passcodeListName, info.masterPasscode, info.passcodeType);
        }
        event3RegistrationAdapter.verifyAddedPasscodeList();
    }

    @And("^Multiple attendee able to register successfully with passcode with live experience$")
    public void multiple_attendee_able_to_register_successfully_with_passcode_with_live_experience(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
            log.info("Registration details are - " + info.firstName + ", " + info.lastName + ", " + info.email + ", " + info.masterPasscode + ". ");
            event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.email, info.masterPasscode);
            sleep(3);
            event3OpenLiveAdapter.clickOnTheSessionTab();
            event3LiveRegistrationAdapter.logOutFromLiveEvent();
        }
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
    }
}