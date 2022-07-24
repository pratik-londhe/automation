package com.brandlive.qa.automation.events3.adapters;

import com.brandlive.qa.automation.events3.pages.Gmail;
import com.brandlive.qa.automation.utils.Doer;

public class GmailAdapter extends Doer {
    Gmail gmail = new Gmail();

    public void loginToGmailAccount() {
        gmail.loginToGmailAccount();
    }

    public void accessEventFromAnEmail() {
        gmail.searchCreatedEventInAnEmail();
        gmail.accessTheEventFromTheEvent();
    }
}