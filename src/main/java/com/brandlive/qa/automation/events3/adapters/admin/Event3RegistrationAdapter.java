package com.brandlive.qa.automation.events3.adapters.admin;

import com.brandlive.qa.automation.events3.pages.admin.LeftNavigation;
import com.brandlive.qa.automation.events3.pages.admin.registrationsetting.*;
import com.brandlive.qa.automation.utils.Doer;

public class Event3RegistrationAdapter extends Doer {

    PaidTicketing paidTicketing = new PaidTicketing();
    ProfileInfo profileInfo = new ProfileInfo();
    Avatar avatar = new Avatar();
    EventAvailability eventAvailability = new EventAvailability();
    GeneralInfo generalInfo = new GeneralInfo();
    CustomizeForm customizeForm = new CustomizeForm();
    LeftNavigation leftNavigation = new LeftNavigation();
    RegistrationGating registrationGating = new RegistrationGating();
    Emails emails = new Emails();

    public void clickOnRegTabFromLeftNav() {
        leftNavigation.clickOnTheRegistrationTab();
    }

    public void enableProfileInfoPage() {
        log.info("Enabling the Profile info page for the registration...");
        profileInfo.addProfileInfoPage();
    }

    public void enableAvatarPage() {
        log.info("Enabling the Avatar page for the registration...");
        avatar.addAvatarPage();
    }

    public void addTicketPage() {
        log.info("Add ticket page for the registration...");
        paidTicketing.addTicketPageForTheRegistration();
    }

    public void editTicketPage() {
        log.info("Edit ticket page for the registration...");
        paidTicketing.editTicketForTheRegistration();
    }

    public void enableTheRegistration() {
        generalInfo.clickOnRegistrationToggle();
        generalInfo.clickOnEnableRegistrationButton();
    }

    public void toggleActionOnSendEmailConfirmation(String toggleAction) {
        eventAvailability.clickOnEventAvailabilityCard();
        emails.toggleActionOnSendEmailConfirmation(toggleAction);
    }

    public void toggleActionOnEmailFiledForTheRegistration(String toggleAction) {
        generalInfo.clickOnGeneralInfoEditIcon();
        customizeForm.toggleActionOnEmailAddress(toggleAction);
        customizeForm.clickOnApplyButton();
    }

    public void addRegistrationGating(String gatingType, String sharedPasscode, String mediaType, String mediaName, String productName, String passListName, String masterPasscode, String passcodeType) {
        registrationGating.clickOnRegistrationGatingToggle();
        registrationGating.addGateRequirements(gatingType, sharedPasscode, mediaType, mediaName, productName, passListName, masterPasscode, passcodeType);
    }

    public void changeThePasscodeLabel(String passcodeLabel) {
        registrationGating.changePasscodeLabel(passcodeLabel);
    }

    public void setEmailSenderName(String emailSenderName) {
        eventAvailability.clickOnEventAvailabilityCard();
        emails.setEmailSenderName(emailSenderName);
    }

    public void setBlockedEmailDomain(String blockedEmailDomain) {
        eventAvailability.setBlockedDomainEmail(blockedEmailDomain);
    }

    public void clickOnEvenAvailabilityCard() {
        eventAvailability.clickOnEventAvailabilityCard();
    }

    public void verifyAddedPasscodeList() {
        registrationGating.verifyAddedPasscodeList();
    }
}
