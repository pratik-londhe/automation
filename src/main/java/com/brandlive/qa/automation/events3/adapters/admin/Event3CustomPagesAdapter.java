package com.brandlive.qa.automation.events3.adapters.admin;

import com.brandlive.qa.automation.events3.pages.admin.EventCustomPages;
import com.brandlive.qa.automation.utils.Doer;

public class Event3CustomPagesAdapter extends Doer {
    EventCustomPages eventCustomPages = new EventCustomPages();

    public void addCustomPageAndPageGatingReqToEvent(int noOfCustomPages, boolean customPageGating, String toggleAction, String mediaType, String mediaName, String productName, String pListName, String pType) {
        eventCustomPages.addCustomPageAndPageGatingReqToEvent(noOfCustomPages, customPageGating, toggleAction, mediaType, mediaName, productName, pListName, pType);
    }

    public void verifyCustomPagesLiveSide(String pageGatingToggleStatus) {
        eventCustomPages.verifyCustomPagesLiveSide(pageGatingToggleStatus);
    }

    public void toggleActionOnPageGating(String toggleAction) {
        eventCustomPages.toggleActionOnPageGating(toggleAction);
    }
}