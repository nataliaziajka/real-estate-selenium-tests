import lombok.val;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageobjects.*;

public class SearchingFlatsTests extends BaseTest {

    @Test(groups = {"functest"})
    public void findFlatsFromYourCity() {
        KrakowFlatsPage krakowFlatsPage = selectCity();
    }

    @Test(groups = {"functest"})
    public void findFlatsWithSelectedSizeAndNumberOfRooms(){
        KrakowFlatsPage krakowFlatsPage = selectCity();
        selectFlatType(krakowFlatsPage);
        selectRooms(krakowFlatsPage);
        selectSize(krakowFlatsPage);
        selectPrice(krakowFlatsPage);

        Assertions.assertThat(krakowFlatsPage.getResultMessage().getText().matches("Znaleziono (\\d+) oferta w (\\d+) inwestycjach")).isTrue();
    }

    protected void selectPrice(KrakowFlatsPage krakowFlatsPage) {
        CenaPage cenaPage = new CenaPage(driver);
        krakowFlatsPage.openCenaPage();
        cenaPage.waitToCenaPageToLoad();
        cenaPage.selectFlatPrice();
    }

    protected void selectSize(KrakowFlatsPage krakowFlatsPage) {
        PowierzchniaPage powierzchniaPage = new PowierzchniaPage(driver);
        krakowFlatsPage.openPowierzchniaPage();
        powierzchniaPage.waitToPowierzchniaPageToLoad();
        powierzchniaPage.selectFlatSize();
    }

    protected void selectRooms(KrakowFlatsPage krakowFlatsPage) {
        PokojePage pokojePage = new PokojePage(driver);
        krakowFlatsPage.openPokojePage();
        pokojePage.waitToPokojePageToLoad();
        pokojePage.selectRoomsNumbers();
    }

    protected void selectFlatType(KrakowFlatsPage krakowFlatsPage) {
        NieruchomosciPage nieruchomosciPage = new NieruchomosciPage(driver);
        krakowFlatsPage.openNieruchomosciPage();
        nieruchomosciPage.waitToNieruchomosciPageToLoad();
        nieruchomosciPage.selectNieruchomosciType();
    }

    protected KrakowFlatsPage selectCity() {
        KrakowFlatsPage krakowFlatsPage = new KrakowFlatsPage(driver);
        krakowFlatsPage.waitToKrakowFlatsPageToLoad();
        krakowFlatsPage.searchFlats("Kraków");
        return krakowFlatsPage;
    }

}