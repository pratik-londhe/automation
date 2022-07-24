import Page from "../../page"
import reporter from "../../../utils/reporter"

class Messaging extends Page {

    constructor() {
        super()
    }

    // Social tab profile toggle details
    get messagingCard() { return $(`(//*[name()='svg' and @id='icon-arrow-right'])[3]`) }
    get enableDirectMessagingToggleOFF() { return $(`(//div[text()='Enable Direct Messaging']//following::div[@class='form-control switch'])[1]`) }
    get enableDirectMessagingToggleON() { return $(`(//div[text()='Enable Direct Messaging']//following::div[@class='form-control switch on'])[1]`) }
    get enableTopicGroupChatsToggleOFF() { return $(`(//div[text()='Enable Topic Group Chats']//following::div[@class='form-control switch'])[1]`) }
    get enableTopicGroupChatsToggleON() { return $(`(//div[text()='Enable Topic Group Chats']//following::div[@class='form-control switch on'])[1]`) }
    get eventChannelsAddButton() { return $(`//*[name()='svg' and @id='icon-add']`) }
    get setEventNameText() { return $(`//input[@placeholder='Set channel name']`) }
    get uploadChannelImage() { return $(`//input[@type='file']`) }
    get saveButton() { return $(`//button[@class='button primary']`) }


    /*
      * Toggle action on Messaging card
      */
    async clickOnMessagingsCard() {
        try {
            if (await this.messagingCard.isDisplayed()) {
                await this.click(await this.messagingCard)
                reporter.addStep("info", 'Clicked on the Messaging Card.')
            }
        } catch (err) {
            err.message = `Error clicking on Messaging Card: , ${err.message} `
            throw err
        }
    }

    /*
      * Toggle action on Direct Messaging
      */
    async directMessagingToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.enableDirectMessagingToggleOFF)
                reporter.addStep("info", 'Enabled the Direct Messaging toggle.')
            } else {
                await this.click(await this.enableDirectMessagingToggleON)
                reporter.addStep("info", 'Disabled the Direct Messaging toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the Direct Messaging toggle: , ${err.message} `
            throw err
        }
    }

    /*
      * Toggle action on Topic Group chat
      */
    async topicGroupChatsToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.enableTopicGroupChatsToggleOFF)
                reporter.addStep("info", 'Enabled the Topic Group Chats toggle.')
            } else {
                await this.click(await this.enableTopicGroupChatsToggleON)
                reporter.addStep("info", 'Disabled the Topic Group Chats toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the Topic Group Chats toggle: , ${err.message} `
            throw err
        }
    }

    /*
      * Click on Event channel add button
      */
    async clickOnEventChannelAddButton() {
        try {
            if (await this.eventChannelsAddButton.isDisplayed()) {
                await this.click(await this.eventChannelsAddButton)
                reporter.addStep("info", 'Clicked on the Event Channel Add Button.')
            }
        } catch (err) {
            err.message = `Error clicking on Event Channel Add button`
            throw err
        }
    }

    /*
      * Set Event Channel Name
      */
    async setEventChannelName(channelName: string) {
        try {
            if (await this.setEventNameText.isDisplayed()) {
                await this.typeInto(await this.setEventNameText, channelName)
                reporter.addStep("info", 'Entered the Event Channel name.')
            }
        } catch (err) {
            err.message = `Error setting the event channel name.`
            throw err
        }
    }

    /*
      * Upload channel image
      */
    async uploadChannelImageDetails(fileName: string) {
        let path = (`${process.cwd()}/data/fileUpload/streams/${fileName}`)
        try {
            await this.uploadChannelImage.addValue(path)
            reporter.addStep("info", 'Uploaded the file.')
            await browser.pause(10000)
            await this.click(await this.saveButton)
            reporter.addStep("info", 'Clicked on the Save button.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error when uploading Image file`
            throw err
        }
    }
}
export default new Messaging