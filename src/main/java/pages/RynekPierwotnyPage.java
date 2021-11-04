package pages;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class RynekPierwotnyPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div[3]/section/nav/a/img")
    private WebElement logo;

    @Getter
    @FindBy(css = "input[data-testid='search-autocomplete']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@data-testid='search-autocomplete-dropdown']//ul")
    private WebElement searchResults;

    public RynekPierwotnyPage(WebDriver driver) {
        super(driver);

    }

    public void setSearchField(String value) {
        searchField.clear();
        searchField.sendKeys(value);
    }

    public void waitToPageToLoad() {
        await()
                .alias("Page was not loaded")
                .pollDelay(Duration.ofSeconds(10))
                .atMost(Duration.ofSeconds(20))
                .pollInterval(Duration.ofSeconds(10))
                .until(() -> searchField.isDisplayed());
    }

    public void setSearchFieldAndConfirm(String value) {
        setSearchField(value);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(searchResults));
        searchField.sendKeys(Keys.ENTER);

    }
}


