import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import logger from "../../utils/logger";
import allure from "@wdio/allure-reporter";
import reporter from "../../utils/reporter"
import GoogleSearchPage from "../../page-objects/google.search.page"
import Reqres from "../../utils/api/reqres"
import cloudflareParameters from "../../utils/cloudflareParameters"

class demo {

    static browserConfig: any
    constructor(){

    }
}

export default new demo

Given (/^Google page is opened$/, async function() {
    logger.info(`Opening Google Page... `)
    allure.addStep(`Opening Google Page... `)
    // console.log(`QA Url: ${process.env.QA_Greenroom_Url}`)
    // console.log(`QA User: ${process.env.QA_Greenroom_User}`)
    // console.log(`QA Password: ${process.env.QA_Greenroom_Password}`)

    await GoogleSearchPage.navigateToGoogleSearchPage("https://www.google.com/")
    // await browser.url("https://www.google.com/")
    // await browser.pause(5000)

    // @ts-ignore
    console.log(`Environment: ${browser.config.Environment}`)
    // @ts-ignore
    console.log(`Username: ${browser.config.Username}`)
    // @ts-ignore
    console.log(`Password: ${browser.config.Password}`)
    // @ts-ignore
    console.log(`Greenroom Url: ${browser.config.Greenroom_Ui_Host}`)
    // @ts-ignore
    console.log(`Streams Url: ${browser.config.Streams_Ui_Host}`)
    // @ts-ignore
    console.log(`Config Values: ${JSON.stringify(browser.config)}`)
    demo.browserConfig = `${JSON.stringify(browser.config)}`

    logger.info(`Google page opened successfully... `)
    allure.addStep(`Google page opened successfully... `)
})

When (/^Search with (.*)$/, async function(searchItem) {
    logger.info(`Searching item at the Google page... `)
    allure.addStep(`Searching item at the Google page... `)

    console.log(`>> Search Item: ${searchItem}`);
    await GoogleSearchPage.searchItemAtGoogleSearchPage(searchItem)
    // let ele = await $(`[name=q]`)
    // await ele.setValue(searchItem)
    await browser.keys("Enter")
    await browser.pause(3000)

    logger.info(`Item searched successfully... `)
    allure.addStep(`Item searched successfully... `)
})

Then (/^Click on first search result$/, async function(){
    logger.info(`Clicking at the searched results... `)
    allure.addStep(`Clicking at the searched results... `)

    await GoogleSearchPage.clickSearchedItemAtGoogleSearchPage()
    // let ele = await $(`<h3>`)
    // ele.click()
    await browser.pause(1000)

    logger.info(`Clicked at the searched results... `)
    allure.addStep(`Clicked at the searched results... `)
})

Then (/^URL should match (.*)$/, async function(ExpectedURL) {
    try {
        logger.info(`Matching url... `)
        allure.addStep(`Matching url... `)

        console.log(`>> Expected URL: ${ExpectedURL}`);
        let browserUrl = await GoogleSearchPage.retriveBrowserUrl()
        // let url = await browser.getUrl()
        chai.expect(ExpectedURL).to.equal(browserUrl)

        let browserConfig = demo.browserConfig
        console.log(`>> Browser Config is: ${browserConfig}`)

        logger.info(`Matched url successfully... `)
        allure.addStep(`Matched url successfully... `)
    } catch (err) {
        console.log(`>> The type of error: ${typeof err}`)
        console.log(`>> The error name: ${err.name}`)
        console.log(`>> The error message: ${err.message}`)
    }
})

/*
* Web Interactions
*/
Given (/^A web page is opened$/, async function(datatable) {
    //reporter.addStep("NA", "info", "Opening a web page... ")
    reporter.addStep("info", "Opening a web page... ")

    await browser.url("https://the-internet.herokuapp.com/")
    await browser.setTimeout({implicit: 5000, pageLoad: 3000})
    await browser.maximizeWindow()

    let dt = datatable.hashes()
    console.log(`Datatable first Username: ${dt[0].Username}`)
    console.log(`Datatable first Password: ${dt[0].Password}`)
    console.log(`Datatable second Username: ${dt[1].Username}`)
    console.log(`Datatable second Password: ${dt[1].Password}`)

    //reporter.addStep("NA", "info", "Web page opened successfully... ")
    reporter.addStep("info", "Web page opened successfully... ")
})

