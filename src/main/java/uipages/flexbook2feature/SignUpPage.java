package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class SignUpPage extends BasePage {

    private final GuiControl btnSignUpUsingEmail = new GuiControl(getElementMap().get("btnSignUpUsingEmail"), webDriver);
    private final GuiControl txtFullName = new GuiControl(getElementMap().get("txtFullName"), webDriver);
    private final GuiControl txtSignUpEmail = new GuiControl(getElementMap().get("txtSignUpEmail"), webDriver);
    private final GuiControl txtSignUpPassword = new GuiControl(getElementMap().get("txtSignUpPassword"), webDriver);
    private final GuiControl dDownMonth = new GuiControl(getElementMap().get("dDownMonth"), webDriver);
    private final GuiControl dDownMonthVal = new GuiControl(getElementMap().get("dDownMonthVal"), webDriver);
    private final GuiControl dDownDay = new GuiControl(getElementMap().get("dDownDay"), webDriver);
    private final GuiControl dDownDayVal = new GuiControl(getElementMap().get("dDownDayVal"), webDriver);
    private final GuiControl dDownYear = new GuiControl(getElementMap().get("dDownYear"), webDriver);
    private final GuiControl dDownYearVal = new GuiControl(getElementMap().get("dDownYearVal"), webDriver);
    private final GuiControl btnSignUp = new GuiControl(getElementMap().get("btnSignUp"), webDriver);
    private final GuiControl headSuccess = new GuiControl(getElementMap().get("headSuccess"), webDriver);
    private final GuiControl btnContinue = new GuiControl(getElementMap().get("btnContinue"), webDriver);
    private final GuiControl errMsgFullName = new GuiControl(getElementMap().get("errMsgFullName"), webDriver);
    private final GuiControl errMsgPassword = new GuiControl(getElementMap().get("errMsgPassword"), webDriver);
    private final GuiControl errMsgEmail = new GuiControl(getElementMap().get("errMsgEmail"), webDriver);
    private final GuiControl showPassCBox = new GuiControl(getElementMap().get("showPassCBox"), webDriver);
    private final GuiControl textStudentSignUp = new GuiControl(getElementMap().get("textStudentSignUp"), webDriver);
    private final GuiControl textTeacherSignUp = new GuiControl(getElementMap().get("textTeacherSignUp"), webDriver);
    private final GuiControl linkSignUpHere = new GuiControl(getElementMap().get("linkSignUpHere"), webDriver);
    private final GuiControl textUsername = new GuiControl(getElementMap().get("textUsername"), webDriver);
    private final GuiControl linkSettings = new GuiControl(getElementMap().get("linkSettings"), webDriver);
    private final GuiControl btnDone = new GuiControl(getElementMap().get("btnDone"), webDriver);
    private final GuiControl formName = new GuiControl(getElementMap().get("formName"), webDriver);
    private final GuiControl formUserName = new GuiControl(getElementMap().get("formUserName"), webDriver);
    private final GuiControl formPassword = new GuiControl(getElementMap().get("formPassword"), webDriver);

    public SignUpPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyStudentSignUpText() {
        return textStudentSignUp.isElementPresent();
    }

    public boolean verifyTeacherSignUpText() {
        return textTeacherSignUp.isElementPresent();
    }

    public boolean verifySignUpHereLink() {
        waitForSec(2);
        return linkSignUpHere.isElementPresent();
    }

    public void clickOnSignUpHereLink() {
        if (linkSignUpHere.isElementPresent()) {
            linkSignUpHere.clickJScript();
            reportLog("Successfully Click On Sign Up Here Link");
        }
    }

    public void clickOnBtnSignUpUsingEmail() {
        waitForSec(2);
        if (btnSignUpUsingEmail.isElementPresent()) {
            btnSignUpUsingEmail.clickJScript();
            reportLog("Clicked on Sign Up Using Email button.");
        }
    }

    public void setFullName(String fullName) {
        if (txtFullName.isElementPresent()) {
            txtFullName.click();
            txtFullName.setText(fullName);
            reportLog("Sign up Full Name value has been set to: " + fullName);
        }
    }

    private void setBDayMonth() {
        if (dDownMonth.isElementPresent()) {
            dDownMonth.clickJScript();
            dDownMonthVal.clickJScript();
            reportLog("Birthday Month value has been set to: January.");
        }
    }

    private void setBDayDay() {
        if (dDownDay.isElementPresent()) {
            dDownDay.click();
            dDownDayVal.click();
            reportLog("Birthday Day value has been set to: 1st.");
        }
    }

    private void setBDayYear() {
        if (dDownYear.isElementPresent()) {
            dDownYear.click();
            dDownYearVal.click();
            reportLog("Birthday Year value has been set to: 1999.");
        }
    }

    public void setBDayAllFields() {
        waitForSec(4);
        setBDayMonth();
        setBDayDay();
        setBDayYear();
    }

    public void setEmail(String userEmail) {
        if (txtSignUpEmail.isElementPresent()) {
            txtFullName.click();
            txtSignUpEmail.setText(userEmail);
            reportLog("Email value has been set to: " + userEmail);
        }
    }

    public void setPassword(String password) {
        if (txtSignUpPassword.isElementPresent()) {
            txtSignUpPassword.click();
            txtSignUpPassword.setText(password);
            reportLog("Password value has been set to: " + password);
        }
    }

    public void clickOnShowPassword() {
        if (showPassCBox.isElementPresent()) {
            showPassCBox.click();
            reportLog("Show Password checkbox value has been set to: True");
        }
    }

    public void clickOnBtnSignUp() {
        waitForSec(2);
        if (btnSignUp.isElementPresent()) {
            btnSignUp.clickJScript();
            reportLog("Clicked on the Sign Up button.");
        }
    }

    public void clickOnBtnContinue() {
        if (btnContinue.isElementPresent()) {
            btnContinue.click();
            reportLog("Clicked on the 'Continue' button.");
        }
    }

    public void clickOnBtnDone() {
        if (btnDone.isElementPresent()) {
            btnDone.click();
            reportLog("Clicked on the 'Done' button.");
        }
    }

    public void clickUserProfile() {
        if (textUsername.isElementPresent()) {
            waitForSec(2);
            textUsername.click();
            reportLog("Clicked on the 'Username' to bring up the Profile Menu");
        }
    }

    public void clickSettingsLink() {
        if (linkSettings.isElementPresent()) {
            linkSettings.click();
            reportLog("Clicked on the 'Settings' link");
            waitForSec(5);
        }
    }

    public boolean verifySuccessMessageDisplay() {
        waitForSec(5);
        String accountMsg = "Account Created";
        if (headSuccess.isElementPresent()) {
            return headSuccess.getText().equalsIgnoreCase(accountMsg);
        } else {
            return false;
        }
    }

    public boolean verifyContinueBtnPresent() {
        return btnContinue.isElementPresent();
    }

    public boolean verifyFullNameErrMessage() {
        waitForSec(2);
        String errMsg = "Enter your full name.";
        if (errMsgFullName.isElementPresent()) {
            return errMsgFullName.getText().equalsIgnoreCase(errMsg);
        }
        return false;
    }

    public boolean verifyEmailErrMessage() {
        waitForSec(4);
        String errMsg = "Enter valid email address(e.g. name@address.com)";
        if (errMsgEmail.isElementPresent()) {
            return errMsgEmail.getText().equalsIgnoreCase(errMsg);
        }
        return false;
    }

    public boolean verifySignUpButtonDisabled() {
        return btnSignUp.isEnable();
    }

    public boolean verifyPasswordErrMsgDisplay() {
        String errMsg = "Enter at least 8 characters.";
        String errMsgStrength = "Poor";
        waitForSec(2);
        System.out.println("Error Message " + errMsgPassword.getText());
        if (errMsgPassword.getText().contains(errMsg) || errMsgPassword.getText().contains(errMsgStrength)){
            return true;
        }
        return false;
    }

    public boolean verifyUsernamePresent() {
        return textUsername.isElementPresent();
    }

    public boolean settingsElementsDisplayed() {
        boolean profileElement = formName.isElementPresent();
        boolean signingInElement = formUserName.isElementPresent();
        boolean passwordElement = formPassword.isElementPresent();
        return (profileElement && signingInElement && passwordElement);
    }
}