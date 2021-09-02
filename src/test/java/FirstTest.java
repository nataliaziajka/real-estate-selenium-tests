import org.testng.annotations.Test;
import pages.RynekPierwotnyPage;

public class FirstTest extends BaseTest {

    @Test
    public void findFlatsFromYourCity() {
        new RynekPierwotnyPage(driver).openRynekPierwotnyPage()
                .clickToSearchField()
                .sendCityToOpen()
                .assertThatSearchPageIsOpen();
    }
}
