package com.brandlive.qa.automation.greenroom.rest;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandaloneHomePageRest extends RestUtil {
    RestAssuredRequest restRequest = new RestAssuredRequest();

    public void retriveMeetingForStandAlone(String rest_GR_Host) {
        List<Map<String, Object>> json = getMeetingForStandAlone(rest_GR_Host).get("$");
    }


    private JsonPath getMeetingForStandAlone(String rest_GR_Host) {
        String url = "https://" + rest_GR_Host + "/v2/greenroom/standalone/meeting";
        String token = LoginLogoutRest.E2GR_Token;
        log.info("GR Get All E2 Events : " + url);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("bl-token", token);
        Response response = restRequest.sendJsonRequestWithoutBody(url, headers);
        JsonPath responseStr = response.jsonPath();
        return responseStr;

    }
}
