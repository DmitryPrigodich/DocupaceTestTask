import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageFlightTable extends PageAbstract{
    private static Logger logger = LogManager.getLogger(PageMain.class);

    public PageFlightTable(WebDriver driver) {
        super(driver);
        logger.info("Flight Table page loading...");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cabinType")));
    }

    public PageFlightTable sortFlightsByEconomyAsc(){
        logger.info("Sort Flights By Economy Price Ascending");
        if(driver.findElement(By.id("announcePriceSort-ECO-BASIC")).getText().equals("sorted descending")){
            driver.findElement(By.id("column-ECO-BASIC")).click();
        }
        return this;
    }

    public PageFlightTable showAllFlights(){
        logger.info("Show all flights");
        driver.findElement(By.id("a-results-show-all")).click();
        return this;
    }

    public String collectDataToJSON(){
        logger.info("Collect Data to JSON");
        int flightNumber = driver.findElements(By.xpath("//ul[@id='flight-result-list-revised']/li")).size();

        logger.info(driver.findElement(By.xpath("//div[@class='flight-time flight-time-depart']")).getText());

        List<Map<String, String>> flightslist = new ArrayList<>();
        for(int i = 0; i < flightNumber; i++){
            if("Not available".equals(driver.findElement(By.xpath("//div[@class='price-point price-point-revised use-roundtrippricing']["+i+"]")).getText())){
                flightslist.add(Map.ofEntries(
                        Map.entry("departureTime", driver.findElement(By.xpath("//div[@class='flight-time flight-time-depart']["+i+"]")).getText())
                        ,Map.entry("arrivalTime", driver.findElement(By.xpath("//div[@class='flight-time flight-time-arrive']["+i+"]")).getText())
                        ,Map.entry("stopsNumber", driver.findElement(By.xpath("//div[@class='connection-count non-stop']["+i+"]")).getText())
                        ,Map.entry("durationTime", driver.findElement(By.xpath("//a[@class='flight-duration otp-tooltip-trigger']["+i+"]")).getText())
                        ,Map.entry("price", driver.findElement(By.xpath("//div[@class='price-point price-point-revised use-roundtrippricing']["+i+"]")).getText())
                ));
            }
        }

        String flightTableJson = new Gson().toJson(flightslist);
        logger.info("Available Flight List:");
        logger.info(flightTableJson);
        return flightTableJson;
    }
}