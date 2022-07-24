package com.brandlive.qa.automation.greenroom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class CalendarView extends Base {
	
	public Boolean checkCalendarViewDisplayed() {
		
		String strCalViewSvgXpath = "//*[name()='svg' and @id='icon-calendar']";
		WebElement calViewSvg = waitForDisplayedAndEnabled(By.xpath(strCalViewSvgXpath), "Calendar View On");
		String strPeriodTypeXpath = "//div[@class='select-small']";
		return calViewSvg.isDisplayed() && elementPresent(By.xpath(strPeriodTypeXpath));
	}
	
	public void selectCalendarView() {
		String strPeriodTypeXpath = "//div[@class='select-small']";
		if(!elementPresent(By.xpath(strPeriodTypeXpath))) {
			//String strCalViewSvgXpath = "//*[name()='svg' and @id='icon-calendar']";
			String strCalViewSvgXpath = "//label[@class='switch-container checked']";
			WebElement calViewSvg = waitForDisplayedAndEnabled(By.xpath(strCalViewSvgXpath), "Calendar View On");
			//calViewSvg.click();
			javascriptExecutorClick(calViewSvg);
		}	
	}
	
	public void selectDifferentCalView(String calView) {
		String strPeriodTypeXpath = "//div[@class='select-small']";
		if(elementPresent(By.xpath(strPeriodTypeXpath))) {
			String strCalViewDropdownArrowXpath = "//*[name()='svg' and @id='icon-keyboard-arrow-down']";
			WebElement calViewDropdownArrow = waitForDisplayedAndEnabled(By.xpath(strCalViewDropdownArrowXpath), "Calendar View Selection"
					+ "Dropdown Arrow");
			calViewDropdownArrow.click();
			String strCalViewDropdownLabelXpath = "//div[@class='select-body open']//label";
			List<WebElement> calViewDropdownLabels = webDriver.findElements(By.xpath(strCalViewDropdownLabelXpath));
			for(WebElement calViewDropdownLabel : calViewDropdownLabels) {
				if(calViewDropdownLabel.getText().equals(calView)) {
					//calViewDropdownLabel.click();
					javascriptExecutorClick(calViewDropdownLabel);
					//calViewDropdownLabel.sendKeys(Keys.ENTER);
				}
			}
		}
	}
	
	public String classAttributeValueOfCalendarPlugin() {
		
		String strCalPluginXpath = "//div[@id='fc-calendar-plugin']";
		return waitForDisplayedAndEnabled(By.xpath(strCalPluginXpath), "Calendar Plugin").getAttribute("Class");
		
	}

	public void searchAndNavigateToShowDetailsPage(){
		String searchBox = "//div[@class='search-field']//input";
		String detailsArrow = "//h4[contains(text(),'%s')]/./parent::div[@class='event-titles']//following-sibling::div[@class='presenters-actions']//button[contains(@class,'details-button')]";
		WebElement searchBoxText = waitForDisplayedAndEnabled(By.xpath(searchBox), "Search Box");
		searchBoxText.sendKeys(eventName);
		sleep(2);
		WebElement detailsArrowButton = waitForDisplayedAndEnabled(By.xpath(String.format(detailsArrow,eventName)), "Details arrow button");
		detailsArrowButton.click();
		sleep(2);
	}

	public void searchAndNavigateToShowDetailsPage(String eventName){
		String searchBox = "//div[@class='search-field']//input";
		//String detailsArrow = "//h4[contains(text(),'%s')]/./parent::div[@class='event-titles']//following-sibling::div[@class='presenters-actions']//button[contains(@class,'details-button')]";
		String detailsArrow = "//h4[contains(text(),'%s')]/./parent::div[@class='event-titles']//following-sibling::div[contains(@class,'presenters-actions')]//button[contains(@class,'details-button')]";
		WebElement searchBoxText = waitForDisplayedAndEnabled(By.xpath(searchBox), "Search Box");
		searchBoxText.sendKeys(eventName);
		sleep(2);
		WebElement detailsArrowButton = waitForDisplayedAndEnabled(By.xpath(String.format(detailsArrow,eventName)), "Details arrow button");
		detailsArrowButton.click();
		sleep(2);
	}
}
