package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GuiControl;

import java.util.List;

public class AssessmentFeature extends PageMenuTab {
    private String nameOfQuizBeforeSelectingAlphabetical;
    private String nameOfQuizBeforeSelectingRecentlyEdited;

    private final GuiControl tabAddAssessment = new GuiControl(getElementMap().get("tabAddAssessment"), webDriver);
    private final GuiControl btnAddPractice = new GuiControl(getElementMap().get("btnAddPractice"), webDriver);
    private final GuiControl btnAddQuiz = new GuiControl(getElementMap().get("btnAddQuiz"), webDriver);
    private final GuiControl iconCloseCreateModality = new GuiControl(getElementMap().get("iconCloseCreateModality"), webDriver);
    private final GuiControl textWhatWouldLikeToAdd = new GuiControl(getElementMap().get("textWhatWouldLikeToAdd"), webDriver);
    private final GuiControl linkWhatsTheDifference = new GuiControl(getElementMap().get("linkWhatsTheDifference"), webDriver);
    private final GuiControl btnWhatsDifferenceClose = new GuiControl(getElementMap().get("btnWhatsDifferenceClose"), webDriver);
    private final GuiControl textPractice = new GuiControl(getElementMap().get("textPractice"), webDriver);
    private final GuiControl textQuizzes = new GuiControl(getElementMap().get("textQuizzes"), webDriver);
    private final GuiControl textPrimaryConcept = new GuiControl(getElementMap().get("textPrimaryConcept"), webDriver);
    private final GuiControl btnChooseConcept = new GuiControl(getElementMap().get("btnChooseConcept"), webDriver);
    private final GuiControl iconBackArrow = new GuiControl(getElementMap().get("iconBackArrow"), webDriver);
    private final GuiControl btnSearch = new GuiControl(getElementMap().get("btnSearch"), webDriver);
    private final GuiControl iconCloseSearch = new GuiControl(getElementMap().get("iconCloseSearch"), webDriver);
    private final GuiControl placeHolderSearch = new GuiControl(getElementMap().get("placeHolderSearch"), webDriver);
    private final GuiControl textSearchResultFor = new GuiControl(getElementMap().get("textSearchResultFor"), webDriver);
    private final GuiControl linkNoDataFound = new GuiControl(getElementMap().get("linkNoDataFound"), webDriver);
    private final GuiControl linkResultBiology = new GuiControl(getElementMap().get("linkResultBiology"), webDriver);
    private final GuiControl linkResultChemistry = new GuiControl(getElementMap().get("linkResultChemistry"), webDriver);
    private final GuiControl textCurrentConcept = new GuiControl(getElementMap().get("textCurrentConcept"), webDriver);
    private final GuiControl btnChangeConcept = new GuiControl(getElementMap().get("btnChangeConcept"), webDriver);
    private final GuiControl btnSavePractice = new GuiControl(getElementMap().get("btnSavePractice"), webDriver);
    private final GuiControl btnAdd = new GuiControl(getElementMap().get("btnAdd"), webDriver);
    private final GuiControl btnSaveQuiz = new GuiControl(getElementMap().get("btnSaveQuiz"), webDriver);
    private final GuiControl iconSelectQuiz = new GuiControl(getElementMap().get("iconSelectQuiz"), webDriver);
    private final GuiControl btnCreateNewQuiz = new GuiControl(getElementMap().get("btnCreateNewQuiz"), webDriver);
    private final GuiControl iconBackQuiz = new GuiControl(getElementMap().get("iconBackQuiz"), webDriver);
    private final GuiControl btnRefresh = new GuiControl(getElementMap().get("btnRefresh"), webDriver);
    private final GuiControl linkOfQuizzes = new GuiControl(getElementMap().get("linkOfQuizzes"), webDriver);
    private final GuiControl textDropDownSelectedValue = new GuiControl(getElementMap().get("textDropDownSelectedValue"), webDriver);
    private final GuiControl linkAlphabetically = new GuiControl(getElementMap().get("linkAlphabetically"), webDriver);
    private final GuiControl linkMostRecentlyEdited = new GuiControl(getElementMap().get("linkMostRecentlyEdited"), webDriver);
    private final GuiControl iconDropDownContainer = new GuiControl(getElementMap().get("iconDropDownContainer"), webDriver);
    private final GuiControl btnViewPractice = new GuiControl(getElementMap().get("btnViewPractice"), webDriver);
    private final GuiControl textEstimatedTime = new GuiControl(getElementMap().get("textEstimatedTime"), webDriver);
    private final GuiControl btnPreview = new GuiControl(getElementMap().get("btnPreview"), webDriver);
    private final GuiControl btnChooseDifferentPractice = new GuiControl(getElementMap().get("btnChooseDifferentPractice"), webDriver);
    private final GuiControl btnSwitchToQuiz = new GuiControl(getElementMap().get("btnSwitchToQuiz"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl iconCreatePracticeClose = new GuiControl(getElementMap().get("iconCreatePracticeClose"), webDriver);
    private final GuiControl iconCreateQuizClose = new GuiControl(getElementMap().get("iconCreateQuizClose"), webDriver);
    private final GuiControl btnViewQuiz = new GuiControl(getElementMap().get("btnViewQuiz"), webDriver);
    private final GuiControl btnChooseDifferentQuiz = new GuiControl(getElementMap().get("btnChooseDifferentQuiz"), webDriver);
    private final GuiControl btnSwitchToPractice = new GuiControl(getElementMap().get("btnSwitchToPractice"), webDriver);
    private final GuiControl linkLatestVersion = new GuiControl(getElementMap().get("linkLatestVersion"), webDriver);

    public AssessmentFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver,extentTest,extentReports);
    }

