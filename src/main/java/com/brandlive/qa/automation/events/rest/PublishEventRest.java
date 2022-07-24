package com.brandlive.qa.automation.events.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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

public class PublishEventRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	CreateEventsRest createEventsRestAdapter = new CreateEventsRest();
	EventsHomePageRest eventsHomePageRestAdapter = new EventsHomePageRest();
	DuplicateEventRest duplicateEventRest = new DuplicateEventRest();

	
	public static JsonPath eventPublish;
	public static JsonPath eventE2Publish;
	public static Map<String, Object> duplicateEventPublish;
	
	// Public methods
	
	public void publishEvent(String host) {
		eventPublish = postPublishEvent(host);

	}
	
	public void publishDuplicateEvent(String host) {
		duplicateEventPublish = postPublishDuplicateEvent(host).get("$");
	}
	
	public void publishE2Event(String host, String channelName) {
		eventE2Publish = postPublishE2Event(host,channelName);
	}
	

	// Private Methods

	private JsonPath postPublishEvent(String host) {
		
		String event_uuid = CreateEventsRest.eventCreation.getString("uuid");
		String event_name = CreateEventsRest.eventCreation.getString("name");
		
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/events/publish");
		url = "https://" + host + "/v3/admin/events/publish?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 Event Publish Api : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		// publishEvent JsonObject
		JsonObject publishEvent = new JsonObject();
		publishEvent.addProperty("uuid", event_uuid);
		publishEvent.addProperty("url", event_name.replaceAll("(:|\\s)+", "-").toLowerCase());

		log.debug("publish Event Body - " + publishEvent.toString());
		Response response = restRequest.sendJsonRequestWithBody(url,publishEvent.toString(), headers); 
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}
	
	private JsonPath postPublishDuplicateEvent(String host) {
		
		String event_uuid = (String) DuplicateEventRest.duplicateEvent.get("uuid");
		String event_name = (String) DuplicateEventRest.duplicateEvent.get("name");
		
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/events/publish");
		url = "https://" + host + "/v3/admin/events/publish?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 Event Publish Api : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		// publishEvent JsonObject
		JsonObject publishEvent = new JsonObject();
		publishEvent.addProperty("uuid", event_uuid);
		publishEvent.addProperty("url", event_name.replaceAll("(:|\\s)+", "-").toLowerCase());

		log.debug("publish Event Body - " + publishEvent.toString());
		Response response = restRequest.sendJsonRequestWithBody(url,publishEvent.toString(), headers); 
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath postPublishE2Event(String host , String channelName) {

		eventsHomePageRestAdapter.e2Channels(host, channelName);
		createEventsRestAdapter.saveNewE2Event(host, channelName);
		
		String token = LoginLogoutRest.E2_Token;
        String e2EventName = createEventsRestAdapter.eventName.replaceAll("(:|\\s)+", "-").toLowerCase();
        String e2TitleName = createEventsRestAdapter.eventName;
		int clientId = (int) (EventsHomePageRest.e2ChannelInfo.get("client"));
        int eventId = Integer.parseInt(createEventsRestAdapter.saveNewE2Event.getString("insertId"));

		//broadcast date detail
		long broadCastTimestamp = Instant.now().plus(15, ChronoUnit.MINUTES).toEpochMilli();
        Date date = new Date(broadCastTimestamp);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
        
        String broadCastDate = format.format(date).substring(0,10);
        String broadCastTime1 = format.format(date).substring(11,19);
        
        
        JsonPath responseStr = null;
		
        try {
        	
			/* Reading json file */
		    
			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_publishNewE2Event.json"));
		    ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode parser = objectMapper.readTree(reader);
		    JsonNode event = parser.path("event");
		    
		    String url = "https://" + host + "/publish-event";	
			log.debug("E2 Publish New Event Rest Api Call: " + url);
			
			
			/* Updating values from file */
		    
		    if(parser.path("token").asText().equalsIgnoreCase("token")){
		    	((ObjectNode)parser).put("token", token);
		    }
		    
		    if(event.path("draft").asInt() == 0) {
		    	((ObjectNode)event).put("draft", eventId);
		    }
		    
		    if(event.path("client").asInt() == 0) {
		    	((ObjectNode)event).put("client", clientId);
		    }
		    
		    if(event.path("title").asText().equalsIgnoreCase("titleName")) {
		    	((ObjectNode)event).put("title", e2TitleName);
		    }
		    
		    if(event.path("url").asText().equalsIgnoreCase("eventName")) {
		    	((ObjectNode)event).put("url", e2EventName);
		    }
			
		    if(event.path("broadcast_date").asText().equalsIgnoreCase("broadcastDate")) {
		    	((ObjectNode)event).put("broadcast_date", broadCastDate);
		    }
		    
		    if(event.path("broadcast_time1").asText().equalsIgnoreCase("bradcastTime")) {
		    	((ObjectNode)event).put("broadcast_time1", broadCastTime1);
		    }
		    
		    if(event.path("broadcast_timestamp").asLong() == 0) {
		    	((ObjectNode)event).put("broadcast_timestamp", broadCastTimestamp);
		    }
		    
		    if(event.path("created_by").asInt() == 8990) {
		    	((ObjectNode)event).put("created_by", 8983);
		    }
		    
			Response response = restRequest.sendJsonRequestWithBody(url, parser.toString());
			responseStr = response.jsonPath();		
		   	
		} catch (IOException e) {
			e.printStackTrace();
		}
        

		return responseStr;
	}
	
}
