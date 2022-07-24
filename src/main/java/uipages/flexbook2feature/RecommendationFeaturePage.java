package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

import java.util.Set;

public class RecommendationFeaturePage extends BasePage {
    private static final Logger logger = Logger.getLogger(RecommendationFeaturePage.class);

    private final GuiControl textWeRecommend = new GuiControl(getElementMap().get("textWeRecommend"), webDriver);
    private final GuiControl textRecommendTitle = new GuiControl(getElementMap().get("textRecommendTitle"), webDriver);
    private final GuiControl textBubbleSpeech = new GuiControl(getElementMap().get("textBubbleSpeech"), webDriver);
    private final GuiControl imageCharacter = new GuiControl(getElementMap().get("imageCharacter"), webDriver);
    private final GuiControl iconCloseBubble = new GuiControl(getElementMap().get("iconCloseBubble"), webDriver);
    private final GuiControl readModalityType = new GuiControl(getElementMap().get("readModalityType"), webDriver);
    private final GuiControl videoModalityType = new GuiControl(getElementMap().get("videoModalityType"), webDriver);
    private final GuiControl realWorldModalityType = new GuiControl(getElementMap().get("realWorldModalityType"), webDriver);
    private final GuiControl textModalityTitle = new GuiControl(getElementMap().get("textModalityTitle"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl iconReadCheckMark = new GuiControl(getElementMap().get("iconReadCheckMark"), webDriver);
    private final GuiControl iconVideoCheckMark = new GuiControl(getElementMap().get("iconVideoCheckMark"), webDriver);
    private final GuiControl iconRealWorldCheckMark = new GuiControl(getElementMap().get("iconRealWorldCheckMark"), webDriver);
    private final GuiControl contentModality = new GuiControl(getElementMap().get("contentModality"), webDriver);
    private final GuiControl linkReturnToPractice = new GuiControl(getElementMap().get("linkReturnToPractice"), webDriver);
    private final GuiControl iconUnlocked = new GuiControl(getElementMap().get("iconUnlocked"), webDriver);
    private final GuiControl btnStartPractice = new GuiControl(getElementMap().get("btnStartPractice"), webDriver);
    private final GuiControl textSkillLevel = new GuiControl(getElementMap().get("textSkillLevel"), webDriver);
    private final GuiControl imageSkillDial = new GuiControl(getElementMap().get("imageSkillDial"), webDriver);
    private final GuiControl textSkillLabel = new GuiControl(getElementMap().get("textSkillLabel"), webDriver);
    private final GuiControl iconSkillLevelWrapper = new GuiControl(getElementMap().get("iconSkillLevelWrapper"), webDriver);
    private final GuiControl textSpeech = new GuiControl(getElementMap().get("textSpeech"), webDriver);
    private final GuiControl speechOkBtn = new GuiControl(getElementMap().get("speechOkBtn"), webDriver);
    private final GuiControl placeHolderAnswer = new GuiControl(getElementMap().get("placeHolderAnswer"), webDriver);
    private final GuiControl btnCheckIt = new GuiControl(getElementMap().get("btnCheckIt"), webDriver);
    private final GuiControl btnNextQuestion = new GuiControl(getElementMap().get("btnNextQuestion"), webDriver);
    private final GuiControl textWrongMessage = new GuiControl(getElementMap().get("textWrongMessage"), webDriver);
    private final GuiControl OptionA = new GuiControl(getElementMap().get("OptionA"), webDriver);

    public RecommendationFeaturePage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void giveTheAnswerOfQuestions() {
        try {
            if (placeHolderAnswer.isElementPresent()) {
                setValueInAnswerPlaceHolder();
                clickOnCheckItButton();
                verifyWrongAnswerText();
                if (verifyWeRecommendText()) {
                    reportLog("Now Recommendation Pop Up is Display");
                } else {
                    clickOnNextButton();
                    giveTheAnswerOfQuestions();
                }
            } else {
                OptionA.isElementPresent();
                OptionA.clickJScript();
                clickOnCheckItButton();
                if (verifyWeRecommendText()) {
                    reportLog("Now Recommendation Pop Up is Display");
                } else {
                    clickOnNextButton();
                    giveTheAnswerOfQuestions();
                }
            }
        } catch (Exception e) {
            logger.info(e);
        }
    }

    public boolean verifyWeRecommendText() {
        waitForSec(10);
        return textWeRecommend.isElementPresent();
    }

    public boolean verifyRecommendTitleText() {
        waitForSec(2);
        return textRecommendTitle.isElementPresent();
    }

    public boolean verifySpeechText() {
        return textSpeech.isElementPresent();
    }

    public boolean verifySkillLabelText() {
        return textSkillLabel.isElementPresent();
    }

    public boolean verifySkillDialImage() {
        return imageSkillDial.isElementPresent();
    }

    public boolean verifyBubbleSpeechIsDisplay() {
        return textBubbleSpeech.isElementPresent();
    }

    public boolean verifyCharacterImage() {
        return imageCharacter.isElementPresent();
    }

    public boolean verifyBubbleSpeechIsNotDisplay() {
        return !textBubbleSpeech.isElementPresent();
    }

    public boolean verifyCloseBubbleIcon() {
        return iconCloseBubble.isElementPresent();
    }

    public void clickOnCloseBubbleIcon() {
        if (iconCloseBubble.isElementPresent()) {
            iconCloseBubble.clickJScript();
            reportLog("Successfully click on the close Bubble ICon");
        }
    }

    public boolean verifyModalityTypeRead() {
        return readModalityType.isElementPresent();
    }

    public void clickOnModalityTypeRead() {
        if (readModalityType.isElementPresent()) {
            readModalityType.clickJScript();
            reportLog("Successfully click on the Modality Type Read");
        }
    }

    public boolean verifyModalityTypeVideo() {
        return videoModalityType.isElementPresent();
    }

    public void clickOnModalityTypeVideo() {
        if (videoModalityType.isElementPresent()) {
            videoModalityType.clickJScript();
            reportLog("Successfully click on the Modality Type Video");
        }
    }

    public boolean verifyModalityTypeRealWorld() {
        return realWorldModalityType.isElementPresent();
    }

    public void clickOnModalityTypeRealWorld() {
        if (realWorldModalityType.isElementPresent()) {
            realWorldModalityType.clickJScript();
            reportLog("Successfully click on the Modality Type Real World");
        }
    }

    public boolean verifyModalityTitleText() {
        return textModalityTitle.isElementPresent();
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public boolean verifyMultipleBrowserTabsPresent() {
        Set<String> handles = webDriver.getWindowHandles();
        return (handles.size()>1);
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Successfully click on the close ICon");
        }
    }

    public boolean verifyReadCheckMarkIcon() {
        return iconReadCheckMark.isElementPresent();
    }

    public boolean verifyVideoCheckMarkIcon() {
        return iconVideoCheckMark.isElementPresent();
    }

    public boolean verifyRealWorldCheckMarkIcon() {
        return iconRealWorldCheckMark.isElementPresent();
    }

    public boolean verifyModalityContent() {
        return contentModality.isElementPresent();
    }

    public boolean verifyReturnToPracticeIcon() {
        return linkReturnToPractice.isElementPresent();
    }

    public void clickOnReturnToPracticeIcon() {
        if (linkReturnToPractice.isElementPresent()) {
            linkReturnToPractice.clickJScript();
            reportLog("Successfully click on the  Return To Practice Icon");
        }
    }

    public boolean verifyUnlockedIcon() {
        return iconUnlocked.isElementPresent();
    }

    public boolean verifyStartPracticeButton() {
        waitForSec(5);
        return btnStartPractice.isElementPresent();
    }

    public void clickOnStartPracticeButton() {
        if (btnStartPractice.isElementPresent()) {
            btnStartPractice.clickJScript();
            reportLog("Successfully click on the  Start Practice Button");
        }
    }

    public void enteredIntoFrame() {
        waitForSec(5);
        webDriver.switchTo().frame("embedModalityContainer");
        reportLog("Successfully Entered In the Frame ");
    }

    public void removeFromFrame() {
        webDriver.switchTo().defaultContent();
        reportLog("Successfully Remove From Frame ");
    }

    public boolean verifySkillLevelText() {
        waitForSec(5);
        return textSkillLevel.isElementPresent();
    }

    public boolean verifySkillLevelWrapperIcon() {
        return iconSkillLevelWrapper.isElementPresent();
    }

    public void clickOnSKillLevelWrapperIcon() {
        if (iconSkillLevelWrapper.isElementPresent()) {
            iconSkillLevelWrapper.clickJScript();
            reportLog("Successfully click on the close ICon");
        }
    }

    public boolean verifyOkButton() {
        return speechOkBtn.isElementPresent();
    }

    public void clickOnOkButton() {
        if (speechOkBtn.isElementPresent()) {
            speechOkBtn.clickJScript();
            reportLog("Successfully click on the Speech Ok button");
        }
    }

    private void clickOnCheckItButton() {
        if (btnCheckIt.isElementPresent()) {
            btnCheckIt.clickJScript();
            reportLog("Successfully click on the CheckIT button");
        }
    }

    private void clickOnNextButton() {
        if (btnNextQuestion.isElementPresent()) {
            btnNextQuestion.clickJScript();
            reportLog("Successfully click on the Next button");
        }
    }

    private boolean verifyWrongAnswerText() {
        waitForSec(5);
        return textWrongMessage.isElementPresent();
    }

    private void setValueInAnswerPlaceHolder() {
        if (placeHolderAnswer.isElementPresent()) {
            placeHolderAnswer.clickJScript();
            placeHolderAnswer.setText("25");
            reportLog("Successfully Set Value In Answer PlaceHolder");
        }
    }
}