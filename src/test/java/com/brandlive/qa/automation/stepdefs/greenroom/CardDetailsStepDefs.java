package com.brandlive.qa.automation.stepdefs.greenroom;

import com.brandlive.qa.automation.greenroom.adapters.CalendarListViewAdapter;
import com.brandlive.qa.automation.greenroom.adapters.CardDetailsAdapter;
import com.brandlive.qa.automation.greenroom.adapters.GreenroomHeaderAdapter;
import com.brandlive.qa.automation.greenroom.adapters.UpNextCardsAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class CardDetailsStepDefs extends StepDefs {

	GreenroomHeaderAdapter grHeaderAdapter = new GreenroomHeaderAdapter();
	UpNextCardsAdapter cardsAdapter = new UpNextCardsAdapter();
	CardDetailsAdapter cardDetailsAdapter = new CardDetailsAdapter();
	CalendarListViewAdapter calendarListViewAdapter = new CalendarListViewAdapter();

	class SessionType{
		String sessionType;
	}
	
	@When("^Navigate to event card details$")
	public void navigate_to_event_card_details() {
		calendarListViewAdapter.navigateToShowDetailsPage();
		sleep();
	}
	
	@And("^Enter Greenroom in Live mode$")
	public void enter_Greenroom_in_Live_mode() {
		cardDetailsAdapter.enterGreenroomFromEventCardDetailsInLiveMode();
		sleep();
	}
	
	@Then("^Exit Greenroom from Live mode to return shows$")
	public void exit_Greenroom_from_Live_mode_to_return_shows() {
		String url = blSubscription.getGreenroomUrl();
	    String greenroomRole = blSubscription.getGreenroomRole();
	    if(greenroomRole.contains("Producer")) {
		    String producerUrl = url.concat("/producer");
		    grHeaderAdapter.exitGreenroomFromLiveModeToShows(producerUrl);
	    }	
		sleep(3);
	}

	@Given("^Add following types of sessions in the show$")
	public void add_following_types_of_sessions_in_the_show(List<SessionType> sessions) {
		for(SessionType sessionType: sessions) {
			cardDetailsAdapter.addSession(sessionType.sessionType);
		}

	}

	@Given("^update rehearsal session name$")
	public void update_rehearsal_session_name(){
		cardDetailsAdapter.updateSession();
	}

	@Given("^delete all the added sessions$")
	public void delete_all_the_added_sessions() {
		cardDetailsAdapter.deleteAllSessions();

	}

	@When("^Navigate to event \"([^\"]*)\" card details$")
	public void search_and_navigate_to_event_card_details(String eventName) {
		calendarListViewAdapter.navigateToLegacyShowDetailsPage(eventName);
		sleep();
	}

}