    public boolean verifyAddAssessmentButton() {
        waitForSec(5);
        return tabAddAssessment.isElementPresent();
    }

    public void clickOnAddAssessmentButton() {
        if (tabAddAssessment.isElementPresent()) {
            tabAddAssessment.clickJScript();
            reportLog("Successfully clicked On Add Assessment Tab.");
        }
    }

    public boolean verifyAddPracticeButton() {
        return btnAddPractice.isElementPresent();
    }

    public void clickOnAddPracticeButton() {
        if (btnAddPractice.isElementPresent()) {
            btnAddPractice.clickJScript();
            reportLog("Successfully clicked On Add Practice Tab.");
        }
    }

    public boolean verifyAddQuizButton() {
        return btnAddQuiz.isElementPresent();
    }

    public void clickOnAddQuizButton() {
        if (btnAddQuiz.isElementPresent()) {
            btnAddQuiz.clickJScript();
            reportLog("Successfully clicked On Add Quiz Tab.");
        }
    }

    public boolean verifyCloseModalIcon() {
        return iconCloseCreateModality.isElementPresent();
    }

    public void clickOnCloseModalIcon() {
        if (iconCloseCreateModality.isElementPresent()) {
            iconCloseCreateModality.clickJScript();
            reportLog("Successfully clicked On Close Modal Icon.");
        }
    }

    public boolean verifyCreatedModalityCloseModalIcon() {
        return iconCreatePracticeClose.isElementPresent();
    }

    public void clickOnCreatedModalityCloseModalIcon() {
        if (iconCreatePracticeClose.isElementPresent()) {
            iconCreatePracticeClose.clickJScript();
            reportLog("Successfully clicked On Created Modality Close Modal Icon.");
        }
    }

    public boolean verifyCreatedQuizCloseModalIcon() {
        return iconCreateQuizClose.isElementPresent();
    }

    public void clickOnCreatedQuizCloseModalIcon() {
        if (iconCreateQuizClose.isElementPresent()) {
            iconCreateQuizClose.clickJScript();
            reportLog("Successfully clicked On Created Quiz Close Modal Icon.");
        }
    }

    public boolean verifyWhatsTheDifferenceLink() {
        return linkWhatsTheDifference.isElementPresent();
    }

