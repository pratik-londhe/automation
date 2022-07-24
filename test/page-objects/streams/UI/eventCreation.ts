import Page from "../../page"
import reporter from "../../../utils/reporter"
import EventTemplateSelection from "./eventTemplateSelection";
import pause from "webdriverio/build/commands/browser/pause";
// import EventTemplateSelection from "./EventTemplateSelection"

class EventCreation extends Page {

    public static eventName: string
    public static nameOfRoom: string

    constructor() {
        super()
    }

    // Create Event Button
    get addSessionModal() { return $(`//div[@class='modal normal']`) }
    get dropDownArrow() { return $(`//span[@class='arrow']`) }
    get onDemanSelector() { return $(`(//div[@class='session-type-selector open']//label)[1]`) }
    get sessionInputName() { return $(`(//input[@class='evt-field-input'])[2]`) }
    get addButton() { return $(`//button[@class='primary']`) }
    get openRadio() { return $(`//label[@for='registration-off']`) }
    get registerRadio() { return $(`//label[@for='registration-on']`) }
    get noLPRadio() { return $(`//label[@for='homepage-off']`) }
    get yesLPRadio() { return $(`//label[@for='homepage-on']`) }
    get eventNameText() { return $(`//input[@class='evt-field-input']`) }
    get addSessionLink() { return $(`//button[@class='add-session']`) }
    get addEventButton() { return $(`//button[@class='primary create-event-continue']`) }
    get dateTimeInput() { return $(`//div[@class='react-datepicker__input-container']/input`) }
    get modalTitle() { return $(`//h4[@class='modal-title']`) }
    get durationInputText() { return $(`//div[@class='timepicker-input']/input`) }
    get firesideSelector() { return $(`(//div[@class='session-type-selector open']//label)[4]`) }
    get breakOutV2Selector() { return $(`(//div[@class='session-type-selector open']//label)[3]`) }
    get RegToggleDisabled() { return $(`//div[@class='registration-toggles disabled']`) }
    get zoomPoweredToggleOff() { return $(`//div[@class='field-group switch']//div[@class='form-control switch']`) }
    get zoomPoweredToggleOn() { return $(`//div[@class='field-group switch']//div[@class='form-control switch on']`) }
    get addRoom() { return $(`//button[@class='clear no-style button-plain breakout-rooms-button']`) }
    get textRoomName() { return $$(`//input[@placeholder='Give your room a name']`) }
    get maximumUserDropDown() { return $$(`//span[@class='ev-icon-keyboard-arrow-down icon-white']`) }
    get saveButton() { return $(`(//button[@class='primary'])[2]`) }



    async addOnDemandSession() {
        try {
            if (await this.addSessionModal.isDisplayed()) {
                reporter.addStep("info", `Session modal is displayed.`)
                await this.click(await this.dropDownArrow)
                reporter.addStep("info", `Clicked on the Session drop down.`)
                await this.click(await this.onDemanSelector)
                reporter.addStep("info", `Selected the On Demand Session from the drop down.`)
                await this.typeInto(await this.sessionInputName, await this.generateSessionName("On Demand Session"))
                reporter.addStep("info", `Entered the session name.`)
                await this.click(await this.addButton)
                reporter.addStep("info", `Clicked on the Add button.`)
            }

        } catch (err) {
            err.message = `Error creating the On Demand session: , ${err.message} `
            throw err
        }
    }

    private async setEventAvailability(register: boolean) {
        try {
            if (await this.addSessionModal.isDisplayed()) {
                reporter.addStep("info", `The modal pop up is displayed.`)
                if (!register) {
                    await this.click(await this.openRadio)
                    reporter.addStep("info", `Clicked on the Open radio button.`)
                } else {
                    await this.click(await this.registerRadio)
                    reporter.addStep("info", `Clicked on the registrataion radio button.`)
                }
                await browser.pause(2000)
                await this.click(await this.addButton)
                reporter.addStep("info", `Clicked on the Next button.`)
                await browser.pause(3000)
            }

        } catch (err) {
            err.message = `Error setting the event availability: , ${err.message} `
            throw err
        }
    }

