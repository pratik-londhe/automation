package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.CreateEventsRest;
import com.brandlive.qa.automation.events.rest.CustomPagesRest;
import com.brandlive.qa.automation.events.rest.UpdateEventRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import static org.junit.Assert.*;

import cucumber.api.java.en.And;

public class CustomPagesStepDefs extends StepDefs {

	CustomPagesRest customPageRest = new CustomPagesRest();
	UpdateEventRest updateEventRest = new UpdateEventRest();
	CreateEventsRest createEventsRest = new CreateEventsRest();
	
	@And("^Add a custom page to event$")
	public void add_custom_page_to_event() {
		createEventsRest.getEventDetailsbyEventUuid(rest_Event_Host(), channel_name());
		customPageRest.addCustomPageToEvent(rest_Event_Host());
		updateEventRest.updateEventWithCustomPageAddition(rest_Event_Host());
		
		Map<String, Object> addCustomPageToEventRes = CustomPagesRest.addCustomPageToEvent;
		log.debug("The custom page path is " + addCustomPageToEventRes.get("path"));
		assertNotNull("The custom page path is empty... ", addCustomPageToEventRes.get("path"));
		log.debug("The custom page creation and event updation is " + UpdateEventRest.updateEventWithCPAddition);
		assertEquals("The event update is not success... ", "OK", UpdateEventRest.updateEventWithCPAddition);
	}
	
	@And("^Update a custom page to event$")
	public void update_custom_page_to_event() {
		createEventsRest.getEventDetailsbyEventUuid(rest_Event_Host(), channel_name());
		customPageRest.updateCustomPageToEvent(rest_Event_Host());
		updateEventRest.updateEventWithCustomPageUpdation(rest_Event_Host());
		
		Map<String, Object> updateCustomPageToEventRes = CustomPagesRest.updateCustomPageToEvent;
		log.debug("The custom page icon is " + updateCustomPageToEventRes.get("icon"));
		assertEquals("The custom page icon does not match... ", "infoOutline", updateCustomPageToEventRes.get("icon"));
		log.debug("The custom page updation and event updation is " + UpdateEventRest.updateEventWithCPUpdation);
		assertEquals("The event update is not success... ", "OK", UpdateEventRest.updateEventWithCPUpdation);
	}
	
	@And("^Get custom pages of event$")
	public void get_custom_pages_of_event() {
		customPageRest.getCustomPageOfEvent(rest_Event_Host(), channel_name());
		
		List<Map<String, Object>> getCustomPagesOfEventRes = CustomPagesRest.getCustomPagesOfEvent;
		for(Map<String, Object> custom_page : getCustomPagesOfEventRes) {
			log.debug("The custom page path is " + custom_page.get("path"));
			assertNotNull("The custom page path is empty... ", custom_page.get("path"));
		}
	}
}
