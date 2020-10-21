import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAbstract {
    private static Logger logger = LogManager.getLogger(PageAbstract.class);

    public PageAbstract(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebDriverWait wait;
    protected WebDriver driver;

    public void waitFewSeconds(long seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch(Exception ignored){}
    }
}