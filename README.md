# DocupaceTestTask
A test task for a Docupace.

_"could you complete it in Java?" (c)_

### THE TASK
1. Install Nightwatchjs ( http://nightwatchjs.org/ )
2. Using Nightwatch, write a script for automated test to:
  + Navigate to https://www.united.com
  + Fill the search criteria:
    - One-way flight
    - From “New York JFK” to “Miami, FL, US (MIA - All Airports)”
    - Depart date August 20th
    - Economy class
  + Click Find flights
  + In the flight table:
    - Sort the flights by Economy (Most Restricted), lowest price first
    - Collect (Economy (Most Restricted)price only) data in a json object.
        - Depart, 
        - Arrive, 
        - Stops, 
        - Duration, 
        - Price 
    - If the flight is not available for Price criteria: (Economy (Most Restricted),filter the flight data out of the json object
    - Print the final json object in the console.

### THE RESULT
- Test is getting from the initial page to the second with the correct data input;
- Flight table is visible
- Data gathered to JSON and printed out to log - well, w/o trimming extra, and there might not be everything
- Problem with displaying all the flight results, link is not clickable or takes too much time to react

It was decided to stop as it already took me 2h per 7h after the work to google forgotten things, investigate the site and code. Somewhere 80% are done, other 20% would probably take the same amount of time. 
