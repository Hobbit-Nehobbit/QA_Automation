package megalote;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import pages.MegalotePage;

/**
 * Created by hobbit on 11/19/19.
 */
public class is18False extends AbstractParentTest {
    @Test
    public void is18True(){
        megalotePage.openPage();
        megalotePage.clicFalse();
        AbstractParentTest.checkExpectedResult("МСЛ за відповідальну гру!"
                , megalotePage.isBlockPresent());
        AbstractParentTest.checkExpectedResult("МСЛ за відповідальну гру!"
                , megalotePage.isAlarmPresent());



    }


}
