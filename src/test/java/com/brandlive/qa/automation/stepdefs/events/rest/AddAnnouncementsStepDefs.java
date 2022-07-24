package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.Map;

import com.brandlive.qa.automation.events.rest.AddAnnouncementRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class AddAnnouncementsStepDefs extends StepDefs {
	
	AddAnnouncementRest addAnnouncementRest = new AddAnnouncementRest();
	
	@And("^Add announcement for whole event$")
	public void Add_announcement_for_whole_event() {
		addAnnouncementRest.wholeEventAnnouncement(rest_Event_Host());
		Map<String, Object> wholeEventAnnouncementRes = AddAnnouncementRest.wholeEventAnnouncement;
		log.debug("The announcement message for whole event is " + wholeEventAnnouncementRes.get("msg"));
	}
	
	@And("^Add announcement for registered attendees$")
	public void Add_announcement_for_registered_attendees() {
		addAnnouncementRest.registeredAttendeesAnnouncement(rest_Event_Host());
		Map<String, Object> registeredAttendeesAnnouncementRes = AddAnnouncementRest.registeredAttendeesAnnouncement;
		log.debug("The announcement message for registered attendees is " + registeredAttendeesAnnouncementRes.get("msg"));
	}
	
	@And("^Add announcement for all sessions$")
	public void Add_announcement_for_all_sessions() {
		addAnnouncementRest.allSessionsAnnouncement(rest_Event_Host());
		Map<String, Object> allSessionsAnnouncementRes = AddAnnouncementRest.allSessionsAnnouncement;
		log.debug("The announcement message for all sessions is " + allSessionsAnnouncementRes.get("msg"));
	}

}
