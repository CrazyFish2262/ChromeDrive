import Postman.Users.*;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class APItest {
    WebDriver driver;
    Scanner scanner;


/*    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }*/

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
        System.out.println("TEST getAvatar: Check of getting user avatars");
        TheRoot root = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users?page=2")
                .body()
                .as(TheRoot.class);
        List<Users> avatarList = root.data;
        System.out.println("Avatar links: ");
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
        System.out.println();


    }

    @Test
    public void getUserList() throws InterruptedException {
        System.out.println("TEST getUserList: Check of getting user list");
        TheRoot root = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users?page=2")
                .body()
                .as(TheRoot.class);

        //создание списка
        List<Users> usersList = root.data;
        System.out.println("User list for page #" + root.page + ":");

        //вывод данных о пользователях
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println("ID: " + usersList.get(i).id);
            System.out.println("Email: " + usersList.get(i).email);
            System.out.println("First name: " + usersList.get(i).first_name);
            System.out.println("Last name: " + usersList.get(i).last_name);
            System.out.println("Avatar link: " + usersList.get(i).avatar);
            System.out.println();
        }
        System.out.println();

    }


    @Test
    public void getSingleUser() {
        System.out.println("TEST getSingleUser: Check of getting info about a single user");
        String userID = "2";
        System.out.println("UserID to be found is" + userID);
        System.out.println("Result:");
        SingleUser singleUser  = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users/" + userID)
                .body()
                .as(SingleUser.class);
            System.out.println("ID: " + singleUser.data.id);
            System.out.println("Email: " + singleUser.data.email);
            System.out.println("First name: " + singleUser.data.first_name);
            System.out.println("Last name: " + singleUser.data.last_name);
            System.out.println("Avatar link: " + singleUser.data.avatar);
            System.out.println();
    }



    @Test
    public void userNotFound() {
        System.out.println("TEST userNotFound: Check of 404 status code");
        String userID = "23";
        System.out.println("User ID to be found is " + userID);
        int requestStatusCode  = given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users/" + userID)
                .statusCode();
        System.out.println("Expected status code is 404");
        System.out.println("Actual status code is " + requestStatusCode);
        Assert.assertEquals(requestStatusCode,404);
    }


    @Test
    public void getPantoneList() {
        System.out.println("TEST getPantoneList: Check of getting pantone list");
        PantoneRoot pantoneRoot = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/unknown")
                .body()
                .as(PantoneRoot.class);

        //создание списка
        List<Pantone> pantoneList = pantoneRoot.data;
        System.out.println("Pantone list for page #" + pantoneRoot.page + ":");
        System.out.println();
        //вывод данных
        for (int i = 0; i < pantoneList.size(); i++) {
            System.out.println("ID: " + pantoneList.get(i).id);
            System.out.println("Name: " + pantoneList.get(i).name);
            System.out.println("Year: " + pantoneList.get(i).year);
            System.out.println("Color: " + pantoneList.get(i).color);
            System.out.println("Pantone value: " + pantoneList.get(i).pantone_value);

            System.out.println();
        }

    }

    @Test
    public void getSinglePantone() {
        System.out.println("TEST getSinglePantone: Check of getting info about a single pantone");
        String pantoneID = "2";
        System.out.println("PantoneID to be found is " + pantoneID);
        System.out.println("Result:");
        SinglePantone singlePantone  = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/unknown/" + pantoneID)
                .body()
                .as(SinglePantone.class);
        System.out.println("ID: " + singlePantone.data.id);
        System.out.println("Name: " + singlePantone.data.name);
        System.out.println("Year: " + singlePantone.data.year);
        System.out.println("Color: " + singlePantone.data.color);
        System.out.println("Pantone value: " + singlePantone.data.pantone_value);
        System.out.println();
    }


    @Test
    public void pantoneNotFound() {
        System.out.println("TEST pantoneNotFound: Check of 404 status code");
        String userID = "23";
        System.out.println("Pantone ID to be found is " + userID);
        int requestStatusCode  = given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/unknown/" + userID)
                .statusCode();
        System.out.println("Expected status code is 404");
        System.out.println("Actual status code is " + requestStatusCode);
        Assert.assertEquals(requestStatusCode,404);
    }

}


