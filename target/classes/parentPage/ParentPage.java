package parentPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by hobbit on 11/15/19.
 */
public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    public ParentPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
