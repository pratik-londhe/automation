package utils;

import com.relevantcodes.extentreports.ExtentTest;
import environment.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

/**
 * Created by pratik.londhe on 8/18/2018.
 */
public class GuiControl {
    private static final Logger logger = Logger.getLogger(GuiControl.class);

    private String locatorType;
    private String locatorValue;
    protected WebDriver webDriver;
    protected Properties configProperty = null;
    private int timeInSec = 0;

    public GuiControl() {
        //Do nothing
    }

    public GuiControl(String locator, WebDriver webDriver) {
        locatorType = locator.split("_TBD_")[0];
        locatorValue = locator.split("_TBD_")[1];
        this.webDriver = webDriver;
    }

    public WebElement getWebElement() {
        return getWebElement(locatorType, locatorValue);
    }

    public List<WebElement> getWebElements() {
        return getGuiControlChild(locatorType, locatorValue);
    }

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
                break;
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
            case "CSSSELECTOR":
                webElementList = webDriver.findElements(By.cssSelector(locatorValue));
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
        waitForPageLoaded();
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
            waitForElementUntilClickable(20);
            getWebElement().click();
        } catch (StaleElementReferenceException e) {
            logger.info(e);
            logger.error("Encountered StaleElementException, consider using click_Retry method instead");
            getWebElement().click();
        }
    }

    public void clickFirstFromListOfElements() {
        waitForPageLoaded();
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
        waitForPageLoaded();
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement element = getWebElement();
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", getWebElement());
    }

    public void waitForElementUntilClickable(int sec, WebElement webElement) {
        try {
            (new WebDriverWait(webDriver, sec)).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not clickable within given timeout.");
        }
    }

    public boolean waitForElementUntilClickable(int sec) {
        try {
            (new WebDriverWait(webDriver, sec)).until(ExpectedConditions.elementToBeClickable(getWebElement()));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not clickable within given timeout");
        }
        return false;
    }

    public boolean waitForStalenessOfElement(int sec) {
        try {
            (new WebDriverWait(webDriver, sec)).until(ExpectedConditions.stalenessOf(getWebElement()));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element doesn't get stale within given timeout");
        }
        return false;
    }

    public boolean waitForUntilVisibilityOfElementList(int sec) {
        try {
            (new WebDriverWait(webDriver, sec)).until(ExpectedConditions.visibilityOf(getWebElements().get(0)));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not visible within given timeout");
        }
        return false;
    }

    public boolean waitForUntilVisibilityOfElement(int sec) {
        try {
            (new WebDriverWait(webDriver, sec)).until(ExpectedConditions.visibilityOf(getWebElement()));
        } catch (TimeoutException tou) {
            logger.info(tou);
            logger.warn("Element is not visible within given timeout");
        }
        return false;
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(webDriver, 30);
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
        configProperty = PropertyReader.getConfigData();
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
        Actions builder = new Actions(webDriver);
        builder.moveToElement(getWebElement()).build().perform();
    }

    public void mouseHoverWithJavaScript(){
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement element = getWebElement();
        executor.executeScript("var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); " +
                "mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);", element);
    }

    public void doubleClick() {
        Actions act = new Actions(webDriver);
        act.moveToElement(getWebElement()).doubleClick().build().perform();
    }

    public String getAttribute(String args) {
        return getWebElement().getAttribute(args);
    }

    public boolean isDisplayed() {
        return this.getWebElement().isDisplayed();
    }

    public boolean isEnable() {
        return this.getWebElement().isEnabled();
    }

    public boolean isSelected() {
        return this.getWebElement().isSelected();
    }

    public void selectByVisibleText(String textSelection) {
        new Select(getWebElement()).selectByVisibleText(textSelection);
    }

    // Get API event of Network tab
    public String getNetworkEvent() {
        String jsEvent = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
        return ((JavascriptExecutor) webDriver).executeScript(jsEvent).toString();
    }

    public void switchToFrameByFrameElement(WebElement element) {
        webDriver.switchTo().frame(element);
    }

    public void scrollByPixel(int pixelValue) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,"+ pixelValue +")");
    }

}