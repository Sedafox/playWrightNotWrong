package SauceDemo.PageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage extends BasePage {
    Page page;
    Locator shoppingCartButton;
    Locator filterProductsDropdown;
    Locator filterProductsActiveOption;
    Locator firstProduct;
    public ProductPage(Page page){
        super(page);
        this.page = page;
        shoppingCartButton = page.locator("//a[@class='shopping_cart_link']");
        filterProductsDropdown = page.locator("//span[@class='select_container']");
        filterProductsActiveOption = filterProductsDropdown.locator(".active_option");
        firstProduct = page.locator("//div[@class='inventory_item_description']").first();
    }

    public Boolean verifyOnProductPage(){
        return page.url().contains("inventory.html");
    }

    public Boolean isShoppingCartButtonVisible(){
        return shoppingCartButton.isVisible();
    }

    public boolean thisIsTheActiveFilter(String filterText){
        return filterProductsActiveOption.textContent().equals(filterText);
    }

    public void clickFilterButton(){
        filterProductsDropdown.click();
    }

    public void selectOptionFromFilterDropdown(String selection){
        filterProductsDropdown.type(selection);
        filterProductsDropdown.press("Enter");
    }

    public boolean isThisTheFirstProduct(String expectedProduct){
        return firstProduct.textContent().contains(expectedProduct);
    }

}
