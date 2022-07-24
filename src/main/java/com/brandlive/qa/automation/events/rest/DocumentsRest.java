package com.brandlive.qa.automation.events.rest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DocumentsRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest eventHomePageRest = new EventsHomePageRest();
	
	public static Response getEventDocumentsByChannelIdRes;
	
	public static JsonPath getEventDocumentsByChannelIdJsonPath;
	
	public static List<Map<String, Object>> channelDocuments;
	public static Map<String, Object> selectedDocument; //Document for the payload
	public static Map<String, Object> uploadedDocument;
	public static String convertedDocument;
	public static Map<String, Object> deletedDocument;
	
	// public methods
	
	public void getChannelDocuments(String host, String channelName) {
		channelDocuments = getChannelDocumentsByChannelId(host, channelName).get("$");
	}
	
	public void getFirstDocumentFromListOfChannelDocuments() {
		
		int channel = getEventDocumentsByChannelIdJsonPath.get("[0].channel");
		int created_by = getEventDocumentsByChannelIdJsonPath.get("[0].created_by");
		String created_at = getEventDocumentsByChannelIdJsonPath.get("[0].created_at");
		int document = getEventDocumentsByChannelIdJsonPath.get("[0].document");
		int module_id = getEventDocumentsByChannelIdJsonPath.get("[0].module_id");
		String original_name = getEventDocumentsByChannelIdJsonPath.get("[0].original_name");
		String location = getEventDocumentsByChannelIdJsonPath.get("[0].location");
		String thumbnail = getEventDocumentsByChannelIdJsonPath.get("[0].thumbnail");
		String cloud_convert_id = getEventDocumentsByChannelIdJsonPath.get("[0].cloud_convert_id");
		String displayNameBase = getEventDocumentsByChannelIdJsonPath.get("[0].display_name.base");
		int thumbnail_status = getEventDocumentsByChannelIdJsonPath.get("[0].thumbnail_status");
		int filesize = getEventDocumentsByChannelIdJsonPath.get("[0].filesize");
		
		selectedDocument = new HashMap<String, Object>();
		selectedDocument.put("channel", new Integer(channel));
		selectedDocument.put("created_by", new Integer(created_by));
		selectedDocument.put("document", new Integer(document));
		selectedDocument.put("module_id", new Integer(module_id));
		selectedDocument.put("created_at", created_at);
		selectedDocument.put("location", location);
		selectedDocument.put("thumbnail", thumbnail);
		selectedDocument.put("cloud_convert_id", cloud_convert_id);
		selectedDocument.put("original_name", original_name);
		selectedDocument.put("displayNameBase", displayNameBase);
		selectedDocument.put("thumbnail_status", new Integer(thumbnail_status));
		selectedDocument.put("filesize", new Integer(filesize));
		
		for(Object obj : selectedDocument.values()) {
			if(obj instanceof String) log.debug(obj);
			if(obj instanceof Boolean) log.debug(obj);
			if(obj instanceof Integer) log.debug(obj);
		}
	}
	
	public void uploadNewDocumentFile(String host, String filename) {
		uploadedDocument = postDocumentFileUpload(host, filename).get("$");
		convertedDocument = postConvertUploadedDocumentFile(host, filename);
	}
	
	public void deleteUploadedDocument(String host, String channelName) {
		deletedDocument = deleteUploadedDocumentFile(host, channelName).get("$");
	}
	
	// private methods
	
	private JsonPath getChannelDocumentsByChannelId(String host, String channelName) {
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Videos Details by channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/channel/documents/" + channel_id);
		url = "https://" + host + "/v3/admin/channel/documents/" + channel_id + "?expiry=" + params[0] + "&mac="
				+ params[1];

		token = LoginLogoutRest.E3_Token;

		log.info("E3 rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		getEventDocumentsByChannelIdRes = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(getEventDocumentsByChannelIdRes.prettyPrint());
		getEventDocumentsByChannelIdJsonPath = getEventDocumentsByChannelIdRes.jsonPath();
		
		return getEventDocumentsByChannelIdJsonPath;

	}
	
	@SuppressWarnings("static-access")
	private JsonPath postDocumentFileUpload(String host, String fileName) {
		String url = null;
		String token = null;
		String[] params = null;
		
		String locationUrl = UploadRest.uploadFile.get("url") + "/" + UploadRest.uploadFileResFields.get("Key");
		File file = null;
		if(fileName!=null) {
			file = new File("src/test/resources/eventsmedia/documents/"+fileName);
		}
		
		params = generateCloudflareParameters("/v3/admin/channel/documents");
		url = "https://" + host + "/v3/admin/channel/documents?expiry=" + params[0] + "&mac=" + params[1];
		
		// creating payload
		JsonObject document = new JsonObject();
		document.addProperty("location", locationUrl);
		document.addProperty("original_name", fileName);
		document.addProperty("thumbnail", new String());
		document.addProperty("thumbnail_status", 1);
		document.addProperty("filesize", new FileUtils().sizeOf(file));
		JsonObject displayName = new JsonObject();
		displayName.addProperty("base", fileName);
		displayName.addProperty("changed", "true");
		document.add("display_name", displayName);
		JsonObject documentPayload = new JsonObject();
		documentPayload.add("document", document);
		
		String payloadJson = documentPayload.toString();
		log.debug(payloadJson);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 upload document to channel file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();
		
		return responseStr;
	}
	
	private String postConvertUploadedDocumentFile(String host, String fileName) {
		String url = null;
		String token = null;
		String[] params = null;
		
		String prefix = UploadRest.uploadFileResFields.get("Key");
		prefix = prefix.substring(prefix.indexOf("/")+1);
		String ext = fileName.substring(fileName.indexOf(".")+1);
		//String ext = fileExt[1];
				
		params = generateCloudflareParameters("/v3/admin/channel/documents/convert");
		url = "https://" + host + "/v3/admin/channel/documents/convert?expiry=" + params[0] + "&mac=" + params[1];
		int documentId = (int) uploadedDocument.get("document");
		
		// creating payload
		JsonObject document = new JsonObject();
		document.addProperty("document", documentId);
		document.addProperty("ext", ext);
		document.addProperty("prefix", prefix);
		document.addProperty("filename", fileName);
		
		String payloadJson = document.toString();
		log.debug(payloadJson);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 convert document to channel file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendJsonRequestWithBody(url, payloadJson, headers);
		log.debug(response.prettyPrint());
		
		return response.asString();
	}
	
	private JsonPath deleteUploadedDocumentFile(String host, String channelName) {
		String url = null;
		String token = null;
		String[] params = null;
		
		eventHomePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		
		params = generateCloudflareParameters("/v3/admin/channel/documents");
		url = "https://" + host + "/v3/admin/channel/documents?expiry=" + params[0] + "&mac=" + params[1];
		
		JsonObject payloadJson = new JsonObject();
		JsonArray documentArr = new JsonArray();
		documentArr.add((int) uploadedDocument.get("document"));
		payloadJson.add("documentIDs", documentArr);
		payloadJson.addProperty("channel", channel_id);
		
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