    private async addLandingPage(lp: boolean) {
        try {
            if (await this.addSessionModal.isDisplayed()) {
                if (!lp) {
                    await this.click(await this.noLPRadio)
                    reporter.addStep("info", `Clicked on the No Landing page radio button.`)
                } else {
                    await this.click(await this.yesLPRadio)
                    reporter.addStep("info", `Clicked on the Yes Landing page radio button.`)
                }
                await browser.pause(2000)
                await this.click(await this.addButton)
                reporter.addStep("info", `Clicked on the Next button.`)
            }

        } catch (err) {
            err.message = `Error setting the event availability: , ${err.message} `
            throw err
        }
    }

    private async generateSessionName(sessionName: String): Promise<any> {
        try {
            reporter.addStep("info", `Generating the Session name...`)
            let random = Math.floor(Math.random() * 10) + 1;
            let nameOfSession = sessionName + " " + random;
            reporter.addStep("info", `The session name is:  ${nameOfSession}`);
            reporter.addStep("info", `Generated the Session name...`)
            return nameOfSession
        } catch (err) {
            err.message = `Error generating the session name: , ${err.message} `
            throw err
        }
    }

    private async generateEventName(): Promise<any> {
        try {
            reporter.addStep("info", `Generating the Event name...`)
            let random = Math.floor(Math.random() * 1000) + 1;
            var date = new Date().toLocaleString()
            EventCreation.eventName = "Automation " + Object.getPrototypeOf(EventTemplateSelection).constructor.selectedTemplateName + " Event " + random + " " + date
            reporter.addStep("info", `The Event name is:  ${EventCreation.eventName}`);
            reporter.addStep("info", `Generated the Event name...`)
            return EventCreation.eventName
        } catch (err) {
            err.message = `Error generating the session name: , ${err.message} `
            throw err
        }
    }

    async createEventWithOnDemandSession(setEA: boolean, addLP: boolean) {
        try {
            await this.typeInto(await this.eventNameText, await this.generateEventName())
            reporter.addStep("info", `Entered the Event name.`)
            await this.click(await this.addSessionLink)
            reporter.addStep("info", `Clicked on the Add session link.`)
            await this.addOnDemandSession()
            await browser.pause(2000)
            await this.click(await this.addEventButton)
            reporter.addStep("info", `Clicked on the Next button.`)
            await browser.pause(2000)
            await this.setEventAvailability(setEA);
            await this.addLandingPage(addLP);
            await browser.pause(10000)
        } catch (err) {
            err.message = `Error creating the On Demand session: , ${err.message} `
            throw err
        }
    }

    async addBroadcastSession() {
        try {
            if (await this.addSessionModal.isDisplayed()) {
                reporter.addStep("info", `Session modal is displayed.`)
                await this.typeInto(await this.sessionInputName, await this.generateSessionName("Broadcast Session"))
                reporter.addStep("info", `Entered the session name.`)
                await this.typeInto(await this.dateTimeInput, await this.generateExtraPlusMinutes(15))
                reporter.addStep("info", `Added the extra time.`)
                await browser.pause(2000)
                await this.durationInputText.clearValue()
                await this.typeInto(await this.durationInputText, "15")
                reporter.addStep("info", `Entered the session limit time.`)
                await this.click(await this.addButton)
                reporter.addStep("info", `Clicked on the Add button.`)
            }

        } catch (err) {
            err.message = `Error creating the On Broadcast session: , ${err.message} `
            throw err
        }
    }

    private async generateExtraPlusMinutes(time: number): Promise<any> {
        try {
            reporter.addStep("info", `Generating the extra time...`)
            var setDate = new Date()
            reporter.addStep("info", `The current date is:  ${setDate}`);
            setDate.setMinutes(setDate.getMinutes() + time);
            reporter.addStep("info", `The set date is:  ${setDate}`);
            return setDate.toLocaleDateString() + " " + setDate.getHours() + ":" + setDate.getMinutes()
        } catch (err) {
            err.message = `Error generating the extra time session name: , ${err.message} `
            throw err
        }
    }

