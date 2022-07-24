package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class ForgotPasswordSignInPopUp extends BasePage {

    private final GuiControl linkForgotPassword = new GuiControl(getElementMap().get("linkForgotPassword"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl txtAddress = new GuiControl(getElementMap().get("txtAddress"), webDriver);
    private final GuiControl btnSendAddress = new GuiControl(getElementMap().get("btnSendAddress"), webDriver);
    private final GuiControl btnJoin = new GuiControl(getElementMap().get("btnJoin"), webDriver);

    public ForgotPasswordSignInPopUp(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnForgotPasswordLink() {
        waitForSec(5);
        if (linkForgotPassword.isElementPresent()) {
            linkForgotPassword.click();
            reportLog("Click on Forgot Password Link");
        }
        waitForSec(5);
    }

    public boolean verifyCancelButton() {
        return btnCancel.isElementPresent();
    }

    public boolean verifySendAddressButton() {
        return btnSendAddress.isElementPresent();
    }

    public boolean verifyForgotPasswordLink() {
        return linkForgotPassword.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.click();
            reportLog("Clicked on Cancel Button");
        }
    }

    public void clickOnTxtAddress(String emailAddress) {
        if (txtAddress.isElementPresent()) {
            txtAddress.click();
            txtAddress.setText(emailAddress);
            reportLog("Entered Your Email Address");
        }
    }

    public void clickOnSendAddressButton() {
        if (btnSendAddress.isElementPresent()) {
            btnSendAddress.click();
            reportLog("Clicked on Send Address button");
        }
    }

    public boolean verifyJoinButton() {
        return btnJoin.isElementPresent();
    }
}