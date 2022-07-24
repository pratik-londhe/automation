package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FaviconRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static Map<String, String> uploadFaviconFile;
	public static int deleteUploadFaviconFile;
	
	// Public methods
	public void faviconFileUpload(String host, String channelName) {
		uploadFaviconFile = postFaviconFileUpload(host, channelName).get("$");
	}
	
	public void faviconFileDelete(String host, String channelName) {
		deleteUploadFaviconFile = deleteUploadedFavicon(host, channelName);
	}

	// Private methods
	private JsonPath postFaviconFileUpload(String host, String channelName) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		String favicon = UploadRest.uploadFile.get("url") + "/" + UploadRest.uploadFileResFields.get("Key");
		
		eventHomePageRest.getChannelEvents(host, channelName);
		eventHomePageRest.getEventDetails(CreateEventsRest.eventName);
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");
		
		params = generateCloudflareParameters("/v3/admin/events/favicon/"+event_uuid);
		url = "https://" + host + "/v3/admin/events/favicon/"+event_uuid+"?expiry=" + params[0] + "&mac=" + params[1];
		
		// creating payload
		JsonObject uploadFaviconPayload = new JsonObject();
		uploadFaviconPayload.addProperty("favicon", favicon);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 upload favicon file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, uploadFaviconPayload.toString(), headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private int deleteUploadedFavicon(String host, String channelName) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		eventHomePageRest.getChannelEvents(host, channelName);
		eventHomePageRest.getEventDetails(CreateEventsRest.eventName);
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");
		
		params = generateCloudflareParameters("/v3/admin/events/favicon/"+event_uuid);
		url = "https://" + host + "/v3/admin/events/favicon/"+event_uuid+"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 delete favicon file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.deleteJsonRequestWithoutBody(url, headers);
		log.debug(response.prettyPrint());
		
		return response.statusCode();
	}
}
