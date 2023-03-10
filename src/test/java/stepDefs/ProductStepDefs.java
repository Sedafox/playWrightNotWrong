package stepDefs;

import SauceDemo.PageObject.ProductPage;
import SauceDemo.Utilities.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.time.Year;

public class ProductStepDefs extends PageManager {

    ProductPage productPage;

    public ProductStepDefs() {
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
        Assert.assertTrue(productPage.isThisTheActiveFilter(filterText));
    }

    @And("I click the filter product button")
    public void iClickTheFilterProductButton() {
        productPage.clickFilterButton();
    }

    @Then("I select {string} from the filter selection dropdown")
    public void iSelect(String selection) {
        productPage.selectOptionFromFilterDropdown(selection);
    }

    @Then("I verify the current filter for products is displayed as {string}")
    public void iVerifyTheCurrentFilterForProductsIsDisplayedAs(String expectedSelection) {
        Assert.assertTrue(productPage.isThisTheActiveFilter(expectedSelection));
    }

    @Then("I verify the first product on the page is {string}")
    public void iVerifyTheFirstProductOnThePageIsSauceLabsBackpack(String expectedFirstProduct) {
        Assert.assertTrue(productPage.isThisTheFirstProduct(expectedFirstProduct));
    }

    @And("I click add to cart on product number {int}")
    public void iClickAddToCartOnProductNumber(int itemIndex) {
        productPage.addProductToCart(itemIndex - 1);
    }

    @Then("the button on product number {int} now displays Remove")
    public void theButtonOnProductNumberNowDisplaysRemove(int itemIndex) {
        Assert.assertTrue(productPage.doesTheProductDisplayRemove(itemIndex - 1));
    }

    @And("I add {string} to the cart")
    public void iAddSauceLabsBoltTShirtToTheCart(String productName) {
        productPage.addProductToCart(productName);
    }

    @Then("the shopping cart displays a {string} badge")
    public void theShoppingCartDisplaysABadge(String badgeNumber) {
        Assert.assertTrue(productPage.doesTheCartShowTheseManyItems(badgeNumber));
    }

    @And("I remove {string} from the cart")
    public void iRemoveSauceLabsBackpackFromTheCart(String productName) {
        productPage.clickTheProductRemoveButton(productName);
    }

    @And("I remove product number {int} from the cart")
    public void iRemoveProductNumberFromTheCart(int itemIndex) {
        productPage.clickTheProductRemoveButton(itemIndex - 1);
    }

    @Then("Privacy Policy can be seen on the Products Page")
    public void privacyPolicyCanBeSeenOnTheProductsPage() {
        Assert.assertTrue(productPage.verifyPrivacyPolicyExistence());
    }

    @And("the Privacy Policy displays the following text on the Product Page: {string}")
    public void thePrivacyPolicyDisplaysTheFollowingTextOnTheProductPageSauceLabsAllRightsReservedTermsOfServicePrivacyPolicy(String privacyPolicyText) {
        Assert.assertTrue(productPage.getPrivacyPolicyText().contains(privacyPolicyText));
        Assert.assertTrue(productPage.getPrivacyPolicyText().contains(String.valueOf(Year.now().getValue()))); //Ensure the current year is displayed
    }
}
