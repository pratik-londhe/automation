import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import chatDrawer from "../../../page-objects/greenroom/UI/chatDrawer";
import reporter from "../../../utils/reporter"

Given (/^Open Chat Drawer$/, async function(){
    reporter.addStep("info", `Opening chat drawer...`)
    await chatDrawer.navigateToChatDrawer()
})

Given (/^Send a message to one of the presenter$/, async function(){
    reporter.addStep("info", `Sending msg to presenter...`)
	let inputChat = "This is test msg"
    await chatDrawer.sendMsgInChat(inputChat)
})

Given (/^Open Presenter Group Chat$/, async function(){
    reporter.addStep("info", `Open Presenter Group Chat...`)
    await chatDrawer.openPresenterGroupChat()
})

Given (/^Validate chat notification on chat drawer$/, async function(){
    reporter.addStep("info", `Validating chat notification...`)
    await chatDrawer.validateChatNotificationOnChatDrawer()

})

Given (/^Validate chat toast notification on chat drawer$/, async function(){
    reporter.addStep("info", `Validating toast notification...`)
    await chatDrawer.validateChatNotificationOnChatDrawer()
})

Given (/^Refresh the page$/, async function(){
    reporter.addStep("info", `Validating toast notification...`)
	await browser.refresh()
})

Given (/^Validate sent message in group chat$/, async function(){
    reporter.addStep("info", `Validating chat notification...`)
    await chatDrawer.validateChatMessage()
	chai.expect(Object.getPrototypeOf(chatDrawer).constructor.chatMessageValue).to.be.equal("This is test msg")

})

