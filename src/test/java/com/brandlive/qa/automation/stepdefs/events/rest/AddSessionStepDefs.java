package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.AddNewSessionRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class AddSessionStepDefs extends StepDefs {

	AddNewSessionRest addNewSessionRest = new AddNewSessionRest();
	
	@And("^Add new Broadcast session$")
	public void Add_new_Broadcast_session() {
		addNewSessionRest.AddNewBroadcastSession(rest_Event_Host(), channel_name());
		Map<String, Object> newBroadcastSessionRes = AddNewSessionRest.addBroadcastSessionResponse;
		log.debug("The new broadcast session id is " + newBroadcastSessionRes.get("session") + " and UUID is " + newBroadcastSessionRes.get("uuid"));
	}
	
	@And("^Get Session by Id$")
	public void Get_session_By_Id() {
		addNewSessionRest.GetBroadcastSessionById(rest_Event_Host());
		Map<String, Object> getSessionByIdRes = AddNewSessionRest.getBroadcastSessionByIdResponse;
		log.debug("The session id is " + getSessionByIdRes.get("session") + " and UUID is " + getSessionByIdRes.get("uuid"));
	}
	
	@And("^Get Session by Uuid$")
	public void Get_session_By_Uuid() {
		addNewSessionRest.GetBroadcastSessionByUuid(rest_Event_Host(), channel_name());
		List<Map<String, Object>> getSessionByUuidRes = AddNewSessionRest.getBroadcastSessionByUuidResponse;
		log.debug("The event left with " + getSessionByUuidRes.size() + " sessions now." );
	}
	
	@And("^Update Broadcast session for schedule$")
	public void Update_Broadcast_session_for_schedule() {
		addNewSessionRest.updateSession(rest_Event_Host());
		Map<String, Object> updateSessionRes = AddNewSessionRest.updateSessionResponse;
		log.debug("The id of updated session is " + updateSessionRes.get("session") );
	}
	
	@And("^Delete session by id$")
	public void Delete_session_by_id() {
		addNewSessionRest.deleteSessionBySessionId(rest_Event_Host());
		Map<String, Object> deleteSessionRes = AddNewSessionRest.deleteSessionResponse;
		log.debug("The id of deleted session is " + deleteSessionRes.get("session") );
	}
	
	@And("^Get session RTMP details$")
	public void Get_session_RTMP_details() {
		addNewSessionRest.GetSessionRtmp(rest_Event_Host());
		Map<String, Object> sessionRTMPRes = AddNewSessionRest.getSessionRtmpResponse;
		log.debug("The rtmps address of session is " + sessionRTMPRes.get("rtmps_address") + " and stream key is " + sessionRTMPRes.get("stream_key"));
	}
	
}
