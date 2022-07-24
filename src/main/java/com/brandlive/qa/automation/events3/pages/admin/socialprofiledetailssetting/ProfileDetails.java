package com.brandlive.qa.automation.events3.pages.admin.socialprofiledetailssetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfileDetails extends Base {

    private void clickOnProfileDetailsCard() {
        String eventAvailability = "(//*[name()='svg' and @id='icon-arrow-right'])[2]";
        WebElement eventAvailabilityCard = waitForDisplayedAndEnabled(By.xpath(eventAvailability), "Event Availability Card");
        eventAvailabilityCard.click();
        log.info("Clicked on the Event Availability Card.");
    }

    public void toggleActionOnProfileDetails(String toggleAction) {
        clickOnProfileDetailsCard();
        String toggleProfileON = "//div[@class='editable-nav-name']//following::div[@class='form-control switch on'][1]";
        String toggleProfileOFF = "//div[@class='editable-nav-name']//following::div[@class='form-control switch'][1]";
        if (toggleAction.equals("ON")) {
            if (elementPresent(By.xpath(toggleProfileON))) {
                log.info("Already the Profile toggle is ON");
            } else {
                WebElement profileToggleOff = waitForDisplayedAndEnabled(By.xpath(toggleProfileOFF), "Profile Toggle OFF");
                profileToggleOff.click();
                log.info("Enabled the Profile Toggle.");
            }
        } else {
            if (elementPresent(By.xpath(toggleProfileOFF))) {
                log.info("Already the Profile toggle is OFF.");
            } else {
                WebElement profileToggleON = waitForDisplayedAndEnabled(By.xpath(toggleProfileON), "Profile toggle ON");
                profileToggleON.click();
                log.info("Disabled the Profile toggle.");
            }
        }
    }
}