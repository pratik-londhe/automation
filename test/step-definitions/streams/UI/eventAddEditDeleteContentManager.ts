import { Given, When, Then } from "@cucumber/cucumber";
import reporter from "../../../utils/reporter"
import HomePageUi from "../../../page-objects/streams/UI/homePageUI"
import ContentManager from "../../../page-objects/streams/UI/contentManager";
import ProductManager from "../../../page-objects/streams/UI/productManager";


Given(/Add a Document$/, async function (datatable) {
    reporter.addStep("info", `Adding a Document...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Document Name: ${regInfo[0].DocumentName}`)
    await HomePageUi.clickOnContentTab()
    await ContentManager.clickOnAddContentButton()
    await ContentManager.clickOnDocumentsIcon()
    await ContentManager.uploadDocumentDetails(regInfo[0].DocumentName)
})

Given(/^Delete a Document$/, async function (datatable) {
    reporter.addStep("info", `Deleting the Document...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Document Name: ${regInfo[0].DocumentName}`)
    await ProductManager.searchProduct(regInfo[0].DocumentName)
    await ProductManager.deleteProduct()
})

Given(/^Add a Image$/, async function (datatable) {
    reporter.addStep("info", `Adding the Image...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Image Name: ${regInfo[0].ImageName}`)
    await ContentManager.clickOnAddContentButton()
    await ContentManager.clickOnImagesIcon()
    await ContentManager.uploadImagesDetails(regInfo[0].ImageName)
})

Given(/^Delete a Image$/, async function (datatable) {
    reporter.addStep("info", `Deleting the Image...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Image Name: ${regInfo[0].ImageName}`)
    await browser.refresh()
    await ContentManager.clickOnImagesTab()
    await ProductManager.searchProduct(regInfo[0].ImageName)
    await ProductManager.deleteProduct()
})

Given(/^Add a Video$/, async function (datatable) {
    reporter.addStep("info", `Adding the Video...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Video Name: ${regInfo[0].VideoName}`)
    await ContentManager.clickOnAddContentButton()
    await ContentManager.clickOnVideoIcon()
    await ContentManager.uploadVideoDetails(regInfo[0].VideoName)
})

Given(/^Delete a Video$/, async function (datatable) {
    reporter.addStep("info", `Deleting the Video...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Video Name: ${regInfo[0].VideoName}`)
    await browser.refresh()
    await ContentManager.clickOnVideosTab()
    await ContentManager.clickOnUploadedVideo()
    await ProductManager.searchProduct(regInfo[0].VideoName)
    await ProductManager.deleteProduct()
})

Given(/^Add a Fonts$/, async function (datatable) {
    reporter.addStep("info", `Adding the Fonts...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Fonts Name: ${regInfo[0].FontsName}`)
    await ContentManager.clickOnAddContentButton()
    await ContentManager.clickOnFontsIcon()
    await ContentManager.uploadFontsDetails(regInfo[0].FontsName)
})

Given(/^Delete a Fonts$/, async function (datatable) {
    reporter.addStep("info", `Deleting the Fonts...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Fonts Name: ${regInfo[0].FontsName}`)
    await browser.refresh()
    await ContentManager.clickOnFontsTab()
    await ProductManager.searchProduct(regInfo[0].FontsName)
    await ProductManager.deleteProduct()
})

Given(/Add a palettes$/, async function (datatable) {
    reporter.addStep("info", `Adding the palettes...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first palettes Name: ${regInfo[0].PaletteName}`)
    await ContentManager.clickOnAddContentButton()
    await ContentManager.clickOnPalettesIcon()
    await ContentManager.createColorPalettes(regInfo[0].PaletteName)
})

Given(/^Delete a palettes$/, async function (datatable) {
    reporter.addStep("info", `Deleting the palettes...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first palettes Name: ${regInfo[0].PaletteName}`)
    await browser.refresh()
    await ContentManager.clickOnPalettesTab()
    await ProductManager.searchProduct(regInfo[0].PaletteName)
    await ProductManager.deleteProduct()
})
