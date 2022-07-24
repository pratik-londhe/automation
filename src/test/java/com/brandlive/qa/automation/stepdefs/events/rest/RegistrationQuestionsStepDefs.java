package com.brandlive.qa.automation.stepdefs.events.rest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.events.rest.RegistrationQuestionsRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class RegistrationQuestionsStepDefs extends StepDefs {
	
	RegistrationQuestionsRest registrationQuestionsRest = new RegistrationQuestionsRest();
	
	@And("^Get registration questions for channel$")
	public void get_registration_questions_for_channel() {
		registrationQuestionsRest.getRegistrationQuestions(rest_Event_Host(), channel_name());
		
		List<Map<String, Object>> getRegistrationQuestionsRes = RegistrationQuestionsRest.getRegistrationQuestions;
		log.debug("There are total " + getRegistrationQuestionsRes.size() + " questions.");
		assertTrue("The registration questions are not present... ", getRegistrationQuestionsRes.size() > 0);
	}

}
