package com.brandlive.qa.automation.greenroom.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;

public class DeleteMediaAndShotRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();
	UploadMediaRest uploadMediaRest = new UploadMediaRest();
 
	public void deleteMedia(String host) {
		String response = postDeleteMedia(host);
		log.debug(response);
		if(!(response.isEmpty())) {
			log.debug("Newly added media id - " +uploadMediaRest.successUploadMediaId+ " was able to delete succesfully!");
		}	
	}
	

	public void deleteShot(String host) {
		String response = postDeleteShot(host);
		log.debug(response);
		if(!(response.isEmpty())) {
			log.debug("Newly added shot - " +AddNewShotPageRest.shotId+ " was able to delete succesfully!");
		}	
	}
	
	//private 
	
	private String postDeleteShot(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		JsonObject deleteShot = new JsonObject();
		deleteShot.addProperty("shotId",AddNewShotPageRest.shotId);
		deleteShot.addProperty("meetingId",DetailsPageRest.meetingRoomNumber);
		
		String url = "https://" + host + "/v2/greenroom/shots/delete";
		log.debug("This is delete api call for " +url);
		String response = restRequest.sendJsonRequestWithBody(url,deleteShot.toString(), headers).getStatusLine();
		return response;
	}

	
	private String postDeleteMedia(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		String url = "https://" + host + "/v2/greenroom/media/" + uploadMediaRest.successUploadMediaId;
		log.debug("This is delete api call" +url);
		String response = restRequest.deleteJsonRequestWithoutBody(url, headers).getStatusLine();
		return response;
		
	}



}