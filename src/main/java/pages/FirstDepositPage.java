package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

/**
 * Created by hobbit on 12/13/19.
 */
public class FirstDepositPage extends ParentPage {



    public FirstDepositPage(WebDriver webDriver) {
        super(webDriver, "/account/deposit");
    }
    @FindBy(xpath = "//*[@class='sign-out']")
    private WebElement exitButton;


}
