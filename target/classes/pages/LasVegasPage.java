package pages;

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

    public boolean isButtonVyhidDisplayed() {
        try {
            WebElement button = webDriver.findElement(By.xpath("//*[@class='sign-out']"));
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean resultsAreDisplayed() {
        try {
            WebElement ticket = webDriver.findElement(By.xpath("//span[text()='купити квиток']"));
            return ticket.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTextPresent() {
        try {
            WebElement text = webDriver.findElement(By.xpath("//span[@class='modal-pay-ticet__text-sum' and text()='50']"));
            return text.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openPage() {
        try {
            webDriver.get("https://test.megalot.emict.net/las-vegas/uk");
        } catch (Exception e) {
            Assert.fail("Can't work with page");
        }
    }

    public void enterLoginInToFieldLogin(String login) {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed success");
    }

    public void enterPassInToFieldPassword(String password) {
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " was inputed success");
    }

    public void clickOnButtonVhid() {
        ButtonVhid.click();
        logger.info("Click was success");
    }

    public void mneEst18() {
        MneEst18.click();
        logger.info("Soglasen");
    }


    public void vhodButton() {
        vhodButton.click();
        logger.info("URA");
    }

    public void propusk() {
        Propusk.click();
        logger.info("Propustil");
    }

    public void pokupkaButton() {
        Pokupka.click();
        logger.info("kupil");
    }

    public void clickProdovgzity() {
        Prodovgzity.click();
        logger.info("Prodovgziv");
    }

    public void clickAvto() {
        Avto.click();
        logger.info("Razigral");
    }

    public void clickPochaty() {
        Pochaty.click();
        logger.info("pochaly");
    }

    public void closePodskazku() {
        podskazka.click();
        logger.info("zakril podskazku");
    }

    public boolean tiketBySuccess() {
        try {
            WebElement ticketNumber = webDriver.findElement(By.xpath("//ul/li[@class='ticet-number']"));
            return ticketNumber.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void changeCountOfTicket() {
        plus.click();
        logger.info("count + 1");
    }
}
