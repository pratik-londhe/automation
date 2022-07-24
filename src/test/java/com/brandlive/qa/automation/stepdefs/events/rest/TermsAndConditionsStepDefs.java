package com.brandlive.qa.automation.stepdefs.events.rest;

import java.util.Map;

import com.brandlive.qa.automation.events.rest.TermsAndConditionsRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import static org.junit.Assert.*;

import cucumber.api.java.en.And;

public class TermsAndConditionsStepDefs extends StepDefs {
	
	TermsAndConditionsRest termsNConditionsRest = new TermsAndConditionsRest();	
	
	private String content = "**Event Participant Terms**:- Brandlive, Inc. "
			+ "(**we**, **our** or **Brandlive**) provides an event platform for our customers to invite **you**,"
			+ " the event participant, to participate in one or more events hosted by our customer (the **Event**). "
			+ "When you accept this agreement by clicking 'I agree', or otherwise indicating your acceptance of these terms, "
			+ "you agree to access and use the Event in accordance with these participant terms (**Terms**)."
			+ " It is important to note that these Terms are made between you, the participant, and Brandlive. "
			+ "Our customer, the event sponsor, is not a party to these Terms. "
			+ "**YOU MAY NOT ACCESS THE EVENT IF YOU ARE UNDER THE AGE OF 16. "
			+ "BY ACCESSING THE EVENT YOU AFFIRM THAT YOU ARE OVER THE AGE OF 16.**";
	
	@And("^Add terms and conditions for the event$")
	public void Add_terms_and_conditions_for_the_event() {
		termsNConditionsRest.addTermsAndConditions(rest_Event_Host(), channel_name(), content);
		
		Map<String, Object> addTermsAndConditionsRes = TermsAndConditionsRest.addTermsAndConditions;
		log.debug("The ToC event UUID is " + addTermsAndConditionsRes.get("eventID"));
		assertNotNull(addTermsAndConditionsRes.get("eventID"));
		
		Map<String, Object> addNewTermsAndConditionsRes = TermsAndConditionsRest.addNewTermsAndConditions;
		log.debug("The new terms id is " + addNewTermsAndConditionsRes.get("terms_id"));
		log.debug("The new terms content is " + addNewTermsAndConditionsRes.get("content"));
		assertNotNull(addNewTermsAndConditionsRes.get("terms_id"));
		assertEquals("The content does not match", content, addNewTermsAndConditionsRes.get("content"));
	}
	
	@And("^Get terms and conditions for the event$")
	public void Get_terms_and_conditions_for_the_event() {
		termsNConditionsRest.getTermsAndConditions(rest_Event_Host());
		
		Map<String, Object> getNewTermsAndConditionsRes = TermsAndConditionsRest.getNewTermsAndConditions;
		Map<String, Object> addNewTermsAndConditionsRes = TermsAndConditionsRest.addNewTermsAndConditions;
		log.debug("The new terms id is " + getNewTermsAndConditionsRes.get("terms_id"));
		log.debug("The new terms content is " + getNewTermsAndConditionsRes.get("content"));
		assertEquals("The terms id does not match", addNewTermsAndConditionsRes.get("terms_id"), getNewTermsAndConditionsRes.get("terms_id"));
		assertEquals("The content does not match", content, getNewTermsAndConditionsRes.get("content"));
	}
	
	@And("^Update terms and conditions for the event$")
	public void Update_terms_and_conditions_for_the_event() {
		String updatedContent = content.concat(" This is by the order of Brandlive Inc. ");
		termsNConditionsRest.updateTermsAndConditions(rest_Event_Host(), updatedContent);
		
		Map<String, Object> updateNewTermsAndConditionsRes = TermsAndConditionsRest.updateNewTermsAndConditions;
		Map<String, Object> addNewTermsAndConditionsRes = TermsAndConditionsRest.addNewTermsAndConditions;
		log.debug("The new terms id is " + updateNewTermsAndConditionsRes.get("terms_id"));
		log.debug("The new terms content is " + updateNewTermsAndConditionsRes.get("content"));
		assertEquals("The terms id does not match", addNewTermsAndConditionsRes.get("terms_id"), updateNewTermsAndConditionsRes.get("terms_id"));
		assertEquals("The content does not match", updatedContent, updateNewTermsAndConditionsRes.get("content"));
	}

}
