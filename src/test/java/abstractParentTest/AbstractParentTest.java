package abstractParentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IndexPage;
import pages.KarePage;
import pages.LasVegasPage;
import pages.MegalotePage;

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
    @Before
    public void SetUp(){
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lasVegasPage = new LasVegasPage(webDriver);
        indexPage = new IndexPage(webDriver);
        megalotePage = new MegalotePage(webDriver);
        karePage = new KarePage(webDriver);

    }
    @After
    public void tearDown(){
        webDriver.quit();
    }

    public static void checkExpectedResult(String message, boolean actualResult){
        Assert.assertEquals(message, true, actualResult);
    }
}
