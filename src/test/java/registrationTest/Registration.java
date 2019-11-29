package registrationTest;

import abstractParentTest.AbstractParentTest;
import libs.Utils;

/**
 * Created by hobbit on 11/29/19.
 */
public class Registration extends AbstractParentTest{
    private final String email = "hobbit.love.vedmochka+" + Utils.getDateAndTimeFormated() + "@gmail.com";
    private final String number = Utils.getDateAndTimeFormated();
    public void PositiveRegistration(){
        registrationPage.openPage();
        registrationPage.checkCurrentUrl();
        registrationPage.typeEmailIntoInput(email);
        registrationPage.typeMobileOperatorCode("50");
        registrationPage.typeMobileNumber(number);
        registrationPage.setOfertaCheckBox();
        registrationPage.setObrobkaCheckBox();
        registrationPage.setConfidentialCheckBox();
        registrationPage.setILiveInUkraine();
        registrationPage.clickNextButton();

    }
}
