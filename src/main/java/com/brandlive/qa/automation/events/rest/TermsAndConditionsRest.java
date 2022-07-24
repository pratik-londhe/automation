package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TermsAndConditionsRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	private static JsonPath addToCJPath;
	
	public static Map<String, Object> addTermsAndConditions;
	public static Map<String, Object> addNewTermsAndConditions;
	public static Map<String, Object> getNewTermsAndConditions;
	public static Map<String, Object> updateNewTermsAndConditions;
	
	// public methods
	public void addTermsAndConditions(String host, String channelName, String tocContent) {
		addTermsAndConditions = postTermsAndConditionsResponse(host, channelName, tocContent).get("$");
		addNewTermsAndConditions = addToCJPath.get("newTerms");
	}
	
	public void getTermsAndConditions(String host) {
		getNewTermsAndConditions = getTermsAndConditionsResponse(host).get("$");
	}
	
	public void updateTermsAndConditions(String host, String tocContent) {
		updateNewTermsAndConditions = putTermsAndConditionsResponse(host, tocContent).get("$");
	}
	
	// private methods
	private JsonPath postTermsAndConditionsResponse(String host, String channelName, String tocContent) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		eventHomePageRest.getChannelEvents(host, channelName);
		eventHomePageRest.getEventDetails(CreateEventsRest.eventName);
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");
		
		// Creating payload jsonBody
		JsonObject termsNConditionCreation = new JsonObject();
		termsNConditionCreation.addProperty("eventID", event_uuid);
		termsNConditionCreation.addProperty("channel", channel_id);
		termsNConditionCreation.addProperty("content", tocContent);		
		
		params = generateCloudflareParameters("/v3/admin/events/terms-conditions");
		url = "https://" + host + "/v3/admin/events/terms-conditions?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, termsNConditionCreation.toString(), headers);
		//log.debug(response.prettyPrint());
		addToCJPath = response.jsonPath();
		
		return addToCJPath;
	}
	
	private JsonPath getTermsAndConditionsResponse(String host) {
		
		String url = null;
		String token = null;
		String[] params = null;	
		
		params = generateCloudflareParameters("/v3/admin/events/terms-conditions/"+addNewTermsAndConditions.get("terms_id"));
		url = "https://" + host + "/v3/admin/events/terms-conditions/"+addNewTermsAndConditions.get("terms_id")+"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		//log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath putTermsAndConditionsResponse(String host, String tocContent) {
		
		String url = null;
		String token = null;
		String[] params = null;	
		
		// Creating payload jsonBody
		JsonObject termsNConditionCreation = new JsonObject();
		termsNConditionCreation.addProperty("settings", "");
		termsNConditionCreation.addProperty("content", tocContent);	
		
		params = generateCloudflareParameters("/v3/admin/events/terms-conditions/"+addNewTermsAndConditions.get("terms_id"));
		url = "https://" + host + "/v3/admin/events/terms-conditions/"+addNewTermsAndConditions.get("terms_id")+"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, termsNConditionCreation.toString(), headers);
		//log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}

}
