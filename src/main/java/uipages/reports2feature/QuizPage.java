package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class QuizPage extends BasePage {

    private String conceptName;
    private int countOfContainer;

    private final GuiControl moduleTitle = new GuiControl(getElementMap().get("moduleTitle"), webDriver);
    private final GuiControl privacyLink = new GuiControl(getElementMap().get("privacyLink"), webDriver);
    private final GuiControl linkAddQuiz = new GuiControl(getElementMap().get("linkAddQuiz"), webDriver);
    private final GuiControl linkCreateNewLink = new GuiControl(getElementMap().get("linkCreateNewLink"), webDriver);
    private final GuiControl btnBack = new GuiControl(getElementMap().get("btnBack"), webDriver);
    private final GuiControl btnCreate = new GuiControl(getElementMap().get("btnCreate"), webDriver);
    private final GuiControl iconAlert = new GuiControl(getElementMap().get("iconAlert"), webDriver);
    private final GuiControl txtQuestionRequired = new GuiControl(getElementMap().get("txtQuestionRequired"), webDriver);
    private final GuiControl placeHolderTitle = new GuiControl(getElementMap().get("placeHolderTitle"), webDriver);
    private final GuiControl iconAddQuestion = new GuiControl(getElementMap().get("iconAddQuestion"), webDriver);
    private final GuiControl textChooseConcept = new GuiControl(getElementMap().get("textChooseConcept"), webDriver);
    private final GuiControl btnSelect = new GuiControl(getElementMap().get("btnSelect"), webDriver);
    private final GuiControl placeHolderSearchConcept = new GuiControl(getElementMap().get("placeHolderSearchConcept"), webDriver);
    private final GuiControl iconCloseSearchConcept = new GuiControl(getElementMap().get("iconCloseSearchConcept"), webDriver);
    private final GuiControl chkBoxSearchResult = new GuiControl(getElementMap().get("chkBoxSearchResult"), webDriver);
    private final GuiControl iconSearch = new GuiControl(getElementMap().get("iconSearch"), webDriver);
    private final GuiControl textSearchResult = new GuiControl(getElementMap().get("textSearchResult"), webDriver);
    private final GuiControl btnGotIt = new GuiControl(getElementMap().get("btnGotIt"), webDriver);
    private final GuiControl iconRemove = new GuiControl(getElementMap().get("iconRemove"), webDriver);
    private final GuiControl btnPreview = new GuiControl(getElementMap().get("btnPreview"), webDriver);
    private final GuiControl btnBackToAssignment = new GuiControl(getElementMap().get("btnBackToAssignment"), webDriver);
    private final GuiControl textQuizCreated = new GuiControl(getElementMap().get("textQuizCreated"), webDriver);
    private final GuiControl textPreview = new GuiControl(getElementMap().get("textPreview"), webDriver);
    private final GuiControl textDeskTop = new GuiControl(getElementMap().get("textDeskTop"), webDriver);
    private final GuiControl btnUpdate = new GuiControl(getElementMap().get("btnUpdate"), webDriver);
    private final GuiControl btnClose = new GuiControl(getElementMap().get("btnClose"), webDriver);
    private final GuiControl iconEdit = new GuiControl(getElementMap().get("iconEdit"), webDriver);
    private final GuiControl btnAddQuestion = new GuiControl(getElementMap().get("btnAddQuestion"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl iconBackToPrevious = new GuiControl(getElementMap().get("iconBackToPrevious"), webDriver);
    private final GuiControl textConceptName = new GuiControl(getElementMap().get("textConceptName"), webDriver);
    private final GuiControl textEditQuiz = new GuiControl(getElementMap().get("textEditQuiz"), webDriver);
    private final GuiControl iconCreateNewQuestions = new GuiControl(getElementMap().get("iconCreateNewQuestions"), webDriver);
    private final GuiControl headerText = new GuiControl(getElementMap().get("headerText"), webDriver);
    private final GuiControl linkAddQuizProd = new GuiControl(getElementMap().get("linkAddQuizProd"), webDriver);
    private final GuiControl assignmentName = new GuiControl(getElementMap().get("assignmentName"), webDriver);
    private final GuiControl selectClass = new GuiControl(getElementMap().get("selectClass"), webDriver);
    private final GuiControl saveAssignment = new GuiControl(getElementMap().get("saveAssignment"), webDriver);
    private final GuiControl btnSaveProd = new GuiControl(getElementMap().get("btnSaveProd"), webDriver);
    private final GuiControl score = new GuiControl(getElementMap().get("score"), webDriver);
    private final GuiControl dueDate = new GuiControl(getElementMap().get("dueDate"), webDriver);
    private final GuiControl currentDate = new GuiControl(getElementMap().get("currentDate"), webDriver);

    public QuizPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyBackToPreviousPageIcon() {
        return iconBackToPrevious.isElementPresent();
    }

    public void clickOnBackToPreviousPageIcon() {
        if (iconBackToPrevious.isElementPresent()) {
            iconBackToPrevious.clickJScript();
            reportLog("Successfully click On Back To Previous Page Icon");
        }
    }

    public boolean verifyConceptNameText() {
        return textConceptName.isElementPresent();
    }

    public boolean verifyEditQuizText() {
        waitForSec(8);
        return textEditQuiz.isElementPresent();
    }

    public boolean verifyAddQuestionButton() {
        waitForSec(5);
        return btnAddQuestion.isElementPresent();
    }

    public void clickOnAddQuestionButton() {
        if (btnAddQuestion.isElementPresent()) {
            btnAddQuestion.clickJScript();
            reportLog("Successfully click On Add Question Button");
        }
        waitForSec(8);
    }

    public boolean verifyCancelButton() {
        return btnCancel.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.clickJScript();
            reportLog("Successfully click On Cancel Button");
        }
    }

    public boolean verifySaveButton() {
        return btnSave.isElementPresent();
    }

    public void clickOnSaveButton() {
        if (btnSave.isElementPresent()) {
            btnSave.clickJScript();
            reportLog("Successfully click On Save Button");
        }
    }

    public void clickOnSaveButtonProd() {
        if (btnSaveProd.isElementPresent()) {
            btnSaveProd.clickJScript();
            reportLog("Successfully click On Save Button");
            waitForSec(4);
        }
    }

    public boolean verifyEditIcon() {
        waitForSec(4);
        iconEdit.mouseHover();
        return iconEdit.isElementPresent();
    }

    public void clickOnEditIcon() {
        if (iconEdit.isElementPresent()) {
            iconEdit.mouseHover();
            iconEdit.clickJScript();
            reportLog("Successfully click On Edit Icon");
        }
        waitForSec(5);
    }

    public boolean verifyUpdateButton() {
        waitForSec(5);
        iconAddQuestion.scrollIntoView();
        return btnUpdate.isElementPresent();
    }

    public void clickOnUpdateButton() {
        if (btnUpdate.isElementPresent()) {
            btnUpdate.clickJScript();
            reportLog("Successfully click On Update Button");
        }
    }

    public void clickOnCloseButton() {
        waitForSec(5);
        if (btnClose.isElementPresent()) {
            btnClose.clickJScript();
            reportLog("Successfully click On Close Button");
        }
    }

    public void clickOnBackToAssignmentButton() {
        if (btnBackToAssignment.isElementPresent()) {
            btnBackToAssignment.clickJScript();
            reportLog("Successfully click On Back To Assignment Button");
        }
        waitForSec(5);
    }

    public boolean verifyBackToAssignmentButton() {
        waitForSec(5);
        return btnBackToAssignment.isElementPresent();
    }

    public boolean verifyPreviewButton() {
        waitForSec(5);
        return btnPreview.isElementPresent();
    }

    public void clickOnPreviewButton() {
        if (btnPreview.isElementPresent()) {
            btnPreview.clickJScript();
            reportLog("Successfully click On Preview Button");
        }
    }

    public boolean verifyQuizCreatedSuccessfullyText() {
        return textQuizCreated.isElementPresent();
    }

    public boolean verifyRemoveIcon() {
        iconRemove.mouseHover();
        return iconRemove.isElementPresent();
    }

    public void clickOnRemoveIcon() {
        if (iconRemove.isElementPresent()) {
            iconRemove.mouseHover();
            iconRemove.clickJScript();
            reportLog("Successfully click On Remove Icon");
        }
    }

    public boolean verifyPreviewText() {
        waitForSec(5);
        return textPreview.isElementPresent();
    }

    public boolean verifyDeskTopText() {
        return textDeskTop.isElementPresent();
    }

    public boolean verifyQuestionSetIsRemove() {
        List<WebElement> containerList = webDriver.findElements(By.xpath("//ul[@id='exerciseContainer']//li"));
        int containerCount = containerList.size();
        reportLog("Total count Of Container List is = " + containerCount);
        return countOfContainer != containerCount;
    }

    public boolean verifyQuestionSetIsAdded() {
        List<WebElement> containerList = webDriver.findElements(By.xpath("//ul[@id='exerciseContainer']//li"));
        countOfContainer = containerList.size();
        reportLog("Total count Of Container List is = " + countOfContainer);
        return 2 == countOfContainer;
    }

    public void clickOnGotItButton() {
        if (btnGotIt.isElementPresent()) {
            btnGotIt.clickJScript();
            reportLog("Successfully click On Got It Button");
        }
    }

    public void clickOnSearchResultCheckBox() {
        if (chkBoxSearchResult.isElementPresent()) {
            chkBoxSearchResult.clickJScript();
            reportLog("Successfully click On Search Result CheckBox");
        }
    }

    public void getConceptText() {
        conceptName = textSearchResult.getText();
        reportLog("Successfully Get Text Of Concept Name And Concept Name Is = " + conceptName);
    }

    public boolean verifySearchIcon() {
        return iconSearch.isElementPresent();
    }

    public void clickOnSearchIcon() {
        if (iconSearch.isElementPresent()) {
            iconSearch.clickJScript();
            reportLog("Successfully click On Search Icon");
        }
    }

    public boolean verifyCloseSearchIcon() {
        waitForSec(5);
        return iconCloseSearchConcept.isElementPresent();
    }

    public void clickOnCloseSearchIcon() {
        if (iconCloseSearchConcept.isElementPresent()) {
            iconCloseSearchConcept.clickJScript();
            reportLog("Successfully click On Close Search Icon");
        }
    }

    public void setValueInSearchConceptPlaceHolder(String concept) {
        if (placeHolderSearchConcept.isElementPresent()) {
            placeHolderSearchConcept.clickJScript();
            reportLog("Successfully click On Search Concept PlaceHolder");
            placeHolderSearchConcept.setText(concept);
            reportLog("Successfully set Value in PlaceHolder And Value is = " + concept);
        }
    }

    public boolean verifySelectButton() {
        waitForSec(5);
        return btnSelect.isElementPresent();
    }

    public void clickOnSelectButton() {
        if (btnSelect.isElementPresent()) {
            btnSelect.clickJScript();
            reportLog("Successfully click On Select Button");
        }
    }

    public boolean verifyChooseConceptText() {
        waitForSec(5);
        return textChooseConcept.isElementPresent();
    }

    public boolean verifyQuizPageUI() {
        return moduleTitle.isElementPresent() && privacyLink.isElementPresent();
    }

    public void setValueInTitlePlaceHolder(String title) {
        if (placeHolderTitle.isElementPresent()) {
            placeHolderTitle.clickJScript();
            reportLog("Successfully click On Title PlaceHolder");
            placeHolderTitle.setText(title + currentTimeStamp());
            reportLog("Successfully set Title PlaceHolder And Title is = " + title);
        }
    }

    public boolean verifyQuestionRequiredText() {
        return txtQuestionRequired.isElementPresent();
    }

    public boolean verifyAlertIcon() {
        waitForSec(5);
        iconAlert.scrollIntoView();
        return iconAlert.isElementPresent();
    }

    public void enteredIntoTheQuizPageFrame() {
        webDriver.switchTo().frame("assessmentFrame");
        reportLog("Entered Into The Parent Frame Of Quiz Page");
    }

    public void removeFromTheQuizPageFrame() {
        webDriver.switchTo().defaultContent();
        reportLog("Remove From The Parent Frame Of Quiz Page");
    }

    public boolean verifyCreateButton() {
        btnCreate.scrollIntoView();
        return btnCreate.isElementPresent();
    }

    public void clickOnCreateButton() {
        if (btnCreate.isElementPresent()) {
            btnCreate.clickJScript();
            reportLog("Successfully click On Create Button");
        }
        waitForSec(5);
    }

    public boolean verifyAddQuizLink() {
        return linkAddQuiz.isElementPresent();
    }

    public void clickOnAddQuizLink() {
        if (linkAddQuiz.isElementPresent()) {
            linkAddQuiz.mouseHover();
            linkAddQuiz.clickJScript();
            reportLog("Successfully click On Add Quiz Link");
        }
    }

    public boolean verifyAddQuestionIcon() {
        return iconAddQuestion.isElementPresent();
    }

    public void clickOnAddQuestionIcon() {
        if (iconAddQuestion.isElementPresent()) {
            iconAddQuestion.clickJScript();
            reportLog("Successfully click On Add Question Icon");
        }
    }

    public boolean verifyCreateNewQuizLink_old() {
        waitForSec(5);
        try {
            return linkAddQuizProd.isElementPresent();
        } catch (Exception e) {
            return linkCreateNewLink.isElementPresent();
        }
    }

    public boolean verifyCreateNewQuizLink() {
        waitForSec(20);
        return linkAddQuizProd.isElementPresent() || linkCreateNewLink.isElementPresent();
    }

    public boolean verifyCreateNewQuizLinkProd() {
        waitForSec(5);
        return linkAddQuizProd.isElementPresent();
    }

    public void clickOnCreateNewQuizLink() {
        try {
            linkCreateNewLink.isElementPresent();
            linkCreateNewLink.clickJScript();
            reportLog("Successfully click On Create New Quiz Link");
        } catch (Exception e) {
            linkAddQuizProd.isElementPresent();
            linkAddQuizProd.clickJScript();
            reportLog("Successfully click On Create New Quiz Link");
        }
    }

    public void clickOnCreateNewQuizLinkProd() {
        if (linkAddQuizProd.isElementPresent()) {
            linkAddQuizProd.clickJScript();
            reportLog("Successfully click On Create New Quiz Link");
        }
    }

    public boolean verifyBackButton() {
        waitForSec(5);
        return btnBack.isElementPresent();
    }

    public void clickOnBackButton() {
        waitForSec(5);
        if (btnBack.isElementPresent()) {
            btnBack.clickJScript();
            reportLog("Successfully click On Back Button");
        }
        waitForSec(5);
    }

    public void clickOnCreateNewQuestionsIcon() {
        if (iconCreateNewQuestions.isElementPresent()) {
            iconCreateNewQuestions.clickJScript();
            reportLog("Clicked on the create new questions link.");
        }
    }

    public void enterAssignmentName() {
        waitForSec(5);
        assignmentName.setText("test" + currentTimeStamp());
    }

    public void selectClass() {
        selectClass.clickJScript();
        waitForSec(8);

    }

    public void saveAssignment() {
        saveAssignment.clickJScript();
        waitForSec(15);
    }

    public String getStudentScore() {
        return score.getText();
    }

    public void selectDueDate() {
        dueDate.click();
        logger.info("Clicked on the Due Date button");
        waitForSec(4);
        currentDate.clickJScript();
        logger.info("Selected the Due Date");
        waitForSec(4);
    }
}