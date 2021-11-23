package pages;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class CenaPage extends BasePage{

    private static final By PRICE_FROM = By.xpath("//input[@data-testid='input-price__lower']");

    @FindBy(xpath = "//input[@data-testid='input-price__lower']")
    private WebElement price_From;

    @FindBy(xpath = "//input[@data-testid='input-price__upper']")
    private WebElement price_To;

    @FindBy(css = "div.rp-1uxkh7x:nth-child(2) > button:nth-child(1)")
    private WebElement confirmButton;

    public CenaPage(WebDriver driver) {
        super(driver);
    }

    public CenaPage selectFlatPrice() {
        waitForPriceFromToLoad();
        price_From.click();
        price_From.sendKeys("500000");
        price_To.click();
        price_To.sendKeys("600000");
        confirmButton.click();
        return this;
    }

    public void waitToCenaPageToLoad() {
        await()
                .alias("Page was not loaded")
                .pollDelay(Duration.ofSeconds(10))
                .atMost(Duration.ofSeconds(20))
                .pollInterval(Duration.ofSeconds(10))
                .until(() -> price_From.isDisplayed());
    }
    public void waitForPriceFromToLoad() {
        await().until(() -> CollectionUtils.isNotEmpty(driver.findElements(PRICE_FROM)));
    }
}
