package com.brandlive.qa.automation.stepdefs.events.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import com.brandlive.qa.automation.events.rest.PrivacyPolicyRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;

public class PrivacyPolicyStepDefs extends StepDefs {

	PrivacyPolicyRest privacyPolicyRest = new PrivacyPolicyRest();	
	
	private String content = "**Privacy Policy**:- "
			+ "This Privacy Policy describes how we collect, use, and protect the personal information you "
			+ "provide when you use the services provided by Brandlive Inc. through its websites, including "
			+ "the the www.brand.live site, and through its mobile applications (collectively, the **Service**). "
			+ "Unless otherwise defined in this Privacy Policy, capitalized terms used in this Privacy Policy "
			+ "have the same meaning as in the Brandlive Terms of Service. ";
	
	@And("^Add privacy policy for the event$")
	public void Add_privacy_policy_for_the_event() {
		privacyPolicyRest.addPrivacyPolicy(rest_Event_Host(), channel_name(), content);
		
		Map<String, Object> addPrivacyPolicyRes = PrivacyPolicyRest.addPrivacyPolicy;
		log.debug("The privacy policy event UUID is " + addPrivacyPolicyRes.get("eventID"));
		assertNotNull(addPrivacyPolicyRes.get("eventID"));
		
		Map<String, Object> addNewPrivacyPolicyRes = PrivacyPolicyRest.addNewPrivacyPolicy;
		log.debug("The new policy id is " + addNewPrivacyPolicyRes.get("privacy_policy"));
		log.debug("The new policy content is " + addNewPrivacyPolicyRes.get("content"));
		assertNotNull(addNewPrivacyPolicyRes.get("privacy_policy"));
		assertEquals("The content does not match", content, addNewPrivacyPolicyRes.get("content"));
	}
	
	@And("^Get privacy policy for the event$")
	public void Get_privacy_policy_for_the_event() {
		privacyPolicyRest.getPrivacyPolicy(rest_Event_Host());
		
		Map<String, Object> getNewPrivacyPolicyRes = PrivacyPolicyRest.getNewPrivacyPolicy;
		Map<String, Object> addNewPrivacyPolicyRes = PrivacyPolicyRest.addNewPrivacyPolicy;
		log.debug("The new policy id is " + getNewPrivacyPolicyRes.get("privacy_policy"));
		log.debug("The new policy content is " + getNewPrivacyPolicyRes.get("content"));
		assertEquals("The policy id does not match", addNewPrivacyPolicyRes.get("privacy_policy"), getNewPrivacyPolicyRes.get("privacy_policy"));
		assertEquals("The content does not match", content, getNewPrivacyPolicyRes.get("content"));
	}
	
	@And("^Update privacy policy for the event$")
	public void Update_privacy_policy_for_the_event() {
		String updatedContent = content.concat(" This is by the order of Brandlive Inc. ");
		privacyPolicyRest.updatePrivacyPolicy(rest_Event_Host(), updatedContent);
		
		Map<String, Object> updateNewPrivacyPolicyRes = PrivacyPolicyRest.updateNewPrivacyPolicy;
		Map<String, Object> addNewPrivacyPolicyRes = PrivacyPolicyRest.addNewPrivacyPolicy;
		log.debug("The new policy id is " + updateNewPrivacyPolicyRes.get("privacy_policy"));
		log.debug("The new policy content is " + updateNewPrivacyPolicyRes.get("content"));
		assertEquals("The policy id does not match", addNewPrivacyPolicyRes.get("privacy_policy"), updateNewPrivacyPolicyRes.get("privacy_policy"));
		assertEquals("The content does not match", updatedContent, updateNewPrivacyPolicyRes.get("content"));
	}

}
