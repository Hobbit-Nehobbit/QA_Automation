package parentPage;

import io.qameta.allure.Step;
import libs.ActionsWithElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by hobbit on 11/15/19.
 */
public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithElements actionsWithElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expectedUrl;
    public ParentPage(WebDriver webDriver, String partUrl){
        baseUrl = configProperties.base_url();
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithElements = new ActionsWithElements(webDriver);
        expectedUrl = baseUrl + partUrl;
    }


    @Step
    public void checkCurrentUrl(){
        try{
            Assert.assertEquals("Url is not expected", expectedUrl, webDriver.getCurrentUrl());
        }catch (Exception e){
            logger.error("Can't get url " + e);
            Assert.fail("Can't get url " + e);
        }
    }
}
