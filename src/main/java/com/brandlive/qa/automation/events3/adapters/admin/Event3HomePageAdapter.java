package com.brandlive.qa.automation.events3.adapters.admin;

import com.brandlive.qa.automation.events3.pages.Dashboard;
import com.brandlive.qa.automation.events3.pages.admin.EventHeader;
import com.brandlive.qa.automation.events3.pages.admin.homesetting.Home;
import com.brandlive.qa.automation.events3.pages.admin.landingpagesetting.Products;
import com.brandlive.qa.automation.events3.pages.admin.landingpagesetting.Speakers;
import com.brandlive.qa.automation.events3.pages.admin.landingpagesetting.Sponsors;
import com.brandlive.qa.automation.events3.pages.admin.landingpagesetting.Videos;
import com.brandlive.qa.automation.utils.Doer;

public class Event3HomePageAdapter extends Doer {
    Home home = new Home();
    EventHeader eventHeader = new EventHeader();
    Dashboard dash = new Dashboard();
    Speakers speakers = new Speakers();
    Sponsors sponsors = new Sponsors();
    Products products = new Products();
    Videos videos = new Videos();

    public void verifyHomePageForOpenEvent(boolean singleOpenSessionEvent, boolean LP, boolean EA) {
        home.verifyHomePageForOpenEvent(singleOpenSessionEvent, LP, EA);
    }

    public void goToAdminPage() {
        eventHeader.goToAdminPage();
    }

    public void searchCreatedEvent() {
        dash.searchEvent();
    }

    public void clickOnUpcomingEventTab() {
        dash.clickOnUpcomingEventTab();
    }

    public void createDuplicateEvent() {
        dash.editEvent();
        dash.clickOnDuplicate();
    }

    public void deleteOriginalEvent() {
        dash.editEvent();
        dash.deleteOriginalEvent();
    }

    public void clickOnHomeTab() {
        home.clickOnHomeTab();
    }

    public void addSpeakersToHomePage() {
        home.enableSpeakersToggle();
        speakers.selectSpeakers();
        sponsors.addItemToPage();
    }

    public void verifyAddedSpeakersOnHomePage() {
        speakers.verifyAddedSpeakerOnAdmin();
    }

    public void addSponsorsToHomePage() {
        home.enableSponsorsToggle();
        sponsors.selectSponsors();
        sponsors.addItemToPage();
    }

    public void verifyAddedSponsorsOnHomePage() {
        sponsors.verifyAddedSponsorsOnAdmin();
    }

    public void addProductsToHomePage() {
        home.enableProductToggle();
        products.selectProduct();
        sponsors.addItemToPage();
    }

    public void verifyAddedProductsOnHomePage() {
        products.verifyAddedProductsOnAdmin();
    }

    public void addVideoToHomePage() {
        home.enableVideoToggle();
        videos.selectVideo();
        sponsors.addItemToPage();
    }

    public void verifyAddedVideoOnHomePage() {
        videos.verifyAddedVideoOnAdmin();
    }
}