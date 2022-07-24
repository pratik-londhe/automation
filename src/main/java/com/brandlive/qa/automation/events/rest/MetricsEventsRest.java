package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MetricsEventsRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	MetricsChannelRest metricsChannelRest = new MetricsChannelRest();
	
	public static String eventName = null;
	public static String eventUuid = null;
	
	public static List<Map<String, Object>> e3EventSessionsMetrics;
	public static List<Map<String, Object>> e3EventDeviceTypesMetrics;
	public static Map<String, Object> e3EventRegistrationsMetrics;
	public static Map<String, Object> e3EventEmailsMetrics;
	public static List<Map<String, Object>> e3EventBrowsersMetrics;
	public static Map<String, Object> e3EventAverageDurationMetrics;
	public static Map<String, Object> e3EventViewsMetrics;
	public static Map<String, Object> e3EventWatchTimeMetrics;
	public static List<Map<String, Object>> e3EventRegionsMetrics;
	public static List<Map<String, Object>> e3EventLanguagesMetrics;
	public static List<Map<String, Object>> e3EventCountryMapMetrics;
	public static Map<String, Object> e3EventRetentionAverageMetrics;
	public static List<Map<String, Object>> e3EventRetentionBucketsMetrics;
	
	public static String e3EventExportSummaryMetrics;
	public static String e3EventExportProductsMetrics;
	public static String e3EventExportDocumentsMetrics;
	public static String e3EventExportQuestionsMetrics;
	public static String e3EventExportSponsorsMetrics;
	public static String e3EventExportVideosMetrics;
	
	// Public Methods
	
	public void getSessionsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventSessionsMetrics = getSessionsByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getDeviceTypesByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventDeviceTypesMetrics = getDeviceTypesByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getRegistrationsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventRegistrationsMetrics = getRegistrationsByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getEmailsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventEmailsMetrics = getEmailsByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getBrowsersByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventBrowsersMetrics = getBrowsersByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getAverageDurationByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventAverageDurationMetrics = getAverageDurationByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getViewsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventViewsMetrics = getViewsByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getWatchTimeByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventWatchTimeMetrics = getWatchTimeByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getRegionsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventRegionsMetrics = getRegionsByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getLanguagesByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventLanguagesMetrics = getLanguagesByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getCountryMapByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventCountryMapMetrics = getCountryMapByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getRentionAverageByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventRetentionAverageMetrics = getRetentionAverageByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getRentionBucketsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventRetentionBucketsMetrics = getRetentionBucketsByEventUuidMetrics(host, channelName).get("$");
	}
	
	public void getExportSummaryByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventExportSummaryMetrics = getExportSummaryByEventUuidMetrics(host, channelName);
	}
	
	public void getExportProductsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventExportProductsMetrics = getExportProductsByEventUuidMetrics(host, channelName);
	}
	
	public void getExportDocumentsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventExportDocumentsMetrics = getExportDocumentsByEventUuidMetrics(host, channelName);
	}
	
	public void getExportQuestionsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventExportQuestionsMetrics = getExportQuestionsByEventUuidMetrics(host, channelName);
	}
	
	public void getExportSponsorsByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventExportSponsorsMetrics = getExportSponsorsByEventUuidMetrics(host, channelName);
	}
	
	public void getExportVideosByEventUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3EventExportVideosMetrics = getExportVideosByEventUuidMetrics(host, channelName);
	}
	
	
	// Private Methods
	
	private void eventDetailsforMetricsAPIs(String host, String channelName) {

		if(host.contains("qa")) {
			eventName = "Automation Apollo Event 884 02/20/2022 02:01:12 AM";
		} else if(host.contains("staging")) {
			eventName = "Automation O2 Event 98 02/18/2022 10:02:00 PM";
		} else if(host.contains("hot")) {
			eventName = "Automation  Event 524 05/06/2022 07:46:22 AM";
		} else if(host.contains("brandlive.com")) {
			eventName = "Automation Event 219 Sun Jun 05 15:49:12 PDT 2022";
		}

		metricsChannelRest.getEventsByChannelIdforMetrics(host, channelName);
		List<Map<String, Object>> eventMetricByChannelId = MetricsChannelRest.e3ChannelEventMetrics;
		log.debug("Number of events: " + eventMetricByChannelId.size());
		for(Map<String, Object> event : eventMetricByChannelId) {
			String name = (String) event.get("name");
			if(name.equals(eventName)) {
				eventUuid = (String) event.get("uuid");
				break;
			}
		}
	}
	
	
	private JsonPath getSessionsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Sessions Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/sessions");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/sessions?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getDeviceTypesByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Device Types Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/deviceTypes");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/deviceTypes?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getRegistrationsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Registrations Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/registrations");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/registrations?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getEmailsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Emails Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/emails");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/emails?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getBrowsersByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Browsers Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/browsers");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/browsers?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getAverageDurationByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Average Duration Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/averageDuration");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/averageDuration?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getViewsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Views Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/views");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/views?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getWatchTimeByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Watch Time Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/watchtime");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/watchtime?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getRegionsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Regions Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/regions");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/regions?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getLanguagesByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Languages Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/languages");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/languages?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getCountryMapByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Country Map Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/countryMap");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/countryMap?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getRetentionAverageByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Retention Average Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/retention/average");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/retention/average?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getRetentionBucketsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Retention Buckets Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/retention/buckets");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/retention/buckets?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private String getExportSummaryByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Summary Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/export/summary");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/export/summary?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}
	
	private String getExportProductsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Products Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/export/products");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/export/products?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}
	
	private String getExportDocumentsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Documents Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/export/documents");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/export/documents?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}
	
	private String getExportQuestionsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Questions Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/export/questions");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/export/questions?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}
	
	private String getExportSponsorsByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Sponsors Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/export/sponsors");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/export/sponsors?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}
	
	private String getExportVideosByEventUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Videos Metrics by Event Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/events/" + eventUuid + "/export/videos");
		url = "https://" + host + "/v3/admin/metrics/events/" + eventUuid + "/export/videos?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}

}
