package com.brandlive.qa.automation.stepdefs.events.rest;


import com.brandlive.qa.automation.events.rest.CreateEventsRest;
import com.brandlive.qa.automation.events.rest.PublishEventRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import io.restassured.path.json.JsonPath;

import cucumber.api.java.en.And;

public class PublishEventStepDefs extends StepDefs {
	
	CreateEventsRest createEventsRestAdapter = new CreateEventsRest();
	PublishEventRest publishEventRestAdapter = new PublishEventRest();

	
	@And("^Publish Event$")
	public void Publish_Event() {
		publishEventRestAdapter.publishEvent(rest_Event_Host());
		JsonPath publishEvent   = PublishEventRest.eventPublish;
		log.debug("Publish event uuid is " +publishEvent.getString("uuid"));  
	}
	
	
	@And("^Check Published Event Status$")
	public void Check_published_Event_Status () {
		createEventsRestAdapter.EventStatus(rest_Event_Host(),channel_name());
		int eventPublishStatusCode = CreateEventsRest.checkEventPublishStatus;
		if (eventPublishStatusCode == 1) {
			log.debug("Event is published with status code : " + eventPublishStatusCode);
		} else {
			log.error("Event is not published with status code : " + eventPublishStatusCode);
		}
	}
	
	
	@And("^Publish E2 Event$")
	public void Publish_E2_Event() {
		publishEventRestAdapter.publishE2Event(rest_Event_Host(), channel_name());
		JsonPath publishE2Event   = PublishEventRest.eventE2Publish;
		log.debug("E2Event Id is  " +publishE2Event.getString("insertId"));  
	}

}
