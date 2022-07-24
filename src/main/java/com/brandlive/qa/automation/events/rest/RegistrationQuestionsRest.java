package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RegistrationQuestionsRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static List<Map<String, Object>> getRegistrationQuestions;
	
	// Public Methods
	public void getRegistrationQuestions(String host, String channelName) {
		getRegistrationQuestions = getRegistrationQuestionsForChannel(host, channelName).getList("$");
	}
	
	// Private Methods
	private JsonPath getRegistrationQuestionsForChannel(String host, String channelName) {
		String url = null;
		String token = null;
		String[] params = null;
		
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		
		eventHomePageRest.getChannelEvents(host, channelName);
		eventHomePageRest.getEventDetails(CreateEventsRest.eventName);
		String event_uuid = (String) EventsHomePageRest.eventDetailsByEventName.get("uuid");
		
		params = generateCloudflareParameters("/v3/admin/events/registration-questions/"+channel_id+"/"+event_uuid);
		url = "https://" + host + "/v3/admin/events/registration-questions/"+channel_id+"/"+event_uuid+"?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 get registration questions rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}

}
