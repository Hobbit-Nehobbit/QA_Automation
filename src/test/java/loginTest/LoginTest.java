package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;


/**
 * Created by hobbit on 11/15/19.
 */
public class LoginTest extends AbstractParentTest {
    @Test
    public void validLogin(){
        lasVegasPage.openPage();
        lasVegasPage.mneEst18();
        lasVegasPage.propusk();
        lasVegasPage.vhodButton();
        lasVegasPage.enterLoginInToFieldLogin("hobbit.love.vedmochka+17");
        lasVegasPage.enterPassInToFieldPassword("Parol123");
        lasVegasPage.clickOnButtonVhid();
        AbstractParentTest.checkExpectedResult("button Vyhid is present"
                , lasVegasPage.isButtonVyhidDisplayed());
    }
}
