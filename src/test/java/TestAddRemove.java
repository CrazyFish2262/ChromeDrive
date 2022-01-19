import com.sun.javafx.scene.control.behavior.SliderBehavior;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

public class TestAddRemove {
    WebDriver driver;
    SecureRandom random = new SecureRandom();

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


}


/*
@Test
    public void inputPlaceholder(){
    driver.get("https://www.onliner.by");
    WebElement placeholder = driver.findElement(By.className("fast-search__input"));
    String actualResult = placeholder.getAttribute("placeholder");
    System.out.println(actualResult);
Assert.assertTrue(actualResult.contains("Поиск в Каталоге."));

}
*/
/*public long getFolderSizeBefore() {
    String folderPath = "C:\\Users\\st\\Downloads\\";
    File file = new File(folderPath);
    long length = 0;
    for (int i = 0; i < file.list().length; i++) {
        File tmp = new File(folderPath + file.list()[i]);
        length += tmp.length();
    }
    return length;
}


    @Test
    public void downloadFiles() throws InterruptedException {
        Long sizeBefore = getFolderSizeBefore();
    System.out.println("Folder size before downloading: " + sizeBefore + " bytes");
        driver.get("https://the-internet.herokuapp.com/download");
        List<WebElement> list = driver.findElements(By.xpath("//div[@id=\"content\"]/div//a"));
*//*        list.forEach(element ->
                System.out.println(element.getAttribute("href")));*//*
        WebElement file = list.get(random.nextInt(list.size()));
        file.click();
        Thread.sleep(5000);
        System.out.println();
        System.out.println("Downloaded file is " + file.getText());
        String folderPath = "C:\\Users\\st\\Downloads\\";
        File file1 = new File(folderPath + file.getText());
        System.out.println("It's size is " + file1.length() + " bytes");
        System.out.println("Folder size after downloading: " + getFolderSizeAfter() + " bytes");
        Long sizeAfter = getFolderSizeAfter();
        Assert.assertEquals(sizeAfter + 0, sizeBefore + file1.length());
    }



    public long getFolderSizeAfter() {
        String folderPath = "C:\\Users\\st\\Downloads\\";
        File file = new File(folderPath);
        long length = 0;
        for (int i = 0; i < file.list().length; i++) {
            File tmp = new File(folderPath + file.list()[i]);
            length += tmp.length();
        }
        return length;
    }*/


/*    @Test
    public void findRenderedAfter() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dynamicLoading = driver.findElement(By.xpath(".//*[@href=\"/dynamic_loading\"]"));
        dynamicLoading.click();
        WebElement example2 = driver.findElement(By.xpath(".//*[@href=\"/dynamic_loading/2\"]"));
        example2.click();
        WebElement startButton = driver.findElement(By.tagName("button"));
        startButton.click();
        WebElement renderedElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=\"finish\"]/h4")));
        Assert.assertEquals(renderedElement.getText(), "Hello World!");
    }*/

/*
    @Test
    public void findRenderedAfter() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        String fileName = "test.png";
        WebElement fileUpload = driver.findElement(By.xpath(".//*[@href=\"/upload\"]"));
       fileUpload.click();
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\st\\Downloads\\" + fileName);
        WebElement submitButton = driver.findElement(By.id("file-submit"));
        submitButton.click();
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(),fileName);
    }
*/


}
