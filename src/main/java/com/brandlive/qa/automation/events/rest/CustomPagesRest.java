package com.brandlive.qa.automation.events.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

public class CustomPagesRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static Response addCustomPageResponse;
	public static Response updateCustomPageResponse;
	public static Response getCustomPageResponse;
	
	public static Map<String, Object> addCustomPageToEvent;
	public static Map<String, Object> updateCustomPageToEvent;
	public static List<Map<String, Object>> getCustomPagesOfEvent;
	
	// public methods
	
	public void addCustomPageToEvent(String host) {
		addCustomPageToEvent = postCustomPagesToEvent(host).get("$");
	}
	
	public void updateCustomPageToEvent(String host) {
		updateCustomPageToEvent = putCustomPagesToEvent(host).get("$");
	}
	
	public void getCustomPageOfEvent(String host, String channelName) {
		getCustomPagesOfEvent = getCustomPagesByEventUuid(host, channelName).get("$");
	}
	
	// private methods
	
	private JsonPath postCustomPagesToEvent(String host) {
		String url = null;
		String token = null;
		String[] params = null;
		
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		
		String nameOfCustomPage = "Custom_Page_" + (int) (Math.random() * 100) + 1;
		
		// Creating payload jsonBody
		JsonObject customPageCreation = new JsonObject();
		customPageCreation.addProperty("icon", "breakoutRooms");
		customPageCreation.addProperty("channel", channel_id);	
		customPageCreation.addProperty("type", "web");
		customPageCreation.addProperty("path", nameOfCustomPage.replace("_", "-"));
		
		JsonObject page_name = new JsonObject();
		page_name.addProperty("base", nameOfCustomPage);
		page_name.addProperty("en", nameOfCustomPage);
		page_name.addProperty("changed", true);
		
		customPageCreation.add("page_name", page_name);
		
		params = generateCloudflareParameters("/v3/admin/events/custom-page");
		url = "https://" + host + "/v3/admin/events/custom-page?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 custom page creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		addCustomPageResponse = restRequest.sendJsonRequestWithBody(url, customPageCreation.toString(), headers);
		//log.debug(addCustomPageResponse.prettyPrint());
		JsonPath addCustomPageToEvent = addCustomPageResponse.jsonPath();
		
		return addCustomPageToEvent;		
	}
	
	private JsonPath putCustomPagesToEvent(String host) {
		String url = null;
		String token = null;
		String[] params = null;
		
		ObjectMapper objectMapperForCustomPageRes = new ObjectMapper();
		JsonNode customPageResRoot = null;
		JsonNode pageName = null;
		try {
			customPageResRoot = objectMapperForCustomPageRes
					.readTree(CustomPagesRest.addCustomPageResponse.prettyPrint());
			pageName = customPageResRoot.path("page_name");
		} catch (IOException e) {
			e.printStackTrace();
		}

		((ObjectNode) customPageResRoot).put("icon", "infoOutline");
		((ObjectNode) pageName).put("changed", "true");
		
		params = generateCloudflareParameters("/v3/admin/events/custom-page");
		url = "https://" + host + "/v3/admin/events/custom-page?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 custom page updation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		updateCustomPageResponse = restRequest.sendPutJsonRequestWithBody(url, customPageResRoot.toString(), headers);
		//log.debug(updateCustomPageResponse.prettyPrint());
		JsonPath updateCustomPageToEvent = updateCustomPageResponse.jsonPath();
		
		return updateCustomPageToEvent;		
	}
	
	private JsonPath getCustomPagesByEventUuid(String host, String channelName) {
		String url = null;
		String token = null;
		String[] params = null;
		
		eventHomePageRest.getChannelEvents(host, channelName);
		eventHomePageRest.getEventDetails(CreateEventsRest.eventName);
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");
		
		params = generateCloudflareParameters("/v3/admin/events/custom-pages/"+event_uuid);
		url = "https://" + host + "/v3/admin/events/custom-pages/"+event_uuid+"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 custom page rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getCustomPageResponse = restRequest.sendJsonRequestWithoutBody(url, headers);
		//log.debug(getCustomPageResponse.prettyPrint());
		JsonPath getCustomPagesOfEvent = getCustomPageResponse.jsonPath();
		
		return getCustomPagesOfEvent;	
	}
}
