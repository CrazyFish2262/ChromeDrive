import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestAddRemove {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
/*

*/
/*
    @Test
    public void findElement() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        String actualResult = addElementButton.getText();
        Assert.assertEquals(actualResult, "Add Element");
        addElementButton.click();
        WebElement deleteButton = driver.findElement(By.className("added-manually"));
    }

    @Test
    public void dropDownMenu() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
        option.click();
        dropdown.click();
    }*//*


    @Test
    public void listElement() {
        System.out.println("Тест на проверку элементов навигационного меню");
        driver.get("https://www.onliner.by/");
        List<WebElement> list = driver.findElements(By.className("b-main-navigation"));
        list.forEach(category -> {
                    System.out.println(category.getText());
                }
        );
        System.out.println();

    }
*/
/*
    .//ul[@class='b-main-navigation'] - для поиска конкретного элемента через xPath
    .//*[@class='b-main-navigation'] - для поиска элемента, если не знаем название класса
    *//*


@Test
public void listE() {
    System.out.println("Тест на проверку названия категорий");
    driver.get("https://catalog.onliner.by/");
    List<WebElement> list = driver.findElements(By.xpath(".//ul[@class='catalog-navigation-classifier ']/li"));
    list.forEach(category -> {
                System.out.println(category.getText());
            }
    );
}
*/


@Test
    public void findMers(){
    driver.get("https://www.onliner.by/");
    WebElement autobaraholka = driver.findElement(By.xpath(".//ul[@class='b-main-navigation']/li[3]"));
    autobaraholka.click();
    WebElement dropdown = driver.findElement(By.xpath(".//*[@id=\"container\"]/div/div/div/div/div/div[2]/div/div/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]"));
    dropdown.click();
    WebElement brand = driver.findElement(By.xpath(".//*[@class='dropdown-style__list dropdown-style__list_brand']/li[7]"));
    List<WebElement>list = driver.findElements(By.xpath(".//*[@class='vehicle-form__offers-list']/a"));
    list.forEach(element -> {
        System.out.println(element.getAttribute("href"));
    });


    //*[@id="container"]/div/div/div/div/div/div[2]/div/div/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]
}





}
