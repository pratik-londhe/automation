package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

import java.util.Set;

public class ClassPage extends BasePage {

    private final GuiControl linkReports = new GuiControl(getElementMap().get("linkReports"), webDriver);
    private final GuiControl linkSettings = new GuiControl(getElementMap().get("linkSettings"), webDriver);
    private final GuiControl linkSharedResources = new GuiControl(getElementMap().get("linkSharedResources"), webDriver);
    private final GuiControl classImage = new GuiControl(getElementMap().get("classImage"), webDriver);
    private final GuiControl btnDeleteClass = new GuiControl(getElementMap().get("btnDeleteClass"), webDriver);
    private final GuiControl labelClassCode = new GuiControl(getElementMap().get("labelClassCode"), webDriver);
    private final GuiControl txtJoinClassLink = new GuiControl(getElementMap().get("txtJoinClassLink"), webDriver);
    private final GuiControl btnTryNewReports = new GuiControl(getElementMap().get("btnTryNewReports"), webDriver);

    public ClassPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyReportsOption() {
        return linkReports.isElementPresent();
    }

    public void clickOnReportsOption() {
        if (linkReports.isElementPresent()) {
            linkReports.clickJScript();
            reportLog("Clicked on Reports option.");
        }
    }

    public boolean verifySettingsOption() {
        return linkSettings.isElementPresent();
    }

    public void clickOnSettingsOption() {
        if (linkSettings.isElementPresent()) {
            linkSettings.clickJScript();
            reportLog("Clicked on Settings option.");
        }
    }

    public boolean verifySharedResourcesOption() {
        return linkSharedResources.isElementPresent();
    }

    public void clickOnSharedResourcesOption() {
        if (linkSharedResources.isElementPresent()) {
            linkSharedResources.clickJScript();
            reportLog("Clicked on Shared Resources option.");
        }
    }

    public boolean verifyClassImage() {
        waitForSec(5);
        return classImage.isElementPresent();
    }

    public boolean verifyDeleteClassButton() {
        return btnDeleteClass.isElementPresent();
    }

    public void clickOnDeleteClassButton() {
        if (btnDeleteClass.isElementPresent()) {
            btnDeleteClass.clickJScript();
            reportLog("Clicked on Delete Class Button.");
        }
    }

    public boolean verifyClassCodeLabel() {
        return labelClassCode.isElementPresent();
    }

    public boolean verifyJoinClassLink() {
        return txtJoinClassLink.isElementPresent();
    }

    public boolean verifyTryNewReportsBtn() {
        return btnTryNewReports.isElementPresent();
    }

    public void clickOnTryNewReportsBtn() {
        btnTryNewReports.click();
        reportLog("Clicked on the Try new Reports button.");
    }

    public void handleMultipleWindows() {
        String parentWindow = webDriver.getWindowHandle();
        Set<String> childWindow = webDriver.getWindowHandles();
        for (String windows : childWindow) {
            if (!windows.equals(parentWindow)) {
                webDriver.switchTo().window(windows);
            }

        }
    }
}