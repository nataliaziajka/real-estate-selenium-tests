
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.KrakowFlatsResultsPage;

public class KafelkiTest extends BaseTest {

    private WebDriver driver;

    @Test(groups = {"functest"})
    public void checkKafelki(){

        driver.get("https://rynekpierwotny.pl/s/nowe-mieszkania-i-domy-krakowski/");
        KrakowFlatsResultsPage krakowFlatsResultsPage = new KrakowFlatsResultsPage(driver);
        krakowFlatsResultsPage.testKafelkiList();



        }

    }
