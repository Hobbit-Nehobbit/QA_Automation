package lasVegas;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 11/18/19.
 */
public class LasVegasBuyTickets extends AbstractParentTest{
    @Test
    public void oneTicketBuy(){
        lasVegasPage.fillingLoginForm("hobbit.love.vedmochka+17", "Parol123");
        checkExpectedResult("button Vyhid is present"
                , lasVegasPage.isButtonVyhidDisplayed());
        lasVegasPage.pokupkaButton();
        checkExpectedResult("З вашого ігрового балансу буде списано 50 грн"
                , lasVegasPage.isTextPresent());
        lasVegasPage.clickProdovgzity();
        checkExpectedResult("Билет куплен"
                , lasVegasPage.tiketBySuccess());
        lasVegasPage.clickAvto();
        checkExpectedResult("Rezul'taty"
                , lasVegasPage.resultsAreDisplayed());
    }
}
