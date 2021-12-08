package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reps {
    @JsonProperty(value="Rep")
    public ArrayList<Rep> weatherArray;

    public ArrayList<Rep> getWeatherArray() {
        return weatherArray;
    }
}
