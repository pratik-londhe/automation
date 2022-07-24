package com.brandlive.qa.automation.common.adapters;

import com.brandlive.qa.automation.utils.Base;
import com.brandlive.qa.automation.utils.Doer;

public class LoginLogoutAdapter extends Doer {
	
	public static String eventsVersion = new String();
	Base base = new Base();
	
	public void loginToEvents(String version) {
		eventsVersion = version;
		base.loginToEventsAsAdmin(version);
	}
	
	public void logoutOfEvents(String version) {
		base.logoutOfEvents(version);
	}
	
	public void loginToGreenroomAfterEvents() {
		base.loginToGreenroomAsProducer(eventsVersion);
	}
	
	public void logoutOfGreenroom() {
		base.logoutOfGreenroom();
	}

	public void loginToGreenroomAsPresenter(String emailId,String password){
		base.loginToGreenroomAsPresenter(emailId,password);
	}

	public void logoutToGreenroomAsPresenter(){
		base.logoutOfGreenroomAsPresenter();
	}

	public void loginToGreenroomAfterEvents(String eventsVersion) {
		base.loginToGreenroomAsProducer(eventsVersion);
	}
}
