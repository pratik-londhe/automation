package com.brandlive.qa.automation.runner.greenroom;

import com.brandlive.qa.automation.utils.Connection;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = { "@gr.events3_GR_Basic_RegressionTest.released"},
        monochrome = true,
        glue = { "com.brandlive.qa.automation.stepdefs" },
        format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
        features = { "src/test/resources/com/brandlive/qa/automation/features" })

public class GRRegressionUITestsRunner {

    @AfterClass
    public static void tearDown() {
        Connection.close();
    }
}
