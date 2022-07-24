import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import RegistrationRestApi from "../../../page-objects/streams/restApi/registrationRestApi"
import UpdateEventRestApi from "../../../page-objects/streams/restApi/updateEventRestApi"
import editJsonFile from "edit-json-file"

async function getEventUuid(): Promise<string> {
    let eventDetails = Object.getPrototypeOf(CreateEventRestApi).constructor.getEventDetailsByUuidRes
    console.log(`Event >>> ${JSON.stringify(eventDetails)}`)

    let eventUuid: string = eventDetails.uuid
    if(!eventUuid) throw Error(`The event Uuid is ${eventUuid}`)

    return eventUuid
}

async function getPayloadForUpdateEvent(): Promise<string> {
    let file = editJsonFile(`./data/jsonFiles/streams/payload_E3_event.json`)
    file.unset("registration_steps")
    file.append("registration_steps", {isOn: true, type: "general", questions: [{registration_question: 1, channel: 0, name: "First Name",
        type: "text", options: null, global: true, persistent: true, default_value: null}, {registration_question: 2, channel: 0, name: "Last Name",
        type: "text", options: null, global: true, persistent: true, default_value: null}, {registration_question: 3, channel: 0, name: "Email Address",
        type: "email", options: null, global: true, persistent: true, default_value: null}] })
    file.append("registration_steps", {isOn: true, type: "profile", questions: [{registration_question: 6, channel: 0, name: "Company Name",
        type: "text", options: null, global: true, persistent: true, default_value: null}, {registration_question: 4, channel: 0, name: "Bio",
        type: "textarea", options: null, global: true, persistent: false, default_value: null}, {registration_question: 9, channel: 0, name: "Fun Fact",
        type: "text", options: null, global: true, persistent: false, default_value: null}] })
    file.append("registration_steps", {isOn: true, type: "avatar"}) 

    return JSON.stringify(file.toObject())
}

Given (/^Update registration profile and avatar steps to event$/, async function(){

    let eventUuid = await getEventUuid()
    console.log(`Event Uuid is: ${eventUuid}`)

    let generalStep = `{"isOn":true,"type":"general","questions":[1,2,3]}`
    let profileStep = `{"isOn":true,"type":"profile","questions":[6,4,9]}`
    let avatarStep = `{"isOn":true,"type":"avatar"}`

    let payload = `{"event_uuid":"${eventUuid}","updated_steps":[${generalStep},${profileStep},${avatarStep}]}`

    //@ts-ignore
    let response = await RegistrationRestApi.putRegistrationSteps(browser.config.Streams_Api_Host, payload)
    chai.expect(response.status).to.equals(200)

    payload = `{"event": ${await getPayloadForUpdateEvent()}}`

    //@ts-ignore
    response = await UpdateEventRestApi.putUpdateEventWithRegistrationSteps(browser.config.Streams_Api_Host, payload)
    chai.expect(response.text).to.equals("OK")

    reporter.addStep("info", `Update registration steps for event... is success.`)
})

Given (/^Get registration questions for event$/, async function(){
    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.postCreateEventRes
    let eventUuid = newEventJson.uuid
    let channelId = newEventJson.channel

    //@ts-ignore
    let response = await RegistrationRestApi.getRegistrationQuestions(browser.config.Streams_Api_Host, channelId, eventUuid);
    chai.expect(response).length.greaterThan(0);
    reporter.addStep("info", `Get registration questions for event... is success.`)
})