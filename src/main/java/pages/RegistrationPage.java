package pages;

import libs.CheckingMails;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by hobbit on 11/29/19.
 */
public class RegistrationPage extends ParentPage {
    @FindBy(id = "account_email")
    private WebElement emailInput;
    @FindBy(id = "account_phone_code")
    private WebElement account_phone_code;
    @FindBy(id = "account_phone_number")
    private WebElement account_phone_number;
    @FindBy (xpath = "//*[@id='account_signup_form']/div[4]/div/div[2]/label/i")
    private WebElement oferta;
    @FindBy(xpath = "//*[@id='account_signup_form']/div[4]/div/div[3]/label/i")
    private WebElement obrobka;
    @FindBy (xpath = "//*[@id='account_signup_form']/div[4]/div/div[4]/label/i")
    private WebElement confidential;
    @FindBy (xpath = "//*[@id='account_signup_form']/div[4]/div/div[5]/label/i")
    private WebElement ukraine;
    @FindBy(id = "registration_btn")
    private WebElement nextButton;
    @FindBy(xpath = "//*[@class='ripple is18-yes-btn yep yes']")
    private WebElement yes18yearsOld;
    @FindBy (xpath = "//select[@id='account_birthday_day']")
    private WebElement dayOfBirth;
    @FindBy (xpath = "//select[@id='account_birthday_day']//option[19]")
    private WebElement value18;
    @FindBy(id = "account_birthday_month")
    private WebElement monthOfBirth;
    @FindBy(xpath = "//select[@id='account_birthday_month']//option[7]")
    private WebElement valueJune;
    @FindBy (xpath = "//select[@id='account_birthday_year']//option[10]")
    private WebElement year1993;
    @FindBy (id = "account_birthday_year")
    private WebElement year;
    @FindBy (id = "account_passwd")
    private WebElement passInput;
    @FindBy (id = "account_passwd_confirm")
    private WebElement passConfirm;
    @FindBy(id = "registration_btn")
    private WebElement sighnUpButton;
    @FindBy(xpath = "//a[@href='https://igra.msl.ua/test_dlya_igroka']")
    private WebElement successLink;
    @FindBy(xpath = "//*[@class='arrow-back']")
    private WebElement backButton;
    @FindBy (id = "account_email_check")
    private WebElement email_check;
    @FindBy(id = "account_phone_check")
    private WebElement phone_check;
    @FindBy(id = "account_signup_form")
    private WebElement signup_form;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver, "/account/signup");
    }

    public void openPage() {
        try {
            webDriver.get("https://test.megalot.emict.net/account/signup");
        } catch (Exception e){
            Assert.fail("Can't work with browser");
        }
    }

    public void typeEmailIntoInput(String email) {
        actionsWithElements.enterTextIntoInput(emailInput, email);
    }

    public void typeMobileOperatorCode(String code) {
        actionsWithElements.enterTextIntoInput(account_phone_code, code);
    }

    public void typeMobileNumber(String number) {
        actionsWithElements.enterTextIntoInput(account_phone_number, number);
    }

    public void setOfertaCheckBox() {
        actionsWithElements.setStateToCheckBox(oferta, "uncheck");
    }

    public void setObrobkaCheckBox() {
        actionsWithElements.setStateToCheckBox(obrobka, "uncheck");    }

    public void setConfidentialCheckBox() {
        actionsWithElements.setStateToCheckBox(confidential, "uncheck");
    }

    public void setILiveInUkraine() {
        actionsWithElements.setStateToCheckBox(ukraine, "uncheck");
    }

    public void clickNextButton() {
        actionsWithElements.clickOnElement(nextButton);
    }

    public void confirm18Age() {
        actionsWithElements.clickOnElement(yes18yearsOld);
    }

    public boolean buttonBackPresent() {
        return actionsWithElements.isElementDisplayed(backButton);
    }

    public void clicDayOfBirth() {
        actionsWithElements.clickOnElement(dayOfBirth);
    }

    public void checkDayOfBirth() {
        actionsWithElements.clickOnElement(value18);
    }

    public void clickMonthOfBirth() {
        actionsWithElements.clickOnElement(monthOfBirth);
    }

    public void checkMonthOfBirth() {
        actionsWithElements.clickOnElement(valueJune);
    }

    public void clicYearOfBirth() {
        actionsWithElements.clickOnElement(year);
    }

    public void checkYearOfBirth() {
        actionsWithElements.clickOnElement(year1993);
    }

    public void typePasswordIntoInput(String password) {
        actionsWithElements.enterTextIntoInput(passInput, password);
    }

    public void confirmPassword(String password) {
        actionsWithElements.enterTextIntoInput(passConfirm, password);
    }

    public void clickSighUpButton() {
        actionsWithElements.clickOnElement(sighnUpButton);
    }

    public boolean successLinkisDisplayed() {
        return actionsWithElements.isElementDisplayed(successLink);
    }

    public void activateUser(String connetion) {
        webDriver.get(connetion);
    }

    public void clickActivateLinkFromMail() throws GeneralSecurityException, MessagingException, IOException {
        String activation = CheckingMails.check();
        webDriver.get(activation);
    }

    public void waitForValidationOfEmail(String text) {
        actionsWithElements.waitForText(email_check, text);
    }

    public void waitForValidationNumber(String text) {
        actionsWithElements.clickOnElement(signup_form);
        actionsWithElements.waitForText(phone_check, text);
    }
}
