import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By plusProductLocator=new By.ByCssSelector("button[class='ty-numeric-counter-button']");
    By confirmCartButtonLocator =new By.ByCssSelector("div[class='pb-summary-approve']");
    By cartNumberLocator=new By.ByCssSelector("div[class='basket-item-count-container visible']");
    By deleteButtonLocator=By.xpath("//button/i[@class='i-trash']");
    By productHaveNumberLocator=new By.ByCssSelector("div[class='pb-header']");
    By deleteButtonLocator2=By.xpath("(//button[@class='ty-font-w-semi-bold ty-button ty-bordered ty-transition ty-input-medium ty-notr'])[2]");
    By myCartTextLocator=new By.ByCssSelector("div[class='pb-basket-item-price']");
    By myBasketTextLocator=new By.ByCssSelector("span[class='discount-box-amount']");
    By accountHaveLactor=new By.ByCssSelector("input[class='counter-content']");


    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void addNewProduct() {
        wait(2000);
        click(plusProductLocator);
    }
    public boolean isProductCountTwo() {
        wait(1000);
        return getCartTwo() > 1 ;
    }
    private int getCartTwo(){
        String count = find(accountHaveLactor).getAttribute("value");
        return Integer.parseInt(count);
    }

    public void deleteAllProduct() {
        wait(2000);
        click(deleteButtonLocator);

    }

    public void deleteAlert(){
        wait(2000);
        click(deleteButtonLocator2);
    }

    public boolean isEmpty() {
        return true;
    }

    private int getCartCount(){
        String count =find(cartNumberLocator).getText();
        return Integer.parseInt(count);
    }

   public void getcaryazdır(){
      System.out.println(getCartCount());
   }

    public boolean checkIfProductAdded() {
        wait(1000);
        return isDisplayed(confirmCartButtonLocator);

    }

    public String princeOfBasket() {
        return find(myCartTextLocator).getText();

    }
    public String myBasketChar(){
        return find(myBasketTextLocator).getText();
    }
    public boolean checkedIfPriceIsSame() {
        return princeOfBasket().contains(myBasketChar());
    }


}
