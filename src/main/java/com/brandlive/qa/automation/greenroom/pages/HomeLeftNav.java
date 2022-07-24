package com.brandlive.qa.automation.greenroom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class HomeLeftNav extends Base {
	
	public void selectChannel() {
		String strChannelXpath = "//img[@alt='"+ blSubscription.getChannelName() +"']";
		WebElement channelTab = waitForDisplayedAndEnabled(By.xpath(strChannelXpath), "Channel selection");
		channelTab.click();
	}
	
	public Boolean checkChannelSelected() {
		
		String strChannelDivXpath = "//div[@class='home-sidebar-wrapper flex']/div[contains(@class,'selected')]";
		WebElement channelTabDiv = waitForDisplayedAndEnabled(By.xpath(strChannelDivXpath), "Selected Channel");
		
		return channelTabDiv.getAttribute("data-name").equalsIgnoreCase(blSubscription.getChannelName());
	}

}
