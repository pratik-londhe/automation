package com.brandlive.qa.automation.events3.pages.admin.homesetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Home extends Base {

    public boolean verifyHomePageForOpenEvent(boolean singleOpenSessionEvent, boolean LP, boolean EA) {
        String homeTab = "//div[@class='main-nav-item-icon-container']//*[name()='svg' and @id='icon-home']";
        if (singleOpenSessionEvent && !LP && !EA) {
            if (!elementPresent(By.xpath(homeTab))) {
                log.info("The Home Page is not available for open event for single session.");
                return true;
            }
        } else {
            if (elementPresent(By.xpath(homeTab))) {
                log.info("The Home page is available for the open event for more than one session.");
                return true;
            }
        }
        return false;
    }

    public void clickOnHomeTab() {
        String home = "//div[@class='main-nav-item-icon-container']//*[name()='svg' and @id='icon-home']";
        WebElement homeTab = waitForDisplayedAndEnabled(By.xpath(home), "Home Tab");
        homeTab.click();
        log.info("Clicked on the Home Tab.");
    }

    public void enableProductToggle() {
        String products = "//div[text()='Products']//following::div[@class='form-control switch'][1]";
        WebElement productsToggle = waitForDisplayedAndEnabled(By.xpath(products), "Products Toggle");
        if (productsToggle.isDisplayed()) {
            productsToggle.click();
            log.info("The Products toggle is displayed and enabled.");
        }
        sleep(2);
    }

    public void enableSpeakersToggle() {
        String speakers = "//div[text()='Speakers']//following::div[@class='form-control switch'][1]";
        WebElement speakersToggle = waitForDisplayedAndEnabled(By.xpath(speakers), "Speakers Toggle");
        if (speakersToggle.isDisplayed()) {
            speakersToggle.click();
            log.info("The speakers toggle is displayed and enabled.");
        }
        sleep(2);
    }

    public void enableSponsorsToggle() {
        String sponsors = "//div[text()='Sponsors']//following::div[@class='form-control switch'][1]";
        WebElement sponsorsToggle = waitForDisplayedAndEnabled(By.xpath(sponsors), "Sponsors Toggle");
        if (sponsorsToggle.isDisplayed()) {
            sponsorsToggle.click();
            log.info("The Sponsors toggle is displayed and enabled.");
        }
        sleep(2);
    }

    public void enableVideoToggle() {
        String videos = "//div[text()='Videos']//following::div[@class='form-control switch'][1]";
        WebElement videosToggle = waitForDisplayedAndEnabled(By.xpath(videos), "Videos Toggle");
        if (videosToggle.isDisplayed()) {
            videosToggle.click();
            log.info("The Videos toggle is displayed and enabled.");
        }
        sleep(2);
    }
}