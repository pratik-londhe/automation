package com.brandlive.qa.automation.events3.pages.admin;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EventCustomPages extends Base {
    public static String customPageName;

    private void clickOnAddPage() {
        String addPage = "//button[@class='no-style clear']";
        WebElement addCustomPage = waitForDisplayedAndEnabled(By.xpath(addPage), "Add Page button");
        javascriptExecutorClick(addCustomPage);
        log.info("Clicked on the Add Page button.");
    }

    private void enterPageName(String customPageName) {
        String pageName = "//input[@placeholder='Page name']";
        WebElement pageNameText = waitForDisplayedAndEnabled(By.xpath(pageName), "Page Name.");
        pageNameText.clear();
        pageNameText.sendKeys(customPageName);
    }

    private void clickOnSaveButton() {
        String save = "//button[@class='button primary']";
        WebElement saveButton = waitForDisplayedAndEnabled(By.xpath(save), "Save button");
        saveButton.click();
        sleep(3);
    }

    private boolean verifyCustomPageAdded(String customPageName) {
        String customPage = "//div[text()=' " + customPageName + "']";
        if (elementPresent(By.xpath(customPage))) {
            log.info("The custom page is added successfully.");
            return true;
        }
        return false;
    }

    public void addCustomPageAndPageGatingReqToEvent(int noOfCustomPages, boolean customPageGating, String toggleAction, String mediaType, String mediaName, String productName, String pListName, String pType) {
        for (int gated = 1; gated <= noOfCustomPages; gated++) {
            clickOnAddPage();
            int random = (int) (Math.random() * 10) + 1;
            customPageName = "Custom-Page " + random;
            enterPageName(customPageName);
            clickOnSaveButton();
            log.info("Created" + gated + "custom page: " + customPageName);
            verifyCustomPageAdded(customPageName);
            if (customPageGating) {
                if (gated == 1) {
                    toggleActionOnPageGating(toggleAction);
                    log.info("Click on Page Gated toggle for first page gating.");
                } else {
                    clickOnAddGateButton();
                    log.info("Click on Add Gate button for second page gating.");
                }
                chooseCustomPageForGating(customPageName);
                addPageGatingRequirements(mediaType, mediaName, productName, pListName, pType);
            } else {
                log.info("Page Gating is not required.");
            }
        }
    }

    public void toggleActionOnPageGating(String toggleAction) {
        String pageGatingOff = "//label[text()='Page Gating']//following::div[@class='form-control switch'][1]";
        String pageGatingON = "//label[text()='Page Gating']//following::div[@class='form-control switch on'][1]";
        if (toggleAction.equals("ON")) {
            WebElement pageGatingToggleOFF = waitForDisplayedAndEnabled(By.xpath(pageGatingOff), "Page Gating toggle OFF");
            pageGatingToggleOFF.click();
            log.info("Enabled the Page Gating toggle.");
        } else {
            WebElement pageGatingToggleON = waitForDisplayedAndEnabled(By.xpath(pageGatingON), "Send Page Gating toggle ON");
            pageGatingToggleON.click();
            log.info("Disabled the Page Gating toggle toggle.");
        }
    }

    private void chooseCustomPageForGating(String customPageName) {
        String gatedPages = "//input[contains(@id,'react-select-')]";
        String modalTitle = "//h4[@class='modal-title']";
        String uploadingList = "//label[text()='Uploading List'] | //label[text()='Upload a list'] ";
        WebElement gatedPagesText = waitForDisplayedAndEnabled(By.xpath(gatedPages), "Custom Page Gating");
        gatedPagesText.sendKeys(customPageName);
        gatedPagesText.sendKeys(Keys.ENTER);
        log.info("Added the gating to the custom page : " + customPageName);
        sleep(3);
        WebElement gatedPagesModalTitle = waitForDisplayedAndEnabled(By.xpath(modalTitle), "Custom Page Gating modal pop up");
        gatedPagesModalTitle.click();
        log.info("Clicked on the Custom Page gating modal Pop up.");
        WebElement uploadingListRadioButton = waitForDisplayedAndEnabled(By.xpath(uploadingList), "Uploading List radio Button");
        uploadingListRadioButton.click();
        log.info("Clicked on the Uploading List radio button");
    }

    private void addPageGatingRequirements(String mediaType, String mediaName, String productName, String pListName, String passcodeType) {
        String uploadPasscodeList = "(//input[@type='file'])[5]";
        String passcodeListName = "//input[@placeholder='Audience list name']";
        String radioButton = "//label[text()='" + passcodeType + "']//preceding-sibling::div";
        String apply = "//button[@class='primary']";
        WebElement uploadPasscodeListCSV = webDriver.findElement(By.xpath(uploadPasscodeList));
        uploadFile(mediaType, mediaName, uploadPasscodeListCSV, productName);
        sleep(5);
        log.info("Uploaded a Passcode List CSV file");
        int randomNumber = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        String nameOfPasscodeList = " " + randomNumber + " " + FOMATTER.format(dt);
        WebElement passCodeListName = waitForDisplayedAndEnabled(By.xpath(passcodeListName), "Passcode List Name text.");
        passCodeListName.sendKeys(pListName + nameOfPasscodeList);
        log.info("Entered the passcode List Name");
        WebElement emailPassRadioButton = waitForDisplayedAndEnabled(By.xpath(radioButton), "Email and Passcode radio button.");
        emailPassRadioButton.click();
        log.info("Clicked on the Email only radio button.");
        WebElement applyButton = waitForDisplayedAndEnabled(By.xpath(apply), "Apply button.");
        applyButton.click();
        log.info("Clicked on the apply button.");
        sleep(5);
    }

    public void clickOnAddGateButton() {
        String addGate = "//div[@class='field-group large-button']";
        WebElement addGateButton = waitForDisplayedAndEnabled(By.xpath(addGate), "Add Gate Button.");
        addGateButton.click();
        log.info("Clicked on the Add Gate button.");
    }

    public boolean verifyCustomPagesLiveSide(String pageGatingToggleStatus) {
        boolean result = false;
        String customPagesLive = "//a[contains(@href,'/en/pages/')]";
        if (pageGatingToggleStatus.equals("ON")) {
            if (!elementPresent(By.xpath(customPagesLive))) {
                log.info("The Custom Pages are not present at the live side when the Page Gating is ON.");
                result = true;
            } else {
                log.info("The Custom Pages are present at the live side when the Page Gating is ON.");
                return result;
            }
        } else {
            List<WebElement> customPages = webDriver.findElements(By.xpath(customPagesLive));
            log.info("The total Custom pages are: " + customPages.size());
            for (WebElement page : customPages) {
                if (page.isDisplayed()) {
                    result = true;
                    log.info("The custom page displayed.");
                }
            }
        }
        return result;
    }
}