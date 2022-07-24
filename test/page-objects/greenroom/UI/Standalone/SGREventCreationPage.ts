import reporter from "../../../../utils/reporter";
import Page from "../../../page";


class SGREventCreationPage extends Page {

	public static getSGREventName: string;

    constructor(){
        super()
    }

    // page objects - create SGR Event
	get clickSGREventButton() {return $(`//span[@class='margin-left-small font-weight-bold text-dark']`)}
	get inputSGREventTitleName() {return $(`//input[@class='input']`)}
	get clickStartDateWidgetOfSGREvent() {return $(`(//div[@class='date']//div[@class='react-datepicker__input-container']//input)[1]`)}
	get selectStartDateOfSGREvent() {return $(`(//div[@class='date']//div[@class='react-datepicker__input-container']//input)[1]`)}
	get clickStartTimeWidgetOfSGREvent() {return $(`(//div[@class='time']//div[@class='react-datepicker__input-container']//input)[1]`)}
	get selectStartTimeOfSGREvent() {return $(`(//div[@class='time']//div[@class='react-datepicker__input-container']//input)[1]`)}
	get clickEndDateOfSGREvent() {return $(`(//div[@class='date']//div[@class='react-datepicker__input-container']//input)[2]`)}
	get clickEndTimeWidgetOfSGREvent() {return $(`(//div[@class='time']//div[@class='react-datepicker__input-container']//input)[2]`)}
	get selectEndTimeOfSGREvent() {return $(`(//div[@class='time']//div[@class='react-datepicker__input-container']//input)[2]`)}
	get sendEmailInvite() {return $(`//input[@placeholder='Enter email to invite...']`)}
	get createSGREvent(){return $(`//button[normalize-space()='Save']`)}

    // page object methods

	/*
	 * Create new SGR Event
	 */
	async createNewSGREvent(invite: string) {
		try{
			await this.click(await this.clickSGREventButton)
			SGREventCreationPage.getSGREventName =  await this.generateEventName()

			await this.typeInto(await this.inputSGREventTitleName,SGREventCreationPage.getSGREventName)
			await browser.pause(1000)

			await this.click(await this.clickStartDateWidgetOfSGREvent)
			await this.typeInto(await this.selectStartDateOfSGREvent, (await this.addDaysToDate()))
	
			await browser.pause(2000)


			await this.click(await this.clickStartTimeWidgetOfSGREvent)
			await browser.keys(['Control','a'])
			await browser.keys(['Backspace'])
			await this.typeInto(await this.selectStartTimeOfSGREvent, await this.getSGREventTime('Start-Time') )
			await browser.pause(2000)

			await this.click(await this.clickEndDateOfSGREvent)
			
			await this.typeInto(await this.sendEmailInvite, invite)
			await this.click(await this.createSGREvent)
			await browser.pause(5000)

        }catch(err){
            err.message = `Error creating new sgr event name: , ${err.message} `
            throw err
        }
	}



	//private methods

	private async addDaysToDate() {

		const now = new Date()
		const next5Days = new Date(new Date(now).setDate(now.getDate() + 5))
		console.log('now', now.toLocaleDateString())
		console.log('Next5Day', next5Days.toLocaleDateString())
		return next5Days.toLocaleString();
	  }
	  
	/*
	 * private method for getting SGR Event Name
	 */
		public async generateEventName() {
			try {
				reporter.addStep("info", `Generating the Event name...`)
				let random = Math.floor(Math.random() * 1000) + 1;
				var date = new Date().toLocaleString()
				SGREventCreationPage.getSGREventName = "SGR Automation Event : " + random + " " + date
				console.log('The Event name is: ',SGREventCreationPage.getSGREventName)
				reporter.addStep("info", `Generated the Event name...`)
				return SGREventCreationPage.getSGREventName
			} catch (err) {
				err.message = `Error generating the SGR Event name: , ${err.message} `
				throw err
			}

		}


	/*
	 * private method for getting SGR Event Time ( Start and End Time )
	 */
	private async getSGREventTime(whichTime: String) {
		const currentDate = new Date();
		if (whichTime === 'Start-Time'){
			return new Date(currentDate.getTime() + 30*60000).toLocaleString([], { hour: 'numeric', minute: 'numeric' })

		}else{
			return new Date(currentDate.getTime() + 60*60000).toLocaleString([], { hour: 'numeric', minute: 'numeric' })
		}
	}



}

export default new SGREventCreationPage


