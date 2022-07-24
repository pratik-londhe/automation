package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class SupportFeature extends BasePage {

    private final GuiControl btnSupport = new GuiControl(getElementMap().get("btnSupport"), webDriver);
    private final GuiControl textSupport = new GuiControl(getElementMap().get("textSupport"), webDriver);
    private final GuiControl iconDash = new GuiControl(getElementMap().get("iconDash"), webDriver);
    private final GuiControl iconSearch = new GuiControl(getElementMap().get("iconSearch"), webDriver);
    private final GuiControl textTopResult = new GuiControl(getElementMap().get("textTopResult"), webDriver);
    private final GuiControl placeHolderSearchFiled = new GuiControl(getElementMap().get("placeHolderSearchFiled"), webDriver);
    private final GuiControl linkFirstResult = new GuiControl(getElementMap().get("linkFirstResult"), webDriver);
    private final GuiControl iconBack = new GuiControl(getElementMap().get("iconBack"), webDriver);

    public SupportFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifySupportButton() {
        waitForSec(5);
        return btnSupport.isElementPresent();
    }

    public void clickOnSupportButton() {
        if (btnSupport.isElementPresent()) {
            btnSupport.clickJScript();
            reportLog("Clicked on Support button.");
        }
    }

    public boolean verifySupportText() {
        waitForSec(5);
        return textSupport.isElementPresent();
    }

    public void enterInToParentFrameOfSupport() {
        waitForSec(5);
        webDriver.switchTo().frame("webWidget");
        reportLog("Successfully Enter InTo Parent Frame");
    }

    public void removeFromParentFrameOfSupport() {
        webDriver.switchTo().defaultContent();
        reportLog("Successfully Remove From Parent Frame");
    }

    public boolean verifyDashIcon() {
        iconDash.mouseHover();
        return iconDash.isElementPresent();
    }

    public void clickOnDashIcon() {
        iconDash.mouseHover();
        if (iconDash.isElementPresent()) {
            iconDash.clickJScript();
            reportLog("Clicked on Dash Icon.");
        }
    }

    public boolean verifySearchIcon() {
        iconSearch.mouseHover();
        return iconSearch.isElementPresent();
    }

    public void clickOnSearchIcon() {
        iconSearch.mouseHover();
        if (iconSearch.isElementPresent()) {
            iconSearch.clickJScript();
            reportLog("Clicked on Search Icon.");
        }
    }

    public boolean verifyTopResultText() {
        waitForSec(5);
        return textTopResult.isElementPresent();
    }

    public void putValueInSearchFieldPlaceHolder(String text) {
        if (placeHolderSearchFiled.isElementPresent()) {
            placeHolderSearchFiled.setText(text);
            reportLog("Successfully Set Value In Search Placeholder Filed");
        }
    }

    public boolean verifyFirstResultLink() {
        linkFirstResult.mouseHover();
        return linkFirstResult.isElementPresent();
    }

    public void clickOnFirstResultLink() {
        linkFirstResult.click();
        reportLog("Clicked on First Result Link.");
    }

    public boolean verifyBackIcon() {
        waitForSec(5);
        iconBack.mouseHover();
        return iconBack.isElementPresent();
    }

    public void clickOnBackIcon() {
        iconBack.mouseHover();
        if (iconBack.isElementPresent()) {
            iconBack.clickJScript();
            reportLog("Clicked on Back Icon.");
        }
    }
}
