package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

import java.util.Set;

public class AnswerKey extends BasePage {
    private String parentWindow;
    private final GuiControl linkStudyGuide = new GuiControl(getElementMap().get("linkStudyGuide"), webDriver);
    private final GuiControl linkAnswerKey = new GuiControl(getElementMap().get("linkAnswerKey"), webDriver);
    private final GuiControl btnShareWithClasses = new GuiControl(getElementMap().get("btnShareWithClasses"), webDriver);
    private final GuiControl btnEditDraft = new GuiControl(getElementMap().get("btnEditDraft"), webDriver);
    private final GuiControl textModalityType = new GuiControl(getElementMap().get("textModalityType"), webDriver);
    private final GuiControl iconDisable = new GuiControl(getElementMap().get("iconDisable"), webDriver);
    private final GuiControl textAnswerKeys = new GuiControl(getElementMap().get("textAnswerKeys"), webDriver);
    private final GuiControl sharedAnswerKeyLink = new GuiControl(getElementMap().get("sharedAnswerKeyLink"), webDriver);
    private final GuiControl btnResources = new GuiControl(getElementMap().get("btnResources"), webDriver);
    private final GuiControl textNoResources = new GuiControl(getElementMap().get("textNoResources"), webDriver);

    public AnswerKey(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyAnswerKeyModalityLink() {
        waitForSec(2);
        linkStudyGuide.scrollIntoView();
        waitForSec(2);
        return linkAnswerKey.isElementPresent();
    }

    public void clickOnAnswerKeyModalityLink() {
        if (linkAnswerKey.isElementPresent()) {
            linkAnswerKey.click();
            reportLog("Successfully clicked on Answer key type");
        }
    }

    public boolean verifyShareWithClassesButton() {
        waitForSec(5);
        return btnShareWithClasses.isElementPresent();
    }

    public void clickOnShareWithClassesButton() {
        if (btnShareWithClasses.isElementPresent()) {
            btnShareWithClasses.clickJScript();
            reportLog("Successfully clicked on Share With Classes Button");
        }
    }

    public boolean verifyEditDraftButton() {
        waitForSec(5);
        return btnEditDraft.isElementPresent();
    }

    public boolean verifyAnswerKeyText() {
        waitForSec(5);
        return textAnswerKeys.isElementPresent();
    }

    public void clickOnEditDraftButton() {
        if (btnEditDraft.isElementPresent()) {
            btnEditDraft.clickJScript();
            reportLog("Successfully clicked on Edit Draft Button");
        }
    }

    public boolean verifyModalityTypeText() {
        return textModalityType.isElementPresent();
    }

    public boolean verifyDisableIcon() {
        return iconDisable.isElementPresent();
    }

    public boolean verifySharedResourcesLink() {
        return sharedAnswerKeyLink.isElementPresent();
    }

    public void clickOnSharedResourcesLink() {
        if (sharedAnswerKeyLink.isElementPresent()) {
            sharedAnswerKeyLink.clickJScript();
            reportLog("Successfully clicked on Edit Draft Button");
        }
    }

    public void switchToChildWindow() {
        parentWindow = webDriver.getWindowHandle();
        Set<String> childWindow = webDriver.getWindowHandles();
        for (String window : childWindow) {
            if (!parentWindow.equals(window)) {
                webDriver.switchTo().window(window);
                reportLog("Successfully Move To Child Window");
            }
        }
    }
    public void switchToChildWindowOfAssignment() {
        Set<String> childWindow = webDriver.getWindowHandles();
        for (String window : childWindow) {
            if (parentWindow.equals(window)) {
                webDriver.switchTo().window(window);
                logger.info("Successfully Move To Child Window");
            }
        }
    }

    public void switchToThirdWindow() {
        parentWindow = webDriver.getWindowHandle();
        Set<String> childWindow = webDriver.getWindowHandles();
        int i = 1;
        for (String window : childWindow) {
            if (!parentWindow.equals(window)) {
                if (i == 3) {
                    webDriver.switchTo().window(window);
                    reportLog("Successfully Move To Child Window");
                }
            }
            i++;
        }
    }

    public void switchToParentWindow() {
        webDriver.switchTo().window(parentWindow);
        reportLog("Switched to the parent window.");
    }

    public boolean verifyResourcesButton() {
        waitForSec(5);
        return btnResources.isElementPresent();
    }

    public void clickOnResourcesButton() {
        if (btnResources.isElementPresent()) {
            btnResources.clickJScript();
            reportLog("Successfully clicked on Resources Button");
        }
    }

    public boolean verifyNoResourcesText() {
        waitForSec(5);
        textNoResources.scrollIntoView();
        return textNoResources.isElementPresent();
    }
}