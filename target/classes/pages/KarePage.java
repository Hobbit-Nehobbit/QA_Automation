package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

/**
 * Created by hobbit on 11/19/19.
 */
public class KarePage extends ParentPage {
    public KarePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//button[@class='ripple is18-no-btn nope no']")
    private WebElement Ni;
    @FindBy(xpath = "//*[@class='is18wrap-no no']")
    private WebElement blocker;
    @FindBy(xpath = "//*[@class='gtfo']")
    private WebElement text;
    @FindBy(xpath = ".//input[@id='username']")
    private WebElement inputLogin;
    @FindBy(xpath = ".//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@id='login-form']/div[5]/button")
    private WebElement buttonVhod;
    @FindBy(xpath = "//button[@class='ripple is18-yes-btn yep yes']")
    private WebElement yes18yearsOld;
    @FindBy(xpath = "/html/body/header/div[2]/div/div[2]/button/text()")
    private WebElement loginButton;

    public void openPage() {
        try {
            webDriver.get("https://test.megalot.emict.net/kare/uk");
        } catch (Exception e) {
            Assert.fail("Can't work with page");
        }
    }

    public void clicFalse() {
        Ni.click();
        logger.info("Mne net 18");
    }

    public boolean isBlockPresent() {
        try {
            WebElement blocker = webDriver.findElement(By.xpath("//*[@class='is18wrap-no no']"));
            return blocker.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isAlarmPresent() {
        try {
            WebElement text = webDriver.findElement(By.xpath("//*[@class='gtfo']"));
            return text.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void accept18yearsOld() {
        actionsWithElements.clickOnElement(yes18yearsOld);
    }

    public void enterLoginInToInputLogin(String login) {
        actionsWithElements.enterTextIntoInput(inputLogin, login);
    }

    public void enterPassInToInputPassword(String password){
        actionsWithElements.enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonVhod() {
        actionsWithElements.clickOnElement(buttonVhod);
    }

    public void clickOnButtonLogin() {
        actionsWithElements.clickOnElement(loginButton);
    }
}
