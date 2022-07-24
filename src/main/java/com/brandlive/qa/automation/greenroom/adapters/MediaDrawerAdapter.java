package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.BuilderModeMediaDrawer;
import com.brandlive.qa.automation.greenroom.pages.BuilderModeShowBoard;
import com.brandlive.qa.automation.utils.Doer;

public class MediaDrawerAdapter extends Doer {
    BuilderModeMediaDrawer builderModeMediaDrawer = new BuilderModeMediaDrawer();
    BuilderModeShowBoard builderModeShowBoard = new BuilderModeShowBoard();

    public void uploadMediaInBuilderMode(String mediaType, String mediaName, String productName){
        builderModeMediaDrawer.openMediaDrawerInBuilderMode();
        builderModeMediaDrawer.uploadMedia(mediaType,mediaName,productName);
    }

    public void dragAndDropMediaOnCanvas(String mediaName,int feedNumber){
       builderModeMediaDrawer.openMediaDrawerInBuilderMode();
       builderModeMediaDrawer.clickOnFilesTab();
       sleep(5);
       builderModeMediaDrawer.dragAndDropMediaOnFeed(mediaName,feedNumber);
        sleep(10);
    }

    public void navigateToOverlaysTab(){
        builderModeMediaDrawer.openMediaDrawerInBuilderMode();
        builderModeMediaDrawer.clickOnOverlaysTab();
    }

    public void dragAndDropOverlayOnCanvas(String mediaName) {
        builderModeMediaDrawer.dragAndDropOverlaysOnTheFeed(mediaName);
        sleep(10);
    }

    public void applyBuildInAnimation(String animationName) {
        builderModeMediaDrawer.addBuildInAnimation(animationName);
        builderModeMediaDrawer.addBuildInAnimationEffect("Dissolve");
        builderModeMediaDrawer.addBuildInAnimationDuration("10 sec.");
        sleep(2);
    }

    public void previewBuildInAnimation(){
        builderModeMediaDrawer.previewAnimation();
    }
}
