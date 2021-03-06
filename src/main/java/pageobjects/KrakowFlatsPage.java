package pageobjects;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class KrakowFlatsPage extends BasePage {

    private static final By SEARCH_RESULTS = By.xpath("//div[@data-testid='search-autocomplete-dropdown']//ul");
    private static final String SEARCH_FIELD_LOCATOR = "input[data-testid='search-autocomplete']";


    @FindBy(xpath = "//section[1]//span[text()='Mieszkania, Domy']")
    private WebElement flatTypeMenu;

    @FindBy(xpath = "//section[1]//span[text()='Powierzchnia']")
    private WebElement flatMenu;

    @FindBy(css = "div.rp-14vknz7")
    private WebElement resultMessage;

    @FindBy(xpath = "//section[1]//span[text()='Pokoje']")
    private WebElement roomMenu;

    @FindBy(xpath = "//section[1]//span[text()='Cena']")
    private WebElement priceMenu;

    @FindBy(css = SEARCH_FIELD_LOCATOR)
    private WebElement searchField;

    @FindBy(xpath = "//div[@data-testid='search-autocomplete-dropdown']//ul")
    private WebElement searchResults;

    @FindBy(css = "div.modal-close-button:nth-child(7) > svg")
    private WebElement popup;

    public WebElement getResultMessage() {
        return resultMessage;
    }

    public KrakowFlatsPage(WebDriver driver) {
        super(driver);
    }

    public void waitToKrakowFlatsPageToLoad() {
        await()
                .alias("Page was not loaded")
                .pollDelay(Duration.ofSeconds(2))
                .atMost(Duration.ofSeconds(10))
                .pollInterval(Duration.ofSeconds(1))
                .until(this::isSearchFieldPresent);
    }
    public void waitToPopupToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(popup));
    }

    public boolean isSearchFieldPresent(){
        return CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(SEARCH_FIELD_LOCATOR)));
    }
    public void openNieruchomosciPage(){
        flatTypeMenu.click();
    }
    public void openPokojePage(){
        roomMenu.click();
    }
    public void openPowierzchniaPage() {
        flatMenu.click();
    }
    public void openCenaPage() { priceMenu.click(); }
    public void close_popup() {
        waitToPopupToLoad();
        popup.click(); }
    public void waitForResultsToLoad() {
        await().until(() -> CollectionUtils.isNotEmpty(driver.findElements(SEARCH_RESULTS)));
    }

    public void searchFlats(String cityName) {
        searchField.clear();
        searchField.sendKeys(cityName);
        //new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(searchResults));
        waitForResultsToLoad();
        searchField.sendKeys(Keys.ENTER);

    }
}