    public void clickOnWhatsTheDifferenceLink() {
        if (linkWhatsTheDifference.isElementPresent()) {
            linkWhatsTheDifference.clickJScript();
            reportLog("Successfully clicked On Whats The Difference Link.");
        }
    }

    public boolean verifyWhatWouldLikeToAddText() {
        waitForSec(5);
        return textWhatWouldLikeToAdd.isElementPresent();
    }

    public boolean verifyCloseWhatDifferenceButton() {
        waitForSec(5);
        return btnWhatsDifferenceClose.isElementPresent();
    }

    public void clickOnCloseWhatDifferenceButton() {
        if (btnWhatsDifferenceClose.isElementPresent()) {
            btnWhatsDifferenceClose.clickJScript();
            reportLog("Successfully clicked On Close What Difference Button.");
        }
    }

    public boolean verifyPracticeText() {
        return textPractice.isElementPresent();
    }

    public boolean verifyQuizzesText() {
        return textQuizzes.isElementPresent();
    }

    public boolean verifyPrimaryConceptText() {
        waitForSec(5);
        return textPrimaryConcept.isElementPresent();
    }

    public boolean verifyChooseConceptButton() {
        return btnChooseConcept.isElementPresent();
    }

    public void clickOnChooseConceptButton() {
        if (btnChooseConcept.isElementPresent()) {
            btnChooseConcept.clickJScript();
            reportLog("Successfully clicked On Choose Concept Button.");
        }
    }

    public boolean verifyBackArrowIcon() {
        return iconBackArrow.isElementPresent();
    }

    public void clickOnBackArrowIcon() {
        if (iconBackArrow.isElementPresent()) {
            iconBackArrow.clickJScript();
            reportLog("Successfully clicked On Back Arrow Icon.");
        }
    }

    public boolean verifySearchButton() {
        waitForSec(5);
        return btnSearch.isElementPresent();
    }

    public void clickOnSearchButton() {
        if (btnSearch.isElementPresent()) {
            btnSearch.clickJScript();
            reportLog("Successfully clicked On Search Button.");
        }
    }

    public boolean verifyCloseSearchIcon() {
        return iconCloseSearch.isElementPresent();
    }

    public void clickOnCloseSearchIcon() {
        if (iconCloseSearch.isElementPresent()) {
            iconCloseSearch.clickJScript();
            reportLog("Successfully clicked On Close Search Icon.");
        }
    }

    public boolean verifySearchPlaceHolder() {
        return placeHolderSearch.isElementPresent();
    }

    public void setValueSearchPlaceHolder(String value) {
        if (placeHolderSearch.isElementPresent()) {
            placeHolderSearch.clickJScript();
            placeHolderSearch.setText(value);
            reportLog("Successfully Set Value In Search PlaceHolder.");
        }
    }

    public boolean verifySearchResultForText() {
        waitForSec(5);
        return textSearchResultFor.isElementPresent();
    }

    public boolean verifyNoDataFoundLink() {
        return linkNoDataFound.isElementPresent();
    }

    public void clickOnNoDataFoundLink() {
        if (linkNoDataFound.isElementPresent()) {
            linkNoDataFound.clickJScript();
            reportLog("Successfully clicked On No Data Found Link.");
        }
    }

    public boolean verifyBiologyLink() {
        return linkResultBiology.isElementPresent();
    }

    public void clickOnBiologyLink() {
        waitForSec(2);
        if (linkResultBiology.isElementPresent()) {
            linkResultBiology.clickJScript();
            reportLog("Successfully clicked On Biology Link.");
        }
    }

    public boolean verifyChemistryLink() {
        return linkResultChemistry.isElementPresent();
    }

    public void clickOnChemistryLink() {
        if (linkResultChemistry.isElementPresent()) {
            linkResultChemistry.clickJScript();
            reportLog("Successfully clicked On Chemistry Link.");
        }
    }

    public boolean verifyCurrentConceptText() {
        waitForSec(5);
        return textCurrentConcept.isElementPresent();
    }

    public boolean verifyChangeConceptButton() {
        return btnChangeConcept.isElementPresent();
    }

