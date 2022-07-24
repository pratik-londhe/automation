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

public class SponsorsRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static Response getEventSponsorsByChannelIdRes;
	public static Response putAddExistingSponsorToEventRes;
	
	public static JsonPath getEventSponsorsByChannelIdJsonPath;
	public static JsonPath putAddExistingSponsorToEventJsonPath;
	
	public static List<Map<String, Object>> channelSponsors;
	public static Map<String, Object> addedSponsorMap;
	public static Map<String, Object> selectedSponsor; //Sponsor for the payload
	
	// Public methods
	
	public void getChannelSponsors(String host, String channelName) {
		channelSponsors = getEventSponsorsByChannelId(host, channelName).get("$");
	}
	
	public void getFirstSponsorFromListOfChannelSponsors() {
		
		int channel = getEventSponsorsByChannelIdJsonPath.get("[0].channel");
		int created_by = getEventSponsorsByChannelIdJsonPath.get("[0].created_by");
		String created_at = getEventSponsorsByChannelIdJsonPath.get("[0].created_at");
		int sponsor = getEventSponsorsByChannelIdJsonPath.get("[0].sponsor");
		int module_id = getEventSponsorsByChannelIdJsonPath.get("[0].module_id");
		boolean enable_cta = getEventSponsorsByChannelIdJsonPath.get("[0].enable_cta");
		String name = getEventSponsorsByChannelIdJsonPath.get("[0].name");
		String imageUrl = getEventSponsorsByChannelIdJsonPath.get("[0].image");
		String description_base = getEventSponsorsByChannelIdJsonPath.get("[0].description.base");	
		String description_changed = getEventSponsorsByChannelIdJsonPath.get("[0].description.changed");
		int call_to_action_type = getEventSponsorsByChannelIdJsonPath.get("[0].call_to_action.type");
		String call_to_action_button_name_base = getEventSponsorsByChannelIdJsonPath.get("[0].call_to_action.button_name.base");	
		String call_to_action_button_name_changed = getEventSponsorsByChannelIdJsonPath.get("[0].call_to_action.button_name.changed");
		
		selectedSponsor = new HashMap<String, Object>();
		selectedSponsor.put("channel", new Integer(channel));
		selectedSponsor.put("created_by", new Integer(created_by));
		selectedSponsor.put("sponsor", new Integer(sponsor));
		selectedSponsor.put("module_id", new Integer(module_id));
		selectedSponsor.put("created_at", created_at);
		selectedSponsor.put("enable_cta", new Boolean(enable_cta));
		selectedSponsor.put("imageUrl", imageUrl);
		selectedSponsor.put("name", name);
		selectedSponsor.put("description.base", description_base);
		selectedSponsor.put("description.changed", description_changed);
		selectedSponsor.put("call_to_action.type", call_to_action_type);
		selectedSponsor.put("call_to_action.button_name.base", call_to_action_button_name_base);
		selectedSponsor.put("call_to_action.button_name.changed", call_to_action_button_name_changed);
		
		for(Object obj : selectedSponsor.values()) {
			if(obj instanceof String) log.debug(obj);
			if(obj instanceof Boolean) log.debug(obj);
			if(obj instanceof Integer) log.debug(obj);
		}
	}
	
	public void addExistingSponsorToEvent(String host) {
		addedSponsorMap = putAddExistingSponsorToEvent(host).get("$");
	}
	
	// Private methods
	
	private JsonPath getEventSponsorsByChannelId(String host, String channelName) {
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event sponsors by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/channel/sponsors/" + channel_id);
		url = "https://" + host + "/v3/admin/channel/sponsors/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 get sponsors rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getEventSponsorsByChannelIdRes = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(getEventSponsorsByChannelIdRes.prettyPrint());
		getEventSponsorsByChannelIdJsonPath = getEventSponsorsByChannelIdRes.jsonPath();
		return getEventSponsorsByChannelIdJsonPath;
	}

	
	private JsonPath putAddExistingSponsorToEvent(String host) {
		
		Reader reader;
		ObjectMapper objectMapperForProduct = new ObjectMapper();
		JsonNode productJsonRoot = null;
		JsonNode call_to_action = null;
		JsonNode button_name = null;
		JsonNode description = null;

		try {
			reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_E3_sponsor.json"));
			productJsonRoot = objectMapperForProduct.readTree(reader);
			call_to_action = (ObjectNode) productJsonRoot.path("call_to_action");
			button_name = (ObjectNode) call_to_action.path("button_name");
			description = (ObjectNode) productJsonRoot.path("description");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((ObjectNode) productJsonRoot).put("channel", (int) selectedSponsor.get("channel"));
		((ObjectNode) productJsonRoot).put("created_by", (int) selectedSponsor.get("created_by"));
		((ObjectNode) productJsonRoot).put("created_at", (String) selectedSponsor.get("created_at"));
		((ObjectNode) productJsonRoot).put("sponsor", (int) selectedSponsor.get("sponsor"));
		((ObjectNode) productJsonRoot).put("module_id", (int) selectedSponsor.get("module_id"));
		((ObjectNode) productJsonRoot).put("enable_cta", (boolean) selectedSponsor.get("enable_cta"));
		((ObjectNode) productJsonRoot).put("name", (String) selectedSponsor.get("name"));
		((ObjectNode) productJsonRoot).put("image", (String) selectedSponsor.get("imageUrl"));
		
		((ObjectNode) call_to_action).put("type", (int) selectedSponsor.get("call_to_action.type"));
		((ObjectNode) button_name).put("base", (String) selectedSponsor.get("call_to_action.button_name.base"));
		((ObjectNode) button_name).put("changed", (String) selectedSponsor.get("call_to_action.button_name.changed"));
		
		((ObjectNode) description).put("base", (String) selectedSponsor.get("description.base"));
		((ObjectNode) description).put("changed", (String) selectedSponsor.get("description.changed"));
		
		String payloadJson = "{\"sponsor\":" + productJsonRoot.toString() + ",\"languages\":[\"en\"]}";
		log.debug(payloadJson);
		
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/channel/sponsors/");
		url = "https://" + host + "/v3/admin/channel/sponsors/?expiry=" + params[0] + "&mac="+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 add sponsor to event rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		putAddExistingSponsorToEventRes = restRequest.sendPutJsonRequestWithBody(url, payloadJson, headers);
		log.debug(putAddExistingSponsorToEventRes.prettyPrint());
		putAddExistingSponsorToEventJsonPath = putAddExistingSponsorToEventRes.jsonPath();
		return putAddExistingSponsorToEventJsonPath;
		
	}

}
