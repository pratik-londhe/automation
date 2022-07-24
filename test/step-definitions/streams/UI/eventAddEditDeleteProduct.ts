import { Given, When, Then } from "@cucumber/cucumber";
import reporter from "../../../utils/reporter"
import HomePageUi from "../../../page-objects/streams/UI/homePageUI"
import ProductManager from "../../../page-objects/streams/UI/productManager";


Given(/Add a Product$/, async function (datatable) {
    reporter.addStep("info", `Creating a Product..`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first First Product Title: ${regInfo[0].ProductTitle}`)
    console.log(`Datatable first Catagories: ${regInfo[0].Catagories}`)
    console.log(`Datatable first About Text: ${regInfo[0].AboutText}`)
    console.log(`Datatable first File Name: ${regInfo[0].FileName}`)
    console.log(`Datatable first Product Price: ${regInfo[0].ProductPrice}`)
    console.log(`Datatable first First Product Sale price: ${regInfo[0].ProductSalePrice}`)
    console.log(`Datatable first First Buy Now URL: ${regInfo[0].BuyNowURL}`)
    console.log(`Datatable first First Buy Now Button Name: ${regInfo[0].BuyNowButtonName}`)
    console.log(`Datatable first First Attribute Name: ${regInfo[0].AttributeName}`)
    console.log(`Datatable first First Attribute Value: ${regInfo[0].AttributeValue}`)

    await HomePageUi.clickOnProductsTab()
    await browser.pause(3000)
    await ProductManager.clickOnAddProductsButton()
    await ProductManager.addProductsDetails(regInfo[0].ProductTitle, regInfo[0].Catagories, regInfo[0].AboutText, regInfo[0].FileName, regInfo[0].ProductPrice, regInfo[0].ProductSalePrice,
        regInfo[0].BuyNowURL, regInfo[0].BuyNowButtonName, regInfo[0].AttributeName, regInfo[0].AttributeValue)
    reporter.addStep("info", "Product created successfylly...")
})

Given(/^Edit a Product$/, async function (datatable) {
    reporter.addStep("info", `Search the product...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first Product Title: ${regInfo[0].ProductTitle}`)
    console.log(`Datatable first Edit Product Name: ${regInfo[0].EditProductName}`)
    await ProductManager.searchProduct(regInfo[0].ProductTitle)
    await ProductManager.editProduct(regInfo[0].EditProductName)
})

Given(/^Delete a Product$/, async function (datatable) {
    reporter.addStep("info", `Deleting the product...`)
    let regInfo = datatable.hashes()
    console.log(`Datatable first New Product Title: ${regInfo[0].EditProductName}`)
    await ProductManager.deleteProduct()
    await ProductManager.searchProduct(regInfo[0].EditProductName)
    await ProductManager.verifyDeletedProduct()
})