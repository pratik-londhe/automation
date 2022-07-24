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

public class CK12SubjectsPage extends BasePage {

    private final GuiControl listOfChapters = new GuiControl(getElementMap().get("listOfChapters"), webDriver);
    private final GuiControl linkHaveAClass = new GuiControl(getElementMap().get("linkHaveAClass"), webDriver);
    private final GuiControl btnStartLearning = new GuiControl(getElementMap().get("btnStartLearning"), webDriver);
    private final GuiControl iconCloseJoinClass = new GuiControl(getElementMap().get("iconCloseJoinClass"), webDriver);
    private final GuiControl textEmptyCodeMsg = new GuiControl(getElementMap().get("textEmptyCodeMsg"), webDriver);
    private final GuiControl textEnterYourClassCode = new GuiControl(getElementMap().get("textEnterYourClassCode"), webDriver);
    private final GuiControl btnJoinClass = new GuiControl(getElementMap().get("btnJoinClass"), webDriver);
    private final GuiControl btnPlay = new GuiControl(getElementMap().get("btnPlay"), webDriver);
    private final GuiControl textVideoTitle = new GuiControl(getElementMap().get("textVideoTitle"), webDriver);
    private final GuiControl textWhatDoYouWantToLearn = new GuiControl(getElementMap().get("textWhatDoYouWantToLearn"), webDriver);
    private final GuiControl iconCk12Image = new GuiControl(getElementMap().get("iconCk12Image"), webDriver);
    private final GuiControl btnStartBrowsing = new GuiControl(getElementMap().get("btnStartBrowsing"), webDriver);
    private final GuiControl textWhatDoYouWantToTeach = new GuiControl(getElementMap().get("textWhatDoYouWantToTeach"), webDriver);
    private final GuiControl textMathByLevel = new GuiControl(getElementMap().get("textMathByLevel"), webDriver);
    private final GuiControl textScience = new GuiControl(getElementMap().get("textScience"), webDriver);
    private final GuiControl textCollege = new GuiControl(getElementMap().get("textCollege"), webDriver);
    private final GuiControl textCountry = new GuiControl(getElementMap().get("textCountry"), webDriver);
    private final GuiControl textExploreSomeOurProducts = new GuiControl(getElementMap().get("textExploreSomeOurProducts"), webDriver);
    private final GuiControl linkBrowseFlexBook = new GuiControl(getElementMap().get("linkBrowseFlexBook"), webDriver);
    private final GuiControl linkBrowseAdaptivePractice = new GuiControl(getElementMap().get("linkBrowseAdaptivePractice"), webDriver);
    private final GuiControl linkPhysics = new GuiControl(getElementMap().get("linkPhysics"), webDriver);
    private final GuiControl linkChemistry = new GuiControl(getElementMap().get("linkChemistry"), webDriver);
    private final GuiControl linkPlix = new GuiControl(getElementMap().get("linkPlix"), webDriver);
    private final GuiControl linkStudyGuide = new GuiControl(getElementMap().get("linkStudyGuide"), webDriver);
    private final GuiControl linkFindYourSchool = new GuiControl(getElementMap().get("linkFindYourSchool"), webDriver);
    private final GuiControl textFlexBook = new GuiControl(getElementMap().get("textFlexBook"), webDriver);
    private final GuiControl frameElement = new GuiControl(getElementMap().get("frameElement"), webDriver);
    private final GuiControl carousel = new GuiControl(getElementMap().get("carousel"), webDriver);

    public CK12SubjectsPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyTheListOfChaptersOfSubject() {
        boolean result = false;
        List<WebElement> chapters = listOfChapters.getWebElements();
        reportLog("Total Chapters Are: " + chapters.size());
        for (WebElement chapterName : chapters) {
            if (chapterName.isDisplayed()) {
                reportLog("Chapter is: " + chapterName.getText());
                result = true;
            }
        }
        return result;
    }

    public void scrollExploreSoeOtherText() {
        waitForSec(5);
        textExploreSomeOurProducts.scrollIntoView();
        waitForSec(5);
    }

    public boolean verifyBrowseFleBookLink() {
        return linkBrowseFlexBook.isElementPresent();
    }

    public void clickOnBrowseFleBookLink() {
        if (linkBrowseFlexBook.isElementPresent()) {
            linkBrowseFlexBook.clickJScript();
            reportLog("Successfully Clicked On Browse FleBook Link");
        }
    }

    public boolean verifyAdaptivePracticeLink() {
        return linkBrowseAdaptivePractice.isElementPresent();
    }

    public void clickOnAdaptivePracticeLink() {
        if (linkBrowseAdaptivePractice.isElementPresent()) {
            linkBrowseAdaptivePractice.clickJScript();
            reportLog("Successfully Clicked On Adaptive Practice Link");
        }
    }

    public boolean verifyFindYourLink() {
        return linkFindYourSchool.isElementPresent();
    }

    public void clickOnFindYourLink() {
        if (linkFindYourSchool.isElementPresent()) {
            linkFindYourSchool.clickJScript();
            reportLog("Successfully Clicked On Find Your Link");
        }
    }

