import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;

    @BeforeTest
    void setup() {

       prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterTest
    void finish() {
        driver.quit();
    }
}
