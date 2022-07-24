package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class SchoolFeature extends BasePage {

    private String alaskaState;

    private final GuiControl containerHeader = new GuiControl(getElementMap().get("containerHeader"), webDriver);
    private final GuiControl linkSchool = new GuiControl(getElementMap().get("linkSchool"), webDriver);
    private final GuiControl textSchool = new GuiControl(getElementMap().get("textSchool"), webDriver);
    private final GuiControl imageHeart = new GuiControl(getElementMap().get("imageHeart"), webDriver);
    private final GuiControl linkSchoolView = new GuiControl(getElementMap().get("linkSchoolView"), webDriver);
    private final GuiControl linkSchoolTitle = new GuiControl(getElementMap().get("linkSchoolTitle"), webDriver);
    private final GuiControl textCaliforniaState = new GuiControl(getElementMap().get("textCaliforniaState"), webDriver);
    private final GuiControl dropdownState = new GuiControl(getElementMap().get("dropdownState"), webDriver);
    private final GuiControl linkStateAlabama = new GuiControl(getElementMap().get("linkStateAlabama"), webDriver);
    private final GuiControl linkStateAlaska = new GuiControl(getElementMap().get("linkStateAlaska"), webDriver);
    private final GuiControl stateText = new GuiControl(getElementMap().get("stateText"), webDriver);
    private final GuiControl iconSchoolEmbedCode = new GuiControl(getElementMap().get("iconSchoolEmbedCode"), webDriver);
    private final GuiControl linkStateName = new GuiControl(getElementMap().get("linkStateName"), webDriver);
    private final GuiControl textCopyAndPaste = new GuiControl(getElementMap().get("textCopyAndPaste"), webDriver);
    private final GuiControl textCopyEmbedCode = new GuiControl(getElementMap().get("textCopyEmbedCode"), webDriver);
    private final GuiControl btnCopy = new GuiControl(getElementMap().get("btnCopy"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl flexBookCover = new GuiControl(getElementMap().get("flexBookCover"), webDriver);
    private final GuiControl textDescription = new GuiControl(getElementMap().get("textDescription"), webDriver);
    private final GuiControl textCreatedBy = new GuiControl(getElementMap().get("textCreatedBy"), webDriver);

    public SchoolFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyHeaderContainer() {
        waitForSec(5);
        return containerHeader.isElementPresent();
    }

    public void clickOnHeaderContainer() {
        if (containerHeader.isElementPresent()) {
            containerHeader.clickJScript();
            reportLog("Successfully clicked on Header Container");
        }
    }

    public boolean verifySchoolLink() {
        waitForSec(5);
        return linkSchool.isElementPresent();
    }

    public void clickOnSchoolLink() {
        if (linkSchool.isElementPresent()) {
            linkSchool.clickJScript();
            reportLog("Successfully clicked on School Link");
        }
    }

    public boolean verifySchoolText() {
        waitForSec(5);
        return textSchool.isElementPresent();
    }

    public boolean verifyHeartImage() {
        return imageHeart.isElementPresent();
    }

    public boolean verifyViewSchoolLink() {
        return linkSchoolView.isElementPresent();
    }

    public void clickOnViewSchoolLink() {
        if (linkSchoolView.isElementPresent()) {
            linkSchoolView.clickJScript();
            reportLog("Successfully clicked on School View Link");
        }
    }

    public boolean verifySchoolTitleLink() {
        return linkSchoolTitle.isElementPresent();
    }

    public boolean verifyStateDropDown() {
        waitForSec(5);
        return dropdownState.isElementPresent();
    }

    public void clickOnStateDropDown() {
        if (dropdownState.isElementPresent()) {
            dropdownState.clickJScript();
            reportLog("Successfully clicked on State DropDown");
        }
    }

    public boolean verifyCaliforniaStateIsSelected() {
        return textCaliforniaState.isElementPresent();
    }

    public boolean verifyAlaskaStateLink() {
        waitForSec(5);
        return linkStateAlaska.isElementPresent();
    }

    public void clickOnStateAlaskaLink() {
        if (linkStateAlaska.isElementPresent()) {
            linkStateAlaska.clickJScript();
            reportLog("Successfully clicked on State Alaska");
        }
    }

    public void getTextOfStateAlaska() {
        if (linkStateAlaska.isElementPresent()) {
            alaskaState = linkStateAlaska.getText();
            reportLog("Successfully Get Text Of State Alaska");
        }
    }

    public boolean verifyAlabamaStateLink() {
        return linkStateAlabama.isElementPresent();
    }

    public boolean verifyStateLinkIsUpdatedInStateDropDown() {
        return alaskaState.equalsIgnoreCase(stateText.getText());
    }

    public boolean verifyEmbedSchoolIcon() {
        waitForSec(5);
        return iconSchoolEmbedCode.isElementPresent();
    }

    public void clickOnEmbedSchoolIcon() {
        if (iconSchoolEmbedCode.isElementPresent()) {
            iconSchoolEmbedCode.clickJScript();
            reportLog("Successfully clicked on Embed School Icon");
        }
    }

    public boolean verifyStateNameLink() {
        return linkStateName.isElementPresent();
    }

    public void clickOnStateNameLink() {
        if (linkStateName.isElementPresent()) {
            linkStateName.clickJScript();
            reportLog("Successfully clicked on State Name Link");
        }
    }

    public boolean verifyCopyEmbedCodeText() {
        waitForSec(5);
        return textCopyEmbedCode.isElementPresent();
    }

    public boolean verifyCopyAndPasteText() {
        return textCopyAndPaste.isElementPresent();
    }

    public boolean verifyCopyButton() {
        return btnCopy.isElementPresent();
    }

    public void clickOnCopyButton() {
        if (btnCopy.isElementPresent()) {
            btnCopy.clickJScript();
            reportLog("Successfully clicked on Copy Button");
        }
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.click();
            reportLog("Successfully clicked on Close Icon");
        }
    }

    public boolean verifyFlexBookBookCoverAreVisible() {
        return flexBookCover.isElementPresent();
    }

    public void hoverFlexBookBookCover() {
        flexBookCover.mouseHover();
    }

    public boolean verifyDescriptionText() {
        return textDescription.isElementPresent();
    }

    public boolean verifyCreatedByText() {
        return textCreatedBy.isElementPresent();
    }
}