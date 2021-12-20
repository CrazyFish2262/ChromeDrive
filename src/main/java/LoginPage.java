import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private String login = "vlad.bogomoltsev@gmail.com";
    private String password = "vlad.bogomoltsev_mm";

    public static final By newsSectionTitle = By.xpath("//*[@id='blog-articles']/h1");
    public static final By newsArticleItem = By.xpath("//div[@class='blog-article']//a");
    public static final By footerMenuItem = By.xpath("//li[@class='footer-menu-item']//a");
    public static final By newPageTitle = By.xpath("//*[@class='post-title']/h1");

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