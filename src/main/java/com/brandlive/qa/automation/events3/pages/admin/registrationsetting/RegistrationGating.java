package com.brandlive.qa.automation.events3.pages.admin.registrationsetting;

import com.brandlive.qa.automation.events3.pages.admin.EventTemplateSelection;
import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistrationGating extends Base {

    public void clickOnRegistrationGatingToggle() {
        String regGating = "//label[text()='Registration gating']//following::div[@class='form-control switch'][1]";
        WebElement regGatingToggle = waitForDisplayedAndEnabled(By.xpath(regGating), "Registration gating toggle");
        regGatingToggle.click();
        log.info("Clicked on the Registration gating toggle.");
    }

    public void addGateRequirements(String gatingType, String sharedPass, String mediaType, String mediaName, String productName, String passList, String masterPass, String passcodeType) {
        String gatingDrpDwn = "//div[@class='select-dropdown-container']";
        String gating = "//div[@class='select-option']//span[text()='" + gatingType + "']";
        String sharedPasscode = "//input[@placeholder='Enter shared passcode']";
        String apply = "//button[@class='primary']";
        WebElement typeOfGatingDrpDwn = waitForDisplayedAndEnabled(By.xpath(gatingDrpDwn), "Type of Gating drop down.");
        typeOfGatingDrpDwn.click();
        log.info("Clicked on the Type of Gating Drop Down.");
        WebElement gatingOption = waitForDisplayedAndEnabled(By.xpath(gating), "Gating type");
        if (gatingType.equals("Shared passcode")) {
            gatingOption.click();
            log.info("Selected the Shared passcode gating option.");
            WebElement sharedPasscodeText = waitForDisplayedAndEnabled(By.xpath(sharedPasscode), "Shared Password text filed.");
            sharedPasscodeText.sendKeys(sharedPass);
            log.info("Set the Shared Passcode.");
            WebElement applyButton = waitForDisplayedAndEnabled(By.xpath(apply), "Apply button.");
            applyButton.click();
            log.info("Clicked on the apply button.");
        } else if (gatingType.equals("Domain email")) {
            gatingOption.click();
            log.info("Selected the Domain email gating option.");
        } else if (gatingType.equals("Audience List")) {
            gatingOption.click();
            log.info("Selected the Passcode List gating option.");
            addGateRequirementsForPasscodeList(mediaType, mediaName, productName, passList, masterPass, passcodeType);
        }
    }

    public void changePasscodeLabel(String passLabel) {
        String editPasscodeLabel = "//button[@class='no-style no-margin no-padding options']";
        String passcodeLabel = "//input[@placeholder='Enter a custom passcode label']";
        String apply = "//button[@class='primary']";
        WebElement editPasscodeLabelIcon = waitForDisplayedAndEnabled(By.xpath(editPasscodeLabel), "Edit Passcode label icon.");
        javascriptExecutorClick(editPasscodeLabelIcon);
        log.info("Clicked on the Edit icon of Passcode Label.");
        WebElement passcodeLabelText = waitForDisplayedAndEnabled(By.xpath(passcodeLabel), "Passcode label text.");
        sleep(3);
        passcodeLabelText.clear();
        passcodeLabelText.sendKeys(passLabel);
        log.info("Changed the passcode label.");
        WebElement applyButton = waitForDisplayedAndEnabled(By.xpath(apply), "Apply button.");
        applyButton.click();
        log.info("Clicked on the apply button.");
    }

    private void addGateRequirementsForPasscodeList(String mediaType, String mediaName, String productName, String passList, String masterPass, String passcodeType) {
        String gatedSession = "//div[@class='field-group tag-select-container session-select scrollableParent']";
        String sessionCheckBox = "(//*[name()='svg' and @id='icon-checkbox'])[1]";
        String passcodeListName = "//input[@placeholder='Audience list name']";
        String masterPasscode = "//input[@placeholder='Enter master passcode']";
        String uploadPasscodeList = "(//input[@type='file'])[2]";
        String gateReqPopUp = "//div[@class='modal medium']";
        String apply = "//button[@class='primary']";
        WebElement gateRequirementsModalPopUp = waitForDisplayedAndEnabled(By.xpath(gateReqPopUp), "Gate Requirements modal Pop up on the registration page.");
        if (gateRequirementsModalPopUp.isDisplayed()) {
            WebElement gatedSessionDropDown = waitForDisplayedAndEnabled(By.xpath(gatedSession), "Gated Session drop down.");
            gatedSessionDropDown.click();
            log.info("Clicked on the Gated Sessions drop down.");
            WebElement allSessionCheckBox = waitForDisplayedAndEnabled(By.xpath(sessionCheckBox), "All Session checkbox Session.");
            allSessionCheckBox.click();
            log.info("Clicked on the all sessions checkbox.");
            gateRequirementsModalPopUp.click();
            WebElement uploadPasscodeListCSV = webDriver.findElement(By.xpath(uploadPasscodeList));
            uploadFile(mediaType, mediaName, uploadPasscodeListCSV, productName);
            sleep(5);
            log.info("Uploaded a Passcode List CSV file");
            int randomNumber = (int) (Math.random() * 1000);
            DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            LocalDateTime dt = LocalDateTime.now();
            String nameOfPasscodeList = " " + randomNumber + " " + FOMATTER.format(dt);
            WebElement passCodeListName = waitForDisplayedAndEnabled(By.xpath(passcodeListName), "Passcode List Name text.");
            passCodeListName.sendKeys(passList + nameOfPasscodeList);
            log.info("Entered the passcode List Name");
            WebElement passcodeMaster = waitForDisplayedAndEnabled(By.xpath(masterPasscode), "Master Passcode text.");
            passcodeMaster.sendKeys(masterPass);
            log.info("Entered the master passcode Name");
            selectPasscodeType(passcodeType);
            WebElement applyButton = waitForDisplayedAndEnabled(By.xpath(apply), "Apply button.");
            applyButton.click();
            log.info("Clicked on the apply button.");
        }
    }

    private void selectPasscodeType(String passcodeType) {
        String radioButton = "//label[text()='" + passcodeType + "']//preceding-sibling::div";
        if (passcodeType.equals("Email Only")) {
            WebElement emailOnlyRadioButton = waitForDisplayedAndEnabled(By.xpath(radioButton), "Email Only radio button.");
            emailOnlyRadioButton.click();
            log.info("Clicked on the Email only radio button.");
        } else if (passcodeType.equals("Passcode only")) {
            WebElement passcodeOnlyRadioButton = waitForDisplayedAndEnabled(By.xpath(radioButton), "Passcode Only radio button.");
            passcodeOnlyRadioButton.click();
            log.info("Clicked on the Passcode only radio button.");
        } else if (passcodeType.contains("Both email and passcode")) {
            WebElement emailPassRadioButton = waitForDisplayedAndEnabled(By.xpath(radioButton), "Email and Passcode radio button.");
            emailPassRadioButton.click();
            log.info("Clicked on the Email only radio button.");
        }
    }

    public boolean verifyAddedPasscodeList() {
        String passcodeList = "//div[@class='settings-card sub-list detailed-card']";
        if (elementPresent(By.xpath(passcodeList))) {
            log.info("The Passcode list is added successfully.");
            return true;
        }
        return false;
    }
}