package com.brandlive.qa.automation.events2.pages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class Event2CreationAtDashboard extends Base {
	
	public Boolean checkChannelSelectedInEvents2() {
		log.debug("checking channel in events... ");
		Boolean channelSelected = false;
		WebElement menuButton = webDriver.findElement(By.xpath("//a[@class='global-menu-btn']"));
		menuButton.click();
		WebElement channelText = webDriver.findElement(By.xpath("//a[@class='global-menu-client']"));
		if(channelText.getText().equalsIgnoreCase(blSubscription.getChannelName())) {
			WebElement menuCloseButton = webDriver.findElement(By.xpath("//a[@class='global-menu-btn active']"));
			menuCloseButton.click();
			channelSelected = true;
			sleep();
		}
		return channelSelected;
	}
	
	public void openMenuAndSelectChannelInEvents2() {
		if(elementPresent(By.xpath("//nav[contains(@class, 'active')]"))) {
			selectChannelInEvents2();
		} else {
			WebElement menuButton = webDriver.findElement(By.xpath("//a[@class='global-menu-btn']"));
			menuButton.click();
			selectChannelInEvents2();
		}
	}
	
	private void selectChannelInEvents2() {
		WebElement channelDD = webDriver.findElement(By.xpath("//i[contains(@class, 'fa-angle-down')]"));
		channelDD.click();
		WebElement divActive = webDriver.findElement(By.xpath("//div[contains(@class, 'popover active')]"));
		sleep(3);
		if(divActive.isDisplayed()) {
			List<WebElement> els = webDriver.findElements(By.xpath("(//ul[contains(@class, 'options')])[1]/li"));
			for(WebElement el : els) {
				if(el.getText().equalsIgnoreCase(blSubscription.getChannelName())) {
					el.click();
					break;
				}
			}
		}
	}
	
	public void createEvent2() {
		log.debug("creating event... ");
		WebElement createButton = webDriver.findElement(By.xpath("//button[@class='small primary']"));
		createButton.click();
		WebElement iconCalendar = webDriver.findElement(By.xpath("(//i[@class='icon-calendar'])[2]"));
		iconCalendar.click();
		WebElement createEventModal = webDriver.findElement(By.xpath("//div[@class='modal small create-modal']"));
		sleep(5);
		if(createEventModal.isDisplayed()) {
			WebElement eventNameText = webDriver.findElement(By.xpath("//input[contains(@placeholder, 'Example:')]"));
			int a = (int)(Math.random() * 1000);
			DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
			LocalDateTime dt = LocalDateTime.now();
			eventName = "Automation Event " + a + " " + FOMATTER.format(dt);
			eventNameText.sendKeys(eventName);
			WebElement getStartedButton = webDriver.findElement(By.xpath("(//button[@class='small primary'])[2]"));
			getStartedButton.click();
		}
		WebElement settingsSection = webDriver.findElement(By.xpath("//section[@class='tab-nav']/a[3]"));
		settingsSection.click();	
		WebElement dateText = webDriver.findElement(By.id("broadcast_date_text"));
		dateText.sendKeys(dateMethod()+Keys.TAB);
		timeCompoElement("h");
		timeCompoElement("mm");
		timeCompoElement("a");
		WebElement durationText = webDriver.findElement(By.xpath("//input[@class='large ng-untouched ng-pristine ng-valid']"));
		durationText.clear();
		durationText.sendKeys("15");		
	}
	
	public void publishEvent2() {
		//WebElement publishButton = waitForDisplayedAndEnabled(By.xpath("//button[@class='small action']"),"Publish event button");
		javascriptExecutorClick(webDriver.findElement(By.xpath("//button[@class='small action']")));
		//publishButton.click();
		WebElement publishEventModal = webDriver.findElement(By.xpath("//div[@class='modal small']"));
		sleep(5);
		if(publishEventModal.isDisplayed()) {
			WebElement publishEventButton = webDriver.findElement(By.xpath("(//button[@class='small action'])[2]"));
			publishEventButton.click();
		}
	}
	
	private String dateMethod() {
	  	DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.now();
		return FOMATTER.format(date);
	}
	
	private String timeMethod(String compo) {
		DateTimeFormatter FOMATTER = null;
		LocalTime time = null;
		if(compo.equalsIgnoreCase("h")) {
			FOMATTER = DateTimeFormatter.ofPattern("h");
			time = LocalTime.now().plusMinutes(30);
			return  FOMATTER.format(time);
		} else if (compo.equalsIgnoreCase("mm")) {
			FOMATTER = DateTimeFormatter.ofPattern("mm");
			time = LocalTime.now().plusMinutes(30);
			String timeStr = FOMATTER.format(time);
			if(Integer.parseInt(timeStr) > 0 && Integer.parseInt(timeStr) <= 5) {
				return "05";
			} else if (Integer.parseInt(timeStr) > 5 && Integer.parseInt(timeStr) <= 10) {
				return "10";
			} else if (Integer.parseInt(timeStr) > 10 && Integer.parseInt(timeStr) <= 15) {
				return "15";
			} else if (Integer.parseInt(timeStr) > 15 && Integer.parseInt(timeStr) <= 20) {
				return "20";
			} else if (Integer.parseInt(timeStr) > 20 && Integer.parseInt(timeStr) <= 25) {
				return "25";
			} else if (Integer.parseInt(timeStr) > 25 && Integer.parseInt(timeStr) <= 30) {
				return "30";
			} else if (Integer.parseInt(timeStr) > 30 && Integer.parseInt(timeStr) <= 35) {
				return "35";
			} else if (Integer.parseInt(timeStr) > 35 && Integer.parseInt(timeStr) <= 40) {
				return "40";
			} else if (Integer.parseInt(timeStr) > 40 && Integer.parseInt(timeStr) <= 45) {
				return "45";
			} else if (Integer.parseInt(timeStr) > 45 && Integer.parseInt(timeStr) <= 50) {
				return "50";
			} else if (Integer.parseInt(timeStr) > 50 && Integer.parseInt(timeStr) <= 55) {
				return "55";
			} else if (Integer.parseInt(timeStr) > 55 && Integer.parseInt(timeStr) <= 59) {
				return "55";
			}
			return  "55";
		} else {
			FOMATTER = DateTimeFormatter.ofPattern("a");
			time = LocalTime.now().plusMinutes(30);
			return  FOMATTER.format(time);
		}
	}
	
	private void timeCompoElement(String compo) {
		List<WebElement> els = null;
		if(compo.equalsIgnoreCase("h")) {
			els = webDriver.findElements(By.xpath("(//select)[1]/option"));
		} else if (compo.equalsIgnoreCase("mm")) {
			els = webDriver.findElements(By.xpath("(//select)[2]/option"));
		} else {
			els = webDriver.findElements(By.xpath("(//select)[3]/option"));
		}
		log.debug("Count: " + els.size());
		for(WebElement el : els) {
			log.debug(el.getText());
			log.debug(timeMethod(compo));
			if(timeMethod(compo).equalsIgnoreCase(el.getText())) {
				el.click();
				break;
			}
		}
	}

}
