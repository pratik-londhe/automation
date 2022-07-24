package com.brandlive.qa.automation.stepdefs.greenroom.rest;



import java.util.List;
import java.util.Map;

import com.brandlive.qa.automation.greenroom.rest.AddNewShotPageRest;
import com.brandlive.qa.automation.greenroom.rest.DetailsPageRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;

import cucumber.api.java.en.And;


public class AddNewShotPageStepDefs extends StepDefs {

	AddNewShotPageRest addNewShotPageRest = new AddNewShotPageRest();
	
	@And("^Add a new shot$")
	public void Add_New_Shot() {
		addNewShotPageRest.addNewShot(rest_GR_Host());
		Map<String, Object> shot_data = addNewShotPageRest.addNewShots.getMap("shot_data");
		for (Map.Entry<String, Object> entry : shot_data.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("shotTitle")) {
				log.debug("Shot TitleName is : " +entry.getValue());
				break;
			}
		}
	}
	
	@And("^Bulk Edit Shots$")
	public void Bulk_Edit_Shots() {
		addNewShotPageRest.editBulkShot(rest_GR_Host(), "Live");
		if(addNewShotPageRest.editBulkShots == 200) {
			log.debug("Api builk edit new shot is success!");
		}
	}
	
	@And("^Edit the shot$")
	public void Edit_the_Shot() {
		addNewShotPageRest.editShot(rest_GR_Host());
		List<Object> shot_data = addNewShotPageRest.editShots.getList("shot_data");
		for(int i = 0 ; i<shot_data.size();i++) {
			log.debug("Edit Shot Data" +shot_data.get(i));
		}
	}
	
	@And("^Select the shot$")
	public void Select_the_Shot() {
		addNewShotPageRest.selectNewlyAddedShot(rest_GR_Host());
	}
	
	
	@And("^Add Shot duration$")
	public void Add_Shot_Duration(){
		addNewShotPageRest.addShotDuration(rest_GR_Host());
		addNewShotPageRest.getShotDetails(addNewShotPageRest.editshotDurationResponse);
	}	
}
