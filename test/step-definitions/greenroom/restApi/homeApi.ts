import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import HomeRestApi from "../../../page-objects/greenroom/restApi/homeRestApi"

Given (/^Check producer app access$/, async function(){
    //@ts-ignore
    let email = browser.config.Username
    let payload = `{"email":"${email}"}`;
    //@ts-ignore
    let response = await HomeRestApi.postCheckAppsForProducer(browser.config.Greenroom_Api_Host, payload)
    reporter.addStep("info", `Check producer app access... is success.`)
    chai.expect(response.events_producer).to.be.true
})

Given (/^Login to greenroom with (.*)$/, async function(appName: string){
    //@ts-ignore
    let email = browser.config.Username
    //@ts-ignore
    let password = browser.config.Password
    let payload = `{"email":"${email}", "password":"${password}", "app":"${appName}", "storedTwoFactorEvents":null}`;
    //@ts-ignore
    let response = await HomeRestApi.postLoginToGreenroomWithAppByProducer(browser.config.Greenroom_Api_Host, payload)
    reporter.addStep("info", `Login to app by producer... is success.`)
    chai.expect(response.token).to.not.null
})

Given (/^Get greenroom channels by profile$/, async function(){
    //@ts-ignore
    let response = await HomeRestApi.getChannelsForProfile(browser.config.Greenroom_Api_Host)
    let channelArr = response.events_channels
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)
    console.log(`There are ${channelArr.length} channels`)
    chai.expect(channelArr.length).to.greaterThanOrEqual(1)
    reporter.addStep("info", `Get profile channels... is success.`)

    if(channelArr.length >= 1) {
        for(let ele of channelArr) {
            for(let key in ele) {
                let keyVal = `${ele[key]}`
                if(keyVal.match(channelName)) {
                    reporter.addStep("info", `Get profile channels and check channel name... is success.`)
                    chai.expect(keyVal).to.equal(channelName)
                }
            }
        }
    }
})

Given (/^Get show session types$/, async function(){
   //@ts-ignore
   let response = await HomeRestApi.getSessionTypes(browser.config.Greenroom_Api_Host)
   chai.expect(response.length).to.equal(4)
   reporter.addStep("info", `Get show session types... is success.`)
   let sessionTypeArr = []
   if(response.length > 1) {
       for(let ele of response) {
           for(let key in ele) {
               if(key.match("name")) {
                sessionTypeArr.push(ele[key])
               }
           }
       }
   }
   console.log(`SessionTypeArray >> ${sessionTypeArr}`)
   chai.expect(sessionTypeArr).to.contains("rehearsal" && "tech check" && "recording" && "broadcast")
})

Given (/^Get all events for channel for greenroom$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)
    let allGreenroomChannels = Object.getPrototypeOf(HomeRestApi).constructor.getChannelsForProfileRes
    let channelArr = allGreenroomChannels.events_channels
    console.log(`Channels >>> ${JSON.stringify(channelArr)}`)

    let channelId: number
    if(channelArr.length >= 1) {
        for(let ele of channelArr) {
            for(let key in ele) {
                let keyVal = `${ele[key]}`
                if(keyVal.match(channelName)) {
                    channelId = parseInt(`${ele['channel']}`)
                }
            }
        }
    }
    if(!channelId) throw Error(`The channel id is ${channelId}`)

    console.log(`Channel id is: ${channelId}`)
    //@ts-ignore
    let response = await HomeRestApi.getEventsForChannel(browser.config.Greenroom_Api_Host, channelId)
    chai.expect(response.body.length).to.greaterThanOrEqual(1)
    reporter.addStep("info", `Get all events for channel... is success.`)
})

Given (/^Get broadcast check by meeting id$/, async function(){
    //@ts-ignore
    let response = await HomeRestApi.getBroadcastCheckByMeetingId(browser.config.Greenroom_Api_Host)
    chai.expect(response.status).to.equal(200)
 })

 Given (/^Get greenroom profiles$/, async function(){
    //@ts-ignore
    let response = await HomeRestApi.getGreenroomProfiles(browser.config.Greenroom_Api_Host)
    chai.expect(response.status).to.equal(200)
 })

 Given (/^Post load teams$/, async function(){
    let payload = `{
        "channels":{
           "events_channels":[
              
           ],
           "events_legacy_channels":[
              
           ],
           "gr_channels":[
              
           ]
        }
     }`;
      //@ts-ignore
    let response = await HomeRestApi.postLoadTeams(browser.config.Greenroom_Api_Host,payload)
    chai.expect(response.status).to.equal(200)
 })
 

