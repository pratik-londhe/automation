package com.brandlive.qa.automation.events3.pages.admin.landingpagesetting;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Products extends Base {

    private void clickOnProductsTab() {
        String products = "//div[text()='Products']";
        WebElement productsTab = waitForDisplayedAndEnabled(By.xpath(products), "Products Tab");
        if (productsTab.isDisplayed()) {
            productsTab.click();
            log.info("The Products Tab is displayed and clicked.");
        }
    }

    private void clickOnAddProduct() {
        String addProduct = "//div[@class='field-group large-button']//label[text()='Add Product']";
        WebElement addProductButton = waitForDisplayedAndEnabled(By.xpath(addProduct), "Add Product button");
        if (addProductButton.isDisplayed()) {
            javascriptExecutorClick(addProductButton);
            log.info("The Add product button is displayed and clicked.");
        }
    }

    public void selectProduct() {
        clickOnProductsTab();
        clickOnAddProduct();
        String product = "(//div[@class='add-product']//div)[1]";
        WebElement addProduct = waitForDisplayedAndEnabled(By.xpath(product), "Add Product");
        addProduct.click();
        log.info("Selected the Product.");
    }

    public boolean verifyAddedProductsOnAdmin() {
        String product = "//div[@class='product-item-image-container']//img";
        if (elementPresent(By.xpath(product))) {
            log.info("Verified the added product on the admin side.");
            return true;
        }
        return false;
    }
}