import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find (By locator){
        return driver.findElement(locator);
    }
}
