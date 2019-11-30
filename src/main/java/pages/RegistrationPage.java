package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

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
    @FindBy (xpath = "//*[@id=\"account_signup_form\"]/div[4]/div/div[4]/label/i")
    private WebElement confidential;
    @FindBy ()
    private WebElement ukraine;

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
        actionsWithElements.setStateToCheckBox(oferta, "check");
    }

    public void setObrobkaCheckBox() {
        actionsWithElements.setStateToCheckBox(obrobka, "check");    }

    public void setConfidentialCheckBox() {
        actionsWithElements.setStateToCheckBox(confidential, "check");
    }

    public void setILiveInUkraine() {
        actionsWithElements.setStateToCheckBox(ukraine, "check");
    }
}
