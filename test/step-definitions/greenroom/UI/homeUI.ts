import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import HomePageUi from "../../../page-objects/greenroom/UI/homePageUI"

Given (/^Login to greenroom app: (.*) as (.*)$/, async function(app: string, role: string){
    reporter.addStep("info", `The log in to greenroom is in progress...`)
    //@ts-ignore
    let email = browser.config.Username
    //@ts-ignore
    let password = browser.config.Password
    //@ts-ignore
    let greenroom_host = browser.config.Greenroom_Ui_Host

    switch(role.toLowerCase()) {
        case "producer":
            reporter.addStep("info", `The role value is ${role}...`)
            let url = `${greenroom_host}/producer`
            await HomePageUi.navigateToGreenroomUrl(url)
            await HomePageUi.checkGreenroomAppAccessForProfile(email)
            await HomePageUi.appSelectionForGreenroom(app)
            await HomePageUi.greenroomLoginForApp(email, password)
            break;
        case "presenter":
            reporter.addStep("info", `The role value is ${role}...`)
            let presenterUrl = `${greenroom_host}`
            await HomePageUi.navigateToGreenroomUrl(presenterUrl)
            await HomePageUi.greenroomLoginForApp(email, password)
            await HomePageUi.confirmPresenterDetails()
            break;
        default:
            reporter.addStep("info", `The role value ${role} is not valid...`)
            break;
    }
})

Given (/^Select the channel for automation$/, async function(){
    reporter.addStep("info", `The selection of greenroom channel is in progress...`)
    //@ts-ignore
    let channelName = browser.config.ChannelName
    await HomePageUi.selectChannelForProfile(channelName)
})

Given (/^Check header info at the home page$/, async function(){
    reporter.addStep("info", `The checking of home page header for greenroom is in progress...`)
    try {
        let name = await HomePageUi.checkHomeHeaderInfo()
        //@ts-ignore
        let channelName = browser.config.ChannelName
        chai.expect(name).to.equal(channelName)
    } catch (err) {
        err.message = `Error with assertion: , ${err.message} `
        throw err
    }
})

Given (/^Search "(.*)" team member at team menu$/, async function(filter: string){
    reporter.addStep("info", `Searching of member at team is in progress...`)
    await HomePageUi.searchTeamMemberAtHomePage(filter)
})

Given (/^Search "(.*)" show at shows menu$/, async function(filter: string){
    reporter.addStep("info", `Searching of show at All Shows is in progress...`)
    await HomePageUi.searchShowAtHomePage(filter)
})

Given (/^Check profile: "(.*)" option$/, async function(option: string){
    reporter.addStep("info", `Checking of profile options is in progress...`)
    await HomePageUi.selectProfileOptionAndFormClosure(option)
})

Given (/^Sign out the greenroom$/, async function(){
    reporter.addStep("info", `Signing out from greenroom is in progress...`)
    await HomePageUi.signoutGreenroomAtHomePage()
})
