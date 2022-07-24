import Page from "../../page"
import reporter from "../../../utils/reporter"

class EventTemplateSelection extends Page {

    public static selectedTemplateName: string

    constructor() {
        super()
    }

    async selectEventTemplateAtRandom() {
        try {
            let random = Math.floor(Math.random() * 3) + 1;
            EventTemplateSelection.selectedTemplateName = await ($(`(//button[@class='primary']//preceding::h3)[${random}]`)).getText()
            reporter.addStep("info", `The template name is:  ${EventTemplateSelection.selectedTemplateName}`);
            await browser.pause(2000)
            await this.click(await $(`(//button[@class='primary'])[${random}]`))
            reporter.addStep("info", `Clicked on the Event random template.`)
        } catch (err) {
            err.message = `Error selecting the event template at random: , ${err.message} `
            throw err
        }
    }
}
export default new EventTemplateSelection