package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class SimulationFeature extends BasePage {

    private final GuiControl containerSimulation = new GuiControl(getElementMap().get("containerSimulation"), webDriver);
    private final GuiControl iconCk12 = new GuiControl(getElementMap().get("iconCk12"), webDriver);
    private final GuiControl textExplorationSeries = new GuiControl(getElementMap().get("textExplorationSeries"), webDriver);
    private final GuiControl tabPhysicsBranch = new GuiControl(getElementMap().get("tabPhysicsBranch"), webDriver);
    private final GuiControl tabChemistryBranch = new GuiControl(getElementMap().get("tabChemistryBranch"), webDriver);
    private final GuiControl tabInstructionVideo = new GuiControl(getElementMap().get("tabInstructionVideo"), webDriver);
    private final GuiControl dropdownLanguage = new GuiControl(getElementMap().get("dropdownLanguage"), webDriver);
    private final GuiControl linkEnglish = new GuiControl(getElementMap().get("linkEnglish"), webDriver);
    private final GuiControl linkGerman = new GuiControl(getElementMap().get("linkGerman"), webDriver);
    private final GuiControl flagBeta = new GuiControl(getElementMap().get("flagBeta"), webDriver);
    private final GuiControl placeHolderSearch = new GuiControl(getElementMap().get("placeHolderSearch"), webDriver);
    private final GuiControl iconFilter = new GuiControl(getElementMap().get("iconFilter"), webDriver);
    private final GuiControl textNoMatchFound = new GuiControl(getElementMap().get("textNoMatchFound"), webDriver);
    private final GuiControl linkResultConcept = new GuiControl(getElementMap().get("linkResultConcept"), webDriver);
    private final GuiControl textInstructionTitle = new GuiControl(getElementMap().get("textInstructionTitle"), webDriver);
    private final GuiControl iconInstructionClose = new GuiControl(getElementMap().get("iconInstructionClose"), webDriver);
    private final GuiControl textFilter = new GuiControl(getElementMap().get("textFilter"), webDriver);
    private final GuiControl iconBackArrow = new GuiControl(getElementMap().get("iconBackArrow"), webDriver);
    private final GuiControl textFilterByConcept = new GuiControl(getElementMap().get("textFilterByConcept"), webDriver);
    private final GuiControl textFilterByStandards = new GuiControl(getElementMap().get("textFilterByStandards"), webDriver);

    public SimulationFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifySimulationContainer() {
        waitForSec(5);
        return containerSimulation.isElementPresent();
    }

    public void clickOnSimulationContainer() {
        if (containerSimulation.isElementPresent()) {
            containerSimulation.clickJScript();
            reportLog("Clicked on Simulation Container.");
        }
    }

    public boolean verifyCk12ImageIcon() {
        return iconCk12.isElementPresent();
    }

    public void clickOnCk12ImageIcon() {
        /*if (iconCk12.isElementPresent()) {
            iconCk12.clickJScript();
            reportLog("Clicked on Ck12 Image Icon.");
        }*/
        webDriver.navigate().back();
    }

    public boolean verifyFiltersIcon() {
        return iconFilter.isElementPresent();
    }

    public void clickOnFiltersIcon() {
        if (iconFilter.isElementPresent()) {
            iconFilter.clickJScript();
            reportLog("Clicked on Filters Icon.");
        }
    }

    public boolean verifyExplorationSeriesText() {
        waitForSec(5);
        return textExplorationSeries.isElementPresent();
    }

    public boolean verifyFilterText() {
        waitForSec(5);
        return textFilter.isElementPresent();
    }

    public boolean verifyPhysicsBranchTab() {
        return tabPhysicsBranch.isElementPresent();
    }

    public void clickOnPhysicsBranchTab() {
        if (tabPhysicsBranch.isElementPresent()) {
            tabPhysicsBranch.clickJScript();
            reportLog("Clicked on Physics Branch Tab.");
        }
    }

    public boolean verifyFilterByConceptWrapper() {
        return textFilterByConcept.isElementPresent();
    }

    public void clickOnFilterByConceptWrapper() {
        if (textFilterByConcept.isElementPresent()) {
            textFilterByConcept.clickJScript();
            reportLog("Clicked on Filter By Concept Wrapper.");
        }
    }

    public boolean verifyFilterByStandardWrapper() {
        return textFilterByStandards.isElementPresent();
    }

    public boolean verifyChemistryBranchTab() {
        waitForSec(5);
        return tabChemistryBranch.isElementPresent();
    }

    public boolean verifyChemistryBranchTabIsNotPresent() {
        return ! tabChemistryBranch.isElementPresent();
    }

    public void clickOnChemistryBranchTab() {
        if (tabChemistryBranch.isElementPresent()) {
            tabChemistryBranch.clickJScript();
            reportLog("Clicked on Chemistry Branch Tab.");
        }
    }

    public boolean verifyInstructionVideoTab() {
        return tabInstructionVideo.isElementPresent();
    }

    public void clickOnInstructionVideoTab() {
        if (tabInstructionVideo.isElementPresent()) {
            tabInstructionVideo.clickJScript();
            reportLog("Clicked on Instruction Video Tab.");
        }
    }

    public boolean verifyLanguageDropDown() {
        return dropdownLanguage.isElementPresent();
    }

    public void clickOnLanguageDropDown() {
        if (dropdownLanguage.isElementPresent()) {
            dropdownLanguage.clickJScript();
            reportLog("Clicked on Language DropDown.");
        }
    }

    public boolean verifyEnglishLanguageLink() {
        waitForSec(5);
        return linkEnglish.isElementPresent();
    }

    public boolean verifyBetaFlag() {
        waitForSec(5);
        return flagBeta.isElementPresent();
    }

    public void clickOnEnglishLanguageLink() {
        if (linkEnglish.isElementPresent()) {
            linkEnglish.clickJScript();
            reportLog("Clicked on English Language Link.");
        }
    }

    public boolean verifyGermanLanguageLink() {
        return linkGerman.isElementPresent();
    }

    public void clickOnGermanLanguageLink() {
        if (linkGerman.isElementPresent()) {
            linkGerman.clickJScript();
            reportLog("Clicked on German Language Link.");
        }
    }

    public boolean verifySearchPlaceHolder() {
        return placeHolderSearch.isElementPresent();
    }

    public void setTextInSearchPlaceHolder(String text) {
        if (placeHolderSearch.isElementPresent()) {
            placeHolderSearch.clickJScript();
            placeHolderSearch.setText(text);
            reportLog("Clicked on Search PlaceHolder");
        }
    }

    public boolean verifyNoMatchFoundText() {
        waitForSec(5);
        return textNoMatchFound.isElementPresent();
    }

    public boolean verifyConceptResultLink() {
        waitForSec(5);
        return linkResultConcept.isElementPresent();
    }

    public boolean verifyInstructionTitleText() {
        waitForSec(5);
        return textInstructionTitle.isElementPresent();
    }

    public boolean verifyCloseInstructionIcon() {
        return iconInstructionClose.isElementPresent();
    }

    public void clickOnCloseInstructionIcon() {
        if (iconInstructionClose.isElementPresent()) {
            iconInstructionClose.clickJScript();
            reportLog("Clicked on Close Instruction Icon.");
        }
    }

    public boolean verifyBackArrowIcon() {
        return iconBackArrow.isElementPresent();
    }

    public void clickOnBackArrowIcon() {
        if (iconBackArrow.isElementPresent()) {
            iconBackArrow.clickJScript();
            reportLog("Clicked on Back Arrow Icon.");
        }
    }

    public void enterInToFrame(){
        webDriver.switchTo().frame(0);
        reportLog("Successfully Enter Into Parent Frame");
    }

    public void removeFromTheFrame(){
        webDriver.switchTo().defaultContent();
        reportLog("Successfully remove from Frame");
    }
}