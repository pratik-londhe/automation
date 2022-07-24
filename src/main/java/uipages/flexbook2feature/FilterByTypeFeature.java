package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GuiControl;

import java.util.List;

public class FilterByTypeFeature extends PageMenuTab {
    private static final Logger logger = Logger.getLogger(FilterByTypeFeature.class);

    private final GuiControl checkBoxFlexBookTextBook = new GuiControl(getElementMap().get("checkBoxFlexBookTextBook"), webDriver);
    private final GuiControl checkBoxFlexBook = new GuiControl(getElementMap().get("checkBoxFlexBook"), webDriver);
    private final GuiControl checkBoxRead = new GuiControl(getElementMap().get("checkBoxRead"), webDriver);
    private final GuiControl checkBoxQuiz = new GuiControl(getElementMap().get("checkBoxQuiz"), webDriver);
    private final GuiControl textFilterByType = new GuiControl(getElementMap().get("textFilterByType"), webDriver);
    private final GuiControl textTitle = new GuiControl(getElementMap().get("textTitle"), webDriver);
    private final GuiControl listOfLibraryItem = new GuiControl(getElementMap().get("listOfLibraryItem"), webDriver);
    private final GuiControl checkBoxWorkBook = new GuiControl(getElementMap().get("checkBoxWorkBook"), webDriver);
    private final GuiControl textNoItemsInLibrary = new GuiControl(getElementMap().get("textNoItemsInLibrary"), webDriver);
    private final GuiControl linkMore = new GuiControl(getElementMap().get("linkMore"), webDriver);
    private final GuiControl checkBoxVideo = new GuiControl(getElementMap().get("checkBoxVideo"), webDriver);
    private final GuiControl checkBoxStudyAids = new GuiControl(getElementMap().get("checkBoxStudyAids"), webDriver);
    private final GuiControl btnClear = new GuiControl(getElementMap().get("btnClear"), webDriver);
    private final GuiControl btnClearAll = new GuiControl(getElementMap().get("btnClearAll"), webDriver);
    private final GuiControl checkBoxCreatedByMe = new GuiControl(getElementMap().get("checkBoxCreatedByMe"), webDriver);
    private final GuiControl checkBoxDraft = new GuiControl(getElementMap().get("checkBoxDraft"), webDriver);
    private final GuiControl checkBoxFinalize = new GuiControl(getElementMap().get("checkBoxFinalize"), webDriver);
    private final GuiControl checkBoxOthers = new GuiControl(getElementMap().get("checkBoxOthers"), webDriver);
    private final GuiControl textCreateName = new GuiControl(getElementMap().get("textCreateName"), webDriver);

    public FilterByTypeFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyAddToLibraryCheckBox() {
        return checkBoxOthers.isElementPresent();
    }

    public void clickOnAddToLibraryCheckBox() {
        if (checkBoxOthers.isElementPresent()) {
            checkBoxOthers.clickJScript();
            reportLog("Successfully clicked On AddToLibrary CheckBox");
        }
    }

    public boolean verifyFinalizeCheckBox() {
        return checkBoxFinalize.isElementPresent();
    }

    public void clickOnFinalizeCheckBox() {
        if (checkBoxFinalize.isElementPresent()) {
            checkBoxFinalize.clickJScript();
            reportLog("Successfully clicked On Finalize CheckBox");
        }
    }

    public boolean verifyDraftCheckBox() {
        return checkBoxDraft.isElementPresent();
    }

    public void clickOnDraftCheckBox() {
        if (checkBoxDraft.isElementPresent()) {
            checkBoxDraft.clickJScript();
            reportLog("Successfully clicked On Draft CheckBox");
        }
    }

    public boolean verifyFilterByTypeText() {
        waitForSec(5);
        return textFilterByType.isElementPresent();
    }

    public boolean verifyWorkBookCheckBox() {
        return checkBoxWorkBook.isElementPresent();
    }

    public void clickOnWorkBookCheckBox() {
        if (checkBoxWorkBook.isElementPresent()) {
            checkBoxWorkBook.clickJScript();
            reportLog("Successfully clicked On Workbook CheckBox");
        }
    }

    public boolean verifyFlexBookCheckBox() {
        return checkBoxFlexBook.isElementPresent();
    }

    public void clickOnFlexBookCheckBox() {
        if (checkBoxFlexBook.isElementPresent()) {
            checkBoxFlexBook.clickJScript();
            reportLog("Successfully clicked On FlexBook CheckBox");
        }
    }

    public boolean verifyFirstItemOfLibraryListIsFlexBook() {
        return "FlexBook 2.0".equalsIgnoreCase(textTitle.getText());
    }

