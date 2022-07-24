package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class VideosRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static Response getEventVideosByChannelIdRes;
	
	public static JsonPath getEventVideosByChannelIdJsonPath;
	
	public static Map<String, Object> selectedVideo; //Video for the payload	
	public static List<Map<String, Object>> channelVideos;
	public static List<Map<String, Object>> channelVideos2;
	public static List<Map<String, Object>> channelRecordedVideos;
	public static int channelUStreamVideos;
	public static Map<String, Object> insertedVideo;
	public static Map<String, Object> deletedVideo;
	
	// public methods
	
	public void getChannelVideos(String host, String channelName) {
		channelVideos = getEventVideoByChannelId(host, channelName).get("$");
	}
	
	public void getChannelVideos2(String host, String channelName) {
		channelVideos2 = getEventVideoByChannelId2(host, channelName).get("$");
	}
	
	public void getChannelRecordedVideos(String host, String channelName) {
		channelRecordedVideos = getEventRecordedVideoByChannelId(host, channelName).get("$");
	}
	
	public void getChannelUStreamVideos(String host, String channelName) {
		channelUStreamVideos = getEventUStreamVideoByChannelId(host, channelName);
	}
	
	public void getFirstVideoFromListOfChannelVideos() {
		
		int channel = getEventVideosByChannelIdJsonPath.get("[0].channel");
		int created_by = getEventVideosByChannelIdJsonPath.get("[0].created_by");
		String created_at = getEventVideosByChannelIdJsonPath.get("[0].created_at");
		int video = getEventVideosByChannelIdJsonPath.get("[0].video");
		int module_id = getEventVideosByChannelIdJsonPath.get("[0].module_id");
		boolean use_thumbnail = getEventVideosByChannelIdJsonPath.get("[0].use_thumbnail");
		String sourceUrl = getEventVideosByChannelIdJsonPath.get("[0].source");
		String imageUrl = getEventVideosByChannelIdJsonPath.get("[0].image");
		String originalImageUrl = getEventVideosByChannelIdJsonPath.get("[0].original_image");
		String videoName = getEventVideosByChannelIdJsonPath.get("[0].name");
		String convertJobUrl = getEventVideosByChannelIdJsonPath.get("[0].convert_job");
		String hlsLinkUrl = getEventVideosByChannelIdJsonPath.get("[0].hls_link");
		int convertStatus = getEventVideosByChannelIdJsonPath.get("[0].convert_status");
		int duration = getEventVideosByChannelIdJsonPath.get("[0].duration");
		boolean is_fireside = getEventVideosByChannelIdJsonPath.get("[0].is_fireside");
		String videoUuid = getEventVideosByChannelIdJsonPath.get("[0].uuid");
		
		selectedVideo = new HashMap<String, Object>();
		selectedVideo.put("channel", new Integer(channel));
		selectedVideo.put("created_by", new Integer(created_by));
		selectedVideo.put("video", new Integer(video));
		selectedVideo.put("module_id", new Integer(module_id));
		selectedVideo.put("created_at", created_at);
		selectedVideo.put("use_thumbnail", new Boolean(use_thumbnail));
		selectedVideo.put("sourceUrl", sourceUrl);
		selectedVideo.put("imageUrl", imageUrl);
		selectedVideo.put("originalImageUrl", originalImageUrl);
		selectedVideo.put("videoName", videoName);
		selectedVideo.put("convertJobUrl", convertJobUrl);
		selectedVideo.put("hlsLinkUrl", hlsLinkUrl);
		selectedVideo.put("convertStatus", new Integer(convertStatus));
		selectedVideo.put("duration", new Integer(duration));
		selectedVideo.put("is_fireside", new Boolean(is_fireside));
		selectedVideo.put("videoUuid", videoUuid);
		
		for(Object obj : selectedVideo.values()) {
			if(obj instanceof String) log.debug(obj);
			if(obj instanceof Boolean) log.debug(obj);
			if(obj instanceof Integer) log.debug(obj);
		}
	}
	
	public void uploadNewVideoFile(String host, String fileName) {
		insertedVideo = postVideoFileUpload(host, fileName).get("$");
	}
	
	public void deleteUploadedVideo(String host) {
		deletedVideo = deleteUploadedVideoFile(host).get("$");
	}
	
	// private methods
	
	private JsonPath getEventVideoByChannelId(String host, String channelName) {
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Videos Details by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/channel/videos/channel/" + channel_id);
		url = "https://" + host + "/v3/admin/channel/videos/channel/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getEventVideosByChannelIdRes = restRequest.sendJsonRequestWithoutBody(url, headers);
		getEventVideosByChannelIdJsonPath = getEventVideosByChannelIdRes.jsonPath();
		return getEventVideosByChannelIdJsonPath;
	}
	
	private JsonPath getEventVideoByChannelId2(String host, String channelName) {
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Videos Details by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/channel/videos/" + channel_id);
		url = "https://" + host + "/v3/admin/channel/videos/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath resJsonPath = response.jsonPath();
		
		return resJsonPath;
	}
	
	private JsonPath getEventRecordedVideoByChannelId(String host, String channelName) {
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Videos Details by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/channel/videos/recorded/" + channel_id);
		url = "https://" + host + "/v3/admin/channel/videos/recorded/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath resJsonPath = response.jsonPath();
		
		return resJsonPath;
	}
	
	private int getEventUStreamVideoByChannelId(String host, String channelName) {
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Videos Details by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/channel/videos/ustream-id/" + channel_id);
		url = "https://" + host + "/v3/admin/channel/videos/ustream-id/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		//JsonPath resJsonPath = response.jsonPath();
		
		return response.getStatusCode();
	}
	
	private JsonPath postVideoFileUpload(String host, String fileName) {
		String url = null;
		String token = null;
		String[] params = null;
		
		String sourceVideoUrl = UploadRest.uploadFile.get("url") + "/" + UploadRest.uploadFileResFields.get("Key");
		String imageUrl = "https://assets.brandlive.com/" + UploadRest.uploadThumbnailResFields.get("Key");
		
		params = generateCloudflareParameters("/v3/admin/channel/videos/uploaded");
		url = "https://" + host + "/v3/admin/channel/videos/uploaded?expiry=" + params[0] + "&mac=" + params[1];
		
		// creating payload
		JsonObject uploadVideoPayload = new JsonObject();
		uploadVideoPayload.addProperty("type", "uploaded");
		uploadVideoPayload.addProperty("name", fileName);
		uploadVideoPayload.addProperty("use_thumbnail", false);
		uploadVideoPayload.addProperty("duration", 10);
		uploadVideoPayload.addProperty("image", imageUrl);
		uploadVideoPayload.addProperty("original_image", imageUrl);
		uploadVideoPayload.addProperty("source", sourceVideoUrl);
		
		String payloadJson = uploadVideoPayload.toString();
		log.debug(payloadJson);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 upload product to channel file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private JsonPath deleteUploadedVideoFile(String host) {
		String url = null;
		String token = null;
		String[] params = null;
		
		params = generateCloudflareParameters("/v3/admin/channel/products");
		url = "https://" + host + "/v3/admin/channel/products?expiry=" + params[0] + "&mac=" + params[1];
		
		JsonObject payloadJson = new JsonObject();
		JsonArray videoArr = new JsonArray();
		videoArr.add((int) insertedVideo.get("video"));
		payloadJson.add("videoIDs", videoArr);
		
		log.debug(payloadJson.toString());

		token = LoginLogoutRest.E3_Token;

		log.info("E3 delete product from channel rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.deleteJsonRequestWithBody(url, payloadJson.toString(), headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}

}
