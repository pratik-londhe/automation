package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import com.brandlive.qa.automation.greenroom.rest.NavigateToLiveModeRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;


public class NavigateToLiveModeStepDefs extends StepDefs {

	NavigateToLiveModeRest navigateToLiveModeRest = new NavigateToLiveModeRest();
	
	@And("^Go to LiveMode from BuilderMode$")
	public void Go_to_LiveMode_from_BuilderMode() {
		navigateToLiveModeRest.exitBuilderMode(rest_GR_Host());
	}
	
	@And("^Edit the first Shot$")
	public void Edit_First_Shot() {
		navigateToLiveModeRest.editFirstShot(rest_GR_Host());
	}
}