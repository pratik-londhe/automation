package com.brandlive.qa.automation.greenroom.rest;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.events.rest.CreateEventsRest;
import com.brandlive.qa.automation.events.rest.EventsHomePageRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


public class DetailsPageRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();
	CreateEventsRest createEventsRest = new CreateEventsRest();

	public static int meetingRoomNumber;
	public static String meeting_id;
	public static String opentok_session;

	public static List<Map<String, Object>> meetingRoomMediaDetails;

	public static JsonPath shots;
	public static Response postJsonShots;
	public static JsonPath broadcastCheckForMeetingRoom;
	public static JsonPath RTMPRoomDetails;
	public static List<Map<String, Object>> openTokDetails;
	public static JsonPath meetingRoomDetails;

	// public method
	public void updateMeetingRoom(String host){
		meetingRoomNumber = postCreateUpdateMeetingRoom(host).get("meeting");
	}

	public void loadShots(String host){
		shots = postLoadShots(host);
	}

	public void meetingRoom(String host){
		meetingRoomDetails = getMeetingDetailsByMeetingRoomNumber(host);
		meeting_id = meetingRoomDetails.getString("meeting_id");
		opentok_session = meetingRoomDetails.getString("opentok_session");
	}

	public void getMediaDetails(String host) {
		meetingRoomMediaDetails = getMediaDetailsForMeetingRoom(host).get("$");
	}

	public void checkBroadcast(String host) {
		broadcastCheckForMeetingRoom = meetingRoomBroadCast(host);
	}

	public void getRTMPDetails(String host) {
		RTMPRoomDetails = RTMPMeetingRoomDetails(host);
	}

	public void getOpentokDetails(String host) {
		openTokDetails = openTokSessionDetails(host).get("$");
	}

	//private method
	private JsonPath postCreateUpdateMeetingRoom(String host){
		int channel_id = (int) HomePageRest.e3ChannelInfo.get("channel");
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		JsonPath responseStr = null;
		try {
			Date startDate = new Date(createEventsRest.startTime);
			Date endDate = new Date(createEventsRest.endTime);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

			JsonPath getEventCreationData = createEventsRest.eventCreation;
			List<Map<String, String>> session = getEventCreationData.getList("sessions");

			/* Reading json file */

			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_create_update_E3_meeting.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode parser = objectMapper.readTree(reader);

			/* Updating values from file */

			if(parser.path("channel").asInt() == 0) {
				((ObjectNode)parser).put("channel", channel_id);
			}

			if(parser.path("start_time").asText().equalsIgnoreCase("start_time")) {
				((ObjectNode)parser).put("start_time", sdf.format(startDate));
			}

			if(parser.path("end_time").asText().equalsIgnoreCase( "end_time")) {
				((ObjectNode)parser).put("end_time", sdf.format(endDate));
			}
			if(parser.path("events_session_uuid").asText().equalsIgnoreCase("session_uuid")) {
				((ObjectNode)parser).put("events_session_uuid", session.get(0).get("uuid"));
			}

			String url = "https://" + host + "/v2/greenroom/create-or-update-meeting";
			log.info("E3 Create or Update meeting room rest api call: " + url);
			Response response = restRequest.sendJsonRequestWithBody(url, parser.toString(),headers);
			responseStr = response.jsonPath();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return responseStr;
	}

	private JsonPath  postLoadShots(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject meeting = new JsonObject();
		meeting.addProperty("meetingId", meetingRoomNumber);

		String url = "https://" + host + "/v2/greenroom/shots/load";
		log.info("E3 Load Shots rest api call: " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, meeting.toString(),headers);
		postJsonShots = response;
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath getMeetingDetailsByMeetingRoomNumber(String host) {
		String url = "https://" + host + "/v2/greenroom/" +meetingRoomNumber;
		String token = LoginLogoutRest.E3GR_Token;

		log.info("E3 Get Meeting Id by Meeting Room number : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath getMediaDetailsForMeetingRoom(String host) {
		String url = "https://" + host + "/v2/greenroom/media/" +meetingRoomNumber;
		String token = LoginLogoutRest.E3GR_Token;

		log.info("E3 Get Media Room Details For Meeting Room : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath meetingRoomBroadCast(String host) {
		String url = "https://" + host + "/v2/greenroom/broadcast/check/" +meetingRoomNumber;
		String token = LoginLogoutRest.E3GR_Token;

		log.info("E3 Meeting Room Broadcast Check : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath RTMPMeetingRoomDetails(String host) {
		JsonPath getEventCreationData = createEventsRest.eventCreation;
		List<Map<String, String>> session = getEventCreationData.getList("sessions");
		String sessionUuid = session.get(0).get("uuid");

		String url = "https://" + host + "/v2/greenroom/events/rtmp/"+sessionUuid+"/en" ;
		String token = LoginLogoutRest.E3GR_Token;

		log.info("E3 Meeting Room Broadcast Check : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}
	
	
	private JsonPath openTokSessionDetails(String host) {
		String url = "https://" + host + "/v2/greenroom/opentok-sessions/" +meetingRoomNumber;
		String token = LoginLogoutRest.E3GR_Token;

		log.info("OpenTok Session Details  : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}


}
