import lombok.val;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.KrakowFlatsPage;
import pages.RynekPierwotnyPage;

public class SearchingFlatsTests extends BaseTest {

    @Test(groups = {"functest"})
    public void findFlatsFromYourCity() {
        searchFlats();
    }

    @Test(groups = {"functest"})
    public void findFlatsWithSelectedSizeAndNumberOfRooms(){

        val krakowFlatsPage = searchFlats();

        krakowFlatsPage.waitToPageToLoad();
        krakowFlatsPage.selectFlatType();
        krakowFlatsPage.selectRoomsNumbers();
        krakowFlatsPage.selectFlatSize();
        krakowFlatsPage.selectFlatPrice();
        Assertions.assertThat(krakowFlatsPage.getResultMessage().getText().matches("Znaleziono (\\d+) oferta w (\\d+) inwestycjach"));
    }

    private KrakowFlatsPage searchFlats() {
        val page = new RynekPierwotnyPage(driver);
        page.waitToPageToLoad();
        page.setSearchFieldAndConfirm("Kraków");
        return new KrakowFlatsPage(driver);
    }
}