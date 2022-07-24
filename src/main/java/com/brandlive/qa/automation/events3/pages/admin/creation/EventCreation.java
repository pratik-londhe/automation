package com.brandlive.qa.automation.events3.pages.admin.creation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.brandlive.qa.automation.events3.pages.admin.EventTemplateSelection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.brandlive.qa.automation.utils.Base;

public class EventCreation extends Base {
    public static String nameOfRoom;

    public void createEventWithMultipleSessions() {
        log.info("creating multiple session event...");
        int a = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        eventName = "Automation " + EventTemplateSelection.selectedTemplateName + " Event " + a + " " + FOMATTER.format(dt);
        WebElement nameText = webDriver.findElement(By.xpath("//input[@class='evt-field-input']"));
        nameText.sendKeys(eventName);
        WebElement addSessionLink = webDriver.findElement(By.xpath("//button[@class='add-session']"));
        addSessionLink.click();
        addOnDemandSession();
        addSessionLink.click();
        addBroadcastSession();
        WebElement addEventButton = webDriver.findElement(By.xpath("//button[@class='primary create-event-continue']"));
        addEventButton.click();
        setEventAvailability(true);
        sleep(10);
    }

    private void addBroadcastSession() {
        WebElement addSessionModal = webDriver.findElement(By.xpath("//div[@class='modal normal']"));
        sleep(3);
        if (addSessionModal.isDisplayed()) {
            int random = (int) (Math.random() * 10) + 1;
            String nameOfSession = "Broadcast Session " + random;
            WebElement sessionNameInput = webDriver.findElement(By.xpath("(//input[@class='evt-field-input'])[2]"));
            sessionNameInput.sendKeys(nameOfSession);
            DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
            LocalDateTime dt = LocalDateTime.now();
            String datetimeStr = FOMATTER.format(dt.plusMinutes(15));
            WebElement datetimeInput = webDriver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/input"));
            int i = 0;
            while (i <= 19) {
                datetimeInput.sendKeys(Keys.BACK_SPACE);
                i++;
            }
            datetimeInput.sendKeys(datetimeStr);
//			WebElement broadcastRadio = webDriver.findElement(By.xpath("(//div[@class='field-group radio-group']//div[@class='radio'])[2]"));
//			broadcastRadio.click();
            webDriver.findElement(By.xpath("//h4[@class='modal-title']")).click();
            WebElement durationInput = webDriver.findElement(By.xpath("//div[@class='timepicker-input']/input"));
            durationInput.clear();
            durationInput.sendKeys("15");
            WebElement addButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
            addButton.click();
            sleep(5);
        }
    }

    private void addOnDemandSession() {
        WebElement addSessionModal = webDriver.findElement(By.xpath("//div[@class='modal normal']"));
        sleep(3);
        if (addSessionModal.isDisplayed()) {
            webDriver.findElement(By.xpath("//span[@class='arrow']")).click();
            WebElement onDemandSelector = webDriver.findElement(By.xpath("(//div[@class='session-type-selector open']//label)[1]"));
            onDemandSelector.click();
            int random = (int) (Math.random() * 10) + 1;
            String nameOfSession = "On Demand Session " + random;
            WebElement sessionNameInput = webDriver.findElement(By.xpath("(//input[@class='evt-field-input'])[2]"));
            sessionNameInput.sendKeys(nameOfSession);
//			WebElement onDemandRadio = webDriver.findElement(By.xpath("(//div[@class='field-group radio-group']//div[@class='radio'])[1]"));
//			onDemandRadio.click();
            WebElement addButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
            addButton.click();
            sleep(5);
        }
    }

