import lombok.val;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageobjects.*;

public class SearchingFlatsTests extends BaseTest {

    @Test(groups = {"functest"})
    public void findFlatsFromYourCity() {
        val krakowFlatsPage = new KrakowFlatsPage(driver);
        krakowFlatsPage.waitToKrakowFlatsPageToLoad();
        krakowFlatsPage.searchFlats("Kraków");
    }

    @Test(groups = {"functest"})
    public void findFlatsWithSelectedSizeAndNumberOfRooms(){
        KrakowFlatsPage krakowFlatsPage = new KrakowFlatsPage(driver);
        krakowFlatsPage.waitToKrakowFlatsPageToLoad();
        krakowFlatsPage.searchFlats("Kraków");

        NieruchomosciPage nieruchomosciPage = new NieruchomosciPage(driver);
        krakowFlatsPage.openNieruchomosciPage();
        nieruchomosciPage.waitToNieruchomosciPageToLoad();
        nieruchomosciPage.selectNieruchomosciType();

        PokojePage pokojePage = new PokojePage(driver);
        krakowFlatsPage.openPokojePage();
        pokojePage.waitToPokojePageToLoad();
        pokojePage.selectRoomsNumbers();

        PowierzchniaPage powierzchniaPage = new PowierzchniaPage(driver);
        krakowFlatsPage.openPowierzchniaPage();
        powierzchniaPage.waitToPowierzchniaPageToLoad();
        powierzchniaPage.selectFlatSize();

        CenaPage cenaPage = new CenaPage(driver);
        krakowFlatsPage.openCenaPage();
        cenaPage.waitToCenaPageToLoad();
        cenaPage.selectFlatPrice();

        Assertions.assertThat(krakowFlatsPage.getResultMessage().getText().matches("Znaleziono (\\d+) oferta w (\\d+) inwestycjach"));
    }

}