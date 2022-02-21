package pageobjects;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;
import static org.awaitility.Awaitility.await;

public class PokojePage extends KrakowFlatsPage{

    private static final By ROOM_NUMBER = By.xpath("//section[1]//div/span/span[text()='3']");

    @FindBy(xpath = "//section[1]//span[text()='Pokoje']")
    private WebElement roomMenu;

    @FindBy(xpath = "//section[1]//div/span/span[text()='3']")
    private WebElement roomNumber;

    @FindBy(css = "div.rp-1uxkh7x:nth-child(3) > button:nth-child(1)")
    private WebElement confirmButton;

    public PokojePage(WebDriver driver) {
        super(driver);
    }

    public KrakowFlatsPage selectRoomsNumbers() {
        waitForRoomNumberToLoad();
        roomNumber.click();
        confirmButton.click();
        return this;
    }

    public void waitToPokojePageToLoad() {
        await()
                .alias("Page was not loaded")
               // .pollDelay(Duration.ofSeconds(10))
                .atMost(Duration.ofSeconds(20))
                .pollInterval(Duration.ofSeconds(10))
                .until(() -> roomMenu.isDisplayed());
    }
    public void waitForRoomNumberToLoad() {
        await().until(() -> CollectionUtils.isNotEmpty(driver.findElements(ROOM_NUMBER)));
    }
}
