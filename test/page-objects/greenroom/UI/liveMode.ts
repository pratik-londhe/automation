import getText from "webdriverio/build/commands/element/getText";
import Page from "../../page";

class LiveMode extends Page {

	constructor(){
        super()
    }

	static videoPausedDuration : any

	get showBuilderMode() {return $(`//div[@class='room-state-switch-button showtime']`)}
	get accountProfile(){return $(`//div[@class='avatar-button']//div`)}
	get signOut(){return $(`//button[normalize-space()='Sign Out']`)}
	get overlayTab(){return $(`(//div[contains(@class,'sliding-menu-option font-weight-heavy')])[3]`)}
	get DragNDropOverlay(){return $(`//div[@class='video-container-presenter first']`)}
	get buildInAnimationEffect(){return $(`(//div[@class='animation-row']//div[@class='select-small'])[2]`)}
	get buildInAnimationEffectDropDownOptions(){return $(`(//div[@class='select-body open drop-left']//div[contains(@class,'select-option')])[3]`)}
	get saveButton(){return $(`//button[contains(@class,'padding-button-medium background-green')]`)}
	get videoControls(){return $(`"//div[@class='width-full align-items-center media-controls']"`)}
	get clickPlayShot(){return $(`//span[contains(.,'Play Shot')]`)}
	get clickToNextShot(){return $(`//span[contains(.,'Next Shot')]`)}
	get clickMuteVideo(){return $(`//div[@class='vol-icon-wrap']`)}
	get clickPauseVideo(){return $(`//button[@class='background-lighter round play-button']`)}
	//get clickPauseVideo(){return $(`//*[name()='svg' and @id='icon-pause']`)}
	get clickUnMuteVideo(){return $(`//div[@class='vol-icon-wrap muted']`)}
	get clickResumeVideo(){return $(`//button[@class='background-lighter round play-button muted']`)}
	get clickToPreviousShot(){return $(`//button[@class='margin-right-small round padding-small background-lighter']`)}
	get paginationNextArrow(){return $(`(//button[@class='background-lighter round padding-medium control'])[1]`)}
    get paginationBackArrow(){return $(`(//button[@class='background-lighter round padding-medium control'])[2]`)}
    get pdfShot(){return $(`(//div[@class='media-controls-layer width-full height-full first false']`)}
    get backShot(){return $(`(//button[@class='margin-right-small round padding-small background-lighter']`)}
	get gettingReadyOld(){return $(`//div[@class='broadcast-status loading']`)}
	get goLive(){return $(`//*[name()='svg' and @id='icon-live']`)}
	get gettingReadyStream(){return $(`//div[@class='broadcast-status text-transform-capitalize loading']`)}
	get goLiveStream(){return $(`//div[contains(@class,'broadcast-indicator')]`)}
	get feedsTab(){return $(`//div[@class='right-drawer-menu non-highlight-section']//div[1]//div[1]`)}
	get videoDuration(){return $(`//div[@class='white-space-nowrap font-weight-bold padding-right-medium']`)}
	get streamDropDown(){return $(`(//span[@class='select-label dropdown'])[1]`)}
	get streamRecordOtions(){return $(`(//div[contains(@class,'select-option')])[2]`)}
	get savedRecording(){return $(`//div[contains(@class,'sliding-menu-option font-weight-heavy')])[3]`)}

	public static recordingName: string;


	/*
	 * Navigate to ShowBuilderMode
	 */
		async navigateToShowBuilderMode() {
			try {
				await this.click(await this.showBuilderMode)
				await browser.pause(6000)
			} catch (err) {
				err.message=`Error when entering ShowBuilder Mode`
				throw err
			}
		}


	/*
	 * Navigate to ShowBuilderMode
	 */
			async signOutGRFromLiveMode() {
				try {
					await this.click(await this.accountProfile)
					await browser.pause(3000)
					await this.click(await this.signOut)
					await browser.pause(3000)
					await this.click(await this.signOut)
					await browser.pause(6000)
				} catch (err) {
					err.message=`Error when signingout from livemode`
					throw err
				}
			}

		/* Refreshing every 30 secs for 10 mins */

			async refreshEvery(seconds) {
				try {

					const start = new Date()
					const currentTimePlus10Mins = Math.round((start.getTime() + (60 * 1000 * 10)) / 1000)

					while (true) {
						const now = new Date()
						const currentTime = Math.round(now.getTime() / 1000)

						if (currentTimePlus10Mins>currentTime){
							await browser.pause(seconds * 1000)
							await browser.refresh()
						}
						else{
							console.log('10 Mins have passed!');
							break
						}
					}
				} catch (err) {
					err.message='Error when refreshing'
				}
			}

