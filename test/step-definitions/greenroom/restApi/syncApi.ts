
import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import liveModeApi from "./liveModeApi";
import writeStateRestApi from "../../../page-objects/greenroom/restApi/syncApiRest";
import editJsonFile from "edit-json-file";
import standaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi";
import liveModeRestApi from "../../../page-objects/greenroom/restApi/liveModeRestApi";

class syncApi{
	static mediaDetails = Object.getPrototypeOf(liveModeRestApi).constructor.getMediaDetailsResponse

    constructor(){

    }

	public async getIntroMediaId() {
		let mediaDetails = await syncApi.mediaDetails
		return mediaDetails[0].id
	 }
	
	 
	 public async getIntroMediaImageArray() {
		let mediaDetails = await syncApi.mediaDetails
		return mediaDetails[0].media_data.image_array
	}
	
	public async getIntroMediaName() {
		let mediaDetails = await syncApi.mediaDetails
		return mediaDetails[0].custom_name
	}

	public async getPayloadOfSetPresenterMedia(payloadWritePresenterVideo: string,action_type: string, greenroom_mode: string){ 
		let file = editJsonFile(payloadWritePresenterVideo)	
		file.set("room", Object.getPrototypeOf(standaloneHomeRestApi).constructor.getNewSGRMeetingId)
		file.set("timestamp", new Date().valueOf())
		file.unset("action")
	
		
		let action = 
		 {
			"type": action_type,
			"payload": [
			  {
				"mediaId": new syncApi().getIntroMediaId,
				"presentedBy": 0,
				"pages": new syncApi().getIntroMediaImageArray,
				"currentPage": 1,
				"background_color": "",
				"fill": false,
				"name": new syncApi().getIntroMediaId
			  }
			]
		  }
	
		file.set("action",action)			
		return  JSON.stringify(file.toObject())
	}

	public async getNegativeTestPayloadOfWriteState(payloadWritePresenterVideo: string,action_type: string){ 
		let file = editJsonFile(payloadWritePresenterVideo)	
		file.set("room", 1)
		file.set("timestamp", new Date().valueOf())		
		return 
	}
}

export default new syncApi
   
  
Given(/^Write State for (.*) in (.*) mode$/, async function(action_type: string, greenroom_mode: string){

	let setPresentedMedia = "./data/jsonFiles/greenroom/payload_write_state_set_presented_media.json"
	let file = await (new syncApi().getPayloadOfSetPresenterMedia(setPresentedMedia,action_type,greenroom_mode))
	let payload = file

	//@ts-ignore
	let response = await writeStateRestApi.writeSetPresenterMedia(browser.config.Greenroom_Sync_Host , payload)
	chai.expect(response.status).to.equal(200)
	reporter.addStep("info", `Write State for ${action_type} in ${greenroom_mode} is success!`)
	
 })

 
 Given(/^Pass incorrect JSON file$/, async function(){

	let mockJsonFile = editJsonFile("./data/jsonFiles/greenroom/payload_write_state_set_presented_media.json")
	mockJsonFile.set("room", 1)
	mockJsonFile.unset("stateData")
	mockJsonFile.set("timestamp", new Date().valueOf())	
	let payload =  JSON.stringify(mockJsonFile.toObject())

	//@ts-ignore
	let response = await writeStateRestApi.writeSetPresenterMedia(browser.config.Greenroom_Sync_Host , payload)
	chai.expect(response.status).to.equal(400)
	chai.expect(response.text).to.equal('{"Error":"Client sent write-state with room:1, stateData:undefined, session:0, action:[object Object]"}')
	console.log(response.text)

 })


 Given(/^Pass incorrect data inside JSON file$/, async function(){

	let mockJsonFile = editJsonFile("./data/jsonFiles/greenroom/payload_write_state_set_presented_media.json")
	mockJsonFile.unset("stateData")
	let mockStateData = {
	"stateData":{
		"staiteVar":"",
		"reducer":"",
		"conditional":null,
		"resetOnEmpty":null
	 }}
	mockJsonFile.set("room", 1)
	mockJsonFile.unset("stateData")
	mockJsonFile.set("stateData",mockStateData)
	mockJsonFile.set("timestamp", new Date().valueOf())	
	let payload =  JSON.stringify(mockJsonFile.toObject())

	//@ts-ignore
	let response = await writeStateRestApi.writeSetPresenterMedia(browser.config.Greenroom_Sync_Host , payload)
	chai.expect(response.status).to.equal(500)
	chai.expect(response.text).to.equal('{"Error":"Could not write state"}')
	console.log(response.text)

	
 })





