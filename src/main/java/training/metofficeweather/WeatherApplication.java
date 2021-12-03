package training.metofficeweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);

		Client client = ClientBuilder.newClient();
		String name = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=724c591c-bbe6-497f-bbbf-1cd3effa45ee")
				.request(MediaType.TEXT_PLAIN)
				.get(String.class);

		System.out.println(name);

	}

}
