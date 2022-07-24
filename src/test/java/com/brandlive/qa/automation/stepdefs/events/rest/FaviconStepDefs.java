package com.brandlive.qa.automation.stepdefs.events.rest;

import static org.junit.Assert.*;

import java.util.Map;

import com.brandlive.qa.automation.events.rest.FaviconRest;
import com.brandlive.qa.automation.events.rest.UpdateEventRest;
import com.brandlive.qa.automation.events.rest.UploadRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class FaviconStepDefs extends StepDefs {

	FaviconRest faviconRest = new FaviconRest();
	UploadRest uploadRest = new UploadRest();
	UpdateEventRest updateEvent = new UpdateEventRest();
	
	// Located at src/test/resources/eventsmedia/images/beach.jpeg
	String filename = "beach.jpeg";	
	String fileNameSpecificStr = "_w612_h344.jpeg";
	
	@And("^Upload a favicon with social sharing$")
	public void upload_favicon_with_social_sharing() {
		uploadRest.uploadFile(rest_Event_Host(), filename, fileNameSpecificStr);
		faviconRest.faviconFileUpload(rest_Event_Host(), channel_name());
		
		Map<String, String> uploadedFaviconFileRes = FaviconRest.uploadFaviconFile;
		assertTrue("The upload favicon failed... ", uploadedFaviconFileRes.get("favicon").contains("uploads"));
		
		updateEvent.updateEventWithSocialSharingAddition(rest_Event_Host());
		assertEquals("The upload social sharing failed...", "OK", UpdateEventRest.updateEventWithSocialSharingAddition);
	}
	
	@And("^Delete a favicon with social sharing$")
	public void delete_favicon_with_social_sharing() {
		faviconRest.faviconFileDelete(rest_Event_Host(), channel_name());
		assertEquals("The delete favicon failed... ", 200, FaviconRest.deleteUploadFaviconFile);
		
		updateEvent.updateEventWithSocialSharingDeletion(rest_Event_Host(), channel_name());
		assertEquals("The uploaded social sharing deletion failed...", "OK", UpdateEventRest.updateEventWithSocialSharingDeletion);
	}
	
	
	
}
