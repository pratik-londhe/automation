package com.brandlive.qa.automation.greenroom.rest;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;
import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SGRRetrieveMeetingsRest extends RestUtil {
    RestAssuredRequest restRequest = new RestAssuredRequest();

    public void getStandAloneMeetings(String host) {
        ArrayList<Object> sgrMeetingDetails = getSGRMeeting(host).get("$");
        log.debug(sgrMeetingDetails.toString());

    }

    public void getStandAloneMeetingsByMeetingId(String host) {
        ArrayList<Object> sgrMeetingDetailsbyMeetingId = getSGRMeetingByMeetingId(host).get("$");
        log.debug(sgrMeetingDetailsbyMeetingId.toString());
    }

    public void getStandAloneMeetingsByChannelId(String host) {
        ArrayList<Object> sgrMeetingDetailsbyChannelId = getSGRMeetingByChannelId(host).get("$");
        log.debug(sgrMeetingDetailsbyChannelId.toString());
    }


    // Get SGR Meetings
    private JsonPath getSGRMeeting(String host) {
        Response response;
        String token = LoginLogoutRest.SGR_Token;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("bl-token", token);
        String url = "https://" + host + "/v2/greenroom/standalone/meetings";
        log.info("SGR Retrieve Meeting Api call: " + url);
        response = restRequest.sendJsonRequestWithoutBody(url, headers);
        JsonPath responseStr = response.jsonPath();
        return responseStr;

    }

    //Get SGR Meetings by MeetingId
    private JsonPath getSGRMeetingByMeetingId(String host) {
        Response response;
        String token = LoginLogoutRest.SGR_Token;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("bl-token", token);
        String url = "https://" + host + "/v2/greenroom/standalone/meetings/"+HomePageRest.newSGREventId;
        log.info("SGR Retrieve Meeting by Meeting Id call: " + url);
        response = restRequest.sendJsonRequestWithoutBody(url, headers);
        JsonPath responseStr = response.jsonPath();
        return responseStr;
    }

    // Get SGR Meetings by Channel Id
    private JsonPath getSGRMeetingByChannelId(String host) {
        Response response;
        String token = LoginLogoutRest.SGR_Token;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("bl-token", token);

        String url = "https://" + host + "/v2/greenroom/standalone/meetings/"+HomePageRest.sGRChannelInfo.get("channel");
        log.info("SGR Retrieve Meeting by Channel Id call: " + url);
        response = restRequest.sendJsonRequestWithoutBody(url, headers);
        JsonPath responseStr = response.jsonPath();
        return responseStr;
    }

}
