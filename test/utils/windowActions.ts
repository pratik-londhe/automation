import reporter from "./reporter"

class WindowActions {

    constructor() {

    }

    async switchToNextWindow(winNumber: number) {
        reporter.addStep("info", "Switching to the new window.")
        let handles = await browser.getWindowHandles()
        console.log(`Multiple windows ID's: ${handles}`)
        await browser.switchToWindow(handles[winNumber])
    }

}
export default new WindowActions