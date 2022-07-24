package com.brandlive.qa.automation.greenroom.rest;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.db.MySqlConnector;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UploadMediaRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();
	MySqlConnector mySqlConnector = new MySqlConnector();


	public static JsonPath uploadMediaResponse;
	public static JsonPath verifyUploadMediaResponse;
	public static Response dragNdropResponse;
	public static JsonNode editPayloadForNewShot;
	public static int successUploadMediaId=0;
	public static String uploadedFileName;

	public void uploadMediaFile(String host, String fileName) {
			uploadMediaResponse = postMultiPartMedia(host,fileName);		
	}

	public void VerifyUploadMediaFile(String host, String fileName) throws InterruptedException {
		log.debug("Doing verification for file Name : " +fileName);
		verifyUploadMediaResponse = verifyUpload(host);
		
		ArrayList<Map<String, Object>> cloudConvert_id = verifyUploadMediaResponse.get("$");
		Map<String, Object> newMediaDetails = cloudConvert_id.get(0);
		
		String convertStatusFromDb = getConvertStatusValueFromDatabase(getNewlyAddedMediaId());
		
		for (Entry<String, Object> entry : newMediaDetails.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("convert_status")) {
				log.debug("Cloud Convert Status for newly added media : " + entry.getValue());
				if (entry.getValue().equals("complete") && convertStatusFromDb.equalsIgnoreCase("complete")) {
					successUploadMediaId  =  getNewlyAddedMediaId();
					uploadedFileName = fileName;
					log.debug("For file Name: " +fileName+ " ("+successUploadMediaId+") convert status from dB is : " +convertStatusFromDb+"");
				}
			}
		}
	}


	public void addMediaToShot(String host) {
		dragNdropResponse = postMediaToShot(host);
		
	}
	
	
	// private method
	
	
	private JsonPath postMultiPartMedia(String host, String fileName) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		File newVideoFile ;
		
		if(fileName.contains("mp4")) {
			newVideoFile= new File("src/test/resources/greenroomMedia/videos/"+fileName);
		}else if ((fileName.contains("pdf"))){
			newVideoFile = new File("src/test/resources/greenroomMedia/documents/"+fileName);
		}else {
			newVideoFile = new File("src/test/resources/greenroomMedia/images/"+fileName);
		}
		
		String url = "https://" + host + "/v2/greenroom/media/" + DetailsPageRest.meetingRoomNumber + "/upload";

		Response response = restRequest.sendPostMultiParMedia(headers, url, newVideoFile);
		log.debug(response.getStatusCode());
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private JsonPath verifyUpload(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		String url = "https://" + host + "/v2/greenroom/media/" + DetailsPageRest.meetingRoomNumber;

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private Response postMediaToShot(String host) {
	String token = LoginLogoutRest.E3GR_Token;
	Map<String, String> headers = new HashMap<String, String>();
	headers.put("bl-token", token);
	Response response = null;
	
	if(successUploadMediaId!=0) {
	try {

		ObjectMapper objectMapper = new ObjectMapper();
		log.debug("success upload media id : " +successUploadMediaId);
		// Actual payload for adding a media to canvas
		JsonNode mediaToCanvasPayload = objectMapper.readTree(AddNewShotPageRest.postSelectShotPayload);
		JsonNode shot = mediaToCanvasPayload.get("shot");
		JsonNode shot_data = shot.get("shot_data");
		
		ArrayNode mediaArrayNode = (ArrayNode) shot_data.get("shotFeeds");
		JsonNode  firstMedia = mediaArrayNode.get(0);	
		
		if (shot_data.path("shotDuration").asInt() == 0) {
			((ObjectNode) shot_data).put("shotDuration", 300);
		}
		
		if (shot.path("edited").isTextual()) {
			((ObjectNode) shot).put("edited", getEditDate());
		}
		
		if (firstMedia.path("feedType").isTextual()) {
			((ObjectNode) firstMedia).put("feedType", "media");
		}
		
		if (firstMedia.path("media").isNull()) {
			((ObjectNode) firstMedia).put("media", successUploadMediaId);
		}
		
		editPayloadForNewShot = mediaToCanvasPayload;
		
		log.debug("This is Adding Media To Canvas Api " + mediaToCanvasPayload.toString());

		String url = "https://" + host + "/v2/greenroom/shots/edit";
		log.info("Adding Media To Canvas Api" + url);

		response = restRequest.sendJsonRequestWithBody(url, mediaToCanvasPayload.toString(), headers);

	} catch (IOException e) {
		e.printStackTrace();
		}
	}
	return response;
	}	

	private int getNewlyAddedMediaId() {
		String newMediaId = uploadMediaResponse.getString("id");
		return Integer.valueOf(newMediaId.substring(1, newMediaId.length() - 1));
	}
	
	private String getConvertStatusValueFromDatabase(int newlyAddedMediaId) {
		String query = "select convert_status FROM ybl.gr_media where id = "+newlyAddedMediaId;
		String dbValue = mySqlConnector.getGR_TableColumnValue("convert_status", "String", query);
		log.debug("Value from database :  " +dbValue);
		return dbValue;
	}
}