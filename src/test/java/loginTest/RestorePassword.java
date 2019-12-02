package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 12/2/19.
 */
public class RestorePassword extends AbstractParentTest {
    @Test
    public void restorePasswordFromEmail(){
        loginPage.openPage();
        loginPage.is18True();
        loginPage.waitForPopUp18closed();
        loginPage.clickRestorePassword();


        restorePage.typeEmailOrLoginIntoInputPasswordRestore("bce450+2104153");
        restorePage.submitForm();
        checkExpectedResult("Test is fail"
                , restorePage.isSuccessTextDisplayed());

    }
}
