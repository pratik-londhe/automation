package com.brandlive.qa.automation.events3.pages.admin.registrationsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaidTicketing extends Base {

    public void addTicketPageForTheRegistration() {
        String settingTab = "//div[@class='tab-header-buttons']//div[2]";
        String paidTicketing = "(//*[name()='svg' and @id='icon-arrow-right'])[2]";
        String addTicketType = "//*[name()='svg' and @id='icon-add']";
        WebElement settingRegistrationTab = waitForDisplayedAndEnabled(By.xpath(settingTab), "Setting tab on the registration page.");
        settingRegistrationTab.click();
        log.info("Clicked on the setting tab.");
        WebElement paidTicketingArrow = waitForDisplayedAndEnabled(By.xpath(paidTicketing), "Paid Ticketing on the registration page.");
        if (paidTicketingArrow.isDisplayed()) {
            paidTicketingArrow.click();
            log.info("Clicked on the Paid Ticketing Arrow");
            WebElement addTicketTypeButton = waitForDisplayedAndEnabled(By.xpath(addTicketType), "Add ticket type button on the registration page.");
            addTicketTypeButton.click();
            log.info("Clicked on the Add Ticket Type button.");
        }
        sleep(3);
    }

    public void editTicketForTheRegistration() {
        String ellipsis = "//*[name()='svg' and @id='icon-three-dots-horizontal']";
        String editButton = "//div[@class='popover-wrapper open']//button[1]";
        String addTicketModal = "//div[@class='modal normal']";
        String gatedSession = "//div[@class='field-group tag-select-container session-select normal']";
        String sessionCheckBox = "(//*[name()='svg' and @id='icon-checkbox'])[1]";
        String save = "//button[@class='primary']";
        WebElement ellipsisIcon = waitForDisplayedAndEnabled(By.xpath(ellipsis), "Ellipsis icon on the registration page.");
        if (ellipsisIcon.isDisplayed()) {
            ellipsisIcon.click();
            log.info("Clicked on the Ellipsis icon.");
            WebElement editTicketButton = waitForDisplayedAndEnabled(By.xpath(editButton), "Edit ticket on the registration page.");
            editTicketButton.click();
            log.info("Clicked on the Edit ticket button.");
            WebElement addTicketModalPopUp = waitForDisplayedAndEnabled(By.xpath(addTicketModal), "Add Ticket modal Pop up on the registration page.");
            if (addTicketModalPopUp.isDisplayed()) {
                WebElement gatedSessionDropDown = waitForDisplayedAndEnabled(By.xpath(gatedSession), "Gated Session drop down.");
                gatedSessionDropDown.click();
                log.info("Clicked on the Gated Sessions drop down.");
                WebElement allSessionCheckBox = waitForDisplayedAndEnabled(By.xpath(sessionCheckBox), "All Session checkbox Session.");
                allSessionCheckBox.click();
                log.info("Clicked on the all sessions checkbox.");
                addTicketModalPopUp.click();
                log.info("Clicked on Add tickets modal pop up.");
                WebElement saveButton = waitForDisplayedAndEnabled(By.xpath(save), "All Session checkbox Session.");
                saveButton.click();
                log.info("Clicked on Save button.");
            }
        }
    }
}