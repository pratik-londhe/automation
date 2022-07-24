import Page from "../../page"
import reporter from "../../../utils/reporter"

class HomePageUI extends Page {

	public static eventTitleNameValue: string;


    constructor(){
        super()
    }

    // page objects
    get checkAppAccessEmailInputBox() {return $(`[name="Email"]`)}
    get checkAppAccessNextButton() {return $(`//button`)}
    get appStreamsButton() {return $(`//button[1]`)}
    get appLegacyButton() {return $(`//button[2]`)}
    get appStandaloneButton() {return $(`//button[3]`)}
    get appLoginEmailInputBox() {return $(`//input[1]`)}
    get appLoginPasswordInputBox() {return $(`[name=Password]`)}
    get appLoginButton() {return $(`//button`)}
    get channelListForProfile() {return $$(`//div[contains(@class,'home-channel-bubble-container flex')]`)}
    get channelNameAtHeader() {return $(`//header/span`)}
    get notificationBellAtHeader() {return $(`//header/div/button`)}
    get profileBubbleAtHeader() {return $(`//header/div/div/div`)}
    get profileOptionsAtHeader() {return $$(`//header/div/div/div/div[2]/div/button`)}
    get appSignOutButton() {return $(`//div[@class='dialog-container right']//button[2]`)}

    // page objects - Team menu
    get teamButtonAtHome() {return $(`//div[@class='home-menu flex']/button[2]`)}
    get teamHeaderAtHome() {return $(`//h1`)}
    get teamSearchInputBox() {return $(`//div[@class='flex']//input`)}
    get teamInviteButton() {return $(`//div[@class='flex']/div[2]/span`)}

    // page objects - Shows menu
    get showsButtonAtHome() {return $(`//div[@class='home-menu flex']/button[1]`)}
    get showsCardContainer() {return $(`//div[@class='select-content-container']/div[@class='featured-cards-container']`)}
    get showsCardContainerCard() {return $$(`//div[@class='select-content-container']/div[@class='featured-cards-container']//div[@class='card']`)}
    get allShowsSearchInputBox() {return $(`//div[@class='select-content-container']//input[@placeholder='Search']`)}
    get allShowsCalendarIcon() {return $(`//div[@class='calendar-switch-container']//label[@class='switch-container']`)}
    get allShowsListIcon() {return $(`//div[@class='calendar-switch-container']//label[@class='switch-container checked']`)}
    get allShowsPeriodSelectBox() {return $$(`//div[@class='select-content-container']//div[@class='select-small']/div/div`)}
    get allShowsUpcomingButton() {return $(`//div[@class='upcoming-past-container']//button[1]`)}
    get allShowsPastButton() {return $(`//div[@class='upcoming-past-container']//button[2]`)}

    // page objects - Profile menu options
    get editProfileFormClosure() {return $(`//div[@class='meta-menu-content open']//button[@class='transparent text-highlight']`)}
    get appSignOutCancelButton() {return $(`//div[@class='dialog-container right']//button[1]`)}
	
	// Search SGR Name
	get searchSGRName(){return $(`//input[@placeholder='Search']`)}
	get sgrEventTitleName() {return $(`div[class='event-titles'] h4`)}
	get clickEventAction(){return $(`//div[@class='event-row']`)}

    //Confirm presenter details
    get nextButton(){return $(`//button[contains(@class,'next background-green')]`)}




    // page object methods
    async navigateToGreenroomUrl(path: string) {
        if(!path) throw Error(`Given path ${path} is not valid`)

        try{
            await this.navigateTo(path)
            await browser.pause(2000)
            reporter.addStep("info", "Greenroom page loaded successfully")
        }catch(err){
            err.message = `Error entering url: , ${err.message} `
            throw err
        }
    }

    async checkGreenroomAppAccessForProfile(email: string) {
        if(!email) throw Error(`The ${email} is not valid...`)

        try {
            await this.typeInto(await this.checkAppAccessEmailInputBox, email)
            await this.click(await this.checkAppAccessNextButton)
            await browser.pause(2000)
            reporter.addStep("info", "App access check completed successfully...")
        } catch (err) {
            err.message = `Error completing the app access check: , ${err.message} `
            throw err
        }

    }

