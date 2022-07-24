package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import com.brandlive.qa.automation.greenroom.rest.BuilderModePageRest;
import com.brandlive.qa.automation.greenroom.rest.LiveModePageRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;


public class BuilderModePageStepDefs extends StepDefs {

	BuilderModePageRest builderModePageRest = new BuilderModePageRest();
	
	@And("^Post Setting API$")
	public void Post_Settings_API() {
		builderModePageRest.postSettingsApi(rest_GR_Host());
		if (builderModePageRest.settingApiResponse == 200) {
			log.debug("Setting Api is success! ");
		}
	}

	@And("^Check if producer is present in session call$")
	public void Check_if_producer_is_present_in_session_call() {
		builderModePageRest.checkProducerSessionCall(rest_GR_Host());
		log.info("Check producer is in session response: "+BuilderModePageRest.isProducerForSession);
	}
}
