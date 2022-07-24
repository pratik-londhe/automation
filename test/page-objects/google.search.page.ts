import Page from "./page"
import reporter from "../utils/reporter"

class GoogleSearchPage extends Page {
    constructor(){
        super()
    }

    // page objects
    get googleSearchInputBox() {return $(`[name=q]`)}
    get googleSearchedResultLink() {return $(`<h3>`)}

    // page object methods
    async navigateToGoogleSearchPage(path: string) {
        if(!path) throw Error(`Given path ${path} is not valid`)
        try{
            await this.navigateTo(path)
            //reporter.addStep("NA", "info", "Google page loaded successfully")
            reporter.addStep("info", "Google page loaded successfully")
        }catch(err){
            err.message = `Error entering url: , ${err.message} `
            throw err
        }
    }

    async searchItemAtGoogleSearchPage(text: string) {
        if(!text) throw Error(`Given search text ${text} is not valid`)
        try{
            await this.typeInto(await this.googleSearchInputBox, text)
            //reporter.addStep("NA", "info", `Search text ${text} entered successfully`)
            reporter.addStep("info", `Search text ${text} entered successfully`)
        }catch(err){
            err.message = `Error entering search text: , ${err.message} `
            throw err
        }
    }

    async clickSearchedItemAtGoogleSearchPage() {
        try{
            await this.click(await this.googleSearchedResultLink)
            //reporter.addStep("NA", "info", "Searched text clicked successfully")
            reporter.addStep("info", "Searched text clicked successfully")
        }catch(err){
            err.message = `Error clicking searched text: , ${err.message} `
            throw err
        }
    }

    async retriveBrowserUrl() {
        try{
            let actualUrl = await this.browserUrl()
            //reporter.addStep("NA", "info", `Browser url ${actualUrl} retrieved successfully`)
            reporter.addStep("info", `Browser url ${actualUrl} retrieved successfully`)
            return actualUrl
        }catch(err){
            err.message = `Error retrieving url: , ${err.message} `
            throw err
        }
    }
}

export default new GoogleSearchPage()