import Page from "../../page";

class DesignDrawer extends Page{
   
    constructor(){
        super()
    }

    get designTab(){return $(`(//div[@class='right-drawer-option'])[5]`)}
    get titleTab(){return $(`(//div[contains(@class,'sliding-menu-option')])[3]`)}
    get titleDropDownOptions(){return $(`//div[@class='titles-dropdown-option preview']`)}
    get titleDropDown(){return $(`//div[@class='titles-dropdown-option']//div[@class='card-3']`)}
    get animationDropDown(){return $(`(//span[@class='select-label dropdown'])[1]`)}
    get moveInAnimation(){return $(`//span[text()='Move In']`)}


    async openDesignDrawer() {
        try {
            await this.click(await this.designTab)
        } catch (err) {
            err.message=`Error clicking on Design tab`
            throw err
        }
    }

    async navigateToTileTab() {
        try {
            await this.click(await this.titleTab)
        } catch (err) {
            err.message=`Error clicking on Title tab`
            throw err
        }
    }

    async selectTitleDesign() {
        try {
            await this.click(await this.titleDropDownOptions)
            await this.click(await this.titleDropDown)
            await browser.pause(2000)
        } catch (err) {
            err.message=`Error selecting design title`
            throw err
        }
    }

    async selectAnimationForTitle() {
        try {
            await this.click(await this.animationDropDown)
            await this.click(await this.moveInAnimation)
            await browser.pause(1000)
        } catch (err) {
            err.message=`Error selecting design title`
            throw err
        }
    }



}

export default new DesignDrawer