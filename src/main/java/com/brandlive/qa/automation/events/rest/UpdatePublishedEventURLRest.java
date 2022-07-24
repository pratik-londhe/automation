package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
import io.restassured.response.Response;

public class UpdatePublishedEventURLRest extends RestUtil {
	
	EventsHomePageRest eventsHomeRest = new EventsHomePageRest();
	RestAssuredRequest restRequest = new RestAssuredRequest();
	
	public static String response;
	
	// Public Methods

	public void updateDuplicateEventUrl(String host, String channelName) {
		response = postUpdateEventUrl(host, channelName, DuplicateEventRest.duplicateEventName);
	}
	
	public void updateNewEventUrl(String host, String channelName) {
		response = postUpdateEventUrl(host, channelName, CreateEventsRest.eventName);
	}
	
	// Private Methods
	
	private String postUpdateEventUrl(String host, String channelName, String eventName) {
		
		String url = null;
		String token = null;
		String[] params = null;
		String event_uuid = null;
		
		eventsHomeRest.getChannelEvents(host, channelName);
		
		List<Map<String, Object>> eventsByChannelId = EventsHomePageRest.eventDetailsByChannelId;
		
		for(Map<String, Object> event : eventsByChannelId) {
			if(((String) event.get("name")).equalsIgnoreCase(eventName)) {
				event_uuid = (String) event.get("uuid");
			}
		}
		
		// publishEvent JsonObject
		JsonObject updateEventUrl = new JsonObject();
		updateEventUrl.addProperty("eventUuid", event_uuid);
		updateEventUrl.addProperty("newUrl", eventName.replaceAll("(:|\\s)+", "-").toLowerCase().concat("_1"));
		
		params = generateCloudflareParameters("/v3/admin/events/update-url");
		url = "https://" + host + "/v3/admin/events/update-url?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;
		
		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, updateEventUrl.toString(), headers);
		return response.asString();

	}

}
