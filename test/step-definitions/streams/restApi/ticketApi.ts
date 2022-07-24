import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import TicketApi from "../../../page-objects/streams/restApi/ticketRestApi"

Given (/^Get confirmation from the Stripe$/, async function(){
     //@ts-ignore
     let response = await TicketApi.getStripeStatus(browser.config.Streams_Api_Host)
     chai.expect(response.stripe_status).to.equal("ready");
     reporter.addStep("info", `Get confirmation from the Stripe... is success.`)
})

Given (/^Get exhange rate information$/, async function(){
    //@ts-ignore
    let response = await TicketApi.getExchangeRate(browser.config.Streams_Api_Host);
    const conversionRateObj = Object.keys(response.conversion_rates);
    chai.expect(conversionRateObj.length).to.greaterThan(0)
    reporter.addStep("info", `Get exhange rate information... is success.`)
})


Given (/^Get all global currencies for event$/, async function(){
    //@ts-ignore
    let response = await TicketApi.getGlobalCurrencies(browser.config.Streams_Api_Host);
    chai.expect(response.length).to.greaterThan(0);
    reporter.addStep("info", `Get all global currencies for event... is success.`)
})

