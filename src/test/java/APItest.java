import Postman.Users.*;
import Postman.Users.LogIn.LogInFAIL;
import Postman.Users.LogIn.LogInOK;
import Postman.Users.LogIn.LogInRoot;
import Postman.Users.Registration.RegistrationFAIL;
import Postman.Users.Registration.RegistrationOK;
import Postman.Users.Registration.RegistrationRoot;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

import static io.restassured.RestAssured.*;

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
        System.out.println("UserID to be found is " + userID);
        SingleUser singleUser  = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users/" + userID)
                .body()
                .as(SingleUser.class);

        System.out.println("Result");
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
        ValidatableResponse requestResult = given()
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/unknown/" + userID)
                .then().assertThat().statusCode(404);

        SinglePantone singlePantone = requestResult.extract().body().as(SinglePantone.class);
        System.out.println("User data found: " + singlePantone.data);
        System.out.println("Request status code is " + requestResult.extract().statusCode());
        Assert.assertNull(singlePantone.data);
    }

    @Test
    public void createNewUser() {
        System.out.println("TEST createNewUser: Check of creating a new user");

       UserBase user = new UserBase("Morpheus", "leader");
        UserBase newUser = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .body(user)
                .post("/api/users")
                .then()
                .assertThat().statusCode(201)
                .and()
                .log().body()
                .and()
                .extract().body().as(UserBase.class);

        System.out.println("New user's data:");
        System.out.println("Name: " + newUser.name);
        System.out.println("Job: " + newUser.job);
        System.out.println("UserID: " + newUser.id);
        System.out.println("Date of creation: " + newUser.createdAt);
        Assert.assertEquals(newUser.name, user.name);
        Assert.assertEquals(newUser.job, user.job);



    }


    @Test
    public void updateUserInfoWithPUT() {
        System.out.println("TEST updateNewUserWithPUT: Check of update user's data");

        UserBase user = new UserBase("Morpheus", "zion resident");
        UserBaseUpdate newUserUpdate = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .body(user)
                .put("/api/users/2")
                .then()
                .assertThat().statusCode(200)
                .and()
                .log().body()
                .and()
                .extract().body().as(UserBaseUpdate.class);

        System.out.println("User data after update:");
        System.out.println("Name: " + newUserUpdate.name);
        System.out.println("Job: " + newUserUpdate.job);
        System.out.println("Update time: " + newUserUpdate.updatedAt);
        Assert.assertEquals(newUserUpdate.name, user.name);
        Assert.assertEquals(newUserUpdate.job, user.job);
    }



    @Test
    public void updateUserInfoWithPATCH() {
        System.out.println("TEST updateNewUserWithPATCH: Check of update user's data");

        UserBase user = new UserBase("Morpheus", "zion resident");
        UserBaseUpdate newUserUpdate = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .body(user)
                .patch("/api/users/2")
                .then()
                .assertThat().statusCode(200)
                .and()
                .log().body()
                .and()
                .extract().body().as(UserBaseUpdate.class);

        System.out.println("User data after update:");
        System.out.println("Name: " + newUserUpdate.name);
        System.out.println("Job: " + newUserUpdate.job);
        System.out.println("Update time: " + newUserUpdate.updatedAt);
        Assert.assertEquals(newUserUpdate.name, user.name);
        Assert.assertEquals(newUserUpdate.job, user.job);
    }


    @Test
    public void deleteUser() {
        System.out.println("TEST deleteUser: Check of delete user's data");

        ValidatableResponse deleteUser = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .delete("/api/users/2")
                .then()
                .assertThat().statusCode(204);
        int statusCode = deleteUser.extract().statusCode();
        System.out.println("Status code is " + statusCode);
    }




    @Test
    public void registrationSUCCESSFUL() {
        System.out.println("TEST registrationSUCCESSFUL: Check of successful registration");

        RegistrationRoot registrationData = new RegistrationRoot("eve.holt@reqres.in", "pistol");
        ValidatableResponse registration = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .body(registrationData)
                .post("/api/register")
                .then().assertThat().statusCode(200);
/*                .and()
                .extract().body().as(RegistrationOK.class);*/
 RegistrationOK registrationOK = registration.extract().body().as(RegistrationOK.class);

        System.out.println("Registration data");
        System.out.println("Email: " + registrationData.email);
        System.out.println("Password: " + registrationData.password);
        System.out.println("Request status code is " + registration.extract().statusCode());
        System.out.println("ID: " + registrationOK.id);
        System.out.println("Registration token: " + registrationOK.token);
    }



    @Test
    public void registrationFAIL() {
        System.out.println("TEST registrationFAIL: Check of unsuccessful registration");

        RegistrationRoot registrationData = new RegistrationRoot("peter@klaven");
        ValidatableResponse registration = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .body(registrationData)
                .post("/api/register")
                .then().assertThat().statusCode(400);

        RegistrationFAIL registrationFAIL = registration.extract().body().as(RegistrationFAIL.class);

        System.out.println("Email: " + registrationData.email);
        System.out.println("Password: " + registrationData.password);
        Assert.assertNull(registrationData.email);
        Assert.assertNull(registrationData.password);
        System.out.println("Request status code is " + registration.extract().statusCode());
        System.out.println("Error message: " + registrationFAIL.error);
        Assert.assertEquals(registrationFAIL.error,"Missing password");


    }





    @Test
    public void loginSUCCESSFUL() {
        System.out.println("TEST loginSUCCESSFUL: Check of successful log in");

        LogInRoot logInData = new LogInRoot("eve.holt@reqres.in", "cityslicka");
        ValidatableResponse logIn = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .body(logInData)
                .post("/api/login")
                .then().assertThat().statusCode(200);

        LogInOK logInOK = logIn.extract().body().as(LogInOK.class);

        System.out.println("LogIn data");
        System.out.println("Email: " + logInData.email);
        System.out.println("Password: " + logInData.password);
        System.out.println("Request status code is " + logIn.extract().statusCode());
        System.out.println("Registration token: " + logInOK.token);
    }




    @Test
    public void logInFAIL() {
        System.out.println("TEST logInFAIL: Check of unsuccessful log in");

        LogInRoot logInData = new LogInRoot("peter@klaven");
        ValidatableResponse logIn = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .body(logInData)
                .post("/api/login")
                .then().assertThat().statusCode(400);

        LogInFAIL logInFAIL = logIn.extract().body().as(LogInFAIL.class);

        System.out.println("Email: " + logInData.email);
        System.out.println("Password: " + logInData.password);
        Assert.assertNull(logInData.email);
        Assert.assertNull(logInData.password);
        System.out.println("Request status code is " + logIn.extract().statusCode());
        System.out.println("Error message: " + logInFAIL.error);
        Assert.assertEquals(logInFAIL.error,"Missing password");
    }



    @Test
    public void delayedResponse() throws InterruptedException {
        System.out.println("TEST delayedResponse: Check of delay");
        long expectedResponseTime = 3000;

        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in/")
                .when()
                .get("/api/users?delay=3")
                .then()
                .time(Matchers.greaterThanOrEqualTo(expectedResponseTime))
                .assertThat().statusCode(200);
        long actualResponseTime = response.extract().response().getTime();
        System.out.println("Actual response time: " + actualResponseTime + " ms");
        System.out.println("Expected response time is more than " + expectedResponseTime + " ms" );

    }



}


