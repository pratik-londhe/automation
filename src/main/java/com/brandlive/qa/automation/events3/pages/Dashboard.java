package com.brandlive.qa.automation.events3.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class Dashboard extends Base {

    public Boolean checkChannelSelectedInEvents3() {
        log.debug("checking channel in events... ");
        Boolean channelSelected = false;
        WebElement channelDiv = webDriver.findElement(By.xpath("(//span[@class='navdrop-title'])[2]"));
        channelDiv.click();
        log.debug(blSubscription.getChannelName());
        List<WebElement> listDiv = webDriver.findElements(By.xpath("//div[@class='navdrop-list']/div"));
        for (WebElement el : listDiv) {
            if (el.getAttribute("class").contains("on")) {
                WebElement channelLabel = el.findElement(By.tagName("label"));
                if (channelLabel.getText().equalsIgnoreCase(blSubscription.getChannelName())) {
                    channelSelected = true;
                    return channelSelected;
                }
            }
        }

        return channelSelected;
    }

    public void selectChannelInEvents3() {
        log.debug("selecting channel in events... ");
        if (elementPresent(By.xpath("//div[@class='navdrop-list']"))) {
            List<WebElement> listLabel = webDriver.findElements(By.xpath("//div[@class='navdrop-list']/div//label"));
            for (WebElement el : listLabel) {
                if (el.getText().contains(blSubscription.getChannelName())) {
                    //el.click();
                    javascriptExecutorClick(el);
                    break;
                }
            }
        } else {
            WebElement channelDiv = webDriver.findElement(By.xpath("//div[@class='channel-avatar']"));
            channelDiv.click();
            List<WebElement> listLabel = webDriver.findElements(By.xpath("//div[@class='navdrop-list']/div//label"));
            for (WebElement el : listLabel) {
                if (el.getText().contains(blSubscription.getChannelName())) {
                    //el.click();
                    javascriptExecutorClick(el);
                    break;
                }
            }
        }
    }

    public void initiateEventCreation() {
        sleep(3);
        log.debug("initiating event creation... ");
        //WebElement createEventButton = webDriver.findElement(By.xpath("//a[@class='create-event']"));
        WebElement createDropDown = waitForDisplayedAndEnabled(By.xpath("(//span[@class='navdrop-title'])[1]"), "Create Event drop down", 10);
        //createEventButton.click();
        if (createDropDown.isDisplayed()) {
            log.debug("Create Event button is displayed.");
            javascriptExecutorClick(createDropDown);
            log.debug("Clicked on the Create Event drop down.");
            WebElement createEventButton = waitForDisplayedAndEnabled(By.xpath("//a[@class='create-event']"), "Create Event Button", 10);
            javascriptExecutorClick(createEventButton);
            log.debug("Clicked on the Create Event button.");
            sleep(2);
        }
    }


    public void clickOnUpcomingEventTab() {
        String upcomingTab = "//button[text()='Upcoming']";
        WebElement upcomingEventTab = waitForDisplayedAndEnabled(By.xpath(upcomingTab), "Upcoming Event Tab.");
        upcomingEventTab.click();
        log.info("Clicked on the Upcoming the event tab.");
    }

    public void searchEvent() {
        String search = "//input[@placeholder='Search']";
        WebElement searchText = waitForDisplayedAndEnabled(By.xpath(search), "Search Text field.");
        searchText.sendKeys(Base.eventName);
        log.info("Searched the event.");
        searchText.sendKeys(Keys.ENTER);
        log.info("Pressed the enter.");
    }

    public void editEvent() {
        String editIcon = "//h5[text()='" + Base.eventName + "']//preceding::button[@class='passcode-edit no-style'][1]";
        WebElement editEventIcon = waitForDisplayedAndEnabled(By.xpath(editIcon), "Edit Icon");
        editEventIcon.click();
        log.info("Clicked on the Edit icon of Event.");
    }

    public void clickOnDuplicate() {
        String duplicate = "//div[@class='popover-wrapper event-options open']//button[text()='Duplicate']";
        WebElement duplicateButton = waitForDisplayedAndEnabled(By.xpath(duplicate), "Duplicate button.");
        duplicateButton.click();
        log.info("Clicked on the Duplicate button Event.");
        sleep(10);
    }

    public void deleteOriginalEvent() {
        String delete = "//div[@class='popover-wrapper event-options open']//button[text()='Delete']";
        String deleteBtn = "//button[@class='primary']";
        WebElement deleteLink = waitForDisplayedAndEnabled(By.xpath(delete), "Delete Link");
        deleteLink.click();
        log.info("Clicked on the Delete link.");
        sleep(5);
        WebElement deleteButton = waitForDisplayedAndEnabled(By.xpath(deleteBtn), "Delete Button");
        javascriptExecutorClick(deleteButton);
        log.info("Clicked on the Delete button.");
        sleep(5);
    }
}
