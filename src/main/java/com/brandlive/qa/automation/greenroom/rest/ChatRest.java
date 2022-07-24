package com.brandlive.qa.automation.greenroom.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ChatRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	public static String channelName;

	
	// Public Method 
	
	public void createChatMessage(String host) {
		postCreateChatMessage(host);
	}
	
	
	public void directMsgByMeetingId(String host) {
		HashMap<String,Object> directMsgDetails = getDirectMsgByMeetingId(host).get("$");
		log.debug(directMsgDetails.toString());
	}
	

	public void chatRoomMsgByMeetingId(String host) {
		ArrayList<String> chatRoomMsgDetails = getChatRoomMsgByMeetingId(host).get("$");
		log.debug(chatRoomMsgDetails.toString());
	}
	
	



	//Private Method
	
	private void postCreateChatMessage(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonObject createChat = new JsonObject();
		JsonArray mentions = new JsonArray();
		
		
		createChat.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		createChat.addProperty("message", "**Get ready to talk in 5 min**");
		createChat.addProperty("room", 0);
		createChat.add("mentions",mentions);

		String url = "https://" + host + "/v2/greenroom/chat";

		log.info("Create Chat Message : " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, createChat.toString(), headers);
		log.debug("The response code is " + response.getStatusCode());
		log.debug("The response is " + response.asString());
		
	}


	private JsonPath getDirectMsgByMeetingId(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/chat/direct/"+DetailsPageRest.meetingRoomNumber;
		
		log.info("Get Direct Msg By Meeting Id Api Call " + url);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
		
	}


	private JsonPath getChatRoomMsgByMeetingId(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/chat/rooms/"+DetailsPageRest.meetingRoomNumber;
		
		log.info("Get Chat Room Msg By Meeting Id Api Call " + url);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
		
	}
}
