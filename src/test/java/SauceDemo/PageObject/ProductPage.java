package SauceDemo.PageObject;

import SauceDemo.Utilities.PageUtilities;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage extends BasePage {
    Page page;
    Locator shoppingCartButton;
    Locator shoppingCartButtonBadge;
    Locator filterProductsDropdown;
    Locator filterProductsActiveOption;
    Locator firstProduct;

    Locator privacyPolicy;

    public ProductPage(Page page) {
        super(page);
        this.page = page;
        shoppingCartButton = page.locator("//a[@class='shopping_cart_link']");
        shoppingCartButtonBadge = shoppingCartButton.locator(".shopping_cart_badge");
        filterProductsDropdown = page.locator("//span[@class='select_container']");
        filterProductsActiveOption = filterProductsDropdown.locator(".active_option");
        firstProduct = page.locator("//div[@class='inventory_item_description']").first();
        privacyPolicy = page.locator(".footer_copy");
    }

    public Boolean verifyOnProductPage() {
        return page.url().contains("inventory.html");
    }

    public Boolean isShoppingCartButtonVisible() {
        return shoppingCartButton.isVisible();
    }

    public boolean isThisTheActiveFilter(String filterText) {
        return PageUtilities.retryVerificationForSeconds(10, filterProductsActiveOption.textContent().equals(filterText));
    }

    public void clickFilterButton() {
        filterProductsDropdown.click();
    }

    public void selectOptionFromFilterDropdown(String selection) {
        filterProductsDropdown.type(selection);
        filterProductsDropdown.press("Enter");
    }

    public boolean isThisTheFirstProduct(String expectedProduct) {
        return PageUtilities.retryVerificationForSeconds(10, firstProduct.textContent().contains(expectedProduct));
    }

    public void addProductToCart(int itemIndex) {
        page.locator("//button[contains(@id,'add-to-cart')]").nth(itemIndex).click();
    }

    public void addProductToCart(String productName) {
        page.locator("//div[contains(text(),'" + productName + "')]/../../..//div//button[contains(@id,'add-to-cart')]").click();
    }

    public boolean doesTheProductDisplayRemove(int itemIndex) {
        return page.locator("//div[@class='inventory_item_description']").nth(itemIndex).locator("//button").textContent().equals("Remove");
    }

    public boolean doesTheProductDisplayRemove(String productName) {
        return page.locator("//div[contains(text(),'" + productName + "')]/../../..//div//button[text()='Remove']").textContent().equals("Remove");
    }

    public boolean doesTheCartShowTheseManyItems(String numOfItemsExpected) {
        return shoppingCartButtonBadge.textContent().equals(numOfItemsExpected);
    }

    public void clickTheProductRemoveButton(int itemIndex) {
        page.locator("//div[@class='inventory_item_description']").nth(itemIndex).locator("//button[text()='Remove']").click();
    }

    public void clickTheProductRemoveButton(String productName) {
        page.locator("//div[contains(text(),'" + productName + "')]/../../..//div//button[text()='Remove']").click();
    }

    public boolean verifyPrivacyPolicyExistence(){
        return privacyPolicy.isVisible();
    }

    public String getPrivacyPolicyText() {
        return privacyPolicy.textContent();
    }
}
