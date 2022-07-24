package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

public class CafeForumUIFeature extends BasePage {

    private final GuiControl textSortedBy = new GuiControl(getElementMap().get("textSortedBy"), webDriver);
    private final GuiControl dropDownSortedBy = new GuiControl(getElementMap().get("dropDownSortedBy"), webDriver);
    private final GuiControl linkNewest = new GuiControl(getElementMap().get("linkNewest"), webDriver);
    private final GuiControl linkUnAnswered = new GuiControl(getElementMap().get("linkUnAnswered"), webDriver);
    private final GuiControl linkPopular = new GuiControl(getElementMap().get("linkPopular"), webDriver);
    private final GuiControl linkQuestionOfTheWeek = new GuiControl(getElementMap().get("linkQuestionOfTheWeek"), webDriver);
    private final GuiControl textSelectedFilter = new GuiControl(getElementMap().get("textSelectedFilter"), webDriver);
    private final GuiControl linkSeeAnswer = new GuiControl(getElementMap().get("linkSeeAnswer"), webDriver);
    private final GuiControl linkBeTheFirstToAnswer = new GuiControl(getElementMap().get("linkBeTheFirstToAnswer"), webDriver);
    private final GuiControl btnAskQuestion = new GuiControl(getElementMap().get("btnAskQuestion"), webDriver);
    private final GuiControl btnPost = new GuiControl(getElementMap().get("btnPost"), webDriver);
    private final GuiControl iconCloseQuestionContainer = new GuiControl(getElementMap().get("iconCloseQuestionContainer"), webDriver);
    private final GuiControl btnFollow = new GuiControl(getElementMap().get("btnFollow"), webDriver);
    private final GuiControl btnFollowing = new GuiControl(getElementMap().get("btnFollowing"), webDriver);
    private final GuiControl textWriteYourQuestion = new GuiControl(getElementMap().get("textWriteYourQuestion"), webDriver);
    private final GuiControl placeHolderTag = new GuiControl(getElementMap().get("placeHolderTag"), webDriver);
    private final GuiControl linkShare = new GuiControl(getElementMap().get("linkShare"), webDriver);
    private final GuiControl linkSetting = new GuiControl(getElementMap().get("linkSetting"), webDriver);
    private final GuiControl textShareThisDiscussion = new GuiControl(getElementMap().get("textShareThisDiscussion"), webDriver);
    private final GuiControl btnSend = new GuiControl(getElementMap().get("btnSend"), webDriver);
    private final GuiControl iconCloseShare = new GuiControl(getElementMap().get("iconCloseShare"), webDriver);
    private final GuiControl textEmptyError = new GuiControl(getElementMap().get("textEmptyError"), webDriver);
    private final GuiControl placeHolderEmail = new GuiControl(getElementMap().get("placeHolderEmail"), webDriver);
    private final GuiControl textThanks = new GuiControl(getElementMap().get("textThanks"), webDriver);
    private final GuiControl btnDone = new GuiControl(getElementMap().get("btnDone"), webDriver);
    private final GuiControl btnBack = new GuiControl(getElementMap().get("btnBack"), webDriver);
    private final GuiControl textEmailNotification = new GuiControl(getElementMap().get("textEmailNotification"), webDriver);
    private final GuiControl linkFollowers = new GuiControl(getElementMap().get("linkFollowers"), webDriver);
    private final GuiControl linkInviteFollower = new GuiControl(getElementMap().get("linkInviteFollower"), webDriver);
    private final GuiControl textWantToFollow = new GuiControl(getElementMap().get("textWantToFollow"), webDriver);
    private final GuiControl btnDonNotFollow = new GuiControl(getElementMap().get("btnDonNotFollow"), webDriver);
    private final GuiControl btnYesFollow = new GuiControl(getElementMap().get("btnYesFollow"), webDriver);
    private final GuiControl linkBrowseDiscussion = new GuiControl(getElementMap().get("linkBrowseDiscussion"), webDriver);

