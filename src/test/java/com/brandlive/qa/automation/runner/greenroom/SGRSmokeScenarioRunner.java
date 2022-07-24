package com.brandlive.qa.automation.runner.greenroom;

import com.brandlive.qa.automation.utils.Connection;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = { "@gr.events3_GR_SmokeTest_SGR.released"},
        monochrome = true,
        glue = { "com.brandlive.qa.automation.stepdefs" },
        format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
        features = { "src/test/resources/com/brandlive/qa/automation/features" })
public class SGRSmokeScenarioRunner {

    @AfterClass
    public static void tearDown() {
        Connection.close();
    }

}
