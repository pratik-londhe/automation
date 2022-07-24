package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class PracticeWidgetModal extends BasePage {

    private final GuiControl dropDownPreview = new GuiControl(getElementMap().get("dropDownPreview"), webDriver);
    private final GuiControl btnDownload = new GuiControl(getElementMap().get("btnDownload"), webDriver);
    private final GuiControl btnCustomize = new GuiControl(getElementMap().get("btnCustomize"), webDriver);
    private final GuiControl linkPdf = new GuiControl(getElementMap().get("linkPdf"), webDriver);
    private final GuiControl linkHTML = new GuiControl(getElementMap().get("linkHTML"), webDriver);
    private final GuiControl textGetAnswerKey = new GuiControl(getElementMap().get("textGetAnswerKey"), webDriver);
    private final GuiControl btnClose = new GuiControl(getElementMap().get("btnClose"), webDriver);
    private final GuiControl textCreateQuiz = new GuiControl(getElementMap().get("textCreateQuiz"), webDriver);
    private final GuiControl btnBack = new GuiControl(getElementMap().get("btnBack"), webDriver);

    public PracticeWidgetModal(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyPreviewDropDown() {
        waitForSec(5);
        return dropDownPreview.isElementPresent();
    }

    public void clickOnPreviewDropDown() {
        if (dropDownPreview.isElementPresent()) {
            dropDownPreview.clickJScript();
            reportLog("Successfully clicked on Preview DropDown");
        }
    }

    public boolean verifyDownloadButton() {
        waitForSec(5);
        return btnDownload.isElementPresent();
    }

    public void clickOnDownloadButton() {
        if (btnDownload.isElementPresent()) {
            btnDownload.clickJScript();
            reportLog("Successfully clicked on Download Button");
        }
    }

    public boolean verifyCustomizeButton() {
        return btnCustomize.isElementPresent();
    }

    public void clickOnCustomizeButton() {
        if (btnCustomize.isElementPresent()) {
            btnCustomize.clickJScript();
            reportLog("Successfully clicked on Customize Button");
        }
    }

    public boolean verifyPDFLink() {
        waitForSec(5);
        return linkPdf.isElementPresent();
    }

    public void clickOnPDFLink() {
        if (linkPdf.isElementPresent()) {
            linkPdf.clickJScript();
            reportLog("Successfully clicked on PDF Link");
        }
    }

    public boolean verifyHTMLLink() {
        return linkHTML.isElementPresent();
    }

    public void clickOnHTMLLink() {
        if (linkHTML.isElementPresent()) {
            linkHTML.clickJScript();
            reportLog("Successfully clicked on HTML Link");
        }
    }

    public boolean verifyGetAnswerKeyText() {
        waitForSec(5);
        return textGetAnswerKey.isElementPresent();
    }

    public boolean verifyCloseButton() {
        return btnClose.isElementPresent();
    }

    public void clickOnCloseButton() {
        if (btnClose.isElementPresent()) {
            btnClose.clickJScript();
            reportLog("Successfully clicked on Close Button");
        }
    }

    public boolean verifyBackButton() {
        waitForSec(5);
        return btnBack.isElementPresent();
    }

    public void clickOnBackButton() {
        if (btnBack.isElementPresent()) {
            btnBack.clickJScript();
            reportLog("Successfully clicked on Back Button");
        }
    }

    public boolean verifyCreateQuizText() {
        return textCreateQuiz.isElementPresent();
    }
}