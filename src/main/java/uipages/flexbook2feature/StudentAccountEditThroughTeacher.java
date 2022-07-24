package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uipages.BasePage;
import utils.GuiControl;
import java.util.List;

public class StudentAccountEditThroughTeacher extends BasePage {

    private int memCountBefore = 0;
    private int memCountAfter = 0;
    private List<WebElement> memberNameBefore;
    private List<WebElement> memberNameAfter;
    private String firstNameBefore;
    private String firstNameAfter;
    private String studentNameCountXpath = "//div[@class='member-details']//span[2]";

    private final GuiControl iconMoreOption = new GuiControl(getElementMap().get("iconMoreOption"), webDriver);
    private final GuiControl linkViewReports = new GuiControl(getElementMap().get("linkViewReports"), webDriver);
    private final GuiControl linkEditAccount = new GuiControl(getElementMap().get("linkEditAccount"), webDriver);
    private final GuiControl linkRemove = new GuiControl(getElementMap().get("linkRemove"), webDriver);
    private final GuiControl btnCancelRemove = new GuiControl(getElementMap().get("btnCancelRemove"), webDriver);
    private final GuiControl btnCloseRemove = new GuiControl(getElementMap().get("btnCloseRemove"), webDriver);
    private final GuiControl btnDeleteMember = new GuiControl(getElementMap().get("btnDeleteMember"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl btnSave = new GuiControl(getElementMap().get("btnSave"), webDriver);
    private final GuiControl iconCloseEditAccount = new GuiControl(getElementMap().get("iconCloseEditAccount"), webDriver);
    private final GuiControl txtUpdateFirstName = new GuiControl(getElementMap().get("txtUpdateFirstName"), webDriver);
    private final GuiControl linkDiscardChanges = new GuiControl(getElementMap().get("linkDiscardChanges"), webDriver);
    private final GuiControl iconInfoRelativeInline = new GuiControl(getElementMap().get("iconInfoRelativeInline"), webDriver);
    private final GuiControl linkResetPassword = new GuiControl(getElementMap().get("linkResetPassword"), webDriver);
    private final GuiControl txtUpdatePassword = new GuiControl(getElementMap().get("txtUpdatePassword"), webDriver);
    private final GuiControl txtErrorPassword = new GuiControl(getElementMap().get("txtErrorPassword"), webDriver);
    private final GuiControl linkShowPassword = new GuiControl(getElementMap().get("linkShowPassword"), webDriver);
    private final GuiControl linkHidePassword = new GuiControl(getElementMap().get("linkHidePassword"), webDriver);

    public StudentAccountEditThroughTeacher(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void RemoveStudentRepeated() {
        clickOnIconMoreOption();
        clickOnLinkRemoveStudent();
        clickOnDeleteStudentButton();
    }

    public boolean verifyMoreOptionDropDown() {
        List<WebElement> textInformation1 = webDriver.findElements(By.xpath("//div[@class='modal-contents ie8text']"));
        return !textInformation1.isEmpty();
    }

    public void clickOnIconMoreOption() {
        waitForSec(10);
        if (iconMoreOption.isElementPresent()) {
            iconMoreOption.clickFirstFromListOfElements();
            reportLog("Successfully Clicked On First Student's 'More' option");
        }
        waitForSec(5);
    }

    public boolean verifyLinkViewReports() {
        return linkViewReports.isElementPresent();
    }

    public boolean verifyLinkEditAccount() {
        return linkEditAccount.isElementPresent();
    }

    public boolean verifyLinkRemove() {
        return linkRemove.isElementPresent();
    }

    public void clickOnLinkEditAccount() {
        if (linkEditAccount.isElementPresent()) {
            linkEditAccount.mouseHover();
            linkEditAccount.click();
            reportLog("Successfully Clicked On link 'Edit Account'");
        }
    }

    public boolean verifyCancelEditAccountButton() {
        return btnCancel.isElementPresent();
    }

    public boolean verifySaveButton() {
        return btnSave.isElementPresent();
    }

    public boolean verifyCloseEditAccountIcon() {
        return iconCloseEditAccount.isElementPresent();
    }

    public void clickOnIconCloseEditAccount() {
        if (iconCloseEditAccount.isElementPresent()) {
            iconCloseEditAccount.click();
            reportLog("Successfully Clicked On Icon 'Close' on Edit Account");
        }
    }

    public void clickOnButtonCancel() {
        if (btnCancel.isElementPresent()) {
            btnCancel.clickJScript();
            reportLog("Successfully Clicked On 'Cancel' Button");
        }
    }

    public void getNameOfMemberBefore() {
        memberNameBefore = webDriver.findElements(By.xpath(studentNameCountXpath));
        reportLog("Successfully retrieved Name Of Member before edit");
    }

    public void getNameOfMemberAfter() {
        memberNameAfter = webDriver.findElements(By.xpath(studentNameCountXpath));
        reportLog("Successfully retrieved Name Of Member after edit");
    }

    public boolean verifyNamesAfterCancelButton() {
        return memberNameBefore.equals(memberNameAfter);
    }

    public boolean verifyTxtUpdateFirstName() {
        return txtUpdateFirstName.isElementPresent();
    }

    public boolean verifyLinkDiscardChanges() {
        return linkDiscardChanges.isElementPresent();
    }

    public void getFirstNameBeforeEdit() {
        firstNameBefore = txtUpdateFirstName.getAttribute("data-default-value");
        reportLog("Successfully retrieved FirstName value before edit: " + firstNameBefore);
    }

    public void clickOnTextUpdateFirstName(String updateName) {
        txtUpdateFirstName.setText(updateName + currentTimeStamp());
        reportLog("Successfully Set Text In FirstName");
    }

    public void clickOnLinkDiscardChanges() {
        if (linkDiscardChanges.isElementPresent()) {
            linkDiscardChanges.click();
            reportLog("Successfully Clicked On link 'Discard Changes'");
        }
    }

    public void getFirstNameAfterEdit() {
        firstNameAfter = txtUpdateFirstName.getAttribute("data-default-value");
        reportLog("Successfully retrieved FirstName Value after edit: " + firstNameAfter);
    }

    public boolean verifyFirstNameAfterDiscardChange() {
        return firstNameBefore.equalsIgnoreCase(firstNameAfter);
    }

    public void hoverIconInfoPassword() {
        if (iconInfoRelativeInline.isElementPresent()) {
            iconInfoRelativeInline.mouseHover();
            reportLog("Successfully Hovered on icon Info RelativeInline");
        }
    }

    public boolean verifyLinkRestPassword() {
        return linkResetPassword.isElementPresent();
    }

    public void clickOnLinkResetPassword() {
        if (linkResetPassword.isElementPresent()) {
            linkResetPassword.click();
            reportLog("Successfully Clicked on link 'Reset Password'");
        }
    }

    public boolean verifyShowPasswordLink() {
        return linkShowPassword.isElementPresent();
    }

    public void clickOnTextUpdatePassword(String updatePassword) {
        txtUpdatePassword.setText(updatePassword);
        reportLog("Successfully Set Text In Password");
    }

    public void clickOnSaveButton() {
        if (btnSave.isElementPresent()) {
            btnSave.click();
            reportLog("Successfully Clicked on 'Save' button");
        }
    }

    public boolean verifyTextErrorPassword() {
        return txtErrorPassword.isElementPresent();
    }

    public void clickOnShowPasswordLink() {
        if (linkShowPassword.isElementPresent()) {
            linkShowPassword.click();
            reportLog("Successfully Clicked on link 'Show Password'");
        }
    }

    public boolean verifyHidePasswordLink() {
        return linkHidePassword.isElementPresent();
    }

    public void clickOnHidePasswordLink() {
        if (linkHidePassword.isElementPresent()) {
            linkHidePassword.click();
            reportLog("Successfully Clicked on link 'Hide Password'");
        }
    }

    public void clickOnTextUpdatePasswordAgain(String updatePassword1) {
        txtUpdatePassword.setText(updatePassword1 + currentTimeStamp());
        reportLog("Successfully Set Text In Password");
    }

    public boolean VerifyUserNameAfterSave() {
        waitForSec(23);
        List<WebElement> changes = webDriver.findElements(By.xpath(studentNameCountXpath));
        reportLog("userName of Member is = " + firstNameBefore);
        for (WebElement change : changes) {
            if (!change.getText().equals(firstNameBefore)) {
                return true;
            }
        }
        return false;
    }

    public void clickOnLinkRemoveStudent() {
        if (linkRemove.isElementPresent()) {
            linkRemove.click();
            reportLog("Successfully Clicked On link 'Remove'");
        }
        waitForSec(5);
    }

    public boolean verifyTextRemoveStudent() {
        List<WebElement> textInformation = webDriver.findElements(By.xpath("//div[@class='modal-contents ie8text']"));
        return !textInformation.isEmpty();
    }

    public boolean verifyCancelButton() {
        return btnCancelRemove.isElementPresent();
    }

    public boolean verifyRemoveButton() {
        return btnDeleteMember.isElementPresent();
    }

    public boolean verifyCloseRemoveIcon() {
        return btnCloseRemove.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancelRemove.isElementPresent()) {
            btnCancelRemove.clickJScript();
            reportLog("Successfully Clicked On 'Cancel' Button");
        }
    }

    public void clickOnCloseRemoveButton() {
        if (btnCloseRemove.isElementPresent()) {
            btnCloseRemove.clickFirstFromListOfElements();
            reportLog("Successfully Clicked On Close Remove Button");
        }
    }

    public void getCountOfMemberBefore() {
        List<WebElement> membersBefore = webDriver.findElements(By.xpath(studentNameCountXpath));
        memCountBefore = membersBefore.size();
        if (memCountBefore > 1) {
            reportLog("Count of Members is = " + memCountBefore);
        } else {
            reportLog("Failed To get Members Count");
        }
    }

    public void getCountOfMemberAfter() {
        waitForSec(5);
        List<WebElement> membersAfter = webDriver.findElements(By.xpath(studentNameCountXpath));
        memCountAfter = membersAfter.size();
        if (memCountAfter > 0) {
            reportLog("Count of Members is = " + memCountAfter);
        } else {
            reportLog("Failed To get Members Count");
        }
    }

    public boolean verifyMembersCountAfterCancel() {
        return memCountAfter == memCountBefore;
    }

    public boolean verifyMembersCountAfterRemoveMember() {
        return memCountAfter != memCountBefore;
    }

    public void clickOnDeleteStudentButton() {
        waitForSec(5);
        if (btnDeleteMember.isElementPresent()) {
            btnDeleteMember.clickJScript();
            reportLog("Successfully Clicked On Delete Member Button");
        }
    }

    public void clickOnLinkViewReports() {
        if (linkViewReports.isElementPresent()) {
            linkViewReports.click();
            reportLog("Successfully Clicked On link View Reports");
        }
    }
}