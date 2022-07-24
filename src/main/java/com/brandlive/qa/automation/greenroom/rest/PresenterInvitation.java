package com.brandlive.qa.automation.greenroom.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PresenterInvitation extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();

	
	public void presenterInvitationCall(String host) {
		ArrayList<Object> presenter = getPresenterInvitation(host).get("$");		
	}
	
	
	private JsonPath getPresenterInvitation(String host) {
		Response response;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/presenter-invitations";
		log.info("Get Presenter Invitation Api Call url: " + url);

		response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
		
	}


}