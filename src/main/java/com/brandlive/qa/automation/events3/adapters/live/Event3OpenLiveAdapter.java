package com.brandlive.qa.automation.events3.adapters.live;

import com.brandlive.qa.automation.events3.pages.admin.EventHeader;
import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Documents;
import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Polls;
import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Sessions;
import com.brandlive.qa.automation.events3.pages.admin.eventsessionsetting.Speakers;
import com.brandlive.qa.automation.events3.pages.live.EventLandingPage;
import com.brandlive.qa.automation.events3.pages.live.Session;
import com.brandlive.qa.automation.utils.Doer;

public class Event3OpenLiveAdapter extends Doer {
    public static String eventLink;

    EventLandingPage eventLivePage = new EventLandingPage();
    EventHeader eventHeader = new EventHeader();
    Session session = new Session();
    Polls polls = new Polls();
    Documents documents = new Documents();
    Speakers speakers = new Speakers();
    Sessions sessions = new Sessions();

    public void copyPublishedEventLink() {
        eventLink = eventHeader.copyPublishedEventLink();
    }

    public void goWithTheLiveEvent() {
        eventLivePage.goLiveWithTheEvent(eventLink);
    }

    public void clickOnTheJoinEvent() {
        eventLivePage.clickOnTheJoinEvent();
    }

    public void clickOnTheSessionTab() {
        eventLivePage.clickOnTheSessionTab();
    }

    public void verifyTheVideoStreamingControls() {
        eventLivePage.verifyAndPauseVideoStreaming();
        eventLivePage.verifyAndPlayVideoStreaming();
        sleep(3);
        eventLivePage.verifyMuteSpeaker();
       eventLivePage.verifyUnMuteSpeaker();
        eventLivePage.verifyTheImageVideoStreamingIsLive();
    }

    public void verifyTheODVideoStreamingControls() {
        session.verifyAndPauseVideoStreamingForOD();
        session.verifyAndPlayVideoStreamingForOD();
        session.verifyODVideoStreamingIsPlayedByTimer();
        sleep(3);
        eventLivePage.verifyCurrentlyWatchingAttendees();
        eventLivePage.verifyLiveChatWrapper();
    }

    public void verifyBrandliveLiveSite(String brandliveURL) {
        eventLivePage.verifyBrandliveLiveSite(brandliveURL);
    }

    public void verifyAnnouncementAlertAndMessage() {
        eventLivePage.verifyAnnouncementAlertAndMessage();
    }

    public void verifySessionContainerPageOpenedLive() {
        eventLivePage.verifySessionContainerPageOpenedLive();
    }

    public void verifySpeakerSponsorsVideoProductsOnLiveLPPage() {
        eventLivePage.verifySpeakersOnLandingPage();
        eventLivePage.verifySponsorsOnLandingPage();
        eventLivePage.verifyVideosOnLandingPage();
        eventLivePage.verifyProductsOnLandingPage();
    }

    public void verifySpeakerSponsorsVideoProductsOnLiveHomePage() {
        eventLivePage.verifySpeakersOnLandingPage();
        eventLivePage.verifySponsorsOnLandingPage();
        eventLivePage.verifyVideosOnLandingPage();
        eventLivePage.verifyProductsOnLandingPage();
    }

    public void verifySpeakerSimilarSessionPollsDocOnLiveSessionPage() {
        speakers.verifyAddedSpeakerOnAdmin();
        session.verifySimilarSessionOnSessionPage();
        session.clickOnPollsTab();
        polls.verifyAddedPollOnAdmin();
        session.clickOnDocumentsTab();
        documents.verifyAddedDocumentOnAdmin();
    }

    public void verifyTheODVideoIframeStreamingControls() {
        session.verifyAndPlayVideoIframeStreamingForOD();
        sleep(20);
        session.verifyAndPauseVideoIframeStreamingForOD();
        session.verifyODVideoStreamingIsPlayedByTimer();
        eventLivePage.verifyLiveChatWrapper();
    }
}