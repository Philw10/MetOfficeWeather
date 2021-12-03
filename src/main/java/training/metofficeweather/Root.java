package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    @JsonProperty(value="Locations") // For ObjectMapper
    private Locations locations;

    @Override
    public String toString() {
        return "Root{" +
                "locations=" + locations +
                '}';
    }
}
