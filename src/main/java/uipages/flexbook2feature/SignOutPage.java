package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class SignOutPage extends BasePage {

    private final GuiControl userProfileBtnLink = new GuiControl(getElementMap().get("userProfileBtnLink"), webDriver);
    private final GuiControl btnSignOut = new GuiControl(getElementMap().get("btnSignOut"), webDriver);
    private final GuiControl btnJoin = new GuiControl(getElementMap().get("btnJoin"), webDriver);
    private final GuiControl textCreateAccountWithCK12 = new GuiControl(getElementMap().get("textCreateAccountWithCK12"), webDriver);
    private final GuiControl textStudentSignUp = new GuiControl(getElementMap().get("textStudentSignUp"), webDriver);
    private final GuiControl textAreYouTeacher = new GuiControl(getElementMap().get("textAreYouTeacher"), webDriver);
    private final GuiControl linkSignUpHere = new GuiControl(getElementMap().get("linkSignUpHere"), webDriver);
    private final GuiControl textTeacherSignUp = new GuiControl(getElementMap().get("textTeacherSignUp"), webDriver);
    private final GuiControl btnGoogleSignUp = new GuiControl(getElementMap().get("btnGoogleSignUp"), webDriver);
    private final GuiControl btnFaceBookSignUp = new GuiControl(getElementMap().get("btnFaceBookSignUp"), webDriver);
    private final GuiControl btnShowMore = new GuiControl(getElementMap().get("btnShowMore"), webDriver);
    private final GuiControl btnSignUpUsingEmail = new GuiControl(getElementMap().get("btnSignUpUsingEmail"), webDriver);
    private final GuiControl btnTwitterSignUp = new GuiControl(getElementMap().get("btnTwitterSignUp"), webDriver);
    private final GuiControl btnMicrosoftSignUp = new GuiControl(getElementMap().get("btnMicrosoftSignUp"), webDriver);
    private final GuiControl textOr = new GuiControl(getElementMap().get("textOr"), webDriver);
    private final GuiControl linkSignIn = new GuiControl(getElementMap().get("linkSignIn"), webDriver);
    private final GuiControl textSignIn = new GuiControl(getElementMap().get("textSignIn"), webDriver);
    private final GuiControl fullNamePlaceHolder = new GuiControl(getElementMap().get("fullNamePlaceHolder"), webDriver);
    private final GuiControl placeHolderEmail = new GuiControl(getElementMap().get("placeHolderEmail"), webDriver);
    private final GuiControl placeHolderPassword = new GuiControl(getElementMap().get("placeHolderPassword"), webDriver);
    private final GuiControl textDoubleQuotesError = new GuiControl(getElementMap().get("textDoubleQuotesError"), webDriver);
    private final GuiControl textSpecialCharacterError = new GuiControl(getElementMap().get("textSpecialCharacterError"), webDriver);
    private final GuiControl textPoorPassword = new GuiControl(getElementMap().get("textPoorPassword"), webDriver);
    private final GuiControl checkBoxShowPassword = new GuiControl(getElementMap().get("checkBoxShowPassword"), webDriver);
    private final GuiControl valuePassword = new GuiControl(getElementMap().get("valuePassword"), webDriver);
    private final GuiControl textHiddenPassword = new GuiControl(getElementMap().get("textHiddenPassword"), webDriver);
    private final GuiControl btnSignUp = new GuiControl(getElementMap().get("btnSignUp"), webDriver);
    private final GuiControl textAreYouStudent = new GuiControl(getElementMap().get("textAreYouStudent"), webDriver);

    public SignOutPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver,extentTest,extentReports);
    }

    public void clickOnUserProfileIcon() {
        if (userProfileBtnLink.isElementPresent()) {
            userProfileBtnLink.clickJScript();
            reportLog("Clicked on user profile icon.");
        }
    }

    public void clickOnSignOut() {
        if (btnSignOut.isElementPresent()) {
            btnSignOut.clickJScript();

        }
    }

    public boolean verifySignOut() {
        waitForSec(5);
        return btnSignOut.isElementPresent();
    }

    public boolean verifyJoinButton() {
        waitForSec(5);
        return btnJoin.isElementPresent();
    }

    public void clickOnJoinButton() {
        if (btnJoin.isElementPresent()) {
            btnJoin.clickJScript();
        }
    }

    public boolean verifyShowMoreButton() {
        return btnShowMore.isElementPresent();
    }

    public void clickOnShowMoreButton() {
        if (btnShowMore.isElementPresent()) {
            btnShowMore.clickJScript();
            reportLog("Clicked on Show More Button.");
        }
    }

    public void HoverOnJoinButton() {
        if (btnJoin.isElementPresent()) {
            btnJoin.mouseHover();
            reportLog("Hover on Join Button.");
        }
    }

    public boolean verifyCreateAccountWithCk12Text() {
        waitForSec(2);
        return textCreateAccountWithCK12.isElementPresent();
    }

    public boolean verifyStudentSignUpText() {
        waitForSec(5);
        return textStudentSignUp.isElementPresent();
    }

    public boolean verifyAreYouTeacherText() {
        return textAreYouTeacher.isElementPresent();
    }

    public boolean verifyAreYouStudentText() {
        return textAreYouStudent.isElementPresent();
    }

    public boolean verifySignUpHereLink() {
        return linkSignUpHere.isElementPresent();
    }

    public void clickOnSignUpHereLink() {
        if (linkSignUpHere.isElementPresent()) {
            linkSignUpHere.clickJScript();
            reportLog("Clicked on Sign Up here Link.");
        }
    }

    public boolean verifyTeacherSignUpText() {
        return textTeacherSignUp.isElementPresent();
    }

    public boolean verifySignUpWithGoogleButton() {
        return btnGoogleSignUp.isElementPresent();
    }

    public boolean verifySignUpWithFaceBookButton() {
        return btnFaceBookSignUp.isElementPresent();
    }

    public boolean verifySignUpUsingEmailButton() {
        return btnSignUpUsingEmail.isElementPresent();
    }

    public void clickOnSignUpUsingEmailButton() {
        if (btnSignUpUsingEmail.isElementPresent()) {
            btnSignUpUsingEmail.clickJScript();
            reportLog("Clicked on Sign Up Using Email Button.");
        }
    }

    public boolean verifySignUpWithTwitterButton() {
        return btnTwitterSignUp.isElementPresent();
    }

    public boolean verifySignUpWithMicrosoftButton() {
        return btnMicrosoftSignUp.isElementPresent();
    }

    public void scrollTheScreen(){
        textOr.isElementPresent();
        textOr.scrollIntoView();
        reportLog("Successfully Scroll Screen through Or Text.");
    }

    public boolean verifySignInLink() {
        waitForSec(2);
        return linkSignIn.isElementPresent();
    }

    public void clickOnSignInLink() {
        if (linkSignIn.isElementPresent()) {
            linkSignIn.clickJScript();
            reportLog("Clicked on Sign In Link.");
        }
    }

    public boolean verifySignInText() {
        waitForSec(5);
        return textSignIn.isElementPresent();
    }

    public boolean verifyFullNamePlaceHolder() {
        waitForSec(5);
        return fullNamePlaceHolder.isElementPresent();
    }

    public void setValueInFullNamePlaceHolder(String name) {
        if (fullNamePlaceHolder.isElementPresent()) {
            fullNamePlaceHolder.clickJScript();
            fullNamePlaceHolder.setText(name);
            reportLog("Set Value in Full Name PlaceHolder.");
        }
    }

    public boolean verifyEmailPlaceHolder() {
        return placeHolderEmail.isElementPresent();
    }

    public boolean verifyPasswordPlaceHolder() {
        return placeHolderPassword.isElementPresent();
    }

    public void setValueInPasswordPlaceHolder(String pass) {
        if (placeHolderPassword.isElementPresent()) {
            placeHolderPassword.clickJScript();
            placeHolderPassword.setText(pass);
            reportLog("Set Value in Password PlaceHolder.");
        }
    }

    public void clickOnPasswordPlaceHolder() {
        if (placeHolderPassword.isElementPresent()) {
            placeHolderPassword.clickJScript();
            placeHolderPassword.setText("");
            reportLog("Click On Password PlaceHolder.");
        }
    }

    public boolean verifyDoubleQuotesErrorText() {
        waitForSec(5);
        return textDoubleQuotesError.isElementPresent();
    }

    public boolean verifySpecialCharacterErrorText() {
        waitForSec(5);
        return textSpecialCharacterError.isElementPresent();
    }

    public boolean verifySixCharacterErrorText() {
        waitForSec(2);
        return textPoorPassword.isElementPresent();
    }

    public boolean verifyShowPasswordCheckBox() {
        return checkBoxShowPassword.isElementPresent();
    }

    public void clickOnShowPasswordCheckBox() {
        if (checkBoxShowPassword.isElementPresent()) {
            checkBoxShowPassword.clickJScript();
            reportLog("Clicked on Show Password CheckBox.");
        }
    }

    public boolean verifyShowPasswordCheckBoxIsSelected() {
        waitForSec(2);
        return valuePassword.isElementPresent();
    }

    public boolean verifyPasswordIsHidden() {
        waitForSec(2);
        return textHiddenPassword.isElementPresent();
    }

    public boolean verifySignUpButton() {
        return btnSignUp.isElementPresent();
    }

    public void clickOnSignUpButton() {
        if (btnSignUp.isElementPresent()) {
            btnSignUp.clickJScript();
            reportLog("Clicked on SignUpButton.");
        }
    }
}