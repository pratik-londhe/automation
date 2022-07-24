package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GuiControl;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShowAndHideClassFunctionality extends PageMenuTab {
    private static final Logger logger = Logger.getLogger(ShowAndHideClassFunctionality.class);

    private int countBefore = 0;
    private int countAfter = 0;

    private final GuiControl dropDownMoreOption = new GuiControl(getElementMap().get("dropDownMoreOption"), webDriver);
    private final GuiControl linkHideFromDashBoard = new GuiControl(getElementMap().get("linkHideFromDashBoard"), webDriver);
    private final GuiControl dropDownShowClasses = new GuiControl(getElementMap().get("dropDownShowClasses"), webDriver);
    private final GuiControl btnHide = new GuiControl(getElementMap().get("btnHide"), webDriver);
    private final GuiControl btnCancelHide = new GuiControl(getElementMap().get("btnCancelHide"), webDriver);
    private final GuiControl linkDisplayOnDashBoard = new GuiControl(getElementMap().get("linkDisplayOnDashBoard"), webDriver);
    private final GuiControl linkWhatAreHiddenClasses = new GuiControl(getElementMap().get("linkWhatAreHiddenClasses"), webDriver);
    private final GuiControl txtHiddenClassInformation = new GuiControl(getElementMap().get("txtHiddenClassInformation"), webDriver);
    private final GuiControl btnDisplay = new GuiControl(getElementMap().get("btnDisplay"), webDriver);
    private final GuiControl btnDisplayCancel = new GuiControl(getElementMap().get("btnDisplayCancel"), webDriver);

    public ShowAndHideClassFunctionality(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void getCountOfClassesBefore() {
        waitForSec(5);
        List<WebElement> classNamesBefore = webDriver.findElements(By.xpath("//div[@class='scss-components-GroupCard__headerTitles___Nls9A']//a//span"));
        countBefore = classNamesBefore.size();
        reportLog("Total Number Of Classes Is = " + countBefore);
    }

    public void getCountOfClassesAfter() {
        waitForSec(5);
        List<WebElement> classNamesAfter = dropDownMoreOption.getWebElement().findElements(By.xpath("//div[@class='scss-components-GroupCard__headerTitles___Nls9A']//a//span"));
        countAfter = classNamesAfter.size();
        reportLog("Total Number Of Classes Is = " + countAfter);
    }

    public boolean verifyCountOfClassesAfterHide() {
        return countBefore != countAfter;
    }

    public boolean verifyCountOfClassesAfterCancelHide() {
        return countBefore == countAfter;
    }

    public void clickOnMoreOptionsDropDown() {
        waitForSec(5);
        dropDownMoreOption.clickFirstFromListOfElements();
        reportLog("Successfully click On More Option DropDown");
    }

    public boolean verifyHideFromDashBoardLink() {
        return linkHideFromDashBoard.isElementPresent();
    }

    public void clickOnHideFromDashBoardLink() {
        waitForSec(4);
        if (linkHideFromDashBoard.isElementPresent()) {
            linkHideFromDashBoard.clickJScript();
            reportLog("Successfully clicked On Hide From DashBoard Link");
        }
    }

    public boolean verifyShowClassesDropDown() {
        waitForSec(5);
        return dropDownShowClasses.isElementPresent();
    }

    public void clickOnHiddenClassesButton() {
        Select dropdown = new Select(webDriver.findElement(By.xpath("//div[@class='row']//select")));
        dropdown.selectByValue("Hidden Classes");
    }

    public boolean verifyHideButton() {
        waitForSec(5);
        return btnHide.isElementPresent();
    }

    public void clickOnHideButton() {
        if (btnHide.isElementPresent()) {
            btnHide.clickJScript();
            reportLog("Successfully clicked On Hide Button");
        }
    }

    public boolean verifyHideCancelButton() {
        return btnCancelHide.isElementPresent();
    }

    public void clickOnHideCancelButton() {
        if (btnCancelHide.isElementPresent()) {
            btnCancelHide.clickJScript();
            reportLog("Successfully clicked On Hide Cancel Button");
        }
    }

    public boolean verifyDisplayOnDashBoardLink() {
        return linkDisplayOnDashBoard.isElementPresent();
    }

    public void clickOnDisplayOnDashBoardLink() {
        if (linkDisplayOnDashBoard.isElementPresent()) {
            linkDisplayOnDashBoard.clickJScript();
            reportLog("Successfully clicked On Display On DashBoard Link");
        }
    }

    public void clickOnWhatAreHiddenClassesLink() {
        if (linkWhatAreHiddenClasses.isElementPresent()) {
            linkWhatAreHiddenClasses.clickJScript();
            reportLog("Successfully clicked On What Are Hidden Classes Link");
        }
    }

    public boolean verifyHiddenClassInformationText() {
        waitForSec(5);
        return txtHiddenClassInformation.isElementPresent();
    }

    public boolean verifyDisplayButton() {
        waitForSec(5);
        return btnDisplay.isElementPresent();
    }

    public void clickOnDisplayButton() {
        if (btnDisplay.isElementPresent()) {
            btnDisplay.click();
            reportLog("Successfully clicked On Display Button");
        }
    }

    public boolean verifyCancelDisplayButton() {
        return btnDisplayCancel.isElementPresent();
    }

    public void clickOnCancelDisplayButton() {
        if (btnDisplayCancel.isElementPresent()) {
            btnDisplayCancel.clickJScript();
            reportLog("Successfully clicked Cancel Display Button");
        }
    }

    public void clickOnCurrentClassesLink() {
        Select dropdown = new Select(webDriver.findElement(By.xpath("//div[@class='row']//select")));
        dropdown.selectByValue("Current Classes");
    }
}