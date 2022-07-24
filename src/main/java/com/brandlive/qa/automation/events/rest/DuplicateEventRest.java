package com.brandlive.qa.automation.events.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DuplicateEventRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventsHomePageRest = new EventsHomePageRest();
	
	public static Response duplicateEventResponse;
	
	public static Map<String, Object> duplicateEvent;
	public static Map<String, Object> deleteEvent;
	public static String updateEvent;
	
	public static String duplicateEventName;
	
	// Public Methods
	public void duplicateEvent(String host, String channelName) {
		duplicateEvent = postDuplicateEvent(host, channelName).get("$");
		duplicateEventName = (String) duplicateEvent.get("name");
	}
	
	public void deleteDuplicatedEvent(String host) {
		deleteEvent = deleteEventByEventUuid(host).get("$");
	}
	
	public void updateDuplicatedEvent(String host) {
		updateEvent = putEventByUpdatingName(host);
	}
	
	
	// Private Methods
	private JsonPath postDuplicateEvent(String host, String channelName) {
		
		eventsHomePageRest.e3Channels(host, channelName);
		
		String url = null;
		String token = null;
		String[] params = null;
		
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		
		// Creating jsonBody
		JsonObject duplicateEvent = new JsonObject();
		duplicateEvent.addProperty("channel", channel_id);
		
		String event_uuid = CreateEventsRest.eventCreation.getString("uuid");
		
		params = generateCloudflareParameters("/v3/admin/events/duplicate-event/" + event_uuid);
		url = "https://" + host + "/v3/admin/events/duplicate-event/"+ event_uuid +"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;
		
		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithBody(url, duplicateEvent.toString(), headers);
		duplicateEventResponse = response;
		JsonPath responseStr = response.jsonPath();

		return responseStr;
		
	}
	
	private String putEventByUpdatingName(String host) {
		
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode parser = null;
		try {
			parser = objectMapper.readTree(duplicateEventResponse.prettyPrint());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String updatedDuplicateEvantName = duplicateEventName.concat(" Updated");

    	((ObjectNode)parser).put("name", updatedDuplicateEvantName);
	    
	    String json = "{\"event\":"+parser.toString()+"}";
		
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/event");
		url = "https://" + host + "/v3/admin/event?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, json, headers);
		log.debug("Response: " + response.asString());
		
		return response.asString();
	}
	
	private JsonPath deleteEventByEventUuid(String host) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		eventsHomePageRest.refreshToken(host);

		String event_uuid = (String) duplicateEvent.get("uuid");
		
		params = generateCloudflareParameters("/v3/admin/events/event/" + event_uuid);
		url = "https://" + host + "/v3/admin/events/event/"+ event_uuid +"?expiry=" + params[0] + "&mac=" + params[1];

		//token = LoginLogoutRest.E3_Token;
		token = (String) EventsHomePageRest.refreshedToken.get("token");
		
		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.deleteJsonRequestWithoutBody(url, headers);
		log.debug("The response code is " + response.getStatusCode());
		log.debug("The response is " + response.asString());
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}
}