    async createEventWithBroadcastSession(setEA: boolean, addLP: boolean) {
        try {
            await this.typeInto(await this.eventNameText, await this.generateEventName())
            reporter.addStep("info", `Entered the Event name.`)
            await this.click(await this.addSessionLink)
            reporter.addStep("info", `Clicked on the Add session link.`)
            await browser.pause(2000)
            await this.addBroadcastSession()
            await this.click(await this.addEventButton)
            reporter.addStep("info", `Clicked on the Next button.`)
            await browser.pause(2000)
            await this.setEventAvailability(setEA);
            await this.addLandingPage(addLP);
            await browser.pause(10000)
        } catch (err) {
            err.message = `Error creating the Broadcast session: , ${err.message} `
            throw err
        }
    }

    async addFiresideSession() {
        try {
            if (await this.addSessionModal.isDisplayed()) {
                reporter.addStep("info", `Session modal is displayed.`)
                await this.click(await this.dropDownArrow)
                reporter.addStep("info", `Clicked on the Session drop down.`)
                await this.click(await this.firesideSelector)
                reporter.addStep("info", `Selected the On Fireside Session from the drop down.`)
                await this.typeInto(await this.sessionInputName, await this.generateSessionName("Fireside Session"))
                reporter.addStep("info", `Entered the session name.`)
                await this.typeInto(await this.dateTimeInput, await this.generateExtraPlusMinutes(10))
                reporter.addStep("info", `Added the extra time.`)
                await browser.pause(2000)
                await this.durationInputText.clearValue()
                await this.typeInto(await this.durationInputText, "15")
                reporter.addStep("info", `Entered the session limit time.`)
                await this.click(await this.addButton)
                reporter.addStep("info", `Clicked on the Add button.`)
            }

        } catch (err) {
            err.message = `Error creating the On Fireside session: , ${err.message} `
            throw err
        }
    }

    async createEventWithFiresideSession(addLP: boolean) {
        try {
            await this.typeInto(await this.eventNameText, await this.generateEventName())
            reporter.addStep("info", `Entered the Event name.`)
            await this.click(await this.addSessionLink)
            reporter.addStep("info", `Clicked on the Add session link.`)
            await this.addFiresideSession()
            await this.click(await this.addEventButton)
            reporter.addStep("info", `Clicked on the Next button.`)
            await browser.pause(2000)
            if (await this.RegToggleDisabled.isDisplayed()) {
                reporter.addStep("info", `Registration toggle is selected and disabled by default.`)
            }
            await this.click(await this.addButton)
            reporter.addStep("info", `Clicked on the Next button.`)
            await this.addLandingPage(addLP);
            await browser.pause(10000)
        } catch (err) {
            err.message = `Error creating the Fireside session: , ${err.message} `
            throw err
        }
    }

    async addBreakoutV2Session() {
        try {
            if (await this.addSessionModal.isDisplayed()) {
                reporter.addStep("info", `Session modal is displayed.`)
                await this.click(await this.dropDownArrow)
                reporter.addStep("info", `Clicked on the Session drop down.`)
                await this.click(await this.breakOutV2Selector)
                reporter.addStep("info", `Selected the On Breakout V2 Session from the drop down.`)
                await this.typeInto(await this.sessionInputName, await this.generateSessionName("Breakout V2 Session"))
                reporter.addStep("info", `Entered the session name.`)
                await this.typeInto(await this.dateTimeInput, await this.generateExtraPlusMinutes(10))
                reporter.addStep("info", `Added the extra time.`)
                await browser.pause(2000)
                await this.durationInputText.clearValue()
                await this.typeInto(await this.durationInputText, "15")
                reporter.addStep("info", `Entered the session limit time.`)
                await this.click(await this.addButton)
                reporter.addStep("info", `Clicked on the Add button.`)
                await browser.pause(2000)
            }

        } catch (err) {
            err.message = `Error creating On Breakout session: , ${err.message} `
            throw err
        }
    }

