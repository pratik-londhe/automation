package com.brandlive.qa.automation.greenroom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class LiveModeHeader extends Base {
	
	public void exitGRFromLiveView(String url) {
		String strExitGRButtonXpath = "//button[@class='basic header-back-btn']";
		WebElement exitButton = waitForDisplayedAndEnabled(By.xpath(strExitGRButtonXpath), "Exit GR Button");
		exitButton.click();
		getWebDriver().get(url);
	}

	public void enterBuilderMode(){
		String strEnterBuilderModeXpath = "//div[@class='room-state-switch-button showtime']";
		WebElement showBuilderButton = waitForDisplayedAndEnabled(By.xpath(strEnterBuilderModeXpath),"ShowBuilder GR Button");
		showBuilderButton.click();
		sleep(10);
	}

	public void goLive() {
		//String goLive = "//*[name()='svg' and @id='icon-live']";
		String goLive = "(//*[name()='svg' and @id='icon-live'])[1]";
		String gettingReadyOld = "//div[@class='broadcast-status loading']";
		if(elementPresent(By.xpath(gettingReadyOld))) {
			if (elementPresent(By.xpath(gettingReadyOld))) {
				sleep(300);
				webDriver.navigate().refresh();
				sleep(20);
				clickOn(By.xpath(goLive), 30);
			} else {
				clickOn(By.xpath(goLive), 30);
			}
		}else {
			String goLiveStream = "//div[contains(@class,'broadcast-indicator')]";
			String gettingReady = "//div[@class='broadcast-status text-transform-capitalize loading']";
			if (elementPresent(By.xpath(gettingReady))) {
				sleep(300);
				webDriver.navigate().refresh();
				sleep(20);
				clickOn(By.xpath(goLiveStream), 20);
			} else {
				sleep(1);
				clickOn(By.xpath(goLiveStream), 20);
				sleep(10);
			}
		}
		}
}