    public void createEventWithOnDemandSession(Boolean setEA, Boolean addLP) {
        log.info("creating single session event...");
        int a = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        eventName = "Automation " + EventTemplateSelection.selectedTemplateName + " Event " + a + " " + FOMATTER.format(dt);
        WebElement nameText = webDriver.findElement(By.xpath("//input[@class='evt-field-input']"));
        nameText.sendKeys(eventName);
        WebElement addSessionLink = webDriver.findElement(By.xpath("//button[@class='add-session']"));
        addSessionLink.click();
        addOnDemandSession();
        WebElement addEventButton = webDriver.findElement(By.xpath("//button[@class='primary create-event-continue']"));
        addEventButton.click();
        setEventAvailability(setEA);
        addLandingPage(addLP);
        sleep(10);
    }

    private void setEventAvailability(Boolean register) {
        WebElement addSessionModal = webDriver.findElement(By.xpath("//div[@class='modal normal']"));
        sleep(3);
        if (addSessionModal.isDisplayed()) {
            if (!register) {
                WebElement openRadio = webDriver.findElement(By.xpath("//label[@for='registration-off']"));
                openRadio.click();
            } else {
                WebElement registerRadio = webDriver.findElement(By.xpath("//label[@for='registration-on']"));
                registerRadio.click();
            }
            WebElement nextButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
            nextButton.click();
            sleep(3);
        }
    }

    private void addLandingPage(Boolean lp) {
        WebElement addSessionModal = webDriver.findElement(By.xpath("//div[@class='modal normal']"));
        sleep(3);
        if (addSessionModal.isDisplayed()) {
            if (!lp) {
                WebElement noLPRadio = webDriver.findElement(By.xpath("//label[@for='homepage-off']"));
                noLPRadio.click();
            } else {
                WebElement yesLPRadio = webDriver.findElement(By.xpath("//label[@for='homepage-on']"));
                yesLPRadio.click();
            }
            WebElement nextButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
            nextButton.click();
            sleep(3);
        }
    }

    public void createEventWithSingleBroadcastSession(Boolean setEA, Boolean addLP) {
        log.info("Creating single broadcast session open event...");
        int a = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        eventName = "Automation " + EventTemplateSelection.selectedTemplateName + " Event " + a + " " + FOMATTER.format(dt);
        WebElement nameText = webDriver.findElement(By.xpath("//input[@class='evt-field-input']"));
        nameText.sendKeys(eventName);
        WebElement addSessionLink = webDriver.findElement(By.xpath("//button[@class='add-session']"));
        addSessionLink.click();
        addBroadcastSession();
        WebElement addEventButton = webDriver.findElement(By.xpath("//button[@class='primary create-event-continue']"));
        addEventButton.click();
        setEventAvailability(setEA);
        addLandingPage(addLP);
        sleep(10);
    }

    private void addBreakOutV2Session() {
        WebElement addSessionModal = webDriver.findElement(By.xpath("//div[@class='modal normal']"));
        sleep(3);
        webDriver.findElement(By.xpath("//span[@class='arrow']")).click();
        WebElement breakoutSelector = webDriver.findElement(By.xpath("(//div[@class='session-type-selector open']//label)[3]"));
        breakoutSelector.click();
        if (addSessionModal.isDisplayed()) {
            int random = (int) (Math.random() * 10) + 1;
            String nameOfSession = "Breakout V2 Session " + random;
            WebElement sessionNameInput = webDriver.findElement(By.xpath("(//input[@class='evt-field-input'])[2]"));
            sessionNameInput.sendKeys(nameOfSession);
            DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
            LocalDateTime dt = LocalDateTime.now();
            String datetimeStr = FOMATTER.format(dt.plusMinutes(10));
            WebElement datetimeInput = webDriver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/input"));
            int i = 0;
            while (i <= 19) {
                datetimeInput.sendKeys(Keys.BACK_SPACE);
                i++;
            }
            datetimeInput.sendKeys(datetimeStr);
            webDriver.findElement(By.xpath("//h4[@class='modal-title']")).click();
            WebElement durationInput = webDriver.findElement(By.xpath("//div[@class='timepicker-input']/input"));
            durationInput.clear();
            durationInput.sendKeys("15");
            WebElement addButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
            addButton.click();
            sleep(5);
        }
    }

