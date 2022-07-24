package com.brandlive.qa.automation.events3.pages.admin.registrationsetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralInfo extends Base {

    public void clickOnRegistrationToggle() {
        String toggle = "//div[@class='form-control switch']";
        WebElement toggleButton = waitForDisplayedAndEnabled(By.xpath(toggle), "Toggle Button");
        toggleButton.click();
        log.info("Clicked on the Registration toggle.");
    }

    public void clickOnEnableRegistrationButton() {
        String enableRegistration = "//button[@class='primary']";
        WebElement enableRegistrationButton = waitForDisplayedAndEnabled(By.xpath(enableRegistration), "Enable Registration Button");
        enableRegistrationButton.click();
        log.info("Clicked on the Enable Registration toggle.");
    }

    public void clickOnGeneralInfoEditIcon() {
        String pencil = "(//*[name()='svg' and @id='icon-edit'])[1]";
        String generalInfo = "//div[@class='toggle-card']//label[text()='General Info']";
        WebElement generalInfoCard = waitForDisplayedAndEnabled(By.xpath(generalInfo), "general Info card");
        mouseHoverAction(generalInfoCard);
        WebElement pencilIcon = waitForDisplayedAndEnabled(By.xpath(pencil), "Pencil Icon of general Info");
        pencilIcon.click();
        log.info("Clicked on the Pencil icon of general Info.");
    }
}
