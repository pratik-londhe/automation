import { Given, When, Then } from "@cucumber/cucumber";
import reporter from "../../../utils/reporter"
import chai from "chai";
import SGREventCreationPage from "../../../page-objects/greenroom/UI/Standalone/SGREventCreationPage";
import DetailsPage from "../../../page-objects/greenroom/UI/detailsPage";
import LiveMode from "../../../page-objects/greenroom/UI/liveMode";
import ShowBuilderMode from "../../../page-objects/greenroom/UI/showBuilderMode";
import homePageUI from "../../../page-objects/greenroom/UI/homePageUI";
import mediaDrawer from "../../../page-objects/greenroom/UI/mediaDrawer";
import settingsPage from "../../../page-objects/greenroom/UI/settingsPage";
import showBoard from "../../../page-objects/greenroom/UI/showBoard"

Given(/^Login to (.*) greenroom as (.*) using (.*)$/, async function(app: string, role: string,email: string){
    reporter.addStep("info", `The log in to greenroom is in progress with user : ${email}`)

	//@ts-ignore
	let password = browser.config.Password
    //@ts-ignore
    let greenroom_host = browser.config.Greenroom_Ui_Host

    switch(role.toLowerCase()) {
        case "producer":
            reporter.addStep("info", `The role value is ${role}...`)
			const room_code = process.env?.ROOM_CODE ?? 'NA'
			let url
			if (room_code !='NA'){
			 reporter.addStep("info", `Room code is present, so it will directly navigate to Live Mode`)
			 url = `${greenroom_host}/producer/`+process.env?.ROOM_CODE
			}
			else{
			 url = `${greenroom_host}/producer/`
			}
			reporter.addStep("info", `Login URL is ${url}`)
            await homePageUI.navigateToGreenroomUrl(url)
            await homePageUI.checkGreenroomAppAccessForProfile(email)
            await homePageUI.greenroomLoginForApp(email, password)
            break;
        case "presenter":
            reporter.addStep("info", `The role value is ${role}...`)
			let presenterUrl = `${greenroom_host}`
            await homePageUI.navigateToGreenroomUrl(presenterUrl)
            await homePageUI.greenroomLoginForApp(email, password)
            await homePageUI.confirmPresenterDetails()
            break;
        default:
            reporter.addStep("info", `The role value ${role} is not valid...`)
            break;
    }
})


Given (/^Create New SGR Event and invite (.*)$/, async function(invite: string){
	await browser.pause(15000)
    reporter.addStep("info", `Create New SGR Event show is in progress...`)
    await SGREventCreationPage.createNewSGREvent(invite)
	console.log(`New SGR Event Created with Title : `, Object.getPrototypeOf(SGREventCreationPage).constructor.getSGREventName)
})

Given (/^Search and Navigate to Show Details Page$/, async function(){
    await browser.pause(8000)
    reporter.addStep("info", `Search New SGR Event...`)
		const room_title = process.env?.ROOM_TITLE ?? 'NA'
		console.log("The room title is " ,room_title)

		if (room_title !='NA'){
			await homePageUI.searchNewSGREvent(room_title)
		}else{
		await homePageUI.searchNewSGREvent(Object.getPrototypeOf(SGREventCreationPage).constructor.getSGREventName)
		}
		try {
		if (room_title !='NA'){
			chai.expect(Object.getPrototypeOf(homePageUI).constructor.eventTitleNameValue).to.be.equal(room_title)
			await browser.pause(5000)
		}else{
			chai.expect(Object.getPrototypeOf(homePageUI).constructor.eventTitleNameValue).to.be.equal(Object.getPrototypeOf(SGREventCreationPage).constructor.getSGREventName)
			await browser.pause(5000)
		}
	}
		catch(err){
			err.message = `SGR Title didnot match`
			throw err
		}
		await homePageUI.navigateToShowDetailsPage()
})

Given (/^Navigate to Showbuilder Mode$/, async function(){
    reporter.addStep("info", `Navigating to Showbuilder Mode...`)
    await LiveMode.navigateToShowBuilderMode()
})

Given (/^Open Media Drawer$/, async function(){
    reporter.addStep("info", `Open Media Drawer...`)
    await mediaDrawer.openMediaDrawer();
})

// Given (/^upload file "(.*)"$/, async function(file){
//     reporter.addStep("info", `upload sample_image.jpg file...`)
//     console.log(file);
//     await mediaDrawer.uploadImageMedia(file);
// })

Given (/^Navigate to Streaming Tab$/, async function(){
    reporter.addStep("info", `Navigating to Streaming Tab inside settings`)
    await settingsPage.openSettingsTab()
})

Given (/^Add Streaming Destination$/, async function(){
    reporter.addStep("info", `Adding Streaming Destination Details`)
	await settingsPage.addDetailsToStreamingTab()
})

Given (/^Sign out the greenroom from Live Mode$/, async function(){
    reporter.addStep("info", `Signing Out GR from LiveMode...`)
    await LiveMode.signOutGRFromLiveMode()
})

Given (/^Click on Add Shot Button$/, async function(){
    reporter.addStep("info", `Clicking on Add Shot button...`)
    await showBoard.addShotButton()
})

Given (/^Select 2B Layout$/, async function(){
    reporter.addStep("info", `Selecting 2B Layout...`)
    await showBoard.select2BLayout()
})

Given (/^Apply Layout$/, async function(){
    reporter.addStep("info", `Applying layout...`)
    await showBoard.applyLayout()
})

Given (/^Expand Show board$/, async function(){
    reporter.addStep("info", `Expand Show board.`)
    await showBoard.expandShowBoard()
})

Given (/^Drag and Drop Image to canvas$/, async function(){
    reporter.addStep("info", `Drag and Drop media item to canvas.`)
    await mediaDrawer.dragAndDropImage("sample_image.jpg")
})

Given (/^Refresh the room every (.*) secs$/, async function(seconds:number){
    reporter.addStep("info", `Refresing room every ${seconds} secs`)
	await LiveMode.refreshEvery(seconds)
})

Given (/^Pause the execution for (.*) mins$/, async function(mins:number){
    reporter.addStep("info", `Pausing execution for ${mins} mins`)
	const totalTime = mins*1000*60
	await browser.pause(totalTime)
})


Given (/^Navigate to overaly Tab$/, async function(){
    reporter.addStep("info", `Navigate to overlays tab`)
    await LiveMode.navigateToOverlaysTab()
})

Given (/^Drag and Drop (.*) to the 1B Shot$/, async function(fileName:string){
    reporter.addStep("info", `Drag and Drop ${fileName} to 1B Shot`)
    await LiveMode.dragAndDropOverlay(fileName)
})

Given (/^Save overlay with animation settings$/, async function(){
    reporter.addStep("info", `Save animation settings`)
    await LiveMode.applyBuildInAnimation()
})

Given (/^Go Live with the show$/, async function(){
    reporter.addStep("info", `Go live with show`)
    await LiveMode.goLiveWithShow()
})
