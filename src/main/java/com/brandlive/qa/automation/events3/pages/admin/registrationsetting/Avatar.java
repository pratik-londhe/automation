package com.brandlive.qa.automation.events3.pages.admin.registrationsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Avatar extends Base {

    public void addAvatarPage() {
        String avatarToggleOff = "(//div[@class='toggle-card']//div[@class='form-control switch'])[1]";
        WebElement avatarToggleOffButton = waitForDisplayedAndEnabled(By.xpath(avatarToggleOff), "Registration tab at the admin side.");
        if (avatarToggleOffButton.isDisplayed()) {
            avatarToggleOffButton.click();
            log.info("Enabled the Avatar toggle");
        }
        sleep(3);
    }
}