import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public void newsSectionNameTest() {

String actualTitle = loginPage.find(LoginPage.newsSectionTitle).getText();
Assert.assertEquals(actualTitle,"News");
    }


    @Test
    public void newsArticleTest() throws InterruptedException {
        driver.get("https://my.monkkee.com/#/");
        Thread.sleep(3000);
        System.out.println("Проверка ссылок из раздела News");
        List<WebElement> news = driver.findElements(LoginPage.newsArticleItem);
        System.out.println("Раздел News содержит следующие статьи:");
        for (WebElement article : news) {
            System.out.println(article.getText());
            System.out.println(article.getAttribute("href"));
            System.out.println();
            article.click();
        }
        Thread.sleep(3000);
    }

    @Test
    public void footerLinksTest() throws InterruptedException {
        driver.get("https://my.monkkee.com/#/");
        Thread.sleep(3000);
        System.out.println("Проверка ссылок футтера");
        List<WebElement> news = driver.findElements(LoginPage.footerMenuItem);
        System.out.println("Футер-меню содержит следующие ссылки:");
        for (WebElement article : news) {
            System.out.println(article.getText());
            System.out.println(article.getAttribute("href"));
            System.out.println();
            article.click();
        }
        Thread.sleep(3000);
    }



    @Test
    public void loginTest() {
        loginPage.find(loginInput).sendKeys(loginPage.getLogin());
        loginPage.find(passwordInput).sendKeys(loginPage.getPassword());
        loginPage.click(loginButton);
    }


}