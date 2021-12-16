package training.metofficeweather.dataRoute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationLocation {
    private String i;
    private String lat;
    private String lon;
    private String name;
    private String country;
    private String continent;
    private String elevation;
    @JsonProperty(value = "Period")
    private ArrayList<LocationPeriod> Period;

    public ArrayList<LocationPeriod> getPeriod() {
        return Period;
    }

}