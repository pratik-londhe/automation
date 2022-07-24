package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.PresenterView;
import com.brandlive.qa.automation.utils.Doer;

public class PresenterViewAdapter extends Doer {
    PresenterView presenterView = new PresenterView();

    public void confirmPresenterDetails(){
        presenterView.confirmPresenterInfo();
    }

    public void navigateToShowAsPresenter(){
        presenterView.searchAndNavigateToShowDetailsPageAsPresenter();
        sleep(15);
    }

}
