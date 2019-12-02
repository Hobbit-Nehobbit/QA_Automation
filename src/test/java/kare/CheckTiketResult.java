package kare;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 11/21/19.
 */
public class CheckTiketResult extends AbstractParentTest{

    @Test
    public void checkWinTiketResult(){
        karePage.openPage();
        karePage.accept18yearsOld();
        karePage.is18PopUpClose();
        karePage.inputIntoCheckTicketField("05259000009740520000001622");
        karePage.clickCheckButton();
        karePage.waitForPopUp();
        checkExpectedResult("Вітаємо! Ваш виграш..."
                , karePage.isWinTicketPopUpPresent());
        karePage.closePopup();
        karePage.inputIntoCheckTicketField("05259001009740510000001392");
        karePage.clickCheckButton();
        checkExpectedResult("Інформація про білет"
                , karePage.isLoseTicketPopUpPresent());
    }
}
