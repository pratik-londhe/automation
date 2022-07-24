package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3RegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3SmokeSanityScenario5StepDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3RegistrationAdapter event3RegistrationAdapter = new Event3RegistrationAdapter();
    Event3RegistrationAdapter eventAdminRegistration = new Event3RegistrationAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();

    class RegistrationInfo {
        private String templateName;
        private String language;
        private String gatingType;
        private String passcode;
        private String passcodeLabel;
        private String senderName;
        private String blockedEmailDomain;
        private String firstName;
        private String lastName;
        private String emailBlockedDomain;
        private String email;
        private String ticketSoldMessage;
        private String cardName;
        private String cardNumber;
        private String expiration;
        private String cvv;
        private String zip;
    }

    @And("^Add Studio Event with multi Broadcast sessions, English and with Asian, European or African Language and registration$")
    public void add_Studio_Event_with_multi_Broadcast_sessions_English_and_with_Asian_European_or_African_Language_and_registration(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Event and Session details are - " + info.templateName + ", " + info.language + ". ");
            event3CreationAdapter.createMultiBroadcastEvent(true, true, info.templateName, info.language);
        }
    }

    @And("^Add Shared Passcode$")
    public void add_Shared_Passcode(List<RegistrationInfo> Infos) {
        event3RegistrationAdapter.clickOnRegTabFromLeftNav();
        event3RegistrationAdapter.clickOnEvenAvailabilityCard();
        for (RegistrationInfo info : Infos) {
            log.info("Registration gating details are - " + info.gatingType + ", " + info.passcode + ". ");
            event3RegistrationAdapter.addRegistrationGating(info.gatingType, info.passcode, "", "", "", "", "", "");
        }
    }

    @And("^Change the Passcode Label$")
    public void change_the_Passcode_Label(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Passcode label details are - " + info.passcodeLabel + ". ");
            event3RegistrationAdapter.changeThePasscodeLabel(info.passcodeLabel);
        }
        event3RegistrationAdapter.clickOnRegTabFromLeftNav();
    }

    @And("^Add Sender name$")
    public void add_Sender_name(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Sender Name details are - " + info.senderName + ". ");
            event3RegistrationAdapter.setEmailSenderName(info.senderName);
        }
    }

    @And("^Blocked Domain Emails enabled$")
    public void blocked_Domain_Emails_enabled(List<RegistrationInfo> Infos) {
        event3RegistrationAdapter.clickOnRegTabFromLeftNav();
        for (RegistrationInfo info : Infos) {
            log.info("Email details are - " + info.blockedEmailDomain + ". ");
            event3RegistrationAdapter.setBlockedEmailDomain(info.blockedEmailDomain);
        }
    }

    @And("^Add one Ticket with CC Payment$")
    public void add_one_Ticket_with_CC_Payment() {
        event3RegistrationAdapter.clickOnRegTabFromLeftNav();
        eventAdminRegistration.addTicketPage();
    }

    @And("^Edit the ticket to add gated sessions$")
    public void edit_the_ticket_to_add_gated_sessions() {
        eventAdminRegistration.editTicketPage();
    }

    @And("^Publish and Go live$")
    public void publish_and_Go_live() {
        event3CreationAdapter.publishEvent();
        event3OpenLiveAdapter.copyPublishedEventLink();
        event3OpenLiveAdapter.goWithTheLiveEvent();
    }

    @And("^Make sure Blocked Domain Emails working$")
    public void make_sure_Blocked_Domain_Emails_working(List<RegistrationInfo> Infos) {
        event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
        for (RegistrationInfo info : Infos) {
            log.info("Registration details are - " + info.firstName + ", " + info.lastName + ", " + info.emailBlockedDomain + ", " + info.passcode + ". ");
            event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.emailBlockedDomain, info.passcode);
        }
        sleep(2);
        event3LiveRegistrationAdapter.verifyBlockedEmailDomainMessage();
        browser.refreshBrowserWindow();
    }

    @And("^check the Passcode label has been change$")
    public void check_the_Passcode_label_has_been_change(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Passcode Label details are - " + info.passcodeLabel + ". ");
            event3LiveRegistrationAdapter.verifyThePasscodeLabelIsChanged(info.passcodeLabel);
        }
    }

    @And("^Attendee able to register successfully with shared passcode$")
    public void attendee_able_to_register_successfully_with_shared_passcode(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Registration details are - " + info.firstName + ", " + info.lastName + ", " + info.email + ", " + info.passcode + ". ");
            event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.email, info.passcode);
            event3LiveRegistrationAdapter.userTicketCheckoutDetails(info.email, info.cardName, info.cardNumber, info.expiration, info.cvv);

        }
        sleep(3);
        event3OpenLiveAdapter.clickOnTheSessionTab();
    }

    @And("^Try to register with different attendee and check that ticket is sold out$")
    public void try_to_register_with_different_attendee_and_check_that_ticket_is_sold_out(List<RegistrationInfo> Infos) {
        event3LiveRegistrationAdapter.logOutFromLiveEvent();
        sleep(2);
        event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
        for (RegistrationInfo info : Infos) {
            log.info("Ticket details are - " + info.ticketSoldMessage + ". ");
            event3LiveRegistrationAdapter.verifyTicketSoldOutMessage(info.ticketSoldMessage);
        }
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
        event3CreationAdapter.clickOnPathingHeader();
    }
}