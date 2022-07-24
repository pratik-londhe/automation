import Page from "../../page"
import reporter from "../../../utils/reporter"

class LeftNavigation extends Page {

    constructor() {
        super()
    }

    // Left navigation details
    get socialTab() { return $(`//*[name()='svg' and @id='icon-people']`) }
    get registrationTab() { return $(`//*[name()='svg' and @id='icon-registration']`) }
    get eventTab() { return $(`//*[name()='svg' and @id='icon-events-nav']`) }
    get landingTab() { return $(`(//*[name()='svg' and @id='icon-desktop-slim'])[2]`) }


    async clickOnSocialTab() {
        try {
            if (await this.socialTab.isDisplayed()) {
                await this.click(await this.socialTab)
                reporter.addStep("info", 'Clicked on the Social Tab.')
            }
        } catch (err) {
            err.message = `Error clicking on social tab: , ${err.message} `
            throw err
        }
    }

    async clickOnRegistrationTab() {
        try {
            if (await this.registrationTab.isDisplayed()) {
                await this.click(await this.registrationTab)
                reporter.addStep("info", 'Clicked on the registration Tab.')
            }
        } catch (err) {
            err.message = `Error clicking on registration tab: , ${err.message} `
            throw err
        }
    }

    async clickOnEventTab() {
        try {
            if (await this.eventTab.isDisplayed()) {
                await this.click(await this.eventTab)
                reporter.addStep("info", 'Clicked on the Event Tab.')
            }
        } catch (err) {
            err.message = `Error clicking on event tab: , ${err.message} `
            throw err
        }
    }

    async clickOnLandingTab() {
        try {
            if (await this.landingTab.isDisplayed()) {
                await this.click(await this.landingTab)
                reporter.addStep("info", 'Clicked on the landing Tab.')
            }
        } catch (err) {
            err.message = `Error clicking on landing tab: , ${err.message} `
            throw err
        }
    }
}
export default new LeftNavigation