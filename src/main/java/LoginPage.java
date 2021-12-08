import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private String login = "45687@mail.ru";
    private String password = "qwerty4575";


    LoginPage(WebDriver driver) {
        super(driver);
    }

}
