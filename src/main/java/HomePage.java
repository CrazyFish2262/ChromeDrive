import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

private String textEntry = "Test entry";

    HomePage(WebDriver driver) {
        super(driver);
    }
    public String getEntry(){
        return textEntry;
    }
}