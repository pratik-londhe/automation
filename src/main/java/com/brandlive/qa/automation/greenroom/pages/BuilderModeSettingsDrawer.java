package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuilderModeSettingsDrawer extends Base {

    public void navigateToStreamingTab(){
        String streamingTab = "(//div[contains(@class,'sliding-menu-options')]//div[2])[2]";
        WebElement streamingTabIcon = waitForDisplayedAndEnabled(By.xpath(streamingTab),"Streaming in Builder Mode");
        streamingTabIcon.click();
        sleep(1);
    }

    public void addDestinationInBuilderMode(String destinationType,String name,String rtmpAddress,String streamKey){
        String addDestination = "//div[@class='session-card add-button']//div";
        WebElement addDestinationButton = waitForDisplayedAndEnabled(By.xpath(addDestination),"Add Destination in Builder Mode");
        addDestinationButton.click();
        selectDestination(destinationType);
        sleep(2);
        String title  = "//input[@placeholder='Name your destination...']";
        WebElement titleInputField = waitForDisplayedAndEnabled(By.xpath(title),"Destination title name in Builder Mode");
        titleInputField.sendKeys(name);
        String rmtpAddress  = "//input[@placeholder='Paste RTMP address here...']";
        WebElement rmtpAddressInputField = waitForDisplayedAndEnabled(By.xpath(rmtpAddress),"RTMP address name in Builder Mode");
        rmtpAddressInputField.sendKeys(rtmpAddress);
        String rmtpKey  = "//input[@placeholder='Paste stream key here...']";
        WebElement rmtpKeyInputField = waitForDisplayedAndEnabled(By.xpath(rmtpKey),"RTMP key name in Builder Mode");
        rmtpKeyInputField.sendKeys(streamKey);
        String save = "//button[@class='info-green']";
        WebElement saveButton = waitForDisplayedAndEnabled(By.xpath(save),"Save button in Builder Mode");
        saveButton.click();
        sleep(2);
    }

    public void toggleOnDestination(){
        String toggle  = "(//label[@class='switch-container'])[2]";
        WebElement toggleButton = waitForDisplayedAndEnabled(By.xpath(toggle),"destination toggle in Builder Mode");
        toggleButton.click();
    }

    public void selectDestination(String destinationName){
        List<WebElement> destinationList = webDriver.findElements(By.xpath("//div[contains(@class,'active destination-options')]//span"));
        for(WebElement destination :destinationList){
            if (destination.getText().equalsIgnoreCase(destinationName)){
                destination.click();
                break;
            }
        }
    }


}
