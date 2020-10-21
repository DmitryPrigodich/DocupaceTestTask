import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageMain extends PageAbstract{
    private static Logger logger = LogManager.getLogger(PageMain.class);

    public PageMain(WebDriver driver) {
        super(driver);
        logger.info("Main page loading...");
        driver.get(Constants.TEST_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cabinType")));
    }

    public PageMain selectOneWayFlight(){
        driver.findElement(By.id("oneway")).click();
        return this;
    }

    public PageMain selectTextboxFromNewYorkJFK(){
        driver.findElement(By.id("bookFlightOriginInput")).clear(); //id="Combined-Shape"
        driver.findElement(By.id("bookFlightOriginInput")).sendKeys("New York JFK");
        driver.findElement(By.id("bookFlightOriginInput")).submit();
        return this;
    }

    public PageMain selectTextboxToMiami(){
        driver.findElement(By.id("bookFlightDestinationInput")).clear(); //id="Combined-Shape"
        driver.findElement(By.id("bookFlightDestinationInput")).sendKeys("Miami MFL");
        driver.findElement(By.id("bookFlightDestinationInput")).submit();
        return this;
    }

    public PageMain selectTextboxDepartDate(){
        driver.findElement(By.id("DepartDate")).clear(); //id="Combined-Shape"
        driver.findElement(By.id("DepartDate")).sendKeys("Aug 20");
        driver.findElement(By.id("DepartDate")).sendKeys(Keys.ENTER);
        return this;
    }

    public PageMain selectDropdownEconomyClass(){
        driver.findElement(By.id("cabinType")).click();
        driver.findElement(By.id("cabinType_item-0")).click();
        return this;
    }

    public PageFlightTable clickButtonFindFlights(){
        //<button
        // type="submit" class="app-components-BookFlightForm-bookFlightForm__findFlightBtn--1lbFe app-components-BookFlightForm-bookFlightForm__btnDefault--3yb7R app-components-BookFlightForm-bookFlightForm__primaryButton--2fg9l"
        // aria-label="Find flights"
        // ><span>Find flights</span></button>
        driver.findElement(By.xpath("//button[@aria-label='Find flights']")).click();
        return new PageFlightTable(driver);
    }
}

