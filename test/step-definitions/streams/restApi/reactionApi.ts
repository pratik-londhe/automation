import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import ReactionRestApi from "../../../page-objects/streams/restApi/reactionRestApi";
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import fs from "fs"
import sessionRestApi from "../../../page-objects/streams/restApi/sessionRestApi";
import editJsonFile from "edit-json-file";

class ReactionApi {

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

    async updateSessionJsonFile(response: any) {
        if (fs.existsSync("./data/jsonFiles/streams/payload_E3_session.json")) {
            fs.rmSync("./data/jsonFiles/streams/payload_E3_session.json", { recursive: true })
        }
        fs.writeFileSync("./data/jsonFiles/streams/payload_E3_session.json", JSON.stringify(response, null, 4))
    }
}
export default new ReactionApi

Given(/^Get channel reactions$/, async function () {
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    ReactionApi.channelID = await (new ReactionApi()).getChannelId(channelName)
    console.log(`Channel id is: ${ReactionApi.channelID}`)
    //@ts-ignore
    let response = await ReactionRestApi.getChannelReactions(browser.config.Streams_Api_Host, ReactionApi.channelID)
    chai.expect(response.length).to.greaterThan(0)
    reporter.addStep("info", `Get all channel level reactions... is success.`)
})

Given(/^Get session by id$/, async function () {
    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    console.log(`>> Response of events details: ${JSON.stringify(newEventJson)}`)
    let sessionID = newEventJson.sessions[0].session
    console.log(`>> Session details by session id: ${sessionID}`)

    //@ts-ignore
    let response = await sessionRestApi.getSessionDetails(browser.config.Streams_Api_Host, sessionID)
    chai.expect(response.body).to.not.null
    await (new ReactionApi()).updateSessionJsonFile(response)
})

Given(/^Update reactions to the session$/, async function () {
    let channelReactionRes = Object.getPrototypeOf(ReactionRestApi).constructor.getChannelResponceRes
    console.log(`>> Response of channel level reaction details: ${JSON.stringify(channelReactionRes)}`)
    let reactionURL = channelReactionRes[0].url
    console.log(`>> Reaction URL details: ${reactionURL}`)

    let file = editJsonFile(`./data/jsonFiles/streams/payload_E3_session.json`)
    file.unset("reaction_settings")
    file.set("reaction_settings",{
        "enabled": false, 
        "show_descriptions": false,
        "reactions":[ {enabled: "true", color: "#000000", opacity: 0, name: "Custom",
        url: reactionURL, 
        description: ""}]
    })
    
    let payload = `{"session":${JSON.stringify(file.toObject())}}`

    //@ts-ignore
    let response = await ReactionRestApi.updateReactionsToSession(browser.config.Streams_Api_Host, payload)
    chai.expect(response.body).to.not.null
    console.log(`>> Response of session updates with reaction: ${JSON.stringify(response)}`)
    reporter.addStep("info", `Session is updated with reactions... is success.`)
})