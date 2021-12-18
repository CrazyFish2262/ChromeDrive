import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private String login = "vlad.bogomoltsev@gmail.com";
    private String password = "vlad.bogomoltsev_mm";
    public static final By newsArticleItem = By.xpath("//div[@class='blog-article']//a");

    LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }



}