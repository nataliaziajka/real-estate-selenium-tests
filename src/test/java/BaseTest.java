import config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        Properties properties = new Properties();
        PropertiesFile.readPropertiesFile();

        driver = new ChromeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterTest
    void finish() {
        driver.quit();
    }
}
