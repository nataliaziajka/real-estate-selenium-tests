import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.KrakowFlatsResultsPage;

public class KafelkiTest extends KrakowFlatsResultsPage {

    private WebDriver driver;

    @Test(groups = {"functest"})
    public void checkKafelki(){

        driver.get("https://rynekpierwotny.pl/s/nowe-mieszkania-i-domy-krakowski/");
        testKafelkiList();
        //Assertions.assertThat();

//        List<KafelkaData> kafelki =  KafelkaData.getKafelkiList();
//        return kafelki.forEach(kafelka -> {
//            System.out.println(KafelkaData.getPropertyName());
//            System.out.println(KafelkaData.getFlatSize());
//            System.out.println(KafelkaData.getFlatRooms());

        }

    }
