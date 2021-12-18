import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;
    private static final By loginInput = By.xpath(".//input[@id='login']");
    private static final By passwordInput = By.xpath(".//input[@id='password']");
    private static final By loginButton = By.xpath(".//button[@type='submit']");

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        driver.get("https://my.monkkee.com/#/");
        Thread.sleep(3000);
    }

    @Test
    public void newsArticleTest() {
        List<WebElement> news = driver.findElements(LoginPage.newsArticleItem);
        System.out.println("Раздел News содержит следующие статьи");
        news.forEach(article -> {
            System.out.println(article.getAttribute("href"));
            System.out.println(article.getText());
            article.click();
        });

    }

/*    @Test
    public void loginTest() {
        loginPage.find(loginInput).sendKeys(loginPage.getLogin());
        loginPage.find(passwordInput).sendKeys(loginPage.getPassword());
        loginPage.click(loginButton);
    }*/



}