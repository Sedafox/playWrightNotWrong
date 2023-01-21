package stepDefs;

import SauceDemo.PageObject.ProductPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProductStepDefs {

    Page page;
    ProductPage productPage;

    @Before
    public void getPage(){
        this.page = stepDefs.Hook.page;
        productPage = new ProductPage(page);
    }
    @Then("I observe the shopping cart button on the products page")
    public void iObserveTheShoppingCartButtonOnTheProductsPage() {
        Assert.assertTrue(productPage.isShoppingCartButtonVisible());
    }

    @And("I click the hamburger menu on the products page")
    public void iClickTheHamburgerMenuOnTheProductsPage() {
        productPage.clickHamburgerMenuButton();
    }

    @Then("I observe {string}, {string}, {string}, and {string} on the menu")
    public void iObserveALLITEMSABOUTLOUGOUTAndRESETAPPSTATEOnTheMenu(String arg0, String arg1, String arg2,
                                                                      String arg3) {
        String[] itemsToVerify = new String[]{arg0, arg1, arg2, arg3};

        Assert.assertTrue(productPage.areMenuItemsVisibleOnPage(itemsToVerify));

    }

    @Then("I verify the default filter for products is {string}")
    public void iVerifyTheDefaultFilterForProductsIsNameAToZ(String filterText) {
        Assert.assertTrue(productPage.thisIsTheActiveFilter(filterText));
    }
}
