import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import ChannelRestApi from "../../../page-objects/streams/restApi/channelRestApi"

function getPasscodeListId(): number {
    let passcodelistId: number
    let allPasscodeListArr = Object.getPrototypeOf(ChannelRestApi).constructor.getChannelPasscodeListsRes
    console.log(`Passcode Lists >>> ${JSON.stringify(allPasscodeListArr)}`)

    if(allPasscodeListArr.length >= 1) {
        for(let ele of allPasscodeListArr) {
            for(let key in ele) {
                if(key.match(`member_count`)) {
                    let keyVal= ele[key]
                    if(keyVal >= 1) {
                        passcodelistId = ele['passcode_list']
                        return passcodelistId
                    }
                }
            }
        }
    }

    return passcodelistId
}

function getChannelId(channelName: string): number {
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
    return channelId
}

Given (/^Get channel registrations$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)
    //@ts-ignore
    let response = await ChannelRestApi.getChannelRegistrations(browser.config.Streams_Api_Host, channelId)
    chai.expect(response.body.length).to.greaterThan(0)
    reporter.addStep("info", `Get all registrations for channel for streams... is success.`)
})

Given (/^Get channel registrations count$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)
    //@ts-ignore
    let response = await ChannelRestApi.getChannelRegistrationsCount(browser.config.Streams_Api_Host, channelId)
    chai.expect(response.count).to.greaterThan(0)
    reporter.addStep("info", `Get all registrations count for channel for streams... is success.`)
})

Given (/^Get channel passcode lists$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)
    //@ts-ignore
    let response = await ChannelRestApi.getChannelPasscodeLists(browser.config.Streams_Api_Host, channelId)
    chai.expect(response.length).to.greaterThan(0)
    reporter.addStep("info", `Get all passcode lists for channel... is success.`)
})

Given (/^Get channel members for passcode list$/, async function(){

    let passcodeLisId = getPasscodeListId()
    console.log(`Passcode List id is: ${passcodeLisId}`)
    //@ts-ignore
    let response = await ChannelRestApi.getPasscodeListMembers(browser.config.Streams_Api_Host, passcodeLisId)
    chai.expect(response.length).to.greaterThan(0)
    reporter.addStep("info", `Get all members of passcode list... is success.`)
})

Given (/^Get channel member count for passcode list$/, async function(){

    let passcodeLisId = getPasscodeListId()
    console.log(`Passcode List id is: ${passcodeLisId}`)
    //@ts-ignore
    let response = await ChannelRestApi.getPasscodeListMembersCount(browser.config.Streams_Api_Host, passcodeLisId)
    chai.expect(response[0].member_count).to.greaterThan(0)
    reporter.addStep("info", `Get member count of passcode list... is success.`)
})