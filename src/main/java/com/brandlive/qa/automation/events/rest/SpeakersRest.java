package com.brandlive.qa.automation.events.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SpeakersRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static Response getEventSpeakersByChannelIdRes;
	
	public static JsonPath getEventSpeakersByChannelIdJsonPath;
	
	public static List<Map<String, Object>> channelSpeakers;
	public static Map<String, String> addedSpeakerMap;
	public static Map<String, Object> selectedSpeaker; //Speaker for the payload
	
	// Public methods
	
	public void getChannelSpeakers(String host, String channelName) {
		channelSpeakers = getEventSpeakersByChannelId(host, channelName).get("$");
	}
	
	public void getFirstSpeakerFromListOfChannelSpeakers() {
		
		int channel = getEventSpeakersByChannelIdJsonPath.get("[0].channel");
		int created_by = getEventSpeakersByChannelIdJsonPath.get("[0].created_by");
		String created_at = getEventSpeakersByChannelIdJsonPath.get("[0].created_at");
		int speaker = getEventSpeakersByChannelIdJsonPath.get("[0].speaker");
		int module_id = getEventSpeakersByChannelIdJsonPath.get("[0].module_id");
		boolean link_social = getEventSpeakersByChannelIdJsonPath.get("[0].link_social");
		String imageUrl = getEventSpeakersByChannelIdJsonPath.get("[0].image");
		String original_imageUrl = getEventSpeakersByChannelIdJsonPath.get("[0].original_image");
		String job_title_en = getEventSpeakersByChannelIdJsonPath.get("[0].job_title.en");
		String job_title_base = getEventSpeakersByChannelIdJsonPath.get("[0].job_title.base");	
		String job_title_changed = getEventSpeakersByChannelIdJsonPath.get("[0].job_title.changed");
		String description_en = getEventSpeakersByChannelIdJsonPath.get("[0].description.en");
		String description_base = getEventSpeakersByChannelIdJsonPath.get("[0].description.base");	
		String description_changed = getEventSpeakersByChannelIdJsonPath.get("[0].description.changed");
		String first_name = getEventSpeakersByChannelIdJsonPath.get("[0].first_name");
		String last_name = getEventSpeakersByChannelIdJsonPath.get("[0].last_name");
		
		selectedSpeaker = new HashMap<String, Object>();
		selectedSpeaker.put("channel", new Integer(channel));
		selectedSpeaker.put("created_by", new Integer(created_by));
		selectedSpeaker.put("speaker", new Integer(speaker));
		selectedSpeaker.put("module_id", new Integer(module_id));
		selectedSpeaker.put("created_at", created_at);
		selectedSpeaker.put("link_social", new Boolean(link_social));
		selectedSpeaker.put("imageUrl", imageUrl);
		selectedSpeaker.put("original_imageUrl", original_imageUrl);
		selectedSpeaker.put("job_title.en", job_title_en);
		selectedSpeaker.put("job_title.base", job_title_base);
		selectedSpeaker.put("job_title.changed", job_title_changed);
		selectedSpeaker.put("description.en", description_en);
		selectedSpeaker.put("description.base", description_base);
		selectedSpeaker.put("description.changed", description_changed);
		selectedSpeaker.put("first_name", first_name);
		selectedSpeaker.put("last_name", last_name);
		
		for(Object obj : selectedSpeaker.values()) {
			if(obj instanceof String) log.debug(obj);
			if(obj instanceof Boolean) log.debug(obj);
			if(obj instanceof Integer) log.debug(obj);
		}
	}
	
	public void addExistingSpeakerToEvent(String host) {
		addedSpeakerMap = putAddExistingSpeakerToEvent(host);
	}
	
	// Private methods
	
	private JsonPath getEventSpeakersByChannelId(String host, String channelName) {
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Speakers by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/events/speakers/" + channel_id);
		url = "https://" + host + "/v3/admin/events/speakers/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 get speakers rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getEventSpeakersByChannelIdRes = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(getEventSpeakersByChannelIdRes.prettyPrint());
		getEventSpeakersByChannelIdJsonPath = getEventSpeakersByChannelIdRes.jsonPath();
		return getEventSpeakersByChannelIdJsonPath;
	}
	
	private Map<String, String> putAddExistingSpeakerToEvent(String host) {
		
		Map<String, String> methodReturn = new HashMap<>();
		
		Reader reader;
		ObjectMapper objectMapperForProduct = new ObjectMapper();
		JsonNode speakerJsonRoot = null;
		JsonNode job_title = null;
		JsonNode description = null;

		try {
			reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_E3_speaker.json"));
			speakerJsonRoot = objectMapperForProduct.readTree(reader);
			job_title = (ObjectNode) speakerJsonRoot.path("job_title");
			description = (ObjectNode) speakerJsonRoot.path("description");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((ObjectNode) speakerJsonRoot).put("channel", (int) selectedSpeaker.get("channel"));
		((ObjectNode) speakerJsonRoot).put("created_by", (int) selectedSpeaker.get("created_by"));
		((ObjectNode) speakerJsonRoot).put("created_at", (String) selectedSpeaker.get("created_at"));
		((ObjectNode) speakerJsonRoot).put("speaker", (int) selectedSpeaker.get("speaker"));
		((ObjectNode) speakerJsonRoot).put("module_id", (int) selectedSpeaker.get("module_id"));
		((ObjectNode) speakerJsonRoot).put("link_social", (boolean) selectedSpeaker.get("link_social"));
		((ObjectNode) speakerJsonRoot).put("image", (String) selectedSpeaker.get("imageUrl"));
		((ObjectNode) speakerJsonRoot).put("original_image", (String) selectedSpeaker.get("original_imageUrl"));
		((ObjectNode) speakerJsonRoot).put("first_name", (String) selectedSpeaker.get("first_name"));
		((ObjectNode) speakerJsonRoot).put("last_name", (String) selectedSpeaker.get("last_name"));
		
		((ObjectNode) job_title).put("en", (String) selectedSpeaker.get("product_title.en"));
		((ObjectNode) job_title).put("base", (String) selectedSpeaker.get("product_title.base"));
		((ObjectNode) job_title).put("changed", (String) selectedSpeaker.get("product_title.changed"));
		
		((ObjectNode) description).put("en", (String) selectedSpeaker.get("description.en"));
		((ObjectNode) description).put("base", (String) selectedSpeaker.get("description.base"));
		((ObjectNode) description).put("changed", (String) selectedSpeaker.get("description.changed"));
		
		methodReturn.put("speakerJsonRoot", speakerJsonRoot.toString());
		
		String payloadJson = "{\"speaker\":" + speakerJsonRoot.toString() + ",\"languages\":[\"en\"]}";
		log.debug(payloadJson);
		
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/events/speakers/");
		url = "https://" + host + "/v3/admin/events/speakers/?expiry=" + params[0] + "&mac="+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 add speaker to event rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());
		methodReturn.put("return", response.asString());

		return methodReturn;
		
	}

}
