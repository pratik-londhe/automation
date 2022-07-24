package com.brandlive.qa.automation.events.rest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.google.gson.JsonObject;

public class UploadRest extends RestUtil {

	RestAssuredRequest restRequest = new RestAssuredRequest();
	
	public static JsonPath uploadFileRes;
	public static JsonPath uploadThumbnailRes;
	
	public static Map<String, Object> uploadFile;
	public static Map<String, Object> uploadThumbnail;
	
	public static Map<String, String> uploadFileResFields;
	public static Map<String, String> uploadThumbnailResFields;
	
	public static int S3AwsFileUploadStatusCode;
	public static String uploadFileMakePublic;
	
	// Public methods
	public void uploadFile(String host, String filename, String fileNameSpecificStr) {
		if(fileNameSpecificStr == null) {
			if(filename.contains(".pdf")) {
				uploadFile = putUploadVideoDocFile(host, filename).get("$");
				uploadFileResFields = uploadFileRes.get("fields");
				S3AwsFileUploadStatusCode = postAwsUploadCall(filename);
				uploadFileMakePublic = putUploadFileMakePublic(host, null);
			}
			if(filename.contains(".mp4")) {
				uploadFile = putUploadVideoDocFile(host, filename).get("$");
				uploadFileResFields = uploadFileRes.get("fields");
				S3AwsFileUploadStatusCode = postAwsUploadCall(filename);
			}
			if(filename.contains("thumbnail.jpg")) {
				uploadThumbnail = putUploadThumbnailFile(host, filename).get("$");
				uploadThumbnailResFields = uploadThumbnailRes.get("fields");
				S3AwsFileUploadStatusCode = postAwsUploadCall(filename);
				uploadFileMakePublic = putUploadFileMakePublic(host, filename);
			}
		} else {
			uploadFile = putUploadFile(host, fileNameSpecificStr).get("$");
			uploadFileResFields = uploadFileRes.get("fields");
			S3AwsFileUploadStatusCode = postAwsUploadCall(filename);
			uploadFileMakePublic = putUploadFileMakePublic(host, null);
		}
	}	
	
	// Private methods
	private JsonPath putUploadFile(String host, String fileNameSpecificStr) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
		String prefix = channel_id + "/" + createRandomUUID();
		
		params = generateCloudflareParameters("/v3/admin/channel/upload-endpoint");
		url = "https://" + host + "/v3/admin/channel/upload-endpoint?expiry=" + params[0] + "&mac=" + params[1];
		
		String filename = params[0] + fileNameSpecificStr;
		