    public void addBreakOutV2SessionWithTwoRooms() {
        log.info("Creating Breakout V2 session...");
        int a = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        eventName = "Automation " + EventTemplateSelection.selectedTemplateName + " Event " + a + " " + FOMATTER.format(dt);
        WebElement nameText = webDriver.findElement(By.xpath("//input[@class='evt-field-input']"));
        nameText.sendKeys(eventName);
        WebElement addSessionLink = webDriver.findElement(By.xpath("//button[@class='add-session']"));
        addSessionLink.click();
        addBreakOutV2Session();
        createMultipleBreakOutRooms(1);
        setMaximumUsers(10);
        WebElement saveButton = webDriver.findElement(By.xpath("(//button[@class='primary'])[2]"));
        saveButton.click();
        log.info("Clicked on the save button");
        WebElement addEventButton = webDriver.findElement(By.xpath("//button[@class='primary create-event-continue']"));
        javascriptExecutorClick(addEventButton);
        sleep(3);
        WebElement regToggleDisabled = webDriver.findElement(By.xpath("//div[@class='registration-toggles disabled']"));
        if (regToggleDisabled.isDisplayed()) {
            log.info("Registration toggle is selected and disabled by default.");
        }
        WebElement nextButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
        nextButton.click();
        addLandingPage(true);
        sleep(10);
    }

    private void createMultipleBreakOutRooms(int rooms) {
        String zoomPoweredToggleOff = "//div[@class='field-group switch']//div[@class='form-control switch']";
        String zoomPoweredToggleOn = "//div[@class='field-group switch']//div[@class='form-control switch on']";
        String addRoom = "//button[@class='clear no-style button-plain breakout-rooms-button']";

        WebElement zoomPoweredToggleOffButton = waitForDisplayedAndEnabled(By.xpath(zoomPoweredToggleOff), "Zoom powered Toggle button on the Add Session Page.");
        if (zoomPoweredToggleOffButton.isDisplayed()) {
            log.info("The Zoom breakout is Off and breakout V2 is On");
        } else {
            WebElement zoomPoweredToggleOnButton = waitForDisplayedAndEnabled(By.xpath(zoomPoweredToggleOn), "Zoom powered Toggle button on the Add Session Page.");
            zoomPoweredToggleOnButton.click();
            log.info("Enabled the breakout V2 and off the Zoom.");
        }
        sleep(3);
        log.info("Add the multiple rooms to the breakout session.");
        WebElement addRoomButton = waitForDisplayedAndEnabled(By.xpath(addRoom), "Add Room button on the breakout page.");
        for (int i = 1; i <= rooms; i++) {
            if (addRoomButton.isDisplayed()) {
                addRoomButton.click();
                log.info("Created breakout room: " + i);
            }
        }
        List<WebElement> textRoomsName = webDriver.findElements(By.xpath("//input[@placeholder='Give your room a name']"));
        log.info("Give the name to the multiple rooms.");
        for (WebElement room : textRoomsName) {
            int random = (int) (Math.random() * 10) + 1;
            nameOfRoom = "Breakout V2 Room " + random;
            if (room.isDisplayed()) {
                room.sendKeys(nameOfRoom);
                log.info("Entered the room name.");
                sleep(4);
            }
        }
    }

    private void setMaximumUsers(int noOfUsers) {
        List<WebElement> maxUserDropDown = webDriver.findElements(By.xpath("//span[@class='ev-icon-keyboard-arrow-down icon-white']"));
        String users = "(//div[@class='select-dropdown open']//span)" + "[" + noOfUsers + "]";

        log.info("Select multiple users.");
        for (WebElement userDropDown : maxUserDropDown) {
            if (userDropDown.isDisplayed()) {
                userDropDown.click();
                log.info("Clicked on the drop down.");
                clickOn(By.xpath(users), 5);
                log.info("Set the users to the room.");
            }
        }
    }

