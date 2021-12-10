package training.metofficeweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) throws IOException {
		/*SpringApplication.run(WeatherApplication.class, args);*/
		boolean keepGoing = true;

		ObjectMapper objectMapper = new ObjectMapper();
		Scanner choiceOfOutput = new Scanner(System.in);

		Import bringInJsonAsString = new Import();
		Locations displayWholeLocationList = new Locations();
		Location locationSearch = new Location();

		String locationImport = bringInJsonAsString.importWholeList();
		Root location = objectMapper.readValue(locationImport, Root.class); //JSON route Locations -> Location
		ArrayList<Location> arrayOfLocations = location.getLocations().getListOfLocations();

		System.out.println("Welcome to weatherapp");

		while (keepGoing) {
			System.out.println("What would you like to do?\n1. List areas available for forecast\n2. Select an area for forecast");
			String option = choiceOfOutput.nextLine();

			if (option.equals("1")) {
				displayWholeLocationList.locationList(arrayOfLocations);
			} else if (option.equals("2")) {
				System.out.println("Please enter a location?");
				String locationId = locationSearch.searchLocationId(choiceOfOutput.nextLine(), arrayOfLocations);
					if (locationId.equals("Not found")){
						System.out.println("Location not found.  Please try again");
						continue;
					}else {
						System.out.println(bringInJsonAsString.importWithLocation(locationId));

						// Location in JSON SiteRep  DV  Location  Period  Rep
						String cityWeather = bringInJsonAsString.importWithLocation(locationId);
						Root weather = objectMapper.readValue(cityWeather, Root.class);
						System.out.println(weather);
					}
			}
		}


	}
}
