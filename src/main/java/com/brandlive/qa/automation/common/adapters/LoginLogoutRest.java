package com.brandlive.qa.automation.common.adapters;

import com.brandlive.qa.automation.rest.RestAssuredRequest;
import com.brandlive.qa.automation.utils.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginLogoutRest extends RestUtil {
	
  RestAssuredRequest restRequest = new RestAssuredRequest();
  
  public static String E2_Token = new String();
  public static String E3_Token = new String();
  
  public static String E2GR_Token = new String();
  public static String E3GR_Token = new String();
  public static String SGR_Token  = new String();

  
  private JsonPath E3Login(String host, String text) {
	  	String[] params = generateCloudflareParameters("/v3/admin/auth/sign-in");
	    String url = "https://"+host+"/v3/admin/auth/sign-in?expiry="+params[0]+"&mac="+params[1];
	    log.info("E3 Login rest api call: " + url);
	    Response response = restRequest.sendJsonRequestWithBody(url, text);
	    JsonPath responseStr = response.jsonPath();
	    //log.info("E3 Login response " + responseStr.prettyPrint());
	    return responseStr;
  }
  
  private JsonPath GRLogin(String host, String text) {
	    String url = "https://"+host+"/v2/greenroom/producer/login/";
	    log.info("GR Login rest api call: " + url);
	    Response response = restRequest.sendJsonRequestWithBody(url, text);
	    JsonPath responseStr = response.jsonPath();
	    //log.info("GR Login response " + response.prettyPrint());
	    return responseStr;
  }
   
  private JsonPath E2Login(String host, String text) {
	    String url = "https://"+host+"/v2/sign-in";
	    log.info("E2 Login rest api call: " + url);
	    Response response = restRequest.sendJsonRequestWithBody(url, text);
	    JsonPath responseStr = response.jsonPath();
	    return responseStr;
	}
  
  
  
  public void getE3LoginToken(String host, String text) {
	  E3_Token = E3Login(host, text).get("token");
	  log.debug("E3 Token: "+ E3_Token);
  }
  
  public void getGRE3LoginToken(String host, String text) {
	  E3GR_Token = GRLogin(host, text).get("token");
	  log.debug("E3GR Token: "+ E3GR_Token);
  }
  
  public void getGRE2LoginToken(String host, String text) {
	  E2GR_Token = GRLogin(host, text).get("token");
	  log.debug("E2GR Token: "+ E2GR_Token);
  }

  public void getE2LoginToken(String host, String text) {
	  E2_Token = E2Login(host, text).get("token");
	  log.debug("E2 Login Token" +E2_Token);
  }


  public void getSRELoginToken(String host, String text) {
	  SGR_Token = GRLogin(host, text).get("token");
	  log.debug("SGR_Token Token: "+ SGR_Token);
}


}
