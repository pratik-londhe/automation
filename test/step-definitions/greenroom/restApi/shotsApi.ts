import { BulkEditShotsPayload } from './../../../page-objects/greenroom/restApi/detailsPageRestApi';

import { Given, When, Then } from "@cucumber/cucumber";
import chai, { use } from "chai";
import StandaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi";
import shotsRestApi from "../../../page-objects/greenroom/restApi/shotsRestApi";
import editJsonFile from "edit-json-file";
import standaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi";

class shotApi{
	constructor(){

	}

	public async getPayloadOfAddShot(payloadAddShot: string){ 
		let file = editJsonFile(payloadAddShot)	
		file.set("shot.meeting", Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId)
		file.set("meetingId", Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId)
		return  JSON.stringify(file.toObject())
	}


	public async getPayloadForEditingSelectedNewShot(editValue: string){
		let editPayload = `{
			"shot": ${Object.getPrototypeOf(shotsRestApi).constructor.addShotResponseBody},
			"meetingId": ${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}
		  }`;

		 let selectShotPayload = JSON.parse(editPayload);

		// Updating payload values
		selectShotPayload.shot.media = null
		selectShotPayload.shot.presenters = null
		selectShotPayload.shot.status =1
		selectShotPayload.shot.shot_data.order = 1

		if (editValue == "shotDuration"){
			selectShotPayload.shot.shot_data.shotDuration = 300
		}
		if (editValue == "shotTitle"){
			selectShotPayload.shot.shot_data.shotTitle = "New Shot 3"
		}
		return selectShotPayload
	}
}

export default new shotApi

	 Given (/^Post Load Shots$/, async function(){
		let payload = `{"meetingId": ${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}}`;
		   //@ts-ignore
		let response = await shotsRestApi.postLoadShots(browser.config.Greenroom_Api_Host,payload)
		let loadShotDetails = JSON.parse(JSON.stringify(response.body))
		for(let i = 0; i < loadShotDetails.length; i++) {
			let obj = loadShotDetails[i];
			console.log(`>>Load Shots : ${obj.shot_id}`)
		}
		chai.expect(response.status).to.equal(200)
	})

	Given (/^Add shot in builder mode$/, async function(){
		let setAddShot = "./data/jsonFiles/greenroom/payload_addShot.json"
		let file = await (new shotApi().getPayloadOfAddShot(setAddShot))
		let payload = file
	
		//@ts-ignore
		let response = await shotsRestApi.postAddShotInBuilderMode(browser.config.Greenroom_Api_Host , payload)
		chai.expect(response.status).to.equal(200)
	 })

	 Given (/^Post Bulk Edit Shots$/, async function(){

		let postBulkEditShotsPayload = `{
			"shots": ${Object.getPrototypeOf(shotsRestApi).constructor.postLoadShotResponseBody},
			"meetingId": ${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}
		  }`;

		  //@ts-ignore
		let response = await shotsRestApi.postBulkEditInBuilderMode(browser.config.Greenroom_Api_Host , postBulkEditShotsPayload)
		chai.expect(response.status).to.equal(200)
	 })

	 Given (/^Delete shot in builder mode$/, async function(){
		let payloadstring = {
			"meetingId": Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId,
			"shotId": Object.getPrototypeOf(shotsRestApi).constructor.getShotId,
		}
	  
		let payload = JSON.stringify(payloadstring) 
		//@ts-ignore
		let response = await shotsRestApi.postDeleteShot(browser.config.Greenroom_Api_Host , payload)
		chai.expect(response.status).to.equal(200)
	 })


	 Given(/^Add (.*) of newly added shot$/,async function(editType: string) {
		let payload = await (new shotApi().getPayloadForEditingSelectedNewShot(editType))
		//@ts-ignore
		let response = await shotsRestApi.postEditNewlyAddedShot(browser.config.Greenroom_Api_Host , payload)
		chai.expect(response.status).to.equal(200)
	 })