		// creating payload
		JsonObject uploadFilePayload = new JsonObject();
		uploadFilePayload.addProperty("filename", filename);
		uploadFilePayload.addProperty("prefix", prefix);
		uploadFilePayload.addProperty("isThumb", false);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 upload file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, uploadFilePayload.toString(), headers);
		log.debug(response.prettyPrint());
		uploadFileRes = response.jsonPath();
		
		return uploadFileRes;
	}
	
	private JsonPath putUploadVideoDocFile(String host, String filename) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
	
		params = generateCloudflareParameters("/v3/admin/channel/upload-endpoint");
		url = "https://" + host + "/v3/admin/channel/upload-endpoint?expiry=" + params[0] + "&mac=" + params[1];
		
		// creating payload
		JsonObject uploadFilePayload = new JsonObject();
		uploadFilePayload.addProperty("filename", filename);		
		if(filename.contains(".mp4")) {
			String prefix = "uploads/" + channel_id + "/" + createRandomUUID();
			uploadFilePayload.addProperty("prefix", prefix);
		}
		if(filename.contains(".pdf")) {
			String prefix = "/uploads/" + channel_id + "/documents/" + createRandomUUID();
			uploadFilePayload.addProperty("prefix", prefix);
		}
		uploadFilePayload.addProperty("isThumb", false);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 upload file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, uploadFilePayload.toString(), headers);
		log.debug(response.prettyPrint());
		uploadFileRes = response.jsonPath();
		
		return uploadFileRes;
	}
	
	private JsonPath putUploadThumbnailFile(String host, String filename) {
		
		String url = null;
		String token = null;
		String[] params = null;
		
		int channel_id = (int) EventsHomePageRest.e3ChannelInfo.get("channel");
	
		params = generateCloudflareParameters("/v3/admin/channel/upload-endpoint");
		url = "https://" + host + "/v3/admin/channel/upload-endpoint?expiry=" + params[0] + "&mac=" + params[1];
		
		// creating payload
		JsonObject uploadFilePayload = new JsonObject();
		uploadFilePayload.addProperty("filename", filename);		
		if(filename.contains("thumbnail.jpg")) {
			String prefix = channel_id + "/" + createRandomUUID();
			uploadFilePayload.addProperty("prefix", prefix);
		}
		uploadFilePayload.addProperty("isThumb", false);

		token = LoginLogoutRest.E3_Token;

		log.info("E3 upload file rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, uploadFilePayload.toString(), headers);
		log.debug(response.prettyPrint());
		uploadThumbnailRes = response.jsonPath();
		
		return uploadThumbnailRes;
	}
	
	private int postAwsUploadCall(String filename) {
		
		String url = null;		
		File newVideoFile = null;
		
		if(filename != null) {
			if(filename.contains(".jpg") || filename.contains(".jpeg") || filename.contains(".png")) {
				if(!filename.equalsIgnoreCase("thumbnail.jpg")) {
					newVideoFile= new File("src/test/resources/eventsmedia/images/"+filename);
				}else {
					newVideoFile= new File("thumbnail.jpg");
				}
			}
			if(filename.contains(".mp4")) {
				newVideoFile= new File("src/test/resources/eventsmedia/videos/"+filename);
			}
			if(filename.contains(".pdf")) {
				newVideoFile= new File("src/test/resources/eventsmedia/documents/"+filename);
			}
		}
		
		String mimeType = null;
		
		if(filename.toLowerCase().contains(".jpeg") || filename.toLowerCase().contains(".jpg")) {
			mimeType = "image/jpeg";			
		} else if (filename.toLowerCase().contains(".png")) {
			mimeType = "image/png";
		} else if (filename.toLowerCase().contains(".mp4")) {
			mimeType = "video/mp4";
		} else if (filename.toLowerCase().contains(".pdf")) {
			mimeType = "application/pdf";
		}
		
		url = (String) uploadFile.get("url");
		url = url.concat("/");
		log.info("E3 upload file rest api S3 call: " + url);
		
		Response response = null;
				
		if(filename.equalsIgnoreCase("thumbnail.jpg")) {
			for(String key : uploadThumbnailResFields.keySet()) {
				log.debug("The uploadThumbnailResFields key is " + key + " and value is " + uploadThumbnailResFields.get(key));
			}
			response = restRequest.sendPostMultiPartMedia(uploadThumbnailResFields, url, newVideoFile, mimeType);
		} else {
			for(String key : uploadFileResFields.keySet()) {
				log.debug("The uploadFileResFields key is " + key + " and value is " + uploadFileResFields.get(key));
			}
			response = restRequest.sendPostMultiPartMedia(uploadFileResFields, url, newVideoFile, mimeType);
		}
		log.debug("The response code is " + response.getStatusCode());
		
		return response.getStatusCode();
	}
	
	private String putUploadFileMakePublic(String host, String filename) {
		
		String url = null;
		String token = null;
		String[] params = null;

		params = generateCloudflareParameters("/v3/admin/channel/upload-endpoint/make-public");
		url = "https://" + host + "/v3/admin/channel/upload-endpoint/make-public?expiry=" + params[0] + "&mac=" + params[1];
		
		// creating payload
		JsonObject uploadFileMakePublicPayload = new JsonObject();
		if(filename!=null) {
			uploadFileMakePublicPayload.addProperty("filename", uploadThumbnailResFields.get("Key"));
		} else {
			uploadFileMakePublicPayload.addProperty("filename", uploadFileResFields.get("Key"));
		}

		token = LoginLogoutRest.E3_Token;

		log.info("E3 upload file make public rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		
		Response response = restRequest.sendPutJsonRequestWithBody(url, uploadFileMakePublicPayload.toString(), headers);
		log.debug(response.prettyPrint());
		
		return response.asString();
	}
}
