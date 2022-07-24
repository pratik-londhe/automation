import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import DuplicateDeleteRestApi from "../../../page-objects/streams/restApi/duplicateDeleteRestApi"

class DuplicateDeleteEvents {

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
export default new DuplicateDeleteEvents

Given(/^Duplicate the event$/, async function () {
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    DuplicateDeleteEvents.channelID = await (new DuplicateDeleteEvents()).getChannelId(channelName)
    console.log(`Channel id is: ${DuplicateDeleteEvents.channelID}`)

    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    console.log(`>> Response of events details by event uuid: ${JSON.stringify(newEventJson)}`)

    let eventUuid = newEventJson.uuid
    console.log(`>> Events uuid: ${eventUuid}`)

    let payload = `{"channel":${DuplicateDeleteEvents.channelID}}`;

    //@ts-ignore
    let response = await DuplicateDeleteRestApi.duplicateTheEvent(browser.config.Streams_Api_Host, eventUuid, payload)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Get the duplicate event details... is success.`)
})

Given(/^Delete the duplicated event$/, async function () {
    let duplicateEventRes = Object.getPrototypeOf(DuplicateDeleteRestApi).constructor.duplicateEventRes
    console.log(`>> Response of duplicate event details: ${JSON.stringify(duplicateEventRes)}`)

    let eventUuid = duplicateEventRes.uuid
    console.log(`>> Duplicate Events uuid: ${eventUuid}`)

    //@ts-ignore
    let response = await DuplicateDeleteRestApi.DeleteDuplicateEvent(browser.config.Streams_Api_Host, eventUuid)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Get the deleted duplicate event details... is success.`)
})