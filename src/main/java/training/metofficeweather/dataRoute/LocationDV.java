package training.metofficeweather.dataRoute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDV {
    private String dataDate;
    private String type;
    @JsonProperty(value="Location")
    private LocationLocation location;

    public LocationLocation getLocation() {
        return location;
    }

}

