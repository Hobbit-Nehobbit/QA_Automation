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
        super(webDriver, "/kare/uk");
    }
    @FindBy(xpath = "//button[@class='ripple is18-no-btn nope no']")
    private WebElement Ni;
    @FindBy(xpath = "//button[@class='ripple is18-yes-btn yep yes']")
    private WebElement Yes;
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
    @FindBy(xpath = "//button[@class='login ripple js-open-modal auth']")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@id='ticket-checking-input']")
    private WebElement checkWinTicket;
    @FindBy(xpath = "//p[@class='k-popup_text txt-cent']//..")
    private WebElement winTicketPopUp;
    @FindBy(xpath = "//button[@class='btn checking_button']")
    private WebElement checkButton;
    @FindBy(xpath = "//button[@class='k-popup_close js-close-popup']")
    private WebElement closePopUp;
    @FindBy(xpath = "//h3[@class='k-popup_headline']")
    private WebElement loseTicketPopUp;
    @FindBy(xpath = "//*[@class='wrapp-button']")
    private WebElement is18popUp;
    @FindBy(xpath = "//*[@class='modal-inner']")
    private WebElement loginForm;
    @FindBy (id = "table2-auto")
    private WebElement table2auto;
    @FindBy(xpath = "//button[@class='coupon_pay btn js-pay-trigger js-coupon_control-inline']")
    private WebElement payButton;
    @FindBy (xpath = "//button[@class='k-popup_btn btn js-confirm-payment']")
    private WebElement confirmPayButton;
    @FindBy(xpath = "//*[@class='bet_menu-item js-bet-menu-item js-table-1-trigger']")
    private WebElement tableOne;
    @FindBy (id = "table1-auto")
    private WebElement table1auto;
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

    public void enterPassInToInputPassword(String password) {
        actionsWithElements.enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonVhod() {
        actionsWithElements.clickOnElement(buttonVhod);
    }

    public void clickOnButtonLogin() {
        actionsWithElements.clickOnElement(loginButton);
    }

    public void inputIntoCheckTicketField(String maccode) {
        actionsWithElements.enterTextIntoInput(checkWinTicket, maccode);
    }

    public void clickCheckButton() {
        actionsWithElements.clickOnElement(checkButton);
    }


    public boolean isWinTicketPopUpPresent() {
//        actionsWithElements.isElementDisplayed(winTicketPopUp);
//        return winTicketPopUp.isDisplayed();
        try {

            WebElement winTicketPopUp = webDriver.findElement(By.xpath("//h3[@class='k-popup_headline']"));
            return winTicketPopUp.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoseTicketPopUpPresent() {
        try {
            WebElement loseTicketPopUp = webDriver.findElement(By.xpath("//h3[@class='k-popup_headline']"));
            return loseTicketPopUp.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isTextPresent() {
        try {
            WebElement loseTicketPopUp = webDriver.findElement(By.xpath("//h3[@class='k-popup_headline']"));
            return loseTicketPopUp.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closePopup() {
        actionsWithElements.clickOnElement(closePopUp);
    }


    public void is18PopUpClose() {
        actionsWithElements.waitInvisibilityOfElement(is18popUp);
    }

    public void clickTrue() {
        actionsWithElements.clickOnElement(Yes);
    }

    public boolean isLoginFormPresent() {
        try {
            WebElement loginForm = webDriver.findElement(By.xpath("//*[@class='ripple sign-np-btn button']"));
            return loginForm.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isButtonVyhidDisplayed() {
        try {
            WebElement button = webDriver.findElement(By.xpath("//*[@class='sign-out']"));
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public void waitForPopUp() {
        actionsWithElements.waitForPopUp(winTicketPopUp);
    }

    public void validLogin(String login, String password) {
        openPage();
        accept18yearsOld();
        is18PopUpClose();
        clickOnButtonLogin();
        enterLoginInToInputLogin(login);
        enterPassInToInputPassword(password);
        clickOnButtonVhod();
        logger.info("LogIn Success");
    }

    public void clickAutoBetTable2() {
        actionsWithElements.clickOnElement(table2auto);
        logger.info("AutoBet success");
    }

    public boolean isEditButtonPresent() {
        try {
            WebElement editButton = webDriver.findElement(By.xpath("//button[@class='coupon_bet-action js-edit-bet']"));
            return editButton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void clickPayButton() {
        actionsWithElements.clickOnElement(payButton);
        logger.info("Click was success");
    }

    public boolean isSuccessPopUpDisplayed() {
        try {
            WebElement popUp = webDriver.findElement(By.xpath("//*[@class='k-popup js-popup k-popup-visible']"));
            return popUp.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void clickConfirmPay() {
        actionsWithElements.clickOnElement(confirmPayButton);
        logger.info("Confirm success");
    }

    public void checkTableOne() {
        actionsWithElements.clickOnElement(tableOne);
    }

    public void clickAutoBetTable1() {
        actionsWithElements.clickOnElement(table1auto);
    }
}
