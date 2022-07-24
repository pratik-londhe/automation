package com.brandlive.qa.automation.events3.adapters.admin;

import com.brandlive.qa.automation.events3.pages.admin.LeftNavigation;
import com.brandlive.qa.automation.events3.pages.admin.socialprofiledetailssetting.Directory;
import com.brandlive.qa.automation.events3.pages.admin.socialprofiledetailssetting.ProfileDetails;
import com.brandlive.qa.automation.utils.Doer;

public class SocialProfileDetailsSettingAdapter extends Doer {
    ProfileDetails profileDetails = new ProfileDetails();
    LeftNavigation leftNavigation = new LeftNavigation();
    Directory directory = new Directory();

    public void clickOnSocialTab() {
        leftNavigation.clickOnSocialTab();
    }

    public void toggleActionOnProfileDetails(String toggleAction) {
        profileDetails.toggleActionOnProfileDetails(toggleAction);
    }

    public void toggleActionOnDirectoryAvatar(String toggleAction) {
        directory.toggleActionOnDirectoryAvatar(toggleAction);
    }
}