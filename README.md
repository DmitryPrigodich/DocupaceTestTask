# DocupaceTestTask
A test task attempt for a Docupace.

_"could you complete it in Java?" (c)_

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
