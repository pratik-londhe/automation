package com.brandlive.qa.automation.events3.pages.admin.landingpagesetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage extends Base {

    public boolean verifyLandingPageIsDisplayed() {
        String landingStructure = "//div[@class='structure-container']";
        WebElement landingStructurePanel = waitForDisplayedAndEnabled(By.xpath(landingStructure), "Landing structure Panel.");
        if (landingStructurePanel.isDisplayed()) {
            log.info("Verified the landing structure panel is displayed");
            return true;
        }
        return false;
    }
}