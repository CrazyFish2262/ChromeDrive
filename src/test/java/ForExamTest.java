import Recall.UserForPet;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ForExamTest {
    WebDriver driver;
    SecureRandom random = new SecureRandom();

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void findMers() throws InterruptedException {
        driver.get("https://www.onliner.by/");
        WebElement autobaraholka = driver.findElement(By.xpath(".//ul[@class='b-main-navigation']/li[3]"));
        autobaraholka.click();
        WebElement dropdown = driver.findElement(By.xpath(".//*[@id=\"container\"]/div/div/div/div/div/div[2]/div/div/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]"));
        dropdown.click();
        Thread.sleep(1000);
        WebElement brand = driver.findElement(By.xpath(".//ul[@class='dropdown-style__list dropdown-style__list_brand']/li[7]"));
        brand.click();
        Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.xpath(".//*[@class='vehicle-form__offers-list']/a"));
        System.out.println("Список ссылок");
        list.forEach(element -> {
            System.out.println(element.getAttribute("href"));
        });
        System.out.println();
        System.out.println("Искомая ссылка: " + list.get(32).getAttribute("href"));

    }


    @Test
    public void first() {
        UserForPet userForPet = new UserForPet(0, "string", "String","String", "String","String","String", 0);
        ValidatableResponse pets = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2/")
                .body(userForPet)
                .post("/user/createWithArray")
                .then()
                .statusCode(200)
                .and()
                .statusLine("OK");

            }





}
