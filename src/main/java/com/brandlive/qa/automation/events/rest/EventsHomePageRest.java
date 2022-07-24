package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EventsHomePageRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();

	public static Map<String, Object> e3ChannelInfo = new HashMap<String, Object>();
	public static Map<String, Object> e2ChannelInfo = new HashMap<String, Object>();

	public static List<Map<String, Object>> eventDetailsByChannelId;
	public static Map<String, Object> eventDetailsByEventName;
	public static Map<String, Object> refreshedToken;

	/* public methods */

	public void e3Channels(String host, String channelName) {
		List<Map<String, Object>> json = getE3Channels(host).get("$");
		log.debug("E3 Channels response " + json);
		for (Map<String, Object> channel : json) {
			if (channel.get("name").equals(channelName)) {
				e3ChannelInfo = channel;
				break;
			}
		}
	}

	public void getChannelEvents(String host, String channelName) {
		e3Channels(host, channelName);
		String channel_id = String.valueOf(e3ChannelInfo.get("channel"));
		eventDetailsByChannelId = getEventsByChannelId(host, channel_id).get("$");
	}

	public void getEventDetails(String eventName) {
		if (eventDetailsByChannelId != null) {
			for (Map<String, Object> event : eventDetailsByChannelId) {
				if (event.get("name").equals(eventName)) {
					eventDetailsByEventName = event;
					break;
				}
			}
		}
	}

	public void e2Channels(String host, String channelName) {
		List<Map<String, Object>> json = getE2Channels(host).get("$");
		for (Map<String, Object> channel : json) {
			if (channel.get("name").equals(channelName)) {
				e2ChannelInfo = channel;
				break;
			}
		}
	}
	
	public void refreshToken(String host) {
		refreshedToken = getRefreshedToken(host).get("$");
	}

	/* private methods */

	private JsonPath getE3Channels(String host) {
		String url = null;
		String token = null;
		String[] params = generateCloudflareParameters("/v3/admin/auth/channels");
		url = "https://" + host + "/v3/admin/auth/channels?expiry=" + params[0] + "&mac=" + params[1];
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		// log.info("E3 Channels response " + responseStr.prettyPrint());
		return responseStr;
	}

	private JsonPath getEventsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Details by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/events/" + channelId);
		url = "https://" + host + "/v3/admin/events/" + channelId + "?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}

	private JsonPath getE2Channels(String host) {
		String url = "https://" + host + "/client-list";
		String token = LoginLogoutRest.E2_Token;

		log.info("E2 channels rest api call: " + url);

		JsonObject E2LoginToken = new JsonObject();
		E2LoginToken.addProperty("token", token);

		Response response = restRequest.sendJsonRequestWithBody(url, E2LoginToken.toString());

		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	
	private JsonPath getRefreshedToken(String host) {
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/auth/refresh-token");
		url = "https://" + host + "/v3/admin/auth/refresh-token?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
}
