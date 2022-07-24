import Page from "../../page"
import reporter from "../../../utils/reporter"

class ProfileDetails extends Page {

    constructor() {
        super()
    }

    // Social tab profile toggle details
    get profileDetailsCard() { return $(`(//*[name()='svg' and @id='icon-arrow-right'])[2]`) }
    get profileDetailsToggleON() { return $(`(//div[text()='Enable Profile Details']//following::div[@class='form-control switch on'])[1]`) }
    get profileDetailsToggleOFF() { return $(`(//div[text()='Enable Profile Details']//following::div[@class='form-control switch'])[1]`) }
    get aboutToggleON() { return $(`(//div[text()='About']//following::div[@class='form-control switch on'])[1]`) }
    get aboutToggleOFF() { return $(`(//div[text()='About']//following::div[@class='form-control switch'])[1]`) }
    get topicsToggleON() { return $(`(//div[text()='Topics']//following::div[@class='form-control switch on'])[1]`) }
    get topicsToggleOFF() { return $(`(//div[text()='Topics']//following::div[@class='form-control switch'])[1]`) }
    get settingIcon() { return $(`(//div[@class='tab-header-button'])[2]`) }
    get arrowDownIcon() { return $(`(//*[name()='svg' and @id='icon-keyboard-arrow-down'])[2]`) }


    async clickOnProfileDetailsCard() {
        try {
            if (await this.profileDetailsCard.isDisplayed()) {
                await this.click(await this.profileDetailsCard)
                reporter.addStep("info", 'Clicked on the Profile Details Card.')
            }
        } catch (err) {
            err.message = `Error clicking on Profile Details card: , ${err.message} `
            throw err
        }
    }

    async profileDetailsToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.profileDetailsToggleOFF)
                reporter.addStep("info", 'Enabled the Profile Details toggle.')
            } else {
                await this.click(await this.profileDetailsToggleON)
                reporter.addStep("info", 'Disabled the Profile Details toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the Profile Details toggle: , ${err.message} `
            throw err
        }
    }

    async aboutToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.aboutToggleOFF)
                reporter.addStep("info", 'Enabled the About toggle.')
            } else {
                await this.click(await this.aboutToggleON)
                reporter.addStep("info", 'Disabled the About toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the About toggle: , ${err.message} `
            throw err
        }
    }

    async topicsToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.topicsToggleOFF)
                reporter.addStep("info", 'Enabled the Topics toggle.')
            } else {
                await this.click(await this.topicsToggleON)
                reporter.addStep("info", 'Disabled the Topics toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the Topics toggle: , ${err.message} `
            throw err
        }
    }

    async clickOnSettingIcon() {
        try {
            if (await this.settingIcon.isDisplayed()) {
                await this.click(await this.settingIcon)
                reporter.addStep("info", "Clicked on the Setting icon.")
            }
        } catch (err) {
            err.message = `Error cliking on the setting icon: , ${err.message} `
            throw err
        }
    }

    async clickOnArrowDownIcon() {
        try {
            if (await this.arrowDownIcon.isDisplayed()) {
                await this.click(await this.arrowDownIcon)
                reporter.addStep("info", "Clicked on the arrow down icon.")
            }
        } catch (err) {
            err.message = `Error cliking on the arrow down icon: , ${err.message} `
            throw err
        }
    }

    async selectProfileAppearance(profileAppearance: string) {
        try {
            await this.click(await $(`//span[text()='${profileAppearance}']`))
            reporter.addStep("info", `Selected the Profile Appearance: ${profileAppearance}`)
        } catch (err) {
            err.message = `Error selecting the profile appearance: , ${err.message} `
            throw err
        }
    }
}
export default new ProfileDetails