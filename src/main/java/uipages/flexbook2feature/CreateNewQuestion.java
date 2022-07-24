package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CreateNewQuestion extends BasePage {

    private final GuiControl progressPercentage = new GuiControl(getElementMap().get("progressPercentage"), webDriver);
    private final GuiControl iconCloseProgressWrapper = new GuiControl(getElementMap().get("iconCloseProgressWrapper"), webDriver);
    private final GuiControl textQuestionAndAnswer = new GuiControl(getElementMap().get("textQuestionAndAnswer"), webDriver);
    private final GuiControl textFeedbackAndHints = new GuiControl(getElementMap().get("textFeedbackAndHints"), webDriver);
    private final GuiControl textRemember = new GuiControl(getElementMap().get("textRemember"), webDriver);

    public CreateNewQuestion(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyProgressPercentageBeforeCreatingQuestion(){
        waitForSec(2);
        return !"0%".equalsIgnoreCase(progressPercentage.getText());
    }

    public boolean verifyCloseProgressWrapperIcon(){
        return iconCloseProgressWrapper.isElementPresent();
    }

    public void clickOnCloseProgressWrapperIcon() {
        if (iconCloseProgressWrapper.isElementPresent()) {
            iconCloseProgressWrapper.clickJScript();
            reportLog("Successfully Clicked On Close Progress Wrapper Icon.");
        }
    }

    public boolean verifyQuestionAndAnswerText(){
        waitForSec(5);
        return textQuestionAndAnswer.isElementPresent();
    }

    public boolean verifyFeedbackAndHintText(){
        return textFeedbackAndHints.isElementPresent();
    }

    public boolean verifyRememberText(){

        return textRemember.isElementPresent();
    }
}
