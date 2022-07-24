package com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Documents extends Base {

    private void clickOnDocumentTab() {
        String document = "(//ul[@class='page-container-horizontal-tabs tab-navigation']//button)[3]";
        WebElement documentTab = waitForDisplayedAndEnabled(By.xpath(document), "Document Tab");
        javascriptExecutorClick(documentTab);
        log.info("Clicked on the Document tab on the session page.");
    }

    private void clickOnAddDocument() {
        String polls = "//label[text()='Add Documents']";
        WebElement addDocumentButton = waitForDisplayedAndEnabled(By.xpath(polls), "Add Document Button");
        javascriptExecutorClick(addDocumentButton);
        log.info("Clicked on the Add Documents Button on the session page.");
    }

    public void addDocument() {
        clickOnDocumentTab();
        clickOnAddDocument();
        String document = "(//div[@class='image-container']//div)[1]";
        WebElement addDocument = waitForDisplayedAndEnabled(By.xpath(document), "Document CheckBox");
        javascriptExecutorClick(addDocument);
        log.info("Added the document on the session page.");
    }

    public boolean verifyAddedDocumentOnAdmin() {
        String document = "//div[@class='image-container']";
        if (elementPresent(By.xpath(document))) {
            log.info("Verified the added Document on the admin side.");
            return true;
        }
        return false;
    }
}