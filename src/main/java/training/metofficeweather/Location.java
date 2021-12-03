package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    public String elevation;
    public String id;
    public String latitude;
    public String longitude;
    public String name;
    public String region;
    public String unitaryAuthArea;

    @Override
    public String toString() {
        return "Location{" +
                "elevation='" + elevation + '\'' +
                ", id='" + id + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", unitaryAuthArea='" + unitaryAuthArea + '\'' +
                '}';
    }
    public String getName(){
        return name;
    }
}
