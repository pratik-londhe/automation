package com.brandlive.qa.automation.greenroom.rest;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoadTeamsRest extends RestUtil {
	RestAssuredRequest restRequest = new RestAssuredRequest();

	public void loadTeams(String host) {
		ArrayList<Object> loadTeam = postLoadTeams(host).get("$");
	}

	private JsonPath postLoadTeams(String host) {
		String token = LoginLogoutRest.E3GR_Token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("bl-token", token);
		JsonPath responseStr = null;

		try {

			Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/json/payload_loadTeams.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode parser = objectMapper.readTree(reader);
			String url = "https://" + host + "/v2/greenroom/home/load-teams";
			log.info("Load Teams api call: " + url);

			Response response = restRequest.sendJsonRequestWithBody(url, parser.toString(), headers);
			log.debug("Response Status Code for Load Team is " + response.getStatusCode());
			responseStr = response.jsonPath();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseStr;

	}
}