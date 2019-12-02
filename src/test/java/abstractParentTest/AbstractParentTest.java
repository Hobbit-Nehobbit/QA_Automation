package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
    @Before
    public void SetUp() throws Exception {
//        File file = new File("./src/drivers/chromedriver");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        webDriver = new ChromeDriver();
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


    }

    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equalsIgnoreCase(browser))){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if("firefox".equalsIgnoreCase(browser)){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if("ie".equalsIgnoreCase(browser)){
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        } else if("opera".equalsIgnoreCase(browser)){
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        } else {
            throw new Exception("Check browser var ");
        }
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }

    public static void checkExpectedResult(String message, boolean actualResult){
        Assert.assertEquals(message, true, actualResult);
    }
}
