import Page from "../../page"
import reporter from "../../../utils/reporter"

class AvatarDetailsLive extends Page {

    constructor() {
        super()
    }

    // Live registration Avatar details
    get uploadAvatar() { return $(`//input[@type='file']`) }
    get nextButton() { return $(`(//button[@type='submit'])[6]`) }

    /*
        * Upload Avatar on the registrtaion page
        */

    async uploadAvatarDetails(fileName: string) {
        let path = (`${process.cwd()}/data/fileUpload/streams/${fileName}`)
        try {
            await (await this.uploadAvatar).addValue(path)
            reporter.addStep("info", 'Uploaded the file.')
            await browser.pause(5000)
            await this.click(await this.nextButton)
            await browser.pause(3000)
        } catch (err) {
            err.message = `Error when uploading Image file`
            throw err
        }
    }
}
export default new AvatarDetailsLive