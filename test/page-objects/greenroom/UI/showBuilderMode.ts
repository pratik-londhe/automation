import Page from "../../page";

class ShowBuilderMode extends Page {

	constructor(){
        super()
    }

    get exit(){return $(`//div[@class='room-state-switch-button editing']`)}

    async exitBuilderMode() {
        try {
            await this.click(await this.exit)
            await browser.pause(3000)
        } catch (err) {
            err.message=`Error exiting builder mode`
            throw err
        }
    }



}
export default new ShowBuilderMode

