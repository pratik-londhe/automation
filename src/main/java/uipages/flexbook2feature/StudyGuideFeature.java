package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class StudyGuideFeature extends BasePage {

    private List<WebElement> algebraTitles;
    private List<WebElement> geometryTitles;
    private List<WebElement> earthScienceTitles;
    private List<WebElement> biologyTitles;
    private List<WebElement> physicsTitles;

    private final GuiControl linkStudyGuides = new GuiControl(getElementMap().get("linkStudyGuides"), webDriver);
    private final GuiControl textStudyGuides = new GuiControl(getElementMap().get("textStudyGuides"), webDriver);
    private final GuiControl iconCK12 = new GuiControl(getElementMap().get("iconCK12"), webDriver);
    private final GuiControl placeHolderSearch = new GuiControl(getElementMap().get("placeHolderSearch"), webDriver);
    private final GuiControl textNoResult = new GuiControl(getElementMap().get("textNoResult"), webDriver);
    private final GuiControl linkSearchResult = new GuiControl(getElementMap().get("linkSearchResult"), webDriver);
    private final GuiControl iconCloseSearch = new GuiControl(getElementMap().get("iconCloseSearch"), webDriver);
    private final GuiControl linkGeometryBranch = new GuiControl(getElementMap().get("linkGeometryBranch"), webDriver);
    private final GuiControl linkAlgebraBranch = new GuiControl(getElementMap().get("linkAlgebraBranch"), webDriver);
    private final GuiControl linkEarthScienceBranch = new GuiControl(getElementMap().get("linkEarthScienceBranch"), webDriver);
    private final GuiControl linkBiologyBranch = new GuiControl(getElementMap().get("linkBiologyBranch"), webDriver);
    private final GuiControl linkPhysicsBranch = new GuiControl(getElementMap().get("linkPhysicsBranch"), webDriver);
    private final GuiControl textConceptTitles = new GuiControl(getElementMap().get("textConceptTitles"), webDriver);
    private final GuiControl linkFirstConcept = new GuiControl(getElementMap().get("linkFirstConcept"), webDriver);
    private final GuiControl linkLandingPage = new GuiControl(getElementMap().get("linkLandingPage"), webDriver);
    private final GuiControl textTitle = new GuiControl(getElementMap().get("textTitle"), webDriver);
    private final GuiControl linkToolTip = new GuiControl(getElementMap().get("linkToolTip"), webDriver);
    private final GuiControl linkDownload = new GuiControl(getElementMap().get("linkDownload"), webDriver);
    private final GuiControl linkAddToLibrary = new GuiControl(getElementMap().get("linkAddToLibrary"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl iconCloseAlertModal = new GuiControl(getElementMap().get("iconCloseAlertModal"), webDriver);
    private final GuiControl btnOK = new GuiControl(getElementMap().get("btnOK"), webDriver);
    private final GuiControl textAlert = new GuiControl(getElementMap().get("textAlert"), webDriver);
    private final GuiControl linkBrowseConcept = new GuiControl(getElementMap().get("linkBrowseConcept"), webDriver);
    private final GuiControl textModalityTitle = new GuiControl(getElementMap().get("textModalityTitle"), webDriver);
    private final GuiControl iconCloseModalWindow = new GuiControl(getElementMap().get("iconCloseModalWindow"), webDriver);
    private final GuiControl linkRead = new GuiControl(getElementMap().get("linkRead"), webDriver);
    private final GuiControl linkVideo = new GuiControl(getElementMap().get("linkVideo"), webDriver);
    private final GuiControl textVideo = new GuiControl(getElementMap().get("textVideo"), webDriver);
    private final GuiControl textRead = new GuiControl(getElementMap().get("textRead"), webDriver);
    private final GuiControl tabStandard = new GuiControl(getElementMap().get("tabStandard"), webDriver);
    private final GuiControl tagStandardCover = new GuiControl(getElementMap().get("tagStandardCover"), webDriver);
    private final GuiControl textStandardView = new GuiControl(getElementMap().get("textStandardView"), webDriver);
    private final GuiControl linkNinthConcept = new GuiControl(getElementMap().get("linkNinthConcept"), webDriver);

    public StudyGuideFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyStudyGuideLink() {
        return linkStudyGuides.isElementPresent();
    }

    public void clickOnStudyGuideLink() {
        if (linkStudyGuides.isElementPresent()) {
            linkStudyGuides.clickJScript();
            reportLog("Clicked on Study Guide link.");
        }
    }

    public boolean verifyStandardInfoTab() {
        linkNinthConcept.scrollIntoView();
        waitForSec(2);
        return tabStandard.isElementPresent();
    }

    public void clickOnStandardInfoTab() {
        if (tabStandard.isElementPresent()) {
            tabStandard.clickJScript();
            reportLog("Clicked on Standard Info Tab.");
        }
    }

    public boolean verifyStandardCoverTag() {
        return tagStandardCover.isElementPresent();
    }

    public void clickOnStandardCoverTag() {
        if (tagStandardCover.isElementPresent()) {
            tagStandardCover.mouseHover();
            tagStandardCover.click();
            reportLog("Clicked on Standard Cover Tag.");
        }
    }

    public boolean verifyStandardView() {
        return textStandardView.isElementPresent();
    }

    public boolean verifyBrowseConceptLink() {
        return linkBrowseConcept.isElementPresent();
    }

    public void clickOnBrowseConceptLink() {
        if (linkBrowseConcept.isElementPresent()) {
            linkBrowseConcept.clickJScript();
            reportLog("Clicked on Browse Concept link.");
        }
    }

    public boolean verifyStudyGuideText() {
        waitForSec(5);
        return textStudyGuides.isElementPresent();
    }

    public boolean verifyModalityTitleText() {
        waitForSec(5);
        return textModalityTitle.isElementPresent();
    }

    public boolean verifyCK12ImageIcon() {
        return iconCK12.isElementPresent();
    }

    public void clickOnCK12ImageIcon() {
        if (iconCK12.isElementPresent()) {
            iconCK12.clickJScript();
            reportLog("Clicked on Ck12 Image Icon.");
        }
    }

    public boolean verifyCloseWindowModalIcon() {
        return iconCloseModalWindow.isElementPresent();
    }

    public void clickOnCloseWindowModalIcon() {
        if (iconCloseModalWindow.isElementPresent()) {
            iconCloseModalWindow.clickJScript();
            reportLog("Clicked on Close Window Modal Icon.");
        }
    }

    public boolean verifySearchPlaceHolder() {
        waitForSec(2);
        return placeHolderSearch.isElementPresent();
    }

    public void setValueInSearchPlaceHolder(String text) {
        if (placeHolderSearch.isElementPresent()) {
            placeHolderSearch.clickJScript();
            reportLog("Clicked on Search Place Holder.");
            placeHolderSearch.setText(text);
            reportLog("Clicked set value in Search Place Holder.");
        }
    }

    public boolean verifyNoResultText() {
        waitForSec(5);
        return textNoResult.isElementPresent();
    }

    public boolean verifySearchResultLink() {
        waitForSec(5);
        return linkSearchResult.isElementPresent();
    }

    public void clickOnSearchResultLink() {
        if (linkSearchResult.isElementPresent()) {
            linkSearchResult.clickJScript();
            reportLog("Clicked on Link Search Result.");
        }
    }

    public void pressEnterKey() {
        placeHolderSearch.sendKeys(String.valueOf(Keys.ENTER));
        reportLog("Successfully Clicked on Enter Button.");
    }

    public boolean verifyCloseSearchIcon() {
        return iconCloseSearch.isElementPresent();
    }

    public void clickOnCloseSearchIcon() {
        if (iconCloseSearch.isElementPresent()) {
            iconCloseSearch.clickJScript();
            reportLog("Clicked on Close Search Icon.");
        }
    }

    public boolean verifyAlgebraBranchLink() {
        return linkAlgebraBranch.isElementPresent();
    }

    public void clickOnAlgebraBranchLink() {
        if (linkAlgebraBranch.isElementPresent()) {
            linkAlgebraBranch.clickJScript();
            reportLog("Clicked on Algebra Branch Link.");
        }
    }

    public boolean verifyGeometryBranchLink() {
        return linkGeometryBranch.isElementPresent();
    }

    public void clickOnGeometryBranchLink() {
        if (linkGeometryBranch.isElementPresent()) {
            linkGeometryBranch.clickJScript();
            reportLog("Clicked on Geometry Branch Link.");
        }
    }

    public boolean verifyEarthScienceBranchLink() {
        return linkEarthScienceBranch.isElementPresent();
    }

    public void clickOnEarthScienceBranchLink() {
        if (linkEarthScienceBranch.isElementPresent()) {
            linkEarthScienceBranch.clickJScript();
            reportLog("Clicked on Earth Science Branch Link.");
        }
    }

    public boolean verifyBiologyBranchLink() {
        return linkBiologyBranch.isElementPresent();
    }

    public void clickOnBiologyBranchLink() {
        if (linkBiologyBranch.isElementPresent()) {
            linkBiologyBranch.clickJScript();
            reportLog("Clicked on Biology Branch Link.");
        }
    }

    public boolean verifyPhysicsBranchLink() {
        return linkPhysicsBranch.isElementPresent();
    }

    public void clickOnPhysicsBranchLink() {
        if (linkPhysicsBranch.isElementPresent()) {
            linkPhysicsBranch.clickJScript();
            reportLog("Clicked on Physics Branch Link.");
        }
    }

    public void getTextOfAlgebraConceptTitle() {
        algebraTitles = textConceptTitles.getWebElements();
        reportLog("Successfully get algebra concept Titles");
    }

    public void getTextOfGeometryConceptTitle() {
        geometryTitles = textConceptTitles.getWebElements();
        reportLog("Successfully get geometry concept Titles");
    }

    public void getTextOfEarthScienceConceptTitle() {
        earthScienceTitles = textConceptTitles.getWebElements();
        reportLog("Successfully get Earth Science concept Titles");
    }

    public void getTextOfBiologyConceptTitle() {
        biologyTitles = textConceptTitles.getWebElements();
        reportLog("Successfully get Biology concept Titles");
    }

    public void getTextOfPhysicsConceptTitle() {
        physicsTitles= textConceptTitles.getWebElements();
        reportLog("Successfully get Physics concept Titles");
    }

    public boolean verifyGeometryBranchConceptsLink() {
        return ! algebraTitles.equals(geometryTitles);
    }

    public boolean verifyEarthScienceBranchConceptsLink() {
        return ! geometryTitles.equals(earthScienceTitles);
    }

    public boolean verifyBiologyBranchConceptsLink() {
        return ! earthScienceTitles.equals(biologyTitles);
    }

    public boolean verifyPhysicsBranchConceptsLink() {
        return ! biologyTitles.equals(physicsTitles);
    }

    public boolean verifyAlgebraBranchConceptsLink() {
        return ! physicsTitles.equals(algebraTitles);
    }

    public void clickOnFirstBranchConceptLink() {
        if (linkFirstConcept.isElementPresent()) {
            linkFirstConcept.clickJScript();
            reportLog("Clicked on Algebra Branch First Concept Link.");
        }
    }

    public boolean verifyTitleText() {
        waitForSec(5);
        return textTitle.isElementPresent();
    }

    public boolean verifyLandingPageLink() {
        return linkLandingPage.isElementPresent();
    }

    public void clickOnLandingPageLink() {
        if (linkLandingPage.isElementPresent()) {
            linkLandingPage.clickJScript();
            reportLog("Clicked on Landing Page Link.");
        }
    }

    public boolean verifyToolTipLink() {
        return linkToolTip.isElementPresent();
    }

    public void clickOnToolTipLink() {
        if (linkToolTip.isElementPresent()) {
            linkToolTip.clickJScript();
            reportLog("Clicked on Tool Tip Branch Link.");
        }
    }

    public boolean verifyAddToLibraryLink() {
        return linkAddToLibrary.isElementPresent();
    }

    public void clickOnAddToLibraryLink() {
        if (linkAddToLibrary.isElementPresent()) {
            linkAddToLibrary.clickJScript();
            reportLog("Clicked on Add To Library Link.");
        }
    }

    public boolean verifyDownLoadLink() {
        waitForSec(5);
        return linkDownload.isElementPresent();
    }

    public boolean verifyCloseViewerIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseViewerIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Clicked on Ck12 Image Icon.");
        }
    }

    public boolean verifyCloseAlertModalIcon() {
        return iconCloseAlertModal.isElementPresent();
    }

    public void clickOnCloseAlertModalIcon() {
        if (iconCloseAlertModal.isElementPresent()) {
            iconCloseAlertModal.clickJScript();
            reportLog("Clicked on Close Alert Modal Icon.");
        }
    }

    public boolean verifyOkButton() {
        return btnOK.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOK.isElementPresent()) {
            btnOK.clickJScript();
            reportLog("Clicked on Ok Button.");
        }
    }

    public boolean verifyContentText() {
        waitForSec(5);
        return textAlert.isElementPresent();
    }

    public boolean verifyReadLink() {
        return linkRead.isElementPresent();
    }

    public void clickOnReadLink() {
        if (linkRead.isElementPresent()) {
            linkRead.clickJScript();
            reportLog("Clicked on Read Link.");
        }
    }

    public boolean verifyVideoLink() {
        return linkVideo.isElementPresent();
    }

    public void clickOnVideoLink() {
        if (linkVideo.isElementPresent()) {
            linkVideo.clickJScript();
            reportLog("Clicked on Video Link.");
        }
    }

    public boolean verifyVideoText() {
        return textVideo.isElementPresent();
    }

    public boolean verifyReadText() {
        return textRead.isElementPresent();
    }

    public void enterInToFrame(){
        waitForSec(5);
        webDriver.switchTo().frame(0);
        reportLog("Successfully Entered into frame.");
    }

    public void removeFromFrame(){
        webDriver.switchTo().defaultContent();
        reportLog("Successfully Remove From frame.");
    }

    public void navigateBack(){
        webDriver.navigate().back();
        logger.info("Navigating to previous result");
    }
}