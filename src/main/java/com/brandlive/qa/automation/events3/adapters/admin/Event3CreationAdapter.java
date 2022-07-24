package com.brandlive.qa.automation.events3.adapters.admin;

import com.brandlive.qa.automation.events3.pages.Dashboard;
import com.brandlive.qa.automation.events3.pages.admin.creation.EventCreation;
import com.brandlive.qa.automation.events3.pages.admin.EventHeader;
import com.brandlive.qa.automation.events3.pages.admin.EventTemplateSelection;
import com.brandlive.qa.automation.utils.Doer;

public class Event3CreationAdapter extends Doer {

    Dashboard dash = new Dashboard();
    EventTemplateSelection templateSelection = new EventTemplateSelection();
    EventCreation eventCreation = new EventCreation();
    EventHeader eventHeader = new EventHeader();

    public void checkChannelInEvents() {
        if (!dash.checkChannelSelectedInEvents3()) {
            dash.selectChannelInEvents3();
        }
    }

    public void createEvent() {
        dash.initiateEventCreation();
        templateSelection.selectEventTemplateAtRandom();
        eventCreation.createEventWithMultipleSessions();
    }

    public void createSingleBroadcastEvent(Boolean setEA, Boolean addLP) {
        log.info("Creating single broadcast session open event...");
        dash.initiateEventCreation();
        templateSelection.selectEventTemplateAtRandom();
        eventCreation.createEventWithSingleBroadcastSession(setEA, addLP);
    }

    public void publishEvent() {
        eventHeader.publishEvent();
    }

    public void createBreakoutV2EventWithTwoRoomsAdded() {
        log.info("Creating BreakoutV2 session event with two rooms added event...");
        dash.initiateEventCreation();
        templateSelection.selectEventTemplateAtRandom();
        eventCreation.addBreakOutV2SessionWithTwoRooms();
    }

    public void createEventWithOnDemandSession(Boolean setEA, Boolean addLP) {
        log.info("Creating Event with On Demand session...");
        dash.initiateEventCreation();
        templateSelection.selectEventTemplateAtRandom();
        eventCreation.createEventWithOnDemandSession(setEA, addLP);
    }

    public void createBroadcastEvent(Boolean setEA, Boolean addLP, String templateName) {
        log.info("Creating broadcast session open event...");
        dash.initiateEventCreation();
        templateSelection.selectTheTemplateForEvent(templateName);
        eventCreation.createEventWithSingleBroadcastSession(setEA, addLP);
    }

    public void addOnDemandSessionOnEventTab() {
        eventCreation.addOnDemandSessionOnEventTab();
    }

    public void clickOnPathingHeader() {
        eventHeader.clickOnHeaderPathingArrow();
    }

    public void createMultiBroadcastEvent(Boolean setEA, Boolean addLP, String templateName, String language) {
        log.info("Creating multi broadcast session open event...");
        dash.initiateEventCreation();
        templateSelection.selectTheTemplateForEvent(templateName);
        eventCreation.createEventWithMultiBroadcastSession(setEA, addLP, language);
    }

    public void createFiresideEvent(Boolean addLP) {
        log.info("Creating Fireside event...");
        dash.initiateEventCreation();
        templateSelection.selectEventTemplateAtRandom();
        eventCreation.addEventWithFiresideSession(addLP);
    }

    public void createAllTypesOFSessions() {
        log.info("Creating all types of sessions event...");
        dash.initiateEventCreation();
        templateSelection.selectEventTemplateAtRandom();
        eventCreation.createAllTypesOfSessions();
    }

    public void createFiresideSessionWithO2Event(Boolean addLP, String templateName) {
        log.info("Creating Fireside session with O2 event...");
        dash.initiateEventCreation();
        templateSelection.selectTheTemplateForEvent(templateName);
        eventCreation.addEventWithFiresideSession(addLP);
    }
}
