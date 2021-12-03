package training.metofficeweather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) throws IOException {
		/*SpringApplication.run(WeatherApplication.class, args);*/
		ObjectMapper objectMapper = new ObjectMapper();

		Client client = ClientBuilder.newClient();
		String locationImport = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=724c591c-bbe6-497f-bbbf-1cd3effa45ee")
				.request(MediaType.TEXT_PLAIN)
				.get(String.class);


		/*System.out.println(locationImport);*/
		/*Location location = objectMapper.readValue(new URL("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=724c591c-bbe6-497f-bbbf-1cd3effa45ee"), Location.class);*/
		Root location = objectMapper.readValue(locationImport, Root.class);
		System.out.println(location);

	}

}
