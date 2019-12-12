package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

/**
 * Created by hobbit on 12/2/19.
 */
public class RestorePage extends ParentPage {
    @FindBy(id = "login")
    private WebElement login;
    @FindBy (id = "btn_recovery_passwd")
    private WebElement sendFormButton;
    @FindBy (id = "email")
    private WebElement email;
    @FindBy(id = "btn_recovery_login")
    private WebElement sendEmail;
    @FindBy(xpath = "//h2[@class='block_header']")
    private WebElement restoreMessage;

    public RestorePage(WebDriver webDriver) {
        super(webDriver, "/account/recovery");
    }

    public void typeEmailOrLoginIntoInputPasswordRestore(String loginOrEmail) {
        actionsWithElements.enterTextIntoInput(login, loginOrEmail);
        logger.info(loginOrEmail + " was inputed success");
    }

    public void submitForm() {
        actionsWithElements.clickOnElement(sendFormButton);
        logger.info("Button was clicked success");
    }

    public boolean isSuccessTextDisplayed() {
        actionsWithElements.isElementDisplayed(restoreMessage);
        return restoreMessage.isDisplayed();
    }

    public void typeEmailIntoInputLoginRestore(String Email) {
        actionsWithElements.enterTextIntoInput(email, Email);
        logger.info(Email + " was inputed success");
    }

    public void submitButtonClick() {
        actionsWithElements.clickOnElement(sendEmail);
    }
}

