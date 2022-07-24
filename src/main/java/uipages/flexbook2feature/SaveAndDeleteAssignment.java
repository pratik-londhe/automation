package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class SaveAndDeleteAssignment extends BasePage {

    private int countSelectedChkBox;
    private int countUnselectedChkBox;
    private int countAssignBeforeRemove;
    private int countAssignAfterRemove;

    private final GuiControl btnSelect = new GuiControl(getElementMap().get("btnSelect"), webDriver);
    private final GuiControl blankCheckBox = new GuiControl(getElementMap().get("blankCheckBox"), webDriver);
    private final GuiControl selectedCheckbox = new GuiControl(getElementMap().get("selectedCheckbox"), webDriver);
    private final GuiControl iconRemoveConcept = new GuiControl(getElementMap().get("iconRemoveConcept"), webDriver);
    private final GuiControl txtNameAssignment = new GuiControl(getElementMap().get("txtNameAssignment"), webDriver);
    private final GuiControl btnSaveAssignment = new GuiControl(getElementMap().get("btnSaveAssignment"), webDriver);
    private final GuiControl btnCancelAssignment = new GuiControl(getElementMap().get("btnCancelAssignment"), webDriver);
    private final GuiControl txtError = new GuiControl(getElementMap().get("txtError"), webDriver);
    private final GuiControl linkUndoAssign = new GuiControl(getElementMap().get("linkUndoAssign"), webDriver);

    public SaveAndDeleteAssignment(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifySaveAssignmentButton() {
        waitForSec(5);
        return btnSaveAssignment.isElementPresent();
    }

    public void clickOnSaveAssignmentButton() {
        if (btnSaveAssignment.isElementPresent()) {
            btnSaveAssignment.clickJScript();
            reportLog("Clicked on Save Assignment Button.");
        }
    }

    public boolean verifyCancelAssignmentButton() {
        waitForSec(4);
        return btnCancelAssignment.isElementPresent();
    }

    public boolean verifyUndoAssignLink() {
        return linkUndoAssign.isElementPresent();
    }

    public void clickOnCancelAssignmentButton() {
        if (btnCancelAssignment.isElementPresent()) {
            btnCancelAssignment.clickJScript();
            reportLog("Clicked on Cancel Assignment Button.");
        }
    }

    public boolean verifyNameAssignmentText() {
        return txtNameAssignment.isElementPresent();
    }

    public boolean verifyErrorText() {
        return txtError.isElementPresent();
    }

    public boolean verifyRemoveConceptIcon() {
        return iconRemoveConcept.isElementPresent();
    }

    public void clickOnRemoveConceptIcon() {
        if (iconRemoveConcept.isElementPresent()) {
            iconRemoveConcept.clickJScript();
            reportLog("Clicked on remove Concept Icon.");
        }
        waitForSec(5);
    }

    public void getCountOfAssignmentsBeforeRemove() {
        List<WebElement> listAssignBeforeRemove = selectedCheckbox.getWebElement().findElements(By.xpath("//div[@class='custom-box right']//span//i"));
        countAssignBeforeRemove = listAssignBeforeRemove.size();
        reportLog("Total Number Of Count Before Remove Is  = " + countAssignBeforeRemove);
    }

    public void getCountOfAssignmentsAfterRemove() {
        List<WebElement> listAssignAfterRemove = blankCheckBox.getWebElement().findElements(By.xpath("//div[@class='custom-box right']//span"));
        countAssignAfterRemove = listAssignAfterRemove.size();
        reportLog("Total Number Of Count After Remove Is  = " + countAssignAfterRemove);
    }

    public boolean verifyCountAfterRemove() {
        return countAssignBeforeRemove == countAssignAfterRemove;
    }

    public boolean verifySelectButton() {
        return btnSelect.isElementPresent();
    }

    public void clickOnSelectButton() {
        if (btnSelect.isElementPresent()) {
            btnSelect.clickJScript();
            reportLog("Clicked on Select Button.");
        }
        waitForSec(5);
    }

    public void getCountOfSelectedCheckBox() {
        List<WebElement> listSelectedChkBox = webDriver.findElements(By.xpath("//div[@class='custom-box right']//span//i"));
        countSelectedChkBox = listSelectedChkBox.size();
        reportLog("Total Number Of Selected CheckBox Is = " + countSelectedChkBox);
    }

    public void getCountOfUnSelectedCheckBox() {
        List<WebElement> listUnSelectedChkBox = webDriver.findElements(By.xpath("//div[@class='custom-box right']//span"));
        countUnselectedChkBox = listUnSelectedChkBox.size();
        reportLog("Total Number Of Not Selected CheckBox Is = " + countUnselectedChkBox);
    }

    public boolean verifyAllPresentAssignmentIsSelected() {
        return countSelectedChkBox == countUnselectedChkBox;
    }

    public boolean verifyAllPresentAssignmentIsNotSelected() {
        return countSelectedChkBox == countUnselectedChkBox;
    }
}