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
        Thread.sleep(2000);
    }


    private void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    @Test
    public void addEntryTest() throws InterruptedException {
        Thread.sleep(2000);
        waitElement(HomePage.addButton);
        homePage.find(HomePage.addButton).click();
        Thread.sleep(2000);
        waitElement(HomePage.editableArea);
        String testText = UUID.randomUUID().toString() + " test check";
        homePage.find(HomePage.editableArea).click();
        homePage.find(HomePage.editableArea).sendKeys(testText);
        Thread.sleep(4000);
        homePage.find(HomePage.homeButton).click();

        waitElement(HomePage.itemBodyList);

        List<WebElement> elements = driver.findElements(HomePage.itemBodyList);
        boolean flag = false;

        for (WebElement element : elements) {
            if (element.getText().equals(testText))
                flag = true;
        }
        Assert.assertTrue(flag);
    }


    @Test
    public void deleteEntry() throws InterruptedException {
        Thread.sleep(2000);
        //создаём тестовую запись
        waitElement(HomePage.addButton);
        homePage.find(HomePage.addButton).click();
        waitElement(HomePage.editableArea);
        String testText = UUID.randomUUID().toString() + " test check";
        homePage.find(HomePage.editableArea).click();
        homePage.find(HomePage.editableArea).sendKeys(testText);
        Thread.sleep(4000);
        homePage.find(HomePage.homeButton).click();

        //создаём список веб-элементов (записей) до удаления
        waitElement(HomePage.itemBodyList);
        List<WebElement> beforeDelete = driver.findElements(HomePage.itemBodyList);
        System.out.println("Записи ДО удаления:");
        beforeDelete.forEach(webElement ->
                System.out.println(webElement.getText()));
        System.out.println("Итого записей до удаления: " + beforeDelete.size());

        //выбираем чекбокс новой созданной тестовой записи
        homePage.find(HomePage.entryCheckbox).click();
        homePage.find(HomePage.deleteButton).click();
        driver.switchTo().alert().accept();             //переключаем фокус на уведомление и подтверждаем согласие

        //создаём список веб-элементов (записей) после удаления
        Thread.sleep(2000);
        List<WebElement> afterDelete = driver.findElements(HomePage.itemBodyList);
        System.out.println();
        System.out.println("Записи ПОСЛЕ удаления:");
        afterDelete.forEach(element ->
                System.out.println(element.getText()));
        System.out.println("Итого записей после удаления: " + afterDelete.size());

        //сравниваем размер списка ДО и ПОСЛЕ удаления
        Thread.sleep(2000);
        Assert.assertEquals(afterDelete.size(), beforeDelete.size() - 1);
    }



    @Test
    public void findEntry() throws InterruptedException {
        Thread.sleep(2000);
        //создаём тестовую запись
        waitElement(HomePage.addButton);
        homePage.find(HomePage.addButton).click();
        waitElement(HomePage.editableArea);
        String testText = UUID.randomUUID().toString() + " test check";
        homePage.find(HomePage.editableArea).click();
        Thread.sleep(1000);
        homePage.find(HomePage.editableArea).sendKeys(testText);
        Thread.sleep(4000);
        homePage.find(HomePage.homeButton).click();

        //находим и заполняем поле поиска записи
        Thread.sleep(2000);
        waitElement(HomePage.searchInputArea);
        homePage.find(HomePage.searchInputArea).click();
        Thread.sleep(2000);
        homePage.find(HomePage.searchInputArea).sendKeys(testText);
        homePage.find(HomePage.searchButton).click();

        //сравниваем текст найденной записи с текстом созданной тестовой записи
        Thread.sleep(2000);
        waitElement(HomePage.itemBodyList);
        Assert.assertEquals(homePage.getText(HomePage.itemBodyList), testText);//через contains
    }




    @Test
    public void logoutTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://my.monkkee.com/#/entries");
        Thread.sleep(2000);
        homePage.find(HomePage.logoutButton).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://my.monkkee.com/#/");
    }




}