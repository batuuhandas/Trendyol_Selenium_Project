import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(TestResultLogger.class)
public class BaseTest {
    WebDriver driver;

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://trendyol.com/");
        driver.manage().window().maximize();

    }
   /* @AfterAll
    public void quit(){
        driver.quit();
    }*/

}
