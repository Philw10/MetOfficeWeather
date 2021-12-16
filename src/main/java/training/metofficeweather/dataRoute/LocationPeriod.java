package training.metofficeweather.dataRoute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import training.metofficeweather.Rep;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationPeriod {
    private String type;
    private String value;
    @JsonProperty(value="Rep")
    public ArrayList<Rep> weatherArray;

    public ArrayList<Rep> getWeatherArray() {
        return weatherArray;
    }
}

