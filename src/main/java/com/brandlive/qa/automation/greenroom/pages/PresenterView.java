package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PresenterView extends Base {

    public void confirmPresenterInfo(){
        String next = "//button[contains(@class,'next background-green')]";
        WebElement nextButton = waitForDisplayedAndEnabled(By.xpath(next),"Next button");
            nextButton.click();
            sleep(2);
            nextButton.click();
            sleep(2);
            nextButton.click();
            sleep(2);
    }

    public void searchAndNavigateToShowDetailsPageAsPresenter(){
        String searchBox = "//div[@class='search-field']//input";
        String detailsArrow = "//button[contains(@class,'details-button')]";
        WebElement searchBoxText = waitForDisplayedAndEnabled(By.xpath(searchBox), "Search Box");
        searchBoxText.sendKeys(eventName);
        sleep(2);
        WebElement detailsArrowButton = waitForDisplayedAndEnabled(By.xpath(String.format(detailsArrow,eventName)), "Details arrow button");
        detailsArrowButton.click();
        sleep(2);
    }

}
