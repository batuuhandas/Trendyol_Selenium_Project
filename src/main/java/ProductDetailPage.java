import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By addToCartButtonLocator =new By.ByCssSelector("button[class='add-to-basket']");
    By cartCountainerLocator=new By.ByCssSelector("a[class='link account-basket']");
    By cartCountLocator=new By.ByCssSelector("div[class='basket-item-count-container visible']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDetailPage() {
        wait(2000);
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public void goToCart() {
        wait(2000);
        click(cartCountainerLocator);
    }

   public boolean isProductCountUp() {
       wait(1000);
       return getCartCount() > 0 ;
   }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
}
