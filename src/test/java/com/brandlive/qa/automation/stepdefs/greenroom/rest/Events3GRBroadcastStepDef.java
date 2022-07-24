package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.brandlive.qa.automation.greenroom.rest.Events3GRBroadcastRest;
import com.brandlive.qa.automation.greenroom.rest.JoinRequestRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;


public class Events3GRBroadcastStepDef extends StepDefs {


	
	Events3GRBroadcastRest events3GRBroadcastRest = new Events3GRBroadcastRest();
	
	// Broadcast Api's 
	
	@And("^Create manual Broadcast server$")
	public void Create_manual_Broadcast_server() {
		events3GRBroadcastRest.createInternalServer(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.createInternalServer.getStatusCode());
		assertNotNull("Server id should not be empty", events3GRBroadcastRest.createInternalServer.jsonPath().get("server"));
	}
	

	@And("^Get Broacast server$")
	public void Get_Broacast_server() {
		events3GRBroadcastRest.checkBroadcastServer(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.createInternalServer.getStatusCode());
		assertEquals("Incorrect Id", events3GRBroadcastRest.createInternalServer.jsonPath().getInt("server"),
				events3GRBroadcastRest.checkBroadcastServer.jsonPath().getInt("id"));

	}

	
	@And("^Get Events Legacy RTMP Broadcast address$")
	public void Get_Events_Legacy_RTMP_Broadcast_address() {
		events3GRBroadcastRest.checkLegacyRtmpAddress(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.checkLegacyRtmpAddress.getStatusCode());
		assertNotNull("Events Legacy should have an RTMP Url", events3GRBroadcastRest.checkLegacyRtmpAddress.jsonPath().get("url"));
	}

	@And("^Update RTMP End point$")
	public void Update_RTMP_End_point() {
		events3GRBroadcastRest.updateRtmpEndPoint(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.updateRtmpEndPoint.getStatusCode());
		//assertEquals("Incorrect custom Endpoint", "1", events3GRBroadcastRest.updateRtmpEndPoint.asString());

	}
	
	@And("^Update RTMP Custom End point$")
	public void Update_RTMP_Custom_End_point() {
		events3GRBroadcastRest.updateRtmpCustomEndPoint(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.updateRtmpEndPoint.getStatusCode());
		assertEquals("Incorrect name", "test",  events3GRBroadcastRest.updateRtmpCustomEndPoint.jsonPath().get("name"));
		assertEquals("Incorrect rtmp address", "rtmps://",  events3GRBroadcastRest.updateRtmpCustomEndPoint.jsonPath().get("url"));
		assertEquals("Incorrect rtmp key", "123",  events3GRBroadcastRest.updateRtmpCustomEndPoint.jsonPath().get("stream_key"));

		
	}
	
	@And("^Start Broadcast server$")
	public void Start_broadcast_server() {
		events3GRBroadcastRest.startBroadcastServer(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.startBroadcastServer.getStatusCode());
	}
	
	@And("^Autostart Broadcast server$")
	public void Autostart_broadcast_server() {
		events3GRBroadcastRest.autoStartBroadcastServer(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.autoStartBroadcastServer.getStatusCode());

	}
	
	@And("^Set Stream State$")
	public void Set_Stream_State() {
		events3GRBroadcastRest.setSetStream(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.setSetStream.getStatusCode());

	}
	
	@And("^Check Stream State$")
	public void Check_Stream_State() {
		events3GRBroadcastRest.checkStreamState(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.checkStreamState.getStatusCode());

	}
	
	@And("^Write Broadcast server error logs$")
	public void Write_Broadcast_server_error_logs() {
		events3GRBroadcastRest.writeBroadcastError(rest_GR_Host());
	}
	
	@And("^Get Broadcast server error logs$")
	public void Get_Broadcast_server_error_logs() {
		events3GRBroadcastRest.fetchBroadcastError(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.fetchBroadcastError.getStatusCode());
		assertNotNull("Error log url path should be present", events3GRBroadcastRest.fetchBroadcastError.jsonPath().get("logUrl"));

	}
	
	@And("^Reset Broadcast server State$")
	public void Reset_Broadcast_server_State() {
		events3GRBroadcastRest.resetBroadcastState(rest_GR_Host());
		assertEquals("Incorrect status code", 200, events3GRBroadcastRest.resetBroadcastState.getStatusCode());
		assertNotNull("Starting_up path should be present", events3GRBroadcastRest.resetBroadcastState.jsonPath().get("starting_up"));

	}
	
}
