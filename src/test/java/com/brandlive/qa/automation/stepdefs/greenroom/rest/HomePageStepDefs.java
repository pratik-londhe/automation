package com.brandlive.qa.automation.stepdefs.greenroom.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.CreateEventsRest;
import com.brandlive.qa.automation.greenroom.rest.HomePageRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class HomePageStepDefs extends StepDefs {
	
	HomePageRest homeRestAdapter = new HomePageRest();
	CreateEventsRest createEventsRestAdapter = new CreateEventsRest();
	
	@And("^Check all GR channels$")
	public void Check_all_GR_channels() {
		
		homeRestAdapter.grChannels(rest_GR_Host(), gr_Event_Entry_Mode(), channel_name());
		Map<String, Object> channel = new HashMap<String, Object>();
		if(gr_Event_Entry_Mode().contains("3.0")) {
			channel = HomePageRest.e3ChannelInfo;
			log.debug("GR E3 channel id " + channel.get("channel") + " for the channel " + channel_name());
		}
		if(gr_Event_Entry_Mode().contains("2.5")) {
			channel = HomePageRest.e2ChannelInfo;
			log.debug("GR E2 channel id " + channel.get("channel") + " for the channel " + channel_name());
		}
	}
	
	@And("^Get all GR Events$")
	public void Get_all_GR_Events() {
		
		String eventName = createEventsRestAdapter.eventName;
		
		if(gr_Event_Entry_Mode().contains("3.0")) {
			int channelId = (int) HomePageRest.e3ChannelInfo.get("channel");
			homeRestAdapter.getAllE3Events(rest_GR_Host(), channelId,eventName);
			Map<String, Object> e3EventDetail = HomePageRest.e3EventDetails;
			log.debug("E3 Event Detail has title : " + e3EventDetail.get("event_name"));
			if ((eventName).equalsIgnoreCase((String) e3EventDetail.get("event_name"))){
				log.debug("Event Name Matches!");
			}else {
				log.error("Event Name are not same " +eventName+ " != " +(String) e3EventDetail.get("event_name"));
			}
		}
		
		if(gr_Event_Entry_Mode().contains("2.5")) {
			homeRestAdapter.getAllE2Events(rest_GR_Host(), eventName);
			Map<String, Object> e2EventDetail = HomePageRest.e2EventDetails;
			log.debug("E2 Event Detail has title : " + e2EventDetail.get("title"));
			if ((eventName).equalsIgnoreCase((String) e2EventDetail.get("title"))){
				log.debug("Event Name Matches!");
			}else {
				log.error("Event Name are not same " +eventName+ " != " +(String) e2EventDetail.get("title"));
			}
		}
		
	}
	
	@And("^Check all Standalone GR channels$")
	public void Get_all_SGR_channels() {
		homeRestAdapter.getAllStandaloneChannels(rest_GR_Host(), channel_name());
		Map<String, Object> channel = HomePageRest.sGRChannelInfo;
		log.debug("SGR channel id " + channel.get("channel") + " for the channel " + channel_name());
		
	}
	
	@And("^Check all Standalone GR events$")
	public void Get_all_SGR_events() {
		homeRestAdapter.getAllStandaloneEvents(rest_GR_Host(), channel_name());
		Map<Integer, String> sgrEventDetail = HomePageRest.sGREventDetails;
		log.debug("List of Meeting id and event Name for " +channel_name()+ " are  : " + sgrEventDetail.toString());

	}
	
	@And("^Create new Standalone GR Event$")
	public void Create_new_SGR_Event() {
		homeRestAdapter.createNewSgrEvent(rest_GR_Host());
		log.debug("SGR new Event Created meeting id " + homeRestAdapter.newSGREventId  +" for the channel " + channel_name());
		
	}
	
	@And("^Check newly created Standalone GR Event$")
	public void Verify_New_SGR_event() {
		homeRestAdapter.getAllStandaloneEvents(rest_GR_Host(), channel_name());
		Map<Integer, String> sgrEventDetail = HomePageRest.sGREventDetails;
		 
		// using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<Integer,String> eventId : sgrEventDetail.entrySet())
        	if (eventId.getKey().equals(homeRestAdapter.newSGREventId)) {
        		log.debug("StandAlone New Event has created successfully with meeting id : " + eventId.getKey() +
                             " and title  :  " + eventId.getValue());
        	}
	}
	
}
