import lombok.val;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KrakowFlatsPage;
import pages.RynekPierwotnyPage;

public class SearchingFlatsTests extends BaseTest {

    @Test(groups = {"functest"})
    public void findFlatsFromYourCity() {
        val page = new RynekPierwotnyPage(driver);
        page.waitToPageToLoad();
        page.setSearchFieldAndConfirm("Kraków");
        //Assertions.assertThat(page.getSearchField().getAttribute("value")).isEqualTo("Kraków");
    }
    @Test(groups = {"functest"})
    public void findFlatsWithSelectedSizeAndNumberOfRooms(){
        val page = new KrakowFlatsPage(driver);
        driver.get("https://rynekpierwotny.pl/s/nowe-mieszkania-i-domy-krakowski/");
        page.waitToPageToLoad();
        page.selectFlatType();
        page.selectRoomsNumbers();
        page.selectFlatSize();
        page.selectFlatPrice();
        //Assertions...
    }
}