package com.brandlive.qa.automation.stepdefs;

import com.brandlive.qa.automation.common.adapters.LoginLogoutRest;

import cucumber.api.java.en.Given;

public class LoginLogoutRestStepDefs extends StepDefs {
	
	LoginLogoutRest loginRestAdapter = new LoginLogoutRest();
	
	// Token Details for 2.5 and 3.0 Event Creation Page 
	public String E2_Token = new String();
	public String E3_Token = new String();
	
	// Token Details for Apps inside GR. 
	public String E2_GR_Token = new String();
	public String E3_GR_Token = new String();
	public String SGR_Token = new String ();

	@Given("^Logged in to Events \"(.*?)\"$")
	public void Logged_in_to_Events_REST(String version) {
		
		String data = new String();
		if(version.contains("3.0") && E3_Token.isEmpty()) {
			data = "{ \"email\":\""+event_User()+"\", \"password\":\""+event_Password()+"\", \"two_factor_stored\": \"\"}";
			loginRestAdapter.getE3LoginToken(rest_Event_Host(), data);
			E3_Token = loginRestAdapter.E3_Token;
		}
		
		if(version.contains("2.5") && E2_Token.isEmpty()) {
			data = "{\"email\":\""+event_User()+"\",\"password\":\""+event_Password()+"\",\"from_admin_console\":true,\"two_factor_stored\":null}";
			loginRestAdapter.getE2LoginToken(rest_Event_Host(), data);
			E2_Token = loginRestAdapter.E2_Token;
			log.debug(E2_Token);
	 }
	}
	
	@Given("^Logged in to Greenroom using Events \"(.*?)\"$")
	public void Logged_in_to_Greenroom_using_Events_REST(String version) {
		
		String data = new String();
		
		if(version.contains("3.0") && gr_Event_Entry_Mode().contains("3.0") && E3_GR_Token.isEmpty()) {
			data = "{ \"email\":\""+gr_User()+"\", \"password\":\""+gr_Password()+"\", \"storedTwoFactorEvents\": \"\", \"app\":\"events\"}";
			loginRestAdapter.getGRE3LoginToken(rest_GR_Host(), data);
			E3_GR_Token = loginRestAdapter.E3GR_Token;
		}
		
		if(version.contains("2.5") && gr_Event_Entry_Mode().contains("2.5") && E2_GR_Token.isEmpty()) {
			data = "{ \"email\":\""+gr_User()+"\", \"password\":\""+gr_Password()+"\", \"storedTwoFactorEvents\": \"\", \"app\":\"eventsLegacy\"}";
			loginRestAdapter.getGRE2LoginToken(rest_GR_Host(), data);
			E2_GR_Token = loginRestAdapter.E2GR_Token;
		}
		
	}
	
	@Given("^Logged in to Greenroom in Standalone mode$")
	public void Logged_in_to_Greenroom_Standalone_mode() {
		String data = new String();
			data = "{ \"email\":\""+gr_User()+"\", \"password\":\""+gr_Password()+"\", \"storedTwoFactorEvents\": \"\", \"app\":\"greenroom\"}";
			loginRestAdapter.getSRELoginToken(rest_GR_Host(), data);
			SGR_Token = loginRestAdapter.SGR_Token;
		}

}
