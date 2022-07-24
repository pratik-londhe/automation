package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import com.brandlive.qa.automation.greenroom.rest.AddNewShotPageRest;
import com.brandlive.qa.automation.greenroom.rest.DeleteMediaAndShotRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;


public class DeleteMediaAndShotStepDefs extends StepDefs {

	DeleteMediaAndShotRest deleteMediaAndShotRest = new DeleteMediaAndShotRest();
	AddNewShotPageRest addNewShotPageRest = new AddNewShotPageRest();
	
	
	@And("^Delete newly added media$")
	public void Delete_Newly_Added_Media() {
		deleteMediaAndShotRest.deleteMedia(rest_GR_Host());
	}
	
	@And("^Bulk Edit Shots for Delete Media$")
	public void Bulk_Edit_Shots_Media_Deleted() {
		addNewShotPageRest.editBulkShot(rest_GR_Host(), "Delete");
		if(addNewShotPageRest.editBulkShots == 200) {
			log.debug("Api builk edit new shot is success for delete media!");
		}
	}
	
	@And("^Delete newly added shot$")
	public void Delete_Newly_Added_Shot() {
		deleteMediaAndShotRest.deleteShot(rest_GR_Host());
	}
	
	
	
}
