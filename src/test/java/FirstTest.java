import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest {
    //обязательно в названии должно быть слово Test
    WebDriver driver;
 @BeforeTest
 public void setUp(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.onliner.by/");
 }

    @Test
    public void firstTest1() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/header/div[2]/div/nav/ul[1]/li[1]/a[2]/span"));
        String actualResult = element.getText();
        Assert.assertEquals(actualResult, "Каталог");
    }

    @Test
    public static void firstTest2() {

        System.out.println("test2");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("before groups");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }


    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("after groups");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }


}
