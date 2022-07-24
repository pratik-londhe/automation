import Page from "../../page"
import reporter from "../../../utils/reporter"

class DirectoryLive extends Page {

    constructor() {
        super()
    }

    // Directory Live tab details
    get directoryTab() { return $(`//*[name()='svg' and @id='icon-people-nav']`) }
    get profileCards() { return $$(`//li[contains(@class,'directory-profile-card')]`) }
    get bookmarkIcon() { return $(`//*[name()='svg' and @id='icon-bookmark']`) }
    get profileAvatar() { return $$(`//div[contains(@style,'background-image: url')]`) }
    get profileCardsHeaders() { return $$(`//div[@class='card-item-content']//h5`) }
    get profileCardsHeadersValue() { return $$(`//div[@class='card-item-content']//p`) }
    get closeProfileDetailsPopUP() { return $(`//*[name()='svg' and @id='icon-close']`) }
    get PopUpView() { return $(`//div[@class='modal medium event-preview']`) }
    get profile() { return $(`//li[contains(@class,'directory-profile-card')][1]`) }
    get directMessagingChatBubble() { return $(`//div[@class='direct-messaging-main-icon']`) }
    get eventLobbyChannel() { return $(`//div[text()='Event Lobby']`) }
    get channelProfile() { return $(`//div[contains(@style,'background-image: url("https://image-resizer.brandlive.com/')]`) }
    get eventChannels() { return $$(`//div[@class='direct-messaging-group']`) }
    get sendMessageTextArea() { return $(`//textarea[@class='add-live-comment-textarea']`) }
    get messageText() { return $(`//div[@class='message-text']`) }
    get backArrow() { return $(`(//*[name()='svg' and @id='icon-arrow-left'])[2]`) }
    get filterContainer() { return $(`//div[@class='filter-tag-container']`) }
    get filterTag() { return $$(`//li[@class='filter-tag']`) }
    get ProfileCard() { return $(`//li[contains(@class,'directory-profile-card')]`) }


    async verifyDirectoryTab() {
        try {
            if (await this.directoryTab.isDisplayed()) {
                reporter.addStep("info", "Verified the Directory tab.")
            }
        } catch (err) {
            err.message = `Error verifying the Directory tab: , ${err.message} `
            throw err
        }
    }

    async clickOnTheDirectoryTab() {
        try {
            await this.click(await this.directoryTab)
            reporter.addStep("info", "Clicked on the Directory tab.")
        } catch (err) {
            err.message = `Error clicking on the live Directory tab: , ${err.message} `
            throw err
        }
    }

    async verifyAttendeesProfileCardsList() {
        try {
            let profileCardsList: WebdriverIO.Element[]
            profileCardsList = await this.profileCards
            for (let i = 0; i < profileCardsList.length; i++) {
                if (await profileCardsList[i].isDisplayed()) {
                    reporter.addStep("info", `Profile card is displyed:  ${i}`);
                }
            }
        } catch (err) {
            err.message = `Error verifying the profile cards list under the Directory tab: , ${err.message} `
            throw err
        }
    }

    async verifyBookMarkAttendeesIcon() {
        try {
            if (await this.bookmarkIcon.isDisplayed()) {
                reporter.addStep("info", "Verified the Bookmark attendees icon.")
            }
        } catch (err) {
            err.message = `Error verifying bookmark attendees icon: , ${err.message} `
            throw err
        }
    }

    async verifyAvatarToAttendeesProfile() {
        try {
            let avatar: WebdriverIO.Element[]
            avatar = await this.profileAvatar
            for (let i = 0; i < avatar.length; i++) {
                if (await avatar[i].isDisplayed()) {
                    reporter.addStep("info", `Avatar is displayed to the attendees profile card:  ${i}`);
                }
            }
        } catch (err) {
            err.message = `Error verifying Avatar to attendees profile: , ${err.message} `
            throw err
        }
    }

    async VerifyPopUPDetailsforAttendees() {
        try {
            let profiles: WebdriverIO.Element[]
            profiles = await this.profileCards
            for (let i = 0; i < profiles.length; i++) {
                if (await profiles[i].isDisplayed()) {
                    await this.click(profiles[i])
                    await browser.pause(3000)
                    reporter.addStep("info", `Clicked on the ${i} profile:`)
                    this.popupDetails()
                    await this.click(await this.closeProfileDetailsPopUP)
                    reporter.addStep("info", `Closed the profile details pop up.`)
                }
            }
        } catch (err) {
            err.message = `Error Error veriying the profiles pop up details: , ${err.message} `
            throw err
        }
    }

    private async popupDetails() {
        try {
            let headers: WebdriverIO.Element[]
            headers = await this.profileCardsHeaders
            reporter.addStep("info", `Getting the profile pop up header details...`)
            for (let i = 0; i < headers.length; i++) {
                if (await headers[i].isDisplayed()) {
                    let headerName = await headers[i].getText()
                    reporter.addStep("info", `The Header name is: ${headerName}`)
                }
            }
            let headersValue: WebdriverIO.Element[]
            headersValue = await this.profileCardsHeadersValue
            reporter.addStep("info", `Getting the profile pop up header values...`)
            for (let i = 0; i < headersValue.length; i++) {
                if (await headersValue[i].isDisplayed()) {
                    let headerValue = await headersValue[i].getText()
                    reporter.addStep("info", `The Header value is: ${headerValue}`)
                }
            }
        } catch (err) {
            err.message = `Error getting the profiles pop up details: , ${err.message} `
            throw err
        }
    }

