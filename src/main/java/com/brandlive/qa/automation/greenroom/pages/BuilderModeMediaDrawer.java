package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuilderModeMediaDrawer extends Base {

    public void openMediaDrawerInBuilderMode(){
        String mediaDrawer = "//*[name()='svg' and @id='icon-media-tab']";
        String mediaDrawerButton = "(//div[@class='right-drawer-option'])[3]";
        WebElement mediaDrawerInBuilderMode = waitForDisplayedAndEnabled(By.xpath(mediaDrawer),"Media Drawer in Builder Mode");
        WebElement mediaDrawerButtonInBuilderMode = waitForDisplayedAndEnabled(By.xpath(mediaDrawerButton),"Media Drawer in Builder Mode");
        if(mediaDrawerInBuilderMode.getAttribute("class").contains("default-gray icon")){
            mediaDrawerButtonInBuilderMode.click();
        }
    }

    public void clickOnVideosTab(){
        String videoTab= "//div[contains(@class,'sliding-menu-option')][3]";
        WebElement videoTabInBuilderMode = waitForDisplayedAndEnabled(By.xpath(videoTab),"Video Tab in Show Builder Mode");
        videoTabInBuilderMode.click();
    }

    public void deleteVideo(String videoName){
        String video= "//p[text()='%s']/../following-sibling::div";
        String removeOption = "//div[@class='media-ellipses-menu-container open']//div[@class='media-ellipses-option'][3]";
        String deleteButton = "//div[@class='button-row']//button[@class='dark']";
        WebElement videoDots = waitForDisplayedAndEnabled(By.xpath(String.format(video,videoName)),"Three dots next to video specified");
        videoDots.click();
        WebElement removeVideo = waitForDisplayedAndEnabled(By.xpath(removeOption),"Remove button for Video");
        removeVideo.click();
        WebElement deleteConfirmButton = waitForDisplayedAndEnabled(By.xpath(deleteButton),"Delete button from the Delete video confirmation modal");
        deleteConfirmButton.click();
        sleep(3);
    }

    public void uploadMedia(String mediaType, String mediaName, String productName){
       // sleep(5);
        String inputTag = "//input[@id='file-input']";
        String uploading = "//button[contains(@class,'uploading')]";
        WebElement fileUpload  = webDriver.findElement(By.xpath(inputTag));
        uploadFile(mediaType,mediaName,fileUpload,productName);
        elementIsNotPresent(By.xpath(uploading));
        sleep(5);
    }

    public void clickOnFilesTab(){
        String imagesTab= "(//div[contains(@class,'sliding-menu-option')])[2]";
        WebElement imagesTabInBuilderMode = waitForDisplayedAndEnabled(By.xpath(imagesTab),"Images Tab in Show Builder Mode");
        imagesTabInBuilderMode.click();
    }

    public void dragAndDropMediaOnFeed(String mediaName,int feedNo){
        String source = "//p[text()='%s']/..//parent::div/.//parent::div[@class='media-link']";
        switch (feedNo)
        {
            case 1:
                String destination1="//div[@data-rbd-droppable-id='feed-placeholder-0']";
                WebElement mediaLocation = waitForDisplayedAndEnabled(By.xpath(String.format(source,mediaName)),"Media that needs to dragged into Canvas");
                WebElement canvas1Destination = waitForDisplayedAndEnabled(By.xpath(destination1),"Media that needs to dragged into Canvas");
                dragAndDrop(mediaLocation,canvas1Destination);
                sleep(5);
                break;

            case 2:
                String destination2 = "(//div[@class='video-container-presenter second'])[1]";
                WebElement mediaLocation1 = waitForDisplayedAndEnabled(By.xpath(String.format(source,mediaName)),"Media that needs to dragged into Canvas");
                WebElement canvas1Destination1 = waitForDisplayedAndEnabled(By.xpath(destination2),"Media that needs to dragged into Canvas");
                dragAndDrop(mediaLocation1,canvas1Destination1);
                sleep(5);
                break;
            default:
                log.info("Feed not present on canvas");

        }
    }

    public void clickOnOverlaysTab(){
        String overlays = "(//div[contains(@class,'sliding-menu-option')])[4]";
        WebElement overlayTab = waitForDisplayedAndEnabled(By.xpath(overlays),"overlays Tab in Show Builder Mode");
        overlayTab.click();
    }

    public void dragAndDropOverlaysOnTheFeed(String mediaName){
        String source = "//p[text()='%s']/..//parent::div/.//parent::div[@class='media-link']";
        String destination1="//div[@data-rbd-droppable-id='feed-area-media-0']";
        WebElement mediaLocation = waitForDisplayedAndEnabled(By.xpath(String.format(source,mediaName)),"Media that needs to dragged into Canvas");
        WebElement canvas1Destination = waitForDisplayedAndEnabled(By.xpath(destination1),"Media that needs to dragged into Canvas");
        dragAndDrop(mediaLocation,canvas1Destination);
        sleep(5);
    }

    public void addBuildInAnimation(String animationName){
        sleep(2);
        String dropdownArrow = "(//span[@class='select-label dropdown'])[1]";
        WebElement dropdownArrowOpen = waitForDisplayedAndEnabled(By.xpath(dropdownArrow), "Build in animation drop down");
        sleep(2);
        dropdownArrowOpen.click();
        String dropDownOptions = "//div[contains(@class,'select-body open drop')]//div[contains(@class,'select-option')]//label";
        clickOnElementFromDropDown(dropDownOptions,animationName);
        sleep(3);
    }

    public void addBuildInAnimationEffect(String effectName){
        String dropdownArrow = "(//span[@class='select-label dropdown'])[2]";
        WebElement dropdownArrowOpen = waitForDisplayedAndEnabled(By.xpath(dropdownArrow), "Effect in Build in animation drop down");
        sleep(2);
        dropdownArrowOpen.click();
        sleep(2);
        String dropDownOptions = "//div[contains(@class,'select-body open drop')]//div[contains(@class,'select-option')]";
        clickOnElementFromDropDown(dropDownOptions,effectName);
        sleep(2);
    }

    public void addBuildInAnimationDuration(String duration){
        String dropdownArrow = "(//span[@class='select-label dropdown'])[3]";
        WebElement dropdownArrowOpen = waitForDisplayedAndEnabled(By.xpath(dropdownArrow), "Effect in Build in animation drop down");
        dropdownArrowOpen.click();
        sleep(1);
        String dropDownOptions = "//div[contains(@class,'select-body open')]//div[contains(@class,'select-option')]";
        clickOnElementFromDropDown(dropDownOptions,duration);
        sleep(1);
    }

    public void previewAnimation(){
        String preview = "(//div[@class='preview-button'])[1]";
        WebElement previewButton = waitForDisplayedAndEnabled(By.xpath(preview), "Preview button");
        previewButton.click();
        sleep(10);
    }
}
