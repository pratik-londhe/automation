package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class ChangingClassNameAndDescription extends BasePage {

    private String descriptionText;
    private String classNameText;

    private final GuiControl linkAddDescription = new GuiControl(getElementMap().get("linkAddDescription"), webDriver);
    private final GuiControl btnSaveDescription = new GuiControl(getElementMap().get("btnSaveDescription"), webDriver);
    private final GuiControl btnCancelDescription = new GuiControl(getElementMap().get("btnCancelDescription"), webDriver);
    private final GuiControl placeHolderDescription = new GuiControl(getElementMap().get("placeHolderDescription"), webDriver);
    private final GuiControl textDescription = new GuiControl(getElementMap().get("textDescription"), webDriver);
    private final GuiControl iconEditClass = new GuiControl(getElementMap().get("iconEditClass"), webDriver);
    private final GuiControl btnSaveClassName = new GuiControl(getElementMap().get("btnSaveClassName"), webDriver);
    private final GuiControl btnCancelClassName = new GuiControl(getElementMap().get("btnCancelClassName"), webDriver);
    private final GuiControl txtErrorMessage = new GuiControl(getElementMap().get("txtErrorMessage"), webDriver);
    private final GuiControl placeHolderClassName = new GuiControl(getElementMap().get("placeHolderClassName"), webDriver);
    private final GuiControl txtClassName = new GuiControl(getElementMap().get("txtClassName"), webDriver);
    private final GuiControl iconEditDescription = new GuiControl(getElementMap().get("iconEditDescription"), webDriver);


    public ChangingClassNameAndDescription(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyEditDescriptionIcon() {
        return iconEditDescription.isElementPresent();
    }

    public void clickOnEditDescriptionIcon() {
        if (iconEditDescription.isElementPresent()) {
            iconEditDescription.clickJScript();
            reportLog("clicked on Edit Description Icon");
        }
    }

    public boolean verifyClassNameText() {
        return classNameText.equalsIgnoreCase(txtClassName.getText());
    }

    public void setValueInClassNamePlaceHolder(String text) {
        if (placeHolderClassName.isElementPresent()) {
            placeHolderClassName.clickJScript();
            classNameText = text;
            placeHolderClassName.setText(classNameText);
            reportLog("Set Value In Class name PlaceHolder And Value is =" + classNameText);
        }
    }

    public void clearValueInClassNamePlaceHolder(String text1) {
        if (placeHolderClassName.isElementPresent()) {
            placeHolderClassName.clickJScript();
            placeHolderClassName.setText(text1);
            reportLog("Cleared Value In ClassName PlaceHolder");
        }
    }

    public boolean verifyErrorTextMessage() {
        return txtErrorMessage.isElementPresent();
    }

    public boolean verifyCancelButton() {
        return btnCancelClassName.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancelClassName.isElementPresent()) {
            btnCancelClassName.clickJScript();
            reportLog("clicked on Cancel button");
        }
    }

    public boolean verifySaveButton() {
        waitForSec(5);
        return btnSaveClassName.isElementPresent();
    }

    public void clickOnSaveButton() {
        if (btnSaveClassName.isElementPresent()) {
            btnSaveClassName.clickJScript();
            reportLog("clicked on Save Button");
        }
        waitForSec(5);
    }

    public boolean verifyEditClassIcon() {
        return iconEditClass.isElementPresent();
    }

    public void clickOnEditClassIcon() {
        if (iconEditClass.isElementPresent()) {
            iconEditClass.clickJScript();
            reportLog("clicked on Edit Class Icon");
        }
    }

    public boolean verifyDescriptionText() {
        return descriptionText.equalsIgnoreCase(textDescription.getText());
    }

    public void setValueInDescriptionPlaceHolder(String text) {
        if (placeHolderDescription.isElementPresent()) {
            placeHolderDescription.clickJScript();
            descriptionText = text;
            placeHolderDescription.setText(descriptionText);
            reportLog("Set Value In Description PlaceHolder And Value is = " + descriptionText);
        }
    }

    public void clearValueInDescriptionPlaceHolder(String text1) {
        if (placeHolderDescription.isElementPresent()) {
            placeHolderDescription.clickJScript();
            placeHolderDescription.setText(text1);
            reportLog("Set Value In Description PlaceHolder");
        }
    }

    public boolean verifyCancelDescriptionButton() {
        return btnCancelDescription.isElementPresent();
    }

    public void clickOnCancelDescriptionButton() {
        if (btnCancelDescription.isElementPresent()) {
            btnCancelDescription.clickJScript();
            reportLog("clicked on Add Cancel Description Button");
        }
    }

    public boolean verifySaveDescriptionButton() {
        waitForSec(5);
        return btnSaveDescription.isElementPresent();
    }

    public void clickOnSaveDescriptionButton() {
        if (btnSaveDescription.isElementPresent()) {
            btnSaveDescription.clickJScript();
            reportLog("clicked on Add Save Description Button");
        }
        waitForSec(5);
    }

    public boolean verifyAddDescriptionLink() {
        return linkAddDescription.isElementPresent();
    }

    public void clickOnAddDescriptionLink() {
        waitForSec(5);
        if (linkAddDescription.isElementPresent()) {
            linkAddDescription.click();
            reportLog("clicked on Add Description Link ");
        }
    }
}