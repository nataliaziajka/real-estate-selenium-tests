
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageobjects.Kafelka;
import pageobjects.KrakowFlatsPage;
import pageobjects.KrakowFlatsResultsPage;

public class KafelkiTest extends SearchingFlatsTests{

    @Test(groups = {"functest"})
    public void checkKafelki(){

        selectCity();
        KrakowFlatsPage krakowFlatsPage = selectCity();
        selectFlatType(krakowFlatsPage);
        selectRooms(krakowFlatsPage);
        selectSize(krakowFlatsPage);
        selectPrice(krakowFlatsPage);
        KrakowFlatsResultsPage krakowFlatsResultsPage = new KrakowFlatsResultsPage(driver);
        Kafelka pierwsza = krakowFlatsResultsPage.getKafelka(1);
        Assertions.assertThat(pierwsza.getPropertyName()).isEqualTo("Dzień dobry na Heltmana");

    }
    }