    private async createMultipleBreakoutRooms(rooms: number) {
        try {
            if (await this.zoomPoweredToggleOff.isDisplayed()) {
                reporter.addStep("info", `The Zoom breakout is Off and breakout V2 is On.`)
            } else {
                await this.click(await this.zoomPoweredToggleOn)
                reporter.addStep("info", `Enabled the breakout V2 and off the Zoom.`)
            }
            reporter.addStep("info", `Creating breakout V2 rooms.`)
            for (let i = 1; i <= rooms; i++) {
                if (await this.addRoom.isDisplayed()) {
                    await this.addRoom.click();
                    reporter.addStep("info", `Created breakout room:  ${i}`);
                }
            }
            reporter.addStep("info", `Setting the names to the breakout V2 rooms.`)
            let textRoom: WebdriverIO.Element[]
            textRoom = await this.textRoomName
            for (let i = 0; i < textRoom.length; i++) {
                if (await textRoom[i].isDisplayed()) {
                    await this.typeInto(textRoom[i], await this.generateRoomName("Breakout Room"))
                    await browser.pause(2000)
                    reporter.addStep("info", `Entered the room name:`)
                }
            }
        } catch (err) {
            err.message = `Error creating multiple breakout rooms: , ${err.message} `
            throw err
        }
    }

    private async setMaximumUsers(users: number) {
        try {
            reporter.addStep("info", `Setting the maximum users to the breakout room...`)
            let usersDropDown: WebdriverIO.Element[]
            usersDropDown = await this.maximumUserDropDown
            for (let i = 0; i < usersDropDown.length; i++) {
                if (await usersDropDown[i].isDisplayed()) {
                    await this.click(usersDropDown[i])
                    reporter.addStep("info", `Clicked on the users drop down the room name. `)
                    await browser.pause(2000)
                    await this.click(await $(`(//div[@class='select-dropdown open']//span)[${users}]`))
                }
            }
        } catch (err) {
            err.message = `Error setting the maximum users: , ${err.message} `
            throw err
        }
    }

    private async generateRoomName(roomName: String): Promise<any> {
        try {
            reporter.addStep("info", `Generating the room name...`)
            let random = Math.floor(Math.random() * 10) + 1;
            EventCreation.nameOfRoom = roomName + " " + random;
            reporter.addStep("info", `The room name is:  ${EventCreation.nameOfRoom}`);
            reporter.addStep("info", `Generated the room name...`)
            return EventCreation.nameOfRoom
        } catch (err) {
            err.message = `Error generating the session name: , ${err.message} `
            throw err
        }
    }

    async createEventWithBreakoutV2Session(addLP: boolean) {
        try {
            await this.typeInto(await this.eventNameText, await this.generateEventName())
            reporter.addStep("info", `Entered the Event name.`)
            await this.click(await this.addSessionLink)
            reporter.addStep("info", `Clicked on the Add session link.`)
            await this.addBreakoutV2Session()
            await this.createMultipleBreakoutRooms(1)
            await this.setMaximumUsers(10)
            await this.click(await this.saveButton)
            reporter.addStep("info", `Clicked on the save button.`)
            await browser.pause(2000)
            await this.click(await this.addEventButton)
            reporter.addStep("info", `Clicked on the Continue button.`)
            if (await this.RegToggleDisabled.isDisplayed()) {
                reporter.addStep("info", `Registration toggle is selected and disabled by default.`)
            }
            await this.click(await this.addButton)
            reporter.addStep("info", `Clicked on the Next button.`)
            await this.addLandingPage(addLP);
            await browser.pause(10000)
        } catch (err) {
            err.message = `Error creating the breakout V2 session: , ${err.message} `
            throw err
        }
    }
}
export default new EventCreation