package com.brandlive.qa.automation.events3.pages.admin.registrationsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Emails extends Base {

    private void clickOnEmailsCard() {
        String settingTab = "//div[@class='tab-header-buttons']//div[2]";
        String emails = "(//*[name()='svg' and @id='icon-arrow-right'])[3]";
        WebElement settingRegistrationTab = waitForDisplayedAndEnabled(By.xpath(settingTab), "Setting tab on the registration page.");
        settingRegistrationTab.click();
        log.info("Clicked on the Registration Setting.");
        WebElement emailsCard = waitForDisplayedAndEnabled(By.xpath(emails), "Emails card");
        emailsCard.click();
        log.info("Clicked on the Emails card.");
    }

    public void setEmailSenderName(String mailSenderName) {
        String emailSenderName = "//input[@placeholder='name']";
        //clickOnEmailsCard();
        WebElement emailSenderNameText = waitForDisplayedAndEnabled(By.xpath(emailSenderName), "Email Sender Name");
        emailSenderNameText.sendKeys(mailSenderName);
        log.info("Set the email sender name.");
    }
    
    public void toggleActionOnSendEmailConfirmation(String toggleAction) {
        String sendEmailConfON = "//label[text()='Send Email Confirmation']//following::div[@class='form-control switch on']";
        String sendEmailConfOFF = "//label[text()='Send Email Confirmation']//following::div[@class='form-control switch'][1]";
        String offState = "//div[@class='settings-card'][3]//div[@class='form-control switch']";
        //clickOnEmailsCard();
        if (toggleAction.equals("ON")) {
            if (elementPresent(By.xpath(sendEmailConfON))) {
                log.info("Already the Send Email Confirmation toggle is ON");
            } else {
                WebElement sendEmailConfirmationOFF = waitForDisplayedAndEnabled(By.xpath(sendEmailConfOFF), "Send Email Confirmation toggle OFF");
                sendEmailConfirmationOFF.click();
                log.info("Enabled the Send Email Confirmation toggle.");
            }
        } else {
            if (elementPresent(By.xpath(offState))) {
                log.info("Already the Send email confirmation toggle is OFF.");
            } else {
                WebElement sendEmailConfirmationON = waitForDisplayedAndEnabled(By.xpath(sendEmailConfON), "Send Email Confirmation toggle ON");
                sendEmailConfirmationON.click();
                log.info("Disabled the Send Email Confirmation toggle.");
            }
        }
    }
}