When (/^Perform web interactions$/, async function() {
    let inputs = await $(`=Inputs`)
    await inputs.click()
    let number = await $(`//input`)
    await number.setValue("500")
    await browser.pause(3000)
    await number.clearValue()

    let num = 501
    let numStr = num.toString()
    await number.click()
    for(let i=0; i<numStr.length; i++) {
        let char = numStr.charAt(i)
        await browser.pause(1000)
        await browser.keys(char)
    }
    await browser.pause(3000)
    await browser.back()
    await browser.pause(1000)

    let dropdown = await $(`=Dropdown`)
    await dropdown.click()
    await browser.pause(1000)

    let selectedOption = await $(`//select[@id="dropdown"]/option[1]`)  
    let selectedValue = await selectedOption.getText()
    chai.expect(selectedValue).to.equal("Please select an option")
    let options = await $$(`//select[@id="dropdown"]/option`)
    for(let j=1; j<options.length; j++) {
        console.log("The option value is " + (await options[j].getAttribute("value")).toString())
        await browser.pause(1000)
        await options[j].click()
    }
    await browser.pause(3000)
    await browser.back()
    await browser.pause(1000)

    let checkbox = await $(`=Checkboxes`)
    await checkbox.click()
    await browser.pause(1000)

    let checkboxes = await $$(`//form[@id="checkboxes"]/input`)
    if(!await checkboxes[0].isSelected())
        checkboxes[0].click()
        await browser.pause(1000)
    
    chai.expect(await checkboxes[0].isSelected()).to.be.true   
    await browser.pause(3000)
    await browser.back()
    await browser.pause(1000)

    let windows = await $(`=Multiple Windows`)
    await windows.click()

    let clickHere = await $(`=Click Here`)
    clickHere.click()
    let mainWinTitle = await browser.getTitle()
    console.log(`Main window title: ${mainWinTitle}`)
    let mainHandle = await browser.getWindowHandle()

    let handles = await browser.getWindowHandles()
    for(let k=0; k<handles.length; k++) {
        await browser.switchToWindow(handles[k])
        if((await browser.getTitle()).match("New Window")){  
            await browser.pause(2000)
            await browser.closeWindow()
            break;
        }
    }
    await browser.switchToWindow(mainHandle)
    await browser.pause(2000)
    await browser.back()
    await browser.pause(1000)

    await $(`=JavaScript Alerts`).click()
    await browser.pause(1000)
    let button1 = await $(`button=Click for JS Alert`)
    button1.click()
    await browser.pause(1000)
    if((await browser.getAlertText()).match("I am a JS Alert")){
        await browser.acceptAlert()
        chai.expect(await $(`#result`).getText()).to.equal("You successfully clicked an alert")
        await browser.pause(1000)
    }

    let button2 = await $(`button=Click for JS Confirm`)
    button2.click()
    await browser.pause(1000)
    if((await browser.getAlertText()).match("I am a JS Confirm")){
        await browser.acceptAlert()
        chai.expect(await $(`#result`).getText()).to.equal("You clicked: Ok")
        await browser.pause(1000)
    }

    let button3 = await $(`button=Click for JS Prompt`)
    button3.click()
    await browser.pause(1000)
    if((await browser.getAlertText()).match("I am a JS Prompt")){
        let alertText = "Hello World!";
        await browser.sendAlertText(alertText)
        await browser.pause(1000)
        chai.expect(await $(`#result`).getText()).to.equal(`You entered: ${alertText}`)
        await browser.pause(1000)
    }
    await browser.back()
    await browser.pause(2000)

    await $(`=File Upload`).click()
    await browser.pause(1000)

    await $(`#file-upload`).addValue(`${process.cwd()}/data/fileUpload/file1.txt`)
    await browser.pause(1000)
    await $(`#file-submit`).click()
    await browser.pause(1000)
    await browser.back()
    await browser.pause(1000)
    await browser.back()
    await browser.pause(2000)

    await $(`=Frames`).click()
    await browser.pause(1000)

    await $(`=iFrame`).click()
    await browser.pause(1000)
    let iframe = await $(`#mce_0_ifr`)
    await browser.switchToFrame(iframe)
    await $(`#tinymce`).setValue("Entering a new value...")
    await browser.pause(3000)
    await browser.keys(["Meta", "A"])
    await browser.keys("Delete")
    await $(`#tinymce`).addValue("Using add value ...")
    await browser.pause(3000)
    await browser.switchToParentFrame()
    await browser.back()
    await browser.pause(1000)
    await browser.back()
    await browser.pause(2000)
})

/*
* APIs
*/
Given (/^Get user details by page number: (.*)$/, async function(pageNumber){
    console.log(`The page number is ${pageNumber}`)
    let url = "https://reqres.in";
    let endpoint = "/api/users"
    let queryParam = "page="+pageNumber;
    // let parameters = await cloudflareParameters.getCloudflareParameters(endpoint)
    // console.log(`Cloudflare parameters are: Mac=>${parameters[0]} and Expiry=>${parameters[1]}`)
    await cloudflareParameters.generateCloudflareParameters(endpoint)
    console.log(`Cloudflare parameters are: Mac=>${cloudflareParameters.mac} and Expiry=>${cloudflareParameters.expiry}`)
    let res = await Reqres.getUserDetailsByPageNumber(url, endpoint, queryParam)
    //reporter.addStep("NA", "info", `Get user details by page number ${pageNumber}... is success.`)
    reporter.addStep("info", `Get user details by page number ${pageNumber}... is success.`)
    chai.expect(res.total).to.equal(12)
})

Given (/^Add new user$/, async function(datatable){
    let data = datatable.hashes()
    let url = "https://reqres.in";
    let endpoint = "/api/register"
    let payload = `{"email":"${data[0].Email}", "password":"${data[0].Password}"}`
    let res = await Reqres.postNewUser(payload, url, endpoint)
    //reporter.addStep("NA", "info", `Add new user... is success.`)
    reporter.addStep("info", `Add new user... is success.`)
    chai.expect(res).to.contain("\"token\":\"QpwL5tke4Pnpja7X4\"")
})