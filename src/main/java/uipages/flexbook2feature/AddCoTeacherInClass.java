package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GuiControl;

import java.util.List;

public class AddCoTeacherInClass extends PageMenuTab {
    private int countBefore;
    private int countAfter;
    private int countBeforeJoin;
    private int countAfterJoin;

    private final GuiControl dropdownForCoTeacher = new GuiControl(getElementMap().get("dropdownForCoTeacher"), webDriver);
    private final GuiControl linkHowToAddCoTeacher = new GuiControl(getElementMap().get("linkHowToAddCoTeacher"), webDriver);
    private final GuiControl btnOk = new GuiControl(getElementMap().get("btnOk"), webDriver);
    private final GuiControl linkMakeCoTeacher = new GuiControl(getElementMap().get("linkMakeCoTeacher"), webDriver);
    private final GuiControl linkRemoveFromClass = new GuiControl(getElementMap().get("linkRemoveFromClass"), webDriver);
    private final GuiControl dropDownPlus = new GuiControl(getElementMap().get("dropDownPlus"), webDriver);
    private final GuiControl btnJoinClass = new GuiControl(getElementMap().get("btnJoinClass"), webDriver);
    private final GuiControl btnJoin = new GuiControl(getElementMap().get("btnJoin"), webDriver);
    private final GuiControl btnJoinCancel = new GuiControl(getElementMap().get("btnJoinCancel"), webDriver);
    private final GuiControl placeHolderClassCode = new GuiControl(getElementMap().get("placeHolderClassCode"), webDriver);
    private final GuiControl btnClose = new GuiControl(getElementMap().get("btnClose"), webDriver);
    private final GuiControl iconProfile = new GuiControl(getElementMap().get("iconProfile"), webDriver);
    private final GuiControl txtErrorMessage = new GuiControl(getElementMap().get("txtErrorMessage"), webDriver);
    private final GuiControl txtCodeNotMatch = new GuiControl(getElementMap().get("txtCodeNotMatch"), webDriver);
    private final GuiControl btnRemove = new GuiControl(getElementMap().get("btnRemove"), webDriver);
    private final GuiControl btnCancel = new GuiControl(getElementMap().get("btnCancel"), webDriver);
    private final GuiControl linkRemoveCoTeacher = new GuiControl(getElementMap().get("linkRemoveCoTeacher"), webDriver);
    private final GuiControl txtTeacher = new GuiControl(getElementMap().get("txtTeacher"), webDriver);

