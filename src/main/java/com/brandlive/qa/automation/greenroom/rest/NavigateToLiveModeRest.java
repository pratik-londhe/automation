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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class NavigateToLiveModeRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();

	public void exitBuilderMode(String host) {
		int response = goToLiveModeFromBuilderMode(host);
		if (response == 200) {
			log.debug("Exit BuilderMode Settings Api is called successfully! ");
		}

	}

	public void editFirstShot(String host) {
		postEditFirstShot(host);

	}

	private int goToLiveModeFromBuilderMode(String host) {
		int response = 0;
		try {
			String token = LoginLogoutRest.E3GR_Token;
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("bl-token", token);
			Reader reader = Files
					.newBufferedReader(Paths.get("src/main/resources/json/payload_create_update_E3_meeting.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode settingFiles = objectMapper.readTree(reader).get("settings_json");
			JsonNode featureFlag = settingFiles.get("featureFlags");

			if (settingFiles.path("hasSynced").asBoolean() == false) {
				((ObjectNode) settingFiles).put("hasSynced", true);
			}
			
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

	private JsonPath postEditFirstShot(String host) {
		JsonPath responseStr = null;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode editBulkPayload = objectMapper.readTree(AddNewShotPageRest.postBulkEditShotsPayload);
			JsonNode shots = editBulkPayload.get("shots");
			JsonNode firstShotDetails = shots.get(0);

			String editFirstShotPayload = "{\"shot\":" + firstShotDetails.toString() + "}";
			String url = "https://" + host + "/v2/greenroom/shots/edit";

			log.info("This is Edit first shot api call: " + url);

			Response response = restRequest.sendJsonRequestWithBody(url, editFirstShotPayload.toString(), headers);
			responseStr = response.jsonPath();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseStr;
	}

}