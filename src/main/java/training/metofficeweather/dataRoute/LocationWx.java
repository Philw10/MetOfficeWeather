package training.metofficeweather.dataRoute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import training.metofficeweather.Param;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationWx {
    @JsonProperty(value = "Param")
    private Param[] param;

}