    public void addOnDemandSessionOnEventTab() {
        WebElement addSessionModal = webDriver.findElement(By.xpath("//div[@class='modal normal']"));
        sleep(3);
        if (addSessionModal.isDisplayed()) {
            webDriver.findElement(By.xpath("//span[@class='arrow']")).click();
            WebElement onDemandSelector = webDriver.findElement(By.xpath("(//div[@class='session-type-selector open']//label)[1]"));
            onDemandSelector.click();
            int random = (int) (Math.random() * 10) + 1;
            String nameOfSession = "On Demand Session " + random;
            WebElement sessionNameInput = webDriver.findElement(By.xpath("//input[@class='evt-field-input']"));
            sessionNameInput.sendKeys(nameOfSession);
//			WebElement onDemandRadio = webDriver.findElement(By.xpath("(//div[@class='field-group radio-group']//div[@class='radio'])[1]"));
//			onDemandRadio.click();
            WebElement addButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
            addButton.click();
            sleep(5);
        }
    }

    public void createEventWithMultiBroadcastSession(Boolean setEA, Boolean addLP, String language) {
        log.info("Creating multi broadcast session open event...");
        int a = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        eventName = "Automation " + EventTemplateSelection.selectedTemplateName + " Event " + a + " " + FOMATTER.format(dt);
        WebElement nameText = webDriver.findElement(By.xpath("//input[@class='evt-field-input']"));
        nameText.sendKeys(eventName);
        String addSession = "//button[@class='add-session']";
        WebElement addSessionLink = waitForDisplayedAndEnabled(By.xpath(addSession), "Add Session button");
        addSessionLink.click();
        addBroadcastSession();
        addSessionLink.click();
        addBroadcastSession();
        addOtherLanguagesToSession(language);
        WebElement addEventButton = webDriver.findElement(By.xpath("//button[@class='primary create-event-continue']"));
        addEventButton.click();
        setEventAvailability(setEA);
        sleep(10);
    }

    private void addOtherLanguagesToSession(String language) {
        List<WebElement> editSessions = webDriver.findElements(By.xpath("//*[name()='svg' and @id='icon-three-dots-vertical']"));
        String editSession = "//div[@class='navdrop-list session-menu-dropdown']//button[1]";
        log.info("Select language for the session.");
        for (WebElement editIcon : editSessions) {
            if (editIcon.isDisplayed()) {
                editIcon.click();
                log.info("Clicked on the edit session icon.");
                WebElement editSessionLink = waitForDisplayedAndEnabled(By.xpath(editSession), "Edit Session link.");
                editSessionLink.click();
                chooseLanguageFromDropDown(language);
                log.info("Added the language to the session.");
            }
        }
    }

    private void chooseLanguageFromDropDown(String language) {
        log.info("Choose language for the session.");
        String selectLanguage = "//input[@placeholder='Select languages']";
        String langCheckbox = "//*[name()='svg' and @id='icon-checkbox']";
        String update = "//button[@class='primary']";
        WebElement selectLanguageText = waitForDisplayedAndEnabled(By.xpath(selectLanguage), "Select Language text field field.");
        selectLanguageText.sendKeys(language);
        sleep(2);
        WebElement languageCheckbox = waitForDisplayedAndEnabled(By.xpath(langCheckbox), "Language checkbox.");
        languageCheckbox.click();
        WebElement updateButton = waitForDisplayedAndEnabled(By.xpath(update), "Update button.");
        javascriptExecutorClick(updateButton);
        log.info("Clicked on the update button.");
        sleep(3);
    }

