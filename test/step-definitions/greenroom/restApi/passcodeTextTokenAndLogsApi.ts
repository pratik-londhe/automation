import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"

import passcodeTextTokenAndLogsRestApi from "../../../page-objects/greenroom/restApi/passcodeTextTokenAndLogsRestApi";

class passcodeTextTokenAndLogsApi {

	static passcode: any
	static opentok_session: any

    constructor() {

    }
}
export default new passcodeTextTokenAndLogsApi

Given (/^Create greenroom passcode details$/, async function(){
	//@ts-ignore
	let response = await passcodeTextTokenAndLogsRestApi.updatePasscode(browser.config.Greenroom_Api_Host)
	console.log(response.passcode);
	
	passcodeTextTokenAndLogsApi.passcode = response.passcode
	passcodeTextTokenAndLogsApi.opentok_session = response.opentok_session
		
	chai.expect(response.passcode).to.be.not.null
	chai.expect(response.opentok_session).to.be.not.null

	reporter.addStep("info", `Passcode : ${passcodeTextTokenAndLogsApi.passcode}!`)
	reporter.addStep("info", `Open_tok session : ${passcodeTextTokenAndLogsApi.opentok_session}`)

	reporter.addStep("info", `Get greenroom passcode details is success!`)
})


Given (/^Get greenroom passcode details$/, async function(){
	//@ts-ignore
	let response = await passcodeTextTokenAndLogsRestApi.getPasscode(browser.config.Greenroom_Api_Host)
	chai.expect(response.status).to.equals(200)
	reporter.addStep("info", `Update greenroom passcode details is success!`)
})


Given (/^Delete greenroom passcode details$/, async function(){
	//@ts-ignore
	let response = await passcodeTextTokenAndLogsRestApi.deletePasscode(browser.config.Greenroom_Api_Host)
    chai.expect(response.status).to.equals(200)
	reporter.addStep("info", `Delete greenroom passcode details is success!`)
})


Given (/^Send Email Text Link$/, async function(){
	//@ts-ignore
	let email = browser.config.Username
	let jsonString = {"email":email}
	let payload = JSON.stringify(jsonString)
	//@ts-ignore
	let response = await passcodeTextTokenAndLogsRestApi.sendEmailTextLink(browser.config.Greenroom_Api_Host,payload)
	chai.expect(response.status).to.equals(200)
	reporter.addStep("info", `Send Email Text Link is success!`)
})


Given (/^Send Phone Text Link$/, async function(){
	let jsonString = {"phone":999999999}
	let payload = JSON.stringify(jsonString)

	//@ts-ignore
	let response = await passcodeTextTokenAndLogsRestApi.sendPhoneTextLink(browser.config.Greenroom_Api_Host,payload)
	chai.expect(response.status).to.equals(200)
	reporter.addStep("info", `Send Phone Text Link is success!`)
})

Given (/^Refresh Bl-Token$/, async function(){
	//@ts-ignore
	let response = await passcodeTextTokenAndLogsRestApi.refreshToken(browser.config.Greenroom_Api_Host)
	chai.expect(response['newToken']).to.be.not.null
	reporter.addStep("info", `New Token : ${response['newToken']}`)
	reporter.addStep("info", `Refresh Bl-Token is success!`)
})

Given (/^Get Tokbox Session$/, async function(){
	//@ts-ignore
	let response = await passcodeTextTokenAndLogsRestApi.getTokboxSession(browser.config.Greenroom_Api_Host)
	chai.expect(response.sessionId).to.be.not.null
	reporter.addStep("info", `Tok Box Session Id : ${response.sessionId}`)
	reporter.addStep("info", `Get Tokbox Session is success!`)
})

Given (/^Post Logs$/, async function(){
	//@ts-ignore
	let email = browser.config.Username

	let gr_user = await passcodeTextTokenAndLogsRestApi.getGrUserProfile(email)

	let payloadstring = {"gr_user": gr_user}

	let payload = JSON.stringify(payloadstring)

	//@ts-ignore

	let response = await passcodeTextTokenAndLogsRestApi.postLogs(browser.config.Greenroom_Api_Host,payload)
	chai.expect(response.status).to.equals(200)
	reporter.addStep("info", `Post Logs is success!`)
})


Given (/^Get Logs$/, async function(){
	//@ts-ignore
	let response = await passcodeTextTokenAndLogsRestApi.getLogs(browser.config.Greenroom_Api_Host)
	chai.expect(response).to.be.empty
	reporter.addStep("info", `Delete greenroom passcode details is success!`)
})