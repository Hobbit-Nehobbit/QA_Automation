package megalote;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 11/19/19.
 */
public class is18False extends AbstractParentTest {
    @Test
    public void is18True(){
        megalotePage.openPage();
        megalotePage.clicFalse();
        checkExpectedResult("МСЛ за відповідальну гру!"
                , megalotePage.isBlockPresent());
        checkExpectedResult("МСЛ за відповідальну гру!"
                , megalotePage.isAlarmPresent());



    }


}
