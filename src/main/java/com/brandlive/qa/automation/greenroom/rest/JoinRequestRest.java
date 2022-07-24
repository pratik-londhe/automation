package com.brandlive.qa.automation.greenroom.rest;




import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
//import com.jayway.restassured.response.Response;
import io.restassured.response.Response;



public class JoinRequestRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	public static int joinRequest = 0;
	
	
	public static Response isMeetingLive;
	public static Response sendApprovalRequest;
	public static Response updateApprovalRequest;
	public static Response rejectApprovalRequest;
	public static Response listPendingJoinRequest;
	public static Response checkJoinRequest;
	public static Response checkifApprovalIsrequired;
	public static Response checkWatcherState;
	
	

	public void isMeetingLive(String rest_GR_Host) {
		isMeetingLive = getisMeetingLive(rest_GR_Host);

	}



	public void sendApprovalRequest(String rest_GR_Host) {
		sendApprovalRequest = postApprovalRequest(rest_GR_Host);
		joinRequest = sendApprovalRequest.jsonPath().getInt("join_request");
	
	}

	public void updateApprovalRequest(String rest_GR_Host) {
		updateApprovalRequest = putApprovalRequest(rest_GR_Host);
	}

	public void rejectApprovalRequest(String rest_GR_Host) {
		rejectApprovalRequest = deleteRejectApprovalRequest(rest_GR_Host);

	}

	public void listPendingJoinRequest(String rest_GR_Host) {
		listPendingJoinRequest = getListPendingJoinRequest(rest_GR_Host);
		
	}


	public void checkJoinRequest(String rest_GR_Host) {
		checkJoinRequest = getJoinRequest(rest_GR_Host);
	}



	public void checkifApprovalIsrequired(String rest_GR_Host) {
		checkifApprovalIsrequired = getResponseIfApprovalIsrequired(rest_GR_Host);	
	}

	public void checkWatcherState(String rest_GR_Host) {
		checkWatcherState = getWatcherState(rest_GR_Host);
	}



	// private methods
	



	private Response getisMeetingLive(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/is-live/"+ DetailsPageRest.meetingRoomNumber;
			
		log.info("getisMeetingLive Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;

	}

	private Response postApprovalRequest(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject postApprovalRequest = new JsonObject();
		postApprovalRequest.addProperty("meeting", DetailsPageRest.meetingRoomNumber);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/join-request";

		log.info("postApprovalRequest Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, postApprovalRequest.toString(), headers);
		return response;

	}

	private Response putApprovalRequest(String rest_GR_Host) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject putApprovalRequest = new JsonObject();
		putApprovalRequest.addProperty("join_request", joinRequest-1);
		String url = "https://" + rest_GR_Host + "/v2/greenroom/join-request";

		log.info("putApprovalRequest Api call  : " + url);

		Response response = restRequest.sendPutJsonRequestWithBody(url, putApprovalRequest.toString(), headers);

		return response;
	}

	private Response deleteRejectApprovalRequest(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject deleteRejectApprovalRequest = new JsonObject();
		deleteRejectApprovalRequest.addProperty("join_request", joinRequest-1);
		String url = "https://" + rest_GR_Host + "/v2/greenroom/join-request";

		log.info("deleteRejectApprovalRequest Api call  : " + url);

		Response response = restRequest.deleteJsonRequestWithBody(url, deleteRejectApprovalRequest.toString(), headers);

		return response;
	}
		
	private Response getListPendingJoinRequest(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/join-requests/"+ DetailsPageRest.meetingRoomNumber;
			
		log.info("getListPendingJoinRequest Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;

	}
		
	private Response getJoinRequest(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/join-request/"+ DetailsPageRest.meetingRoomNumber;
			
		log.info("getJoinRequest Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;
	}
	
	private Response getResponseIfApprovalIsrequired(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/approval-required/"+ DetailsPageRest.meetingRoomNumber;
			
		log.info("getRespomseIfApprovalIsrequired Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;

	}
		
	private Response getWatcherState(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/watcher-only/"+ DetailsPageRest.meetingRoomNumber;
			
		log.info("getWatcherState Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;
	}


}
