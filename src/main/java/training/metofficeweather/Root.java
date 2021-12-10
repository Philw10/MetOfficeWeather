package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    @JsonProperty(value="Locations")
    private Locations locations;

    public Locations getLocations() {
        return locations;
    }

}
