import Recall.Response;
import Recall.UserForPet;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
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

    @Test //задание №8
    public void findMers() throws InterruptedException {
        driver.get("https://www.onliner.by/");
        WebElement autobaraholka = driver.findElement(By.xpath(".//ul[@class='b-main-navigation']/li[3]"));
        autobaraholka.click();
        WebElement dropdown = driver.findElement(By.xpath("(//div[@class=\"vehicle-form__row\"]//div[@class=\"vehicle-form__line vehicle-form__line_condensed-other\"])[4]"));
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
        System.out.println("Искомая ссылка: " + list.get(31).getAttribute("href"));
        driver.get(list.get(31).getAttribute("href"));

    }


    @Test //задание №9
    public void first() {
        UserForPet newUser = new UserForPet(0, "string", "string", "string", "string", "string", "string", 0);
        UserForPet[] userForPet = new UserForPet[1];
        userForPet[0] = newUser;
        Response newRequest = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2/")
                .body(userForPet)
                .post("user/createWithArray")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(Response.class);
        System.out.println(newRequest.toJson());
        Assert.assertEquals(newRequest.message, "ok");

    }


}
