package com.brandlive.qa.automation.greenroom.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.events.rest.EventsHomePageRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EventsForProducer extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();

	
	public void getEventForProducer(String host) {
		ArrayList<Object> eventDetails = getProducerEvents(host).get("$");
	}
	
	
	private JsonPath getProducerEvents(String host) {
		Response response;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		int channelId = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		
		String url = "https://" + host + "/v2/greenroom/meetings-events-legacy-producer/"+channelId;
		log.info("Get Event Details for Producer Url: " + url);

		response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
		
	}
}