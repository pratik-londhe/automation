package com.brandlive.qa.automation.greenroom.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class NotesRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	public static int noteId;

	// Public Method

	public void createNote(String host) {
		noteId = postCreateNote(host);
	}

	public void saveAndshareNote(String host) {
		HashMap<String, Object> saveAndshareNotes = postsaveAndshareNote(host).get("$");
		log.debug(saveAndshareNotes.toString());

	}

	public void allNotes(String host) {
		ArrayList<String> noteDetails = getAllNotes(host).get("$");
		log.debug(noteDetails.toString());

	}

	// This put will add Note to Room
	public void updateNote(String host) {
		putUpdateNote(host);

	}

	// Private Method

	private int postCreateNote(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/notes/create";

		JsonObject createNote = new JsonObject();
		createNote.addProperty("meeting", DetailsPageRest.meetingRoomNumber);

		log.info("Create Note Api Call " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, createNote.toString(), headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr.get("id");

	}

	private JsonPath postsaveAndshareNote(String host) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/notes/save";

		JsonObject saveNote = new JsonObject();
		saveNote.addProperty("id", noteId);
		saveNote.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		saveNote.addProperty("title", "Automated Note Creation");
		saveNote.addProperty("content",
				" {\"blocks\":[{\"key\":\"275gm\",\"text\":\"Hello Brandlive\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}");
		saveNote.addProperty("content_text", "Hello Brandlive");
		saveNote.addProperty("shared_with", "491");

		log.info("Save Note Api Call " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, saveNote.toString(), headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}

	private JsonPath getAllNotes(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/notes/all";

		log.info("Get all Notes Api call " + url);

		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private void putUpdateNote(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/notes/" + noteId + "/" + DetailsPageRest.meetingRoomNumber;

		log.info("Update Notes Api call " + url);

		Response response = restRequest.sendPutJsonRequestWithoutBody(url, headers);
		log.debug("The response code is " + response.getStatusCode());
		log.debug("The response is " + response.asString());
	}

}
