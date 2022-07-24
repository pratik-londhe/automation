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

import org.apache.commons.collections.MapUtils;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateEventsRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventsHomePageRest = new EventsHomePageRest();

	public static List<Map<String, Object>> eventTemplatesByChannelId;
	public static List<Map<String, Object>> availableTracks;

	public static Response eventCreationResponse;
	public static Response eventDetailByEventUuidResponse;
	
	public static JsonPath eventCreation;
	public static JsonPath eventDetailByEventUuid;
	public static JsonPath saveNewE2Event;
	
	public static long startTime;
	public static long endTime;

	public static int registrationStepResponseStatus;
	public static int checkEventPublishStatus;

	public static Boolean duplicateEventName;
	public static Boolean duplicateLiveURL;

	public static String eventName;
	
	public static List<Map<String, Integer>>  duplicateE2EventName;

	/* public methods - for Events 3.0  */

	public void getEventTemplates(String host, String channelName) {
		eventTemplatesByChannelId = getEventTemplatesByChannelId(host, channelName).get("$");
	}

	public void checkDuplicateEventName(String host, String channelName) {
		Boolean json = checkDuplicateName(host, channelName).get("exists");
		duplicateEventName = json.booleanValue();
	}
	
	public void checkTracks(String host, String channelName) {
		availableTracks = allAvaliableTracks(host, channelName).get("$");
	}
	
	public void postCreateEvent(String host, String channelName) {
		eventCreation = createEvent(host, channelName);
	}
	
	public void getEventDetailsbyEventUuid(String host, String channelName) {
		eventDetailByEventUuid = getEventDetailsbyEventuuid(host, channelName);
	}

	public void updateRegistrationSteps(String host, String channelName) {
		registrationStepResponseStatus = updateRegistrationStep(host, channelName);
	}

	public void checkDuplicateURL(String host, String channelName) {
		Boolean json = checkDuplicateLiveUrl(host, channelName).get("exists");
		duplicateLiveURL = json.booleanValue();
	}

	public void EventStatus(String host, String channelName) {
		checkEventPublishStatus = checkEventStatus(host, channelName).getInt("status");
	}

	public void extractJsonEventDataInformation(JsonPath eventJsonPath) {

		List<Map<String, String>> session = eventJsonPath.getList("sessions");
		Map<String, String> homepage = eventJsonPath.getMap("homepage");
		Map<String, String> template = eventJsonPath.getMap("template");

		// Basic Information
		log.debug("Event Id : " + eventJsonPath.getString("event"));
		log.debug("Event Name : " + eventJsonPath.getString("name"));
		log.debug("Event uuid : " + eventJsonPath.getString("uuid"));
		log.debug("Channel Id : " + eventJsonPath.getString("channel"));
		log.debug("Status : " + eventJsonPath.getString("status"));
		log.debug("Registration On : " + eventJsonPath.getString("registration_on"));
		log.debug("-------------------------");

		// Homepage Information
		log.debug("Homepage Id : " + String.valueOf(homepage.get("homepage")));
		log.debug("Homepage uuid : " + homepage.get("uuid"));
		log.debug("-------------------------");

		// Template Information
		if (MapUtils.isNotEmpty(template)) {
			log.debug("Template Id : " + String.valueOf(template.get("template")));
			log.debug("Template Name : " + template.get("name"));
		}

		log.debug("-------------------------");

		// Session Information
		log.debug("Session Id : " + String.valueOf(session.get(0).get("session")));
		log.debug("Session uuid : " + session.get(0).get("uuid"));
		log.debug("Session Name: ");
		for (Map<String, String> name : session) {
			log.debug(name.get("title"));
		}
	}

	public void validateEventDetailsbyEventUuid(JsonPath getEventDetailsbyEventUuid) {

		String eventNameByEventuuid = getEventDetailsbyEventUuid.getString("name");
		log.debug("Event Name from eventUuid : " + eventNameByEventuuid);

		if (eventName.equalsIgnoreCase(eventNameByEventuuid)) {
			log.debug("Validation True");
		} else {
			log.debug("Validation False");
		}

	}

	public void validateUpdateRegistrationStepStatus(int registrationStatus) {

		if (registrationStatus == 200) {
			log.debug("Validation True - Status response code : " + registrationStatus);
		} else {
			log.debug("Validation False - Status response code : " + registrationStatus);
		}
	}

	public void validateEventPublishStatus(int eventPublishStatusCode) {
		if (eventPublishStatusCode == 2) {
			log.debug("Event is not published with status code : " + eventPublishStatusCode);
		} else {
			log.debug("Event is published with status code : " + eventPublishStatusCode);
		}
	}

	
	/* public methods for Legacy Events 2.5 */
	
	public void checkE2DuplicateEventName(String host, String channelName) {
		duplicateE2EventName = checkE2DuplicateName(host, channelName).get("$");
	}
	
	public void saveNewE2Event(String host, String channelName) {
		saveNewE2Event = newE2Event(host,channelName);
	}
	
	public void extractSaveNewE2EventData(JsonPath e2Event) {
		log.debug("E2 Event Insert Id : " + e2Event.getString("insertId"));
	}

	

	/* private methods - for Events 3.0  */


	private JsonPath getEventTemplatesByChannelId(String host, String channelName) {
		eventsHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Templates by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/events/templates/" + channel_id);
		url = "https://" + host + "/v3/admin/events/templates/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}

	private JsonPath checkDuplicateName(String host, String channelName) {
		eventsHomePageRest.e3Channels(host, channelName);
		eventsHomePageRest.getChannelEvents(host, channelName);
		int channel_id = (int) (EventsHomePageRest.e3ChannelInfo.get("channel"));
		eventName = createRandomEventName();

		JsonObject duplicateEventName = new JsonObject();

		duplicateEventName.addProperty("eventName", eventName);
		duplicateEventName.addProperty("event", 0);
		duplicateEventName.addProperty("channel", channel_id);

		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Checking duplicate event for channel Id " + channel_id);

		params = generateCloudflareParameters("/v3/admin/events/check-event-name");
		url = "https://" + host + "/v3/admin/events/check-event-name?expiry=" + params[0] + "&mac=" + params[1];
		token = LoginLogoutRest.E3_Token;
		log.info("E3 event duplicate rest api call: " + url);

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		Response response = restRequest.sendJsonRequestWithBody(url, duplicateEventName.toString(), headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath allAvaliableTracks(String host, String channelName) {
		eventsHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Details by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/events/tracks/" + channel_id);
		url = "https://" + host + "/v3/admin/events/tracks/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	@SuppressWarnings("unlikely-arg-type")
	private JsonPath createEvent(String host, String channelName) {

		eventsHomePageRest.e3Channels(host, channelName);
		checkDuplicateEventName(host, channelName);
		checkTracks(host, channelName);

		String url = null;
		String token = null;
		String[] params = null;

		// Getting value's for jsonBody
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		String track;
		if (availableTracks.contains("Track1")) {
			track = "Track1";
		} else {
			track = "";
		}

		String sessionTitle = createRandomSessionName();
		int templateNo = createRandomTemplate();
		startTime = Instant.now().plus(10, ChronoUnit.MINUTES).toEpochMilli();
		endTime = Instant.now().plus(25, ChronoUnit.MINUTES).toEpochMilli();

		// Creating jsonBody
		JsonObject eventCreation = new JsonObject();

		eventCreation.addProperty("channel", channel_id);
		eventCreation.addProperty("template", templateNo);
		eventCreation.addProperty("name", eventName);

		// Creating Session Array
		JsonArray sessions = new JsonArray();
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
		sessionObject.addProperty("on_demand", true);
		sessionObject.addProperty("uid", createRandomUUID());
		
		sessions.add(sessionObject);

		eventCreation.add("sessions", sessions);
		eventCreation.addProperty("homepage", true);
		eventCreation.addProperty("registration_on", true);

		params = generateCloudflareParameters("/v3/admin/event");
		url = "https://" + host + "/v3/admin/event?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		eventCreationResponse = restRequest.sendJsonRequestWithBody(url, eventCreation.toString(), headers);
		JsonPath responseStr = eventCreationResponse.jsonPath();
		return responseStr;

	}

	private JsonPath getEventDetailsbyEventuuid(String host, String channelName) {

		String event_uuid = eventCreation.getString("uuid");
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Details by Event uuid " + event_uuid);

		params = generateCloudflareParameters("/v3/admin/event/" + event_uuid);
		url = "https://" + host + "/v3/admin/event/" + event_uuid + "?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 Get Event Detail's by Event uuid call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		eventDetailByEventUuidResponse = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = eventDetailByEventUuidResponse.jsonPath();
		return responseStr;
	}

	private int updateRegistrationStep(String host, String channelName) {
		String event_uuid = eventCreation.getString("uuid");
		String url = null;
		String token = null;
		String[] params = null;

		// Creating jsonBody
		JsonObject registrationSteps = new JsonObject();

		registrationSteps.addProperty("event_uuid", event_uuid);

		// Creating updates Steps Array
		JsonArray updated_steps = new JsonArray();

		JsonObject updatedObject_1 = new JsonObject();
		updatedObject_1.addProperty("type", "general");
		updatedObject_1.addProperty("isOn", true);

		JsonArray questions_1 = new JsonArray();
		questions_1.add(1);
		questions_1.add(2);
		questions_1.add(3);
		updatedObject_1.add("questions", questions_1);
		updated_steps.add(updatedObject_1);

		JsonObject updatedObject_2 = new JsonObject();
		updatedObject_2.addProperty("type", "profile");
		updatedObject_2.addProperty("isOn", false);

		JsonArray questions_2 = new JsonArray();
		questions_2.add(6);
		questions_2.add(92);
		questions_2.add(47);
		updatedObject_2.add("questions", questions_2);
		updated_steps.add(updatedObject_2);

		JsonObject updatedObject_3 = new JsonObject();
		updatedObject_3.addProperty("type", "avatar");
		updatedObject_3.addProperty("isOn", false);
		updated_steps.add(updatedObject_3);

		registrationSteps.add("updated_steps", updated_steps);

		params = generateCloudflareParameters("/v3/admin/events/registration-steps");
		url = "https://" + host + "/v3/admin/events/registration-steps?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		int responseStatus = restRequest.sendPutJsonRequestWithBody(url, registrationSteps.toString(), headers).getStatusCode();
		return responseStatus;
	}

	private JsonPath checkDuplicateLiveUrl(String host, String channelName) {

		String event_name = eventCreation.getString("name");
		int event_id = eventCreation.getInt("event");
		int channel_id = eventCreation.getInt("channel");

		log.debug("event_name" + event_name.replaceAll("(:|\\s)+", "-").toLowerCase());

		JsonObject checkLiveUrl = new JsonObject();

		checkLiveUrl.addProperty("hostname", "qauto1.brandl.live");
		checkLiveUrl.addProperty("pathname", event_name.replaceAll("(:|\\s)+", "-").toLowerCase());
		checkLiveUrl.addProperty("event", event_id);
		checkLiveUrl.addProperty("channel", channel_id);

		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Checking duplicate event for channel Id " + channel_id);

		params = generateCloudflareParameters("/v3/admin/events/check-url");
		url = "https://" + host + "/v3/admin/events/check-url?expiry=" + params[0] + "&mac=" + params[1];
		token = LoginLogoutRest.E3_Token;
		log.info("E3 event live url duplicate rest api call: " + url);

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		Response response = restRequest.sendJsonRequestWithBody(url, checkLiveUrl.toString(), headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath checkEventStatus(String host, String channelName) {

		String event_uuid = eventCreation.getString("uuid");
		
		log.debug("Event uuid for checking event status is -  " +event_uuid);
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/events/published-status/" + event_uuid);
		url = "https://" + host + "/v3/admin/events/published-status/" + event_uuid + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 check event publish status: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}	
	
	/* private methods for Legacy Events 2.5 */
	
	private JsonPath checkE2DuplicateName(String host, String channelName) {
		eventName = createRandomEventName();
		eventsHomePageRest.e2Channels(host, channelName);
		int clientId = (int) (EventsHomePageRest.e2ChannelInfo.get("client"));
		String E2EventName = createRandomEventName();

		JsonObject duplicateE2EventName = new JsonObject();
		
		duplicateE2EventName.addProperty("client", clientId);
		duplicateE2EventName.addProperty("live_chat", 0);
		duplicateE2EventName.addProperty("url", E2EventName.replaceAll("(:|\\s)+", "-").toLowerCase());
		duplicateE2EventName.addProperty("token", LoginLogoutRest.E2_Token);

		String url = "https://" + host + "/check-dup";	

		log.debug("Checking duplicate E2 event for channel Id " + clientId);
		log.debug("E2 event duplicate rest api call: " + url);
		
		Response response = restRequest.sendJsonRequestWithBody(url, duplicateE2EventName.toString());
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}
	
	private JsonPath newE2Event(String host, String channelName) {
		
		eventsHomePageRest.e2Channels(host, channelName);
		checkE2DuplicateEventName(host, channelName);
		String e2EventName = eventName.replaceAll("(:|\\s)+", "-").toLowerCase();
		int client = (int) (EventsHomePageRest.e2ChannelInfo.get("client"));
		String clientId = String.valueOf(client);
		JsonPath responseStr = null;
		
	try {
			/* Reading json file */
		    
			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_saveNewE2Event.json"));
		    ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode parser = objectMapper.readTree(reader);
		    JsonNode event = parser.path("event");
		    
		    /* Updating values from file */
		    
		    if(parser.path("token").asText().equalsIgnoreCase("token")){
		    	((ObjectNode)parser).put("token", LoginLogoutRest.E2_Token);
		    }
		    
		    if(event.path("client").asText().equalsIgnoreCase("clientId")) {
		    	((ObjectNode)event).put("client", clientId);
		    }
		    
		    if(event.path("created_by").asInt() == 8990) {
		    	((ObjectNode)event).put("created_by", 8983);
		    }
		    
		    if(event.path("title").asText().equalsIgnoreCase("eventName")) {
		    	((ObjectNode)event).put("title", e2EventName);
		    }
		    if(event.path("url").asText().equalsIgnoreCase("eventName")) {
		    	((ObjectNode)event).put("url", e2EventName);
		    }
		    
		    String url = "https://" + host + "/save-event";	
			log.debug("E2 Save New Event Rest Api Call: " + url);
			
			Response response = restRequest.sendJsonRequestWithBody(url, parser.toString());
			responseStr = response.jsonPath();		
		   	
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return responseStr;
	}


}
