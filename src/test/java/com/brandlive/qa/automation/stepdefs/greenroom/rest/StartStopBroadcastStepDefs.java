package com.brandlive.qa.automation.stepdefs.greenroom.rest;



import java.util.concurrent.TimeUnit;

import com.brandlive.qa.automation.greenroom.rest.StartStopBroadcastRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;


public class StartStopBroadcastStepDefs extends StepDefs {

	StartStopBroadcastRest startBroadcastRest = new StartStopBroadcastRest();
	
	@And("^Go \"(.*?)\" with Start Api Call$")
	public void Go_Live_Api_Call(String mode) throws InterruptedException {
		TimeUnit.MINUTES.sleep(1);
		startBroadcastRest.goApiCall(rest_GR_Host(),mode);
	}
	
	@And("^Go \"(.*?)\" with Stream Api Call$")
	public void Go_Live_Stream_Call(String mode) {
		startBroadcastRest.goStreamCall(rest_GR_Host(),mode);
	}
	
	
	@And("^\"(.*?)\" with Stop Api Call$")
	public void End_Api_Call(String mode) throws InterruptedException {
		startBroadcastRest.goApiCall(rest_GR_Host(),mode);
	}
	
	@And("^\"(.*?)\" with Stream Api Call$")
	public void End_Stream_Call(String mode) {
		startBroadcastRest.goStreamCall(rest_GR_Host(),mode);
	}
	
	
	@And("^Edit the next shot$")
	public void Edit_Next_Shot() {
		startBroadcastRest.selectNextShot(rest_GR_Host());
	}
	
}
