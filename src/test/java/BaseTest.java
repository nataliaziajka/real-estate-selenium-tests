import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;
    private final static String ENTRY_URL = "https://rynekpierwotny.pl/";

    @BeforeTest
    void setup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(ENTRY_URL);
    }

    @AfterTest
    void finish() {
        driver.quit();
    }
}
