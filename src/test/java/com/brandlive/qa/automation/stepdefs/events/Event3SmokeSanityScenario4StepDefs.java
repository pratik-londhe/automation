package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.*;
import com.brandlive.qa.automation.events3.adapters.live.Event3LiveRegistrationAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.Given;

import java.util.List;

public class Event3SmokeSanityScenario4StepDefs extends StepDefs {
    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3HomePageAdapter event3HomePageAdapter = new Event3HomePageAdapter();
    Event3SessionSettingAdapter event3SessionSettingAdapter = new Event3SessionSettingAdapter();
    Event3RegistrationAdapter event3RegistrationAdapter = new Event3RegistrationAdapter();
    SocialProfileDetailsSettingAdapter socialProfileDetailsSettingAdapter = new SocialProfileDetailsSettingAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();
    Event3LiveRegistrationAdapter event3LiveRegistrationAdapter = new Event3LiveRegistrationAdapter();

    class RegistrationInfo {
        private String firstName;
        private String lastName;
    }

    @Given("^Add O(\\d+) Event with Broadcast session or OD session with English Language and LP but No registration$")
    public void add_O_Event_with_Broadcast_session_or_OD_session_with_English_Language_and_LP_but_No_registration(int event) {
        event3CreationAdapter.clickOnPathingHeader();
        event3CreationAdapter.createBroadcastEvent(false, true, "O2");
    }

    @Given("^Make sure this Open Event has Home Page$")
    public void make_sure_this_Open_Event_has_Home_Page() {
        event3SessionSettingAdapter.clickOnEventTab();
        event3HomePageAdapter.verifyHomePageForOpenEvent(true, true, false);
    }

    @Given("^Enable Registration without email confirmation\\. Email field removed and FName, LName field kept required on General info$")
    public void enable_Registration_without_email_confirmation_Email_field_removed_and_FName_LName_field_kept_required_on_General_info() {
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
        event3RegistrationAdapter.clickOnRegTabFromLeftNav();
        event3RegistrationAdapter.enableTheRegistration();
        event3RegistrationAdapter.toggleActionOnSendEmailConfirmation("OFF");
        socialProfileDetailsSettingAdapter.clickOnSocialTab();
        socialProfileDetailsSettingAdapter.toggleActionOnProfileDetails("OFF");
        event3RegistrationAdapter.clickOnRegTabFromLeftNav();
        event3RegistrationAdapter.toggleActionOnEmailFiledForTheRegistration("Off");
    }

    @Given("^Publish and go live\\. Make sure the Landing page is opened live with Registration button$")
    public void publish_and_go_live_Make_sure_the_Landing_page_is_opened_live_with_Registration_button() {
        event3CreationAdapter.publishEvent();
        event3OpenLiveAdapter.copyPublishedEventLink();
        event3OpenLiveAdapter.goWithTheLiveEvent();
        event3LiveRegistrationAdapter.clickOnTheRegistrationButton();
    }

    @Given("^Register without email and navigate to Home page and later session page$")
    public void register_without_email_and_navigate_to_Home_page_and_later_session_page(List<RegistrationInfo> Infos) {
        for (RegistrationInfo info : Infos) {
            log.info("Registration details are - " + info.firstName + ", " + info.lastName + ". ");
            event3LiveRegistrationAdapter.enterGeneralInfoWithoutEmail(info.firstName, info.lastName);
        }
        sleep(3);
        event3OpenLiveAdapter.clickOnTheSessionTab();
        browser.closeCurrentWindowAndSwitchToPreviousWindow();
        event3CreationAdapter.clickOnPathingHeader();
    }
}