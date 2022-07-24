package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class AdaptivePracticeFeature extends BasePage {

    private String branchName;

    private final GuiControl containerAdaptivePractice = new GuiControl(getElementMap().get("containerAdaptivePractice"), webDriver);
    private final GuiControl iconBrowseBack = new GuiControl(getElementMap().get("iconBrowseBack"), webDriver);
    private final GuiControl textAdaptivePractice = new GuiControl(getElementMap().get("textAdaptivePractice"), webDriver);
    private final GuiControl placeHolderSearch = new GuiControl(getElementMap().get("placeHolderSearch"), webDriver);
    private final GuiControl textGradeSubjectTitle = new GuiControl(getElementMap().get("textGradeSubjectTitle"), webDriver);
    private final GuiControl textMathSubjectTitle = new GuiControl(getElementMap().get("textMathSubjectTitle"), webDriver);
    private final GuiControl iconCk12 = new GuiControl(getElementMap().get("iconCk12"), webDriver);
    private final GuiControl textSearchResult = new GuiControl(getElementMap().get("textSearchResult"), webDriver);
    private final GuiControl textSearchNotFound = new GuiControl(getElementMap().get("textSearchNotFound"), webDriver);
    private final GuiControl linkConceptName = new GuiControl(getElementMap().get("linkConceptName"), webDriver);
    private final GuiControl iconUserAvatar = new GuiControl(getElementMap().get("iconUserAvatar"), webDriver);
    private final GuiControl textEmailId = new GuiControl(getElementMap().get("textEmailId"), webDriver);
    private final GuiControl textUserName = new GuiControl(getElementMap().get("textUserName"), webDriver);
    private final GuiControl linkSubjectGrade = new GuiControl(getElementMap().get("linkSubjectGrade"), webDriver);
    private final GuiControl iconTrack = new GuiControl(getElementMap().get("iconTrack"), webDriver);
    private final GuiControl textSubject = new GuiControl(getElementMap().get("textSubject"), webDriver);
    private final GuiControl dropDownSubject = new GuiControl(getElementMap().get("dropDownSubject"), webDriver);
    private final GuiControl linkArithmeticBranchName = new GuiControl(getElementMap().get("linkArithmeticBranchName"), webDriver);
    private final GuiControl textSubjectSelected = new GuiControl(getElementMap().get("textSubjectSelected"), webDriver);
    private final GuiControl linkConcept = new GuiControl(getElementMap().get("linkConcept"), webDriver);
    private final GuiControl btnKeepPracticing = new GuiControl(getElementMap().get("btnKeepPracticing"), webDriver);
    private final GuiControl btnGoToNextConcept = new GuiControl(getElementMap().get("btnGoToNextConcept"), webDriver);
    private final GuiControl linkAssignToClass = new GuiControl(getElementMap().get("linkAssignToClass"), webDriver);
    private final GuiControl linkCustomize = new GuiControl(getElementMap().get("linkCustomize"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl btnStopForNow = new GuiControl(getElementMap().get("btnStopForNow"), webDriver);
    private final GuiControl iconProgressLevel = new GuiControl(getElementMap().get("iconProgressLevel"), webDriver);
    private final GuiControl btnStartPracticing = new GuiControl(getElementMap().get("btnStartPracticing"), webDriver);
    private final GuiControl btnBack = new GuiControl(getElementMap().get("btnBack"), webDriver);
    private final GuiControl textAdditionalWaysToLearn = new GuiControl(getElementMap().get("textAdditionalWaysToLearn"), webDriver);
    private final GuiControl textTitle = new GuiControl(getElementMap().get("textTitle"), webDriver);
    private final GuiControl iconCk12Assign = new GuiControl(getElementMap().get("iconCk12Assign"), webDriver);
    private final GuiControl iconAssignToClass = new GuiControl(getElementMap().get("iconAssignToClass"), webDriver);
    private final GuiControl btnStart = new GuiControl(getElementMap().get("btnStart"), webDriver);
    private final GuiControl lnkGradeOne = new GuiControl(getElementMap().get("lnkGradeOne"), webDriver);
    private final GuiControl txtGradeOneFirstCategory = new GuiControl(getElementMap().get("txtGradeOneFirstCategory"), webDriver);
    private final GuiControl walkThroughPopup = new GuiControl(getElementMap().get("walkThroughPopup"), webDriver);

    public AdaptivePracticeFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver,extentTest,extentReports);
    }

    public boolean verifyAdaptivePracticeContainer() {
        waitForSec(5);
        return containerAdaptivePractice.isElementPresent();
    }

    public void clickOnAdaptivePracticeContainer() {
        if (containerAdaptivePractice.isElementPresent()) {
            containerAdaptivePractice.clickJScript();
            reportLog("Successfully Clicked On Adaptive Practice Container");
        }
    }

    public boolean verifyGradeSubjectTitleText() {
        return textGradeSubjectTitle.isElementPresent();
    }

    public boolean verifyMathSubjectTitleText() {
        return textMathSubjectTitle.isElementPresent();
    }

    public boolean verifySearchResultText() {
        return textSearchResult.isElementPresent();
    }

    public boolean verifySearchNotFoundText() {
        return textSearchNotFound.isElementPresent();
    }

    public boolean verifyUserEmailIdText() {
        waitForSec(5);
        return textEmailId.isElementPresent();
    }

    public boolean verifyUserNameText() {
        return textUserName.isElementPresent();
    }

    public boolean verifyBrowseBackIcon() {
        return iconBrowseBack.isElementPresent();
    }

    public boolean verifyConceptNameLink() {
        return linkConceptName.isElementPresent();
    }

    public void clickOnBrowseBackIcon() {
        if (iconBrowseBack.isElementPresent()) {
            iconBrowseBack.clickJScript();
            reportLog("Successfully Clicked On Browse Back Icon");
        }
    }

    public boolean verifyCk12Icon() {
        return iconCk12.isElementPresent();
    }

    public void clickOnCk12Icon() {
        if (iconCk12.isElementPresent()) {
            iconCk12.clickJScript();
            reportLog("Successfully Clicked On Ck12 Icon");
        }
    }

    public boolean verifySearchPlaceHolder() {
        return placeHolderSearch.isElementPresent();
    }

    public void setTextInSearchPlaceHolder(String value) {
        if (placeHolderSearch.isElementPresent()) {
            placeHolderSearch.clickJScript();
            placeHolderSearch.setText(value);
            reportLog("Successfully Set Text In Search Place Holder");
            placeHolderSearch.sendKeys(Keys.chord(Keys.ENTER));
            reportLog("Successfully Paste copied text");
        }
    }

    public boolean verifyAdaptivePracticeText() {
        waitForSec(5);
        return textAdaptivePractice.isElementPresent();
    }

    public boolean verifyUserIcon() {
        return iconUserAvatar.isElementPresent();
    }

    public void clickOnUserIcon() {
        if (iconUserAvatar.isElementPresent()) {
            iconUserAvatar.clickJScript();
            reportLog("Successfully Clicked On User Icon");
        }
    }

    public boolean verifyTrackIcon() {
        return iconTrack.isElementPresent();
    }

    public void clickOnTrackIcon() {
        if (iconTrack.isElementPresent()) {
            iconTrack.clickJScript();
            reportLog("Successfully Clicked On Track Icon");
        }
    }

    public boolean verifySubjectGradeLink() {
        return linkSubjectGrade.isElementPresent();
    }

    public void clickOnSubjectGradeLink() {
        if (linkSubjectGrade.isElementPresent()) {
            linkSubjectGrade.clickJScript();
            reportLog("Successfully Clicked On Subject Grade Link");
        }
    }

    public boolean verifySubjectText() {
        return textSubject.isElementPresent();
    }

    public boolean verifySubjectDropDown() {
        return dropDownSubject.isElementPresent();
    }

    public void clickOnSubjectDropDown() {
        if (dropDownSubject.isElementPresent()) {
            dropDownSubject.clickJScript();
            reportLog("Successfully Clicked On Subject DropDown");
        }
    }

    public boolean verifyArithmeticBranchLink() {
        waitForSec(5);
        return linkArithmeticBranchName.isElementPresent();
    }

    public void clickOnArithmeticBranchLink() {
        if (linkArithmeticBranchName.isElementPresent()) {
            linkArithmeticBranchName.clickJScript();
            reportLog("Successfully Clicked On Arithmetic Branch Name Link");
        }
    }

    public void getTextOfBranchLink() {
        if (linkArithmeticBranchName.isElementPresent()) {
            branchName = linkArithmeticBranchName.getText();
            reportLog("Successfully Get Branch Name Text");
        }
    }

    public boolean verifyUpdatedSubjectBranchName() {
        return branchName.equalsIgnoreCase(textSubjectSelected.getText());
    }

    public boolean verifyConceptLink() {
        return linkConcept.isElementPresent();
    }

    public void clickOnConceptLink() {
        waitForSec(2);
        if (linkConcept.isElementPresent()) {
            linkConcept.mouseHover();
            linkConcept.clickJScript();
            reportLog("Successfully Clicked On Arithmetic Branch Name Link");
        }
    }

    public boolean verifyKeepPracticingButton() {
        waitForSec(8);
        return btnKeepPracticing.isElementPresent();
    }

    public void clickOnKeepPracticingButton() {
        if (btnKeepPracticing.isElementPresent()) {
            btnKeepPracticing.clickJScript();
            reportLog("Successfully Clicked On Keep Practicing Button");
        }
    }

    public boolean verifyGotoNextConceptButton() {
        waitForSec(8);
        return btnGoToNextConcept.isElementPresent();
    }

    public void clickOnGotoNextConceptButton() {
        if (btnGoToNextConcept.isElementPresent()) {
            btnGoToNextConcept.clickJScript();
            reportLog("Successfully Clicked On GotoNextConcept Button");
        }
    }

    public boolean verifyAssignToClassLink() {
        return linkAssignToClass.isElementPresent();
    }

    public void clickOnAssignToClassLink() {
        waitForSec(4);
        if (linkAssignToClass.isElementPresent()) {
            linkAssignToClass.clickJScript();
            reportLog("Successfully Clicked On Assign To Class Link");
        }
    }

    public boolean verifyCustomizedLink() {
        waitForSec(4);
        return linkCustomize.isElementPresent();
    }

    public void clickOnCustomizedLink() {
        if (linkCustomize.isElementPresent()) {
            linkCustomize.clickJScript();
            reportLog("Successfully Clicked On Customized Link");
        }
    }

    public boolean verifyCloseIcon() {
        waitForSec(4);
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Successfully Clicked On Close Icon");
        }
    }

    public boolean verifyStopForNowButton() {
        waitForSec(8);
        return btnStopForNow.isElementPresent();
    }

    public void clickOnStopForNowButton() {
        if (btnStopForNow.isElementPresent()) {
            btnStopForNow.clickJScript();
            reportLog("Successfully Clicked On Stop For Now Button");
        }
    }

    public boolean verifyProgressLevelIcon() {
        return iconProgressLevel.isElementPresent();
    }

    public boolean verifyStartPracticingButton() {
        waitForSec(5);
        return btnStartPracticing.isElementPresent();
    }

    public boolean verifyBackButton() {
        waitForSec(5);
        return btnBack.isElementPresent();
    }

    public void clickOnBackButton() {
        if (btnBack.isElementPresent()) {
            btnBack.clickJScript();
            reportLog("Successfully Clicked On Back Button");
        }
    }

    public boolean verifyWaysToLEarnText() {
        return textAdditionalWaysToLearn.isElementPresent();
    }

    public boolean verifyTitleText() {
        waitForSec(5);
        return textTitle.isElementPresent();
    }

    public boolean verifyCk12AssignIcon() {
        waitForSec(5);
        return iconCk12Assign.isElementPresent();
    }

    public void clickOnCk12AssignIcon() {
        if (iconCk12Assign.isElementPresent()) {
            iconCk12Assign.clickJScript();
            reportLog("Successfully Clicked On Ck12 Assign Icon");
        }
    }

    public boolean verifyAssignToClassIcon() {
        waitForSec(5);
        return iconAssignToClass.isElementPresent();
    }

    public boolean verifyStartButton() {
        waitForSec(5);
        return btnStart.isElementPresent();
    }

    public void clickOnStartButton() {
        if (btnStart.isElementPresent()) {
            btnStart.clickJScript();
            reportLog("Successfully Clicked On Start Button");
        }
    }

    public void closeWalkthroughPopup() {
        if (walkThroughPopup.isElementPresent()) {
            walkThroughPopup.click();
        }
    }

    public void clickOnGradeOneLink() {
        if(lnkGradeOne.isElementPresent()) {
            lnkGradeOne.click();
            reportLog("Clicked on the link 'Grade 1'");
        }
    }

    public boolean verifyfirstCategoryInGradeOne() {
        //waitForSec(5);
        return (txtGradeOneFirstCategory.isElementPresent()&&
                txtGradeOneFirstCategory.getText().equalsIgnoreCase("Addition and Subtraction to 20"));
    }
}