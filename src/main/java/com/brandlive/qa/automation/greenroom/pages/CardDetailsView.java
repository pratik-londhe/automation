package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

import java.util.List;

public class CardDetailsView extends Base {
	
	public void enterGRAtLiveView() {
		String strJoinButtonXpath = "//button[@class='join-button is-live']";
		WebElement joinButton = waitForDisplayedAndEnabled(By.xpath(strJoinButtonXpath), "Join Button");
		joinButton.click();
	}

	public void openAddSessionModal(){
		String addButton = "(//div[@class='section-buttons']//span[@class='text-green'])[2]";
		WebElement addSessionButton = waitForDisplayedAndEnabled(By.xpath(addButton), "Add Button");
		addSessionButton.click();
	}

	public void addSession(String sessionType){
		String dropdownArrow = "//div[@class='info-modal-show-session']//span[@class='select-label dropdown']";
		WebElement dropdownArrowOpen = waitForDisplayedAndEnabled(By.xpath(dropdownArrow), "Session type drop down");
		dropdownArrowOpen.click();
		String dropDownOptions = "//div[@class='info-modal-show-session']//div[contains(@class,'select-body')]//div[contains(@class,'select-option')]";
		clickOnElementFromDropDown(dropDownOptions,sessionType);
		sleep(1);
		String save = "//div[@class='info-modal-buttons']//button[@class='info-green']";
		WebElement saveButton = waitForDisplayedAndEnabled(By.xpath(save), "Save button");
		saveButton.click();
		sleep(1);
	}

	public void updateSessionName(){
		String ellipsesMenu = "(//div[@class='edit-ellipses-container'])[1]";
		WebElement dropdownArrowOpen = waitForDisplayedAndEnabled(By.xpath(ellipsesMenu), "ellipses Menu");
		dropdownArrowOpen.click();
		String edit = "//div[contains(@class,'active edit-ellipses-menu')]//button[@class='option text-highlight']";
		WebElement editButton = waitForDisplayedAndEnabled(By.xpath(edit), "edit Button");
		editButton.click();
		String sessionName = "//div[@class='input-body']//input[@type='text']";
		WebElement sessionNameInputField = waitForDisplayedAndEnabled(By.xpath(sessionName), "session Name Input Field");
		sessionNameInputField.sendKeys("_updatedSessionName");
		String save = "//div[@class='info-modal-buttons']//button[@class='info-green']";
		WebElement saveButton = waitForDisplayedAndEnabled(By.xpath(save), "Save button");
		saveButton.click();
	}

	public void deleteAllSessions(){
		String sessionList = "(//div[@class='edit-ellipses-container'])[1]";
		WebElement sessionListButton = waitForDisplayedAndEnabled(By.xpath(sessionList), "ellipses Menu");
		sessionListButton.click();
		deleteSession();
	}

	public void deleteSession(){
		String delete = "//div[contains(@class,'active edit-ellipses-menu')]//button[@class='option text-warning']";
		WebElement deleteButton = waitForDisplayedAndEnabled(By.xpath(delete), "delete Button");
		deleteButton.click();
		String confirmDelete = "//button[@class='info-gray remove']";
		WebElement confirmDeleteButton = waitForDisplayedAndEnabled(By.xpath(confirmDelete), "delete Button");
		confirmDeleteButton.click();
	}

	public boolean validateSessionDeleted(){
		boolean result = false;
		String sessionList = "//div[@class='event-row']";
		List<WebElement> webElements = webDriver.findElements(By.xpath(sessionList));
		if(webElements.size()<=1){
			result = true;
		}
		return result;
	}

}


