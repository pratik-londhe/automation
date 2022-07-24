package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.CardDetailsView;
import com.brandlive.qa.automation.utils.Doer;

public class CardDetailsAdapter extends Doer {
	
	CardDetailsView cardDetailsView = new CardDetailsView();
	
	public void enterGreenroomFromEventCardDetailsInLiveMode() {
		cardDetailsView.enterGRAtLiveView();
	}

	public void addSession(String sessionType){
		cardDetailsView.openAddSessionModal();
		cardDetailsView.addSession(sessionType);
	}

	public void updateSession(){
		cardDetailsView.updateSessionName();
	}

	public void deleteAllSessions(){
		cardDetailsView.deleteAllSessions();
		cardDetailsView.validateSessionDeleted();
	}

}
