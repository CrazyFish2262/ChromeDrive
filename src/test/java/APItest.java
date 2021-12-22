import Postman.Users.TheRoot;
import Postman.Users.Users;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APItest {
    WebDriver driver;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

 /*   @Test
    public void first() {
        Pets[] pets = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2/")
                .when()
                .get("pet/findByStatus?status=sold")
                .body()
                .as(Pets[].class);

        for (int i = 0; i < pets.length; i++) {
            System.out.println(pets[i].toJson());
        }

    }


    @Test
    public void postPetRequest() {

        Pets pet = new Pets(0l, new Category(12L, "sdf"), "Tom", new ArrayList<String>(), new ArrayList<Tag>(), "sold");

        Pets newPet = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2/")
                .body(pet)
                .when()
                .post("/pet")
                .body()
                .as(Pets.class);

        System.out.println(newPet.name);


    }*/

    @Test
    public void getAvatar() throws InterruptedException {
        TheRoot root = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users?page=2")
                .body()
                .as(TheRoot.class);
        List<Users> avatarList = root.data;
        System.out.println("Ссылки на аватары: ");
        for (int i = 0; i < avatarList.size(); i++) {
            System.out.println(avatarList.get(i).first_name + " " + avatarList.get(i).last_name);
            System.out.println(avatarList.get(i).avatar);
            driver.get(avatarList.get(i).avatar);
            Thread.sleep(1500);
            WebElement avatar = driver.findElement(By.xpath("/html/body/img"));
            Assert.assertTrue(avatar.isDisplayed());
            Thread.sleep(1000);
        }
        driver.close();


    }


}
