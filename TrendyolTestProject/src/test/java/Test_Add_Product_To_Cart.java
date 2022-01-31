import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Test_Add_Product_To_Cart extends BaseTest {


    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;

    @Test
    @Order(1)
    public void go_to_login_page() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.acceptAlert();
        homePage.clickLoginButton();
        Assertions.assertTrue(loginPage.isDisplayedLoginButton(),"Error:Your are not on Login Page!");
    }

    @Test
    @Order(2)
    public void login()  {
        loginPage.typeandLoginText("testautomationadress1@gmail.com","test123");
        Assertions.assertEquals("Hesabım",homePage.myAccount(),"Error:Your email or password is not true!");
    }

    @Test
    @Order(3)
    public void  search_a_product() {
        productsPage =new ProductsPage(driver);
        homePage.search("klima");
        Assertions.assertTrue(productsPage.isOnProductPage(),"Error:You are not on product page!");
    }

    @Test
    @Order(4)
    public void select_a_product() {
        productDetailPage=new ProductDetailPage(driver);
        searchPage=new SearchPage(driver);
        searchPage.selectProduct(searchPage.randomProductNumber());
        searchPage.switchwindow(1);
        Assertions.assertTrue(productDetailPage.isProductDetailPage(),"Error:You are not on product detail page!");
    }

    @Test
    @Order(5)
    public void add_product_to_cart(){
        cartPage=new CartPage(driver);
        productDetailPage.addToCart();
        Assertions.assertTrue(productDetailPage.isProductCountUp(),"Error:Porduct was not add to cart!");
    }

    @Test
    @Order(6)
    public void go_to_cart_page(){
        productDetailPage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),"Error:Product price and Cart is not same!");
    }

    @Test
    @Order(7)
    public void add_new_product(){
        cartPage.addNewProduct();
        Assertions.assertTrue(cartPage.isProductCountTwo(),"Error:Your product is still one. ");
    }


    @Test
    @Order(8)
    public void delete_all_product(){
        cartPage.deleteAllProduct();
        cartPage.deleteAlert();
        Assertions.assertTrue(cartPage.isEmpty(),"Error:Your cart is still have product.");
    }



}
