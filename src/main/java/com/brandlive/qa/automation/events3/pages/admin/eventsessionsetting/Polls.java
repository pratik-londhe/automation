package com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Polls extends Base {

    public void clickOnPollsTab() {
        String polls = "(//ul[@class='page-container-horizontal-tabs tab-navigation']//button)[2]";
        WebElement pollsTab = waitForDisplayedAndEnabled(By.xpath(polls), "Polls Tab");
        javascriptExecutorClick(pollsTab);
        log.info("Clicked on the Polls tab on the session page.");
    }

    private void clickOnAddPolls() {
        String polls = "//label[text()='Add Poll']";
        WebElement addPolls = waitForDisplayedAndEnabled(By.xpath(polls), "Add Polls");
        javascriptExecutorClick(addPolls);
        log.info("Clicked on the Add Polls on the session page.");
    }

    public void addPoll() {
        clickOnPollsTab();
        clickOnAddPolls();
        String checkBox = "(//*[name()='svg' and @id='icon-checkbox'])[1]";
        String submit = "//button[@class='primary']";
        WebElement pollsCheckBox = waitForDisplayedAndEnabled(By.xpath(checkBox), "Polls CheckBox");
        pollsCheckBox.click();
        log.info("Added the polls on the session page.");
        WebElement submitButton = waitForDisplayedAndEnabled(By.xpath(submit), "Submit button");
        javascriptExecutorClick(submitButton);
        log.info("Clicked on the submit button.");
    }

    public boolean verifyAddedPollOnAdmin() {
        String pollList = "//div[@class='question-list']";
        if (elementPresent(By.xpath(pollList))) {
            log.info("Verified the added poll list on the admin side.");
            return true;
        }
        return false;
    }
}