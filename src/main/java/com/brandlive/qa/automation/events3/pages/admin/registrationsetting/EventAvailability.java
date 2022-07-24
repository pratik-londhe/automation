package com.brandlive.qa.automation.events3.pages.admin.registrationsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class EventAvailability extends Base {

    public void clickOnEventAvailabilityCard() {
        String settingTab = "//div[@class='tab-header-buttons']//div[2]";
        String eventAvailability = "(//*[name()='svg' and @id='icon-arrow-right'])[1]";
        WebElement settingRegistrationTab = waitForDisplayedAndEnabled(By.xpath(settingTab), "Setting tab on the registration page.");
        settingRegistrationTab.click();
        log.info("Clicked on the Registration Setting.");
        WebElement eventAvailabilityCard = waitForDisplayedAndEnabled(By.xpath(eventAvailability), "Event Availability Card");
        eventAvailabilityCard.click();
        log.info("Clicked on the Event Availability Card.");
    }

//    public void toggleActionOnSendEmailConfirmation(String toggleAction) {
//        String sendEmailConfON = "//label[text()='Send Email Confirmation']//following::div[@class='form-control switch on']";
//        String sendEmailConfOFF = "//label[text()='Send Email Confirmation']//following::div[@class='form-control switch'][1]";
//        String offState = "//div[@class='settings-card'][4]//div[@class='form-control switch']";
//        //clickOnEventAvailabilityCard();
//        new Emails().clickOnEmailsCard();
//        if (toggleAction.equals("ON")) {
//            if (elementPresent(By.xpath(sendEmailConfON))) {
//                log.info("Already the Send Email Confirmation toggle is ON");
//            } else {
//                WebElement sendEmailConfirmationOFF = waitForDisplayedAndEnabled(By.xpath(sendEmailConfOFF), "Send Email Confirmation toggle OFF");
//                sendEmailConfirmationOFF.click();
//                log.info("Enabled the Send Email Confirmation toggle.");
//            }
//        } else {
//            if (elementPresent(By.xpath(offState))) {
//                log.info("Already the Send email confirmation toggle is OFF.");
//            } else {
//                WebElement sendEmailConfirmationON = waitForDisplayedAndEnabled(By.xpath(sendEmailConfON), "Send Email Confirmation toggle ON");
//                sendEmailConfirmationON.click();
//                log.info("Disabled the Send Email Confirmation toggle.");
//            }
//        }
//    }

    public void setBlockedDomainEmail(String blockedEmail) {
        String blockedEmailDomain = "//button[@class='no-style blocked-emails-button']//following::div[@class='form-control switch']";
        String blockedEmailDomainText = "//div[@class='tag-select']//input";
        String apply = "//button[@class='primary']";
        clickOnEventAvailabilityCard();
        WebElement blockedEmailDomainToggle = waitForDisplayedAndEnabled(By.xpath(blockedEmailDomain), "Setting tab on the registration page.");
        blockedEmailDomainToggle.click();
        log.info("Clicked on the Blocked email domain toggle.");
        WebElement blockedEmailText = waitForDisplayedAndEnabled(By.xpath(blockedEmailDomainText), "Event Availability Card");
        blockedEmailText.sendKeys(blockedEmail);
        log.info("Entered the blocked email domain.");
        blockedEmailText.sendKeys(Keys.ENTER);
        log.info("Pressed the enter to add the domain.");
        WebElement applyButton = waitForDisplayedAndEnabled(By.xpath(apply), "Apply button.");
        applyButton.click();
        log.info("Clicked on the apply button.");
    }
}