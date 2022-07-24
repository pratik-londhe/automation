import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import IntegrationRestApi from "../../../page-objects/streams/restApi/integrationRestApi";
import HomeRestApi from "../../../page-objects/streams/restApi/homeRestApi"


Given(/^Get channel integrations solution details$/, async function () {
    //@ts-ignore
    let response = await IntegrationRestApi.getChannelIntegrationsSolution(browser.config.Streams_Api_Host)
    chai.expect(response.length).to.greaterThan(0)
    reporter.addStep("info", `Get all channel level integration solution details... is success.`)
})

Given(/^Create the channel level integration user$/, async function () {
    //@ts-ignore
    let channelName = browser.config.ChannelName
    console.log(`Validating channel name: ${channelName}`)

    let channelJson = Object.getPrototypeOf(HomeRestApi).constructor.getChannelsForProfileRes
    console.log(`>> Response of channel details: ${JSON.stringify(channelJson)}`)

    let channelID = channelJson[0].channel
    console.log(`>> Channel ID details: ${channelID}`)

    let uuid = channelJson[0].uuid
    console.log(`>> Channel uuid details: ${uuid}`)

    let payload = `{"channel": ${channelID},"name":"${channelName}","uuid":"${uuid}"}`;

    //@ts-ignore
    let response = await IntegrationRestApi.createChannelIntegrationUser(browser.config.Streams_Api_Host, payload)
    chai.expect(response.trayID).to.not.null
    reporter.addStep("info", `Create channel level integrations user creation details... is success.`)
})

Given(/^Get channel integrations solution instances details$/, async function () {
    let newUserJson = Object.getPrototypeOf(IntegrationRestApi).constructor.integrationUserRes
    console.log(`>> Response of user details: ${JSON.stringify(newUserJson)}`)

    let trayID = newUserJson.tray_id
    console.log(`>> Tray id details: ${trayID}`)

    //@ts-ignore
    let response = await IntegrationRestApi.getChannelIntegrationsSolutionInstances(browser.config.Streams_Api_Host, trayID)
    chai.expect(response.length).to.greaterThan(0)
    reporter.addStep("info", `Get all channel level integration solution instances details... is success.`)
})

Given(/^Create integrations solution instances$/, async function () {
    let newUserJson = Object.getPrototypeOf(IntegrationRestApi).constructor.integrationUserRes
    console.log(`>> Response of user details: ${JSON.stringify(newUserJson)}`)

    let channelID = newUserJson.channel
    console.log(`>> ChannelID ID details: ${channelID}`)

    let userID = newUserJson.tray_id
    console.log(`>> User/Tray ID details: ${userID}`)

    let solutionRes = Object.getPrototypeOf(IntegrationRestApi).constructor.getChannelIntegrationsSolutionsRes
    console.log(`>> Response of integrations solution details: ${JSON.stringify(solutionRes)}`)

    let solutionID = solutionRes[0].id
    console.log(`>> Solution ID details: ${solutionID}`)

    let solutionName = solutionRes[0].title
    console.log(`>> Solution Name details: ${solutionName}`)

    let payload = `{"channel": ${channelID},"userId":"${userID}","solutionId":"${solutionID}", "solutionName":"${solutionName}", "type": 1, "trayUser": ${JSON.stringify(newUserJson)}}`;

    //@ts-ignore
    let response = await IntegrationRestApi.createIntegrationSolutionInstances(browser.config.Streams_Api_Host, payload)
    chai.expect(response.instance.id).to.not.null
    reporter.addStep("info", `Create channel level integration solution instances details... is success.`)
})

