package com.brandlive.qa.automation.events3.adapters.admin;

import com.brandlive.qa.automation.events3.pages.admin.LeftNavigation;
import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Documents;
import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Polls;
import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Sessions;
import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Streaming;

import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Speakers;
import com.brandlive.qa.automation.events3.pages.admin.landingpagesetting.Sponsors;
import com.brandlive.qa.automation.utils.Doer;

public class Event3SessionSettingAdapter extends Doer {
    Streaming streaming = new Streaming();
    Sessions sessions = new Sessions();
    LeftNavigation leftNavigation = new LeftNavigation();
    Polls polls = new Polls();
    Documents document = new Documents();
    Sponsors sponsors = new Sponsors();
    Speakers speakers = new Speakers();

    public void clickOnEventTab() {
        leftNavigation.clickOnEventTab();
    }

    public void clickOnSession() {
        sessions.clickOnSessionPanel();
    }

    public void clickOnSettingTab() {
        sessions.clickOnSettingTab();
    }

    public void selectStreamingOption(String streamOption) {
        streaming.selectStreamingOptionForSession(streamOption);
    }

    public void addVideoURL(String videoURL) {
        streaming.addVideoURL(videoURL);
    }

    public void verifyUploadedVideoLink(String videoURL) {
        streaming.verifyUploadedVideoLink(videoURL);
    }

    public void clickOnAddSession() {
        sessions.clickOnAddSessionButton();
    }

    public void addSpeakersToSessionPage() {
        speakers.selectSpeakers();
        sponsors.addItemToPage();
    }

    public void verifyAddedSpeakersOnSessionPage() {
        speakers.verifyAddedSpeakerOnAdmin();
    }

    public void addSimilarSessionToSessionPage() {
        sessions.addSimilarSessionToSessionPage();
    }

    public void verifyAddedSimilarSessionOnSessionPage() {
        sessions.verifyAddedSimilarSessionOnAdmin();
    }

    public void addPollToSessionPage() {
        polls.addPoll();
        sponsors.addItemToPage();
    }

    public void verifyAddedPollOnSessionPage() {
        polls.verifyAddedPollOnAdmin();
    }

    public void addDocumentToSessionPage() {
        document.addDocument();
        sponsors.addItemToPage();
    }

    public void verifyAddedDocumentOnSessionPage() {
        document.verifyAddedDocumentOnAdmin();
    }

    public void addVideoIframe(String videoIframe) {
        streaming.addVideoIframe(videoIframe);
    }

    public void verifyModerationChatApproval(String toggleAction) {
        sessions.moderationChatApproval(toggleAction);
    }

    public void verifyModerationQuestionApproval(String toggleAction) {
        sessions.moderationQuestionApproval(toggleAction);
    }
}