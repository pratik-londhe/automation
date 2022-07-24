import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import editJsonFile from "edit-json-file"
import {v4 as uuidv4} from 'uuid'
import fs from "fs"

export async function createEventJsonFile(response: any) {
    if(fs.existsSync("./data/jsonFiles/streams/payload_E3_event.json")) {
        fs.rmSync("./data/jsonFiles//streams/payload_E3_event.json", {recursive:true})
    }
    fs.writeFileSync("./data/jsonFiles/streams/payload_E3_event.json", JSON.stringify(response, null, 4))
}

async function getChannelId(channelName: string): Promise<number> {
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

Given(/^Get all event templates for channel$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)
    //@ts-ignore
    let response = await CreateEventRestApi.getTemplatesForChannel(browser.config.Streams_Api_Host, channelId)
    chai.expect(response.length).to.equal(3)
    reporter.addStep("info", `Get all templates for channel for streams... is success.`)
})

Given(/^Check new event name$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)

    let eventName = await CreateEventRestApi.generateEventName()

    let payload = `{"eventName":"${eventName}","event":0,"channel":${channelId}}`;
    //@ts-ignore
    let response = await CreateEventRestApi.postCheckEventName(browser.config.Streams_Api_Host, payload)
    reporter.addStep("info", `Check event name... is success.`)
    chai.expect(response.exists).to.equal(false)
})

Given(/^Get all available tracks$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)
    //@ts-ignore
    let response = await CreateEventRestApi.getTracksForChannel(browser.config.Streams_Api_Host, channelId)
    //chai.expect(response.length).to.equal(3)
    reporter.addStep("info", `Get all tracks for channel for streams... is success.`)
})

Given(/^Create new "(.*)" session based event$/, async function(sessionType: string){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await getChannelId(channelName)
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
    if(sessionType.match("On Demand")) {
        file.append("sessions", {title: sessionName, channel: channelId, uid: sessionUuid, default_language: "en",
            session_type: "on-demand", replay_on: null, current_language: "en", on_demand: true, streaming_options: {single_stream: false},
            tracks: [], languages: ["en"] })
    }
    if(sessionType.match("Broadcast")) {
        let startTime = (new Date).getTime() + 15 * 60000
        let endTime = (new Date).getTime() + 30 * 60000
        file.append("sessions", {title: sessionName, channel: channelId, uid: sessionUuid, default_language: "en",
            session_type: "broadcast", replay_on: true, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
            tracks: [], languages: ["en"], start_timestamp: startTime, end_timestamp: endTime})
    }
    if(sessionType.match("Fireside")) {
        let startTime = (new Date).getTime() + 15 * 60000
        let endTime = (new Date).getTime() + 30 * 60000
        file.append("sessions", {title: sessionName, channel: channelId, uid: sessionUuid, default_language: "en",
            session_type: "fireside", replay_on: true, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
            tracks: [], languages: ["en"], start_timestamp: startTime, end_timestamp: endTime, firesides_hosts: ["brandlive.automation1@gmail.com",
            "pradnyan.bhilare@brandlive.com"]})
    }
    if(sessionType.match("Breakout Room")) {
        let startTime = (new Date).getTime() + 15 * 60000
        let endTime = (new Date).getTime() + 30 * 60000
        file.append("sessions", {title: sessionName, channel: channelId, uid: sessionUuid, default_language: "en",
            session_type: "breakout-rooms", replay_on: null, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
            tracks: [], languages: ["en"], start_timestamp: startTime, end_timestamp: endTime, breakout_session: {create_room_when_full: true,
            use_zoom: false, hosts: ["brandlive.automation1@gmail.com", "pradnyan.bhilare@brandlive.com"], rooms: [{session: 0, uuid: uuidv4(),
            name: "Room1", max_users: 15, type: "interest", image: "", imageUploading: false, nameFocused: false, video_settings: {},
            closed: false}]}})
    }        

    let payload = JSON.stringify(file.toObject())
    //@ts-ignore
    let response = await CreateEventRestApi.postCreateEvent(browser.config.Streams_Api_Host, payload)
    reporter.addStep("info", `Create event... is success.`)
    chai.expect(response.channel).to.equal(channelId)
    chai.expect(response.name).to.equal(eventName)
})

