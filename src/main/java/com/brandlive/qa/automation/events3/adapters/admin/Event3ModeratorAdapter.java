package com.brandlive.qa.automation.events3.adapters.admin;

import com.brandlive.qa.automation.events3.pages.admin.moderatorsetting.AddAnnouncement;
import com.brandlive.qa.automation.events3.pages.admin.moderatorsetting.Moderator;
import com.brandlive.qa.automation.utils.Doer;

public class Event3ModeratorAdapter extends Doer {

    Moderator moderator = new Moderator();
    AddAnnouncement addAnnouncement = new AddAnnouncement();

    public void clickOnEventDetailsLink() {
        moderator.clickOnDetailsLink();
    }

    public void clickOnModeratorButton() {
        moderator.clickOnModeratorButton();
    }

    public void addAnnouncement(String announcementTO, String aMessage) {
        moderator.clickOnAddButton();
        moderator.clickOnAddAnnouncementButton();
        addAnnouncement.addAnnouncement(announcementTO, aMessage);
    }

    public void verifyMessageOnModerator(String message) {
        moderator.verifyMessage(message);
    }

    public void approveChatOnModerator(String chatMessage) {
        moderator.approveChatMessage(chatMessage);
    }

    public void verifyApprovalIcon(String message, String moderationAction) {
        moderator.verifyApproveIcon(message, moderationAction);
    }

    public void clickOnEditEventButton() {
        moderator.clickOnEditEventButton();
    }

    public void closeModeratorAutoSignInPopUP() {
        moderator.closeModeratorAutoSignInPopUP();
    }
}