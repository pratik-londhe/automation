package com.brandlive.qa.automation.events3.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Gmail extends Base {

    private void goToGmailLogin() {
        String gmailLogin = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
        webDriver.navigate().to(gmailLogin);
        log.info("Navigated to the gmail.");
        sleep(2);
    }

    public void loginToGmailAccount() {
        goToGmailLogin();
        String email = "//input[@type='email']";
        String password = "//input[@type='password']";
        String next = "//span[text()='Next']";
        WebElement emailText = waitForDisplayedAndEnabled(By.xpath(email), "Email Text");
        emailText.sendKeys("brandlive.automation1@gmail.com");
        log.info("Entered the gmail.");
        WebElement nextButton = waitForDisplayedAndEnabled(By.xpath(next), "Next Button");
        nextButton.click();
        log.info("Clicked on the Next button.");
        WebElement passwordText = waitForDisplayedAndEnabled(By.xpath(password), "Password Text");
        passwordText.sendKeys("Brandlive123!");
        log.info("Entered the password.");
        nextButton.click();
        log.info("Clicked on the Next button.");
    }

    public void searchCreatedEventInAnEmail() {
        String search = "//input[@placeholder='Search mail']";
        WebElement searchEmailText = waitForDisplayedAndEnabled(By.xpath(search), "Search Text");
        searchEmailText.sendKeys(eventName);
        log.info("Searched the created event in the Inbox.");
        searchEmailText.sendKeys(Keys.ENTER);
        log.info("Pressed the entered for the email search from the Inbox.");
    }

    public void accessTheEventFromTheEvent() {
        String event = "//div[@title='Inbox']//following::span[1]";
        String accessEvent = "//a[text()='Access ']";
        WebElement eventSubject = waitForDisplayedAndEnabled(By.xpath(event), "Event Subject");
        javascriptExecutorClick(eventSubject);
        log.info("Selected the searched event from the inbox.");
        WebElement accessEventButton = waitForDisplayedAndEnabled(By.xpath(accessEvent), "Access Event Button");
        javascriptExecutorClick(accessEventButton);
        log.info("Clicked on the Access Event button in an email body.");
    }
}