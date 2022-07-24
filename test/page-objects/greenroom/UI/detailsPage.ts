import Page from "../../page";


class DetailsPage extends Page {

	constructor(){
        super()
    }

	get joinSGREvent(){return $(`//button[@class='join-button is-live']`)}

	/*
	 * Navigate to Live Mode  
	 */
	async navigateToLiveMode() {
		try {
			await this.click(await this.joinSGREvent)
			await browser.pause(6000)
		} catch (err) {
			err.message=`Error when entering to live mode`
			throw err
		}
	}


}
export default new DetailsPage