    public CafeForumUIFeature(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public boolean verifySortedByText() {
        return textSortedBy.isElementPresent();
    }

    public boolean verifySortedByDropDown() {
        waitForSec(5);
        return dropDownSortedBy.isElementPresent();
    }

    public void clickOnSortedByDropDown() {
        if (dropDownSortedBy.isElementPresent()) {
            dropDownSortedBy.clickJScript();
            reportLog("Successfully click On Sorted By DropDown");
        }
    }

    public boolean verifyNewestLink() {
        return linkNewest.isElementPresent();
    }

    public void clickOnNewestLink() {
        if (linkNewest.isElementPresent()) {
            linkNewest.clickJScript();
            reportLog("Successfully click On Newest Link");
        }
    }

    public boolean verifyUnAnsweredLink() {
        return linkUnAnswered.isElementPresent();
    }

    public void clickOnUnAnsweredLink() {
        if (linkUnAnswered.isElementPresent()) {
            linkUnAnswered.clickJScript();
            reportLog("Successfully click On Un Answered Link");
        }
    }

    public boolean verifyPopularLink() {
        return linkPopular.isElementPresent();
    }

    public void clickOnUnPopularLink() {
        if (linkPopular.isElementPresent()) {
            linkPopular.clickJScript();
            reportLog("Successfully click On Popular Link");
        }
    }

    public boolean verifyQuestionOfTheWeekLink() {
        return linkQuestionOfTheWeek.isElementPresent();
    }

    public void clickOnUnQuestionOfTheWeekrLink() {
        if (linkQuestionOfTheWeek.isElementPresent()) {
            linkQuestionOfTheWeek.clickJScript();
            reportLog("Successfully click On QuestionOfTheWeek Link");
        }
    }

    public boolean verifyNewestFilterIsSelected() {
        return ("Newest").equalsIgnoreCase(textSelectedFilter.getText());
    }

    public boolean verifyUnAnsweredFilterIsSelected() {
        return ("Unanswered").equalsIgnoreCase(textSelectedFilter.getText());
    }

    public boolean verifyPopularFilterIsSelected() {
        return ("Popular").equalsIgnoreCase(textSelectedFilter.getText());
    }

    public boolean verifyQuestionOfTheWeekFilterIsSelected() {
        return ("Question of the week").equalsIgnoreCase(textSelectedFilter.getText());
    }

    public boolean verifyQuestionOfTheWeekFilterDataIsDisplay() {
        return linkSeeAnswer.isElementPresent();
    }

    public boolean verifyUnAnsweredFilterDataIsDisplay() {
        return linkBeTheFirstToAnswer.isElementPresent();
    }

    public boolean verifyFollowButton() {
        return btnFollow.isElementPresent();
    }

    public void clickOnFollowButton() {
        if (btnFollow.isElementPresent()) {
            btnFollow.clickJScript();
            reportLog("Successfully click On Follow Button");
        }
    }

    public boolean verifyFollowingButton() {
        waitForSec(5);
        return btnFollowing.isElementPresent();
    }

    public void clickOnFollowingButton() {
        if (btnFollowing.isElementPresent()) {
            btnFollowing.clickJScript();
            reportLog("Successfully click On Following Button");
        }
    }

    public boolean verifyAskQuestionButton() {
        return btnAskQuestion.isElementPresent();
    }

    public void clickOnAskQuestionButton() {
        if (btnAskQuestion.isElementPresent()) {
            btnAskQuestion.clickJScript();
            reportLog("Successfully click On Ask Question Button");
        }
    }

    public boolean verifyPostButton() {
        return btnPost.isElementPresent();
    }

    public void clickOnPostButton() {
        if (btnPost.isElementPresent()) {
            btnPost.clickJScript();
            reportLog("Successfully click On Post Button");
        }
    }

    public boolean verifyCloseQuestionContainerIcon() {
        waitForSec(5);
        return iconCloseQuestionContainer.isElementPresent();
    }

    public void clickOnCloseQuestionContainerIcon() {
        if (iconCloseQuestionContainer.isElementPresent()) {
            iconCloseQuestionContainer.clickJScript();
            reportLog("Successfully click On Close Question Container Icon");
        }
    }

    public void scrollTheScreen() {
        btnAskQuestion.scrollIntoView();
        reportLog("Successfully Scroll The Screen");
    }

    public boolean verifyWriteYourQuestionText() {
        return textWriteYourQuestion.isElementPresent();
    }

    public boolean verifyTagPlaceHolder() {
        return placeHolderTag.isElementPresent();
    }

    public void setTextInTagPlaceHolder() {
        String text = "ABC";
        if (placeHolderTag.isElementPresent()) {
            placeHolderTag.setText(text);
            reportLog("Successfully Set Tag On Tag Place Holder");
        }
    }

    public void scrollTheScreenAtTop() {
        btnFollowing.scrollIntoView();
        reportLog("Successfully Scroll The Screen");
    }

    public boolean verifyShareLink() {
        return linkShare.isElementPresent();
    }

    public void clickOnShareLink() {
        waitForSec(10);
        if (linkShare.isElementPresent()) {
            linkShare.clickJScript();
            linkShare.clickJScript();
            reportLog("Successfully click On Share Link");
        }
    }

    public boolean verifySettingLink() {
        return linkSetting.isElementPresent();
    }

    public void clickOnSettingLink() {
        if (linkSetting.isElementPresent()) {
            linkSetting.clickJScript();
            reportLog("Successfully click On Setting Link");
        }
    }

    public boolean verifyShareThisDiscussionText() {
        waitForSec(5);
        return textShareThisDiscussion.isElementPresent();
    }

    public boolean verifySendButton() {
        return btnSend.isElementPresent();
    }

    public void clickOnSendButton() {
        if (btnSend.isElementPresent()) {
            btnSend.clickJScript();
            reportLog("Successfully click On Send Button");
        }
    }

    public boolean verifyEmptyErrorText() {
        waitForSec(5);
        return textEmptyError.isElementPresent();
    }

    public boolean verifyCloseShareIcon() {
        return iconCloseShare.isElementPresent();
    }

    public void clickOnCloseShareIcon() {
        if (iconCloseShare.isElementPresent()) {
            iconCloseShare.clickJScript();
            reportLog("Successfully click On Close Share Icon");
        }
    }

    public boolean verifyEmailPlaceHolder() {
        return placeHolderEmail.isElementPresent();
    }

    public void setTextInEmailPlaceHolder() {
        String text = "teacher+testuser@ck12.org";
        if (placeHolderEmail.isElementPresent()) {
            placeHolderEmail.setText(text);
            reportLog("Successfully Set Email in  Email Place Holder");
        }
    }

    public boolean verifyThanksText() {
        waitForSec(5);
        return textThanks.isElementPresent();
    }

    public boolean verifyDoneButton() {
        return btnDone.isElementPresent();
    }

    public void clickOnDoneButton() {
        if (btnDone.isElementPresent()) {
            btnDone.clickJScript();
            reportLog("Successfully click On Done Button");
        }
    }

    public boolean verifyEmailNotificationText() {
        waitForSec(5);
        return textEmailNotification.isElementPresent();
    }

    public boolean verifyBackButton() {
        return btnBack.isElementPresent();
    }

    public void clickOnBackButton() {
        if (btnBack.isElementPresent()) {
            btnBack.clickJScript();
            reportLog("Successfully click On Back Button");
        }
    }

    public boolean verifyFollowersLink() {
        return linkFollowers.isElementPresent();
    }

    public void clickOnFollowersLink() {
        if (linkFollowers.isElementPresent()) {
            linkFollowers.clickJScript();
            reportLog("Successfully click On Followers Link");
        }
    }

    public boolean verifyInviteFriendLink() {
        return linkInviteFollower.isElementPresent();
    }

    public void clickOnInviteFriendLink() {
        if (linkInviteFollower.isElementPresent()) {
            linkInviteFollower.clickJScript();
            reportLog("Successfully click On Invite Friend Link");
        }
    }

    public boolean verifyWantToFollowText() {
        waitForSec(5);
        return textWantToFollow.isElementPresent();
    }

    public boolean verifyBrowseDiscussionLink() {
        return linkBrowseDiscussion.isElementPresent();
    }

    public void clickOnBrowseDiscussionLink() {
        if (linkBrowseDiscussion.isElementPresent()) {
            linkBrowseDiscussion.clickJScript();
            reportLog("Successfully click On Browse Discussion Link");
        }
    }

    public boolean verifyYesFollowButton() {
        return btnYesFollow.isElementPresent();
    }

    public void clickOnYesFollowButton() {
        if (btnYesFollow.isElementPresent()) {
            btnYesFollow.clickJScript();
            reportLog("Successfully click On Yes Follow Button");
        }
    }

    public boolean verifyDoNotFollowButton() {
        return btnDonNotFollow.isElementPresent();
    }

    public void clickOnDoNotFollowButton() {
        if (btnDonNotFollow.isElementPresent()) {
            btnDonNotFollow.clickJScript();
            reportLog("Successfully click On Do Not Follow Button");
        }
    }
}