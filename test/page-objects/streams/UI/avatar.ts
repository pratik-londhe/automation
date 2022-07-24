import Page from "../../page"
import reporter from "../../../utils/reporter"

class Avatar extends Page {

    constructor() {
        super()
    }

    // Avatar toggle details
    get avatarInfoToggleON() { return $(`(//label[text()='Avatar']//following::div[@class='form-control switch on'])[1]`) }
    get avatarinfoToggleOFF() { return $(`(//label[text()='Avatar']//following::div[@class='form-control switch'])[1]`) }
    get socialAvatarToggleON() { return $(`(//div[text()='Avatar']//following::div[@class='form-control switch on'])[1]`) }
    get socialAvatarToggleOFF() { return $(`(//div[text()='Avatar']//following::div[@class='form-control switch'])[1]`) }


    async avatarToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.avatarinfoToggleOFF)
                reporter.addStep("info", 'Enabled the Avatar toggle.')
            } else {
                await this.click(await this.avatarInfoToggleON)
                reporter.addStep("info", 'Disabled the Avatar toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the Avatar toggle: , ${err.message} `
            throw err
        }
    }

    async socialAvatarToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                if (await this.socialAvatarToggleON.isDisplayed()) {
                    reporter.addStep("info", 'Already the Avatar toggle is enabled.')
                } else {
                    await this.click(await this.socialAvatarToggleOFF)
                    reporter.addStep("info", 'Enabled the Avatar toggle.')
                }
            } else {
                await this.click(await this.socialAvatarToggleON)
                reporter.addStep("info", 'Disabled the Avatar toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the Avatar toggle: , ${err.message} `
            throw err
        }
    }
}
export default new Avatar