package com.brandlive.qa.automation.stepdefs.greenroom;

import com.brandlive.qa.automation.greenroom.adapters.NotesDrawerAdapter;
import com.brandlive.qa.automation.greenroom.adapters.PresenterViewAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.Given;
import org.junit.Assert;

public class PresenterViewStepDef extends StepDefs {
    PresenterViewAdapter presenterViewAdapter = new PresenterViewAdapter();
    NotesDrawerAdapter notesDrawerAdapter = new NotesDrawerAdapter();

    @Given("^Join the show as presenter$")
    public void join_the_show_as_presenter() {
        presenterViewAdapter.confirmPresenterDetails();
    }

    @Given("^Navigate to event card details as presenter$")
    public void navigate_to_event_card_details_as_presenter() {
        presenterViewAdapter.navigateToShowAsPresenter();
    }

    @Given("^Validate presenter is able to see the shared note \"([^\"]*)\"$")
    public void validate_presenter_is_able_to_see_the_shared_note(String noteTitle) {
        Assert.assertTrue(notesDrawerAdapter.validateSharedNoteFromPresenter(noteTitle));
    }
}
