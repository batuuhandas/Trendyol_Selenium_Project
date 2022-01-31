import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By loginButtonLocator=new By.ByCssSelector("div[class='link account-user']");
    By acceptALert=new By.ByCssSelector("div[class='modal-close']");
    By accountButtonLocator=By.xpath("//p[text()='Hesabım']");
    By searchButtonLocator= new By.ByCssSelector("i[class='search-icon']");
    By searchBoxLocator = new By.ByCssSelector("input[class='search-box']");

    public void search(String text)  {
        type(searchBoxLocator,text);
        wait(1000);
        click(searchButtonLocator);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public String getText(By locator){
        return getText(locator);
    }

    public void acceptAlert(){
        if (isDisplayed(acceptALert)) {
            click(acceptALert);
        }
    }
    public String myAccount() {
        wait(2000);
        return find(accountButtonLocator).getText();
    }










}
