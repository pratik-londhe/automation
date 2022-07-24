package com.brandlive.qa.automation.greenroom.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.restassured.response.Response;

public class BuilderModePageRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();

	public static int settingApiResponse;
	public static String isProducerForSession;

	public void postSettingsApi(String host) {
		settingApiResponse = settingApi(host);

	}


	public void checkProducerSessionCall(String host){
		isProducerForSession=getCheckProducerSessionCall(host);
	}

	private int settingApi(String host) {
		int response = 0;
		try {
			String token = LoginLogoutRest.E3GR_Token;
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("bl-token", token);
			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_create_update_E3_meeting.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode settingFiles = objectMapper.readTree(reader).get("settings_json");
			JsonObject settingApi = new JsonObject();
			settingApi.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
			settingApi.addProperty("settings", String.valueOf(settingFiles));
			String url = "https://" + host + "/v2/greenroom/settings";
			log.info("E3 Settings API   " + url);
			response = restRequest.sendJsonRequestWithBody(url, settingApi.toString(), headers).getStatusCode();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return response;
	}

	private String getCheckProducerSessionCall(String host){
		Response response = null;
		String responseStr = null;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		String url = "https://" + host + "/v2/greenroom/events/is-producer-for-session/" + DetailsPageRest.meetingRoomNumber;
		log.debug("This check producer session call" +url);
		response = restRequest.sendJsonRequestWithoutBody(url, headers);
		responseStr = response.asString();
		return responseStr;
	}
}