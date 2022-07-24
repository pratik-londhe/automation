import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import {v4 as uuidv4} from 'uuid'
import editJsonFile from "edit-json-file"

class EventWithBreakoutNegativeApi {

    static channelID: any
    constructor() {

    }

    public async getChannelId(channelName: string): Promise<number> {
        let allStreamsChannelsArr = Object.getPrototypeOf(HomeRestApi).constructor.getChannelsForProfileRes
        console.log(`Channels >>> ${JSON.stringify(allStreamsChannelsArr)}`)

        let channelId: number
        if (allStreamsChannelsArr.length >= 1) {
            for (let ele of allStreamsChannelsArr) {
                for (let key in ele) {
                    let keyVal = `${ele[key]}`
                    if (keyVal.match(channelName)) {
                        channelId = parseInt(`${ele['channel']}`)
                    }
                }
            }
        }
        if (!channelId) throw Error(`The channel id is ${channelId}`)

        console.log(`Channel id is: ${channelId}`)
        return channelId
    }
}
export default new EventWithBreakoutNegativeApi

Given(/^Create new "(.*)" session based event with room name null$/, async function (sessionType: string) {
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await (new EventWithBreakoutNegativeApi()).getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)
    
    let eventName = Object.getPrototypeOf(CreateEventRestApi).constructor.eventNameByApi
    let eventTemplateNum = Object.getPrototypeOf(CreateEventRestApi).constructor.eventTemplateNumber
    let sessionName = await CreateEventRestApi.generateSessionName(sessionType)

    let currentTime = Date.now() 
    console.log(`>> Current Time is ${currentTime}`)
    let sessionUuid = uuidv4()
    console.log(`>> UUID is ${sessionUuid}`)

    let file = editJsonFile(`./data/jsonFiles/streams/payload_E3_eventCreation.json`)
    file.set("channel", channelId)
    file.set("template", eventTemplateNum)
    file.set("name", eventName)
    file.set("social_settings.eventChatChannels", {created_at: currentTime, title: "Event Lobby", 
    uuid: uuidv4(), group_type: 0, channelImageUrl: ""})
    file.unset("sessions")
    
    let startTime = (new Date).getTime() + 15 * 60000
    let endTime = (new Date).getTime() + 30 * 60000
    file.append("sessions", {title: sessionName, channel: channelId, uid: sessionUuid, default_language: "en",
      session_type: "breakout-rooms", replay_on: null, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
      tracks: [], languages: ["en"], start_timestamp: startTime, end_timestamp: endTime, breakout_session: {create_room_when_full: true,
      use_zoom: false, hosts: ["brandlive.automation1@gmail.com", "pradnyan.bhilare@brandlive.com"], rooms: [{session: 0, uuid: uuidv4(),
      name: null, max_users: 15, type: "interest", image: "", imageUploading: false, nameFocused: false, video_settings: {},
      closed: false}]}})

    let payload = JSON.stringify(file.toObject())
    //@ts-ignore
    let response = await CreateEventRestApi.postCreateEvent(browser.config.Streams_Api_Host, payload)
    reporter.addStep("info", `Create event... is success.`)
    console.log(`The Status Code is: ${Object.getPrototypeOf(CreateEventRestApi).constructor.statusCode}`)
    chai.expect(Object.getPrototypeOf(CreateEventRestApi).constructor.statusCode).to.not.equals(200)
})

