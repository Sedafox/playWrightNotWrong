package stepDefs;

import SauceDemo.PageObject.LogInPage;
import SauceDemo.PageObject.ProductPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogInStepDefs {

    Page page;
    LogInPage logInPage;
    ProductPage productPage;

    @Before
    public void getPage(){
        this.page = stepDefs.Hook.page;
        this.logInPage = new LogInPage(page);
        productPage = new ProductPage(page);
    }

    @Given("^I navigate to the log in page of Swag Labs$")
    public void iNavigateToTheLogInPageOfSwagLabs() {
        logInPage.navigateToLoginPage();
    }

    @And("I enter {string} into the username field")
    public void iEnterIntoTheUsernameField(String userName) {
        logInPage.inputUserName(userName);
        Assert.assertTrue(logInPage.nameMatchesWhatIsInUsernameInput(userName));
    }

    @And("I enter {string} into the password field")
    public void iEnterIntoThePasswordField(String password){
        logInPage.inputPassword(password);
    }

    @When("I click the LogIn button")
    public void iClickTheLogInButton() {
        logInPage.clickLoginButton();
    }

    @Then("^I observe the Products page$")
    public void iObserveTheProductsPage() {
        Assert.assertTrue(productPage.verifyOnProductPage());
    }

    @Then("the text {string} is not displayed on the log in page")
    public void theTextSandwichIsNotDisplayedOnTheLogInPage(String text) {
        Assert.assertFalse(logInPage.textExistsOnLoginPage(text));
    }

    @Then("I observe the text {string} on the log in page")
    public void iObserveTheTextEpicSadfaceUsernameAndPasswordDoNotMatchAnyUserInThisServiceOnTheLogInPage(String text) {
        Assert.assertTrue(logInPage.textExistsOnLoginPage(text));
    }

    @Then("I see an x icon in the username field to indicate my username is incorrect")
    public void iSeeAnXIconInTheUsernameFieldToIndicateMyUsernameIsIncorrect() {
        Assert.assertTrue(logInPage.X_IconExistsInUsernameField());
    }

    @Then("I observe the Swag Labs logo")
    public void iObserveTheSwagLabsLogo() {
        Assert.assertTrue(logInPage.isSwagLabsLogoVisible());
    }
}
