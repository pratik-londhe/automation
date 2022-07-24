package com.brandlive.qa.automation.events3.pages.live;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AvatarInfo extends Base {

    public void uploadAvatarDetails(String mediaType, String mediaName, String productName) {
        log.info("Upload Avatar Details...");
        String uploadAvatar = "//input[@type='file']";
        String next = "(//button[@type='submit'])[6]";
        WebElement uploadAvatarProfile = webDriver.findElement(By.xpath(uploadAvatar));
        uploadFile(mediaType, mediaName, uploadAvatarProfile, productName);
        log.info("Uploaded a Avatar profile");
        sleep(5);
        WebElement nextButton = waitForDisplayedAndEnabled(By.xpath(next), "Next button on Avatar page.");
        javascriptExecutorClick(nextButton);
        log.info("Clicked on the submit button.");
        sleep(3);
    }
}