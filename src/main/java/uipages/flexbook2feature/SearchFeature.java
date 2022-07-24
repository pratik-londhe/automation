package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GuiControl;
import java.util.List;

public class SearchFeature extends PageMenuTab {
    private static final Logger logger = Logger.getLogger(SearchFeature.class);

    private int itemList;

    private final GuiControl iconSearch = new GuiControl(getElementMap().get("iconSearch"), webDriver);
    private final GuiControl placeHolderSearch = new GuiControl(getElementMap().get("placeHolderSearch"), webDriver);
    private final GuiControl textWhatDoYouWantToLearn = new GuiControl(getElementMap().get("textWhatDoYouWantToLearn"), webDriver);
    private final GuiControl loadingIcon = new GuiControl(getElementMap().get("loadingIcon"), webDriver);
    private final GuiControl listOfItem = new GuiControl(getElementMap().get("listOfItem"), webDriver);
    private final GuiControl textSearchResult = new GuiControl(getElementMap().get("textSearchResult"), webDriver);
    private final GuiControl listSearchItem = new GuiControl(getElementMap().get("listSearchItem"), webDriver);
    private final GuiControl tabCk12Content = new GuiControl(getElementMap().get("tabCk12Content"), webDriver);
    private final GuiControl tabCommunityContributed = new GuiControl(getElementMap().get("tabCommunityContributed"), webDriver);
    private final GuiControl tabMyLibrary = new GuiControl(getElementMap().get("tabMyLibrary"), webDriver);
    private final GuiControl linkPreviousSearch = new GuiControl(getElementMap().get("linkPreviousSearch"), webDriver);
    private final GuiControl textGrades = new GuiControl(getElementMap().get("textGrades"), webDriver);
    private final GuiControl linkAllGrades = new GuiControl(getElementMap().get("linkAllGrades"), webDriver);
    private final GuiControl linkGrade = new GuiControl(getElementMap().get("linkGrade"), webDriver);
    private final GuiControl textGrade10 = new GuiControl(getElementMap().get("textGrade10"), webDriver);
    private final GuiControl btnClearAll = new GuiControl(getElementMap().get("btnClearAll"), webDriver);
    private final GuiControl btnSearchFilter = new GuiControl(getElementMap().get("btnSearchFilter"), webDriver);
    private final GuiControl btnMath = new GuiControl(getElementMap().get("btnMath"), webDriver);
    private final GuiControl btnScience = new GuiControl(getElementMap().get("btnScience"), webDriver);
    private final GuiControl btnMathSubMenu = new GuiControl(getElementMap().get("btnMathSubMenu"), webDriver);
    private final GuiControl btnScienceSubMenu = new GuiControl(getElementMap().get("btnScienceSubMenu"), webDriver);
    private final GuiControl textFilterSelected = new GuiControl(getElementMap().get("textFilterSelected"), webDriver);
    private final GuiControl iconRemoveFilter = new GuiControl(getElementMap().get("iconRemoveFilter"), webDriver);

    public SearchFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifySearchFilterButton() {
        return btnSearchFilter.isElementPresent();
    }

    public void clickOnSearchFilterButton() {
        if (btnSearchFilter.isElementPresent()) {
            btnSearchFilter.clickJScript();
            reportLog("Successfully clicked On Search Filter Button");
        }
    }

    public boolean verifyRemoveFilterIcon() {
        return iconRemoveFilter.isElementPresent();
    }

    public void clickOnRemoveFilterIcon() {
        if (iconRemoveFilter.isElementPresent()) {
            iconRemoveFilter.clickJScript();
            reportLog("Successfully clicked On Remove Filter Icon");
        }
    }

    public boolean verifySelectedSearchFilterIsDisplay() {
        waitForSec(2);
        return textFilterSelected.isElementPresent();
    }

    public boolean verifySelectedSearchFilterIsNotDisplay() {
        return ! textFilterSelected.isElementPresent();
    }

    public boolean verifyMathFilterButton() {
        waitForSec(2);
        return btnMath.isElementPresent();
    }

    public void clickOnMathFilterButton() {
        if (btnMath.isElementPresent()) {
            btnMath.clickJScript();
            reportLog("Successfully clicked On Math Filter Button");
        }
    }

    public boolean verifyScienceFilterButton() {
        return btnScience.isElementPresent();
    }

    public void clickOnScienceFilterButton() {
        if (btnScience.isElementPresent()) {
            btnScience.clickJScript();
            reportLog("Successfully clicked On Science Filter Button");
        }
    }

