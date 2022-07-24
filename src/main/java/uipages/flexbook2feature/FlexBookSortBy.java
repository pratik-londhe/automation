package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class FlexBookSortBy extends BasePage {
    private static final Logger logger = Logger.getLogger(FlexBookSortBy.class);

    private String afterAscending;
    private String afterDescending;
    private String newestFirst;
    private String oldestFirst;
    private String recentlyModified;
    private String oldestModified;
    private String successMsg = "Successfully get the FlexBook Name After Ascending order And Name is";

    private final GuiControl dropDownSort = new GuiControl(getElementMap().get("dropDownSort"), webDriver);
    private final GuiControl linkAscending = new GuiControl(getElementMap().get("linkAscending"), webDriver);
    private final GuiControl linkDescending = new GuiControl(getElementMap().get("linkDescending"), webDriver);
    private final GuiControl linkNewestFirst = new GuiControl(getElementMap().get("linkNewestFirst"), webDriver);
    private final GuiControl linkOldestFirst = new GuiControl(getElementMap().get("linkOldestFirst"), webDriver);
    private final GuiControl linkRecentlyModified = new GuiControl(getElementMap().get("linkRecentlyModified"), webDriver);
    private final GuiControl linkOldestModified = new GuiControl(getElementMap().get("linkOldestModified"), webDriver);
    private final GuiControl txtFirstCourseBook = new GuiControl(getElementMap().get("txtFirstCourseBook"), webDriver);

    public FlexBookSortBy(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifySortDropDown() {
        dropDownSort.mouseHover();
        return dropDownSort.isElementPresent();
    }

    public void clickOnSortDropDown() {
        if (dropDownSort.isElementPresent()) {
            dropDownSort.clickJScript();
            reportLog("Successfully click on Sort DropDown");
        }
        waitForSec(5);
    }

    public boolean verifyAscendingLink() {
        linkAscending.mouseHover();
        return linkAscending.isElementPresent();
    }

    public void clickOnAscendingLink() {
        if (linkAscending.isElementPresent()) {
            linkAscending.clickJScript();
            reportLog("Successfully click on link Ascending");
        }
    }

    public boolean verifyDescendingLink() {
        linkDescending.mouseHover();
        return linkDescending.isElementPresent();
    }

    public void clickOnDescendingLink() {
        if (linkDescending.isElementPresent()) {
            linkDescending.clickJScript();
            reportLog("Successfully click on Descending link");
        }
    }

    public boolean verifyNewestFirstLink() {
        linkNewestFirst.mouseHover();
        return linkNewestFirst.isElementPresent();
    }

    public void clickOnNewestFirstLink() {
        if (linkNewestFirst.isElementPresent()) {
            linkNewestFirst.clickJScript();
            reportLog("Successfully click on Newest First link");
        }
    }

    public boolean verifyOldestFirstLink() {
        linkOldestFirst.mouseHover();
        return linkOldestFirst.isElementPresent();
    }

    public void clickOnOldestFirstLink() {
        if (linkOldestFirst.isElementPresent()) {
            linkOldestFirst.clickJScript();
            reportLog("Successfully click on Oldest First link");
        }
    }

    public boolean verifyRecentlyModifiedLink() {
        linkRecentlyModified.mouseHover();
        return linkRecentlyModified.isElementPresent();
    }

    public void clickOnRecentlyModifiedLink() {
        if (linkRecentlyModified.isElementPresent()) {
            linkRecentlyModified.clickJScript();
            reportLog("Successfully click on Recently Modified link");
        }
    }

    public boolean verifyOldestModifiedLink() {
        linkOldestModified.mouseHover();
        return linkOldestModified.isElementPresent();
    }

    public void clickOnOldestModifiedLink() {
        if (linkOldestModified.isElementPresent()) {
            linkOldestModified.clickJScript();
            reportLog("Successfully click on oldest Modified link");
        }
    }

    public void getFlexBookNameAfterAscendingOrder() {
        afterAscending = txtFirstCourseBook.getText();
        reportLog(successMsg + afterAscending);
    }

    public void getFlexBookNameAfterDescendingOrder() {
        afterDescending = txtFirstCourseBook.getText();
        reportLog(successMsg + afterDescending);
    }

    public void getFlexBookNameAfterNewestFirst() {
        newestFirst = txtFirstCourseBook.getText();
        reportLog(successMsg + newestFirst);
    }

    public void getFlexBookNameAfterOldestFirst() {
        oldestFirst = txtFirstCourseBook.getText();
        reportLog(successMsg + oldestFirst);
    }

    public void getFlexBookNameAfterRecentlyModified() {
        recentlyModified = txtFirstCourseBook.getText();
        reportLog(successMsg + recentlyModified);
    }

    public void getFlexBookNameAfterOldestModified() {
        oldestModified = txtFirstCourseBook.getText();
        reportLog(successMsg + oldestModified);
    }

    public boolean verifyTextAfterAscending(String name) {
        return name.equalsIgnoreCase(afterAscending);
    }

    public boolean verifyTextAfterDescending(String name) {
        return name.equalsIgnoreCase(afterDescending);
    }

    public boolean verifyTextAfterNewestFirst(String name) {
        return name.equalsIgnoreCase(newestFirst);
    }

    public boolean verifyTextAfterOldestFirst(String name) {
        return name.equalsIgnoreCase(oldestFirst);
    }

    public boolean verifyTextAfterRecentlyModified(String name) {
        return name.equalsIgnoreCase(recentlyModified);
    }

    public boolean verifyTextAfterOldestModified(String name) {
        return name.equalsIgnoreCase(oldestModified);
    }

    public void waitForSomeTime() {
        waitForSec(5);
    }
}