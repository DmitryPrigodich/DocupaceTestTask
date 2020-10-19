import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightTest {
    private static Logger logger = LogManager.getLogger(FlightTest.class);

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_LOCATION);
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @After
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    @Test
    public void testSimpleTest(){
        logger.info("Hello there, Tester!");
    }

    @Test
    public void testMainPage(){
        driver.get(Constants.TEST_PAGE_URL);
    }
}
