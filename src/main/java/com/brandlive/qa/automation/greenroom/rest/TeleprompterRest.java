package com.brandlive.qa.automation.greenroom.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TeleprompterRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	public static int teleprompterId;
	public static String postCreateTeleprompterResponse;
	public static List<Map<String, Object>> loadShotDetails;
	public static int teleprompterSectionId;

	
	// Public Method 
	

	public void createTeleprompter(String host) {
		teleprompterId = postCreateTeleprompter(host);
		log.debug("Teleprompter Id is : " +teleprompterId);	
	}

	public void updateTeleprompter(String host) throws JsonProcessingException, IOException {
		putUpdateTeleprompterById(host);
		
	}
	
	public void shareTeleprompter(String host) {
		postShareTeleprompterById(host);
		
	}

	public void teleprompterDetails(String host) {
		ArrayList<Object> telepromterDetails = getTeleprompterDetailsById(host).get("$");
		log.debug("Here are the teleprompter details " +telepromterDetails.toString());
	}

	public void searchTeleprompter(String host) {
		ArrayList<String> telemprompterSearchDetails =  postSearchTeleprompter(host).get("$");
		log.debug(telemprompterSearchDetails.toString());
		
	}

	public void createTeleprompterSection(String host) {
		teleprompterSectionId = postAndupdateCreateTeleprompterSection(host,"post").get("id");
		
	}

	public void updateTeleprompterSection(String host) {
		postAndupdateCreateTeleprompterSection(host,"put");		
	}
	


	//Private Method
	
	
	private int postCreateTeleprompter(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/teleprompters";

		JsonObject createTeleprompters = new JsonObject();
		JsonArray section = new JsonArray();
		JsonArray shared_with = new JsonArray();
		
		
		createTeleprompters.addProperty("id", 0);
		createTeleprompters.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		createTeleprompters.addProperty("gr_user", 534);
		createTeleprompters.addProperty("title", "");
		createTeleprompters.add("section", section);
		createTeleprompters.addProperty("create_date","");
		createTeleprompters.add("shared_with", shared_with);

		log.info("Create Teleprompter Api Call " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, createTeleprompters.toString(), headers);
		postCreateTeleprompterResponse = response.prettyPrint();
		log.debug("Here is the response from create teleprompter " +postCreateTeleprompterResponse);
		JsonPath responseStr = response.jsonPath();

		return responseStr.get("id");
		
	}
	

	private void putUpdateTeleprompterById(String host) throws JsonProcessingException, IOException {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
	
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode updateTeleprompter = objectMapper.readTree(postCreateTeleprompterResponse.toString());
		log.debug(updateTeleprompter.toString());
		ArrayNode sections = objectMapper.createArrayNode();

		if (updateTeleprompter.path("title").isTextual()) {
			((ObjectNode) updateTeleprompter).put("title", "Automated Teleprompter Creation");
		}

		((ObjectNode) updateTeleprompter).put("sections", sections);
		
		log.debug("Checking update teleprompter payload" +updateTeleprompter.toString());
		
		String url = "https://" + host + "/v2/greenroom/teleprompters/"+teleprompterId;

		log.info("Put Teleprompter by Id Api call  : " + url);

		Response response = restRequest.sendPutJsonRequestWithBody(url, updateTeleprompter.toString(), headers);
		log.debug("The response code is " + response.getStatusCode());
		log.debug("The response is " + response.asString());

		
	}

	private void postShareTeleprompterById(String host) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		JsonArray shareTeleprompterById = new JsonArray();
		shareTeleprompterById.add(491);

		String url = "https://" + host + "/v2/greenroom/teleprompters/"+teleprompterId+"/share";

		log.info("Share Teleprompter by Id Api call  : " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, shareTeleprompterById.toString(), headers);
		log.debug("The response code is " + response.getStatusCode());
		log.debug("The response is " + response.asString());

	}
		
	private JsonPath getTeleprompterDetailsById(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/teleprompters/"+teleprompterId+"/share";
		log.info("Get Teleprompter Details by Id : " + url);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();
		return responseStr;
		
	}


	
	private JsonPath postSearchTeleprompter(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		String url = "https://" + host + "/v2/greenroom/teleprompters/search";

		JsonObject searchTeleprompters = new JsonObject();
	
		searchTeleprompters.addProperty("meeting", DetailsPageRest.meetingRoomNumber);
		searchTeleprompters.addProperty("gr_user", 534);
		

		log.info("Search Teleprompter Api Call " + url);

		Response response = restRequest.sendJsonRequestWithBody(url, searchTeleprompters.toString(), headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
		
		
	}
	
	private JsonPath postAndupdateCreateTeleprompterSection(String host, String method) {

		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		JsonPath responseStr = null;
		loadShotDetails = DetailsPageRest.shots.get("$");
		log.debug("Shot Id : " +loadShotDetails.get(0).get("shot_id"));
		log.debug("Media Id : " +DetailsPageRest.meetingRoomMediaDetails.get(0).get("id"));
		
		int shotId = (int) loadShotDetails.get(0).get("shot_id");
		int mediaId = (int) DetailsPageRest.meetingRoomMediaDetails.get(0).get("id");

		try {
			
			Date createDate = new Date();
			Date editDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			
			/* Reading json file */

			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_presenter_create_shotNote.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode parser = objectMapper.readTree(reader);
			
			JsonNode sectionData = parser.path("section_data");
			JsonNode shotObject  = sectionData.path("shotObject");
			JsonNode shotData  = shotObject.path("shot_data");
			ArrayNode shotFeeds = (ArrayNode) shotData.get("shotFeeds");
			JsonNode  firstMedia = shotFeeds.get(0);

			
			if(parser.path("teleprompter_id").asInt() == 0) {
				((ObjectNode)parser).put("teleprompter_id", teleprompterId);
			}

		
			if(parser.path("section_type_id").asInt() == 0) {
				((ObjectNode)parser).put("section_type_id",shotId);
			}
			
			if (firstMedia.path("media").asInt() == 0) {
				((ObjectNode) firstMedia).put("media", mediaId);
			}
			
			
			if(shotObject.path("shot_id").asInt() == 0) {
				((ObjectNode)shotObject).put("shot_id", shotId);
			}

			if(shotObject.path("meeting").asInt() == 0) {
				((ObjectNode)shotObject).put("meeting", DetailsPageRest.meetingRoomNumber );
			}

			
			if(shotObject.path("edited").asText().equalsIgnoreCase("edited")) {
				((ObjectNode)shotObject).put("edited", sdf.format(createDate));
			}

			if(shotObject.path("created").asText().equalsIgnoreCase( "created")) {
				((ObjectNode)shotObject).put("created", sdf.format(editDate));
			}
			
			
			if (method.equalsIgnoreCase("post")) {
			
				if(parser.path("content").asText().equalsIgnoreCase("content")) {
					((ObjectNode)parser).put("content",  "{\"blocks\":[{\"key\":\"k4ep\",\"text\":\"This is Automation Shot Note on Shot_1\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}");
				}
			
				log.debug("Here is the payload for post Section " +parser.toString());
				String url = "https://" + host + "/v2/greenroom/teleprompters/"+teleprompterId+"/sections";
				log.info("Post Teleprompter API Call: " + url);
				Response response = restRequest.sendJsonRequestWithBody(url, parser.toString(),headers);
				log.debug(response.getStatusCode());
				responseStr = response.jsonPath();
			}
			else {
				
				if(parser.path("content").asText().equalsIgnoreCase("content")) {
					((ObjectNode)parser).put("content",  "{\"blocks\":[{\"key\":\"k4ep\",\"text\":\"Put Api Call --> This is Automation Shot Note on Shot_1\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}");
				}
								
				((ObjectNode) parser).put("id", teleprompterSectionId);
			
			
				log.debug("Here is the payload for put Section " +parser.toString());
				String url = "https://" + host + "/v2/greenroom/teleprompters/"+teleprompterId+"/sections";
				log.info("Put Teleprompter API Call: " + url);
				Response response = restRequest.sendPutJsonRequestWithBody(url, parser.toString(),headers);
				log.debug("This is the response from put telepromter section" +response.getStatusCode());
				responseStr = response.jsonPath();
			}
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return responseStr;
		
	}
	
	
}
