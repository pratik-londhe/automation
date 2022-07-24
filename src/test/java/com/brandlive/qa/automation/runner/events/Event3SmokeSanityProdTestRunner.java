package com.brandlive.qa.automation.runner.events;

import com.brandlive.qa.automation.utils.Connection;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@gr.events3_Smoke_Sanity_Prod.released"},
        monochrome = true,
        glue = {"com.brandlive.qa.automation.stepdefs"},
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features = {"src/test/resources/com/brandlive/qa/automation/features"})
public class Event3SmokeSanityProdTestRunner {

    @AfterClass
    public static void tearDown() {
        Connection.close();
    }
}