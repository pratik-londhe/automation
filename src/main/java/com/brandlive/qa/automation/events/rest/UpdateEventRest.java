package com.brandlive.qa.automation.events.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.response.Response;

public class UpdateEventRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	CreateEventsRest createEventsRest = new CreateEventsRest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();

	public static String updateEventWithCPAddition;
	public static String updateEventWithCPUpdation;
	public static String updateEventWithSocialSharingAddition;
	public static String updateEventWithSocialSharingDeletion;
	public static String addExistingProductToEvent;
	public static String addExistingSponsorToEvent;
	public static String addExistingSpeakerToEvent;
	public static String addExistingVideoToEvent;

	// public methods
	public void updateEventWithCustomPageAddition(String host) {
		updateEventWithCPAddition = putEventWithCustomPage(host, "add");
	}
	
	public void updateEventWithCustomPageUpdation(String host) {
		updateEventWithCPUpdation = putEventWithCustomPage(host, "update");
	}
	
	public void updateEventWithSocialSharingAddition(String host) {
		updateEventWithSocialSharingAddition = putUpdateEventWithSocialSharingFileUpload(host, "add", null);
	}
	
	public void updateEventWithSocialSharingDeletion(String host, String channelName) {
		updateEventWithSocialSharingDeletion = putUpdateEventWithSocialSharingFileUpload(host, "delete", channelName);
	}
	
	public void addExistingProductToEvent(String host, String channelName) {
		addExistingProductToEvent = putAddExistingEntityToEvent(host, channelName, "product");
	}
	
	public void addExistingSponsorToEvent(String host, String channelName) {
		addExistingSponsorToEvent = putAddExistingEntityToEvent(host, channelName, "sponsor");
	}
	
	public void addExistingSpeakerToEvent(String host, String channelName) {
		addExistingSpeakerToEvent = putAddExistingEntityToEvent(host, channelName, "speaker");
	}
	
	public void addExistingVideoToEvent(String host, String channelName) {
		addExistingVideoToEvent = putAddExistingEntityToEvent(host, channelName, "video");
	}

	// private methods
	private String putEventWithCustomPage(String host, String action) {

		ObjectMapper objectMapperForCustomPageRes = new ObjectMapper();
		JsonNode customPageResRoot = null;
		if(action.equalsIgnoreCase("add")) {
			JsonNode pageName = null;
			try {
				customPageResRoot = objectMapperForCustomPageRes
						.readTree(CustomPagesRest.addCustomPageResponse.prettyPrint());
				pageName = customPageResRoot.path("page_name");
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			((ObjectNode) pageName).put("changed", "true");
			//log.debug("The complete customPageResRoot is: " + customPageResRoot.toString());
		}
		if(action.equalsIgnoreCase("update")) {
			try {
				customPageResRoot = objectMapperForCustomPageRes
						.readTree(CustomPagesRest.updateCustomPageResponse.prettyPrint());
			} catch (IOException e) {
				e.printStackTrace();
			}

			//log.debug("The complete customPageResRoot is: " + customPageResRoot.toString());
		}

		ObjectMapper objectMapperForEventRes = new ObjectMapper();
		JsonNode eventResRoot = null;
		ArrayNode sessions = null;
		ArrayNode custom_pages = null;
		ArrayNode registration_steps = null;
		JsonNode home_page = null;
		ArrayNode modules = null;
		JsonNode playbackUrls = null;
		JsonNode template = null;

		try {
			eventResRoot = objectMapperForEventRes
					.readTree(CreateEventsRest.eventDetailByEventUuidResponse.prettyPrint());
			sessions = (ArrayNode) eventResRoot.path("sessions");
			custom_pages = (ArrayNode) eventResRoot.path("custom_pages");
			registration_steps = (ArrayNode) eventResRoot.path("registration_steps");
			home_page = eventResRoot.path("homepage");
			modules = (ArrayNode) home_page.path("modules");
			playbackUrls = eventResRoot.path("playbackUrls");
			template = eventResRoot.path("template");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (modules.isArray()) {
			for (JsonNode module : modules) {
				ObjectNode modul = (ObjectNode) module;
				JsonNode content = modul.path("content");
				if (content.has("custom_heading")) {
					ArrayNode modulez = objectMapperForEventRes.createArrayNode();
					JsonNode custom_heading = content.path("custom_heading");
					JsonNode base = custom_heading.path("base");
					if (base.asText().contains("Speakers") || base.asText().contains("Sponsors")
							|| base.asText().contains("Products")) {
						modul.remove("modules");
						modul.put("modules", modulez);
					}
				}
			}
		}

		if (registration_steps.isArray()) {
			for (JsonNode node : registration_steps) {
				if (node.has("questions")) {
					ArrayNode questions = (ArrayNode) node.path("questions");
					if (questions.isArray()) {
						for (JsonNode question_node : questions) {
							ObjectNode question = (ObjectNode) question_node;
							if (question_node.has("translation")) {
								question.remove("translation");
							}
						}
					}
				}
			}
		}

		if (custom_pages.isArray()) {
			if(custom_pages.size() > 0) {
				custom_pages.removeAll();
			}
			custom_pages.add(customPageResRoot);
		}

		if (sessions.isArray()) {
			ObjectNode streamingOptionsNode = objectMapperForEventRes.createObjectNode();
			streamingOptionsNode.put("single_stream", false);
			JsonNode session = sessions.get(0);
			((ObjectNode) session).put("replay_on", true);
			if (session.has("streaming_options")) {
				((ObjectNode) session).remove("streaming_options");
				((ObjectNode) session).put("streaming_options", streamingOptionsNode);
			}
		}

		if (playbackUrls.isObject()) {
			((ObjectNode) playbackUrls).removeAll();
		}

		if (template.has("properties")) {
			ObjectNode properties = (ObjectNode) template.path("properties");
			if (properties.has("registrationImage")) {
				properties.remove("registrationImage");
			}
		}

		((ObjectNode) eventResRoot).put("social_settings", getSocialSettingsForEventUpdation());

		//log.debug("The complete eventResRoot is: " + eventResRoot.toString());

		String payloadJson = "{\"event\":" + eventResRoot.toString() + "}";

		//log.debug("The complete payload is: " + payloadJson);

		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/event");
		url = "https://" + host + "/v3/admin/event?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event updation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		Response response = restRequest.sendPutJsonRequestWithBody(url, payloadJson, headers);
		//log.debug(response.prettyPrint());

		return response.asString();
	}

	private JsonNode getSocialSettingsForEventUpdation() {

		Reader reader;
		ObjectMapper objectMapperForSocialSettings = new ObjectMapper();
		JsonNode socialSettingsJsonRoot = null;
		JsonNode profiles = null;
		ArrayNode sections = null;
		ArrayNode eventChatChannels = null;

		try {
			reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_E3_socialSettings.json"));
			socialSettingsJsonRoot = objectMapperForSocialSettings.readTree(reader);
			profiles = socialSettingsJsonRoot.path("profiles");
			sections = (ArrayNode) profiles.path("sections");
			eventChatChannels = (ArrayNode) socialSettingsJsonRoot.path("eventChatChannels");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sections.isArray()) {
			for (JsonNode node : sections) {
				((ObjectNode) node).put("uuid", createRandomUUID());
			}
		}

		if (eventChatChannels.isArray()) {
			for (JsonNode node : eventChatChannels) {
				((ObjectNode) node).put("created_at", Long.toString(Instant.now().toEpochMilli()));
				((ObjectNode) node).put("uuid", createRandomUUID());
			}
		}

		return socialSettingsJsonRoot;
	}
	
	private String putUpdateEventWithSocialSharingFileUpload(String host, String action, String channelName) {
		
		String socialSharing = UploadRest.uploadFile.get("url") + "/" + UploadRest.uploadFileResFields.get("Key");
		
		ObjectMapper objectMapperForEventRes = new ObjectMapper();
		JsonNode eventResRoot = null;
		JsonNode social_sharing = null;
		
		if(channelName!=null) {
			createEventsRest.getEventDetailsbyEventUuid(host, channelName);
		}
		
		try {
			eventResRoot = objectMapperForEventRes
					.readTree(CreateEventsRest.eventDetailByEventUuidResponse.prettyPrint());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(action.equalsIgnoreCase("add")) {
			((ObjectNode) eventResRoot).remove("social_sharing");
			ObjectNode socialShare = objectMapperForEventRes.createObjectNode();
			socialShare.put("image", socialSharing);
			socialShare.put("description", "Good Image");
			((ObjectNode) eventResRoot).put("social_sharing", socialShare);
		} else {
			social_sharing = eventResRoot.path("social_sharing");
			if(((ObjectNode) social_sharing).get("image")!=null) {
				((ObjectNode) social_sharing).put("image", "");
			}
		}
		
		String payloadJson = "{\"event\":" + eventResRoot.toString() + "}";
		//log.debug(payloadJson);
			
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/event");
		url = "https://" + host + "/v3/admin/event?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event updation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		Response response = restRequest.sendPutJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());

		return response.asString();
	}

	private String putAddExistingEntityToEvent(String host, String channelName, String entityType) {
		
		ObjectMapper objectMapperForEventRes = new ObjectMapper();
		JsonNode eventResRoot = null;
		JsonNode home_page = null;
		ArrayNode modules = null;
		
		createEventsRest.getEventDetailsbyEventUuid(host, channelName);
		
		try {
			eventResRoot = objectMapperForEventRes
					.readTree(CreateEventsRest.eventDetailByEventUuidResponse.prettyPrint());
			home_page = eventResRoot.path("homepage");
			modules = (ArrayNode) home_page.path("modules");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ObjectMapper objectMapperEntityRes = new ObjectMapper();
		
		if(entityType.equalsIgnoreCase("product")) {
			JsonNode productResRoot = null;
			
			try {
				productResRoot = objectMapperEntityRes
						.readTree(ProductsRest.putAddExistingProductToEventRes.prettyPrint());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(modules.isArray()) {
				for (JsonNode module : modules) {
					ObjectNode modul = (ObjectNode) module;
					JsonNode content = modul.path("content");
					JsonNode custom_heading = content.path("custom_heading");
					if(custom_heading.path("base").asText().contains("Product")) {
						ArrayNode content_modules = objectMapperForEventRes.createArrayNode();
						content_modules.add((int)ProductsRest.addedProductMap.get("product"));
						modul.put("content_modules", content_modules);
						ArrayNode product_modules = objectMapperForEventRes.createArrayNode();
						product_modules.add(productResRoot);
						modul.put("modules", product_modules);
					}
				}
			}
		} else if (entityType.equalsIgnoreCase("sponsor")) {
			JsonNode sponsorResRoot = null;
			
			try {
				sponsorResRoot = objectMapperEntityRes
						.readTree(SponsorsRest.putAddExistingSponsorToEventRes.prettyPrint());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(modules.isArray()) {
				for (JsonNode module : modules) {
					ObjectNode modul = (ObjectNode) module;
					JsonNode content = modul.path("content");
					JsonNode custom_heading = content.path("custom_heading");
					if(custom_heading.path("base").asText().contains("Sponsor")) {
						ArrayNode content_modules = objectMapperForEventRes.createArrayNode();
						content_modules.add((int)SponsorsRest.addedSponsorMap.get("sponsor"));
						modul.put("content_modules", content_modules);
						ArrayNode sponsor_modules = objectMapperForEventRes.createArrayNode();
						sponsor_modules.add(sponsorResRoot);
						modul.put("modules", sponsor_modules);
					}
				}
			}
		} else if (entityType.equalsIgnoreCase("speaker")) {
			JsonNode speakerResRoot = null;
			
			try {
				speakerResRoot = objectMapperEntityRes
						.readTree(SpeakersRest.addedSpeakerMap.get("speakerJsonRoot"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(modules.isArray()) {
				for (JsonNode module : modules) {
					ObjectNode modul = (ObjectNode) module;
					JsonNode content = modul.path("content");
					JsonNode custom_heading = content.path("custom_heading");
					if(custom_heading.path("base").asText().contains("Speaker")) {
						ArrayNode content_modules = objectMapperForEventRes.createArrayNode();
						content_modules.add((int)SpeakersRest.selectedSpeaker.get("speaker"));
						modul.put("content_modules", content_modules);
						ArrayNode speaker_modules = objectMapperForEventRes.createArrayNode();
						speaker_modules.add(speakerResRoot);
						modul.put("modules", speaker_modules);
					}
				}
			}
		} else if (entityType.equalsIgnoreCase("video")) {
			
			Reader reader;
			JsonNode videoResRoot = null;
			
			try {
				reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_E3_video.json"));
				videoResRoot = objectMapperEntityRes.readTree(reader);

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			((ObjectNode) videoResRoot).put("channel", (int) VideosRest.selectedVideo.get("channel"));
			((ObjectNode) videoResRoot).put("created_by", (int) VideosRest.selectedVideo.get("created_by"));
			((ObjectNode) videoResRoot).put("video", (int) VideosRest.selectedVideo.get("video"));
			((ObjectNode) videoResRoot).put("module_id", (int) VideosRest.selectedVideo.get("module_id"));
			((ObjectNode) videoResRoot).put("created_at", (String) VideosRest.selectedVideo.get("created_at"));
			((ObjectNode) videoResRoot).put("use_thumbnail", (boolean) VideosRest.selectedVideo.get("use_thumbnail"));
			((ObjectNode) videoResRoot).put("videoName", (String) VideosRest.selectedVideo.get("videoName"));
			((ObjectNode) videoResRoot).put("convertStatus", (int) VideosRest.selectedVideo.get("convertStatus"));
			((ObjectNode) videoResRoot).put("duration", (int) VideosRest.selectedVideo.get("duration"));
			((ObjectNode) videoResRoot).put("is_fireside", (boolean) VideosRest.selectedVideo.get("is_fireside"));
			((ObjectNode) videoResRoot).put("sourceUrl", (String) VideosRest.selectedVideo.get("sourceUrl"));
			((ObjectNode) videoResRoot).put("imageUrl", (String) VideosRest.selectedVideo.get("imageUrl"));
			((ObjectNode) videoResRoot).put("originalImageUrl", (String) VideosRest.selectedVideo.get("originalImageUrl"));
			((ObjectNode) videoResRoot).put("convertJobUrl", (String) VideosRest.selectedVideo.get("convertJobUrl"));
			((ObjectNode) videoResRoot).put("hlsLinkUrl", (String) VideosRest.selectedVideo.get("hlsLinkUrl"));
			((ObjectNode) videoResRoot).put("videoUuid", (String) VideosRest.selectedVideo.get("videoUuid"));
			
			if(modules.isArray()) {
				for (JsonNode module : modules) {
					ObjectNode modul = (ObjectNode) module;
					JsonNode content = modul.path("content");
					JsonNode custom_heading = content.path("custom_heading");
					if(custom_heading.path("base").asText().contains("Showreel")) {
						ArrayNode content_modules = objectMapperForEventRes.createArrayNode();
						content_modules.add((int)VideosRest.selectedVideo.get("video"));
						modul.put("content_modules", content_modules);
						ArrayNode video_modules = objectMapperForEventRes.createArrayNode();
						video_modules.add(videoResRoot);
						modul.put("modules", video_modules);
					}
				}
			}
		}
		
		String payloadJson = "{\"event\":" + eventResRoot.toString() + "}";
		log.debug(payloadJson);
		
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/event");
		url = "https://" + host + "/v3/admin/event?expiry=" + params[0] + "&mac=" + params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 event updation rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		Response response = restRequest.sendPutJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());

		return response.asString();
	}
}
