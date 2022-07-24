import Page from "../../page"
import reporter from "../../../utils/reporter"

class HomePageUi extends Page {

    constructor(){
        super()
    }

    // Page Objects
    get appLoginEmailInputBox() {return $(`//input[@type='email']`)}
    get appLoginPasswordInputBox() {return $(`//input[@type='password']`)}
    get appLoginButton() {return $(`//button[@class='primary']`)}  
    get appChannelButton() {return $(`//div[@class='navigation-dropdown channels']/button`)}
    get appChannelListButtons() {return $$(`//div[@class='navdrop-list']//label`)}
    get appProfileButton() {return $(`//div[@class='profile-pic']/*`)}
    get appLogoutButton() {return $(`//div[@class='profile-details-wrapper open ']//button`)}

    // page objects - Events 
    get totalEventsIndicator() {return $(`//div[@class='events-header-container']//div[1]/div[2]/h3`)}
    get totalViewsIndicator() {return $(`//div[@class='events-header-container']//div[2]/div[2]/h3`)}
    get averageDurationIndicator() {return $(`//div[@class='events-header-container']//div[3]/div[2]/h3`)}
    get liveEventsButton() {return $(`(//div[@class='tab-wrapper']//div[@class='tab-header-buttons']//button)[1]`)}
    get upcomingEventsButton() {return $(`(//div[@class='tab-wrapper']//div[@class='tab-header-buttons']//button)[2]`)}
    get pastEventsButton() {return $(`(//div[@class='tab-wrapper']//div[@class='tab-header-buttons']//button)[3]`)}
    get odEventsButton() {return $(`(//div[@class='tab-wrapper']//div[@class='tab-header-buttons']//button)[4]`)}
    get eventsSearch() {return $(`//div[@class='search-input']//input`)}
    get eventsSortDropdown() {return $(`//div[@class='select-container']//div[@class='select-dropdown noMaxHeight']`)}
    get listCardView() {return $(`//div[@class='icon-toggle']//label[1]`)}
    get thumbCardView() {return $(`//div[@class='icon-toggle']//label[2]`)}

    // Left Nav Options
    get eventsTabButton() {return $(`//div[@class='admin-nav']//a[1]`)}
    get analyticsTabButton() {return $(`//div[@class='admin-nav']//a[2]`)}
    get peopleTabButton() {return $(`//div[@class='admin-nav']//a[3]`)}
    get contentTabButton() {return $(`//div[@class='admin-nav']//a[4]`)}
    get productsTabButton() {return $(`//div[@class='admin-nav']//a[5]`)}  
    get profilePageButton() {return $(`//div[@class='profile-details-wrapper open ']//a[1]`)}
    get integrationsPageButton() {return $(`//div[@class='profile-details-wrapper open ']/ul/li[1]/a`)}
    get settingsPageButton() {return $(`//div[@class='profile-details-wrapper open ']/ul/li[2]/a`)}

    // Create Event Button
    get createDropDown() { return $(`//button[@class='create-dropdown']`) }
    get createEventButton() { return $(`//a[@class='create-event']`) }

    // Products Details
    get productsTab() { return $(`//a[@href='/admin/products']`) }

    // Content Details
    get contentTab() { return $(`//a[@href='/admin/content']`) }

    // Page Object Methods
    async navigateToStreamsUrl(path: string) {
        if(!path) throw Error(`Given path ${path} is not valid`)

        try{
            await this.navigateTo(path)
            await browser.pause(2000)
            reporter.addStep("info", "Streams page loaded successfully")
        }catch(err){
            err.message = `Error entering url: , ${err.message} `
            throw err
        }
    }

    async streamsLoginForApp(email: string, password: string) {
        try {
            await this.typeInto(await this.appLoginEmailInputBox, email)
            await this.typeInto(await this.appLoginPasswordInputBox, password)
            await this.click(await this.appLoginButton)
            await browser.pause(2000)
            reporter.addStep("info", `The login process completed...`)
        } catch (err) {
            err.message = `Error log in to streams: , ${err.message} `
            throw err
        }
    }

    async selectChannelForProfile(channelName: string) {
        try {
            await this.click(await this.appChannelButton)
            await browser.pause(15000)
            let channelArr: WebdriverIO.Element[]
            channelArr = await this.appChannelListButtons
            for(let i=0; i<channelArr.length; i++){
                let name = await channelArr[i].getText()
                if(name.match(channelName)){
                    await this.click(channelArr[i])
                    reporter.addStep("info", `The channel selected...`)
                    await browser.pause(2000)
                    break
                }
            }
        } catch (err) {
            err.message = `Error while selecting streams channel: , ${err.message} `
            throw err
        }
    }