Given(/^Get integrations auth window details$/, async function () {
    let createSolutionJson = Object.getPrototypeOf(IntegrationRestApi).constructor.createSolutionInstancesRes
    console.log(`>> Response of create solution instances details: ${JSON.stringify(createSolutionJson)}`)

    let trayID = createSolutionJson.user.tray_id
    console.log(`>> Tray id details: ${trayID}`)

    let instanceID = createSolutionJson.instance.id
    console.log(`>> Instance ID details: ${instanceID}`)
    //@ts-ignore
    let response = await IntegrationRestApi.getChannelIntegrationsAuthWindowDetails(browser.config.Streams_Api_Host, trayID, instanceID)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Get all channel level integration auth window details... is success.`)
})

Given(/^Get the passcode details by channel Id$/, async function () {
    let createSolutionJson = Object.getPrototypeOf(IntegrationRestApi).constructor.createSolutionInstancesRes
    console.log(`>> Response of create solution instances details: ${JSON.stringify(createSolutionJson)}`)

    let channelID = createSolutionJson.user.channel
    console.log(`>> Channel ID details: ${channelID}`)

    //@ts-ignore
    let response = await IntegrationRestApi.getPassCodeListDetailsByChannelID(browser.config.Streams_Api_Host, channelID)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Get all channel level Passcode details... is success.`)
})

Given(/^Get the passcode encrypt details by channel Id and passcode list$/, async function () {
    let passcodeDetailsRes = Object.getPrototypeOf(IntegrationRestApi).constructor.passcodeListRes
    console.log(`>> Response of passcode list details: ${JSON.stringify(passcodeDetailsRes)}`)

    let passcode_List = passcodeDetailsRes[0].passcode_list
    console.log(`>> Passcode List details: ${passcode_List}`)

    let createSolutionJson = Object.getPrototypeOf(IntegrationRestApi).constructor.createSolutionInstancesRes
    console.log(`>> Response of create solution instances details: ${JSON.stringify(createSolutionJson)}`)

    let channelID = createSolutionJson.user.channel
    console.log(`>> Channel ID details: ${channelID}`)

    //@ts-ignore
    let response = await IntegrationRestApi.getPasscodeListEncryptDetailsByChannelIDandPassList(browser.config.Streams_Api_Host, channelID, passcode_List)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Get all channel level Passcode encrypt details... is success.`)
})

Given(/^Update the solution instances$/, async function () {
    let passcodeListEncryptRes = Object.getPrototypeOf(IntegrationRestApi).constructor.passcodeListEncryptRes
    console.log(`>> Response of Passcode list encrypt details: ${JSON.stringify(passcodeListEncryptRes)}`)

    let configValue = passcodeListEncryptRes.encryptedString
    console.log(`>> Config value details: ${configValue}`)

    let createSolutionJson = Object.getPrototypeOf(IntegrationRestApi).constructor.createSolutionInstancesRes
    console.log(`>> Response of create solution instances details: ${JSON.stringify(createSolutionJson)}`)

    let trayID = createSolutionJson.user.tray_id
    console.log(`>> Tray id details: ${trayID}`)

    let instanceID = createSolutionJson.instance.id
    console.log(`>> Instance ID details: ${instanceID}`)

    let payload = `{"userId": "${trayID}","instanceId":"${instanceID}","configName": "external_passcode","configValue":"${configValue}"}`;

    //@ts-ignore
    let response = await IntegrationRestApi.updateIntegrationSolutionInstances(browser.config.Streams_Api_Host, payload)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Update solution Instances details... is success.`)
})

Given(/^Toggle instance of any Integrations$/, async function () {
    let createSolutionJson = Object.getPrototypeOf(IntegrationRestApi).constructor.createSolutionInstancesRes
    console.log(`>> Response of create solution instances details: ${JSON.stringify(createSolutionJson)}`)

    let trayID = createSolutionJson.user.tray_id
    console.log(`>> Tray id details: ${trayID}`)

    let instanceID = createSolutionJson.instance.id
    console.log(`>> Instance ID details: ${instanceID}`)

    let channelID = createSolutionJson.user.channel
    console.log(`>> Channel ID details: ${channelID}`)

    let payload = `{"userId": "${trayID}","channel":${channelID},"type": 2, "instanceId":"${instanceID}", "enabled": true}`;

    //@ts-ignore
    let response = await IntegrationRestApi.toggleInstanceOfIntegration(browser.config.Streams_Api_Host, payload)
    chai.expect(response.body).to.not.null
    reporter.addStep("info", `Toggling instance details... is success.`)
})