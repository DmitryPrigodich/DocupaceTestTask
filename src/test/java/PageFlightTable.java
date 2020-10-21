import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageFlightTable extends PageAbstract{
    private static Logger logger = LogManager.getLogger(PageMain.class);

    public PageFlightTable(WebDriver driver) {
        super(driver);
        logger.info("Flight Table page loading...");
        driver.get(Constants.TEST_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cabinType")));
    }

    public PageFlightTable sortFlightsByEconomy(){
        return this;
    }

    public Object collectDataToJSON(){
        return new Object();
    }
}
//    In the flight table:
//        Sort the flights by Economy (Most Restricted), lowest price first
//        Collect Depart, Arrive, Stops, Duration, Price (Economy (Most Restricted)price only) data in a json object.
//        If the flight is not available for Price criteria: (Economy (Most Restricted),filter the flight data out of the json object
//        Print the final json object in the console.