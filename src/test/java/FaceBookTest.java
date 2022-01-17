import Postman.Users.LogIn.LogInFAIL;
import Postman.Users.LogIn.LogInOK;
import Postman.Users.LogIn.LogInRoot;
import Postman.Users.*;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FaceBookTest {
    WebDriver driver;


   @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
    }
@Test
    public void doRegister(){

       WebElement login = driver.findElement(By.xpath("//*[@data-testid=\"open-registration-form-button\"]"));
       login.click();
}
}


