import { Given, When, Then } from "@cucumber/cucumber";
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import chai from "chai";
import editJsonFile from "edit-json-file";
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import { v4 as uuidv4 } from 'uuid'
import reporter from "../../../utils/reporter";

class AddODSessionWithNoRegLPApi {

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
export default new AddODSessionWithNoRegLPApi

Given(/^Add Event with "(.*)" session and No registration and No LP$/, async function (sessionType: string) {
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await (new AddODSessionWithNoRegLPApi()).getChannelId(channelName)
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
    file.set("homepage", false)
    file.set("registration_on", false)
    file.set("social_settings.eventChatChannels", {
        created_at: currentTime, title: "Event Lobby",
        uuid: uuidv4(), group_type: 0, channelImageUrl: ""
    })
    file.unset("sessions")
    file.append("sessions", {
        title: sessionName, channel: channelId, uid: sessionUuid, default_language: "en",
        session_type: "on-demand", replay_on: null, current_language: "en", on_demand: true, streaming_options: { single_stream: false },
        tracks: [], languages: ["en"]
    })

    let payload = JSON.stringify(file.toObject())
    //@ts-ignore
    let response = await CreateEventRestApi.postCreateEvent(browser.config.Streams_Api_Host, payload)
    chai.expect(response.body).to.not.null
    console.log(`>> Response of event creation with on demand session with No reg,LP and home page: ${JSON.stringify(response)}`)
    reporter.addStep("info", `On demand session is created with no Reg, LP and Home page... is success.`)
})