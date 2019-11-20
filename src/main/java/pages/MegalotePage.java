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
public class MegalotePage extends ParentPage {
    public MegalotePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[@class='ripple is18-no-btn nope no']")
    private WebElement Ni;
    @FindBy(xpath = "//*[@class='is18wrap-no no']")
    private WebElement blocker;
    @FindBy(xpath = "//*[@class='gtfo']")
    private WebElement text;
    @FindBy(xpath = "//button[@class='login ripple js-open-modal auth']")
    private WebElement vhodButton;
    @FindBy(xpath = "//*[@id='username']")
    private WebElement inputLogin;
    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPass;
    @FindBy(xpath = "//input[@name='yt0']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[@class='ripple is18-yes-btn yep yes']")
    private WebElement mneEst18;
    @FindBy(xpath = "//button[@class='tutorial_close-popup js-exit-tutorial']")
    private WebElement closeTutorial;

    public void openPage() {
        try {
            webDriver.get("https://test.megalot.emict.net/megalote/uk");
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
            WebElement bloker = webDriver.findElement(By.xpath("//*[@class='is18wrap-no no']"));
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

    public void clickOnLoginButton() {
        vhodButton.click();
        logger.info("click po knopke vhod proshel");
    }

    public void typeLogin(String login) {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " uspeshno vvely");
    }

    public void typePassword(String password) {
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " uspeshno vvely");
    }

    public void clickVhodButton() {
        loginButton.click();
        logger.info("Click po knopke vhod - uspeshniy");

    }

    public boolean isButtonVyhidDisplayed() {
        try {
            WebElement button = webDriver.findElement(By.xpath("//*[@class='sign-out']"));
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void mneEst18() {
        mneEst18.click();
        logger.info("Mne est 18");
    }

    public void closeTutorial() {
        closeTutorial.click();
        logger.info("zakryl tutorial");
    }
}