package com.brandlive.qa.automation.events3.pages.admin.registrationsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomizeForm extends Base {

    public void toggleActionOnEmailAddress(String toggleAction) {
        String emailToggleON = "//p[text()='Email Address']//preceding-sibling::div[@class='form-control switch on']";
        String emailToggleOFF = "//p[text()='Email Address']//preceding-sibling::div[@class='form-control switch']";
        if (toggleAction.equals("ON")) {
            if (elementPresent(By.xpath(emailToggleON))) {
                log.info("Already the Email field toggle is ON");
            } else {
                WebElement emailAddressToggleOFF = waitForDisplayedAndEnabled(By.xpath(emailToggleOFF), "Email Address field toggle OFF");
                emailAddressToggleOFF.click();
                log.info("Disabled the Send Address toggle.");
            }
        } else {
            if (elementPresent(By.xpath(emailToggleOFF))) {
                log.info("Already the email address field is OFF.");
            } else {
                WebElement sendEmailConfirmationON = waitForDisplayedAndEnabled(By.xpath(emailToggleON), "Email Address field toggle ON");
                sendEmailConfirmationON.click();
                log.info("Disabled the Send Email Confirmation toggle.");
            }
        }
    }

    public void clickOnApplyButton() {
        String apply = "//button[@class='primary']";
        WebElement applyButton = waitForDisplayedAndEnabled(By.xpath(apply), "Apply Button.");
        applyButton.click();
        log.info("Clicked on the Apply Button.");
    }
}