    public boolean getListOfBookAndVerifyFlexBook() {
        for (int i = 0; i <= textTitle.getWebElements().size(); i++) {
            for (WebElement book : textTitle.getWebElements()) {
                if (book.getText().equals("FlexBook® 2.0")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifyOnlyFlexBookTextBookAndFlexBookItemsArePresent() {
        int itemsCount;
        List<WebElement> count = listOfLibraryItem.getWebElements();
        itemsCount = count.size();
        reportLog("Count Of Library Item Is = " + itemsCount);
        return itemsCount >= 2;
    }

    public boolean verifyFlexBookTextBookCheckBox() {
        return checkBoxFlexBookTextBook.isElementPresent();
    }

    public void clickOnFlexBookTextBookCheckBox() {
        if (checkBoxFlexBookTextBook.isElementPresent()) {
            checkBoxFlexBookTextBook.clickJScript();
            reportLog("Successfully clicked On FlexBook TextBook CheckBox");
        }
    }

    public boolean verifyFirstItemOfLibraryListIsFlexBookTextBook() {
        return "FlexBook® Textbooks".equalsIgnoreCase(textTitle.getText());
    }

    public boolean verifyOnlyFlexBookTextBookItemsArePresent() {
        int itemsCount;
        List<WebElement> count = listOfLibraryItem.getWebElements();
        itemsCount = count.size();
        reportLog("Count Of Library Item Is = " + itemsCount);
        return itemsCount >= 1;
    }

    public boolean verifyReadCheckBox() {
        return checkBoxRead.isElementPresent();
    }

    public void clickOnReadCheckBox() {
        if (checkBoxRead.isElementPresent()) {
            checkBoxRead.clickJScript();
            reportLog("Successfully clicked On Read CheckBox");
        }
    }

    public boolean verifyFirstItemOfLibraryListIsReadModality() {
        for (int i = 0; i <= textTitle.getWebElements().size(); i++) {
            for (WebElement book : textTitle.getWebElements()) {
                if (book.getText().equals("Read")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifyPresentLibraryItemsAfterClickingOnReadCheckBox() {
        int itemsCount;
        List<WebElement> count = listOfLibraryItem.getWebElements();
        itemsCount = count.size();
        reportLog("Count Of Library Item Is = " + itemsCount);
        return itemsCount >= 3;
    }

    public boolean verifyQuizzesCheckBox() {
        return checkBoxQuiz.isElementPresent();
    }

    public void clickOnQuizzesCheckBox() {
        if (checkBoxQuiz.isElementPresent()) {
            checkBoxQuiz.clickJScript();
            reportLog("Successfully clicked On Quiz CheckBox");
        }
    }

    public boolean getListOfBookAndVerifyQuiz() {
        checkBoxRead.clickJScript();
        waitForSec(4);
        checkBoxWorkBook.clickJScript();
        waitForSec(4);
        checkBoxFlexBookTextBook.clickJScript();
        waitForSec(4);
        checkBoxFlexBook.clickJScript();
        waitForSec(4);
        for (int i = 0; i <= textTitle.getWebElements().size(); i++) {
            for (WebElement book : textTitle.getWebElements()) {
                if (book.getText().equals("Quiz")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifyPresentLibraryItemsAfterClickingOnQuizCheckBox() {
        int itemsCount;
        List<WebElement> count = listOfLibraryItem.getWebElements();
        itemsCount = count.size();
        reportLog("Count Of Library Item Is = " + itemsCount);
        return itemsCount >= 1;
    }

    public boolean verifyNoItemsInLibraryText() {
        return textNoItemsInLibrary.isElementPresent();
    }

    public boolean verifyLibraryIsNotEmpty() {
        return !textNoItemsInLibrary.isElementPresent();
    }

    public boolean verifyMoreLink() {
        return linkMore.isElementPresent();
    }

    public void clickOnMoreLink() {
        if (linkMore.isElementPresent()) {
            linkMore.clickJScript();
            reportLog("Successfully clicked On More Link");
        }
    }

    public void scrollScreen() {
        textFilterByType.scrollIntoView();
        reportLog("Successfully Scroll Screen Through Filter By Type Text.");
    }

    public boolean verifyVideoCheckBox() {
        return checkBoxVideo.isElementPresent();
    }

    public void clickOnVideoCheckBox() {
        if (checkBoxVideo.isElementPresent()) {
            checkBoxVideo.clickJScript();
            reportLog("Successfully clicked On Video CheckBox");
        }
    }

    public boolean verifyFirstItemOfLibraryListIsVideo() {
        return ("Video").equalsIgnoreCase(textTitle.getText());
    }

    public boolean getListOfBookAndVerifyVideo() {
        for (int i = 0; i <= textTitle.getWebElements().size(); i++) {
            for (WebElement book : textTitle.getWebElements()) {
                if (book.getText().equals("Video")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean getListOfBookAndVerifyStudyGuide() {
        for (int i = 0; i <= textTitle.getWebElements().size(); i++) {
            for (WebElement book : textTitle.getWebElements()) {
                if (book.getText().equals("Study Guide")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifyStudyAidsCheckBox() {
        return checkBoxStudyAids.isElementPresent();
    }

    public void clickOnStudyAidsCheckBox() {
        if (checkBoxStudyAids.isElementPresent()) {
            checkBoxStudyAids.clickJScript();
            reportLog("Successfully clicked On Quiz CheckBox");
        }
    }

    public boolean verifyFirstItemOfLibraryListIsStudyAids() {
        return "Study Guide".equalsIgnoreCase(textTitle.getText());
    }

    public boolean verifyClearButton() {
        return btnClear.isElementPresent();
    }

    public void clickOnClearButton() {
        if (btnClear.isElementPresent()) {
            btnClear.clickJScript();
            reportLog("Successfully clicked On Clear Button");
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

    public boolean verifyCreateByMeCheckBox() {
        return checkBoxCreatedByMe.isElementPresent();
    }

    public void clickOnCreateByMeCheckBox() {
        if (checkBoxCreatedByMe.isElementPresent()) {
            checkBoxCreatedByMe.clickJScript();
            reportLog("Successfully clicked On Created By Me CheckBox");
        }
    }

    public boolean verifyFirstItemOfLibraryListIsCreatedByMe() {
        return textCreateName.isElementPresent();
    }
}