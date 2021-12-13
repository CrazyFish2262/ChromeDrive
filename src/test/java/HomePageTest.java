import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

public class HomePageTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    private static final By loginInput = By.xpath(".//input[@id='login']");
    private static final By passwordInput = By.xpath(".//input[@id='password']");
    private static final By loginButton = By.xpath(".//button[@type='submit']");
    private static final By addEntryButton = By.xpath(".//*[@id=\"create-entry\"]");
    private static final By editableArea = By.xpath(".//*[@id=\"editable\"]");
    private static final By homeButton = By.xpath(".//*[@id=\"back-to-overview\"]");
    private static final By deleteEntryButton = By.xpath(".//*[@id=\"delete-entry\"]");

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        driver.get("https://my.monkkee.com/#/");
        Thread.sleep(3000);
        loginPage.find(loginInput).sendKeys(loginPage.getLogin());
        loginPage.find(passwordInput).sendKeys(loginPage.getPassword());
        loginPage.click(loginButton);
    }

    @Test
    public void addEnrty() {
        homePage.find(addEntryButton).click();
        homePage.find(editableArea).sendKeys(homePage.getEntry());
        homePage.find(homeButton).click();
        List<WebElement> list = driver.findElements(By.tagName("body "));
        UUID.randomUUID().toString(); //Для вызова рандомного текста

    }


}
