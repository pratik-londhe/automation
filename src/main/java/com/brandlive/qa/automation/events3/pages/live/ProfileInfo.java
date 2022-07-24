package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfileInfo extends Base {

    public void enterProfileInfo(String cName, String bioText, String funFactText, String location) {
        log.info("Enter personal info...");
        String companyName = "(//input[@placeholder='Company Name'])[2]";
        String bio = "(//textarea[@placeholder='Bio'])[2]";
        String funFact = "(//input[@placeholder='Fun Fact'])[2]";
        String next = "(//button[@type='submit'])[4]";

        WebElement companyNameTextField = waitForDisplayedAndEnabled(By.xpath(companyName), "Company Name on the Profile Info.");
        companyNameTextField.sendKeys(cName);
        log.info("Entered the Company Name.");
        WebElement bioTextArea = waitForDisplayedAndEnabled(By.xpath(bio), "Bio on the Profile Info.");
        bioTextArea.sendKeys(bioText);
        log.info("Entered the Job Title.");
        WebElement funFac = waitForDisplayedAndEnabled(By.xpath(funFact), "Fun Fact on the Profile Info.");
        funFac.sendKeys(funFactText);
        log.info("Entered the Age.");
        WebElement nextButton = waitForDisplayedAndEnabled(By.xpath(next), "Next button on the Profile Info.");
        nextButton.click();
        log.info("Clicked on the next button.");
        sleep(3);
    }
}