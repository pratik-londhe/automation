package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuilderModeShowBoard extends Base {

    public void addShotInBuilderMode(){
        sleep(5);
        String addShotXpath = "//div[@class='add-shot-button-short']";
        WebElement addShotButton = waitForDisplayedAndEnabled(By.xpath(addShotXpath),"Add Shot button in Show Builder Mode");
      //  addShotButton.click();
        javascriptExecutorClick(addShotButton);
        sleep(3);
    }

    public void applyLayoutInBuilderMode(int noOfFeeds){
        sleep(3);
        String layout = "//div[@class='layout-row-container'][%d]//div[@class='layout-row']//div[@class='layout-selector-wrapper'][1]";
        String applyLayout = "//div[@class='layout-modal-header-buttons']//button";
        WebElement feedLayout = waitForDisplayedAndEnabled(By.xpath(String.format(layout,noOfFeeds)),"Shot layout with feed");
        feedLayout.click();
        sleep();
        WebElement applyLayoutButton = waitForDisplayedAndEnabled(By.xpath(applyLayout),"Apply layout button in Show Builder Mode");
        applyLayoutButton.click();
        sleep(2);
    }

    public void selectShot(){
        String shotNameLocator = "(//div[@class='showboard-shot-item']//div[contains(@class,'shot-thumbnail')])[13]";
        WebElement shotNameInShowBuilder = waitForDisplayedAndEnabled(By.xpath(shotNameLocator),"Shot Name in Builder Mode");
        shotNameInShowBuilder.click();
    }

    public void expandShowBoard() {
        String showBoardExpand = "//div[contains(@class,'showboard-drawer')]";
      //  String showBoardArrow = "//*[name()='svg' and @id='icon-keyboard-arrow-up']";
        String showBoardArrow = "//div[@class='open-button']";
        WebElement shotDrawerInBuilderMode = waitForDisplayedAndEnabled(By.xpath(showBoardExpand), "Show Board expand button");
        if (!shotDrawerInBuilderMode.getAttribute("class").contains("open")) {
            WebElement shotDrawerInBuilderModeArrow = waitForDisplayedAndEnabled(By.xpath(showBoardArrow), "Show Board expand button");
           // shotDrawerInBuilderModeArrow.click();
            javascriptExecutorClick(shotDrawerInBuilderModeArrow);
            //clickOn(By.xpath(showBoardArrow), 10);
        }
    }

    public boolean validateShotPresent(String shotName){
        sleep(6);
        expandShowBoard();
        String shotNameLocator = "//input[@value='%s']/../parent::div//preceding-sibling::div[contains(@class,'shot-thumbnail')]";
        WebElement shotNameInShowBuilder = waitForDisplayedAndEnabled(By.xpath(String.format(shotNameLocator,shotName)),"Shot Name in Builder Mode");
        return shotNameInShowBuilder.isDisplayed();
    }

    public void nextShot(){
        log.info("Click on the next shot.");
        WebElement nextShotButton = webDriver.findElement(By.xpath("round padding-small background-green"));
        if (nextShotButton.isDisplayed()){
            nextShotButton.click();
            log.info("Clicked on the next Shot button.");
        }
        sleep(2);
    }
}