Given(/^Create new "(.*)" session based event without room name$/, async function (sessionType: string) {
   //@ts-ignore
   let channelName = browser.config.ChannelName
   console.log(`Validating channel name: ${channelName}`)

   let channelId = await (new EventWithBreakoutNegativeApi()).getChannelId(channelName)
   console.log(`Channel id is: ${channelId}`)
   
   let eventName = Object.getPrototypeOf(CreateEventRestApi).constructor.eventNameByApi
   let eventTemplateNum = Object.getPrototypeOf(CreateEventRestApi).constructor.eventTemplateNumber
   let sessionName = await CreateEventRestApi.generateSessionName(sessionType)

   let currentTime = Date.now() 
   console.log(`>> Current Time is ${currentTime}`)
   let sessionUuid = uuidv4()
   console.log(`>> UUID is ${sessionUuid}`)

   let file = editJsonFile(`./data/jsonFiles/streams/payload_E3_eventCreation.json`)
   file.set("channel", channelId)
   file.set("template", eventTemplateNum)
   file.set("name", eventName)
   file.set("social_settings.eventChatChannels", {created_at: currentTime, title: "Event Lobby", 
   uuid: uuidv4(), group_type: 0, channelImageUrl: ""})
   file.unset("sessions")
    
    let startTime = (new Date).getTime() + 15 * 60000
    let endTime = (new Date).getTime() + 30 * 60000
    file.append("sessions", {title: sessionName, channel: channelId, uid: sessionUuid, default_language: "en",
      session_type: "breakout-rooms", replay_on: null, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
      tracks: [], languages: ["en"], start_timestamp: startTime, end_timestamp: endTime, breakout_session: {create_room_when_full: true,
      use_zoom: false, hosts: ["brandlive.automation1@gmail.com", "pradnyan.bhilare@brandlive.com"]}})

    let payload = JSON.stringify(file.toObject())
    //@ts-ignore
    let response = await CreateEventRestApi.postCreateEvent(browser.config.Streams_Api_Host, payload)
    reporter.addStep("info", `Create event... is success.`)
    console.log(`The Status Code is: ${Object.getPrototypeOf(CreateEventRestApi).constructor.statusCode}`)
    chai.expect(Object.getPrototypeOf(CreateEventRestApi).constructor.statusCode).to.not.equals(200)
})

Given(/^Create new "(.*)" session based event with past date$/, async function (sessionType: string) {
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await (new EventWithBreakoutNegativeApi()).getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)
    
    let eventName = Object.getPrototypeOf(CreateEventRestApi).constructor.eventNameByApi
    let eventTemplateNum = Object.getPrototypeOf(CreateEventRestApi).constructor.eventTemplateNumber
    let sessionName = await CreateEventRestApi.generateSessionName(sessionType)

    let currentTime = Date.now() 
    console.log(`>> Current Time is ${currentTime}`)
    let sessionUuid = uuidv4()
    console.log(`>> UUID is ${sessionUuid}`)

    let file = editJsonFile(`./data/jsonFiles/streams/payload_E3_eventCreation.json`)
    file.set("channel", channelId)
    file.set("template", eventTemplateNum)
    file.set("name", eventName)
    file.set("social_settings.eventChatChannels", {created_at: currentTime, title: "Event Lobby", 
    uuid: uuidv4(), group_type: 0, channelImageUrl: ""})
    file.unset("sessions")
    
    file.append("sessions", {title: sessionName, channel: channelId, uid: sessionUuid, default_language: "en",
      session_type: "breakout-rooms", replay_on: null, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
      tracks: [], languages: ["en"], start_timestamp: "1655647600736", end_timestamp: "1655647600736", breakout_session: {create_room_when_full: true,
      use_zoom: false, hosts: ["brandlive.automation1@gmail.com", "pradnyan.bhilare@brandlive.com"], rooms: [{session: 0, uuid: uuidv4(),
      name: "Room1", max_users: 15, type: "interest", image: "", imageUploading: false, nameFocused: false, video_settings: {},
      closed: false}]}})

    let payload = JSON.stringify(file.toObject())
    //@ts-ignore
    let response = await CreateEventRestApi.postCreateEvent(browser.config.Streams_Api_Host, payload)
    reporter.addStep("info", `Create event... is success.`)
    console.log(`The Status Code is: ${Object.getPrototypeOf(CreateEventRestApi).constructor.statusCode}`)
    chai.expect(Object.getPrototypeOf(CreateEventRestApi).constructor.statusCode).to.not.equals(200)
})