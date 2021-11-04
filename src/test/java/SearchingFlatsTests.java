import lombok.val;

import org.testng.annotations.Test;
import pages.KrakowFlatsPage;
import pages.RynekPierwotnyPage;

public class SearchingFlatsTests extends BaseTest {

    @Test(groups = {"functest"})
    public void findFlatsFromYourCity() {
        searchFlats();
        //Assertions.assertThat(page.getSearchField().getAttribute("value")).isEqualTo("Krakow");
    }

    @Test(groups = {"functest"})
    public void findFlatsWithSelectedSizeAndNumberOfRooms(){

        val krakowFlatsPage = searchFlats();

        krakowFlatsPage.waitToPageToLoad();
        krakowFlatsPage.selectFlatType();
        krakowFlatsPage.selectRoomsNumbers();
        krakowFlatsPage.selectFlatSize();
        krakowFlatsPage.selectFlatPrice();
        //Assertions...
    }

    private KrakowFlatsPage searchFlats() {
        val page = new RynekPierwotnyPage(driver);
        page.waitToPageToLoad();
        page.setSearchFieldAndConfirm("Kraków");
        return new KrakowFlatsPage(driver);
    }
}