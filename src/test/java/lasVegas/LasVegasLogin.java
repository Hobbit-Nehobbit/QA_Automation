package lasVegas;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LasVegasLogin extends AbstractParentTest {
    @Test
    public void login(){
        lasVegasPage.openPage();
        lasVegasPage.mneEst18();
        lasVegasPage.is18YearsOldClosed();
        lasVegasPage.vhodButton();
        lasVegasPage.enterLoginInToFieldLogin("hobbit.love.vedmochka+17");
        lasVegasPage.enterPassInToFieldPassword("Parol123");
        lasVegasPage.clickOnButtonVhid();
        checkExpectedResult("button Vyhid is present"
                , lasVegasPage.isButtonVyhidDisplayed());
    }
}