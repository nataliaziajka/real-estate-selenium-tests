package pageobjects;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;
import static org.awaitility.Awaitility.await;

public class NieruchomosciPage extends KrakowFlatsPage{

    private static final By HOME_CHECKBOX = By.xpath("//section[1]//span[text()='Domy']");

    @FindBy(xpath = "//section[1]//span[text()='Mieszkania, Domy']")
    private WebElement flatTypeMenu;

    @FindBy(xpath = "//section[1]//span[text()='Domy']")
    private WebElement homeCheckbox;

    @FindBy(css = "div.rp-1uxkh7x:nth-child(3) > button:nth-child(1)")
    private WebElement confirmButton;

    public NieruchomosciPage(WebDriver driver) {
        super(driver);
    }

    public NieruchomosciPage selectNieruchomosciType() {
        waitForHomeCheckboxToLoad();
        homeCheckbox.click();
        confirmButton.click();
        return this;
    }
    public void waitToNieruchomosciPageToLoad() {
        await()
                .alias("Page was not loaded")
                .pollDelay(Duration.ofSeconds(2))
                .atMost(Duration.ofSeconds(20))
                .pollInterval(Duration.ofSeconds(10))
                .until(() -> flatTypeMenu.isDisplayed());
    }
    public void waitForHomeCheckboxToLoad() {
        await().until(() -> CollectionUtils.isNotEmpty(driver.findElements(HOME_CHECKBOX)));
    }
}
