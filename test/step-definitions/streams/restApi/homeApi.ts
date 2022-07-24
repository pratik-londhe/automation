import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"

Given (/^Login to streams$/, async function(){
    //@ts-ignore
    let email = browser.config.Username
    //@ts-ignore
    let password = browser.config.Password
    let payload = `{"email":"${email}", "password":"${password}", "two_factor_stored":""}`;
    //@ts-ignore
    let response = await HomeRestApi.postLoginToStreams(browser.config.Streams_Api_Host, payload)
    reporter.addStep("info", `Login to streams... is success.`)
    chai.expect(response.token).to.not.null
})

Given (/^Get streams channels by profile$/, async function(){
    //@ts-ignore
    let response = await HomeRestApi.getChannelsForProfile(browser.config.Streams_Api_Host)
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)
    console.log(`There are ${response.length} channels`)
    chai.expect(response.length).to.greaterThanOrEqual(1)
    reporter.addStep("info", `Get profile channels... is success.`)

    if(response.length >= 1) {
        for(let ele of response) {
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

Given (/^Get all events for channel for streams$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)
    let allStreamsChannelsArr = Object.getPrototypeOf(HomeRestApi).constructor.getChannelsForProfileRes
    console.log(`Channels >>> ${JSON.stringify(allStreamsChannelsArr)}`)

    let channelId: number
    if(allStreamsChannelsArr.length >= 1) {
        for(let ele of allStreamsChannelsArr) {
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
    let response = await HomeRestApi.getEventsForChannel(browser.config.Streams_Api_Host, channelId)
    chai.expect(response.body.length).to.greaterThanOrEqual(1)
    reporter.addStep("info", `Get all events for channel for streams... is success.`)
})