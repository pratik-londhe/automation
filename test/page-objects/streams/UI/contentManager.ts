import Page from "../../page"
import reporter from "../../../utils/reporter"

class ContentManager extends Page {

    constructor() {
        super()
    }

    // Content details
    get addContentButton() { return $(`//button[@class='small primary']`) }
    get documentIcon() { return $(`(//*[name()='svg' and @id='icon-document'])[1]`) }
    get fileUpoad() { return $(`//input[@type='file']`) }
    get addButton() { return $(`//button[@class='primary']`) }
    get imageIcon() { return $(`(//*[name()='svg' and @id='icon-wallpaper'])[1]`) }
    get videoIcon() { return $(`(//*[name()='svg' and @id='icon-camera-on'])[1]`) }
    get fontsIcon() { return $(`(//*[name()='svg' and @id='icon-fonts'])[1]`) }
    get uploadHeaderFonts() { return $(`(//input[@type='file'])[1]`) }
    get uploadBodyFonts() { return $(`(//input[@type='file'])[2]`) }
    get palettesIcon() { return $(`(//*[name()='svg' and @id='icon-palettes'])[1]`) }
    get palettesText() { return $(`//input[@placeholder='Palette Name']`) }
    get imagesTab() { return $(`//span[text()='Images']`) }
    get fontsTab() { return $(`//span[text()='Fonts']`) }
    get palettesTab() { return $(`//span[text()='Palettes']`) }
    get videoTab() { return $(`//label[text()='Videos']`) }
    get uploadedVideoTab() { return $(`//li[text()='Uploaded']`) }


    /*
     * Click on the Add Content icon
     */
    async clickOnAddContentButton() {
        try {
            await this.click(await this.addContentButton)
            reporter.addStep("info", 'clicked on the add content button.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the add content button`
            throw err
        }
    }

    /*
     * Click on the documents icon
     */
    async clickOnDocumentsIcon() {
        try {
            await this.click(await this.documentIcon)
            reporter.addStep("info", 'clicked on the Documents icon.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the documents icon`
            throw err
        }
    }

    /*
     * Upload document in the content manager
     */
    async uploadDocumentDetails(fileName: string) {
        let path = (`${process.cwd()}/data/fileUpload/streams/${fileName}`)
        try {
            await (await this.fileUpoad).addValue(path)
            reporter.addStep("info", 'Uploaded the file.')
            await browser.pause(5000)
            await this.click(await this.addButton)
            reporter.addStep("info", 'clicked on the Done button.')
            await browser.pause(3000)
        } catch (err) {
            err.message = `Error when uploading Document file`
            throw err
        }
    }

    /*
     * Click on the Images icon
     */
    async clickOnImagesIcon() {
        try {
            await this.click(await this.imageIcon)
            reporter.addStep("info", 'clicked on the Images icon.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the Images icon`
            throw err
        }
    }

    /*
     * Upload Images in the content manager
     */
    async uploadImagesDetails(fileName: string) {
        let path = (`${process.cwd()}/data/fileUpload/streams/${fileName}`)
        try {
            await (await this.fileUpoad).addValue(path)
            reporter.addStep("info", 'Uploaded the images.')
            await browser.pause(5000)
            await this.click(await this.addButton)
            reporter.addStep("info", 'clicked on the Done button.')
            await browser.pause(3000)
        } catch (err) {
            err.message = `Error when uploading Image file`
            throw err
        }
    }

    /*
     * Click on the Video icon
     */
    async clickOnVideoIcon() {
        try {
            await this.click(await this.videoIcon)
            reporter.addStep("info", 'clicked on the video icon.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the video icon`
            throw err
        }
    }

    /*
    * Upload video in the content manager
    */
    async uploadVideoDetails(fileName: string) {
        let path = (`${process.cwd()}/data/fileUpload/greenroom/${fileName}`)
        try {
            await (await this.fileUpoad).addValue(path)
            reporter.addStep("info", 'Uploaded the Videos.')
            await browser.pause(25000)
            await this.click(await this.addButton)
            reporter.addStep("info", 'clicked on the Done button.')
            await browser.pause(3000)
        } catch (err) {
            err.message = `Error when Videos Image file`
            throw err
        }
    }

    /*
     * Click on the Fonts icon
     */
    async clickOnFontsIcon() {
        try {
            await this.click(await this.fontsIcon)
            reporter.addStep("info", 'clicked on the fonts icon.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the fonts icon`
            throw err
        }
    }

    /*
    * Upload fonts in the content manager
    */
    async uploadFontsDetails(fileName: string) {
        let path = (`${process.cwd()}/data/fileUpload/streams/${fileName}`)
        try {
            await (await this.uploadHeaderFonts).addValue(path)
            reporter.addStep("info", 'Uploaded header fonts.')
            await browser.pause(5000)
            await (await this.uploadBodyFonts).addValue(path)
            reporter.addStep("info", 'Uploaded body fonts.')
            await browser.pause(5000)
            await this.click(await this.addButton)
            reporter.addStep("info", 'clicked on the Done button.')
            await browser.pause(3000)
        } catch (err) {
            err.message = `Error when fonts image file`
            throw err
        }
    }

    /*
    * Click on the Palettes icon
    */
    async clickOnPalettesIcon() {
        try {
            await this.click(await this.palettesIcon)
            reporter.addStep("info", 'clicked on the fonts icon.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the fonts icon`
            throw err
        }
    }

    /*
    * Create color palettes
    */
    async createColorPalettes(palettesName: string) {
        try {
            await this.typeInto(await this.palettesText, palettesName)
            reporter.addStep("info", 'Entered the palettes name.')
            await this.click(await this.addButton)
            reporter.addStep("info", 'clicked on the Done button.')
            await browser.pause(3000)
        } catch (err) {
            err.message = `Error creating the palettes`
            throw err
        }
    }

    /*
    * Click on the images tab
    */
    async clickOnImagesTab() {
        try {
            await this.click(await this.imagesTab)
            reporter.addStep("info", 'clicked on the images tab.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the images tab`
            throw err
        }
    }

    /*
    * Click on the fonts tab
    */
    async clickOnFontsTab() {
        try {
            await this.click(await this.fontsTab)
            reporter.addStep("info", 'clicked on the fonts tab.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the fonts tab`
            throw err
        }
    }

    /*
     * Click on the Palettes tab
     */
    async clickOnPalettesTab() {
        try {
            await this.click(await this.palettesTab)
            reporter.addStep("info", 'clicked on the Palettes tab.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the Palettes tab`
            throw err
        }
    }

    /*
     * Click on the videos tab
     */
    async clickOnVideosTab() {
        try {
            await this.click(await this.videoTab)
            reporter.addStep("info", 'clicked on the Videos tab.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the Videos tab`
            throw err
        }
    }

    /*
     * Click on the uplpaded videos tab
     */
    async clickOnUploadedVideo() {
        try {
            await this.click(await this.uploadedVideoTab)
            reporter.addStep("info", 'clicked on the uploaded video tab.')
            await browser.pause(2000)
        } catch (err) {
            err.message = `Error clicking on the uploaded video tab`
            throw err
        }
    }
}
export default new ContentManager