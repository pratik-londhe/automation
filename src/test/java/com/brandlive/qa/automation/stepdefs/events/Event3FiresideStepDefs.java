package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.GmailAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.events3.adapters.live.FiresideRoomAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3FiresideStepDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();
    Event3OpenLiveAdapter event3LiveAdapter = new Event3OpenLiveAdapter();

    class RegistrationInfo {
        private String firstName;
        private String lastName;
        private String email;
        private String passcode;
        private String cardName;
        private String cardNumber;
        private String expiration;
        private String cvv;
        private String zip;
        private String companyName;
        private String bio;
        private String funFact;
        private String location;
        private String firesideHeaderTagName;
        private String spotlightCount;
        private String signInMessage;
    }

    @And("^Create event \"(.*?)\" with fireside session$")
    public void create_event_with_fireside_session(String version) {
        if (version.contains("3.0")) {
            event3CreationAdapter.createFiresideEvent(true);
        }
        sleep();
    }

    @And("^The event \"(.*?)\" live page is opened and registration is successful by host user$")
    public void the_event_live_page_is_opened_and_registration_is_successful_by_host_user(String version, List<RegistrationInfo> Infos) {
        if (version.contains("3.0")) {
            event3LiveAdapter.goWithTheLiveEvent();
            event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
            for (RegistrationInfo info : Infos) {
                log.info("Registration details are - " + info.firstName + ", " + info.lastName + ", " + info.email + ", " + info.passcode + ", "
                        + info.cardName + ", " + info.cardNumber + ", " + info.expiration + ", " + info.cvv + ", " + info.zip + "," + info.companyName + ", "
                        + info.bio + ", " + info.funFact + ", " + info.location + ". ");
                event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.email, info.passcode);
                event3LiveRegistrationAdapter.userProfileInfo(info.companyName, info.bio, info.funFact, info.location);
                event3LiveRegistrationAdapter.userUploadAvatarDetails("image", "avatar.jpg", "Events");
                event3LiveRegistrationAdapter.userTicketCheckoutDetails(info.email, info.cardName, info.cardNumber, info.expiration, info.cvv);
            }
        }
        sleep();
    }

    @And("^Verify the Sign in page$")
    public void verify_the_Sign_in_page(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Sign in page details are - " + info.signInMessage + ". ");
            event3LiveRegistrationAdapter.verifySignInPage(info.signInMessage);
        }
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
    }
}