			async videoActions(){
				try {

							await this.muteVideo()
							await browser.pause(2000)

							await this.unMuteVideo()
							await browser.pause(2000)

							await this.pauseVideo()
							await browser.pause(2000)

							await this.resumeVideo()
							await browser.pause(1000)
				} catch (err) {
					err.message=`Error when clicking previous button`
					throw err
				}

			}

			async muteVideo() {
				try {
					$("//div[@class='width-full align-items-center media-controls']").moveTo()
					await this.click(await this.clickMuteVideo)
					await browser.pause(6000)
				} catch (err) {
					err.message=`Error when muting Outro Video`
					throw err
				}
			}

			async dragAndDropOverlay(name :string) {
				console.log('====================================');
				console.log(name);
				console.log('====================================');
				try {
					await browser.pause(5000)
					await (await this.DragNDropOverlay).waitForDisplayed()
					await ((await $(`//p[text()=${name}]/..//parent::div/.//parent::div[contains(@class,'media-link')]`))).dragAndDrop(await this.DragNDropOverlay,{duration:6000})
					await browser.pause(10000)

				} catch (err) {
					err.message=`Error when dragging overlay file`
				}
			}

			async pauseVideo() {
				try {
					$("//div[@class='width-full align-items-center media-controls']").moveTo()
					await this.click(await this.clickPauseVideo)
					await browser.pause(6000)
				} catch (err) {
					err.message=`Error when pausing Intro Video`
					throw err
				}
			}

			async unMuteVideo() {
				try {
					$("//div[@class='width-full align-items-center media-controls']").moveTo()
					await this.click(await this.clickUnMuteVideo)
					await browser.pause(6000)
				} catch (err) {
					err.message=`Error when Un muting Outro Video`
					throw err
				}
			}


			async resumeVideo() {
				try {
					$("//div[@class='width-full align-items-center media-controls']").moveTo()
					await this.click(await this.clickResumeVideo)
					await browser.pause(6000)
				} catch (err) {
					err.message=`Error when resuming OutroVideo`
					throw err
				}
			}

			async paginationControls() {
				try {
					$("//div[@class='media-controls-layer width-full height-full first false']").moveTo()
					await browser.pause(5000)
					await this.click(await this.paginationBackArrow)
					await browser.pause(5000)
					await this.click(await this.paginationNextArrow)
					await browser.pause(8000)
				} catch (err) {
					err.message=`Error whendoing pagination`
					throw err
				}
			}

			async applyBuildInAnimation() {
				try {
					await this.click(await this.buildInAnimationEffect)
					await browser.pause(3000)
					await this.click(await this.buildInAnimationEffectDropDownOptions)
					await browser.pause(2000)
					await this.click(await this.saveButton)
					await browser.pause(2000)
				} catch (err) {
					err.message=`Error applying build in animation`
				}
			}


			async openFeedsTab() {
				try {
					await this.click(await this.feedsTab)
					await browser.pause(6000)
				} catch (err) {
					err.message=`Error when opening feeds tab`
					throw err
				}
			}

			async previousShot() {
				try {
					await this.click(await this.clickToPreviousShot)
					await browser.pause(6000)
				} catch (err) {
					err.message=`Error when clicking previous shot`
					throw err
				}
			}


			async goLiveWithShow() {
				try {
					if((await this.gettingReadyOld).isDisplayed){
						await browser.pause(20000)
						browser.refresh
						await this.click(await this.goLive)
						await browser.pause(5000)
					}else{
						await browser.pause(20000)
						browser.refresh
						await this.click(await this.goLiveStream)
						await browser.pause(5000)
					}
				} catch (err) {
					err.message=`Error when going live`
					throw err
				}
			}

			async navigateToOverlaysTab() {
				try {
					await this.click(await this.overlayTab)
					await browser.pause(1000)
				} catch (err) {
					err.message=`Error navigating to overlay tab`
				}
			}

			async getVideoDuration() {
				try {
					$("//div[@class='width-full align-items-center media-controls']").moveTo()
					let videoDuration=  await this.videoDuration.getText()
					LiveMode.videoPausedDuration = videoDuration.split("/")[0].trim().split(":")[0]
					
				} catch (err) {
					err.message=`Error when pausing Outro Video`
					throw err
				}
			}

			async startRecordingShow() {
				try {
					await this.click(await this.streamDropDown)
					await this.click(await this.streamRecordOtions)
					}
			catch (err) {
					err.message=`Error selecting record option`
				}
			}

			async stopRecordingShow() {
				try {
					await this.click(await this.streamRecordOtions)
					await browser.pause(1000)
				} catch (err) {
					err.message=`Error stopping recording of the show`
				}
			}

			async validateRecordingName() {
				try {
		
					(await this.savedRecording).isDisplayed
					LiveMode.recordingName = await this.savedRecording.getText()
				} catch (err) {
					err.message=`Error validating chat notification`
					throw err
				}
			}

}
export default new LiveMode

