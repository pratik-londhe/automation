package com.brandlive.qa.automation.stepdefs.greenroom;

import com.brandlive.qa.automation.greenroom.adapters.HomeHeaderAndLeftNavAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.Given;

public class HomeHeaderStepDef extends StepDefs {
    HomeHeaderAndLeftNavAdapter homeHeaderAndLeftNavAdapter = new HomeHeaderAndLeftNavAdapter();


    @Given("^Create an event in SGR with broadcast session$")
    public void create_an_event_in_SGR_with_broadcast_session() {
        homeHeaderAndLeftNavAdapter.createSGREvent();
    }
}
