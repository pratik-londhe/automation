package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3HomePageAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3LandingPageAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3SessionSettingAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;

import java.util.List;

public class Event3AddUploadSmokeStepDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3LandingPageAdapter event3LandingPageAdapter = new Event3LandingPageAdapter();
    Event3SessionSettingAdapter event3SessionSettingAdapter = new Event3SessionSettingAdapter();
    Event3HomePageAdapter homePageAdapter = new Event3HomePageAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();

    class RegistrationInfo {
        private String firstName;
        private String lastName;
        private String email;
        private String passcode;
    }

    @And("^Create event \"(.*?)\" with broadcast session$")
    public void create_event_with_broadcast_session(String version) {
        if (version.contains("3.0")) {
            event3CreationAdapter.createSingleBroadcastEvent(true, true);
        }
        sleep();
    }

    @And("^Add products, speakers, sponsors, videos on LP$")
    public void add_products_speakers_sponsors_videos_on_LP() {
        event3LandingPageAdapter.addProductsToLandingPage();
        event3LandingPageAdapter.verifyAddedProductsOnLandingPage();
        event3LandingPageAdapter.addSpeakersToLandingPage();
        event3LandingPageAdapter.verifyAddedSpeakersOnLandingPage();
        event3LandingPageAdapter.addSponsorsToLandingPage();
        event3LandingPageAdapter.verifyAddedSponsorsOnLandingPage();
        event3LandingPageAdapter.addVideoToLandingPage();
        event3LandingPageAdapter.verifyAddedVideoOnLandingPage();
    }

    @And("^Add products, speakers, sponsors, videos on Home Page$")
    public void add_products_speakers_sponsors_videos_on_Home_Page() {
        event3SessionSettingAdapter.clickOnEventTab();
        homePageAdapter.clickOnHomeTab();
        homePageAdapter.addProductsToHomePage();
        homePageAdapter.verifyAddedProductsOnHomePage();
        browser.refreshBrowserWindow();
        homePageAdapter.addSpeakersToHomePage();
        homePageAdapter.verifyAddedSpeakersOnHomePage();
        browser.refreshBrowserWindow();
        homePageAdapter.addSponsorsToHomePage();
        homePageAdapter.verifyAddedSponsorsOnHomePage();
        browser.refreshBrowserWindow();
        homePageAdapter.addVideoToHomePage();
        homePageAdapter.verifyAddedVideoOnHomePage();
    }

    @And("^Add speakers, similar sessions, polls, documents at the session page$")
    public void add_speakers_similar_sessions_polls_documents_at_the_session_page() {
        event3SessionSettingAdapter.clickOnEventTab();
        event3SessionSettingAdapter.clickOnSession();
        sleep(5);
        event3SessionSettingAdapter.addSpeakersToSessionPage();
        event3SessionSettingAdapter.verifyAddedSpeakersOnSessionPage();
        browser.refreshBrowserWindow();
        event3SessionSettingAdapter.addSimilarSessionToSessionPage();
        event3SessionSettingAdapter.verifyAddedSimilarSessionOnSessionPage();
        browser.refreshBrowserWindow();
        event3SessionSettingAdapter.addPollToSessionPage();
        event3SessionSettingAdapter.verifyAddedPollOnSessionPage();
        browser.refreshBrowserWindow();
        event3SessionSettingAdapter.addDocumentToSessionPage();
        event3SessionSettingAdapter.verifyAddedDocumentOnSessionPage();
    }

    @And("^Validate the speakers, sponsors, videos, products, polls, documents on LP, Home Page and session page$")
    public void validate_the_speakers_sponsors_videos_products_polls_documents_on_LP_Home_Page_and_session_page(List<RegistrationInfo> Infos) {
        event3OpenLiveAdapter.verifySpeakerSponsorsVideoProductsOnLiveLPPage();
        event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
        for (RegistrationInfo info : Infos) {
            log.info("Registration details are - " + info.firstName + ", " + info.lastName + ", " + info.email + info.passcode + ". ");
            event3LiveRegistrationAdapter.userGeneralInfo(info.firstName, info.lastName, info.email, info.passcode);
        }
        sleep(2);
        event3OpenLiveAdapter.verifySpeakerSponsorsVideoProductsOnLiveHomePage();
        event3OpenLiveAdapter.clickOnTheSessionTab();
        event3OpenLiveAdapter.verifySpeakerSimilarSessionPollsDocOnLiveSessionPage();
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
    }
}