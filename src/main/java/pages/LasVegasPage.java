package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by hobbit on 11/15/19.
 */
public class LasVegasPage extends ParentPage {
    public LasVegasPage(WebDriver webDriver) {
        super(webDriver, "/las-vegas/uk");
    }

    @FindBy(xpath = "//*[@id='username']")
    private WebElement inputLogin;
    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPass;
    @FindBy(xpath = "//button[@class='ripple sign-np-btn button']")
    private WebElement ButtonVhid;
    @FindBy(xpath = "//button[@class='ripple is18-yes-btn yep yes']")
    private WebElement MneEst18;
    @FindBy(xpath = "/html/body/header/div[2]/div/div[2]/button")
    private WebElement vhodButton;
    @FindBy(xpath = "//*[@class='close-las-wegas-begin js-close-las-wegas-begin']")
    private WebElement Propusk;
    @FindBy(xpath = "//button[@id='button-game']")
    private WebElement Pokupka;
    @FindBy(xpath = "//span[@class='modal-pay-ticet__text-sum' and text()='50']")
    private WebElement ZaOdinBilet;
    @FindBy(xpath = ".//button[@id='button-play-game']")
    private WebElement Prodovgzity;
    @FindBy(xpath = "//*[@id='auto-game']")
    private WebElement Avto;
    @FindBy(xpath = "//*[@class='number-ticet-result']")
    private WebElement TicketResult;
    @FindBy(xpath = "//button[@id='button-game']")
    private WebElement Pochaty;
    @FindBy(xpath = "//*[@class='close-modal-window js-close-prompt-wrapp']")
    private WebElement podskazka;
    @FindBy(xpath = "//ul/li[@class='ticet-number']")
    private WebElement ticketNumber;
    @FindBy(xpath = "//button[@class='button-plus']")
    private WebElement plus;
    @FindBy (xpath = "//span[text()='купити квиток']")
    private WebElement results;
    @FindBy (xpath = "//*[@class='sign-out']")
    private WebElement vyhidButton;
    @FindBy(xpath = "//*[@class='wrapp-button']")
    private WebElement is18popUp;
    @Step
    public boolean isButtonVyhidDisplayed() {
        return actionsWithElements.isElementDisplayed(vyhidButton);
    }
    @Step
    public boolean resultsAreDisplayed() {
        return actionsWithElements.isElementDisplayed(results);
    }
    @Step
    public boolean isTextPresent() {
        return actionsWithElements.isElementDisplayed(ZaOdinBilet);
    }
    @Step
    public void openPage() {
        try {
            webDriver.get("https://test.megalot.emict.net/las-vegas/uk");
        } catch (Exception e) {
            Assert.fail("Can't work with page");
        }
    }
    @Step
    public void enterLoginInToFieldLogin(String login) {
        actionsWithElements.enterTextIntoInput(inputLogin, login);
        logger.info(login + " was inputed success");
    }
    @Step
    public void enterPassInToFieldPassword(String password) {
        actionsWithElements.enterTextIntoInput(inputPass, password);
        logger.info(password + " was inputed success");
    }
    @Step
    public void clickOnButtonVhid() {
        actionsWithElements.clickOnElement(ButtonVhid);
        logger.info("Click was success");
    }
    @Step
    public void mneEst18() {
        actionsWithElements.clickOnElement(MneEst18);
        logger.info("Soglasen");
    }

    @Step
    public void vhodButton() {
        actionsWithElements.clickOnElement(vhodButton);
        logger.info("URA");
    }
    @Step
    public void propusk() {
        actionsWithElements.clickOnElement(Propusk);
        logger.info("Propustil");
    }
    @Step
    public void pokupkaButton() {
        actionsWithElements.clickOnElement(Pokupka);
        logger.info("kupil");
    }
    @Step
    public void clickProdovgzity() {
        actionsWithElements.clickOnElement(Prodovgzity);
        logger.info("Prodovgziv");
    }
    @Step
    public void clickAvto() {
        actionsWithElements.clickOnElement(Avto);
        logger.info("Razigral");
    }
    @Step
    public void clickPochaty() {
        actionsWithElements.clickOnElement(Pochaty);
        logger.info("pochaly");
    }
    @Step
    public void closePodskazku() {
        actionsWithElements.clickOnElement(podskazka);
        logger.info("zakril podskazku");
    }
    @Step
    public boolean tiketBySuccess() {
        return actionsWithElements.isElementDisplayed(ticketNumber);
    }
    @Step
    public void changeCountOfTicket() {
        actionsWithElements.clickOnElement(plus);
        logger.info("count + 1");
    }
    @Step
    public void fillingLoginForm(String login, String password) {
        openPage();
        mneEst18();
        propusk();
        vhodButton();
        actionsWithElements.enterTextIntoInput(inputLogin, login);
        actionsWithElements.enterTextIntoInput(inputPass, password);
        clickOnButtonVhid();
    }
    @Step
    public void waitForResults() {
        actionsWithElements.waitVisibilityOfElement(results);
    }
    @Step
    public void is18YearsOldClosed() {
        actionsWithElements.waitInvisibilityOfElement(is18popUp);
    }
}
