package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {
    @JsonProperty(value="Location") // For ObjectMapper
    private Location[] locations;

    @Override
    public String toString() {
        return "Locations{" +
                "locations=" + Arrays.toString(locations) +
                '}';
    }
}
