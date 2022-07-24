import { Given, When, Then } from "@cucumber/cucumber";
import reporter from "../../../utils/reporter"
import DetailsPage from "../../../page-objects/greenroom/UI/detailsPage";
import LiveMode from "../../../page-objects/greenroom/UI/liveMode";
import mediaDrawer from "../../../page-objects/greenroom/UI/mediaDrawer";
import showBoard from "../../../page-objects/greenroom/UI/showBoard"
import feedsDrawer from "../../../page-objects/greenroom/UI/feedsDrawer";
import liveMode from "../../../page-objects/greenroom/UI/liveMode";
import chai from "chai";
import designDrawer from "../../../page-objects/greenroom/UI/designDrawer";

Given (/^Navigate to Live Mode$/, async function(){
    reporter.addStep("info", `Joining SGR Event show...`)
    await DetailsPage.navigateToLiveMode()
})

Given (/^Play Intro Shot$/, async function(){
    reporter.addStep("info", `Play Intro Shot...`)
    await showBoard.playIntroShot()
})

Given (/^Clear Intro Shot$/, async function(){
    reporter.addStep("info", `Clear Intro shot`)
	await showBoard.clearIntroShot()
})

Given (/^Resume Intro Shot$/, async function(){
    reporter.addStep("info", `Resume Intro Shot`)
	await showBoard.resumeIntroShot()
})

Given (/^Click Next Shot$/, async function(){
    reporter.addStep("info", `Click Next Shot...`)
    await showBoard.navigateToNextShot()
})

Given (/^Drag and Drop (.*) to 1B Shot$/, async function(fileName:string){
    reporter.addStep("info", `Drag and Drop ${fileName} to 1B Shot`)
    await mediaDrawer.dragNDropFileToFeed(fileName,1)
})

Given (/^Perform Video controls on shot$/, async function(){
    reporter.addStep("info", `Performing video controls`)
	await LiveMode.videoActions()
})

Given (/^Drag and Drop (.*) to 3B Shot$/, async function(fileName:string){
    reporter.addStep("info", `Drag and Drop ${fileName} to 1B Shot`)
    await mediaDrawer.dragNDropFileToFeed(fileName,1)
})

Given (/^Drag and Drop (.*) to 3B second feed Shot$/, async function(fileName:string){
    reporter.addStep("info", `Drag and Drop ${fileName} to 1B Shot`)
    await mediaDrawer.dragNDropFileToFeed(fileName,2)
})

Given (/^Drag and Drop (.*) to 3B third feed Shot$/, async function(fileName:string){
    reporter.addStep("info", `Drag and Drop ${fileName} to 1B Shot`)
    await mediaDrawer.dragNDropFileToFeed(fileName,3)
})

Given (/^Perform Pdf Pagination$/, async function(){
    reporter.addStep("info", `Perform Pdf Pagination`)
    await LiveMode.paginationControls()
})

Given (/^Open feeds Tab$/, async function(){
    reporter.addStep("info", `Open Feeds Tab`)
    await LiveMode.openFeedsTab()
})


Given (/^Click Previous Shot$/, async function(){
    reporter.addStep("info", `Click Previous Shot`)
    await LiveMode.previousShot()
})


Given (/^Mute all users$/, async function(){
    reporter.addStep("info", `Mute all users from feeds tab`)
    await feedsDrawer.muteAllUsers()
})

Given (/^Unmute all users$/, async function(){
    reporter.addStep("info", `Unmute All users from feeds tab`)
    await feedsDrawer.unmuteAllUsers()
})

Given (/^Pause video playing on the shot$/, async function(){
    reporter.addStep("info", `Pausing video playing on the canvas`)
    await liveMode.pauseVideo()
})

Given (/^Get the duration at which the video is paused$/, async function(){
    reporter.addStep("info", `Capturing duration at which the video is paused`)
    await liveMode.getVideoDuration()
})

Given (/^Validate that the video is paused at the correct duration$/, async function(){
    reporter.addStep("info", `Validating video is paused at correct duration for presenter`)
    let videoDuration = Object.getPrototypeOf(LiveMode).constructor.videoPausedDuration
    let durationNUmber: number = +videoDuration;
   chai.expect(durationNUmber).to.be.greaterThanOrEqual(1)
})

Given (/^Pause (.*) times execution for (.*) mins$/, async function(loop:number,mins:number){
    reporter.addStep("info", `Pausing ${loop} times execution for ${mins} mins`)
	const totalTime = mins*1000*60
	for (let i = 0; i < loop; i++) {
		await browser.pause(totalTime)
		console.log('Count : ' , i);
	  }
})

Given (/^Start recording of the show$/, async function(){
    reporter.addStep("info", `Starting recording of the show`)
    await liveMode.startRecordingShow()
})

Given (/^Stop recodring of the show$/, async function(){
    reporter.addStep("info", `Stopping recording of the show`)
    await liveMode.stopRecordingShow()
})

Given (/^Navigate to Recordings tab$/, async function(){
    reporter.addStep("info", `Stopping recording of the show`)
    await mediaDrawer.navigateToRecordingTab();
})

Given (/^Validate that recording is saved with correct name$/, async function(){
    reporter.addStep("info", `Validating name of the saved recording`)
    await liveMode.validateRecordingName();
	chai.expect(Object.getPrototypeOf(liveMode).constructor.recordingName).to.be.equal("recording-1")
})

Given (/^Drag and drop feeds to the canvas$/, async function(){
    reporter.addStep("info", `Dropping the feed to canvas...`)
    await feedsDrawer.dragAndDropFeedToCanvas()
})

Given (/^Open Design Tab$/, async function(){
    reporter.addStep("info", `Navigating to Design tab...`)
    await designDrawer.openDesignDrawer()
})