    private void addFiresideSession() {
        WebElement addSessionModal = webDriver.findElement(By.xpath("//div[@class='modal normal']"));
        sleep(3);
        if (addSessionModal.isDisplayed()) {
            webDriver.findElement(By.xpath("//span[@class='arrow']")).click();
            WebElement firesideSelector = webDriver.findElement(By.xpath("(//div[@class='session-type-selector open']//label)[4]"));
            firesideSelector.click();
            int random = (int) (Math.random() * 10) + 1;
            String nameOfSession = "Fireside Session " + random;
            WebElement sessionNameInput = webDriver.findElement(By.xpath("(//input[@class='evt-field-input'])[2]"));
            sessionNameInput.sendKeys(nameOfSession);
            DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
            LocalDateTime dt = LocalDateTime.now();
            String datetimeStr = FOMATTER.format(dt.plusMinutes(10));
            WebElement datetimeInput = webDriver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/input"));
            int i = 0;
            while (i <= 19) {
                datetimeInput.sendKeys(Keys.BACK_SPACE);
                i++;
            }
            datetimeInput.sendKeys(datetimeStr);
            javascriptExecutorClick(webDriver.findElement(By.xpath("//h4[@class='modal-title']")));
            WebElement durationInput = webDriver.findElement(By.xpath("//div[@class='timepicker-input']/input"));
            durationInput.clear();
            durationInput.sendKeys("15");
            WebElement addButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
            addButton.click();
            sleep(5);
        }
    }

    public void addEventWithFiresideSession(Boolean addLP) {
        log.info("Creating Fireside session...");
        int a = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        eventName = "Automation " + EventTemplateSelection.selectedTemplateName + " Event " + a + " " + FOMATTER.format(dt);
        WebElement nameText = webDriver.findElement(By.xpath("//input[@class='evt-field-input']"));
        nameText.sendKeys(eventName);
        WebElement addSessionLink = webDriver.findElement(By.xpath("//button[@class='add-session']"));
        addSessionLink.click();
        addFiresideSession();
        WebElement addEventButton = webDriver.findElement(By.xpath("//button[@class='primary create-event-continue']"));
        javascriptExecutorClick(addEventButton);
        sleep(3);
        WebElement regToggleDisabled = webDriver.findElement(By.xpath("//div[@class='registration-toggles disabled']"));
        if (regToggleDisabled.isDisplayed()) {
            log.info("Registration toggle is selected and disabled by default.");
        }
        WebElement nextButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
        nextButton.click();
        addLandingPage(addLP);
        sleep(10);
    }

    public void createAllTypesOfSessions() {
        log.info("Creating all types of sessions...");
        int a = (int) (Math.random() * 1000);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime dt = LocalDateTime.now();
        eventName = "Automation " + EventTemplateSelection.selectedTemplateName + " Event " + a + " " + FOMATTER.format(dt);
        WebElement nameText = webDriver.findElement(By.xpath("//input[@class='evt-field-input']"));
        nameText.sendKeys(eventName);
        WebElement addSessionLink = webDriver.findElement(By.xpath("//button[@class='add-session']"));
        addSessionLink.click();
        addBroadcastSession();
        addSessionLink.click();
        addOnDemandSession();
        addSessionLink.click();
        addBreakOutV2Session();
        createMultipleBreakOutRooms(1);
        setMaximumUsers(10);
        WebElement saveButton = webDriver.findElement(By.xpath("(//button[@class='primary'])[2]"));
        saveButton.click();
        log.info("Clicked on the save button");
        addSessionLink.click();
        addFiresideSession();
        WebElement addEventButton = webDriver.findElement(By.xpath("//button[@class='primary create-event-continue']"));
        javascriptExecutorClick(addEventButton);
        sleep(3);
        WebElement regToggleDisabled = webDriver.findElement(By.xpath("//div[@class='registration-toggles disabled']"));
        if (regToggleDisabled.isDisplayed()) {
            log.info("Registration toggle is selected and disabled by default.");
        }
        WebElement nextButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
        nextButton.click();
        sleep(10);
    }
}
