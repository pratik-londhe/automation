import Page from "../../page";

class ShowBoard extends Page{

    constructor(){
    super()

}

// Add a new shot to showbuilder mode 

get addNewShotButton(){return $(`//div[@class='add-shot-button-short']`)}
get selectLayout(){return $(`//div[@class='layout-selector stack two right contain']//div[@class='layout-selector-subscript-container']`)}
get applyNewLayout(){return $(`//button[normalize-space()='Apply layout']`)}
get expandShowBoardArrow(){return $(`//div[@class='open-button']`)}
get add1BShot(){return $("(//div[contains(@class,'between-shot')])[1]")}
get add3BShot(){return $("//div[contains(@class,'between-shot-hover')]")}
get select1BShot(){return $(`//div[@class='layout-selector single-padding cover']//div[@class='layout-selector-subscript-container']`)}
get select3BShot(){return $(`//div[@class='layout-selector stack three top']//div[@class='layout-selector-subscript-container']`)}

get videoControls(){return $(`"//div[@class='width-full align-items-center media-controls']"`)}
get clickPlayShot(){return $(`//span[contains(.,'Play Shot')]`)}
get clickToNextShot(){return $(`//span[contains(.,'Next Shot')]`)}
get clickMuteVideo(){return $(`//div[@class='vol-icon-wrap']`)}
get clickPauseVideo(){return $(`//button[@class='background-lighter round play-button']`)}
get clickUnMuteVideo(){return $(`//div[@class='vol-icon-wrap muted']`)}
get clickResumeVideo(){return $(`//button[@class='background-lighter round play-button muted']`)}
get clickToPreviousShot(){return $(`//button[@class='margin-right-small round padding-small background-lighter']`)}

get clearShot(){return $(`//span[normalize-space()='Clear']`)}
get resumeShot(){return $(`//span[normalize-space()='Resume']`)}


/*
	 * Click add new shot button
	 */
async addShotButton() {
	try {
		await this.click(await this.addNewShotButton)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when clicking new shot button`
		throw err
	}
}

/*
 * Select Layout
 */
async select2BLayout() {
    await browser.pause(3000)
    try {
		await this.click(await this.selectLayout)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when selecting 2B Layout`
		throw err
	}
}


/*
 * Apply  Layout
 */
async applyLayout() {
	try {
		await this.click(await this.applyNewLayout)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when applying layout`
		throw err
	}
}

/*
	 * Exapand Show Board by showboard button
	 */
async expandShowBoard(){
	try {
		await this.click(await this.expandShowBoardArrow)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when clicking show board arrow`
		throw err
	}	
}

async add3BLayout(){
	try {
		$("(//div[@class='showboard-shot-item'][2]//div[contains(@class,'between-shot')])[1]").moveTo()
		await this.click(await this.add3BShot)
		await browser.pause(3000)
		await this.click(await this.select3BShot)
		await browser.pause(3000)
		await this.click(await this.applyNewLayout)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when adding 3B Layout shot`
		throw err
	}
}

async add1BLayout(){
	try {
		$("//div[@class='between-shot']").moveTo()
		await browser.pause(1000)
		await this.click(await this.add1BShot)
		await browser.pause(3000)
		await this.click(await this.select1BShot)
		await browser.pause(3000)
		await this.click(await this.applyNewLayout)
		await browser.pause(3000)
	} catch (err) {
		err.message=`Error when adding 1B Layout shot`
		throw err
	}
}		

	async 	playIntroShot() {
		try {
			await this.click(await this.clickPlayShot)
			await browser.pause(6000)
		} catch (err) {
			err.message=`Error when Playing Intro Shot`
			throw err
		}
	}

	async clearIntroShot(){
		try {
			await this.click(await this.clearShot)
			await browser.pause(6000)
		} catch (err) {
			err.message=`Error when clicking previous button`
			throw err
		}

	}

	async resumeIntroShot(){
		try {
			await this.click(await this.resumeShot)
			await browser.pause(6000)
		} catch (err) {
			err.message=`Error when clicking previous button`
			throw err
		}

	}

	async 	navigateToNextShot() {
		try {
			await this.click(await this.clickToNextShot)
			await browser.pause(6000)
		} catch (err) {
			err.message=`Error when Clicking Next Shot`
			throw err
		}
	}
}
export default new ShowBoard