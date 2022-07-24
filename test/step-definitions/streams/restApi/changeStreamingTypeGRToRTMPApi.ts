import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import ChangeStreamingTypeGRToRTMPRestApi from "../../../page-objects/streams/restApi/changeStreamingTypeGRToRTMPRestApi"
import reporter from "../../../utils/reporter";
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"

class ChangeStreamingTypeGRToRTMPApi {

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
export default new ChangeStreamingTypeGRToRTMPApi

Given(/^Get products details by channel id$/, async function () {
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelId = await (new ChangeStreamingTypeGRToRTMPApi()).getChannelId(channelName)
    console.log(`Channel id is: ${channelId}`)

    //@ts-ignore
    let response = await ChangeStreamingTypeGRToRTMPRestApi.getProductsDetails(browser.config.Streams_Api_Host, channelId)
    chai.expect(response.body).to.not.null
    console.log(`>> Response products details: ${JSON.stringify(response)}`)
    reporter.addStep("info", `Product details... is success.`)
})

Given(/^Get secondary video details by session id$/, async function () {
    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    console.log(`>> Response of events details: ${JSON.stringify(newEventJson)}`)
    let sessionID = newEventJson.sessions[0].session
    console.log(`>> Session details by session id: ${sessionID}`)

    //@ts-ignore
    let response = await ChangeStreamingTypeGRToRTMPRestApi.getSecondaryVideoDetails(browser.config.Streams_Api_Host, sessionID)
    chai.expect(response.body).to.not.null
    console.log(`>> Response secondary video details: ${JSON.stringify(response)}`)
    reporter.addStep("info", `Response secondary video... is success.`)
})