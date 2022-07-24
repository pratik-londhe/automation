package com.brandlive.qa.automation.stepdefs.greenroom;


import org.junit.Assert;

import com.brandlive.qa.automation.greenroom.adapters.CalendarListViewAdapter;
import com.brandlive.qa.automation.greenroom.adapters.HomeHeaderAndLeftNavAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CalendarViewStepDefs extends StepDefs {
	

	CalendarListViewAdapter calViewAdapter = new CalendarListViewAdapter();
	HomeHeaderAndLeftNavAdapter grHomeView = new HomeHeaderAndLeftNavAdapter();
	
	@Given("^Check correct channel selected in Greenroom$")
	public void check_correct_channel_selected_in_Greenroom() {
		grHomeView.selectChannel();
	}

	@When("^Select Calendar view$")
	public void Select_Calendar_view() {
		calViewAdapter.selectCalendarView();
		sleep();
	}
	
	@And("^Select List view again$")
	public void Select_List_view_again() {
		calViewAdapter.selectListView();
		sleep();
	}
	
	@And("^Calendar view format changed to \"(.*?)\" successfully$")
	public void Calendar_View_format_changed_to_successfully(String field1) {
		String calPluginClassValue = calViewAdapter.changeCalendarView(field1);
		switch(calPluginClassValue) {
		case "dayGridMonth":
			Assert.assertTrue(calPluginClassValue.contains(field1));
			break;
		case "timeGridWeek":
			Assert.assertTrue(calPluginClassValue.contains(field1));
			break;
		case "timeGridDay":
			Assert.assertTrue(calPluginClassValue.contains(field1));
			break;
		default:
			log.debug("This is not a correct option");
		}
		sleep();
	}

}
