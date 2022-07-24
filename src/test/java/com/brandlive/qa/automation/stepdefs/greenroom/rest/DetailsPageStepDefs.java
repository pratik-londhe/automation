package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import com.brandlive.qa.automation.greenroom.rest.DetailsPageRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DetailsPageStepDefs extends StepDefs {
	
	DetailsPageRest detailsPageRest= new DetailsPageRest();

	@And("^Create or Update Meeting Room$")
	public void Create_Update_Meeting_Room() {
		detailsPageRest.updateMeetingRoom(rest_GR_Host());
		log.debug("Meeting Room Number : " +detailsPageRest.meetingRoomNumber);
	}

	@And("^Load Shots$")
	public void Load_Shots() {
		detailsPageRest.loadShots(rest_GR_Host());
		List<Map<String, String>> loadShot_data = detailsPageRest.shots.getList("shot_data");
			 for (Map<String, String> loadShot : loadShot_data) {
				 log.debug(loadShot);
			 }
	}

	@And("^Get Meeting Room Details$")
	public void Get_Meeting_Room_Details() {
		detailsPageRest.meetingRoom(rest_GR_Host());

		log.debug("Meeting Id : " + detailsPageRest.meeting_id);
		log.debug("OpenTok_Sessions : " + detailsPageRest.opentok_session);
		log.debug("Session Title: " + detailsPageRest.meetingRoomDetails.getString("title"));
		log.debug("Event Name : " + detailsPageRest.meetingRoomDetails.getString("event_name"));
		log.debug("Event Session Id : " + detailsPageRest.meetingRoomDetails.getString("events_session_id"));
	}

	@And("^Get Media Details for Meeting Room$")
	public void Get_Media_Details() {
		detailsPageRest.getMediaDetails(rest_GR_Host());
		for (Map<String, Object> mediaDetails : detailsPageRest.meetingRoomMediaDetails) {
			log.debug("Id Details - " +mediaDetails.get("id"));
			log.debug("Custom Name - " +mediaDetails.get("custom_name"));
		}
	}

	@And("^Check Broadcast for Meeting Room$")
	public void Check_Broadcast_For_Meeting_Room() {
		detailsPageRest.checkBroadcast(rest_GR_Host());
	}

	@And("^Get RTMP Details for Meeting Room$")
	public void Get_RTMP_Meeting_Room_Details() {
		detailsPageRest.getRTMPDetails(rest_GR_Host());
		String rtmpAddress = detailsPageRest.RTMPRoomDetails.getString("rtmps_address");
		String streamKey = detailsPageRest.RTMPRoomDetails.getString("stream_key");

		log.debug("Rtmp Details for Meeting Room Number - " +detailsPageRest.meetingRoomNumber+ " are ");
		log.debug("Rtmp Address : " +rtmpAddress);
		log.debug("Stream Key : " +streamKey);

	}
	
	@And("^Get Opentok session Details for Meeting Room$")
	public void Get_Opentok_Details_For_Meeting_Room() {
		detailsPageRest.getOpentokDetails(rest_GR_Host());
	}
	
}
