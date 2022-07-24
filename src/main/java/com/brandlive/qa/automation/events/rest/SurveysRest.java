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
import com.fasterxml.jackson.databind.node.ArrayNode;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SurveysRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static Response getChannelSurveysByChannelIdRes;
	public static Response getChannelSurveysRes;
	
	public static JsonPath getChannelSurveysByChannelIdJsonPath;
	public static JsonPath getChannelSurveysJsonPath;
	
	public static List<Map<String, Object>> channelSurveys;
	public static List<Map<String, Object>> surveysByChannelId;
	public static JsonNode selectedSurvey = null; //Survey for the payload
	
	// public methods
	
	public void getChannelSurveys(String host, String channelName) {
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/channel/surveys");
		url = "https://" + host + "/v3/admin/channel/surveys?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getChannelSurveysRes = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(getChannelSurveysRes.prettyPrint());
		getChannelSurveysJsonPath = getChannelSurveysRes.jsonPath();
		channelSurveys = getChannelSurveysJsonPath.get("$");
	}
	
	public void channelSurveysByChannelId(String host, String channelName) {
		surveysByChannelId = getChannelSurveysByChannelId(host, channelName).get("$");
	}
	
	// private methods
	
	private JsonPath getChannelSurveysByChannelId(String host, String channelName) {
		
		String url = null;
		String token = null;
		String[] params = null;

		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		
		params = generateCloudflareParameters("/v3/admin/events/surveys/" + channel_id);
		url = "https://" + host + "/v3/admin/events/surveys/"+channel_id+"?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getChannelSurveysByChannelIdRes = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(getChannelSurveysByChannelIdRes.prettyPrint());
		getChannelSurveysByChannelIdJsonPath = getChannelSurveysByChannelIdRes.jsonPath();
		
		return getChannelSurveysByChannelIdJsonPath;
		
	}
	
	public void getAutomationPollSurveyInChannel() {
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode surveysResRoot = null;
		
		try {
			surveysResRoot = objectMapper.readTree(getChannelSurveysRes.prettyPrint());
			if(surveysResRoot.isArray()) {
				for(JsonNode node : surveysResRoot) {
					JsonNode name = node.path("name");
					String base = name.path("base").asText();
					ArrayNode questions = (ArrayNode) node.path("questions");
					JsonNode question = questions.get(0);
					ArrayNode options = (ArrayNode) question.path("options");
					if(base.contains("Automation Poll") && options.size() == 3) {
						selectedSurvey = node;
						break;
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
