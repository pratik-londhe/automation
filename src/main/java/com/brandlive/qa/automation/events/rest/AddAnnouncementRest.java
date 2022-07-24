package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddAnnouncementRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	
	public static Map<String, Object> wholeEventAnnouncement;
	public static Map<String, Object> registeredAttendeesAnnouncement;
	public static Map<String, Object> allSessionsAnnouncement;
	
	public void wholeEventAnnouncement(String host) {
		wholeEventAnnouncement = postWholeEventAnnouncementResponse(host).get("$");
	}
	
	public void registeredAttendeesAnnouncement(String host) {
		registeredAttendeesAnnouncement = postRegisteredAttendeesAnnouncementResponse(host).get("$");
	}
	
	public void allSessionsAnnouncement(String host) {
		allSessionsAnnouncement = postAllSessionsAnnouncementResponse(host).get("$");
	}
	
	
	private JsonPath postWholeEventAnnouncementResponse(String host) {
		
		// Creating jsonBody
		JsonObject announcementCreation = new JsonObject();
		announcementCreation.addProperty("message_type", "announcement");
		
		JsonObject contentCreation = new JsonObject();
		contentCreation.addProperty("recipients", "event");
		contentCreation.addProperty("eventUUID", CreateEventsRest.eventCreation.getString("uuid"));
		contentCreation.addProperty("messageText", "Whole Event Announcement");
		contentCreation.addProperty("buttonOn", true);
		contentCreation.addProperty("buttonText", "Click");
		contentCreation.addProperty("buttonLinkType", "url");
		contentCreation.addProperty("buttonLink", "https://www.google.com");
		contentCreation.addProperty("scheduleDate", getEditDate());
		
		announcementCreation.add("content", contentCreation);
		
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/notifications/announcement");
		url = "https://" + host + "/v3/admin/notifications/announcement?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, announcementCreation.toString(), headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath postRegisteredAttendeesAnnouncementResponse(String host) {
		
		// Creating jsonBody
		JsonObject announcementCreation = new JsonObject();
		announcementCreation.addProperty("message_type", "announcement");
		
		JsonObject contentCreation = new JsonObject();
		contentCreation.addProperty("recipients", "registered");
		contentCreation.addProperty("eventUUID", CreateEventsRest.eventCreation.getString("uuid"));
		contentCreation.addProperty("messageText", "Registered Attendees Announcement");
		contentCreation.addProperty("scheduleDate", getEditDate());
		
		announcementCreation.add("content", contentCreation);
		
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/notifications/announcement");
		url = "https://" + host + "/v3/admin/notifications/announcement?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, announcementCreation.toString(), headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath postAllSessionsAnnouncementResponse(String host) {
		
		// Creating jsonBody
		JsonObject announcementCreation = new JsonObject();
		announcementCreation.addProperty("message_type", "announcement");
		
		JsonObject contentCreation = new JsonObject();
		contentCreation.addProperty("recipients", "session");
		contentCreation.addProperty("eventUUID", CreateEventsRest.eventCreation.getString("uuid"));
		contentCreation.addProperty("messageText", "All Sessions Announcement");
		contentCreation.addProperty("scheduleDate", getEditDate());

		JsonArray toSessions = new JsonArray();
		List<JsonObject> sessions =  CreateEventsRest.eventCreation.getList("sessions");
		log.debug("The sessions jsonarray is: " + sessions.toString());
		String[] session = sessions.toString().split("session=");
		String sessionId = session[1].substring(0, session[1].indexOf(","));
		toSessions.add(Integer.parseInt(sessionId)); 
		contentCreation.add("toSessions", toSessions);
		
		announcementCreation.add("content", contentCreation);
		
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/notifications/announcement");
		url = "https://" + host + "/v3/admin/notifications/announcement?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, announcementCreation.toString(), headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}

}
