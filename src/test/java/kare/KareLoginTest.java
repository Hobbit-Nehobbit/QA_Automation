package kare;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by hobbit on 11/21/19.
 */
public class KareLoginTest extends AbstractParentTest {
    @Test
    public void login(){
        karePage.openPage();
        karePage.accept18yearsOld();
        karePage.is18PopUpClose();
        karePage.clickOnButtonLogin();
        karePage.enterLoginInToInputLogin("hobbit.love.vedmochka+18");
        karePage.enterPassInToInputPassword("Parol123");
        karePage.clickOnButtonVhod();
        checkExpectedResult("button Vyhid is present"
                , karePage.isButtonVyhidDisplayed());
    }
}
