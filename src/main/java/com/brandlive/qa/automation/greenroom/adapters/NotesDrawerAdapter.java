package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.BuilderModeNotesDrawer;
import com.brandlive.qa.automation.utils.Doer;

public class NotesDrawerAdapter extends Doer {

    BuilderModeNotesDrawer builderModeNotesDrawer = new BuilderModeNotesDrawer();

    public void navigateToNotesDrawer(){
        builderModeNotesDrawer.openNotesDrawerInBuilderMode();
    }

    public void createNote(String noteType,String noteTitle,String noteContent){
        builderModeNotesDrawer.addNote(noteType);
        builderModeNotesDrawer.addNoteDetails(noteTitle,noteContent);
    }

    public void shareAndCloseNote(){
        builderModeNotesDrawer.shareNoteWithPresenter();
        builderModeNotesDrawer.closeNote();
    }

    public boolean validateSharedNoteFromProducer(){
      return builderModeNotesDrawer.validateNoteShared();
    }

    public boolean validateSharedNoteFromPresenter(String noteTitle){
        return builderModeNotesDrawer.validateSharedNoteTileOnPresenter(noteTitle) && builderModeNotesDrawer.validatePresenterAvatarOnSharedNoteTile();
    }
}
