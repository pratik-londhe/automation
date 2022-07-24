package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class JoinClass extends BasePage {
    private static final Logger logger = Logger.getLogger(JoinClass.class);

    private final GuiControl iconMoreOption = new GuiControl(getElementMap().get("iconMoreOption"), webDriver);
    private final GuiControl linkRemoveFromClass = new GuiControl(getElementMap().get("linkRemoveFromClass"), webDriver);
    private final GuiControl btnRemove = new GuiControl(getElementMap().get("btnRemove"), webDriver);
    private final GuiControl btnAddStudent = new GuiControl(getElementMap().get("btnAddStudent"), webDriver);
    private final GuiControl btnJoinClass = new GuiControl(getElementMap().get("btnJoinClass"), webDriver);
    private final GuiControl textJoinAClass = new GuiControl(getElementMap().get("textJoinAClass"), webDriver);
    private final GuiControl txtEmptyError = new GuiControl(getElementMap().get("txtEmptyError"), webDriver);
    private final GuiControl txtWrongError = new GuiControl(getElementMap().get("txtWrongError"), webDriver);
    private final GuiControl placeHolderClassCode = new GuiControl(getElementMap().get("placeHolderClassCode"), webDriver);

    public JoinClass(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void setValueInCassCodePlaceHolder(String classCode) {
        if (placeHolderClassCode.isElementPresent()) {
            placeHolderClassCode.setText(classCode);
            reportLog("Successfully Set Value In Class Code PlaceHolder");
        }
    }

    public boolean verifyEmptyErrorText() {
        waitForSec(2);
        return txtEmptyError.isElementPresent();
    }

    public boolean verifyWrongErrorText() {
        waitForSec(2);
        return txtWrongError.isElementPresent();
    }

    public boolean verifyJoinClassButton() {
        waitForSec(5);
        return btnJoinClass.isElementPresent();
    }

    public void clickOnJoinClassButton() {
        if (btnJoinClass.isElementPresent()) {
            btnJoinClass.clickJScript();
            reportLog("Successfully click On Join Class Button");
        }
    }

    public boolean verifyAddStudentButton() {
        waitForSec(5);
        return btnAddStudent.isElementPresent();
    }

    public boolean verifyJoinAClassText() {
        return textJoinAClass.isElementPresent();
    }

    public boolean verifyMoreOptionIcon() {
        waitForSec(5);
        return iconMoreOption.isElementPresent();
    }

    public void clickOnMoreOptionIcon() {
        if (iconMoreOption.isElementPresent()) {
            iconMoreOption.clickJScript();
            reportLog("Successfully click On More Option Icon");
        }
    }

    public boolean verifyRemoveFromClassLink() {
        waitForSec(5);
        return linkRemoveFromClass.isElementPresent();
    }

    public void clickOnRemoveFromClassLink() {
        if (linkRemoveFromClass.isElementPresent()) {
            linkRemoveFromClass.clickJScript();
            reportLog("Successfully click On Remove From Class Link");
        }
    }

    public boolean verifyRemoveButton() {
        waitForSec(5);
        return btnRemove.isElementPresent();
    }

    public void clickOnRemoveButton() {
        if (btnRemove.isElementPresent()) {
            btnRemove.clickJScript();
            reportLog("Successfully click On Remove Button");
        }
    }
}