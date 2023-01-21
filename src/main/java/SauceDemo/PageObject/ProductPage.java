package SauceDemo.PageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
    Page page;
    public ProductPage(Page page){
        this.page = page;
    }

    public Boolean verifyOnProductPage(){
        return page.url().contains("inventory.html");
    }

}
