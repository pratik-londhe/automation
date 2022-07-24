package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PrivacyPolicyRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	private static JsonPath addPrivacyPolicyJPath;
	
	public static Map<String, Object> addPrivacyPolicy;
	public static Map<String, Object> addNewPrivacyPolicy;
	public static Map<String, Object> getNewPrivacyPolicy;
	public static Map<String, Object> updateNewPrivacyPolicy;
	
	// public methods
	public void addPrivacyPolicy(String host, String channelName, String policyContent) {
		addPrivacyPolicy = postPrivacyPolicyResponse(host, channelName, policyContent).get("$");
		addNewPrivacyPolicy = addPrivacyPolicyJPath.get("newPolicy");
	}
	
	public void getPrivacyPolicy(String host) {
		getNewPrivacyPolicy = getPrivacyPolicyResponse(host).get("$");
	}
	
	public void updatePrivacyPolicy(String host, String policyContent) {
		updateNewPrivacyPolicy = putPrivacyPolicyResponse(host, policyContent).get("$");
	}
	
	// private methods
	private JsonPath postPrivacyPolicyResponse(String host, String channelName, String policyContent) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		eventHomePageRest.getChannelEvents(host, channelName);
		eventHomePageRest.getEventDetails(CreateEventsRest.eventName);
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");
		
		// Creating payload jsonBody
		JsonObject privacyPolicyCreation = new JsonObject();
		privacyPolicyCreation.addProperty("eventID", event_uuid);
		privacyPolicyCreation.addProperty("channel", channel_id);
		privacyPolicyCreation.addProperty("content", policyContent);		
		
		params = generateCloudflareParameters("/v3/admin/events/privacy-policy");
		url = "https://" + host + "/v3/admin/events/privacy-policy?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event privacy policy creation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, privacyPolicyCreation.toString(), headers);
		//log.debug(response.prettyPrint());
		addPrivacyPolicyJPath = response.jsonPath();
		
		return addPrivacyPolicyJPath;
	}
	
	private JsonPath getPrivacyPolicyResponse(String host) {
		
		String url = null;
		String token = null;
		String[] params = null;	
		
		params = generateCloudflareParameters("/v3/admin/events/privacy-policy/"+addNewPrivacyPolicy.get("privacy_policy"));
		url = "https://" + host + "/v3/admin/events/privacy-policy/"+addNewPrivacyPolicy.get("privacy_policy")+"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event privacy policy get rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		//log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath putPrivacyPolicyResponse(String host, String policyContent) {
		
		String url = null;
		String token = null;
		String[] params = null;	
		
		// Creating payload jsonBody
		JsonObject privacyPolicyUpdation = new JsonObject();
		privacyPolicyUpdation.addProperty("settings", "");
		privacyPolicyUpdation.addProperty("content", policyContent);	
		
		params = generateCloudflareParameters("/v3/admin/events/privacy-policy/"+addNewPrivacyPolicy.get("privacy_policy"));
		url = "https://" + host + "/v3/admin/events/privacy-policy/"+addNewPrivacyPolicy.get("privacy_policy")+"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event privacy policy updation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, privacyPolicyUpdation.toString(), headers);
		//log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}


}
