import Page from "../../page"
import reporter from "../../../utils/reporter"

class GeneralInfo extends Page {

    constructor() {
        super()
    }

    // General Info details
    get firstName() { return $(`(//input[@placeholder='First Name'])[1]`) }
    get lastName() { return $(`(//input[@placeholder='Last Name'])[1]`) }
    get email() { return $(`(//input[@placeholder='Email Address'])[1]`) }
    get passcodeLabel() { return $(`//input[contains(@placeholder,'Passcode')]`) }
    get nextButton() { return $(`(//button[@type='submit'])[1]`) }
    get questionDropDown() { return $(`(//select[@class='evt-select'])[1]`) }


    /*
    * Enter general info on the registraaion page
    */
    async enterGeneralInfo(fName: string, lName: string, mail: string, passcode: string) {
        reporter.addStep("info", "Enter general info details on the registration page...")
        await this.firstName.clearValue()
        await this.typeInto(await this.firstName, fName)
        reporter.addStep("info", "Entered first name...")
        await this.lastName.clearValue()
        await this.typeInto(await this.lastName, lName)
        reporter.addStep("info", "Entered last name...")
        await this.email.clearValue()
        await this.typeInto(await this.email, mail)
        reporter.addStep("info", "Entered last name...")
        if (await this.passcodeLabel.isDisplayed()) {
            await this.email.clearValue();
            await this.typeInto(await this.passcodeLabel, passcode)
            reporter.addStep("info", "Entered passcode label name...")
        } else {
            reporter.addStep("info", "There is not passcode lebel...")
        }
        if (await this.questionDropDown.isDisplayed()) {
            await this.selectDropDownOption()
        } else {
            reporter.addStep("info", "registration Drop down or Multipselec questions are not added...")
        }
        browser.pause(3000)
        await this.click(await this.nextButton)
        reporter.addStep("info", "Clicked on the Next button.")
        browser.pause(3000)
    }

    /*
     * Select drop down option
    */
    private async selectDropDownOption() {
        reporter.addStep("info", "Selecting the value from download...")
        if (await this.questionDropDown.isDisplayed()) {
            await this.questionDropDown.selectByIndex(0);
            reporter.addStep("info", "Selected the drop down value.")
        }
    }

}
export default new GeneralInfo