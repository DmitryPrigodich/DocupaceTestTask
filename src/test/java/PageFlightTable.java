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
        wait.until(ExpectedConditions.elementToBeClickable(By.id("column-ECO-BASIC")));
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
    logger.info("flight number is " + getFlightNumber());
        driver.findElement(By.id("a-results-show-all")).click();
    logger.info("flight number is " + getFlightNumber());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='flight-duration otp-tooltip-trigger']")));

        return this;
    }

    public String collectDataToJSON(){
        logger.info("Collect Data to JSON");
        int flightNumber = getFlightNumber();

        List<Map<String, String>> flightslist = new ArrayList<>();
        try{
            for(int i = 1; i < flightNumber; i++){
                if(!flightPrice(i).contains("Not available")){
                    flightslist.add(Map.ofEntries(
                            Map.entry("departureTime", departTime(i))
                            ,Map.entry("arrivalTime", arriveTime(i))
                            ,Map.entry("stopsNumber", connectionNumber(i))
                            ,Map.entry("durationTime", flightDuration(i))
                            ,Map.entry("price", flightPrice(i))
                    ));
                }
            }
        }catch(Exception ignored){}

        String flightTableJson = new Gson().toJson(flightslist);
        logger.info("Available Flight List:");
        logger.info(flightTableJson);
        return flightTableJson;
    }

    private String departTime(int index){
        return driver.findElement(By.xpath("//li["+index+"]//div[@class='flight-time flight-time-depart']")).getText();
    }
    private String arriveTime(int index){
        return driver.findElement(By.xpath("//li["+index+"]//div[@class='flight-time flight-time-arrive']")).getText();
    }
    private String connectionNumber(int index){
        return driver.findElement(By.xpath("//li["+index+"]//div[@class='connection-count non-stop']")).getText();
    }
    private String flightDuration(int index){
        return driver.findElement(By.xpath("//li["+index+"]//a[@class='flight-duration otp-tooltip-trigger']")).getText();
    }
    private String flightPrice(int index){
        return driver.findElement(By.xpath("//li["+index+"]//div[@class='price-point price-point-revised use-roundtrippricing']")).getText();
    }

    private int getFlightNumber(){
        return driver.findElements(By.xpath("//ul[@id='flight-result-list-revised']/li")).size();
    }
}