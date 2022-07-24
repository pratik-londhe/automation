package com.brandlive.qa.automation.greenroom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class ListView extends Base {

	public Boolean checkListViewDisplayed() {
		
		String strListViewSvgXpath = "//*[name()='svg' and @id='icon-list']";
		WebElement listViewSvg = waitForDisplayedAndEnabled(By.xpath(strListViewSvgXpath), "List View On");
		String strPeriodTypeXpath = "//div[@class='select-small']";
		return listViewSvg.isDisplayed() && !elementPresent(By.xpath(strPeriodTypeXpath));
	}
	
	public void selectListView() {		
		String strPeriodTypeXpath = "//div[@class='select-small']";
		if(elementPresent(By.xpath(strPeriodTypeXpath))) {
			//String strListViewSvgXpath = "//*[name()='svg' and @id='icon-list']"; //*[name()='svg' and @id='icon-list']//parent::span
			//String strListViewSvgXpath = "//div[@class='calendar-switch-container']/span[2]";
			String strListViewSvgXpath = "//label[@class='switch-container']";
			WebElement listViewSvg = waitForDisplayedAndEnabled(By.xpath(strListViewSvgXpath), "List View On");
			//listViewSvg.click();
			javascriptExecutorClick(listViewSvg);
			//listViewSvg.sendKeys(Keys.ENTER);

//			sendKeys(By.xpath("//input[@placeholder='Search']"), standardWaitInSeconds(), ""+Keys.ENTER);
//			clickOn(By.xpath("//span[@class='search-icon']"), standardWaitInSeconds());
//			clickOn(By.xpath("//input[@placeholder='Search']"), standardWaitInSeconds());

//			//String something = "//*[name()='svg' and @id='icon-calendar']//parent::span/following-sibling::span";
//			String something = "//div[@class='calendar-switch-container']/span[2]";
//			if(elementIsPresent(By.xpath(something)).apply(webDriver)) {
//				ExpectedCondition<WebElement> el = elementToBeClickable(By.xpath(something));
//				el.apply(webDriver).click();
//			}
//			//clickOn(By.xpath(something), standardWaitInSeconds());
		}		
	}
}