    async appSelectionForGreenroom(app: string) {
        if(!app) throw Error(`The ${app} is not valid...`)

        try {
            switch(app.toLowerCase()) {
                case "streams":
                    await this.click(await this.appStreamsButton)
                    await browser.pause(2000)
                    reporter.addStep("info", "App selected successfully...")
                    break;
                case "legacy":
                    await this.click(await this.appLegacyButton)
                    await browser.pause(2000)
                    reporter.addStep("info", "App selected successfully...")
                    break;
                case "standalone":
                    await this.click(await this.appStandaloneButton)
                    await browser.pause(2000)
                    reporter.addStep("info", "App selected successfully...")
                    break;
                default:
                    reporter.addStep("info", `App ${app} is invalid...`)
                    break;
            }
        } catch (err) {
            err.message = `Error completing the app selection: , ${err.message} `
            throw err
        }
    }

    async greenroomLoginForApp(email: string, password: string) {
        try {
            await this.typeInto(await this.appLoginEmailInputBox, email)
            await this.typeInto(await this.appLoginPasswordInputBox, password)
            await this.click(await this.appLoginButton)
            await browser.pause(2000)
            reporter.addStep("info", `The login process completed...`)
        } catch (err) {
            err.message = `Error log in to greenroom: , ${err.message} `
            throw err
        }
    }

    async selectChannelForProfile(channelName: string) {
        try {
            let channelsForProfile = []
            let channelImgsForProfile = []
            channelsForProfile = await this.channelListForProfile
     
            let i = 0
            while(i < channelsForProfile.length) {
                let name: string
                let channelForProfile: WebdriverIO.Element
                channelForProfile = channelsForProfile[i]
                console.log(`The counters are ${i}`)
                try {
                    name = await channelForProfile.getAttribute("data-name")
                    console.log(`The name of channel is ${name}`)
                    if(name && name.match(channelName)) {
                        await this.click(channelForProfile)
                        await browser.pause(2000)
                        reporter.addStep("info", `The automation channel selected...`)
                        break;
                    }
                } catch (err) {
                    
                }
                i++
            }    
        } catch (err) {
            err.message = `Error while selecting automation channel: , ${err.message} `
            throw err
        }
    }

    async checkHomeHeaderInfo(): Promise<any> {
        try {
            let name = await this.channelNameAtHeader.getText()
            await this.click(await this.notificationBellAtHeader)
            await browser.pause(3000)
            await browser.refresh()
            await browser.pause(3000)
            await this.click(await this.profileBubbleAtHeader)
            await browser.pause(3000)
            await this.click(await this.profileBubbleAtHeader)
            reporter.addStep("info", `The header info at the channel home page checked...`)
            return name
        } catch (err) {
            err.message = `Error while checking home page header: , ${err.message} `
            throw err
        }
    }

    async signoutGreenroomAtHomePage(){
        try {
            await this.click(await this.profileBubbleAtHeader)
            await browser.pause(3000)
            console.log(`In the signoutGreenroomAtHomePage`);
            let profileOptions = []
            profileOptions = await this.profileOptionsAtHeader
            console.log(`The options number: ${profileOptions.length}`);
            let optionText: string
            let profileOption: WebdriverIO.Element
            for(let i=0; i<=profileOptions.length; i++) {
                profileOption = profileOptions[i]
                optionText = await profileOption.getText()
                console.log(`The option text is ${optionText}`);
                if(optionText.match("Sign Out")){
                    await this.click(profileOption)
                    reporter.addStep("info", `Clicked on Sign Out option...`)
                    break;
                }
            }
            await this.click(await this.appSignOutButton)
            reporter.addStep("info", `Signed out of greenroom...`)
        } catch (err) {
            err.message = `Error while signing out of greenroom: , ${err.message} `
            throw err
        }
    }

    async searchTeamMemberAtHomePage(filter: string) {
        try {
            await this.click(await this.teamButtonAtHome)
            await browser.pause(1000)
            await this.click(await this.teamInviteButton)
            await browser.pause(1000)
            await this.typeInto(await this.teamSearchInputBox, filter)
            await browser.keys("Enter")
            await browser.pause(3000)
            reporter.addStep("info", `Team member ${filter} searched successfully...`)
        } catch (err) {
            err.message = `Error while searching team member: , ${err.message} `
            throw err
        }
    }

