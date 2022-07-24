package utils;

import constants.Constants;
import environment.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by Afreen Shaikh
 */

public class GuiControlWeb {
    private static final Logger logger = Logger.getLogger(GuiControlWeb.class);

    private String locatorType;
    private String locatorValue;
    protected WebDriver webDriver;
    protected Properties configProperty;
    public Actions builder;
    private int timeInSec = 0;

    public GuiControlWeb(String locator, WebDriver webDriver) {
        locatorType = locator.split("_TBD_")[0];
        locatorValue = locator.split("_TBD_")[1];
        this.webDriver = webDriver;
    }

    public GuiControlWeb() {
        //Do nothing
    }

    //Get web Element
    public WebElement getWebElement() {
        return getWebElement(locatorType, locatorValue);
    }

    //Get list of web elements
    public List<WebElement> getWebElements() {
        return getGuiControlChild(locatorType, locatorValue);
    }

    //Find element by locator value
    public WebElement getWebElement(String locatorType, String locatorValue) {
        WebElement webElement = null;
        switch (locatorType.toUpperCase()) {

            case "ID":
                webElement = webDriver.findElement(By.id(locatorValue));
                break;
            case "NAME":
                webElement = webDriver.findElement(By.name(locatorValue));
                break;
            case "CLASSNAME":
                webElement = webDriver.findElement(By.className(locatorValue));
                break;
            case "TAGNAME":
                webElement = webDriver.findElement(By.tagName(locatorValue));
                break;
            case "XPATH":
                webElement = webDriver.findElement(By.xpath(locatorValue));
                break;
            case "LINKTEXT":
                webElement = webDriver.findElement(By.linkText(locatorValue));
                break;
            case "PARTIALLINKTEXT":
                webElement = webDriver.findElement(By.partialLinkText(locatorValue));
                break;
            case "CSSSELECTOR":
                webElement = webDriver.findElement(By.cssSelector(locatorValue));
            default:
                logger.info("Invalid locator type -" + locatorType);
        }
        return webElement;

    }

    public List<WebElement> getGuiControlChild(String locatorType, String locatorValue) {
        List<WebElement> webElementList = null;

        switch (locatorType.toUpperCase()) {
            case "ID":
                webElementList = webDriver.findElements(By.id(locatorValue));
                break;
            case "NAME":
                webElementList = webDriver.findElements(By.name(locatorValue));
                break;
            case "CLASSNAME":
                webElementList = webDriver.findElements(By.className(locatorValue));
                break;
            case "TAGNAME":
                webElementList = webDriver.findElements(By.tagName(locatorValue));
                break;
            case "XPATH":
                webElementList = webDriver.findElements(By.xpath(locatorValue));
                break;
            case "LINKTEXT":
                webElementList = webDriver.findElements(By.linkText(locatorValue));
                break;
            default:
                logger.info("Wrong locator type.");
                break;
        }
        return webElementList;
    }


    public String getText() {
        return getWebElement().getText();
    }

    //Click on web element
    public void click() {
        WebElement element = getWebElement();
        if (!element.isDisplayed()) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        if (!element.isDisplayed()) {
            Point location = element.getLocation();
            String str = String.format("javascript:window.scrollBy(%d,%d)", location.getX(), location.getY());
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript(str);
        }
        try {
            getWebElement().click();
        } catch (StaleElementReferenceException e) {
            logger.info(e);
            logger.error("Encountered StaleElementException, consider using click_Retry method instead");
            getWebElement().click();
        }
    }

