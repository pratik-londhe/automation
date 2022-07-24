package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CreateNewModality extends BasePage {

    private final GuiControl linkModality = new GuiControl(getElementMap().get("linkModality"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl btnGoBack = new GuiControl(getElementMap().get("btnGoBack"), webDriver);
    private final GuiControl ModalityTypeDropDown = new GuiControl(getElementMap().get("ModalityTypeDropDown"), webDriver);
    private final GuiControl linkRead = new GuiControl(getElementMap().get("linkRead"), webDriver);
    private final GuiControl linkVideo = new GuiControl(getElementMap().get("linkVideo"), webDriver);
    private final GuiControl btnEditTitle = new GuiControl(getElementMap().get("btnEditTitle"), webDriver);
    private final GuiControl btnAreYouStuck = new GuiControl(getElementMap().get("btnAreYouStuck"), webDriver);
    private final GuiControl textNeedHelp = new GuiControl(getElementMap().get("textNeedHelp"), webDriver);
    private final GuiControl textCK12Editing = new GuiControl(getElementMap().get("textCK12Editing"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl btnAssignToClass = new GuiControl(getElementMap().get("btnAssignToClass"), webDriver);
    private final GuiControl iconCk12ClassRoom = new GuiControl(getElementMap().get("iconCk12ClassRoom"), webDriver);
    private final GuiControl btnShareWithClasses = new GuiControl(getElementMap().get("btnShareWithClasses"), webDriver);
    private final GuiControl btnShare = new GuiControl(getElementMap().get("btnShare"), webDriver);
    private final GuiControl textShareWithClasses = new GuiControl(getElementMap().get("textShareWithClasses"), webDriver);
    private final GuiControl textPleaseSelectClass = new GuiControl(getElementMap().get("textPleaseSelectClass"), webDriver);
    private final GuiControl checkBoxClassName = new GuiControl(getElementMap().get("checkBoxClassName"), webDriver);
    private final GuiControl btnSuccess = new GuiControl(getElementMap().get("btnSuccess"), webDriver);
    private final GuiControl btnAddToLibrary = new GuiControl(getElementMap().get("btnAddToLibrary"), webDriver);
    private final GuiControl dropDownShowDetails = new GuiControl(getElementMap().get("dropDownShowDetails"), webDriver);
    private final GuiControl dropDownHideDetails = new GuiControl(getElementMap().get("dropDownHideDetails"), webDriver);
    private final GuiControl textDateCreated = new GuiControl(getElementMap().get("textDateCreated"), webDriver);
    private final GuiControl textDescription = new GuiControl(getElementMap().get("textDescription"), webDriver);

    public CreateNewModality(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyModalityLink() {
        return linkModality.isElementPresent();
    }

    public void clickOnModalityLink() {
        waitForSec(6);
        if (linkModality.isElementPresent()) {
            linkModality.click();
            reportLog("Successfully clicked on Modality Link");
        }
        waitForSec(8);
    }

    public boolean verifySaveButton() {
        return btnSave.isElementPresent();
    }

    public void clickOnSaveButton() {
        waitForSec(5);
        if (btnSave.isElementPresent()) {
            btnSave.click();
            reportLog("Successfully clicked on Save Button");
        }
    }

    public boolean verifyGoBackButton() {
        return btnGoBack.isElementPresent();
    }

    public void clickOnGoBackButton() {
        if (btnGoBack.isElementPresent()) {
            btnGoBack.click();
            reportLog("Successfully clicked on Go Back Button");
        }
    }

    public boolean verifyModalityTypeDropDown() {
        return ModalityTypeDropDown.isElementPresent();
    }

    public void clickOnModalityTypeDropDown() {
        if (ModalityTypeDropDown.isElementPresent()) {
            ModalityTypeDropDown.click();
            reportLog("Successfully clicked on Modality type DropDown");
        }
    }

    public boolean verifyReadLink() {
        return linkRead.isElementPresent();
    }

    public boolean verifyVideoLink() {
        return linkVideo.isElementPresent();
    }

    public boolean verifyEditTitleButton() {
        waitForSec(2);
        return btnEditTitle.isElementPresent();
    }

    public void clickOnEditTitleButton() {
        if (btnEditTitle.isElementPresent()) {
            btnEditTitle.click();
            reportLog("Successfully clicked on Edit Title Button.");
        }
    }

    public boolean verifyAreYouStuckButton() {
        return btnAreYouStuck.isElementPresent();
    }

    public void clickOnAreYouStuckButton() {
        if (btnAreYouStuck.isElementPresent()) {
            btnAreYouStuck.clickJScript();
            reportLog("Successfully clicked on Are You Stuck Button.");
        }
    }

    public boolean verifyNeedHelpText() {
        return textNeedHelp.isElementPresent();
    }

    public boolean verifyCK12EditingText() {
        return textCK12Editing.isElementPresent();
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.click();
            reportLog("Successfully clicked on Close Icon.");
        }
    }

    public boolean verifyAssignToClassButton() {
        waitForSec(15);
        return btnAssignToClass.isElementPresent();
    }

    public void clickOnAssignToClassButton() {
        if (btnAssignToClass.isElementPresent()) {
            btnAssignToClass.click();
            reportLog("Successfully clicked on Assign To Class Button.");
        }
    }

    public boolean verifyCK12ClassRoomIcon() {
        waitForSec(2);
        return iconCk12ClassRoom.isElementPresent();
    }

    public boolean verifyShareWithClassesButton() {
        return btnShareWithClasses.isElementPresent();
    }

    public void clickOnShareWithClassesButton() {
        if (btnShareWithClasses.isElementPresent()) {
            btnShareWithClasses.click();
            reportLog("Successfully clicked on Share With Classes Button.");
        }
    }

    public boolean verifyShareButton() {
        waitForSec(3);
        return btnShare.isElementPresent();
    }

    public void clickOnShareButton() {
        if (btnShare.isElementPresent()) {
            btnShare.click();
            reportLog("Successfully clicked on Share Button.");
        }
    }

    public boolean verifyShareWithClassesText() {
        return textShareWithClasses.isElementPresent();
    }

    public boolean verifyPleaseSelectClassesText() {
        return textPleaseSelectClass.isElementPresent();
    }

    public void clickOnClassNameCheckBox() {
        checkBoxClassName.clickFirstFromListOfElements();
        reportLog("Successfully clicked on First Class Name CheckBox.");
    }

    public boolean verifySuccessButton() {
        waitForSec(3);
        return btnSuccess.isElementPresent();
    }

    public void clickOnSuccessButton() {
        if (btnSuccess.isElementPresent()) {
            btnSuccess.click();
            reportLog("Successfully clicked on Success Button.");
        }
    }

    public boolean verifyAddToLibraryButton() {
        return btnAddToLibrary.isElementPresent();
    }

    public boolean verifyShowDetailsDropDown() {
        return dropDownShowDetails.isElementPresent();
    }

    public void scrollToViewDetails(){
        btnShareWithClasses.scrollIntoView();
        reportLog("Successfully Scroll To View Details");
    }

    public void clickOnShowDetailsDropDown() {
        if (dropDownShowDetails.isElementPresent()) {
            dropDownShowDetails.click();
            reportLog("Successfully clicked on Show Details Drop Down.");
        }
    }

    public boolean verifyHideDetailsDropDown() {
        waitForSec(2);
        return dropDownHideDetails.isElementPresent();
    }

    public void clickOnHideDetailsDropDown() {
        if (dropDownHideDetails.isElementPresent()) {
            dropDownHideDetails.click();
            reportLog("Successfully clicked on Hide Details Drop Down.");
        }
    }

    public boolean verifyDescriptionText() {
        return textDescription.isElementPresent();
    }

    public boolean verifyCreatedDateText() {
        return textDateCreated.isElementPresent();
    }
}