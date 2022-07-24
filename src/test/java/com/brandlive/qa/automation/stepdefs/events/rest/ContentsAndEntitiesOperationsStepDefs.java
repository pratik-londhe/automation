package com.brandlive.qa.automation.stepdefs.events.rest;

import static org.junit.Assert.*;

import java.util.Map;

import com.brandlive.qa.automation.events.rest.AddNewSessionRest;
import com.brandlive.qa.automation.events.rest.DocumentsRest;
import com.brandlive.qa.automation.events.rest.EventRegistrationsRest;
import com.brandlive.qa.automation.events.rest.ProductsRest;
import com.brandlive.qa.automation.events.rest.SpeakersRest;
import com.brandlive.qa.automation.events.rest.SponsorsRest;
import com.brandlive.qa.automation.events.rest.SurveysRest;
import com.brandlive.qa.automation.events.rest.UpdateEventRest;
import com.brandlive.qa.automation.events.rest.UploadRest;
import com.brandlive.qa.automation.events.rest.VideosRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class ContentsAndEntitiesOperationsStepDefs extends StepDefs {

	ProductsRest productsRest = new ProductsRest();
	UploadRest uploadRest = new UploadRest();
	UpdateEventRest updateEventRest = new UpdateEventRest();
	SponsorsRest sponsorsRest = new SponsorsRest();
	SpeakersRest speakersRest = new SpeakersRest();
	VideosRest videoRest = new VideosRest();
	DocumentsRest documentRest = new DocumentsRest();
	AddNewSessionRest sessionRest = new AddNewSessionRest();
	SurveysRest surveysRest = new SurveysRest();
	EventRegistrationsRest eventRegistrationsRest = new EventRegistrationsRest();
	
	@And("^Add a channel product to event$")
	public void Add_channel_product_to_event() {
		productsRest.getChannelProducts(rest_Event_Host(), channel_name());
		productsRest.getFirstProductFromListOfChannelProducts();
		productsRest.addExistingProductToEvent(rest_Event_Host());
		
		assertEquals("Add channel product to event failed...", ProductsRest.addedProductMap.get("product") , 
				ProductsRest.selectedProduct.get("product"));
		
		updateEventRest.addExistingProductToEvent(rest_Event_Host(), channel_name());
		
		assertEquals("Update event with new product info failed...", "OK" , 
				UpdateEventRest.addExistingProductToEvent);
	}
	
	@And("^Upload a new product to channel$")
	public void Upload_new_product_to_channel() {
		// Located at src/test/resources/eventsmedia/images/glasses.jpeg
		String filename = "glasses.jpeg";	
		String fileNameSpecificStr = "_w275_h183.jpeg";
		
		uploadRest.uploadFile(rest_Event_Host(), filename, fileNameSpecificStr);
		productsRest.uploadNewProductFile(rest_Event_Host());
		
		Map<String, Object> uploadedProductFileRes = ProductsRest.insertedProduct;
		assertNotNull("The upload product failed... ", uploadedProductFileRes.get("product"));
	}
	
	@And("^Delete the newly uploaded product to channel$")
	public void Delete_the_newly_uploaded_product_to_channel() {
		productsRest.deleteUploadedProduct(rest_Event_Host());
		Map<String, Object> deletedProductFileRes = ProductsRest.deletedProduct;
		assertNotNull("The delete product failed... ", deletedProductFileRes.get("deletedProducts"));
	}
	
	@And("^Add a channel sponsor to event$")
	public void Add_channel_sponsor_to_event() {
		sponsorsRest.getChannelSponsors(rest_Event_Host(), channel_name());
		sponsorsRest.getFirstSponsorFromListOfChannelSponsors();
		sponsorsRest.addExistingSponsorToEvent(rest_Event_Host());
		
		assertEquals("Add channel sponsor to event failed...", SponsorsRest.addedSponsorMap.get("sponsor") , 
				SponsorsRest.selectedSponsor.get("sponsor"));
		
		updateEventRest.addExistingSponsorToEvent(rest_Event_Host(), channel_name());
		
		assertEquals("Update event with new sponsor info failed...", "OK" , 
				UpdateEventRest.addExistingSponsorToEvent);
	}
	
	@And("^Add a channel speaker to event$")
	public void Add_channel_speaker_to_event() {
		speakersRest.getChannelSpeakers(rest_Event_Host(), channel_name());
		speakersRest.getFirstSpeakerFromListOfChannelSpeakers();
		speakersRest.addExistingSpeakerToEvent(rest_Event_Host());
		
		assertEquals("Add channel speaker to event failed...", "OK" , 
				SpeakersRest.addedSpeakerMap.get("return"));
		
		updateEventRest.addExistingSpeakerToEvent(rest_Event_Host(), channel_name());
		
		assertEquals("Update event with new speaker info failed...", "OK" , 
				UpdateEventRest.addExistingSpeakerToEvent);
	}
	
	@And("^Upload a new video to channel$")
	public void Upload_new_video_to_channel() {
		// Located at src/test/resources/eventsmedia/videos/video.mp4
		String filename = "video.mp4";			
		uploadRest.uploadFile(rest_Event_Host(), filename, null);
		uploadRest.uploadFile(rest_Event_Host(), "thumbnail.jpg", null);
		
		videoRest.uploadNewVideoFile(rest_Event_Host(), filename);
		
		Map<String, Object> uploadedVideoFileRes = VideosRest.insertedVideo;
		assertNotNull("The upload video failed... ", uploadedVideoFileRes.get("video"));
	}
	
	@And("^Delete the newly uploaded video to channel$")
	public void Delete_the_newly_uploaded_video_to_channel() {
		videoRest.deleteUploadedVideo(rest_Event_Host());
		Map<String, Object> deletedVideoFileRes = VideosRest.deletedVideo;
		assertNotNull("The delete video failed... ", deletedVideoFileRes.get("videoIDs"));
	}
	
	@And("^Add a channel video to event$")
	public void Add_channel_video_to_event() {
		videoRest.getChannelVideos(rest_Event_Host(), channel_name());
		videoRest.getFirstVideoFromListOfChannelVideos();
		
		updateEventRest.addExistingVideoToEvent(rest_Event_Host(), channel_name());
		
		assertEquals("Update event with new video info failed...", "OK" , 
				UpdateEventRest.addExistingVideoToEvent);
	}
	
	@And("^Get Recorded Videos by channel Id$")
	public void Get_recorded_video_by_channel_id() {
		videoRest.getChannelVideos2(rest_Event_Host(), channel_name());
		assertTrue("Get videos info failed...", VideosRest.channelVideos2.size() > 0);
		
		videoRest.getChannelRecordedVideos(rest_Event_Host(), channel_name());
		assertTrue("Get recorded videos info failed...", VideosRest.channelRecordedVideos.size() > 0);
		
		videoRest.getChannelUStreamVideos(rest_Event_Host(), channel_name());		
		assertEquals("Get UStream videos info failed...", 200, VideosRest.channelUStreamVideos);
	}
	
	@And("^Upload a new document to channel$")
	public void Upload_new_document_to_channel() {
		// Located at src/test/resources/eventsmedia/documents/sample-pdf-file.pdf
		String filename = "sample-pdf-file.pdf";	
		
		uploadRest.uploadFile(rest_Event_Host(), filename, null);
		documentRest.uploadNewDocumentFile(rest_Event_Host(), filename);
		
		Map<String, Object> uploadedDocumentFileRes = DocumentsRest.uploadedDocument;
		assertNotNull("The upload document failed... ", uploadedDocumentFileRes.get("document"));
		assertEquals("The upload document conversion failed...", "OK", DocumentsRest.convertedDocument);
	}
		
	@And("^Delete the newly uploaded document to channel$")
	public void Delete_the_newly_uploaded_document_to_channel() {
		String filename = "sample-pdf-file.pdf";
		documentRest.deleteUploadedDocument(rest_Event_Host(), filename);
		Map<String, Object> deletedDocumentFileRes = DocumentsRest.deletedDocument;
		assertNotNull("The delete document failed... ", deletedDocumentFileRes.get("deletedDocuments"));
	}
	
	@And("^Add a channel document to event session$")
	public void Add_channel_document_to_event_session() {
		sessionRest.GetBroadcastSessionByUuid(rest_Event_Host(), channel_name());
		int sessionId = 0;
		for(Map<String, Object> session : AddNewSessionRest.getBroadcastSessionByUuidResponse) {
			sessionId = (int) session.get("session");
		}
		sessionRest.GetBroadcastSessionById(rest_Event_Host(), sessionId);
		documentRest.getChannelDocuments(rest_Event_Host(), channel_name());
		documentRest.getFirstDocumentFromListOfChannelDocuments();
		sessionRest.updateSessionWithDocument(rest_Event_Host());
		
		assertNotNull("Update event session with existing document info failed...",  AddNewSessionRest.updateSessionWithDocResponse);
	}
	
	@And("Add a channel survey to event session")
	public void Add_channel_survey_to_event_session() {
		sessionRest.GetBroadcastSessionByUuid(rest_Event_Host(), channel_name());
		int sessionId = 0;
		for(Map<String, Object> session : AddNewSessionRest.getBroadcastSessionByUuidResponse) {
			sessionId = (int) session.get("session");
		}
		sessionRest.GetBroadcastSessionById(rest_Event_Host(), sessionId);
		
		surveysRest.getChannelSurveys(rest_Event_Host(), channel_name());
		surveysRest.channelSurveysByChannelId(rest_Event_Host(), channel_name());
		surveysRest.getAutomationPollSurveyInChannel();
		assertTrue("There are no surveys in the channel..failed..", SurveysRest.channelSurveys.size() > 0);
		assertTrue("There are no surveys in the channel..failed..", SurveysRest.surveysByChannelId.size() > 0);
		
		sessionRest.updateSessionWithSurvey(rest_Event_Host());
		assertNotNull("Update event session with existing survey info failed...",  AddNewSessionRest.updateSessionWithSurveyResponse);
	}
	
	@And("Get all registrations for an event")
	public void Get_all_registrations_for_an_event() {
		eventRegistrationsRest.eventRegistrationCount(rest_Event_Host(), channel_name());
		assertTrue("There are no registrations for the event..failed..", (int) EventRegistrationsRest.registrationCount.get("count") > 0);
		
		eventRegistrationsRest.eventRegistrations(rest_Event_Host(), channel_name());
		assertTrue("There are no registrations for the event..failed..", EventRegistrationsRest.registrationList.size() > 0);
	}
	
}
