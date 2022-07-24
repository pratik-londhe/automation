package com.brandlive.qa.automation.events3.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class EventTemplateSelection extends Base {

    public static String selectedTemplateName = new String();

    public void selectEventTemplateAtRandom() {
        int random = (int) (Math.random() * 3) + 1;
        WebElement templateNameH3 = webDriver.findElement(By.xpath("(//button[@class='primary'])[" + random + "]//parent::div//parent::div/h3"));
        selectedTemplateName = templateNameH3.getText();
        WebElement templateButton = webDriver.findElement(By.xpath("(//button[@class='primary'])[" + random + "]"));
        templateButton.click();
    }

    public void returnToEvents() {
        WebElement returnToEventsButton = webDriver.findElement(By.xpath("//a[@href='/admin/events']"));
        returnToEventsButton.click();
    }

    public void selectTheTemplateForEvent(String templateName) {
        String template = "(//h3[text()='" + templateName + "']//following::div[@class='button-row']//button)[1]";
        WebElement templateNameH3 = waitForDisplayedAndEnabled(By.xpath(template), "Template Name Section.");
        templateNameH3.click();
        log.info("Selected the template: " + templateName);
    }
}
