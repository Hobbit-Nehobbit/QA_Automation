package kare;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 11/21/19.
 */
public class KareLoginTest extends AbstractParentTest {
    @Test
    public void login(){
        karePage.openPage();
        karePage.accept18yearsOld();
        karePage.clickOnButtonLogin();
        karePage.enterLoginInToInputLogin("hobbit.love.vedmochka+18");
        karePage.enterPassInToInputPassword("Parol123");
        karePage.clickOnButtonVhod();
    }
}
