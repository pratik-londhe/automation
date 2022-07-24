import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import HomePageUi from "../../../page-objects/streams/UI/homePageUI"

Given (/^Login to streams using UI$/, async function(){
    reporter.addStep("info", `The login to streams is in progress...`)
    //@ts-ignore
    let email = browser.config.Username
    //@ts-ignore
    let password = browser.config.Password
    //@ts-ignore
    let streams_host = browser.config.Streams_Ui_Host

    await HomePageUi.navigateToStreamsUrl(streams_host)
    await HomePageUi.streamsLoginForApp(email, password)
    reporter.addStep("info", "Streams login completed successfully...")
})

Given (/^Select the streams channel for automation$/, async function(){
    reporter.addStep("info", `The selection of streams channel is in progress...`)
    //@ts-ignore
    let channelName = browser.config.ChannelName
    await HomePageUi.selectChannelForProfile(channelName)
})

Given (/^Check the events info at the home page$/, async function(){
    reporter.addStep("info", `Checking of events at home page is in progress...`)
    let eventsIndArr = await HomePageUi.checkEventsDetailsAtHomePage("session")
    chai.expect(eventsIndArr).to.not.null
})

Given (/^Navigate to (.*) page$/, async function(option: string){
    reporter.addStep("info", `Checking of streams functional areas is in progress...`)
    await HomePageUi.checkVariousFunctions(option)
    reporter.addStep("info", `Checking of streams functional areas is completed...`)
})

Given (/^Logout of streams$/, async function(){
    reporter.addStep("info", `The logging out from streams is in progress...`)
    await HomePageUi.signoutStreamsAtHomePage()
})
