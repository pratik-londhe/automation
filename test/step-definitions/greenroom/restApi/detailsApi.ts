import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import DetailsPageRestApi from "../../../page-objects/greenroom/restApi/detailsPageRestApi"
import StandaloneHomeRestApi from "../../../page-objects/greenroom/restApi/standaloneHomeRestApi"
import reporter from "../../../utils/reporter"


Given (/^Send inviations to presenter using meeting id$/, async function(){
    let payload = `{
        "meeting": "${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}",
        "channel_name": "Brandlive QA Automation I",
        "title": "InvitationsApi",
        "channel": ${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.channelId},
        "invitations": [
          {
            "email": "brandlive.automation1@gmail.com",
            "watcher_only": false
          }
        ]
      }`;
       //@ts-ignore
    let response = await DetailsPageRestApi.postCreateInvitations(browser.config.Greenroom_Api_Host,payload)
   chai.expect(response.status).to.equal(200)
})

Given (/^Get inviations using room id$/, async function(){
    //@ts-ignore
    let response = await DetailsPageRestApi.getDetailsByInvitationsByRoomId(browser.config.Greenroom_Api_Host)
   chai.expect(response.status).to.equal(200)
})

Given (/^Create log for a meeting message type (.*)$/, async function(type: string){
  //@ts-ignore
  let email = browser.config.Username

  let gr_user = await StandaloneHomeRestApi.getGrUserProfile(email)

  let message = "";

  if (type == 'producer_connected') {
	  message = `{\"producer_connected\":${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId}`
  }
  else if (type == 'load_meeting') {
	 message = `${JSON.stringify(Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getDetailsByMeetingId)}`	
  }
  else if (type == 'socket_connected'){
	  message = `{\"socket_connected\": ${await DetailsPageRestApi.generateRandomString()}}`
  }
  else if (type == 'connected_users'){
	  message = `{\"connected_users\": [${gr_user}]}`
  }

  let payloadstring = {
      "gr_user":gr_user,
      "user_agent":'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.36',
      "meeting":Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRMeetingId,
      "invitation":null,
      "url":`https://greenroom.brandlive-qa.com/producer/${Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getNewSGRSlugMeetingId}`,
      "type":type,
      "is_reload":false,
      "message":message,
      "local_session": await DetailsPageRestApi.generateRandomString()
  }

  let payload = JSON.stringify(payloadstring) 
  
  //@ts-ignore
  let response = await StandaloneHomeRestApi.postJoinRoomCreateLog(browser.config.Greenroom_Api_Host,payload)
  chai.expect(response.status).to.equal(200)  
})


Given (/^Get Request State Sync$/, async function(){
   //@ts-ignore
   let response = await DetailsPageRestApi.requestStateSync(browser.config.Greenroom_Sync_Host)
   chai.expect(response.status).to.equal(200)
})


Given (/^Get Graphics Details$/, async function(){

	//@ts-ignore
	let response = await DetailsPageRestApi.getGraphicsDetails(browser.config.Greenroom_Api_Host)
	let getGraphicId = JSON.parse(JSON.stringify(response.body))
	for(let i = 0; i < getGraphicId.length; i++) {
		let obj = getGraphicId[i];
		console.log(`>>Graphic Shot Id : ${obj.id}`)
	}
	chai.expect(response.status).to.equal(200)

})

Given (/^Get Show Sessions$/, async function(){
		
	//@ts-ignore
	let response = await DetailsPageRestApi.getShowSessions(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)

})

Given (/^Get media all meeting background$/, async function(){
		
	//@ts-ignore
	let response = await DetailsPageRestApi.getAllMeetingBackground(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)

})

Given (/^Get presenter messages$/, async function(){
		
	//@ts-ignore
	let response = await DetailsPageRestApi.getPresenterMsgs(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)

})

Given (/^Get Join Request by meeting id$/, async function(){
		
	//@ts-ignore
	let response = await DetailsPageRestApi.joinRequestByMeetingId(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)

})

Given (/^Post Tokbox token$/, async function(){
	let openTokSession = JSON.stringify(Object.getPrototypeOf(StandaloneHomeRestApi).constructor.getDetailsByMeetingId['opentok_session'])
	let payload = `{"sessionId": ${openTokSession}}`;
	//@ts-ignore
	let response = await DetailsPageRestApi.postTokBoxToken(browser.config.Greenroom_Api_Host,payload)
	console.log("Tok box token : ", JSON.parse(JSON.stringify(response.body.token)));
	chai.expect(response.status).to.equal(200)
})

Given (/^Get Green Room Notification$/, async function(){
		
	//@ts-ignore
	let response = await DetailsPageRestApi.getGrNotifications(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)
})

Given (/^Get all session types$/, async function(){
	//@ts-ignore
	let response = await DetailsPageRestApi.getSessionTypes(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equal(200)
})
