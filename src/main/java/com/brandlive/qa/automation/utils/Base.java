package com.brandlive.qa.automation.utils;

import java.nio.file.FileSystems;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base extends Doer {

    protected BrandliveSubscription blSubscription = new BrandliveSubscription();
    protected static WebDriver webDriver;
    protected static String eventName;
    private static Boolean loggedInToGreenroomAsProducer = false;
    private static Boolean loggedInToEvents = false;

    protected WebDriver getWebDriver() {
        try {
            if (webDriver == null) {
                webDriver = Connection.currentInstance().getWebDriver();
                sleep(10);
                //return webDriver;
            }
            if (!loggedInToEvents) {
                if (!blSubscription.getGreenroomEntryMode().equalsIgnoreCase("Decoupling")) {
//					String eventsVersion = blSubscription.getGreenroomEntryMode();
//					if(eventsVersion.contains("2.5")) {
//						loginToEventsAsAdmin("2.5");
//					} else {
//						loginToEventsAsAdmin("3.0");
//					}
                }
                loggedInToEvents = true;
            } else if (!loggedInToGreenroomAsProducer) {
//				loginToGreenroomAsProducer(blSubscription.getGreenroomEntryMode());
                loggedInToGreenroomAsProducer = true;
            }
            //login to gr a presenter
            return webDriver;
        } catch (Throwable t) {
            printCallStack(t);
            if (t.getMessage() == null) {
                String errorMsg = "Encountered problem while initializing Selenium and logging to BL as admin user";
                log.error(errorMsg);
                throw new RuntimeException(errorMsg, t);
            } else {
                throw t;
            }
        }
    }

    public void loginToGreenroomAsProducer(String mode) {
        log.info("Log in to Greenroom...");
        String url = blSubscription.getGreenroomUrl();
        String user = blSubscription.getGreenroomUser();
        String password = blSubscription.getGreenroomPassword();
        String greenroomRole = blSubscription.getGreenroomRole();
        if (greenroomRole.contains("Producer")) {
            String producerUrl = url.concat("/producer");
            loginToGreenroomAsProducer(mode, producerUrl, user, password);
        } else {
            reportError("The test is not meant to login to GR as Producer");
        }
    }

    private void loginToGreenroomAsProducer(String mode, String url, String user, String password) {
        log.debug("Log in to Greenroom... ");
        gotoUrl(url);
        WebElement userText = webDriver.findElement(By.xpath("//input[@name='Email']"));
//		WebElement userText = waitForDisplayedAndEnabled(By.xpath("//input[@name='Email']"), "Greenroom Email");
        userText.sendKeys(user);
        WebElement loginButton = webDriver.findElement(By.xpath("//button[contains(@class, 'onboarding producer')]"));
        loginButton.click();
        sleep(3);
        WebElement eventsSpan = null;
        if (mode.contains("2.5")) {
            eventsSpan = webDriver.findElement(By.xpath("(//button[@class='app-button'])[2]"));
        } else if (mode.contains("3.0")) {
            eventsSpan = webDriver.findElement(By.xpath("(//button[@class='app-button'])[1]"));
        } else {
                eventsSpan = webDriver.findElement(By.xpath("(//button[@class='app-button'])[3]"));
        }
        eventsSpan.click();
        sleep(3);
        WebElement passwordText = webDriver.findElement(By.name("Password"));
        passwordText.sendKeys(password);
        loginButton = webDriver.findElement(By.xpath("//button[contains(@class, 'onboarding producer')]"));
        loginButton.click();
        sleep(5);
        webDriver.findElement(By.xpath("//header//button[@class='notification-bell']"));
        log.debug("User logged in to Greenroom... ");
        if (elementPresent(By.xpath("//div[@class='info-modal']"))) {
            waitForDisplayedAndEnabled(By.xpath("//*[@id='icon-close']"), "Close Pop Over").click();
            sleep();
        }
        String strChannelXpath = "//div[@data-name='" + blSubscription.getChannelName() + "']";
        WebElement channelTab = waitForDisplayedAndEnabled(By.xpath(strChannelXpath), "Channel selection");
        channelTab.click();
    }

    public void loginToEventsAsAdmin(String version) {
        log.info("Log in to events...");
        String url = blSubscription.getEventsUrl();
        String user = blSubscription.getEventsUser();
        String password = blSubscription.getEventsPassword();
        loginToEventsAsAdmin(version, url, user, password);
    }

    private void loginToEventsAsAdmin(String version, String url, String user, String password) {
        log.debug("Log in to Events... ");
        if (version.equals("2.5")) {
            gotoUrl(url);
            WebElement userText = webDriver.findElement(By.name("username"));
//			WebElement userText = waitForDisplayedAndEnabled(By.name("username"), "Events 2.5 Username");
            userText.sendKeys(user);
            WebElement passwordText = webDriver.findElement(By.name("password"));
            passwordText.sendKeys(password);
            WebElement loginButton = webDriver.findElement(By.xpath("(//button[@class='large action'])[1]"));
            loginButton.click();
            sleep(5);
        } else {
            gotoUrl(url);
            WebElement userText = webDriver.findElement(By.id("business-email"));
//			WebElement userText = waitForDisplayedAndEnabled(By.id("business-email"), "Events 3.0 Email");
            userText.sendKeys(user);
            WebElement passwordText = webDriver.findElement(By.id("password"));
            passwordText.sendKeys(password);
            WebElement loginButton = webDriver.findElement(By.xpath("//button[@class='primary']"));
            loginButton.click();
            sleep(5);
            waitForDisplayedAndEnabled(By.xpath("//div[@class='events-title']"), "Events Header", 15);
        }
    }

    public void logoutOfEvents(String version) {
        log.debug("Logout of Events... ");
        sleep(5);
        if (version.equals("2.5")) {
            WebElement profileDD = webDriver.findElement(By.xpath("//img[@class='avatar']"));
            profileDD.click();
            WebElement logoutButton = webDriver.findElement(By.xpath("//a[@class='button xsmall']"));
            logoutButton.click();
            sleep(10);
        } else {
            WebElement profileDD = webDriver.findElement(By.xpath("//div[@class='profile-pic']"));
            profileDD.click();
            WebElement logoutButton = webDriver.findElement(By.xpath("//div[@class='profile-details-wrapper open top']//li[4]/button"));
            logoutButton.click();
            sleep(5);
        }
    }

    public void logoutOfGreenroom() {
        sleep(5);
        WebElement profileDD = webDriver.findElement(By.xpath("//div[contains(@class, 'avatar small')]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", profileDD);
        profileDD.click();
        WebElement logoutButton = webDriver.findElement(By.xpath("//div[@class='avatar-options']/button[4]"));
        logoutButton.click();
        WebElement signoutButton = webDriver.findElement(By.xpath("//div[@class='dialog-container right']//button[@class='dark']"));
        signoutButton.click();
        sleep(5);
    }

    protected void gotoUrl(String url) {
        //webDriver.get(url);
        getWebDriver().get(url);
        sleep(20);
    }

    protected WebElement waitForDisplayedAndEnabled(By locator, String description) {
        return waitForDisplayedAndEnabled(locator, description, maximumWaitInSeconds());
    }

    protected WebElement waitForDisplayedAndEnabledMaybe(By locator, String description, int waitTime) {
        return waitForDisplayedAndEnabled(locator, description, waitTime, false);
    }

    protected WebElement waitForDisplayedAndEnabled(By locator, String description, int waitTime) {
        return waitForDisplayedAndEnabled(locator, description, waitTime, true);
    }

    protected WebElement waitForDisplayedAndEnabled(By locator, String description, int waitTime, boolean reportError) {
        return waitForNthDisplayedAndEnabled(1, locator, description, waitTime, reportError);
    }

    protected WebElement waitForNthDisplayedAndEnabled(int n, By locator, String description, int maxSeconds,
                                                       boolean reportError) {
        float seconds = 0;
        while (seconds < maxSeconds) {
            try {
                return findNthDisplayedAndEnabled(n, locator, description);
            } catch (Exception e) {
                log.debug(afterWaitingFor(seconds) + " " + description + " is still loading.");
                seconds += sleep();
            }
        }
        String errorMsg = "Failed to find " + description + " in " + maxSeconds + secondOrSeconds(maxSeconds);
        if (reportError) {
            reportError(errorMsg);
        } else {
            throw new NoSuchElementException(errorMsg);
        }
        return null; // keep compiler happy, but reportError will always prevent this line from executing
    }

    protected WebElement findNthDisplayedAndEnabled(int n, By locator, String description) {
        log.debug("Looking for #" + n + " displayed and enabled " + description + " (" + locator + ')');
        //return nthDisplayedAndEnabled(n, description, getWebDriver().findElements(locator));
        return nthDisplayedAndEnabled(n, description, webDriver.findElements(locator));
    }

    private WebElement nthDisplayedAndEnabled(int n, String description, List<WebElement> elements) {
        if (elements.size() == 0) {
            throw new NoSuchElementException(
                    "No " + description + " found (regardless whether displayed and enabled, or not)");
        }
        int counter = 1;
        int i = 0;
        log.debug("Starting to search for displayed and enabled " + description + " #" + n + " out of "
                + elements.size() + " candidates");

        for (WebElement element : elements) {
            log.debug("Checking whether " + description + " #" + counter++ + " is displayed and enabled");
            if (isDisplayedAndEnabled(element, description)) {
                if (++i == n) {
                    log.debug("Found displayed and enabled " + description + " #" + i);
                    return element;
                }
            }
        }
        String errorMessage = "Found " + elements.size() + " instance(s) of " + description
                + ", but none that is both displayed and enabled";
        throw new NoSuchElementException(errorMessage);
    }

    private boolean isDisplayedAndEnabled(WebElement element, String description) {
        try {
            if (!element.isDisplayed()) {
                log.debug(description + " is not displayed!");
                return false;
            }
            if (!element.isEnabled()) {
                log.debug(description + " is not enabled!");
                return false;
            }
            log.debug("Heureka! - " + description + " is both displayed and enabled!");
            return true;
        } catch (StaleElementReferenceException sere) {
            log.debug(description + " no longer exists in the DOM!");
            return false;
        }
    }

    public boolean elementPresent(By by) {
        try {
            getWebDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void javascriptExecutorClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);
    }

    protected void javascriptExecutorEnterValue(WebElement element, String value) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].value=" + value + ";", element);
    }

    protected ExpectedCondition<WebElement> elementToBeClickable(final By locator) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = (WebElement) ExpectedConditions.visibilityOfElementLocated(locator).apply(driver);
                try {
                    return element != null && element.isEnabled() ? element : null;
                } catch (StaleElementReferenceException var) {
                    return null;
                }
            }
        };
    }

    protected ExpectedCondition<Boolean> elementIsPresent(final By locator) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(locator);
                    return element.isDisplayed();
                } catch (StaleElementReferenceException var) {
                    return null;
                }
            }
        };
    }

    protected void clickOn(By locator, int timeout) {
        //new WebDriverWait(webDriver, timeout).until(elementToBeClickable(locator)).click();
        new WebDriverWait(getWebDriver(), timeout).until(elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, int timeout, String value) {
        //new WebDriverWait(webDriver, timeout).until(elementToBeClickable(locator)).sendKeys(value);
        new WebDriverWait(getWebDriver(), timeout).until(elementToBeClickable(locator)).sendKeys(value);
    }

    protected void clearText(By locator, int timeout) {
        //new WebDriverWait(webDriver, timeout).until(elementToBeClickable(locator)).clear();
        new WebDriverWait(getWebDriver(), timeout).until(elementToBeClickable(locator)).clear();
    }

    protected void uploadFile(String mediaType, String fileName, WebElement inputElement, String productName) {
        String filePath = null;
        String fileSeparator = FileSystems.getDefault().getSeparator();
        if (productName.contains("GR")) {
            if (mediaType.equalsIgnoreCase("video") || mediaType.equalsIgnoreCase("picture")) {
                filePath = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "greenroomMedia" + fileSeparator + "videos" + fileSeparator + fileName;
            }
            if (mediaType.equalsIgnoreCase("image")) {
                filePath = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "greenroomMedia" + fileSeparator + "images" + fileSeparator + fileName;
            }
            inputElement.sendKeys(filePath);
        } else if (productName.contains("Events")) {
            if (mediaType.equalsIgnoreCase("video") || mediaType.equalsIgnoreCase("picture")) {
                filePath = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "eventsmedia" + fileSeparator + "videos" + fileSeparator + fileName;
            }
            if (mediaType.equalsIgnoreCase("image")) {
                filePath = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "eventsmedia" + fileSeparator + "images" + fileSeparator + fileName;
            }
            if (mediaType.equalsIgnoreCase("documents")) {
                filePath = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "eventsmedia" + fileSeparator + "documents" + fileSeparator + fileName;
            }
            inputElement.sendKeys(filePath);
        }
    }

    protected void dragAndDrop(WebElement source, WebElement destination) {
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(source).moveByOffset(-1, -5).pause(100).release(destination).build().perform();
    }

    public void mouseHoverAction(WebElement element) {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(element).build().perform(); // Does the mouse hover on the specified web element.
    }

    protected void switchToFrameByIndex(int frameIndex) {
        webDriver.switchTo().frame(frameIndex);
    }

    protected void switchToFrameByFrameId(String frameID) {
        webDriver.switchTo().frame(frameID);
    }

    protected void switchToFrameByFrameElement(WebElement element) {
        webDriver.switchTo().frame(element);
    }

    protected void switchOutFromFrame() {
        webDriver.switchTo().defaultContent();
    }

    protected ExpectedCondition<Boolean> elementIsNotPresent(final By locator) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(locator);
                    while(element.isDisplayed()){
                        sleep(1);
                    }
                   return  !element.isDisplayed();
                } catch (NoSuchElementException var) {
                    return null;
                }
            }
        };
    }

    public void navigateToStreamViewer(String code) {
        String channelCode = "//input[@name='Enter Code']";
        String next ="//button[@class='onboarding']";
        gotoUrl("https://api.brandnot.live/test-stream/");
        sleep(2);
        WebElement channelCodeInputField = waitForDisplayedAndEnabled(By.xpath(channelCode), "channel Code input field");
        channelCodeInputField.sendKeys(code);
        WebElement nextButton = waitForDisplayedAndEnabled(By.xpath(next), "Next button");
        nextButton.click();
        sleep(2);
    }

    public void loginToGreenroomAsPresenter(String emailId,String password){
        log.debug("Log in to Greenroom as Presenter... ");
        gotoUrl(blSubscription.getGreenroomUrl());
        String email = "//input[@name='Email']";
        WebElement emailField = waitForDisplayedAndEnabled(By.xpath(email),"Email field for presenter login");
        emailField.sendKeys(emailId);
        sleep(1);
        String passwordInfo = "//input[@name='Password']";
        WebElement passwordField = waitForDisplayedAndEnabled(By.xpath(passwordInfo),"Password field for presenter login");
        passwordField.sendKeys(password);
        sleep(1);
        String login = "//button[@class='onboarding']";
        WebElement loginButton = waitForDisplayedAndEnabled(By.xpath(login),"Login button for presenter login");
        loginButton.click();
    }

    public void logoutOfGreenroomAsPresenter(){
        log.debug("Log in to Greenroom as Presenter... ");
        String avatar = "//div[@class='avatar-button']//div[@class='avatar-text']";
        WebElement avatarIcon = waitForDisplayedAndEnabled(By.xpath(avatar),"avatar for presenter login");
        //avatarIcon.click();
        javascriptExecutorClick(avatarIcon);
        sleep(2);
        String logout = "(//button[@class='avatar-option'])[5]";
        WebElement logoutOption = waitForDisplayedAndEnabled(By.xpath(logout),"logout for presenter login");
        logoutOption.click();
        String signout = "//div[@class='button-row']//button[@class='dark']";
        WebElement signoutOption = waitForDisplayedAndEnabled(By.xpath(signout),"logout for presenter login");
        signoutOption.click();
        sleep(10);
    }

    public void scrollIntoElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOnElementFromDropDown(String locatorName, String elementName) {
            List<WebElement> webElements = webDriver.findElements(By.xpath(locatorName));
            for (WebElement ele : webElements) {
                if (ele.getText().contains(elementName)) {
                    javascriptExecutorClick(ele);
                    sleep(2);
                    break;
                }
            }
        sleep(1);
    }
}
