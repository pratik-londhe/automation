package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MetricsChannelRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest homePageRest = new EventsHomePageRest();
	
	public static List<Map<String, Object>> e3ChannelEventMetrics;
	public static List<Map<String, Object>> e3ChannelDeviceTypesMetrics;
	public static Map<String, Object> e3ChannelRegistrationsMetrics;
	public static List<Map<String, Object>> e3ChannelBrowsersMetrics;
	public static Map<String, Object> e3ChannelAudienceMetrics;
	public static Map<String, Object> e3ChannelAverageDurationMetrics;
	public static Map<String, Object> e3ChannelViewsMetrics;
	public static Map<String, Object> e3ChannelWatchTimeMetrics;
	public static List<Map<String, Object>> e3ChannelRegionsMetrics;
	public static Map<String, Object> e3ChannelRetentionAverageMetrics;
	public static List<Map<String, Object>> e3ChannelRetentionBucketsMetrics;
	
	// Public Methods
	
	public void getEventsByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelEventMetrics = getEventsByChannelIdMetrics(host, channel_id).get("$");
	}
	
	public void getDeviceTypesByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelDeviceTypesMetrics = getDeviceTypesMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getRegistrationsByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelRegistrationsMetrics = getRegistrationsMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getBrowsersByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelBrowsersMetrics = getBrowsersMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getAudienceByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelAudienceMetrics = getAudienceMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getAverageDurationByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelAverageDurationMetrics = getAverageDurationMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getViewsByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelViewsMetrics = getViewsMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getWatchTimeByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelWatchTimeMetrics = getWatchTimeMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getRegionsByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelRegionsMetrics = getRegionsMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getRetentionAverageByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelRetentionAverageMetrics = getRetentionAverageMetricsByChannelId(host, channel_id).get("$");
	}
	
	public void getRetentionBucketsByChannelIdforMetrics(String host,String channelName) {
		homePageRest.e3Channels(host,channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));
		e3ChannelRetentionBucketsMetrics = getRetentionBucketsMetricsByChannelId(host, channel_id).get("$");
	}
	
	// Private Methods

	private JsonPath getEventsByChannelIdMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Event Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/events");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/events?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getDeviceTypesMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Device Types Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/deviceTypes");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/deviceTypes?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getRegistrationsMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Registrations Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/registrations");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/registrations?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getBrowsersMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Browsers Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/browsers");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/browsers?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getAudienceMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Audience Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/audience");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/audience?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getAverageDurationMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Average Duration Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/averageDuration");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/averageDuration?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getViewsMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Views Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/views");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/views?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getWatchTimeMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Watch Time Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/watchtime");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/watchtime?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getRegionsMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Regions Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/regions");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/regions?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getRetentionAverageMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Retention Average Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/retention/average");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/retention/average?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
	
	private JsonPath getRetentionBucketsMetricsByChannelId(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Retention Buckets Metrics by channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/channels/" + channelId + "/retention/buckets");
		url = "https://" + host + "/v3/admin/metrics/channels/" + channelId + "/retention/buckets?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 channels rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;

	}
}
