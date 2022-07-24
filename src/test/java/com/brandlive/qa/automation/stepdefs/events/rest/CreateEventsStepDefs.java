package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.CreateEventsRest;
import com.brandlive.qa.automation.events.rest.ProductsRest;
import com.brandlive.qa.automation.events.rest.SpeakersRest;
import com.brandlive.qa.automation.events.rest.SponsorsRest;
import com.brandlive.qa.automation.events.rest.VideosRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import io.restassured.path.json.JsonPath;

import cucumber.api.java.en.And;

public class CreateEventsStepDefs extends StepDefs {
	
	CreateEventsRest createEventsRestAdapter = new CreateEventsRest();
	ProductsRest productsRest = new ProductsRest();
	SpeakersRest speakersRest = new SpeakersRest();
	SponsorsRest sponsorsRest = new SponsorsRest();
	VideosRest videosRest = new VideosRest();

	/* Start  -  Related to Events 3.0 */

	@And("^Get Event Templates$")
	public void Get_Event_Templates() {		
		createEventsRestAdapter.getEventTemplates(rest_Event_Host(),channel_name());
		List<Map<String, Object>> eventTemplates   = CreateEventsRest.eventTemplatesByChannelId;
		log.debug("Total there are  " + eventTemplates.size() + " templates for channel name " +channel_name());	
		log.debug("Template Names are : ");
		for (Map<String, Object> name : eventTemplates) {
			log.debug(name.get("name"));
		}
	}
	
	@And("^Check event name for duplication$")
	public void Check_Duplicate_Event_Name() {
		createEventsRestAdapter.checkDuplicateEventName(rest_Event_Host(),channel_name());
		boolean checkDuplicateEventName = CreateEventsRest.duplicateEventName;
		log.debug("Event Name '"+CreateEventsRest.eventName+"' is already present ? : " +checkDuplicateEventName);
	}
	
	@And("^Check all available tracks$")
	public void Check_all_available_tracks() {
		createEventsRestAdapter.checkTracks(rest_Event_Host(),channel_name());
		List<Map<String, Object>> allAvaliableTracks   = CreateEventsRest.availableTracks;
		log.debug("There are total " +allAvaliableTracks.size()+ " tracks avalible and they are : " +allAvaliableTracks);  
	}
	
	@And("^Create a new Event$")
	public void Create_New_Event() {
		createEventsRestAdapter.postCreateEvent(rest_Event_Host(),channel_name());
		JsonPath getEventCreationData = CreateEventsRest.eventCreation;
		createEventsRestAdapter.extractJsonEventDataInformation(getEventCreationData);
	}
	
	@And("^Get Event Details by event uuid$")
	public void Get_Event_Details_By_Event_uuid() {
		createEventsRestAdapter.getEventDetailsbyEventUuid(rest_Event_Host(),channel_name());
		JsonPath getEventDetailsbyEventUuid = CreateEventsRest.eventDetailByEventUuid;
		createEventsRestAdapter.validateEventDetailsbyEventUuid(getEventDetailsbyEventUuid);
	}
	
	@And("^Update Registration Steps$")
	public void Update_Registration_Steps() {
		createEventsRestAdapter.updateRegistrationSteps(rest_Event_Host(),channel_name());
		int registrationStatusCode = CreateEventsRest.registrationStepResponseStatus;
		createEventsRestAdapter.validateUpdateRegistrationStepStatus(registrationStatusCode);
	}
	
	@And("^Check Live URL for duplication$")
	public void Check_Duplicate_Live_URL() {
		createEventsRestAdapter.checkDuplicateURL(rest_Event_Host(),channel_name());
		boolean checkDuplicateLiveURL= CreateEventsRest.duplicateLiveURL;
		log.debug("Live URL is already present ? : " +checkDuplicateLiveURL);
	}
	
	@And("^Check Unpublished Event Status$")
	public void Check_Unpublished_Event_Status() {
		createEventsRestAdapter.EventStatus(rest_Event_Host(),channel_name());
		int eventPublishStatusCode = CreateEventsRest.checkEventPublishStatus;
		if (eventPublishStatusCode == 2) {
			log.debug("Event is not published with status code : " + eventPublishStatusCode);
		} else {
			log.error("Event is published with status code : " + eventPublishStatusCode);
		}
	}
	
	@And("^Get Event Videos by channel Id$")
	public void Get_Event_Videos_By_channel_Id() {
		videosRest.getChannelVideos(rest_Event_Host(),channel_name());
		List<Map<String, Object>> allEventVideos   = VideosRest.channelVideos;
		log.debug("There are total " +allEventVideos.size()+ " Videos avalible and they are : " +allEventVideos);  
	}
	
	@And("^Get Event Speakers by channel Id$")
	public void Get_Event_Speakers_By_channel_Id() {
		speakersRest.getChannelSpeakers(rest_Event_Host(),channel_name());
		List<Map<String, Object>> allEventSpeakers   = SpeakersRest.channelSpeakers;
		log.debug("There are total " +allEventSpeakers.size()+ " speakers avalible and they are : " +allEventSpeakers);  
	}
	
	@And("^Get Event Products by channel Id$")
	public void Get_Event_Products_By_channel_Id() {
		productsRest.getChannelProducts(rest_Event_Host(),channel_name());
		List<Map<String, Object>> allEventProducts   = ProductsRest.channelProducts;
		log.debug("There are total " +allEventProducts.size()+ " allEventProducts avalible and they are : " +allEventProducts);  
	}
		
	@And("^Get Event Sponsors by channel Id$")
	public void Get_Event_Sponsors_By_channel_Id() {
		sponsorsRest.getChannelSponsors(rest_Event_Host(),channel_name());
		List<Map<String, Object>> allEventSponsors   = SponsorsRest.channelSponsors;
		log.debug("There are total " +allEventSponsors.size()+ " allEventSponsors avalible and they are : " +allEventSponsors);  
	}
	
	/*End -  Related to Events 3.0 */
	
	
	/* Start - Related to Events 2.5 */
	
	@And("^Check E2 event name for duplication$")
	public void Check_E2_Duplicate_Event_Name() {
		createEventsRestAdapter.checkE2DuplicateEventName(rest_Event_Host(),channel_name());
		for (Map<String, Integer> checkEventName : CreateEventsRest.duplicateE2EventName) {
			if (checkEventName.get("count") == 0) {
				log.debug("E2 Event Name '" +CreateEventsRest.eventName+"' is not present");
				break;
			}
			else {
				log.error("Already E2 Event Name '" +CreateEventsRest.eventName+"' is present");
			}
		}
	}
	
	@And("^Create a new E2 Event$")
	public void Create_New_E2_Event() {
		createEventsRestAdapter.saveNewE2Event(rest_Event_Host(),channel_name());
		JsonPath saveNewE2Event = CreateEventsRest.saveNewE2Event;
		createEventsRestAdapter.extractSaveNewE2EventData(saveNewE2Event);
	}
	
}

