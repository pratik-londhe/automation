package com.brandlive.qa.automation.greenroom.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SessionRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	public static Date startDate = new Date();
	public static Date endDate = new Date();
	public static HashMap<String, Object> createSession;

	
	//Public Method
	
	public void sessionTypes(String host) {
		ArrayList<String> sessionTypes = getSessionTypes(host).get("$");
		log.debug("Sesion Types : " + sessionTypes.toString());
	}

	public void sessionDetailbyMeetingId(String host) {
		ArrayList<String> sessionDetails = getSessionDetailsByMeetingId(host).get("$");
		log.debug("Session Details By Meeting Id :  " + sessionDetails.toString());
	}

	public void createSession(String host) {
		createSession = postCreateSession(host).get("$");
		log.debug("Create Session Details :  " + createSession.toString());
	}

	public void updateSession(String host) {
		HashMap<String, Object> updateSession = putUpdateSession(host).get("$");
		log.debug("Update Session Details :  " + updateSession.toString());
	}

	public void deleteSession(String host) {
		postDeleteSession(host);
	}

	public void isProducerforSessionCall(String host) {
		booleanCheckIsProducerForSessionCall(host);
	}

	// Private Method

	private JsonPath getSessionTypes(String host) {
		String url = "https://" + host + "/v2/greenroom/show-sessions/types";
		String token = LoginLogoutRest.E3GR_Token;

		log.info("Get GR Session Types : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private JsonPath getSessionDetailsByMeetingId(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/meetings/" + DetailsPageRest.meetingRoomNumber
				+ "/show-sessions";
		log.info("Get Session Details by Meeting Id : " + url);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private JsonPath postCreateSession(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		endDate.setTime(endDate.getTime() + (30 * 60 * 1000));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

		JsonObject createSession = new JsonObject();
		JsonArray invitation = new JsonArray();

		createSession.addProperty("session_type_id", 3);
		createSession.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		createSession.addProperty("start_time", sdf.format(startDate));
		createSession.addProperty("end_time", sdf.format(endDate));
		createSession.addProperty("id", 0);
		createSession.addProperty("title", createRandomSessionName("Broadcast"));
		createSession.add("invitation", invitation);

		log.debug(createSession.toString());

		String url = "https://" + host + "/v2/greenroom/show-sessions";
		log.info("Create Session Api Call: " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, createSession.toString(), headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private JsonPath putUpdateSession(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

		JsonObject updateSession = new JsonObject();
		JsonArray invitation = new JsonArray();

		updateSession.addProperty("session_type_id", 1);
		updateSession.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		updateSession.addProperty("start_time", sdf.format(startDate));
		updateSession.addProperty("end_time", sdf.format(endDate));
		updateSession.addProperty("id", (int) createSession.get("insertId"));
		updateSession.addProperty("title", createRandomSessionName("Broadcast"));
		updateSession.add("invitation", invitation);

		log.debug(updateSession.toString());

		String url = "https://" + host + "/v2/greenroom/show-sessions";
		log.info("Update Session Api Call: " + url);

		Response response = restRequest.sendPutJsonRequestWithBody(url, updateSession.toString(), headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private void postDeleteSession(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject deleteSession = new JsonObject();
		deleteSession.addProperty("id", (int) createSession.get("insertId"));

		String url = "https://" + host + "/v2/greenroom/show-sessions";
		log.info("Delete Session Api Call: " + url);

		Response response = restRequest.deleteJsonRequestWithBody(url, deleteSession.toString(), headers);
		log.debug("The response code is " + response.getStatusCode());
		log.debug("The response is " + response.asString());

	}

	private void booleanCheckIsProducerForSessionCall(String host) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/events/is-producer-for-session/"
				+ DetailsPageRest.meetingRoomNumber;
		log.info("booleanCheckIsProducerForSessionCall : " + url);

		String response = restRequest.sendJsonRequestWithoutBody(url, headers).getBody().asString();
		log.debug("BooleanCheckIsProducerForSessionCall ? " + response);

	}

}
