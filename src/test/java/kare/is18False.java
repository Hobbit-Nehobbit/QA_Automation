package kare;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 11/19/19.
 */
public class is18False extends AbstractParentTest {
    @Test
    public void is18True(){
        karePage.openPage();
        karePage.clicFalse();
        AbstractParentTest.checkExpectedResult("МСЛ за відповідальну гру!"
                , karePage.isBlockPresent());
        AbstractParentTest.checkExpectedResult("МСЛ за відповідальну гру!"
                , karePage.isAlarmPresent());



    }
}