    public boolean verifyMathSubMenuButton() {
        waitForSec(2);
        return btnMathSubMenu.isElementPresent();
    }

    public void clickOnMathSubMenuButton() {
        if (btnMathSubMenu.isElementPresent()) {
            btnMathSubMenu.clickJScript();
            reportLog("Successfully clicked On Math SubMenu Button");
        }
    }

    public boolean verifScienceSubMenuButton() {
        waitForSec(2);
        return btnScienceSubMenu.isElementPresent();
    }

    public void clickOnScienceSubMenuButton() {
        if (btnScienceSubMenu.isElementPresent()) {
            btnScienceSubMenu.clickJScript();
            reportLog("Successfully clicked On Math SubMenu Button");
        }
    }

    public boolean verifyClearAllButton() {
        return btnClearAll.isElementPresent();
    }

    public void clickOnClearAllButton() {
        if (btnClearAll.isElementPresent()) {
            btnClearAll.clickJScript();
            reportLog("Successfully clicked On Clear All Button");
        }
    }

    public boolean verifyGradesOfFirstItemInList() {
        return textGrade10.isElementPresent();
    }

    public boolean verifyGradesLink() {
        return linkGrade.isElementPresent();
    }

    public void clickOnGradeLink() {
        if (linkGrade.isElementPresent()) {
            linkGrade.clickJScript();
            reportLog("Successfully clicked On Grade Link");
        }
    }

    public boolean verifyAllGradesLinks(){
        List<WebElement> countOfGrades = linkAllGrades.getWebElements();
        int totalCount=countOfGrades.size();
        reportLog("Total number of grades Is = " + totalCount);
        return totalCount <13;
    }

    public boolean verifyGradesText() {
        return textGrades.isElementPresent();
    }

    public boolean verifyMyLibraryTab() {
        tabMyLibrary.mouseHover();
        return tabMyLibrary.isElementPresent();
    }
    
    public boolean verifyPreviousSearchLink() {
        return linkPreviousSearch.isElementPresent();
    }

    public void clickOnPreviousSearchLink() {
        if (linkPreviousSearch.isElementPresent()) {
            linkPreviousSearch.clickJScript();
            reportLog("Successfully clicked On Previous Search Link");
        }
    }

    public boolean verifyCk12ContentTab() {
        return tabCk12Content.isElementPresent();
    }

    public void clickOnCk12ContentTab() {
        if (tabCk12Content.isElementPresent()) {
            tabCk12Content.clickJScript();
            reportLog("Successfully clicked On Ck12 Content Tab");
        }
    }

    public boolean verifyCommunityContributedTab() {
        tabCommunityContributed.mouseHover();
        return tabCommunityContributed.isElementPresent();
    }

    public void clickOnCommunityContributedTab() {
        if (tabCommunityContributed.isElementPresent()) {
            tabCommunityContributed.clickJScript();
            reportLog("Successfully clicked On CommunityContributed Tab");
        }
    }

    public boolean verifySearchIcon() {
        waitForSec(5);
        return iconSearch.isElementPresent();
    }

    public void clickOnSearchIcon() {
        if (iconSearch.isElementPresent()) {
            iconSearch.clickJScript();
            reportLog("Successfully clicked On Search Icon");
        }
    }

    public boolean verifyWhatDoYouWantToLEarnTodayTextInsideSearchPlaceHolder() {
        return textWhatDoYouWantToLearn.isElementPresent();
    }

    public boolean verifySearchPlaceHolder() {
        return placeHolderSearch.isElementPresent();
    }

    public void setValueInSearchPlaceHolder(String text) {
        if (placeHolderSearch.isElementPresent()) {
            placeHolderSearch.click();
            placeHolderSearch.setText(text);
            reportLog("Successfully Entered Value In Search PlaceHolder.");
        }
    }

    public boolean verifyLoadingIcon() {
        return loadingIcon.isElementPresent();
    }

    public void getCountOfAutoGenerateListItems() {
        List<WebElement> countOfList = listOfItem.getWebElements();
        itemList=countOfList.size();
        reportLog("Successfully Get Count Of List Items And Count Are = " + itemList);
    }

    public boolean verifyAutoGenerateCountOfList() {
        return itemList <= 10;
    }

    public boolean verifyLSearchResultText() {
        waitForSec(5);
        return textSearchResult.isElementPresent();
    }
}