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
    @FindBy(xpath = "//*[@class='sign-out']")
    private WebElement buttonVyhid;

    public MegalotePage(WebDriver webDriver) {
        super(webDriver, "/megalote/uk");
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
        actionsWithElements.clickOnElement(Ni);
        logger.info("Mne net 18");
    }

    public boolean isBlockPresent() {
        return actionsWithElements.isElementDisplayed(blocker);
    }

    public boolean isAlarmPresent() {
        return actionsWithElements.isElementDisplayed(text);
    }

    public void clickOnLoginButton() {
        actionsWithElements.clickOnElement(vhodButton);
        logger.info("click po knopke vhod proshel");
    }

    public void typeLogin(String login) {
        actionsWithElements.enterTextIntoInput(inputLogin, login);
        logger.info(login + " uspeshno vvely");
    }

    public void typePassword(String password) {
        actionsWithElements.enterTextIntoInput(inputPass, password);
        logger.info(password + " uspeshno vvely");
    }

    public void clickVhodButton() {
        actionsWithElements.clickOnElement(loginButton);
        logger.info("Click po knopke vhod - uspeshniy");

    }

    public boolean isButtonVyhidDisplayed() {
        return actionsWithElements.isElementDisplayed(buttonVyhid);
    }

    public void mneEst18() {
        actionsWithElements.clickOnElement(mneEst18);
        logger.info("Mne est 18");
    }

    public void closeTutorial() {
        actionsWithElements.clickOnElement(closeTutorial);
        logger.info("zakryl tutorial");
    }
}