package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import com.brandlive.qa.automation.greenroom.rest.ActiveRoomRest;
import com.brandlive.qa.automation.greenroom.rest.CreateNotificationRest;
import com.brandlive.qa.automation.greenroom.rest.EventsForProducer;
import com.brandlive.qa.automation.greenroom.rest.FindUsersRest;
import com.brandlive.qa.automation.greenroom.rest.InvitationRest;
import com.brandlive.qa.automation.greenroom.rest.SessionRest;
import com.brandlive.qa.automation.greenroom.rest.LoadTeamsRest;
import com.brandlive.qa.automation.greenroom.rest.PresenterInvitation;
import com.brandlive.qa.automation.greenroom.rest.RetrieveNotificationRest;
import com.brandlive.qa.automation.greenroom.rest.SetSeenNotification;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;


public class NotificationInvitationStepDefs extends StepDefs {


	LoadTeamsRest loadTeamRest = new LoadTeamsRest();
	FindUsersRest findUserRest = new FindUsersRest();
	ActiveRoomRest activeRoomRest = new ActiveRoomRest();
	PresenterInvitation presenterInvitationRest = new PresenterInvitation();
	EventsForProducer eventforProduver = new EventsForProducer();
	CreateNotificationRest createNotificationRest = new CreateNotificationRest();
	RetrieveNotificationRest retrieveNotificationRest = new RetrieveNotificationRest();
	SetSeenNotification setSeenNotification = new SetSeenNotification();
	SessionRest gRSessionApiRest = new SessionRest();
	InvitationRest gRInvitationApiRest = new InvitationRest();
	
	// Home Apis 
	
	@And("^Load Teams$")
	public void Load_Teams() {
		loadTeamRest.loadTeams(rest_GR_Host());
	}
		
	@And("^Find Users$")
	public void Find_Users() {
		findUserRest.findUsers(rest_GR_Host());
	}
	
	@And("^Get Active Rooms$")
	public void Get_Active_Room() {
		activeRoomRest.getActiveRoomDetails(rest_GR_Host());
	}
		
	@And("^Get Events for Producer$")
	public void Get_Events_for_Producer() {
		eventforProduver.getEventForProducer(rest_GR_Host());
	}
	
	@And("^Get Presenter Invitation Call$")
	public void Get_Presenter_Invitation_Call() {
		presenterInvitationRest.presenterInvitationCall(rest_GR_Host());
	}
	
	// Notification Apis 
	
	@And("^Create Notification$")
	public void Create_Notification() {
		createNotificationRest.createNotification(rest_GR_Host());
	}
	
	@And("^Retrieve Notitication$")
	public void Retrieve_Notitication() {
		retrieveNotificationRest.retrieveNotificationDetails(rest_GR_Host());
	}
	
	@And("^Set Seen Notification$")
	public void Set_Seen_Notification() {
		setSeenNotification.setSeenNotification(rest_GR_Host());
	}
	
	// Session Apis 
	
	@And("^Get Session Types$")
	public void Get_Session_Types() {
		gRSessionApiRest.sessionTypes(rest_GR_Host());
	}
	
	@And("^Get Session Details by Meeting Id$")
	public void Get_Session_Details_by_Meeting_Id() {
		gRSessionApiRest.sessionDetailbyMeetingId(rest_GR_Host());
	}
	
	@And("^Create Session$")
	public void Create_Session() {
		gRSessionApiRest.createSession(rest_GR_Host());
	}
	
	@And("^Update Session$")
	public void Update_Session() {
		gRSessionApiRest.updateSession(rest_GR_Host());
	}
	
	@And("^Delete Session$")
	public void Delete_Session() {
		gRSessionApiRest.deleteSession(rest_GR_Host());
	}
	
	@And("^Check Producer for Session Call$")
	public void Check_Producer_for_Session_Call() {
		gRSessionApiRest.isProducerforSessionCall(rest_GR_Host());
	}


	// Invitation Apis 
	
	@And("^Create Invitation$")
	public void Create_Invitation() {
		gRInvitationApiRest.createInvitation(rest_GR_Host(),channel_name());
	}

	@And("^Create Multiple Invitations$")
	public void Create_Multiple_Invitations() {
		gRInvitationApiRest.createMultipleInvitation(rest_GR_Host());
	}

	@And("^Create Invitation Notification$")
	public void Create_Invitation_Notification() {
		gRInvitationApiRest.createNotificationForInvitation(rest_GR_Host());
	}

	@And("^Create iOS Notification$")
	public void Create_iOS_Notification() {
		gRInvitationApiRest.createiOSNotification(rest_GR_Host());
	}

	@And("^Get Invitation by Meeting Id$")
	public void Get_Invitation_by_Meeting_Id() {
		gRInvitationApiRest.invitationDetailsByMeetingId(rest_GR_Host());
	}

	@And("^Revoke Invitation$")
	public void Revoke_Invitation() {
		gRInvitationApiRest.revokeInvitation(rest_GR_Host());
	}	
	
}
