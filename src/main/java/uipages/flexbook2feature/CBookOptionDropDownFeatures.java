package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class CBookOptionDropDownFeatures extends BasePage {

    private String name1;
    private String name2;
    private int count1;
    private String initialColour;
    private int countOfClasses;

    private final GuiControl optionDropDown = new GuiControl(getElementMap().get("optionDropDown"), webDriver);
    private final GuiControl btnShare = new GuiControl(getElementMap().get("btnShare"), webDriver);
    private final GuiControl btnAddToFlexBook = new GuiControl(getElementMap().get("btnAddToFlexBook"), webDriver);
    private final GuiControl btnShareToClass = new GuiControl(getElementMap().get("btnShareToClass"), webDriver);
    private final GuiControl btnDetails = new GuiControl(getElementMap().get("btnDetails"), webDriver);
    private final GuiControl btnBackToPage = new GuiControl(getElementMap().get("btnBackToPage"), webDriver);
    private final GuiControl txtVocabulary = new GuiControl(getElementMap().get("txtVocabulary"), webDriver);
    private final GuiControl txtEditor = new GuiControl(getElementMap().get("txtEditor"), webDriver);
    private final GuiControl placeHolderEmail = new GuiControl(getElementMap().get("placeHolderEmail"), webDriver);
    private final GuiControl btnDone = new GuiControl(getElementMap().get("btnDone"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl btnOkay = new GuiControl(getElementMap().get("btnOkay"), webDriver);
    private final GuiControl btnOkAgain = new GuiControl(getElementMap().get("btnOkAgain"), webDriver);
    private final GuiControl iconPlus = new GuiControl(getElementMap().get("iconPlus"), webDriver);
    private final GuiControl txtPlaceHolder = new GuiControl(getElementMap().get("txtPlaceHolder"), webDriver);
    private final GuiControl txtOfFlexBookName = new GuiControl(getElementMap().get("txtOfFlexBookName"), webDriver);
    private final GuiControl linkCk12 = new GuiControl(getElementMap().get("linkCk12"), webDriver);
    private final GuiControl dropDownMoreOption = new GuiControl(getElementMap().get("dropDownMoreOption"), webDriver);
    private final GuiControl btnArchive = new GuiControl(getElementMap().get("btnArchive"), webDriver);
    private final GuiControl btnOky = new GuiControl(getElementMap().get("btnOky"), webDriver);
    private final GuiControl btnShareLink = new GuiControl(getElementMap().get("btnShareLink"), webDriver);
    private final GuiControl iconClose2 = new GuiControl(getElementMap().get("iconClose2"), webDriver);
    private final GuiControl btnDetailsStudent = new GuiControl(getElementMap().get("btnDetailsStudent"), webDriver);
    private final GuiControl btnAddToFlexBookStudent = new GuiControl(getElementMap().get("btnAddToFlexBookStudent"), webDriver);
    private final GuiControl linkOptionDropDown = new GuiControl(getElementMap().get("linkOptionDropDown"), webDriver);
    private final GuiControl textAlreadyInLibrary = new GuiControl(getElementMap().get("textAlreadyInLibrary"), webDriver);
    private final GuiControl linkAddToLibrary = new GuiControl(getElementMap().get("linkAddToLibrary"), webDriver);
    private final GuiControl textChooseClasses = new GuiControl(getElementMap().get("textChooseClasses"), webDriver);
    private final GuiControl textShowAnswer = new GuiControl(getElementMap().get("textShowAnswer"), webDriver);
    private final GuiControl ShowAnswerContainer = new GuiControl(getElementMap().get("ShowAnswerContainer"), webDriver);
    private final GuiControl textClassName = new GuiControl(getElementMap().get("textClassName"), webDriver);
    private final GuiControl btnAssignAssignment = new GuiControl(getElementMap().get("btnAssignAssignment"), webDriver);
    private final GuiControl iconCheckMark = new GuiControl(getElementMap().get("iconCheckMark"), webDriver);
    private final GuiControl checkBoxClassName = new GuiControl(getElementMap().get("checkBoxClassName"), webDriver);
    private final GuiControl btnShareAgain = new GuiControl(getElementMap().get("btnShareAgain"), webDriver);

    public CBookOptionDropDownFeatures(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyCheckMarkIcon() {
        return iconCheckMark.isElementPresent();
    }

    public void clickOnCheckMarkIcon() {
        if (iconCheckMark.isElementPresent()) {
            iconCheckMark.clickJScript();
            reportLog("Successfully clicked on Check Mark Icon");
        }
    }

    public boolean verifyButtonShareAgain() {
        waitForSec(5);
        return btnShareAgain.isElementPresent();
    }

    public void clickOnButtonShareAgain() {
        if (btnShareAgain.isElementPresent()) {
            btnShareAgain.clickJScript();
            reportLog("Successfully clicked on btn Share Again");
        }
    }

    public boolean verifyClassNameCheckBox() {
        return checkBoxClassName.isElementPresent();
    }

    public void clickOnClassNameCheckBox() {
        if (checkBoxClassName.isElementPresent()) {
            checkBoxClassName.clickJScript();
            reportLog("Successfully clicked on Class Name CheckBox");
        }
    }

    public boolean verifyShowAnswerText() {
        return textShowAnswer.isElementPresent();
    }

    public void getCountOfClasses() {
        countOfClasses = textClassName.getWebElements().size();
        reportLog("Total Count Of Present Classes Are = " + countOfClasses);
    }

    public boolean verifyAllClassesArePresent() {
        return countOfClasses>1;
    }

    public void getInitialColourBeforeSelectingShowAnswer() {
        WebElement firstColour = webDriver.findElement(By.xpath("(//label[@class='switch custom-check-box-cs-small']//span)[3]"));
        initialColour = firstColour.getCssValue("background-color");
        reportLog(initialColour);
    }

    public boolean verifyShowAnswerIsSelected() {
        WebElement colour = webDriver.findElement(By.xpath("(//label[@class='switch custom-check-box-cs-small']//span)[3]"));
        reportLog(colour.getCssValue("background-color"));
        return initialColour != (colour.getCssValue("background-color"));
    }

    public void clickOnShowAnswerContainer() {
        if (ShowAnswerContainer.isElementPresent()) {
            ShowAnswerContainer.clickJScript();
            reportLog("Successfully clicked on Show Answer Container");
        }
    }

    public boolean verifyChooseClassesText() {
        waitForSec(5);
        return textChooseClasses.isElementPresent();
    }

    public boolean verifyAlreadyInLibraryText() {
        waitForSec(5);
        return textAlreadyInLibrary.isElementPresent();
    }

    public boolean verifyOptionsLink() {
        waitForSec(5);
        return linkOptionDropDown.isElementPresent();
    }

    public void clickOnOptionsLink() {
        if (linkOptionDropDown.isElementPresent()) {
            linkOptionDropDown.click();
            reportLog("Successfully clicked on Option DropDown Link");
        }
    }

    public boolean verifyAddToLibraryLink() {
        waitForSec(5);
        return linkAddToLibrary.isElementPresent();
    }

    public void clickOnAddToLibraryLink() {
        if (linkAddToLibrary.isElementPresent()) {
            linkAddToLibrary.click();
            reportLog("Successfully clicked on Add To Library Link");
        }
    }

    public boolean verifyAssignAssignmentButtonIsVisible() {
        return btnAssignAssignment.isElementPresent();
    }

    public void clickOnAssignAssignmentButton() {
        if (btnAssignAssignment.isElementPresent()) {
            btnAssignAssignment.click();
            reportLog("Successfully clicked on Assign Assignment Button");
        }
    }

    public boolean verifyAssignAssignmentButtonIsEnable() {
        return btnAssignAssignment.isElementPresent();
    }


    public boolean verifyShareButtonLink() {
        waitForSec(5);
        return btnShareLink.isElementPresent();
    }

    public void clickOnIconClose2() {
        if (iconClose2.isElementPresent()) {
            iconClose2.click();
            reportLog("Successfully clicked on icon Close2");
        }
    }

    public boolean verifyOptionsDropDown() {
        waitForSec(5);
        return optionDropDown.isElementPresent();
    }

    public void clickOnOptionsDropDown() {
        if (optionDropDown.isElementPresent()) {
            optionDropDown.click();
            reportLog("Successfully clicked onOption DropDown");
        }
    }

    public boolean verifyShareToClassButton() {
        btnShareToClass.mouseHover();
        return btnShareToClass.isElementPresent();
    }

    public void clickOnShareToClassButton() {
        if (btnShareToClass.isElementPresent()) {
            btnShareToClass.mouseHover();
            btnShareToClass.clickJScript();
            reportLog("Successfully clicked on Share To Class Button");
        }
    }

    public boolean verifyShareButton() {
        waitForSec(5);
        btnShare.mouseHover();
        return btnShare.isElementPresent();
    }

    public void clickOnShareButton() {
        if (btnShare.isElementPresent()) {
            btnShare.mouseHover();
            btnShare.clickJScript();
            reportLog("Successfully clicked on Share Button");
        }
    }

    public boolean verifyAddToFlexBookButton() {
        waitForSec(5);
        return btnAddToFlexBook.isElementPresent();
    }

    public void clickOnAddToFlexBookButton() {
        if (btnAddToFlexBook.isElementPresent()) {
            btnAddToFlexBook.mouseHover();
            btnAddToFlexBook.clickJScript();
            reportLog("Successfully clicked on Add To FlexBook Button");
        }
    }

    public boolean verifyAddToFlexBookButtonAgain() {
        waitForSec(5);
        return btnAddToFlexBookStudent.isElementPresent();
    }

    public void clickOnAddToFlexBookButtonAgain() {
        if (btnAddToFlexBookStudent.isElementPresent()) {
            btnAddToFlexBookStudent.mouseHover();
            btnAddToFlexBookStudent.clickJScript();
            reportLog("Successfully clicked on Add To FlexBook Button");
        }
    }

    public boolean verifyDetailsButton() {
        btnDetails.mouseHover();
        return btnDetails.isElementPresent();
    }

    public void clickOnDetailsButton() {
        if (btnDetails.isElementPresent()) {
            btnDetails.mouseHover();
            btnDetails.clickJScript();
            reportLog("Successfully clicked on Details Button");
        }
    }

    public boolean verifyDetailsButtonAgain() {
        btnDetailsStudent.mouseHover();
        return btnDetailsStudent.isElementPresent();
    }

    public void clickOnDetailsButtonAgain() {
        if (btnDetailsStudent.isElementPresent()) {
            btnDetailsStudent.mouseHover();
            btnDetailsStudent.clickJScript();
            reportLog("Successfully clicked on Details Button");
        }
    }

    public boolean verifyBackToPageButton() {
        btnBackToPage.scrollIntoView();
        return btnBackToPage.isElementPresent();
    }

    public void clickOnBackToPageButton() {
        if (btnBackToPage.isElementPresent()) {
            btnBackToPage.clickJScript();
            reportLog("Successfully clicked on Back To Page Button");
        }
    }

    public void clickOnEmailPlaceHolder(String email) {
        if (placeHolderEmail.isElementPresent()) {
            placeHolderEmail.setText(email);
            reportLog("Successfully Set Value in Email Place Holder");
        }
    }

    public boolean verifyVocabularyText() {
        txtVocabulary.scrollIntoView();
        return txtVocabulary.isElementPresent();
    }

    public boolean verifyEditorText() {
        waitForSec(5);
        txtEditor.scrollIntoView();
        return txtEditor.isElementPresent();
    }

    public boolean verifyDoneButton() {
        waitForSec(5);
        return btnDone.isElementPresent();
    }

    public void clickOnDoneButton() {
        if (btnDone.isElementPresent()) {
            btnDone.clickJScript();
            reportLog("Successfully clicked on Done Button");
        }
    }

    public boolean verifyCancelButton() {
        return btnCancel.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.clickJScript();
            reportLog("Successfully clicked on Cancel Button");
        }
    }

    public boolean verifyOkayButton() {
        waitForSec(5);
        return btnOkay.isElementPresent();
    }

    public void clickOnOkayButton() {
        if (btnOkay.isElementPresent()) {
            btnOkay.clickJScript();
            reportLog("Successfully clicked on Okay Button");
        }
    }

    public boolean verifyOkButtonAgain() {
        waitForSec(5);
        return btnOkAgain.isElementPresent();
    }

    public void clickOnOkButtonAgain() {
        if (btnOkAgain.isElementPresent()) {
            btnOkAgain.clickJScript();
            reportLog("Successfully clicked on Ok Button Again ");
        }
    }

    public void clickOnPlusIcon() {
        waitForSec(5);
        if (iconPlus.isElementPresent()) {
            iconPlus.clickJScript();
            reportLog("Successfully clicked on Plus Icon");
        }
    }

    public boolean verifyPlaceHolderText() {
        return txtPlaceHolder.isElementPresent();
    }

    public void setNameInPlaceHolder(String name) {
        if (txtPlaceHolder.isElementPresent()) {
            name1 = name + currentTimeStamp();
            txtPlaceHolder.setText(name1);
            reportLog("Successfully Set Name in PlaceHolder Text And Name is = " + name1);
        }
    }

    public boolean verifyNameTextOfPlaceHolder() {
        waitForSec(5);
        return txtOfFlexBookName.isElementPresent();
    }

    public void getNameOfCreatedFlexBook() {
        name2 = txtOfFlexBookName.getText();
        reportLog("Successfully got Name Of Created FlexBook And Name Is = " + name2);
    }

    public void clickOnCk12Link() {
        if (linkCk12.isElementPresent()) {
            linkCk12.scrollIntoView();
            linkCk12.doubleClick();
            reportLog("Successfully clicked on Ck12 Link");
        }
    }

    public boolean verifyRecentlyCreatedFlexBookName() {
        waitForSec(5);
        reportLog("Created FlexBook Name is = " + name1);
        List<WebElement> list = webDriver.findElements(By.xpath("//div[@class='listitem js-listitem row collapse']//following-sibling::a[@class='bold']"));
        count1 = list.size();
        reportLog("Count Of FlexBook is = " + count1);
        for (WebElement listName : list) {
            if (name1.equalsIgnoreCase(listName.getText())) {
                return true;
            }
        }
        return false;
    }

    public void clickOnMoreOptionDropDown() {
        dropDownMoreOption.clickFirstFromListOfElements();
        reportLog("Successfully click on More Option DropDown");
    }

    public boolean verifyArchiveButton() {
        waitForSec(5);
        return btnArchive.isElementPresent();
    }

    public void clickOnArchiveButton() {
        if (btnArchive.isElementPresent()) {
            btnArchive.mouseHover();
            btnArchive.click();
            reportLog("Successfully clicked On Archive Button");
        }
    }

    public boolean verifyOkyButton() {
        waitForSec(5);
        return btnOky.isElementPresent();
    }

    public void clickOnOkyButton() {
        btnOky.clickJScript();
        reportLog("Successfully clicked On Oky Button");
    }
}