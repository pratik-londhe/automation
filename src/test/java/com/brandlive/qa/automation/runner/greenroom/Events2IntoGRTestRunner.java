package com.brandlive.qa.automation.runner.greenroom;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    tags = { "@gr.events_2.released"},
    monochrome = true, 
    glue = { "com.brandlive.qa.automation.stepdefs" },
    format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
    features = { "src/test/resources/com/brandlive/qa/automation/features" })
public class Events2IntoGRTestRunner {
	
	/*
	  @AfterClass
	  public static void tearDown() {
	      Connection.close();
	  }
	*/
}
