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

public class CourseBookCreateEditAssignDelete extends BasePage {
    private static final Logger logger = Logger.getLogger(CourseBookCreateEditAssignDelete.class);

    private int count;
    private int countAfter;
    private String modalityName;
    private String requiredDate;
    private String titleName;
    private int countOfDraftText;

    private final GuiControl drpDwnCreateNew = new GuiControl(getElementMap().get("drpDwnCreateNew"), webDriver);
    private final GuiControl btnAddToCk12 = new GuiControl(getElementMap().get("btnAddToCk12"), webDriver);
    private final GuiControl linkModality = new GuiControl(getElementMap().get("linkModality"), webDriver);
    private final GuiControl linkFlexBookTextBook = new GuiControl(getElementMap().get("linkFlexBookTextBook"), webDriver);
    private final GuiControl linkFlexBook2 = new GuiControl(getElementMap().get("linkFlexBook2"), webDriver);
    private final GuiControl linkQuiz = new GuiControl(getElementMap().get("linkQuiz"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl addContentOptions = new GuiControl(getElementMap().get("addContentOptions"), webDriver);
    private final GuiControl linkSearchCk12 = new GuiControl(getElementMap().get("linkSearchCk12"), webDriver);
    private final GuiControl linkNewRead = new GuiControl(getElementMap().get("linkNewRead"), webDriver);
    private final GuiControl linkNewChapter = new GuiControl(getElementMap().get("linkNewChapter"), webDriver);
    private final GuiControl btnGoBAck = new GuiControl(getElementMap().get("btnGoBAck"), webDriver);
    private final GuiControl spanContentNames = new GuiControl(getElementMap().get("spanContentNames"), webDriver);
    private final GuiControl inputTextModality = new GuiControl(getElementMap().get("inputTextModality"), webDriver);
    private final GuiControl btnOk = new GuiControl(getElementMap().get("btnOk"), webDriver);
    private final GuiControl txtPleaseAddContent = new GuiControl(getElementMap().get("txtPleaseAddContent"), webDriver);
    private final GuiControl txtPleaseEnterSearchTerm = new GuiControl(getElementMap().get("txtPleaseEnterSearchTerm"), webDriver);
    private final GuiControl btnEdit = new GuiControl(getElementMap().get("btnEdit"), webDriver);
    private final GuiControl spanFlexBookNames = new GuiControl(getElementMap().get("spanFlexBookNames"), webDriver);
    private final GuiControl txtContent = new GuiControl(getElementMap().get("txtContent"), webDriver);
    private final GuiControl placeHolderChapterTitle = new GuiControl(getElementMap().get("placeHolderChapterTitle"), webDriver);
    private final GuiControl btnNewChapterDone = new GuiControl(getElementMap().get("btnNewChapterDone"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl btnEditTitle = new GuiControl(getElementMap().get("btnEditTitle"), webDriver);
    private final GuiControl linkAuthor = new GuiControl(getElementMap().get("linkAuthor"), webDriver);
    private final GuiControl btnKeepDraft = new GuiControl(getElementMap().get("btnKeepDraft"), webDriver);
    private final GuiControl btnFinalizeDraft = new GuiControl(getElementMap().get("btnFinalizeDraft"), webDriver);
    private final GuiControl btnDiscardDraft = new GuiControl(getElementMap().get("btnDiscardDraft"), webDriver);
    private final GuiControl btnPermanentlyDiscard = new GuiControl(getElementMap().get("btnPermanentlyDiscard"), webDriver);
    private final GuiControl btnKeepEditing = new GuiControl(getElementMap().get("btnKeepEditing"), webDriver);
    private final GuiControl btnContinueEditing = new GuiControl(getElementMap().get("btnContinueEditing"), webDriver);
    private final GuiControl btnFinalize = new GuiControl(getElementMap().get("btnFinalize"), webDriver);
    private final GuiControl txtDraft = new GuiControl(getElementMap().get("txtDraft"), webDriver);
    private final GuiControl iconCk12ClassRoom = new GuiControl(getElementMap().get("iconCk12ClassRoom"), webDriver);
    private final GuiControl iconGoogleClassRoom = new GuiControl(getElementMap().get("iconGoogleClassRoom"), webDriver);
    private final GuiControl txtAssignToClass = new GuiControl(getElementMap().get("txtAssignToClass"), webDriver);
    private final GuiControl txtStartDate = new GuiControl(getElementMap().get("txtStartDate"), webDriver);
    private final GuiControl txtDueDate = new GuiControl(getElementMap().get("txtDueDate"), webDriver);
    private final GuiControl btnShowAnswer = new GuiControl(getElementMap().get("btnShowAnswer"), webDriver);
    private final GuiControl iconEditTitle = new GuiControl(getElementMap().get("iconEditTitle"), webDriver);
    private final GuiControl txtTitleValue = new GuiControl(getElementMap().get("txtTitleValue"), webDriver);
    private final GuiControl btnGotIt = new GuiControl(getElementMap().get("btnGotIt"), webDriver);
    private final GuiControl popUp = new GuiControl(getElementMap().get("popUp"), webDriver);

    public CourseBookCreateEditAssignDelete(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyAddToCk12Button() {
        waitForSec(10);
        return btnAddToCk12.isElementPresent();
    }

    public boolean verifyCreateNewDropDown() {
        waitForSec(10);
        return drpDwnCreateNew.isElementPresent();
    }

    public void clickOnCreateNewDropDown() {
        if (drpDwnCreateNew.isElementPresent()) {
            drpDwnCreateNew.clickJScript();
            reportLog("Clicked on Create New DropDown");
        }
        waitForSec(3);
    }

    public boolean verifyModalityLink() {
        linkModality.mouseHover();
        return linkModality.isElementPresent();
    }

    public boolean verifyFlexBookTextBookLink() {
        linkFlexBookTextBook.mouseHover();
        return linkFlexBookTextBook.isElementPresent();
    }

    public boolean verifyFlexBook2Link() {
        linkFlexBook2.mouseHover();
        return linkFlexBook2.isElementPresent();
    }

    public void clickOnFlexBook2Link() {
        if (linkFlexBook2.isElementPresent()) {
            linkFlexBook2.clickJScript();
            reportLog("Clicked on link FlexBook2");
        }
    }

    public boolean verifyQuizLink() {
        linkQuiz.mouseHover();
        return linkQuiz.isElementPresent();
    }

    public void clickOnPoUP() {
        try {
            if (popUp.isDisplayed()) {
                popUp.clickJScript();
            }
        } catch (Exception e) {
           logger.info(e);
        }
    }

    public boolean verifyAddContentOptions() {
        waitForSec(10);
        return addContentOptions.isElementPresent();
    }

    public void clickOnAddContentDropDown() {
        //commenting out because this UI element has been changed
/*        if (addContentOptions.isElementPresent()) {
            addContentOptions.clickJScript();
            reportLog("Clicked On Add Content DropDown");
        }*/
    }

    public boolean verifySaveButton() {
        return btnSave.isElementPresent();
    }

    public void clickOnSaveButton() {
        waitForSec(3);
        if (btnSave.isElementPresent()) {
            btnSave.click();
            reportLog("Clicked On Save Button");
        }
    }

    public boolean verifySearchCk12Link() {
        linkSearchCk12.mouseHover();
        return linkSearchCk12.isElementPresent();
    }

    public void clickOnSearchCk12Link() {
        if (linkSearchCk12.isElementPresent()) {
            linkSearchCk12.clickJScript();
            reportLog("Clicked On Search Ck12 Link");
        }
    }

    public boolean verifyNewReadLink() {
        linkNewRead.mouseHover();
        return linkNewRead.isElementPresent();
    }

    public void clickOnNewReadLink() {
        if (linkNewRead.isElementPresent()) {
            linkNewRead.clickJScript();
            reportLog("Clicked On New Read Link");
        }
    }

    public boolean verifyNewChapterLink() {
        linkNewChapter.mouseHover();
        return linkNewChapter.isElementPresent();
    }

    public void clickOnNewChapterLink() {
        if (linkNewChapter.isElementPresent()) {
            linkNewChapter.clickJScript();
            reportLog("Clicked On New Chapter Link");
        }
    }

    public boolean verifyGoBAckButton() {
        return btnGoBAck.isElementPresent();
    }

    public void clickOnGoBAckButton() {
        if (btnGoBAck.isElementPresent()) {
            btnGoBAck.click();
            reportLog("Clicked On Go Back Button");
        }
    }

    public void getCountOfContents() {
        waitForSec(3);
        List<WebElement> names = spanContentNames.getWebElement().findElements(By.xpath("//div[@class='artifact_row js_artifact_row']//div[2]//span"));
        count = names.size();
        reportLog("Successfully Get Count Of Content And Count is = " + count);
    }

    public void getCountOfContentsBefore() {
        waitForSec(3);
        List<WebElement> names = txtContent.getWebElement().findElements(By.xpath("//div[@class='artifact_row js_artifact_row']"));
        count = names.size();
        reportLog("Successfully Get Count Of Content Before And Count is = " + count);
    }

    public void getCountOfContentsAfter() {
        waitForSec(3);
        List<WebElement> names = txtContent.getWebElement().findElements(By.xpath("//div[@class='artifact_row js_artifact_row']"));
        countAfter = names.size();
        reportLog("Successfully Get Count Of Content after And Count is = " + countAfter);
    }

    public boolean verifyContentList() {
        return count > 0;
    }

    public boolean verifyContentListCountAfterSave() {
        return count != countAfter;
    }

    public void enterModalityNameAgain(String name) {
        modalityName = name + currentTimeStamp();
        inputTextModality.setText(modalityName);
        logger.error("Modality Name again is =" + modalityName);
    }

    public boolean verifyEditedContentAddedInList() {
        waitForSec(3);
        logger.error("Modality Name while editing is =" + modalityName);
        List<WebElement> names = spanContentNames.getWebElement().findElements(By.xpath("//div[@class='artifact_row js_artifact_row']//div[1]//span"));
        for (WebElement list : names) {
            if (list.getText().equalsIgnoreCase(modalityName)) {
                reportLog("SuccessFully Verified Recently Added Content");
                return true;
            }
        }
        reportLog("Failed To Verified Recently Added Content");
        return false;
    }

    public boolean verifyPleaseAddContentText() {
        return txtPleaseAddContent.isElementPresent();
    }

    public boolean verifyOkButton() {
        return btnOk.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOk.isElementPresent()) {
            btnOk.clickJScript();
            reportLog("Clicked On Ok Button");
        }
    }

    public boolean verifyPleaseEnterSearchTermText() {
        return txtPleaseEnterSearchTerm.isElementPresent();
    }

    public void clickOnEditButton() {
        if (btnEdit.isElementPresent()) {
            btnEdit.mouseHover();
            btnEdit.click();
            reportLog("Clicked On Edit Button");
        }
    }

    public boolean verifyFlexBookNameAddedInList() {
        waitForSec(3);
        logger.error("FlexBook Modality Name is =" + modalityName);
        List<WebElement> names = spanFlexBookNames.getWebElement().findElements(By.xpath("//a[@class='dxtrack-user-action']//b//div//span[1]"));
        for (WebElement list : names) {
            reportLog("FlexBook Names =" + list.getText());
            if (list.getText().equalsIgnoreCase(modalityName)) {
                reportLog("SuccessFully Verified Recently Added FlexBook");
                return true;
            }
        }
        reportLog("Failed To Verified Recently Added FlexBook");
        return false;
    }

    public boolean verifyNewChapterDoneButton() {
        waitForSec(3);
        return btnNewChapterDone.isElementPresent();
    }

    public void clickOnNewChapterDoneButton() {
        if (btnNewChapterDone.isElementPresent()) {
            btnNewChapterDone.mouseHover();
            btnNewChapterDone.click();
            reportLog("Clicked On Save Chapter Button");
        }
    }

    public void setChapterName(String chapterName) {
        if (placeHolderChapterTitle.isElementPresent()) {
            placeHolderChapterTitle.clickJScript();
            modalityName = chapterName + currentTimeStamp();
            placeHolderChapterTitle.setText(modalityName);
            logger.error("Successfully Set Modality Name");
        }
    }

    public boolean isDeleteRowButtonPresent() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        waitForSec(3);
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Clicked On Close Icon");
        }
    }

    public boolean verifyEditTitleButton() {
        return btnEditTitle.isElementPresent();
    }

    public void clickOnEditTitleButton() {
        if (btnEditTitle.isElementPresent()) {
            btnEditTitle.clickJScript();
            reportLog("Clicked On Edit Title Button");
        }
    }

    public boolean verifyAuthorLink() {
        waitForSec(3);
        return linkAuthor.isElementPresent();
    }

    public boolean verifyKeepDraftButton() {
        return btnKeepDraft.isElementPresent();
    }

    public void clickOnKeepDraftButton() {
        if (btnKeepDraft.isElementPresent()) {
            btnKeepDraft.clickJScript();
            reportLog("Clicked on Keep As A Draft Button");
        }
    }

    public boolean verifyFinalizeDraftButton() {
        return btnFinalizeDraft.isElementPresent();
    }

    public void clickOnFinalizeDraftButton() {
        if (btnFinalizeDraft.isElementPresent()) {
            btnFinalizeDraft.clickJScript();
            reportLog("Clicked on Finalize Draft Button");
        }
    }

    public boolean verifyDiscardDraftButton() {
        return btnDiscardDraft.isElementPresent();
    }

    public void clickOnDiscardDraftButton() {
        if (btnDiscardDraft.isElementPresent()) {
            btnDiscardDraft.clickJScript();
            reportLog("Clicked On Discard Draft Button");
        }
    }

    public boolean verifyPermanentlyDiscardButton() {
        return btnPermanentlyDiscard.isElementPresent();
    }

    public void clickOnPermanentlyDiscardButton() {
        if (btnPermanentlyDiscard.isElementPresent()) {
            btnPermanentlyDiscard.clickJScript();
            reportLog("Clicked On Permanently Discard Button");
        }
    }

    public boolean verifyKeepEditingButton() {
        return btnKeepEditing.isElementPresent();
    }

    public void clickOnKeepEditingButton() {
        if (btnKeepEditing.isElementPresent()) {
            btnKeepEditing.clickJScript();
            reportLog("Clicked On Keep Editing Button");
        }
    }

    public boolean verifyContinueEditingButton() {
        return btnContinueEditing.isElementPresent();
    }

    public void clickOnContinueEditingButton() {
        if (btnContinueEditing.isElementPresent()) {
            btnContinueEditing.clickJScript();
            reportLog("Clicked On Continue Editing Button");
        }
    }

    public boolean verifyFinalizeButton() {
        return btnFinalize.isElementPresent();
    }

    public void clickOnFinalizeButton() {
        if (btnFinalize.isElementPresent()) {
            btnFinalize.clickJScript();
            reportLog("Clicked On Finalize Button");
        }
    }

    public void getCountOfDraftText() {
        waitForSec(3);
        List<WebElement> names = txtDraft.getWebElement().findElements(By.xpath("//div[@class='row_artifact_title js_artifact_title']//span[2]"));
        countOfDraftText = names.size();
        reportLog("Successfully Get Count Of Draft Text And Count is = " + countOfDraftText);
    }

    public boolean verifyContentListDraftCount() {
        if (countOfDraftText > 0) {
            return true;
        }
        return false;
    }

    public boolean verifyCk12ClassRoomIcon() {
        return iconCk12ClassRoom.isElementPresent();
    }

    public boolean verifyGoogleClassRoomIcon() {
        return iconGoogleClassRoom.isElementPresent();
    }

    public void clickOnCk12ClassRoomIcon() {
        if (iconCk12ClassRoom.isElementPresent()) {
            iconCk12ClassRoom.clickJScript();
            reportLog("Clicked On Ck12 ClassRoom Icon");
        }
    }

    public boolean verifyAssignToClassText() {
        return txtAssignToClass.isElementPresent();
    }

    public boolean verifyStartDateText() {
        return txtStartDate.isElementPresent();
    }

    public void clickOnStartDatePlaceHolder() {
        if (txtStartDate.isElementPresent()) {
            txtStartDate.clickJScript();
            reportLog("Clicked On Start Date PlaceHolder");
        }
    }

    public boolean verifyDueDateText() {
        return txtDueDate.isElementPresent();
    }

    public void getDueDateText() {
        waitForSec(3);
        requiredDate = txtDueDate.getText();
    }

    public void clickOnDueDatePlaceHolder() {
        if (txtDueDate.isElementPresent()) {
            txtDueDate.clickJScript();
            reportLog("Clicked On Due Date PlaceHolder");
        }
    }

    public boolean verifyRequiredDueDateText() {
        return "required".equalsIgnoreCase(requiredDate);
    }

    public boolean verifyShowAnswerButton() {
        waitForSec(3);
        return btnShowAnswer.isElementPresent();
    }

    public void clickOnShowAnswerButton() {
        if (btnShowAnswer.isElementPresent()) {
            btnShowAnswer.clickJScript();
            reportLog("Clicked On Show Answer Button");
        }
    }

    public boolean verifyEditTitleIcon() {
        return iconEditTitle.isElementPresent();
    }

    public void clickOnEditTitleIcon() {
        if (iconEditTitle.isElementPresent()) {
            iconEditTitle.clickJScript();
            reportLog("Clicked On Edit Title Icon");
        }
    }

    public boolean verifyTitleText() {
        return txtTitleValue.isElementPresent();
    }

    public void getValueOfTitleText() {
        if (txtTitleValue.isElementPresent()) {
            titleName = txtTitleValue.getAttribute("value");
            reportLog("Successfully Get Title Name And Title Name Is = " + titleName);
        }
    }

    public boolean verifyGotItButton() {
        return btnGotIt.isElementPresent();
    }

    public void clickOnGotItButton() {
        if (btnGotIt.isElementPresent()) {
            btnGotIt.clickJScript();
            reportLog("Successfully clicked On Got It Button");
        }
    }
}