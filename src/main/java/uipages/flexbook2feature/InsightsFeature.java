package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class InsightsFeature extends BasePage {
    private static final Logger logger = Logger.getLogger(InsightsFeature.class);

    private final GuiControl btnInsights = new GuiControl(getElementMap().get("btnInsights"), webDriver);
    private final GuiControl BackInsightsIcon = new GuiControl(getElementMap().get("BackInsightsIcon"), webDriver);
    private final GuiControl textInsights = new GuiControl(getElementMap().get("textInsights"), webDriver);
    private final GuiControl dropDownGroupClass = new GuiControl(getElementMap().get("dropDownGroupClass"), webDriver);
    private final GuiControl linkClasses = new GuiControl(getElementMap().get("linkClasses"), webDriver);
    private final GuiControl linkClassWithAssignment = new GuiControl(getElementMap().get("linkClassWithAssignment"), webDriver);
    private final GuiControl linkClassWithoutAssignment = new GuiControl(getElementMap().get("linkClassWithoutAssignment"), webDriver);
    private final GuiControl dropDownSortBy = new GuiControl(getElementMap().get("dropDownSortBy"), webDriver);
    private final GuiControl linkPerformanceLowToHigh = new GuiControl(getElementMap().get("linkPerformanceLowToHigh"), webDriver);
    private final GuiControl linkPerformanceHighToLow = new GuiControl(getElementMap().get("linkPerformanceHighToLow"), webDriver);
    private final GuiControl linkAlphabeticalAtoZ = new GuiControl(getElementMap().get("linkAlphabeticalAtoZ"), webDriver);
    private final GuiControl linkAlphabeticalZtoA = new GuiControl(getElementMap().get("linkAlphabeticalZtoA"), webDriver);
    private final GuiControl linkSortByText = new GuiControl(getElementMap().get("linkSortByText"), webDriver);
    private final GuiControl linkFirstStudent = new GuiControl(getElementMap().get("linkFirstStudent"), webDriver);
    private final GuiControl textNeedToAssign = new GuiControl(getElementMap().get("textNeedToAssign"), webDriver);

    public InsightsFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyInsightsButton() {
        return btnInsights.isElementPresent();
    }

    public void clickOnInsightsButton() {
        if (btnInsights.isElementPresent()) {
            btnInsights.clickJScript();
            reportLog("Clicked on Insights Button.");
        }
    }

    public boolean verifyInsightsText() {
        waitForSec(5);
        return textInsights.isElementPresent();
    }

    public boolean verifyBackInsightsIcon() {
        return BackInsightsIcon.isElementPresent();
    }

    public void clickOnBackInsightsIcon() {
        if (BackInsightsIcon.isElementPresent()) {
            BackInsightsIcon.clickJScript();
            reportLog("Clicked on BAck Insights Icon.");
        }
    }

    public boolean verifyGroupClassDropDown() {
        return dropDownGroupClass.isElementPresent();
    }

    public void clickOnGroupClassDropDown() {
        if (dropDownGroupClass.isElementPresent()) {
            dropDownGroupClass.clickJScript();
            reportLog("Clicked on Group Class DropDown.");
        }
    }

    public boolean verifyGroupClassesLink() {
        waitForSec(5);
        List<WebElement> classesCount = linkClasses.getWebElements();
        return classesCount.size() > 1;
    }

    public boolean verifyClassWithAssignmentLink() {
        return linkClassWithAssignment.isElementPresent();
    }

    public void clickOnClassWithAssignmentLink() {
        if (linkClassWithAssignment.isElementPresent()) {
            linkClassWithAssignment.clickJScript();
            reportLog("Clicked on Class With Assignment Link.");
        }
    }

    public boolean verifyClassWithoutAssignmentLink() {
        return linkClassWithoutAssignment.isElementPresent();
    }

    public void clickOnClassWithoutAssignmentLink() {
        if (linkClassWithoutAssignment.isElementPresent()) {
            linkClassWithoutAssignment.clickJScript();
            reportLog("Clicked on Class Without Assignment Link.");
        }
    }

    public boolean verifySortByDropDown() {
        return dropDownSortBy.isElementPresent();
    }

    public boolean verifySortByDropDownIsNotPresent() {
        return ! dropDownSortBy.isElementPresent();
    }

    public void clickOnSortByDropDown() {
        if (dropDownSortBy.isElementPresent()) {
            dropDownSortBy.clickJScript();
            reportLog("Clicked on Sort By DropDown.");
        }
        waitForSec(5);
    }

    public boolean verifyPerformanceLowToHighLink() {
        return linkPerformanceLowToHigh.isElementPresent();
    }

    public void clickOnPerformanceLowToHighLink() {
        if (linkPerformanceLowToHigh.isElementPresent()) {
            linkPerformanceLowToHigh.clickJScript();
            reportLog("Clicked on Performance Low To High Link.");
        }
    }

    public boolean verifyPerformanceHighToLowLink() {
        return linkPerformanceHighToLow.isElementPresent();
    }

    public void clickOnPerformanceHighToLowLink() {
        if (linkPerformanceHighToLow.isElementPresent()) {
            linkPerformanceHighToLow.clickJScript();
            reportLog("Clicked on Performance High To Low Link.");
        }
    }

    public boolean verifyAlphabeticalAToZLink() {
        return linkAlphabeticalAtoZ.isElementPresent();
    }

    public void clickOnAlphabeticalAToZLink() {
        if (linkAlphabeticalAtoZ.isElementPresent()) {
            linkAlphabeticalAtoZ.clickJScript();
            reportLog("Clicked on Alphabetical A To Z Link.");
        }
    }

    public boolean verifyAlphabeticalZToALink() {
        return linkAlphabeticalZtoA.isElementPresent();
    }

    public void clickOnAlphabeticalZToALink() {
        if (linkAlphabeticalZtoA.isElementPresent()) {
            linkAlphabeticalZtoA.clickJScript();
            reportLog("Clicked on Alphabetical Z To A Link.");
        }
    }

    public boolean verifyNeedToAssignText() {
        return textNeedToAssign.isElementPresent();
    }

    public boolean verifyPerformanceLowToHighSortByIsSelected() {
        return ("Performance Low to High").equalsIgnoreCase(linkSortByText.getText());
    }

    public boolean verifyPerformanceHighToLowSortByIsSelected() {
        return ("Performance High to Low").equalsIgnoreCase(linkSortByText.getText());
    }

    public boolean verifyAlphabeticalAtoZSortByIsSelected() {
        return ("Alphabetical A - Z").equalsIgnoreCase(linkSortByText.getText());
    }

    public boolean verifyAlphabeticalZtoASortByIsSelected() {
        return ("Alphabetical Z - A").equalsIgnoreCase(linkSortByText.getText());
    }

    public boolean verifyFirstStudentAfterSelectingPerformanceLowToHigh() {
        return ("studentinsight2").equalsIgnoreCase(linkFirstStudent.getText());
    }

    public boolean verifyFirstStudentAfterSelectingPerformanceHighToLow() {
        return ("studentinsight1").equalsIgnoreCase(linkFirstStudent.getText());
    }

    public boolean verifyFirstStudentAfterSelectingAlphabeticalAtoZ() {
        return ("AlphaAnso1").equalsIgnoreCase(linkFirstStudent.getText());
    }

    public boolean verifyFirstStudentAfterSelectingAlphabeticalZtoA() {
        return ("studentinsight2").equalsIgnoreCase(linkFirstStudent.getText());
    }

}