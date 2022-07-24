import { Given, When, Then } from "@cucumber/cucumber";
import chai from "chai";
import reporter from "../../../utils/reporter"
import designDrawer from "../../../page-objects/greenroom/UI/designDrawer";

Given (/^Navigate to Tiltes Tab$/, async function(){
    reporter.addStep("info", `Navigating to titles tab...`)
    await designDrawer.navigateToTileTab()
})

Given (/^Add title design and animation for the shot$/, async function(){
    reporter.addStep("info", `Adding animation and design settings...`)
    await designDrawer.selectTitleDesign()
    await designDrawer.selectAnimationForTitle()
})