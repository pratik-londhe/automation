package com.brandlive.qa.automation.stepdefs;

import com.brandlive.qa.automation.utils.Camera;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class CucumberHooks extends StepDefs {

    @After
    /**
     * On Failure, embed a screenshot into the test report
     *
     * @param scenario
     */
    public void failureScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = Camera.takeScreenShot();
                log.info(scenario.getName() + " is failed");
                if(screenshot!=null)
                	scenario.embed(screenshot, "image/png");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
