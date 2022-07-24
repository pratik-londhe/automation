package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class ManageFolder extends BasePage {

    private int beforeCount;
    private int afterCount;
    private int labelCount;
    private int before;
    private int after;

    private final GuiControl btnManageFolder = new GuiControl(getElementMap().get("btnManageFolder"), webDriver);
    private final GuiControl checkBoxMathematics = new GuiControl(getElementMap().get("checkBoxMathematics"), webDriver);
    private final GuiControl checkBoxScience = new GuiControl(getElementMap().get("checkBoxScience"), webDriver);
    private final GuiControl btnCreate = new GuiControl(getElementMap().get("btnCreate"), webDriver);
    private final GuiControl btnOk = new GuiControl(getElementMap().get("btnOk"), webDriver);
    private final GuiControl textCount = new GuiControl(getElementMap().get("textCount"), webDriver);
    private final GuiControl placeHolderNewFolder = new GuiControl(getElementMap().get("placeHolderNewFolder"), webDriver);
    private final GuiControl textError = new GuiControl(getElementMap().get("textError"), webDriver);
    private final GuiControl btnApplyFolder = new GuiControl(getElementMap().get("btnApplyFolder"), webDriver);
    private final GuiControl textFolderCount = new GuiControl(getElementMap().get("textFolderCount"), webDriver);
    private final GuiControl iconCloseFilter = new GuiControl(getElementMap().get("iconCloseFilter"), webDriver);
    private final GuiControl btnRemove = new GuiControl(getElementMap().get("btnRemove"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl linkAll = new GuiControl(getElementMap().get("linkAll"), webDriver);

    public ManageFolder(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void scrollUpScreen() {
        linkAll.scrollIntoView();
    }

    public void getCountOfFolderFilterBefore() {
        List<WebElement> count = textFolderCount.getWebElement().findElements(By.xpath("//div[@id='label-filter']//div//a[@title]"));
        before = count.size();
        reportLog("Successfully Get Count Of Folder Filter And Count is = " + before);
    }

    public void getCountOfFolderFilterAfter() {
        waitForSec(5);
        List<WebElement> count = textFolderCount.getWebElement().findElements(By.xpath("//div[@id='label-filter']//div//a[@title]"));
        after = count.size();
        reportLog("Successfully Get Count Of Folder Filter And Count is = " + after);
    }

    public boolean verifyFolderFilterAfterRemove() {
        return before != after;
    }

    public boolean verifyNewFolderFilterAfterCancel() {
        return before == after;
    }


    public boolean verifyCloseFilterIcon() {
        waitForSec(5);
        return iconCloseFilter.isElementPresent();
    }

    public void clickOnCloseFilterIcon() {
        if (iconCloseFilter.isElementPresent()) {
            iconCloseFilter.clickJScript();
            reportLog("Clicked on Close Filter Icon");
        }
        waitForSec(5);
    }

    public boolean verifyCancelButton() {
        return btnCancel.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.clickJScript();
            reportLog("Clicked on Cancel Button.");
        }
    }

    public boolean verifyRemoveButton() {
        return btnRemove.isElementPresent();
    }

    public void clickOnRemoveButton() {
        if (btnRemove.isElementPresent()) {
            btnRemove.clickJScript();
            reportLog("Clicked on Remove Button.");
        }
        waitForSec(5);
    }

    public void getCountOfLabelText() {
        List<WebElement> count = webDriver.findElements(By.xpath("//div[@id='library-items-list']/div[1]//div[4]/span"));
        labelCount = count.size();
        reportLog("Successfully Get Count Of Label Text and Count is = " + labelCount);
    }

    public boolean verifyLabelTexts() {
        waitForSec(6);
        return labelCount >= 1;
    }

    public boolean verifyOkApplyFolderButton() {
        return btnApplyFolder.isElementPresent();
    }

    public void clickOnApplyFolderButton() {
        if (btnApplyFolder.isElementPresent()) {
            btnApplyFolder.clickJScript();
            reportLog("Clicked on Apply Folder Button.");
        }
        waitForSec(5);
    }

    public void setValueInFolderNamePlaceHolder(String name) {
        if (placeHolderNewFolder.isElementPresent()) {
            placeHolderNewFolder.clickJScript();
            reportLog("Clicked on FolderName PlaceHolder");
            placeHolderNewFolder.setText(name);
            reportLog("Successfully enter Value in FolderName PlaceHolder");
        }
    }

    public void getCountOfFolderBefore() {
        List<WebElement> count = textCount.getWebElement().findElements(By.xpath("//label[@class='checkbox']//div[@title]"));
        beforeCount = count.size();
        reportLog("Successfully Get Count Of Folder And Count is = " + beforeCount);
    }

    public void getCountOfFolderAfter() {
        waitForSec(5);
        List<WebElement> count = textCount.getWebElement().findElements(By.xpath("//label[@class='checkbox']//div[@title]"));
        afterCount = count.size();
        reportLog("Successfully Get Count Of Folder And Count is = " + afterCount);
    }

    public boolean verifyNewFolderIsAddedInList() {
        waitForSec(8);
        return beforeCount != afterCount;
    }

    public boolean verifyErrorText() {
        return textError.isElementPresent();
    }

    public boolean verifyOkButton() {
        return btnOk.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOk.isElementPresent()) {
            btnOk.clickJScript();
            reportLog("Clicked on Ok Button.");
        }
        waitForSec(5);
    }

    public boolean verifyCreateButton() {
        return btnCreate.isElementPresent();
    }

    public void clickOnCreateButton() {
        if (btnCreate.isElementPresent()) {
            btnCreate.clickJScript();
            reportLog("Clicked on Create Button.");
        }
        waitForSec(5);
    }

    public boolean verifyManageFolderButton() {
        waitForSec(5);
        return btnManageFolder.isElementPresent();
    }

    public void clickOnManageFolderButton() {
        if (btnManageFolder.isElementPresent()) {
            btnManageFolder.clickJScript();
            reportLog("Clicked on Manage Folder Button.");
        }
        waitForSec(5);
    }

    public void clickOnMathematicsCheckBox() {
        checkBoxMathematics.clickJScript();
        reportLog("Clicked on Mathematics CheckBox.");
    }

    public void clickOnScienceCheckBox() {
        checkBoxScience.clickJScript();
        reportLog("Clicked on Science CheckBox.");
    }
}