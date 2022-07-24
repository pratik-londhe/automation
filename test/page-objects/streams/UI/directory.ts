import Page from "../../page"
import reporter from "../../../utils/reporter"

class Directory extends Page {

    constructor() {
        super()
    }

    // Directory toggle details
    get directoryCard() { return $(`(//*[name()='svg' and @id='icon-arrow-right'])[1]`) }
    get directoryToggleON() { return $(`(//div[text()='Enable Directory']//following::div[@class='form-control switch on'])[1]`) }
    get directoryToggleOFF() { return $(`(//div[text()='Enable Directory']//following::div[@class='form-control switch'])[1]`) }
    get avatarToggleON() { return $(`(//div[text()='Avatar']//following::div[@class='form-control switch on'])[1])`) }
    get avatarToggleOFF() { return $(`(//div[text()='Avatar']//following::div[@class='form-control switch'])[1]`) }
    get bookmarkAttendeesToggleON() { return $(`(//div[text()='Avatar']//following::div[@class='form-control switch on'])[1])`) }
    get bookmarkAttendeesToggleOFF() { return $(`(//div[text()='Avatar']//following::div[@class='form-control switch'])[1]`) }
    get filterToggleOFF() { return $(`(//div[text()='Filters']//following::div[@class='form-control switch'])[1]`) }
    get filterToggleON() { return $(`(//div[text()='Filters']//following::div[@class='form-control switch on'])[1]`) }
    get filterQuestion() { return $(`//div[@class='filter-tag not-selected tag-container']`) }
    get saveFilter() { return $(`//button[@class='button primary']`) }


    async clickOnDirectoryCard() {
        try {
            if (await this.directoryCard.isDisplayed()) {
                await this.click(await this.directoryCard)
                reporter.addStep("info", 'Clicked on the directory Card.')
            }
        } catch (err) {
            err.message = `Error clicking on directory card: , ${err.message} `
            throw err
        }
    }

    async directoryToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.directoryToggleOFF)
                reporter.addStep("info", 'Enabled the directory toggle.')
            } else {
                await this.click(await this.directoryToggleON)
                reporter.addStep("info", 'Disabled the directory toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the directory toggle: , ${err.message} `
            throw err
        }
    }

    async avatarToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.avatarToggleOFF)
                reporter.addStep("info", 'Enabled the avatar toggle.')
            } else {
                await this.click(await this.avatarToggleON)
                reporter.addStep("info", 'Disabled the avatar toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the avatar toggle: , ${err.message} `
            throw err
        }
    }

    async bookmarkAttendeesToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.bookmarkAttendeesToggleOFF)
                reporter.addStep("info", 'Enabled the Bookmark Attendees toggle.')
            } else {
                await this.click(await this.bookmarkAttendeesToggleON)
                reporter.addStep("info", 'Disabled the directory toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the directory toggle: , ${err.message} `
            throw err
        }
    }

    /*
    * Select the added question as a filter
    */
    async selectFilterQuestion() {
        try {
            await this.click(await this.filterQuestion)
            reporter.addStep("info", "Selected the Filter Question.")
        } catch (err) {
            err.message = `Error selecting the filter question: , ${err.message} `
            throw err
        }
    }

    /*
    * Click On Save Filter button
    */
    async clickOnSaveFilter() {
        try {
            if (await this.saveFilter.isDisplayed()) {
                await this.click(await this.saveFilter)
                reporter.addStep("info", "Clicked on the Save Filter button.")
            }
        } catch (err) {
            err.message = `Error clicking on the Save Filter button.`
            throw err
        }
    }

    /*
    * Toggle action on Directory Filter
    */
    async filterToggleAction(toggle: string) {
        try {
            if (toggle.match("ON")) {
                await this.click(await this.filterToggleOFF)
                reporter.addStep("info", 'Enabled the Filter toggle.')
            } else {
                await this.click(await this.filterToggleON)
                reporter.addStep("info", 'Disabled the Filter toggle.')
            }
        } catch (err) {
            err.message = `Error performing ${toggle} action on the Filter toggle: , ${err.message} `
            throw err
        }
    }
}
export default new Directory