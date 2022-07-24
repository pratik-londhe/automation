import { Given, When, Then } from "@cucumber/cucumber";
import reporter from "../../../utils/reporter"
import EventTemplateSelection from "../../../page-objects/streams/UI/eventTemplateSelection"
import EventCreation from "../../../page-objects/streams/UI/eventCreation"
import HomePageUi from "../../../page-objects/streams/UI/homePageUI"


Given(/^Create event3.0 with broadcast session$/, async function () {
    reporter.addStep("info", `Creating an event with broadcast session is in progress...`)
    await HomePageUi.clickOnCreateEventButton()
    await EventTemplateSelection.selectEventTemplateAtRandom()
    await EventCreation.createEventWithBroadcastSession(true, true)
    reporter.addStep("info", "Event created successfylly...")
})
