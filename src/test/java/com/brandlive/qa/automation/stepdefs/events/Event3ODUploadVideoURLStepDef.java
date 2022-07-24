package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3CreationAdapter;
import com.brandlive.qa.automation.events3.adapters.admin.Event3SessionSettingAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.Given;

import java.util.List;

public class Event3ODUploadVideoURLStepDef extends StepDefs {

    Event3CreationAdapter event3CreationAdapter = new Event3CreationAdapter();
    Event3SessionSettingAdapter event3EventAdapter = new Event3SessionSettingAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();

    class StreamingInfo {
        private String streamOption;
        private String videoURL;
    }

    @Given("^Create event \"(.*?)\" with on demand session$")
    public void create_event_with_on_demand_session(String version) {
        if (version.contains("3.0")) {
            event3CreationAdapter.createEventWithOnDemandSession(false, true);
        }
        sleep();
    }

    @Given("^Upload a video using URL$")
    public void upload_a_video_using_URL(List<StreamingInfo> Infos) {
        event3EventAdapter.clickOnEventTab();
        event3EventAdapter.clickOnSession();
        event3EventAdapter.clickOnSettingTab();
        for (StreamingInfo info : Infos) {
            log.info("Streaming details are - " + info.streamOption + ", " + info.videoURL + ". ");
            event3EventAdapter.selectStreamingOption(info.streamOption);
            event3EventAdapter.addVideoURL(info.videoURL);
            event3EventAdapter.verifyUploadedVideoLink(info.videoURL);
        }
    }

    @Given("^Check the streaming for the uploaded video for on demand session$")
    public void check_the_streaming_for_the_uploaded_video_for_on_demand_session() {
        sleep(20);
        event3OpenLiveAdapter.verifyTheODVideoStreamingControls();
    }
}