package com.brandlive.qa.automation.events.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EventRegistrationsRest extends RestUtil {
	
	RestAssuredRequest restRequest = new RestAssuredRequest();
	EventsHomePageRest homePageRest = new EventsHomePageRest();
	MetricsChannelRest metricsChannelRest = new MetricsChannelRest();
	
	public static String eventName = null;
	public static int eventId;
	
	public static Map<String, Object> registrationCount;
	public static List<Map<String, Object>> registrationList;
	
	
	// Public methods
	
	public void eventRegistrations(String host, String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		registrationList = getEventRegistrationsByEventId(host, channelName).get("$");
	}
	
	public void eventRegistrationCount(String host, String channelName) {
		eventDetailsforMetricsAPIs(host, channelName);
		registrationCount = getEventRegistrationsCountByEventId(host, channelName).get("$");
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
				eventId = (int) event.get("event");
				break;
			}
		}
	}
	
	private JsonPath getEventRegistrationsCountByEventId(String host, String channelName) {
		String url = null;
		String token = null;
		String[] params = null;
		
		homePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));

		log.debug("Getting Sessions Metrics by Event Uuid for Channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/events/count-event-registrations/count/"+channel_id+"/"+eventId);
		url = "https://" + host + "/v3/admin/events/count-event-registrations/count/"+channel_id+"/"+eventId+"?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}
	
	private JsonPath getEventRegistrationsByEventId(String host, String channelName) {
		String url = null;
		String token = null;
		String[] params = null;
		
		homePageRest.e3Channels(host, channelName);
		String channel_id = String.valueOf(EventsHomePageRest.e3ChannelInfo.get("channel"));

		log.debug("Getting Sessions Metrics by Event Uuid for Channel Id " + channel_id);
		params = generateCloudflareParameters("/v3/admin/events/event-registrations/"+channel_id+"/"+eventId + "/0/8");
		url = "https://" + host + "/v3/admin/events/event-registrations/"+channel_id+"/"+eventId+"/0/8?expiry=" + params[0] + "&mac=" + params[1];
		
		token = LoginLogoutRest.E3_Token;

		log.info("E3 events rest api call: " + url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
		log.debug(response.prettyPrint());
		JsonPath responseStr = response.jsonPath();

		return responseStr;
	}

}
