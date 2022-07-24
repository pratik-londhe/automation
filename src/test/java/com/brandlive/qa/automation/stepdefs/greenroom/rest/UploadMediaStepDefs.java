package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import com.brandlive.qa.automation.greenroom.rest.AddNewShotPageRest;
import com.brandlive.qa.automation.greenroom.rest.UploadMediaRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;


public class UploadMediaStepDefs extends StepDefs {

	UploadMediaRest uploadMediaRest = new UploadMediaRest();
	AddNewShotPageRest addNewShotPageRest = new AddNewShotPageRest();

	
	@And("^Upload \"(.*?)\" file$")
	public void Upload_Video_File(String fileName) throws InterruptedException {
		uploadMediaRest.uploadMediaFile(rest_GR_Host(), fileName);
		log.debug("Newly Added Video id : " +uploadMediaRest.uploadMediaResponse.getString("id"));
	}
	
	@And("^Verify upload for \"(.*?)\"$")
	public void Verify_Upload(String fileName) throws InterruptedException {
		TimeUnit.SECONDS.sleep(30);
		uploadMediaRest.VerifyUploadMediaFile(rest_GR_Host(), fileName);
	}
	
	@And("^Drag n Drop Media to Shot$")
	public void Drag_n_Drop_Media_to_Shot() {
		uploadMediaRest.addMediaToShot(rest_GR_Host());
		assertTrue(UploadMediaRest.successUploadMediaId>0);
	}
}
