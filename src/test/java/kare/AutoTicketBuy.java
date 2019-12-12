package kare;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by hobbit on 12/2/19.
 */
public class AutoTicketBuy extends AbstractParentTest {
    @Test
    public void buyTicketTable2(){
        karePage.fillingLoginForm("hobbit.love.vedmochka+17", "Parol123");
        checkExpectedResult("button Vyhid is present"
                , karePage.isButtonVyhidDisplayed());
        karePage.clickAutoBetTable2();
        checkExpectedResult("edit button"
                , karePage.isEditButtonPresent());
        karePage.clickPayButton();
        karePage.clickConfirmPay();
        checkExpectedResult("popUp is not displaed"
                , karePage.isSuccessPopUpDisplayed());
    }

    @Test
    public void byTicketTable1(){
        karePage.fillingLoginForm("hobbit.love.vedmochka+17", "Parol123");
        checkExpectedResult("button Vyhid is present"
                , karePage.isButtonVyhidDisplayed());
        karePage.checkTableOne();
        karePage.clickAutoBetTable1();
        checkExpectedResult("edit button"
                , karePage.isEditButtonPresent());
        karePage.clickPayButton();
        karePage.clickConfirmPay();
        checkExpectedResult("popUp is not displaed"
                , karePage.isSuccessPopUpDisplayed());
    }
}
