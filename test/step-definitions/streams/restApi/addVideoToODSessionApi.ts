import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import fs from "fs"
import sessionRestApi from "../../../page-objects/streams/restApi/sessionRestApi";
import editJsonFile from "edit-json-file";
import AddVideoToODSessionRestApi from "../../../page-objects/streams/restApi/addVideoToODSessionRestApi";

class AddVideoToODSessionApi {

    constructor() {

    }

    async updateSessionJsonFile(response: any) {
        if (fs.existsSync("./data/jsonFiles/streams/payload_E3_session.json")) {
            fs.rmSync("./data/jsonFiles/streams/payload_E3_session.json", { recursive: true })
        }
        fs.writeFileSync("./data/jsonFiles/streams/payload_E3_session.json", JSON.stringify(response, null, 4))
    }
}
export default new AddVideoToODSessionApi

Given(/^Get session details by id$/, async function () {
    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    console.log(`>> Response of events details: ${JSON.stringify(newEventJson)}`)
    let sessionID = newEventJson.sessions[0].session
    console.log(`>> Session details by session id: ${sessionID}`)

    //@ts-ignore
    let response = await sessionRestApi.getSessionDetails(browser.config.Streams_Api_Host, sessionID)
    chai.expect(response.body).to.not.null
    await (new AddVideoToODSessionApi()).updateSessionJsonFile(response)
})

Given(/^Add video to a session$/, async function () {
    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    let channelId = newEventJson.channel

    //@ts-ignore
    let response = await AddVideoToODSessionRestApi.getChannelDetails(browser.config.Streams_Api_Host, channelId)
    let channelUuid = response[0].uuid

    let file = editJsonFile(`./data/jsonFiles/streams/payload_E3_session.json`)
    file.unset("on_demand_video")
    file.set("on_demand_video", [{
        "channel": channelId,
        "status": 1,
        "archived": false,
        "base_language": "en",
        "created_by": 7768,
        "created_at": "2022-04-26T23:50:29.788Z",
        "modified_by": null,
        "modified_at": null,
        "video": 996,
        "type": "uploaded",
        "source": "https://brandlive-upload.s3-us-west-2.amazonaws.com/uploads/uploads/101287/854e53d7-0bf2-4278-82b2-79fdf426bb74/Sample1_16.mp4",
        "image": "https://brandlive-upload.s3-us-west-2.amazonaws.com/uploads/101287/5577f74c-a591-4ce0-9afc-e5695087d9e4/thumbnail.jpg",
        "name": "Sample1_16.mp4",
        "module_id": 33762,
        "original_image": "https://brandlive-upload.s3-us-west-2.amazonaws.com/uploads/101287/5577f74c-a591-4ce0-9afc-e5695087d9e4/thumbnail.jpg",
        "use_thumbnail": false,
        "convert_job": "arn:aws:mediaconvert:us-west-2:111776770072:jobs/1651017029676-2is1be",
        "hls_link": "https://brandlive-upload.s3-us-west-2.amazonaws.com/uploads/uploads/101287/854e53d7-0bf2-4278-82b2-79fdf426bb74/converted.m3u8",
        "convert_status": 1,
        "duration": 30,
        "convert_progress": null,
        "is_fireside": false,
        "uuid": channelUuid,
        "session_language": "en"
    }])

    let payload = `{"session":${JSON.stringify(file.toObject())}}`

    //@ts-ignore
    let responseAddVideo = await AddVideoToODSessionRestApi.addVideoToSession(browser.config.Streams_Api_Host, payload)
    chai.expect(responseAddVideo.body).to.not.null
    console.log(`>> Response of existing video to a session: ${JSON.stringify(responseAddVideo)}`)
    reporter.addStep("info", `Session is updated with exisiting video... is success.`)
})

Given(/^Start action$/, async function () {
    let payload = `{"target_id_string": "on-demand","target_type": "video","action_id": "12f979f9-f886-4a5a-a765-bcc54aee2c87", "bl_profile":0,"channel_id":0,"event_id":0,"registration_id":"","source_app":"events","source_app_version":"3.1.2","user_session_uuid":"","action":"start","action_type":"passive","miscellaneous":"{\"relative_timestamp\":0}"}`

    //@ts-ignore
    let response = await AddVideoToODSessionRestApi.videoAction(browser.config.Streams_Live_Api_Host, payload)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Start Action on the video... is success.`)
})

Given(/^Milestone action$/, async function () {
    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    let channelId = newEventJson.channel

    //@ts-ignore
    let channelResponse = await AddVideoToODSessionRestApi.getChannelDetails(browser.config.Streams_Api_Host, channelId)
    let channelUuid = channelResponse[0].uuid

    let payload = `{"target_id_string":"on-demand","target_type":"video","action_id":"23d4c7ca-0328-4d63-8bed-35bb573226c1","bl_profile":0,"channel_id":0,"event_id":0,"registration_id":"","source_app":"events","source_app_version":"3.1.2","user_session_uuid":"","playedSeconds":3.838307,"action":"milestone","action_type":"passive","miscellaneous":"{\"milestone\":{\"channel\":${channelId},\"status\":1,\"archived\":false,\"base_language\":\"en\",\"created_by\":7768,\"created_at\":\"2022-04-26T23:50:29.788Z\",\"modified_by\":null,\"modified_at\":null,\"video\":996,\"type\":\"uploaded\",\"source\":\"https://brandlive-upload.s3-us-west-2.amazonaws.com/uploads/uploads/101287/854e53d7-0bf2-4278-82b2-79fdf426bb74/Sample1_16.mp4\",\"image\":\"https://brandlive-upload.s3-us-west-2.amazonaws.com/uploads/101287/5577f74c-a591-4ce0-9afc-e5695087d9e4/thumbnail.jpg\",\"name\":\"Sample1_16.mp4\",\"module_id\":33762,\"original_image\":\"https://brandlive-upload.s3-us-west-2.amazonaws.com/uploads/101287/5577f74c-a591-4ce0-9afc-e5695087d9e4/thumbnail.jpg\",\"use_thumbnail\":false,\"convert_job\":\"arn:aws:mediaconvert:us-west-2:111776770072:jobs/1651017029676-2is1be\",\"hls_link\":\"https://brandlive-upload.s3-us-west-2.amazonaws.com/uploads/uploads/101287/854e53d7-0bf2-4278-82b2-79fdf426bb74/converted.m3u8\",\"convert_status\":1,\"duration\":30,\"convert_progress\":null,\"is_fireside\":false,\"uuid\":${channelUuid},\"session_language\":\"en\",\"languageSelection\":null,\"playedSeconds\":3.838307,\"played\":0.12765988087937652}}"}`

    //@ts-ignore
    let response = await AddVideoToODSessionRestApi.videoAction(browser.config.Streams_Live_Api_Host, payload)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Milestones Action on the video... is success.`)
})

Given(/^End action$/, async function () {
    let payload = `{"target_id_string":"on-demand","target_type":"video","action_id":"de55bdb0-169b-4f9e-9caf-9ae43aeb2bdc","bl_profile":0,"channel_id":0,"event_id":0,"registration_id":"","source_app":"events","source_app_version":"3.1.2","user_session_uuid":"","action":"end","action_type":"passive","miscellaneous":"{\"relative_timestamp\":0}"}`

    //@ts-ignore
    let response = await AddVideoToODSessionRestApi.videoAction(browser.config.Streams_Live_Api_Host, payload)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `End Action on the video... is success.`)
})
