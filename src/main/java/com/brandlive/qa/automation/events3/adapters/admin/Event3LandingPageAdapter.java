package com.brandlive.qa.automation.events3.adapters.admin;

import com.brandlive.qa.automation.events3.pages.admin.LeftNavigation;
import com.brandlive.qa.automation.events3.pages.admin.landingpagesetting.*;
import com.brandlive.qa.automation.utils.Doer;

public class Event3LandingPageAdapter extends Doer {
    LandingPage landingPage = new LandingPage();
    LeftNavigation leftNavigation = new LeftNavigation();
    Speakers speakers = new Speakers();
    Sponsors sponsors = new Sponsors();
    Products products = new Products();
    Videos videos = new Videos();

    public void verifyLandingPageIsDisplayed() {
        leftNavigation.clickOnTheLandingTab();
        landingPage.verifyLandingPageIsDisplayed();
    }


    public void addSpeakersToLandingPage() {
        speakers.selectSpeakers();
        sponsors.addItemToPage();
    }

    public void verifyAddedSpeakersOnLandingPage() {
        speakers.verifyAddedSpeakerOnAdmin();
    }

    public void addSponsorsToLandingPage() {
        sponsors.selectSponsors();
        sponsors.addItemToPage();
    }

    public void verifyAddedSponsorsOnLandingPage() {
        sponsors.verifyAddedSponsorsOnAdmin();
    }

    public void addProductsToLandingPage() {
        products.selectProduct();
        sponsors.addItemToPage();
    }

    public void verifyAddedProductsOnLandingPage() {
        products.verifyAddedProductsOnAdmin();
    }

    public void addVideoToLandingPage() {
        videos.selectVideo();
        sponsors.addItemToPage();
    }

    public void verifyAddedVideoOnLandingPage() {
        videos.verifyAddedVideoOnAdmin();
    }
}