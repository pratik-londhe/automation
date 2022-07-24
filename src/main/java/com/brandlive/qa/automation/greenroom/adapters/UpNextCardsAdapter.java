package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.ShowsUpNextCards;
import com.brandlive.qa.automation.utils.Doer;

public class UpNextCardsAdapter extends Doer {	
	
	ShowsUpNextCards upNextCards = new ShowsUpNextCards();
	
	public void navigateToEventCardDetails() {
		upNextCards.navigateToEventCardDetails();
	}

}
