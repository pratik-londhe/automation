package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3RegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.SocialProfileDetailsSettingAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.utils.Doer;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3RegistrationStefDefs extends Doer {
    Event3RegistrationAdapter eventAdminRegistration = new Event3RegistrationAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();
    Event3OpenLiveAdapter event3LiveAdapter = new Event3OpenLiveAdapter();
    SocialProfileDetailsSettingAdapter socialProfileDetailsSettingAdapter = new SocialProfileDetailsSettingAdapter();

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
    }

    @And("^Enable the Profile Avatar and tickets for the event \"(.*?)\" registration$")
    public void enable_the_Profile_Avatar_and_tickets_for_the_event_registration(String version) {
        if (version.contains("3.0")) {
            eventAdminRegistration.clickOnRegTabFromLeftNav();
            eventAdminRegistration.enableProfileInfoPage();
            eventAdminRegistration.enableAvatarPage();
            eventAdminRegistration.addTicketPage();
            eventAdminRegistration.editTicketPage();
            socialProfileDetailsSettingAdapter.clickOnSocialTab();
            socialProfileDetailsSettingAdapter.toggleActionOnDirectoryAvatar("ON");
        }
        sleep();
    }

    @And("^The event \"(.*?)\" live page is opened and registration is successful$")
    public void the_event_live_page_is_opened_and_registration_is_successful(String version, List<RegistrationInfo> Infos) {
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
}
