package training.metofficeweather.dataRoute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootLocation {
    @JsonProperty(value="SiteRep")
    private LocationSiteRep siteRep;

    public LocationSiteRep getLocationSireRep() {
        return siteRep;
    }
}

