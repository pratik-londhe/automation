package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.CalendarView;
import com.brandlive.qa.automation.greenroom.pages.ListView;
import com.brandlive.qa.automation.utils.Doer;

public class CalendarListViewAdapter extends Doer {
	
	CalendarView calView = new CalendarView();	
	ListView listView = new ListView();

	
	public void selectCalendarView() {
		
		if(listView.checkListViewDisplayed()) {
			calView.selectCalendarView();
		}
	}
	
	public void selectListView() {
		
		if(calView.checkCalendarViewDisplayed()) {
			listView.selectListView();
		}
	}
	
	public String changeCalendarView(String newView) {
		
		calView.selectDifferentCalView(newView);
		return calView.classAttributeValueOfCalendarPlugin();
		
	}

	public void navigateToShowDetailsPage(){
		calView.searchAndNavigateToShowDetailsPage();
	}

	public void navigateToLegacyShowDetailsPage(String eventName){
		calView.searchAndNavigateToShowDetailsPage(eventName);
	}


}
