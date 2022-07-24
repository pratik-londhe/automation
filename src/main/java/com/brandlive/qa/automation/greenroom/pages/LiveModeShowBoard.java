package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LiveModeShowBoard extends Base {

    public void playShotInLiveMode(){
        log.info("Click on the play shot.");
        String playShotButton = "//span[contains(@class,'margin-right-small margin-left-small')]";
        WebElement playShotButtonInLiveMode = waitForDisplayedAndEnabled(By.xpath(playShotButton),"Play shot button in Live mode");
        playShotButtonInLiveMode.click();
        sleep(2);
    }
}
