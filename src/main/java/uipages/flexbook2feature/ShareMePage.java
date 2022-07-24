package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class ShareMePage extends BasePage {

    private final GuiControl wdgtShareMe = new GuiControl(getElementMap().get("wdgtShareMe"), webDriver);
    private final GuiControl txtFullName = new GuiControl(getElementMap().get("txtFullName"), webDriver);
    private final GuiControl txtEmailFrom = new GuiControl(getElementMap().get("txtEmailFrom"), webDriver);
    private final GuiControl txtEmailRecipient = new GuiControl(getElementMap().get("txtEmailRecipient"), webDriver);
    private final GuiControl btnSend = new GuiControl(getElementMap().get("btnSend"), webDriver);
    private final GuiControl btnClose = new GuiControl(getElementMap().get("btnClose"), webDriver);
    private final GuiControl errMsgFullName = new GuiControl(getElementMap().get("errMsgFullName"), webDriver);
    private final GuiControl errMsgEmailFrom = new GuiControl(getElementMap().get("errMsgEmailFrom"), webDriver);
    private final GuiControl errMsgEmailRecipient = new GuiControl(getElementMap().get("errMsgEmailRecipient"), webDriver);

    public ShareMePage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnShareMeWidget() {
        if (wdgtShareMe.isElementPresent()) {
            wdgtShareMe.click();
            reportLog("Clicked on the 'Share Me' widget.");
        }
        waitForSec(5);
    }

    public void setFullNameField(String fullName) {
        if (txtFullName.isElementPresent()) {
            txtFullName.clickJScript();
           // txtFullName.setText(fullName);
            reportLog("Set the 'Full Name' field  on the 'Share Me' popup to" + fullName);
        }
    }

    public void setEmailFromField(String emailFrom) {
        if (txtEmailFrom.isElementPresent()) {
            txtEmailFrom.clickJScript();
          //  txtEmailFrom.setText(emailFrom);
            reportLog("Set the 'Email From' field on the 'Share Me' popup to" + emailFrom);
        }
    }

    public void setEmailRecipientField(String emailRecp) {
        if (txtEmailRecipient.isElementPresent()) {
            txtEmailRecipient.clickJScript();
            //txtEmailRecipient.setText(emailRecp);
            reportLog("Set the 'Email Recipient' field on the 'Share Me' popup to" + emailRecp);
        }
    }

    public boolean verifySendButton() {
        waitForSec(5);
        return btnSend.isElementPresent();
    }

    public void clickOnSendButton() {
        if (btnSend.isElementPresent()) {
            btnSend.click();
            reportLog("Clicked on the 'Send' button on the 'Share Me' popup");
        }
    }

    public void clickOnCloseButton() {
        if (btnClose.isElementPresent()) {
            btnClose.click();
            reportLog("Clicked on the 'Close' button on the 'Share Me' popup");
        }
    }

    public boolean verifyFullNameErrMsg() {
        return errMsgFullName.isElementPresent();
    }

    public boolean verifyEmailFromErrMsg() {
        waitForSec(5);
        return errMsgEmailFrom.isElementPresent();
    }

    public boolean verifyEmailRecipientErrMsg() {
        return errMsgEmailRecipient.isElementPresent();
    }
}