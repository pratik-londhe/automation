package com.brandlive.qa.automation.events3.adapters.live;

import com.brandlive.qa.automation.events3.pages.live.*;
import com.brandlive.qa.automation.utils.Doer;

public class Event3LiveRegistrationAdapter extends Doer {

    GeneralInfo liveRegistrationGeneralInfo = new GeneralInfo();
    TicketInfo liveTicketInfo = new TicketInfo();
    ProfileInfo profileInfo = new ProfileInfo();
    AvatarInfo avatarInfo = new AvatarInfo();
    EventLandingPage eventLandingPage = new EventLandingPage();

    public void userGeneralInfo(String fName, String lName, String email, String passcode) {
        liveRegistrationGeneralInfo.enterGeneralInfo(fName, lName, email, passcode);
    }

    public void userTicketCheckoutDetails(String email, String cardName, String cardNumber, String expiration, String cvv) {
        liveTicketInfo.enterTicketsCheckoutDetails(email, cardName, cardNumber, expiration, cvv);
    }

    public void userProfileInfo(String companyName, String bioText, String funFactText, String location) {
        profileInfo.enterProfileInfo(companyName, bioText, funFactText, location);
    }

    public void userUploadAvatarDetails(String mediaType, String mediaName, String productName) {
        avatarInfo.uploadAvatarDetails(mediaType, mediaName, productName);
    }

    public void clickOnTheRegistrationButton() {
        eventLandingPage.clickOnRegistrationButton();
    }

    public void enterGeneralInfoWithoutEmail(String fName, String lName) {
        liveRegistrationGeneralInfo.enterGeneralInfoWithoutEmail(fName, lName);
    }

    public void verifyBlockedEmailDomainMessage() {
        liveRegistrationGeneralInfo.verifyMessageForBlockedEmailDomain();
    }

    public void verifyThePasscodeLabelIsChanged(String passcodeLabel) {
        liveRegistrationGeneralInfo.verifyThePasscodeLabelChanged(passcodeLabel);
    }

    public void verifyTicketSoldOutMessage(String ticketSoldOutMessage) {
        liveRegistrationGeneralInfo.verifyTicketIsSoldOutMessage(ticketSoldOutMessage);
    }

    public void verifyGeneralInfoPage(String generalInfoPageMessage) {
        liveRegistrationGeneralInfo.verifyTheGeneralInfoPage(generalInfoPageMessage);
    }

    public void logOutFromLiveEvent() {
        eventLandingPage.logOutFromLiveEvent();
    }

    public void verifySignInPage(String signInMessage) {
        liveRegistrationGeneralInfo.verifySignInPage(signInMessage);
    }
}