    public boolean verifyStudyGuideLink() {
        return linkStudyGuide.isElementPresent();
    }

    public void clickOnStudyGuideLink() {
        if (linkStudyGuide.isElementPresent()) {
            linkStudyGuide.clickJScript();
            reportLog("Successfully Clicked On Study Guide Link");
        }
    }

    public boolean verifyPhysicsLink() {
        return linkPhysics.isElementPresent();
    }

    public void clickOnPhysicsLink() {
        if (linkPhysics.isElementPresent()) {
            linkPhysics.clickJScript();
            reportLog("Successfully Clicked On Physics Link");
        }
    }

    public boolean verifyChemistryLink() {
        return linkChemistry.isElementPresent();
    }

    public void clickOnChemistryLink() {
        if (linkChemistry.isElementPresent()) {
            linkChemistry.clickJScript();
            reportLog("Successfully Clicked On Chemistry Link");
        }
    }

    public boolean verifyPlixLink() {
        return linkPlix.isElementPresent();
    }

    public void clickOnPlixLink() {
        if (linkPlix.isElementPresent()) {
            linkPlix.clickJScript();
            reportLog("Successfully Clicked On Plix Link");
        }
    }

    public boolean verifyWhatDoYouWantYoTeachText() {
        waitForSec(2);
        return textWhatDoYouWantToTeach.isElementPresent();
    }

    public boolean verifyMathText() {
        return textMathByLevel.isElementPresent();
    }

    public boolean verifyScienceText() {
        return textScience.isElementPresent();
    }

    public boolean verifyCollegeText() {
        return textCollege.isElementPresent();
    }

    public boolean verifyCountryText() {
        return textCountry.isElementPresent();
    }

    public boolean verifyStartBrowsingButton() {
        waitForSec(5);
        try{
            carousel.clickJScript();
            return btnStartBrowsing.isElementPresent();
        }catch (Exception e){
            logger.info(e);
            return btnStartBrowsing.isElementPresent();
        }

    }

    public boolean verifyFlexBookText() {
        waitForSec(5);
        return textFlexBook.isElementPresent();
    }

    public void clickOnStartBrowsingButton() {
        if (btnStartBrowsing.isElementPresent()) {
            btnStartBrowsing.clickJScript();
            reportLog("Successfully Clicked On Start Browsing button");
        }
    }

    public boolean verifyStartLearningButton() {
        return btnStartLearning.isElementPresent();
    }

    public void clickOnStartLearningButton() {
        if (btnStartLearning.isElementPresent()) {
            btnStartLearning.click();
            reportLog("Successfully Clicked On Start learning button");
        }
    }

    public boolean verifyHaveClassCodeLink() {
        waitForSec(5);
        return linkHaveAClass.isElementPresent();
    }

    public void clickOnHaveClassCodeLink() {
        if (linkHaveAClass.isElementPresent()) {
            linkHaveAClass.click();
            reportLog("Successfully Clicked On Have Class Code Link");
        }
    }

    public boolean verifyCloseJoinClassIcon() {
        return iconCloseJoinClass.isElementPresent();
    }

    public void clickOnCloseJoinClassIcon() {
        if (iconCloseJoinClass.isElementPresent()) {
            iconCloseJoinClass.click();
            reportLog("Successfully Clicked On Close Join Class Icon");
        }
    }

    public boolean verifyTextEmptyErrorMessage() {
        waitForSec(5);
        return textEmptyCodeMsg.isElementPresent();
    }

    public boolean verifyEnterYourCodeText() {
        waitForSec(5);
        return textEnterYourClassCode.isElementPresent();
    }

    public boolean verifyJoinClassButton() {
        return btnJoinClass.isElementPresent();
    }

    public void clickOnJoinClassButton() {
        if (btnJoinClass.isElementPresent()) {
            btnJoinClass.click();
            reportLog("Successfully Clicked On  Join Class Button");
        }
    }

    public void enterIntoParentFrame() {
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@title='CK-12 Student Overview']")));
        reportLog("Successfully Enter Into Parent Frame");
    }

    public void removeFromFrame() {
        webDriver.switchTo().defaultContent();
        reportLog("Successfully Enter Into Parent Frame");
    }

    public boolean verifyPlayButton() {
        return btnPlay.isElementPresent();
    }

    public void clickOnPlayButton() {
        if (btnPlay.isElementPresent()) {
            btnPlay.click();
            reportLog("Successfully Clicked On  Play Button");
        }
    }

    public boolean verifyVideoTitleText() {
        waitForSec(5);
        return textVideoTitle.isElementPresent();
    }

    public boolean verifyWhatDoYouWantYoLearnText() {
        waitForSec(2);
        return textWhatDoYouWantToLearn.isElementPresent();
    }

    public boolean verifyCK12ImageIcon() {
        return iconCk12Image.isElementPresent();
    }

    public void clickOnCK12ImageIcon() {
        if (iconCk12Image.isElementPresent()) {
            iconCk12Image.clickJScript();
            reportLog("Clicked on Ck12 Image Icon.");
        }
    }
}