    async signoutStreamsAtHomePage() {
        try {
            await this.click(await this.appProfileButton)
            await browser.pause(2000)
            await this.click(await this.appLogoutButton)
            await browser.pause(3000)
            reporter.addStep("info", `The signed out of streams...`)
        } catch (err) {
            err.message = `Error while logging out from streams: , ${err.message} `
            throw err
        }
    }

    async checkEventsDetailsAtHomePage(filter: string): Promise<any> {
        try {
            await this.click(await this.upcomingEventsButton)
            await browser.pause(2000)
            await this.click(await this.pastEventsButton)
            await browser.pause(2000)
            await this.click(await this.liveEventsButton)
            await browser.pause(2000)
            if(await this.odEventsButton.isDisplayed()) {
                await this.click(await this.odEventsButton)
                await browser.pause(2000)
            }
            await this.typeInto(await this.eventsSearch, filter)
            await browser.keys("Enter")
            await browser.pause(2000)
            if(await this.eventsSortDropdown.isDisplayed()) {
                // add code here
            }
            await this.click(await this.listCardView)
            await browser.pause(2000)
            await this.click(await this.thumbCardView)
            await browser.pause(2000)
            reporter.addStep("info", `Checked events on home page...`)
            let eventsIndicatorArr = []
            eventsIndicatorArr.push(await this.totalEventsIndicator.getText())
            eventsIndicatorArr.push(await this.totalViewsIndicator.getText())
            eventsIndicatorArr.push(await this.averageDurationIndicator.getText())
            return eventsIndicatorArr
        } catch (err) {
            err.message = `Error while checking events: , ${err.message} `
            throw err
        }
    }

    async checkVariousFunctions(area: string) {
        try {
            switch(area.toLowerCase()) {
                case "events":
                    await this.click(await this.eventsTabButton)
                    await browser.pause(2000)
                    break;
                case "analytics":
                    await this.click(await this.analyticsTabButton)
                    await browser.pause(2000)
                    break;
                case "people":
                    await this.click(await this.peopleTabButton)
                    await browser.pause(2000)
                    break;
                case "content":
                    await this.click(await this.contentTabButton)
                    await browser.pause(2000)
                    break;
                case "products":
                    await this.click(await this.productsTabButton)
                    await browser.pause(2000)
                    break;
                case "profile":
                    await this.click(await this.appProfileButton)
                    await browser.pause(2000)
                    await this.click(await this.profilePageButton)
                    await browser.pause(2000)
                    break;    
                case "integrations":
                    await this.click(await this.appProfileButton)
                    await browser.pause(2000)
                    await this.click(await this.integrationsPageButton)
                    await browser.pause(2000)
                    break;
                case "settings":
                    await this.click(await this.appProfileButton)
                    await browser.pause(2000)
                    await this.click(await this.settingsPageButton)
                    await browser.pause(2000)
                    break;
                default:
                    reporter.addStep("info", `The ${area} is not valid...`)
                    break;
            }
        } catch (err) {
            err.message = `Error while checking various functions of streams: , ${err.message} `
            throw err
        }
    }

    async clickOnCreateEventButton() {
        try {
            if(await this.createDropDown.isDisplayed())
            await this.click(await this.createDropDown)
            await browser.pause(2000)
            await this.click(await this.createEventButton)
            await browser.pause(2000)
            reporter.addStep("info", `Clicked on the Create Event button.`)
        } catch (err) {
            err.message = `Error clicking to Create Event button: , ${err.message} `
            throw err
        }
    }

    /*
     * Click on the products tab
     */
    async clickOnProductsTab() {
        try {
            if (await this.productsTab.isDisplayed()) {
                await this.click(await this.productsTab)
                reporter.addStep("info", 'Clicked on the Products tab.')
            } 
        } catch (err) {
            err.message = `Error clicking on the products tab: , ${err.message} `
            throw err
        }
    }

    /*
     * Click on the Content tab
     */
    async clickOnContentTab() {
        try {
            if (await this.contentTab.isDisplayed()) {
                await this.click(await this.contentTab)
                reporter.addStep("info", 'Clicked on the Contents tab.')
            } 
        } catch (err) {
            err.message = `Error clicking on the Contents tab: , ${err.message} `
            throw err
        }
    }
}
export default new HomePageUi