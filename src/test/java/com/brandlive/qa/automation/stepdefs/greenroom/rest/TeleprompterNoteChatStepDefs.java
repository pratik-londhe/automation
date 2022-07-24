package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import java.io.IOException;

import com.brandlive.qa.automation.greenroom.rest.ChatRest;
import com.brandlive.qa.automation.greenroom.rest.NotesRest;
import com.brandlive.qa.automation.greenroom.rest.TeleprompterRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import com.fasterxml.jackson.core.JsonProcessingException;

import cucumber.api.java.en.And;


public class TeleprompterNoteChatStepDefs extends StepDefs {


	ChatRest chatRest = new ChatRest();
	NotesRest notesRest = new NotesRest();
	TeleprompterRest teleprompterRest = new TeleprompterRest();
	
	// Chat Api's 
	
	@And("^Create Chat Message$")
	public void Create_Chat_Message() {
		chatRest.createChatMessage(rest_GR_Host());
	}
	
	@And("^Get Chat Direct Message by meeting id$")
	public void Get_Chat_Direct_Message_by_meeting_id() {
		chatRest.directMsgByMeetingId(rest_GR_Host());
	}
	
	@And("^Get Chat of Room by meeting id$")
	public void Get_Chat_of_Room_by_meeting_id() {
		chatRest.chatRoomMsgByMeetingId(rest_GR_Host());
	}
	
	
	// Notes Api's 
	
	@And("^Create a Note$")
	public void Create_a_Note() {
		notesRest.createNote(rest_GR_Host());
	}
	
	@And("^Save and Share a Note$")
	public void Save_and_Share_a_Note() {
		notesRest.saveAndshareNote(rest_GR_Host());
	}
	
	@And("^Get All Notes$")
	public void Get_All_Notes() {
		notesRest.allNotes(rest_GR_Host());
	}
	
	@And("^Update Note by Id and Meeting Id$")
	public void Update_Note_by_Id_and_Meeting_Id() {
		notesRest.updateNote(rest_GR_Host());
	} 
	
	
	// Telepromter Api's 
	    
	@And("^Create a Teleprompter$")
	public void Create_a_Teleprompter() {
		teleprompterRest.createTeleprompter(rest_GR_Host());
	}
	
	@And("^Update Teleprompter by id$")
	public void Update_Teleprompter_by_id() throws JsonProcessingException, IOException {
		teleprompterRest.updateTeleprompter(rest_GR_Host());
	} 
	
	@And("^Share Teleprompter by id$")
	public void Share_Teleprompter_by_id() {
		teleprompterRest.shareTeleprompter(rest_GR_Host());
	}
	
	
	@And("^Get Teleprompter information by id$")
	public void Get_Teleprompter_information_by_id() {
		teleprompterRest.teleprompterDetails(rest_GR_Host());
	}

	@And("^Search Teleprompter$")
	public void Search_Teleprompter() {
		teleprompterRest.searchTeleprompter(rest_GR_Host());
	}

	@And("^Create Teleprompter Section by id$")
	public void Create_Teleprompter_Section_by_id() {
		teleprompterRest.createTeleprompterSection(rest_GR_Host());
	}

	@And("^Update Teleprompter Section by id$")
	public void Update_Teleprompter_Section_by_id() {
		teleprompterRest.updateTeleprompterSection(rest_GR_Host());
	}
}
