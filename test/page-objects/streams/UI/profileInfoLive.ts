import Page from "../../page"
import reporter from "../../../utils/reporter"

class ProfileInfoLive extends Page {

    constructor() {
        super()
    }

    // Registration live profile info details
    get companyName() { return $(`(//input[@placeholder='Company Name'])[2]`) }
    get bio() { return $(`(//textarea[@placeholder='Bio'])[2]`) }
    get funFact() { return $(`(//input[@placeholder='Fun Fact'])[2]`) }
    get nextButton() { return $(`(//button[@type='submit'])[4]`) }

    /*
        * Enter Profile info on the registration page
        */

    async enterProfileInfo(cName: string, bioText: string, funFactText: string) {
        reporter.addStep("info", "Enter profile info details on the registration page...")
        await this.companyName.clearValue()
        await this.typeInto(await this.companyName, cName)
        reporter.addStep("info", "Entered company name...")
        await this.bio.clearValue()
        await this.typeInto(await this.bio, bioText)
        reporter.addStep("info", "Entered bio name...")
        await this.funFact.clearValue()
        await this.typeInto(await this.funFact, funFactText)
        reporter.addStep("info", "Entered fun fact name...")
        await this.click(await this.nextButton)
        reporter.addStep("info", "Clicked on the Next button.")
        browser.pause(3000)
    }
}
export default new ProfileInfoLive