package com.brandlive.qa.automation.runner.events;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    tags = { "@gr.events3_metrics.released"},
    monochrome = true, 
    glue = { "com.brandlive.qa.automation.stepdefs" },
    format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
    features = { "src/test/resources/com/brandlive/qa/automation/features" })
public class Events3MetricsRestTestRunner {

}
