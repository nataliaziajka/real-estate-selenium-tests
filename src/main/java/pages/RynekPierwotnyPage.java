package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class RynekPierwotnyPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div[3]/section/nav/a/img")
    WebElement logo;


    WebElement searchField = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.rp-17061tj.eagykhz0")));

    public RynekPierwotnyPage(WebDriver driver) {
        super(driver);
    }

    public RynekPierwotnyPage sendCityToOpen() {
        searchField.sendKeys("Kraków" + Keys.ENTER);
        return this;
    }

    public void assertThatSearchPageIsOpen() {
        Logger.getLogger("Assert Rynek Pierwotny Page Is Open : ");
        Assertions.assertThat(logo.isDisplayed()).isTrue();
    }

    public RynekPierwotnyPage clickToSearchField() {
        searchField.click();
        return this;
    }

    public RynekPierwotnyPage openRynekPierwotnyPage() {
        driver.get("https://rynekpierwotny.pl/");
        return this;
    }
}


