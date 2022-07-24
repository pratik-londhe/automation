package com.brandlive.qa.automation.greenroom.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FindUsersRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();

	
	public void findUsers(String host) {
		HashMap<String, Object> userDetails = postUsers(host).get("$");
		log.debug(userDetails.get("profile"));
		
	}
	
	
	private JsonPath postUsers(String host) {
		Response response;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/home/find-user";
		log.info("Find Users Api Call url: " + url);

		JsonObject findUser = new JsonObject();

		findUser.addProperty("email", "pradnyanbhilare@gmail.com");

		response = restRequest.sendJsonRequestWithBody(url, findUser.toString(), headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
		
	}
}