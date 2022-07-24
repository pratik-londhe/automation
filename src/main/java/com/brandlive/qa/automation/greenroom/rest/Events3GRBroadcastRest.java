package com.brandlive.qa.automation.greenroom.rest;

import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
//import com.jayway.restassured.response.Response;
import io.restassured.response.Response;


public class Events3GRBroadcastRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	public static int internalServerId = 0;

	public static Response createInternalServer;
	public static Response checkBroadcastServer;
	public static Response checkLegacyRtmpAddress;
	public static Response updateRtmpEndPoint;
	public static Response updateRtmpCustomEndPoint;
	public static Response startBroadcastServer;
	public static Response autoStartBroadcastServer;
	public static Response setSetStream;
	public static Response checkStreamState;
	public static Response writeBroadcastError;
	public static Response fetchBroadcastError;
	public static Response resetBroadcastState;

	public void createInternalServer(String rest_GR_Host) {

		createInternalServer = postCreateInternalServer(rest_GR_Host);
		internalServerId = createInternalServer.jsonPath().get("server");
	}

	public void checkBroadcastServer(String rest_GR_Host) {

		checkBroadcastServer = getBroadcastServer(rest_GR_Host);
	}

	public void checkLegacyRtmpAddress(String rest_GR_Host) {
		checkLegacyRtmpAddress = getLegacyRtmpAddress(rest_GR_Host);
	}

	public void updateRtmpEndPoint(String rest_GR_Host) {
		updateRtmpEndPoint = putUpdateRtmpEndPoint(rest_GR_Host);
	}

	public void updateRtmpCustomEndPoint(String rest_GR_Host) {

		updateRtmpCustomEndPoint = putUpdateRtmpCustomEndPoint(rest_GR_Host);

	}

	public void startBroadcastServer(String rest_GR_Host) {
		startBroadcastServer = postStartBroadcastServer(rest_GR_Host);

	}

	public void autoStartBroadcastServer(String rest_GR_Host) {
		autoStartBroadcastServer = putAutoStartBroadcastServer(rest_GR_Host);
	}

	public void setSetStream(String rest_GR_Host) {
		setSetStream = putSetStream(rest_GR_Host);
	}

	public void checkStreamState(String rest_GR_Host) {
		checkStreamState = getStreamState(rest_GR_Host);
	}

	public void writeBroadcastError(String rest_GR_Host) {
		writeBroadcastError = postBroadcastError(rest_GR_Host);
	}

	public void fetchBroadcastError(String rest_GR_Host) {
		fetchBroadcastError = getBroadcastError(rest_GR_Host);
	}

	public void resetBroadcastState(String rest_GR_Host) {
		resetBroadcastState = postResetBroadcastState(rest_GR_Host);
	}

	// private methods

	private Response postCreateInternalServer(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/internal/broadcast/"
				+ DetailsPageRest.meetingRoomNumber;

		log.info("createInternalServer Api call  : " + url);

		Response response = restRequest.sendPutJsonRequestWithoutBody(url, headers);
		return response;

	}

	private Response getBroadcastServer(String rest_GR_Host) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/server/" + DetailsPageRest.meetingRoomNumber;

		log.info("getBroadcastServer Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;

	}

	private Response getLegacyRtmpAddress(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/events-legacy/endpoint/127";

		log.info("getLegacyRtmpAddress Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;
	}

	private Response putUpdateRtmpEndPoint(String rest_GR_Host) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject putUpdateRtmpEndPoint = new JsonObject();
		putUpdateRtmpEndPoint.addProperty("useCustomEndpoint", "1");
		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/use-custom-endpoint/"
				+ DetailsPageRest.meetingRoomNumber;

		log.info("putUpdateRtmpEndPoint Api call  : " + url);

		Response response = restRequest.sendPutJsonRequestWithBody(url, putUpdateRtmpEndPoint.toString(), headers);

		return response;
	}

	private Response putUpdateRtmpCustomEndPoint(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/endpoint/"
				+ DetailsPageRest.meetingRoomNumber;

		JsonObject putUpdateRtmpCustomEndPoint = new JsonObject();
		putUpdateRtmpCustomEndPoint.addProperty("name", "test");
		putUpdateRtmpCustomEndPoint.addProperty("rtmpAddress", "rtmps://");
		putUpdateRtmpCustomEndPoint.addProperty("streamKey", "123");

		log.info("putUpdateRtmpCustomEndPoint Api call  : " + url);

		Response response = restRequest.sendPutJsonRequestWithBody(url, putUpdateRtmpCustomEndPoint.toString(),
				headers);

		return response;
	}

	private Response postStartBroadcastServer(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject postStartBroadcastServer = new JsonObject();
		postStartBroadcastServer.addProperty("meeting", DetailsPageRest.meetingRoomNumber);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/success";

		log.info("postStartBroadcastServer Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, postStartBroadcastServer.toString(), headers);
		return response;

	}

	private Response putAutoStartBroadcastServer(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/auto-start/"
				+ DetailsPageRest.meetingRoomNumber;

		log.info("putAutoStartBroadcastServer Api call  : " + url);

		Response response = restRequest.sendPutJsonRequestWithoutBody(url, headers);

		return response;
	}

	private Response putSetStream(String rest_GR_Host) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject putSetStream = new JsonObject();
		putSetStream.addProperty("stream_state", 0);
		putSetStream.addProperty("meeting", DetailsPageRest.meetingRoomNumber);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/stream-state";

		log.info("putSetStream Api call  : " + url);

		Response response = restRequest.sendPutJsonRequestWithBody(url, putSetStream.toString(), headers);

		return response;
	}

	private Response getStreamState(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/stream-state/"
				+ DetailsPageRest.meetingRoomNumber;

		log.info("getStreamState Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;
	}

	private Response postBroadcastError(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject postBroadcastError = new JsonObject();
		postBroadcastError.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		postBroadcastError.addProperty("error", "This is a test error msg!");

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/error";

		log.info("postBroadcastError Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, postBroadcastError.toString(), headers);
		return response;
	}

	private Response getBroadcastError(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/error-logs/"
				+ DetailsPageRest.meetingRoomNumber;

		log.info("getBroadcastError Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		return response;
	}

	private Response postResetBroadcastState(String rest_GR_Host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject postResetBroadcastState = new JsonObject();
		postResetBroadcastState.addProperty("starting_up", internalServerId);

		String url = "https://" + rest_GR_Host + "/v2/greenroom/broadcast/reset-broadcast-state/"
				+ DetailsPageRest.meetingRoomNumber;

		log.info("postResetBroadcastState Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, postResetBroadcastState.toString(), headers);
		return response;
	}

}
