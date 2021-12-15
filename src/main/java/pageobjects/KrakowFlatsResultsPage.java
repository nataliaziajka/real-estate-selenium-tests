package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class KrakowFlatsResultsPage<i> {

    private WebDriver driver;
    private static final By PROPERTY_NAME = By.xpath("//section[4]/div/ul/li/div/div/h2/div");
    //private static final By FLAT_READY = By.xpath("//section[4]//div/ul/li[text() = 'Oddanie: ']");
    private static final By FLAT_SIZE = By.xpath("//section[4]//div/ul/li[text() = 'Metraż:']");
    private static final By FLAT_ROOMS = By.xpath("//section[4]//div/ul/li[text() = 'Pokoje:']");

    public void testKafelkiList() {
        int ilength = driver.findElements(By.xpath("//section[4]/div/ul/li[@class='rp-np9kb1 ejhc5io0']")).size();

        for (int i = 0; i < ilength; i++) {
            List<WebElement> kafelkiList = driver.findElements(By.xpath("//section[4]/div/ul/li[@class='rp-np9kb1 ejhc5io0']"));
            for (WebElement kafelka : kafelkiList) {
                String propertyName = kafelka.findElement(PROPERTY_NAME).getText();
                int flatSize = Integer.parseInt(kafelka.findElement(FLAT_SIZE).getText());
                int flatRooms = Integer.parseInt(kafelka.findElement(FLAT_ROOMS).getText());

                //var KafelkaData = new KafelkaData(propertyName,flatSize,flatRooms);
                kafelkiList.add(kafelka);
            }

        }
    }}