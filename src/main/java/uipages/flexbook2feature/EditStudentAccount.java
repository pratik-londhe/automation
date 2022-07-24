package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class EditStudentAccount extends BasePage {
    private static final Logger logger = Logger.getLogger(EditStudentAccount.class);

    private final GuiControl btnAddStudent = new GuiControl(getElementMap().get("btnAddStudent"), webDriver);
    private final GuiControl iconEllipsisFirst = new GuiControl(getElementMap().get("iconEllipsisFirst"), webDriver);
    private final GuiControl iconEllipsisSecond = new GuiControl(getElementMap().get("iconEllipsisSecond"), webDriver);
    private final GuiControl editAccountLink = new GuiControl(getElementMap().get("editAccountLink"), webDriver);
    private final GuiControl editAccountLinkSec = new GuiControl(getElementMap().get("editAccountLinkSec"), webDriver);
    private final GuiControl iconRelative = new GuiControl(getElementMap().get("iconRelative"), webDriver);
    private final GuiControl textThisActionIsOnlyForCreator = new GuiControl(getElementMap().get("textThisActionIsOnlyForCreator"), webDriver);
    private final GuiControl textEditAccount = new GuiControl(getElementMap().get("textEditAccount"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl iconCloseEditAccount = new GuiControl(getElementMap().get("iconCloseEditAccount"), webDriver);
    private final GuiControl textUserName = new GuiControl(getElementMap().get("textUserName"), webDriver);
    private final GuiControl iconUserNameInfo = new GuiControl(getElementMap().get("iconUserNameInfo"), webDriver);
    private final GuiControl textUsernameCanNotChange = new GuiControl(getElementMap().get("textUsernameCanNotChange"), webDriver);
    private final GuiControl iconCloseUserNameInfo = new GuiControl(getElementMap().get("iconCloseUserNameInfo"), webDriver);
    private final GuiControl iconHidden = new GuiControl(getElementMap().get("iconHidden"), webDriver);
    private final GuiControl linkResetPassword = new GuiControl(getElementMap().get("linkResetPassword"), webDriver);
    private final GuiControl placeHolderUpdatePassword = new GuiControl(getElementMap().get("placeHolderUpdatePassword"), webDriver);
    private final GuiControl linkDiscardChanges = new GuiControl(getElementMap().get("linkDiscardChanges"), webDriver);
    private final GuiControl stuUsername = new GuiControl(getElementMap().get("stuUsername"), webDriver);

    public EditStudentAccount(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyHiddenIcon() {
        return iconHidden.isElementPresent();
    }

    public String getStudUsername(){
        waitForSec(4);
        return stuUsername.getText();
    }
    public void HoverOnHiddenIcon() {
        if (iconHidden.isElementPresent()) {
            iconHidden.clickJScript();
            reportLog("Successfully Clicked On Hidden Icon");
        }
    }

    public boolean verifyResetPasswordLink() {
        waitForSec(2);
        return linkResetPassword.isElementPresent();
    }

    public void clickOnResetPasswordLink() {
        if (linkResetPassword.isElementPresent()) {
            linkResetPassword.clickJScript();
            reportLog("Successfully Clicked On Reset Password Link");
        }
    }

    public boolean verifyUpdatePasswordPlaceHolder() {
        waitForSec(2);
        return placeHolderUpdatePassword.isElementPresent();
    }

    public void setValueInUpdatePasswordPlaceHolder() {
        if (placeHolderUpdatePassword.isElementPresent()) {
            placeHolderUpdatePassword.clickJScript();
            placeHolderUpdatePassword.setText("Abcd123");
            reportLog("Successfully Clicked On Update Password PlaceHolder");
        }
    }

    public boolean verifyDiscardChangesLink() {
        return linkDiscardChanges.isElementPresent();
    }

    public void clickOnDiscardChangesLink() {
        if (linkDiscardChanges.isElementPresent()) {
            linkDiscardChanges.clickJScript();
            reportLog("Successfully Clicked On Discard Changes Link");
        }
    }

    public boolean verifyAddStudentButton() {
        waitForSec(5);
        return btnAddStudent.isElementPresent();
    }

    public boolean verifyFirstEllipsisIcon() {
        return iconEllipsisFirst.isElementPresent();
    }

    public void clickOnFirstEllipsisIcon() {
        if (iconEllipsisFirst.isElementPresent()) {
            iconEllipsisFirst.clickJScript();
            reportLog("Successfully Clicked On First Ellipsis Icon");
        }
    }

    public boolean verifySecondEllipsisIcon() {
        return iconEllipsisSecond.isElementPresent();
    }

    public void clickOnSecondEllipsisIcon() {
        if (iconEllipsisSecond.isElementPresent()) {
            iconEllipsisSecond.clickJScript();
            reportLog("Successfully Clicked On Second Ellipsis Icon");
        }
    }

    public boolean verifyEditAccountLink() {
        waitForSec(5);
        return editAccountLink.isElementPresent();
    }

    public void clickOnEditAccountLink() {
        if (editAccountLinkSec.isElementPresent()) {
            editAccountLinkSec.clickJScript();
            reportLog("Successfully Clicked On edit Account Link");
        }
    }
    public void clickOnEditAccountLinkFirst() {
        if (editAccountLink.isElementPresent()) {
            editAccountLink.clickJScript();
            reportLog("Successfully Clicked On edit Account Link");
        }
    }
    public boolean verifyRelativeIcon() {
        waitForSec(5);
        return iconRelative.isElementPresent();
    }

    public void HoverOnRelativeIcon() {
        if (iconRelative.isElementPresent()) {
            iconRelative.mouseHover();
            reportLog("Successfully Clicked On Relative Icon");
        }
    }

    public boolean verifyThisActionISOnlyForCreatorText() {
        waitForSec(2);
        return textThisActionIsOnlyForCreator.isElementPresent();
    }

    public boolean verifyEditAccountText() {
        waitForSec(5);
        return textEditAccount.isElementPresent();
    }

    public boolean verifyCancelButton() {
        return btnCancel.isElementPresent();
    }

    public boolean verifyCloseEditAccountIcon() {
        return iconCloseEditAccount.isElementPresent();
    }

    public void clickOnCloseEditAccountIcon() {
        if (iconCloseEditAccount.isElementPresent()) {
            iconCloseEditAccount.clickJScript();
            reportLog("Successfully Clicked On Close Edit Account Icon");
        }
    }

    public boolean verifyUserNameText() {
        return textUserName.isElementPresent();
    }

    public boolean verifyUserNameInfoIcon() {
        return iconUserNameInfo.isElementPresent();
    }

    public void clickOnUserNameInfoIcon() {
        if (iconUserNameInfo.isElementPresent()) {
            iconUserNameInfo.clickJScript();
            reportLog("Successfully Clicked On UserName Info Icon");
        }
    }

    public boolean verifyUserNameCanNotBeChangeText() {
        waitForSec(2);
        return textUsernameCanNotChange.isElementPresent();
    }

    public boolean verifyCloseUserNAmeInfoIcon() {
        return iconCloseUserNameInfo.isElementPresent();
    }

    public void clickOnCloseUserNameInfoIcon() {
        if (iconCloseUserNameInfo.isElementPresent()) {
            iconCloseUserNameInfo.clickJScript();
            reportLog("Successfully Clicked On Close UserName Info Icon");
        }
    }
}
