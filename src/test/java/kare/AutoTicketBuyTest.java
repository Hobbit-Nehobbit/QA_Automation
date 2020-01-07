package kare;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;

/**
 * Created by hobbit on 12/2/19.
 */
@Epic("Las-Vegas")
@Feature("TicketBuy")
public class AutoTicketBuyTest extends AbstractParentTest {
        @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
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


    @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
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
