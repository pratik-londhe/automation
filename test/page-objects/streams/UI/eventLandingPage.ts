import Page from "../../page"
import reporter from "../../../utils/reporter"
import EventHeader from "./eventHeader"

class EventLandingPage extends Page {

    constructor() {
        super()
    }

    // General Info details
    get registrationButton() { return $(`//div[@class='header-col-right']//button`) }
    get profileIcon() { return $(`//div[@id='profile-details-dropdown-container']//button`) }
    get logOut() { return $(`//button[text()='Logout']`) }
    get homeTab() { return $(`//span[@class='ev-icon-home icon-giant']`) }
    get sessionTab() { return $(`//span[@class='ev-icon-event icon-giant']`) }


    async goLiveWithTheEvent() {
        try {
            await browser.newWindow(await EventHeader.copyPublishedEventLink())
            reporter.addStep("info", "Launched the event in the new tab.")
        } catch (err) {
            err.message = `Error launching event in the new tab: , ${err.message} `
            throw err
        }
    }

    async clickOnRegistrationButton() {
        try {
            await this.click(await this.registrationButton)
            reporter.addStep("info", "Clicked on the registration button.")
        } catch (err) {
            err.message = `Error clicking on the registration button: , ${err.message} `
            throw err
        }
    }

    async logOutFromEvent() {
        try {
            await this.click(await this.profileIcon)
            reporter.addStep("info", "Clicked on the profile Icon.")
            await this.click(await this.logOut)
            reporter.addStep("info", "Clicked on the log out link.")
        } catch (err) {
            err.message = `Error logging out from an event: , ${err.message} `
            throw err
        }
    }

    /*
      * Click on the Live Home Tab
      */
    async clickOnHomeTab() {
        try {
            await this.click(await this.homeTab)
            reporter.addStep("info", "Clicked on the Home tab.")
        } catch (err) {
            err.message = `Error clicking on the home tab: , ${err.message} `
            throw err
        }
    }

    /*
      * Click on the Live Session tab
      */
    async clickOnSessionTab() {
        try {
            await this.click(await this.sessionTab)
            reporter.addStep("info", "Clicked on the Session Tab.")
        } catch (err) {
            err.message = `Error clicking on the Session Tab: , ${err.message} `
            throw err
        }
    }

}
export default new EventLandingPage
