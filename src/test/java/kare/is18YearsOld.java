package kare;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 11/19/19.
 */
public class is18YearsOld extends AbstractParentTest {
    @Test
    public void is18False(){
        karePage.openPage();
        karePage.clicFalse();
        checkExpectedResult("МСЛ за відповідальну гру!"
                , karePage.isBlockPresent());
        checkExpectedResult("МСЛ за відповідальну гру!"
                , karePage.isAlarmPresent());
    }
    @Test
    public void is18True(){
        karePage.openPage();
        karePage.clickTrue();
        karePage.is18PopUpClose();
        karePage.clickOnButtonLogin();
        checkExpectedResult("Element isn't clickable"
                , karePage.isLoginFormPresent());
    }
}
