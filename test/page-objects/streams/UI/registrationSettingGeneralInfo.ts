import Page from "../../page"
import reporter from "../../../utils/reporter"

class RegistrationSettingGeneralInfo extends Page {

    constructor() {
        super()
    }

    // Registration Setting General Info
    get pencilIcon() { return $(`(//*[name()='svg' and @id='icon-edit'])[1]`) }
    get addCustomFieldButton() { return $(`//*[name()='svg' and @id='icon-add']`) }
    get enterQuestionTitleText() { return $(`//input[@placeholder='Enter field name']`) }
    get questionsTypeDropDown() { return $(`//div[@class='select-dropdown-container']`) }
    get dropDownOption() { return $(`//div[@data-value='select']`) }
    get multiSelectOption() { return $(`//div[@data-value='multiselect']`) }
    get addOptions() { return $(`//span[text()='Add Option']`) }
    get optionvalueOne() { return $(`(//div[@class='edit-registration-question-option']//input)[1]`) }
    get optionvalueTwo() { return $(`(//div[@class='edit-registration-question-option']//input)[2]`) }
    get optionvalueThree() { return $(`(//div[@class='edit-registration-question-option']//input)[3]`) }
    get applyButton() { return $(`//button[@class='primary']`) }
    get filterTag() { return $(`//div[@class='filter-tag not-selected tag-container']`) }
    get generalInfoToggleCard() { return $(`(//div[@class='toggle-card'])[1] | (//div[@class='toggle-container'])[4]`) }


    /*
     * Click on the general info pencil icon
     */
    async clickOnPencilIcon() {
        try {
            await (await this.generalInfoToggleCard).moveTo()
            await browser.pause(2000)
            if (await this.pencilIcon.isDisplayed()) {
                await this.click(await this.pencilIcon)
                reporter.addStep("info", "Clicked on the pencil icon.")
            }
        } catch (err) {
            err.message = `Error clicking on the pencil icon.`
            throw err
        }
    }

    /*
    * Click on the Add Custom filed button
    */
    async clickOnAddCustomFieldButton() {
        try {
            if (await this.addCustomFieldButton.isDisplayed()) {
                await this.click(await this.addCustomFieldButton)
                reporter.addStep("info", "Clicked on the custom field button.")
            }
        } catch (err) {
            err.message = `Error clicking on the custom field button.`
            throw err
        }
    }

    /*
    * Enter the question title
    */
    async enterQuestionTitle(questionTitle: string) {
        try {
            if (await this.enterQuestionTitleText.isDisplayed()) {
                await this.enterQuestionTitleText.clearValue()
                await this.typeInto(await this.enterQuestionTitleText, questionTitle)
                reporter.addStep("info", "entered the question title.")
            }
        } catch (err) {
            err.message = `Error entering the question title.`
            throw err
        }
    }

    /*
    * Select the registration question type
    */
    async selectRegistrationQuestionType(questionType: string, noOfOptions: number, valueOne: string, valueTwo: string, valueThree: string) {
        try {
            if (questionType.match("Dropdown List")) {
                await this.click(await this.questionsTypeDropDown)
                reporter.addStep("info", "Selected the Drop Down.")
                await this.click(await this.dropDownOption)
                await browser.pause(2000)
                reporter.addStep("info", "Selected the Drop Down List option.")
                await this.addOptionsToQuestion(noOfOptions, valueOne, valueTwo, valueThree)
            } else if (questionType.match("Multi Select")) {
                await this.click(await this.multiSelectOption)
                reporter.addStep("info", "Selected the Multi Select option.")
                await this.addOptionsToQuestion(noOfOptions, valueOne, valueTwo, valueThree)
            }
        } catch (err) {
            err.message = `Error selecting registration questions.`
            throw err
        }
    }

    /*
    * Add options to question
    */
    private async addOptionsToQuestion(noOfOptions: number, vOne: string, vtwo: string, vThree: string) {
        try {
            reporter.addStep("info", `Adding the options to question...`)
            for (let i = 1; i <= noOfOptions; i++) {
                await this.click(await this.addOptions)
                await browser.pause(2000)
                reporter.addStep("info", `Added the option the Profile Appearance: ${i}`)
            }
            reporter.addStep("info", `Adding the options value...`)
            await this.optionvalueOne.clearValue()
            await this.typeInto(await this.optionvalueOne, vOne)
            reporter.addStep("info", `Added the first option value.`)
            await this.optionvalueTwo.clearValue()
            await this.typeInto(await this.optionvalueTwo, vtwo)
            reporter.addStep("info", `Added the second option value.`)
            await this.optionvalueThree.clearValue()
            await this.typeInto(await this.optionvalueThree, vThree)
            reporter.addStep("info", `Added the third option value.`)
        } catch (err) {
            err.message = `Error adding the options values.`
            throw err
        }
    }

    /*
    * Click On Apply button
    */
    async clickOnApply() {
        try {
            if (await this.applyButton.isDisplayed()) {
                await this.click(await this.applyButton)
                reporter.addStep("info", "Clicked on the Apply button.")
                await browser.pause(2000)
            }
        } catch (err) {
            err.message = `Error clicking on the Apply button.`
            throw err
        }
    }
}
export default new RegistrationSettingGeneralInfo