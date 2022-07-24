package uipages.reports2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import uipages.flexbook2feature.LoginPage;
import utils.GuiControl;

public class AssignAndCloseFeatureOnAssignment extends BasePage {
    private static final Logger logger = Logger.getLogger(AssignAndCloseFeatureOnAssignment.class);

    private final GuiControl btnCreateAnAssignment = new GuiControl(getElementMap().get("btnCreateAnAssignment"), webDriver);
    public final GuiControl btnClose = new GuiControl(getElementMap().get("btnClose"), webDriver);
    private final GuiControl iconBack = new GuiControl(getElementMap().get("iconBack"), webDriver);
    public final GuiControl btnAssign = new GuiControl(getElementMap().get("btnAssign"), webDriver);
    private final GuiControl iconSearch = new GuiControl(getElementMap().get("iconSearch"), webDriver);
    private final GuiControl iconCloseSearch = new GuiControl(getElementMap().get("iconCloseSearch"), webDriver);
    private final GuiControl txtEnterKeywords = new GuiControl(getElementMap().get("txtEnterKeywords"), webDriver);
    private final GuiControl placeHolderSearch = new GuiControl(getElementMap().get("placeHolderSearch"), webDriver);
    private final GuiControl btnSelectAll = new GuiControl(getElementMap().get("btnSelectAll"), webDriver);
    private final GuiControl btnSearch = new GuiControl(getElementMap().get("btnSearch"), webDriver);
    private final GuiControl textMostRecentlyEdited = new GuiControl(getElementMap().get("textMostRecentlyEdited"), webDriver);
    private final GuiControl iconSortBy = new GuiControl(getElementMap().get("iconSortBy"), webDriver);
    private final GuiControl linkMostRecentlyEdited = new GuiControl(getElementMap().get("linkMostRecentlyEdited"), webDriver);
    private final GuiControl linkAZ = new GuiControl(getElementMap().get("linkAZ"), webDriver);
    private final GuiControl linkZA = new GuiControl(getElementMap().get("linkZA"), webDriver);

    public AssignAndCloseFeatureOnAssignment(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyMostRecentlyLink() {
        return linkMostRecentlyEdited.isElementPresent();
    }

    public void clickOnMostRecentlyLink() {
        if (linkMostRecentlyEdited.isElementPresent()) {
            linkMostRecentlyEdited.clickJScript();
            reportLog("Successfully clicked On Most Recently Edited Link");
        }
    }

    public boolean verifyAscendingLink() {
        return linkAZ.isElementPresent();
    }

    public void clickOnAscendingLink() {
        if (linkAZ.isElementPresent()) {
            linkAZ.clickJScript();
            reportLog("Successfully clicked On Ascending Link");
        }
    }

    public boolean verifyDescendingLink() {
        return linkZA.isElementPresent();
    }

    public void clickOnDescendingLink() {
        if (linkZA.isElementPresent()) {
            linkZA.clickJScript();
            reportLog("Successfully clicked On Descending Link");
        }
    }

    public boolean verifyMostRecentlyText() {
        return textMostRecentlyEdited.isElementPresent();
    }

    public void clickOnSortByIcon() {
        waitForSec(5);
        if (iconSortBy.isElementPresent()) {
            iconSortBy.click();
            reportLog("Successfully clicked On Sort By Icon");
        }
        waitForSec(5);
    }

    public boolean verifyQuizIsInAscendingOrder() {
        String ascendingOrderList = webDriver.findElement(By.xpath("(//span[@class='concept-name']//span)[1]")).getText();
        if ("AlexdenderQuiz".equalsIgnoreCase(ascendingOrderList)) {
            reportLog("Successfully Verify  Ascending Order Quiz List");
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyQuizIsInMostRecentlyEditedOrder() {
        String recentlyEdited = webDriver.findElement(By.xpath(" //span[@class='concept-name']//span")).getText();
        if ("RandomQuiz".equalsIgnoreCase(recentlyEdited)) {
            reportLog("Successfully Verify Most Recently Edited Quiz List");
            return true;
        } else {
            return false;
        }
    }

    public void waitThread() {
        waitForSec(5);
    }

    public boolean verifyQuizIsInDescendingOrder() {
        String descendingOrderList = webDriver.findElement(By.xpath("(//span[@class='concept-name']//span)[1]")).getText();
        if ("ZentoQuiz".equalsIgnoreCase(descendingOrderList)) {
            reportLog("Successfully Verify Descending Order Quiz List");
            return true;
        } else {
            return false;
        }
    }

    public boolean verifySearchButton() {
        return btnSearch.isElementPresent();
    }

    public void clickOnSearchButton() {
        if (btnSearch.isElementPresent()) {
            btnSearch.click();
            reportLog("Successfully clicked On Search Button");
        }
    }

    public void clickOnSearchPlaceHolder() {
        if (placeHolderSearch.isElementPresent()) {
            placeHolderSearch.clickJScript();
            reportLog("Successfully clicked On Search placeHolder");
        }
    }

    public void setValueInSearchPlaceHolder(String text) {
        if (placeHolderSearch.isElementPresent()) {
            placeHolderSearch.clickJScript();
            reportLog("Successfully clicked On Search placeHolder");
            placeHolderSearch.setText(text);
            reportLog("Successfully Entered Value in Search placeHolder And Text is " + text);
        }
    }

    public boolean verifySelectAllButton() {
        waitForSec(5);
        return btnSelectAll.isElementPresent();
    }

    public boolean verifyEnterKeyWordText() {
        return txtEnterKeywords.isElementPresent();
    }

    public boolean verifyCloseSearchIcon() {
        return iconCloseSearch.isElementPresent();
    }

    public void clickOnCloseSearchIcon() {
        if (iconCloseSearch.isElementPresent()) {
            iconCloseSearch.clickJScript();
            reportLog("Successfully clicked On Close Search Icon");
        }
    }

    public boolean verifySearchIcon() {
        return iconSearch.isElementPresent();
    }

    public void clickOnSearchIcon() {
        if (iconSearch.isElementPresent()) {
            iconSearch.click();
            reportLog("Successfully clicked On Search Icon");
        }
        waitForSec(5);
    }

    public boolean verifyBackIcon() {
        return iconBack.isElementPresent();
    }

    public void clickOnBackIcon() {
        if (iconBack.isElementPresent()) {
            iconBack.clickJScript();
            reportLog("Successfully clicked On Back Icon");
        }
    }

    public boolean verifyAssignButton() {
        return btnAssign.isElementPresent();
    }

    public void clickOnAssignButton() {
        if (btnAssign.isElementPresent()) {
            btnAssign.clickJScript();
            reportLog("Successfully clicked On Assign Button");
        }
    }

    public boolean verifyCloseButton() {
        return btnClose.isElementPresent();
    }

    public boolean verifyCloseButtonForClassAssignment() {
        waitForSec(5);
        btnClose.scrollIntoView();
        return btnClose.isElementPresent();
    }

    public void clickOnCloseButton() {
        if (btnClose.isElementPresent()) {
            btnClose.clickJScript();
            reportLog("Successfully clicked On Close Button");
        }
    }

    public boolean verifyCreateAssignmentButton() {
        waitForSec(5);
        btnCreateAnAssignment.mouseHover();
        return btnCreateAnAssignment.isElementPresent();
    }

    public void scrollDownScreen() {
        btnCreateAnAssignment.scrollIntoView();
    }

    public void clickOnCreateAssignmentButton() {
        if (btnCreateAnAssignment.isElementPresent()) {
            btnCreateAnAssignment.clickJScript();
            reportLog("Successfully clicked Create An Assignment Button");
        }
    }
}