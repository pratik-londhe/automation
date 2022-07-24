import { Given, When, Then } from "@cucumber/cucumber";
import reporter from "../../../utils/reporter"
import EventTemplateSelection from "../../../page-objects/streams/UI/eventTemplateSelection"
import EventCreation from "../../../page-objects/streams/UI/eventCreation"
import EventHeader from "../../../page-objects/streams/UI/eventHeader"
import HomePageUi from "../../../page-objects/streams/UI/homePageUI"


Given(/^Create event3.0 with on demand session$/, async function () {
    reporter.addStep("info", `Creating an event with on demand session is in progress...`)
    await HomePageUi.clickOnCreateEventButton()
    await EventTemplateSelection.selectEventTemplateAtRandom()
    await EventCreation.createEventWithOnDemandSession(true, true)
    reporter.addStep("info", "Event created successfylly...")
})

Given(/^publish an event3.0$/, async function () {
    reporter.addStep("info", `The event push is in progress...`)
    await EventHeader.publishEvent()
})
