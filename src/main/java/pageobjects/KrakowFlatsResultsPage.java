package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class KrakowFlatsResultsPage extends BasePage{

    private static final By PROPERTY_NAME = By.xpath("//section[4]/div/ul/li/div/div/h2/div");
    private static final By FLAT_READY = By.xpath("//section[4]//div/ul/li[text() = 'Oddanie: ']");
    private static final By FLAT_SIZE = By.xpath("//section[4]//div/ul/li[text() = 'Metraż:']");
    private static final By FLAT_ROOMS = By.xpath("//section[4]//div/ul/li[text() = 'Pokoje:']");

    public KrakowFlatsResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<Kafelka> testKafelkiList() {

        List<Kafelka> kafelkaList = new LinkedList<>();
        List<WebElement> kafelkiWebElementList = driver.findElements(By.xpath("//section[4]/div/ul/li[@class='rp-np9kb1 ejhc5io0']"));
            for (WebElement kafelka : kafelkiWebElementList) {
                String propertyName = kafelka.findElement(PROPERTY_NAME).getText();
                String flatReady = kafelka.findElement(PROPERTY_NAME).getText();
                int flatSize = Integer.parseInt(kafelka.findElement(FLAT_SIZE).getText());
                int flatRooms = Integer.parseInt(kafelka.findElement(FLAT_ROOMS).getText());

                var Kafelka = new Kafelka(propertyName,flatSize,flatRooms);
                kafelkaList.add(Kafelka);

            }
            return kafelkaList;
        }
    }