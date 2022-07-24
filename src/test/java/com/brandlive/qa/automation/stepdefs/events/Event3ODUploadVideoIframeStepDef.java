package com.brandlive.qa.automation.stepdefs.events;

import com.brandlive.qa.automation.events3.adapters.admin.Event3SessionSettingAdapter;
import com.brandlive.qa.automation.events3.adapters.live.Event3OpenLiveAdapter;
import com.brandlive.qa.automation.stepdefs.StepDefs;
import cucumber.api.java.en.Given;

import java.util.List;

public class Event3ODUploadVideoIframeStepDef extends StepDefs {
    Event3SessionSettingAdapter event3EventAdapter = new Event3SessionSettingAdapter();
    Event3OpenLiveAdapter event3OpenLiveAdapter = new Event3OpenLiveAdapter();

    class StreamingInfo {
        private String streamOption;
        private String videoIframe;
    }

    @Given("^Upload a video using iframe$")
    public void upload_a_video_using_iframe(List<StreamingInfo> Infos) {
        event3EventAdapter.clickOnEventTab();
        event3EventAdapter.clickOnSession();
        event3EventAdapter.clickOnSettingTab();
        for (StreamingInfo info : Infos) {
            log.info("Streaming details are - " + info.streamOption + ", " + info.videoIframe + ". ");
            event3EventAdapter.selectStreamingOption(info.streamOption);
            event3EventAdapter.addVideoIframe(info.videoIframe);
            event3EventAdapter.verifyUploadedVideoLink(info.videoIframe);
        }
    }

    @Given("^Check the streaming for the uploaded video iframe for on demand session$")
    public void check_the_streaming_for_the_uploaded_video_iframe_for_on_demand_session() {
        event3OpenLiveAdapter.verifyTheODVideoIframeStreamingControls();
    }
}