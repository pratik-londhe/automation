package com.brandlive.qa.automation.runner.greenroom;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.brandlive.qa.automation.utils.Connection;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    tags = { "@gr.events3_GR_Basic_SmokeTest.released"},
    monochrome = true, 
    glue = { "com.brandlive.qa.automation.stepdefs" },
    format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
    features = { "src/test/resources/com/brandlive/qa/automation/features" })
public class Events3GRBasicSmokeTestRunner {
	
	  @AfterClass
	  public static void tearDown() {
	      Connection.close();
	  }
	
}
