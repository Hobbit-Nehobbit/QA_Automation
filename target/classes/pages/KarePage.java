package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

/**
 * Created by hobbit on 11/19/19.
 */
public class KarePage extends ParentPage {
    public KarePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//button[@class='ripple is18-no-btn nope no']")
    private WebElement Ni;
    @FindBy(xpath = "//*[@class='is18wrap-no no']")
    private WebElement blocker;
    @FindBy(xpath = "//*[@class='gtfo']")
    private WebElement text;

    public void openPage() {
        try {
            webDriver.get("https://test.megalot.emict.net/kare/uk");
        } catch (Exception e) {
            Assert.fail("Can't work with page");
        }
    }

    public void clicFalse() {
        Ni.click();
        logger.info("Mne net 18");
    }

    public boolean isBlockPresent() {
        try {
            WebElement blocker = webDriver.findElement(By.xpath("//*[@class='is18wrap-no no']"));
            return blocker.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isAlarmPresent() {
        try {
            WebElement text = webDriver.findElement(By.xpath("//*[@class='gtfo']"));
            return text.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
