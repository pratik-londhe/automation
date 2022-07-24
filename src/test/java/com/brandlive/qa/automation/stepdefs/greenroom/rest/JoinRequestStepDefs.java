package com.brandlive.qa.automation.stepdefs.greenroom.rest;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.brandlive.qa.automation.greenroom.rest.JoinRequestRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;


public class JoinRequestStepDefs extends StepDefs {

	
	JoinRequestRest joinRequest = new JoinRequestRest();
	
	@And("^Check if meeting is live$")
	public void Check_if_meeting_is_live() {
		joinRequest.isMeetingLive(rest_GR_Host());
		assertEquals("Incorrect status code", 200, JoinRequestRest.isMeetingLive.getStatusCode());
		assertNotNull("Is Live path should not be empty", JoinRequestRest.isMeetingLive.jsonPath().get("is_live"));
	}
	

	@And("^Request join meeting$")
	public void Request_join_meeting() {
		joinRequest.sendApprovalRequest(rest_GR_Host());
		assertEquals("Incorrect status code", 200, JoinRequestRest.sendApprovalRequest.getStatusCode());
		assertNotNull("Join Request should not be empty", JoinRequestRest.sendApprovalRequest.jsonPath().get("join_request"));
	}

	
	@And("^Update Approve Join request$")
	public void Update_Approve_Join_request() {
		joinRequest.updateApprovalRequest(rest_GR_Host());
		assertEquals("Incorrect status code", 200, JoinRequestRest.updateApprovalRequest.getStatusCode());
	}

	@And("^Reject Join Request$")
	public void Reject_Join_Request() {
		joinRequest.rejectApprovalRequest(rest_GR_Host());
		assertEquals("Incorrect status code", 200, JoinRequestRest.rejectApprovalRequest.getStatusCode());
	}
	
	@And("^List Pending Join Request$")
	public void List_Pending_Join_Request() {
		joinRequest.listPendingJoinRequest(rest_GR_Host());
		assertEquals("Incorrect status code", 200, JoinRequestRest.listPendingJoinRequest.getStatusCode());
	}
	
	@And("^Check Join Request$")
	public void Check_Join_Request() {
		joinRequest.checkJoinRequest(rest_GR_Host());
		assertEquals("Incorrect status code", 200, JoinRequestRest.checkJoinRequest.getStatusCode());
		assertEquals("Approval should be false", false , JoinRequestRest.checkJoinRequest.jsonPath().get("approved"));
		assertEquals("Watcher state should be true", true , JoinRequestRest.checkJoinRequest.jsonPath().get("watcher_only"));

	}
	
	@And("^Check if Approval Required for joining$")
	public void Check_if_Approval_Required_for_joining() {
		joinRequest.checkifApprovalIsrequired(rest_GR_Host());
		assertEquals("Incorrect status code", 200, JoinRequestRest.checkifApprovalIsrequired.getStatusCode());
		assertEquals("Approval Required should be false", false , JoinRequestRest.checkifApprovalIsrequired.jsonPath().get("approval_required"));
	}
	
	@And("^Check Watcher only$")
	public void Check_Watcher_only() {
		joinRequest.checkWatcherState(rest_GR_Host());
		assertEquals("Incorrect status code", 200, JoinRequestRest.checkWatcherState.getStatusCode());
		assertEquals("Watcher state should be true", true , JoinRequestRest.checkWatcherState.jsonPath().get("watcher_only"));
	}
	
	
}
