package com.brandlive.qa.automation.greenroom.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SetSeenNotification extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();

	
	public void setSeenNotification(String host) {
		int seenNotification = postSeenNotification(host);
		log.debug(seenNotification);
		
	}
	
	
	private int postSeenNotification(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		int response = 0;
		String url = "https://" + host + "/v2/greenroom/notifications/set-seen";
		log.info("Set Seen Notifications: " + url);

		JsonObject notificationIds = new JsonObject();
		JsonArray notificationIdArray = new JsonArray();

		notificationIds.add("notificationIDs", notificationIdArray);

		response = restRequest.sendJsonRequestWithBody(url, notificationIds.toString(), headers).getStatusCode();
		return response;
		
	}
}