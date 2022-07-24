package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.Map;

import com.brandlive.qa.automation.events.rest.DuplicateEventRest;
import com.brandlive.qa.automation.events.rest.PublishEventRest;
import com.brandlive.qa.automation.events.rest.UpdatePublishedEventURLRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class EventSessionBasicOperationStepDefs extends StepDefs {
	
	DuplicateEventRest duplicateEventRest = new DuplicateEventRest();
	PublishEventRest publishEventRest = new PublishEventRest();
	UpdatePublishedEventURLRest updatePublishedEventUrl = new UpdatePublishedEventURLRest();
	
	@And("^Duplicate Event$")
	public void duplicate_event() {
		duplicateEventRest.duplicateEvent(rest_Event_Host(), channel_name());
		Map<String, Object> duplicateEventMap = DuplicateEventRest.duplicateEvent;
		log.debug("The duplicate event name is " + duplicateEventMap.get("name") + " with uuid " + duplicateEventMap.get("uuid"));
	}
	
	@And("^Publish Duplicate Event$")
	public void publish_Duplicate_event() {
		publishEventRest.publishDuplicateEvent(rest_Event_Host());
		Map<String, Object> publishDuplicateEventMap = PublishEventRest.duplicateEventPublish;
		log.debug("The duplicate event name with uuid " + publishDuplicateEventMap.get("uuid") + " is published");
	}
	
	@And("^Update the duplicate published event URL$")
	public void Update_duplicate_published_event_URL() {
		updatePublishedEventUrl.updateDuplicateEventUrl(rest_Event_Host(), channel_name());
		log.debug("The duplicate event URL update is " + UpdatePublishedEventURLRest.response);
	}
	
	@And("^Delete the duplicated event$")
	public void delete_duplicated_event() {
		duplicateEventRest.deleteDuplicatedEvent(rest_Event_Host()); 
		Map<String, Object> duplicateEventDeleteRes = DuplicateEventRest.deleteEvent;
		log.debug("The duplicate event "+ duplicateEventDeleteRes.get("event") +" deleted. Status is " + duplicateEventDeleteRes.get("status"));
	}
	
	@And("^Update the duplicated event$")
	public void update_duplicated_event() {
		duplicateEventRest.updateDuplicatedEvent(rest_Event_Host()); 
		log.debug("The duplicate event is updated "+ DuplicateEventRest.updateEvent);
	}

}
