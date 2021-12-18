import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.management.HotspotMemoryMBean;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class HomePageTest {
    private static final By loginInput = By.xpath(".//input[@id='login']");
    private static final By passwordInput = By.xpath(".//input[@id='password']");
    private static final By loginButton = By.xpath(".//button[@type='submit']");
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;


    @BeforeTest
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.get("https://my.monkkee.com/#/");
        Thread.sleep(2000);
        loginPage.find(loginInput).sendKeys(loginPage.getLogin());
        loginPage.find(passwordInput).sendKeys(loginPage.getPassword());
        loginPage.click(loginButton);

    }

    @Test
    public void addEntryTest() throws InterruptedException {
        waitElement(HomePage.addButton);
        homePage.find(HomePage.addButton).click();
        waitElement(HomePage.editableArea);
        String testText = UUID.randomUUID().toString() + " test check";
        homePage.find(HomePage.editableArea).sendKeys(testText);
        Thread.sleep(1000);
        homePage.find(HomePage.homeButton).click();

        waitElement(HomePage.itemBodyList);

        List<WebElement> elements = driver.findElements(HomePage.itemBodyList);

        boolean flag = false;

        for (WebElement element : elements) {
            if(element.getText().equals(testText))
                flag = true;
        }

        Assert.assertTrue(flag);
    }

    private void waitElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

/*    @Test
        public void deleteEntry() throws InterruptedException {
   waitElement(HomePage.addButton);
        homePage.find(HomePage.addButton).click();
        waitElement(HomePage.editableArea);
        String testText = UUID.randomUUID().toString();
        homePage.find(HomePage.editableArea).sendKeys(testText);
        homePage.find(HomePage.homeButton).click();

        waitElement(HomePage.itemBodyList);
            List<WebElement> elements = driver.findElements(HomePage.itemBodyList);
            int entryCounter = elements.size();
            homePage.find(HomePage.entryCheckbox);
            homePage.find(HomePage.deleteButton).click();
            driver.switchTo().alert().accept();
            Assert.assertEquals(elements.size(), entryCounter - 1);
        }
    @Test
    public void findEntry() {
        waitElement(HomePage.addButton);
        homePage.find(HomePage.addButton).click();
        waitElement(HomePage.editableArea);
        String testText = UUID.randomUUID().toString();
        homePage.find(HomePage.editableArea).sendKeys(testText);
        homePage.find(HomePage.homeButton).click();
        waitElement(HomePage.searchInputArea);
        homePage.find(HomePage.searchInputArea).sendKeys(testText);
        homePage.find(HomePage.searchButton).click();
        Assert.assertEquals(HomePage.itemBodyList, testText);
    }*/

/*

    @Test
    public void logout() throws InterruptedException {
        driver.get("https://my.monkkee.com/#/entries");
homePage.find(HomePage.logoutButton).click();
Thread.sleep(2000);
Assert.assertEquals(driver.getCurrentUrl(),"https://my.monkkee.com/#/entries");
    }
*/
@Test
public void logout() throws InterruptedException {
    driver.get("https://my.monkkee.com/#/entries");
    Thread.sleep(2000);
    homePage.find(HomePage.logoutButton).click();
    Thread.sleep(2000);
    Assert.assertEquals(driver.getCurrentUrl(),"https://my.monkkee.com/#/entries");
}

}