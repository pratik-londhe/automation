import Page from "../../page"
import reporter from "../../../utils/reporter"

class ProductManager extends Page {

    constructor() {
        super()
    }

    // Add Products Details
    get addProductsButton() { return $(`//button[@class='button primary small category-button']`) }
    get productTitleText() { return $(`//input[@placeholder='Enter Product Title']`) }
    get categories() { return $(`//div[@class='tag-select']//input`) }
    get aboutText() { return $(`//textarea[@placeholder='Describe your product']`) }
    get uploadPhoto() { return $(`//input[@type='file']`) }
    get productPrice() { return $(`#product-price`) }
    get productSalePrice() { return $(`#sale-price`) }
    get buyNowURL() { return $(`#product-url`) }
    get buyNowButtonName() { return $(`#link-text`) }
    get addAttributeIcon() { return $(`(//*[name()='svg' and @id='icon-add'])[2]`) }
    get attributeText() { return $(`//input[@placeholder='Enter attribute']`) }
    get attributeValue() { return $(`//input[@placeholder='Attribute value']`) }
    get doneButton() { return $(`//button[@class='primary']`) }
    get editProductIcon() { return $(`//button[@class='no-style edit-icon']`) }
    get searchText() { return $(`//input[@placeholder='Search']`) }
    get deleteCheckBox() { return $(`//div[@class='field-group checkbox']`) }
    get deleteButton() { return $(`//button[text()='Delete']`) }
    get deletePopUpButton() { return $(`(//button[text()='Delete'])[2]`) }
    get productName() { return $(`//p[@class='item-title grid-span']`) }


    /*
     * Click on the Add products button
     */
    async clickOnAddProductsButton() {
        try {
            if (await this.addProductsButton.isDisplayed()) {
                await this.click(await this.addProductsButton)
                reporter.addStep("info", 'Clicked on the Add Products button.')
            }
        } catch (err) {
            err.message = `Error clicking on the Add products button: , ${err.message} `
            throw err
        }
    }

    /*
     * Add product details 
     */
    async addProductsDetails(productTitle: string, catagories: string, aboutText: string, fileName: string, pPrice: string,
        productSalePrice: string, buyNowURL: string, buyNowButtonName: string, attributeName: string, attributeValue: string) {
        try {
            await this.typeInto(await this.productTitleText, productTitle)
            reporter.addStep("info", 'Entered the Products title.')
            await this.typeInto(await this.categories, catagories)
            await (await this.categories).keys('Enter')
            reporter.addStep("info", 'Entered the Products catagories.')
            await this.typeInto(await this.aboutText, aboutText)
            reporter.addStep("info", 'Entered the about product.')
            let path = (`${process.cwd()}/data/fileUpload/streams/${fileName}`)
            await this.uploadPhoto.addValue(path)
            await browser.pause(5000)
            reporter.addStep("info", 'uploaded the image for the product.')
            await this.typeInto(await this.productPrice, pPrice)
            reporter.addStep("info", 'Entered the Products price.')
            await this.typeInto(await this.productSalePrice, productSalePrice)
            reporter.addStep("info", 'Entered the Products sale price.')
            await this.typeInto(await this.buyNowURL, buyNowURL)
            reporter.addStep("info", 'Entered the Products by now URL.')
            await this.typeInto(await this.buyNowButtonName, buyNowButtonName)
            reporter.addStep("info", 'Entered the Products buy now button name.')
            await this.addAttributsDetails(attributeName, attributeValue)
            await this.click(await this.doneButton)
            await browser.pause(2000)
            reporter.addStep("info", 'Clicked on the Done button.')
        } catch (err) {
            err.message = `Error adding the product details: , ${err.message} `
            throw err
        }
    }

    /*
     * Add attributes details 
     */
    private async addAttributsDetails(attributeName: string, attributeValue: string) {
        try {
            await this.click(await this.addAttributeIcon)
            reporter.addStep("info", 'Clicked on the Add Attribute link.')
            await browser.pause(2000)
            await this.typeInto(await this.attributeText, attributeName)
            reporter.addStep("info", 'Entered the Attribute name.')
            await this.typeInto(await this.attributeValue, attributeValue)
            reporter.addStep("info", 'Entered the attribute value.')
        } catch (err) {
            err.message = `Error entering the attribute details: , ${err.message} `
            throw err
        }
    }

    /*
     * Search product
     */
    async searchProduct(productName: string) {
        try {
            await this.typeInto(await this.searchText, productName)
            await browser.pause(2000)
            await (await this.searchText).keys('Enter')
            await browser.pause(2000)
            reporter.addStep("info", `Searched the product:  ${productName}`);
        } catch (err) {
            err.message = `Error searching the product: , ${err.message} `
            throw err
        }
    }

    /*
     * Edit product
     */
    async editProduct(editProductName: string) {
        try {
            await this.click(await this.editProductIcon)
            reporter.addStep("info", `Clicked on the edit product:`);
            await browser.pause(2000)
            await this.productTitleText.clearValue()
            await browser.pause(2000)
            await this.typeInto(await this.productTitleText, editProductName)
            reporter.addStep("info", 'Entered the Products title.')
            await this.click(await this.doneButton)
            await browser.pause(2000)
            reporter.addStep("info", 'Clicked on the Done button.')
            if ((await this.productName.getText()).match(editProductName)) {
                reporter.addStep("info", 'Product name is updated successfully.')
                return true
            }
            return false
        } catch (err) {
            err.message = `Error editing the product.: , ${err.message} `
            throw err
        }
    }

    /*
     * Delete product
     */
    async deleteProduct() {
        try {
            await this.click(await this.deleteCheckBox)
            reporter.addStep("info", `Clicked on the delete checkbox.`);
            await this.click(await this.deleteButton)
            reporter.addStep("info", `Clicked on the delete button.`);
            await browser.pause(2000)
            await this.click(await this.deletePopUpButton)
        } catch (err) {
            err.message = `Error clicking on the delete product: , ${err.message} `
            throw err
        }
    }

    /*
     * Verify the product is deleted
     */
    async verifyDeletedProduct() {
        try {
            if (!await this.productName.isDisplayed()) {
                reporter.addStep("info", 'Product name is updated successfully.')
                return true
            }
        } catch (err) {
            err.message = `Error verifying the deleted product , ${err.message} `
            throw err
        }
    }
}
export default new ProductManager