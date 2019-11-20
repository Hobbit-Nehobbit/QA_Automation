package megalote;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 11/19/19.
 */
public class LoginTest extends AbstractParentTest {
    @Test
    public void validLogin(){
        megalotePage.openPage();
        megalotePage.mneEst18();
        megalotePage.closeTutorial();
        megalotePage.clickOnLoginButton();
        megalotePage.typeLogin("hobbit.love.vedmochka+17");
        megalotePage.typePassword("Parol123");
        megalotePage.clickVhodButton();
        AbstractParentTest.checkExpectedResult("button Vyhid is present"
                , megalotePage.isButtonVyhidDisplayed());

    }
}