Given(/^Get new event by event uuid$/, async function(){

    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.postCreateEventRes
    let eventUuid = newEventJson.uuid
    let channelId = newEventJson.channel
    let eventName = newEventJson.name

    //@ts-ignore
    let response = await CreateEventRestApi.getEventDetailsByUuid(browser.config.Streams_Api_Host, eventUuid)
    await createEventJsonFile(response)
    chai.expect(response.channel).to.equal(channelId)
    chai.expect(response.name).to.equal(eventName)
    chai.expect(response.uuid).to.equal(eventUuid)
    reporter.addStep("info", `Get new event details... is success.`)
})

Given(/^Check url for the new event$/, async function(){

    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    let eventId = newEventJson.event
    let channelId = newEventJson.channel
    let eventName = newEventJson.name
    let eventNamePath = eventName.replaceAll(/\ /g, "-")
    console.log(`>> Event Name: ${eventName}`)
    console.log(`>> Event Path: ${eventNamePath}`)
    //@ts-ignore
    let channel_host = browser.config.Channel_Live_Host

    let payload = `{"hostname":"${channel_host}","pathname":"${eventNamePath}","event":${eventId},"channel":${channelId}}`;

    //@ts-ignore
    let response = await CreateEventRestApi.postCheckEventPathUrl(browser.config.Streams_Api_Host, payload)
    reporter.addStep("info", `Check event url... is success.`)
    chai.expect(response.exists).to.equal(false)
})

Given(/^Create new all sessions based event$/, async function(){
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)
    let eventName = Object.getPrototypeOf(CreateEventRestApi).constructor.eventNameByApi
    let eventTemplateNum = Object.getPrototypeOf(CreateEventRestApi).constructor.eventTemplateNumber
    let odSessionName = await CreateEventRestApi.generateSessionName("On Demand")
    let bcSessionName = await CreateEventRestApi.generateSessionName("Broadcast")
    let brSessionName = await CreateEventRestApi.generateSessionName("Breakout Room")
    let fsSessionName = await CreateEventRestApi.generateSessionName("Fireside")
    let currentTime = Date.now() 
    console.log(`>> Current Time is ${currentTime}`)
    let startTime = (new Date).getTime() + 15 * 60000
    let endTime = (new Date).getTime() + 30 * 60000
    let sessionUuid = uuidv4()
    console.log(`>> UUID is ${sessionUuid}`)

    let file = editJsonFile(`./data/jsonFiles/streams/payload_E3_eventCreation.json`)
    file.set("channel", channelId)
    file.set("template", eventTemplateNum)
    file.set("name", eventName)
    file.set("social_settings.eventChatChannels", {created_at: currentTime, title: "Event Lobby", 
    uuid: uuidv4(), group_type: 0, channelImageUrl: ""})
    file.unset("sessions")

    file.append("sessions", {title: odSessionName, channel: channelId, uid: sessionUuid, default_language: "en",
        session_type: "on-demand", replay_on: null, current_language: "en", on_demand: true, streaming_options: {single_stream: false},
        tracks: [], languages: ["en"] })

    file.append("sessions", {title: bcSessionName, channel: channelId, uid: sessionUuid, default_language: "en",
        session_type: "broadcast", replay_on: true, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
        tracks: [], languages: ["en"], start_timestamp: startTime, end_timestamp: endTime})

    file.append("sessions", {title: fsSessionName, channel: channelId, uid: sessionUuid, default_language: "en",
        session_type: "fireside", replay_on: true, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
        tracks: [], languages: ["en"], start_timestamp: startTime, end_timestamp: endTime, firesides_hosts: ["brandlive.automation1@gmail.com",
        "pradnyan.bhilare@brandlive.com"]})

    file.append("sessions", {title: brSessionName, channel: channelId, uid: sessionUuid, default_language: "en",
        session_type: "breakout-rooms", replay_on: null, current_language: "en", on_demand: false, streaming_options: {single_stream: false},
        tracks: [], languages: ["en"], start_timestamp: startTime, end_timestamp: endTime, breakout_session: {create_room_when_full: true,
        use_zoom: false, hosts: ["brandlive.automation1@gmail.com", "pradnyan.bhilare@brandlive.com"], rooms: [{session: 0, uuid: uuidv4(),
        name: "Room1", max_users: 15, type: "interest", image: "", imageUploading: false, nameFocused: false, video_settings: {},
        closed: false}]}})
      
    let payload = JSON.stringify(file.toObject())
    //@ts-ignore
    let response = await CreateEventRestApi.postCreateEvent(browser.config.Streams_Api_Host, payload)
    reporter.addStep("info", `Create event... is success.`)
    chai.expect(response.channel).to.equal(channelId)
    chai.expect(response.name).to.equal(eventName)
})