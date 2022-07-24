package com.brandlive.qa.automation.stepdefs.greenroom;

import com.brandlive.qa.automation.greenroom.adapters.*;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;

import java.util.List;

public class BuilderModeStepDef extends StepDefs {
    ShowBoardAdapter showBoardAdapter = new ShowBoardAdapter();
    GreenroomHeaderAdapter greenroomHeaderAdapter = new GreenroomHeaderAdapter();
    MediaDrawerAdapter mediaDrawerAdapter = new MediaDrawerAdapter();
    NotesDrawerAdapter notesDrawerAdapter = new NotesDrawerAdapter();
    ChatDrawerAdapter chatDrawerAdapter = new ChatDrawerAdapter();

    class UploadMediaInfo{
        String mediaType;
        String mediaName;
    }

    class DestinationDetails{
        String destinationType;
        String streamTitle;
    }

    @And("^Validate Intro and Outro shots$")
    public void validate_Intro_and_Outro_shots() {
       Assert.assertTrue(showBoardAdapter.validateShots("Intro"));
       Assert.assertTrue(showBoardAdapter.validateShots("Outro"));
    }

    @Given("^Exit builder mode to enter live mode$")
    public void exit_builder_mode_to_enter_live_mode(){
        greenroomHeaderAdapter.navigateFromShowBuilderModeToLiveMode();
    }

    @Given("^Add one shot with (\\d+) feeds$")
    public void add_one_shot_with_feeds(int noOfFeeds) {
        showBoardAdapter.addShotWithFeeds(noOfFeeds);
    }


    @Given("^Upload two files: picture and video$")
    public void upload_two_files_picture_and_video(List<UploadMediaInfo> media) {
        for(UploadMediaInfo uploadMedia: media) {
            mediaDrawerAdapter.uploadMediaInBuilderMode(uploadMedia.mediaType, uploadMedia.mediaName, "GR");
            sleep(15);
        }
    }

    @Given("^select shot from showboard in builder mode$")
    public void select_from_showboard_in_builder_mode()  {
        showBoardAdapter.selectShotFromShowBoard();
    }

    @Given("^Drag and drop two files on canvas$")
    public void drag_and_drop_two_files_on_canvas() {
       mediaDrawerAdapter.dragAndDropMediaOnCanvas("image1.jpg",1);
       mediaDrawerAdapter.dragAndDropMediaOnCanvas("video1.mp4",2);
    }

    @Given("^go to Streaming tab of the show$")
    public void go_to_Streaming_tab_of_the_show(){
        greenroomHeaderAdapter.navigateToStreaming();
    }

    @Given("^add streaming destination with following details with rtmp address as \"([^\"]*)\" and stream key as \"([^\"]*)\"$")
    public void add_streaming_destination_with_following_details_with_rtmp_address_as_and_stream_key_as(String rtmpAddress, String rtmpKey, List<DestinationDetails> destinationInfo){
        for(DestinationDetails destinationDetails : destinationInfo){
            greenroomHeaderAdapter.addDestinationForSGRShow(destinationDetails.destinationType,destinationDetails.streamTitle,rtmpAddress,rtmpKey);
        }
    }

    @Given("^Invite presenter \"([^\"]*)\" to the show$")
    public void invite_presenter_to_the_show(String emailId) {
        greenroomHeaderAdapter.invitePresenterToTheShow(emailId);
    }


    @Given("^Navigate to overlays tab$")
    public void navigate_to_overlays_tab(){
        mediaDrawerAdapter.navigateToOverlaysTab();
    }

    @Given("^drag and drop default overlay to the shot$")
    public void drag_and_drop_default_overlay_to_the_shot(){
        mediaDrawerAdapter.dragAndDropOverlayOnCanvas("Brandlive");
    }

    @Given("^Add \"([^\"]*)\" animation to the overlay$")
    public void add_animation_to_the_overlay(String animationName){
        mediaDrawerAdapter.applyBuildInAnimation(animationName);
        sleep(2);
    }

    @Given("^Preview the overlay animation$")
    public void preview_the_overlay_animation(){
        mediaDrawerAdapter.previewBuildInAnimation();
        sleep(2);
    }

    @Given("^Open notes drawer$")
    public void Open_notes_drawer() {
        notesDrawerAdapter.navigateToNotesDrawer();
    }

    @Given("^Create a new \"([^\"]*)\" as \"([^\"]*)\" in notes drawer$")
    public void create_a_new_note_as_in_notes_drawer(String noteType,String noteTitle) {
        notesDrawerAdapter.createNote(noteType,noteTitle,"This is test note");
    }

    @Given("^Share the note with presenter$")
    public void share_the_note_with_presenter() {
        notesDrawerAdapter.shareAndCloseNote();
    }

    @Given("^Validate note is shared with presenter from producer notes drawer$")
    public void validate_note_is_shared_with_presenter_from_producer_notes_drawer() {
        Assert.assertTrue(notesDrawerAdapter.validateSharedNoteFromProducer());
    }

    @Given("^Navigate to Chat drawer$")
    public void navigate_to_chat_drawer() {
        chatDrawerAdapter.navigateToChatDrawer();
    }

    @Given("^Send a message in presenter group$")
    public void send_a_message_in_presenter_group() {
        chatDrawerAdapter.sendMsgToPresenterGroup("Test1");
    }

    @Given("^Send a message to one of the presenter$")
    public void send_a_message_to_one_of_the_presenter() {
        chatDrawerAdapter.sendDMToPresenter("Test1");
    }

    @Given("^Validate presenter is able to see unread chat toast notification$")
    public void validate_presenter_is_able_to_see_unread_chat_toast_notification() {
        chatDrawerAdapter.validateUnreadChatToastNotification();
    }

    @Given("^Validate Chat drawer has chat notification$")
    public void validate_chat_drawer_has_chat_notification() {
        Assert.assertTrue(chatDrawerAdapter.validateChatDrawerNotification());
    }

    @Given("^Validate presenter chat shows chat notification$")
    public void validate_presenter_chat_shows_chat_notification() {
        Assert.assertTrue(chatDrawerAdapter.validatePresenterGroupNotification());
    }

    @Given("^Validate DM shows chat notification$")
    public void validate_DM_shows_chat_notification() {
        Assert.assertTrue(chatDrawerAdapter.validateDMChatNotification());
    }

    @Given("^Validate presenter group chat from Presenter login$")
    public void validate_presenter_group_chat_from_presenter_login() {
      chatDrawerAdapter.openPresenterGroup();
    }

    @Given("^Validate chat notification disappear from Chat drawer$")
    public void validate_chat_notification_disappear_from_chat_drawer() {
        Assert.assertFalse(chatDrawerAdapter.validateChatDrawerNotification());
    }

}
