package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class AvailableAssignmentFeature extends BasePage {

    private int count;
    private int beforeCount;
    private int afterCount;
    private String assignmentFirst = "Test123";
    private String getCountXpath = "//i[@class='icon-arrow_right leader-assignment-arrow-icon']";

    private final GuiControl tabAvailableAssignment = new GuiControl(getElementMap().get("tabAvailableAssignment"), webDriver);
    private final GuiControl dropdownAssignmentType = new GuiControl(getElementMap().get("dropdownAssignmentType"), webDriver);
    private final GuiControl dropdownSortBy = new GuiControl(getElementMap().get("dropdownSortBy"), webDriver);
    private final GuiControl linkUnAssign = new GuiControl(getElementMap().get("linkUnAssign"), webDriver);
    private final GuiControl linkAssign = new GuiControl(getElementMap().get("linkAssign"), webDriver);
    private final GuiControl linkLatestCreationDate = new GuiControl(getElementMap().get("linkLatestCreationDate"), webDriver);
    private final GuiControl linkEarliestCreationDate = new GuiControl(getElementMap().get("linkEarliestCreationDate"), webDriver);
    private final GuiControl linkAlphabetical = new GuiControl(getElementMap().get("linkAlphabetical"), webDriver);
    private final GuiControl linkLatestDueDate = new GuiControl(getElementMap().get("linkLatestDueDate"), webDriver);
    private final GuiControl linkEarliestDueDate = new GuiControl(getElementMap().get("linkEarliestDueDate"), webDriver);
    private final GuiControl linkLatestStartDate = new GuiControl(getElementMap().get("linkLatestStartDate"), webDriver);
    private final GuiControl linkEarliestStartDate = new GuiControl(getElementMap().get("linkEarliestStartDate"), webDriver);
    private final GuiControl linkAssignLatestCreationDate = new GuiControl(getElementMap().get("linkAssignLatestCreationDate"), webDriver);
    private final GuiControl linkAssignEarliestCreationDate = new GuiControl(getElementMap().get("linkAssignEarliestCreationDate"), webDriver);
    private final GuiControl linkAssignAlphabetical = new GuiControl(getElementMap().get("linkAssignAlphabetical"), webDriver);
    private final GuiControl textFirstAssignment = new GuiControl(getElementMap().get("textFirstAssignment"), webDriver);
    private final GuiControl dropdownAssignSortBy = new GuiControl(getElementMap().get("dropdownAssignSortBy"), webDriver);

    public AvailableAssignmentFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnAssignSortByDropDown() {
        if (dropdownAssignSortBy.isElementPresent()) {
            dropdownAssignSortBy.clickJScript();
            reportLog("Clicked on Assigned Sort By DropDown.");
        }
        waitForSec(5);
    }


    public boolean verifyTextOfFirstAssignmentForLatestDueDateLink() {
        return assignmentFirst.equalsIgnoreCase(textFirstAssignment.getText());
    }

    public boolean verifyTextOfFirstAssignmentForEarliestDueDateLink() {
        return assignmentFirst.equalsIgnoreCase(textFirstAssignment.getText());
    }

    public boolean verifyTextOfFirstAssignmentForLatestStartDateLink() {
        return assignmentFirst.equalsIgnoreCase(textFirstAssignment.getText());
    }

    public boolean verifyTextOfFirstAssignmentForEarliestStartDateLink() {
        return assignmentFirst.equalsIgnoreCase(textFirstAssignment.getText());
    }

    public boolean verifyTextOfFirstAssignmentForAssignLatestCreationDateLink() {
        return assignmentFirst.equalsIgnoreCase(textFirstAssignment.getText());
    }

    public boolean verifyTextOfFirstAssignmentForAssignEarliestCreationDateLink() {
        return assignmentFirst.equalsIgnoreCase(textFirstAssignment.getText());
    }

    public boolean verifyTextOfFirstAssignmentForAssignAlphabeticalLink() {
        return assignmentFirst.equalsIgnoreCase(textFirstAssignment.getText());
    }

    public boolean verifyLatestDueDateLink() {
        linkLatestDueDate.mouseHover();
        return linkLatestDueDate.isElementPresent();
    }

    public void clickOnLatestDueDateLink() {
        if (linkLatestDueDate.isElementPresent()) {
            linkLatestDueDate.mouseHover();
            linkLatestDueDate.clickJScript();
            reportLog("Clicked on Latest Due Date Link.");
        }
    }

    public boolean verifyEarliestDueDateLink() {
        linkEarliestDueDate.mouseHover();
        return linkEarliestDueDate.isElementPresent();
    }

    public void clickOnEarliestDueDateLink() {
        if (linkEarliestDueDate.isElementPresent()) {
            linkEarliestDueDate.mouseHover();
            linkEarliestDueDate.clickJScript();
            reportLog("Clicked on Earliest Due Date Link.");
        }
    }

    public boolean verifyLatestStartDateLink() {
        linkLatestStartDate.mouseHover();
        return linkLatestStartDate.isElementPresent();
    }

    public void clickOnLatestStartDateLink() {
        if (linkLatestStartDate.isElementPresent()) {
            linkLatestStartDate.mouseHover();
            linkLatestStartDate.clickJScript();
            reportLog("Clicked on Latest Start Date Link.");
        }
    }

    public boolean verifyEarliestStartDateLink() {
        linkEarliestStartDate.mouseHover();
        return linkEarliestStartDate.isElementPresent();
    }

    public void clickOnEarliestStartDateLink() {
        if (linkEarliestStartDate.isElementPresent()) {
            linkEarliestStartDate.mouseHover();
            linkEarliestStartDate.clickJScript();
            reportLog("Clicked on Earliest Start Date Link.");
        }
    }

    public boolean verifyAssignLatestCreationDateLink() {
        linkAssignLatestCreationDate.mouseHover();
        return linkAssignLatestCreationDate.isElementPresent();
    }

    public void clickOnAssignLatestCreationDateLink() {
        if (linkAssignLatestCreationDate.isElementPresent()) {
            linkAssignLatestCreationDate.mouseHover();
            linkAssignLatestCreationDate.clickJScript();
            reportLog("Clicked on Assign Latest Creation Date Link.");
        }
    }

    public boolean verifyAssignEarliestCreationDateLink() {
        linkAssignEarliestCreationDate.mouseHover();
        return linkAssignEarliestCreationDate.isElementPresent();
    }

    public void clickOnAssignEarliestCreationDateLink() {
        if (linkAssignEarliestCreationDate.isElementPresent()) {
            linkAssignEarliestCreationDate.mouseHover();
            linkAssignEarliestCreationDate.clickJScript();
            reportLog("Clicked on Assign Earliest Creation Date Link.");
        }
    }

    public boolean verifyAssignAlphabeticalLink() {
        linkAssignAlphabetical.mouseHover();
        return linkAssignAlphabetical.isElementPresent();
    }

    public void clickOnAssignAlphabeticalLink() {
        if (linkAssignAlphabetical.isElementPresent()) {
            linkAssignAlphabetical.mouseHover();
            linkAssignAlphabetical.clickJScript();
            reportLog("Clicked on Assign Alphabetical Link.");
        }
    }

    public boolean verifyTextOfFirstAssignmentForLatestCreationDate() {
        waitForSec(4);
        if ("Test".equalsIgnoreCase(textFirstAssignment.getText())) {
            return true;
        }
        return false;
    }

    public boolean verifyTextOfFirstAssignmentForEarliestCreationDate() {
        waitForSec(4);
        if ("Basid".equalsIgnoreCase(textFirstAssignment.getText())) {
            return true;
        }
        return false;
    }

    public boolean verifyTextOfFirstAssignmentForAlphabetical() {
        waitForSec(4);
        if ("Basid".equalsIgnoreCase(textFirstAssignment.getText())) {
            return true;
        }
        return false;
    }

    public boolean verifyAlphabeticalLink() {
        linkAlphabetical.mouseHover();
        return linkAlphabetical.isElementPresent();
    }

    public void clickOnAlphabeticalLink() {
        if (linkAlphabetical.isElementPresent()) {
            linkAlphabetical.mouseHover();
            linkAlphabetical.clickJScript();
            reportLog("Clicked on Alphabetical Link.");
        }
    }

    public boolean verifyEarliestCreationDateLink() {
        linkEarliestCreationDate.mouseHover();
        return linkEarliestCreationDate.isElementPresent();
    }

    public void clickOnEarliestCreationDateLink() {
        if (linkEarliestCreationDate.isElementPresent()) {
            linkEarliestCreationDate.mouseHover();
            linkEarliestCreationDate.clickJScript();
            reportLog("Clicked on Earliest Creation Date Link.");
        }
    }

    public boolean verifyLatestCreationDateLink() {
        linkLatestCreationDate.mouseHover();
        return linkLatestCreationDate.isElementPresent();
    }

    public void clickOnLatestCreationDateLink() {
        if (linkLatestCreationDate.isElementPresent()) {
            linkLatestCreationDate.mouseHover();
            linkLatestCreationDate.clickJScript();
            reportLog("Clicked on the Latest Creation Date Link.");
        }
    }

    public boolean verifyCountOfAssignment() {
        if (count >= 1) {
            return true;
        }
        return false;
    }

    public void getCountOfAssignmentBeforeCancel() {
        List<WebElement> count1 = webDriver.findElements(By.xpath(getCountXpath));
        beforeCount = count1.size();
        reportLog("Successfully Get Count For Assignment And Count is = " + beforeCount);
    }

    public void getCountOfAssignmentAfterCancel() {
        waitForSec(5);
        List<WebElement> count1 = webDriver.findElements(By.xpath(getCountXpath));
        afterCount = count1.size();
        reportLog("Successfully Get Count For Assignment And Count is = " + afterCount);
    }

    public boolean verifyCountOfAssignmentAfterCancel() {
        if (beforeCount == afterCount) {
            reportLog("Successfully Verify Count Of Assignment.");
            return true;
        }
        return false;
    }


    public void getCountOfAssignmentForUnAssign() {
        List<WebElement> count1 = webDriver.findElements(By.xpath(getCountXpath));
        count = count1.size();
        reportLog("User got count for unassigned assignment and the count is = " + count);
    }

    public void getCountOfAssignmentForAssign() {
        List<WebElement> count2 = webDriver.findElements(By.xpath(getCountXpath));
        count = count2.size();
        reportLog("Successfully Get Count For Assign Assignment And Count is = " + count);
    }

    public boolean verifyAssignLink() {
        return linkAssign.isElementPresent();
    }

    public void clickOnAssignLink() {
        if (linkAssign.isElementPresent()) {
            linkAssign.clickJScript();
            reportLog("Clicked on Assign Link.");
        }
    }

    public boolean verifyUnAssignLink() {
        return linkUnAssign.isElementPresent();
    }

    public void clickOnUnAssignLink() {
        if (linkUnAssign.isElementPresent()) {
            linkUnAssign.clickJScript();
            reportLog("Clicked on UnAssign Link.");
        }
    }

    public void clickOnSortByDropDown() {
        if (dropdownSortBy.isElementPresent()) {
            dropdownSortBy.clickJScript();
            reportLog("Clicked on Sort By DropDown.");
        }
        waitForSec(5);
    }

    public boolean verifyStatusDropDown() {
        return dropdownAssignmentType.isElementPresent();
    }

    public void clickOnStatusDropDown() {
        if (dropdownAssignmentType.isElementPresent()) {
            dropdownAssignmentType.clickJScript();
            reportLog("Clicked on Status DropDown.");
        }
        waitForSec(5);
    }

    public boolean verifyAvailableAssignmentTab() {
        waitForSec(5);
        return tabAvailableAssignment.isElementPresent();
    }

    public void clickOnAvailableAssignmentTab() {
        if (tabAvailableAssignment.isElementPresent()) {
            tabAvailableAssignment.clickJScript();
            reportLog("Clicked on Available Assignment Tab.");
        }
    }
}