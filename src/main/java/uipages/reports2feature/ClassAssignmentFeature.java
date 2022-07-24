package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class ClassAssignmentFeature extends BasePage {

    private String assignmentName;
    private String instruction;
    private String description;
    private String undoAssignmentName;

    private final GuiControl btnAssignAssignment = new GuiControl(getElementMap().get("btnAssignAssignment"), webDriver);
    private final GuiControl btnAssign = new GuiControl(getElementMap().get("btnAssign"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl txtAssignmentName = new GuiControl(getElementMap().get("txtAssignmentName"), webDriver);
    private final GuiControl placeHolderDueDate = new GuiControl(getElementMap().get("placeHolderDueDate"), webDriver);
    private final GuiControl dueDate = new GuiControl(getElementMap().get("dueDate"), webDriver);
    private final GuiControl btnClose = new GuiControl(getElementMap().get("btnClose"), webDriver);
    private final GuiControl iconEditTitle = new GuiControl(getElementMap().get("iconEditTitle"), webDriver);
    private final GuiControl txtInstruction = new GuiControl(getElementMap().get("txtInstruction"), webDriver);
    private final GuiControl placeholderInstruction = new GuiControl(getElementMap().get("placeholderInstruction"), webDriver);
    private final GuiControl txtDescription = new GuiControl(getElementMap().get("txtDescription"), webDriver);
    private final GuiControl btnEdit = new GuiControl(getElementMap().get("btnEdit"), webDriver);
    private final GuiControl btnContinueEditing = new GuiControl(getElementMap().get("btnContinueEditing"), webDriver);
    private final GuiControl btnCancelEditing = new GuiControl(getElementMap().get("btnCancelEditing"), webDriver);
    private final GuiControl linkUndoAssign = new GuiControl(getElementMap().get("linkUndoAssign"), webDriver);
    private final GuiControl btnYesRemove = new GuiControl(getElementMap().get("btnYesRemove"), webDriver);
    private final GuiControl btnCancelRemove = new GuiControl(getElementMap().get("btnCancelRemove"), webDriver);
    private final GuiControl txtUndoAssignmentName = new GuiControl(getElementMap().get("txtUndoAssignmentName"), webDriver);

    public ClassAssignmentFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void getNameOfUndoAssignment() {
        undoAssignmentName = txtUndoAssignmentName.getText();
        reportLog("Successfully Get Assignment Name");
    }

    public boolean verifyCancelRemoveButton() {
        return btnCancelRemove.isElementPresent();
    }

    public void clickOnCancelRemoveButton() {
        if (btnCancelRemove.isElementPresent()) {
            btnCancelRemove.clickJScript();
            reportLog("Clicked on Cancel Remove Button");
        }
    }

    public boolean verifyYesRemoveButton() {
        return btnYesRemove.isElementPresent();
    }

    public void clickOnYesRemoveButton() {
        if (btnYesRemove.isElementPresent()) {
            btnYesRemove.clickJScript();
            reportLog("Clicked on Yes Remove Button");
        }
        waitForSec(5);
    }

    public boolean verifyUndoAssignLink() {
        waitForSec(5);
        return linkUndoAssign.isElementPresent();
    }

    public void clickOnUndoAssignLink() {
        if (linkUndoAssign.isElementPresent()) {
            linkUndoAssign.clickJScript();
            reportLog("Clicked on Undo Assign Link");
        }
        waitForSec(5);
    }

    public boolean verifyCancelEditButton() {
        return btnCancelEditing.isElementPresent();
    }

    public void clickOnCancelEditButton() {
        if (btnCancelEditing.isElementPresent()) {
            btnCancelEditing.clickJScript();
            reportLog("Clicked on Cancel Edit Button");
        }
    }

    public boolean verifyContinueEditButton() {
        return btnContinueEditing.isElementPresent();
    }

    public void clickOnContinueEditButton() {
        if (btnContinueEditing.isElementPresent()) {
            btnContinueEditing.clickJScript();
            reportLog("Clicked on Continue Edit Button");
        }
    }

    public void scrollUpScreen() {
        iconEditTitle.scrollIntoView();
    }

    public boolean verifyEditButton() {
        return btnEdit.isElementPresent();
    }

    public void clickOnEditButton() {
        if (btnEdit.isElementPresent()) {
            btnEdit.clickJScript();
            reportLog("Clicked on Edit Button");
        }
        waitForSec(5);
    }

    public boolean verifyEditTitleIcon() {
        return iconEditTitle.isElementPresent();
    }

    public void clickOnEditTitleIcon() {
        if (iconEditTitle.isElementPresent()) {
            iconEditTitle.clickJScript();
            reportLog("Clicked on Edit Title Icon");
        }
    }

    public boolean verifyInstructionText() {
        return txtInstruction.isElementPresent();
    }

    public void SetValueInInstructionPlaceHolder(String info) {
        if (placeholderInstruction.isElementPresent()) {
            placeholderInstruction.clickJScript();
            instruction = info;
            placeholderInstruction.setText(instruction);
            reportLog("Successfully Set Value In Instruction PlaceHolder.");
        }
    }

    public void getTextOfDescription() {
        waitForSec(5);
        description = txtDescription.getText();
        reportLog("Successfully Get Description Text = " + description);
    }

    public boolean verifyDescriptionText() {
        if (instruction.equalsIgnoreCase(description)) {
            reportLog("Successfully verify Description Text.");
            return true;
        }
        return false;
    }

    public void getTextOfAssignmentName() {
        assignmentName = txtAssignmentName.getText();
        reportLog("Successfully Get Assignment Name And Name Is = " + assignmentName);
    }

    public boolean verifyDueDatePlaceHolder() {
        waitForSec(5);
        return placeHolderDueDate.isElementPresent();
    }

    public void SetValueInDueDatePlaceHolder() {
        if (placeHolderDueDate.isElementPresent()) {
            placeHolderDueDate.clickJScript();
           // waitForSec(5);
           // dueDate.clickJScript();
            reportLog("Clicked on Due Date.");
        }
    }

    public void clickOnAssignAssignmentButton() {
        if (btnAssignAssignment.isElementPresent()) {
            btnAssignAssignment.clickJScript();
            reportLog("Clicked on Assign Button.");
        }
    }

    public boolean verifyAssignAssignmentButton() {
        return btnAssignAssignment.isElementPresent();
    }

    public boolean verifyAssignButton() {
        return btnAssign.isElementPresent();
    }

    public void clickOnAssignButton() {
        if (btnAssign.isElementPresent()) {
            btnAssign.clickJScript();
            reportLog("Clicked on Assign Button.");
        }
    }

    public boolean verifyCancelButton() {
        waitForSec(5);
        return btnCancel.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.clickJScript();
            reportLog("Clicked on Cancel Button.");
        }
    }

    public void clickOnCloseButton() {
        if (btnClose.isElementPresent()) {
            btnClose.clickJScript();
            reportLog("Clicked on Close  Button.");
        }
    }

    public boolean verifyAssignmentIsAvailableInTheClass() {
        waitForSec(5);
        List<WebElement> list = webDriver.findElements(By.xpath("//div[@class='left assignment-title']//span[@class]"));
        for (WebElement names : list) {
            if (assignmentName.equalsIgnoreCase(names.getText())) {
                reportLog("Assignment Is Successfully Assign To Class");
                return true;
            }
        }
        reportLog("Failed To Assign Assignment To Class");
        return false;
    }

    public boolean verifyAssignmentIsAvailableInTheAvailedClass() {
        waitForSec(5);
        List<WebElement> list = webDriver.findElements(By.xpath("//div[@class='left assignment-title']//span[@class]"));
        for (WebElement names : list) {
            if (undoAssignmentName.equalsIgnoreCase(names.getText())) {
                reportLog("Assignment Is Successfully Available In Class");
                return true;
            }
        }
        return false;
    }

}
