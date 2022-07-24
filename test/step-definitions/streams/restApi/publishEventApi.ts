import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import CreateEventRestApi from "../../../page-objects/streams/restApi/createEventRestApi"
import PublishEventRestApi from "../../../page-objects/streams/restApi/publishEventRestApi"

Given(/^Get event publish status by event uuid$/, async function(){

    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.postCreateEventRes
    let eventUuid = newEventJson.uuid

    //@ts-ignore
    let response = await PublishEventRestApi.getPublishStatusByUuid(browser.config.Streams_Api_Host, eventUuid)
    chai.expect(response.status).to.not.null
    let status: number = response.status
    console.log(`>> status: ${status}`)
    if(status === 1) {
        chai.expect(response.url).to.not.null
    }
    reporter.addStep("info", `Get publish status... is success.`)
})

Given(/^Publish event$/, async function(){

    let newEventJson = Object.getPrototypeOf(CreateEventRestApi).constructor.postCreateEventRes
    let eventUuid = newEventJson.uuid
    let eventName = newEventJson.name
    let eventNamePath = eventName.replaceAll(/(\ |,|\/|:|\\s)+/g, "-")

    let payload = `{"uuid":"${eventUuid}","url":"${eventNamePath}"}`;

    //@ts-ignore
    let response = await PublishEventRestApi.postPublishEvent(browser.config.Streams_Api_Host, payload)
    chai.expect(response.uuid).to.not.null
    reporter.addStep("info", `Publish event... is success.`)
})