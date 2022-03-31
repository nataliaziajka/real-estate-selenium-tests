package pageobjects;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class PowierzchniaPage extends BasePage {

    private static final By SIZE_FROM = By.xpath("//input[@data-testid='input-area__lower']");

    @FindBy(xpath = "//input[@data-testid='input-area__lower']")
    private WebElement size_From;

    @FindBy(xpath = "//input[@data-testid='input-area__upper']")
    private WebElement size_To;

    @FindBy(xpath = "//section[1]//span[text()='Powierzchnia']")
    private WebElement flatMenu;

    @FindBy(css = "div.rp-1uxkh7x:nth-child(2) > button:nth-child(1)")
    private WebElement confirmButton;

    public PowierzchniaPage(WebDriver driver) {
        super(driver);
    }
    public PowierzchniaPage  selectFlatSize() {
        waitForSizeFormToLoad();
        size_From.click();
        size_From.sendKeys("50");
        size_To.click();
        size_To.sendKeys("60");
        confirmButton.click();
        return this;
    }

    public void waitToPowierzchniaPageToLoad() {
        await()
                .alias("Page was not loaded")
                .pollDelay(Duration.ofSeconds(2))
                .atMost(Duration.ofSeconds(20))
                .pollInterval(Duration.ofSeconds(10))
                .until(() -> flatMenu.isDisplayed());
    }
    public void waitForSizeFormToLoad() {
        await().until(() -> CollectionUtils.isNotEmpty(driver.findElements(SIZE_FROM)));
    }

    }
