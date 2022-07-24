package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomeHeader extends Base {

    public void createSGREvent(){
        String createShow = "//button[contains(@class,'corner-round-massive')]";
        WebElement createShowButton = waitForDisplayedAndEnabled(By.xpath(createShow),"Create show button for SGR");
        createShowButton.click();
        String eventTitle = "//div[@class='input-container name']//input";
        int a = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        eventName = "Automation Event " + a + " " + FOMATTER.format(dt);
        WebElement eventTitleTextBox = waitForDisplayedAndEnabled(By.xpath(eventTitle),"Event title text box");
        eventTitleTextBox.sendKeys(eventName);
        String startDate = "(//div[@class='date']//div[@class='react-datepicker__input-container']//input)[1]";
        WebElement startDateInputField = waitForDisplayedAndEnabled(By.xpath(startDate),"Start date input field for SGR event");
        startDateInputField.sendKeys(dateMethodForSGR());
        String startTime = "(//div[@class='time']//div[@class='react-datepicker__input-container']//input)[1]";
        WebElement startTimeInputField = waitForDisplayedAndEnabled(By.xpath(startTime),"Start time input field for SGR event");
        startTimeInputField.sendKeys(timeFormatForSGR("StartTime"));
        String endDate = "(//div[@class='date']//div[@class='react-datepicker__input-container']//input)[2]";
        String endTime = "(//div[@class='time']//div[@class='react-datepicker__input-container']//input)[2]";
        WebElement endTimeInputField = waitForDisplayedAndEnabled(By.xpath(endTime),"Start time input field for SGR event");
        sleep(2);
        String saveEvent = "//div[@class='bottom-buttons']//button[@class='green']";
        WebElement saveEventButton = waitForDisplayedAndEnabled(By.xpath(saveEvent),"Save button for SGR event");
        saveEventButton.click();
        sleep(7);
    }

}
