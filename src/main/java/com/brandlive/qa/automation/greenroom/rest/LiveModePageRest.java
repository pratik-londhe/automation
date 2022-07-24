package com.brandlive.qa.automation.greenroom.rest;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.db.MySqlConnector;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LiveModePageRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();
	DetailsPageRest detailsPageRest = new DetailsPageRest();
	MySqlConnector mySqlConnector = new MySqlConnector();


	public static int writeStateAPIResponse;
	public static String tokboxToken;
	public static String use_sync;
	public static String use_sync_media;
	public static String writeStateSession= "writeStateSession";

	public static JsonPath featureFlag;
	public static List<Map<String, Object>> backgroundImg;


	// public method
	public void featureFlagApiCall(String host) {
		featureFlag = postFeatureFlagApiCall(host);
		use_sync = featureFlag.getString("use_sync");
		use_sync_media = featureFlag.getString("use_sync_media");
	}

	public void tokboxTokenApi(String host) {
		tokboxToken = postTokBoxToken(host).get("token");
	}

	public void writeStateAPI(String host,String actionType, String grPageMode){
		writeStateAPIResponse = postWriteStateApi(host, actionType,grPageMode);
	}

	public void getBackground(String host) {
		backgroundImg = getBackgroundInLiveMode(host).get("$");
	}



	// private method
	private JsonPath postFeatureFlagApiCall(String host) {
		String url = "https://" + host + "/v2/greenroom/feature-flags" ;
		log.info("E3 Feature Flag Api   " + url);
		Response response = restRequest.sendJsonPostRequestWithURL(url);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath postTokBoxToken(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject meeting = new JsonObject();
		meeting.addProperty("sessionId", detailsPageRest.opentok_session);

		String url = "https://" + host + "/get-tokbox-token";
		log.info("E3 Tokbox token api call: " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, meeting.toString(),headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private int postWriteStateApi(String host, String actionType, String grPageMode) {
		String payloadBody = null;
		int roomNumber = DetailsPageRest.meetingRoomNumber;
		long timestamp = Instant.now().toEpochMilli();
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String imageUrl=null;
		String mediaName=null;
		int mediaId=0;
		int shotId=0;
		int response = 0;
		
		if (grPageMode.equalsIgnoreCase("Live") || grPageMode.equalsIgnoreCase("Builder")) {
			mediaId = (int) DetailsPageRest.meetingRoomMediaDetails.get(0).get("id");
			mediaName = (String) DetailsPageRest.meetingRoomMediaDetails.get(0).get("custom_name");
			shotId = (int) DetailsPageRest.shots.getList("shot_id").get(0);
			imageUrl = "https://assets.brandlive.com/uploads/all-meetings/videos/Make_Em_Go_Wow.mp4";
			
		}else if(grPageMode.equalsIgnoreCase("Broadcast")) {
			mediaId = UploadMediaRest.successUploadMediaId;
			mediaName = UploadMediaRest.uploadedFileName;
			shotId = UploadMediaRest.editPayloadForNewShot.get("shot").get("shot_id").asInt();
			imageUrl = getEndpointMediaDetailsFromDatabase();	
		}

		if(writeStateSession.equalsIgnoreCase("writeStateSession")) {
			writeStateSession = getRandomNumberString();
		}


		try {

			if (actionType.equalsIgnoreCase("SET_PRESENTED_MEDIA")){
				 payloadBody = setPresentedMedia(roomNumber,mediaId,mediaName,timestamp,actionType,grPageMode,imageUrl);
				 log.debug("Set presented media for" + grPageMode + " is " +payloadBody);
			}else if (actionType.equalsIgnoreCase("ADD_PRESENTER_VIDEO")){
				 payloadBody = addPresenterVideo(roomNumber,actionType,timestamp);
			}else if (actionType.equalsIgnoreCase("SET_CURRENT_SHOT_ID")){
				 payloadBody = setCurrentShotId(roomNumber,actionType,timestamp,shotId);
			}
			
			String url = "https://" + host + "/write-state";
			log.info("E3 Live Mode - Write State Api for " + grPageMode + " is : "+ url);
			response = restRequest.sendJsonRequestWithBody(url, payloadBody,headers).getStatusCode();
		}

		catch(IOException e) {
			e.printStackTrace();
		}
		return response;
	}


	private JsonPath getBackgroundInLiveMode(String host) {
		String url = "https://" + host + "/v2/greenroom/media/all-meetings/backgrounds" ;
		String token = LoginLogoutRest.E3GR_Token;

		log.info("E3 Background Images in Live Mode Api : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private String setPresentedMedia(int roomNumber, int mediaId, String mediaName, long timestamp, String actionType, String grPageMode, String imageUrl) throws IOException {

		log.debug("This is imageURL :  " +imageUrl);
		
		Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_write_state_set_presented_media.json"));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode parser = objectMapper.readTree(reader);
		JsonNode action = parser.path("action");
		ArrayNode payload = (ArrayNode) action.get("payload");	
				
	    ArrayNode resultArray = JsonNodeFactory.instance.arrayNode();
        resultArray.add(imageUrl); 
        
		/* Updating values from file */

		if (parser.path("room").asInt() == 0) {
			((ObjectNode) parser).put("room", roomNumber);
		}

		if (action.path("type").asText().equalsIgnoreCase("actionType")) {
			((ObjectNode) action).put("type", actionType);
		}
		
		
		if(payload.isArray()) {
			if (grPageMode.equalsIgnoreCase("Builder")) {
				payload.removeAll();
			}else if(grPageMode.equalsIgnoreCase("Live") || (grPageMode.equalsIgnoreCase("Broadcast"))) {
			for(JsonNode jsonNode : payload) {
				((ObjectNode) jsonNode).put("mediaId", mediaId);
				((ObjectNode) jsonNode).put("name" ,  mediaName);
				((ObjectNode) jsonNode).put("pages" ,  resultArray);

				}
			}
			
		}		
		

		if (parser.path("session").asText().equalsIgnoreCase("session")) {
			((ObjectNode) parser).put("session", writeStateSession);
		}

		if (parser.path("timestamp").asLong() == 0) {
			((ObjectNode) parser).put("timestamp", timestamp);
		}



		
		return parser.toString();
	}

	private String addPresenterVideo(int roomNumber, String actionType, long timestamp) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_write_state_add_presenter_media.json"));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode parser = objectMapper.readTree(reader);
		JsonNode action = parser.path("action");
		JsonNode payload = action.path("payload");
		String uuid = createRandomUUID();

		/* Updating values from file */

		if (parser.path("room").asInt() == 0) {
			((ObjectNode) parser).put("room", roomNumber);
		}

		if (action.path("type").asText().equalsIgnoreCase("actionType")) {
			((ObjectNode) action).put("type", actionType);
		}

		if (payload.path("id").asText().equalsIgnoreCase("uuId")) {
			((ObjectNode) payload).put("id", uuid);
		}

		if (parser.path("session").asText().equalsIgnoreCase("session")) {
			((ObjectNode) parser).put("session", writeStateSession);
		}

		if (parser.path("timestamp").asLong() == 0) {
			((ObjectNode) parser).put("timestamp", timestamp);
		}

		return parser.toString();
	}

	private String setCurrentShotId(int roomNumber, String actionType, long timestamp, int shotId) throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_write_state_set_current_shot_id.json"));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode parser = objectMapper.readTree(reader);
		JsonNode action = parser.path("action");
				
		/* Updating values from file */

		if (parser.path("room").asInt() == 0) {
			((ObjectNode) parser).put("room", roomNumber);
		}

		if (action.path("type").asText().equalsIgnoreCase("actionType")) {
			((ObjectNode) action).put("type", actionType);
		}
		
		if (action.path("payload").asInt() == 0) {
			((ObjectNode) action).put("payload", shotId);
		}

		if (parser.path("session").asText().equalsIgnoreCase("session")) {
			((ObjectNode) parser).put("session", writeStateSession);
		}

		if (parser.path("timestamp").asLong() == 0) {
			((ObjectNode) parser).put("timestamp", timestamp);
		}

		return parser.toString();
	}
	
	
	
	public static String getRandomNumberString() {
		  String sessionId = RandomStringUtils.randomAlphanumeric(8);
		  return sessionId;
	}

	private String getEndpointMediaDetailsFromDatabase() {
		String query = "select images from gr_media where id = "+UploadMediaRest.successUploadMediaId;
		String dbValue = mySqlConnector.getGR_TableColumnValue("images", "String", query);
		log.debug("Value from database :  " +dbValue);
		return dbValue; 
		
	}
}
