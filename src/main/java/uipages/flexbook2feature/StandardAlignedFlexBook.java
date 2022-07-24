package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class StandardAlignedFlexBook extends BasePage {

    private final GuiControl linkRecommendBySubjects = new GuiControl(getElementMap().get("linkRecommendBySubjects"), webDriver);
    private final GuiControl linkStandardAlignedFlexBook = new GuiControl(getElementMap().get("linkStandardAlignedFlexBook"), webDriver);
    private final GuiControl containerRead = new GuiControl(getElementMap().get("containerRead"), webDriver);
    private final GuiControl textTrending = new GuiControl(getElementMap().get("textTrending"), webDriver);
    private final GuiControl containerPractice = new GuiControl(getElementMap().get("containerPractice"), webDriver);
    private final GuiControl textFilter = new GuiControl(getElementMap().get("textFilter"), webDriver);
    private final GuiControl textStandardAlignedFlexBook = new GuiControl(getElementMap().get("textStandardAlignedFlexBook"), webDriver);
    private final GuiControl filterContainer = new GuiControl(getElementMap().get("filterContainer"), webDriver);
    private final GuiControl linkCBSC = new GuiControl(getElementMap().get("linkCBSC"), webDriver);
    private final GuiControl linkCalifornia = new GuiControl(getElementMap().get("linkCalifornia"), webDriver);
    private final GuiControl linkViewMoreStandards = new GuiControl(getElementMap().get("linkViewMoreStandards"), webDriver);
    private final GuiControl textInternational = new GuiControl(getElementMap().get("textInternational"), webDriver);
    private final GuiControl textUnitedState = new GuiControl(getElementMap().get("textUnitedState"), webDriver);
    private final GuiControl linkCollapse = new GuiControl(getElementMap().get("linkCollapse"), webDriver);
    private final GuiControl containerSubject = new GuiControl(getElementMap().get("containerSubject"), webDriver);
    private final GuiControl linkAlgebraSubject = new GuiControl(getElementMap().get("linkAlgebraSubject"), webDriver);
    private final GuiControl linkBiologySubject = new GuiControl(getElementMap().get("linkBiologySubject"), webDriver);
    private final GuiControl containerGrade = new GuiControl(getElementMap().get("containerGrade"), webDriver);
    private final GuiControl link9thGrade = new GuiControl(getElementMap().get("link9thGrade"), webDriver);
    private final GuiControl linkFlexBook = new GuiControl(getElementMap().get("linkFlexBook"), webDriver);
    private final GuiControl linkCA = new GuiControl(getElementMap().get("linkCA"), webDriver);
    private final GuiControl iconArrowRight = new GuiControl(getElementMap().get("iconArrowRight"), webDriver);
    private final GuiControl iconArrowLeft = new GuiControl(getElementMap().get("iconArrowLeft"), webDriver);

    public StandardAlignedFlexBook(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnRecommendBySubjectLink() {
        if (linkRecommendBySubjects.isElementPresent()) {
            linkRecommendBySubjects.clickJScript();
            reportLog("Successfully click On Recommend By Subject Link");
        }
    }

    public boolean verifyRecommendBySubjectLink() {
        waitForSec(5);
        return linkRecommendBySubjects.isElementPresent();
    }

    public void clickOnStandardAlignedFlexBookLink() {
        if (linkStandardAlignedFlexBook.isElementPresent()) {
            linkStandardAlignedFlexBook.clickJScript();
            reportLog("Successfully click On Standard Aligned FlexBook Link");
        }
    }

    public boolean verifyStandardAlignedFlexBookLink() {
        waitForSec(5);
        return linkStandardAlignedFlexBook.isElementPresent();
    }

    public boolean verifyTrendingText() {
        waitForSec(5);
        return textTrending.isElementPresent();
    }

    public boolean verifyReadContainer() {
        return containerRead.isElementPresent();
    }

    public boolean verifyPracticeContainer() {
        containerRead.scrollIntoView();
        waitForSec(5);
        return containerPractice.isElementPresent();
    }

    public boolean verifyStandardAlignedFlexBookText() {
        waitForSec(5);
        return textStandardAlignedFlexBook.isElementPresent();
    }

    public boolean verifyFilterText() {
        return textFilter.isElementPresent();
    }

    public boolean verifyFilterContainer() {
        return filterContainer.isElementPresent();
    }

    public void clickOnFilterContainer() {
        if (filterContainer.isElementPresent()) {
            filterContainer.clickJScript();
            reportLog("Successfully click Filter Container");
        }
    }

    public boolean verifyInternationalStateCBSCLink() {
        waitForSec(5);
        return linkCBSC.isElementPresent();
    }

    public void clickOnInternationalStateCBSCLink() {
        if (linkCBSC.isElementPresent()) {
            linkCBSC.clickJScript();
            reportLog("Successfully click On International State CBSC Link");
        }
    }

    public boolean verifyUnitedStateCaliforniaLink() {
        return linkCalifornia.isElementPresent();
    }

    public void clickOnUnitedStateCaliforniaLink() {
        if (linkCalifornia.isElementPresent()) {
            linkCalifornia.clickJScript();
            reportLog("Successfully click On United State California Link");
        }
    }

    public boolean verifyViewMoreStandardsLink() {
        return linkViewMoreStandards.isElementPresent();
    }

    public void clickOnViewMoreStandardsLink() {
        if (linkViewMoreStandards.isElementPresent()) {
            linkViewMoreStandards.clickJScript();
            reportLog("Successfully click On View More Standards Link");
        }
    }

    public boolean verifyInternationalText() {
        waitForSec(5);
        return textInternational.isElementPresent();
    }

    public boolean verifyInternationalTextIsNotPresent() {
        return !textInternational.isElementPresent();
    }

    public boolean verifyUnitedStateText() {
        return textUnitedState.isElementPresent();
    }

    public boolean verifyUnitedStateTextIsNotPresent() {
        return !textUnitedState.isElementPresent();
    }

    public boolean verifyCollapseLink() {
        return linkCollapse.isElementPresent();
    }

    public void clickOnCollapseLink() {
        if (linkCollapse.isElementPresent()) {
            linkCollapse.clickJScript();
            reportLog("Successfully click On Collapse Link");
        }
    }

    public boolean verifySubjectContainer() {
        return containerSubject.isElementPresent();
    }

    public void clickOnSubjectContainer() {
        if (containerSubject.isElementPresent()) {
            containerSubject.clickJScript();
            reportLog("Successfully click on Subject Container");
        }
    }

    public boolean verifyAlgebraSubjectLink() {
        waitForSec(5);
        return linkAlgebraSubject.isElementPresent();
    }

    public void clickOnAlgebraSubjectLink() {
        if (linkAlgebraSubject.isElementPresent()) {
            linkAlgebraSubject.clickJScript();
            reportLog("Successfully click on link AlgebraS ubject");
        }
    }

    public boolean verifyBiologySubjectLink() {
        return linkBiologySubject.isElementPresent();
    }

    public boolean verifyGradeContainer() {
        return containerGrade.isElementPresent();
    }

    public void clickOnGradeContainer() {
        if (containerGrade.isElementPresent()) {
            containerGrade.clickJScript();
            reportLog("Successfully click on Grade Container");
        }
    }

    public boolean verify9thGradeLink() {
        waitForSec(5);
        return link9thGrade.isElementPresent();
    }

    public void clickOn9thGradeLink() {
        if (link9thGrade.isElementPresent()) {
            link9thGrade.clickJScript();
            reportLog("Successfully click on 9th Grade Link");
        }
    }

    public boolean verifyFlexBookLink() {
        return linkFlexBook.isElementPresent();
    }

    public boolean verifyCALink() {
        return linkCA.isElementPresent();
    }

    public boolean verifyRightArrowIcon() {
        return iconArrowRight.isElementPresent();
    }

    public void clickOnRightArrowIcon() {
        if (iconArrowRight.isElementPresent()) {
            iconArrowRight.clickJScript();
            reportLog("Successfully click on Right Arrow Icon.");
        }
    }

    public boolean verifyLeftArrowIcon() {
        return iconArrowLeft.isElementPresent();
    }

    public void clickOnLeftArrowIcon() {
        if (iconArrowLeft.isElementPresent()) {
            iconArrowLeft.clickJScript();
            reportLog("Successfully click on Left Arrow Icon.");
        }
    }
}