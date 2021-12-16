package training.metofficeweather;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		WeatherApplication setup = new WeatherApplication();

		setup.appInitialSetUp();
		System.out.println("Welcome to Weatherapp");
		setup.optionInput();
	}


}
