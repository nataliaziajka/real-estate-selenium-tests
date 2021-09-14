import lombok.val;

import org.testng.annotations.Test;
import pages.RynekPierwotnyPage;

public class FirstTest extends BaseTest {

    @Test(groups = {"functest"})
    public void findFlatsFromYourCity() {
        val page = new RynekPierwotnyPage(driver);
        page.waitToPageToLoad();
        page.setSearchFieldAndConfirm("Kraków");
        //Assertions.assertThat(page.getSearchField().getAttribute("value")).isEqualTo("Kraków");
    }
}