    public void clickOnChangeConceptButton() {
        if (btnChangeConcept.isElementPresent()) {
            btnChangeConcept.clickJScript();
            reportLog("Successfully clicked On Change Concept Button.");
        }
    }

    public boolean verifySaveConceptButton() {
        return btnSavePractice.isElementPresent();
    }

    public void clickOnSaveConceptButton() {
        if (btnSavePractice.isElementPresent()) {
            btnSavePractice.clickJScript();
            reportLog("Successfully clicked On Save Concept Button.");
        }
    }

    public boolean verifySaveConceptButtonIsNotAvailable() {
        return !btnSavePractice.isElementPresent();
    }

    public boolean verifyRefreshButton() {
        waitForSec(5);
        return btnRefresh.isElementPresent();
    }

    public void clickOnRefreshButton() {
        if (btnRefresh.isElementPresent()) {
            btnRefresh.clickJScript();
            reportLog("Successfully clicked On Refresh Button.");
        }
    }

    public boolean verifyCreateNewQuizButton() {
        waitForSec(5);
        return btnCreateNewQuiz.isElementPresent();
    }

    public boolean verifySaveQuizButton() {
        return btnSaveQuiz.isElementPresent();
    }

    public void clickOnSaveQuizButton() {
        if (btnSaveQuiz.isElementPresent()) {
            btnSaveQuiz.clickJScript();
            reportLog("Successfully clicked On Save Quiz Button.");
        }
    }

    public boolean verifyAddButtonIsEnable() {
        return btnAdd.isElementPresent();
    }

    public boolean verifyBackQuizIcon() {
        return iconBackQuiz.isElementPresent();
    }

    public void clickOnBackQuizIcon() {
        if (iconBackQuiz.isElementPresent()) {
            iconBackQuiz.clickJScript();
            reportLog("Successfully clicked On Back Quiz Icon.");
        }
    }

    public boolean verifyListOfQuiz() {
        List<WebElement> listOfQuiz = linkOfQuizzes.getWebElements();
        int sizeOfList = listOfQuiz.size();
        reportLog("Successfully Get Quiz List And Total Quizzes Are = " + sizeOfList);
        return sizeOfList > 0;
    }

    public void clickOnFirstQuiz() {
        if (iconSelectQuiz.isElementPresent()) {
            iconSelectQuiz.clickJScript();
            reportLog("Successfully clicked On Select Quiz Icon.");
        }
    }

    public boolean verifyDropDownSelectedValue() {
        return textDropDownSelectedValue.isElementPresent();
    }

    public boolean verifyDropDownSelectedValueIsMostRecentlyEdited() {
        waitForSec(2);
        return "Most Recently Edited".equalsIgnoreCase(textDropDownSelectedValue.getText());
    }

    public boolean verifyDropDownSelectedValueIsAlphabetically() {
        waitForSec(2);
        return "Alphabetically".equalsIgnoreCase(textDropDownSelectedValue.getText());
    }

    public boolean verifyAlphabeticalLink() {
        return linkAlphabetically.isElementPresent();
    }

    public void clickOnAlphabeticalLink() {
        if (linkAlphabetically.isElementPresent()) {
            linkAlphabetically.clickJScript();
            reportLog("Successfully clicked On Alphabetical Link.");
        }
    }

    public boolean verifyMostRecentlyEditedLink() {
        return linkMostRecentlyEdited.isElementPresent();
    }

    public void clickOnMostRecentlyEditedLink() {
        if (linkMostRecentlyEdited.isElementPresent()) {
            linkMostRecentlyEdited.clickJScript();
            reportLog("Successfully clicked On Most Recently Edited Link.");
        }
    }

    public boolean verifyDropDownContainerIcon() {
        return iconDropDownContainer.isElementPresent();
    }

    public void clickOnDropDownContainerIcon() {
        if (iconDropDownContainer.isElementPresent()) {
            iconDropDownContainer.clickJScript();
            reportLog("Successfully clicked On DropDown Container Icon.");
        }
    }

