package com.brandlive.qa.automation.stepdefs;

import com.brandlive.qa.automation.common.adapters.LoginLogoutAdapter;

import com.brandlive.qa.automation.events2.adapters.E2StreamViewerAdapter;
import com.brandlive.qa.automation.stepdefs.greenroom.BuilderModeStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.List;

public class LoginLogoutStepDefs extends StepDefs {

	LoginLogoutAdapter loginAdapter = new LoginLogoutAdapter();
	E2StreamViewerAdapter e2LoginLogoutAdapter =  new E2StreamViewerAdapter();

	class PresenterInformation{
		String emailId;
		String password;
	}


	@Given("^Logged in to Events \"(.*?)\" successfully$")
	public void Logged_in_to_Events_successfully(String version) {
		loginAdapter.loginToEvents(version);
		sleep(3);
	}

	@And("^Logged out of Events \"(.*?)\"$")
	public void Logged_out_of_Events(String version) {
		loginAdapter.logoutOfEvents(version);
		sleep(3);
	}

	@And("^Logged in to Greenroom after Events successfully$")
	public void Logged_in_to_Greenroom_after_Events_successfully() {
		browser.openNewWindowTab();
		browser.switchToNextWindow();
		loginAdapter.loginToGreenroomAfterEvents();
		sleep(6);
	}

	@And("^Logged out of Greenroom$")
	public void Logged_out_of_Greenroom() {
		loginAdapter.logoutOfGreenroom();
		sleep(3);
	}
	
    @Given("^Logged out of Events \"(.*?)\" after Greenroom$")
    public void logged_out_of_Events_after_Greenroom(String version) {
    	browser.switchToMainWindow();
        loginAdapter.logoutOfEvents(version);
    }

	@Given("^Logged in to greenroom SGR successfully$")
	public void logged_in_to_greenroom_successfully() {
		loginAdapter.loginToGreenroomAfterEvents();
		sleep(3);
	}

	@Given("^stream the show on Stream Viewer with channel code \"([^\"]*)\"$")
	public void stream_the_show_on_stream_viewer_with_channel_code(String channelCode){
		browser.openNewWindowTab();
		browser.switchToNextWindow();
		e2LoginLogoutAdapter.navigateToStreamViewer(channelCode);
		sleep(60);
	}

	@Given("^Exit Stream Viewer$")
	public void exit_stream_viewer(){
		browser.closeCurrentWindowAndSwitchToPreviousWindow();
	}

	@Given("^Login to greenroom as presenter with following credentials$")
	public void login_to_greenroom_as_presenter_with_following_credentials(List<PresenterInformation> presenterInfo) {
		for(PresenterInformation info : presenterInfo) {
			loginAdapter.loginToGreenroomAsPresenter(info.emailId, info.password);
		}
	}

	@Given("^Logged out as presenter from greenroom$")
	public void logged_out_as_presenter_from_greenroom(){
		loginAdapter.logoutToGreenroomAsPresenter();
		sleep(3);
	}

	@Given("^Logged in to greenroom legacy events \"([^\"]*)\" successfully$")
	public void logged_in_to_greenroom_2_successfully(String mode) {
		loginAdapter.loginToGreenroomAfterEvents(mode);
		sleep(3);
	}

}
