package com.brandlive.qa.automation.events3.pages.admin;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LeftNavigation extends Base {

    public void clickOnTheRegistrationTab() {
        String registrationTab = "//*[name()='svg' and @id='icon-registration']";
        WebElement registrationTabLeftNav = waitForDisplayedAndEnabled(By.xpath(registrationTab), "Registration tab at the admin side.");
        registrationTabLeftNav.click();
    }

    public void clickOnEventTab() {
        String eventTab = "//*[name()='svg' and @id='icon-events-nav']";
        WebElement eventTabLeftNav = waitForDisplayedAndEnabled(By.xpath(eventTab), "Event tab");
        eventTabLeftNav.click();
        log.info("Clicked on the setting tab.");
    }

    public void clickOnSocialTab() {
        String social = "//*[name()='svg' and @id='icon-people']";
        WebElement socialTab = waitForDisplayedAndEnabled(By.xpath(social), "Social Tab");
        socialTab.click();
        log.info("Clicked on the Social Tab.");
    }

    public void clickOnTheLandingTab() {
        String landing = "(//*[name()='svg' and @id='icon-desktop-slim'])[2]";
        WebElement landingTab = waitForDisplayedAndEnabled(By.xpath(landing), "Landing tab.");
        landingTab.click();
        log.info("Clicked on the Landing tab.");
    }
}