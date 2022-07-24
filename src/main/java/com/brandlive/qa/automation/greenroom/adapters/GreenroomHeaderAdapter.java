package com.brandlive.qa.automation.greenroom.adapters;

import com.brandlive.qa.automation.greenroom.pages.BuilderModeHeader;
import com.brandlive.qa.automation.greenroom.pages.BuilderModeMediaDrawer;
import com.brandlive.qa.automation.greenroom.pages.BuilderModeSettingsDrawer;
import com.brandlive.qa.automation.greenroom.pages.LiveModeHeader;
import com.brandlive.qa.automation.utils.Doer;

public class GreenroomHeaderAdapter extends Doer {

	public static String presenterInviteLink;
	
	LiveModeHeader liveGRHeader = new LiveModeHeader();
	BuilderModeHeader builderModeHeader = new BuilderModeHeader();
	BuilderModeSettingsDrawer builderModeSettingsDrawer =  new BuilderModeSettingsDrawer();

	public void exitGreenroomFromLiveModeToShows(String url) {
		liveGRHeader.exitGRFromLiveView(url);
	}

	public void enterGreenroomShowBuilderMode(){
		liveGRHeader.enterBuilderMode();
		builderModeHeader.validateExitButtonInShowBuilderMode();
	}

	public void navigateFromShowBuilderModeToLiveMode(){
		builderModeHeader.exitBuilderMode();
	}

	public void goLiveWithShow(){
		liveGRHeader.goLive();
	}

	public void navigateToStreaming(){
		builderModeHeader.openSettingsTab();
		builderModeSettingsDrawer.navigateToStreamingTab();
	}

	public void addDestinationForSGRShow(String destinationType,String name,String RTMPAddress,String RTMPKey){
		builderModeSettingsDrawer.addDestinationInBuilderMode(destinationType,name,RTMPAddress,RTMPKey);
		builderModeSettingsDrawer.toggleOnDestination();
		builderModeHeader.closeSettingsTab();
		sleep(2);
	}

	public void invitePresenterToTheShow(String emailId){
		builderModeHeader.openInviteUsersTab();
		//presenterInviteLink = builderModeHeader.copyInviteLink();
		builderModeHeader.invitePresenterFromBuilderMode(emailId);
		builderModeHeader.closeSettingsTab();
	}
}
