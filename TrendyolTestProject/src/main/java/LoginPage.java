import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By emailLocator = By.id("login-email");
    By passwordLocator = By.id("login-password-input");
    By loginButtonLocator= new By.ByCssSelector("button[class='q-primary q-fluid q-button-medium q-button submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeandLoginText(String email, String password) {
        type(emailLocator, email);
        type(passwordLocator, password);
        click(loginButtonLocator);
    }

    public boolean isDisplayedLoginButton() {
        return isDisplayed(loginButtonLocator);
    }



}
