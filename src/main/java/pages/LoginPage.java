package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

/**
 * Created by hobbit on 12/2/19.
 */
public class LoginPage extends ParentPage{
    @FindBy (xpath = "//button[@class='ripple is18-yes-btn yep yes']")
    private WebElement yes18Button;
    @FindBy(xpath = "//*[@id='forgetPassword1-element']")
    private WebElement restorePassword;
    @FindBy (xpath = "//*[@class='wrapp-button']")
    private WebElement is18truePopUp;
    @FindBy (id = "forgetPassword2-element")
    private WebElement restoreLogin;
    @FindBy (id = "auth-message")
    private WebElement auth_message;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/account/signin");
    }

    public void openPage() {
        try {
            webDriver.get("https://test.megalot.emict.net/account/signin");
        } catch (Exception e) {
            Assert.fail("Can't work with browser");
        }

    }

    public void is18True() {
        actionsWithElements.clickOnElement(yes18Button);
        logger.info("Yes, I'm 18 years old");
    }

    public void clickRestorePassword() {
        actionsWithElements.clickOnElement(restorePassword);
        logger.info("click on restoreLink success");
    }

    public void waitForPopUp18closed() {
        actionsWithElements.waitInvisibilityOfElement(is18truePopUp);
    }

    public void clickRestoreLogin() {
        actionsWithElements.clickOnElement(restoreLogin);
        logger.info("click on restoreLink success");
    }
    public boolean exitButtonIsDisplayed() {
        return actionsWithElements.isElementDisplayed(auth_message);
    }
}
