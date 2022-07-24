package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

/**
 * Created by pratik.londhe on 8/8/2018.
 */
public class LibraryPage extends BasePage {
    private static final Logger logger = Logger.getLogger(LibraryPage.class);

    private final GuiControl drpDwnCreateNew = new GuiControl(getElementMap().get("drpDwnCreateNew"), webDriver);
    private final GuiControl linkFlexBook = new GuiControl(getElementMap().get("linkFlexBook"), webDriver);
    private final GuiControl linkQuiz = new GuiControl(getElementMap().get("linkQuiz"), webDriver);
    private final GuiControl iconEditAndDeleteFlexBook = new GuiControl(getElementMap().get("iconEditAndDeleteFlexBook"), webDriver);
    private final GuiControl linkArchive = new GuiControl(getElementMap().get("linkArchive"), webDriver);
    private final GuiControl btnOKArchived = new GuiControl(getElementMap().get("btnOKArchived"), webDriver);
    private final GuiControl msgArchivedSuccess = new GuiControl(getElementMap().get("msgArchivedSuccess"), webDriver);
    private final GuiControl linkEdit = new GuiControl(getElementMap().get("linkEdit"), webDriver);
    private final GuiControl textNoItemsInLibrary = new GuiControl(getElementMap().get("textNoItemsInLibrary"), webDriver);
    private final GuiControl btnViewArchive = new GuiControl(getElementMap().get("btnViewArchive"), webDriver);
    private final GuiControl btnRestore = new GuiControl(getElementMap().get("btnRestore"), webDriver);
    private final GuiControl btnViewLibrary = new GuiControl(getElementMap().get("btnViewLibrary"), webDriver);
    private final GuiControl textPleaseSelectItems = new GuiControl(getElementMap().get("textPleaseSelectItems"), webDriver);
    private final GuiControl btnOk = new GuiControl(getElementMap().get("btnOk"), webDriver);
    private final GuiControl btnAddToCk12 = new GuiControl(getElementMap().get("btnAddToCk12"), webDriver);
    private final GuiControl textDragThisLink = new GuiControl(getElementMap().get("textDragThisLink"), webDriver);
    private final GuiControl iconCloseBookMarket = new GuiControl(getElementMap().get("iconCloseBookMarket"), webDriver);
    private final GuiControl ellipsisIcon = new GuiControl(getElementMap().get("ellipsisIcon"), webDriver);
    private final GuiControl ellipsisIconSecond = new GuiControl(getElementMap().get("ellipsisIconSecond"), webDriver);

    public LibraryPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnCreateNewDrpDwnBtn() {
        waitForSec(5);
        if (drpDwnCreateNew.isElementPresent()) {
            drpDwnCreateNew.clickJScript();
            reportLog("Clicked on the Create New dropdown.");
        }
    }

    public void clickOnLinkFlexBook() {
        if (linkFlexBook.isElementPresent()) {
            linkFlexBook.clickJScript();
            reportLog("Clicked on FlexBook 2.0 option.");
        }
    }

    public void clickOnLinkQuiz() {
        if (linkQuiz.isElementPresent()) {
            linkQuiz.clickJScript();
            reportLog("Clicked on Create New > Quiz option.");
        }
    }

    public boolean isFlexBookOptionVisible() {
        return linkFlexBook.isElementPresent();
    }

    public void clickOnElipsisIconForEdit() {
        waitForSec(5);
        if (iconEditAndDeleteFlexBook.isElementPresent()) {
            iconEditAndDeleteFlexBook.clickJScript();
            reportLog("Clicked on elipsis icon.");
        }
        waitForSec(5);
    }

    public boolean verifyEditButton() {
        waitForSec(1);
        //linkEdit.mouseHover();
        return linkEdit.isElementPresent();
    }

    public boolean verifyArchiveButton() {
        waitForSec(1);
        //linkArchive.mouseHover();
        return linkArchive.isElementPresent();
    }

    public void clickOnArchive() {
        if (linkArchive.isElementPresent()) {
            linkArchive.clickJScript();
            reportLog("Clicked on edit option. ");
        }
    }

    public void clickOnOK() {
        waitForSec(5);
        btnOKArchived.click();
    }

    public boolean verifyOkArchiveButton() {
        return btnOKArchived.isElementPresent();
    }

    public boolean isArchivedSuccessMessageDisplaying() {
        String msg = "Item archived successfully";
        return msgArchivedSuccess.getText().equals(msg);
    }

    public void clickOnEdit() {
        if (linkEdit.isElementPresent()) {
            linkEdit.clickJScript();
            reportLog("Clicked on edit option. ");
        }
        waitForSec(5);
    }

    public boolean verifyNoItemsInLibraryText() {
        return textNoItemsInLibrary.isElementPresent();
    }

    public boolean verifyViewArchiveButton() {
        waitForSec(5);
        return btnViewArchive.isElementPresent();
    }

    public void clickOnViewArchive() {
        if (btnViewArchive.isElementPresent()) {
            btnViewArchive.clickJScript();
            reportLog("Clicked on View Archive Button. ");
        }
    }

    public boolean verifyRestoreButton() {
        return btnRestore.isElementPresent();
    }

    public void clickOnRestoreButton() {
        if (btnRestore.isElementPresent()) {
            btnRestore.clickJScript();
            reportLog("Clicked on Restore Button Button. ");
        }
    }

    public boolean verifyViewLibraryButton() {
        waitForSec(5);
        return btnViewLibrary.isElementPresent();
    }

    public boolean verifyPleaseSelectItemText() {
        waitForSec(5);
        return textPleaseSelectItems.isElementPresent();
    }

    public boolean verifyOkButton() {
        return btnOk.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOk.isElementPresent()) {
            btnOk.clickJScript();
            reportLog("Clicked on Ok Button. ");
        }
    }

    public boolean verifyAddToCk12Button() {
        btnAddToCk12.mouseHover();
        return btnAddToCk12.isElementPresent();
    }

    public void clickOnAddToCk12Button() {
        if (btnAddToCk12.isElementPresent()) {
            btnAddToCk12.clickJScript();
            reportLog("Clicked on Add To Ck-12 Button. ");
        }
    }

    public boolean verifyDragThisLinkText() {
        waitForSec(5);
        return textDragThisLink.isElementPresent();
    }

    public boolean verifyCloseBookMarketIcon() {
        return iconCloseBookMarket.isElementPresent();
    }

    public void clickOnCloseBookMarketIcon() {
        if (iconCloseBookMarket.isElementPresent()) {
            iconCloseBookMarket.clickJScript();
            reportLog("Clicked on 'Close Book Market' Icon. ");
        }
    }

    public void clickOnEllipsisIcon() {
        try {
            waitForSec(6);
            ellipsisIconSecond.click();
        } catch (Exception e) {
            ellipsisIcon.click();
        }
    }
}