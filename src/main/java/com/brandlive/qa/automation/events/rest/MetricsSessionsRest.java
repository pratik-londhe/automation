package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MetricsSessionsRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	MetricsEventsRest metricsEventsRest = new MetricsEventsRest();
	
	public static String sessionUuid = null;
	
	public static List<Map<String, Object>> e3SessionDeviceTypesMetrics;
	public static Map<String, Object> e3SessionRegistrationsMetrics;
	public static Map<String, Object> e3SessionEmailsMetrics;
	public static List<Map<String, Object>> e3SessionBrowsersMetrics;
	public static Map<String, Object> e3SessionAverageDurationMetrics;
	public static Map<String, Object> e3SessionViewsMetrics;
	public static Map<String, Object> e3SessionWatchTimeMetrics;
	public static List<Map<String, Object>> e3SessionRegionsMetrics;
	public static List<Map<String, Object>> e3SessionLanguagesMetrics;
	public static List<Map<String, Object>> e3SessionTimelineMetrics;
	public static List<Map<String, Object>> e3SessionCountryMapMetrics;
	public static Map<String, Object> e3SessionRetentionAverageMetrics;
	
	public static String e3SessionExportSummaryMetrics;
	public static String e3SessionExportDocumentsMetrics;
	public static String e3SessionExportQuestionsMetrics;
	
	// Public Methods
	
	public void getDeviceTypesBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionDeviceTypesMetrics = getDeviceTypesBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getRegistrationsBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionRegistrationsMetrics = getRegistrationsBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getEmailsBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionEmailsMetrics = getEmailsBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getBrowsersBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionBrowsersMetrics = getBrowsersBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getAverageDurationBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionAverageDurationMetrics = getAverageDurationBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getViewsBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionViewsMetrics = getViewsBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getWatchTimeBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionWatchTimeMetrics = getWatchTimeBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getRegionsBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionRegionsMetrics = getRegionsBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getLanguagesBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionLanguagesMetrics = getLanguagesBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getTimelineBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionTimelineMetrics = getTimelineBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getCountryMapBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionCountryMapMetrics = getCountryMapBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getRetentionAverageBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionRetentionAverageMetrics = getRetentionAverageBySessionUuidMetrics(host, channelName).get("$");
	}
	
	public void getExportSummaryBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionExportSummaryMetrics = getExportSummaryBySessionUuidMetrics(host, channelName);
	}
	
	public void getExportDocumentsBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionExportDocumentsMetrics = getExportDocumentsBySessionUuidMetrics(host, channelName);
	}
	
	public void getExportQuestionsBySessionUuidforMetrics(String host,String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		e3SessionExportQuestionsMetrics = getExportQuestionsBySessionUuidMetrics(host, channelName);
	}
	
	// Private Methods
	
	private void eventDetailsforMetricsAPIs(String host, String channelName) {
		metricsEventsRest.getSessionsByEventUuidforMetrics(host, channelName);
		List<Map<String, Object>> sessionsMetricByEventUuid = MetricsEventsRest.e3EventSessionsMetrics;
		Map<String, Object> session = sessionsMetricByEventUuid.get(0);
		sessionUuid = (String) session.get("uuid");
	}
	
	private JsonPath getDeviceTypesBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Device Types Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/deviceTypes");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/deviceTypes?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getRegistrationsBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Registrations Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/registrations");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/registrations?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getEmailsBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Emails Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/emails");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/emails?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getBrowsersBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Browsers Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/browsers");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/browsers?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getAverageDurationBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Average Duration Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/averageDuration");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/averageDuration?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getViewsBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Views Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/views");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/views?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getWatchTimeBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Watch Time Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/watchtime");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/watchtime?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getRegionsBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Regions Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/regions");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/regions?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getLanguagesBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Languages Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/languages");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/languages?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getTimelineBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Timeline Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/timeline");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/timeline?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getCountryMapBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Country Map Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/countryMap");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/countryMap?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getRetentionAverageBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Retention Average Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/retention/average");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/retention/average?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private String getExportSummaryBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Summary Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/export/summary");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/export/summary?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}
	
	private String getExportDocumentsBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Documents Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/export/documents");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/export/documents?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}
	
	private String getExportQuestionsBySessionUuidMetrics(String host, String channelId) {
		String url = null;
		String token = null;
		String[] params = null;

		log.debug("Getting Export Questions Metrics by Session Uuid for Channel Id " + channelId);
		params = generateCloudflareParameters("/v3/admin/metrics/sessions/" + sessionUuid + "/export/questions");
		url = "https://" + host + "/v3/admin/metrics/sessions/" + sessionUuid + "/export/questions?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		String responseStr = response.asString();

		return responseStr;
	}
	
}
