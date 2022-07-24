package com.brandlive.qa.automation.events3.pages.admin.registrationsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfileInfo extends Base {

    public void addProfileInfoPage() {
        String profileToggleOff = "(//div[@class='toggle-card']//div[@class='form-control switch'])[1]";
        WebElement profileToggleOffButton = waitForDisplayedAndEnabled(By.xpath(profileToggleOff), "Profile Toggle on the registration page.");
        if (profileToggleOffButton.isDisplayed()) {
            profileToggleOffButton.click();
            log.info("Enabled the Profile toggle");
        }
        sleep(3);
    }
}