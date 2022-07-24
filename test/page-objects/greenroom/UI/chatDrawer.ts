import Page from "../../page";

class ChatDrawer extends Page{
   
    constructor(){
        super()
    }

	public static chatMessageValue: string;

    get chatDrawer(){return $(`//*[name()='svg' and @id='icon-chat-tab']`)}
    get chatInput(){return $(`//span[@class='chat-input']`)}
    get sendMsg(){return $(`//*[name()='svg' and @id='icon-send']`)}
    get dmChat(){return $(`//*[name()='svg' and @id='icon-send']`)}
    get notification(){return $(`//span[contains(@class,'unseen-messages')]`)}
    get backArrow(){return $(`//button[@class='chat-back-button']//*[name()='svg' and @id='icon-arrow-left']`)}
    get toastNotification(){return $(`//*[name()='svg' and @id='icon-close']`)}
	get presenterGroupChat(){return $(`(//*[name()='svg' and @id='icon-arrow-right'])[2]`)}
	get sentMsg(){return $(`//div[@class='chat-message-content']//p`)}
    

    async navigateToChatDrawer() {
		try {
			await this.click(await this.chatDrawer)
			await browser.pause(1000)
		} catch (err) {
			err.message=`Error when clicking on chat drawer`
			throw err
		}
	}

    async sendMsgInChat(msg: string) {
		try {
			await this.typeInto(await this.chatInput,msg)
            await this.click(await this.sendMsg)
			
		} catch (err) {
			err.message=`Error when sending msg`
			throw err
		}
	}

    async openChatDm() {
		try {
            await this.click(await this.dmChat)
			
		} catch (err) {
			err.message=`Error when clicking on chat dm`
			throw err
		}
	}

    async validateChatNotificationOnChatDrawer() {
		try {

            (await this.notification).isDisplayed
		} catch (err) {
			err.message=`Error validating chat notification`
			throw err
		}
	}

    async closeChatMessagesWindow() {
		try {
			await this.click(await this.backArrow)
		} catch (err) {
			err.message=`Error closing chat drawer`
			throw err
		}
	}

    async validateUnreadChatToastNotification() {
		try {
            (await this.toastNotification).isDisplayed
			
		} catch (err) {
			err.message=`Error validating chat toast notification`
			throw err
		}
	}

	async openPresenterGroupChat(){
		try {
			await this.click(await this.presenterGroupChat)
			await browser.pause(1000)
		} catch (err) {
			err.message=`Error when clicking on presenter chat`
			throw err
		}
	}

	async validateChatMessage() {
		try {

            (await this.sentMsg).isDisplayed
			ChatDrawer.chatMessageValue = await this.sentMsg.getText()
		} catch (err) {
			err.message=`Error validating chat notification`
			throw err
		}
	}

}

export default new ChatDrawer