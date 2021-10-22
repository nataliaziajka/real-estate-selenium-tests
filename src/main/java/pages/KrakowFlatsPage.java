package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class KrakowFlatsPage extends BasePage {

    @FindBy(xpath = "//section[1]//span[text()='Mieszkania, Domy']")
    private WebElement flatTypeMenu;

    @FindBy(xpath = "//section[1]//span[text()='Domy']")
    private WebElement homeCheckbox;

    @FindBy(css = "div.rp-1uxkh7x:nth-child(3) > button:nth-child(1)")
    private WebElement confirmButton;

    @FindBy(xpath = "//section[1]//span[text()='Pokoje']")
    private WebElement roomMenu;

    @FindBy(xpath = "//section[1]//div/span/span[text()='3']")
    private WebElement roomNumber;

    @FindBy(xpath = "//section[1]//span[text()='Powierzchnia']")
    private WebElement flatMenu;

    @FindBy(xpath = "//input[@data-testid='input-area__lower']")
    private WebElement size_From;

    @FindBy(xpath = "//input[@data-testid='input-area__upper']")
    private WebElement size_To;

    @FindBy(xpath = "//section[1]//span[text()='Cena']")
    private WebElement priceMenu;

    @FindBy(xpath = "//input[@data-testid='input-price__lower']")
    private WebElement price_From;

    @FindBy(xpath = "//input[@data-testid='input-price__upper']")
    private WebElement price_To;

    public KrakowFlatsPage(WebDriver driver) {
        super(driver);
    }


    public KrakowFlatsPage selectFlatType() {
        flatTypeMenu.click();
        homeCheckbox.click();
        confirmButton.click();
        return this;
    }

    public KrakowFlatsPage selectRoomsNumbers() {
        roomMenu.click();
        roomNumber.click();
        confirmButton.click();
        return this;
    }

    public KrakowFlatsPage selectFlatSize() {
        flatMenu.click();
        size_From.click();
        size_From.sendKeys("50");
        size_To.click();
        size_To.sendKeys("60");
       return this;
    }

    public KrakowFlatsPage selectFlatPrice() {
        priceMenu.click();
        price_From.click();
        price_From.sendKeys("50");
        price_To.click();
        price_To.sendKeys("60");
        return this;
    }
    public void waitToPageToLoad() {
        await()
                .alias("Page was not loaded")
                .pollDelay(Duration.ofSeconds(10))
                .atMost(Duration.ofSeconds(20))
                .pollInterval(Duration.ofSeconds(10))
                .until(() -> flatTypeMenu.isDisplayed());
    }

}
