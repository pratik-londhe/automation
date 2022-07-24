package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class QuestionTypeFeature extends BasePage {
    private static final Logger logger = Logger.getLogger(QuestionTypeFeature.class);

    private final GuiControl linkCreateNewQuestion = new GuiControl(getElementMap().get("linkCreateNewQuestion"), webDriver);
    private final GuiControl iconNew = new GuiControl(getElementMap().get("iconNew"), webDriver);
    private final GuiControl textQuestionType = new GuiControl(getElementMap().get("textQuestionType"), webDriver);
    private final GuiControl dropDownQuestionType = new GuiControl(getElementMap().get("dropDownQuestionType"), webDriver);
    private final GuiControl linkMultipleChoice = new GuiControl(getElementMap().get("linkMultipleChoice"), webDriver);
    private final GuiControl linkSelectAllThatApply = new GuiControl(getElementMap().get("linkSelectAllThatApply"), webDriver);
    private final GuiControl linkTrueFalse = new GuiControl(getElementMap().get("linkTrueFalse"), webDriver);
    private final GuiControl linkShortAnswer = new GuiControl(getElementMap().get("linkShortAnswer"), webDriver);
    private final GuiControl linkFillInTheBlanks = new GuiControl(getElementMap().get("linkFillInTheBlanks"), webDriver);
    private final GuiControl linkDragAndDrop = new GuiControl(getElementMap().get("linkDragAndDrop"), webDriver);
    private final GuiControl linkHighLight = new GuiControl(getElementMap().get("linkHighLight"), webDriver);
    private final GuiControl linkDiscussion = new GuiControl(getElementMap().get("linkDiscussion"), webDriver);
    private final GuiControl optionFirst = new GuiControl(getElementMap().get("optionFirst"), webDriver);
    private final GuiControl btOK = new GuiControl(getElementMap().get("btOK"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl iconCloseModal = new GuiControl(getElementMap().get("iconCloseModal"), webDriver);
    private final GuiControl fontItalic = new GuiControl(getElementMap().get("fontItalic"), webDriver);
    private final GuiControl linkVariable = new GuiControl(getElementMap().get("linkVariable"), webDriver);
    private final GuiControl linkProgress = new GuiControl(getElementMap().get("linkProgress"), webDriver);
    private final GuiControl linkAddVariable = new GuiControl(getElementMap().get("linkAddVariable"), webDriver);
    private final GuiControl textVariable = new GuiControl(getElementMap().get("textVariable"), webDriver);
    private final GuiControl iconCloseVariableWrapper = new GuiControl(getElementMap().get("iconCloseVariableWrapper"), webDriver);
    private final GuiControl btnAddVariable = new GuiControl(getElementMap().get("btnAddVariable"), webDriver);
    private final GuiControl btnCancelModal = new GuiControl(getElementMap().get("btnCancelModal"), webDriver);
    private final GuiControl iconCloseVariableModal = new GuiControl(getElementMap().get("iconCloseVariableModal"), webDriver);
    private final GuiControl constantVariableTypeChecked = new GuiControl(getElementMap().get("constantVariableTypeChecked"), webDriver);
    private final GuiControl textErrorMsg = new GuiControl(getElementMap().get("textErrorMsg"), webDriver);
    private final GuiControl placeHolderVariableName = new GuiControl(getElementMap().get("placeHolderVariableName"), webDriver);
    private final GuiControl placeHolderVariableValue = new GuiControl(getElementMap().get("placeHolderVariableValue"), webDriver);
    private final GuiControl usingArrayVariableType = new GuiControl(getElementMap().get("usingArrayVariableType"), webDriver);
    private final GuiControl textEnterRule = new GuiControl(getElementMap().get("textEnterRule"), webDriver);
    private final GuiControl constantVariableType = new GuiControl(getElementMap().get("constantVariableType"), webDriver);
    private final GuiControl textConstantValue = new GuiControl(getElementMap().get("textConstantValue"), webDriver);
    private final GuiControl iconDragVariable = new GuiControl(getElementMap().get("iconDragVariable"), webDriver);
    private final GuiControl choseFromSetType = new GuiControl(getElementMap().get("choseFromSetType"), webDriver);
    private final GuiControl checkBoxList = new GuiControl(getElementMap().get("checkBoxList"), webDriver);
    private final GuiControl checkBoxRange = new GuiControl(getElementMap().get("checkBoxRange"), webDriver);
    private final GuiControl textNotEqualTo = new GuiControl(getElementMap().get("textNotEqualTo"), webDriver);
    private final GuiControl textWithInterval = new GuiControl(getElementMap().get("textWithInterval"), webDriver);
    private final GuiControl addQues = new GuiControl(getElementMap().get("addQues"), webDriver);

    public QuestionTypeFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyRangeCheckBox() {
        waitForSec(5);
        return checkBoxRange.isElementPresent();
    }

    public void clickOnAddQues() {
        waitForSec(5);
        webDriver.switchTo().frame("assessmentFrame");
        addQues.click();
    }

    public void clickOnRangeCheckBox() {
        if (checkBoxRange.isElementPresent()) {
            checkBoxRange.clickJScript();
            reportLog("Successfully Clicked On Range CheckBox.");
        }
    }

    public boolean verifyWithInterValText() {
        waitForSec(5);
        return textWithInterval.isElementPresent();
    }

    public boolean verifyListCheckBox() {
        return checkBoxList.isElementPresent();
    }

    public void clickOnListCheckBox() {
        if (checkBoxList.isElementPresent()) {
            checkBoxList.clickJScript();
            reportLog("Successfully Clicked On LIst CheckBox.");
        }
    }

    public boolean verifyNotEqualToText() {
        waitForSec(5);
        return textNotEqualTo.isElementPresent();
    }

    public boolean verifyChooseFromSetVariableType() {
        return choseFromSetType.isElementPresent();
    }

    public void clickOnChooseFromSetVariableType() {
        if (choseFromSetType.isElementPresent()) {
            choseFromSetType.clickJScript();
            reportLog("Successfully Clicked On Choose From Set Variable Type.");
        }
    }


    public boolean verifyConstantVariableType() {
        return constantVariableType.isElementPresent();
    }

    public void clickOnConstantVariableTypen() {
        if (constantVariableType.isElementPresent()) {
            constantVariableType.clickJScript();
            reportLog("Successfully Clicked On Constant Variable Type.");
        }
    }

    public boolean verifyDragVariableICon() {
        return iconDragVariable.isElementPresent();
    }

    public boolean verifyConstantValueText() {
        waitForSec(5);
        return textConstantValue.isElementPresent();
    }

    public boolean verifyEnterRuleText() {
        waitForSec(5);
        return textEnterRule.isElementPresent();
    }

    public boolean verifyUsingArrayVariableType() {
        return usingArrayVariableType.isElementPresent();
    }

    public void clickOnUsingArrayVariableTypen() {
        if (usingArrayVariableType.isElementPresent()) {
            usingArrayVariableType.clickJScript();
            reportLog("Successfully Clicked On Using Array Variable Type.");
        }
    }

    public void setValueInVariableNamePlaceHolder() {
        if (placeHolderVariableName.isElementPresent()) {
            placeHolderVariableName.clickJScript();
            reportLog("Successfully Clicked On Variable Name PlaceHolder.");
            placeHolderVariableName.setText("Basid");
            reportLog("Successfully Set Value In Variable Name PlaceHolder.");
        }
    }

    public void setValueInVariableValuePlaceHolder() {
        if (placeHolderVariableValue.isElementPresent()) {
            placeHolderVariableValue.clickJScript();
            reportLog("Successfully Clicked On Variable Value PlaceHolder.");
            placeHolderVariableValue.setText("AAAA");
            reportLog("Successfully Set Value In Variable Value PlaceHolder.");
        }
    }

    public void removeValueFromInVariableNamePlaceHolder() {
        if (placeHolderVariableName.isElementPresent()) {
            placeHolderVariableName.clickJScript();
            reportLog("Successfully Remove Value From Variable Name PlaceHolder.");
            placeHolderVariableName.setText("");
            reportLog("Successfully  Remove Value From Variable Name PlaceHolder.");
        }
    }

    public boolean verifyAddVariableButton() {
        waitForSec(5);
        return btnAddVariable.isElementPresent();
    }

    public boolean verifyErrorMsgText() {
        waitForSec(5);
        return textErrorMsg.isElementPresent();
    }

    public boolean verifyConstantVariableTypeIsByDefaultSelected() {
        return constantVariableTypeChecked.isElementPresent();
    }

    public void clickOnAddVariableButton() {
        if (btnAddVariable.isElementPresent()) {
            btnAddVariable.clickJScript();
            reportLog("Successfully Clicked On Add Variable btn.");
        }
    }

    public boolean verifyCancelModalButton() {
        return btnCancelModal.isElementPresent();
    }

    public void clickOnCancelModalButton() {
        if (btnCancelModal.isElementPresent()) {
            btnCancelModal.clickJScript();
            reportLog("Successfully Clicked On Cancel Modal btn.");
        }
    }

    public boolean verifyCloseVariableModalICon() {
        return iconCloseVariableModal.isElementPresent();
    }

    public void clickOnCloseVariableModalICon() {
        if (iconCloseVariableModal.isElementPresent()) {
            iconCloseVariableModal.clickJScript();
            reportLog("Successfully Clicked On Close Variable Modal ICon.");
        }
    }

    public boolean verifyVariableText() {
        waitForSec(5);
        return textVariable.isElementPresent();
    }

    public boolean verifyAddVariableLink() {
        waitForSec(8);
        return linkAddVariable.isElementPresent();
    }

    public void clickOnAddVariableLink() {
        if (linkAddVariable.isElementPresent()) {
            linkAddVariable.clickJScript();
            reportLog("Successfully Clicked On Add Variable Link.");
        }
    }

    public boolean verifyCloseVariableWrapperIcon() {
        return iconCloseVariableWrapper.isElementPresent();
    }

    public void clickOnCloseVariableWrapperIcon() {
        if (iconCloseVariableWrapper.isElementPresent()) {
            iconCloseVariableWrapper.clickJScript();
            reportLog("Successfully Clicked On Close Variable Wrapper Icon.");
        }
    }

    public boolean verifyVariableLink() {
        waitForSec(5);
        return linkVariable.isElementPresent();
    }

    public void clickOnVariableLink() {
        if (linkVariable.isElementPresent()) {
            linkVariable.clickJScript();
            reportLog("Successfully Clicked On Variable Link.");
        }
    }

    public boolean verifyProgressLink() {
        waitForSec(5);
        return linkProgress.isElementPresent();
    }

    public void clickOnProgressLink() {
        if (linkProgress.isElementPresent()) {
            linkProgress.clickJScript();
            reportLog("Successfully Clicked On Progress Link.");
        }
    }

    public boolean verifyOkButton() {
        waitForSec(20);
        return btOK.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btOK.isElementPresent()) {
            btOK.clickJScript();
            reportLog("Successfully Clicked On btb OK.");
        }
    }

    public boolean verifyCancelButton() {
        return btnCancel.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.clickJScript();
            reportLog("Successfully Clicked On btb Cancel.");
        }
    }

    public boolean verifyCloseModalIcon() {
        return iconCloseModal.isElementPresent();
    }

    public void clickOnCloseModalIcon() {
        if (iconCloseModal.isElementPresent()) {
            iconCloseModal.clickJScript();
            reportLog("Successfully Clicked On Close Modal Icon.");
        }
    }

    public boolean verifyQuestionTypeDropDown() {
        waitForSec(5);
        return dropDownQuestionType.isElementPresent();
    }

    public void clickOnQuestionTypeDropDown() {
        if (dropDownQuestionType.isElementPresent()) {
            dropDownQuestionType.clickJScript();
            reportLog("Successfully Clicked On Question Type DropDown.");
            waitForSec(5);
        }
    }

    public boolean verifyMultipleChoiceOptionFirst() {
        return optionFirst.isElementPresent();
    }

    public void SetValueMultipleChoiceOptionFirst() {
        String text = "ABC";
        if (optionFirst.isElementPresent()) {
            optionFirst.clickJScript();
            dropDownQuestionType.scrollIntoView();
            waitForSec(2);
            clickOnItalicFontButton();
            waitForSec(2);
            enterIntoFrame();
            waitForSec(2);
            webDriver.findElement(By.id("questionStem_ifr")).sendKeys(text);
            reportLog("Successfully Set Value In Option First.");
            removeFromFrame();
            waitForSec(2);
        }
    }

    public boolean verifyOkButtonIsDisplayOrNot() {
        waitForSec(5);
        try {
            if (btOK.isElementPresent()) {
                reportLog("Successfully Verify OK Button.");
                return true;
            } else {
                for (int loopCount = 1; loopCount < 15; loopCount++) {
                    verifyQuestionTypeDropDown();
                    clickOnQuestionTypeDropDown();
                    clickOnQuestionTypeLink(loopCount);
                    if (btOK.isElementPresent()) {
                        reportLog("Successfully Verify OK Button.");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return false;
    }

    private void clickOnQuestionTypeLink(int loopCount) {

        int count;
        count = loopCount;
        switch (count) {
            case 1:
                clickOnSelectAllLink();
                break;
            case 2:
                clickOnDragAndDropLink();
                break;
            case 3:
                clickOnHighLightLink();
                break;
            case 4:
                clickOnSelectAllLink();
                break;
            case 5:
                clickOnMultipleChoiceLink();
                break;
            case 6:
                clickOnDiscussionLink();
                break;
            case 7:
                clickOnFillInTheBlanksLink();
                break;
            case 8:
                clickOnShortAnswerLink();
                break;
            case 9:
                clickOnDiscussionLink();
                break;
            case 10:
                clickOnDragAndDropLink();
                break;
            case 11:
                clickOnSelectAllLink();
                break;
            case 12:
                clickOnMultipleChoiceLink();
                break;
            case 13:
                clickOnDiscussionLink();
                break;
            case 14:
                clickOnDiscussionLink();
                break;
            default:
                reportLog("Now This is Bug ");
                break;
        }
    }

    private void enterIntoFrame() {
        webDriver.switchTo().frame("questionStem_ifr");
        reportLog("Enter Into Frame");
    }

    public void removeFromFrame() {
        webDriver.switchTo().defaultContent();
        reportLog("Remove From The Frame");
    }

    public boolean verifyMultipleChoiceLink() {
        return linkMultipleChoice.isElementPresent();
    }

    public void clickOnMultipleChoiceLink() {
        if (linkMultipleChoice.isElementPresent()) {
            linkMultipleChoice.clickJScript();
            reportLog("Successfully Clicked On Multiple Choice Link.");
        }
    }

    public boolean verifySelectAllLink() {
        return linkSelectAllThatApply.isElementPresent();
    }

    public void clickOnSelectAllLink() {
        if (linkSelectAllThatApply.isElementPresent()) {
            linkSelectAllThatApply.clickJScript();
            reportLog("Successfully Clicked On Select All Link.");
        }
    }

    public boolean verifyTrueFalseLink() {
        return linkTrueFalse.isElementPresent();
    }

    public void clickOnTrueFalseLink() {
        if (linkTrueFalse.isElementPresent()) {
            linkTrueFalse.clickJScript();
            reportLog("Successfully Clicked On True False Link.");
        }
    }

    public boolean verifyShortAnswerLink() {
        return linkShortAnswer.isElementPresent();
    }

    public void clickOnShortAnswerLink() {
        if (linkShortAnswer.isElementPresent()) {
            linkShortAnswer.clickJScript();
            reportLog("Successfully Clicked On Short Answer Link.");
        }
    }

    public boolean verifyDragAndDropLink() {
        return linkDragAndDrop.isElementPresent();
    }

    public void clickOnDragAndDropLink() {
        if (linkDragAndDrop.isElementPresent()) {
            linkDragAndDrop.clickJScript();
            reportLog("Successfully Clicked On Drag And Drop Link.");
        }
    }

    public boolean verifyHighLightLink() {
        return linkHighLight.isElementPresent();
    }

    public void clickOnHighLightLink() {
        if (linkHighLight.isElementPresent()) {
            linkHighLight.clickJScript();
            reportLog("Successfully Clicked On HighLight Link.");
        }
    }

    public boolean verifyDiscussionLink() {
        return linkDiscussion.isElementPresent();
    }

    public void clickOnDiscussionLink() {
        if (linkDiscussion.isElementPresent()) {
            linkDiscussion.clickJScript();
            reportLog("Successfully Clicked On Discussion Link.");
        }
    }

    private void clickOnItalicFontButton() {
        if (fontItalic.isElementPresent()) {
            fontItalic.clickJScript();
            reportLog("Successfully Clicked On font Italic.");
        }
    }

    public boolean verifyFillInTheBlanksLink() {
        return linkFillInTheBlanks.isElementPresent();
    }

    public void clickOnFillInTheBlanksLink() {
        if (linkFillInTheBlanks.isElementPresent()) {
            linkFillInTheBlanks.clickJScript();
            reportLog("Successfully Clicked On Fill In The Blanks Link.");
        }
    }

    public boolean verifyCreateNewQuestionLink() {
        waitForSec(5);
        return linkCreateNewQuestion.isElementPresent();
    }

    public void clickOnCreateNewQuestionLink() {
        if (linkCreateNewQuestion.isElementPresent()) {
            linkCreateNewQuestion.clickJScript();
            reportLog("Successfully Clicked On Create New Question Link.");
        }
    }

    public boolean verifyNewQuestionIcon() {
        waitForSec(15);
        return iconNew.isElementPresent();
    }

    public void clickOnNewQuestionIcon() {
        if (iconNew.isElementPresent()) {
            iconNew.clickJScript();
            reportLog("Successfully Clicked On New Question Icon.");
        }
    }

    public boolean verifyQuestionTypeText() {
        return textQuestionType.isElementPresent();
    }

    public boolean verifySelectAllQuestionTypeIsSelected() {
        return "select-all-that-apply".equalsIgnoreCase(dropDownQuestionType.getText());
    }

    public boolean verifyMultipleChoiceQuestionTypeIsSelected() {
        return "multiple-choice".equalsIgnoreCase(dropDownQuestionType.getText());
    }

    public boolean verifyTrueFalseQuestionTypeIsSelected() {
        return "true false".equalsIgnoreCase(dropDownQuestionType.getText());
    }

    public boolean verifyShortAnswerQuestionTypeIsSelected() {
        return "short-answer".equalsIgnoreCase(dropDownQuestionType.getText());
    }

    public boolean verifyFillBlanksQuestionTypeIsSelected() {
        return "fill-in-the-blanks".equalsIgnoreCase(dropDownQuestionType.getText());
    }

    public boolean verifyDragDropQuestionTypeIsSelected() {
        return "drag-and-drop".equalsIgnoreCase(dropDownQuestionType.getText());
    }

    public boolean verifyDiscussionQuestionTypeIsSelected() {
        return "discussion".equalsIgnoreCase(dropDownQuestionType.getText());
    }

    public boolean verifyHighLightQuestionTypeIsSelected() {
        return "Highlight".equalsIgnoreCase(dropDownQuestionType.getText());
    }
}