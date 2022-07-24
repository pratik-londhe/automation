package com.brandlive.qa.automation.greenroom.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.events.rest.CreateEventsRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HomePageRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	CreateEventsRest createEventsRest = new CreateEventsRest();
	
	public static String grEventName = CreateEventsRest.eventName;
	
	public static Map<String, Object> e2ChannelInfo  = new HashMap<String, Object>();
	public static Map<String, Object> e3ChannelInfo  = new HashMap<String, Object>();
	public static Map<String, Object> sGRChannelInfo = new HashMap<String, Object>();
	
	public static Map<String, Object> e2EventDetails  = new HashMap<String, Object>();
	public static Map<String, Object> e3EventDetails  = new HashMap<String, Object>();
	public static Map<Integer, String> sGREventDetails = new HashMap<Integer, String>();

	public static int newSGREventId;

	// public method
	@SuppressWarnings("unchecked")
	
	public void grChannels(String host, String version, String channelName) {
		Map<String, Object> json = getGRChannels(host, version).get("$");
		log.debug("GR Channels response " + json);
		List<Map<String, Object>> channels = new ArrayList<Map<String, Object>>();
		if (version.contains("3.0")) {
			channels = (List<Map<String, Object>>) json.get("events_channels");
			log.debug("GR Channels for E3 " + channels);
			for (Map<String, Object> channel : channels) {
				if (channel.get("name").equals(channelName)) {
					e3ChannelInfo = channel;
					break;
				}
			}
		}
		if (version.contains("2.5")) {
			channels = (List<Map<String, Object>>) json.get("events_legacy_channels");
			log.debug("GR Channels for E2 " + channels);
			for (Map<String, Object> channel : channels) {
				if (channel.get("name").equals(channelName)) {
					e2ChannelInfo = channel;
					break;
				}
			}
		}
	}
	
	public void getAllStandaloneChannels(String host , String channelName) {
		Map<String, Object> json = getStandAloneChannels(host, channelName).get("$");
		List<Map<String, Object>> standAlonechannels = (List<Map<String, Object>>) json.get("gr_channels");
		log.debug("SGR Channels " + standAlonechannels);
		for (Map<String, Object> channel : standAlonechannels) {
				sGRChannelInfo = channel;
				break;
			}	
	}

	public void getAllE2Events(String host, String eventName) {
		log.debug("Event Name = " + eventName);
		List<Map<String, Object>> json = getE2Event(host).get("$");
		for (Map<String, Object> e2Name : json) {
			if (e2Name.get("title").equals(eventName)) {
				e2EventDetails = e2Name;
				break;
			}
		}
	}

	public void getAllE3Events(String host, int channelId, String eventName) {
		List<Map<String, Object>> json = getE3Event(host, channelId).get("$");
		for (Map<String, Object> e3Name : json) {
			if (e3Name.get("event_name").equals(eventName)) {
				e3EventDetails = e3Name;
				break;
			}
		}
	}
	
	public void getAllStandaloneEvents(String host, String channelName) {
		List<Map<String, Object>> json = getStandaloneEvents(host).get("$");
		for (Map<String, Object> sgrName : json) {
			if (sgrName.get("channel_name").equals(channelName)) {
				int meeting = (int) sgrName.get("meeting");
				String eventName = (String) sgrName.get("title");
				sGREventDetails.put(meeting, eventName);
				}
			}
		}
	
	public void createNewSgrEvent(String host) {
		newSGREventId = postCreateNewSgrEvent(host).get("meeting");
		log.debug("Newly Created StandAlone Green Room EventId : " +newSGREventId);
	}
	
	//private method

	private JsonPath getGRChannels(String host, String version) {
		String url = null;
		String token = null;
		if (version.contains("3.0")) {
			url = "https://" + host + "/v2/greenroom/profile/events";
			token = LoginLogoutRest.E3GR_Token;
		}
		if (version.contains("2.5")) {
			url = "https://" + host + "/v2/greenroom/profile/eventsLegacy";
			token = LoginLogoutRest.E2GR_Token;
		}
		log.info("GR Login rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		// log.info("E3 Channels response " + responseStr.prettyPrint());
		return responseStr;
	}

	private JsonPath getE2Event(String host) {
		String url = "https://" + host + "/v2/greenroom/meetings-events-legacy-producer";
		String token = LoginLogoutRest.E2GR_Token;

		log.info("GR Get All E2 Events : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private JsonPath getE3Event(String host, int channelId) {
		String url = "https://" + host + "/v2/greenroom/events/broadcast-sessions/" + channelId;
		String token = LoginLogoutRest.E3GR_Token;

		log.info("GR Get All E3 Events : " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;

	}

	private JsonPath getStandAloneChannels(String host, String channelName) {
		String url = "https://" + host + "/v2/greenroom/profile/greenroom";
		String token = LoginLogoutRest.SGR_Token;
		log.info("SGR Get all channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}
	
	private JsonPath getStandaloneEvents(String host) {
		String url = "https://" + host + "/v2/greenroom/standalone/meetings";
		String token = LoginLogoutRest.SGR_Token;
		log.info("SGR Get all events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
	}

	private JsonPath postCreateNewSgrEvent(String host) {
		int channel = (int) sGRChannelInfo.get("channel");
		long startTime = Instant.now().plus(10, ChronoUnit.MINUTES).toEpochMilli();
		long endTime = Instant.now().plus(25, ChronoUnit.MINUTES).toEpochMilli();
		String standAloneEventName = createRandomEventName();
		
		String token = LoginLogoutRest.SGR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		JsonPath responseStr = null;
		
		try {
			
			/* Reading json file */
		    
			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_saveNewStandaloneEvent.json"));
		    ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode parser = objectMapper.readTree(reader);
		    
		    /* Updating values from file */

		    if(parser.path("channel").asInt() == 0) {
		    	((ObjectNode)parser).put("channel", channel);
		    }
		    
		    if(parser.path("start_time").asLong() == 0) {
		    	((ObjectNode)parser).put("start_time", startTime);
		    }
		    
		    if(parser.path("end_time").asLong() == 0) {
		    	((ObjectNode)parser).put("end_time", endTime);
		    }
		    
		    if(parser.path("standalone_title").asText().equalsIgnoreCase("eventName")) {
		    	((ObjectNode)parser).put("standalone_title", standAloneEventName);
		    }
		    
		    String url = "https://" + host + "/v2/greenroom/create-or-update-meeting";
			log.info("SGR Post Create new SGR events rest api call: " + url);
			Response response = restRequest.sendJsonRequestWithBody(url, parser.toString(),headers);
			responseStr = response.jsonPath();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return responseStr;
	}

}
