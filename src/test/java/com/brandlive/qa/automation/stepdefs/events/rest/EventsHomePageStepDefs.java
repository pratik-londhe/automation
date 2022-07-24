package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.EventsHomePageRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class EventsHomePageStepDefs extends StepDefs {
	
	EventsHomePageRest eventsHomePageRestAdapter = new EventsHomePageRest();
	
	@And("^Check all E3 channels$")
	public void Check_all_E3_channels() {		
		eventsHomePageRestAdapter.e3Channels(rest_Event_Host(), channel_name());
		Map<String, Object> channel = new HashMap<String, Object>();
		channel = EventsHomePageRest.e3ChannelInfo;
		log.debug("E3 channel id " + channel.get("channel") + " for the channel " + channel_name());
	}
	
	@And("^Get Events by channel Id$")
	public void Get_Events_by_channelId(){
		eventsHomePageRestAdapter.getChannelEvents(rest_Event_Host(),channel_name());
		List<Map<String, Object>> eventDetailsByChannel  = EventsHomePageRest.eventDetailsByChannelId;
		log.debug("There are total of " + eventDetailsByChannel.size() + " events for the channel " +channel_name());
	}
	
	@And("^Check all E2 channels$")
	public void Check_all_E2_channels() {
		eventsHomePageRestAdapter.e2Channels(rest_Event_Host(),channel_name());
		Map<String, Object> E2channel   = eventsHomePageRestAdapter.e2ChannelInfo;
		log.debug("E2 channel id " + E2channel.get("client") + " for the channel " + channel_name());
	}

}
