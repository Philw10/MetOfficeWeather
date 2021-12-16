package training.metofficeweather.dataRoute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationSiteRep {
    @JsonProperty(value="Wx")
    private LocationWx wX;

    @JsonProperty(value="DV")
    private LocationDV dv;

    public LocationDV getDv() {
        return dv;
    }

}
