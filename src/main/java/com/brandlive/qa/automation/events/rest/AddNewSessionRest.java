package com.brandlive.qa.automation.events.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddNewSessionRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventsHomePageRest = new EventsHomePageRest();
	
	public static Response addBCSessionResponse;
	public static Response getSessionsByUuidResponse;
	public static Response getSessionsBySessionIdResponse;
	
	public static long startTime;
	public static long endTime;
	
	public static Map<String, Object> addBroadcastSessionResponse;
	public static Map<String, Object> getBroadcastSessionByIdResponse;
	public static List<Map<String, Object>> getBroadcastSessionByUuidResponse;
	public static Map<String, Object> deleteSessionResponse;
	public static Map<String, Object> updateSessionResponse;
	public static Map<String, Object> getSessionRtmpResponse;
	public static Map<String, Object> updateSessionWithDocResponse;
	public static Map<String, Object> updateSessionWithSurveyResponse;
	
	// Public Method
	
	public void AddNewBroadcastSession(String host, String channelName) {
		addBroadcastSessionResponse = AddBroadcastSession(host, channelName).get("$");
	}
	
	public void GetBroadcastSessionById(String host) {
		getBroadcastSessionByIdResponse = getSessionByIdResponse(host).get("$");
	}
	
	public void GetBroadcastSessionById(String host, int sessionId) {
		getBroadcastSessionByIdResponse = getSessionByIdResponse(host, sessionId).get("$");
	}
	
	public void GetBroadcastSessionByUuid(String host, String channelName) {
		getBroadcastSessionByUuidResponse = getSessionByUuidResponse(host, channelName).get("$");
	}
	
	public void deleteSessionBySessionId(String host) {
		deleteSessionResponse = deleteSessionBySessionIdResponse(host).get("$");
	}
	
	public void updateSession(String host) {
		updateSessionResponse = putSessionByUpdatingTimeResponse(host).get("$");
	}
	
	public void GetSessionRtmp(String host) {
		getSessionRtmpResponse = getSessionRtmpDetails(host).get("$");
	}
	
	public void updateSessionWithDocument(String host) {
		updateSessionWithDocResponse = putAddExistingDocumentToSession(host).get("$");
	}
	
	public void updateSessionWithSurvey(String host) {
		updateSessionWithSurveyResponse = putAddExistingSurveyToSession(host).get("$");
	}
	
	// Private Methods

	@SuppressWarnings("unlikely-arg-type")
	private JsonPath AddBroadcastSession(String host, String channelName) {
		
		String eventName = null;
		String url = null;
		String token = null;
		String[] params = null;
		
		if(DuplicateEventRest.duplicateEventName != null) {
			eventName = DuplicateEventRest.duplicateEventName;
		} else {
			eventName = CreateEventsRest.eventName;
		}
		
		if(eventName != null) {
			eventsHomePageRest.getEventDetails(eventName);
		}
		
		// Getting value's for jsonBody
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		int event_id = (int) EventsHomePageRest.eventDetailsByEventName.get("event");
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");
		
		String track;
		if (CreateEventsRest.availableTracks.contains("Track1")) {
			track = "Track1";
		} else {
			track = "";
		}

		String sessionTitle = createRandomSessionName("Broadcast");
		startTime = Instant.now().plus(10, ChronoUnit.MINUTES).toEpochMilli();
		endTime = Instant.now().plus(25, ChronoUnit.MINUTES).toEpochMilli();
		
		// Creating jsonBody
		JsonObject sessionCreation = new JsonObject();
		sessionCreation.addProperty("channel", channel_id);
		sessionCreation.addProperty("event", event_id);
		sessionCreation.addProperty("eventUuid", event_uuid);
		
		// Creating Session Array
		JsonObject sessionObject = new JsonObject();
		sessionObject.addProperty("title", sessionTitle);
		sessionObject.addProperty("channel", channel_id);

		JsonArray languages = new JsonArray();
		languages.add("en");
		sessionObject.add("languages", languages);

		sessionObject.addProperty("default_language", "en");

		JsonArray tracks = new JsonArray();
		tracks.add(track);
		sessionObject.add("tracks", tracks);
		
		sessionObject.addProperty("session_type", "broadcast");
		sessionObject.addProperty("start_timestamp", startTime);
		sessionObject.addProperty("end_timestamp", endTime);
		sessionObject.addProperty("on_demand", false);

		sessionCreation.add("session", sessionObject);
		
		params = generateCloudflareParameters("/v3/admin/event/session");
		url = "https://" + host + "/v3/admin/event/session?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, sessionCreation.toString(), headers);
		addBCSessionResponse = response;
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
		
	}
	
	private JsonPath getSessionByIdResponse(String host) {
		
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/events/session/" + addBroadcastSessionResponse.get("session"));
		url = "https://" + host + "/v3/admin/events/session/" + addBroadcastSessionResponse.get("session") +"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath getSessionByIdResponse(String host, int sessionId) {
		
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/events/session/" + sessionId);
		url = "https://" + host + "/v3/admin/events/session/" + sessionId +"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getSessionsBySessionIdResponse = restRequest.sendJsonRequestWithoutBody(url, headers);
		
		JsonPath responseStr = getSessionsBySessionIdResponse.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath getSessionByUuidResponse(String host, String channelName) {
		
		String url = null;
		String token = null;
		String[] params = null;

		eventsHomePageRest.getEventDetails(CreateEventsRest.eventName);
		
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");

		params = generateCloudflareParameters("/v3/admin/events/sessions/" + event_uuid);
		url = "https://" + host + "/v3/admin/events/sessions/" + event_uuid +"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getSessionsByUuidResponse = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(getSessionsByUuidResponse.prettyPrint());
		JsonPath responseStr = getSessionsByUuidResponse.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath deleteSessionBySessionIdResponse(String host) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");
		int session_id = (int) addBroadcastSessionResponse.get("session");
		
		// Creating jsonBody
		JsonObject sessionDeletion = new JsonObject();
		sessionDeletion.addProperty("sessionID", session_id);
		sessionDeletion.addProperty("eventUuid", event_uuid);
		log.debug(sessionDeletion.toString());
		
		params = generateCloudflareParameters("/v3/admin/events/session");
		url = "https://" + host + "/v3/admin/events/session?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.deleteJsonRequestWithBody(url, sessionDeletion.toString(), headers);
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath putSessionByUpdatingTimeResponse(String host) {
			
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode parser = null;
		try {
			parser = objectMapper.readTree(addBCSessionResponse.prettyPrint());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		startTime = Instant.now().plus(15, ChronoUnit.MINUTES).toEpochMilli();
		endTime = Instant.now().plus(30, ChronoUnit.MINUTES).toEpochMilli();	

    	((ObjectNode)parser).put("timestamp", startTime);
    	((ObjectNode)parser).put("end_timestamp", endTime);
	    
	    String json = "{\"session\":"+parser.toString()+"}";

		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/event/session");
		url = "https://" + host + "/v3/admin/event/session?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, json, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;

	}
	
	private JsonPath getSessionRtmpDetails(String host) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/events/session/rtmp/"+addBroadcastSessionResponse.get("uuid")+"/en");
		url = "https://" + host + "/v3/admin/events/session/rtmp/"+addBroadcastSessionResponse.get("uuid")+"/en?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
		
	}
	
	private JsonPath putAddExistingDocumentToSession(String host) {
		
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode sessionResRoot = null;
		ArrayNode modules = null;
		
		try {
			sessionResRoot = objectMapper.readTree(getSessionsBySessionIdResponse.prettyPrint());
			modules = (ArrayNode) sessionResRoot.path("modules");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reader reader;
		JsonNode documentResRoot = null;
		JsonNode displayName = null;
		
		try {
			reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_E3_document.json"));
			documentResRoot = objectMapper.readTree(reader);
			displayName = (ObjectNode) documentResRoot.path("display_name");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		((ObjectNode) documentResRoot).put("channel", (int) DocumentsRest.selectedDocument.get("channel"));
		((ObjectNode) documentResRoot).put("created_by", (int) DocumentsRest.selectedDocument.get("created_by"));
		((ObjectNode) documentResRoot).put("document", (int) DocumentsRest.selectedDocument.get("document"));
		((ObjectNode) documentResRoot).put("module_id", (int) DocumentsRest.selectedDocument.get("module_id"));
		((ObjectNode) documentResRoot).put("created_at", (String) DocumentsRest.selectedDocument.get("created_at"));
		((ObjectNode) documentResRoot).put("original_name", (String) DocumentsRest.selectedDocument.get("original_name"));
		((ObjectNode) documentResRoot).put("thumbnail_status", (int) DocumentsRest.selectedDocument.get("thumbnail_status"));
		((ObjectNode) documentResRoot).put("filesize", (int) DocumentsRest.selectedDocument.get("filesize"));
		((ObjectNode) documentResRoot).put("location", (String) DocumentsRest.selectedDocument.get("location"));
		((ObjectNode) documentResRoot).put("thumbnail", (String) DocumentsRest.selectedDocument.get("thumbnail"));
		((ObjectNode) documentResRoot).put("cloud_convert_id", (String) DocumentsRest.selectedDocument.get("cloud_convert_id"));
		((ObjectNode) displayName).put("base", (String) DocumentsRest.selectedDocument.get("displayNameBase"));
		
		if(modules.isArray()) {
			for (JsonNode module : modules) {
				ObjectNode modul = (ObjectNode) module;
				JsonNode content = modul.path("content");
				JsonNode custom_heading = content.path("custom_heading");
				if(custom_heading.path("base").asText().contains("Document")) {
					ArrayNode content_modules = objectMapper.createArrayNode();
					content_modules.add((int)DocumentsRest.selectedDocument.get("document"));
					modul.put("content_modules", content_modules);
					ArrayNode document_modules = objectMapper.createArrayNode();
					document_modules.add(documentResRoot);
					modul.put("modules", document_modules);
				}
			}
		}
		
		String payloadJson = "{\"session\":" + sessionResRoot.toString() + "}";
		log.debug(payloadJson);
		
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/event/session");
		url = "https://" + host + "/v3/admin/event/session?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 session updation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		Response response = restRequest.sendPutJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath putAddExistingSurveyToSession(String host) {
		
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode sessionResRoot = null;
		ArrayNode modules = null;
		
		try {
			sessionResRoot = objectMapper.readTree(getSessionsBySessionIdResponse.prettyPrint());
			modules = (ArrayNode) sessionResRoot.path("modules");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsonNode surveyResRoot = SurveysRest.selectedSurvey;
		
		if(modules.isArray()) {
			for (JsonNode module : modules) {
				ObjectNode modul = (ObjectNode) module;
				JsonNode content = modul.path("content");
				JsonNode custom_heading = content.path("custom_heading");
				if(custom_heading.path("base").asText().contains("Poll")) {
					ArrayNode content_modules = objectMapper.createArrayNode();
					content_modules.add((int)surveyResRoot.path("survey").asInt());
					modul.put("content_modules", content_modules);
					ArrayNode survey_modules = objectMapper.createArrayNode();
					survey_modules.add(surveyResRoot);
					modul.put("modules", survey_modules);
				}
			}
		}
		
		String payloadJson = "{\"session\":" + sessionResRoot.toString() + "}";
		log.debug(payloadJson);
		
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/event/session");
		url = "https://" + host + "/v3/admin/event/session?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 session updation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		Response response = restRequest.sendPutJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}

}
