import Page from "../../page";

class MediaDrawer extends Page {

	constructor(){
        super()
    }
 
 get clickMediaDrawer(){return $(`//div[@class='right-drawer-menu non-highlight-section']//div[3]//div[1]`)}
 get uploadButton(){return $(`//input[@id='file-input']`)}

 get imageSource(){return $(`//p[text()='{$}']/..//parent::div/.//parent::div[@class='media-link']`)}  
 get imageDestination(){return $(`//div[@class='video-container-presenter second']`)}
 get DragNDrop1B(){return $(`//div[@class='video-container-presenter first']`)}
 get DragNDropSecondFeed(){return $(`(//div[@class='video-container-presenter second'])[1]`)}
 get DragNDropThirdFeed(){return $(`(//div[@class='video-container-presenter third'])[1]`)}
 get recordingTab(){return $(`(//div[contains(@class,'sliding-menu-option')])[5]`)}

 async openMediaDrawer() {
    try {
        await this.click(await this.clickMediaDrawer)
        await browser.pause(3000)
    } catch (err) {
        err.message=`Error when Opening media drawer`
        throw err
    }
}



/*
	 * Upload image file
	 */
async uploadImageMedia(mediaName : string) {
    let path = (`${process.cwd()}/data/fileUpload/${mediaName}`)
    try {
        await (await this.uploadButton).addValue(path)
        await browser.pause(20000)
    } catch (err) {
        err.message=`Error when uploading Image file`
        throw err
    }
}

/*
 * Drag and Drop Image file to canvas
 */
	
async dragAndDropImage(name :string) {
	let source = await ($(`//p[text()='${name}']/..//parent::div/.//parent::div[@class='media-link']`))
	console.log('source locator is '+ source)
	try { 	
		await (await this.imageDestination).waitForDisplayed()
		await ($(`//p[text()='${name}']/..//parent::div/.//parent::div[@class='media-link']`)).dragAndDrop(await this.imageDestination)
		await browser.pause(10000)
		
	} catch (err) {
		err.message=`Error when dragging image file`
		throw err
	}
}

async dragNDropFileToFeed(name :string,feedNo : number) {

    console.log('====================================');
    console.log(name);
    console.log('====================================');
    try { 	
        await browser.pause(5000)
    switch (feedNo) {
        case 1:
        await (await this.DragNDrop1B).waitForDisplayed()
        await ((await $(`//p[text()=${name}]/..//parent::div/.//parent::div[@class='media-link']`))).dragAndDrop(await this.DragNDrop1B,{duration:6000})
        await browser.pause(10000)
            
            break;

        case 2:
        await (await this.DragNDropSecondFeed).waitForDisplayed()
        await ((await $(`//p[text()=${name}]/..//parent::div/.//parent::div[@class='media-link']`))).dragAndDrop(await this.DragNDropSecondFeed,{duration:6000})
        await browser.pause(10000)
            
            break;

        case 3:
        await (await this.DragNDropThirdFeed).waitForDisplayed()
        await ((await $(`//p[text()=${name}]/..//parent::div/.//parent::div[@class='media-link']`))).dragAndDrop(await this.DragNDropThirdFeed,{duration:6000})
        await browser.pause(10000)
                    
                    break;
    
        default:
            break;
    }		

        await browser.pause(10000)
    } catch (err) {
        err.message=`Error when dragging image file`
        throw err
    }
}

async navigateToRecordingTab() {
    try {
        await this.click(await this.recordingTab)
        await browser.pause(1000)
    } catch (err) {
        err.message=`Error when Opening recording tab`
        throw err
    }
}





}
export default new MediaDrawer