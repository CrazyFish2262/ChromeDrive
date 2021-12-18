import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public static final By addButton =By.xpath("//a[@id='create-entry']");
    public static final By deleteButton =By.xpath("//a[@id='delete-entries']");
    public static final By editableArea =By.xpath("//div[@id='editable']");
    public static final By homeButton =By.xpath("//a[@id='back-to-overview']");
    public static final By itemBodyList =By.xpath("//div[@class='body ']");
    public static final By entryCheckbox =By.xpath("//*[@ng-change='updateSelectionState()']");
    public static final By searchInputArea =By.xpath("//*[@id='appendedInputButton']");
    public static final By searchButton =By.xpath("//*[@class='btn btn-primary input-group-addon']");
    public static final By logoutButton =By.xpath("//*[@ng-click='logout($event)']");



    HomePage(WebDriver driver) {
        super(driver);
    }

}