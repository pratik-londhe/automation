package com.brandlive.qa.automation.greenroom.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.events.rest.EventsHomePageRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class InvitationRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	public static String channelName;

	// Public Method 
	
	public void createInvitation(String host, String channelName) {
		String emailId = "Hardik.gami@brandlive.com";
		ArrayList<String> createInvitation = postCreateInvitation(host, channelName, emailId).get("$");
		log.debug("Create Invitation Details :  " + createInvitation.toString());
	}

	public void createMultipleInvitation(String host) {
		String emailIds = "brandlive.automation1@gmail.com,brandlive.automation2@gmail.com";
		ArrayList<String> createMultipleInvitation = postCreateInvitation(host, channelName, emailIds).get("$");
		log.debug("Multiple Invitation : " + createMultipleInvitation.toString());
	}

	public void createNotificationForInvitation(String host) {
		postCreateInviteNotification(host);
	}

	public void createiOSNotification(String host) {
		postCreateInviiOsteNotification(host);
	}

	public void invitationDetailsByMeetingId(String host) {
		ArrayList<String> invitationDetails = getInvitationDetailsByMeetingId(host).get("$");
		log.debug("Invitation Details By Meeting Id :  " + invitationDetails.toString());
	}

	public void revokeInvitation(String host) {
		postRevokeInvitation(host);
	}

	// Private Methods

	private JsonPath postCreateInvitation(String host, String channel, String emailId) {
		channelName = channel;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject createInvitation = new JsonObject();

		JsonArray emailInvitation = new JsonArray();
		JsonObject emailObject = new JsonObject();

		emailObject.addProperty("email", emailId);
		emailObject.addProperty("watcher_only", false);

		emailInvitation.add(emailObject);

		createInvitation.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		createInvitation.addProperty("channel_name", channel);
		createInvitation.addProperty("title", createRandomSessionName("Invitation"));
		createInvitation.addProperty("channel", (int) EventsHomePageRest.e3ChannelInfo.get("channel"));
		createInvitation.add("invitations", emailInvitation);

		log.debug(createInvitation.toString());

		String url = "https://" + host + "/v2/greenroom/create-invitations";
		log.info("Create Session Api Call: " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, createInvitation.toString(), headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private void postCreateInviteNotification(String host) {
		int channelId = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		getEditDate();
		// CreateEventsRest.java:119

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		try {

			/* Reading json file */

			Reader reader = Files
					.newBufferedReader(Paths.get("src/main/resources/json/payload_create_invitation.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode parser = objectMapper.readTree(reader);

			JsonNode notification = parser.get("notification");
			JsonNode data = notification.get("data");

			/* Updating values from file */

			if (notification.path("meeting").asInt() == 0) {
				((ObjectNode) notification).put("meeting", DetailsPageRest.meetingRoomNumber);
			}

			if (notification.path("channel").asInt() == 0) {
				((ObjectNode) notification).put("channel", channelId);
			}

			if (notification.path("created").asText().equalsIgnoreCase("created")) {
				((ObjectNode) notification).put("created", getEditDate());
			}

			if (data.path("meeting_slug").asText().equalsIgnoreCase("meeting_slug")) {
				((ObjectNode) data).put("meeting_slug", DetailsPageRest.meeting_id);
			}

			if (data.path("meeting_name").asText().equalsIgnoreCase("meeting_name")) {
				((ObjectNode) data).put("meeting_name", DetailsPageRest.meetingRoomDetails.getString("event_name"));
			}

			String url = "https://" + host + "/v2/greenroom/notifications/create";
			log.info("Create Invitation Notification: " + url);
			Response response = restRequest.sendJsonRequestWithBody(url, parser.toString(), headers);

			log.debug("The response code is " + response.getStatusCode());
			log.debug("The response is " + response.asString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void postCreateInviiOsteNotification(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject createInviteNotification = new JsonObject();
		createInviteNotification.addProperty("emails", "brandlive.automation1@gmail.com");
		createInviteNotification.addProperty("profiles", "");
		createInviteNotification.addProperty("message", "You have been invited as a presenter");

		String url = "https://" + host + "/v2/greenroom/ios-notification/create";

		log.info("Create Invite Notification : " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, createInviteNotification.toString(), headers);
		log.debug("The response code is " + response.getStatusCode());
		log.debug("The response is " + response.asString());

	}

	private JsonPath getInvitationDetailsByMeetingId(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/invitations/" + DetailsPageRest.meetingRoomNumber;
		log.info("Get Invitation Details by Meeting Id : " + url);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private void postRevokeInvitation(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject revokeInviteNotification = new JsonObject();
		revokeInviteNotification.addProperty("channel", (int) EventsHomePageRest.e3ChannelInfo.get("channel"));
		revokeInviteNotification.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		revokeInviteNotification.addProperty("email", "brandlive.automation1@gmail.com,brandlive.automation2@gmail.com");

		String url = "https://" + host + "/v2/greenroom/revoke-invitation";
		log.info("Revoke Invitation Api Call: " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, revokeInviteNotification.toString(), headers);
		log.debug("The response code is " + response.getStatusCode());
		log.debug("The response is " + response.asString());

	}

}
