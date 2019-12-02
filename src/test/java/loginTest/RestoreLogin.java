package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 12/2/19.
 */
public class RestoreLogin extends AbstractParentTest {
    @Test
    public void restoreLogin(){
        loginPage.openPage();
        loginPage.is18True();
        loginPage.waitForPopUp18closed();
        loginPage.clickRestoreLogin();

        restorePage.typeEmailIntoInputLoginRestore("bce450+2104153@gmail.com");
        restorePage.submitButtonClick();
        checkExpectedResult("Test is fail"
                , restorePage.isSuccessTextDisplayed());
    }
}
