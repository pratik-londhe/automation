package com.brandlive.qa.automation.greenroom.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.db.MySqlConnector;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
import io.restassured.response.Response;

public class StartStopBroadcastRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();
	LiveModePageRest liveModePageRest = new LiveModePageRest();
	MySqlConnector mySqlConnector = new MySqlConnector();

	public static Response broadCastNextShot;

	public void goApiCall(String host, String mode) {

		Response broadcastServer = putLiveCall(host, mode);
		if (mode.equalsIgnoreCase("Live")) {
			String serverId = broadcastServer.jsonPath().getString("broadcast_server");
			if (serverId != null) {
				log.debug("Go Api Call server id with " + mode + " mode is : " + serverId);
			}
		} else {
			int statusCode = broadcastServer.getStatusCode();
			if (statusCode == 200) {
				log.debug("End Api call is success!");
			}
		}
	}

	public void goStreamCall(String host, String mode) {
		int responseStatus = putStreamCall(host, mode);
		log.debug("Stream Call With Api return status for "+mode+" : is  " + responseStatus);

	}

	public void selectNextShot(String host) {
		broadCastNextShot = postSelectNextshot(host);
	}

	private Response putLiveCall(String host, String mode) {
		Response response = null;
		String methodType = null;
		String url = null;
		JsonObject liveApi = new JsonObject();

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		if (mode.equalsIgnoreCase("Live")) {
			methodType = "start";
			liveApi.addProperty("resolution", "1920x1080");
		} else {
			methodType = "stop";
			liveApi.addProperty("", "");
		}

		url = "https://" + host + "/v2/greenroom/broadcast/" + methodType + "/" + DetailsPageRest.meetingRoomNumber;
		response = restRequest.sendPutJsonRequestWithBody(url, liveApi.toString(), headers);

		return response;
	}

	private int putStreamCall(String host, String mode) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/broadcast/stream-state";
		log.info("Stream Api Call url: " + url);

		JsonObject StreamApi = new JsonObject();

		if (mode.equalsIgnoreCase("Live")) {
			StreamApi.addProperty("stream_state", 2);
			StreamApi.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		} else {
			StreamApi.addProperty("stream_state", 0);
			StreamApi.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		}
		int response = restRequest.sendPutJsonRequestWithBody(url, StreamApi.toString(), headers).getStatusCode();
		return response;
	}

	private Response postSelectNextshot(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = null;

		String url = "https://" + host + "/v2/greenroom/shots/edit";
		log.info("E3  Edit api call: " + url);
		
		String payloadNextShot = UploadMediaRest.editPayloadForNewShot.toString();
		
		if (payloadNextShot != null) {

		response = restRequest.sendJsonRequestWithBody(url, UploadMediaRest.editPayloadForNewShot.toString(), headers);
		}
		else {
			log.error("Cannot play next shot because no media was uploaded. This is just empty shot!");
		}
		return response;
	}

}
