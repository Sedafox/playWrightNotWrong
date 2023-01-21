package SauceDemo.PageObject;
import com.microsoft.playwright.*;

public class LogInPage {

    Page page;
    Locator logInUsernameField;
    Locator logInPasswordField;
    Locator logInButton;
    public LogInPage(Page page){
        this.page = page;
        logInUsernameField = page.locator("#user-name");
        logInPasswordField = page.locator("#password");
        logInButton = page.locator("#login-button");
    }

    String baseURL = "http://www.saucedemo.com";

    public void navigateToLoginPage(){
        page.navigate(baseURL);
    }

    public void inputUserName(String username){
        logInUsernameField.type(username);
    }

    public boolean verifyNameMatchesWhatIsInUsernameInput(String username){
        return logInUsernameField.getAttribute("value").equals(username);
    }

    public void inputPassword(String password){
        logInPasswordField.type(password);
    }

    public void clickLoginButton(){
        logInButton.click();
    }
}
