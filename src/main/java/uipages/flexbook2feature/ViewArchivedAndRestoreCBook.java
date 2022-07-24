package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;

import java.util.List;

public class ViewArchivedAndRestoreCBook extends BasePage {

    private List<WebElement> listOfTotalBooks;
    private List<WebElement> listOfArchivedBooks;
    private List<WebElement> listOfCBooksPreRestore;
    private List<WebElement> listOfCbooksPostRestore;
    private String listArchivedBookCSS = "div[class='listiteminfo small-7 small-offset-1 large-offset-1 large-8 columns left'] a.bold";

    private String courseBookName;

    private final GuiControl btnArchived = new GuiControl(getElementMap().get("btnArchived"), webDriver);
    private final GuiControl btnRestoreItems = new GuiControl(getElementMap().get("btnRestoreItems"), webDriver);
    private final GuiControl spanNamesOfCourseBook = new GuiControl(getElementMap().get("spanNamesOfCourseBook"), webDriver);
    private final GuiControl textNameOfFirstCourseBook = new GuiControl(getElementMap().get("textNameOfFirstCourseBook"), webDriver);
    private final GuiControl checkBoxCourseBook = new GuiControl(getElementMap().get("checkBoxCourseBook"), webDriver);
    private final GuiControl btnOk = new GuiControl(getElementMap().get("btnOk"), webDriver);

    public ViewArchivedAndRestoreCBook(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void getTextOfCourseBookName() {
        waitForSec(5);
        courseBookName = textNameOfFirstCourseBook.getText();
        reportLog("Successfully retrieved the name of CourseBook. Name is: " + courseBookName);
    }

    public boolean verifyListOfArchivedCBookPostRestore() {
        waitForSec(5);
        List<WebElement> listOfArchivedCBooksPostRestore = webDriver.findElements(By.cssSelector(listArchivedBookCSS));
        reportLog("Successfully retrieved names Of Archived courseBooks after Restore action.");
        int flag = 0;
        for (WebElement names : listOfArchivedCBooksPostRestore) {
            if (names.getText().equalsIgnoreCase(courseBookName)) {
                flag++;
            }
        }

        if (flag == 0) {
            reportLog("CourseBook Item is Successfully Restored");
            return true;
        } else {
            return false;
        }
    }

    public void clickOnCheckBox() {
        waitForSec(8);
        if (checkBoxCourseBook.isElementPresent()) {
            checkBoxCourseBook.clickFirstFromListOfElements();
            reportLog("Clicked on CourseBook CheckBox.");
        }
    }


    public boolean verifyViewArchivedButton() {
        return btnArchived.isElementPresent();
    }

    public void clickOnViewArchivedButton() {
        if (btnArchived.isElementPresent()) {
            btnArchived.clickJScript();
            reportLog("Clicked on View Archived Button.");
        }
    }

    public boolean verifyRestoreItemsButton() {
        return btnRestoreItems.isElementPresent();
    }

    public void clickOnRestoreItemsButton() {
        if (btnRestoreItems.isElementPresent()) {
            btnRestoreItems.mouseHover();
            btnRestoreItems.clickJScript();
            reportLog("Clicked on Restore Items Button.");
        }
    }

    public void getListOfCourseBookInLibrary() {
        waitForSec(5);
        listOfTotalBooks = webDriver.findElements(By.cssSelector(listArchivedBookCSS));
        reportLog("Successfully retrieved names Of courseBooks In Library");
    }

    public void getListOfCourseBookInArchiveLibrary() {
        waitForSec(5);
        listOfArchivedBooks = webDriver.findElements(By.cssSelector(listArchivedBookCSS));
        reportLog("Successfully retrieved names Of Archived courseBooks.");
    }

    public boolean verifyListsOfUnarchivedAndArchivedCBooks() {
        if (!(listOfTotalBooks.equals(listOfArchivedBooks))) {
            reportLog("Lists of Un-archived and Archived CourseBooks are different");
            return true;
        }
        return false;
    }

    public boolean verifyOkButton() {
        return btnOk.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOk.isElementPresent()) {
            btnOk.clickJScript();
            reportLog("Clicked on Ok Button.");
        }
    }

    public void getListOfCourseBookBeforeRestore() {
        listOfCBooksPreRestore = spanNamesOfCourseBook.getWebElement().findElements(By.cssSelector(listArchivedBookCSS));
        reportLog("Successfully retrieved names Of courseBooks In Library");
    }

    public void getListOfCourseBookAfterRestore() {
        waitForSec(5);
        listOfCbooksPostRestore = spanNamesOfCourseBook.getWebElement().findElements(By.cssSelector(listArchivedBookCSS));
        reportLog("Successfully retrieved names Of Archived courseBooks");
    }

    public boolean verifyCBooksListsPostRestore() {
        return !listOfCBooksPreRestore.equals(listOfCbooksPostRestore);
    }
}