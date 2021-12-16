package training.metofficeweather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import training.metofficeweather.dataRoute.RootLocation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherApplication {
    private final Client client = ClientBuilder.newClient();
    private String locationImport;
    private String locationChoice;
    private ArrayList<Location> arrayOfLocations;
    private ArrayList<Rep> arrayOfWeather;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Location locationSearch = new Location();


    private String importWholeList(){
        locationImport = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=724c591c-bbe6-497f-bbbf-1cd3effa45ee")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        return locationImport;
    }
    private String importWithLocation(String locationId){
        locationImport = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/" + locationId + "?res=3hourly&key=724c591c-bbe6-497f-bbbf-1cd3effa45ee")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        return locationImport;
    }
    public void appInitialSetUp() {
        String locationImport = importWholeList();
        Root location = null; //JSON route Locations -> Location
        try {
            location = objectMapper.readValue(locationImport, Root.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert location != null;
        arrayOfLocations = location.getLocations().getListOfLocations();
    }

    private void weatherAtSpecificLocation(String locationId) {
        String locationImport = importWithLocation(locationId);
        RootLocation location = null; //Location in JSON SiteRep  Wx --> Param -> DV  Location  Period  Rep
        try {
            location = objectMapper.readValue(locationImport, RootLocation.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        arrayOfWeather = location.getLocationSireRep().getDv().getLocation().getPeriod().get(0).getWeatherArray();
    }

    public void optionInput() throws NullPointerException {
        Scanner choiceOfOutput = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat would you like to do?\n1. List areas available for forecast\n2. Select an area for forecast\n3. Exit");
            String option = choiceOfOutput.nextLine();

            switch (option) {
                case "1" -> locationSearch.locationList(arrayOfLocations);
                case "2" -> {
                    System.out.println("Please enter a location?");
                    locationChoice = capitalizeWord(choiceOfOutput.nextLine());
                    System.out.println(locationChoice);
                    weatherForLocation();
                }
                case "3" -> System.exit(0);
            }
        }
    }
    private void weatherForLocation(){
        String locationId = locationSearch.searchLocationId(locationChoice, arrayOfLocations);
        if (locationId.equals("Not found")){
            System.out.println("Location not found.  Please try again\n");
            optionInput();
        }else {
            weatherAtSpecificLocation(locationId);
        }
        System.out.println("\nThe current weather for " + locationChoice + " is:-");
        System.out.println("Temperature: " + arrayOfWeather.get(0).T + "c");
        System.out.println("It currently feels like " + arrayOfWeather.get(0).F + "c");
        System.out.println("The wind direction is " + arrayOfWeather.get(0).D + " ,and the wind speed is " + arrayOfWeather.get(0).S + "mph");
        System.out.println("There is a " + arrayOfWeather.get(0).Pp + "% chance of rain\n");
    }
    public static String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }

}
