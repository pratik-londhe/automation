package com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sessions extends Base {

    public void clickOnSessionPanel() {
        String eventTab = "//*[name()='svg' and @id='icon-events-nav']";
        String sessionPanelCard = "//div[@class='session-panel-card-link']";
        WebElement eventTabLeftNav = waitForDisplayedAndEnabled(By.xpath(eventTab), "Event tab");
        if (eventTabLeftNav.isDisplayed()) {
            eventTabLeftNav.click();
            log.info("Clicked on the Event Tab left Nav");
            WebElement sessionPanelCardLink = waitForDisplayedAndEnabled(By.xpath(sessionPanelCard), "Session card link");
            if (sessionPanelCardLink.isDisplayed()) {
                sessionPanelCardLink.click();
            }
        }
        sleep(5);
    }

    public void clickOnSettingTab() {
        String settingTab = "//div[@class='tab-header-buttons']//div[2]";
        WebElement settingRegistrationTab = waitForDisplayedAndEnabled(By.xpath(settingTab), "Setting tab on the registration page.");
        settingRegistrationTab.click();
        log.info("Clicked on the setting tab.");
    }

    public void clickOnAddSessionButton() {
        String addSession = "//div[@class='single-session-event-options']//button";
        WebElement addSessionButton = waitForDisplayedAndEnabled(By.xpath(addSession), "Add Session Button.");
        addSessionButton.click();
        log.info("Clicked on the Add Session Button.");
    }

    private void clickOnAddSimilarSession() {
        String similarSession = "//div[@class='field-group large-button']//label[text()='Add Session']";
        WebElement addSimilarSessionButton = waitForDisplayedAndEnabled(By.xpath(similarSession), "Add Similar Session button");
        javascriptExecutorClick(addSimilarSessionButton);
        log.info("Clicked on the Add Similar Session button on the session page.");
    }

    public void addSimilarSessionToSessionPage() {
        clickOnAddSimilarSession();
        String session = "(//div[@class='session-row '])[1]";
        String done = "//button[@class='primary']";
        WebElement similarSession = waitForDisplayedAndEnabled(By.xpath(session), "similar Session");
        similarSession.click();
        log.info("Selected on the similar Session.");
        WebElement doneButton = waitForDisplayedAndEnabled(By.xpath(done), "Done button");
        doneButton.click();
        log.info("Clicked on the done button.");
        sleep(4);
    }

    public boolean verifyAddedSimilarSessionOnAdmin() {
        String similarSession = "//div[@class='agenda-session-card-image']";
        if (elementPresent(By.xpath(similarSession))) {
            log.info("Verified the added similar Session on the admin side.");
            return true;
        }
        return false;
    }

    public void moderationChatApproval(String toggleAction) {
        String chatApprovalON = "//h5[text()='Moderation']//following::div[1]//div[@class='form-control switch on']";
        String chatApprovalOFF = "//h5[text()='Moderation']//following::div[1]//div[@class='form-control switch']";
        if (toggleAction.equals("ON")) {
            if (elementPresent(By.xpath(chatApprovalON))) {
                log.info("Already the Chat toggle is ON");
            } else {
                WebElement chatApprovalToggleOFF = waitForDisplayedAndEnabled(By.xpath(chatApprovalOFF), "Chat field toggle OFF");
                chatApprovalToggleOFF.click();
                log.info("Enabled the Chat toggle.");
            }
        } else {
            if (elementPresent(By.xpath(chatApprovalOFF))) {
                log.info("Already the Chat field is OFF.");
            } else {
                WebElement chatApprovalToggleON = waitForDisplayedAndEnabled(By.xpath(chatApprovalON), "Chat field toggle ON");
                chatApprovalToggleON.click();
                log.info("Disabled the Chat toggle.");
            }
        }
    }

    public void moderationQuestionApproval(String toggleAction) {
        String QueApprovalON = "//h5[text()='Moderation']//following::div[@class='field-group switch'][2]//div[@class='form-control switch on']";
        String QueApprovalOFF = "//h5[text()='Moderation']//following::div[@class='field-group switch'][2]//div[@class='form-control switch']";
        if (toggleAction.equals("ON")) {
            if (elementPresent(By.xpath(QueApprovalON))) {
                log.info("Already the Question toggle is ON");
            } else {
                WebElement QueApprovalToggleOFF = waitForDisplayedAndEnabled(By.xpath(QueApprovalOFF), "Question field toggle OFF");
                QueApprovalToggleOFF.click();
                log.info("Enabled the Question toggle.");
            }
        } else {
            if (elementPresent(By.xpath(QueApprovalOFF))) {
                log.info("Already the Question field is OFF.");
            } else {
                WebElement QuesApprovalToggleON = waitForDisplayedAndEnabled(By.xpath(QueApprovalON), "Question field toggle ON");
                QuesApprovalToggleON.click();
                log.info("Disabled the Chat toggle.");
            }
        }
    }
}