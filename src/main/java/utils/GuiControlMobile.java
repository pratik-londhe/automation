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
public class GuiControlMobile {
    private static final Logger logger = Logger.getLogger(GuiControlMobile.class);

    private String locatorType;
    private String locatorValue;
    protected Properties configProperty;
    public Actions builder;
    //Get list of web elements
    protected AppiumDriver appiumDriver;
    private int timeInSec = 0;
    private String ipsywindow;

    public GuiControlMobile(String locator, AppiumDriver appiumDriver) {
        locatorType = locator.split("_TBD_")[0];
        locatorValue = locator.split("_TBD_")[1];
        this.appiumDriver = appiumDriver;
    }

    public GuiControlMobile() {
        //Do nothing
    }

    //Get web Element
    public WebElement getWebElement() {
        return getMobileElement(locatorType, locatorValue);
    }

    //Get list of web elements
    public List<WebElement> getWebElements() {
        return getGuiControlChild(locatorType, locatorValue);
    }

    public WebElement getMobileElement(String locatorType, String locatorValue) {
        WebElement webElement = null;


        switch (locatorType.toUpperCase()) {
            case "ID":
                webElement = appiumDriver.findElement(MobileBy.id(locatorValue));
                break;
            case "NAME":
                webElement = appiumDriver.findElement(MobileBy.name(locatorValue));
                break;
            case "CLASSNAME":
                webElement = appiumDriver.findElement(MobileBy.className(locatorValue));
                break;
            case "TAGNAME":
                webElement = appiumDriver.findElement(By.tagName(locatorValue));
                break;
            case "XPATH":
                webElement = appiumDriver.findElement(MobileBy.xpath(locatorValue));
                break;
            case "LINKTEXT":
                webElement = appiumDriver.findElement(MobileBy.linkText(locatorValue));
                break;
            case "PARTIALLINKTEXT":
                webElement = appiumDriver.findElement(MobileBy.partialLinkText(locatorValue));
                break;
            case "CSSSELECTOR":
                webElement = appiumDriver.findElement(MobileBy.cssSelector(locatorValue));
                break;
            default:
                logger.info("Invalid locator type -" + locatorType);
        }
        return webElement;
    }



