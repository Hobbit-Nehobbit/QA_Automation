package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by hobbit on 11/15/19.
 */
public class AbstractParentTest {
    WebDriver webDriver;
    protected LasVegasPage lasVegasPage;
    protected IndexPage indexPage;
    protected MegalotePage megalotePage;
    protected KarePage karePage;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected RestorePage restorePage;
    protected FirstDepositPage firstDepositPage;
    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    protected Logger logger = Logger.getLogger(getClass());

    @Before
    public void SetUp() throws Exception {
        webDriver = driverInit();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lasVegasPage = new LasVegasPage(webDriver);
        indexPage = new IndexPage(webDriver);
        megalotePage = new MegalotePage(webDriver);
        karePage = new KarePage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        loginPage = new LoginPage(webDriver);
        restorePage = new RestorePage(webDriver);
        firstDepositPage = new FirstDepositPage(webDriver);


    }

    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equalsIgnoreCase(browser))) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        } else if ("opera".equalsIgnoreCase(browser)) {
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        } else {
            throw new Exception("Check browser var ");
        }
    }

    @After
    public void tearDown() {
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }

        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }

        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };

    @Step
    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }
}
