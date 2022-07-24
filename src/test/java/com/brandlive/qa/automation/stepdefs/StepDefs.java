package com.brandlive.qa.automation.stepdefs;

import com.brandlive.qa.automation.utils.BrandliveSubscription;
import com.brandlive.qa.automation.utils.Browser;
import com.brandlive.qa.automation.utils.Doer;

public class StepDefs extends Doer {
	
	protected BrandliveSubscription blSubscription = new BrandliveSubscription();
	public Browser browser = new Browser();
	
	protected String gr_Event_Entry_Mode() {
		return blSubscription.getGreenroomEntryMode();
	}

	protected String gr_Host() {
		return blSubscription.getGreenroomUrl();
	}

	protected String gr_User() {
		return blSubscription.getGreenroomUser();
	}
	
	protected String gr_Password() {
		return blSubscription.getGreenroomPassword();
	}
	
	protected String channel_name() {
		return blSubscription.getChannelName();
	}
	
	protected String rest_GR_Host() {
		if(gr_Host().contains("qa")) {
			return "greenroom-api.brandlive-qa.com"; 
		}
		if(gr_Host().contains("staging")) {
			return "greenroom-api.brandlive-staging.com"; 
		}
		if(gr_Host().contains("hot")) {
			return "greenroom-api.brandlive-hot.com"; 
		}
		if(gr_Host().contains("brand.live")) {
			return "api-greenroom.brand.live";
		}
		return null;
	}

	protected String rest_GR_Sync_Host() {
		if(gr_Host().contains("qa")) {
			return "greenroom-sync.brandlive-qa.com";
		}
		if(gr_Host().contains("staging")) {
			return "greenroom-sync.brandlive-staging.com";
		}
		if(gr_Host().contains("hot")) {
			return "greenroom-sync.brandlive-hot.com";
		}
		if(gr_Host().contains("brand.live")) {
			return "sync-greenroom.brand.live";
		}
		return null;
	}
	
	protected String event_Host() {
		return blSubscription.getEventsUrl();
	}
	
	protected String event_User() {
		return blSubscription.getEventsUser();
	}
	
	protected String event_Password() {
		return blSubscription.getEventsPassword();
	}

	protected String rest_Event_Host() {
		if(event_Host().contains("qa")) {
			return "events-api.brandlive-qa.com"; 
		}
		if(event_Host().contains("staging")) {
			return "events-api.brandlive-staging.com"; 
		}
		if(event_Host().contains("hot")) {
			return "events-api.brandlive-hot.com"; 
		}
		if(event_Host().contains("brandlive.com")) {
			return "events-api.brandlive.com";
		}
		if(event_Host().contains("brandnot.live")) {
			return "api.brandnot.live";
		}
		if(event_Host().contains("brand.live")) {
			return "api.brand.live";
		}

		return null;
	}
}