    public List<WebElement> getGuiControlChild(String locatorType, String locatorValue) {
        List<WebElement> webElementList = null;

        switch (locatorType.toUpperCase()) {
            case "NAME":
                webElementList = appiumDriver.findElements(MobileBy.name(locatorValue));
                break;
            case "CLASSNAME":
                webElementList = appiumDriver.findElements(MobileBy.className(locatorValue));
                break;
            case "TAGNAME":
                webElementList = appiumDriver.findElements(MobileBy.tagName(locatorValue));
                break;
            case "XPATH":
                webElementList = appiumDriver.findElements(MobileBy.xpath(locatorValue));
                break;
            case "LINKTEXT":
                webElementList = appiumDriver.findElements(MobileBy.linkText(locatorValue));
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

    public void click() {
        WebElement element = getWebElement();
        waitForElementUntilClickable(5, element);
        waitForPageLoaded(appiumDriver);
        if (!element.isDisplayed()) {
            ((JavascriptExecutor) appiumDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        if (!element.isDisplayed()) {
            Point location = element.getLocation();
            String str = String.format("javascript:window.scrollBy(%d,%d)", location.getX(), location.getY());
            JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
            js.executeScript(str);
        }
        try {
            waitForElementUntilClickable(20);
            getWebElement().click();
        } catch (StaleElementReferenceException e) {
            logger.info(e);
            logger.error("Encountered StaleElementException, consider using click_Retry method instead");
            getWebElement().click();
        }
    }


    public void clickFirstFromListOfElements() {
        waitForPageLoaded(appiumDriver);
        List<WebElement> elements = getWebElements();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isDisplayed()) {
                elements.get(i).click();
                break;
            }
        }
    }

    public void clickLastFromListOfElements() {
        List<WebElement> elements = getWebElements();
        int listSize = elements.size();
        elements.get(listSize - 1).click();
    }

    public void clickJScript() {
        waitForPageLoaded(appiumDriver);
        JavascriptExecutor executor = (JavascriptExecutor) appiumDriver;
        WebElement element = getWebElement();
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView() {
        ((JavascriptExecutor) appiumDriver).executeScript("arguments[0].scrollIntoView(true);", getWebElement());
    }

    public void waitForElementUntilClickable(int sec, WebElement webElement) {
        try {
            (new WebDriverWait(appiumDriver, sec)).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not clickable within given timeout.");
        }
    }

    public boolean waitForElementUntilClickable(int sec) {
        try {
            (new WebDriverWait(appiumDriver, sec)).until(ExpectedConditions.elementToBeClickable(getWebElement()));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not clickable within given timeout");
        }
        return false;
    }

    public boolean waitForStalenessOfElement(int sec) {
        try {
            (new WebDriverWait(appiumDriver, sec)).until(ExpectedConditions.stalenessOf(getWebElement()));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element doesn't get stale within given timeout");
        }
        return false;
    }

    public boolean waitForUntilVisibilityOfElementList(int sec) {
        try {
            (new WebDriverWait(appiumDriver, sec)).until(ExpectedConditions.visibilityOf(getWebElements().get(0)));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not visible within given timeout");
        }
        return false;
    }

    public boolean waitForUntilVisibilityOfElement(int sec) {
        try {
            (new WebDriverWait(appiumDriver, sec)).until(ExpectedConditions.visibilityOf(getWebElement()));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not visible within given timeout");
        }
        return false;
    }

    public void waitForPageLoaded(AppiumDriver appiumDriver) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
            wait.until(expectation);
        } catch (TimeoutException error) {
            logger.info("Timeout waiting for Page Load Request complete." + error);
        } catch (InterruptedException iEx) {
            logger.info(iEx);
            Thread.currentThread().interrupt();
        }
    }

    public void sendKeys(String keys) {
        getWebElement().sendKeys(keys);
    }

    public void setText(String text) {
        getWebElement().clear();
        sendKeys(text);
    }

    public void clearText() {
        getWebElement().clear();
    }

    public boolean isElementPresent() {
        try {
            timeInSec = Integer.parseInt(configProperty.getProperty("waitForSecond"));
        } catch (NumberFormatException e) {
            logger.info("Number format is exception occurred.");
        }
        boolean result = false;
        for (int i = 0; i < timeInSec / 10; i++) {
            try {
                if (getWebElement().isDisplayed()) {
                    logger.info("Element found--> {" + locatorType + ": " + locatorValue + "}");
                    return true;
                }
            } catch (Exception e) {
                logger.info("Element not found-->{" + locatorType + ": " + locatorValue + "}");
                logger.info(e);
            }
            try {
                logger.info("Going For Sleep");
                Thread.sleep(1000);
            } catch (InterruptedException iEx) {
                logger.info(iEx);
                Thread.currentThread().interrupt();
            }
        }
        return result;
    }

    public void mouseHover() {
        Actions builder = new Actions(appiumDriver);
        builder.moveToElement(getWebElement()).build().perform();
    }

    public void doubleClick() {
        Actions act = new Actions(appiumDriver);
        act.moveToElement(getWebElement()).doubleClick().build().perform();
    }

    public String getAttribute(String args) {
        return getWebElement().getAttribute(args);
    }

    public boolean isDisplayed() {
        return this.getWebElement().isDisplayed();
    }


    public boolean isSelected() {
        return this.getWebElement().isSelected();
    }

    public void selectByVisibleText(String textSelection) {
        new Select(getWebElement()).selectByVisibleText(textSelection);
    }

    public void switchToFrameByFrameElement(WebElement element) {
        appiumDriver.switchTo().frame(element);
    }

    public void gotoBackPage() {
        appiumDriver.navigate().back();
    }

    public String getPlatform() {
        String iOS = "ios";
        String Android = "android";
        String chrome = "web";
        String safari = "safari";
        if ("ios".equalsIgnoreCase(PropertyReader.getConfigData().getProperty("platform"))) {
            return iOS;
        } else if ("web".equalsIgnoreCase(PropertyReader.getConfigData().getProperty("platform"))) {
            return chrome;
        } else if ("safari".equalsIgnoreCase(PropertyReader.getConfigData().getProperty("platform"))) {
            return safari;
        } else {
            return Android;
        }
    }

    public void switchToNewWindow() {
        this.ipsywindow = appiumDriver.getWindowHandle();
        logger.info("First window name" + ipsywindow);
        Set<String> newWindows = appiumDriver.getWindowHandles();
        for (String newWindow : newWindows) {
            if (!newWindow.equals(ipsywindow)) {
                appiumDriver.switchTo().window(newWindow);
            }
        }
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void acceptAlert() {
        appiumDriver.switchTo().alert().accept();
    }

    public void scrollToMiddle() {
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        js.executeScript("scroll(0, loc);");
    }

    public void scrollToUp() {
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void setValuesWithHideKeyboard(By locator, String values) {
        WebElement element = appiumDriver.findElement(locator);
        element.sendKeys(values);
        appiumDriver.hideKeyboard();
    }

    public void hideKeyboard(AppiumDriver appiumDriver) {
        appiumDriver.hideKeyboard();
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

    public void switchToWindow(String window) {
        appiumDriver.switchTo().window(window);
    }

    public void switchToParentWindow() {
        logger.info("Inside switchToParentWindow Method");
        if (getBrowser().contains("safari")) {
            appiumDriver.close();
        }
        logger.info("CLosing the newly opened tab");
        switchToWindow(ipsywindow);
    }

    public String getCssValue(String args) {
        return getWebElement().getCssValue(args);
    }

    public void scrollToElement() {
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement());
    }
}