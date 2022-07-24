package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.GuiControl;

public class ProtectedClassFeature extends PageMenuTab {
    private static final Logger logger = Logger.getLogger(ProtectedClassFeature.class);

    private final GuiControl linkView = new GuiControl(getElementMap().get("linkView"), webDriver);
    private final GuiControl linkAddStudent = new GuiControl(getElementMap().get("linkAddStudent"), webDriver);
    private final GuiControl textUserName = new GuiControl(getElementMap().get("textUserName"), webDriver);
    private final GuiControl linkAddStudentWithoutEmail = new GuiControl(getElementMap().get("linkAddStudentWithoutEmail"), webDriver);
    private final GuiControl iconCloseModel = new GuiControl(getElementMap().get("iconCloseModel"), webDriver);
    private final GuiControl linkCopyClassCode = new GuiControl(getElementMap().get("linkCopyClassCode"), webDriver);
    private final GuiControl textCopied = new GuiControl(getElementMap().get("textCopied"), webDriver);
    private final GuiControl switchYesOrNo = new GuiControl(getElementMap().get("switchYesOrNo"), webDriver);
    private final GuiControl textClassCode = new GuiControl(getElementMap().get("textClassCode"), webDriver);
    private final GuiControl placeHolderClassCode = new GuiControl(getElementMap().get("placeHolderClassCode"), webDriver);
    private final GuiControl textCodeOfClass = new GuiControl(getElementMap().get("textCodeOfClass"), webDriver);
    private final GuiControl linkRecentClassActivity = new GuiControl(getElementMap().get("linkRecentClassActivity"), webDriver);

    public ProtectedClassFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyRecentClassActivityLink() {
        waitForSec(7);
        return linkRecentClassActivity.isElementPresent();
    }

    public boolean verifyClassCodeIsDisplayBelowClassName() {
        return textCodeOfClass.isElementPresent();
    }

    public boolean verifyClassCodeIsNotDisplayBelowClassName() {
        try {
            if (textCodeOfClass.isDisplayed()) {
                reportLog("Class Code Is Display");
                return true;
            } else {
                reportLog("Class Code Is Not Display");
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return false;
    }

    public boolean verifyViewLink() {
        waitForSec(7);
        return linkView.isElementPresent();
    }

    public void clickOnViewLink() {
        if (linkView.isElementPresent()) {
            linkView.clickJScript();
            reportLog("Successfully clicked On View Link");
        }
    }

    public boolean verifyAddStudentLink() {
        return linkAddStudent.isElementPresent();
    }

    public void clickOnAddStudentLink() {
        if (linkAddStudent.isElementPresent()) {
            linkAddStudent.clickJScript();
            reportLog("Successfully clicked On Add Student Link");
        }
    }

    public boolean verifyUserNameText() {
        waitForSec(5);
        return textUserName.isElementPresent();
    }

    public boolean verifyAddStudentWithoutLink() {
        waitForSec(5);
        return linkAddStudentWithoutEmail.isElementPresent();
    }

    public boolean verifyCloseModelIcon() {
        waitForSec(4);
        return iconCloseModel.isElementPresent();
    }

    public void clickOnCloseModelIcon() {
        if (iconCloseModel.isElementPresent()) {
            iconCloseModel.clickJScript();
            reportLog("Successfully clicked On Close Model Icon");
        }
    }

    public boolean verifyCopyClassCodeLink() {
        return linkCopyClassCode.isElementPresent();
    }

    public void clickOnCopyClassCodeLink() {
        if (linkCopyClassCode.isElementPresent()) {
            linkCopyClassCode.clickJScript();
            reportLog("Successfully clicked On Copy Class Code link");
        }
    }

    public boolean verifyCopiedText() {
        return textCopied.isElementPresent();
    }

    public boolean verifyYesOrNoSwitch() {
        waitForSec(4);
        return switchYesOrNo.isElementPresent();
    }

    public void clickOnNoSwitch() {
        try {
            waitForSec(2);
            if (linkCopyClassCode.isDisplayed()) {
                reportLog("No need Click on Yes Switch");
            } else {
                switchYesOrNo.clickJScript();
                reportLog("Successfully Click on Yes Switch");
            }
        } catch (Exception e) {
            logger.info(e);
        }
    }

    public void clickOnYesSwitch() {
        try {
            waitForSec(3);
            linkCopyClassCode.isDisplayed();
            switchYesOrNo.clickJScript();
            reportLog("Successfully Click on Yes Switch");

        } catch (Exception e) {
            logger.info(e);
            reportLog("No need Click on Yes Switch");
        }
    }

    public boolean verifyClassCodeText() {
        return textClassCode.isElementPresent();
    }

    public boolean verifyClassCodePlaceHolder() {
        return placeHolderClassCode.isElementPresent();
    }

    public void pasteCopiedClassCodeInPlaceHolder() {
        if (placeHolderClassCode.isElementPresent()) {
            placeHolderClassCode.clickJScript();
            reportLog("Successfully clicked On Copy Class Code link");
            placeHolderClassCode.sendKeys(Keys.chord(Keys.CONTROL + "v"));
            reportLog("Successfully Paste copied text");
        }
    }
}