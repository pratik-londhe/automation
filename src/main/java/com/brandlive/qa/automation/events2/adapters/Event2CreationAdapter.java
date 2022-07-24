package com.brandlive.qa.automation.events2.adapters;

import com.brandlive.qa.automation.events2.pages.Event2CreationAtDashboard;
import com.brandlive.qa.automation.utils.Doer;

public class Event2CreationAdapter extends Doer {
	
	Event2CreationAtDashboard eventCreation = new Event2CreationAtDashboard();
	
	public void checkChannelInEvents() {
		if(!eventCreation.checkChannelSelectedInEvents2()) {
			eventCreation.openMenuAndSelectChannelInEvents2();
		}
	}
	
	public void createEvent() {
		eventCreation.createEvent2();
	}
	
	public void publishEvent() {
		eventCreation.publishEvent2();
	}

}
