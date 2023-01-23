package SauceDemo.PageObject;
import com.microsoft.playwright.*;

public class LogInPage extends BasePage {

    Page page;
    Locator logInUsernameField;
    Locator logInPasswordField;
    Locator logInButton;
    Locator incorrectUsernameIcon;
    Locator swagLabsLogo;
    public LogInPage(Page page){
        super(page);
        this.page = page;
        logInUsernameField = page.locator("#user-name");
        logInPasswordField = page.locator("#password");
        logInButton = page.locator("#login-button");
        incorrectUsernameIcon = page.locator("//input[@data-test='username']/..//*[contains(@class,'svg')]");
        swagLabsLogo = page.locator(".login_logo");
    }

    String baseURL = "http://www.saucedemo.com";
    public String standardUser = "standard_user";
    public String standardUserPassword = "secret_sauce";

    public void navigateToLoginPage(){
        page.navigate(baseURL);
    }

    public void inputUserName(String username){
        logInUsernameField.type(username);
    }

    public void inputPassword(String password){
        logInPasswordField.type(password);
    }

    public void clickLoginButton(){
        logInButton.click();
    }

    public boolean nameMatchesWhatIsInUsernameInput(String username) {
        return logInUsernameField.getAttribute("value").equals(username);
    }

    public boolean textExistsOnLoginPage(String text) {
        return page.getByText(text).isVisible();
    }

    public boolean X_IconExistsInUsernameField(){
        return incorrectUsernameIcon.isVisible();
    }

    public boolean isSwagLabsLogoVisible(){
        return swagLabsLogo.isVisible();
    }
}
