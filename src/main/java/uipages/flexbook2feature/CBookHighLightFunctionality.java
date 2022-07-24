package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class CBookHighLightFunctionality extends BasePage {

    private final GuiControl btnHighlight = new GuiControl(getElementMap().get("btnHighlight"), webDriver);
    private final GuiControl txtConceptText = new GuiControl(getElementMap().get("txtConceptText"), webDriver);
    private final GuiControl txtYellowShade = new GuiControl(getElementMap().get("txtYellowShade"), webDriver);
    private final GuiControl btnAddNote = new GuiControl(getElementMap().get("btnAddNote"), webDriver);
    private final GuiControl txtAddNotes = new GuiControl(getElementMap().get("txtAddNotes"), webDriver);
    private final GuiControl btnAnnotatorCancel = new GuiControl(getElementMap().get("btnAnnotatorCancel"), webDriver);
    private final GuiControl btnAnnotatorSave = new GuiControl(getElementMap().get("btnAnnotatorSave"), webDriver);
    private final GuiControl iconAnnotatorNotes = new GuiControl(getElementMap().get("iconAnnotatorNotes"), webDriver);
    private final GuiControl iconColour = new GuiControl(getElementMap().get("iconColour"), webDriver);
    private final GuiControl txtSkyBlueShade = new GuiControl(getElementMap().get("txtSkyBlueShade"), webDriver);
    private final GuiControl btnEditItem = new GuiControl(getElementMap().get("btnEditItem"), webDriver);
    private final GuiControl iconRemoveHighlight = new GuiControl(getElementMap().get("iconRemoveHighlight"), webDriver);
    private final GuiControl iconHighlight = new GuiControl(getElementMap().get("iconHighlight"), webDriver);
    private final GuiControl txtNotesHighlight = new GuiControl(getElementMap().get("txtNotesHighlight"), webDriver);
    private final GuiControl txtNotes = new GuiControl(getElementMap().get("txtNotes"), webDriver);
    private final GuiControl iconDelete = new GuiControl(getElementMap().get("iconDelete"), webDriver);
    private final GuiControl txtHighlightAfterDelete = new GuiControl(getElementMap().get("txtHighlightAfterDelete"), webDriver);

    public CBookHighLightFunctionality(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyHighlightButton() {
        btnHighlight.mouseHover();
        return btnHighlight.isElementPresent();
    }

    public void clickOnHighLightButton() {
        btnHighlight.mouseHover();
        if (btnHighlight.isElementPresent()) {
            btnHighlight.clickJScript();
            reportLog("Successfully click On HighLight Button");
        }
    }

    public boolean verifyTextAfterHighlight() {
        txtYellowShade.scrollIntoView();
        return txtYellowShade.isElementPresent();
    }

    public boolean verifyAddNoteButton() {
        waitForSec(2);
        btnAddNote.mouseHover();
        return btnAddNote.isElementPresent();
    }

    public void clickOnAddNotesButton() {
        btnAddNote.mouseHover();
        if (btnAddNote.isElementPresent()) {
            btnAddNote.clickJScript();
            reportLog("Successfully click Add Note Button");
        }
    }

    public boolean verifyCancelAnnotatorButton() {
        waitForSec(5);
        return btnAnnotatorCancel.isElementPresent();
    }

    public boolean verifySaveAnnotatorButton() {
        return btnAnnotatorSave.isElementPresent();
    }

    public void clickOnSaveAnnotatorButton() {
        if (btnAnnotatorSave.isElementPresent()) {
            btnAnnotatorSave.doubleClick();
            reportLog("Successfully click on Save Annotator Button");
        }
    }

    public boolean verifyAddNoteAnnotationIcon() {
        waitForSec(5);
        return iconAnnotatorNotes.isElementPresent();
    }

    public void clickOnAddNoteAnnotatorIcon() {
        waitForSec(5);
        if (iconAnnotatorNotes.isElementPresent()) {
            iconAnnotatorNotes.clickJScript();
            reportLog("Successfully click on Add Note Annotator icon");
        }
    }

    public void clickOnCancelAnnotatorButton() {
        if (btnAnnotatorCancel.isElementPresent()) {
            btnAnnotatorCancel.clickJScript();
            reportLog("Successfully click on Annotator Cancel Button");
        }
    }

    public void clickOnPageText() {
        waitForSec(5);
        if (txtYellowShade.isElementPresent()) {
            txtYellowShade.clickJScript();
            reportLog("Successfully click Text of Concept");
        }
    }

    public boolean verifyIconOfColours() {
        waitForSec(5);
        return iconColour.isElementPresent();
    }

    public boolean verifyTextAfterChangingHighlightColour() {
        return txtSkyBlueShade.isElementPresent();
    }

    public void clickOnPageTextAgain() {
        if (txtSkyBlueShade.isElementPresent()) {
            txtSkyBlueShade.click();
            reportLog("Successfully click Text of Concept Again");
        }
    }

    public boolean verifyEditTitle() {
        waitForSec(5);
        return btnEditItem.isElementPresent();
    }

    public boolean verifyRemoveHighlightIcon() {
        return iconRemoveHighlight.isElementPresent();
    }

    public void clickOnEditTitle() {
        if (btnEditItem.isElementPresent()) {
            btnEditItem.mouseHover();
            btnEditItem.click();
            reportLog("Successfully click Edit Title Button");
        }
    }

    public void clickOnRemoveHighlightIcon() {
        if (iconRemoveHighlight.isElementPresent()) {
            iconRemoveHighlight.mouseHover();
            iconRemoveHighlight.click();
            reportLog("Successfully click Icon Remove Highlight");
        }
    }

    public boolean verifyHighlightIcon() {
        return iconHighlight.isElementPresent();
    }

    public void clickOnHighlightIcon() {
        if (iconHighlight.isElementPresent()) {
            iconHighlight.click();
            reportLog("Successfully click Icon Highlight");
        }
    }

    public boolean verifyTextHighlightNotes() {
        return txtNotesHighlight.isElementPresent();
    }

    public boolean verifyNoteData() {
        return txtNotes.isElementPresent();
    }

    public void clickOnDeleteIcon() {
        waitForSec(5);
        List<WebElement> data = webDriver.findElements(By.xpath("//table[@class='rmq-70514cf4']//tbody//tr//i"));
        int deleteCount = data.size();
        reportLog("Total Number Of Delete Icon is =  " + deleteCount);
        for (int i = 0; i < deleteCount; i++) {
            iconDelete.clickJScript();
        }
        reportLog("Successfully clicked on Delete Icon");
    }

    public boolean verifyTextAfterDelete() {
        return txtHighlightAfterDelete.isElementPresent();
    }
}