package com.brandlive.qa.automation.greenroom.rest;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class AddNewShotPageRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();
	DetailsPageRest detailsPageRest = new DetailsPageRest();

	public static JsonPath addNewShots;
	public static int shotId;
	public static Response postAddNewShots;

	public static int editBulkShots;
	public static String postBulkEditShotsPayload;

	public static JsonPath editShots;
	public static String postEditShotsPayload;

	public static String postSelectShotPayload;
	public static Response selectShotResponse;

	public static String editShotDurationPayload;
	public static Response editshotDurationResponse;

	// public method

	public void addNewShot(String host) {
		addNewShots = postAddNewShots(host);
	}

	public void editBulkShot(String host,String mode) {
		editBulkShots = postEditBulkShot(host, mode);
	}

	public void editShot(String host) {
		editShots = postEditShots(host);
	}

	public void selectNewlyAddedShot(String host) {
		selectShotResponse= postSelectNewlyAddedShot(host);

	}

	public void addShotDuration(String host) {
		editshotDurationResponse = postShotDuration(host);
	}

	public void getShotDetails(Response selectShotResponse) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode selectNewShot = objectMapper.readTree(selectShotResponse.asString());
			for (int i = 0; i < selectNewShot.size(); i++) {
				if (selectNewShot.get(i).get("shot_data").get("shotTitle").asText().equalsIgnoreCase("Shot 3")) {
					log.debug("Shot Duration : " + selectNewShot.get(i).get("shot_data").get("shotDuration").asText());
					log.debug("Shot Id : " + selectNewShot.get(i).get("shot_id").asInt());
					shotId = selectNewShot.get(i).get("shot_id").asInt();
					log.debug("Shot Status : " + selectNewShot.get(i).get("status").asInt());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// private method

	private JsonPath postAddNewShots(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		JsonPath responseStr = null;

		try {

			/* Reading json file */

			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_addNewShot.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode parser = objectMapper.readTree(reader);
			JsonNode shot = parser.path("shot");

			/* Updating values from file */

			if (parser.path("meetingId").asInt() == 0) {
				((ObjectNode) parser).put("meetingId", detailsPageRest.meetingRoomNumber);
			}

			if (shot.path("meeting").asInt() == 0) {
				((ObjectNode) shot).put("meeting", detailsPageRest.meetingRoomNumber);
			}

			log.debug("Add Shot Api payload body " + parser.toString());

			String url = "https://" + host + "/v2/greenroom/shots/add";
			log.info("E3 Add New Shots rest api call: " + url);

			Response response = restRequest.sendJsonRequestWithBody(url, parser.toString(), headers);
			postAddNewShots = response;
			responseStr = response.jsonPath();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseStr;
	}

	private int postEditBulkShot(String host , String mode) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		String postJsonShots= null;
		
		if (mode.equalsIgnoreCase("Delete")) {
			log.debug("Bulk update for delete media!! ");
			postJsonShots = detailsPageRest.shots.prettify();
			log.debug("the delete media bulk shot load --> " +postJsonShots);
		}else {
			 postJsonShots = detailsPageRest.postJsonShots.asString();
		}
		
		postBulkEditShotsPayload = "{\"shots\":" + postJsonShots + ",\"meetingId\":"
				+ detailsPageRest.meetingRoomNumber + "}";
		String url = "https://" + host + "/v2/greenroom/shots/bulk-edit";
		log.info("E3 Bulk Edit api call: " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, postBulkEditShotsPayload.toString(), headers);
		return response.getStatusCode();
	}

	private JsonPath postEditShots(String host) {
		JsonPath responseStr = null;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		postEditShotsPayload = "{\"shot\":" + postAddNewShots.asString() + ",\"meetingId\":"
				+ detailsPageRest.meetingRoomNumber + "}";
		String url = "https://" + host + "/v2/greenroom/shots/edit";

		log.debug("This is Edit Api Payload " + postEditShotsPayload);

		log.info("E3  Edit api call: " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, postEditShotsPayload.toString(), headers);
		responseStr = response.jsonPath();
		return responseStr;
	}

	private Response postSelectNewlyAddedShot(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = null;
		try {

			String createdTime = null;
			ObjectMapper objectMapper = new ObjectMapper();

			// For getting created time from EditBulkShot Payload
			JsonNode createdTimeBulkEdit = objectMapper.readTree(postBulkEditShotsPayload);
			JsonNode shots = createdTimeBulkEdit.get("shots");
			for (int i = 0; i < shots.size(); i++) {
				if (shots.get(i).get("shot_data").get("shotTitle").asText().equalsIgnoreCase("Shot 3")) {
					createdTime = shots.get(i).get("created").asText();
				}
			}
			
			// Actual payload for select Shot
			JsonNode selectShotPayload = objectMapper.readTree(postEditShotsPayload);
			JsonNode shot = selectShotPayload.get("shot");
			JsonNode shot_data = shot.get("shot_data");

			if (shot_data.path("order").asInt() == 0) {
				((ObjectNode) shot_data).put("order", 1);
			}

			((ObjectNode) shot).put("created", createdTime);
			((ObjectNode) shot).put("edited", getEditDate());
			((ObjectNode) shot).put("media", NullNode.getInstance());
			((ObjectNode) shot).put("presenters", NullNode.getInstance());
			((ObjectNode) shot).put("status", 1);

			log.debug("Select Newly created shot Api Payload " + selectShotPayload.toString());
			postSelectShotPayload = selectShotPayload.toString();

			String url = "https://" + host + "/v2/greenroom/shots/edit";
			log.info("E3  Edit api call: " + url);

			response = restRequest.sendJsonRequestWithBody(url, selectShotPayload.toString(), headers);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;

	}

	private Response postShotDuration(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = null;

		try {

			ObjectMapper objectMapper = new ObjectMapper();

			// Actual payload for shot duration
			JsonNode shotDurationPayload = objectMapper.readTree(postSelectShotPayload);
			JsonNode shot = shotDurationPayload.get("shot");
			JsonNode shot_data = shot.get("shot_data");

			if (shot_data.path("shotDuration").asInt() == 0) {
				((ObjectNode) shot_data).put("shotDuration", 300);
			}
			
			if (shot.path("edited").isTextual()) {
				((ObjectNode) shot).put("edited", getEditDate());
			}
						
			editShotDurationPayload = shotDurationPayload.toString();

			String url = "https://" + host + "/v2/greenroom/shots/edit";
			log.info("E3  Edit api call for shot duration: " + url);

			response = restRequest.sendJsonRequestWithBody(url, shotDurationPayload.toString(), headers);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;

	}

}
