package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class KrakowFlatsResultsPage extends BasePage{

    private static final By PROPERTY_NAME = By.xpath("//section[4]/div/ul/li[1]/div/div/h2/div");
    private static final By FLAT_READY = By.xpath(".//div/ul/li[text() = 'Oddanie: ']");
    private static final By FLAT_SIZE = By.xpath(".//div/ul/li[text() = 'Metraż:']");
    private static final By FLAT_ROOMS = By.xpath(".//div/ul/li[text() = 'Pokoje:']");

    public KrakowFlatsResultsPage(WebDriver driver) {
        super(driver);
    }


    public List<Kafelka> getKafelki() {
        int elementsListCount = driver.findElements(By.xpath("//div[1]/main/article/section[4]/div/ul/li")).size();
        List<Kafelka> kalefkaList = new LinkedList<>();
        for(int i=1; i<elementsListCount;i++){
        Kafelka kafelka = getKafelka(i);
        System.out.println(kafelka);
        kalefkaList.add(kafelka);
    }
        return kalefkaList;
    }

    public Kafelka getKafelka(int index) {
         String xpath = "(//div[1]/main/article/section[4]/div/ul/li)["+index+"]";
         WebElement kafelka = driver.findElement(By.xpath(xpath));
         String name = getPropertyName(kafelka);
         String flatReady = getFlatReady(kafelka);
         String flatSize = getFlatSize(kafelka);
         String flatRooms = getFlatRooms(kafelka);
        return Kafelka.builder()
                .propertyName(name)
                .flatReady(flatReady)
                .flatSize(flatSize)
                .flatRooms(flatRooms)
                .build();
    }
    public String getPropertyName(WebElement kafelka ){

        return kafelka.findElement(PROPERTY_NAME).getText();
    }
    public String getFlatReady(WebElement kafelka){
        return kafelka.findElement(FLAT_READY).getText();
    }
    public String getFlatSize(WebElement kafelka){

        return kafelka.findElement(FLAT_SIZE).getText();
    }
    public String getFlatRooms(WebElement kafelka){

        return kafelka.findElement(FLAT_ROOMS).getText();
    }


}