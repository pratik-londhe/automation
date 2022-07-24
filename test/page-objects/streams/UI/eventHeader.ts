import Page from "../../page"
import reporter from "../../../utils/reporter"


class EventHeader extends Page {

    public static eventLink: any

    constructor() {
        super()
    }

    // Event header details
    get waitingIndicator() { return $(`//*[name()='svg' and @class='waiting-indicator']`) }
    get eventPublishButton() { return $(`//button[@class='small primary publish-btn' or @class='small primary']`) }
    get publisiModal() { return $(`//div[@class='modal normal']`) }
    get nextPublishButton() { return $(`(//button[@class='primary'])[1]`) }
    get assistantChecklistModal() { return $(`(//div[@class='modal normal'])[2]`) }
    get nextAssistantModalPublishButton() { return $(`(//button[@class='primary'])[2]`) }
    get copyEventLink() { return $(`//div[@class='copy-event reverse-tooltip']//button`) }


    async publishEvent() {
        try {
            if (await this.waitingIndicator.isDisplayed()) {
                await browser.pause(5000)
                reporter.addStep("info", 'Waiting to display Publish Event button from Loading state.')
            }
            await this.click(await this.eventPublishButton)
            reporter.addStep("info", `Clicked on the Publish Event button.`)
            await browser.pause(2000)
            if (await this.publisiModal.isDisplayed()) {
                await this.click(await this.nextPublishButton)
                reporter.addStep("info", 'Clicked on the next publish button')
            }
            await browser.pause(2000)
            if (await this.assistantChecklistModal.isDisplayed()) {
                await this.click(await this.nextAssistantModalPublishButton)
                reporter.addStep("info", 'Clicked on the next assitant modal publish button')
                await browser.pause(2000)
            }
        } catch (err) {
            err.message = `Error publishing the event: , ${err.message} `
            throw err
        }
    }

    async copyPublishedEventLink(): Promise<any> {
        try {
            if (await this.copyEventLink.isDisplayed()) {
                await this.click(await this.copyEventLink)
                reporter.addStep("info", 'Clicked on copy event link.')
            }
            var nodeClipboard = require('node-clipboardy')
            EventHeader.eventLink = await nodeClipboard.readSync()
            reporter.addStep("info", `The Event link is:  ${EventHeader.eventLink}`);
            return EventHeader.eventLink
        } catch (err) {
            err.message = `Error copying the vent link: , ${err.message} `
            throw err
        }
    }
}
export default new EventHeader