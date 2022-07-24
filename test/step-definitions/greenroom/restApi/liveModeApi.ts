import { Given } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import liveModeRestApi from "../../../page-objects/greenroom/restApi/liveModeRestApi";
import editJsonFile from "edit-json-file";
import standaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi";


class liveModeApi{

	static mediaDetailsIntroAndOutro: any
    constructor(){
    }

	public async  roomMediaDetails() {
 
		let mediaDetails = Object.getPrototypeOf(liveModeRestApi).constructor.getMediaDetailsResponse
		
		console.log(`--------------`)
	
		console.log(`>>Media Id for Intro Video : ${mediaDetails[0].id}`)
		console.log(`>>Media Name for Intro Video : ${mediaDetails[0].custom_name}`)
		console.log(`>>Media Image Query for Intro Video : ${mediaDetails[0].media_data.image_array}`)
		
		console.log(`--------------`)
	
		console.log(`>>Media Id for Outro Video : ${mediaDetails[1].id}`)
		console.log(`>>Media Name for Outro Video : ${mediaDetails[1].custom_name}`)
		console.log(`>>Media Image Query for Outro Video : ${mediaDetails[1].media_data.image_array}`)
	
		return mediaDetails
	
	}

}

export default new liveModeApi

 Given (/^Get rooms media details$/, async function(){
    //@ts-ignore
    let response = await liveModeRestApi.getMediaDetails(browser.config.Greenroom_Api_Host)
	liveModeApi.mediaDetailsIntroAndOutro = ( new liveModeApi().roomMediaDetails())
	chai.expect(response[0]).to.be.not.null
 })
 

Given(/^Request State for current meeting$/, async function() {

	const config = browser.config as unknown as { [key: string]: any };
	const meetingId = Number(
		`${Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId}`,
	);

	chai.expect(meetingId).to.be.greaterThan(0);

	const { body, status } = await liveModeRestApi.requestState(
		config.Greenroom_Sync_Host,
		meetingId
	);

	chai.expect(body).to.not.be.empty;
	chai.expect(status).to.equal(200);
	reporter.addStep('info', 'Request State for current meeting is a success!');

});

 Given (/^Get Direct Chat Messages$/, async function(){
    //@ts-ignore
    let response = await liveModeRestApi.getDirectChatMessages(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)
 })
 
 
 Given (/^Get Room Chat Messages$/, async function(){
    //@ts-ignore
    let response = await liveModeRestApi.getRoomChatMessages(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)
 })
 

 Given (/^Set Seen Notification$/, async function(){
	//@ts-ignore
	
	let jsonString = {"notificationIDs":[]}

	let payload = JSON.stringify(jsonString)
	//@ts-ignore
	let response = await liveModeRestApi.postSetSeenNotification(browser.config.Greenroom_Api_Host , payload)
	chai.expect(response.status).to.equal(200)
	reporter.addStep("info", `Set Seen Notificatin is success`)
})

Given (/^Create feature flags information$/, async function(){
    //@ts-ignore
    let response = await liveModeRestApi.postCreateFeatureFlags(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)
 })
