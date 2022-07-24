package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.GuiControl;

public class CreateStandardAlignedFlexBook extends PageMenuTab {
    private static final Logger logger = Logger.getLogger(CreateStandardAlignedFlexBook.class);

    private final GuiControl linkStandardAlignedFlexBook = new GuiControl(getElementMap().get("linkStandardAlignedFlexBook"), webDriver);
    private final GuiControl textCreateStandardAlignedFlexBook = new GuiControl(getElementMap().get("textCreateStandardAlignedFlexBook"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl dropdownSelectSubject = new GuiControl(getElementMap().get("dropdownSelectSubject"), webDriver);
    private final GuiControl linkSubjectAnalysis = new GuiControl(getElementMap().get("linkSubjectAnalysis"), webDriver);
    private final GuiControl textSelectedSubject = new GuiControl(getElementMap().get("textSelectedSubject"), webDriver);
    private final GuiControl dropdownSelectState = new GuiControl(getElementMap().get("dropdownSelectState"), webDriver);
    private final GuiControl linkCCSS = new GuiControl(getElementMap().get("linkCCSS"), webDriver);
    private final GuiControl textSelectedState = new GuiControl(getElementMap().get("textSelectedState"), webDriver);
    private final GuiControl dropdownSelectGrade = new GuiControl(getElementMap().get("dropdownSelectGrade"), webDriver);
    private final GuiControl link9thGrade = new GuiControl(getElementMap().get("link9thGrade"), webDriver);
    private final GuiControl textSelectedGrade = new GuiControl(getElementMap().get("textSelectedGrade"), webDriver);
    private final GuiControl containerTextArea = new GuiControl(getElementMap().get("containerTextArea"), webDriver);
    private final GuiControl textFlexBookTextBookTitle = new GuiControl(getElementMap().get("textFlexBookTextBookTitle"), webDriver);
    private final GuiControl btnSaveBook = new GuiControl(getElementMap().get("btnSaveBook"), webDriver);
    private final GuiControl btnCancelSave = new GuiControl(getElementMap().get("btnCancelSave"), webDriver);
    private final GuiControl link7thGrade = new GuiControl(getElementMap().get("link7thGrade"), webDriver);
    private final GuiControl linkTexas = new GuiControl(getElementMap().get("linkTexas"), webDriver);
    private final GuiControl textContentNotAvailable = new GuiControl(getElementMap().get("textContentNotAvailable"), webDriver);
    private final GuiControl btnOk = new GuiControl(getElementMap().get("btnOk"), webDriver);
    private final GuiControl textTitleOfFlexBook = new GuiControl(getElementMap().get("textTitleOfFlexBook"), webDriver);
    private final GuiControl linkSubjectAlgebra = new GuiControl(getElementMap().get("linkSubjectAlgebra"), webDriver);

    public CreateStandardAlignedFlexBook(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyStandardAlignedFlexBookLink() {
        waitForSec(5);
        return linkStandardAlignedFlexBook.isElementPresent();
    }

    public void clickOnStandardAlignedFlexBookLink() {
        if (linkStandardAlignedFlexBook.isElementPresent()) {
            linkStandardAlignedFlexBook.click();
            reportLog("Successfully clicked On Standard Aligned FlexBook Link");
        }
    }

    public boolean verifyCreateStandardAlignedFlexBookText() {
        waitForSec(5);
        return textCreateStandardAlignedFlexBook.isElementPresent();
    }

    public boolean verifyContentNotAvailableText() {
        waitForSec(5);
        return textContentNotAvailable.isElementPresent();
    }

    public boolean verifyCloseModalIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseModalIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("Successfully clicked On Close Modal Icon");
        }
    }

    public boolean verifySelectSubjectDropDown() {
        return dropdownSelectSubject.isElementPresent();
    }

    public void clickOnSelectSubjectDropDown() {
        if (dropdownSelectSubject.isElementPresent()) {
            dropdownSelectSubject.clickJScript();
            reportLog("Successfully clicked On Select Subject DropDown");
        }
    }

    public boolean verifyAnalysisSubjectLink() {
        return linkSubjectAnalysis.isElementPresent();
    }

    public void clickOnAnalysisSubjectLink() {
        if (linkSubjectAnalysis.isElementPresent()) {
            linkSubjectAnalysis.clickJScript();
            reportLog("Successfully clicked On Analysis Subject Link");
        }
    }

    public boolean verifyAlgebraSubjectLink() {
        return linkSubjectAlgebra.isElementPresent();
    }

    public void clickOnAlgebraSubjectLink() {
        if (linkSubjectAlgebra.isElementPresent()) {
            linkSubjectAlgebra.clickJScript();
            reportLog("Successfully clicked On Algebra Subject Link");
        }
    }

    public boolean verifySelectedSubjectText() {
        return textSelectedSubject.isElementPresent();
    }

    public boolean verifyStateDropDown() {
        return dropdownSelectState.isElementPresent();
    }

    public void clickOnStateDropDown() {
        if (dropdownSelectState.isElementPresent()) {
            dropdownSelectState.clickJScript();
            reportLog("Successfully clicked On Select State DropDown");
        }
    }

    public boolean verifyCCSSStateLink() {
        waitForSec(2);
        return linkCCSS.isElementPresent();
    }

    public void clickOnCCSSStateLink() {
        if (linkCCSS.isElementPresent()) {
            linkCCSS.clickJScript();
            reportLog("Successfully clicked On CCSS State Link");
        }
    }

    public boolean verifyTexasStateLink() {
        return linkTexas.isElementPresent();
    }

    public void clickOnTexasStateLink() {
        if (linkTexas.isElementPresent()) {
            linkTexas.clickJScript();
            reportLog("Successfully clicked On Texas State Link");
        }
    }

    public boolean verifySelectedStateText() {
        return textSelectedState.isElementPresent();
    }

    public boolean verifyGradeDropDown() {
        return dropdownSelectGrade.isElementPresent();
    }

    public void clickOnGradeDropDown() {
        if (dropdownSelectGrade.isElementPresent()) {
            dropdownSelectGrade.clickJScript();
            reportLog("Successfully clicked On Select Grade DropDown");
        }
    }

    public boolean verify9thGradeLink() {
        return link9thGrade.isElementPresent();
    }

    public void clickOn9thGradeLink() {
        if (link9thGrade.isElementPresent()) {
            link9thGrade.clickJScript();
            reportLog("Successfully clicked On 9th Grade Link");
        }
    }

    public boolean verify7thGradeLink() {
        return link7thGrade.isElementPresent();
    }

    public void clickOn7thGradeLink() {
        if (link7thGrade.isElementPresent()) {
            link7thGrade.clickJScript();
            reportLog("Successfully clicked On 7th Grade Link");
        }
    }

    public boolean verifySelectedGradeText() {
        return textSelectedGrade.isElementPresent();
    }

    public boolean verifyFlexBookTitleText() {
        return textFlexBookTextBookTitle.isElementPresent();
    }

    public boolean verifyContainerTextArea() {
        return containerTextArea.isElementPresent();
    }

    public boolean verifyCancelButton() {
        return btnCancelSave.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancelSave.isElementPresent()) {
            btnCancelSave.clickJScript();
            reportLog("Successfully clicked On Cancel Button");
        }
    }

    public boolean verifySaveButton() {
        return btnSaveBook.isElementPresent();
    }

    public void clickOnSaveButton() {
        if (btnSaveBook.isElementPresent()) {
            btnSaveBook.clickJScript();
            reportLog("Successfully clicked On Save Button");
        }
    }

    public boolean verifyOkButton() {
        return btnOk.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOk.isElementPresent()) {
            btnOk.clickJScript();
            reportLog("Successfully clicked On Ok Button");
        }
    }

    public boolean verifyTitleOfFlexBook() {
        waitForSec(15);
        return textTitleOfFlexBook.isElementPresent();
    }
}