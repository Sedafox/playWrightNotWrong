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

    @Before
    public void getPage(){
        this.page = Hook.page;
    }

    @Given("^I navigate to the log in page of Swag Labs$")
    public void iNavigateToTheLogInPageOfSwagLabs() {
        LogInPage logInPage = new LogInPage(page);
        logInPage.navigateToLoginPage();
    }

    @And("I enter {string} into the username field")
    public void iEnterIntoTheUsernameField(String userName) {
        LogInPage logInPage = new LogInPage(page);
        logInPage.inputUserName(userName);
        Assert.assertTrue(logInPage.verifyNameMatchesWhatIsInUsernameInput(userName));
    }

    @And("I enter {string} into the password field")
    public void iEnterIntoThePasswordField(String password){
        LogInPage logInPage = new LogInPage(page);
        logInPage.inputPassword(password);
    }

    @When("I click the LogIn button")
    public void iClickTheLogInButton() {
        LogInPage logInPage = new LogInPage(page);
        logInPage.clickLoginButton();
    }

    @Then("^I observe the Products page$")
    public void iObserveTheProductsPage() {
        ProductPage productPage = new ProductPage(page);
        Assert.assertTrue(productPage.verifyOnProductPage());
    }
}
