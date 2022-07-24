import Page from "../../page";

class SettingsPage extends Page {
    constructor(){
        super()
    }

// Add Streaming Destination 
get settingTab(){return $(`(//div[@class='header-small-button'])[1]`)}
get ckickStreamingTab(){return $(`(//div[contains(@class,'sliding-menu-options')]//div[2])[2]`)}
get clickAddDestination(){return $(`//div[@class='session-card add-button']//div`)}
get clickDestinationType(){return $(`//span[normalize-space()='other']`)}
get inputDestinationTitle(){return $(`//input[@placeholder='Name your destination...']`)}
get inputRTMPAddress(){return $(`//input[@placeholder='Paste RTMP address here...']`)}
get inputRTMPKey(){return $(`//input[@placeholder='Paste stream key here...']`)}
get clickSaveDestination(){return $(`//button[normalize-space()='Save']`)}
get toggle(){return $(`(//label[@class='switch-container'])[2]`)}
get closeSettings(){return $(`//div[@class='meta-share-tabs']//button[contains(@class,'transparent text')]`)}

	/*
	 * Open Settings Tab
	 */
	async openSettingsTab(){
		try {
			await this.click(await this.settingTab)
			await browser.pause(3000)
		} catch (err) {
			err.message=`Error when clicking setting`
			throw err
		}	
	}


/*
 * Navigate to Streaming tab and add RTMP address
 */
async addDetailsToStreamingTab(){
	try {
		await this.switchToStreamingTab()
		await this.addRTMPDestinationAddress()
		await this.toggleOnDestination()
		await this.closeSettingTab()
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when adding streaming destination in settings tab`
		throw err
	}	
}



async  switchToStreamingTab() {
	try {
		await this.click(await this.ckickStreamingTab)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Switching to Streaming Tab`
		throw err
	}
}


async  addRTMPDestinationAddress() {
	try {
		await this.click(await this.clickAddDestination)
		await this.click(await this.clickDestinationType)
		browser.pause(3000)
		await this.typeInto(await this.inputDestinationTitle, 'StandAloneAPI')
		await browser.pause(1000)
		await this.typeInto(await this.inputRTMPAddress, 'rtmp://1.24041363.fme.ustream.tv/ustreamVideo/24041363')
		await browser.pause(1000)
		await this.typeInto(await this.inputRTMPKey,'zD7u9rT6fxmVVxk5vkZAMCgscQ23JAE7')
		await browser.pause(1000)
		await this.click(await this.clickSaveDestination)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when entering RTMP Details`
		throw err
	}
}

async  toggleOnDestination() {
	try {
		await this.click(await this.toggle)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error toggling On Destination`
		throw err
	}
}

async  closeSettingTab() {
	try {
		await this.click(await this.closeSettings)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when closing Setting Tab`
		throw err
	}
}
}
export default new SettingsPage