package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CreatedReadModalityFeaturePage extends BasePage {
    private static final Logger logger = Logger.getLogger(CreatedReadModalityFeaturePage.class);

    private final GuiControl placeHolderEdit = new GuiControl(getElementMap().get("placeHolderEdit"), webDriver);
    private final GuiControl btnKeepAsDraft = new GuiControl(getElementMap().get("btnKeepAsDraft"), webDriver);
    private final GuiControl btnFinalize = new GuiControl(getElementMap().get("btnFinalize"), webDriver);
    private final GuiControl textHighlightText = new GuiControl(getElementMap().get("textHighlightText"), webDriver);
    private final GuiControl buttonAddToFlexBook = new GuiControl(getElementMap().get("buttonAddToFlexBook"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl btnOK = new GuiControl(getElementMap().get("btnOK"), webDriver);
    private final GuiControl textError = new GuiControl(getElementMap().get("textError"), webDriver);
    private final GuiControl btnOkOfErrorMsg = new GuiControl(getElementMap().get("btnOkOfErrorMsg"), webDriver);
    private final GuiControl iconPlus = new GuiControl(getElementMap().get("iconPlus"), webDriver);
    private final GuiControl dataText = new GuiControl(getElementMap().get("dataText"), webDriver);
    private final GuiControl textInHighlightSection = new GuiControl(getElementMap().get("textInHighlightSection"), webDriver);
    private final GuiControl deleteIcon = new GuiControl(getElementMap().get("deleteIcon"), webDriver);
    private final GuiControl textNotesHighlight = new GuiControl(getElementMap().get("textNotesHighlight"), webDriver);
    private final GuiControl placeHolderAddNote = new GuiControl(getElementMap().get("placeHolderAddNote"), webDriver);
    private final GuiControl btnNotesAndHighlight = new GuiControl(getElementMap().get("btnNotesAndHighlight"), webDriver);
    private final GuiControl textInNotesSection = new GuiControl(getElementMap().get("textInNotesSection"), webDriver);
    private final GuiControl dropDownFlexBookVersion = new GuiControl(getElementMap().get("dropDownFlexBookVersion"), webDriver);
    private final GuiControl linkFlexBookSecondVersion = new GuiControl(getElementMap().get("linkFlexBookSecondVersion"), webDriver);
    private final GuiControl textFlexBookSecondVersion = new GuiControl(getElementMap().get("textFlexBookSecondVersion"), webDriver);
    private final GuiControl txtPlaceHolder = new GuiControl(getElementMap().get("txtPlaceHolder"), webDriver);
    private final GuiControl linkPublish = new GuiControl(getElementMap().get("linkPublish"), webDriver);
    private final GuiControl btnPublish = new GuiControl(getElementMap().get("btnPublish"), webDriver);
    private final GuiControl textContributionTypeErrorMsg = new GuiControl(getElementMap().get("textContributionTypeErrorMsg"), webDriver);
    private final GuiControl checkBoxCK12ContributionType = new GuiControl(getElementMap().get("checkBoxCK12ContributionType"), webDriver);
    private final GuiControl textModalityPublished = new GuiControl(getElementMap().get("textModalityPublished"), webDriver);
    private final GuiControl tagBold = new GuiControl(getElementMap().get("tagBold"), webDriver);
    private final GuiControl dropDownShowResources = new GuiControl(getElementMap().get("dropDownShowResources"), webDriver);
    private final GuiControl dropDownHideResources = new GuiControl(getElementMap().get("dropDownHideResources"), webDriver);
    private final GuiControl textNoResources = new GuiControl(getElementMap().get("textNoResources"), webDriver);
    private final GuiControl btnResources = new GuiControl(getElementMap().get("btnResources"), webDriver);
    private final GuiControl btnEdit = new GuiControl(getElementMap().get("btnEdit"), webDriver);

    public CreatedReadModalityFeaturePage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void enterDataInEditPlaceHolder(String textData) {
        placeHolderEdit.clickJScript();
        placeHolderEdit.sendKeys(textData);
        reportLog("Entered Value In Edit PlaceHolder And Data Is = " + textData);
    }

    public void enteredInToParentFrame() {
        waitForSec(15);
        webDriver.switchTo().frame("artifact_content_ifr");
        reportLog("Successfully Entered Into Frame");
    }

    public void removeFromFrame() {
        webDriver.switchTo().defaultContent();
        reportLog("Successfully Remove From Frame");
    }

    public boolean verifyKeepAsDraftButton() {
        waitForSec(2);
        return btnKeepAsDraft.isElementPresent();
    }

    public void clickOnKeepAsDraftButton() {
        if (btnKeepAsDraft.isElementPresent()) {
            btnKeepAsDraft.click();
            reportLog("Successfully click on keep As Draft Button");
        }
    }

    public boolean verifyFinalizeButton() {
        waitForSec(5);
        return btnFinalize.isElementPresent();
    }

    public void clickOnFinalizeButton() {
        if (btnFinalize.isElementPresent()) {
            btnFinalize.click();
            reportLog("Successfully click on Finalize Button");
        }
    }

    public boolean verifyHighlightText() {
        return textHighlightText.isElementPresent();
    }

    public boolean verifyAddToFlexBookButton() {
        waitForSec(5);
        return buttonAddToFlexBook.isElementPresent();
    }

    public void clickOnAddToFlexBookButton() {
        if (buttonAddToFlexBook.isElementPresent()) {
            buttonAddToFlexBook.click();
            reportLog("Successfully click on Add To FlexBook Button");
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

    public boolean verifyOkButton() {
        waitForSec(5);
        return btnOK.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOK.isElementPresent()) {
            btnOK.clickJScript();
            reportLog("Successfully clicked on Okay Button");
        }
    }

    public boolean verifyErrorText() {
        waitForSec(5);
        return textError.isElementPresent();
    }

    public void clickOnOkButtonOfErrorPopUp() {
        if (btnOkOfErrorMsg.isElementPresent()) {
            btnOkOfErrorMsg.clickJScript();
            reportLog("Successfully clicked on Okay Button");
        }
    }

    public boolean verifyPlusIcon() {
        return iconPlus.isElementPresent();
    }

    public void clickOnPlusIcon() {
        if (iconPlus.isElementPresent()) {
            iconPlus.clickJScript();
            reportLog("Successfully clicked on Plus Button");
        }
    }

    public void clickForHighlightText() {
        if (dataText.isElementPresent()) {
            dataText.doubleClick();
            reportLog("Successfully click on text for highlight");
        }
    }

    public boolean verifyHighlightedDataPresentInNotesAndHighlightSection() {
        waitForSec(5);
        return textInHighlightSection.isElementPresent();
    }

    public void clickForAddNoteInText() {
        if (dataText.isElementPresent()) {
            dataText.doubleClick();
            reportLog("Successfully click on text for Add Note");
        }
    }

    public void enterDataInAddNotePlaceHolder(String textData) {
        placeHolderAddNote.clickJScript();
        placeHolderAddNote.setText(textData);
        reportLog("Entered Value In Add Note PlaceHolder And Data Is = " + textData);
    }

    public boolean verifyNotedDataPresentInNotesAndHighlightSection() {
        waitForSec(5);
        return textInNotesSection.isElementPresent();
    }

    public boolean verifyFlexBookVersionDropDown() {
        waitForSec(2);
        return dropDownFlexBookVersion.isElementPresent();
    }

    public void clickOnFlexBookVersionDropDown() {
        if (dropDownFlexBookVersion.isElementPresent()) {
            dropDownFlexBookVersion.clickJScript();
            reportLog("Successfully clicked on FlexBook Version DropDown");
        }
    }

    public boolean verifyFlexBookSecondVersionLink() {
        waitForSec(2);
        return linkFlexBookSecondVersion.isElementPresent();
    }

    public void clickOnFlexBookSecondVersionLink() {
        if (linkFlexBookSecondVersion.isElementPresent()) {
            linkFlexBookSecondVersion.clickJScript();
            reportLog("Successfully clicked on FlexBook Second Version Link");
        }
    }

    public boolean verifyFlexBookSecondVersionIsSelected() {
        waitForSec(5);
        return textFlexBookSecondVersion.isElementPresent();
    }

    public void setNameInPlaceHolder(String name) {
        if (txtPlaceHolder.isElementPresent()) {
            txtPlaceHolder.setText(name + currentTimeStamp());
            reportLog("Successfully Set Name in PlaceHolder Text And Name is = " + name);
        }
    }

    public boolean verifyHighlightAndNotesButton() {
        buttonAddToFlexBook.scrollIntoView();
        return btnNotesAndHighlight.isElementPresent();
    }

    public void clickOnHighlightAndNotesButton() {
        if (btnNotesAndHighlight.isElementPresent()) {
            btnNotesAndHighlight.clickJScript();
            reportLog("Successfully clicked on Notes And Highlight Button");
        }
    }

    public boolean verifyNotesHighlightText() {
        waitForSec(5);
        return textNotesHighlight.isElementPresent();
    }

    public boolean verifyDeleteIcon() {
        return deleteIcon.isElementPresent();
    }

    public void clickOnDeleteIcon() {
        if (deleteIcon.isElementPresent()) {
            deleteIcon.click();
            reportLog("Successfully click on Delete Icon");
        }
    }

    public boolean verifyPublishLink() {
        return linkPublish.isElementPresent();
    }

    public void clickOnPublishLink() {
        if (linkPublish.isElementPresent()) {
            linkPublish.clickJScript();
            reportLog("Successfully clicked on Publish Link");
        }
    }

    public boolean verifyPublishButton() {
        return btnPublish.isElementPresent();
    }

    public void clickOnPublishButton() {
        if (btnPublish.isElementPresent()) {
            btnPublish.clickJScript();
            reportLog("Successfully clicked on Publish Button");
        }
    }

    public boolean verifyContributionTypeErrorMessageText() {
        waitForSec(2);
        return textContributionTypeErrorMsg.isElementPresent();
    }

    public boolean verifyCk12ContributionTypeCheckBox() {
        return checkBoxCK12ContributionType.isElementPresent();
    }

    public void clickOnCk12ContributionTypeCheckBox() {
        if (checkBoxCK12ContributionType.isElementPresent()) {
            checkBoxCK12ContributionType.clickJScript();
            reportLog("Successfully clicked on Ck12 Contribution Type CheckBox");
        }
    }

    public boolean verifyModalityPublishedText() {
        waitForSec(5);
        return textModalityPublished.isElementPresent();
    }

    public void clickOnBoldTag() {
        waitForSec(3);
        if (tagBold.isElementPresent()) {
            tagBold.clickJScript();
            reportLog("Successfully clicked on BoldTag");
        }
    }

    public boolean verifyShowResourcesDropDown() {
        return dropDownShowResources.isElementPresent();
    }

    public boolean verifyHideResourcesDropDown() {
        waitForSec(5);
        buttonAddToFlexBook.scrollIntoView();
        return dropDownHideResources.isElementPresent();
    }

    public void clickOnShowResourcesDropDown() {
        buttonAddToFlexBook.scrollIntoView();
        if (dropDownShowResources.isElementPresent()) {
            dropDownShowResources.clickJScript();
            reportLog("Successfully clicked on Show Resources DropDown");
        }
    }

    public void clickOnHideResourcesDropDown() {
        if (dropDownHideResources.isElementPresent()) {
            dropDownHideResources.clickJScript();
            reportLog("Successfully clicked on Hide Resources DropDown");
        }
    }

    public boolean verifyNoResourcesText() {
        return textNoResources.isElementPresent();
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

    public boolean verifyEditButton() {
        return btnEdit.isElementPresent();
    }

    public void clickOnEditButton() {
        if (btnEdit.isElementPresent()) {
            btnEdit.clickJScript();
            reportLog("Successfully clicked on Edit Button");
        }
    }
}
