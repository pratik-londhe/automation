package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

/**
 * Created by pratik.londhe on 8/8/2018.
 */
public class CreateFlexBookPage extends BasePage {
    private static final Logger logger = Logger.getLogger(CreateFlexBookPage.class);

    private String flexBookTitleName;
    private String detailsText;

    private final GuiControl txtArtifactTitle = new GuiControl(getElementMap().get("txtArtifactTitle"), webDriver);
    private final GuiControl btnAddContent = new GuiControl(getElementMap().get("btnAddContent"), webDriver);
    private final GuiControl linkNewChapter = new GuiControl(getElementMap().get("linkNewChapter"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl optionSearchCK12 = new GuiControl(getElementMap().get("optionSearchCK12"), webDriver);
    private final GuiControl inputtextSearchBox = new GuiControl(getElementMap().get("inputtextSearchBox"), webDriver);
    private final GuiControl buttonSearch = new GuiControl(getElementMap().get("buttonSearch"), webDriver);
    private final GuiControl buttonAddConceptInFlexbook = new GuiControl(getElementMap().get("buttonAddConceptInFlexbook"), webDriver);
    private final GuiControl optionModality = new GuiControl(getElementMap().get("optionModality"), webDriver);
    private final GuiControl inputtextModality = new GuiControl(getElementMap().get("inputtextModality"), webDriver);
    private final GuiControl inputtextModalityFlexBook = new GuiControl(getElementMap().get("inputtextModalityFlexBook"), webDriver);
    private final GuiControl buttonSaveModality = new GuiControl(getElementMap().get("buttonSaveModality"), webDriver);
    private final GuiControl buttonGoBackFromModality = new GuiControl(getElementMap().get("buttonGoBackFromModality"), webDriver);
    private final GuiControl buttonDiscardModality = new GuiControl(getElementMap().get("buttonDiscardModality"), webDriver);
    private final GuiControl buttonConfirmDiscardModality = new GuiControl(getElementMap().get("buttonConfirmDiscardModality"), webDriver);
    private final GuiControl textArea = new GuiControl(getElementMap().get("textArea"), webDriver);
    private final GuiControl btnGotIt = new GuiControl(getElementMap().get("btnGotIt"), webDriver);
    private final GuiControl invalidTitleOnPopUp = new GuiControl(getElementMap().get("invalidTitleOnPopUp"), webDriver);
    private final GuiControl popUpMessage = new GuiControl(getElementMap().get("popUpMessage"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl btnCancelNew = new GuiControl(getElementMap().get("btnCancelNew"), webDriver);
    private final GuiControl btnEditTitle = new GuiControl(getElementMap().get("btnEditTitle"), webDriver);
    private final GuiControl btnEditTitleNew = new GuiControl(getElementMap().get("btnEditTitleNew"), webDriver);
    private final GuiControl linkItemFromSearch = new GuiControl(getElementMap().get("linkItemFromSearch"), webDriver);
    private final GuiControl iconCross = new GuiControl(getElementMap().get("iconCross"), webDriver);
    private final GuiControl txtFlexBookTitle = new GuiControl(getElementMap().get("txtFlexBookTitle"), webDriver);
    private final GuiControl tabDetails = new GuiControl(getElementMap().get("tabDetails"), webDriver);
    private final GuiControl placeHolderLearningObjective = new GuiControl(getElementMap().get("placeHolderLearningObjective"), webDriver);
    private final GuiControl btnCancelReadMod = new GuiControl(getElementMap().get("btnCancelReadMod"), webDriver);
    private final GuiControl btnEditTitleReadMod = new GuiControl(getElementMap().get("btnEditTitleReadMod"), webDriver);

    public CreateFlexBookPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void enterCourseBookTitle(String courseBookTitle) {
        waitForSec(5);
        txtArtifactTitle.isElementPresent();
        flexBookTitleName = courseBookTitle + currentTimeStamp();
        txtArtifactTitle.setText(flexBookTitleName);
        reportLog("Entered the FlexBook book title.");
    }

    public void clickOnSaveBtn() {
        if (btnSave.isElementPresent()) {
            btnSave.clickJScript();
            reportLog("Clicked on the save button.");
        }
    }

    public void clickOnAddContentBtn() {
        if (btnAddContent.isElementPresent()) {
            btnAddContent.click();
            reportLog("Clicked on the add content button.");
        }
    }

    public void clickOnNewChapterLink() {
        if (linkNewChapter.isElementPresent()) {
            linkNewChapter.click();
            reportLog("Clicked on the new chapter link.");
        }
    }

    public void selectSearchCK12Option() {
        optionSearchCK12.isElementPresent();
        optionSearchCK12.click();
    }

    public void enterConceptAddLibrary(String concept) {
        inputtextSearchBox.setText(concept);
    }

    public boolean verifySearchButton() {
        return buttonSearch.isElementPresent();
    }

    public void clickOnSearchButton() {
        buttonSearch.click();
    }

    public void clickOnAddConceptToFlexbook() {
        buttonAddConceptInFlexbook.isElementPresent();
        buttonAddConceptInFlexbook.click();
        waitForSec(5);
    }

    public boolean verifyAddToFlexBookButton() {
        return buttonAddConceptInFlexbook.isElementPresent();
    }

    public void selectModality() {
        optionModality.click();
    }

    public void enterModalityName(String name) {
        inputtextModality.setText(name + currentTimeStamp());
    }

    public void enterModalityNameFlexBook(String name) {
        inputtextModalityFlexBook.setText(name + currentTimeStamp());
    }

    public void clickOnSaveModality() {
        try {
            buttonSaveModality.click();
            waitForSec(5);
        } catch (Exception e) {
            logger.error("Save button is not displaying. Printing stack trace and continuing execution... " + "\n" + e);
        }
    }

    public boolean verifySaveModalityButton() {
        return buttonSaveModality.isElementPresent();
    }

    public void clickOnGoBackButton() {
        waitForSec(5);
        if (buttonDiscardModality.isElementPresent()) {
            buttonDiscardModality.clickJScript();
            waitForSec(2);
            if (buttonConfirmDiscardModality.isElementPresent()){
                buttonConfirmDiscardModality.clickJScript();
                waitForSec(5);
            }
        }else if (buttonGoBackFromModality.isElementPresent()) {
            buttonGoBackFromModality.clickJScript();
            waitForSec(5);
        }
    }

    public boolean verifyGoBackModalityButton() {
        waitForSec(5);
        return buttonGoBackFromModality.isElementPresent();
    }

    public void enterDetailsForModality(String details) {
        waitForSec(5);
        textArea.click();
        detailsText = details + currentTimeStamp();
        detailsText = details + currentTimeStamp();
        textArea.setText(detailsText);
        waitForSec(5);
    }

    public void clickOnGotItButtonPopUp() {
        try {
            waitForSec(5);
            btnGotIt.click();
        } catch (Exception e) {
            logger.error("'Got it' button is not displayed. Printing stack trace and continuing execution... " + "\n" + e);
        }
    }

    public boolean isInvalidTitleOnPopUpVisible() {
        return invalidTitleOnPopUp.isElementPresent();
    }

    public boolean isMessageOnPopUpVisible() {
        return popUpMessage.isElementPresent();
    }

    public boolean isCancelBtnOnPopUpVisible() {
        waitForSec(2);
        return btnCancel.isElementPresent();
    }

    public boolean isCancelNewBtnOnPopUpVisible() {
        waitForSec(5);
        return btnCancelNew.isElementPresent();
    }

    public boolean isCancelBtnOnPopUpVisibleReadMod() {
        waitForSec(2);
        return btnCancelReadMod.isElementPresent();
    }


    public boolean isEditTitleBtnOnPopUpVisible() {
        return btnEditTitle.isElementPresent();
    }

    public boolean isEditTitleNewBtnOnPopUpVisible() {
        return btnEditTitleNew.isElementPresent();
    }

    public boolean isEditTitleBtnOnPopUpVisibleReadMod() {
        return btnEditTitleReadMod.isElementPresent();
    }

    public void selectConceptFromList() {
        if (linkItemFromSearch.isElementPresent()) {
            linkItemFromSearch.clickFirstFromListOfElements();
            reportLog("Selected the first concept form list");
        }
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.click();
            reportLog("Clicked on the cancel button.");
        }
    }

    public void clickOnCancelNewButton() {
        if (btnCancelNew.isElementPresent()) {
            btnCancelNew.click();
            reportLog("Clicked on the cancel button.");
        }
    }

    public void clickOnEditTitleButton() {
        if (btnEditTitle.isElementPresent()) {
            btnEditTitle.click();
            reportLog("Clicked on the Edit Title button.");
        }
    }
    public void clickOnEditTitleNewButton() {
        if (btnEditTitleNew.isElementPresent()) {
            btnEditTitleNew.click();
            reportLog("Clicked on the Edit Title button.");
        }
    }

    public void clickOnEditTitleButtonReadMod() {
        if (btnEditTitleReadMod.isElementPresent()) {
            btnEditTitleReadMod.click();
            reportLog("Clicked on the Edit Title button.");
        }
    }

    public boolean verifyCrossIcon() {
        return iconCross.isElementPresent();
    }

    public boolean verifySaveButton() {
        return btnSave.isElementPresent();
    }

    public boolean verifyNewChapterLink() {
        linkNewChapter.mouseHover();
        return linkNewChapter.isElementPresent();
    }

    public void clickOnCrossIcon() {
        if (iconCross.isElementPresent()) {
            iconCross.click();
            reportLog("Clicked on the cross Icon.");
        }
    }

    public boolean verifyFlexBookTitle() {
        waitForSec(5);
        logger.error("Title Name is =" + flexBookTitleName);
        if (flexBookTitleName.equalsIgnoreCase(txtFlexBookTitle.getText())) {
            reportLog("SuccessFully Verified Recently Added FlexBook");
            return true;
        }
        reportLog("Failed To Verified Recently Added FlexBook");
        return false;
    }

    public boolean verifyDetailsTab() {
        waitForSec(5);
        return tabDetails.isElementPresent();
    }

    public void clickOnDetailsTab() {
        waitForSec(4);
        if (tabDetails.isElementPresent()) {
            tabDetails.click();
            reportLog("Clicked on Details Tab.");
        }
    }

    public void clickOnLearningObjectivePlaceHolder() {
        if (placeHolderLearningObjective.isElementPresent()) {
            placeHolderLearningObjective.click();
            reportLog("Clicked on learning Objective PlaceHolder");
        }
    }
}