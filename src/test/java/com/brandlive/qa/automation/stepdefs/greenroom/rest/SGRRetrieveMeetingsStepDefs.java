package com.brandlive.qa.automation.stepdefs.greenroom.rest;

import com.brandlive.qa.automation.greenroom.rest.HomePageRest;
import com.brandlive.qa.automation.greenroom.rest.SGRRetrieveMeetingsRest;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

public class SGRRetrieveMeetingsStepDefs extends StepDefs {
    HomePageRest homeRestAdapter = new HomePageRest();
    SGRRetrieveMeetingsRest sGRRetrieveMeetings = new SGRRetrieveMeetingsRest();


    @And("^Retrieve Meetings for standalone$")
    public void Retrieve_Meetings_for_standalone() {
        sGRRetrieveMeetings.getStandAloneMeetings(rest_GR_Host());
    }

    @And("^Retrieve Meetings for standalone by Meeting Id$")
    public void Retrieve_Meetings_for_standalone_by_MeetingId() {
        sGRRetrieveMeetings.getStandAloneMeetingsByMeetingId(rest_GR_Host());

    }


    @And("^Retrieve Meetings for standalone by Channel Id$")
    public void Retrieve_Meetings_for_standalone_by_ChannelId() {
        sGRRetrieveMeetings.getStandAloneMeetingsByChannelId(rest_GR_Host());
    }
}
