package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CoTeacherFeature extends BasePage {

    private final GuiControl textShow = new GuiControl(getElementMap().get("textShow"), webDriver);
    private final GuiControl iconClassMenu = new GuiControl(getElementMap().get("iconClassMenu"), webDriver);
    private final GuiControl linkHideFromDashBoard = new GuiControl(getElementMap().get("linkHideFromDashBoard"), webDriver);
    private final GuiControl textHideFromDashBoard = new GuiControl(getElementMap().get("textHideFromDashBoard"), webDriver);
    private final GuiControl btnHide = new GuiControl(getElementMap().get("btnHide"), webDriver);
    private final GuiControl linkCreateNewOne = new GuiControl(getElementMap().get("linkCreateNewOne"), webDriver);
    private final GuiControl textCreateNewClass = new GuiControl(getElementMap().get("textCreateNewClass"), webDriver);
    private final GuiControl iconClose = new GuiControl(getElementMap().get("iconClose"), webDriver);
    private final GuiControl linkHiddenClasses = new GuiControl(getElementMap().get("linkHiddenClasses"), webDriver);
    private final GuiControl linkDisplayOnDashBoard = new GuiControl(getElementMap().get("linkDisplayOnDashBoard"), webDriver);
    private final GuiControl textDisplayOnDashBoard = new GuiControl(getElementMap().get("textDisplayOnDashBoard"), webDriver);
    private final GuiControl btnDisplay = new GuiControl(getElementMap().get("btnDisplay"), webDriver);
    private final GuiControl linkCurrentClasses = new GuiControl(getElementMap().get("linkCurrentClasses"), webDriver);
    private final GuiControl textClassName = new GuiControl(getElementMap().get("textClassName"), webDriver);
    private final GuiControl textEmailNotification = new GuiControl(getElementMap().get("textEmailNotification"), webDriver);
    private final GuiControl deleteClassButton = new GuiControl(getElementMap().get("deleteClassButton"), webDriver);
    private final GuiControl textClassAdmin = new GuiControl(getElementMap().get("textClassAdmin"), webDriver);
    private final GuiControl btnAddStudent = new GuiControl(getElementMap().get("btnAddStudent"), webDriver);
    private final GuiControl textReports = new GuiControl(getElementMap().get("textReports"), webDriver);
    private final GuiControl linkHowDoesThisWork = new GuiControl(getElementMap().get("linkHowDoesThisWork"), webDriver);
    private final GuiControl btnChoose = new GuiControl(getElementMap().get("btnChoose"), webDriver);
    private final GuiControl btnShareToClass = new GuiControl(getElementMap().get("btnShareToClass"), webDriver);
    private final GuiControl textYouDoNotOwnAnyClass = new GuiControl(getElementMap().get("textYouDoNotOwnAnyClass"), webDriver);
    private final GuiControl linkCreateNewClass = new GuiControl(getElementMap().get("linkCreateNewClass"), webDriver);
    private final GuiControl iconCk12 = new GuiControl(getElementMap().get("iconCk12"), webDriver);
    private final GuiControl btnAssign = new GuiControl(getElementMap().get("btnAssign"), webDriver);
    private final GuiControl btnAssignToClass = new GuiControl(getElementMap().get("btnAssignToClass"), webDriver);
    private final GuiControl btnShareWithClasses = new GuiControl(getElementMap().get("btnShareWithClasses"), webDriver);
    private final GuiControl btnCreateAClass = new GuiControl(getElementMap().get("btnCreateAClass"), webDriver);
    private final GuiControl linkCreateClass = new GuiControl(getElementMap().get("linkCreateClass"), webDriver);
    private final GuiControl btnCreateAssignment = new GuiControl(getElementMap().get("btnCreateAssignment"), webDriver);
    private final GuiControl textFirstClassName = new GuiControl(getElementMap().get("textFirstClassName"), webDriver);
    private final GuiControl textSecondClassName = new GuiControl(getElementMap().get("textSecondClassName"), webDriver);
    private final GuiControl buttonAssign = new GuiControl(getElementMap().get("buttonAssign"), webDriver);
    private final GuiControl btnTurnIn = new GuiControl(getElementMap().get("btnTurnIn"), webDriver);
    private final GuiControl iconCk12ImageAgain = new GuiControl(getElementMap().get("iconCk12ImageAgain"), webDriver);

    public CoTeacherFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyTurnInButtonIsVisible() {
        waitForSec(5);
        return btnTurnIn.isElementPresent();
    }

    public boolean verifyNameOfCreateClassAndJoinClassAreSame(){
        return textFirstClassName.getText().equalsIgnoreCase(textSecondClassName.getText());
    }

    public boolean verifyAssignToClassButton() {
        waitForSec(5);
        return btnAssignToClass.isElementPresent();
    }

    public boolean verifyAssignButtonOfOptionDropDown() {
        return buttonAssign.isElementPresent();
    }

    public void clickOnAssignButtonOfOptionDropDown() {
        if (buttonAssign.isElementPresent()) {
            buttonAssign.clickJScript();
            reportLog("clicked on Assign To Class Button");
        }
    }

    public boolean verifyCreateClassNameText() {
        waitForSec(5);
        return textFirstClassName.isElementPresent();
    }

    public boolean verifyJoinedClassNameText() {
        return textSecondClassName.isElementPresent();
    }

    public boolean verifyCreateClassLink() {
        waitForSec(5);
        return linkCreateClass.isElementPresent();
    }

    public void clickOnAssignToClassButton() {
        if (btnAssignToClass.isElementPresent()) {
            btnAssignToClass.clickJScript();
            reportLog("clicked on Assign To Class Button");
        }
    }

    public boolean verifyShareWithClassButton() {
        return btnShareWithClasses.isElementPresent();
    }

    public void clickOnShareWithClassButton() {
        if (btnShareWithClasses.isElementPresent()) {
            btnShareWithClasses.clickJScript();
            reportLog("clicked on Share With Class Button");
        }
    }

    public boolean verifyCreateAClassButton() {
        waitForSec(5);
        return btnCreateAClass.isElementPresent();
    }

    public boolean verifyAssignButton() {
        waitForSec(10);
        return btnAssign.isElementPresent();
    }

    public void clickOnAssignButton() {
        if (btnAssign.isElementPresent()) {
            btnAssign.clickJScript();
            reportLog("clicked on Assign Button");
        }
    }

    public boolean verifyCk12ImageIcon() {
        waitForSec(5);
        return iconCk12.isElementPresent();
    }

    public void clickOnCk12ImageIcon() {
        if (iconCk12.isElementPresent()) {
            iconCk12.clickJScript();
            reportLog("clicked on Ck12ImageIcon");
        }
    }

    public boolean verifyCk12ImageIconAgain() {
        waitForSec(5);
        return iconCk12ImageAgain.isElementPresent();
    }

    public void clickOnCk12ImageIconAgain() {
        if (iconCk12ImageAgain.isElementPresent()) {
            iconCk12ImageAgain.clickJScript();
            reportLog("clicked on Ck12 Image Icon Again");
        }
    }

    public boolean verifyCreateNewClassLink() {
        waitForSec(5);
        return linkCreateNewClass.isElementPresent();
    }

    public boolean checkDeleteClassButtonIsNotVisible() {
        return !deleteClassButton.isElementPresent();
    }

    public boolean checkCreateAssignmentButtonIsNotVisible() {
        return !btnCreateAssignment.isElementPresent();
    }

    public boolean checkAddStudentButtonIsNotVisible() {
        return !btnAddStudent.isElementPresent();
    }

    public boolean verifyChooseButton() {
        waitForSec(5);
        return btnChoose.isElementPresent();
    }

    public void clickOnChooseButton() {
        if (btnChoose.isElementPresent()) {
            btnChoose.clickJScript();
            reportLog("clicked on Choose Button");
        }
    }

    public boolean verifyShareToClassButton() {
        waitForSec(5);
        return btnShareToClass.isElementPresent();
    }

    public void clickOnShareToClassButton() {
        if (btnShareToClass.isElementPresent()) {
            btnShareToClass.clickJScript();
            reportLog("clicked on Share To Class Button");
        }
    }

    public boolean verifyShowText() {
        waitForSec(5);
        return textShow.isElementPresent();
    }

    public boolean verifyYouDoNotOwnAnyClassText() {
        waitForSec(5);
        return textYouDoNotOwnAnyClass.isElementPresent();
    }

    public boolean verifyClassReportsText() {
        return textReports.isElementPresent();
    }

    public boolean verifyClassAdminText() {
        return textClassAdmin.isElementPresent();
    }

    public void clickOnClassMenu() {
        if (iconClassMenu.isElementPresent()) {
            iconClassMenu.clickJScript();
            reportLog("clicked on Class Menu Icon");
        }
    }

    public boolean verifyHideFromDashBoardLink() {
        waitForSec(5);
        return linkHideFromDashBoard.isElementPresent();
    }

    public void clickOnHideFromDashBoardLink() {
        if (linkHideFromDashBoard.isElementPresent()) {
            linkHideFromDashBoard.clickJScript();
            reportLog("clicked on Hide From DashBoard Link");
        }
    }

    public boolean verifyDisplayOnDashBoardLink() {
        waitForSec(5);
        return linkDisplayOnDashBoard.isElementPresent();
    }

    public boolean verifyClassNameText() {
        waitForSec(5);
        return textClassName.isElementPresent();
    }

    public boolean verifyEmailNotificationText() {
        return textEmailNotification.isElementPresent();
    }

    public void clickOnDisplayOnDashBoardLink() {
        if (linkDisplayOnDashBoard.isElementPresent()) {
            linkDisplayOnDashBoard.clickJScript();
            reportLog("clicked on Display On DashBoard Link");
        }
    }

    public boolean verifyHideFromDashBoardText() {
        waitForSec(5);
        return textHideFromDashBoard.isElementPresent();
    }

    public boolean verifyDisplayOnDashBoardText() {
        waitForSec(5);
        return textDisplayOnDashBoard.isElementPresent();
    }

    public void scrollScreen() {
        textHideFromDashBoard.scrollIntoView();
        reportLog("Successfully scroll screen through Hide From DashBoard Text");
    }

    public void scrollScreenForDisplayButton() {
        textDisplayOnDashBoard.scrollIntoView();
        reportLog("Successfully scroll screen through Display On DashBoard Text");
    }

    public boolean verifyHideButton() {
        return btnHide.isElementPresent();
    }

    public void clickOnHideButton() {
        if (btnHide.isElementPresent()) {
            btnHide.clickJScript();
            reportLog("clicked on Hide Button.");
        }
    }

    public boolean verifyDisplayButton() {
        btnDisplay.scrollIntoView();
        waitForSec(2);
        return btnDisplay.isElementPresent();
    }

    public void clickOnDisplayButton() {
        if (btnDisplay.isElementPresent()) {
            btnDisplay.clickJScript();
            reportLog("clicked on Display Button.");
        }
    }

    public boolean verifyCreateNewOneLink() {
        return linkCreateNewOne.isElementPresent();
    }

    public boolean verifyHowDoesThisWorkLink() {
        return linkHowDoesThisWork.isElementPresent();
    }

    public void clickOnCreateNewOneLink() {
        if (linkCreateNewOne.isElementPresent()) {
            linkCreateNewOne.clickJScript();
            reportLog("clicked on Create New One Link.");
        }
    }

    public boolean verifyCreateNEwClassText() {
        waitForSec(5);
        return textCreateNewClass.isElementPresent();
    }

    public boolean verifyCloseIcon() {
        return iconClose.isElementPresent();
    }

    public void clickOnCloseIcon() {
        if (iconClose.isElementPresent()) {
            iconClose.clickJScript();
            reportLog("clicked on Close Icon");
        }
    }

    public boolean verifyHiddenClassesLink() {
        //linkHiddenClasses.scrollIntoView();
        waitForSec(2);
        return linkHiddenClasses.isElementPresent();
    }

    public void clickOnHiddenClassesLink() {
        if (linkHiddenClasses.isElementPresent()) {
            linkHiddenClasses.selectByVisibleText("Hidden Classes");
            reportLog("clicked on link Hidden nClasses");
        }
    }

    public boolean verifyCurrentClassesLink() {
        return linkCurrentClasses.isElementPresent();
    }

    public void clickOnCurrentClassesLink() {
        if (linkCurrentClasses.isElementPresent()) {
            linkCurrentClasses.clickJScript();
            reportLog("clicked on link Current nClasses");
        }
    }
}