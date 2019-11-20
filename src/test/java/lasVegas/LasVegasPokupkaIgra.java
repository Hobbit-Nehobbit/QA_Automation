package lasVegas;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 11/18/19.
 */
public class LasVegasPokupkaIgra extends AbstractParentTest{
    @Test
    public void pokupkaOdnogoBileta(){
        lasVegasPage.openPage();
        lasVegasPage.mneEst18();
        lasVegasPage.propusk();
        lasVegasPage.vhodButton();
        lasVegasPage.enterLoginInToFieldLogin("hobbit.love.vedmochka+17");
        lasVegasPage.enterPassInToFieldPassword("Parol123");
        lasVegasPage.clickOnButtonVhid();
        AbstractParentTest.checkExpectedResult("button Vyhid is present"
                , lasVegasPage.isButtonVyhidDisplayed());
        lasVegasPage.pokupkaButton();
        AbstractParentTest.checkExpectedResult("З вашого ігрового балансу буде списано 50 грн"
                , lasVegasPage.isTextPresent());
        lasVegasPage.clickProdovgzity();
        AbstractParentTest.checkExpectedResult("Билет куплен"
                , lasVegasPage.tiketBySuccess());
        lasVegasPage.closePodskazku();
        lasVegasPage.clickPochaty();
        lasVegasPage.clickAvto();
        AbstractParentTest.checkExpectedResult("Rezul'taty"
                , lasVegasPage.resultsAreDisplayed());
    }
}
