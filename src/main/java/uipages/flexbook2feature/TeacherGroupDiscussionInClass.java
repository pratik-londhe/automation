package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.*;

public class TeacherGroupDiscussionInClass extends BasePage {

    private List<WebElement> questionBefore;
    private List<WebElement> questionAfter;
    private String editPlaceHolderText;
    private int countBefore;
    private int countAfter;
    private String countQuesXpath="//div[@class='ph-content post-type-question']//div[2]";

    private final GuiControl btnQA = new GuiControl(getElementMap().get("btnQA"), webDriver);
    private final GuiControl linkHowDoesThisWork = new GuiControl(getElementMap().get("linkHowDoesThisWork"), webDriver);
    private final GuiControl btnNoThanks = new GuiControl(getElementMap().get("btnNoThanks"), webDriver);
    private final GuiControl btnOkShowMe = new GuiControl(getElementMap().get("btnOkShowMe"), webDriver);
    private final GuiControl iconExitClose = new GuiControl(getElementMap().get("iconExitClose"), webDriver);
    private final GuiControl btnNowWhatHappen = new GuiControl(getElementMap().get("btnNowWhatHappen"), webDriver);
    private final GuiControl btnComment = new GuiControl(getElementMap().get("btnComment"), webDriver);
    private final GuiControl placeHolderAskQuestion = new GuiControl(getElementMap().get("placeHolderAskQuestion"), webDriver);
    private final GuiControl placeHolderQuestion = new GuiControl(getElementMap().get("placeHolderQuestion"), webDriver);
    private final GuiControl btnPost = new GuiControl(getElementMap().get("btnPost"), webDriver);
    private final GuiControl containerLayout = new GuiControl(getElementMap().get("containerLayout"), webDriver);
    private final GuiControl txtInPlaceHolder = new GuiControl(getElementMap().get("txtInPlaceHolder"), webDriver);
    private final GuiControl txtPleaseWriteQuestion = new GuiControl(getElementMap().get("txtPleaseWriteQuestion"), webDriver);
    private final GuiControl btnEdit = new GuiControl(getElementMap().get("btnEdit"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl editPlaceHolderQuestion = new GuiControl(getElementMap().get("editPlaceHolderQuestion"), webDriver);
    private final GuiControl editPlaceHolderQuestionText = new GuiControl(getElementMap().get("editPlaceHolderQuestionText"), webDriver);
    private final GuiControl iconDelete = new GuiControl(getElementMap().get("iconDelete"), webDriver);
    private final GuiControl btnCancelDelete = new GuiControl(getElementMap().get("btnCancelDelete"), webDriver);
    private final GuiControl btnDelete = new GuiControl(getElementMap().get("btnDelete"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);

    public TeacherGroupDiscussionInClass(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnEditButton() {
        waitForSec(5);
        if (btnEdit.isElementPresent()) {
            btnEdit.clickJScript();
            reportLog("Successfully clicked on 'Edit' button");
        }
    }

    public boolean verifyCancelButton() {
        waitForSec(5);
        return btnCancel.isElementPresent();
    }

    public boolean verifySaveButton() {
        return btnSave.isElementPresent();
    }

    public void clickOnCancelEditButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.click();
            reportLog("Successfully clicked on 'Cancel' Button");
        }
    }

    public void clickOnSaveButton() {
        if (btnSave.isElementPresent()) {
            btnSave.click();
            reportLog("Successfully clicked on 'Save' Button");
        }
        waitForSec(5);
    }

    public void getListOfQuestionBefore() {
        waitForSec(5);
        questionBefore = webDriver.findElements(By.xpath(countQuesXpath));
        reportLog("Successfully retrieved Questions List Before Cancel action");
    }

    public void getListOfQuestionAfter() {
        waitForSec(5);
        questionAfter = webDriver.findElements(By.xpath(countQuesXpath));
        reportLog("Successfully retrieved Questions List After Cancel action");
    }

    public boolean verifyQuestionsAfterCancel() {
        return questionBefore.equals(questionAfter);
    }

    public void clickOnEditPlaceHolder() {
        if (editPlaceHolderQuestion.waitForElementUntilClickable(10)) {
            editPlaceHolderQuestion.clickJScript();
            reportLog("Successfully clicked On 'Edit' Place Holder");
        }
    }


    public void setTextInEditPlaceHolder(String text) {
        if (editPlaceHolderQuestion.isElementPresent()) {
            editPlaceHolderQuestion.clickJScript();
            waitForSec(2);
            editPlaceHolderQuestionText.setText(text + currentTimeStamp());
            reportLog("Successfully Set Text in Edit Question Place Holder");
        }
    }

    public void getPlaceHolderTextBeforeSave() {
        if (editPlaceHolderQuestion.isElementPresent()) {
            editPlaceHolderText = editPlaceHolderQuestion.getText();
            reportLog("Successfully retrieved text From place Holder. The text is = " + editPlaceHolderText);
        }
    }

    public boolean verifyQuestionTextAfterSave() {
        waitForSec(5);
        List<WebElement> text = webDriver.findElements(By.xpath(countQuesXpath));
        for (WebElement commented : text) {
            return commented.getText().split("\n")[0].trim().equalsIgnoreCase(editPlaceHolderText);
        }
        return false;
    }

    public boolean verifyDeleteIcon() {
        waitForSec(5);
        return iconDelete.isElementPresent();
    }

    public void clickOnDeleteIcon() {
        waitForSec(5);
        if (iconDelete.isElementPresent()) {
            iconDelete.clickFirstFromListOfElements();
            reportLog("Successfully clicked on 'Delete' Icon");
        }
    }

    public boolean verifyCancelDeleteButton() {
        return btnCancelDelete.isElementPresent();
    }

    public void clickOnCancelDeleteButton() {
        if (btnCancelDelete.isElementPresent()) {
            btnCancelDelete.click();
            reportLog("Successfully clicked on 'Cancel' Delete Button");
        }
    }

    public boolean verifyDeleteButton() {
        return btnDelete.isElementPresent();
    }

    public void clickOnDeleteButton() {
        if (btnDelete.isElementPresent()) {
            btnDelete.click();
            reportLog("Successfully clicked on 'Delete' Button");
        }
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.click();
            reportLog("Successfully clicked on 'Close' icon");
        }
    }

    public void getCountOfQuestionBefore() {
        List<WebElement> before = webDriver.findElements(By.xpath("//div[@class='ph-content-container']"));
        countBefore = before.size();
        reportLog("Successfully retrieved Count Of Questions before 'Cancel/Delete' action and Count is = " + countBefore);
    }

    public void getCountOfQuestionAfter() {
        waitForSec(5);
        List<WebElement> after = webDriver.findElements(By.xpath("//div[@class='ph-content-container']"));
        countAfter = after.size();
        reportLog("Successfully retrieved Count Of Questions after 'Cancel/Delete' action and Count is = " + countAfter);
    }

    public boolean verifyCountOfQuestionAfterCancelButton() {
        if (countBefore == countAfter) {
            reportLog("Successfully Verified Count Of Questions after Cancel action.");
            return true;
        }
        reportLog("Failed to Verify Count Of Questions after Cancel action.");
        return false;
    }

    public boolean verifyCountOfQuestionAfterDeleteButton() {
        waitForSec(5);
        return countBefore != countAfter;
    }

    public boolean verifyButtonQAndA() {
        waitForSec(5);
        return btnQA.isElementPresent();
    }

    public void clickOnQAndAButton() {
        if (btnQA.isElementPresent()) {
            btnQA.clickJScript();
            reportLog("Successfully clicked on Q And A Button");
        }
    }

    public boolean verifyHowDoesThisWorkLink() {
        waitForSec(10);
        return linkHowDoesThisWork.isElementPresent();
    }

    public void clickOnHowDoesThisWorkLink() {
        waitForSec(5);
        if (linkHowDoesThisWork.isElementPresent()) {
            linkHowDoesThisWork.clickJScript();
            reportLog("Successfully clicked on 'How Does this Work' Link");
        }
    }

    public boolean verifyNoThanksButton() {
        return btnNoThanks.isElementPresent();
    }

    public boolean verifyOkShowMeButton() {
        waitForSec(5);
        return btnOkShowMe.isElementPresent();
    }

    public void clickOnNoThanksButton() {
        if (btnNoThanks.isElementPresent()) {
            btnNoThanks.click();
            reportLog("Successfully clicked on 'No thanks' Button");
        }
    }

    public void clickOnShowMeButton() {
        if (btnOkShowMe.isElementPresent()) {
            btnOkShowMe.click();
            reportLog("Successfully clicked on 'Show me' Button");
        }
    }

    public boolean verifyNowWhatHappenButton() {
        return btnNowWhatHappen.isElementPresent();
    }

    public void clickOnNowWhatHappenButton() {
        if (btnNowWhatHappen.isElementPresent()) {
            btnNowWhatHappen.click();
            reportLog("Successfully clicked on 'Now What Happen' Button");
        }
    }

    public boolean verifyCommentButton() {
        waitForSec(5);
        return btnComment.isElementPresent();
    }

    public void clickOnExitCloseIcon() {
        if (iconExitClose.isElementPresent()) {
            iconExitClose.click();
            reportLog("Successfully clicked on Exit close icon");
        }
    }

    public boolean verifyAskQuestionPlaceHolder() {
        waitForSec(5);
        return placeHolderAskQuestion.isElementPresent();
    }

    public void clickOnAskQuestionPlaceHolder() {
        if (placeHolderAskQuestion.isElementPresent()) {
            placeHolderAskQuestion.click();
            reportLog("Successfully clicked on Ask Question Place Holder");
        }
    }

    public boolean verifyEditTextContainerLayout() {
        return containerLayout.isElementPresent();
    }

    public boolean verifyPleaseWriteQuestionText() {
        return txtPleaseWriteQuestion.isElementPresent();
    }

    public void setTextInAskQuestionPlaceHolder(String text) {
        if (placeHolderQuestion.isElementPresent()) {
            placeHolderQuestion.setText(text + currentTimeStamp());
            reportLog("Successfully Set Text in Ask Question Place Holder");
        }
    }

    public void getPlaceHolderTextBeforePost() {
        if (txtInPlaceHolder.isElementPresent()) {
            String placeHolderText = txtInPlaceHolder.getText();
            reportLog("Successfully retrieved text From place Holder Text is = " + placeHolderText);
        }
    }

    public void clickOnPostButton() {
        waitForSec(5);
        if (btnPost.isElementPresent()) {
            btnPost.clickJScript();
            reportLog("Successfully clicked on 'Post' Button");
        }
    }

    public boolean verifyQuestionAddedAfterPost() {
        waitForSec(5);
        return countBefore != countAfter;
    }
}