    public AddCoTeacherInClass(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyPlusDropDown() {
        waitForSec(5);
        dropDownPlus.scrollIntoView();
        return dropDownPlus.isElementPresent();
    }

    public void clickOnPlusDropDown() {
        if (dropDownPlus.isElementPresent()) {
            dropDownPlus.clickJScript();
            reportLog("Successfully clicked On DropDown Plus");
        }
    }

    public boolean verifyJoinClassButton() {
        return btnJoinClass.isElementPresent();
    }

    public void clickOnJoinClassButton() {
        if (btnJoinClass.isElementPresent()) {
            btnJoinClass.mouseHover();
            btnJoinClass.clickJScript();
            reportLog("Successfully clicked On Join Class Button");
        }
    }

    public boolean verifyCloseButton() {
        return btnClose.isElementPresent();
    }

    public void clickOnCloseButton() {
        if (btnClose.isElementPresent()) {
            btnClose.clickJScript();
            reportLog("Successfully clicked On Close Button");
        }
    }

    public boolean verifyJoinButton() {
        waitForSec(5);
        return btnJoin.isElementPresent();
    }

    public void clickOnJoinButton() {
        if (btnJoin.isElementPresent()) {
            btnJoin.clickJScript();
            reportLog("Successfully clicked On Join Button");
        }
        waitForSec(5);
    }

    public boolean verifyJoinCancelButton() {
        return btnJoinCancel.isElementPresent();
    }

    public void clickOnJoinCancelButton() {
        if (btnJoinCancel.isElementPresent()) {
            btnJoinCancel.clickJScript();
            reportLog("Successfully clicked On Join Cancel Button");
        }
    }

    public void clickOnClassCodePlaceHolder(String classCode) {
        if (placeHolderClassCode.isElementPresent()) {
            placeHolderClassCode.setText(classCode);
            reportLog("Successfully Set Value in Class Code PlaceHolder");
        }
    }

    public boolean verifyErrorText() {
        return txtErrorMessage.isElementPresent();
    }

    public boolean verifyAccessCodeNotMatchPopUp() {
        waitForSec(5);
        return txtCodeNotMatch.isElementPresent();
    }

    public void getCountOfTotalNumberOfClassBefore() {
        List<WebElement> names3 = webDriver.findElements(By.xpath("//div[@class='scss-components-GroupCard__headerTitles___Nls9A']//a//span"));
        countBeforeJoin = names3.size();
        reportLog("Total Number Of Members Count Before Is = " + countBeforeJoin);
    }

    public void getCountOfTotalNumberOfClassAfter() {
        waitForSec(5);
        List<WebElement> names4 = webDriver.findElements(By.xpath("//div[@class='scss-components-GroupCard__headerTitles___Nls9A']//a//span"));
        countAfterJoin = names4.size();
        reportLog("Total Number Of Members  Count After Is = " + countAfterJoin);
    }

    public boolean verifyCountOfClassesAfterCancel() {
        return countBeforeJoin == countAfterJoin;
    }

    public boolean verifyCountOfClassesAfterJoin() {
        return countBeforeJoin != countAfterJoin;
    }

    public void getTextOfTeacherName() {
        if (iconProfile.isElementPresent()) {
            reportLog("Successfully Get Text Of Teacher Name and Teacher Name is = " + iconProfile.getText());
        }
    }

    public boolean verifyLinkHowToAddCoTeacher() {
        waitForSec(5);
        return linkHowToAddCoTeacher.isElementPresent();
    }

    public void clickOnHoWToAddCoTeacherLink() {
        if (linkHowToAddCoTeacher.isElementPresent()) {
            linkHowToAddCoTeacher.clickJScript();
            reportLog("Successfully clicked On How To Add CoTeacher Link");
        }
    }

    public boolean verifyOkButton() {
        waitForSec(5);
        btnOk.scrollIntoView();
        return btnOk.isElementPresent();
    }

    public void clickOnOkButton() {
        if (btnOk.isElementPresent()) {
            btnOk.clickJScript();
            reportLog("Successfully clicked On Ok Button");
        }
    }

    public void clickOnMoreOptionDropDown() {
        waitForSec(5);
        dropdownForCoTeacher.clickJScript();
        reportLog("Successfully clicked On More DropDown Option");
        waitForSec(5);
    }

    public boolean verifyMakeCoTeacherLink() {
        waitForSec(5);
        return linkMakeCoTeacher.isElementPresent();
    }

    public void clickOnMakeCoTeacherLink() {
        if (linkMakeCoTeacher.isElementPresent()) {
            linkMakeCoTeacher.clickJScript();
            reportLog("Successfully clicked On Link Make CoTeacher");
        }
        waitForSec(5);
    }

    public boolean verifyRemoveFromClassLink() {
        return linkRemoveFromClass.isElementPresent();
    }

    public void clickOnRemoveFromClassLink() {
        waitForSec(5);
        if (linkRemoveFromClass.isElementPresent()) {
            linkRemoveFromClass.clickJScript();
            reportLog("Successfully click On Link Remove From Class");
        }
    }

    public void getCountOfTotalMembersInClassBefore() {
        List<WebElement> names1 = webDriver.findElements(By.xpath("//span[@class='ie8text']"));
        countBefore = names1.size();
        reportLog("Total Number Of Members  Count Before Is = " + countBefore);
    }

    public void getCountOfTotalMembersInClassAfter() {
        waitForSec(5);
        List<WebElement> names2 = webDriver.findElements(By.xpath("//span[@class='ie8text']"));
        countAfter = names2.size();
        reportLog("Total Number Of Members Count After Is = " + countAfter);
    }

    public boolean verifyCountOfMembersAfterCancel() {
        return countBefore == countAfter;
    }

    public boolean verifyCountOfMembersAfterRemove() {
        return countBefore != countAfter;
    }

    public boolean verifyRemoveButton() {
        waitForSec(5);
        return btnRemove.isElementPresent();
    }

    public void clickOnRemoveButton() {
        if (btnRemove.isElementPresent()) {
            btnRemove.clickJScript();
            reportLog("Successfully clicked On Remove Button");
        }
    }

    public boolean verifyCancelButton() {
        return btnCancel.isElementPresent();
    }

    public void clickOnCancelButton() {
        if (btnCancel.isElementPresent()) {
            btnCancel.clickJScript();
            reportLog("Successfully clicked On  Cancel Button");
        }
    }

    public void scrollScreen() {
        linkHowToAddCoTeacher.scrollIntoView();
    }

    public void clickOnRemoveCoTeacherLink() {
        if (linkRemoveCoTeacher.isElementPresent()) {
            linkRemoveCoTeacher.clickJScript();
            reportLog("Successfully clicked On Remove CoTeacher Link");
        }
    }

    public boolean verifyRemoveCoTeacherLink() {
        return linkRemoveCoTeacher.isElementPresent();
    }

    public boolean verifyTeachersText() {
        waitForSec(5);
        return txtTeacher.isElementPresent();
    }
}