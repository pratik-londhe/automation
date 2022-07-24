package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class StudentSettingPage extends BasePage {

    private final GuiControl textInstantNotification = new GuiControl(getElementMap().get("textInstantNotification"), webDriver);
    private final GuiControl textAllClassPosts = new GuiControl(getElementMap().get("textAllClassPosts"), webDriver);
    private final GuiControl switcherAssignment = new GuiControl(getElementMap().get("switcherAssignment"), webDriver);
    private final GuiControl switcherEmailNotification = new GuiControl(getElementMap().get("switcherEmailNotification"), webDriver);
    private final GuiControl linkTONForAssignment = new GuiControl(getElementMap().get("linkTONForAssignment"), webDriver);
    private final GuiControl linkTONForEmailNotification = new GuiControl(getElementMap().get("linkTONForEmailNotification"), webDriver);
    private final GuiControl iconEditAsgNotification = new GuiControl(getElementMap().get("iconEditAsgNotification"), webDriver);
    private final GuiControl btnCloseEAN = new GuiControl(getElementMap().get("btnCloseEAN"), webDriver);
    private final GuiControl checkBoxInstantly = new GuiControl(getElementMap().get("checkBoxInstantly"), webDriver);
    private final GuiControl checkBoxWeekly = new GuiControl(getElementMap().get("checkBoxWeekly"), webDriver);
    private final GuiControl checkBoxDigestEveryDay = new GuiControl(getElementMap().get("checkBoxDigestEveryDay"), webDriver);
    private final GuiControl textWeeklyDigest = new GuiControl(getElementMap().get("textWeeklyDigest"), webDriver);
    private final GuiControl textDigestInEvery6Hours = new GuiControl(getElementMap().get("textDigestInEvery6Hours"), webDriver);
    private final GuiControl textDigestInEvery12Hours = new GuiControl(getElementMap().get("textDigestInEvery12Hours"), webDriver);
    private final GuiControl dropDownHours = new GuiControl(getElementMap().get("dropDownHours"), webDriver);
    private final GuiControl link12Hours = new GuiControl(getElementMap().get("link12Hours"), webDriver);
    private final GuiControl link24Hours = new GuiControl(getElementMap().get("link24Hours"), webDriver);
    private final GuiControl textDigestInEvery24Hours = new GuiControl(getElementMap().get("textDigestInEvery24Hours"), webDriver);
    private final GuiControl link6Hours = new GuiControl(getElementMap().get("link6Hours"), webDriver);
    private final GuiControl iconEditQANotification = new GuiControl(getElementMap().get("iconEditQANotification"), webDriver);
    private final GuiControl btnCloseEQN = new GuiControl(getElementMap().get("btnCloseEQN"), webDriver);
    private final GuiControl checkBoxAllClassPost = new GuiControl(getElementMap().get("checkBoxAllClassPost"), webDriver);
    private final GuiControl checkBoxMyPost = new GuiControl(getElementMap().get("checkBoxMyPost"), webDriver);
    private final GuiControl chkInstantly = new GuiControl(getElementMap().get("chkInstantly"), webDriver);
    private final GuiControl chkWeekly = new GuiControl(getElementMap().get("chkWeekly"), webDriver);
    private final GuiControl chkDigestEvery = new GuiControl(getElementMap().get("chkDigestEvery"), webDriver);
    private final GuiControl textWeeklyDigestAllClassPost = new GuiControl(getElementMap().get("textWeeklyDigestAllClassPost"), webDriver);
    private final GuiControl txtDigestIn6HoursAllPosts = new GuiControl(getElementMap().get("txtDigestIn6HoursAllPosts"), webDriver);
    private final GuiControl txtDigestIn12HoursAllPosts = new GuiControl(getElementMap().get("txtDigestIn12HoursAllPosts"), webDriver);
    private final GuiControl txtDigestIn24HoursAllPosts = new GuiControl(getElementMap().get("txtDigestIn24HoursAllPosts"), webDriver);
    private final GuiControl hoursDropDown = new GuiControl(getElementMap().get("hoursDropDown"), webDriver);
    private final GuiControl LinkHours12 = new GuiControl(getElementMap().get("LinkHours12"), webDriver);
    private final GuiControl LinkHours6 = new GuiControl(getElementMap().get("LinkHours6"), webDriver);
    private final GuiControl LinkHours24 = new GuiControl(getElementMap().get("LinkHours24"), webDriver);
    private final GuiControl textDigestMyPostEvery12Hours = new GuiControl(getElementMap().get("textDigestMyPostEvery12Hours"), webDriver);
    private final GuiControl textDigestMyPostEvery6Hours = new GuiControl(getElementMap().get("textDigestMyPostEvery6Hours"), webDriver);
    private final GuiControl textWeeklyDigestMyPost = new GuiControl(getElementMap().get("textWeeklyDigestMyPost"), webDriver);
    private final GuiControl textInstantlyMyPost = new GuiControl(getElementMap().get("textInstantlyMyPost"), webDriver);

    public StudentSettingPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifyWeeklyDigestAllClassPostText(){
        return textWeeklyDigestAllClassPost.isElementPresent();
    }

    public boolean verifyDigestIn6HoursAllPostsText(){
        return txtDigestIn6HoursAllPosts.isElementPresent();
    }

    public boolean verifyDigestIn12HoursAllPostsText(){
        return txtDigestIn12HoursAllPosts.isElementPresent();
    }

    public boolean verifyDigestIn24HoursAllPostsText(){
        return txtDigestIn24HoursAllPosts.isElementPresent();
    }

    public boolean verifyDigestIn12HoursYourPostsText(){
        return textDigestMyPostEvery12Hours.isElementPresent();
    }

    public boolean verifyDigestIn6HoursYourPostsText(){
        return textDigestMyPostEvery6Hours.isElementPresent();
    }

    public boolean verifyWeeklyDigestYourPostsText(){
        return textWeeklyDigestMyPost.isElementPresent();
    }

    public boolean verifyInstantlyYourPostsText(){
        return textInstantlyMyPost.isElementPresent();
    }

    public boolean verifyCheckBoxAllClassesPost(){
        return checkBoxAllClassPost.isElementPresent();
    }

    public void clickOn12HoursLinkForQA() {
        if (LinkHours12.isElementPresent()) {
            LinkHours12.clickJScript();
            reportLog("Successfully click on 12 Hours Link");
        }
    }

    public void clickOn24HoursLinkForQA() {
        if (LinkHours24.isElementPresent()) {
            LinkHours24.clickJScript();
            reportLog("Successfully click on 24 Hours Link");
        }
    }

    public void clickOn6HoursLinkForQA() {
        if (LinkHours6.isElementPresent()) {
            LinkHours6.clickJScript();
            reportLog("Successfully click on 6 Hours Link");
        }
    }

    public void clickOnCheckBoxAllClassesPost() {
        if (checkBoxAllClassPost.isElementPresent()) {
            checkBoxAllClassPost.clickJScript();
            reportLog("Successfully click on CheckBox All Classes Post");
        }
    }

    public boolean verifyMyPostCheckBox(){
        return checkBoxMyPost.isElementPresent();
    }

    public void clickOnMyPostCheckBox() {
        if (checkBoxMyPost.isElementPresent()) {
            checkBoxMyPost.clickJScript();
            reportLog("Successfully click on My Post CheckBox");
        }
    }

    public boolean verifyInstantlyChkBox(){
        return chkInstantly.isElementPresent();
    }

    public void clickOnInstantlyChkBox() {
        if (chkInstantly.isElementPresent()) {
            chkInstantly.clickJScript();
            reportLog("Successfully click on Instantly CheckBox");
        }
    }

    public boolean verifyWeeklyChkBox(){
        return chkWeekly.isElementPresent();
    }

    public void clickOnWeeklyChkBox() {
        if (chkWeekly.isElementPresent()) {
            chkWeekly.clickJScript();
            reportLog("Successfully click on Weekly CheckBox");
        }
    }

    public boolean verifyDigestEveryDayChkBox(){
        return chkDigestEvery.isElementPresent();
    }

    public void clickOnDigestEveryDayChkBox() {
        if (chkDigestEvery.isElementPresent()) {
            chkDigestEvery.clickJScript();
            reportLog("Successfully click on Digest Every Day CheckBox");
        }
    }

    public boolean verifyInstantNotificationText(){
        return textInstantNotification.isElementPresent();
    }

    public boolean verifyAllClassPost(){
        return textAllClassPosts.isElementPresent();
    }

    public boolean verifyAssignmentSwitcher(){
        return switcherAssignment.isElementPresent();
    }

    public void clickOnAssignmentSwitcher() {
        if (switcherAssignment.isElementPresent()) {
            switcherAssignment.clickJScript();
            reportLog("Successfully click on Assignment Switcher");
        }
    }

    public void clickOn12HoursLink() {
        if (link12Hours.isElementPresent()) {
            link12Hours.clickJScript();
            reportLog("Successfully click on 12 Hours Link");
        }
    }

    public void clickOn24HoursLink() {
        if (link24Hours.isElementPresent()) {
            link24Hours.clickJScript();
            reportLog("Successfully click on 24 Hours Link");
        }
    }

    public void clickOn6HoursLink() {
        if (link6Hours.isElementPresent()) {
            link6Hours.clickJScript();
            reportLog("Successfully click on 6 Hours Link");
        }
    }

    public void clickOnHoursDropDown() {
        if (dropDownHours.isElementPresent()) {
            dropDownHours.clickJScript();
            reportLog("Successfully click on Hours DropDown");
        }
        waitForSec(5);
    }

    public void clickOnHoursDropDownForQA() {
        if (hoursDropDown.isElementPresent()) {
            hoursDropDown.clickJScript();
            reportLog("Successfully click on Hours DropDown");
        }
        waitForSec(5);
    }

    public boolean verifyEmailNotificationSwitcher(){
        return switcherEmailNotification.isElementPresent();
    }

    public void clickOnEmailNotificationSwitcher() {
        if (switcherEmailNotification.isElementPresent()) {
            switcherEmailNotification.clickJScript();
            reportLog("Successfully click on Email Notification Switcher");
        }
    }

    public boolean verifyTONForAssignmentLink(){
        return linkTONForAssignment.isElementPresent();
    }

    public void clickOnTONForAssignmentLink() {
        if (linkTONForAssignment.isElementPresent()) {
            linkTONForAssignment.clickJScript();
            reportLog("Successfully click on TON For Assignment Link");
        }
    }

    public boolean verifyTONForEmailNotificationLink(){
        return linkTONForEmailNotification.isElementPresent();
    }

    public void clickOnTONForEmailNotificationLink() {
        if (linkTONForEmailNotification.isElementPresent()) {
            linkTONForEmailNotification.clickJScript();
            reportLog("Successfully click on TON For Email Notification Link");
        }
    }

    public boolean verifyEditAssignmentNotificationIcon(){
        return iconEditAsgNotification.isElementPresent();
    }

    public void clickOnEditAssignmentNotificationIcon() {
        if (iconEditAsgNotification.isElementPresent()) {
            iconEditAsgNotification.clickJScript();
            reportLog("Successfully click on Edit Assignment Notification Icon");
        }
        waitForSec(5);
    }

    public boolean verifyEditQANotificationIcon(){
        return iconEditQANotification.isElementPresent();
    }

    public void clickOnEditQANotificationIcon() {
        if (iconEditQANotification.isElementPresent()) {
            iconEditQANotification.clickJScript();
            reportLog("Successfully click on Edit QA Notification Icon");
        }
        waitForSec(5);
    }

    public boolean verifyCloseEditAssignmentNotificationButton(){
        return btnCloseEAN.isElementPresent();
    }

    public void clickOnCloseEditAssignmentNotificationButton() {
        if (btnCloseEAN.isElementPresent()) {
            btnCloseEAN.clickJScript();
            reportLog("Successfully click on Close Edit Assignment Notification Button");
        }
    }

    public boolean verifyCloseEditQANotificationButton(){
        return btnCloseEQN.isElementPresent();
    }

    public void clickOnCloseEditQANotificationButton() {
        if (btnCloseEQN.isElementPresent()) {
            btnCloseEQN.clickJScript();
            reportLog("Successfully click on Close Edit QA Notification Button");
        }
    }

    public boolean verifyInstantlyCheckBox(){
        waitForSec(5);
        return checkBoxInstantly.isElementPresent();
    }

    public void clickOnInstantlyCheckBox() {
        if (checkBoxInstantly.isElementPresent()) {
            checkBoxInstantly.clickJScript();
            reportLog("Successfully click on Instantly CheckBox");
        }
        waitForSec(5);
    }

    public boolean verifyWeeklyCheckBox(){
        return checkBoxWeekly.isElementPresent();
    }

    public void clickOnWeeklyCheckBox() {
        if (checkBoxWeekly.isElementPresent()) {
            checkBoxWeekly.clickJScript();
            reportLog("Successfully click on Weekly CheckBox");
        }
    }

    public boolean verifyDigestEveryDayCheckBox(){
        return checkBoxDigestEveryDay.isElementPresent();
    }

    public void clickOnDigestEveryDayCheckBox() {
        if (checkBoxDigestEveryDay.isElementPresent()) {
            checkBoxDigestEveryDay.clickJScript();
            reportLog("Successfully click on Digest Every Day CheckBox");
        }
    }

    public boolean verifyWeeklyDigestText(){
        return textWeeklyDigest.isElementPresent();
    }

    public boolean verifyDigestIn6HoursText(){
        return textDigestInEvery6Hours.isElementPresent();
    }

    public boolean verifyDigestIn12HoursText(){
        return textDigestInEvery12Hours.isElementPresent();
    }

    public boolean verifyDigestIn24HoursText(){
        return textDigestInEvery24Hours.isElementPresent();
    }
}