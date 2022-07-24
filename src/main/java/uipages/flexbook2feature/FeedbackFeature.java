package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;
import java.io.File;

public class FeedbackFeature extends BasePage {

    private final GuiControl iconFeedBack = new GuiControl(getElementMap().get("iconFeedBack"), webDriver);
    private final GuiControl textHowCanWeImprove = new GuiControl(getElementMap().get("textHowCanWeImprove"), webDriver);
    private final GuiControl PlaceHolderReport = new GuiControl(getElementMap().get("PlaceHolderReport"), webDriver);
    private final GuiControl iconUploadImage = new GuiControl(getElementMap().get("iconUploadImage"), webDriver);
    private final GuiControl buttonCancelReport = new GuiControl(getElementMap().get("buttonCancelReport"), webDriver);
    private final GuiControl buttonSendReport = new GuiControl(getElementMap().get("buttonSendReport"), webDriver);
    private final GuiControl iconCloseReport = new GuiControl(getElementMap().get("iconCloseReport"), webDriver);
    private final GuiControl textReportError = new GuiControl(getElementMap().get("textReportError"), webDriver);
    private final GuiControl listUploadImage = new GuiControl(getElementMap().get("listUploadImage"), webDriver);
    private final GuiControl iconDelete = new GuiControl(getElementMap().get("iconDelete"), webDriver);
    private final GuiControl textReportSuccess = new GuiControl(getElementMap().get("textReportSuccess"), webDriver);

    public FeedbackFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyFeedBackIcon() {
        waitForSec(5);
        return iconFeedBack.isElementPresent();
    }

    public void clickOnFeedBackIcon() {
        if (iconFeedBack.isElementPresent()) {
            iconFeedBack.clickJScript();
            reportLog("Successfully Clicked On FeedBack Icon");
        }
    }

    public boolean verifyHowCanWeImproveText() {
        waitForSec(5);
        return textHowCanWeImprove.isElementPresent();
    }

    public boolean verifyReportPlaceHolder() {
        return PlaceHolderReport.isElementPresent();
    }

    public void enterFeedbackText(String feedback) {
        if (PlaceHolderReport.isElementPresent()){
            PlaceHolderReport.clickJScript();
            PlaceHolderReport.clearText();
            PlaceHolderReport.sendKeys(feedback);
            reportLog("Entered feedback and data is: " + feedback);
        }
    }

    public boolean verifyUploadImageIcon() {
        return iconUploadImage.isEnable();
    }

    public void setPathOfFile() {
        iconUploadImage.sendKeys(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "images" + File.separator + "textbooks.jpg");
        reportLog("Successfully Upload File");
    }

    public boolean verifyCancelReportButton() {
        return buttonCancelReport.isElementPresent();
    }

    public void clickOnCancelReportButton() {
        if (buttonCancelReport.isElementPresent()) {
            buttonCancelReport.clickJScript();
            reportLog("Successfully Clicked On Cancel Report Button");
        }
    }

    public boolean verifySendReportButton() {
        return buttonSendReport.isElementPresent();
    }

    public void clickOnSendReportButton() {
        if (buttonSendReport.isElementPresent()) {
            buttonSendReport.clickJScript();
            reportLog("Successfully Clicked On Send Report Button");
        }
    }

    public boolean verifyCloseReportIcon() {
        return iconCloseReport.isElementPresent();
    }

    public void clickOnCloseReportIcon() {
        if (iconCloseReport.isElementPresent()) {
            iconCloseReport.clickJScript();
            reportLog("Successfully Clicked On Close Report Icon");
        }
    }

    public boolean verifyReportErrorText() {
        waitForSec(5);
        return textReportError.isElementPresent();
    }

    public boolean verifyReportSuccessText(){
        return textReportSuccess.isElementPresent();
    }

    public boolean verifyUploadImageIsDisplay() {
        waitForSec(10);
        return listUploadImage.isElementPresent();
    }

    public boolean verifyUploadImageIsNotDisplay() {
        waitForSec(5);
        return ! listUploadImage.isElementPresent();
    }


    public boolean verifyDeleteIcon() {
        return iconDelete.isElementPresent();
    }

    public void clickOnDeleteIcon() {
        if (iconDelete.isElementPresent()) {
            iconDelete.clickJScript();
            reportLog("Successfully Clicked On Delete Icon");
        }
    }

}