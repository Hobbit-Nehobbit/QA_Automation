package registrationTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import libs.Utils;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by hobbit on 11/29/19.
 */
@Epic("Personal Profile")
@Feature("RegistrationTest test")
public class RegistrationTest extends AbstractParentTest{

    private final String email = "bce450+" + Utils.getDateAndTimeFormated() + "@gmail.com";
    private final String number = Utils.getDateAndTimeFormated();
    @Test
    public void PositiveRegistration() throws GeneralSecurityException, MessagingException, IOException, InterruptedException {

        registrationPage.openPage();
        registrationPage.confirm18Age();
        registrationPage.checkCurrentUrl();
        registrationPage.typeEmailIntoInput(email);
//        registrationPage.waitForValidationOfEmail("е-mail доступний");
        registrationPage.typeMobileOperatorCode(number);
        registrationPage.typeMobileNumber(number);
//        registrationPage.waitForValidationNumber("номер телефону доступний");
        registrationPage.setOfertaCheckBox();
        registrationPage.setObrobkaCheckBox();
        registrationPage.setConfidentialCheckBox();
        registrationPage.setILiveInUkraine();
        registrationPage.clickNextButton();
        checkExpectedResult("Button 'Back' isn't displayed"
                , registrationPage.buttonBackPresent());      //First step is over success

        registrationPage.clicDayOfBirth();
        registrationPage.checkDayOfBirth();
        registrationPage.clickMonthOfBirth();
        registrationPage.checkMonthOfBirth();
        registrationPage.clicYearOfBirth();
        registrationPage.checkYearOfBirth();
        registrationPage.typePasswordIntoInput("Parol123");
        registrationPage.confirmPassword("Parol123");
        registrationPage.clickSighUpButton();
        checkExpectedResult("SignUp isn't success"
                , registrationPage.successLinkisDisplayed());

        Thread.sleep(50000);
        registrationPage.clickActivateLinkFromMail();
        checkExpectedResult("Account activation was failed"
                , loginPage.exitButtonIsDisplayed());
    }
}
