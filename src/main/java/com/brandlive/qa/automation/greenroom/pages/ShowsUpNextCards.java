package com.brandlive.qa.automation.greenroom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class ShowsUpNextCards extends Base {
	
	public void navigateToEventCardDetails() {
		String strCardNameXpath = "//div[@class='card']//h2";
		List<WebElement> els = webDriver.findElements(By.xpath(strCardNameXpath));
		String strDetailsButtonXpath = null;
		if(els.size() > 1) {
			int counter = 1;
			for(WebElement el : els) {
				if(el.getText().equalsIgnoreCase(eventName)) {
					strDetailsButtonXpath = "(//button[@class='details-button'])["+counter+"]";
					break;
				}
				if(strDetailsButtonXpath == null && counter == 2) {
					strDetailsButtonXpath = "(//button[@class='details-button'])[1]";
				}
				counter++;
			}
		} else if (els.size() == 1) {
			strDetailsButtonXpath = "(//button[@class='details-button'])[1]";
		} else {
			reportError("There are no cards on Greenroom Channel Home Page.");
		}
		WebElement detailsButton = webDriver.findElement(By.xpath(strDetailsButtonXpath));
		detailsButton.click();
	}

}
