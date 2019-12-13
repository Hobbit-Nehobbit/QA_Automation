package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by hobbit on 11/21/19.
 */
public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
        webDriverWait_15 = new WebDriverWait(webDriver, 15);
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
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
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
    public void setStateToCheckBox(WebElement checkBox, String state) {
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUncheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = checkBox.isSelected();
        if (isStateCheck || isStateUncheck) {
            if ((isStateCheck && isCheckBoxSelected) || (isStateUncheck && !isCheckBoxSelected)) {
                logger.info("CheckBox is already needed state");
            } else if ((isStateCheck && !isCheckBoxSelected) || (isStateUncheck && isCheckBoxSelected)) {
                clickOnElement(checkBox);
            } else {
                logger.error("State should be only 'check' or 'uncheck'");
                stopTestAndPrintMessage();

            }
        }
    }
    public void waitInvisibilityOfElement(WebElement webElement) {
        webDriverWait_10.until(ExpectedConditions.invisibilityOf(webElement));
        logger.info("Element was closed");
    }

    public void waitForPopUp(WebElement webElement) {
        webDriverWait_10.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitVisibilityOfElement(WebElement webElement) {
        webDriverWait_10.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForText(WebElement webElement, String text){
        webDriverWait_10.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

}
