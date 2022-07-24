package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GuiControl;

public class RecommendationParagraphFeature extends PageMenuTab {
    private static final Logger logger = Logger.getLogger(RecommendationParagraphFeature.class);

    private final GuiControl textAnnotator = new GuiControl(getElementMap().get("textAnnotator"), webDriver);
    private final GuiControl iconIndicatorRing = new GuiControl(getElementMap().get("iconIndicatorRing"), webDriver);
    private final GuiControl textRecommendationParagraph = new GuiControl(getElementMap().get("textRecommendationParagraph"), webDriver);
    private final GuiControl textMissedQuestion = new GuiControl(getElementMap().get("textMissedQuestion"), webDriver);
    private final GuiControl iconArrowLeft = new GuiControl(getElementMap().get("iconArrowLeft"), webDriver);
    private final GuiControl iconArrowRight = new GuiControl(getElementMap().get("iconArrowRight"), webDriver);
    private final GuiControl dotActive = new GuiControl(getElementMap().get("dotActive"), webDriver);
    private final GuiControl dotNonActive = new GuiControl(getElementMap().get("dotNonActive"), webDriver);
    private final GuiControl questionMultipleChoice = new GuiControl(getElementMap().get("questionMultipleChoice"), webDriver);
    private final GuiControl questionFillInTheBlanks = new GuiControl(getElementMap().get("questionFillInTheBlanks"), webDriver);
    private final GuiControl optionD = new GuiControl(getElementMap().get("optionD"), webDriver);
    private final GuiControl iconCheckMark = new GuiControl(getElementMap().get("iconCheckMark"), webDriver);
    private final GuiControl btnTryAgain = new GuiControl(getElementMap().get("btnTryAgain"), webDriver);
    private final GuiControl btnCheckIt = new GuiControl(getElementMap().get("btnCheckIt"), webDriver);
    private final GuiControl answerPlaceHolder = new GuiControl(getElementMap().get("answerPlaceHolder"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl iconQuestionModalClose = new GuiControl(getElementMap().get("iconQuestionModalClose"), webDriver);
    private final GuiControl frameElement = new GuiControl(getElementMap().get("frameElement"), webDriver);

    public RecommendationParagraphFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void scrollScreen() {
        waitForSec(5);
        textAnnotator.scrollIntoView();
        reportLog("Successfully Scroll Screen Through Annotator Text");
    }

    public boolean verifyIndicatorRingIcon() {
        waitForSec(5);
        return iconIndicatorRing.isElementPresent();
    }

    public void clickOnIndicatorRingIcon() {
        if (iconIndicatorRing.isElementPresent()) {
            iconIndicatorRing.clickJScript();
            reportLog("Successfully clicked On Indicator Ring Icon");
        }
    }

    public boolean verifyRecommendationParagraphText() {
        waitForSec(5);
        return textRecommendationParagraph.isElementPresent();
    }

    public boolean verifyMissedQuestionsText() {
        return textMissedQuestion.isElementPresent();
    }

    public boolean verifyLeftArrowIcon() {
        return iconArrowLeft.isElementPresent();
    }

    public void clickOnLeftArrowIcon() {
        if (iconArrowLeft.isElementPresent()) {
            iconArrowLeft.clickJScript();
            reportLog("Successfully clicked On Arrow Left Icon");
        }
    }

    public boolean verifyRightArrowIcon() {
        return iconArrowRight.isElementPresent();
    }

    public void clickOnRightArrowIcon() {
        if (iconArrowRight.isElementPresent()) {
            iconArrowRight.clickJScript();
            reportLog("Successfully clicked On Arrow Right Icon");
        }
    }

    public boolean verifyMultipleChoiceQuestion() {
        return questionMultipleChoice.isElementPresent();
    }

    public boolean verifyFillInTheBlanksQuestion() {
        return questionFillInTheBlanks.isElementPresent();
    }

    public boolean verifyNonActiveDot() {
        return dotNonActive.isElementPresent();
    }

    public void clickOnNonActiveDot() {
        if (dotNonActive.isElementPresent()) {
            dotNonActive.clickJScript();
            reportLog("Successfully clicked On Non Active Dot");
        }
    }

    public boolean verifyActiveDot() {
        return dotActive.isElementPresent();
    }

    public boolean verifyOptionD() {
        return optionD.isElementPresent();
    }

    public void clickOnOptionD() {
        if (optionD.isElementPresent()) {
            optionD.clickJScript();
            reportLog("Successfully clicked On Option D");
        }
    }

    public boolean verifyCheckMarkIcon() {
        waitForSec(5);
        return iconCheckMark.isElementPresent();
    }

    public boolean verifyTryAgainButton() {
        btnTryAgain.scrollIntoView();
        waitForSec(5);
        return btnTryAgain.isElementPresent();
    }

    public void clickOnTryAgainButton() {
        if (btnTryAgain.isElementPresent()) {
            btnTryAgain.clickJScript();
            reportLog("Successfully clicked On Try Again Button");
        }
    }

    public boolean verifyCheckMarkIconIsNotPresent() {
        return !iconCheckMark.isElementPresent();
    }

    public boolean verifyCheckItButton() {
        waitForSec(5);
        return btnCheckIt.isElementPresent();
    }

    public void clickOnCheckItButton() {
        if (btnCheckIt.isElementPresent()) {
            btnCheckIt.clickJScript();
            reportLog("Successfully clicked On Check It Button");
        }
    }

    public void setValueInAnswerPlaceHolder() {
        String answer = "23";
        if (answerPlaceHolder.isElementPresent()) {
            answerPlaceHolder.clickJScript();
            reportLog("Successfully clicked On Answer Place Holder");
            answerPlaceHolder.setText(answer);
            reportLog("Successfully Set Value In Answer Place Holder");
        }
    }

    public boolean verifyCloseIcon() {
        waitForSec(5);
        return iconClose.isElementPresent();
    }

    public boolean verifyCloseIconIsNotPresent() {
        return !iconClose.isElementPresent();
    }

    public boolean verifyQuestionModalCloseIcon() {
        return iconQuestionModalClose.isElementPresent();
    }

    public void clickOnQuestionModalCloseIcon() {
        if (iconQuestionModalClose.isElementPresent()) {
            iconQuestionModalClose.clickJScript();
            reportLog("Successfully clicked On Question Modal Close Icon");
        }
    }

    public void enterIntoParentFrame(){
        waitForSec(5);
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@src='/assessment/ui/?test/view/previewQuestion/5801da43da2cfe15783187c2']")));
        reportLog("Successfully Enter Into Parent Frame");
    }

    public void removeFromFrame(){
        webDriver.switchTo().defaultContent();
        reportLog("Successfully Remove From Frame");
    }

    public void enterIntoChildFrame(){
        waitForSec(5);
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@src='/assessment/ui/?test/view/previewQuestion/58920725da2cfe7e473c68e8']")));
        reportLog("Successfully Enter Into Parent Frame");
    }
}
