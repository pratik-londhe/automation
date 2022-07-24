package com.brandlive.qa.automation.events3.pages.admin.landingpagesetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sponsors extends Base {

    private void clickOnSponsorsTab() {
        String sponsors = "//div[text()='Sponsors']";
        WebElement sponsorsTab = waitForDisplayedAndEnabled(By.xpath(sponsors), "Sponsors Tab");
        if (sponsorsTab.isDisplayed()) {
            sponsorsTab.click();
            log.info("The Sponsors Tab is displayed and clicked.");
        }
    }

    private void clickOnAddSponsors() {
        String addSponsors = "//div[@class='field-group large-button']//label[text()='Add Sponsor']";
        WebElement addSponsorsButton = waitForDisplayedAndEnabled(By.xpath(addSponsors), "Add Sponsors button");
        if (addSponsorsButton.isDisplayed()) {
            javascriptExecutorClick(addSponsorsButton);
            log.info("The Add Sponsors button is displayed and clicked.");
        }
    }

    public void selectSponsors() {
        clickOnSponsorsTab();
        clickOnAddSponsors();
        String sponsors = "(//div[@class='add-sponsor']//div)[1]";
        WebElement addSponsors = waitForDisplayedAndEnabled(By.xpath(sponsors), "Add Sponsors");
        javascriptExecutorClick(addSponsors);
        log.info("Selected the Sponsors.");
    }

    public void addItemToPage() {
        String checkBoxSpeaker = "//*[name()='svg' and @id='icon-checkbox-borderless']";
        String done = "//button[@class='primary']";
        if (elementPresent(By.xpath(checkBoxSpeaker))) {
            WebElement doneButton = waitForDisplayedAndEnabled(By.xpath(done), "Done button");
            doneButton.click();
            log.info("Clicked on the Done button.");
        }
        sleep(4);
    }

    public boolean verifyAddedSponsorsOnAdmin() {
        String sponsors = "//div[@class='sponsor-card-container']//img";
        if (elementPresent(By.xpath(sponsors))) {
            log.info("Verified the added sponsors on the admin side.");
            return true;
        }
        return false;
    }
}