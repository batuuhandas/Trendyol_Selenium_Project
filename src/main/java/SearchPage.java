import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage {
    Random random;

    By productNameLocator=new By.ByCssSelector("span[class='prdct-desc-cntnr-name hasRatings']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct(int randomProductNumber) {
        wait(2000);
        getAllProducts().get(randomProductNumber).click();
    }

    public int randomProductNumber(){
        random=new Random();
        return random.nextInt(getAllProducts().size()+1);
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public void switchwindow(int i) {
        List<String> tabs =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i));
    }
}