    async searchShowAtHomePage(filter: string) {
        try {
            await this.click(await this.showsButtonAtHome)
            await browser.pause(1000)
            if(await this.showsCardContainer.isExisting) {
                let cardArr = []
                cardArr = await this.showsCardContainerCard
                reporter.addStep("info", `There are ${cardArr.length} cards in this channel at the moment...`)
            }
            // Moving to Calendar View
            await this.click(await this.allShowsListIcon)
            await browser.pause(1000)
            // let periodArr = []
            // periodArr = await this.allShowsPeriodSelectBox
            // periodArr.forEach((val, index) => {
            //     let ele: WebdriverIO.Element
            //     ele = periodArr[index]
            //     ele.click()
            //     browser.pause(1000)
            //     reporter.addStep("info", `The period option is ${ele.getText()}...`)
            // })
            // Moving to List View
            await this.click(await this.allShowsCalendarIcon)
            await browser.pause(1000)
            await this.click(await this.allShowsPastButton)
            await browser.pause(1000)
            await this.typeInto(await this.allShowsSearchInputBox, filter)
            await browser.keys("Enter")
            await browser.pause(3000)
            await this.click(await this.allShowsUpcomingButton)
            await browser.pause(1000)
            reporter.addStep("info", `Search of show ${filter} completed successfully...`)
        } catch (err) {
            err.message = `Error while searching show: , ${err.message} `
            throw err
        }
    }

    async selectProfileOptionAndFormClosure(option: string) {

        switch(option.toLowerCase()) {
            case "edit profile":
                await this.selectProfileOption(0)
                await this.click(await this.editProfileFormClosure)
                await browser.pause(1000)
                break;
            case "video settings":
                await this.selectProfileOption(1)
                await this.click(await this.editProfileFormClosure)
                await browser.pause(1000)
                break;
            case "all notes":
                await this.selectProfileOption(2)
                await this.click(await this.editProfileFormClosure)
                await browser.pause(1000)
                break;
            case "sign out":
                await this.selectProfileOption(3)
                await this.click(await this.appSignOutCancelButton)
                await browser.pause(1000)
                break;
            default:
                reporter.addStep("info", `The profile option is ${option} is invalid...`)
                break;
        }
    }


	
	/**
	 * @param eventName
	 * Search New SGR Event and validate the sgrEventName using chai
	 */
	 async searchNewSGREvent(eventName : string) {
		console.log('Event Name to search is ' , eventName)
		try {
			await this.typeInto(await this.searchSGRName, eventName)
			await browser.pause(3000)
			const eventTitleName = await this.sgrEventTitleName
			HomePageUI.eventTitleNameValue = await eventTitleName.getText()
			console.log('Event tile name after searching is : ' , HomePageUI.eventTitleNameValue)
			await browser.pause(1000)
		} catch (err){
			err.message = `Error searching sgr event name`
			throw err
		}
	}



	/*
	 * Navigate to show details page  
	 */
	async navigateToShowDetailsPage() {
		try {
			await this.click(await this.clickEventAction)	
			await browser.pause(3000)
		}catch (err) {
			err.message=`Error when navigating to show details page`
			throw err
		}
	}




    private async selectProfileOption(index: number) {
        let profileOptionArr = []
        let profileOption: WebdriverIO.Element
        await this.click(await this.profileBubbleAtHeader)
        await browser.pause(1000)
        profileOptionArr = await this.profileOptionsAtHeader
        profileOption = profileOptionArr[index]
        await profileOption.click()
        await browser.pause(1000)
        reporter.addStep("info", `The profile option ${index} selected successfully...`)
    }


    async confirmPresenterDetails() {
		try {
            await this.click(await this.nextButton)
			await browser.pause(1000)
            await this.click(await this.nextButton)
			await browser.pause(1000)
            await this.click(await this.nextButton)
			await browser.pause(1000)
            await this.click(await this.nextButton)
			await browser.pause(1000)
		} catch (err){
			err.message = `Error confirming presenter details`
			throw err
		}
	}


}
export default new HomePageUI()