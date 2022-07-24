package com.brandlive.qa.automation.events3.pages.admin.socialprofiledetailssetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Directory extends Base {

    private void clickOnDirectoryCard() {
        String directory = "(//*[name()='svg' and @id='icon-arrow-right'])[1]";
        WebElement directoryCard = waitForDisplayedAndEnabled(By.xpath(directory), "Directory Card");
        directoryCard.click();
        log.info("Clicked on the Directory Card.");
    }

    public void toggleActionOnDirectoryAvatar(String toggleAction) {
        clickOnDirectoryCard();
        String toggleDirectoryAvatarON = "//div[@class='editable-nav-name']//following::div[@class='form-control switch on']";
        String toggleDirectoryAvatarOFF = "(//div[@class='editable-nav-name']//following::div[@class='form-control switch'])[2]";
        if (toggleAction.equals("ON")) {
            if (elementPresent(By.xpath(toggleDirectoryAvatarON))) {
                log.info("Already the Directory Avatar toggle is ON");
            } else {
                WebElement directoryAvatarToggleOff = waitForDisplayedAndEnabled(By.xpath(toggleDirectoryAvatarOFF), "Avatar Toggle OFF");
                directoryAvatarToggleOff.click();
                log.info("Enabled the Directory Avatar Toggle.");
            }
        } else {
            if (elementPresent(By.xpath(toggleDirectoryAvatarOFF))) {
                log.info("Already the Profile toggle is OFF.");
            } else {
                WebElement directoryAvatarToggleON = waitForDisplayedAndEnabled(By.xpath(toggleDirectoryAvatarON), "Profile toggle ON");
                directoryAvatarToggleON.click();
                log.info("Disabled the Directory Avatar toggle.");
            }
        }
    }
}