package com.brandlive.qa.automation.events3.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class EventHeader extends Base {

    public void publishEvent() {
        String waitingIndicator = "//*[name()='svg' and @class='waiting-indicator']";
        if (elementPresent(By.xpath(waitingIndicator))) {
            sleep(5);
            log.info("Waiting to display Publish Event button from Loading state.");
        }
        WebElement publishButton = webDriver.findElement(By.xpath("//button[@class='small primary publish-btn' or @class='small primary'] "));
        publishButton.click();
        WebElement publishModal = webDriver.findElement(By.xpath("//div[@class='modal normal']"));
        sleep(3);
        if (publishModal.isDisplayed()) {
            WebElement nextButton = webDriver.findElement(By.xpath("(//button[@class='primary'])[1]"));
            nextButton.click();
        }
        String assistantChecklistModal = "//div[@class='modal normal']";
        sleep(5);
        if (elementPresent(By.xpath(assistantChecklistModal))) {
            WebElement nextButton = webDriver.findElement(By.xpath("(//button[@class='primary'])[2]"));
            nextButton.click();
            log.info("The Assistant pop up is present and clicked on publish.");
            sleep(3);
        } else {
            log.info("The Assistant modal pop up is not present.");
        }
    }

    public String copyPublishedEventLink() {
        sleep(5);
        log.info("Copy the published event link...");
        WebElement copyEventLink = webDriver.findElement(By.xpath("//div[@class='copy-event reverse-tooltip']//button"));
        if (copyEventLink.isDisplayed()) {
            copyEventLink.click();
            log.info("Copied the published event link.");
        }

        log.info("Get the copied URL from the Clipboard...");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String copiedEventURL = null;

        try {
            copiedEventURL = (String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("The copied event link is" + copiedEventURL);
        return copiedEventURL;
    }

    public void clickOnHeaderPathingArrow() {
        String pathingArrow = "//div[@class='pathing-arrow']";
        WebElement headerPathingArrow = waitForDisplayedAndEnabled(By.xpath(pathingArrow), "Header Pathing Arrow");
        if (headerPathingArrow.isDisplayed()) {
            headerPathingArrow.click();
        }
    }

    public void goToAdminPage() {
        String adminLink = "//img[@alt='Go to admin page']";
        WebElement adminLinkPage = waitForDisplayedAndEnabled(By.xpath(adminLink), "Clicked on the admin link page.");
        if (adminLinkPage.isDisplayed()) {
            adminLinkPage.click();
            log.info("Clicked on the Admin link page.");
        }
    }
}
