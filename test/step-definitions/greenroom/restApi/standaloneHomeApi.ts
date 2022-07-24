import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import StandaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi"
import editJsonFile from "edit-json-file";
import SGREventCreationPage from "../../../page-objects/greenroom/UI/Standalone/SGREventCreationPage";
import HomeRestApi from "../../../page-objects/greenroom/restApi/homeRestApi"

Given (/^Get all standalone GR channels$/, async function(){
	//@ts-ignore
	let response = await StandaloneHomeRestApi.getStandAloneChannels(browser.config.Greenroom_Api_Host)
	let allStandAloneChannels = response.gr_channels
	let channelId: number
	for (let i = 0; i < allStandAloneChannels.length; i++) {
		if (allStandAloneChannels[i]['name'] == 'Brandlive QA Automation I'){
			console.log(`Channel Name for Standalone is : ${allStandAloneChannels[i]['name']}`)
			console.log(`Channel Id is ${allStandAloneChannels[i]['channel']} for Standalone channel ${allStandAloneChannels[i]['name']}`)
			reporter.addStep("info", `Channel Id is ${allStandAloneChannels[i]['channel']} for Standalone channel ${allStandAloneChannels[i]['name']}`)
			channelId = allStandAloneChannels[i]['channel']
			Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId = channelId
			break
		}
	}
	if(!channelId) throw Error(`In-correct Channel Id!`)
})

Given(/^Get all standalone GR events$/, async function() {
    //@ts-ignore
    let response = await StandaloneHomeRestApi.getStandaloneEvents(browser.config.Greenroom_Api_Host)
    chai.expect(response.length).to.greaterThanOrEqual(1)
    reporter.addStep("info", `Get all standalone GR events is success.`)
})

Given(/^Create new standalone GR Event$/, async function() {
    let currentTime = Date.now()
    console.log(`>> Current Time is ${currentTime}`)
    let startTime = (new Date).getTime() + 15 * 60000
    let endTime = (new Date).getTime() + 30 * 60000
    const eventName = await SGREventCreationPage.generateEventName()
    Object.getPrototypeOf(StandaloneHomeRestApi).constructor.setNewSGREventName = eventName

    let channelId = Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId

    let payloadSgrCreateEvent = "./data/jsonFiles/greenroom/payload_SGR_eventCreation.json"
    let file = editJsonFile(payloadSgrCreateEvent)
    file.set("channel", channelId)
    file.set("start_time", startTime)
    file.set("end_time", endTime)
    file.set("standalone_title", eventName)

    let payload = JSON.stringify(file.toObject())

    //@ts-ignore
    let response = await StandaloneHomeRestApi.postStandaloneCreateEvent(browser.config.Greenroom_Api_Host, payload)
    Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId = response.meeting
    reporter.addStep("info", `Create event... is success.`)

    chai.expect(response.meeting).to.be.not.null

})

Given(/^Verify newly created standalone GR Event$/, async function() {
    //@ts-ignore
    let response = await StandaloneHomeRestApi.getStandaloneEvents(browser.config.Greenroom_Api_Host)
    const lastValue = Object.values(response).pop()
    const lastJsonString = JSON.stringify(lastValue)
    const lastJsonObj = JSON.parse(lastJsonString)

    Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRSlugMeetingId = lastJsonObj.meeting_id

    let newMeetingId = Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId
    let newSGREventName = Object.getPrototypeOf(StandaloneHomeRestApi).constructor.setNewSGREventName

    chai.expect(newMeetingId).to.equal(lastJsonObj.meeting)
    chai.expect(newSGREventName).to.equal(lastJsonObj.title)

})

Given(/^Copy newly created greenroom$/, async function() {
    //@ts-ignore
    let fromMeetingId = 7470
    let toMeetingId = Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId
    let jsonString = { "fromMeetingId": fromMeetingId, "toMeetingId": toMeetingId }

    let payload = JSON.stringify(jsonString)
    //@ts-ignore
    let response = await StandaloneHomeRestApi.postCopyGreenroom(browser.config.Greenroom_Api_Host, payload)
    reporter.addStep("info", `Green Copy is success`)

    chai.expect(response.toMeetingId).to.be.not.null
})

Given(/^Check presenter app access$/, async function() {
    //@ts-ignore
    let email = browser.config.Username
    //@ts-ignore
    let password = browser.config.Password

    let jsonString = { "email": email, "password": password }

    let payload = JSON.stringify(jsonString)
    //@ts-ignore
    let response = await StandaloneHomeRestApi.checkPresenterAccess(browser.config.Greenroom_Api_Host, payload)
    chai.expect(response.app_signed_in_with).to.be.not.null
    reporter.addStep("info", `presenter check access is success!`)
})

Given(/^Update profile details for greenroom$/, async function() {
    //@ts-ignore
    let email = browser.config.Username

    let gr_user = await StandaloneHomeRestApi.getGrUserProfile(email)

    let payloadstring =
    {
        "token": Object.getPrototypeOf(HomeRestApi).constructor.greenroomToken,
        "app_signed_in_with": "greenroom",
        "gr_user": gr_user,
        "columns": {
            "first_name": "Brandlive",
            "last_name": "Automation 1",
            "title": "Test title",
            "location": null
        }
    }

    let payload = JSON.stringify(payloadstring)
    //@ts-ignore
    let response = await StandaloneHomeRestApi.updateProfileDetail(browser.config.Greenroom_Api_Host, payload)
    chai.expect(response.token).to.be.not.null
    reporter.addStep("info", `Update profule details for greenroom is success!`)
})

Given(/^Get Standalone meetings by channel Id$/, async function() {
    //@ts-ignore
    let response = await StandaloneHomeRestApi.getSGRMeetingByChannelId(browser.config.Greenroom_Api_Host)
    chai.expect(response).to.be.not.null
    reporter.addStep("info", `presenter check access is success!`)
})

Given(/^Get Standalone meetings by event id$/, async function() {
    //@ts-ignore
    let response = await StandaloneHomeRestApi.getSGRMeetingByEventId(browser.config.Greenroom_Api_Host)
    chai.expect(response).to.be.not.null
    reporter.addStep("info", `presenter check access is success!`)
})

Given(/^Get active rooms$/, async function() {
    //@ts-ignore
    let response = await StandaloneHomeRestApi.getActiveRooms(browser.config.Greenroom_Api_Host)
    chai.expect(response.status).to.equal(200)
    reporter.addStep("info", `Get active rooms is success!`)

})

Given(/^Get details using meeting id$/, async function() {
    //@ts-ignore
    let response = await StandaloneHomeRestApi.getDetailsByMeetingId(browser.config.Greenroom_Api_Host)
    chai.expect(response.status).to.equal(200)
    reporter.addStep("info", `Get Details with meeting id is success!`)
})

