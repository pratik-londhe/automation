package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketInfo extends Base {

    private void selectTicket() {
        log.info("Select the ticket...");
        String ticketCheckBox = "//*[name()='svg' and @id='square-checkbox-unselected']";
        WebElement ticketNameCheckBox = waitForDisplayedAndEnabled(By.xpath(ticketCheckBox), "Ticket Name Checkbox.");
        if (!ticketNameCheckBox.isSelected()) {
            ticketNameCheckBox.click();
            log.info("The Ticket name checkbox is selected.");
        }
        String submit = "//fieldset[@class='registration-panel active']//div[@class='registration-actions secondary']//div//button[1]";
        WebElement submitButton = waitForDisplayedAndEnabled(By.xpath(submit), "Submit button on the ticket page.");
        submitButton.click();
        log.info("Clicked on the Submit button.");
        sleep();
    }

    public void enterTicketsCheckoutDetails(String mail, String cName, String cNumber, String expDate, String cvvNum) {
        log.info("Enter ticket checkout details...");
        selectTicket();
        sleep(3);
        String email = "//input[@name='email']";
        String cardName = "//input[@name='card_name']";
        String cardNumber = "//input[@name='cardnumber' and @data-elements-stable-field-name='cardNumber']";
        String expiration = "//input[@name='exp-date']";
        String cvv = "//input[@name='cvc']";
        String zipCode = "//input[@name='card_zip']";
        String submit = "//fieldset[@class='registration-panel active']//div[@class='registration-actions secondary']//div//button[1]";
        String iframeCardNumber = "//iframe[@title='Secure card number input frame']";
        String iframeExpiration = "//iframe[@title='Secure expiration date input frame']";
        String iframeCVV = "//iframe[@title='Secure CVC input frame']";
        WebElement emailTextField = waitForDisplayedAndEnabled(By.xpath(email), "Email details.");
        emailTextField.sendKeys(mail);
        WebElement nameOnCard = waitForDisplayedAndEnabled(By.xpath(cardName), "Name on card details.");
        nameOnCard.sendKeys(cName);
        WebElement iframeCard = waitForDisplayedAndEnabled(By.xpath(iframeCardNumber), "Card details iframe on card details.");
        switchToFrameByFrameElement(iframeCard);
        WebElement cardNumberDetails = waitForDisplayedAndEnabled(By.xpath(cardNumber), "Card Number details.");
        cardNumberDetails.sendKeys(cNumber);
        switchOutFromFrame();
        WebElement iframeExpirationDate = waitForDisplayedAndEnabled(By.xpath(iframeExpiration), "Expiration date iframe on card details.");
        switchToFrameByFrameElement(iframeExpirationDate);
        WebElement expirationDate = waitForDisplayedAndEnabled(By.xpath(expiration), "Expiration date details.");
        expirationDate.sendKeys(expDate);
        switchOutFromFrame();
        WebElement iframeCVVDetails = waitForDisplayedAndEnabled(By.xpath(iframeCVV), "CVV details Iframe on card details.");
        switchToFrameByFrameElement(iframeCVVDetails);
        WebElement cvvNumber = waitForDisplayedAndEnabled(By.xpath(cvv), "CVV number details.");
        cvvNumber.sendKeys(cvvNum);
        switchOutFromFrame();
        /*WebElement zipCodeField = waitForDisplayedAndEnabled(By.xpath(zipCode), "Zip code details.");
        zipCodeField.sendKeys(zip);*/
        WebElement submitButton = waitForDisplayedAndEnabled(By.xpath(submit), "Submit button on the ticket page.");
        javascriptExecutorClick(submitButton);
        log.info("Clicked on the Submit button.");
        sleep(3);
    }
}