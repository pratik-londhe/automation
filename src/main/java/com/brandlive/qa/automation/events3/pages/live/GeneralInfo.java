package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralInfo extends Base {

    public void enterGeneralInfo(String fName, String lName, String mail, String passcode) {
        log.info("Enter general info on the registration button...");
        String firstName = "(//input[@placeholder='First Name'])[1]";
        String LastName = "(//input[@placeholder='Last Name'])[1]";
        String email = "(//input[@placeholder='Email Address'])[1]";
        String next = "(//button[@type='submit'])[1]";
        String passcodeLabel = "//input[contains(@placeholder,'Passcode')]";
        WebElement firstNameTextField = waitForDisplayedAndEnabled(By.xpath(firstName), "First Name on event live page");
        firstNameTextField.clear();
        firstNameTextField.sendKeys(fName);
        log.info("Entered the First Name.");
        WebElement lastNameTextField = waitForDisplayedAndEnabled(By.xpath(LastName), "Last Name button on event live page");
        lastNameTextField.clear();
        lastNameTextField.sendKeys(lName);
        log.info("Entered the Last Name.");
        WebElement emailNameTextField = waitForDisplayedAndEnabled(By.xpath(email), "Email on event live page");
        emailNameTextField.clear();
        emailNameTextField.sendKeys(mail);
        log.info("Entered the Email Name.");
        if (elementPresent((By.xpath(passcodeLabel)))) {
            WebElement passcodeLabelText = waitForDisplayedAndEnabled(By.xpath(passcodeLabel), "Passcode Label");
            passcodeLabelText.clear();
            passcodeLabelText.sendKeys(passcode);
            log.info("Entered the passcode");
        } else {
            log.info("There is no Passcode field on the Registration page");
        }
        WebElement nextButton = waitForDisplayedAndEnabled(By.xpath(next), "Next button on event live page");
        nextButton.click();
        log.info("Clicked on the Next button.");
        sleep(3);
    }

    public void enterGeneralInfoWithoutEmail(String fName, String lName) {
        log.info("Enter general info on the registration button...");
        String firstName = "(//input[@placeholder='First Name'])[1]";
        String LastName = "(//input[@placeholder='Last Name'])[1]";
        String next = "(//button[@type='submit'])[1]";
        WebElement firstNameTextField = waitForDisplayedAndEnabled(By.xpath(firstName), "First Name on event live page");
        firstNameTextField.sendKeys(fName);
        log.info("Entered the First Name.");
        WebElement lastNameTextField = waitForDisplayedAndEnabled(By.xpath(LastName), "Last Name button on event live page");
        lastNameTextField.sendKeys(lName);
        log.info("Entered the Last Name.");
        WebElement nextButton = waitForDisplayedAndEnabled(By.xpath(next), "Next button on event live page");
        nextButton.click();
        log.info("Clicked on the Next button.");
        sleep(3);
    }

    public boolean verifyMessageForBlockedEmailDomain() {
        log.info("Verify blocked email domain error message.");
        String blockedEmailMsg = "//p[@class='registration-error']";
        WebElement blockedEmailDomainMessage = waitForDisplayedAndEnabled(By.xpath(blockedEmailMsg), "Blocked Email domain message.");
        if (blockedEmailDomainMessage.getText().
                contains("Sorry, registration from this email domain is not allowed. Please register with another address and/or an approved work email.")) {
            log.info("Verified that the blocked email domain error message.");
            return true;
        }
        return false;
    }

    public boolean verifyThePasscodeLabelChanged(String passLabel) {
        log.info("Verify the passcode label is changed.");
        String passcode = "//label[text()='" + passLabel + "']";
        WebElement passcodeLabel = waitForDisplayedAndEnabled(By.xpath(passcode), "Passcode Label.");
        if (passcodeLabel.getText().equals(passLabel)) {
            log.info("Verified that the blocked email domain error message.");
            return true;
        }
        return false;
    }

    public boolean verifyTicketIsSoldOutMessage(String ticketSoldOutMessage) {
        log.info("Verify the ticket is sold out message..");
        String ticketSold = "//h2[@class='evt-heading-2 stable registration-form-title ']";
        WebElement ticketSoldMessage = waitForDisplayedAndEnabled(By.xpath(ticketSold), "Ticket Sold header Message.");
        if (ticketSoldMessage.getText().equals(ticketSoldOutMessage)) {
            log.info("Verified that the ticket is sold out message..");
            return true;
        }
        return false;
    }

    public boolean verifyTheGeneralInfoPage(String generalInfoPageMessage) {
        log.info("Verify the General info page..");
        String generalInfoMsg = "//h2[@class='evt-heading-2 stable registration-form-title ']";
        WebElement generalInfoMessage = waitForDisplayedAndEnabled(By.xpath(generalInfoMsg), "General Info page message.");
        if (generalInfoMessage.getText().equals(generalInfoPageMessage)) {
            log.info("Verified the General Info Page.");
            return true;
        }
        return false;
    }

    public boolean verifySignInPage(String signInMsg) {
        String message = "//div[@class='registration-form-inner verification']//p";
        String backToRegistrationButton = "//div[@class='registration-actions secondary']//button";
        WebElement signInMessage = waitForDisplayedAndEnabled(By.xpath(message), "Sign In Page Message");
        if (signInMessage.getText().equals(signInMsg) && elementPresent(By.xpath(backToRegistrationButton))) {
            log.info("Verified the Sign in page.");
            return false;
        }
        return false;
    }
}