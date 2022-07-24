package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3HomePageAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3ModeratorAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3SessionSettingAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3ChatAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3QuestionsAdapter;
import com.brandlive.qa.automation.events3.pages.live.EventLandingPage;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3ModeratorStepDefs extends StepDefs {
    Event3SessionSettingAdapter event3SessionSettingAdapter = new Event3SessionSettingAdapter();
    Event3SessionSettingAdapter event3EventAdapter = new Event3SessionSettingAdapter();
    Event3ChatAdapter event3ChatAdapter = new Event3ChatAdapter();
    Event3ModeratorAdapter event3ModeratorAdapter = new Event3ModeratorAdapter();
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3QuestionsAdapter event3QuestionsAdapter = new Event3QuestionsAdapter();
    Event3HomePageAdapter event3HomePageAdapter = new Event3HomePageAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();
    EventLandingPage eventLandingPage = new EventLandingPage();

    class RegAndChatQuestionsInfo {
        private String firstName;
        private String lastName;
        private String email;
        private String passcode;
        private String chatMessageModerationOFF;
        private String questionMessageModerationOFF;
        private String chatMessageModerationON;
        private String questionMessageModerationON;
    }

    @And("^Moderation is OFF$")
    public void moderation_is_OFF() {
        event3SessionSettingAdapter.clickOnEventTab();
        event3EventAdapter.clickOnSession();
        event3EventAdapter.clickOnSettingTab();
        event3SessionSettingAdapter.verifyModerationChatApproval("OFF");
        event3SessionSettingAdapter.verifyModerationQuestionApproval("OFF");
    }

    @And("^Add Chat and Questions during live session$")
    public void add_Chat_and_Questions_during_live_session(List<RegAndChatQuestionsInfo> Infos) {
        event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
        for (RegAndChatQuestionsInfo info : Infos) {
            log.info("Registration Chat and Questions details are - " + info.firstName + ", " + info.lastName + ", " + info.email + info.passcode + ", " + info.chatMessageModerationOFF + ", " + info.questionMessageModerationOFF + ". ");
            event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.email, info.passcode);
            eventLandingPage.clickOnTheSessionTab();
            event3ChatAdapter.sendChatMessage(info.chatMessageModerationOFF);
            event3ChatAdapter.verifyChatMessage(info.chatMessageModerationOFF, "OFF", false);
            event3QuestionsAdapter.clickOnQuestionsTab();
            event3QuestionsAdapter.enterQuestion(info.questionMessageModerationOFF);
            event3QuestionsAdapter.verifyQuestionMessage(info.questionMessageModerationOFF, "OFF", false);
        }
    }

    @And("^Check that functionality on the Moderator window when Moderation is OFF$")
    public void check_that_functionality_on_the_Moderator_window_when_Moderation_is_OFF(List<RegAndChatQuestionsInfo> Infos) {
        browser.switchToPreviousWindow();
        event3CreationAdapter.clickOnPathingHeader();
        event3HomePageAdapter.clickOnUpcomingEventTab();
        event3HomePageAdapter.searchCreatedEvent();
        event3ModeratorAdapter.clickOnEventDetailsLink();
        event3ModeratorAdapter.clickOnModeratorButton();
        event3ModeratorAdapter.closeModeratorAutoSignInPopUP();
        for (RegAndChatQuestionsInfo info : Infos) {
            log.info("Chat and Questions moderation details are - " + info.chatMessageModerationOFF + ", " + info.questionMessageModerationOFF + ". ");
            event3ModeratorAdapter.verifyMessageOnModerator(info.chatMessageModerationOFF);
            event3ModeratorAdapter.verifyApprovalIcon(info.chatMessageModerationOFF, "OFF");
            event3ModeratorAdapter.verifyMessageOnModerator(info.questionMessageModerationOFF);
            event3ModeratorAdapter.verifyApprovalIcon(info.questionMessageModerationOFF, "OFF");
        }
    }

    @And("^Moderation is ON$")
    public void moderation_is_ON() {
        event3HomePageAdapter.goToAdminPage();
        event3HomePageAdapter.clickOnUpcomingEventTab();
        event3HomePageAdapter.searchCreatedEvent();
        event3ModeratorAdapter.clickOnEventDetailsLink();
        event3ModeratorAdapter.clickOnEditEventButton();
        event3EventAdapter.clickOnEventTab();
        event3EventAdapter.clickOnSession();
        event3EventAdapter.clickOnSettingTab();
        event3SessionSettingAdapter.verifyModerationChatApproval("ON");
        event3SessionSettingAdapter.verifyModerationQuestionApproval("ON");
        event3CreationAdapter.publishEvent();
    }

    @And("^Check that functionality on the Moderator window when Moderation is ON$")
    public void check_that_functionality_on_the_Moderator_window_when_Moderation_is_ON(List<RegAndChatQuestionsInfo> Infos) {
        browser.switchToNextWindow();
        browser.refreshBrowserWindow();
        for (RegAndChatQuestionsInfo info : Infos) {
            log.info("Chat and Questions moderation details are - " + info.chatMessageModerationON + ", " + info.questionMessageModerationON + ". ");
            event3ChatAdapter.sendChatMessage(info.chatMessageModerationON);
            event3ChatAdapter.verifyChatMessage(info.chatMessageModerationON, "ON", false);
            event3QuestionsAdapter.clickOnQuestionsTab();
            event3QuestionsAdapter.enterQuestion(info.questionMessageModerationON);
            event3QuestionsAdapter.verifyQuestionMessage(info.questionMessageModerationON, "ON", false);
            browser.switchToPreviousWindow();
            event3CreationAdapter.clickOnPathingHeader();
            event3HomePageAdapter.clickOnUpcomingEventTab();
            event3HomePageAdapter.searchCreatedEvent();
            event3ModeratorAdapter.clickOnEventDetailsLink();
            event3ModeratorAdapter.clickOnModeratorButton();
            event3ModeratorAdapter.verifyMessageOnModerator(info.chatMessageModerationON);
            event3ModeratorAdapter.verifyApprovalIcon(info.chatMessageModerationON, "ON");
            event3ModeratorAdapter.verifyMessageOnModerator(info.questionMessageModerationON);
            event3ModeratorAdapter.verifyApprovalIcon(info.questionMessageModerationON, "ON");
            event3ModeratorAdapter.approveChatOnModerator(info.chatMessageModerationON);
            event3ModeratorAdapter.approveChatOnModerator(info.questionMessageModerationON);
            sleep(3);
            browser.switchToNextWindow();
            event3ChatAdapter.verifyChatMessage(info.chatMessageModerationON, "ON", true);
            event3QuestionsAdapter.clickOnQuestionsTab();
            event3QuestionsAdapter.verifyQuestionMessage(info.questionMessageModerationON, "ON", true);
        }
    }
}