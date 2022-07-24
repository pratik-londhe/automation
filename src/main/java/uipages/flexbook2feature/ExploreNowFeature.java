package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class ExploreNowFeature extends BasePage {
    private static final Logger logger = Logger.getLogger(ExploreNowFeature.class);

    private final GuiControl btnExploreNow = new GuiControl(getElementMap().get("btnExploreNow"), webDriver);
    private final GuiControl bannerIndiaCk12 = new GuiControl(getElementMap().get("bannerIndiaCk12"), webDriver);
    private final GuiControl containerMathFlexBook = new GuiControl(getElementMap().get("containerMathFlexBook"), webDriver);
    private final GuiControl textYouAreViewing = new GuiControl(getElementMap().get("textYouAreViewing"), webDriver);
    private final GuiControl containerBiologyFlexBook = new GuiControl(getElementMap().get("containerBiologyFlexBook"), webDriver);
    private final GuiControl containerChemistryFlexBook = new GuiControl(getElementMap().get("containerChemistryFlexBook"), webDriver);
    private final GuiControl contentForCBSE = new GuiControl(getElementMap().get("contentForCBSE"), webDriver);
    private final GuiControl textFlexBookIn = new GuiControl(getElementMap().get("textFlexBookIn"), webDriver);
    private final GuiControl textFor = new GuiControl(getElementMap().get("textFor"), webDriver);
    private final GuiControl locationIndia = new GuiControl(getElementMap().get("locationIndia"), webDriver);
    private final GuiControl dropdownSubject = new GuiControl(getElementMap().get("dropdownSubject"), webDriver);
    private final GuiControl dropdownGrades = new GuiControl(getElementMap().get("dropdownGrades"), webDriver);
    private final GuiControl linkAllSubject = new GuiControl(getElementMap().get("linkAllSubject"), webDriver);
    private final GuiControl linkMaths = new GuiControl(getElementMap().get("linkMaths"), webDriver);
    private final GuiControl linkNinthGrade = new GuiControl(getElementMap().get("linkNinthGrade"), webDriver);
    private final GuiControl linkAllGrade = new GuiControl(getElementMap().get("linkAllGrade"), webDriver);
    private final GuiControl iconCk12Foundation = new GuiControl(getElementMap().get("iconCk12Foundation"), webDriver);

    public ExploreNowFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyExploreNowButton() {
        waitForSec(5);
        webDriver.navigate().refresh();
        waitForSec(5);
        return btnExploreNow.isElementPresent();
    }

    public void clickOnExploreNowButton() {
        if (btnExploreNow.isElementPresent()) {
            btnExploreNow.clickJScript();
            reportLog("Successfully Clicked On Explore Now Button");
        }
    }

    public void clickOnCk12FoundationIcon() {
        waitForSec(5);
        if (iconCk12Foundation.isElementPresent()) {
            iconCk12Foundation.clickJScript();
            reportLog("Successfully Clicked On Ck12  Foundation Icon");
        }
    }

    public boolean verifyIndiaCK12Banner() {
        waitForSec(5);
        return bannerIndiaCk12.isElementPresent();
    }

    public boolean verifyMathFlexBookContainer() {
        return containerMathFlexBook.isElementPresent();
    }

    public boolean verifyBiologyFlexBookContainer() {
        containerMathFlexBook.scrollIntoView();
        waitForSec(2);
        return containerBiologyFlexBook.isElementPresent();
    }

    public boolean verifyChemistryFlexBookContainer() {
        containerBiologyFlexBook.scrollIntoView();
        waitForSec(2);
        return containerChemistryFlexBook.isElementPresent();
    }

    public boolean verifyYouAreViewingText() {
        bannerIndiaCk12.scrollIntoView();
        return textYouAreViewing.isElementPresent();
    }

    public boolean verifyCBSEContainIsSelected() {
        return contentForCBSE.isElementPresent();
    }

    public boolean verifyFlexBookInText() {
        return textFlexBookIn.isElementPresent();
    }

    public boolean verifyForText() {
        return textFor.isElementPresent();
    }

    public boolean verifyIndiaLocationIsSelected() {
        return locationIndia.isElementPresent();
    }

    public boolean verifySubjectDropDown() {
        return dropdownSubject.isElementPresent();
    }

    public void clickOnSubjectDropDown() {
        if (dropdownSubject.isElementPresent()) {
            dropdownSubject.clickJScript();
            reportLog("Successfully Clicked On Dropdown Subject");
        }
    }

    public boolean verifyGradeDropDown() {
        return dropdownGrades.isElementPresent();
    }

    public void clickOnGradeDropDown() {
        if (dropdownGrades.isElementPresent()) {
            dropdownGrades.clickJScript();
            reportLog("Successfully Clicked On Dropdown Grades.");
        }
    }

    public boolean verifyAllSubjectLink() {
        waitForSec(2);
        return linkAllSubject.isElementPresent();
    }

    public boolean verifyMathLink() {
        return linkMaths.isElementPresent();
    }

    public boolean verifyAllGradeLink() {
        waitForSec(2);
        return linkAllGrade.isElementPresent();
    }

    public boolean verifyNienthLink() {
        return linkNinthGrade.isElementPresent();
    }
}
