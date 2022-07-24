import Page from "../../page"
import reporter from "../../../utils/reporter"

class ProfileInfo extends Page {

    constructor() {
        super()
    }

    // Registration profile info toggle details
    get profileInfoToggleON() { return $(`(//label[text()='Profile Info']//following::div[@class='form-control switch on'])[1]`) }
    get profileInfoToggleOFF() { return $(`(//label[text()='Profile Info']//following::div[@class='form-control switch'])[1]`) }

    
    async profileInfoToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.profileInfoToggleOFF)
                reporter.addStep("info", 'Enabled the Profile Info toggle.')
            } else {
                await this.click(await this.profileInfoToggleON)
                reporter.addStep("info", 'Disabled the Profile Info toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the Profile Info toggle: , ${err.message} `
            throw err
        }
    }
}
export default new ProfileInfo