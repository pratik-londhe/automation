package com.brandlive.qa.automation.stepdefs.greenroom.rest;


import com.brandlive.qa.automation.greenroom.rest.LiveModePageRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;


public class LiveModePageStepDefs extends StepDefs {

	LiveModePageRest liveModePageRest = new LiveModePageRest();

	@And("^FeatureFlag API Call$")
	public void Feature_Flag_API_Call() {
		liveModePageRest.featureFlagApiCall(rest_GR_Host());
		log.debug("Use_sync : "  +liveModePageRest.use_sync);
		log.debug("Use_sync_media : "  +liveModePageRest.use_sync_media);

		if ((liveModePageRest.use_sync_media.equalsIgnoreCase("true")) && ( liveModePageRest.use_sync.equalsIgnoreCase("true") )){
			log.debug("Feature flag Api is success!");
		}

	}

	@And("^Post Tokbox Token API$")
	public void Post_Tokbox_Token_Api() {
		liveModePageRest.tokboxTokenApi(rest_GR_Host());
		log.debug("Tokbox Token Details - " +liveModePageRest.tokboxToken);
	}


	@And("^Write State for \"(.*?)\" in \"(.*?)\" mode$")
	public void Write_State_API(String actionType,String grPageMode) {
		liveModePageRest.writeStateAPI(rest_GR_Sync_Host(),actionType,grPageMode);
		if (liveModePageRest.writeStateAPIResponse == 200){
			log.debug("Write State API is success! ");
		}
	}

	@And("^Get Background in Live Mode$")
	public void Get_Background_In_Live_Mode() {
		liveModePageRest.getBackground(rest_GR_Host());
		log.debug("Total Images are - " +liveModePageRest.backgroundImg.size());
	}


}
