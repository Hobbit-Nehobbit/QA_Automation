package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hobbit on 11/21/19.
 */
public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void enterTextIntoInput(WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into input");
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed ->" + state);
            return state;
        } catch (Exception e) {
            logger.info("Is element displayed -> False");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can't work with element ");
        Assert.fail("Can't work with element ");
    }
}