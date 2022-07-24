package com.brandlive.qa.automation.greenroom.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RetrieveNotificationRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();

	
	public void retrieveNotificationDetails(String host) {
		ArrayList<String> notification = getNotificationDetails(host).get("$");
		log.debug(notification.toString());
		
	}
	
	
	private JsonPath getNotificationDetails(String host) {
		Response response;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/notifications/get";
		log.info("Retrieve Notification Details: " + url);

		response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
		
	}

}