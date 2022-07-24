import Page from "../../page";

class ShotDrawer extends Page {

	constructor(){
        super()
    }

    get shotTab(){return $(`(//div[contains(@class,'right-drawer-option')])[2]`)}
    get titleToggle(){return $(`(//label[@class='switch-container'])[2]`)}


    async openShotDrawer() {
        try {
            await this.click(await this.shotTab)
            await browser.pause(1000)
        } catch (err) {
            err.message=`Error when Opening shot drawer`
            throw err
        }
    }

    async turnOnTitleToggle(){
        try{
            await this.click(await this.titleToggle)
            await browser.pause(1000)
        } catch (err) {
            err.message=`Error when Opening shot drawer`
            throw err
        }
    }
}

    export default new ShotDrawer