package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class Reports extends BasePage {

    private String assignmentType;
    private String first;
    private String second;
    private String assignmentName;

    private final GuiControl checkBoxFirstAssignment = new GuiControl(getElementMap().get("checkBoxFirstAssignment"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl placeHolderTitle = new GuiControl(getElementMap().get("placeHolderTitle"), webDriver);
    private final GuiControl checkBoxClassNAme = new GuiControl(getElementMap().get("checkBoxClassNAme"), webDriver);
    private final GuiControl btnSaveAssignment = new GuiControl(getElementMap().get("btnSaveAssignment"), webDriver);
    private final GuiControl linkAssignment = new GuiControl(getElementMap().get("linkAssignment"), webDriver);
    private final GuiControl btnStart = new GuiControl(getElementMap().get("btnStart"), webDriver);
    private final GuiControl btnStartSolving = new GuiControl(getElementMap().get("btnStartSolving"), webDriver);
    private final GuiControl linkFirstOption = new GuiControl(getElementMap().get("linkFirstOption"), webDriver);
    private final GuiControl linkSecondOption = new GuiControl(getElementMap().get("linkSecondOption"), webDriver);
    private final GuiControl btnNext = new GuiControl(getElementMap().get("btnNext"), webDriver);
    private final GuiControl btnTurnIn = new GuiControl(getElementMap().get("btnTurnIn"), webDriver);
    private final GuiControl btnContinue = new GuiControl(getElementMap().get("btnContinue"), webDriver);
    private final GuiControl btnClose = new GuiControl(getElementMap().get("btnClose"), webDriver);
    private final GuiControl linkTryNewReports = new GuiControl(getElementMap().get("linkTryNewReports"), webDriver);
    private final GuiControl student1 = new GuiControl(getElementMap().get("student1"), webDriver);
    private final GuiControl student2 = new GuiControl(getElementMap().get("student2"), webDriver);
    private final GuiControl textAssignmentType = new GuiControl(getElementMap().get("textAssignmentType"), webDriver);

    public Reports(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }


    public void checkReportsOfUser() {
        if ("Quiz".equalsIgnoreCase(assignmentType)) {
            if ("80%".equalsIgnoreCase(first)) {
                reportLog("Student is Good In Study");
            } else {
                student1.click();
            }
        }
        if ("Quiz".equalsIgnoreCase(assignmentType)) {
            if ("80%".equalsIgnoreCase(first)) {
                reportLog("Student is Good In Study");
            } else {
                student2.click();
            }
        }
    }

    public void getPercentageOfFirstStudent() {
        first = textAssignmentType.getText();
        reportLog("Successfully get Get Percentage Of First Student  = " + first);
    }

    public void getPercentageOfSeconfStudent() {
        second = textAssignmentType.getText();
        reportLog("Successfully get Get Percentage Of Second Student  = " + second);
    }


    public void getAssignmentType() {
        assignmentType = textAssignmentType.getText();
        reportLog("Successfully get Assignment Type And Type Is = " + assignmentType);
    }


    public boolean verifyTryNewReportsLink() {
        waitForSec(5);
        return linkTryNewReports.isElementPresent();
    }

    public void clickOnTryNewReportsLink() {
        if (linkTryNewReports.isElementPresent()) {
            linkTryNewReports.clickJScript();
            reportLog("Clicked on Try New Reports Link");
        }
        waitForSec(5);
    }

    public boolean verifyCloseButton() {
        waitForSec(5);
        return btnClose.isElementPresent();
    }

    public void clickOnCloseButton() {
        if (btnClose.isElementPresent()) {
            btnClose.clickJScript();
            reportLog("Clicked on Close Option");
        }
        waitForSec(5);
    }

    public boolean verifyContinueButton() {
        waitForSec(5);
        return btnContinue.isElementPresent();
    }

    public void clickOnContinueButton() {
        if (btnContinue.isElementPresent()) {
            btnContinue.clickJScript();
            reportLog("Clicked on Continue Option");
        }
    }

    public boolean verifyTurnInButton() {
        return btnTurnIn.isElementPresent();
    }

    public void clickOnTurnInButton() {
        if (btnTurnIn.isElementPresent()) {
            btnTurnIn.clickJScript();
            reportLog("Clicked on Turn In Option");
        }
    }

    public boolean verifyNextButton() {
        return btnNext.isElementPresent();
    }

    public void clickOnNextButton() {
        if (btnNext.isElementPresent()) {
            btnNext.clickJScript();
            reportLog("Clicked on Next Option");
        }
    }

    public boolean verifySecondOption() {
        waitForSec(5);
        return linkSecondOption.isElementPresent();
    }

    public void clickOnSecondOption() {
        if (linkSecondOption.isElementPresent()) {
            linkSecondOption.clickJScript();
            reportLog("Clicked on Second Option");
        }
        waitForSec(5);
    }

    public boolean verifyFirstOption() {
        waitForSec(5);
        return linkFirstOption.isElementPresent();
    }

    public void clickOnFirstOption() {
        if (linkFirstOption.isElementPresent()) {
            linkFirstOption.clickJScript();
            reportLog("Clicked on First Option");
        }
        waitForSec(5);
    }

    public boolean verifyStartSolvingButton() {
        waitForSec(5);
        return btnStartSolving.isElementPresent();
    }

    public void clickOnStartSolvingButton() {
        if (btnStartSolving.isElementPresent()) {
            btnStartSolving.clickJScript();
            reportLog("Clicked on Start Solving Button");
        }
        waitForSec(5);
    }

    public void clickOnStartAssignmentButton() {
        waitForSec(5);
        btnStart.clickFirstFromListOfElements();
        reportLog("Clicked on Start Assignment Link");
    }

    public void clickOnFirstAssignmentLink() {
        waitForSec(5);
        linkAssignment.mouseHover();
        linkAssignment.clickJScript();
        reportLog("Clicked on  first Assignment Link");
    }

    public void setValueInTitlePlaceHolder(String name) {
        if (placeHolderTitle.isElementPresent()) {
            placeHolderTitle.clickJScript();
            reportLog("Clicked on Title PlaceHolder");
            assignmentName = name + currentTimeStamp();
            placeHolderTitle.setText(assignmentName);
            reportLog("Successfully Set Assignment Name And Assignment Name Is = " + assignmentName);
        }
        waitForSec(5);
    }

    public boolean verifyClassNameCheckBox() {
        return checkBoxClassNAme.isElementPresent();
    }

    public void clickOnClassNameCheckBox() {
        if (checkBoxClassNAme.isElementPresent()) {
            checkBoxClassNAme.clickJScript();
            reportLog("Clicked on ClassName CheckBox");
        }
        waitForSec(5);
    }

    public boolean verifySaveAssignmentButton() {
        return btnSaveAssignment.isElementPresent();
    }

    public void clickOnSaveAssignmentButton() {
        if (btnSaveAssignment.isElementPresent()) {
            btnSaveAssignment.clickJScript();
            reportLog("Clicked on Save Assignment Button");
        }
        waitForSec(5);
    }

    public boolean verifySaveButton() {
        waitForSec(5);
        return btnSave.isElementPresent();
    }

    public void clickOnSaveButton() {
        if (btnSave.isElementPresent()) {
            btnSave.clickJScript();
            reportLog("Clicked on SaveButton");
        }
        waitForSec(5);
    }

    public void clickOnFirstAssignmentCheckBox() {
        waitForSec(5);
        checkBoxFirstAssignment.clickJScript();
        reportLog("Clicked on Close first Assignment CheckBox");
    }
}