    public void getTextOfFirstLinkBeforeSelectingAlphabetically() {
        if (iconSelectQuiz.isElementPresent()) {
            nameOfQuizBeforeSelectingAlphabetical = iconSelectQuiz.getText();
            reportLog("Successfully Get Text Of Link Before Selecting Alphabetically.");
        }
    }

    public void getTextOfFirstLinkBeforeSelectingRecentlyEdited() {
        if (iconSelectQuiz.isElementPresent()) {
            nameOfQuizBeforeSelectingRecentlyEdited = iconSelectQuiz.getText();
            reportLog("Successfully Get Text Of Link Before Selecting Recently Edited.");
        }
    }

    public boolean verifyQuizListIsUpdatedAlphabetically() {
        return nameOfQuizBeforeSelectingAlphabetical.equalsIgnoreCase(iconSelectQuiz.getText());
    }

    public boolean verifyQuizListIsUpdatedRecentlyEdited() {
        return nameOfQuizBeforeSelectingRecentlyEdited.equalsIgnoreCase(iconSelectQuiz.getText());
    }

    public boolean verifyViewPracticeButton() {
        waitForSec(5);
        return btnViewPractice.isElementPresent();
    }

    public void clickOnViewPracticeButton() {
        if (btnViewPractice.isElementPresent()) {
            btnViewPractice.clickJScript();
            reportLog("Successfully clicked On View Practice Button.");
        }
    }

    public boolean verifyPreviewButton() {
        waitForSec(5);
        return btnPreview.isElementPresent();
    }

    public void clickOnViewQuiz() {
        waitForSec(5);
        btnPreview.clickJScript();
        reportLog("Clicked on the View Quiz button.");
    }

    public boolean verifyEstimatedTimeText() {
        return textEstimatedTime.isElementPresent();
    }

    public boolean verifyChooseDifferentPracticeButton() {
        return btnChooseDifferentPractice.isElementPresent();
    }

    public void clickOnChooseDifferentPracticeButton() {
        if (btnChooseDifferentPractice.isElementPresent()) {
            btnChooseDifferentPractice.clickJScript();
            reportLog("Successfully clicked On Choose Different Practice Button.");
        }
    }

    public boolean verifyChooseDifferentQuizButton() {
        return btnChooseDifferentQuiz.isElementPresent();
    }

    public void clickOnChooseDifferentQuizButton() {
        if (btnChooseDifferentQuiz.isElementPresent()) {
            btnChooseDifferentQuiz.clickJScript();
            reportLog("Successfully clicked On Choose Different Quiz Button.");
        }
    }

    public boolean verifySwitchToQuizButton() {
        return btnSwitchToQuiz.isElementPresent();
    }

    public void clickOnSwitchToQuizButton() {
        if (btnSwitchToQuiz.isElementPresent()) {
            btnSwitchToQuiz.clickJScript();
            reportLog("Successfully clicked On Switch To Quiz Button.");
        }
    }

    public boolean verifySwitchToPracticeButton() {
        return btnSwitchToPractice.isElementPresent();
    }

    public void clickOnSwitchToPracticeButton() {
        if (btnSwitchToPractice.isElementPresent()) {
            btnSwitchToPractice.clickJScript();
            reportLog("Successfully clicked On Switch To Practice Button.");
        }
    }

    public boolean verifySaveButton() {
        return btnSave.isElementPresent();
    }

    public boolean verifyViewQuizButton() {
        waitForSec(5);
        return btnViewQuiz.isElementPresent();
    }

    public void clickOnViewQuizButton() {
        if (btnViewQuiz.isElementPresent()) {
            btnViewQuiz.clickJScript();
            reportLog("Successfully clicked On View Quiz Button.");
        }
    }

    public boolean verifyLatestVersionLink() {
        waitForSec(5);
        return linkLatestVersion.isElementPresent();
    }

    public void clickOnLatestVersionLink() {
        if (linkLatestVersion.isElementPresent()) {
            linkLatestVersion.clickJScript();
            reportLog("Successfully clicked On Latest Version Link.");
        }
    }
}