    public void clickFirstFromListOfElements() {
        List<WebElement> elements = getWebElements();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isDisplayed()) {
                elements.get(i).click();
                break;
            }
        }
    }

    //Click on element using javascript
    public void clickJScript() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement element = getWebElement();
        executor.executeScript("arguments[0].click();", element);
    }

    //Scroll into view of element
    public void scrollIntoView() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", getWebElement());
    }

    //Wait for element until it is clickable
    public void waitForElementUntilClickable(int sec, WebElement webElement) {
        try {
            (new WebDriverWait(webDriver, sec)).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not clickable within given timeout.");
        }
    }

    //Wait for element until it is clickable
    public boolean waitForElementUntilClickable(int sec) {
        try {
            (new WebDriverWait(webDriver, sec)).until(ExpectedConditions.elementToBeClickable(getWebElement()));


        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not clickable within given timeout");
        }
        return false;
    }

    //Send text as string to element
    public void sendKeys(String keys) {
        getWebElement().sendKeys(keys);
    }

    //Send key actions on element
    public void sendKeys(Keys key) {
        getWebElement().sendKeys(key);
    }

    //Enter text into element
    public void setText(String text) {
        getWebElement().clear();
        sendKeys(text);
    }

    //Check visibility of element
    public boolean isElementPresent(int sec) {
        logger.info("inside Wait for display");
        int i = 0;
        boolean flag;
        while (i < sec) {
            try {
                flag = getWebElement().isDisplayed();
                if (getWebElement().isDisplayed()) {
                    logger.info("Element display: " + flag);
                    return true;
                }
            } catch (RuntimeException e) {
                logger.info(e);
                waitForSec(1);
                logger.info("Waiting for element display...." + i);
                i = i + 1;
                if (i >= sec)
                    return false;
            }
        }
        logger.info("Element is not present.");
        return false;
    }

    //Wait for seconds
    public void waitForSec(int numberOfSecond) {
        try {
            Thread.sleep(numberOfSecond * 1000L);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    //Wait for seconds
    public void waitForSec() {
        configProperty = PropertyReader.getConfigData();
        int numberOfSecond = Integer.parseInt(configProperty.getProperty("waitForSec"));
        try {
            Thread.sleep(numberOfSecond * 1000L);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    //Wait until element clickable
    public void waitUntilClickableAndClick(int sec) {
        logger.info("Inside waitUntilClickableAndClick method");
        for (int i = sec; i > 0; i--) {
            try {
                if (isElementPresent(2)) {
                    click();
                    logger.info("Element is clicked at: " + (sec - i));
                    break;
                } else {
                    logger.info("Element is not clicked at : " + (sec - i));
                    waitForSec(1);
                }
            } catch (WebDriverException we) {
                logger.info("Element is not clicked: " + (sec - i));
                if (we.getMessage().contains("is not clickable at point")) {
                    logger.info("Got exception : is not clickable at point. " + (sec - i));
                    waitForSec(1);
                } else {
                    throw new WebDriverException(we);
                }
            }
        }
    }

    //Wait until element clickable
    public void waitUntilClickableAndClick() {
        logger.info("Inside waitUntilClickableAndClick method");
        configProperty = PropertyReader.getConfigData();
        int sec = Integer.parseInt(configProperty.getProperty("waitClickTime"));
        for (int i = sec; i > 0; i--) {
            try {
                if (isElementPresent(2)) {
                    waitForSec();
                    click();
                    logger.info("Element is clicked at: " + (sec - i));
                    break;
                } else {
                    logger.info("Element is not clicked at : " + (sec - i));
                    waitForSec(1);
                }
            } catch (WebDriverException we) {
                logger.info("Element is not clicked: " + (sec - i));
                if (we.getMessage().contains("is not clickable at point")) {
                    logger.info("Got exception : is not clickable at point. " + (sec - i));
                    waitForSec(1);
                } else {
                    throw new WebDriverException(we);
                }
            }
        }
    }

    //Select option from drop down by index
    public void selectOptionFromDD(int option) {
        Select ss = new Select(getWebElement());
        ss.selectByIndex(option);
        logger.info(ss.getFirstSelectedOption() + " option is get selected.");
    }

    //Select option from drop down by index
    public List<WebElement> getAllDropDowOptions() {
        Select options = new Select(getWebElement());
        return options.getOptions();
    }

    //Select option from drop down by visible text
    public void selectOptionVisibleTextFromDD(String dropdownOption) {
        new Select(getWebElement()).selectByVisibleText(dropdownOption);
    }

    //Check visibility of element

    public boolean isDisplayed() {
        return this.getWebElement().isDisplayed();
    }

    //Check status of element
    public boolean isSelected() {
        return this.getWebElement().isSelected();
    }

    //Verify element is enable
    public boolean isEnabled() {
        return this.getWebElement().isEnabled();
    }

    //Select option from drop down by value
    public void selectByValue(String value) {
        new Select(getWebElement()).selectByValue(value);
    }

    //Replace locator value by replaceName
    public void replaceText(String replaceName) {
        locatorValue = this.locatorValue.replace("_TTC_", replaceName);
    }

    //Verify click ability of element
    public boolean isClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(this.getWebElement()));
            return true;
        } catch (RuntimeException e) {
            logger.info(e);
            return false;
        }
    }

    //Scroll up window
    public void scrollUp() {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, -document.body.scrollHeight);", getWebElement());
    }

    //Move to element
    public void mouseHover() {
        builder = new Actions(webDriver);
        builder.moveToElement(getWebElement()).build().perform();
    }

    //Drag and drop element
    public void dragDrop(WebElement source, WebElement target, WebDriver webDriver) {
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(source).pause(Constants.THREAD_SLEEP_INSPECTION).moveToElement(target).release().build().perform();
    }

    //Get attribute
    public String getAttribute(String args) {
        return getWebElement().getAttribute(args);
    }

    //Upload file
    public void uploadFile(String filePath) {
        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Robot robot = null;
        try {
            robot = new Robot();
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(150);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            logger.error(e);
        } finally {
            robot = null;
        }
    }

    public void uploadFileMultiple(String filePath) {
        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Robot robot = null;
        try {
            robot = new Robot();
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(150);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(150);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            logger.error(e);
        } finally {
            robot = null;
        }
    }

    //Retrieve current System date
    public String getCurrentSystemDate() {
        String pattern = Constants.DATE_PATTERN;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    //Get only digits from provided string
    public String getDigits(String inputString) {
        String outputString;
        char[] ch = inputString.toCharArray();
        StringBuilder output = new StringBuilder();
        for (int i = Constants.INIT_COUNT; i <= ch.length - Constants.START_INDEX; i++) {
            if (Character.isDigit(ch[i])) {
                output.append(ch[i]);
            }
        }
        outputString = new String(output);
        return outputString;
    }


    public String getBrowser() {
        String safari = "safari";
        String chrome = "chrome";
        if ("safari".equalsIgnoreCase(System.getProperty(CommandLineParameters.BROWSER))) {
            return safari;
        } else {
            return chrome;
        }
    }

}