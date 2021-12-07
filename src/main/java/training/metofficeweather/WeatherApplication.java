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
		String cityWeather = null;
		String option;
		String locationChoice;
		String locationId;
		Import imp = new Import();
		Location locationSearch = new Location();
		ObjectMapper objectMapper = new ObjectMapper();
		Scanner choiceOfOutput = new Scanner(System.in);

		String locationImport = imp.importWholeList();
		Root location = objectMapper.readValue(locationImport, Root.class);
		ArrayList<Location> arrayOfLocations = location.getLocations().getListOfLocations();

		System.out.println("Welcome to weatherapp");

		while (keepGoing) {
			System.out.println("What would you like to do?\n1. List areas available for forecast\n2. Select an area for forecast");
			option = choiceOfOutput.nextLine();

			if (option.equals("1")) {
				int i = 0;

				for (Location number : arrayOfLocations){
					System.out.println(arrayOfLocations.get(i).name + "   " + arrayOfLocations.get(i).id);
					i++;
				}
			} else if (option.equals("2")) {
				System.out.println("Please enter a location?");
				locationChoice = choiceOfOutput.nextLine();
				locationId = locationSearch.searchLocationId(locationChoice, arrayOfLocations);
					if (locationId.equals("Not found")){
						System.out.println("Location not found.  Please try again");
						continue;
					}else {
						/*cityWeather = imp.importWithLocation(locationId);*/
						System.out.println(imp.importWithLocation(locationId));
					}
			}
		}


	}
}
