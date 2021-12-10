package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
class Locations {
    @JsonProperty(value="Location")
    public ArrayList<Location> locationArray;

    public ArrayList<Location> getListOfLocations() {
        return locationArray;
    }




}
