package com.brandlive.qa.automation.greenroom.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.events.rest.EventsHomePageRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateNotificationRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();
	DetailsPageRest detailsPageRest = new DetailsPageRest();
	


	
	public void createNotification(String host) {
		int statusCode = postCreateNotification(host);
		log.debug("Status code for create notification " +statusCode);
	}
	
	
	private int postCreateNotification(String host) {
		int response = 0;
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);

		int channelId = (int) EventsHomePageRest.e3ChannelInfo.get("channel");

		try {
			Date startDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

			/* Reading json file */

			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_createNotification.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode parser = objectMapper.readTree(reader);
			JsonNode notification = parser.path("notification");
			JsonNode data = notification.path("data");

	
			/* Updating values from file */

			if(notification.path("meeting").asInt() == 0) {
				((ObjectNode)notification).put("meeting", detailsPageRest.meetingRoomNumber);
			}

			if(notification.path("channel").asInt() == 0) {
				((ObjectNode)notification).put("channel", channelId);
			}
			
			if(notification.path("created").asText().equalsIgnoreCase("start_time")) {
				((ObjectNode)notification).put("created", sdf.format(startDate));
			}
			
			if(data.path("meeting_name").asText().equalsIgnoreCase("meeting_name")) {
				((ObjectNode)data).put("meeting_name", detailsPageRest.meetingRoomDetails.getString("title"));
			}
			
			if(data.path("meeting_slug").asText().equalsIgnoreCase("meeting_slug")) {
				((ObjectNode)data).put("meeting_slug", detailsPageRest.meeting_id);
			}

			String url = "https://" + host + "/v2/greenroom/notifications/create";
			log.info("Create Notification : " + url);
			 response = restRequest.sendJsonRequestWithBody(url, parser.toString(),headers).getStatusCode();
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		return response;
		
	}

}