    async verifyInPopUpView() {
        try {
            await this.click(await this.profile)
            reporter.addStep("info", "Clicked on the profile card.")
            await browser.pause(2000)
            if (await this.PopUpView.isDisplayed()) {
                reporter.addStep("info", "Verified the Pop Up view.")
                await this.click(await this.closeProfileDetailsPopUP)
                reporter.addStep("info", "Closed the Profile pop up details.")
            }
        } catch (err) {
            err.message = `Error verifying the pop up view: , ${err.message} `
            throw err
        }
    }

    async verifyAsPageView() {
        try {
            await this.click(await this.profile)
            reporter.addStep("info", "Clicked on the profile card.")
            await browser.pause(2000)
            if (!await this.PopUpView.isDisplayed()) {
                reporter.addStep("info", "Verified the As a Page view.")
            }
        } catch (err) {
            err.message = `Error verifying the As a Page view: , ${err.message} `
            throw err
        }
    }

    /*
     * verify Direct Messaging Chat bubble
     */
    async verifyDirectMessagingChatBubble() {
        try {
            if (await this.directMessagingChatBubble.isDisplayed()) {
                reporter.addStep("info", 'verified the direct messaging chat bubble.')
            }
        } catch (err) {
            err.message = `Error clicking on Event Channel Add button`
            throw err
        }
    }

    /*
     * Click on the direct mesagig chat bubble
     */
    async clickOnDirectMessagingChatBubble() {
        try {
            await this.click(await this.directMessagingChatBubble)
            reporter.addStep("info", 'Clicked on the direct messaging chat bubble.')
        } catch (err) {
            err.message = `Error clicking on Direct Messaging chat bubble`
            throw err
        }
    }

    /*
    * Verify Event lobby default channel in the direct messaging chat bubble
    */
    async verifyEventLobbyDefaultChannel() {
        try {
            if (await this.eventLobbyChannel.isDisplayed()) {
                reporter.addStep("info", 'verified the direct messaging event lobby default channel.')
            }
        } catch (err) {
            err.message = `Error verifying direct messaging event lobby default Channel`
            throw err
        }
    }

    /*
      * Verify the new Events channels and uploaded profile under the chat bubble
      */
    async verifyNewEventChannelsUnderChatBubble(newChannelName: string) {
        try {
            if (await $(`//div[text()='${newChannelName}']`).isDisplayed()) {
                if (await this.channelProfile.isDisplayed()) {
                    reporter.addStep("info", 'Verified the new channel name and uploaded image.')
                }
            }
        } catch (err) {
            err.message = `Error verifying the new channel and uploaded image.`
            throw err
        }
    }

    /*
      * Verify the attendees is able to send the messages in Event Channels(Event Loby and new created channel)
      */
    async verifyAttendeesAbleToSendMessageInChannels(chatMessage: string) {
        try {
            let channels: WebdriverIO.Element[]
            channels = await this.eventChannels
            for (let i = 0; i < channels.length; i++) {
                if (await channels[i].isDisplayed()) {
                    await this.click(channels[i])
                    reporter.addStep("info", `Clicked on the ${i} channel:`)
                    await browser.pause(2000)
                    await this.typeInto(await this.sendMessageTextArea, chatMessage)
                    reporter.addStep("info", `Entered the chat message.`)
                    await (await this.sendMessageTextArea).keys('Enter')
                    this.verifyChatMessage(chatMessage)
                    await this.click(await this.backArrow)
                    reporter.addStep("info", `clicked on the back arrow.`)
                }
            }
        } catch (err) {
            err.message = `Error verifying the attendees chat message in the events channels.`
            throw err
        }
    }

    /*
     * Verify chat message sent in the chat box
     */
    private async verifyChatMessage(chatMessage: string) {
        try {
            if ((await this.messageText.getText()).match(chatMessage)) {
                reporter.addStep("info", 'Verified the chat message in the channel.')
            }
        } catch (err) {
            err.message = `Error verifying the chat message in the channel.`
            throw err
        }
    }

    /*
      * Verify the Filter container at live
      */
    async verifyFilterContainer() {
        try {
            if (await this.filterContainer.isDisplayed()) {
                reporter.addStep("info", 'Verified the filter container.')
            }
        } catch (err) {
            err.message = `Error verifying filter container.`
            throw err
        }
    }

    /*
      * Verify the Filter functionality at live
      */
    async verifyFilterFunctionality() {
        try {
            reporter.addStep("info", 'Verify the user profile is displayed which has an option selected after selecting...')
            let filter: WebdriverIO.Element[]
            filter = await this.filterTag
            for (let i = 0; i < filter.length; i++) {
                if (await filter[i].isDisplayed()) {
                    await this.click(filter[0])
                    reporter.addStep("info", `Selected the First Filter tag.`)
                    if (await this.ProfileCard.isDisplayed()) {
                        reporter.addStep("info", `Profile card is displayed which has the question selected.`)
                        break
                    }
                }
            }
            reporter.addStep("info", 'Verify the user profile is not displayed which does not have option selected...')
            for (let i = 1; i < filter.length; i++) {
                if (await filter[i].isDisplayed()) {
                    await this.click(filter[0])
                    reporter.addStep("info", `Selected the all Filter tags.`)
                }
            }
            if (!await this.ProfileCard.isDisplayed()) {
                reporter.addStep("info", `The profile is not displayed which doesn't have the option selected.`);
            }
        } catch (err) {
            err.message = `Error verifying filter Functionality.`
            throw err
        }
    }
}
export default new DirectoryLive